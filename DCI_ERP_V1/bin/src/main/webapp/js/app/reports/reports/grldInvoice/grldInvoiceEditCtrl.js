'use strict';
app.controller('grldInvoiceEditCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, $window,$state,sharedProperties,$timeout,validationService, toaster) {


    $scope.rowCollection = [];
    $scope.displayedCollection = [];    
	$scope.itemsByPage = 10;	
	$scope.polList = [];
	$scope.podList = [];
	$scope.vesselList = [];
	$scope.voyageList = [];
	$scope.bankAcctList=[];
	$scope.typeList=[];
	 $scope.modeList=[];


	$scope.grldinvoiceData = {
    		
            customer : '',type:'',bankDtl:'',
            voyage  : '',
            vessel  : '',
            pol : '',
            pod:'',           
            status : '',
            invoiceNo : '', 
            invoiceDate : '',
            intraState: 'Y' ,
            totalpercentage: '',
            cgstpercentage: '',
            sgstpercentage: '',
            igstpercentage: '',
            grandtotalpercentage: '',
            total: '',
            cgst: '',
            sgst: '',
            igst: '',
            grandtotal: '',val:true,val1:false,
            grldInvoiceDetail:[],
            edit:true,
            view :true,

            carrier:'',
            mode:''
            
           
            
        };			
		
	
	    //vessel list
			$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
				$scope.vesselList = data;

			});
			
			 $scope.$watch('grldinvoiceData.vessel', function(newValue, oldValue) {
			      if(newValue!=null && newValue!=undefined && newValue != ''){
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
							$scope.voyageList = data;
			    	  });
			      }
			      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==true){
			    	  $http.post($stateParams.tenantid+ '/app/booking/getVoyListByVsl?pol='+$scope.booking.pol+'&pod='+$scope.booking.pod+'&ves='+newValue).success(function(data) {
							$scope.voyageList = data.voyList;
				    	  })
			      }
			    });			 
	
			 //mode
			 
			
			 
			 $scope.$watch('grldinvoiceData.type', function(newValue, oldValue) {
			    	if(newValue=='Import'){
			    	$scope.grldinvoiceData.val=true;
			    	$scope.grldinvoiceData.val1=false;

		}else if(newValue=='Export'){
			    	$scope.grldinvoiceData.val1=true;
			    	$scope.grldinvoiceData.val=false;

		}
			    });

	 /* $http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
			$scope.podList = data.commonUtilityBean;
		});
	  */
	    $scope.reset = function() {
	    
	    	$scope.grldinvoiceData = {
	    			customer : '',
	   	            pol : '',
	   	            pod:'',
	   	            voyage : '',
	   	            vessel : '',
	   	            bookingNo:'',
	   	            status : '',
	   	            fromDate:''	,
	             	toDate:'',
	             	
	             	 
	            };
	    	  $state.reload();
	    	}	 
	    
	    
	    //detail table
	    $scope.loadgrldTable = function() {
	        debugger;                
	        var grldtable = {};
	        grldtable = {
	               containerType:'',
	               containerNo :'',
	               dischargeDate :'',
	               releaseDate : '',
	               returnDate : '',
	               grDays : '' ,
	               grFreeDays : '' ,
	               grAmount: '' ,
	               ldDays:'' ,
	               ldFreeDays:'' ,
	               ldAmount: ''
	              

	          };
	       
	          $scope.grldinvoiceData.grldInvoiceDetail.push(grldtable);
	             
	        }
	    $scope.loadgrldTable();
	    
	    //add Row
        $scope.addgrldRow = function(tables) {
          var len = tables.length;
          var table = {
                  select : '', slNo : 1, 
	               containerType:'',
	               containerNo :'',
	               dischargeDate :'',
	               releaseDate : '',
	               returnDate : '',
	               grDays : '' ,
	               grFreeDays : '' ,
	               grAmount: '' ,
	               ldDays:'' ,
	               ldFreeDays:'' ,
	               ldAmount: ''
	            	   };
               
          table.siNo = len+1;
          $scope.grldinvoiceData.grldInvoiceDetail.push(table);
          
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
            $scope.grldinvoiceData.grldInvoiceDetail = $scope.tablerow;
        };
        $scope.$watch('grldInvoiceDetail[trIndex].releaseDate', function(newValue, oldValue) {
        	
  //	  $scope.$watchCollection('[grldInvoiceDetail[trIndex].releaseDate,grldInvoiceDetail[trIndex].dischargeDate]', function(newValue, oldValue) {
  		   var date1 = new Date($scope.grldInvoiceDetail[trIndex].releaseDate); 
  		   var date2 = new Date($scope.grldInvoiceDetail[trIndex].dischargeDate);   		  
  		   // To calculate the time difference of two dates 
  		   var Difference_In_Time = date2.getTime() - date1.getTime();   		  
  		   // To calculate the no. of days between two dates 
  		   var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);   		   
  		   $scope.row.grDays = Difference_In_Days;
			
		 });
 
	 /*   $scope.$watch('grldinvoiceData.voyage', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
		    		  $scope.polList = data;
		    	  })
		    	  
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data11) {
		    		  $scope.podList = data11;
		    	  })
		      }
		})
	    */
        $scope.$watch('grldinvoiceData.voyage', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
		    		  $scope.polList = data;
		    	  })
		    	  
		    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data11) {
		    		  $scope.podList = data11;
		    	  })
		      }
		})

		
		$scope.$watch('grldinvoiceData.customer', function(newValue, oldValue) {
		      if(newValue!=null && newValue!=undefined && newValue != ''){
		    	  $http.post($stateParams.tenantid+ '/app/grldinvoice/getbankList',newValue).success(function(data) {
						$scope.bankAcctList = data;
		    	  });
		      }
		      
		    });			
        $scope.typeList = ['Import','Export']; 
	
	 
	    $scope.$watchCollection('[grldinvoiceData.pol,grldinvoiceData.pod]', function(newValue, oldValue) {
	    	//if(){
			 if($scope.grldinvoiceData.pol != null && $scope.grldinvoiceData.pol != '' && $scope.grldinvoiceData.pol != undefined 
				        && $scope.grldinvoiceData.pod != null && $scope.grldinvoiceData.pod != '' && $scope.grldinvoiceData.pod != undefined
				   ){
				 
				 if($scope.grldinvoiceData.pol == $scope.grldinvoiceData.pod){
				 logger.logError('POL and POD should be different!');
				 $scope.grldinvoiceData.pol ='';
					 $scope.grldinvoiceData.pod ='';
				 }
				 
			 }
	   // }
		 });
		$http.post($stateParams.tenantid+'/app/grldinvoice/getCompany').success(function(datas) {
			//  $scope.grldinvoiceData.invoiceNo=datas.maxInvoiceNo;
			  $scope.customerList=datas.getcustomerlist;
			  $scope.containerTypeList=datas.getcontTypelist;
			
		}).error(function(datas) {

		});
	    
	    $scope.cancel = function() {
	        $state.go('app.reports.grldinvoice.list');
	    };
	  //edit Functionality
	    var invoiceNo=$location.search().invoiceNo;
	    var viewFlag=$location.search().viewFlag;
	    $scope.FetchingValues = function() {     

	        
	         
	        
	        
	      var myURL = $stateParams.tenantid+'/app/grldinvoice/edit?invoiceNo=' + invoiceNo;
	       $http({
	          url : myURL,
	           data : invoiceNo,
	           method : 'post',
	           dataType : 'json',
	           headers : {
	               'Accept' : 'application/json',
	               'Content-Type' : 'application/json'
	           }
	      }).success(function(result) {
	    	  $scope.grldinvoiceData.customer = result.customer;
	      $scope.grldinvoiceData.voyage = result.voyage ;
	      $scope.grldinvoiceData.vessel = result.vessel ;
	      $scope.grldinvoiceData.type = result.type ;
	      $scope.grldinvoiceData.bankDtl = result.bankDtl ;
	      $scope.grldinvoiceData.pol = result.pol;
	      $scope.grldinvoiceData.pod = result.pod;          
	      $scope.grldinvoiceData.invoiceNo = result.invoiceNo; 
	      $scope.grldinvoiceData.invoiceDate = result.invoiceDate;
	      $scope.grldinvoiceData.intraState = result.intraState;
	      $scope.grldinvoiceData.totalpercentage = result.totalpercentage;
	      $scope.grldinvoiceData.cgstpercentage = result.cgstpercentage;
	      $scope.grldinvoiceData.sgstpercentage = result.sgstpercentage;
	      $scope.grldinvoiceData.igstpercentage = result.igstpercentage;
	      $scope.grldinvoiceData.grandtotalpercentage = result.grandtotalpercentage;
	      $scope.grldinvoiceData.total = result.total;
	      $scope.grldinvoiceData.cgst = result.cgst;
	      $scope.grldinvoiceData.sgst = result.sgst;
	      $scope.grldinvoiceData.igst = result.igst;
	      $scope.grldinvoiceData.carrier = result.carrier;
	      $scope.grldinvoiceData.mode = result.mode.toString();

	      if(viewFlag == "true"){
	    	  
		      $scope.grldinvoiceData.podName = result.podName;

	     if(result.carrier==3){
	    	  $scope.grldinvoiceData.carrier ="THE SHIPPING CORPORATION OF INDIA LIMITED";
	      }
	
	      if(result.carrier==1){
	    	  $scope.grldinvoiceData.carrier ="SIMA MARINE (INDIA) PRIVATE LIMITED";
	      }
	      if(result.carrier==5){
	    	  $scope.grldinvoiceData.carrier ="ALLIGATOR  SHIPPING CO LLC";
	      }
	      if(result.carrier==7){
	    	  $scope.grldinvoiceData.carrier ="SUPEREME CONTAINER LINE";
	      }
	      if(result.mode==1){
	    	  $scope.grldinvoiceData.mode = "SEA COASTAL";
	      }
	      if(result.mode==2){
	    	  $scope.grldinvoiceData.mode = "SEA FOREIGN";
	      }
	      if(result.mode==3){
	    	  $scope.grldinvoiceData.mode = "TRUCK";
	      }
	      if(result.mode==4){
	    	  $scope.grldinvoiceData.mode = "LINER";
	      }
	      }
	      $scope.grldinvoiceData.grandtotal= result.grandtotal;
	      $scope.grldinvoiceData.grldInvoiceDetail= result.grldInvoiceDetail;
	      
	      }).error(function(data) {         
	      });
	      }
	    
	    
	    
	    
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


