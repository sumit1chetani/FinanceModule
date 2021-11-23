'use strict';
app.controller('SeasalesInvoiceAddCtrl', function($scope, $rootScope,sharedProperties, 
        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window, $timeout, ngDialog, $controller) {
	$scope.job=$rootScope.jobId;
        $scope.purchaseInvoiceData = {
        		jobNo :'',
        		puchaseInvoiceDate :'', 
                customer :'',
                pol :'',dueDate1:'',creditDays:'',
                pod :'',
                origin :'',
                destination:'',
                flightNo :'',
                arrivalDate :'',
                remarks:'',
                party :'',
                reference :'',
                hbl:'',grandTotal:'',roundOff:'',
                mbl:'',
                flightDate:'',
                departureDate :'',
                narration :'',
                purchaseInvoice:'',
                shipper :false,shipper1:'',
                consignee :false,
                container :false,
                bank:'',
                purchaseInvoiceDetail : [],                purchaseInvoiceDetail1 : [],
                purchaseInvoiceDetailRejectList: [],
                polName:'',
                podName:'',
                vessel:'',
                totalAmount:'',
                partyNo:'',
                sailedDate:'',
                invoiceAmount:'',
                bankDtl:'',
                draftSave:false,
                printNumber:'',
                currSymbol:'',
                selectBox:false,selectBox1:false,
                status:'',
                invoiceNo:'',
                checkInv:''	
        };
        $scope.valid=true;

        $scope.tenant = $stateParams.tenantid       
        $scope.commodityList=[];
        $scope.jobNoList=[];
        $scope.customerList=[];
        $scope.originList=[];
        $scope.partyList=[];
        $scope.hblList=[];
        $scope.polList=[];
        $scope.podList=[];
        $scope.destinationList=[];
        $scope.mblList=[];
        $scope.bankList=[];
        $scope.accountList=[];
        if($scope.job!=null && $scope.job!=''){
            $http.get($stateParams.tenantid+'/app/seasalesinvoice/getJbNo?jobNo='+$scope.job).success(function(datas) {
            	$scope.purchaseInvoiceData.jobNo=datas.code;

            })
        }
        $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data){
        	$scope.commodityList=data.commonUtilityBean;
        })
        $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
        
        if(window.localStorage.getItem('purchaseIv')==$scope.currentURL){
            /*alert('window ' + $scope.currentURL + ' is already opened');*/
           // window.focus();
            // window.open($rootScope.currentURL,'_self').close();
          
           // window.close();
           // localStorage.removeItem('purchaseIv');
        }else{
            window.localStorage.setItem('purchaseIv', $scope.currentURL);
            // window.localStorage.removeItem('purchaseIv');
        }
        $(window).unload(function(){
          // 
           // alert("INSIDE UNLOAD")
             localStorage.removeItem('purchaseIv');
           });
        
       
        $('#purchase_invoice_date').datetimepicker({
            minDate: "01/01/2016",
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        $('#dueDate1').datetimepicker({
            minDate: "01/01/2016",
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        $('#party_invoice_date').datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime: false
        });
        $timeout(function() {
            $("#txtDueDate").datetimepicker({
                minDate: "01/01/2016",
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = dd + '/' + mm + '/' + yyyy;
		$scope.$watchCollection('[purchaseInvoiceData.puchaseInvoiceDate]',function(newValue, oldValue) {
			if ($scope.purchaseInvoiceData.puchaseInvoiceDate != '') {
				var frmDate = today;
				var toDate = $scope.purchaseInvoiceData.puchaseInvoiceDate;
				var splitarray = new Array();
				splitarray = frmDate.split(" ");
				var date = splitarray[0];
				var time = splitarray[1];
				frmDate = date.split("/");
				frmDate = new Date(frmDate[2],
						frmDate[1] - 1, frmDate[0]);
				toDate = toDate.split("/");
				toDate = new Date(toDate[2],
						toDate[1] - 1, toDate[0]);
				if (toDate >frmDate) {
					logger.logError("Invoice Date should be less or equal to current date");
					$scope.purchaseInvoiceData.puchaseInvoiceDate = today;
				}
			}
		});  
		$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
			  $scope.sizeTypeList=datas.getcontypelist;

		}).error(function(data) {

		});
         $scope.getCurrentDate=function(){
             var today = new Date();
             var dd = today.getDate();
             var mm = today.getMonth() + 1;

             var yyyy = today.getFullYear();
             if (dd < 10) {
                 dd = '0' + dd;
             }
             if (mm < 10) {
                 mm = '0' + mm;
             }
             var today = dd + '/' + mm + '/' + yyyy;
             $scope.purchaseInvoiceData.puchaseInvoiceDate = today;
             $scope.purchaseInvoiceData.partyInvoiceDate = today;
             $scope.purchaseInvoiceData.dueDate = today;
             //$scope.purchaseInvoiceData.dueDate1 = today;
             $scope.checkDatesCL = function(puchaseInvoiceDate){
                 var res = $scope.purchaseInvoiceData.puchaseInvoiceDate.split("/");
                 $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='+$scope.purchaseInvoiceData.puchaseInvoiceDate).success(function(datas) {
                     if(datas){
                         logger.logError("Account closed for year "+ res[2]);
                         $scope.purchaseInvoiceData.puchaseInvoiceDate = today;
                         
                     }
                 })
                 
                        debugger
     				    $scope.modeType=1;
     			        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getInvoiceDateChk?mode=' + $scope.modeType +'&invoiceDate='+ $scope.purchaseInvoiceData.puchaseInvoiceDate + '&jobId=' + $scope.purchaseInvoiceData.jobNo).success(function(datas) {
     			            if(datas){
     			                logger.logError("Job Order Closed Pls Contact IT Support");
     			                $scope.purchaseInvoiceData.puchaseInvoiceDate = today;
     			                
     		                 }
     			        }) 
                 
             }
         
     }
        
         $scope.getCurrentDate();
        
        /**
		 * load Detail Table
		 */
        $scope.loadTable = function() {
              var table = {};
              table = {
            		  siNo: 1,select:false,select1:false,
                      accountHeadCode : '',
                      unit:'',
                      chargeHead : '',conType:'',selected:false,status:'',
                      qty:'',
                      rate:'',
                      currency:'',
                      exchangeRate:'',
                      amount:'',
                      taxAmount:'',
                      chargeHeadId:'',shipper1:'',
               };

              $scope.purchaseInvoiceData.purchaseInvoiceDetail.push(table);
              
          }

          $scope.loadTable();
          $scope.loadTable1 = function() {
              var table = {};
              table = {

						select : '',
						commodity : '',
						descriptionGoods : '',selected:false,status:'',
						uom : '',
						length : '',
						width : '',
						height : '',
						noOfPieces : '',
						netWeight : '',
						grossWeight : '',
						chargeableWeight: '',
						remarks : '',
					
						joborderDtlId : '',
						chargeHead : '',
						unit : '',
						conType: '',
						transactionType : '1',
						quantity : '',
						rate : '',
						currency :'',
						exRate :'1',
						amount : '0',
						amount1 :'' ,
					    buySellParty : '',
						status:'1',
				
            		  siNo: 1,select:false,select:false,
                      accountHeadCode : '',
                      qty:'',
                      exchangeRate:'',
                      taxAmount:'',
                      chargeHeadId:''
               };

              $scope.purchaseInvoiceData.purchaseInvoiceDetail1.push(table);
              
          }

          $scope.loadTable1();


          $scope.addRow = function(purchaseInvoiceDetail) {
              var len = purchaseInvoiceDetail.length;
              var table = {
            		  siNo: 1,select:false,selected:false,status:'',select1:false,
                      accountHeadCode : '',
                      unit:'',conType:'',
                      qty:'',
                      rate:'',
                      currency:'',
                      exchangeRate:'',
                      amount:'',
                      taxAmount:''
                   };
              table.siNo = len+1;
              purchaseInvoiceDetail.push(table);
              
          };


          $scope.removeRow = function(purchaseInvoiceDetail) {
              $scope.tablerow = [];
              angular.forEach(purchaseInvoiceDetail, function(row, index) {
                  var check = row.select;
                 
                  if (check == undefined || check == "") {
                      $scope.tablerow.push(row);
                  }
              });
              $scope.purchaseInvoiceData.purchaseInvoiceDetail = $scope.tablerow;

          };

         
        $scope.cancel = function() {
              $location.path($stateParams.tenantid+"/invoice/sea/seasalesinvoice/SalesInvoiceList");
        };

        
        
        /**
		 * Drop Down Functionality commit
		 */
        
        $scope.statusList=[];
		$scope.getjobStatus = function() {
		    var  data = {};
		    data["id"] = "1";
		    data["text"] = "OPEN";
		    $scope.statusList.push(data);
		    data = {};
		    data["id"] = "2";
		    data["text"] = "CLOSED";
		    $scope.statusList.push(data);  
		    
		}
		$scope.getjobStatus();

       $scope.getDropdownvalue = function() {
        
           //new 
    	   $http.get($stateParams.tenantid+'/app/seasalesinvoice/getJobList').success(function(datas) {
               $scope.jobNoList = datas;
               }).error(function(datas) {
           });
           
    	   $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
				debugger
			  //  $scope.quotationList = datas.quotationList;	
				$scope.customerDropList = datas.customerSelectivityList;
				$scope.consigneeDropList = datas.consigneeSelectivityList;
				$scope.shipperDropList = datas.shipperSelectivityList;
				$scope.nominatedDropList = datas.nominatedSelectivityList;
				$scope.vendorDropList = datas.vendorSelectivityList;
				$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
				$scope.customerBuyList = datas.buyServiceList;
				$scope.customerSellList = datas.sellServiceList;
				$scope.salesTypeList = datas.salesSelectivityList;
				$scope.employeeList = datas.employeeSelectivityList;
				$scope.servicePartnerTypelist = datas.serviceSelectivityList;
				$scope.PaymentMethodList = datas.paymentSelectivityList;
				$scope.transactionTypeList = datas.transactionSelectivityList;
				$scope.chargeHeadList = datas.chargeHeadSelectivityList;
				$scope.TermList = datas.termsSelectivityList;
				$scope.UnitList = datas.unitSelectivityList;
				$scope.uomList = datas.uomList;	 
				$scope.sizeTypeList = datas.sizeTypeSelectivityList;
				$scope.commodityList = datas.commoditySelectivityList;	
				$scope.currencylist= datas.currecnySelectivityList;
				$scope.branchList = datas.branchSelectivityList;
			    $scope.portList = datas.portSelectivityList;
			}).error(function(data) {

			});
    	   
    	   /*$http.get($stateParams.tenantid+'/app/seasalesinvoice/getCustomerList').success(function(datas) {
               $scope.customerList = datas;
               }).error(function(datas) {
           });           
           $http.get($stateParams.tenantid+'/app/seasalesinvoice/getPolList').success(function(datas) {
               $scope.polList = datas;
               }).error(function(datas) {
           });
           $http.get($stateParams.tenantid+'/app/seasalesinvoice/getPodList').success(function(datas) {
               $scope.podList = datas;
               }).error(function(datas) {
           });
           $http.get($stateParams.tenantid+'/app/seasalesinvoice/getOriginList').success(function(datas) {
               $scope.originList = datas;
               }).error(function(datas) {
           });
           $http.get($stateParams.tenantid+'/app/seasalesinvoice/getDestinationList').success(function(datas) {
               $scope.destinationList = datas;
               }).error(function(datas) {
           });*/
          
           /*$http.get($stateParams.tenantid+'/app/seasalesinvoice/gethblList').success(function(datas) {
               $scope.hblList = datas;
               }).error(function(datas) {
          });
           $http.get($stateParams.tenantid+'/app/seasalesinvoice/getmblList').success(function(datas) {
               $scope.mblList = datas;
               }).error(function(datas) {
           });*/
           
           
           //
         /* $http.get($stateParams.tenantid+'/app/seasalesinvoice/getAccountList').success(function(datas) {
               $scope.accountList = datas;
               $scope.accountListData.push($scope.accountList);

               }).error(function(datas) {
          });
          $http.get($stateParams.tenantid+'/app/seasalesinvoice/getSubAccountList').success(function(datas) {
              $scope.subAccountList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/seasalesinvoice/getCurrencyList').success(function(datas) {
              $scope.currencyList = datas;
              }).error(function(datas) {
          });*/
          
          /*// code added for attribute dropdown list
          $http.get($stateParams.tenantid+'/app/commonUtility/getTripList').success(function(datas) {
              $scope.voyageList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/trucktrailermapping/trucklist').success(function(datas) {
              $scope.vesselList = datas.truckList;
              }).error(function(datas) {
          });
          $http.get($stateParams.tenantid+'/app/commonUtility/getSectorList').success(function(datas) {
              $scope.sectorList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getEmployeeList').success(function(datas) {
              $scope.employeeList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getPortList').success(function(datas) {
              $scope.portList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getDepartmentList').success(function(datas) {
              $scope.departmentList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getAgentList').success(function(datas) {
              $scope.agentList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getCountryList').success(function(datas) {
              $scope.countryList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getCustomerList').success(function(datas) {
              $scope.customerList = datas;
              }).error(function(datas) {
          });          
          $http.get($stateParams.tenantid+'/app/commonUtility/getDesignationList').success(function(datas) {
              $scope.designationList = datas;
              }).error(function(datas) {
          });*/
       };

       $scope.getDropdownvalue();

       $scope.$watch('purchaseInvoiceData.jobNo', function(newValue,oldValue) {
			if (newValue != '' && newValue != undefined) {
				
				debugger
				$scope.modeType=1;
			        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getJobDate?mode=' + $scope.modeType +'&jobId='+ newValue).success(function(datas) {
			            if(datas){
			                logger.logError("Job Order Closed Pls Contact IT Support");
			                $scope.partyList=[];
		                 }else{
		                	 $http.post($stateParams.tenantid + '/app/seasalesinvoice/dropDownList?jobNo='+newValue).success(function(datas) {
		     					console.log(datas);
		     					$scope.partyList = datas.partyList;
		     				}); 
		                 }
			        })

			}
		});
       $scope.$watch('purchaseInvoiceData.dueDate1', function(newValue,oldValue) {/*
			if (newValue != '' && newValue != undefined) {
if($scope.purchaseInvoiceData.creditDays!='' && $scope.purchaseInvoiceData.creditDays!=null){
	var creditDays=$scope.purchaseInvoiceData.creditDays;
    	   Date.prototype.addDays = function (days) {
        	   let date = new Date(this.valueOf());
        	   date.setDate(date.getDate() + creditDays);
        	   return date;
        	 }
           let date = newValue;
           var dt=date.addDays(creditDays);
           
        	   var month = dt . getMonth();
        	   var day = dt . getDate();
        	   var year = dt . getFullYear();
        	   if(day<10){
        		   day='0'+day;
        	   }
        	   if(month<10){
        		   month='0'+month;
        	   }
               $scope.purchaseInvoiceData.dueDate1=day + "/" + month + "/" + year;  
               }
			}
       */});
       
       
       

       $scope.$watch('purchaseInvoiceData.partyNo', function(newValue, oldValue) {
    	   if($scope.edit==false){
    	//   if($scope.purchaseInvoiceData.draftSave==false){
           if(newValue!="" && newValue!=undefined && newValue!=null){
               
        	   $scope.tempDrfatStatus;
               $http.get($scope.tenant+'/app/seasalesinvoice/getJobDetails?partyNo='+newValue +'&jobNo=' + $scope.purchaseInvoiceData.jobNo +'&status=' + $scope.tempDrfatStatus).success(function(data){
                       //$scope.purchaseInvoiceData.party=data.party;
                   $scope.purchaseInvoiceData.polId=data.polId.toString();    
                   $scope.purchaseInvoiceData.podId=data.podId.toString(); 
                   $scope.purchaseInvoiceData.originId=data.originId.toString(); 
                   $scope.purchaseInvoiceData.destinationId=data.destinationId.toString(); 

                       $scope.purchaseInvoiceData.vessel=data.vessel;
                       $scope.purchaseInvoiceData.bank=data.bank;
                       $scope.purchaseInvoiceData.bankId=data.bankId;
                       var creditDays=data.creditDays;
                       $scope.purchaseInvoiceData.creditDays=data.creditDays;
                       Date.prototype.addDays = function (days) {
                    	   let date = new Date(this.valueOf());
                    	   date.setDate(date.getDate() + creditDays);
                    	   return date;
                    	 }
                       let date = new Date();
                       var dt=date.addDays(creditDays);
                       
                    	   var month = dt . getMonth()+1;
                    	   var day = dt . getDate();
                    	   var year = dt . getFullYear();
                    	   if(day<10){
                    		   day='0'+day;
                    	   }
                    	   if(month<10){
                    		   month='0'+month;
                    	   }
                    	  
                       $scope.purchaseInvoiceData.dueDate1=day + "/" + month + "/" + year;

                       $scope.bankList=data.bankList;
                       if(data.bankList.length>0){
                       $scope.purchaseInvoiceData.bankDtl=data.bankList[0].id;
                       }

                       $scope.hblList=data.hblList;
                       $scope.mblList=data.mblList;
                       if($scope.tempDrfatStatus==false)
                    	   {
                       if(data.jobDetail.length!=0){
                          	$scope.purchaseInvoiceData.purchaseInvoiceDetail=data.jobDetail;
                            for(var i=0;i<data.jobDetail.length;i++) 
                          	{   $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].conType=data.jobDetail[i].conType.toString();
                              $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].commodity=data.jobDetail[i].commodity.toString();
              				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxExem=data.jobDetail[i].taxExem;

                            	$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].chargeHeadId=data.jobDetail[i].chargeHeadId.toString();
                   				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].unitId=data.jobDetail[i].unitId.toString();
                   				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].currencyId=data.jobDetail[i].currencyId.toString();
                   				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].isCgst=data.jobDetail[i].isCgst;
                   				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].isIgst=data.jobDetail[i].isIgst;
                				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxPrct=data.jobDetail[i].taxPrct;
 if($scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxExem=='Y'){
	 $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxAmount=0.0;
	 $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxExemption='Tax Exemption';
}
                          	}
                            /*for(var j=0;j< data.jobDetail.length;j++){
                            	 for(var k=0;k < $scope.tempDtl.length;k++) 
                               	{
                               if(data.jobDetail[j].jobChargeDtlBin == $scope.tempDtl[k].jobChargeDtlBin ){
                               		$scope.purchaseInvoiceData.purchaseInvoiceDetail[j]['select']= true;
                               	}
                               	}
                            }*/
                            $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
                          }else{
                          	logger.logError("Already in Draft");
                          	$scope.purchaseInvoiceData.purchaseInvoiceDetail='';
                          }
               }else{
            	    if(data.jobDetail.length!=0){
            	    	 for(var i=0;i<data.jobDetail.length;i++) 
                     	{
             			   data.jobDetail[i].chargeHeadId=data.jobDetail[i].chargeHeadId.toString();
             			   data.jobDetail[i].unitId=data.jobDetail[i].unitId.toString();
             			   data.jobDetail[i].currencyId=data.jobDetail[i].currencyId.toString();
           				}
                        for(var i=0;i<data.jobDetail.length;i++) 
                      	{
                        	$scope.purchaseInvoiceData.purchaseInvoiceDetail.push(data.jobDetail[i]);
            				

                      	}
            	    }
            	    
                  $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
               }
                       //$scope.calculateTotAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
                       /*$http.get($stateParams.tenantid+'/app/seasalesinvoice/getCustomerList?jobNo='+newValue).success(function(datas) {
                           $scope.partyList = datas;
                           }).error(function(datas) {
                       });*/
               }).error(function(data) {
               });
           }
    	   }else if($scope.edit==true){
               $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);

    	   }
    //	   }
       });
       $scope.$watch('purchaseInvoiceData.totalAmount', function(newValue, oldValue) {
       if (newValue != '' && newValue != undefined) {
    	   var str=$scope.purchaseInvoiceData.totalAmount.split('.');
    	   if(str[1]==0){
    		   $scope.purchaseInvoiceData.roundOff =0;
    	   }else{
    	   $scope.purchaseInvoiceData.roundOff = '0.'+str[1];}
    	   $scope.purchaseInvoiceData.grandTotal = Math.round($scope.purchaseInvoiceData.totalAmount);
    	   
       }
   });
