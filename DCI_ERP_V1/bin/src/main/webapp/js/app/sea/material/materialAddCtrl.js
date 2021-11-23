//define([ 'hospital/purchase/purchase' ], function(module) {

    'use strict';

    app.controller('materialAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, $filter, validationService) {

        $scope.companyList = [];
        $scope.employeeList = [];
        $scope.locationList = [];
        $scope.destLocationList = [];
        $scope.costList = [];
        $scope.isEdit = false;
        $scope.admin;
        $scope.name;
        $scope.len;
        var d = new Date();

        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        ;
        var day = d.getDate();
        $scope.date = day + "/" + month + "/" + year;
        $scope.consignmentRequestData = {
            purchaseRequisitionId : '',
            requisitionNumber : '',
            requisitionDate : '',
            employeeId : '',
            employeeName : '',
            requisitionType : '',
            ItemDescription : '',
            designationName : '',
            costcenter : '',
            sourceLocationName : '',
            destinationLocationName : '',
            sourceLocation : '',
            destinationLocation : '',
            designationId : '',
            companyId : '',
            requisitionStatus : 68,
            prReqNo : '',
            reqDate : '',
            requestType : '217',
            tables : []
        };

        $scope.requisitionStatus = function() {
            $scope.consignmentRequestData.requisitionStatus = 68;
        };

        // load table
        $scope.loadTable = function() {
            var table = {};

            table.consignmentReqRow = [ {
                slNo : '',
                purchaseRequisitionId : '',
                purchaseRequisitionSubId : '',
                itemId : '',
                availQuantity : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategoryId : '',
                itemCategoryName : '',
                itemdescription : '',
                uomId : '',
                uomName : '',
                quantity : '',
                eddDate : '',
                disableDate : false,
                altuom:'',
                altqty:''

            } ];
            $scope.consignmentRequestData.tables.push(table);

        }
        $scope.loadTable();

        // costList Company based
        $scope.$watch("consignmentRequestData.companyId", function(newValue, oldValue) {
            var companyCode = $scope.consignmentRequestData.companyId;
            $http.get('app/purchaseOrder/costcenterList?companyId=' + companyCode).success(function(datas) {
                $scope.costList = datas;
            });
        });
        // validate PR number
        $scope.checkDuplicate = function(prnumber, PRId) {
            if (!$scope.isEdit) {
                $http.get('app/hospital/purchase/consignmentRequest/checkPRnumber?prnumber=' + prnumber).success(function(datas) {
                    if (datas.message == 'SUCCESS') {

                    } else {
                        $scope.consignmentRequestData.prReqNo = "";
                        logger.logError(datas.message);
                    }
                });
            } else {
                var PRnum = 0;
                $http.get('app/hospital/purchase/consignmentRequest/checkPRnumberwithPR?prnumber=' + prnumber + '&PRId=' + PRId).success(function(datas) {
                    if (datas.message == 'SUCCESS') {

                    } else {
                        $scope.consignmentRequestData.prReqNo = prnumber;
                        logger.logError(datas.message);
                    }
                });
            }
        }

        // $scope.consignmentRequestData.reqDate
        $scope.disableSave = false;
        $scope.validate = function(consignmentRequestForm, consignmentRequestData) {

            if (new validationService().checkFormValidity($scope.consignmentRequestForm)) {
                $scope.disableSave = true;
                $scope.save(consignmentRequestData);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.consignmentRequestForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.consignmentRequestData.requisitionDate = $scope.date;

        /*
         * $scope.$watch('consignmentRequestData.requisitionDate',function(newValue,oldValue){
         * if(newValue !== undefined && newValue !== ""){ var givenDate
         * =newValue.split("/"); var from = new Date(givenDate[2], givenDate[1] -
         * 1, givenDate[0]); var currentDateSplit=$scope.date.split("/"); var
         * currentDate1 = new
         * Date(currentDateSplit[2],currentDateSplit[1]-1,currentDateSplit[0]);
         * if (from > currentDate1 ) { logger.logError("Request Date greater
         * than Today's Date");
         * $scope.consignmentRequestData.requisitionDate=''; } } });
         */

       /* $scope.$watchCollection('[ consignmentRequestData.sourceLocation,consignmentRequestData.destinationLocation]', function(newValues) {
            $scope.locationChange($scope.consignmentRequestData.sourceLocation, $scope.consignmentRequestData.destinationLocation);
        });

        $scope.locationChange = function(sourceLocation, destinationLocation) {
            if (sourceLocation != "" && destinationLocation != "") {
                if (sourceLocation == destinationLocation) {
                    $scope.consignmentRequestData.destinationLocation = '';
                    $scope.consignmentRequestData.sourceLocation = '';
                    logger.logError("Source Location and Destination Location Should not be Same!");
                }
            }
        };

*/        $scope.cancel = function() {
            console.log("$scope.consignmentRequestData.tables[0].consignmentReqRow.itemId");
            console.log($scope.consignmentRequestData.tables[0].consignmentReqRow);
            // $state.go("app.hospital.purchase.consignmentRequest.list");
            $state.go("app.sea.material.list");

        };

        // add Row
        $scope.addRow = function(tables) {
            $scope.len = tables.consignmentReqRow.length;
            var table = {
                slNo : '',
                purchaseRequisitionId : '',
                purchaseRequisitionSubId : '',
                itemId : '',
                availQuantity : '',
                itemCode : '',
                itemName : '',
                itemDesc : '',
                itemCategoryId : '',
                itemCategoryName : '',
                itemdescription : '',
                uomId : '',
                uomName : '',
                quantity : '',
                eddDate : '',
                disableDate : false
            };

            tables.consignmentReqRow.push(table);
            $scope.tab = tables;
            console.log("$scope.tab");
            console.log($scope.len);
        };

        $scope.chkAll = false;
        $scope.checkAll = function(checkBox) {
            console.log("consignmentReq table");
            console.log($scope.consignmentRequestData.tables[0].consignmentReqRow);
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.consignmentRequestData.tables[0].consignmentReqRow, function(row) {
                row.section = $scope.chkAll;
            });

        };

        // remove Row
        $scope.removeRow = function(table) {
            $scope.tablerow = [];
            angular.forEach(table.consignmentReqRow, function(consignmentReqRow, index) {
                var check = consignmentReqRow.section;
                console.log(index);
                if (check == undefined || check == "") {
                    $scope.tablerow.push(consignmentReqRow);
                } else {

                }
            });
            table.consignmentReqRow = $scope.tablerow;
        };

        $scope.$watch('consignmentRequestData.reqDate', function(newValue, oldValue) {

            // $scope.CurrentDate = new Date();
            // alert("hh"+$scope.CurrentDate);
            // var date = CurrentDate | date:'dd/MM/yyyy'

            debugger;
            if (newValue !== undefined && newValue !== "") {
                if (newValue != '' && $scope.consignmentRequestData.reqDate != '') {
                    var todayDate = $scope.date;
                    var fromDate = $scope.consignmentRequestData.requisitionDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1], todayDate[0]);
                    if (fromDate < toDate) {
                        $scope.consignmentRequestData.reqDate = "";
                        logger.logError("Request Date should be lower than or equal to requested date and today date!");
                    }
                    /*
                     * if($scope.consignmentRequestData.requisitionStatus==68){
                     * if(fromDate <= toDate && toDate >=todayDate){
                     * 
                     * }else{ logger.logError("EDD Date should be greater than
                     * or equal to requested date and today date!");
                     * $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].eddDate =
                     * $scope.date; } }
                     */
                }
            }

        });
        // Employee List
        var userId = "";
        $scope.getDropdownvalue = function() {

            $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
                $scope.parentLocationList = datas;

                $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas) {

                    $scope.employeeList = datas.employeeList;
                    $scope.locationList = datas.locationList;
                    $scope.itemList = datas.itemList;
                    $scope.destLocationList = datas.destLocationList;
                    // $scope.costList = datas.costList;
                    $scope.requestTypeList = datas.requestTypeList;
                    console.log("$scope.employeeList");
                    console.log($scope.employeeList);
                    userId = datas.userId;

                    $scope.sessionName(userId);
                    if (purchaseRequisitionId == undefined || purchaseRequisitionId == null || purchaseRequisitionId == "") {
                        $scope.isEdit = false;
                        
                    } else {

                        $scope.isEdit = true;
                        $http.post('app/hospital/purchase/consignmentRequest/edit', purchaseRequisitionId).success(function(result) {
                            console.log(result);
                            $scope.consignmentRequestData.purchaseRequisitionId = result.headerData.purchaseRequisitionId;
                            $scope.consignmentRequestData.requisitionNumber = result.headerData.requisitionNumber;
                            $scope.consignmentRequestData.requisitionDate = result.headerData.requisitionDate;
                            $scope.consignmentRequestData.employeeId = result.headerData.employeeId;
                            $scope.consignmentRequestData.designationName = result.headerData.designationName;
                            $scope.consignmentRequestData.requisitionType = result.headerData.requisitionType;
                            $scope.consignmentRequestData.costcenter = result.headerData.costcenter;
                            $scope.consignmentRequestData.requisitionStatus = result.headerData.requisitionStatus;
                            $scope.consignmentRequestData.requisitionStatusName = result.headerData.requisitionStatusName;
                            $scope.consignmentRequestData.sourceLocation = result.headerData.sourceLocation;
                            $scope.consignmentRequestData.destinationLocation = result.headerData.destinationLocation;
                            $scope.consignmentRequestData.companyId = result.headerData.companyId;
                            $scope.consignmentRequestData.prReqNo = result.headerData.prRequestNo;
                            $scope.consignmentRequestData.reqDate = result.headerData.requestDate;
                            $scope.consignmentRequestData.tables[0].consignmentReqRow = result.subData;
                            rowCount = $scope.consignmentRequestData.tables[0].consignmentReqRow.length;

                            
//                            angular.forEach($scope.consignmentRequestData.tables[0].consignmentReqRow,function(row,index){
//                                $scope.consignmentRequestData.tables[0].consignmentReqRow[index].altuom = row.altuom.toString();
//                                $scope.consignmentRequestData.tables[0].consignmentReqRow[index].altqty = row.altqty; 
//                                alert(   $scope.consignmentRequestData.tables[0].consignmentReqRow[index].altuom );
//                            });
                            
                            var obj = $filter('filter')($scope.parentLocationList, {
                                id : result.headerData.sourceLocation
                            });

                        }).error(function(data) {

                        });
                    }
                }).error(function(data) {

                });
            });

            /*
             * $http.get('app/commonUtility/getCompanyList').success(function(datas) {
             * $scope.companyList = datas; }).error(function(datas) { });
             */
            $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });

        }

        $scope.getDropdownvalue();

        $scope.uomCategoryList = [];

        $http.get("app/hospital/inventory/manageUOM/uomCategoryList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });
        var userName = "";
        var designationName = "";
        $scope.sessionName = function(userId) {
            angular.forEach($scope.employeeList, function(value, key) {
                if (userId == value.employeeId) {
                    userName = value.employeeId;
                    designationName = value.designationName;
                }
                $scope.consignmentRequestData.employeeId = userName;
                $scope.admin = userName;
                $scope.consignmentRequestData.designationName = designationName;
                $scope.name = designationName;
            });
        }

        // Fetching job Title

        var designationName = "";
        $scope.$watch('consignmentRequestData.employeeId', function(newValue, oldValue) {
            angular.forEach($scope.employeeList, function(value, key) {
                if (newValue == value.employeeId) {
                    designationName = value.designationName;
                }
                $scope.consignmentRequestData.designationName = designationName;
                $scope.designationName = designationName;
            });

        });

        $scope.save = function(consignmentRequestData) {

            var objheaderData = {
                'purchaseRequisitionId' : $scope.consignmentRequestData.purchaseRequisitionId,
                'requisitionNumber' : $scope.consignmentRequestData.requisitionNumber,
                'requisitionDate' : $scope.consignmentRequestData.requisitionDate,
                'employeeId' : $scope.consignmentRequestData.employeeId,
                'requisitionType' : $scope.consignmentRequestData.requisitionType,
                'costcenter' : $scope.consignmentRequestData.costcenter,
                'sourceLocation' : $scope.consignmentRequestData.sourceLocation,
                'destinationLocation' : $scope.consignmentRequestData.destinationLocation,
                'companyId' : $scope.consignmentRequestData.companyId,
                'requisitionStatus' : $scope.consignmentRequestData.requisitionStatus,
                'prRequestNo' : $scope.consignmentRequestData.prReqNo,
                'requestDate' : $scope.consignmentRequestData.reqDate,
                'requestType' : $scope.consignmentRequestData.requestType
            };

            var objWholeData = {
                'headerData' : objheaderData,
                'subData' : $scope.consignmentRequestData.tables[0].consignmentReqRow
            };

            if (!$scope.isEdit) {
                var flag = true, flag2 = true;
                if ($scope.consignmentRequestData.requisitionDate == '' && $scope.consignmentRequestData.sourceLocation == '') {
                    logger.logError("RequisitionDate Mandatory");
                    logger.logError("sourceLocation Mandatory");
                } else {

                    angular.forEach($scope.consignmentRequestData.tables[0].consignmentReqRow, function(value, key) {
                        if (value.quantity <= 0) {
                            flag = false;
                            value.quantity = '';
                        }

                    });

                    if ($scope.consignmentRequestData.tables[0].consignmentReqRow.length <= 0 || $scope.consignmentRequestData.tables[0].consignmentReqRow == undefined || $scope.consignmentRequestData.tables[0].consignmentReqRow == null || $scope.consignmentRequestData.tables[0].consignmentReqRow == '') {
                        flag2 = false;
                    }

                    if (flag == true && flag2 == true) {
                        var myURL = 'app/hospital/purchase/consignmentRequest/save';
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
                            // save disable
                            /*
                             * if(data==true){ $scope.disableSave=true; }else{
                             * $scope.disableSave=false; }
                             */

                            if (data.success == false) {
                                logger.logError(" Error in Material Request");
                            } else {

                                logger.logSuccess("Material Request Added Successfully");
                                $location.path(  $stateParams.tenantid +' /material/list');
                            }

                        }).error(function(data) {

                        });

                    } else {
                        if (flag == false) {
                            logger.logError("Qunatity should be greter than zero");
                        }
                        if (flag2 == false) {
                            logger.logError("Please add Atleast one item");
                        }
                    }
                    console.log("objWholeData");
                    console.log(objWholeData);
                    console.log($scope.consignmentRequestData.tables[0].consignmentReqRow);

                }
            } else {
                // $scope.disableSave=false;
                var flag = true, flag2 = true;
                angular.forEach($scope.consignmentRequestData.tables[0].consignmentReqRow, function(value, key) {
                    if (value.quantity <= 0) {
                        flag = false;
                    }

                });

                if ($scope.consignmentRequestData.tables[0].consignmentReqRow.length <= 0 || $scope.consignmentRequestData.tables[0].consignmentReqRow == undefined || $scope.consignmentRequestData.tables[0].consignmentReqRow == null || $scope.consignmentRequestData.tables[0].consignmentReqRow == '') {
                    flag2 = false;
                }

                if (flag == true && flag2 == true) {
                    var myURL = 'app/hospital/purchase/consignmentRequest/update';
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
                            logger.logError(" Error in Material Request");
                        } else {
                            logger.logSuccess("Material Request Updtaed Successfully");
                            $location.path(  $stateParams.tenantid +' /material/list');
                        }

                    }).error(function(data) {

                    });
                } else {
                    if (flag == false) {
                        logger.logError("Qunatity should be greter than zero");
                    }
                    if (flag2 == false) {
                        logger.logError("Please add Atleast one item");
                    }
                }
            }
        };

        // Edit Functionality
        $scope.existFlag = false;
        var rowCount = 0;
        var purchaseRequisitionId = $location.search().purchaseRequisitionId;

        if (purchaseRequisitionId == undefined || purchaseRequisitionId == null || purchaseRequisitionId == "") {
            $scope.isEdit = false;

        } else {

            $scope.isEdit = true;
            $http.post('app/hospital/purchase/consignmentRequest/edit', purchaseRequisitionId).success(function(result) {
                $scope.consignmentRequestData.requisitionNumber = result.headerData.requisitionNumber;
                $scope.consignmentRequestData.requisitionDate = result.headerData.requisitionDate;
                $scope.consignmentRequestData.employeeId = result.headerData.employeeId;
                $scope.consignmentRequestData.designationName = result.headerData.designationName;
                $scope.consignmentRequestData.requisitionType = result.headerData.requisitionType;
                $scope.consignmentRequestData.costcenter = result.headerData.costcenter;

                $scope.consignmentRequestData.sourceLocation = result.headerData.sourceLocation;
                $scope.consignmentRequestData.destinationLocation = result.headerData.destinationLocation;
                $scope.consignmentRequestData.sourceLocationName = result.headerData.sourceLocationName;
                $scope.consignmentRequestData.destinationLocationName = result.headerData.destinationLocationName;
                $scope.consignmentRequestData.companyId = result.headerData.companyId;
                $scope.consignmentRequestData.tables[0].consignmentReqRow = result.subData;
                $scope.consignmentRequestData.requisitionStatus = result.headerData.requisitionStatus;
                $scope.consignmentRequestData.requestType = result.headerData.requestType.toString();
                $scope.existFlag = result.headerData.existFlag;
                rowCount = $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
            }).error(function(data) {

            });
        }

        $scope.reset = function(consignmentRequestAddForm) {
            if ($scope.isEdit == false) {
                $scope.consignmentRequestData.purchaseRequisitionId = '';
                $scope.consignmentRequestData.requisitionNumber = '';
                $scope.consignmentRequestData.requisitionDate = '';
                $scope.consignmentRequestData.employeeId = $scope.admin;
                $scope.consignmentRequestData.designationName = $scope.name;
                $scope.consignmentRequestData.requisitionType = '';
                $scope.consignmentRequestData.sourceLocation = '';
                $scope.consignmentRequestData.destinationLocation = '';
                $scope.consignmentRequestData.companyId = '';
                $scope.consignmentRequestData.requisitionStatus = 68;
                $scope.consignmentRequestData.tables[0].consignmentReqRow = [];
                $scope.addRow($scope.consignmentRequestData.tables[0]);

            } else {
                $http.post('app/hospital/purchase/consignmentRequest/edit', purchaseRequisitionId).success(function(result) {
                    console.log(result);
                    console.log("purchaseRequisitionId*****************");
                    console.log(result);
                    $scope.consignmentRequestData.requisitionNumber = result.headerData.requisitionNumber;
                    $scope.consignmentRequestData.requisitionDate = result.headerData.requisitionDate;
                    $scope.consignmentRequestData.employeeId = result.headerData.employeeId;
                    $scope.consignmentRequestData.designationName = result.headerData.designationName;
                    $scope.consignmentRequestData.requisitionType = result.headerData.requisitionType;
                    $scope.consignmentRequestData.sourceLocation = result.headerData.sourceLocation.toString();
                    console.log("$scope.consignmentRequestData.sourceLocation");
                    console.log($scope.consignmentRequestData.sourceLocation);
                    $scope.consignmentRequestData.destinationLocation = result.headerData.destinationLocation.toString();
                    $scope.consignmentRequestData.companyId = result.headerData.companyId;
                    $scope.consignmentRequestData.sourceLocation = parseInt(result.headerData.sourceLocation);
                    $scope.consignmentRequestData.destinationLocation = parseInt(result.headerData.destinationLocation);
                    $scope.consignmentRequestData.requisitionStatus = result.headerData.requisitionStatus;
                    $scope.consignmentRequestData.requestType = result.headerData.requestType.toString();

                    $scope.consignmentRequestData.tables[0].consignmentReqRow = result.subData;
                    rowCount = $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
                });
            }
        };

    });

    app.controller('parentCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.$watch('consignmentRequestData.tables[0].consignmentReqRow[trIndex].itemId', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '' && newValue != null) {
                if($scope.isEdit == false){
                $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
                    var data = response.itemData;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemName = data.itemName;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemDesc = data.itemDesc;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemCategoryName = data.itemCategoryName;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].uomName = data.uomName;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].availQuantity = data.availQuantity;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].altuom = data.altuom;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].altuomName = data.altuomName;
                    $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].altqty = data.altqty;

                });
                }
                /*
                 * if(newValue!=undefined && newValue!=''){ var length=
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
                 * for(var i=0;i<length;i++){ for(var j=0;j<length;j++){
                 * if(i!=j){
                 * if($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!=undefined &&
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!=null &&
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!='' &&
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!=undefined &&
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!=null &&
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!='' ){
                 * if($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId
                 * ==$scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId){
                 * logger.logError("Item Name already added");
                 * $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemId='';
                 * return false; } } } } }
                 *  }
                 */
            }

        });

        // $scope.$watchCollection('[consignmentRequestData.tables[0].consignmentReqRow[trIndex].itemId,consignmentRequestData.tables[0].consignmentReqRow[trIndex].itemdescription]',
        // function(newValue, oldValue) {
        $scope.$watch('consignmentRequestData.tables[0].consignmentReqRow[trIndex].itemId', function(newValue, oldValue) {

            if (newValue != undefined && newValue != '' && newValue != null) {
                $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
                    /*
                     * var data = response.itemData;
                     * $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemName =
                     * data.itemName;
                     * $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemDesc =
                     * data.itemDesc;
                     * $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemCategoryName =
                     * data.itemCategoryName;
                     * $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].uomName =
                     * data.uomName;
                     */

                });

                if (newValue != undefined && newValue != '') {
                    var length = $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
                    for (var i = 0; i < length; i++) {
                        for (var j = 0; j < length; j++) {
                            if (i != j) {
                                if ($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId != undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId != null && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId != '' && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId != undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId != null && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId != '') {
                                    if ($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId == $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId) {
                                        logger.logError("Item Name already added");
                                        $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemId = '';
                                        $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemdescription = '';
                                        return false;
                                    }
                                }
                            }
                        }
                    }

                }
            }

        });

       /* $scope.$watch('consignmentRequestData.tables[0].consignmentReqRow[trIndex].eddDate', function(newValue, oldValue) {
            debugger;
            if (newValue !== undefined && newValue !== "") {
                if (newValue != '' && $scope.consignmentRequestData.requisitionDate != '') {
                    var todayDate = $scope.date;
                    var fromDate = $scope.consignmentRequestData.requisitionDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1], toDate[0]);
                    todayDate = todayDate.split("/");
                    todayDate = new Date(todayDate[2], todayDate[1], todayDate[0]);

                    if ($scope.consignmentRequestData.requisitionStatus == 68) {
                        if (fromDate <= toDate && toDate >= todayDate) {

                        } else {
                            logger.logError("EDD Date should be greater than or equal to requested date and today date!");
                            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].eddDate = $scope.date;
                        }
                    }
                }
            }

        });
*/
    });

//});