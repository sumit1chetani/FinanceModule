'use strict';
app.controller('purchaseInvoiceListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, sharedProperties, $state,$window,$controller,$stateParams) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
    $scope.hideDownloadIcon= true;
    
    $scope.fromToPurInvList=[];
    $scope.bulkPurInvoice = {
            fromPurInvoiceNo:'',
            toPurInvoiceNo:'',
            fromDate : '',
            toDate : ''
            
    }
    
    $scope.purchaseInvoiceData = {
            puchaseInvoiceNo :'',
            puchaseInvoiceDate :'',
            supplier :'',
            partyInvoiceNo :'',
            partyInvoiceDate :'',
            purchaseDraftNo: '',
            draftMode:'',
            purchaseNo :'',
            dueDate :'',
            currency :'',
            exgRate :'',
            amountLocal :'',
            amountUSD :'',
            company :'',
            description :'',
            type:'',
            purInvDetail : [],
            detailArr:[],
            edit : false,
            fromDate : '',
            toDate : ''
         };
    $scope.currentURL=$location.protocol() + '://'+ $location.host() +':'+  $location.port()+"/#" +$location.path();
    
    if(window.localStorage.getItem('purchaseIv_list')==$scope.currentURL){
        alert('window ' + $scope.currentURL + ' is already opened');
       // window.focus();
        //window.open($rootScope.currentURL,'_self').close();
      
       // window.close();
       // localStorage.removeItem('purchaseIv');
    }else{
        window.localStorage.setItem('purchaseIv', $scope.currentURL);
        window.localStorage.removeItem('purchaseIv');
        //window.localStorage.removeItem('purchaseIv');
    }
   
    /*$scope.$watch('bulkPurInvoice.fromDate', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            alert()
            $scope.rowCollection = [];
            $http.post('app/purchaseinvoice/getListByDate',$scope.purchaseInvoiceData).success(function(datas) {
                if(datas.success){
                    console.log("from date")
                    console.log(datas)
                }
            })
        }
    });
    
    $scope.$watch('bulkPurInvoice.toDate', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.rowCollection = [];
            $http.post('app/purchaseinvoice/getListByDate',$scope.purchaseInvoiceData).success(function(datas) {
                if(datas.success){
                    
                }
            })
        }
    });*/
    
    $scope.verified = function(objPuInvHdrLstBean) {
        $http.post($stateParams.tenantid+'/app/purchaseinvoice/toVerify', objPuInvHdrLstBean).success(function(result) {
            if (result) {
                objPuInvHdrLstBean.verified=true;
                logger.logSuccess("Purchase Invoice verified successfully");
               // $scope.search();
            }
        });
    }
    
    $scope.binu = false;
    $scope.search = function(){
        $scope.rowCollection = [];
        $scope.purchaseInvoiceData.fromDate = $scope.bulkPurInvoice.fromDate;
        $scope.purchaseInvoiceData.toDate = $scope.bulkPurInvoice.toDate;
        if(($scope.purchaseInvoiceData.fromDate == "" || $scope.purchaseInvoiceData.fromDate == undefined) && 
                ($scope.purchaseInvoiceData.toDate == "" || $scope.purchaseInvoiceData.toDate == undefined)){
            $scope.getPurchaseInvoiceList();
        }else{
            $http.post($stateParams.tenantid+'/app/purchaseinvoice/getListByDate',$scope.purchaseInvoiceData).success(function(data) {
                if(data.success){
                    console.log("from date")
                    console.log(data)
                    $scope.rowCollection = $scope.rowCollection.concat(data.objPuInvHdrLstBean);
                    if($scope.rowCollection[0].loginId == 'E108')
                        $scope.binu = true;
                }
            })
        }
    }
    
   console.log("form code")
   console.log($('#form_code_id').val())
    $scope.getPurchaseInvoiceList = function() {
       $scope.rowCollection = [];
        $http.get($stateParams.tenantid+'/app/pinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val()).success(function(data) {
           if (data.success == true && !utilsService.isUndefinedOrNull(data.objPuInvHdrLstBean)) {
               console.log("&&&&&&&&&&&&&&&&&&&&")
               console.log(data.objPuInvHdrLstBean)
                $scope.rowCollection = $scope.rowCollection.concat(data.objPuInvHdrLstBean);
                if($scope.rowCollection[0].loginId == 'E108')
                    $scope.binu = true;
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getPurchaseInvoiceList();

    
    $scope.getPurInvoiceDropdownList = function() {
        $http.get($stateParams.tenantid+'/app/purchaseinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+$('#form_code_id').val()).success(function(data) {
            if (data.success == true && !utilsService.isUndefinedOrNull(data.objPuInvHdrLstBean)) {
                var arr=[];
                angular.forEach(data.objPuInvHdrLstBean,function(row,index){
                    var obj = new Object();
                    obj.id = row.puchaseInvoiceNo;
                    obj.text = row.puchaseInvoiceNo;
                    
                    arr.push(obj);
                });
                $scope.fromToPurInvList = arr;
             }
         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
    }
    $scope.getPurInvoiceDropdownList();
    
    
    $scope.bulkPrint= function(fromPurInvoiceNo,toPurInvoiceNo){
        //bulkPurInvoice.fromPurInvoiceNo,bulkPurInvoice.toPurInvoiceNo
        var url = $stateParams.tenantid+'/app/pinvoice/bulkPrint?fromPurInvoiceNo=' + fromPurInvoiceNo+"&toPurInvoiceNo="+toPurInvoiceNo;
        var wnd = $window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
        wnd.print();   
     }
    
    //** ********Add,Edit and Delete******** *//*
  $scope.add = function() {
      $scope.isAdd  = true;
      $location.path($stateParams.tenantid+"/invoice/pinvoice/PInvoiceAdd");
      
  };

  $scope.fileUpload = function () {
          ngDialog.open({
              template : 'fileModal',
              scope :$scope
          });
      
  }
  
  
  $scope.viewDraft = function(limit, offset) {
      $state.go('app.finance.invoice.pinvoice-draft',{tenantid:$stateParams.tenantid});
  };
  $rootScope.uploadPIFile = function(element){
      $scope.excelfile = element.files[0];
      console.log($scope.excelfile);
  }
  
  $rootScope.uploadPIStatement =function(){
      ngDialog.close();
      var excelfile=$scope.excelfile;
      var fileExtension= excelfile.name;
      var fName=[];
      fName=fileExtension.split(".");
      console.log(fName);
      for(var i=0;i<fName.length;i++){
          if(fName[i] == "xls" || fName[i] == "xlsx"){
              var frmData=new FormData();
              frmData.append("file",excelfile);
              $.ajax({
                  type : "POST",
                  url : "app/purchaseinvoice/bulkUpload",
                  data : frmData,
                  contentType: false,
                  processData: false,
                  success : function(result) {
                      console.log(result);
                      if(result.success){
                          logger.logSuccess("Purchase Invoices generated sucessfully");
                          $state.reload();
                      }else{
                          logger.logError(result.message);
                          $state.reload();
                      }                      
                  }
                 
              });
          }
          
      }
  }
  
  $scope.fileDownload = function(){
      var url = $stateParams.tenantid+"/assets/excelDocument/PURCHASE_INV_BULK.xlsx"
      $window.location.href = url;

  }
 
  
    // Redirecting Page For Edit Functionality
    $scope.editRow = function(purchaseInvoiceNo,index) {
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/pinvoice/PInvoiceEdit/"+purchaseInvoiceNo);
    };

    // remove to the real data holder
    $scope.deleteRow = function(puchaseInvoiceNo, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/pinvoice/delete';
            $http({
                method : 'post',
                url : myURL,
                data : puchaseInvoiceNo,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Purchase Invoice deleted successfully");
                } else {
                    logger.logError("Error in deleting Purchase Invoice master!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete Purchase Invoice Master!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
    
 // Redirecting Page For View Functionality
    $scope.view = function(purchaseInvoiceNo,index) {
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/pinvoice/PInvoiceView/"+purchaseInvoiceNo);
    };


    /*  $scope.reversePIN = function(reverseInvoiceNo){
            if(reverseInvoiceNo =="" || reverseInvoiceNo ==undefined){
                logger.logError("Please select invoice");
            }else{
                $http.post('app/purchaseinvoice/reversePIN',reverseInvoiceNo).success(function(datas) {
                    debugger;
                    if(datas.success == true){
                        if(datas.message =='Invoice is already reversed !..')
                            logger.logError(datas.message)
                        else
                            logger.logSuccess(datas.message);
                    }else{
                        logger.logError(datas.message);
                    }
                    }).error(function(datas) {
                });
            }
        }*/
        
        $scope.reversePIN = function(reverseInvoiceNo) {
            if(reverseInvoiceNo =="" || reverseInvoiceNo ==undefined){
                logger.logError("Please select invoice");
            }else{         
                ngDialog.open({
                    scope : $scope,
                    template : 'views/finance/transaction/transactionReverseDialog',
                    controller : $controller('purchaseInvoiceReverseCtrl', {
                        $scope : $scope,
                        invoiceNo: reverseInvoiceNo,
                        screenName: 'purchaseinvoice'
                    }),
                    className : 'ngdialog-theme-plain',
                    showClose : false,
                    closeByDocument : false,
                    closeByEscape : false,
                    preCloseCallback : $scope.getList
                });
            }
        };
        
        $scope.copyInvoice =function(reverseInvoiceNo){
            if(reverseInvoiceNo =="" || reverseInvoiceNo ==undefined){
                logger.logError("Please select invoice");
            }else{
                $location.path($stateParams.tenantid+"/invoice/pinvoice/PInvoiceCopy/"+reverseInvoiceNo);  
            }
            
        }
});
//draft

app.controller('purchaseInvoiceListDraftCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, sharedProperties, $state,$window,$controller,$stateParams) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
    $scope.hideDownloadIcon= true;
    
    $scope.fromToPurInvList=[];
    $scope.bulkPurInvoice = {
            fromPurInvoiceNo:'',
            toPurInvoiceNo:''
    }
    
    $scope.purchaseInvoiceData = {
            puchaseInvoiceNo :'',
            puchaseInvoiceDate :'',
            supplier :'',
            partyInvoiceNo :'',
            partyInvoiceDate :'',
            purchaseNo :'',
            dueDate :'',
            currency :'',
            exgRate :'',
            amountLocal :'',
            amountUSD :'',
            company :'',
            description :'',
            type:'',
            purInvDetail : [],
            detailArr:[],
            edit : false
         };
  
    $scope.getPurchaseInvoiceList = function() {
       console.log("call list")
        $http.get($stateParams.tenantid+'/app/pinvoice/Draftlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+'F0186').success(function(data) {
            console.log("data")
            console.log(data)
           if (data.success == true && !utilsService.isUndefinedOrNull(data.objPuInvHdrLstBean)) {
               
               console.log("hello")
               console.log(data.objPuInvHdrLstBean)
                $scope.rowCollection = $scope.rowCollection.concat(data.objPuInvHdrLstBean);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };

    $scope.getPurchaseInvoiceList();

    
    $scope.getPurInvoiceDropdownList = function() {
        $http.get($stateParams.tenantid+'/app/pinvoice/Draftlist?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&formCode='+'F0186').success(function(data) {
            if (data.success == true && !utilsService.isUndefinedOrNull(data.objPuInvHdrLstBean)) {
                var arr=[];
                angular.forEach(data.objPuInvHdrLstBean,function(row,index){
                    var obj = new Object();
                    obj.id = row.puchaseInvoiceNo;
                    obj.text = row.puchaseInvoiceNo;
                    
                    arr.push(obj);
                });
                $scope.fromToPurInvList = arr;
             }
         }).error(function(data) {
             logger.logError("Error Please Try Again");
         });
    }
    $scope.getPurInvoiceDropdownList();
    
 
  
    // Redirecting Page For Edit Functionality

    $scope.editRow = function(purchaseInvoiceNo,index) {
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/pinvoice/PInvoiceEditTemp/"+purchaseInvoiceNo);
    };

    // remove to the real data holder
    $scope.deleteRow = function(puchaseInvoiceNo, index) {
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/pinvoice/delete';
            $http({
                method : 'post',
                url : myURL,
                data : puchaseInvoiceNo,
            }).success(function(data) {
                if (data == true) {
                    var tableData = $scope.rowCollection;
                    $scope.rowCollection.splice(index, 1);
                    logger.logSuccess("Purchase Invoice deleted successfully");
                } else {
                    logger.logError("Error in deleting Purchase Invoice master!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete Purchase Invoice Master!");
            });
            console.log('Modal promise resolved. Value: ');
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });

    };
    
 // Redirecting Page For View Functionality
    $scope.view = function(purchaseInvoiceNo,index) {
        $scope.isAdd  = false;
        $location.path($stateParams.tenantid+"/invoice/pinvoice/PInvoiceView/"+purchaseInvoiceNo);
    };

        
});

//draft
app.controller('purchaseInvoiceReverseCtrl', function($scope, $http,ngDialog,logger,$location,invoiceNo,screenName,$timeout,$stateParams) {
    $scope.pinReverseObj = {puchaseInvoiceDate:'', puchaseInvoiceNo:''};
    
    $scope.screenNames = screenName;
    
        /*$timeout(function() {
            $("#pinReverse_Date").datetimepicker({
                format : 'DD/MM/YYYY',
                pickTime: false
            });
         }, 1000);
    
       
        
        $("#pinReverse_Date").on("dp.change", function(e) {
            $scope.pinReverseObj.puchaseInvoiceDate = $('#txtPinReverseDate').val();
        });*/
    
    $timeout(function() {
        $("#txtPinReverseDate").datetimepicker({
            minDate: "01/01/2016",
            format : 'DD/MM/YYYY',
            pickTime: false
        });
     }, 1000);
    
    $("#txtPinReverseDate").on("dp.change", function(e) {
        $scope.pinReverseObj.puchaseInvoiceDate = $('#txtPinReverseDate').val();
    });
    
        
    
    $scope.getCurrentDate = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) { dd = '0' + dd }
        if (mm < 10) { mm = '0' + mm }
        var today = dd + '/' + mm + '/' + yyyy;
        $scope.pinReverseObj.puchaseInvoiceDate = today;
    }
    $scope.getCurrentDate();
        
    $scope.pinReverseObj.puchaseInvoiceNo = invoiceNo;
   
    $scope.reverseConfirm = function(){
        if($scope.screenNames=="purchaseinvoice"){
            if($scope.pinReverseObj.puchaseInvoiceDate!=""){
                $http.post($stateParams.tenantid+'/app/pinvoice/reversePIN',$scope.pinReverseObj).success(function(datas) {
                    debugger;
                    if(datas.success == true){
                        if(datas.message =='Invoice is already reversed !..'){
                            logger.logError(datas.message);
                            ngDialog.close();
                        }else{
                            logger.logSuccess(datas.message);
                            ngDialog.close();
                        }
                    }else{
                        logger.logError(datas.message);
                    }
                    }).error(function(datas) {
                });
            }else{
                logger.logError("Please Select Invoice Date!");
            }
        }
    }
    $scope.closeCBPReverseDialog = function() {
        ngDialog.close();
     };
});