//carrier
	 
	 $scope.carrierList=[];


	 $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
	 				debugger
	 			    $scope.carrierList = datas.commonUtilityBean;	    
	 		        //$scope.transList = datas.lCommonUtilityBean;	    

	 			}).error(function(data) {

	 			});
	 
	    $scope.FetchingValues();
	    $scope.update = function(grldInvoiceForm,grldinvoiceData) {  
            if (new validationService().checkFormValidity($scope.grldInvoiceForm)) {         	   
         	   var flag=true;         	  
         	   if(flag==true){         		
         	        
                 $http.post($stateParams.tenantid+'/app/grldinvoice/update', $scope.grldinvoiceData).success(function(result) {
                     console.log("result")
                     if (result.success == true) {
                         logger.logSuccess("updated Successfully!");
                         $state.go('app.reports.grldinvoice.list');
                     } else {
                         logger.logError("Error in update!");
                     }
                 }).error(function(result) {
                     console.log("data" + result);
                 });
            }
           
         } 
             
            else{
                toaster.pop('error', "Please fill the required fields", 
                        logger.getErrorHtmlNew($scope.grldInvoiceForm.$validationSummary), 555000, 'trustedHtml');
                  }
         }
        
	    
	   
});

app.controller('invoicetableCtrl', function($scope, $http, $filter, logger,
		$stateParams) { 
	
	$scope.$watchCollection('[grldInvoiceDetail[trIndex].releaseDate,grldInvoiceDetail[trIndex].dischargeDate]', function(newValue, oldValue) {
	  		   var date1 = new Date($scope.grldInvoiceDetail[trIndex].releaseDate); 
	  		   var date2 = new Date($scope.grldInvoiceDetail[trIndex].dischargeDate);   		  
	  		   // To calculate the time difference of two dates 
	  		   var Difference_In_Time = date2.getTime() - date1.getTime();   		  
	  		   // To calculate the no. of days between two dates 
	  		   var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);   		   
	  		   $scope.row.grDays = Difference_In_Days;
				
			 });});
