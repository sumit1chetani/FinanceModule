//define([ 'hospital/accounts/accounts' ], function(module) {

  ///  'use strict';
    app.controller('creditNoteListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $stateParams,
            $controller, $injector, sharedProperties, toaster, $rootScope,utilsService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.objCBPayment = {
                cbPaymenttDate:''
        }
        $scope.getCreditNoteListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/creditNote/cnlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.reverseList = data.reverseList;

                    $scope.pushCreditNoteListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushCreditNoteListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lCreditNoteBean)) {

                $scope.showEmptyLabel = true;

            } else {

                $scope.rowCollection = $scope.rowCollection.concat(data.lCreditNoteBean);

            }
        };

        $scope.getCreditNoteListUtil();
        
        $scope.add = function() {
            $state.go("app.finance.accounts.creditNote.add");
        };
        
        $scope.editCreditNoteRow = function(collections) {
            $location.url(  $stateParams.tenantid+'/hospital/accounts/creditNote/edit/'+collections.creditNoteCode);
        };
       
        $scope.viewCreditNoteRow= function(collections) {
            $location.url($stateParams.tenantid+'/hospital/accounts/creditNote/view/'+collections.creditNoteCode);
        };
        $scope.deleteCreditNoteRow = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/creditNote/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections.creditNoteCode,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };
        
        /**
         * Validate Data for Approve Record
         */
        $scope.validateDataforApproveRecord = function(selectedrow){
            angular.forEach(selectedrow, function(row, index) {
                $scope.isBreak=true;
                if($scope.isBreak){
                    if(row.creditNoteCode !="" && row.creditNoteDate !=null){
                        $scope.isValidateSucess =true;
                    }else{
                        $scope.isValidateSucess =false;
                        $scope.isBreak =false;
                    }
                }
            });
        }
        
        /**
         * Approval
         */
        $scope.reverseConfirm = function() {
            if ($scope.creditNoteNo == "" || $scope.creditNoteNo == undefined) {
            logger.logError("Please Select JV No!");
            } else {
                if($scope.objCBPayment.cbPaymenttDate != null && $scope.objCBPayment.cbPaymenttDate != "" && 
                        $scope.objCBPayment.cbPaymenttDate != ""){
                $http.get('app/creditNote/reverseCN?creditNoteNo='+ $scope.creditNoteNo
                        +'&createdDate='+$scope.objCBPayment.cbPaymenttDate).success(function(datas) {
               // $http.post($stateParams.tenantid+'/app/journalVoucher/reverseJV1',$scope.jvReverseObj).success(function(datas) {
                    if(datas.success == true){
                        logger.logSuccess(datas.message);
                        ngDialog.close();
                        $state.go("app.finace.accounts.creditNote.list");

                    }else{
                        logger.logError(datas.message);
                    }
                    }).error(function(datas) {
                });
                }
            }
            }
        $scope.reverse = function() {
            $scope.objCBPayment.cbPaymenttDate = "";
            $scope.creditNoteNo=$("#creditNoteNo .selectivity-single-select-input").val();
            $scope.screenNames = "payment";

            if($scope.creditNoteNo =="" || $scope.creditNoteNo ==undefined){
            logger.logError("Please select Credit Note Code");
            }else{
            ngDialog.open({
            template : 'views/finance/accounts/creditNote/transactionCNReverseDialog',
            scope :$scope
            });
            }

            };
            $scope.closeCBPReverseDialog = function() {
                ngDialog.close();
                };
        $scope.approval = function(){
            $scope.selectedrow=[];
            angular.forEach($scope.rowCollection, function(row, index) {
                var check =row.select;
                if (check ==true) {
                    delete row['select'];
                    $scope.selectedrow.push(row);
                }else{

                }
            });
            if($scope.selectedrow.length>0){
                $scope.isValidateSucess =false;
                $scope.validateDataforApproveRecord($scope.selectedrow);

                if($scope.isValidateSucess){
                    var creditnoteCodes="";
                    $scope.lCreditNoteBean =$scope.selectedrow;
                    for(var iRowCtr=0;iRowCtr < $scope.lCreditNoteBean.length;iRowCtr++){
                        if($scope.lCreditNoteBean[iRowCtr].approveStatus!="Y"){
                            if(creditnoteCodes==""){
                                creditnoteCodes= $scope.lCreditNoteBean[iRowCtr].creditNoteCode; //creditNoteCode
                            }
                            else{
                                creditnoteCodes +=","+ $scope.lCreditNoteBean[iRowCtr].creditNoteCode;//creditNoteCode
                            }
                        }
                    }
                    if(creditnoteCodes!=""){
                        $http.post('app/creditNote/approveCreditNote', creditnoteCodes).success(function(data) {
                            
                            if (data) {
                                logger.logSuccess("Approve Record Successfully!");
                                $location.path("hospital/accounts/creditNote/list");
                                $scope.rowCollection =[];
                                $scope.getCreditNoteListUtil();
                            }else{
                                logger.logError("Approve Record Un Successfull");
                                $location.path("hospital/accounts/creditNote/list");
                            }
                        }).error(function(data) {
                        });
                    }else{
                        logger.logError("Record is Already Approved...");
                    }

                }else{
                    logger.logError("Some of the selected row(s) not entered properly...");
                }

            }else{
                logger.logError("Please Select Atleast one row!...");
            }

        }
   // });

});