'use strict';
app.controller('grldRatesAddCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, $window,$state,sharedProperties,$timeout,validationService, toaster) {



    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    	$scope.modeList=[];
	$scope.getQuotationType = function() {
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
    $scope.getQuotationType();
       $scope.agentList = [];
       $scope.orginList = [];
       $scope.containertypeList =[];
    $scope.grldRateData={
    		
    		agent:'', 
    		orgin:'', 
            port:'',
            grldId:'',
           // portid:'',
            fromDate:'',
            toDate:'', 
            line:'',
            freightElement: '',
            serviceType:'',
            customer:'',
           // customerid :'', 
            containerType:'',
            stuffingStatus :'',
            currency :'',
            grldRateTableDetail:[
            	]
           
                
              
    }   


    
    $http.post($stateParams.tenantid+'/api/grldrates/agentlist').success(function(data) {
		$scope.agentList=data;
  });
    
    $http.post($stateParams.tenantid+'/api/grldrates/orginlist').success(function(data) {
		$scope.orginList=data;
  });
    
	/*$scope.line = [
	     {id: '1', text: 'SIMA MARINE (INDIA) PRIVATE LIMITED'},
	    {id: '2', text: 'TCI SEAWAYS'}
	  ];
	*/
	 $scope.line=[];
	
    $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.line = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});

    //$scope.line = ['SOC','SMI'];    
    $scope.freightElmnt = ['GR','LD'];  
    $scope.stuffingStatusList = ['Ladden','Empty'];
/*    $scope.currencyList = ['INR','USD'];
*/    $http.post($stateParams.tenantid+'/api/grldrates/containertypeList').success(function(data) {
        	
		$scope.containertypeList=data;
  });
$http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
	$scope.currencyList= angular.copy(datas.commonUtilityBean);
}).error(function(data) {

});
    $http.post($stateParams.tenantid+'/api/grldrates/getPortList').success(function(data){
        $scope.portList=data;
    }).error(function(datas){
        logger.logError("Error");
    });    
    $scope.getDropDownListprt = function() {
        $http.post($stateParams.tenantid+'/api/grldrates/getPortList').success(function(data){
            $scope.portList=data;
            
            $timeout(function() { 
                $("#portid").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.portList.length>0){   
                          $scope.grldRateData.port ='';
                         angular.forEach($scope.grldRateData.portid, function (item, key) {
                             if(ct==""){
                                 ct = item.id;
                             }else{
                                 ct +=","+ item.id;
                             }       
                             $scope.grldRateData.port = ct;
                         });
                      }else{
                          $scope.grldRateData.port = '';
                      }
                    }
                  });
                $("#portid").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
            
            $timeout(function() { 
                $("#portid").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.portList.length>0){   
                          $scope.grldRateData.port ='';
                         angular.forEach($scope.grldRateData.portid, function (item, key) {
                             if(ct==""){
                                 ct = item.id;
                             }else{
                                 ct +=","+ item.id;
                             }       
                             $scope.grldRateData.port = ct;
                         });
                      }else{
                          $scope.grldRateData.port = '';
                      }
                    }
                  });
                $("#portid").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });

    }
    $scope.getDropDownListprt();
    
    $http.post($stateParams.tenantid+'/api/grldrates/getCustomerList').success(function(data){
        $scope.customerList=data;
    }).error(function(datas){
        logger.logError("Error");
    });
    $scope.getDropDownList = function() {
        $http.post($stateParams.tenantid+'/api/grldrates/getCustomerList').success(function(data){
            $scope.customerList=data;
            
            $timeout(function() { 
                $("#customerid").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.customerList.length>0){   
                          $scope.grldRateData.customer ='';
                         angular.forEach($scope.grldRateData.customerid, function (item, key) {
                             if(ct==""){
                                 ct = item.id;
                             }else{
                                 ct +=","+ item.id;
                             }       
                             $scope.grldRateData.customer = ct;
                         });
                      }else{
                          $scope.grldRateData.customer = '';
                      }
                    }
                  });
                $("#customerid").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
            
            $timeout(function() { 
                $("#customerid").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                        debugger;
                        var ct=""; 
                      if($scope.customerList.length>0){   
                          $scope.grldRateData.customer ='';
                         angular.forEach($scope.grldRateData.customerid, function (item, key) {
                             if(ct==""){
                                 ct = item.id;
                             }else{
                                 ct +=","+ item.idS;
                             }       
                             $scope.grldRateData.customer = ct;
                         });
                      }else{
                          $scope.grldRateData.customer = '';
                      }
                    }
                  });
                $("#customerid").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
                
                }, 2, false);
        }).error(function(data) {
        });

    }
    $scope.getDropDownList();
    

    $scope.cancel = function() {
        $state.go('app.reports.grldrates.list');
    };
    
    $scope.reset = function() {
        $scope.grldRateData={       		
        		agent:'', 
        		orgin:'', 
                port:'',
                grldId:'',
                fromDate:'',
                toDate:'',  
               
                line:'',
                freightElement: '',
                serviceType:'',
                customer:'',
                containerType:'',
                stuffingStatus :'',
                currency :'',
                grldRateTableDetail:[],
                  
        }  
        $scope.grldRateData=[]; 
         

     }
    
    
 
    $scope.loadgrldTable = function() {
        debugger;                
        var grldtable = {};
        grldtable = {
                siNo: 1,select : '',containerType:'',stuffingStatus :'',currency :'', chargeList : [{
                	  from : '',
			          to : '',
			          rateperday : ''}
                ]

          };
          debugger;
          $scope.grldRateData.grldRateTableDetail.push(grldtable);
             
        }
    $scope.loadgrldTable();
        
        //add Row
        $scope.addgrldRow = function(tables) {
          var len = tables.length;
          var table = {
                  select : '', slNo : 1, containerType:'',stuffingStatus :'',currency :'', chargeList : [{
                	  from : '',
			          to : '',
			          rateperday : ''}]
                  
                  
    
              };
               
          table.siNo = len+1;
          $scope.grldRateData.grldRateTableDetail.push(table);
          
        };   //remove Row
        $scope.removegrldRow = function(table) {
           
            $scope.tablerow = [];
            angular.forEach(table, function(row, index) {
                var check = row.select;
                console.log(index);
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);                    
                }
            });
            $scope.grldRateData.grldRateTableDetail = $scope.tablerow;
        };       
        
    
  // add dtl inner row
        $scope.addinnergrldDtl = function(table) {
        	debugger
        	var grldinnerDtl = {
        			           from : '',
        			           to : '',
        			           rateperday : ''
        			 
        			 
        	}   
        	table.chargeList.push(grldinnerDtl);
        }
        	
  
       // remove dtl inner row
        	
        	$scope.deleteinnergrldDtl = function(row,bTrIndex) {

        		$scope.tablerow = [];
        		
        		angular.forEach(row.chargeList,function(row1, index) {
        			
        			if(index != bTrIndex)
        				$scope.tablerow.push(row1);
        		});
        		row.chargeList=$scope.tablerow;
        		}
        	
        		
