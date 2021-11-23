define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    module.registerController('assetValuationAddCtrl', function($scope,$filter, $state, $http, ngDialog, logger, $location, 
            $controller, $injector, sharedProperties, toaster, $rootScope , validationService) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.tableSelection = [];
        $scope.edit = false;
        
        $scope.assetValue = {
            itemId : '',
            startDate : '',
            depAppre : '',
            computationMethod :'',
            assetTrackConfirm : '',
            nextDate :'',
            currPurValue :'',
            itemCategoryId:'',
            assetValId :'',
            noa :'',
            assetValuation : [],
            assetTrackDetails  : [],
            endDate : false
        };
        
        $scope.assetValue1 = {
                amtdep :'',
                amtaggr :'',
                currValue : '',
                deggressiveFactor : '',
                aggressiveFactor : '',
                afterValuation : '',  
                valType : '',
                comMethod :''
        }
        
        $scope.isEdit=false;
        $scope.assetMaintenanceObj={
                itemId:'',
                maintenanceId:'',
                assetProp : []
                
        };
        
        $scope.MyItemList = [];
        $http.get("hospital/asset/valuation/getcategoryList").success(function(datas) {
            console.log("My data List");
            $scope.MyItemList=datas.itemList;
            console.log($scope.MyItemList);
        });
        
        
        $scope.valType = function(){
            debugger;
            console.log($scope.assetValue.itemCategoryId);
            if($scope.assetValue.itemCategoryId == ""){
                logger.logError("Please Select Item Category");
            }else{
                var itemCategoryId = $scope.assetValue.itemCategoryId;
                var depAppre = $scope.assetValue.depAppre;
                $http.get("hospital/asset/valuation/depreappreDetails?itemCategoryId="+itemCategoryId +" &depAppre="+depAppre).success(function(data) {
                    console.log("Loaded Information");
                    console.log(data);
                    
                    if(data.valuationDetail[0].endDate != null){
                        $scope.endDate = true;
                        $scope.assetValue.endDate = data.valuationDetail[0].endDate;
                    }
                 
                    $scope.assetValue.noa =  data.valuationDetail[0].noa;
                    
                    if(data.valuationDetail[0].noa != 0) {
                        $scope.hidenoa =  data.valuationDetail[0].noa;
                        $scope.listlen = $scope.assetValue.assetValuation.length + 1;
                        $scope.hidden.noa= $scope.listlen + " Out of " + $scope.hidenoa ;
                        }
                        else{
                            $scope.hidden.noa = $scope.assetValue.assetValuation.length + 1;
                        }
                       $scope.assetValue1.aggressiveFactor = data.valuationDetail[0].aggressiveFactor;
                    
                    
                });
            }
        }
        
        
        
        
        
        $scope.$watch("assetValue.itemCategoryId", function(newValue, oldValue) {
            if(newValue != "" && newValue!=undefined && newValue!=null){

                $http.get("hospital/asset/valuation/depreappreDetails?itemCategoryId="+newValue).success(function(data) {
                    if(data.success){
                        
                        $scope.dataList = data.valuationDetail;
                        console.log($scope.dataList);
                       for(var i=0;i<$scope.dataList.length;i++){
                           /*if($scope.dataList[i].valType == 'A'){
                            $scope.Appre = false;   
                           }
                           else if($scope.dataList[i].valType == 'D'){
                               $scope.depre = false;
                           } */   
                       }
                    }
                });
                
                $http.get("hospital/asset/valuation/getDropDownList?itemCategoryId="+newValue ).success(function(response) {
                    $scope.ItemList=response.itemList;
                });
            }
        });
        
   /*  $scope.edit = false;
        $scope.$watch("assetValue.depAppre", function(newValue, oldValue) {
            if($scope.edit == false){
                debugger;
            var obj=[];
            if(newValue == "A" ) {
                obj = $filter('filter')($scope.dataList, {
                    valType : newValue
                });
                $scope.assetValue1.aggressiveFactor = obj[0].aggressiveFactor;
                
                
                
                $scope.assetValue.noa = obj[0].noa;
                if($scope.assetValue.noa != "") {
                
                $scope.hidenoa =  $scope.assetValue.noa;
                $scope.listlen = $scope.assetValue.assetValuation.length + 1;
                $scope.hidden.noa= $scope.listlen + " Out of " + $scope.hidenoa ;
                }
                else {
                    $scope.hidden.noa = $scope.assetValue.assetValuation.length + 1; 
                }
               $scope.noa = obj[0].noa;
               $scope.listlen = $scope.assetValue.assetValuation.length + 1;
               $scope.assetValue1.noa = $scope.listlen + " outof " + $scope.noa;
                
              
                if($scope.assetValue1.aggressiveFactor!="" || $scope.assetValue1.aggressiveFactor!=0){  
                    $scope.assetValue1.currValue = $scope.assetValue.currPurValue;
                    $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
                    $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) +  parseInt($scope.percentValueAgg);
                
            }
                
            }
            else if (newValue == "D") {
                obj = $filter('filter')($scope.dataList, {
                    valType : newValue
                });
                $scope.assetValue1.aggressiveFactor = obj[0].aggressiveFactor;
                
                
                
                $scope.assetValue.noa =  obj[0].noa;
                
                if($scope.assetValue.noa != "") {
                
                $scope.hidenoa =  $scope.assetValue.noa;
                $scope.listlen = $scope.assetValue.assetValuation.length + 1;
                $scope.hidden.noa= $scope.listlen + " Out of " + $scope.hidenoa ;
                }else{
                    $scope.hidden.noa = $scope.assetValue.assetValuation.length + 1;
                }
                
                if($scope.assetValue1.aggressiveFactor!="" || $scope.assetValue1.aggressiveFactor!=0){  
                    $scope.assetValue1.currValue = $scope.assetValue.currPurValue;
                    $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
                    $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) -  parseInt($scope.percentValueAgg);
                
            }
            }
                
            }
        });
        */
        
        
        
   
        
        $scope.currValue = function () {
            
            $scope.assetValue1.currValue = $scope.assetValue.currPurValue;
            debugger;
            if($scope.assetValue.depAppre == "D"){
                if($scope.assetValue1.aggressiveFactor!="" || $scope.assetValue1.aggressiveFactor!=0){  
                    $scope.assetValue1.currValue = $scope.assetValue.currPurValue;
                    $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
                    $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) -  parseInt($scope.percentValueAgg);
                
            }
            }
                else
                    {
                    $scope.assetValue1.currValue = $scope.assetValue.currPurValue;
                    $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
                    $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) +  parseInt($scope.percentValueAgg);
                    }
            
            
        }
        
        
     
        $scope.percentageAgg = function() {
            $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
            $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) +  parseInt($scope.percentValueAgg);
        }
        
        $scope.percentageDeg = function() {
            $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
            $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) -  parseInt($scope.percentValueAgg);
        }
        
       
        
        $scope.loadDropDown = function(changedVariable) {
                    $scope.itemCategory();
                   
        };
        
        $scope.getItemDetailCate = function(){
            $http.get("hospital/asset/valuation/getItemList").success(function(response) {
                $scope.ItemList=response.alItemList;
            });
        }
        $scope.getItemDetailCate();
        
        
        $scope.itemCategory=function(){
            if($scope.assetValue.itemId  != ""){
                angular.forEach($scope.ItemList,function(value,key){
                    if($scope.assetValue.itemId === value.id){
                        $scope.assetMaintenanceObj.itemCategoryId=value.itemCategoryName;
                        $scope.assetMaintenanceObj.maintenanceId = value.maintenanceId;
                        $scope.getAssetTrackDetails($scope.assetValue.itemId);
                   } 
                });    
            }else{
                $scope.assetMaintenanceObj.itemId ="";   
                $scope.rowCollection=[];
            }
        };
        
        $scope.$watch('assetValue.itemId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.itemCategory();
              }else{
                  
              }
        });
        
        $scope.getAssetTrackDetails=function(itemId){
            var url = 'hospital/asset/valuation/assetTrackDetails?itemId=' +itemId;
            $http.get(url).success(function(data) {
                if(data.success){
                    $scope.rowCollection=data.lAssetTrack;
                    $scope.assetValue.assetTrackDetails = $scope.rowCollection;
                }else{
                    logger.log(data.errors);
                    $scope.rowCollection=[];
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        
        
        $scope.getDepreAppreDetails=function(id){
            
            var url = 'hospital/asset/valuation/depreappreDetails?id=' +id;
          
            $http.get(url).success(function(data) {
                if(data.success){
                 $scope.assetValue1.aggressiveFactor = data.valuationDetail[0].aggressiveFactor;
                 
                 /*if($scope.assetValue1.aggressiveFactor!="" || $scope.assetValue1.aggressiveFactor!=0){  
                     $scope.percentValueAgg = $scope.assetValue1.currValue * ($scope.assetValue1.aggressiveFactor/100);
                     $scope.assetValue1.afterValuation = $scope.assetValue1.currValue +  $scope.percentValueAgg;
                 
                 }*/
                 
                 $scope.assetValue1.noa = data.valuationDetail[0].noa;
                 if(data.valuationDetail[0].comMethod == 156){
                     $scope.assetValue.comMethod = "Degressive";
                 }
                 else if(data.valuationDetail[0].comMethod == 154){
                     $scope.assetValue.comMethod = "Aggressive";
                 }
                 
                 if(data.valuationDetail[0].valType == "D"){
                     $scope.assetValue.depAppre = "D";
                     
                     
                     
                     
                     
                     
                 }
                 else if(data.valuationDetail[0].valType == "A"){
                     $scope.assetValue.depAppre = "A";
                 }
                  
                }else{
                    logger.log(data.errors);
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        
        
        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        
        var day = d.getDate();
        $scope.date = day + "/" + month + "/" + year;
        $scope.assetValue.startDate = $scope.date;


        $scope.cancel = function() {
            $state.go('app.hospital.asset.assetvaluation.list');
        };
        
        var totalCheckedCount = 0;
        $scope.stateChanged=function(assetTrackConfirm){
            debugger;
            if(assetTrackConfirm){
                totalCheckedCount++;
            }else if(!assetTrackConfirm){
                totalCheckedCount--;
                //$scope.assetRequisitionObj.deleteIds.push(object.asstDetailId);
            }
          
            $scope.assetValue.assetTrackConfirm = totalCheckedCount;
        }

        
        var i =0;
        $scope.saveAll=function(assetValuationForm,assetValue,rowCollection){
            debugger;
            if($scope.edit==false){
                if($scope.assetValue.assetValuation.length != 0 && $scope.assetValue.assetTrackConfirm !=  "" ){
                console.log("$scope.AssetValuation:::::::::::::::::SAVE_DATA:::::::::::::::::::::::::");
                console.log($scope.assetValue);
                $http.post("hospital/asset/valuation/save",$scope.assetValue).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Saved Successfully");
                        $state.go("app.hospital.asset.assetvaluation.list");
                    }else{
                        logger.logSuccess("Unable to Save the records.");
                    }
                });
                }
                else{
                    logger.logError(" Asset Valuation and Track information must");
                }
            }
            else {
                if($scope.assetValue.assetValuation.length != 0 ){
                var assetValId = $location.search().assetValId;
                $scope.assetValue.assetValId = assetValId;
                console.log("$scope.AssetValuation:::::::::::::::::UPDATE_DATA:::::::::::::::::::::::::");
                console.log($scope.assetValue);
                $http.post("hospital/asset/valuation/update",$scope.assetValue).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Updated Successfully");
                        $state.go("app.hospital.asset.assetvaluation.list");
                    }else{
                        logger.logError("Unable to Update the records.");
                    }
                    
                });
            } 
            else{
                logger.logError(" Please Update Valuation");
            }
            }
        }
        
        
        $scope.isEdit = false;
        /**
         * validation
         */
        $rootScope.save = function(assetValuationForm,assetValue,assetValue1) {
            debugger;
            if($scope.assetValue.depAppre == ""){
                logger.logError("Please Choose Appreciation or Depreciation");
            }else {
            if (new validationService().checkFormValidity(assetValuationForm)) {
                debugger;
                if(!$scope.isEdit){
                    $scope.saveDetail(assetValuationForm,assetValue,assetValue1);
                }else{
                    $scope.saveDetail(assetValuationForm,assetValue,assetValue1);
                }
                
            } else {
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew(assetValuationForm.$validationSummary), 555000, 'trustedHtml');
            }
            }
        };
        
     
        $scope.addVal = false;
        $scope.disfac = false;
        $scope.saveDetail = function() {
            debugger;
            if($scope.edit==false){
                if($scope.assetValue.assetValuation.length == 0){
                    $scope.assetValue1.amtaggr = 0;
                    $scope.assetValue1.amtdep = 0;
            $scope.assetValue.assetValuation.push($scope.assetValue1);
            logger.logSuccess("Added Successfully");
            $scope.addVal = true;
            $scope.disfac = true;
                }
                else
                {
                logger.logError("Asset Valuation Added");
                }
            }
            
            else if($scope.edit == true) {
                
                debugger;
                console.log($scope.assetValuation);
                if($scope.assetValue1.valType == 'A' ){
                    //$scope.assetValue1.amtaggr = 0;
                    $scope.assetValue.assetValuation.push($scope.assetValue1);  
                    logger.logSuccess("Added Successfully");
                    $scope.addVal = true;
                    $scope.disfac = true;
                }
                else{
                    //$scope.assetValue1.amtdep = 0;
                    $scope.assetValue.assetValuation.push($scope.assetValue1);  
                    logger.logSuccess("Added Successfully");
                    $scope.addVal = true; 
                    $scope.disfac = true;
                }
                
                
                
            }
        }
        
        $scope.disfac = false;
        $scope.update = function() {
            debugger;
            if($scope.assetValue1.aggressiveFactor != "" && $scope.assetValue1.aggressiveFactor < 100){
                var temp = angular.copy($scope.assetValue1);
                $scope.assetValue.assetValuation.push(temp);
                logger.logSuccess("Updated Successfully");
                $scope.disfac = true;
                /*$scope.assetValue1.afterValuation = $scope.preValue.afterValuation; 
                $scope.assetValue1.currValue =$scope.preValue.currValue; 
                $scope.assetValue1.amtaggr =$scope.preValue.amtaggr;
                $scope.assetValue1.amtdep =$scope.preValue.amtdep; 
                $scope.assetValue1.aggressiveFactor =$scope.preValue.aggressiveFactor;*/
                
                $scope.detailEdit = false;
                $scope.addVal = true;
            }else
                {
                logger.logError("Enter Valid Aggressive Factor");
                }
        }
        
        
        $scope.hidden = {
            noa :''
        }
        
        
        /***
         * Edit Functionality *******************************
         **/
        var assetValId = $location.search().assetValId;
        if(assetValId == undefined || assetValId == null || assetValId ==""){
        }else{
            $scope.edit =true;
                $http.get('hospital/asset/valuation/getAssetValuationDataOnEdit?assetValId='+assetValId).success(function(data) {
                    console.log("Edit Data");
                    console.log(data);
                    $scope.assetValue.startDate = data.nextDate;
                    $scope.assetValue.nextDate = "";
                    $scope.assetValue.currPurValue = data.currPurValue;
                    $scope.assetValue.itemCategoryId = data.id;
                    
                    $scope.rowCollection = data.assetTrackDetails;
                    debugger;
                    
                    $scope.assetValue.noa = data.noa;
                    console.log(data.noa);
                    console.log(data.assetValuation.length);

                    if($scope.assetValue.noa != "") {
                    $scope.hidenoa =  $scope.assetValue.noa;
                    $scope.listlen = data.assetValuation.length + 1;
                    $scope.hidden.noa= $scope.listlen + " Out of " + $scope.hidenoa ;
                    }
                    else{
                        $scope.hidden.noa = data.assetValuation.length + 1;
                    }
                    if(data.comMethod == "1"){
                        $scope.assetValue.comMethod = "Aggressive";
                    }
                    else if(data.comMethod == "2"){
                        $scope.assetValue.comMethod = "Deggressive";
                    }
                    
                    
                    if(data.valType == "A"){
                        $scope.assetValue.depAppre = "A"
                        var i =0;
                        i=data.assetValuation.length -1;
                            if(i == data.assetValuation.length -1)
                            {
                            
                        $scope.assetValue1.aggressiveFactor = data.assetValuation[i].aggressiveFactor;
                        $scope.currValue  = data.assetValuation[i].currValue;
                        $scope.aggress = data.assetValuation[i].aggressiveFactor;
                        $scope.amtalrAppre = data.assetValuation[i].amtaggr;
                        $scope.afterValuation =data.assetValuation[i].afterValuation;
                        if(data.assetValuation[i].amtdep == ""){
                            $scope.assetValue1.amtdep = 0;
                        }
                        
                        console.log("After Valuation");
                        console.log($scope.afterValuation);
                        $scope.assetValue1.amtaggr = parseInt($scope.afterValuation) - parseInt($scope.currValue) + parseInt($scope.amtalrAppre);
                        console.log($scope.assetValue1.amtaggr);
                        $scope.firstVal($scope.afterValuation,$scope.assetValue1.amtaggr,$scope.aggress );
                            
                            }      
                    }
                    
                    else if(data.valType == "D"){
                        $scope.assetValue.depAppre = "D"
                            var i =0;
                        i=data.assetValuation.length -1;
                            if(i == data.assetValuation.length -1)
                            {     
                        $scope.assetValue1.aggressiveFactor = data.assetValuation[i].aggressiveFactor;
                        $scope.currValue  = data.assetValuation[i].currValue;
                        $scope.aggress = data.assetValuation[i].aggressiveFactor;
                        $scope.afterValuation =data.assetValuation[i].afterValuation;
                        $scope.assetValue1.amtaggr = data.assetValuation[i].amtaggr;
                        $scope.amtalrDepre = data.assetValuation[i].amtdep;
                        if(data.assetValuation[i].amtaggr == ""){
                            $scope.assetValue1.amtaggr = 0;
                        }
                        $scope.assetValue1.amtdep = parseInt($scope.currValue) - parseInt($scope.afterValuation) + parseInt($scope.amtalrDepre);
                        $scope.secondVal($scope.afterValuation,$scope.assetValue1.amtdep,$scope.aggress );
                            } 
                    }
                    
                    $scope.assetValue.assetValuation = data.assetValuation;
                    $scope.assetValLen = $scope.assetValue.assetValuation.length -1;
            });
            
   
        }
        $scope.firstVal = function(a,b, c) {
            $scope.assetValue1.currValue = a;
            
            if(c!="" || c!=0){ 
              
                $scope.percentValueAgg = $scope.assetValue1.currValue * (c/100);
                $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) +  parseInt($scope.percentValueAgg);
            
            }
              
          }
          
          $scope.firstVal ();
        
         /* $scope.addDepricate =function(aggressiveFactor){
              
              var factor = angular.copy(aggressiveFactor);
              if($scope.assetValue.depAppre == 'A'){$scope.assetValue1.amtaggr += factor}
              else{$scope.assetValue1.amtdep +=factor}
              
             // $scope.assetValue1.aggressiveFactor += factor;
          }*/
          
        $scope.secondVal = function(a,b, c) {
          $scope.assetValue1.currValue = a;
          if(c!="" || c!=0){ 
            
              $scope.percentValueAgg = $scope.assetValue1.currValue * (c/100);
              $scope.assetValue1.afterValuation = parseInt($scope.assetValue1.currValue) -  parseInt($scope.percentValueAgg);
          
          }
            
        }
        
        $scope.secondVal ();
        
        $scope.preValue = {
                afterValuation : '',
                currValue :'',
                amtaggr :'',
                amtdep :'',
                aggressiveFactor :''
        }
        
        
        
        //Dialog 
     $scope.detailEdit = false;
        $scope.EditVal = function(valuationDtl, index){
            
            if($scope.detailEdit == false){
                
                $scope.preValue.afterValuation = $scope.assetValue1.afterValuation; 
                $scope.preValue.currValue =$scope.assetValue1.currValue; 
                $scope.preValue.amtaggr =$scope.assetValue1.amtaggr;
                $scope.preValue.amtdep =$scope.assetValue1.amtdep; 
                $scope.preValue.aggressiveFactor =$scope.assetValue1.aggressiveFactor;
            }
            $scope.assetValue.nextDate = $scope.assetValue.startDate; 
            $scope.assetValue1.afterValuation = valuationDtl.afterValuation;
            $scope.assetValue1.currValue = valuationDtl.currValue;
            $scope.assetValue1.amtaggr = valuationDtl.amtaggr;
            $scope.assetValue1.amtdep = valuationDtl.amtdep;
            $scope.assetValue1.aggressiveFactor = valuationDtl.aggressiveFactor;
            $scope.detailEdit = true;
            $scope.disfac = false;
            
            $scope.assetValue.assetValuation.splice(index, 1);
                    };

    });
});