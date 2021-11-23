'use strict';
app.controller('userMasterListCtrl', function($scope,$filter, $timeout, $rootScope, $http, $location, logger, $log, ngDialog, utilsService, $injector, sharedProperties, toaster,$stateParams) {

    $scope.userList = [];
    $scope.companyList = [];
    $scope.moduleList = [];
    $scope.formList = [];
    $scope.propertyAll = false;
    $scope.propertyList = [];
    $scope.userFormList=[];
	 $scope.modeList=[];
    $scope.user = {
        userId : '',
        userName : '',
        companyCodesMapped : [],
        mode :''
    };

    $scope.company = {
        companyCode : '',
        companyName : '',
        selected : false
    };

    $scope.module = {
        moduleCode : '',
        moduleName : ''
    };

    $scope.getUserCompanyModuleList = function() {
       $http.get( $stateParams.tenantid+'/app/usermaster/usercompanymodulelist').success(function(datas) {
            
            $scope.userList = datas.lUserMasterBean;
/*            $scope.companyList = datas.lCompanyDetailsBean;
*/            $scope.moduleList = datas.lModuleMasterBean;
            console.log($scope.moduleList);
            $scope.propertyList = datas.lPropertyMasterBean;
        });
    	
       
       
       
       //mode
       
       
       
     /*  $scope.getQuotationType = function() {
		    var  data = {};
		    data["id"] = "1";
		    data["text"] = "SEA COASTAL";
		    $scope.modeList.push(data);
		    //$scope.quotation.mode='1';
		    data = {};
		    data["id"] = "2";
		    data["text"] = "SEA FOREIGN";
		    $scope.modeList.push(data);
		    data = {};
		    data["id"] = "3";
		    data["text"] = "TRUCK";
		    $scope.modeList.push(data);
		    data = {};
		    data["id"] = "4";
		    data["text"] = "LINER";
		    $scope.modeList.push(data);
		}
		$scope.getQuotationType();*/
       
       $scope.getQuotationType = function() {
         //  $http.post($stateParams.tenantid+'/api/grldrates/getPortList').success(function(data){
           //    $scope.portList=data;
    	   var  data = {};
		    data["id"] = "1";
		    data["text"] = "SEA COASTAL";
		    $scope.modeList.push(data);
		    //$scope.quotation.mode='1';
		    data = {};
		    data["id"] = "2";
		    data["text"] = "SEA FOREIGN";
		    $scope.modeList.push(data);
		    data = {};
		    data["id"] = "3";
		    data["text"] = "TRUCK";
		    $scope.modeList.push(data);
		    data = {};
		    data["id"] = "4";
		    data["text"] = "LINER";
		    $scope.modeList.push(data);
		    data = {};
		    data["id"] = "5";
		    data["text"] = "FORWARDING";
		    $scope.modeList.push(data);

               $timeout(function() { 
                   $("#modeid").multiselect({
                       maxHeight: 200,
                       includeSelectAllOption: true,
                       selectAllText: 'Select All',
                       enableFiltering: true,
                       enableCaseInsensitiveFiltering: true,
                       filterPlaceholder: 'Search',
                       onChange: function(element, checked) {
                           debugger;
                           var ct=""; 
                         if($scope.modeList.length>0){   
                             $scope.user.mode ='';
                            angular.forEach($scope.user.modeid, function (item, key) {
                                if(ct==""){
                                    ct = item.id;
                                }else{
                                    ct +=","+ item.id;
                                }       
                                $scope.user.mode = ct;
                            });
                         }else{
                             $scope.user.mode = '';
                         }
                       }
                     });
                   $("#modeid").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                   
                   }, 2, false);
               
               $timeout(function() { 
                   $("#modeid").multiselect({
                       maxHeight: 200,
                       includeSelectAllOption: true,
                       selectAllText: 'Select All',
                       enableFiltering: true,
                       enableCaseInsensitiveFiltering: true,
                       filterPlaceholder: 'Search',
                       onChange: function(element, checked) {
                           debugger;
                           var ct=""; 
                         if($scope.modeList.length>0){   
                             $scope.user.mode ='';
                            angular.forEach($scope.user.modeid, function (item, key) {
                                if(ct==""){
                                    ct = item.id;
                                }else{
                                    ct +=","+ item.id;
                                }       
                                $scope.user.mode = ct;
                            });
                         }else{
                             $scope.user.mode = '';
                         }
                       }
                     });
                   $("#modeid").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                   
                   }, 2, false);
           //}
           
          /* ).error(function(data) {
           });*/

       }
       $scope.getQuotationType();
		
    	 $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList1?formCode='+$('#form_code_id').val()).success(function(datas) {
             debugger;           
             $scope.companyList = datas; 
            
             
             console.log("company")
             console.log($scope.companyList)
             var foundItemDest = $filter('filter')($scope.companyList, { id:  1 })[0];
             $scope.company.companyCode=foundItemDest.id;
             
             /* 
             $timeout(function() {
                 $('#txtCompanyCode').multiselect('deselectAll', false);
                 $('#txtCompanyCode').multiselect('updateButtonText');
                 $("#txtCompanyCode").multiselect('rebuild');
             
             }, 2, false);
             $("#multiselect-button").addClass("width_100 input-sm line-height-5");*/
             }).error(function(datas) {
         });
    };
    
    $scope.excelRightsFormWise=function(){    
        
 /*       var dataUrl =  $stateParams.tenantid+'/app/usermaster/generateFormExcel?formCode=' + $scope.form.formName;
        $http.get(dataUrl).success(function() {
                
        
           $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/UserRights.xlsx" download="UserRights.xlsx"></a>');
           $("#tbExcelExport").bind('click', function() {
           });
           $('#tbExcelExport').simulateClick('click');
                
    }).error(function(result) {
        logger.logError("Error Please Try Again");
    });*/
        var objWholeData = 
        {
          
            formCode:$scope.form.formName
        }

    
    $http.post( $stateParams.tenantid+"/app/usermaster/generateFormExcel",objWholeData).success(function(response)
            {
    
        $('#excelexportXl').remove();
        $('.excelexport').append('<div id="excelexportXl"></div>');
                var file='<a id="tbExcelExport" stype="display:none" href="filePath/UserRights.xlsx" download="UserRights.xlsx"></a>'
            
               $('#excelexportXl').append(file);
               $("#tbExcelExport").bind('click', function() {
               });
               $('#tbExcelExport').simulateClick('click');
               
       

}).error(function(result) {
    logger.logError("Error Please Try Again");
});
    	
        
    }    
        