$scope.calAmt = function(tables) {
           
           var Total = 0.0;
           var TotalTax=0.0;
           var TotalAmt=0.0;
               angular.forEach(tables, function (value, key) {
            	   var check =value.select;
                   if (check ==true) {
        	   Total = parseFloat(value.amount)+Total;
        	   TotalTax= parseFloat(value.taxAmount)+TotalTax;
        	   
                   }               
           });
               TotalAmt = Total+TotalTax;
           $scope.purchaseInvoiceData.invoiceAmount = Total.toFixed(2);
           $scope.purchaseInvoiceData.totaltaxAmount = TotalTax.toFixed(2);
              $scope.purchaseInvoiceData.totalAmount = TotalAmt.toFixed(2);
           
           
       };
       
       $scope.selectAll = function(tables) {
           debugger;
           
               angular.forEach(tables, function (value, key) {
            	   var check =value.select;
                   if ($scope.purchaseInvoiceData.selectBox ==true) {
        	              value.select=true;
        	             
                   }else if($scope.purchaseInvoiceData.selectBox ==false) {
                	   value.select=false;
                   }
                   $scope.calAmt(tables);
           });
          
          
       };
       $scope.selectAll1 = function(tables) {
           debugger;
           
               angular.forEach(tables, function (value, key) {
            	   var check =value.select1;
                   if ($scope.purchaseInvoiceData.selectBox1 ==true) {
        	              value.select1=true;
        	             
                   }else if($scope.purchaseInvoiceData.selectBox1 ==false) {
                	   value.select1=false;
                   }
                   $scope.calAmt(tables);
           });
          
          
       };
       
       $scope.calculateTotAmount = function(tables) {
           
           var Total = 0.0;
               angular.forEach(tables, function (value, key) {
        	   Total = parseFloat(value.amount) + parseFloat(value.taxAmount)+Total;
                             
           });
           $scope.purchaseInvoiceData.totalAmount = Total.toFixed(2);
           
       };
       
    /*   //edit
       var editid = $location.search().salesSNO;    
       var test = parseInt(editid);
       if(test){
       	$scope.edit = false;
       	 $http.post($stateParams.tenantid+'/city/edit',test).success(function(result) {
       	    	console.log(result);
       	    	$scope.city = result;
       	    	$scope.city.state = result.state.toString();
       	    	if(result.isStstus == "t"){
       	    		$scope.city.isActive = true;
       	    	}else{
       	    		$scope.city.isActive = false;
       	    	}    	    	
       	    });    	
       }
       */
       $scope.tempDtl=[];
       $scope.tempDrfatStatus=false;
       var purchaseInvoiceNo=$stateParams.purchaseInvoiceNo;
       if(purchaseInvoiceNo == undefined || purchaseInvoiceNo == null || purchaseInvoiceNo ==""){
           $scope.edit=false;
       }
       else{
           $scope.purchaseTable = true;
           $scope.edit=true;
           $scope.showSalesGrid=false;
           $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
       		if (data[1].userId=='E0003'||data[1].userId=='E0008'||data[1].userId=='E0042'||data[1].userId=='E0043' ||data[1].userId=='E0016' || data[1].userId=='E0110') {
       			$scope.showSalesGrid=true;
       			
       			
       		}

      /* 	}).error(function(data) {
       		logger.logError("Error Please Try Again");*/
       	});
           
           $http.get($stateParams.tenantid+'/app/seasalesinvoice/getEditData?purInvNo='+purchaseInvoiceNo).success(function(result) {
               $scope.purchaseInvoiceData = result;
               $scope.purchaseInvoiceData.draftSave=true;
               $scope.tempDtl=angular.copy(result.purchaseInvoiceDetail);
               $scope.tempDrfatStatus=true;
               $scope.purchaseInvoiceData.jobNo= result.job.toString(); 
               $scope.purchaseInvoiceData.partyNo= result.partyNo.toString();  
               $scope.purchaseInvoiceData.bankDtl=result.bankDtl.toString();
               $scope.purchaseInvoiceData.status=result.status.toString();
               $scope.purchaseInvoiceData.polId=result.polId.toString();    
               $scope.purchaseInvoiceData.podId=result.podId.toString(); 
               $scope.purchaseInvoiceData.originId=result.originId.toString(); 
               $scope.purchaseInvoiceData.destinationId=result.destinationId.toString(); 
               $scope.purchaseInvoiceData.bank=result.bank;
               $scope.purchaseInvoiceData.bankId=result.bankId;
               $scope.purchaseInvoiceData.puchaseInvoiceDate= result.purchaseInvoiceDate;
               $scope.purchaseInvoiceData.grandTotal= result.grandTotal;
               $scope.purchaseInvoiceData.roundOff= result.roundOff;

               $scope.purchaseInvoiceData.hbl=result.hblNo.toString();
               $scope.purchaseInvoiceData.mbl=result.mblNo.toString();
               $scope.bankList=result.bankList;

               $scope.hblList=result.hblList;
               $scope.mblList=result.mblList;
               for(var j=0;j<= $scope.tempDtl.length;j++)  {
       	    	
               $scope.purchaseInvoiceData.purchaseInvoiceDetail[j]['select']= true; 
               $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].chargeHeadId=$scope.tempDtl[j].chargeHeadId.toString();
  			   $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=$scope.tempDtl[j].unitId.toString();
  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].currencyId=$scope.tempDtl[j].currencyId.toString();
  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].isCgst=$scope.tempDtl[j].isCgst;
  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].isIgst=$scope.tempDtl[j].isIgst;
  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxPrct=$scope.tempDtl[j].taxPrct;
  				$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].commodity=$scope.tempDtl[j].commodity;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxExem=$scope.tempDtl[j].taxExem.toString();

  				if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxExem=='Y'){
  					$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxAmount=0.0;
  					$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxExemption='Tax Exemption';
  				}
             }
               $scope.purchaseInvoiceData.bankDtl=result.bankList[0].id;

               $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
           }).error(function(result) {
           });
       }
       
       /*var salesSNO = $location.search().salesSNO;    
       if(salesSNO == undefined || salesSNO == null || salesSNO ==""){
       }else{
           // fetching edit details
           $http.get($stateParams.tenantid+'/app/purchaseinvoice/getPurchaseInvoiceDetailEdit?salesSNO='+salesSNO).success(function(data) {
               $scope.subAccountList=data.subAccountCodeList;
               $scope.purchaseOrderList= data.pOList;
               
               $scope.purchaseInvoiceData = data;
               console.log("$scope.purchaseInvoiceDatacopy111");
               console.log($scope.purchaseInvoiceData);
               $scope.calculateTotalAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
           }).error(function(data) {
           });
       }*/
       
       /**
		 * Edit functionality
		 */
      /* $scope.isEdit1 = false;
       var purchaseInvoiceNo=$stateParams.purchaseInvoiceNo;
       if(purchaseInvoiceNo == undefined || purchaseInvoiceNo == null || purchaseInvoiceNo ==""){
           $scope.edit=false;
       }else{
           // fetching edit details
           $scope.edit=true;
           $http.get($stateParams.tenantid+'/app/purchaseinvoice/getPurchaseInvoiceDetail?purchaseInvoiceNo='+purchaseInvoiceNo).success(function(data) {
               $scope.isEdit1 = true;
               $scope.subAccountList=data.subAccountCodeList;
               $scope.purchaseOrderList= data.pOList;
               
               $scope.purchaseInvoiceData = data;
               console.log("$scope.purchaseInvoiceDatacopy");
               console.log($scope.purchaseInvoiceData);
               $scope.calculateTotalAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
           }).error(function(data) {
           });
       }*/
       
       /* edit and draft functionality */
       
       /*var purchaseInvoiceNo=$stateParams.purchaseInvoiceNo1;
       if(purchaseInvoiceNo == undefined || purchaseInvoiceNo == null || purchaseInvoiceNo ==""){
           $scope.edit=false;
       }else{
           // fetching edit details
           $scope.edit=true;
           $http.get($stateParams.tenantid+'/app/purchaseinvoice/getPurchaseInvoiceDetailDraft?purchaseInvoiceNo='+purchaseInvoiceNo).success(function(data) {
               $scope.isEdit1 = true;
               $scope.subAccountList=data.subAccountCodeList;
               $scope.purchaseOrderList= data.pOList;
               
               $scope.purchaseInvoiceData = data;
               console.log("$scope.purchaseInvoiceDatadraft");
               console.log($scope.purchaseInvoiceData);
               $scope.calculateTotalAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
           }).error(function(data) {
           });
       }*/
       /**
		 * save and update functionality
		 * 
		 * validation submit -
		 * $scope.onSubmit(purchaseInvoiceForm,purchaseInvoiceData);
		 */
       
       $scope.onSubmit = function(purchaseInvoiceForm,purchaseInvoiceData) {
           
           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
			// $('#purchase_invoice_date').val();
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.save();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       $scope.onSubmitDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
           
           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
			// $('#purchase_invoice_date').val();
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.saveDraft();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       
      $scope.onSubmitDraft1 = function(purchaseInvoiceForm,purchaseInvoiceData) {
           
           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
			// $('#purchase_invoice_date').val();
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.saveDraft1();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       $scope.previewInvoice = function(purchaseInvoiceForm,purchaseInvoiceData) {
           
           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
			// $('#purchase_invoice_date').val();
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.savePreview();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       $scope.checkValidation = function() {

 	  	    var alertmsg = "<ui><h4>Please fill the required fields</h4>";
 	  	    var msg = "";
 	  	  /*  if ($scope.checkundefined($scope.quotation.commodity)) {
 	  	        msg = msg + "<li>Commodity:Field is required.</li>";         
 	  	        $scope.changecolor('commodity');
 	  	    }else{
 	  	    	$scope.clearcolor('commodity');
 	  	    }*/
 	  	    if ($scope.checkundefined($scope.hbl.jobNo)) {
 	  	        msg = msg + "<li>jobNo:Field is required.</li>";         
 	  	        $scope.changecolor('jobNo');
 	  	    }else{
 	  	    	$scope.clearcolor('jobNo');
 	  	    }
 	  	    if ($scope.checkundefined($scope.purchaseInvoiceData.partyNo)) {
 	  	        msg = msg + "<li>partyNo:Field is required.</li>";         
 	  	        $scope.changecolor('partyNo');
 	  	    }else{
 	  	    	$scope.clearcolor('partyNo');
 	  	    }
 	  	    if ($scope.checkundefined($scope.purchaseInvoiceData.polName)) {
 	  	        msg = msg + "<li>polName:Field is required.</li>";         
 	  	        $scope.changecolor('polName');
 	  	    }else{
 	  	    	$scope.clearcolor('polName');
 	  	    }
 	  	    if ($scope.checkundefined($scope.purchaseInvoiceData.podName)) {
 	  	        msg = msg + "<li>podName:Field is required.</li>";         
 	  	        $scope.changecolor('podName');
 	  	    }else{
 	  	    	$scope.clearcolor('podName');
 	  	    }
 	  	    if ($scope.checkundefined($scope.purchaseInvoiceData.bankDtl)) {
 	  	        msg = msg + "<li>bankDtl:Field is required.</li>";         
 	  	        $scope.changecolor('bankDtl');
 	  	    }else{
 	  	    	$scope.clearcolor('bankDtl');
 	  	    }
 	  	  
 	  
 	  	 alertmsg = alertmsg + msg + "</ui>";
	  	    if ($scope.checkundefined(msg)) {
	  	        return '';
	  	    } else {
	  	        return alertmsg;
	  	    }
       }
       /**
		 * save and update functionality
		 * 
		 * after validation submit -
		 * $scope.onSubmit(purchaseInvoiceForm,purchaseInvoiceData);
		 */
       //print usd
       $scope.printUsdForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
          
           
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.printUsd();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
      $scope.printUsdFormDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
          
           
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.printUsdDraft();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       $scope.printUsd = function(){
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=false;
        	      $scope.purchaseInvoiceData.printNumber=1,
        	      $scope.purchaseInvoiceData.currSymbol='Usd',
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
        	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                      if (result.success) {
                          
                  
                         var url = $stateParams.tenantid+'/app/seasalesinvoice/printusdandInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                          wnd.print();  
                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                          
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }

                  }).error(function(data) {
                      
                  });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
           }
       
       $scope.printUsdDraft = function(){
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=true;
        	      $scope.purchaseInvoiceData.printNumber=1,
        	      $scope.purchaseInvoiceData.currSymbol='Usd',
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
        	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                      if (result.success) {
                          
                  
                         var url = $stateParams.tenantid+'/app/seasalesinvoice/printusdandInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                          wnd.print();  
                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                          
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }

                  }).error(function(data) {
                      
                  });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
           }
       //print usd Ends
       
       //print SGD
       $scope.printSgdForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
          
           
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.printSgd();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
      $scope.printSgdFormDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
          
           
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.printSgdDraft();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       $scope.printSgd = function(){
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=false;
        	      $scope.purchaseInvoiceData.printNumber=4,
        	      $scope.purchaseInvoiceData.currSymbol='Sgd',
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
        	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                      if (result.success) {
                          
                  
                         var url = $stateParams.tenantid+'/app/seasalesinvoice/printusdandInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                          wnd.print();  
                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                          
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }

                  }).error(function(data) {
                      
                  });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
           }
       
       $scope.printSgdDraft = function(){
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=true;
        	      $scope.purchaseInvoiceData.printNumber=4,
        	      $scope.purchaseInvoiceData.currSymbol='Sgd',
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
        	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                      if (result.success) {
                          
                  
                         var url = $stateParams.tenantid+'/app/seasalesinvoice/printusdandInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                          wnd.print();  
                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                          
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }

                  }).error(function(data) {
                      
                  });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
           }
       
       //print SGD Ends
       
       
       
       
       //print inr
       $scope.printInrForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
           
           
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.printInr();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       $scope.printInrFormDraft = function(purchaseInvoiceForm,purchaseInvoiceData) {
           
           
           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
               $scope.printInrDraft();
           } else {
               toaster.pop('error', "Please fill the required fields", 
                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
           }
       };
       
       $scope.printInr = function(){
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=false;
        	      $scope.purchaseInvoiceData.printNumber=2,
        	      $scope.purchaseInvoiceData.currSymbol='Inr',
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
        	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                      if (result.success) {
                          
                  
                         var url = $stateParams.tenantid+'/app/seasalesinvoice/printusdandInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                          wnd.print();  
                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                          
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }

                  }).error(function(data) {
                      
                  });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
           }
       
       $scope.printInrDraft = function(){
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=true;
        	      $scope.purchaseInvoiceData.printNumber=2,
        	      $scope.purchaseInvoiceData.currSymbol='Inr',
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
        	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                      if (result.success) {
                          
                  
                         var url = $stateParams.tenantid+'/app/seasalesinvoice/printusdandInr?purInvNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                          wnd.print();  
                          $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                          
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }

                  }).error(function(data) {
                      
                  });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
           }
       //print inr Ends
       
 
       //preview
      $scope.savePreview = function(){
           
          
           $scope.approvedData=[];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
           });
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.containerList, function(row, index) {

           if(row.containerNo==null || row.containerNo=='' ){
        	   row.containerNo='';
           }
           })

           if($scope.approvedData.length >0){
        	      $scope.purchaseInvoiceData.isSaveDraft=false;
        	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                  	if(row.taxExem=='Y'){
                  		row.isIgst=false;
                  		row.isCgst=false;

                  	}
                      })
                  $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                   if (result.success) {
                       
                       var url = $stateParams.tenantid+'/app/seasalesinvoice/SalesprintPreview?purInvNo=' + result.purchaseInvoiceNo1;
                       var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                       wnd.print();  
                       $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
           
                   } else {
                       if(result.message != null && result.message != ''){
                           logger.logError(result.message);
                       }else{
                       logger.logError("Error try again");
                       }
                   }

               }).error(function(data) {
                   
               });
           }else{
               logger.logError("Please select atleast one row to Preview Invoice!..");
           }     
}
       
       
       $scope.calculateTotalAmountOnDialog = function(purInvDueDateDtls){
           
           var totalBCAmount=0.0,totalTCAmount=0.0;
           angular.forEach(purInvDueDateDtls, function(row, index) {
               totalBCAmount = totalBCAmount+parseFloat(row.bcAmount);
               totalTCAmount = totalTCAmount+parseFloat(row.tcAmount);
           });
           $scope.totalTCAmount = totalTCAmount.toFixed(2);
           $scope.totalBCAmount = totalBCAmount.toFixed(2);
       };
       
       //save
        $scope.save = function(){
           
           
           $scope.approvedData=[];
           $scope.rejectData=[];
           $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList= [];
           $scope.tempData=[];
           $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
           angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
               var check =row.select;
               if (check ==true) {
                   $scope.approvedData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
               }
               else{
            	   $scope.rejectData.push(row);  
                   $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList=$scope.rejectData;
               }
           });
          
           $scope.purchaseInvoiceData.draftSave=false;
           $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
                  $scope.purchaseInvoiceData.isSaveDraft=false;
                  if($scope.approvedData.length >0){
                  $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                   if (result.success) {
                       
                       $location.path($stateParams.tenantid+"/invoice/sea/seasalesinvoice/SalesInvoiceList");
                       logger.logSuccess("Sales Invoice added successfully");
           
                   } else {
                       if(result.message != null && result.message != ''){
                           logger.logError(result.message);
                           $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                       }else{
                       logger.logError("Error try again");
                       $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                       }
                   }

               }).error(function(data) {
                   
               });
                  }else{
                      logger.logError("Please select atleast one row to save !..");
                  }      
           }
       
        
       // save Draft //
              
            $scope.saveDraft = function(){
            	
            	
                $scope.approvedData=[];
                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                    var check =row.select;
                    if (check ==true) {
                        $scope.approvedData.push(row);  
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
                    }
                });
                $scope.purchaseInvoiceData.draftSave=false;
                $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

                $scope.purchaseInvoiceData.isSaveDraft=true;
                if($scope.approvedData.length >0){
                       $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                        if (result.success) {
                            console.log(result)
                            $location.path($stateParams.tenantid+"/invoice/sea/seasalesinvoice/SalesInvoiceList");
                            logger.logSuccess("Sales Invoice added successfully");
                
                        } else {
                            if(result.message != null && result.message != ''){
                                logger.logError(result.message);
                            }else{
                            logger.logError("Error try again");
                            }
                        }

                    }).error(function(data) {
                        
                    });
                }else{
                    logger.logError("Please select atleast one row to save !..");
                }
       }
            
          $scope.saveDraft1 = function(){
            	
            	
                $scope.approvedData=[];
                $scope.rejectData=[];
                $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList= [];
                $scope.tempData=[];
                $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                    var check =row.select;
                    if (check ==true) {
                        $scope.approvedData.push(row);  
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
                    }
                    else{
                 	   $scope.rejectData.push(row);  
                        $scope.purchaseInvoiceData.purchaseInvoiceDetailRejectList=$scope.rejectData;
                    }
                });
                $scope.purchaseInvoiceData.draftSave=true;
                $scope.purchaseInvoiceData.isSaveDraft=true;
                $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
                angular.forEach($scope.purchaseInvoiceData.containerList, function(row, index) {

                    if(row.containerNo==null || row.containerNo=='' ){
                 	   row.containerNo='';
                    }
                    })
                if($scope.approvedData.length >0){
                    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
                	if(row.taxExem=='Y'){
                		row.isIgst=false;
                		row.isCgst=false;

                	}
                    })
                       $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInv', $scope.purchaseInvoiceData).success(function(result) {
                        if (result.success) {
                            console.log(result)
                            $location.path($stateParams.tenantid+"/invoice/sea/seasalesinvoice/SalesInvoiceList");
                            logger.logSuccess("Sales Invoice added successfully");
                
                        } else {
                            if(result.message != null && result.message != ''){
                                logger.logError(result.message);
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                            }else{
                            logger.logError("Error try again");
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                            }
                        }

                    }).error(function(data) {
                        
                    });
                }else{
                    logger.logError("Please select atleast one row to save !..");
                }
       }
          
          $scope.getjobDetails=function(partyNo,jobNo,tempDrfatStatus){
          $http.get($scope.tenant+'/app/seasalesinvoice/getJobDetails?partyNo='+partyNo +'&jobNo=' + jobNo +'&status=' + tempDrfatStatus).success(function(data){
            
              if($scope.tempDrfatStatus==false)
           	   {
            	  if($scope.valid==true){

              if(data.jobDetail.length!=0){
                 	$scope.purchaseInvoiceData.purchaseInvoiceDetail=data.jobDetail;
                   for(var i=0;i<data.jobDetail.length;i++) 
                 	{   $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].conType=data.jobDetail[i].conType.toString();

                   	$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].chargeHeadId=data.jobDetail[i].chargeHeadId.toString();
          				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].unitId=data.jobDetail[i].unitId.toString();
          				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].currencyId=data.jobDetail[i].currencyId.toString();
          				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].isCgst=data.jobDetail[i].isCgst;
          				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].isIgst=data.jobDetail[i].isIgst;
       				$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxPrct=data.jobDetail[i].taxPrct;

                 	}
                   /*for(var j=0;j< data.jobDetail.length;j++){
                   	 for(var k=0;k < $scope.tempDtl.length;k++) 
                      	{
                      if(data.jobDetail[j].jobChargeDtlBin == $scope.tempDtl[k].jobChargeDtlBin ){
                      		$scope.purchaseInvoiceData.purchaseInvoiceDetail[j]['select']= true;
                      	}
                      	}
                   }*/
                   $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
                 }else{
                 	logger.logError("Already in Draft");
                 	$scope.purchaseInvoiceData.purchaseInvoiceDetail='';
                 }
            	  }
      }else{
    	  if($scope.valid==false){

   	    if(data.jobDetail.length!=0){
   	    	 for(var i=0;i<data.jobDetail.length;i++) 
            	{
    			   data.jobDetail[i].chargeHeadId=data.jobDetail[i].chargeHeadId.toString();
    			   data.jobDetail[i].unitId=data.jobDetail[i].unitId.toString();
    			   data.jobDetail[i].currencyId=data.jobDetail[i].currencyId.toString();
  				}
               for(var i=0;i<data.jobDetail.length;i++) 
             	{
               	$scope.purchaseInvoiceData.purchaseInvoiceDetail.push(data.jobDetail[i]);
   				

             	}
   	    }
     
   	    
         $scope.calAmt($scope.purchaseInvoiceData.purchaseInvoiceDetail);
      }
      }
              //$scope.calculateTotAmount($scope.purchaseInvoiceData.purchaseInvoiceDetail);
              /*$http.get($stateParams.tenantid+'/app/seasalesinvoice/getCustomerList?jobNo='+newValue).success(function(datas) {
                  $scope.partyList = datas;
                  }).error(function(datas) {
              });*/
      }).error(function(data) {
      });
        	 
          }

      	$scope.apply=function(purchaseInvoiceForm,purchaseInvoiceData){
      		if($scope.purchaseInvoiceData.shipper1!=null     && $scope.purchaseInvoiceData.shipper1!=''){
      		$scope.approvedData1=[];$scope.approvedData=[];$scope.data=[];
            $scope.valid=true;
            angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail1, function(row1, index1) {
		        var check =row1.select1;
		        if (check ==true) {
		            $scope.approvedData.push(row1);  
		        }
		    });
            $scope.getjobDetails($scope.purchaseInvoiceData.partyNo,$scope.purchaseInvoiceData.jobNo,$scope.tempDrfatStatus);
          for(var j=0; j<$scope.purchaseInvoiceData.purchaseInvoiceDetail.length; j++){
              var cont='';var count=0;var containerNo='';var check=false;

            for(var i=0;i<$scope.approvedData.length ; i++){
                   	if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].conType==$scope.approvedData[i].sizeType){
               		 count=count+1;
               		 
               	    /*else if(cont!='' && cont!=null && cont!=undefined){
               		cont=$scope.approvedData[i].sizeType;
                    count=1;
                   	} else{
                   		cont=$scope.approvedData[i].sizeType;
                        count=1;
                   	}*/
                   	if(containerNo!='' && containerNo!=null && containerNo!=undefined){
                   		containerNo=containerNo+','+$scope.approvedData[i].containerNo;
                   		check=true;
                   		 }else{
                   			containerNo=$scope.approvedData[i].containerNo;
                   			check=true;
                   		 }
                   	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].grossWeight=$scope.approvedData[i].grossWeight;

                   	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unit=$scope.approvedData[i].uom;
			            /* if($scope.approvedData.length==i+1){   
			            	 if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=="1"){
			                	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate*count;
			            	 }else if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=="2"){
			                	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=Math.round(($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate/1000)*count);

			                  }else if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=="3"){
			                	 $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=Math.round(($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].grossWeight/1000)*count);
			                  }
			                	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate=$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate;
                            	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxAmount=(Math.round($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxAmount/$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].qty)*count);
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].containerNo=containerNo;
                            	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].qty=count;
                            	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].shipper1=$scope.purchaseInvoiceData.shipper1;

       			            $scope.valid=false;

			             }*/
                   	}

			        	
			      } 
            if(check==true){
            	 //if($scope.approvedData.length==i+1){   
	            	 if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=="1"){
	                	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate*count;
	            	 }else if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=="2"){
	                	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=Math.round(($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate/1000)*count);

	                  }else if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId==3 && $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId==$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unit){
	                	  $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=Math.round($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].grossWeight*count*$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate);
	                    }else if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId=="3"){
	                	 $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].amount=Math.round(($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].grossWeight/1000)*count);
	                  }
	                	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate=$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].rate;
                    	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxAmount=(Math.round($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].taxAmount/$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].qty)*count);
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].containerNo=containerNo;
                        if($scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId==3 && $scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unitId==$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].unit){
                        	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].qty=$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].grossWeight*count;
                        }else{
                        	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].qty=count;	
                        }
                    	$scope.purchaseInvoiceData.purchaseInvoiceDetail[j].shipper1=$scope.purchaseInvoiceData.shipper1;

			            $scope.valid=false;

	           //  }
	             $scope.data.push($scope.purchaseInvoiceData.purchaseInvoiceDetail[j]);
            }
          }
		   /* angular.forEach($}scope.approvedData1, function(row1, index1) {
			    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
if(row1.sizeType==row.conType){
	if(row1.chargeHead==row.chargeHeadId){
		if(row1.unit==row.unitId){
			row.amount=row1.amount;
			row.rate=row1.rate;
			row.containerNo=row1.containerNo;
            row.taxAmount=(Math.round(row.taxAmount/row.qty)*row1.quantity);
			row.qty=row1.quantity;
            $scope.data.push(row);
		}
	}
}
			    })
			    });	*/            
		    $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.data;
	        ngDialog.close();
      	}else{
      		logger.logError("Shipper field is Required");	
      	}
      		 }
       // save Draft//
       
			$scope.showTax = function(chargeHeadId,jobNo,partyNo){
			                
			                if(chargeHeadId !=""){
			        ngDialog.open({
			            scope : $scope,
			            template : 'views/finance/invoice/purchaseinvoice/PurchaseInvoiceTaxView',
			            controller : $controller('purchaseInvoiceTaxCtrl', {
			                $scope : $scope,
			                purchaseObject : $scope.purchaseInvoiceData,
			                chargeHeadId:chargeHeadId,
			                jobNo:jobNo,
			                partyNo:partyNo
			            }),
			            className : 'ngdialog-theme-plain',
			            showClose : false,
			            closeByDocument : false,
			            closeByEscape : false,
			            preCloseCallback : $scope.getList
			        });
			    }else{
			        logger.logError("Please Select Job No..");
			        }
			}
			
			$scope.showContainer = function(jobNo,partyNo){
                
                if(jobNo !="" && partyNo!=""){
        ngDialog.open({
            scope : $scope,
            template : 'views/finance/invoice/seasalesinvoice/SalesInvoiceContainer.jsp',
            controller : $controller('purchaseInvoiceContainerCtrl', {
                $scope : $scope,
                purchaseObject : $scope.purchaseInvoiceData,
                jobNo:jobNo,
                partyNo:partyNo

            }),
            className : 'ngdialog-theme-plain',
            showClose : false,
            closeByDocument : false,
            closeByEscape : false,
            preCloseCallback : $scope.getList
        });
    }else{
        logger.logError("Please Select Job No..");
        }
}

			//emailUsd check
				$scope.email = function(purchaseInvoiceForm,purchaseInvoiceData) {
				    console.log($scope.purchaseInvoiceData);    
				    $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				$scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

				if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				    $scope.emailusd(purchaseInvoiceForm,purchaseInvoiceData);
				} else {
				    toaster.pop('error', "Please fill the required fields", 
				        logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				    }
				};
			//emailUsd check  end
				


				//emailUsd check dialog
				$scope.emailusd = function(purchaseInvoiceForm,purchaseInvoiceData){
					
					$scope.approvedData=[];
				    $scope.tempData=[];
				    $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
				    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
				        var check =row.select;
				        if (check ==true) {
				            $scope.approvedData.push(row);  
				            $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
				        }
				    });
				   
				    if($scope.approvedData.length >0){
				    	 $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				 	    $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

				 	    if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {	       
				 	        
				 	        ngDialog.open({
				 	            scope : $scope,
				 	            template : 'views/finance/invoice/seasalesinvoice/SeasalesinvoiceusdView',
				 	            controller : $controller('seasalesinvoiceCtrl', {
				 	                $scope : $scope,
				 	                purchaseObject : $scope.purchaseInvoiceData	                
				 	            }),
				 	            className : 'ngdialog-theme-plain',
				 	            showClose : false,
				 	            closeByDocument : false,
				 	            closeByEscape : false,
				 	            preCloseCallback : $scope.getList
				 	        });
				 	    } else {
				 	        toaster.pop('error', "Please fill the required fields", 
				 	                logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				 	    }
				    }else{
				        logger.logError("Please select atleast one row to Preview Invoice!..");
				    }     
				}
				//emailUsd check dialog end
				
				//emailInr check 
				$scope.email1 = function(purchaseInvoiceForm,purchaseInvoiceData) {
				    console.log($scope.purchaseInvoiceData);    
				    $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				$scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

				if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				    $scope.emailInr(purchaseInvoiceForm,purchaseInvoiceData);
				} else {
				    toaster.pop('error', "Please fill the required fields", 
				        logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				    }
				};
				//emailInr check end
				
				//emailInr check end
				$scope.emailInr = function(purchaseInvoiceForm,purchaseInvoiceData){
									
									$scope.approvedData=[];
								    $scope.tempData=[];
								    $scope.tempData=$scope.purchaseInvoiceData.purchaseInvoiceDetail;
								    angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
								        var check =row.select;
								        if (check ==true) {
								            $scope.approvedData.push(row);  
								            $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.approvedData;
								        }
								    });
								   
								    if($scope.approvedData.length >0){
								    	 $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
					 	    $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

					 	    if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {	       
					 	        
					 	        ngDialog.open({
					 	            scope : $scope,
					 	            template : 'views/finance/invoice/seasalesinvoice/SeasalesinvoiceinrView',
					 	            controller : $controller('seasalesinvoiceCtrl1', {
					 	                $scope : $scope,
					 	                purchaseObject : $scope.purchaseInvoiceData	                
					 	            }),
					 	            className : 'ngdialog-theme-plain',
					 	            showClose : false,
					 	            closeByDocument : false,
					 	            closeByEscape : false,
					 	            preCloseCallback : $scope.getList
					 	        });
					 	    } else {
					 	        toaster.pop('error', "Please fill the required fields", 
					 	                logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
					 	    }
					    }else{
					        logger.logError("Please select atleast one row to Preview Invoice!..");
					    }     
					}
				//emailInr check end
     });