//        		for (var index = 0 ; index < 1; index++) {
//        		angular.forEach(row.chargeList,function(row1, index) {
//        					//var check = row.select;
//        			if(bTrIndex == index){
//						$scope.tablerow.push(row1);
//
//           		 }
//        			else if(index >= 1){
//        				//row.chargeList = $scope.tablerow;
//        	        	row.chargeList=$scope.tablerow;
//
//					}
//           		 /*else{
//						$scope.tablerow.push(row);
//           		 }*/
//        					
//        				});
//        		}
        	
        	/*
        	 row.chargeList=[];
        	 table.chargeList=row;*/
        
       
        
        $scope.save = function(grldRateForm,grldRateData) {  
            if (new validationService().checkFormValidity($scope.grldRateForm)) {         	   
         	   var flag=true;         	  
         	   if(flag==true){         		
         		  $scope.grldRateData.portid=$scope.grldRateData.portid;

		        	var port='';
		        	angular.forEach($scope.grldRateData.portid, function(item, index) {
	                	if(port!=null && port!=''){
	                		port=port+','+item.id;
                    }else{
                    	port=item.id;
	                	}
	                	
	                })
	               $scope.grldRateData.port=port;
		        	
		        	$scope.grldRateData.customerid=$scope.grldRateData.customerid;

		        	var customer='';
		        	angular.forEach($scope.grldRateData.customerid, function(item, index) {
	                	if(customer!=null && customer!=''){
	                		customer=customer+','+item.id;
                    }else{
                    	customer=item.id;
	                	}
	                	
	                })
	               $scope.grldRateData.customer=customer;
		        	
		        	
                 $http.post($stateParams.tenantid+'/api/grldrates/save', $scope.grldRateData).success(function(result) {
                     console.log("result")
                     if (result.success == true) {
                         logger.logSuccess("Saved Successfully!");
                         $state.go('app.reports.grldrates.list');
                     } else {
                         logger.logError("Error in save!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
            }
           
         } 
             
            else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.grldRateForm.$validationSummary), 555000, 'trustedHtml');
                  }
         }
    
     

    
});