/*                  $.fn.simulateClick = function() {
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

          
    
    
    

    $scope.$watchCollection('[user.userId, company.companyCode, module.moduleCode]', function(newVal,oldVal) {
        $scope.getUserPermissions();
    });
    
    $scope.getUserCompanyModuleList();

    function isParamsEmpty() {
        return !utilsService.isUndefinedOrNull($scope.company.companyCode) && !utilsService.isUndefinedOrNull($scope.user.userId) && !utilsService.isUndefinedOrNull($scope.module.moduleCode);
    }

    $scope.getUserPermissions = function() {
        if (isParamsEmpty()) {
            var dataUrl =  $stateParams.tenantid+'/app/usermaster/getuserpermissions/' + $scope.user.userId + '/' + $scope.company.companyCode + '/' + $scope.module.moduleCode;
            $http.get(dataUrl).success(function(datas) {
                if (datas.success) {
                	console.log("1..........."+ datas.lFormMasterBean);
                    $scope.formList = datas.lFormMasterBean;
                } else {
                    logger.logError("Unable to get data");
                }
            });
        }
    };
    
    $scope.getFormNames = function() {
            var dataUrl =  $stateParams.tenantid+'/app/usermaster/getFormNames';
            $http.get(dataUrl).success(function(datas) {
                if (datas.success) {

                    $scope.userFormList = datas.lFormPropertyBean;
                } else {
                    logger.logError("Unable to get data");
                }
            });
        
    };  
    $scope.getFormNames();
    
    

    $scope.saveUserPermissions = function() {
    	debugger
        if (isParamsEmpty()) {
        	
        	if($scope.user.mode == "" || $scope.user.mode == undefined || $scope.user.mode == null )
        		$scope.user.mode = null;
            var dataUrl =  $stateParams.tenantid+'/app/usermaster/saveuserpermissions/' + $scope.user.userId + '/' + $scope.company.companyCode + '/' + $scope.module.moduleCode+'/'+ $scope.user.mode;
            $http.post(dataUrl, $scope.formList).success(function(datas) {
                if (datas.success) {
                    $scope.formList = datas.lFormMasterBean;
                    logger.logSuccess("Successfully updated");
                } else {
                    logger.logError("Unable to update data");
                }
            });
        }
    };
    
    //excel
    
    
    $scope.excel=function(){    
     
        var objWholeData = 
            {
             'lFormMasterBean'  :$scope.formList,
                
            }

        console.log("form list change");
        console.log(objWholeData);
        
        $http.post( $stateParams.tenantid+"/app/usermaster/generateExcel",objWholeData).success(function(response)
                {
        
           $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/UserRights.xlsx" download="UserRights.xlsx"></a>');
           $("#tbExcelExport").bind('click', function() {
           });
           $('#tbExcelExport').simulateClick('click');

    }).error(function(result) {
        logger.logError("Error Please Try Again");
    });
        
    } 
    /*              $.fn.simulateClick = function() {
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

          
    
    
   
    
    
    $scope.excelCompanyWise=function(){    
        
        var d = new Date();
        var n = d.getMinutes();
        var s = d.getSeconds();
        var mon=Number(d.getMonth())+1;
        var day=d.getDate();
        var yr=d.getFullYear();
        var ms=d.getMilliseconds();
        
       
        $scope.filename="UserRights"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
        
        
        var objWholeData = 
            {
              
                userId:$scope.user.userId,
                companyCode:$scope.company.companyCode,
                moduleCode:$scope.module.moduleCode,
                filename:"UserRights"+day+""+mon+""+yr+""+n+""+s+""+ms
            }
 
        
        $http.post( $stateParams.tenantid+"/app/usermaster/generateEmployeeCompany",objWholeData).success(function(response)
                {
        
            $('#excelexportXl').remove();
            $('.excelexport').append('<div id="excelexportXl"></div>');
                    var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                
                   $('#excelexportXl').append(file);
                   $("#tbExcelExport").bind('click', function() {
                   });
                   $('#tbExcelExport').simulateClick('click');
                   
           

    }).error(function(result) {
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
/*    
    $scope.excel=function(formList,lFormPropertyBean){  
        
        console.log("user rights formList");
        console.log(formList);
        
    }*/
    

    /** ********* Form Data Change Watcher ***************** */

    $scope.processFormListData = function() {

        var propertyRowCnt = 0;
        for (var i = 0; i < $scope.formList.length; i++) {
            var objFormMasterBean = $scope.formList[i];
            objFormMasterBean.propertyRow = true;
            for (var j = 0; j < objFormMasterBean.lFormPropertyBean.length; j++) {
                if (objFormMasterBean.lFormPropertyBean[j].enabled == false && objFormMasterBean.lFormPropertyBean[j].available ) {
                    propertyRowCnt = 1;
                    objFormMasterBean.propertyRow = false;
                }
            }
        }

        var propertyModCnt = 0;
        for (var i = 0; i < $scope.propertyList.length; i++) {
            var isModEnabled = true;
            for (var j = 0; j < $scope.formList.length; j++) {
                if (!utilsService.isUndefinedOrNull($scope.formList[j].lFormPropertyBean[i])) {
                    if ($scope.formList[j].lFormPropertyBean[i].enabled == false && $scope.formList[j].lFormPropertyBean[i].available) {
                        propertyModCnt = 1;
                        isModEnabled = false;
                    }
                }
            }
            $scope.propertyList[i].enabled = isModEnabled;
        }
        $scope.propertyAll = propertyRowCnt == 0 && propertyModCnt == 0;
    };

    $scope.$watch('formList', function(oldVal, newVal) {
        $scope.processFormListData();
    }, true);

    /** ********* Form Check Boxes ***************** */

    $scope.changePropertyAll = function() {
        for (var i = 0; i < $scope.formList.length; i++) {
            var objFormMasterBean = $scope.formList[i];
            objFormMasterBean.propertyRow = $scope.propertyAll;
            for (var j = 0; j < objFormMasterBean.lFormPropertyBean.length; j++) {
               if(objFormMasterBean.lFormPropertyBean[j].available){
                objFormMasterBean.lFormPropertyBean[j].enabled = $scope.propertyAll;
               }
               
            }
        }
        for (var i = 0; i < $scope.propertyList.length; i++) {
            if($scope.propertyList[i].available){
            $scope.propertyList[i].enabled = $scope.propertyAll;
            }
            
        }
    };

    $scope.changePropertyMod = function(value, valueIndex) {
        for (var index = 0; index < $scope.formList.length; index++) {
            if ($scope.formList[index].lFormPropertyBean.length > 0) {
                if($scope.formList[index].lFormPropertyBean[valueIndex].available ){
                $scope.formList[index].lFormPropertyBean[valueIndex].enabled = value;
                }
            }
        }
    };

    $scope.changePropertyRow = function(objFormMasterBean, value) {
        for (var index = 0; index < objFormMasterBean.lFormPropertyBean.length; index++) {
            if(objFormMasterBean.lFormPropertyBean[index].available ){
            objFormMasterBean.lFormPropertyBean[index].enabled = value;
            }
        }
    };

    /** ********* Copy User & Company ************** */
    $scope.showCopyText = "Toggle Copy";
    $scope.showCopyWizard = false;
    $scope.showCopyWizard1 = false;
    $scope.showCopyWizard2 = false;
    $scope.copyWizardType = 1;
    $scope.userMapped1 = {};
    $scope.userMapped2 = {};

    $scope.companyCodeWz2 = '';
    $scope.userListWz2 = [];

    $scope.userCompanyMapped = {
            userId : ''
    };
    $scope.companyMapped1 = {
           userId : '',
           fromCompany : '',
           toCompany : ''
    };
    $scope.companyMapped2 = {};
    $scope.companyCodesMapped = [];
    $scope.companyCodesNotMapped = [];

    $scope.toggleCopyWizard = function() {
        $scope.showCopyWizard = !$scope.showCopyWizard;
        $scope.showCopyText = $scope.showCopyWizard ? "Hide Copy" : "Show Copy";
    };

    $scope.toggleUser = {
            companyCodeWz2 : '',
            userId1 : '',
            uesrId2 : ''
    };
    
    $scope.$watch('copyWizardType', function(oldVal, newVal) {
        $scope.companyCodesMapped = [];
        $scope.companyCodesNotMapped = [];
        $scope.showCopyWizard1 = false;
        $scope.showCopyWizard2 = false;
        $scope.splitCompanies($scope.userCompanyMapped);
        if ($scope.copyWizardType == "1") {
            $scope.showCopyWizard1 = true;
        } else if ($scope.copyWizardType == "2") {
            $scope.showCopyWizard2 = true;
        }
    }, true);

    $scope.$watch('userCompanyMapped.userId', function(oldVal, newVal) {
        $scope.companyCodesMapped = [];
        $scope.companyCodesNotMapped = [];
        for (var index = 0; index < $scope.companyList.length; index++) {
            if ($.inArray($scope.companyList[index].companyCode,$scope.userCompanyMapped.userId) > -1) {
                $scope.companyCodesMapped.push($scope.companyList[index]);
            } else {
                $scope.companyCodesNotMapped.push($scope.companyList[index]);
            }
        }
    });
    
    $scope.splitCompanies = function(userObj) {
        $scope.companyCodesMapped = [];
        $scope.companyCodesNotMapped = [];
        for (var index = 0; index < $scope.companyList.length; index++) {
            if ($.inArray($scope.companyList[index].companyCode, userObj.companyCodesMapped) > -1) {
                $scope.companyCodesMapped.push($scope.companyList[index]);
            } else {
                $scope.companyCodesNotMapped.push($scope.companyList[index]);
            }
        }
    };

    var temp1,temp2,temp3;
    $scope.$watch('toggleUser.companyCodeWz2', function(oldVal, newVal) {
        if($scope.toggleUser.companyCodeWz2 != null && $scope.toggleUser.companyCodeWz2 != undefined){
            temp1  = $scope.toggleUser.companyCodeWz2;
            var dataUrl =  $stateParams.tenantid+'/app/usermaster/userlist?companyCode=' + $scope.toggleUser.companyCodeWz2;
            $http.get(dataUrl).success(function(datas) {
                if (datas.success) {
                    $scope.userListWz2 = datas.lUserMasterBean;
                } else {
                    logger.logError("Unable to get data");
                }
            });
        }
    });
    
    
   
    
    $scope.$watch('toggleUser.userId1', function(oldVal, newVal) {
        if($scope.toggleUser.userId1 != '' && $scope.toggleUser.userId1 != undefined){
            temp2  = $scope.toggleUser.userId1;
        }
    });
    
    $scope.$watch('toggleUser.userId2', function(oldVal, newVal) {
        if($scope.toggleUser.userId2 != '' && $scope.toggleUser.userId2 != undefined){
            temp3 = $scope.toggleUser.userId2;
        }
    });
    
    $scope.$watch('companyMapped1.userId', function(oldVal, newVal) {
        if($scope.companyMapped1.userId != '' && $scope.companyMapped1.userId != undefined){
            temp1  = $scope.companyMapped1.userId;
        }
    });
    
    $scope.$watch('companyMapped1.fromCompany', function(oldVal, newVal) {
        if($scope.companyMapped1.fromCompany != '' && $scope.companyMapped1.fromCompany != undefined){
            temp2 = $scope.companyMapped1.fromCompany;
        }
    });
    
    $scope.$watch('companyMapped1.toCompany', function(oldVal, newVal) {
        if($scope.companyMapped1.toCompany != '' && $scope.companyMapped1.toCompany != undefined){
            temp3 = $scope.companyMapped1.toCompany;
        }
    });
    
   /* $scope.getUsers = function(companyCode){
        alert(companyCode)
        var dataUrl =  $stateParams.tenantid+'//usermaster/userlist?companyCode=' + companyCode;
        $http.get(dataUrl).success(function(datas) {
            if (datas.success) {
                $scope.userListWz2 = datas.lUserMasterBean;
            } else {
                logger.logError("Unable to get data");
            }
        });
    };*/

    $scope.insertUserToUser = function() {
        if ($scope.toggleUser.userId1 == $scope.toggleUser.userId2) {
            return logger.logError("Same user id selected");
        }
        var dataUrl =  $stateParams.tenantid+'/app/usermaster/insertusertouser?fromUserId=' + $scope.toggleUser.userId1 + '&toUserId=' + $scope.toggleUser.userId2 +'&compMapped='+$scope.toggleUser.companyCodeWz2;
        $http.get(dataUrl).success(function(datas) {
            if (datas.success) {
                logger.logSuccess("Successfully updated");
            } else {
                logger.logError("Unable to update");
            }
        });
    };

    $scope.insertCompanyToCompany = function() {
        if (temp2 == temp3) {
            return logger.logError("From and To Company should not be same");
        }
        var dataUrl =  $stateParams.tenantid+'/app/usermaster/insertcompanytocompany?fromCompId=' + temp2 + '&toCompId=' + temp3 + '&userId=' + temp1;
        $http.get(dataUrl).success(function(datas) {
            if (datas.success) {
                $scope.userCompanyMapped.companyCodesMapped = datas.userMasterBean.companyCodesMapped;
                $scope.splitCompanies($scope.userCompanyMapped);
                logger.logSuccess("Successfully updated");
            } else {
                logger.logError("Unable to update");
            }
        });
    };

});

