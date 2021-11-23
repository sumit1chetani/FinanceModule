app.controller('containerTypeAddCtrl', function($scope,logger, $rootScope,$stateParams, $http, $location,  $log,  $modal,  $window,$state,$timeout) {
    
	
    $scope.containerAddEditData = {
            containerTypeId :'',
            containertype : '',
            length : '' ,
            height : '' ,
            containerkind : '' ,
            tareweight : '' ,
            material : '' ,
            maxcapacity : '' ,
            specification : '' ,
            teufactor : '' ,
            isocode : '' ,
            containerCategory:''
    };
    $scope.tmpData = angular.copy($scope.containerAddEditData);
    $scope.isEdit=false;
    $scope.thumbsAlert=false;
    $scope.error=false;

    $scope.timeOut = function(){
    	$timeout(function() {
    		$scope.thumbsAlert=false;
    		$scope.error=false;
	    }, 3000);
	}
    
    $scope.containerCategory=[{
    	id:'General',
    	text :'General'
    },{
    	id:'Special',
    	text :'Special'
    }];
    
    /*var typeId = $location.search().containerType;
    if(typeId!=null && typeId!=undefined && typeId!=''){
    	$http.post('/' + $stateParams.tenantid+ '/containertype/request/edit', typeId).success(function(data) {
			if(data){
				$scope.isEdit=true;
	            $scope.tmpEditData = angular.copy(data);
				$scope.containerAddEditData=data;
			}else{
				$scope.errorMsg = "Please try again!";
				$timeout(function() {
					$state.go('containerType.list');
				    }, 2000);
			}
		});
    }*/
    

    var url =$stateParams.tenantid+ '/containertype/request/conatinerSizeList';
    $http.get(url).success(function(data) {
        
        if (data.length > 0) {
            $scope.sizeList = data;
           
        }
     }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
 
    
    var typeId = $location.search().containerType;
    if(typeId!=null && typeId!=undefined && typeId!=''){
		$scope.isEdit=true;
		debugger
        $http.post($stateParams.tenantid+'/containertype/request/edit?containertype='+typeId).success(function(data) {
        	if(data){
        		$scope.containerAddEditData = data;
        		$scope.containerAddEditData.length = data.length.toString();
        	}else{
        		logger.logError("Unable to fetch data");
        	}
        });
	}
	
    
  /*  $scope.reset = function() {
        if ($scope.isEdit == false){
            $scope.containerAddEditData = angular.copy($scope.tmpData );
        }else{
            $scope.containerAddEditData = angular.copy($scope.tmpEditData );
        }
    }*/
    
    $scope.cancel = function() {
    	$state.go('app.master.generalcontainertype.containertype');
    }
    
      
    
    $scope.save = function() {
    	if( $scope.containerAddEditData.containertype!=null && $scope.containerAddEditData.containertype!=undefined && $scope.containerAddEditData.containertype!=''){
    		if( $scope.containerAddEditData.isocode!=null && $scope.containerAddEditData.isocode!=undefined && $scope.containerAddEditData.isocode!=''){
    			//$http.post('/' + $stateParams.tenantid+ '/containertype/request/check', $scope.containerAddEditData).success(function(result) {
                  //  if (result) {
            	$http.post($stateParams.tenantid+ '/containertype/request/save',$scope.containerAddEditData).success(function(data) {

            			//$http.post($stateParams.tenantid+ '/containertype/request/save', $scope.containerAddEditData).success(function(data) {
            				if(data.isSuccess==true){
            					logger.logSuccess("Saved Successfully!");
            						$scope.cancel();
            					
            				}else{
            					logger.logError("Error to Save");
            					$scope.error=true;
            					$scope.timeOut();
            				}
            			});
                    /*}else{
                    	$scope.errorMsg = "Already Exists!";
                    	$scope.error=true;
                    	$scope.timeOut();
                    	}
                    })*/
    		}else{
    			logger.logError("Please enter ISO Code");
    			
    		}
    	}else{
    		logger.logError("Please enter container type");
    		
    	}
    }
    
    $scope.update = function() {
    	if( $scope.containerAddEditData.containertype!=null && $scope.containerAddEditData.containertype!=undefined && $scope.containerAddEditData.containertype!=''){
    		if( $scope.containerAddEditData.isocode!=null && $scope.containerAddEditData.isocode!=undefined && $scope.containerAddEditData.isocode!=''){
    			/*$http.post('/' + $stateParams.tenantid+ '/containertype/request/update', $scope.containerAddEditData).success(function(result) {
                    if (result) {*/
            			$http.post('/' + $stateParams.tenantid+ '/containertype/request/update', $scope.containerAddEditData).success(function(data) {
            				if(data.isSuccess==true){
            					logger.logSuccess("Updated Successfully!");
            						$scope.cancel();
            					
            				}else{
            					logger.logError("Error To Update");
            				}
            			});
                    /*}else{
                    	$scope.errorMsg = "Already Exists!";
                    	$scope.error=true;	
                    	$scope.timeOut();
                    }*/
                    //})
    		}else{
    			logger.logError("Please enter ISO Code");
    			
    		}
    	}else{
    		logger.logError("Please enter container type");
    		
    	}
    }
    
    $scope.reset=function(){
    	if($scope.isEdit == false){
    		$scope.containerAddEditData = {
    	            containerTypeId :'',
    	            containertype : '',
    	            length : '' ,
    	            height : '' ,
    	            containerkind : '' ,
    	            tareweight : '' ,
    	            material : '' ,
    	            maxcapacity : '' ,
    	            specification : '' ,
    	            teufactor : '' ,
    	            isocode : '' 
    	    };
    	}else{
    		var typeId = $location.search().containerType;
    	    if(typeId!=null && typeId!=undefined && typeId!=''){
    			$scope.isEdit=true;
    			debugger
    	        $http.post($stateParams.tenantid+'/containertype/request/edit?containertype='+typeId).success(function(data) {
    	        	if(data){
    	        		$scope.containerAddEditData = data;
    	        	}else{
    	        		logger.logError("Unable to fetch data");
    	        	}
    	        });
    		}
    	}
    }

       
 });