app.controller('seasalesinvoiceCtrl1', function($scope, $rootScope,sharedProperties, 
        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,purchaseObject,ngDialog, $timeout,$state) {
    
    $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

   	      $scope.purchaseInvoiceData.isSaveDraft=false;
   	      $scope.purchaseInvoiceData.printNumber=4,
	      $scope.purchaseInvoiceData.currSymbol='Inr',
	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
          	if(row.taxExem=='Y'){
          		row.isIgst=false;
          		row.isCgst=false;

          	}
              })
   	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
                 if (result.success) {
                    
                      if (result.success) {
                          console.log(result)
                          $scope.id = result.purchaseInvoiceNo1;
                           var url = $stateParams.tenantid+'/app/seasalesinvoice/mailConfim?purchaseInvoiceNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
                  $http({
                      method : 'post',
                      url : url,
                     
                  }).success(function(data) {
                	  
                	  $scope.header = data.objBean1;
                	  $scope.listdata = data.objBean1.purchaseInvoiceDetail;
                	  console.log(data);
                	  $scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
                	  
                    
                  }).error(function(data) {
                	  logger.logError("Error try again");
                  });
                        
              
                      } else {
                          if(result.message != null && result.message != ''){
                              logger.logError(result.message);
                          }else{
                          logger.logError("Error try again");
                          }
                      }
                      
                   
         
                 } else {
                     if(result.message != null && result.message != ''){
                         logger.logError(result.message);
                     }else{
                     logger.logError("Error try again");
                     }
                 }

             }).error(function(data) {
                 
             });
      
	
      $scope.cancelng = function(){
	       
	        ngDialog.close();
	        
	    }
      
    //mail Inr
      $scope.emailInrForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
          
          // $scope.purchaseInvoiceData.puchaseInvoiceDate =
			// $('#purchase_invoice_date').val();
          $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
          $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

          if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
              $scope.emailInr();
          } else {
              toaster.pop('error', "Please fill the required fields", 
                      logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
          }
      };
      
      
      $scope.emailInr = function(){
    	   var url = $stateParams.tenantid+'/app/seasalesinvoice/sendMail?purchaseInvoiceNo=' + $scope.id +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
           $http({
               method : 'post',
               url : url,
               //data : purchaseInvoiceNo1,
           }).success(function(data) {
               if (data.success == true) {                    
                   logger.logSuccess("Mail Sent Successfully");
                   ngDialog.close();
                   $state.reload();
               } else {
                    logger.logSuccess("Mail Sent Successfully");
                    ngDialog.close();
                    $state.reload();
               }
           }).error(function(data) {
                logger.logSuccess("Mail Sent Successfully");
                ngDialog.close();
                $state.reload();
           });
                 
      }
    //mail Inr Ends
});



