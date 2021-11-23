'use strict';

app.controller('serviceMasterAddCtrl', function(sharedProperties, $templateCache, $injector, $location, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, toaster, validationService,$stateParams,$state) {

    $scope.companyList = [];

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = dd + '/' + mm + '/' + yyyy;

    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
    });

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = dd + '/' + mm + '/' + yyyy;

    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
    });

    $scope.hubList = [ {
        id : 'n',
        text : 'No'
    }, {
        id : 'y',
        text : 'Yes'
    }, ];

    $scope.legList = [ {
        id : '0',
        text : '---Select---'
    }, {
        id : 'WB',
        text : 'West Bound (WB)'
    }, {
        id : 'EB',
        text : 'East Bound (EB)'
    }, {
        id : 'NB',
        text : 'North Bound (NB)'
    }, {
        id : 'SB',
        text : 'South Bound(SB)'
    }, ];

    $scope.serviceMaster = {
        sectorCode : '',
        sectorName : '',
        operationSince : '',
        eqmtCntrlEnable : 'Y',
        isActive : 'Y',
        commenceDate : '',
        completionDate : '',
        companyCode : '',
        companyLocation : '',
        isEdit : false,
        
        createdBy: '',
     createdDate : '',
   modifiedBy: '',
modifiedDate: '',

sailingfreq:'',
avgtrans:'',
        tables : []

    };
    $scope.tables = [];
    $scope.serviceList = [];

    
    
	$http.get($stateParams.tenantid+'/app/commonUtility/getServiceOperator').success(function(data) {
		$scope.vesselOperList = data;
	});
	  
	  
    $scope.getDropdownvalue = function() {
     /*   $http.get($stateParams.tenantid+'/app/serviceMaster/getCompanyLocation').success(function(datas) {
            $scope.companyList = datas.objCompanyInfo;
            $scope.branchList = datas.objBranchInfo;
            if (!$scope.serviceMaster.isEdit){
                $scope.portList = datas.objPortTransmitInfo;
            } else {
                     $scope.portList = datas.objPortTransmitInfo;
                                
            }
        });*/
        
        
        $http.get($stateParams.tenantid+'/app/serviceMaster/getService').success(function(datas) {
            $scope.serviceList = datas;
        });
       
    }

    $scope.loadTable = function() {
        var table = {};
        table.row = [ {
            slNo : '',
            portCode : '',
            transhipmentHub : '',
            legDescription : '0',
        } ];
        $scope.serviceMaster.tables.push(table);
    }

   //

    $scope.addRow = function(tables, index) {
        var len = tables.row.length;
        var table = {
            slNo : '',
            portCode : "",
            id : "",
            transhipmentHub : "",
            legDescription : '0',
        };
        tables.row.splice(index + 1, 0, table);
        // tables.row.push(table);
        // $scope.getDropdownvalue();

    }

    $scope.removeRow = function(table) {
        console.log(table);
        $scope.tablerow = [];
        angular.forEach(table.row, function(row, index) {
            var check = row.section;
            console.log(index);
            if (check == undefined || check == "") {
                $scope.tablerow.push(row);
            } else {

            }
        });
        table.row = $scope.tablerow;
    };

    $scope.cancel = function() {
        $state.go("app.master.service.servicemaster")

    };

    /** ********Add,Edit and Delete******** */

    // Edit functionality
    $scope.isEdit = false;

    var rowCount = 0;
    var sectorCode = $location.search().sectorCode;
    if (sectorCode == undefined) {
        $scope.serviceMaster.isEdit = false;
        $scope.loadTable();
        $scope.getDropdownvalue();
    } else {
        $http.post($stateParams.tenantid+'/app/serviceMaster/edit', sectorCode).success(function(result) {

            if (result.isEdit == false) {
                logger.logError("Please Try Again");
            } else {
                console.log("viewwww")
                     console.log(result)
                $scope.serviceMaster.sectorCode = result.companyInfoHeader.sectorCode;
                $scope.serviceMaster.sectorName = result.companyInfoHeader.sectorName;
                $scope.serviceMaster.operationSince = result.companyInfoHeader.operationSince;
                $scope.serviceMaster.eqmtCntrlEnable = result.companyInfoHeader.eqmtCntrlEnable;
                $scope.serviceMaster.isActive = result.companyInfoHeader.isActive;
                $scope.serviceMaster.commenceDate = result.companyInfoHeader.commenceDate;
                $scope.serviceMaster.completionDate = result.companyInfoHeader.completionDate;
                $scope.serviceMaster.companyCode = result.companyInfoHeader.companyCode;
                $scope.serviceMaster.vesselOperator = result.companyInfoHeader.vesselOperator;
                $scope.serviceMaster.vendorName = result.companyInfoHeader.vendorName;                
                $scope.serviceMaster.avgtrans = result.companyInfoHeader.avgtrans;
                $scope.serviceMaster.sailingfreq = result.companyInfoHeader.sailingfreq;
                
                $scope.serviceMaster.createdBy = result.companyInfoHeader.createdBy ;
                $scope.serviceMaster.createdDate  = result.companyInfoHeader.createdDate ;
                $scope.serviceMaster.modifiedBy = result.companyInfoHeader.modifiedBy ;
                $scope.serviceMaster.modifiedDate = result.companyInfoHeader.modifiedDate ;
                $scope.serviceMaster.branchName = result.companyInfoHeader.branchName ;
                
             console.log(result.objPortTransmitInfo)
               // rowCount = $scope.serviceMaster.tables[0].row.length;
                rowCount = result.objPortTransmitInfo.length;

                if(rowCount == 0)
                {          
                $scope.loadTable();
                }else{
                    $scope.loadTable();
                    $scope.serviceMaster.tables[0].row = result.objPortTransmitInfo;
                }

                $scope.serviceMaster.isEdit = result.companyInfoHeader.isEdit;

                $scope.getDropdownvalue();
            }
        }).error(function(data) {

        });
    }

    // Save Functionality

    $scope.save = function(serviceMasterForm, serviceMaster) {

        if (new validationService().checkFormValidity($scope.serviceMasterForm)) {
            $scope.serviceMaster.commenceDate = $('#commenceDate').val();
            $scope.serviceMaster.completionDate = $('#completionDate').val();

            var objheaderData = {
                'companyCode' : $scope.serviceMaster.companyCode,
                'commenceDate' : $scope.serviceMaster.commenceDate,
                'completionDate' : $scope.serviceMaster.completionDate,
                'eqmtCntrlEnable' : $scope.serviceMaster.eqmtCntrlEnable,
                'isActive' : $scope.serviceMaster.isActive,
                'operationSince' : $scope.serviceMaster.operationSince,
                'sectorCode' : $scope.serviceMaster.sectorCode,
                'sectorName' : $scope.serviceMaster.sectorName,
                'vesselOperator' :  $scope.serviceMaster.vesselOperator,
                'sailingfreq' : $scope.serviceMaster.sailingfreq,
                'avgtrans' :  $scope.serviceMaster.avgtrans,
                
           
            };

            var objWholeData = {
                'companyInfoHeader' : objheaderData,
                'objPortTransmitInfo' : $scope.serviceMaster.tables[0].row
            };
            console.log($scope.serviceMaster)
            $scope.list = $scope.serviceMaster.tables[0];
            var message = "";
            for(var i = 0;i < $scope.list.length;i++){
                for(var j = i+1;j < $scope.list.length;i++){
                    if($scope.list[i].portCode==$scope.list[j].portCode && 
                            $scope.list[i].transhipmentHub == $scope.list[j].transhipmentHub &&
                            $scope.list[i].legDescription == $scope.list[j].legDescription){
                         message += (i+1) + "and " +(j+1)+" Line's has repeation of pol,pod and payer combination.<br>";
                    }
                }
            }
            if(message.length>0)
                logger.logError(message)
            else{
            var myURL = $stateParams.tenantid+'/app/serviceMaster/add';
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
               
                    if (data.success == false) {
                        if(data.message == ""){                            
                        logger.logError("Unable to Save");
                        }else
                        logger.logError(data.message);
                    } else {
                        logger.logSuccess("Saved Successfully");
                        $state.go("app.master.service.servicemaster")

                    }
                

            }).error(function(data) {

            });
            }

        } else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.serviceMasterForm.$validationSummary), 555000, 'trustedHtml');
        }
    }

    $scope.update = function(serviceMasterForm, serviceMaster) {
        $scope.list = [];
        if (new validationService().checkFormValidity($scope.serviceMasterForm)) {

            $scope.serviceMaster.commenceDate = $('#commenceDate').val();
            $scope.serviceMaster.completionDate = $('#completionDate').val();

            var objheaderData = {
                'companyCode' : $scope.serviceMaster.companyCode,
                'commenceDate' : $scope.serviceMaster.commenceDate,
                'completionDate' : $scope.serviceMaster.completionDate,
                'eqmtCntrlEnable' : $scope.serviceMaster.eqmtCntrlEnable,
                'isActive' : $scope.serviceMaster.isActive,
                'operationSince' : $scope.serviceMaster.operationSince,
                'sectorCode' : $scope.serviceMaster.sectorCode,
                'sectorName' : $scope.serviceMaster.sectorName,
                'vesselOperator' :  $scope.serviceMaster.vesselOperator,
                'avgtrans' : $scope.serviceMaster.avgtrans,
                'sailingfreq' :  $scope.serviceMaster.sailingfreq,
           
		
            };

            var objWholeData = {
                'companyInfoHeader' : objheaderData,
                'objPortTransmitInfo' : $scope.serviceMaster.tables[0].row
            };
            /*$scope.list.push($scope.serviceMaster.tables[0].row);
            console.log($scope.list.length)
            var message = "";
            for(var i = 0;i < $scope.list.length;i++){
                for(var j = i+1;j < $scope.list.length;i++){
                    if($scope.list[i].portCode==$scope.list[j].portCode && 
                            $scope.list[i].transhipmentHub == $scope.list[j].transhipmentHub &&
                            $scope.list[i].legDescription == $scope.list[j].legDescription){
                         message += (i+1) + "and " +(j+1)+" Line's has repeation of pol,pod and payer combination.<br>";
                    }
                }
            }
            if(message.length>0)
                logger.logError(message)
            else{*/
            var myURL = $stateParams.tenantid+'/app/serviceMaster/update';
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
                console.log("update^^^^^^")
                console.log(data)
                
                    if (data.success == false) {
                        if(data.message != ""){
                            logger.logError(data.message);
                        }else{
                            logger.logError("Unable to update");
                        }
                        
                    } else {
                        logger.logSuccess("Updated Successfully");
                        $state.go("app.master.service.servicemaster")
                    }
                
               /* if (data == false) {
                    logger.logError("Service Master already exists");
                } else {
                    logger.logSuccess("Service Master Updated Successfully");
                    $location.path('service/servicemaster');
                }*/

            }).error(function(data) {

            });

        }
        //}
        else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.serviceMasterForm.$validationSummary), 555000, 'trustedHtml');
        }
    };

    $scope.calcSeaTime = function(rowObj) {
        var distance = rowObj.distance;
        var speed = rowObj.speed;
        if (distance != '' && speed != '' && distance != null && speed != null) {
            if (distance == '0' || speed == '0') {
                rowObj.steamingHour = 0;
                rowObj.steamingMin = 0;
            } else {
                rowObj.steamingHour = Math.floor((distance * 60 / speed * 1) / 60);
                rowObj.steamingMin = Math.round((distance * 60 / speed * 1) % 60);
            }
        } else {
            rowObj.steamingHour = '';
            rowObj.steamingMin = '';
        }
    }
    
    

});