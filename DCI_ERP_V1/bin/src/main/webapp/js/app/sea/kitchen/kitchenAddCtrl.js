'use strict';

app.controller('kitchenAddCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
        utilsService,$state,sharedProperties,$window,$stateParams,toaster,validationService,$controller) {        
        $scope.localDtl=[];
        $scope.isEdit = false;
        var d=new Date();

        var year=d.getFullYear();
        var month=d.getMonth()+1;
        if (month<10){
        month="0" + month;
        };
        var day=d.getDate();
        $scope.date=day + "/" + month + "/" + year;
        $scope.local = {
                requisitionDate : '',
                returnDate : '',
                employeeId : '',
            //    employeeName : '',
             //   requisitionType : '',
            //    ItemDescription :'',
            //    designationName : '',
                costcenter :'',
              //  sourceLocationName : '',
               // destinationLocationName : '',
                sourceLocation : '',
                destinationLocation : '',
              //  designationId : '',
                costcenter :'',
                companyId :'',
                remarks:'',
                            lcNo:'',
                            agent : '',
                            port : '',
                            surcharge:'',
                            fromDate : '',
                            basis :'Type',
                            toDate : '',
                            localDtl : [{slabRate :[],type:'Import'}],
                            localDtl1 : [{slabRate :[],type:'Import'}]
                        }

            $scope.tempLocalDtl = {
             //   itemId:'',
                uom:'',
                description:'',
                itemCategory:'',
                berth : '',
               // itemdescription:'',
                eddDate :'',
                surcharge:'',
                containerType : '',
                hazardous : '',
                stuffing: '',
                currency: '',
                amount: '',
                amountline: '',
                itemName:'',
                description:'',
                quantity:'',
                //select : false,
                slabRate :[{
                    itemName:'',
                    description:'',
                    quantity:''
                }]
            }   
        
        $scope.tempLocalDtl1 = {
                itemName:'',
                description:'',
                quantity:'',
               // select : false,
            }   
        
        $scope.slabRate = {
                itemName:'',
                description:'',
                quantity:''
         
        
            }

       $scope.addCredRow = function(index) {
            console.log($scope.local.localDtl[0].itemName);
          var tmp=angular.copy($scope.tempLocalDtl);
           $scope.local.localDtl.push(tmp);

    }

    $scope.removeCredRow =function(){
        ngDialog.openConfirm().then(function() {
            var tmpDelList = [];
            for(var i=$scope.local.localDtl.length-1;i>=0;i--){
                if($scope.local.localDtl[i].select==true){
                    tmpDelList.push($scope.local.localDtl[i]);
                    $scope.local.localDtl.splice(i, 1);
                }
            }
        })
    }

    $scope.addCredRow1 = function(index) {
        console.log($scope.local.localDtl[0].itemName);
          var tmp=angular.copy($scope.tempLocalDtl);
           $scope.local.localDtl1.push(tmp);

    }

    $scope.removeCredRow1 =function(){
        ngDialog.openConfirm().then(function() {
            var tmpDelList = [];
            for(var i=$scope.local.localDtl1.length-1;i>=0;i--){
                if($scope.local.localDtl1[i].select==true){
                    tmpDelList.push($scope.local.localDtl1[i]);
                    $scope.local.localDtl1.splice(i, 1);
                }
            }
        })
    }

    $scope.addSlab = function(row,index) {
        debugger
        var blcntrinnerDtl = {
                from:'',
                to:'',
                rateDay:''
        }
        row.slabRate.push(blcntrinnerDtl);
    }


    var userId="";
    $scope.getDropdownvalue = function() {

        $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
            $scope.parentLocationList = datas;

          $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas) {

            $scope.employeeList = datas.employeeList;
            $scope.locationList = datas.locationList;
            $scope.itemList = datas.itemList;
            $scope.destLocationList = datas.destLocationList;
            $scope.costList = datas.costList;
            console.log("$scope.employeeList");
            console.log($scope.employeeList);
             userId=datas.userId;

             //$scope.sessionName(userId);
             if (rowId == undefined || rowId == null || rowId == "") {
                 $scope.isEdit = false;

             } else {

                 $scope.isEdit = true;
                 $http.post('app/master/kitchen/edit', rowId).success(function(result) {
                     console.log(result);
                     $scope.consignmentRequestData.rowId = result.headerData.rowId;
                     $scope.consignmentRequestData.requisitionNumber = result.headerData.requisitionNumber;
                     $scope.consignmentRequestData.requisitionDate = result.headerData.requisitionDate;
                     $scope.consignmentRequestData.employeeId = result.headerData.employeeId;
                     $scope.consignmentRequestData.designationName = result.headerData.designationName;
                     $scope.consignmentRequestData.requisitionType = result.headerData.requisitionType;
                     $scope.consignmentRequestData.returnDate = result.headerData.returnDate;
                     $scope.consignmentRequestData.costcenter = result.headerData.costcenter;
                     $scope.consignmentRequestData.requisitionStatus = result.headerData.requisitionStatus;
                     $scope.consignmentRequestData.requisitionStatusName = result.headerData.requisitionStatusName;
                     $scope.consignmentRequestData.sourceLocation = parseInt(result.headerData.sourceLocation);
                     $scope.consignmentRequestData.destinationLocation = parseInt(result.headerData.destinationLocation);
                     $scope.consignmentRequestData.companyId  =result.headerData.companyId;
                     $scope.consignmentRequestData.tables[0].consignmentReqRow = result.subData;
                     rowCount = $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
                     
                     var obj = $filter('filter')($scope.parentLocationList, {
                         id : result.headerData.sourceLocation
                     });

                 }).error(function(data) {

                 });
             }
           }).error(function(data) {

        });
        });

        /*$http.get('app/commonUtility/getCompanyList').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });*/
        $http.get('app/commonUtility/getCompanyListPurchase').success(function(datas) {
            $scope.companyList = datas;
            }).error(function(datas) {
        });
        
    }

    $scope.getDropdownvalue();
    var userName="";
    var  designationName="";