app.controller('seasalesinvoiceCtrl', function($scope, $rootScope,sharedProperties, 
        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,purchaseObject,ngDialog, $timeout,$state) {
    $scope.purchaseInvoiceData.containerList=$scope.purchaseInvoiceData.purchaseInvoiceDetail;

	 $scope.purchaseInvoiceData.isSaveDraft=false;
	      $scope.purchaseInvoiceData.printNumber=3,
	      $scope.purchaseInvoiceData.currSymbol='Usd',
	      angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail, function(row, index) {
          	if(row.taxExem=='Y'){
          		row.isIgst=false;
          		row.isCgst=false;

          	}
              })
	      $http.post($stateParams.tenantid+'/app/seasalesinvoice/savePurInvPreview', $scope.purchaseInvoiceData).success(function(result) {
            if (result.success) {
               
                 if (result.success) {
                     console.log(result)
                      $scope.id = result.purchaseInvoiceNo1;
                      var url = $stateParams.tenantid+'/app/seasalesinvoice/mailConfim?purchaseInvoiceNo=' + result.purchaseInvoiceNo1 +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
             $http({
                 method : 'post',
                 url : url,
                
             }).success(function(data) {
           	  
           	  $scope.header = data.objBean1;
           	  $scope.listdata = data.objBean1.purchaseInvoiceDetail;
           	  
            	$scope.purchaseInvoiceData.purchaseInvoiceDetail=$scope.tempData;
           	  
               
             }).error(function(data) {
           	  logger.logError("Error try again");
             });
                   
         
                 } else {
                     if(result.message != null && result.message != ''){
                         logger.logError(result.message);
                     }else{
                     logger.logError("Error try again");
                     }
                 }
                 
              
    
            } else {
                if(result.message != null && result.message != ''){
                    logger.logError(result.message);
                }else{
                logger.logError("Error try again");
                }
            }

        }).error(function(data) {
            
        });    
	
      $scope.cancelng = function(){
	       
	        ngDialog.close();
	        
	    }
      
    //mail usd
      $scope.emailUsdForm = function(purchaseInvoiceForm,purchaseInvoiceData) {
          
          // $scope.purchaseInvoiceData.puchaseInvoiceDate =
			// $('#purchase_invoice_date').val();
          $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
          $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();

          if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
              $scope.emailUsd();
          } else {
              toaster.pop('error', "Please fill the required fields", 
                      logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
          }
      };
      
      
      $scope.emailUsd = function(){
    	  var url = $stateParams.tenantid+'/app/seasalesinvoice/sendMail?purchaseInvoiceNo=' +  $scope.id +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
          $http({
              method : 'post',
              url : url,
              //data : purchaseInvoiceNo1,
          }).success(function(data) {
              if (data.success == true) {                    
                  logger.logSuccess("Mail Sent Successfully");
                  ngDialog.close();
                  $state.reload();
              } else {
                  logger.logSuccess("Mail Sent Successfully");
                  ngDialog.close();
                  $state.reload();
              }
          }).error(function(data) {
               logger.logSuccess("Mail Sent Successfully");
               ngDialog.close();
               $state.reload();
          });    
          }
    //mail Usd Ends
});



     app.controller('purchaseInvoiceTaxCtrl', function($scope, $rootScope,sharedProperties, 
             logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,purchaseObject,ngDialog, $timeout,chargeHeadId,jobNo,partyNo) {
         
    	 $scope.rowCollection=[];
     	$http.get($stateParams.tenantid + '/app/seasalesinvoice/getTaxList?chargeHead=' + chargeHeadId + '&jobNo=' + jobNo + '&partyNo=' + partyNo).success(
     			function(response) {
     				if(response.taxList.length>0){
     					$scope.rowCollection = response.taxList;
     				}
     				else{
     					logger.logError("There are no Tax Types defined for the seleted Charge Head..");
     				}
     				
     			});
         
     	 $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	        if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }
     	    }
     });
     
     app.controller('purchaseInvoiceContainerCtrl', function($scope, $rootScope,sharedProperties, 
             logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,purchaseObject,ngDialog,
             $timeout,jobNo,partyNo, $controller) {
    	 $scope.shipperDropList=[];
    	 $scope.containerNoList=[];
    	 $scope.purchaseInvoiceData.shipper1='';
    	 $scope.selectAll1 = function(tables) {
             debugger;
             
                 angular.forEach(tables, function (value, key) {
              	   var check =value.select1;
                     if ($scope.purchaseInvoiceData.selectBox1 ==true) {
          	              value.select1=true;
          	             
                     }else if($scope.purchaseInvoiceData.selectBox1 ==false) {
                  	   value.select1=false;
                     }
                     $scope.calAmt(tables);
             });
            
            
         };
          $scope.getDropdownvalue = function() {
         
       	   $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
   				debugger
   				$scope.shipperDropList = datas.shipperSelectivityList;

   			}).error(function(data) {

   			});
       	  
          };

          $scope.getDropdownvalue();
    	 $scope.rowCollection=[];
    	 $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				
			   //$scope.conTypeList=datas.getcontypelist;
				$scope.containerNoList=datas.getcontainer;
				
			}).error(function(datas) {

			});
     	/*$http.get($stateParams.tenantid + '/app/seasalesinvoice/getContainerList?&jobNo=' + jobNo + '&partyNo=' + partyNo).success(
     			function(response) {
     				if(response.containerList.length>0){
     					$scope.purchaseInvoiceData.purchaseInvoiceDetail1 = response.containerList;
     	                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail1, function(row, rowindex)
     	                		{
     	                	row.select=false;
     	                })
     				}
     				else{
     				//s	logger.logError("There are no Tax Types defined for the seleted Charge Head..");
     				}
     				
     			});*/
    	 $http.post($stateParams.tenantid + '/app/jobOrderSea/editForSalesInv',
    			 jobNo)
			.success(
					function(data) {
						

						
						
						debugger
						$scope.joborder = data.lJobOrderBean[0];
						
						if(data.lJobOrderBean[0].service!='' && data.lJobOrderBean[0].service!=null){
							$scope.joborder.service = data.lJobOrderBean[0].service.toString();
							}
						if(data.lJobOrderBean[0].mode!='' && data.lJobOrderBean[0].mode!=null){
							$scope.joborder.mode = data.lJobOrderBean[0].mode.toString();
							}
							if(data.lJobOrderBean[0].remarks1!='' && data.lJobOrderBean[0].remarks1!=null){
							$scope.joborder.searemarks = data.lJobOrderBean[0].remarks1.toString();
							}
							$scope.joborder.remarks1='';
							if(data.lJobOrderBean[0].branch!=''&& data.lJobOrderBean[0].branch!=null)
								{
							$scope.joborder.branch = data.lJobOrderBean[0].branch.toString();
								}
							//if(data.lJobOrderBean[0].mode!=''=data.lJobOrderBean[0].mode!=null)
							//{
								$scope.joborder.mode = data.lJobOrderBean[0].mode;
							//}
						$scope.joborder.jobDate=data.lJobOrderBean[0].jobDate;
						if(data.lJobOrderBean[0].aol!=''&&data.lJobOrderBean[0].aol!=null)
							{
						$scope.joborder.aol = data.lJobOrderBean[0].aol
								.toString();
							}
						if(data.lJobOrderBean[0].aod!=''&&data.lJobOrderBean[0].aod!=null)
							{
						$scope.joborder.aod = data.lJobOrderBean[0].aod
								.toString();
							}
						if(data.lJobOrderBean[0].term!=''&&data.lJobOrderBean[0].term!=null)
							{
						$scope.joborder.term = data.lJobOrderBean[0].term
								.toString();
							}
						if(data.lJobOrderBean[0].origin!=''&&data.lJobOrderBean[0].origin!=null)
							{
						$scope.joborder.origin = data.lJobOrderBean[0].origin
								.toString();
							}
						if(data.lJobOrderBean[0].destination!=''&&data.lJobOrderBean[0].destination!=null)
							{
						$scope.joborder.destination = data.lJobOrderBean[0].destination
								.toString();
							}
						if(data.lJobOrderBean[0].customer!=''&&data.lJobOrderBean[0].customer!=null)
							{
						$scope.joborder.customer = data.lJobOrderBean[0].customer
								.toString();
							}
						if(data.lJobOrderBean[0].shipper!=''&&data.lJobOrderBean[0].shipper!=null)
							{
						$scope.joborder.shipper = data.lJobOrderBean[0].shipper
								.toString();
							}
						if (data.lJobOrderBean[0].nominatedBy != null
								&& data.lJobOrderBean[0].nominatedBy != '') {
						$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
								.toString();
						}
						if(data.lJobOrderBean[0].currency!=''&&data.lJobOrderBean[0].currency!=null)
							{
						$scope.joborder.currency = data.lJobOrderBean[0].currency
								.toString();
							}
						if(data.lJobOrderBean[0].quotationnum!=''&&data.lJobOrderBean[0].quotationnum!=null)
							{
						$scope.joborder.quotationnum = data.lJobOrderBean[0].quotationnum
						.toString();
							}
						if(data.lJobOrderBean[0].mode.toString()!=''&&data.lJobOrderBean[0].mode.toString()!=null)
							{
						$scope.joborder.mode = data.lJobOrderBean[0].mode.toString();
							}
						if(data.lJobOrderBean[0].salesType!=''&&data.lJobOrderBean[0].salesType!=null)
							{
						$scope.joborder.salesType = data.lJobOrderBean[0].salesType
								.toString();
							}
						if(data.lJobOrderBean[0].vessel!=''&&data.lJobOrderBean[0].vessel!=null)
							{
						$scope.joborder.vessel = data.lJobOrderBean[0].vessel
						.toString();
							}
						if(data.lJobOrderBean[0].consignee!=''&&data.lJobOrderBean[0].consignee!=null)
							{
						$scope.joborder.consignee = data.lJobOrderBean[0].consignee
						.toString();
							}
						if(data.lJobOrderBean[0].vendor!=''&&data.lJobOrderBean[0].vendor!=null)
							{
						$scope.joborder.vendor = data.lJobOrderBean[0].vendor
						.toString();
							}
						if (data.lJobOrderBean[0].customsBroker != null
								&& data.lJobOrderBean[0].customsBroker != '') {
						$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
						.toString();
						}
						
                        
						debugger
						for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
					
							$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHead.toString();
							$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
									.toString();
							$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
									.toString();								
							$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
									.toString();
							$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySellParty
								.toString();
						    $scope.joborder.joborderDtl[i].status = $scope.joborder.joborderDtl[i].status.toString();
						    $scope.joborder.joborderDtl[i].color = $scope.joborder.joborderDtl[i].color;

						}
						/*for (var i = 0; i < $scope.joborder.joborderDtl1.length; i++) {
							
							$scope.joborder.joborderDtl1[i].chargeHead = $scope.joborder.joborderDtl1[i].chargeHead.toString();
							$scope.joborder.joborderDtl1[i].unit = $scope.joborder.joborderDtl1[i].unit
									.toString();
							$scope.joborder.joborderDtl1[i].currency = $scope.joborder.joborderDtl1[i].currency
									.toString();
							$scope.joborder.joborderDtl1[i].paymentMode= $scope.joborder.joborderDtl1[i].paymentMode
									.toString();
							$scope.joborder.joborderDtl1[i].transactionType = $scope.joborder.joborderDtl1[i].transactionType
									.toString();
							$scope.joborder.joborderDtl1[i].buySellParty = $scope.joborder.joborderDtl1[i].buySellParty
								.toString();
						    $scope.joborder.joborderDtl1[i].status = $scope.joborder.joborderDtl1[i].status.toString();
						    $scope.joborder.joborderDtl1[i].color = $scope.joborder.joborderDtl1[i].color;

						}*/

						var buy1 =0;
						var sell=0;
						var sell1 =0;
						var amount =0;

						var total =0; 
				    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
	for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{
		

		var amount1=[];
		var amount=[];
		if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
         {
			if($scope.joborder.joborderDtl[i].transactionType =="1")
              {
				
				if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
				{
				amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
				$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

				
			
				buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
				console.log("i:"+i+" buy1:"+buy1);
				
				}
              }	
			
			else {
				if($scope.joborder.joborderDtl[i].transactionType =="2")
				{
								
								if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
								{
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

								sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:"+i+" sell1:"+sell1);
								}
				}	
			}
			
			
			

}

		$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);
		
	
}
	total =parseFloat(sell1)-parseFloat(buy1);
	
	console.log("total"+total+" sell1:"+sell1);	
	
	
	}
				    	}
				    	$scope.joborder.sell1=sell1.toFixed(2);
						$scope.joborder.buy1=buy1.toFixed(2);
						$scope.joborder.total=total.toFixed(2);
						
						debugger
					
						$scope.purchaseInvoiceData.purchaseInvoiceDetail1 = data.lJobOrderBean[0].joborderTrackingDtl;
						for (var j = 0; j < $scope.joborder.joborderDtl.length; j++) {
							for (var i = 0; i < $scope.purchaseInvoiceData.purchaseInvoiceDetail1.length; i++) {

							if($scope.joborder.joborderDtl[j].conType==$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].sizeType){
								$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].unit=$scope.joborder.joborderDtl[j].unit;
								$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].rate=$scope.joborder.joborderDtl[j].rate;
								$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].chargeHead=$scope.joborder.joborderDtl[j].chargeHead;
								$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].quantity=$scope.joborder.joborderDtl[j].quantity;
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].amount=$scope.joborder.joborderDtl[j].amount;
							}
						$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].uom = $scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].uom.toString();	
						$scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].sizeType = $scope.purchaseInvoiceData.purchaseInvoiceDetail1[i].sizeType.toString();
						
						}
						}
						
					});
         
     	 $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	        if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }
     	    }
     
     });
     
     


