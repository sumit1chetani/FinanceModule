//define([ 'hospital/inventory/inventory' ], function(module) {


    'use strict';
    app.controller('ggrnListCtrl', function($scope, $state, $http, ngDialog,$stateParams, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope,$window) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0

        $scope.isDisplay = false;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.getList = function() {
            var url = 'app/grn/list?formName=grn&limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lGRNBean);
                    sharedProperties.setObject($scope.emptyObject);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        };

        $scope.getList();

        $scope.add = function() {
            $state.go("app.finance.inventory.ggrn.add");
        };

        $scope.navPoDetailsView = function(poId, purchaseType) {
            if (purchaseType == 44) {
                $location.url($stateParams.tenantid +'/finance/purchase/rateContract/view?purchaseOrderId=' + poId);
            }
            if (purchaseType == 45) {
                $location.url($stateParams.tenantid +'/finance/purchase/consignmentPO/view?purchaseOrderId=' + poId);
            }
            if (purchaseType == 43) {
                $location.url($stateParams.tenantid +'/finance/purchase/purchaseOrder/view?purchaseOrderId=' + poId);
            }
        }

        $scope.editRowBtn = function(grnCode) {
            $location.url($stateParams.tenantid +'/finance/inventory/ggrn/view?grnCode=' + grnCode);
        }

        $scope.deleteRow = function(grnNo, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/grn/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : grnNo,
                }).success(function(data) {
                    if (data == true) {
                        debugger;
                        $scope.rowCollection.splice(index, 1);
                        $state.reload();
                        logger.logSuccess("deleted successfully");
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };

  /*      $scope.exportExcel1 = function() {

            $http.post('app/grn/exportExcel').success(function(data) {
                if (data.success == true) {
                    logger.logSuccess("File Exported Successfully");
                    $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/GRN_File.xls" class="control-label" download="GRN_File.xls"></a>');
                    $("#captainMsglink").bind('click', function() {
                    });
                    $('#captainMsglink').simulateClick('click');
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
            });
        };

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click(); // IE
                }
            });
        }*/

        $scope.exportExcel = function(){    
            $scope.grnData = {
                    grnId : '',
                    grnCode : '',
                    locId : '',
                    locName : '',
                    vendorId : '',
                    poId : '',
                    poNo : '',
                    poType : '',
                    grnDate : '',
                    poRequisitionId : '',
                    poRequisition : '',
                    delOrderNo : '',
                    delOrderDate : '',
                    invoiceNo : '',
                    invoiceDate : '',
                    dueDate : '',
                    deliveryMthd : '',
                    transMode : '',
                    dstLocId : '',
                    conTransferNo : '',
                    qcLocationId : '',
                    companyId : '',
                    poFreight : '',
                    description : '',
                    grnTables : [],
                    schDtlList : []
                }
       

            
            
            
                $http.post('app/grn/exportExcel1', $scope.grnData).success(function(data) {
                    if(data){
                        debugger;
                        $("#invReport").bind('click', function() {
                        });
                        $('#invReport').simulateClick('click');
                        logger.logSuccess("Exported successfully!");
                    }else{
                        logger.logError("Failed to export");
                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
         
        
        }

        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click(); // IE
                }
            });
        }
    });
    
        
/*        //print
        $scope.GRNprint = function(grnCode){
            var url='app/grn/grnPrint?grnId='+grnCode;
            var wnd = $window.open(url, 'Omega', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();   
         
        } */

 

//});