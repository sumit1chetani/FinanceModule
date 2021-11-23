
app.controller('cargoManifestListCtrl', function($scope, $rootScope, $controller,sharedProperties, validationService, toaster, $http,
		$location, $state, logger, $log, ngDialog, $modal, utilsService, $window, $filter, $stateParams) {

	$scope.rowCollection = [];
	$scope.displayedCollection = [];

	$scope.hideAddIcon = true;
	$scope.hideUploadIcon = true;
	$scope.hideEditIcon = true;
	$scope.hideBreadcrumb = true;
	$scope.showEmptyLabel = false;
	$scope.isExport = false;
    $scope.voyageList = [];
    $scope.vesselList = [];
    $scope.portList = [];
    $scope.translo = {
        vessel_name : '',
        agent_voyage_number : '',
        containerNo : '',       
        rotation_number : '',
        tvessel_name:'',
        tagent_voyage_number:'',
        origin_port:'',
        distination_port:''
    }
 
$scope.resetData=function(){
    $scope.translo = {
            vessel_name : '',
            agent_voyage_number : '',
            containerNo : '',       
            rotation_number : '',
            tvessel_name:'',
            tagent_voyage_number:''
        }
    $scope.transDisLoad=[];
}

    
    $scope.dropdown = function() {

        var formCode = $('#form_code_id').val();
        $http.get($stateParams.tenantid+'/app/onBoard/dropDownList').success(function(data) {
      		$scope.vesselList=data.vesselList;
      		$scope.portList = data.portList; 
      });
       
    }
    
    $scope.getReport = function() {
    		debugger;
        var formCode = $('#form_code_id').val();
			 $http.get($stateParams.tenantid + '/app/cargoManifest/reportDesign').success(function(datas) {
				 debugger;
					$scope.dailyLoadingHeaderList =  datas.headerList;
					$scope.isExport = true;
				}).error(function(datas) {
				});
    }

    $scope.dropdown();
    $scope.getReport();
    
    $scope.$watch('translo.vessel_name', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.post($stateParams.tenantid+'/app/onBoard/getVoyage?vesselCode='+newValue).success(function(data) {
            	debugger;
            	if(data.success){
            		$scope.voyageList=data.voyageList;
            	}else{
            		logger.logError("Error Please Try Again");
            	}
            });
        } else {

            $scope.voyageList = [];
            $scope.translo.voyage = '';
        }
    });
    
    
    $scope.slotchkAll = false;
    $scope.checkSlotMsgAll = function(slotMessageItems, selectedAll) {
        if (selectedAll) {
            $scope.selectedAll = true;
        } else {
            $scope.selectedAll = false;
        }
        var i=0;
        angular.forEach($scope.transDisLoad, function(slot) {
        	slot.select = $scope.selectedAll;
        	i++;
        });

    };

    $scope.slotchk = false;
    $scope.checkSlotMsg = function(chkMsgSlot,selectedAll) {
        if (chkMsgSlot == true) {
            selectedAll= true;
        } else {
            selectedAll= false;
        }
    };
    
    $scope.selectall = true;
    $scope.selectAll = function(value){
        
        for(var index in $scope.dailyLoadingHeaderList){
           
            var colum = $scope.dailyLoadingHeaderList[index];
            if(colum.isDefault == false){
                if(value == true){
                    colum.visible = true;
                }else{
                    colum.visible = false;
                }
            }
        }
            
    }
    
    $scope.selectedVisibility = [];
    $scope.getSelectedColumn=function(index){
        
        var value = $scope.dailyLoadingHeaderList.indexOf(index);
        var indexExsists = $scope.selectedVisibility.indexOf(index);
        if(indexExsists ==-1)
            {
                $scope.selectedVisibility.push(value);
            }
    };
    
    
    $scope.onDropComplete = function (index, obj, evt) {

        var otherIndex = $scope.dailyLoadingHeaderList.indexOf(obj);
        
        if(index !=undefined){
            $scope.dailyLoadingHeaderList.splice(otherIndex, 1);
            $scope.dailyLoadingHeaderList.splice(index, 0, obj);
        }

        else if(index = "undefined"){
            $scope.dailyLoadingHeaderList.splice(otherIndex, 1);
            $scope.dailyLoadingHeaderList.splice($scope.dailyLoadingHeaderList.length, 0, obj);
        }
    };

    
    
    $scope.fileNewUpload = function() {
        ngDialog.close();
        $('#uploadfile').attr('disabled', true);
        ngDialog.open({
            template : 'fileNewModal',
            scope : $scope
        });
    };
    $scope.checkundefined=function(value){
        var invalid=false;
        if(value==undefined || value=='undefined' || value==null || value=='null' || value=='' ){
            invalid=true;
        }
        return invalid;
    }
    
    
    $scope.downloadNewFile = function() {
        $("#tbnewExport").bind('click', function() {

        });
        $('#tbnewExport').simulateClick('click');
    }
    $rootScope.closeFileDialog = function() {
        ngDialog.close();
        $('#uploadfile').attr('disabled', false);
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
    }

    $scope.onDropComplete = function (index, obj, evt) {
        var otherIndex = $scope.messageHeaderList.indexOf(obj);
        
        if(index !=undefined){
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice(index, 0, obj);
        }

        else if(index = "undefined"){
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice($scope.messageHeaderList.length, 0, obj);
        }
    };
    
    $scope.selectedVisibility = [];
    $scope.getSelectedColumn=function(index){
        
        var value = $scope.messageHeaderList.indexOf(index);
        var indexExsists = $scope.selectedVisibility.indexOf(index);
        if(indexExsists ==-1)
            {
                $scope.selectedVisibility.push(value);
            }
    };
    
    $scope.filterColumn = function(){
        debugger;
        if($scope.selectedVisibility.length > 0){
            angular.forEach($scope.selectedVisibility,function(value){
                
                var checkedValue  = $scope.messageHeaderList[value].visible;
                $scope.columnHeader[value].visible  = checkedValue;
                         
            });     
        }
        else{
            angular.copy($scope.messageHeaderList,$scope.columnHeader);
        } 
    };
    
    $scope.onDropComplete = function (index, obj, evt) {
        var otherIndex = $scope.messageHeaderList.indexOf(obj);
        
        if(index !=undefined){
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice(index, 0, obj);
        }

        else if(index = "undefined"){
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice($scope.messageHeaderList.length, 0, obj);
        }
    };
    
    
 $rootScope.uploadFile = function(element) {
        
        $scope.excelfile = element.files[0];
    }


    $rootScope.uploadnewSlotMessage = function() {
        ngDialog.close();
        var excelfile = $scope.excelfile;
        var fileExtension = excelfile.name;
        var fName = [];
        $('#uploadfile').attr('disabled', false);
        var frmData = new FormData();
        frmData.append("file", excelfile);
        var url1 = $stateParams.tenantid+'/app/cargoManifest/uploadfile';
        $.ajax({
            type : "POST",
            url : url1,
            data : frmData,
            contentType : false,
            processData : false,
            success : function(result) {
                if (result.success) {
                    if(!$scope.checkundefined(result.code)){
                        ngDialog.openConfirm({            
                            template:
                                
                   ' <div class="modal-header">CONFIRMATION</div> '+
                                '  <div class="row"> '+
                                '  <div class="col-lg-12"> '+
                                '   <div class="col-lg-12">  Check Digit empty in rows ('+result.code+') .Do you want to Continue?'+                                 
                                '    </div> '+
                                '   </div>  '+
                                '  </div> '+
                                '  <div class="modal-footer">'+ 
                                '    <button class="btn btn-info" type="button" ng-click="confirm()">YES</button>'+
                                '   <button class="btn btn-danger" ng-click="closeThisDialog()">NO</button>'+
                                '  </div>'
                                 ,
                            plain: true,
                            scope:$scope           
                        }).then(function(value){
                            var obj={bean:result.bean};
                            $http.post($stateParams.tenantid+'/app/cargoManifest/insert', obj).success(function(data) {
                                if (data.success == true) {
                                    
                                    logger.logSuccess(data.message);
                              
                                } else {
                                    logger.logError(data.message);
                                }

                            }).error(function(data) {
                                logger.logError("Error Please Try Again");
                            });  
                        },function(reject){
                       
                        });
                    }else{
                        logger.logSuccess(result.message);
                    } 
                 
                    
                   
                } else {
                    logger.logError(result.message);
                }
               
            }

        });

    }


    
    $scope.exportTblExcelfile = function() {
        
        $scope.obj={
                vessel:$scope.translo.vessel_name,
                voyage:$scope.translo.agent_voyage_number,
                tvessel:$scope.translo.tvessel_name,
                tvoyage:$scope.translo.tagent_voyage_number,
                port:'',
                fromdate:'',
                todate:'',
                containerNo:$scope.translo.containerNo,
                shipmentterms:'',
                pol:'',
                pod:'',
                crvessel:'',
                crvoyage:'',
                typeoffile:'',
                rotation:$scope.translo.rotation_number,
                origin_port:$scope.translo.origin_port,
                distination_port:$scope.translo.distination_port
        }
        
          /*  if( $scope.translo.vessel_name =='' && $scope.translo.agent_voyage_number ==''){
                logger.logError("Select search Criteria");
            }else if($scope.translo.vessel_name =='' ){
                logger.logError("Select Vessel");
            }
            else if($scope.translo.agent_voyage_number =='' ){
                logger.logError("Select Voyage");
            }
            else{ */
                var d = new Date();
                var n = d.getMinutes();
                var s = d.getSeconds();
                var mon=Number(d.getMonth())+1;
                var day=d.getDate();
                var yr=d.getFullYear();
                var ms=d.getMilliseconds();
                
                $scope.filename="DISC_VERESK_DETAIL"+day+""+mon+""+yr+""+n+""+s+""+ms+".xlsx";
                
                $scope.obj.filename="DISC_VERESK_DETAIL"+day+""+mon+""+yr+""+n+""+s+""+ms;
              
            
                $http.post($stateParams.tenantid+'/app/cargoManifest/tblfile',$scope.obj).success(function(result) {
                    $('#exportXl').remove();
                    $('.test').append('<div id="exportXl"></div>');
                  var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                        
                           $('#exportXl').append(file);
                           $("#tbExcelExport").bind('click', function() {
                           });
                           $('#tbExcelExport').simulateClick('click');
                    
                    }).error(function(data) {
                        logger.logError("Error Please Try Again");
                    });
        /* }*/
            
        }
    

    $scope.transDisLoad = [];
    $scope.columnHeader = [];
    $scope.getData = function() {
        $http.post($stateParams.tenantid+'/app/cargoManifest/list', $scope.translo).success(function(data) {
            $scope.transDisLoad = [];
            $scope.transDisLoad = data.cargoManifestDtlBean;

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    $scope.bulkDelete = function() {
        $scope.obj = {
            cargoManifestDtlBean : $scope.transDisLoad
        };
        var selectedList = $filter('filter')($scope.transDisLoad, {
            select : true
        });
        if (selectedList == '' || selectedList == undefined || selectedList.length == 0 ) {
         
           logger.logError("No container selected for delete");
        }else{
            
        $http.post($stateParams.tenantid+'/app/transDisLoad/bulkDelete', $scope.obj).success(function(data) {
            if (data.success == true) {
                logger.logSuccess(data.message);
                $scope.transDisLoad =[];
            } else {
                logger.logError(data.message);
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
      
        }
    }
    
});
 