app.controller('seasalesViewCtrl', function($scope, $rootScope,sharedProperties, 
        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,$state,ngDialog) {

    $scope.purchaseTable = false;
    
    $scope.commodityList=[];
    $scope.invoiceList = [ {
        id : '1',
        text : 'Sales Invoice'
    },
    {
        id : '2',
        text : 'Tax Invoice'
    }
    ]
    $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data){
    	$scope.commodityList=data.commonUtilityBean;
    })
    var purchaseInvoiceNo=$stateParams.purchaseInvoiceNo;
    if(purchaseInvoiceNo == undefined || purchaseInvoiceNo == null || purchaseInvoiceNo ==""){
        $scope.edit=false;
    }
    // fetching edit details
    else{
        $scope.edit=true;
        $http.get($stateParams.tenantid+'/app/seasalesinvoice/getViewData?purInvNo='+purchaseInvoiceNo).success(function(data) {
            
        	 var totalTaxAmt=0; 
             $scope.purchaseInvoiceData = data; 
             
             for(var i=0;i< $scope.purchaseInvoiceData.purchaseInvoiceDetail.length;i++)
             { 
            	 if($scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxExem=='Y'){
            		 $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxAmount=0.0;
            		 $scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxExemption='Tax Exemption';
            	}
            	 totalTaxAmt=totalTaxAmt+$scope.purchaseInvoiceData.purchaseInvoiceDetail[i].taxAmount; } 
             $scope.purchaseInvoiceData['totaltaxAmount']=totalTaxAmt.toFixed(2);
        }).error(function(data) {
        });
    }
    
    var purchaseInvoiceNo1=$stateParams.purchaseInvoiceNo1;
    if(purchaseInvoiceNo1 == undefined || purchaseInvoiceNo1 == null || purchaseInvoiceNo1 ==""){
        $scope.edit=false;
    }
    else{
        $scope.purchaseTable = true;
        $scope.edit=true;
        
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/getViewData?purInvNo='+purchaseInvoiceNo1).success(function(data) {
            $scope.purchaseInvoiceData = data;
            
        }).error(function(data) {
        });
    }

    $scope.cancel = function() {
          $location.path($stateParams.tenantid+"/invoice/sea/seasalesinvoice/SalesInvoiceList");
    };
    
    $scope.cancel1 = function() {
        $state.go('app.reports.finance.invoiceInformation',{tenantid:$stateParams.tenantid});
    };
    
 // invoiceCancel
	$scope.deleteInvoice = function(sNo) {
		ngDialog
				.openConfirm()
				.then(
						function() {
							$http.post($stateParams.tenantid + '/app/seasalesinvoice/cancel?sNo=',+ sNo).success(function(data) {
						    logger.logSuccess('Invoice Canceled Successfully.')
						    $location.path($stateParams.tenantid+ "/invoice/sea/seasalesinvoice/SalesInvoiceList");
							}).error(function(data) {
					    });
				});
	};
    /**
	 * print PIN...
	 */
    $scope.printPurchaseInvoice= function(puchaseInvoiceNo){
    	  $scope.purchaseInvoiceData.printNumber=1,
	      $scope.purchaseInvoiceData.currSymbol='Usd'
	      var url = $stateParams.tenantid+'/app/seasalesinvoice/printfinalusdandInr?purInvNo=' + puchaseInvoiceNo +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
          var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
          wnd.print();  
     }
    $scope.printPurchaseInvoiceSgd= function(puchaseInvoiceNo){
  	  $scope.purchaseInvoiceData.printNumber=4,
	      $scope.purchaseInvoiceData.currSymbol='Sgd'
	      var url = $stateParams.tenantid+'/app/seasalesinvoice/printfinalusdandInr?purInvNo=' + puchaseInvoiceNo +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();  
   }
    $scope.printPurchaseInvoicelocal= function(puchaseInvoiceNo){
    	$scope.purchaseInvoiceData.printNumber=2,
	      $scope.purchaseInvoiceData.currSymbol='Inr'
    	var url = $stateParams.tenantid+'/app/seasalesinvoice/printfinalusdandInr?purInvNo=' + puchaseInvoiceNo +'&printNumber='+$scope.purchaseInvoiceData.printNumber+ '&currSymbol=' +$scope.purchaseInvoiceData.currSymbol;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();
    	 	  
     }
    
    $scope.quickLinkMethd=function(qulkVal){
		if(qulkVal!='Select'){
			if($scope.purchaseInvoiceData.purchaseInvoiceSno!='' && $scope.purchaseInvoiceData.purchaseInvoiceSno!=undefined){
			$http.post($stateParams.tenantid + '/app/seasalesinvoice/getQuickLinkId?category='+qulkVal+'&salesInvNo='+$scope.purchaseInvoiceData.purchaseInvoiceSno).success(function(datas) {
						if(datas.quickLinkId!=null){
							var rowid=datas.quickLinkId;
							if(qulkVal=="Job Order"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/jobOrderSea/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/jobOrderSea/view?rowid='+rowid, '_blank');	
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="HBL"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/hbl/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/hbl/view?rowid='+rowid, '_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="MBL"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/mabl/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/mabl/view?rowid='+rowid,'_blank');
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="Delivery Order"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/deliveryorder/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/deliveryorder/view?rowid='+rowid,'_blank');	
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}
							else if(qulkVal=="Purchase Invoice"){
								if(rowid !=0){
									$location.url($stateParams.tenantid+'/invoice/seapurchaseinvoice/PurchaseInvoiceView/'+rowid); 
									//$window.open('#'+$stateParams.tenantid+"/invoice/seapurchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');	
								}else{
									logger.logError("There is no "+qulkVal);
								}
							}
						} else if(datas.quickLinkIdList!=null){var quickLinkIdList=datas.quickLinkIdList;
						if(qulkVal=="HAWB"){
							$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
							//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
						}else if(qulkVal=="MAWB"){
							$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
							//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
						}else if(qulkVal=="Delivery Order"){
							$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
							//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
						}else if(qulkVal=="Sales Invoice"){ 
							$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
							//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
						}else if(qulkVal=="Purchase Invoice"){
							$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
							//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
						}
			}else{var quickLinkIdList=datas.quickLinkIdList;
			if(qulkVal=="HAWB"){
				$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
				//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
			}else if(qulkVal=="MAWB"){
				$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
				//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
			}else if(qulkVal=="Delivery Order"){
				$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
				//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
			}else if(qulkVal=="Sales Invoice"){ 
				$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
				//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
			}else if(qulkVal=="Purchase Invoice"){
				$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
				//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
			}
}
						
			})
		}
	}
	}
    
    
});


