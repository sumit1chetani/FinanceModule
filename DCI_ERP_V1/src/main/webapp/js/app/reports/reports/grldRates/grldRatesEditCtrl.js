'use strict';
app.controller('grldRatesEditCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, $window,$state,sharedProperties,$timeout,validationService, toaster) {



    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    
    
       $scope.agentList = [];
       $scope.orginList = [];
      // $scope.portList = [];
    $scope.grldRateData={
    		
    		agent:'', 
    		orgin:'', 
            port:'',
            grldId:'',
            fromDate:'',
            toDate:'', 
            edit:true,
            line:'',mode:'',
            freightElement: '',
            serviceType:'',
            customer:'',
            containerType:'',
            stuffingStatus :'',
            currency :'',
            grldRateTableDetail:[]
              
    }   

    $http.post($stateParams.tenantid+'/api/grldrates/containertypeList').success(function(data) {
    	
		$scope.containertypeList=data;
  });
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
    
$http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
	$scope.currencyList= angular.copy(datas.commonUtilityBean);
}).error(function(data) {

});
$scope.line=[];

$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
	debugger
    $scope.line = datas.commonUtilityBean;	    
    //$scope.transList = datas.lCommonUtilityBean;	    

}).error(function(data) {

});


    
    //edit Functionality
    var grldId=$location.search().grldId;
    $scope.FetchingValues = function() {     

        
         
        
        
      var myURL = $stateParams.tenantid+'/api/grldrates/edit?grldId=' + grldId;
       $http({
          url : myURL,
           data : grldId,
           method : 'post',
           dataType : 'json',
           headers : {
               'Accept' : 'application/json',
               'Content-Type' : 'application/json'
           }
      }).success(function(result) {
                $scope.grldRateData.mode = result.mode;
      
          $scope.grldRateData.agent = result.agent;
          $scope.grldRateData.orgin = result.orgin;
          $scope.grldRateData.grldId = result.grldId;
          $scope.grldRateData.fromDate=result.fromDate;
          $scope.grldRateData.toDate=result.toDate; 
         // $scope.grldRateData.portid=result.port.toString();

          $scope.grldRateData.line=result.line;
          $scope.grldRateData.freightElement=result.freightElement;
          $scope.grldRateData.serviceType=result.serviceType;
          //$scope.grldRateData.customer=result.customer;
          $scope.grldRateData.edit=result.edit;
          $scope.grldRateData.grldRateTableDetail=result.grldRateTableDetail1;
          if(result.grldRateTableDetail1.containerType != null && result.grldRateTableDetail1.containerType != "")
          $scope.grldRateData.grldRateTableDetail.containerType=result.grldRateTableDetail1.containerType.toString();

          
          $http.post($stateParams.tenantid+'/api/grldrates/getPortList').success(function(data) { 
              $scope.portList = data;
           	 $scope.compaccList = [];
           	 var valArr = result.port.split(',');
           	 var i = 0, size = valArr.length;
           	 for (i; i < size; i++) {
           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
           	 angular.forEach($scope.portList, function(value, key) {
           	 if (valArr[i] == value.id) {
           	 $scope.compaccList.push(value);
           	 }
           	 });
           	  
           	 }
             $scope.grldRateData.portid = $scope.compaccList;

           //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
           	 $timeout(function() { 
           		 $("#portid").multiselect('destroy');
           	 $("#portid").multiselect({
           	 maxHeight : 400,
           	 includeSelectAllOption : true,
           	 selectAllText : 'Select All',
           	 enableFiltering : true,
           	 enableCaseInsensitiveFiltering : true,
           	 filterPlaceholder : 'Search',
           	 numberDisplayed: 1,
           	 });
           	 }, 3, false);
           	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
           	 
           	
           	 
           	 });
            
   
          
          
          
          
          
          //new edit 
          
          
          $http.post($stateParams.tenantid+'/api/grldrates/getCustomerList').success(function(data) { 
              $scope.customerList=data;
              $scope.compaccnewList = [];
              var valArr = result.customer.split(',');
           	 var i = 0, size = valArr.length;
           	 for (i; i < size; i++) {
           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
               angular.forEach($scope.customerList, function(value, key) {
           	 if (valArr[i] == value.id) {
           	 $scope.compaccnewList.push(value);
           	 }
           	 });
           	  
           	 }
             //$scope.grldRateData.portid = $scope.compaccnewList;
             $scope.grldRateData.customerid = $scope.compaccnewList;

           //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
           	 $timeout(function() { 
           		 $("#customerid").multiselect('destroy');
           	 $("#customerid").multiselect({
           	 maxHeight : 400,
           	 includeSelectAllOption : true,
           	 selectAllText : 'Select All',
           	 enableFiltering : true,
           	 enableCaseInsensitiveFiltering : true,
           	 filterPlaceholder : 'Search',
           	 numberDisplayed: 1,
           	 });
           	 }, 3, false);
           	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
           	 
           	
           	 
           	 });
            
   
          
          
      	   	
        	   	
                    }).error(function(data) {         
           });
           }
         
          
          
          
          
          
   
          
          
     $scope.FetchingValues();
 
    
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

   // $scope.line = ['SOC','SMI'];    
    $scope.freightElmnt = ['GR','LD'];
    
   // $scope.containertypeList =  ['40 HC','20 DC','40 RF','20 RF'];
    $scope.stuffingStatusList = ['Ladden','Empty'];
    //$scope.currencyList = ['INR','USD'];
   
    
    
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
                grldRateTableDetail:[]
                  
        }  
         
        $state.reload();

     }
 
    $scope.loadgrldTable = function() {
                       
        var grldtable = {};
        grldtable = {
                siNo: 1,select : '',containerType:'',stuffingStatus :'',currency :'', chargeList : [{
              	  from : '',
		          to : '',
		          rateperday : ''}]

          };
          debugger;
          $scope.grldRateData.grldRateTableDetail.push(grldtable);
             
        }
        
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
      
    };
    

    
    //remove Row
  

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
        	
  
       /*// remove dtl inner row
        	
        	$scope.deleteinnergrldDtl = function(table,bTrIndex) {
        	 var table=[];
        	 for(var i=0;i< table.chargeList.length;i++){
        		 if(bTrIndex == i){
        			 
        		 }
        		 else{
        			 table.push(table.chargeList[i]);
        		 }
        	 }
        	 table.chargeList=[];
        	 table.chargeList=table;
        }
*/
        	
        	

        	$scope.deleteinnergrldDtl = function(row,bTrIndex) {

        		$scope.tablerow = [];
        		
        		angular.forEach(row.chargeList,function(row1, index) {
        			
        			if(index != bTrIndex)
        				$scope.tablerow.push(row1);
        		});
        		row.chargeList=$scope.tablerow;
        		}
        //Update Functionality
        
        $scope.update = function(grldRateForm,grldRateData) {  
            if (new validationService().checkFormValidity($scope.grldRateForm)) {         	   
         	   var flag=true;         	  
         	   if(flag==true){         		
         	        
         		  var port = "";
              	if($scope.grldRateData.portid!=null){
              		 angular.forEach($scope.grldRateData.portid, function(item, key) {
                           if (port == "") {
                        	   port = item.id;
                           } else {
                        	   port += "," + item.id;
                           }
                           $scope.grldRateData.port = port;
                           });
              	}else{
              		$scope.grldRateData.port ='';
              	}
              

              	if($scope.grldRateData.portid == '' || $scope.grldRateData.portid == null){
              		$scope.grldRateData.portid=[];
              	}    
                  //customer
              	
              	var customer = "";
              	if($scope.grldRateData.customerid!=null){
              		 angular.forEach($scope.grldRateData.customerid, function(item, key) {
                           if (customer == "") {
                        	   customer = item.id;
                           } else {
                        	   customer += "," + item.id;
                           }
                           $scope.grldRateData.customer = customer;
                           });
              	}else{
              		$scope.grldRateData.customer ='';
              	}
              

              	if($scope.grldRateData.customerid == '' || $scope.grldRateData.customerid == null){
              		$scope.grldRateData.customerid=[];
              	}    
                  

                 

              	
         		   
                 $http.post($stateParams.tenantid+'/api/grldrates/update', $scope.grldRateData).success(function(result) {
                     console.log("result")
                     console.log(result)
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