
    'use strict';
    
   	app.controller('PffTaxSlabCtrlAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {        
        $scope.slabRate = {
                slabHdrId:'',
                fromDate:'',
                toDate   :'',
                rateTable:[]       
         };
       
        //Detail row add 
        var i=1;
        $scope.slabRateAdd = function(Table) {
           debugger
           var len=Table.length+1;
              var rate = {
                    
                      slabName : 'Slab'+' '+ len,
                      rangeFromAmount : '',       
                      rangeToAmount : '',
                      professionaltax:''
                      
              };
              //i++;
              $scope.slabRate.rateTable.push(rate);
             
          }
     
        
       
        
     /*   
        $scope.slabRateAdd = function() {
            debugger
            
               var rate = {
                     
                       slabName : 'Slab'+' '+ i,
                       rangeFromAmount : '',       
                       rangeToAmount : '',
                       professionaltax:''
                       
               };
               i++;
               $scope.slabRate.rateTable.push(rate);
              
           }
        */

        $scope.slabRateRemove = function() {
            debugger
            $scope.slabRateRow = [];
            angular.forEach($scope.slabRate.rateTable, function(rate, index) {
                
                var check = rate.section;
                if (check == undefined || check == "") {
                    $scope.slabRateRow.push(rate);
                } else {
                     i--;
                }
            });
           
            for(var j=0;j < $scope.slabRateRow.length;j++){
                var len=j+1;
                $scope.slabRateRow[j].slabName = 'Slab'+' '+ len;
            }
            $scope.slabRate.rateTable = $scope.slabRateRow;
        };
        
        
        $scope.$watchCollection('[slabRate.fromDate,slabRate.toDate]', function(newValues) {
            debugger
           if(newValues[1]!=""){
               var fromDate = $scope.slabRate.fromDate;
               var toDate = $scope.slabRate.toDate;
               fromDate = fromDate.split("/");
               fromDate = new Date(fromDate[2], fromDate[1], fromDate[0]);
               toDate = toDate.split("/");
               toDate = new Date(toDate[2], toDate[1], toDate[0]);
              $scope.slabRate.edit=$scope.isEdit;
               if(fromDate < toDate){
                   $http.post('payroll/master/professionalTax/validate',$scope.slabRate).success(function(response){
                       if(!response){
                           $scope.slabRate.toDate="";
                           logger.logError("Already entry exist for the given dates");
                       }
                   })
               }else{
                   logger.logError("To Date is greater than From Date");
                   $scope.slabRate.toDate="";
               }       
           }
        });
        
        
        $scope.addRow = function() {
            $scope.callDialog($scope, 0, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };
        
        $scope.editRow = function(per, index) {
            $scope.callDialog($scope, per, index, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };
        
        
       /* var currentdate = new Date();
        var date = "1";
        var month = currentdate.getMonth() + 1;
        var year = currentdate.getFullYear();
        var currentDate = date + "/" + month + "/" + year;
        $scope.slabRate.toDate = date + "/" + month + "/" + year;*/
   
        //save functionality 
        
        $scope.save = function(pffTaxSlabRate) {
            debugger
            if (new validationService().checkFormValidity(pffTaxSlabRate)) {
               
                $http.post('payroll/master/professionalTax/save', $scope.slabRate).success(function(result) {
                    if (result.savedSuccess == true) {
                        logger.logSuccess("Saved Successfully");
                        $state.go('app.payroll.ProffTaxSlabRate.list');
                        
                    } else {
//                        logger.logError("Sorry Some Error occurred");
                        logger.logError(result.message);
                      
                    }

                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(pffTaxSlabRate.$validationSummary), 5000, 'trustedHtml');
            }
        }
        
        
        //copy functionality 
        
        $scope.copy = function(pffTaxSlabRate) {
            debugger
            if (new validationService().checkFormValidity(pffTaxSlabRate)) {
               
                $http.post('payroll/master/professionalTax/save', $scope.slabRate).success(function(result) {
                    if (result.savedSuccess == false) {
                        logger.logSuccess("Saved Successfully");
                        $state.go('app.payroll.ProffTaxSlabRate.list');
                        
                    } else {
                        logger.logError("Sorry Some Error occurred");
                        
                      
                    }

                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(pffTaxSlabRate.$validationSummary), 5000, 'trustedHtml');
            }
        } 

       $scope.isEdit = false;
        $scope.diminishingEMIList=[];
        
//        $scope.ischeck=false;
        
      
    var slabHdrId = $location.search().slabHdrId;
        if (slabHdrId == undefined) {
            debugger
            
            $scope.isEdit = false;
        } else {
            debugger
           
            $http.get('payroll/master/professionalTax/edit?slabHdrId='+ slabHdrId).success(function(result) {
               /* 
                $scope.slabRate.fromDate = result.editList[0].fromDate;
                $scope.slabRate.toDate= result.editList[0].toDate;*/
               
                $scope.slabRate.fromDate=result.editListDtl[0].fromDate;
                $scope.slabRate.toDate=result.editListDtl[0].toDate;
                $scope.slabRate.slabHdrId=result.editListDtl[0].slabHdrId;
                $scope.slabRate.rateTable=result.editList;
                   console.log(result);
                        $scope.isEdit = true;
                    
            }).error(function(data) {

            });
        }
        
        
        //Detail Section 
        
        app.controller('slabrateDetailCtrl', function($scope, $http, $filter, logger) {
debugger
            $scope.$watch('slabRate.rateTable[$index].rangeFromAmount', function(newValue, oldValue) {
                debugger
                if (newValue != undefined && newValue != '') {
                    angular.forEach($scope.slabRate.rateTable, function(value, key) {
                        if (key != $scope.$index) {
                            if (value.rangeFromAmount != undefined && value.rangeFromAmount != null && value.rangeFromAmount == newValue) {
                                logger.logError(" Range From Amount Already Exist");

                             //   $scope.slabRate.rateTable[$scope.$index].rangeFromAmount = '';

                            }

                        }

                    });
                

                } 

            });
          


//Range
$scope.$watchCollection('[slabRate.rateTable[$index].rangeFromAmount,slabRate.rateTable[$index].rangeToAmount]', function(newValue, oldValue) {
   // $scope.slabRate.rateTable[$index].rangeFromAmount
  //  $scope.slabRate.rateTable[$index].rangeToAmount
        newValue[0];
        newValue[1];
if(newValue[0]!= null && newValue[0]!="" & newValue[0] != undefined && newValue[1]!= null && newValue[1]!="" & newValue[1] != undefined){
    angular.forEach($scope.slabRate.rateTable, function(value, key) {
        if (key != $scope.$index) {
    if( parseInt(newValue[0]) >= parseInt(value.rangeFromAmount) && parseInt(newValue[0]) <= parseInt(value.rangeToAmount)){
           // if(parseInt(newValue[0]) >= parseInt(value.rangeFromAmount) && parseInt(newValue[0]) <= parseInt(value.rangeToAmount){    
        logger.logError(" Amount Range Already Exist, Please Choose Different!");
        $scope.slabRate.rateTable[$scope.$index].rangeFromAmount = '';
        $scope.slabRate.rateTable[$scope.$index].rangeToAmount = '';
        
    }
        }
    })
}
});

$scope.$watch('slabRate.rateTable[$index].rangeFromAmount', function(newValue, oldValue) {
    debugger
    if (newValue != undefined && newValue != "") {
        angular.forEach($scope.slabRate.rateTable, function(value, key) {
            if (key != $scope.$index) {
                if (value.rangeFromAmount != undefined && value.rangeFromAmount != null && value.rangeFromAmount == newValue) {
                    logger.logError(" Range From Amount Already Exist");

                 //   $scope.slabRate.rateTable[$scope.$index].rangeFromAmount = '';

                }

            }

        });
    

    } 

});


$scope.$watch('slabRate.rateTable[$index].rangeToAmount', function(newValue, oldValue) {
    debugger
    if (newValue != undefined && newValue != "" && newValue!= null) {
        angular.forEach($scope.slabRate.rateTable, function(value, key) {
            if (key != $scope.$index) {
                if (value.rangeToAmount != undefined && value.rangeToAmount != null && value.rangeToAmount == newValue) {
                    logger.logError(" Range To Amount Already Exist");

                 //   $scope.slabRate.rateTable[$scope.$index].rangeFromAmount = '';

                }

            }

        });
    

    } 

});

        });
        
        
        $scope.reset= function(){
            debugger
            if (slabHdrId == undefined) {
                debugger
                
                $scope.isEdit = false;
                
                $scope.slabRate = {
                        slabHdrId:'',
                        fromDate:'',
                        toDate   :'',
                        rateTable:[]       
                 };
            }
            else{
                $http.get('payroll/master/professionalTax/edit?slabHdrId='+ slabHdrId).success(function(result) {
                    /* 
                     $scope.slabRate.fromDate = result.editList[0].fromDate;
                     $scope.slabRate.toDate= result.editList[0].toDate;*/
                    
                     $scope.slabRate.fromDate=result.editListDtl[0].fromDate;
                     $scope.slabRate.toDate=result.editListDtl[0].toDate;
                     $scope.slabRate.slabHdrId=result.editListDtl[0].slabHdrId;
                     $scope.slabRate.rateTable=result.editList;
                             $scope.isEdit = true;
                         
                 })
                
            }
            
            
            
        }
        
        $scope.cancel =function(){
            $state.go('app.payroll.ProffTaxSlabRate.list');
        };
   
        
        $scope.update= function(pffTaxSlabRate){
            debugger
            $http.post('payroll/master/professionalTax/update', $scope.slabRate).success(function(data){
                if(data.updated=true){
                    
                    logger.logSuccess("Updated Successfully");
                    $state.go('app.payroll.ProffTaxSlabRate.list');
                }
                
                
            })
            
        }
    
    
    
});