/*    $scope.sessionName=function(userId){
         angular.forEach($scope.employeeList,function(value,key){
             if(userId == value.employeeId){
                userName = value.employeeId;
                designationName =value.designationName;
            }
            $scope.consignmentRequestData.employeeId=userName;
            $scope.admin = userName;
            $scope.consignmentRequestData.designationName = designationName;
            $scope.name = designationName;
                });
     }*/
/*    if(newValue!=undefined && newValue!='' && newValue!=null){
    $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
        var data = response.itemData;
        $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemName = data.itemName;
        $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemDesc = data.itemDesc;
        $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemCategoryName = data.itemCategoryName;
        $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].uomName = data.uomName;

    });
    }*/
    
    $scope.$watch('tempLocalDtl.itemId', function(newValue, oldValue) {
        if(newValue!=undefined && newValue!='' && newValue!=null){
        $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
            var data = response.itemData;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemName = data.itemName;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemDesc = data.itemDesc;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemCategoryName = data.itemCategoryName;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].uomName = data.uomName;

        });
        
        /*if(newValue!=undefined && newValue!=''){
            var length=  $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
           for(var i=0;i<length;i++){
                  for(var j=0;j<length;j++){
                      if(i!=j){
                          if($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!=undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!=null && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!='' &&
                            $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!=undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!=null && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!='' ){
                          if($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId ==$scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId){
                              logger.logError("Item Name already added");
                              $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemId='';
                              return false;
                          }
                          }
                      }
                  }
              }
         
          }*/
        }
        
         });  
    
    
    
    $scope.$watchCollection('[tempLocalDtl.itemId,tempLocalDtl.itemdescription]', function(newValue, oldValue) {
        if(newValue!=undefined && newValue!='' && newValue!=null){
        $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
            /*var data = response.itemData;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemName = data.itemName;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemDesc = data.itemDesc;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemCategoryName = data.itemCategoryName;
            $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].uomName = data.uomName;*/

        });
        
        if(newValue!=undefined && newValue!=''){
            var length=  $scope.consignmentRequestData.tables[0].consignmentReqRow.length;
           for(var i=0;i<length;i++){
                  for(var j=0;j<length;j++){
                      if(i!=j){
                          if($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!=undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!=null && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId!='' &&
                            $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!=undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!=null && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId!='' &&
                            $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemdescription!=undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemdescription!=null && $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemdescription!='' &&
                            $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemdescription!=undefined && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemdescription!=null && $scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemdescription!='' ){
                          if($scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemId ==$scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemId &&
                             $scope.consignmentRequestData.tables[0].consignmentReqRow[i].itemdescription ==$scope.consignmentRequestData.tables[0].consignmentReqRow[j].itemdescription){
                              logger.logError("Item Name already added");
                              $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemId='';
                              $scope.consignmentRequestData.tables[0].consignmentReqRow[$scope.$index].itemdescription='';
                              return false;
                          }
                          }
                      }
                  }
              }
         
          }
        }
        
        });
    

    $scope.removeSlab = function(row,bTrIndex) {
         var table=[];
         for(var i=0;i< row.slabRate.length;i++){
             if(row.slabRate[i].select){
                 
             }
             else{
                 table.push(row.slabRate[i]);
             }
         }
         row.slabRate=[];
         row.slabRate=table;
    }




    $http.get($stateParams.tenantid+ '/api/localcharges/getlcNo').success(function(data) {
        console.log(data);
    $scope.local.lcNo = data.lcNo;
    });
    // Dropdown for Selectivity
    /*$http.post($stateParams.tenantid+ '/api/containerOnHire/dropDownList').success(function(data) {

                        $scope.containerType = data.listContainerTypeList;

                    });*/

    $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {

          $scope.containerType=datas.getcontypelist;
          $scope.containerSizeList=datas.containerSizeList;
        
        }).error(function(datas) {

        });
    $http.post($stateParams.tenantid+ '/app/localcharges/dropDown').success(function(data) {

        $scope.dockList = data.getdocklist;
        $scope.berthList = data.getberthlist;
          $scope.surchargeList=data.getsurchargelist    ;
          $scope.agentList=data.getagencylist   ;
          $scope.stuffList=data.getstufflist;
          $scope.surchargelistTHC= data.getsurchargeListthc;      

    });


    //dropdown




    $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
        
          $scope.currencyList=datas.getcurrencylist ;

        //logger.logSuccess('Mail Sent Successfully!')


    });


    $scope.showSlabPopup = function() {
        
                      ngDialog.close();
                      ngDialog.open({
                          template : 'views/master/localcharge/slabPopUp',
                          scope : $scope,
                          closeByEscape: true
                });
                }


        

      $scope.getDropdownvalue = function() {
            
            $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
              $scope.portlist =datas.getportlist;
        }).error(function(datas) {

        });
         
            $http.get($stateParams.tenantid+'/api/vesselsailing/vessellist').success(function(datas) {
                $scope.vessellist = datas;
            }).error(function(datas) {
            });

        }
        $scope.getDropdownvalue();

        //date validation
        $scope.$watchCollection('[ local.fromDate]',function(newValue, oldValue) {
            if ($scope.local.toDate!= '') {
                var frmDate = $scope.local.fromDate;
                var toDate = $scope.local.toDate;
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
                if ( frmDate>toDate ) {
                    logger
                            .logError(" From Date should  be lesser than To Date");
                    $scope.local.fromDate = "";
                }
            }
        });
        $scope.$watchCollection('[ local.toDate]',function(newValue, oldValue) {
                            if ($scope.local.fromDate != '') {
                                var frmDate = $scope.local.fromDate;
                                var toDate = $scope.local.toDate;
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
                                if (toDate <frmDate) {
                                    logger.logError(" To Date should  be greater than From Date");
                                    $scope.local.toDate = "";
                                }
                            }
                        });
    
        
        //publish
     $scope.Publish = function(localForm, local) {
            $scope.local.rowId = $location.search().rowId;
            $http.post('app/master/kitchen/publish',local).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Published Successfully");
                   // $scope.getEducationNotificationList();
                    $state.go('app.sea.kitchen.list');

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }
        $scope.Reject = function(localForm, local) {
            $scope.local.rowId = $location.search().rowId;

            $http.post('app/hospital/purchase/WorkOrderApproval/reject' , local).success(function(response) {
                if (response.success == true) {
                    logger.logSuccess("Rejected Successfully");
                  //  $scope.getEducationNotificationList();
                    $state.go('app.hospital.purchase.WorkOrderApproval.list');

                } else {
                    logger.logError("Sorry Some Error occurred");

                }
            });
        }
        
        
        module.registerController('outItemDetailCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
            $scope.$watch('local.localDtl[trIndex].itemName', function(newValue, oldValue) {
                if(newValue!=undefined && newValue!='' && newValue!=null){
                $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
                    var data = response.itemData;
                    $scope.local.localDtl[$scope.$index].itemCategory = data.itemCategoryName;
                    $scope.local.localDtl[$scope.$index].uom = data.uomName;
                    if($scope.isEdit == false){
                    $scope.local.localDtl[$scope.$index].description = data.itemDesc;
                   
                }
                });
                }                
            });  
            $scope.$watch('local.localDtl1[trIndex].itemName', function(newValue, oldValue) {
                if(newValue!=undefined && newValue!='' && newValue!=null){
                $http.post("app/hospital/purchase/consignmentRequest/itemList", newValue).success(function(response) {
                    var data = response.itemData;
                    
                    $scope.local.localDtl1[$scope.$index].itemCategory = data.itemCategoryName;
                    $scope.local.localDtl1[$scope.$index].uom = data.uomName;
                    
                    if($scope.isEdit == false){
                        $scope.local.localDtl1[$scope.$index].description = data.itemDesc;

                    }

                });
                }                
            }); 
        });

        
        
        
        //save
    $scope.save = function(localForm,local) {
       if (new validationService().checkFormValidity($scope.localForm)) {
    //  $scope.container.containerDtl=$scope.rowCollection;
            $http.post('app/master/kitchen/save',local).success(function(data) {
                console.log("data" + data);
                if (data.isSuccess) {
                    logger.logSuccess("Saved successfully!");
                    $state.go('app.sea.kitchen.list');
                } else {
                    logger.logError("Error!!");
                }
            }).error(function(result) {
                console.log("data" + data);
            });
        } else {
           toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.localForm.$validationSummary), 555000, 'trustedHtml');
       }
        
     };
     
    //Fetch Values
     $scope.isEdit = false;
     var rowId = $location.search().rowId;
     if (rowId == undefined) {

     } else {

         $http.get('app/master/kitchen/edit?rowId=' +rowId).success(function(result) {

             if (result.isEdit == false) {
                 logger.logError("Please Try Again");
             } else {

                 $scope.local=result;
                 $scope.local.sourceLocation = parseInt(result.sourceLocation);
                 $scope.local.destinationLocation = parseInt(result.destinationLocation);
                
//                 var desclist = [];
//                 angular.forEach(result.localDtl, function(item, key) {
////                     var description = new Object();
////                     description.id = result.localDtl[key].id;
////                     description.text = result.localDtl[key].text;
////                     desclist.push(description);
//                     $scope.local.localDtl[key].description =  item.description;
//                 });
//                 
//                 $scope.localDtl = desclist;

              
                $scope.isEdit=true;
             }
         }).error(function(data) {
             console.log("data" + data);
         });
     }
    //update
     $scope.update = function(localForm, local) {
//         if (new validationService().checkFormValidity($scope.containerForm)) {
              $scope.local.rowId = $location.search().rowId;
              
             $http.post('app/master/kitchen/update', $scope.local).success(function(result) {
                 if (result) {
                     logger.logSuccess("Updated successfully!");
                     $state.go('app.sea.kitchen.list',{tenantid:$stateParams.tenantid});
                 } else {
                     logger.logError("Error in update!");
                 }
             }).error(function(data) {
                 console.log("data" + data);
             });

//         } else {
//             toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.containerForm.$validationSummary), 555000, 'trustedHtml');
//         }
     };
     $scope.cancel1 = function() {
         $state.go('app.sea.kitchen.list');
     }; 
         
    /*$scope.cancel = function() {
        $state.go('app.sea.kitchen.list');
    };
*/
    $scope.modeType=[
         
          { id: 'Road', text: 'Road' },
          { id: 'Rail', text: 'Rail' }
        
    ]

    $scope.basisList=[
         
          { id: 'Type', text: 'Type' },
          { id: 'Size', text: 'Size' }
        
    ]


    //reset
    $scope.reset = function(local) {
         if (lcNo == undefined) {
             
        
             $scope.local={
                        lcNo:'',
                        agent : '',
                        port : '',
                        surcharge:'',
                        fromDate : '',
                        toDate : '',
                        localDtl : [],
                    
                }

         } else {
             $http.get($stateParams.tenantid+'/api/localcharges/edit?lcNo=' +lcNo).success(function(result) {

                 if (result.isEdit == false) {
                     logger.logError("Please Try Again");
                 } else {

                     $scope.local=result;
                
                    $scope.isEdit=true;
                 }
             }).error(function(data) {
                 console.log("data" + data);
             });
         }
    }

       
    });
    
    
