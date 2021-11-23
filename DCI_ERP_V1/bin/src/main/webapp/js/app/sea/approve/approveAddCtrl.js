//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('approveAddCtrl', function($scope, $state, $http, ngDialog,$stateParams, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService) {

        $scope.employeeList = [];
        $scope.locationList = [];
        $scope.itemList = [];
        $scope.statusList = [];
        $scope.isEdit = false;
        $scope.isAdd=true;

        $scope.storeApprovalData = {
            purchaseRequisitionId : '',
            requisitionNumber : '',
            requisitionDate : '',
            employeeId : '',
            employeeName : '',
            requisitionType : '',
            designationName : '',
            sourceLocationName : '',
            destinationLocationName : '',
            sourceLocation : '',
            destinationLocation : '',
            designationId : '',
            requisitionStatus : '',
            requisitionStatusName : '',
            remarks : '',
            prReqNo : '',
            prReqDate : '',
            approvedDate :new Date(),
            approvedId : '',
            tables : []
        };
        
        $scope.date = '';
        
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;

        $scope.cancel = function() {
            $state.go("app.sea.approve.list");
        };
        
        //Watch method for Invoice From Date 
        $scope.$watch('storeApprovalData.requisitionDate', function(newValue, oldValue) {
           if(newValue!=""){
               var fromDate = newValue;
               var toDate = oldValue;
               fromDate = fromDate.split("/");
               fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
               toDate = toDate.split("/");
               toDate = new Date(toDate[2], toDate[1], toDate[0]);
               
               if($scope.storeApprovalData.requisitionDate == $scope.date){
                   $scope.storeApprovalData.requisitionDate=$scope.date;
               }else{
                   if(fromDate < toDate){
                       logger.logError("Requested Date is lesser than the Current Date");
                       $scope.storeApprovalData.requisitionDate=$scope.date;
                  }
               }
               
            }
           
        });
        
        $scope.$watch('[storeApprovalData.requisitionDate,storeApprovalData.approvedDate]', function(newValue) {
            
            if(newValue!=""){
                if($scope.storeApprovalData.requisitionDate!='' && $scope.storeApprovalData.approvedDate != '' && $scope.storeApprovalData.requisitionDate!=undefined && $scope.storeApprovalData.approvedDate != undefined && $scope.storeApprovalData.requisitionDate!=null && $scope.storeApprovalData.approvedDate != null){
                var fromDate = $scope.storeApprovalData.requisitionDate;
                var toDate = $scope.storeApprovalData.approvedDate;
                var todayDate = $scope.date;
                todayDate=todayDate.split("/");
                todayDate= new Date(todayDate[2], todayDate[1], todayDate[0]);
                fromDate = fromDate.split("/");
                fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                toDate = toDate.split("/");
                toDate = new Date(toDate[2], toDate[1], toDate[0]);
                if(toDate >= fromDate && toDate <= todayDate){
                }else{
                    $scope.storeApprovalData.approvedDate = '';
                    logger.logError("Approved Date should be greater than Requested Date and less than or equval to Current Date");
                }   
            }
       }
        });

        //load table
        $scope.loadTable = function() {
            var table = {};

            table.storeTableRow = [ {
                slNo : '',
                purchaseRequisitionId : '',
                purchaseRequisitionSubId : '',
                itemId : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategoryId : '',
                itemCategoryName : '',
                uomId : '',
                uomName : '',
                quantity : '',
                eddDate : ''

            } ];
            $scope.storeApprovalData.tables.push(table);
        }
        $scope.loadTable();

        //add Row 
        $scope.addRow = function(tables) {
            var len = tables.storeTableRow.length;
            var table = {
                slNo : '',
                purchaseRequisitionId : '',
                purchaseRequisitionSubId : '',
                itemId : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategoryId : '',
                itemCategoryName : '',
                uomId : '',
                uomName : '',
                quantity : '',
                eddDate : ''

            };

            tables.storeTableRow.push(table);

        };

        //remove Row
        $scope.removeRow = function(table) {
            $scope.tablerow = [];
            angular.forEach(table.storeTableRow, function(storeTableRow, index) {
                var check = storeTableRow.section;
                console.log(index);
                if (check == undefined || check == "") {
                    $scope.tablerow.push(storeTableRow);
                } else {

                }
            });
            table.storeTableRow = $scope.tablerow;
        };

        //Employee List requisitionStatus
        var userId = '';
        $scope.getDropdownvalue = function() {
            $http.get('app/hospital/purchase/storeApproval/employeeList').success(function(datas) {

                $scope.employeeList = datas.employeeList;
                $scope.locationList = datas.locationList;
                $scope.itemList = datas.itemList;
                
                $scope.statusList = datas.statusList;
                userId = datas.userId;
                
                console.log($scope.employeeList);

                $scope.sessionName(userId);

            }).error(function(data) {

            });

        }

        $scope.getDropdownvalue();

        var userName = "";
        $scope.sessionName = function(userId) {

            angular.forEach($scope.employeeList, function(value, key) {

                if (userId == value.employeeId) {
                    userName = value.employeeId;

                }
                $scope.storeApprovalData.approvedId = userName;
            });

        }



        //Save Functionality

        $scope.save = function(storeApprovalForm, storeApprovalData) {
            var isQuantity = 0;
            if (new validationService().checkFormValidity($scope.storeApprovalForm)) {
                
                var objheaderData = {
                    'purchaseRequisitionId' : $scope.storeApprovalData.purchaseRequisitionId,
                    'requisitionNumber' : $scope.storeApprovalData.requisitionNumber,
                    'requisitionDate' : $scope.storeApprovalData.requisitionDate,
                    'approvedId' : $scope.storeApprovalData.approvedId,
                    'requisitionType' : $scope.storeApprovalData.requisitionType,
                    'sourceLocation' : $scope.storeApprovalData.sourceLocation,
                    'destinationLocation' : $scope.storeApprovalData.destinationLocation,
                    'approvedDate' : $scope.storeApprovalData.approvedDate,
                    'requisitionStatus' : $scope.storeApprovalData.requisitionStatus,
                    'remarks' : $scope.storeApprovalData.remarks
                };

                var objWholeData = {
                    'headerData' : objheaderData,
                    'subData' : $scope.storeApprovalData.tables[0].storeTableRow
                };
                
                angular.forEach($scope.storeApprovalData.tables[0].storeTableRow, function (value, key) {
                    if(value.quantity=="0"){
                        isQuantity = 1;
                    }
                });
                
                if(isQuantity==1){
                    logger.logError("Quantity Must be Greater than Zero!");
                }else{
                    var myURL = 'app/hospital/purchase/storeApproval/update';
                    $http({
                        url : myURL,
                        data : objWholeData,
                        method : 'post',
                        dataType : 'json',
                        headers : {
                            'Accept' : 'application/json',
                            'Content-Type' : 'application/json'
                        }
                    }).success(function(data) {
                        console.log(data);

                        if (data.success == false) {
                            logger.logError(" Error in Store To Approval");
                        } else {
                            logger.logSuccess("Updated Successfully");
                            $location.path($stateParams.tenantid +'master/approve/list');

                        }

                    }).error(function(data) {

                    });
                }

            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.storeApprovalForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        //Edit Functionality

      /*  var rowCount = 0;
        var purchaseRequisitionId = $location.search().purchaseRequisitionId;

        if ($scope.storeApprovalData.purchaseRequisitionId == undefined) {
            $scope.isEdit = false;

        } else {
            $scope.isEdit = true;

            $http.post('app/hospital/purchase/storeApproval/edit', purchaseRequisitionId).success(function(result) {
                debugger;
                $scope.storeApprovalData.purchaseRequisitionId = result.headerData.purchaseRequisitionId;
                $scope.storeApprovalData.requisitionNumber = result.headerData.requisitionNumber;
                $scope.storeApprovalData.requisitionDate = result.headerData.requisitionDate;
                $scope.storeApprovalData.employeeId = result.headerData.employeeId;
                $scope.storeApprovalData.employeeName = result.headerData.employeeName;
                $scope.storeApprovalData.designationName = result.headerData.designationName;
                $scope.storeApprovalData.requisitionType = result.headerData.requisitionType;
                $scope.storeApprovalData.sourceLocation = result.headerData.sourceLocation;
                $scope.storeApprovalData.destinationLocation = result.headerData.destinationLocation;
                $scope.storeApprovalData.remarks = result.headerData.remarks;
                $scope.storeApprovalData.approvedDate =  $scope.date;//result.headerData.approvedDate;
                if (utilsService.isUndefinedOrNull(result.headerData.approvedDate)) {
                    $scope.showEmptyLabel = true;
                    }
                else{
                    $scope.storeApprovalData.approvedDate = result.headerData.approvedDate;
                }
                $scope.storeApprovalData.requisitionStatus = result.headerData.requisitionStatus;
                $scope.storeApprovalData.requisitionStatusName = result.headerData.requisitionStatusName;
                
                console.log("result.subData ::::::::::::::");
                console.log(result.subData);
                $scope.storeApprovalData.tables[0].storeTableRow = result.subData;
                rowCount = $scope.storeApprovalData.tables[0].storeTableRow.length;

            }).error(function(data) {

            });
        }*/

        var rowCount = 0;
        var purchaseRequisitionId = $location.search().purchaseRequisitionId;

        if ($scope.storeApprovalData.purchaseRequisitionId == undefined) {
            $scope.isEdit = false;

        } else {
            $scope.isEdit = true;
            $http.post('app/hospital/purchase/storeApproval/view', purchaseRequisitionId).success(function(result) {

                $scope.storeApprovalData.purchaseRequisitionId = result.headerData.purchaseRequisitionId;
                $scope.storeApprovalData.requisitionNumber = result.headerData.requisitionNumber;
                $scope.storeApprovalData.requisitionDate = result.headerData.requisitionDate;
                $scope.storeApprovalData.employeeId = result.headerData.employeeId;
                $scope.storeApprovalData.employeeName = result.headerData.employeeName;
                $scope.storeApprovalData.designationName = result.headerData.designationName;
                $scope.storeApprovalData.requisitionType = result.headerData.requisitionType;
                $scope.storeApprovalData.sourceLocation = result.headerData.sourceLocation;
                $scope.storeApprovalData.destinationLocation = result.headerData.destinationLocation;
                $scope.storeApprovalData.remarks = result.headerData.remarks;
                $scope.storeApprovalData.approvedDate = result.headerData.approvedDate;
                //$scope.storeApprovalData.requisitionStatus = result.headerData.requisitionStatus;
                $scope.storeApprovalData.requisitionStatusName = result.headerData.requisitionStatusName;
                $scope.storeApprovalData.prReqNo = result.headerData.prReqNo;
                $scope.storeApprovalData.prReqDate = result.headerData.prReqDate;
                $scope.storeApprovalData.tables[0].storeTableRow = result.subData;
                rowCount = $scope.storeApprovalData.tables[0].storeTableRow.length;
                
                var currentDate = new Date();
                currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
                
                $scope.storeApprovalData.requisitionStatus = "67";
                $scope.storeApprovalData.approvedDate = currentDate;

            }).error(function(data) {

            });
        }

        $scope.reset = function(storeApprovalAddForm) {

            if ($scope.storeApprovalData.isEdit == false) {
                $scope.storeApprovalData.purchaseRequisitionId = '';
                $scope.storeApprovalData.requisitionNumber = '';
                $scope.storeApprovalData.requisitionDate = '';
                $scope.storeApprovalData.employeeId = '';
                $scope.storeApprovalData.designationName = '';
                $scope.storeApprovalData.requisitionType = '';
                $scope.storeApprovalData.sourceLocation = '';
                $scope.storeApprovalData.destinationLocation = '';
                $scope.storeApprovalData.tables[0].storeTableRow = [];
                $scope.addRow($scope.storeApprovalData.tables[0]);

            } else {
                $http.post('app/hospital/purchase/storeApproval/edit', purchaseRequisitionId).success(function(result) {
                    if (result.isEdit == false) {
                        logger.logError("Please Try Again");
                    } else {
                        
                        $scope.storeApprovalData.purchaseRequisitionId = result.headerData.purchaseRequisitionId;
                        $scope.storeApprovalData.requisitionNumber = result.headerData.requisitionNumber;
                        $scope.storeApprovalData.requisitionDate = result.headerData.requisitionDate;
                        $scope.storeApprovalData.employeeId = result.headerData.employeeId;
                        $scope.storeApprovalData.employeeName = result.headerData.employeeName;
                        $scope.storeApprovalData.designationName = result.headerData.designationName;
                        $scope.storeApprovalData.requisitionType = result.headerData.requisitionType;
                        $scope.storeApprovalData.sourceLocation = result.headerData.sourceLocation;
                        $scope.storeApprovalData.destinationLocation = result.headerData.destinationLocation;
                        $scope.storeApprovalData.remarks = result.headerData.remarks;
                        $scope.storeApprovalData.approvedDate = result.headerData.approvedDate;
                        //$scope.storeApprovalData.requisitionStatus = result.headerData.requisitionStatus;
                        $scope.storeApprovalData.requisitionStatusName = result.headerData.requisitionStatusName;
                        $scope.storeApprovalData.tables[0].storeTableRow = result.subData;
                        rowCount = $scope.storeApprovalData.tables[0].storeTableRow.length;
                        
                        var currentDate = new Date();
                        currentDate = ('0' + currentDate.getDate()).slice(-2)+"/"+('0' + (Number(currentDate.getMonth())+1)).slice(-2)+"/"+currentDate.getFullYear();
                        
                        $scope.storeApprovalData.requisitionStatus = "67";
                        $scope.storeApprovalData.approvedDate = currentDate;
                        
                    }
                });
            }
        };

    });

    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.$watch('storeApprovalData.tables[0].storeTableRow[trIndex].itemId', function(newValue, oldValue) {
            
            if(newValue != undefined && newValue != ''){
                $http.post("app/hospital/purchase/storeApproval/itemList", newValue).success(function(response) {
                    var data = response.itemData;

                    if (data != undefined) {
                        $scope.storeApprovalData.tables[0].storeTableRow[$scope.$index].itemName = data.itemName;
                        $scope.storeApprovalData.tables[0].storeTableRow[$scope.$index].itemDesc = data.itemDesc;
                        $scope.storeApprovalData.tables[0].storeTableRow[$scope.$index].itemCategoryName = data.itemCategoryName;
                        $scope.storeApprovalData.tables[0].storeTableRow[$scope.$index].uomName = data.uomName;
                    }

                });
            }

        });

    });

//});