app.controller('designationMasterListCtrl', function($scope, $timeout, $rootScope, $http, $location, logger, $log, ngDialog, utilsService, $injector, sharedProperties, toaster,$stateParams) {

    $scope.designationList = [];
    $scope.moduleList = [];
    $scope.formList = [];
    $scope.propertyList = [];
    $scope.propertyAll = false;

    $scope.designation = {
        designationCode : '',
        designationName : ''
    };

    $scope.module = {
        moduleCode : '',
        moduleName : ''
    };

    $scope.getDesgnModuleList = function() {
        $http.get( $stateParams.tenantid+'/app/usermaster/desgnmodulelist').success(function(datas) {
            $scope.designationList = datas.lDesignationMasterBean;
            $scope.moduleList = datas.lModuleMasterBean;
            $scope.propertyList = datas.lPropertyMasterBean;
        });
    };
    
    $scope.$watchCollection('[designation.designationCode, module.moduleCode]', function(newVal,oldVal) {
        $scope.getDesignationPermissions();
    });

    $scope.getDesgnModuleList();

    $scope.getDesignationPermissions = function() {
        var isParamsEmpty = !utilsService.isUndefinedOrNull($scope.designation.designationCode) && !utilsService.isUndefinedOrNull($scope.module.moduleCode)
        if (isParamsEmpty) {
            var dataUrl =  $stateParams.tenantid+'/app/usermaster/getdesgnpermissions/' + $scope.designation.designationCode + '/' + $scope.module.moduleCode;
            $http.get(dataUrl).success(function(datas) {
                if (datas.success) {
                    $scope.formList = datas.lFormMasterBean;
                } else {
                    logger.logError("Unable to update");
                }
            });
        }
    };

    $scope.saveDesignationPermissions = function() {
        var isParamsEmpty = !utilsService.isUndefinedOrNull($scope.designation.designationCode) && !utilsService.isUndefinedOrNull($scope.module.moduleCode)
        if (isParamsEmpty) {
            var dataUrl =  $stateParams.tenantid+'/app/usermaster/savedesgnpermissions/' + $scope.designation.designationCode + '/' + $scope.module.moduleCode;
            $http.post(dataUrl, $scope.formList).success(function(datas) {
                if (datas.success) {
                    $scope.formList = datas.lFormMasterBean;
                    logger.logSuccess("Successfully updated");
                } else {
                    logger.logError("Unable to update");
                }
            });
        }
    };

    /** ********* Form Data Change Watcher ***************** */

    $scope.processFormListData = function() {

        var propertyRowCnt = 0;
        for (var i = 0; i < $scope.formList.length; i++) {
            var objFormMasterBean = $scope.formList[i];
            objFormMasterBean.propertyRow = true;
            for (var j = 0; j < objFormMasterBean.lFormPropertyBean.length; j++) {
                if (objFormMasterBean.lFormPropertyBean[j].enabled == false && objFormMasterBean.lFormPropertyBean[j].available) {
                    propertyRowCnt = 1;
                    objFormMasterBean.propertyRow = false;
                }
            }
        }

        var propertyModCnt = 0;
        for (var i = 0; i < $scope.propertyList.length; i++) {
            var isModEnabled = true;
            for (var j = 0; j < $scope.formList.length; j++) {
                if (!utilsService.isUndefinedOrNull($scope.formList[j].lFormPropertyBean[i])) {
                    if ($scope.formList[j].lFormPropertyBean[i].enabled == false  && $scope.formList[j].lFormPropertyBean[i].available) {
                        propertyModCnt = 1;
                        isModEnabled = false;
                    }
                }
            }
            $scope.propertyList[i].enabled = isModEnabled;
        }

        $scope.propertyAll = propertyRowCnt == 0 && propertyModCnt == 0;
    };

    $scope.$watch('formList', function(oldVal, newVal) {
        $scope.processFormListData();
    }, true);

    /** ********* Form Check Boxes ***************** */

    $scope.changePropertyAll = function() {
        for (var i = 0; i < $scope.formList.length; i++) {
            var objFormMasterBean = $scope.formList[i];
            objFormMasterBean.propertyRow = $scope.propertyAll;
            for (var j = 0; j < objFormMasterBean.lFormPropertyBean.length; j++) {
                if(objFormMasterBean.lFormPropertyBean[j].available){
                objFormMasterBean.lFormPropertyBean[j].enabled = $scope.propertyAll;
                }
            }
        }
        for (var i = 0; i < $scope.propertyList.length; i++) {
            if($scope.propertyList[i].available){
            $scope.propertyList[i].enabled = $scope.propertyAll;
            }
        }
    };

    $scope.changePropertyMod = function(value, valueIndex) {
        for (var index = 0; index < $scope.formList.length; index++) {
            if ($scope.formList[index].lFormPropertyBean.length > 0) {
                if($scope.formList[index].lFormPropertyBean[valueIndex].available){
                $scope.formList[index].lFormPropertyBean[valueIndex].enabled = value;
                }
            }
        }
    };

    $scope.changePropertyRow = function(objFormMasterBean, value) {
        for (var index = 0; index < objFormMasterBean.lFormPropertyBean.length; index++) {
            if(objFormMasterBean.lFormPropertyBean[index].available){
            objFormMasterBean.lFormPropertyBean[index].enabled = value;
            }
        }
    };


});
