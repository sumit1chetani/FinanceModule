'use strict';

app.controller('containerListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

		$scope.itemsByPage = 10;
		$scope.numPages = 0;
		$scope.offsetCount = 0;
		$scope.limitCount = 1000;
		$scope.rowCollection = [];
		$scope.displayedCollection = [];
		$scope.itemsByPage = 10;
		$scope.isUpload=true;
		$scope.isDelete=true;
		
		
		$scope.quotation={
				service:'',
				aol:'',
				origin:'',
				customer:'',
				salesPerson:'',
				vendor : '', 
				attention : '',
				quotationDate : '',
				branch : '',
				aod : '',
				destination : '',
				shipper : '',
				salesType : '',
				carrier : '',
				termConditions : '',
				mode : '1',
				currency : '',
				term : '',
				commodity : '',
				consignee : '',
				nominatedBy : '',
				validityDate : '',
				remarks : '',
				vessel :'',
				dimensionName:'',
				conNumber:'',
				quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
				sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}]
		
		}

		
		$scope.add = function() {
		    $state.go("app.operation.containerReleaseOrder.add",{tenantid:$stateParams.tenantid});
		};
		
		$scope.getRfqList = function() {
			$http.post($stateParams.tenantid+'/app/container/list').success(function(datas) {
				$scope.rowCollection = datas.lQuotationBean
			}).error(function(datas) {

			});
		};
		$scope.getRfqList();
		
		//Edit functionality
		$scope.editRow = function(containerreleaseCode,gateOutStatus) {
			if(gateOutStatus != "COMPLETED"){
		    $location.url($stateParams.tenantid+'/master/inventory/containerReleaseOrder/edit?containerreleaseCode=' + containerreleaseCode);
			}else{
				logger.logError("You Can't Edit this Record, Related Data Exist!");	
			}
				
			};
		
		//Export Excel
		
		
		$scope.excelexport=function(containerreleaseCode){
			
			debugger
			$http.post($stateParams.tenantid+'/app/container/excelexport?containerreleaseCode=' + containerreleaseCode).success(function(datas){
				
				debugger;
	            $("#emptyExport").bind('click', function() {
	            });
	            $('#emptyExport').simulateClick('click');
	            logger.logSuccess("Exported successfully!");
	       /* }else{
	            logger.logError("Failed to export");
	        }*/
	     }).error(function(result) {
	         console.log("data" + result);
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
		
		//Delete functionality
		$scope.deleteRow = function(quotationNo,gateOutStatus) {	
			if(gateOutStatus != "COMPLETED"){
			ngDialog.openConfirm().then(function() {
			
			$http.post($stateParams.tenantid+'/app/container/delete',quotationNo).success(function(datas) {
				
				if(datas.success){
					
				$state.reload();
				logger.logError("Deleted Successfully");
				
				
				
				}else{
					logger.logError("Error in Delete");
				}
				 
			
		
		}).error(function(datas) {

		});
		
			}, function(reason) {
	        	
	            console.log('Modal promise rejected. Reason: ', reason);
	        });
			}else{
	    		logger.logError("You Can't Delete this Record, Related Data Exist!");	
	    	}
		};
		
		
	    $scope.printBooking = function(containerreleaseCode) {
	           
	         	   var url = $stateParams.tenantid+'/app/container/printbookingConfirm?containerreleaseCode=' + containerreleaseCode;
	           
	                var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
	                wnd.print();
	            
	     };
	     
	     $scope.printreleaseorder = function(containerreleaseCode) {
	           
       	   var url = $stateParams.tenantid+'/app/container/printreleaseorder?containerreleaseCode=' + containerreleaseCode;
         
              var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
              wnd.print();
          
   };
	     
	     
	     
	     $scope.printCRO = function(containerreleaseCode) {
	           
       	   var url = $stateParams.tenantid+'/app/container/printCRO?containerreleaseCode=' + containerreleaseCode;
         
              var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
              wnd.print();
          
   };
	     
   $scope.sendMail = function(containerreleaseCode) {
	   $http.post($stateParams.tenantid+'/app/container/sendMail',containerreleaseCode).success(function(datas) {
		   if(datas.success==true){
			   logger.logSuccess("Mail sent!");
		   }else{
			   logger.logError("Unable to send!");
		   }
	   });
	   
      
};
	     


		$scope.viewGateOut = function(gateOutCode) {
		    $location.url($stateParams.tenantid+'/operation/gateOut/edit?gateOutCode=' + gateOutCode);
		};
		
		 $scope.viewGateIn = function(gateInNo) {
		    	debugger
		        $location.url($stateParams.tenantid+'/operation/gateIn/edit?gateInNo='+gateInNo);
		    };
});