app.controller('purinvtableCtrl', function($scope,$http, $filter,logger,$timeout,$stateParams){
    
	
	 $scope.tenant = $stateParams.tenantid;
	
	
    /*$scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].companyCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(!$scope.isEdit1)
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode = '';
            // $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCode
			// = '';
        }
    });
    
    
    $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].voyageCode', function(newValue, oldValue) {
        
        if (newValue != '' && newValue != undefined) {
                $http.get($stateParams.tenantid+'/app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });*/
    
   /*
	 * $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].companyCode',
	 * function(newValue, oldValue) { if(newValue =='C0001'){
	 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAttrMandatory=true;
	 * }else{
	 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAttrMandatory=true; }
	 * });
	 */
    
    
   /* $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].accountHeadCode', function(newValue, oldValue,$stateParams) {
       
    	
    	$scope.tenant
        if (newValue != '' && newValue != undefined) {
            
			 * if($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode
			 * !='' &&
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode!=undefined &&
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode
			 * !=null){
			 
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked=false;
                // Trade Debitors
                if(newValue == '10080001'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode =true;
                    $http.get($scope.tenant+'/app/commonUtility/getonlypayer').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });                   
                    
                }
                else  if(newValue == '20010001' || newValue == '10090017'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode =true;
                    $http.get($scope.tenant+'/app/commonUtility/getonlySupplier').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });                                              
                }
                else if(newValue=='10120001' || newValue=='10070004'|| newValue=='10070002'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                    $http.get($scope.tenant+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '10070001'){
                    if($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0003')
                        $scope.currencyList = [{id:'SGD',text:'SGD'}];
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                    $http.get($scope.tenant+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010004'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                    $http.get($scope.tenant+'/app/commonUtility/getJvPartnerAccount').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010002'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                    $http.get($scope.tenant+'/app/commonUtility/getAgentList').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        }).error(function(datas) {
                    });   
                }else{
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList=[];
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=false;
                }
            
               
				 * if(newValue.substring(0, 4)=='1000'){
				 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset=true;
				 * $http.get($stateParams.tenantid+'/app/commonUtility/getassetList').success(function(datas) {
				 * 
				 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].assetList =
				 * datas; }).error(function(datas) { }); }
				 
                
                
                if(newValue.substring(0, 4)=='1000'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset=true;
                    $http.get($scope.tenant+'/app/commonUtility/getassetList').success(function(datas) {
                         ;
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].assetList = datas;
                        }).error(function(datas) {
                    });
                }
                
                
                
                $http.get($scope.tenant+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if((!$scope.edit || $scope.isOnChange) && !$scope.isEdit1){
                    
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].voyageCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].employeeCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].portCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].portSequence='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].departmentCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].agentCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].countryCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].customerCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].supplierCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].designationCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].costCenter='';
                // commented for inter-company transaction
                 $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode=''; 
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].quantityGO='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].quantityFO='';
                }
                
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyage=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVessel=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isService=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPort=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgent=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter=false;
                // commented for inter-company transaction
                 $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany=false; 
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGO=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFO=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequence=false;
                
                // code added for mandatory
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan=false;
             
                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList, function(row, rowindex) {
                    
                    if(row.attributeName == "Voyage"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyage=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode != 'C0002'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan=true;
                        }
                    }else if(row.attributeName == "Vessel"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVessel=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode != 'C0002'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan=true;
                        }
                    }else if(row.attributeName == "Service"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isService=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode != 'C0002'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan=true;
                        }
                    }else if(row.attributeName == "Employee"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan=true;
                        }
                    }else if(row.attributeName == "Port"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPort=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan=true;
                        }
                    }else if(row.attributeName == "Department"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan=true;
                        }
                    }else if(row.attributeName == "Agent"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgent=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan=true;
                        }
                    }else if(row.attributeName == "Location"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan=true;
                        }
                    }else if(row.attributeName == "Customer"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan=true;
                        }
                    }else if(row.attributeName == "Supplier"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan=true;
                        }
                    }else if(row.attributeName == "Designation"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan=true;
                        }
                    }else if(row.attributeName == "Cost Center"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan=true;
                        }
                    }else if(row.attributeName == "Company"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompanyMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompanyMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGO=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFO=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan=true;
                        }
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequence=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            if($scope.isOwner)
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan=false;
                            else
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan=true;
                        }
                    }else if(row.attributeName == "From Date"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isFromDate=true;
                    }else if(row.attributeName == "To Date"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isToDate=true;
                    }
                    });
                }).error(function(datas) {
            });    
                
                $timeout(function() {
                    var len=$scope.$index;
                    if( $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isFromDate==true){
                    $('#toDate' + len).datetimepicker({
                        format : 'DD/MM/YYYY',
                        pickTime: false
                    })
                    $('#fromDate' + len).datetimepicker({
                        format : 'DD/MM/YYYY',
                        pickTime: false
                    })
                   
                    
                    $("#toDate" + len).on("dp.change", function(e) {
                        var from = $("#txtfromDate" + len).val();
                        var date = from.split("/");
                        from = new Date(date[2], date[1] - 1, date[0]);
                        var to = e.date._d;
                        if (to < from) {
                            logger.logError("Please Select Valid To greater then  Valid From");
                            $("#txttoDate" + len).val('')
                        }else{
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toDate = $("#txttoDate" + len).val();
                        }

                    });
                    
                    $("#fromDate" + len).on("dp.change", function(e) {
                        var to = $("#txttoDate" + len).val();
                        var date = to.split("/");
                        to = new Date(date[2], date[1] - 1, date[0]);

                        var from = e.date._d;
                        if (to < from) {
                            logger.logError("Please Select Valid From less then  Valid To");
                            $("#txtfromDate" + len).val('')
                        }else{
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromDate = $("#txtfromDate" + len).val(); 
                        }

                    });
                    }
                    }, 500);
                
            if($scope.$index !=0){
                angular.forEach($scope.accountList, function(value, indexs) {
                    if(newValue == value.accountHeadCode){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency=value.currency;
                        // get exchange rate for currency
                        $http.get($scope.tenant+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+value.currency).success(function(data) {
                            // $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=data;
                            if(data.success){
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromCurrency=data.fromCurrency;
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toCurrency=data.toCurrency;
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=data.exchangeRate;    
                            }else{
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate='';
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromCurrency='';
                                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toCurrency='';
                            }
                        }).error(function(data) {
                        });                        
                    }
                });
            } 
           
			 * }else{  if(
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode
			 * !='') logger.logError("Please select Company First");
			 * 
			 * $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode=''; }
			 

        }else{
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency='';
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate='';
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = [];
        }
        });
    
     Voyage On Change............... 
    $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].voyageCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            angular.forEach($scope.voyageList, function(value, indexs) {
                if(newValue == value.voyageCode){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode=value.vesselCode;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode=value.sectorCode;
                }
            });
        }else{
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode='';
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode='';
        }
    });    
    
    
    $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].subAccountCode', function(newValue, oldValue,$stateParams) {
        if (newValue != '' && newValue != undefined) {
            if($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode == '20010001' || 
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode=='10120001' ||
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].accountHeadCode=='20010002'){
                $http.get($stateParams.tenantid+'/app/commonUtility/getSupplierCurrency?supplierCode='+newValue).success(function(data) {
                    if(data.success){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency=data.currencyCode;
                        if(data.isAgent =='Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001')
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked=true;
                        else
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked=false;
                    }else{
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked=false;
                    }
                }).error(function(data) {
                });
            }else{
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked=false;
            }
        }else{
            
        }
    }); */  
    
    /*$scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].currency', function(newValue, oldValue,$stateParams) {
        if (newValue != '' && newValue != undefined) {
            // get exchange rate for currency
             $http.get('app/commonUtility/getDefaultExchangeRate?currencyCode='+newValue).success(function(data) 
            $http.get($scope.tenant+'/app/commonUtility/getExchangeRateWithCurrency?currencyCode='+newValue).success(function(data){
                if(data.success){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].fromCurrency=data.fromCurrency;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].toCurrency=data.toCurrency;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate=data.exchangeRate;
                    
                    $scope.amountCalculationexchange(data.exchangeRate,[$scope.$index],$scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index]);
                }else{
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate='';
                }                
            }).error(function(data) {
            });
        }
    });*/
});


app.controller('purinvtableCtrlView', function($scope,$http, $filter,logger,$stateParams){
	$scope.tenant =  $stateParams.tenantid;

    
    /*$scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].voyageCode', function(newValue, oldValue) {
        
        if (newValue != '' && newValue != undefined) {
                $http.get($stateParams.tenantid+'/app/commonUtility/getVesselService?voyageCode='+newValue).success(function(datas) {
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode=datas.vesselCode;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode=datas.sectorCode;
                    }).error(function(datas) {
                });
       
        }
    });
    
    $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].accountHeadCode', function(newValue, oldValue) {
    	
        if (newValue != '' && newValue != undefined) {
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCurrencyBlocked=false;
                if(newValue == '10080001'){
                    $http.get($scope.tenant+'/app/commonUtility/getonlypayer').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode =true;
                        }).error(function(datas) {
                    });
                }else if(newValue=='10120001'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getSubAccountCodeListTradeCreditors').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }
                else  if(newValue == '20010001' || newValue == '10090017'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode =true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getonlySupplier').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });                                              
                }               
                else if(newValue == '10070001'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getStaffListForAdvances').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else if(newValue == '20010004'){
                    $http.get($stateParams.tenantid+'/app/commonUtility/getJvPartnerAccount').success(function(datas) {
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = datas;
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=true;
                        }).error(function(datas) {
                    });   
                }else{
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList=[];
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSubAccountCode=false;
                }
            
                if(newValue.substring(0, 4)=='1000'){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAsset=true;
                    $http.get($stateParams.tenantid+'/app/commonUtility/getassetList').success(function(datas) {
                        
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].assetList = datas;
                        }).error(function(datas) {
                    });
                }
                
                $http.get($stateParams.tenantid+'/app/commonUtility/getAttributesList?accountCode='+newValue).success(function(datas) {
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList=datas;
                if(newValue==oldValue){
                    $scope.isOnChange =false;
                }else{
                    $scope.isOnChange =true;
                }
                if(!$scope.edit || $scope.isOnChange){
                    
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].voyageCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].employeeCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].portCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].portSequence='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].departmentCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].agentCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].countryCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].customerCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].supplierCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].designationCode='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].costCenter='';
                // commented for inter-company transaction
                 $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode=''; 
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].quantityGO='';
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].quantityFO='';
                }
                
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyage=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVessel=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isService=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPort=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgent=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter=false;
                // commented for inter-company transaction
                 $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany=false; 
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGO=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFO=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequence=false;
                
                // code added for mandatory
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan=false;
                $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan=false;
             
                angular.forEach($scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].attributeList, function(row, rowindex) {
                    
                    if(row.attributeName == "Voyage"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyage=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVoyageMan=true;
                        }
                    }else if(row.attributeName == "Vessel"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVessel=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isVesselMan=true;
                        }
                    }else if(row.attributeName == "Service"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isService=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isServiceMan=true;
                        }
                    }else if(row.attributeName == "Employee"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployee=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isEmployeeMan=true;
                        }
                    }else if(row.attributeName == "Port"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPort=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortMan=true;
                        }
                    }else if(row.attributeName == "Department"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartment=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDepartmentMan=true;
                        }
                    }else if(row.attributeName == "Agent"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgent=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isAgentMan=true;
                        }
                    }else if(row.attributeName == "Location"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocation=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isLocationMan=true;
                        }
                    }else if(row.attributeName == "Customer"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomer=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCustomerMan=true;
                        }
                    }else if(row.attributeName == "Supplier"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplier=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isSupplierMan=true;
                        }
                    }else if(row.attributeName == "Designation"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignation=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isDesignationMan=true;
                        }
                    }else if(row.attributeName == "Cost Center"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenter=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCostCenterMan=true;
                        }
                    }else if(row.attributeName == "Company"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompany=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isCompanyMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) GO"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGO=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityGOMan=true;
                        }
                    }else if(row.attributeName == "Quantity (MT) FO"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFO=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isQuantityFOMan=true;
                        }
                    }else if(row.attributeName == "Port with Sequence"){
                        $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequence=true;
                        if(row.isMandatory == 'Y' && $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].companyCode == 'C0001'){
                            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].isPortSequenceMan=true;
                        }
                    }
                    });
                }).error(function(datas) {
            });             
                     
        }else{
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].currency='';
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].exchangeRate='';
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].subAccountCodeList = [];
        }
    });
    
     Voyage On Change............... 
    $scope.$watch('purchaseInvoiceData.purchaseInvoiceDetail[trIndex].voyageCode', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            angular.forEach($scope.voyageList, function(value, indexs) {
                if(newValue == value.voyageCode){
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode=value.vesselCode;
                    $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode=value.sectorCode;
                }
            });
        }else{
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].vesselCode='';
            $scope.purchaseInvoiceData.purchaseInvoiceDetail[$scope.$index].sectorCode='';
        }
    }); */   
    
     
    
});

app.controller('jobtableCtrl', function($scope,$http, $filter,logger,$stateParams,$location){

$scope.tenant =  $stateParams.tenantid;
$scope.shipperDropList=[];
$scope.purchaseInvoiceData.shipper1='';

 $scope.getDropdownvalue = function() {

	   $http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
			debugger
			$scope.shipperDropList = datas.shipperSelectivityList;

		}).error(function(data) {

		});
	  
 };

 $scope.getDropdownvalue();
debugger;
var jobId =   parseInt($location.search().rowid) ;
if(jobId != '' && jobId != null){
   $scope.isEdit=true;
}
else{
   $scope.isEdit=false;
}
$scope.$watch('joborder.joborderDtl[trIndex].transactionType', function(newValue, oldValue) {
debugger;
    if (newValue != '' && newValue != undefined) {
    	
		var buy1 =0;
		var sell=0;
		var sell1 =0;
		var amount =0;

		var total =0; 
    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
{
for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
{


var amount1=[];
var amount=[];
if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
{
if($scope.joborder.joborderDtl[i].transactionType =="1")
{

if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
{
amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);



buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
console.log("i:"+i+" buy1:"+buy1);

}
}	

else {
if($scope.joborder.joborderDtl[i].transactionType =="2")
{
				
				if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
				{
				amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
				$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

				sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
				console.log("i:"+i+" sell1:"+sell1);
				}
}	
}




}

$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);


}
total =parseFloat(sell1)-parseFloat(buy1);

console.log("total"+total+" sell1:"+sell1);	


}
    	}
    	$scope.joborder.sell1=sell1.toFixed(2);
		$scope.joborder.buy1=buy1.toFixed(2);
		$scope.joborder.total=total.toFixed(2);
		
		$scope.joborder.sell2=sell1.toFixed(2);
		$scope.joborder.buy2=buy1.toFixed(2);
		$scope.joborder.total2=total.toFixed(2);
		
		
		var id = newValue;
		/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			console.log(datas);				
			 $scope.serviceParnrDropList=datas.serviceParnrList;
		  
		}).error(function(data) {

		});*/
		
    
    }  
    });
//calculate debit credit
$scope.$watch('joborder.joborderDtl1[trIndex].transactionType', function(newValue, oldValue) {
	   debugger;
	        if (newValue != '' && newValue != undefined) {
	        	
				var buy1 =0;
				var sell=0;
				var sell1 =0;
				var amount =0;

				var total =0; 
		    	if($scope.joborder.joborderDtl1.length != null ||$scope.joborder.joborderDtl1.length != undefined ||$scope.joborder.joborderDtl1.length != "" ||$scope.joborder.joborderDtl1.length != ''){
	{
	for( var i=0;i<=$scope.joborder.joborderDtl1.length-1;i++)
	{


	var amount1=[];
	var amount=[];
	if(($scope.joborder.joborderDtl1[i].transactionType != null ) || ($scope.joborder.joborderDtl1[i].transactionType != undefined ) ||($scope.joborder.joborderDtl1[i].transactionType != "" ) ||($scope.joborder.joborderDtl1[i].transactionType != '' ))
	{
	if($scope.joborder.joborderDtl1[i].transactionType =="1")
	{
		
		if(($scope.joborder.joborderDtl1[i].quantity  != null || $scope.joborder.joborderDtl1[i].quantity != undefined ||$scope.joborder.joborderDtl1[i].quantity !="" ||$scope.joborder.joborderDtl1[i].quantity != '') &&  ($scope.joborder.joborderDtl1[i].rate  != null || $scope.joborder.joborderDtl1[i].rate != undefined ||$scope.joborder.joborderDtl1[i].rate != " " ||$scope.joborder.joborderDtl1[i].rate != '') && ($scope.joborder.joborderDtl1[i].exRate  != null || $scope.joborder.joborderDtl1[i].exRate == undefined ||$scope.joborder.joborderDtl1[i].exRate !="" ||$scope.joborder.joborderDtl1[i].exRate != '') )
		{
		amount1[i] = (parseFloat(($scope.joborder.joborderDtl1[i].quantity)) * parseFloat(($scope.joborder.joborderDtl1[i].rate))*parseFloat(($scope.joborder.joborderDtl1[i].exRate)));
		$scope.joborder.joborderDtl1[i].amount=parseFloat(amount1[i]);

		

		buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl1[i].amount);
		console.log("i:"+i+" buy1:"+buy1);
		
		}
	}	

	else {
		if($scope.joborder.joborderDtl1[i].transactionType =="2")
		{
						
						if(($scope.joborder.joborderDtl1[i].quantity  != null || $scope.joborder.joborderDtl1[i].quantity != undefined ||$scope.joborder.joborderDtl1[i].quantity !="" ||$scope.joborder.joborderDtl1[i].quantity != '') &&  ($scope.joborder.joborderDtl1[i].rate  != null || $scope.joborder.joborderDtl1[i].rate != undefined ||$scope.joborder.joborderDtl1[i].rate != " " ||$scope.joborder.joborderDtl1[i].rate != '') && ($scope.joborder.joborderDtl1[i].exRate  != null || $scope.joborder.joborderDtl1[i].exRate == undefined ||$scope.joborder.joborderDtl1[i].exRate !="" ||$scope.joborder.joborderDtl1[i].exRate != '') )
						{
						amount1[i] = (parseFloat(($scope.joborder.joborderDtl1[i].quantity)) * parseFloat(($scope.joborder.joborderDtl1[i].rate))*parseFloat(($scope.joborder.joborderDtl1[i].exRate)));
						$scope.joborder.joborderDtl1[i].amount=parseFloat(amount1[i]);

						sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl1[i].amount);
						console.log("i:"+i+" sell1:"+sell1);
						}
		}	
	}




	}

	$scope.joborder.joborderDtl1[i].amount=parseFloat(amount1[i]).toFixed(2);


	}
	total =parseFloat(sell1)-parseFloat(buy1);

	console.log("total"+total+" sell1:"+sell1);	


	}
		    	}
		    	$scope.joborder.sell2=parseFloat(sell1.toFixed(2)) + parseFloat($scope.joborder.sell1);
				$scope.joborder.buy2=parseFloat(buy1.toFixed(2)) + parseFloat($scope.joborder.buy1);
				$scope.joborder.total2=parseFloat(total.toFixed(2)) + parseFloat($scope.joborder.total);
			

				var id = newValue;
				/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
					console.log(datas);				
					 $scope.serviceParnrDropList=datas.serviceParnrList;
				  
				}).error(function(data) {

				});*/
				
	        
	        }  
	         });
//end calculate debit credit


 var defaultCurrency1 = '';
 var  fromCurrency1='';
 var toCurrency1='';

$scope.$watch('joborder.joborderDtl[trIndex].currency', function(newValue, oldValue) {
	if (newValue != '' && newValue != undefined) {
	    
	    $http.get($stateParams.tenantid+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
		.success(
				function(data) {
					debugger
				/*	if(!$scope.isEdit){*/
						$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
				/*	}*/
					
				/*	defaultCurrency1 = data.defaultCurrency;
					fromCurrency1=data.fromCurrency;
					toCurrency1=data.toCurrency;
					$scope.checkExRate($scope.joborder.joborderDtl[$scope.trIndex].exRate,$scope.trIndex);
					$scope.ratevalues();*/
				});
	}
	
});

$scope.ratevalues = function() {
	var buy1 = 0;
	var sell = 0;
	var sell1 = 0;
	var amount = 0;

	var total = 0;
	if ($scope.joborder.joborderDtl.length != null
			|| $scope.joborder.joborderDtl.length != undefined
			|| $scope.joborder.joborderDtl.length != ""
			|| $scope.joborder.joborderDtl.length != '') {
		{
			for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

				var amount1 = [];
				var amount = [];
				if (($scope.joborder.joborderDtl[i].transactionType != null)
						|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
						|| ($scope.joborder.joborderDtl[i].transactionType != "")
						|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
					if ($scope.joborder.joborderDtl[i].transactionType == "1") {

						if (($scope.joborder.joborderDtl[i].quantity != null
								|| $scope.joborder.joborderDtl[i].quantity != undefined
								|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
								&& ($scope.joborder.joborderDtl[i].rate != null
										|| $scope.joborder.joborderDtl[i].rate != undefined
										|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
								&& ($scope.joborder.joborderDtl[i].exRate != null
										|| $scope.joborder.joborderDtl[i].exRate == undefined
										|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
							amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
									* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
							$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

							buy1 = parseFloat(buy1)
									+ parseFloat($scope.joborder.joborderDtl[i].amount);
							console.log("i:" + i + " buy1:"
									+ buy1);

						}
					}

					else {
						if ($scope.joborder.joborderDtl[i].transactionType == "2") {

							if (($scope.joborder.joborderDtl[i].quantity != null
									|| $scope.joborder.joborderDtl[i].quantity != undefined
									|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
									&& ($scope.joborder.joborderDtl[i].rate != null
											|| $scope.joborder.joborderDtl[i].rate != undefined
											|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
									&& ($scope.joborder.joborderDtl[i].exRate != null
											|| $scope.joborder.joborderDtl[i].exRate == undefined
											|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
										* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

								sell1 = parseFloat(sell1)
										+ parseFloat($scope.joborder.joborderDtl[i].amount);
								console
										.log("i:" + i
												+ " sell1:"
												+ sell1);
							}
						}
					}

				}

				$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

			}
			total = parseFloat(sell1) - parseFloat(buy1);

			console
					.log("total" + total + " sell1:"
							+ sell1);

		}
	}
	$scope.joborder.sell1 = sell1.toFixed(2);
	$scope.joborder.buy1 = buy1.toFixed(2);
	$scope.joborder.total = total.toFixed(2);
	
	$scope.joborder.sell2 = sell1.toFixed(2);
	$scope.joborder.buy2 = buy1.toFixed(2);
	$scope.joborder.total2 = total.toFixed(2);

}

$scope.checkExRate = function(exRate,trIndex){
	if(exRate >= fromCurrency1 && exRate <= toCurrency1){
		
	}
	else{
		//logger.logError("Exchange Rate Between "+fromCurrency1+ " and " +toCurrency1);
		$scope.joborder.joborderDtl[trIndex].exRate ='';
	}
}

$scope.CheckExRateDtl = function(currecny,index){
	if (currecny != '' && currecny != undefined) {
    
    $http
	.get(
			$stateParams.tenantid
					+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
	.success(
			function(data) {
				debugger
				/*if(!$scope.isEdit){
					$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
				}*/
				
				defaultCurrency1 = data.defaultCurrency;
				fromCurrency1=data.fromCurrency;
				toCurrency1=data.toCurrency;
				$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
				$scope.ratevalues();
			});
}
}

	
    $scope.$watchCollection('[joborder.joborderTrackingDtl[trIndex].sizeType,joborder.joborderDtl[trIndex].unit,joborder.joborderDtl[trIndex].conType]',function(newValue, oldValue) {
	   
	for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
	{
 		var grossqty=0;
		if($scope.joborder.joborderDtl[i].unit==2 || $scope.joborder.joborderDtl[i].unit==3){
   
			angular.forEach($scope.joborder.joborderTrackingDtl, function(value, key) {
        		if(value.sizeType==$scope.joborder.joborderDtl[i].conType){
        			
        			grossqty=grossqty+value.grossWeight;
        			
        		}
        	})
        	
        	
        	$scope.joborder.joborderDtl[i].quantity=grossqty;
    		
    		
    	}
		
	 }


});
});
		
