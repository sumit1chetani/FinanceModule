 'use strict';   
app.controller('vendorMasterViewCtrl', function($scope, $rootScope, $http, $location,ngDialog, logger, utilsService,$state,sharedProperties,$window) {

    $scope.vendorlist = [];
    $scope.cancel = function() {
        $location.path("vendor/vendorMaster");
    };
    
    $scope.vendorMaster={
            
            vendorCode: '',
            vendorName: '',
            vendorShortName: '',
            vendorAddress: '',
            vendorAddress1: '',
            countryId: '',
            vendorOfficTelephno: '',
            vendorFaxNumber: '',
            telexNo: '',
            vendorEmail: '',
            vendorCreditLimit: '',
            currencyCode: '',
            exchangeRate: '',
            bunkerSupplier: '',
            vendorContactPerson: '',
            vendorContactEmail: '',
            vendorContatcTelephno: '',
            vendorContactFaxNumber: '',
            vendorActive: 'N',
            
            vendorLoan : '',
            vendorTrkMaintce:'',
            vendorPort:'',
            vendorPlrCharges:'',
       
           /**
            * vendor type
            */
            vendorType: '',
            slotOperator: '',
            vesselOperator: '',
            jvPartner: '',
            subSlot :'',
            servicePartner: '',
            agent: '',
            jvTypeShareRVC: '',
            jvTypeSlotSwap: '',
            jvTypeCost: '',
            jvTypeDeadFreight: '',
       
           /**
            * Credit terms
            */
            vendorCreditPeriod: '',
            vendorCreditPeriodType: '',
            vendorCreditAmount: '',
            vendorCreditAmtType: '',
       
           /**
            * Remiatance Details
            */
            beneBankAcctNumber: '',
            beneBankAcctName: '',
            beneAddress: '',
            beneSwiftCode: '',
            corressBankAccountNumber: '',
            corressBankAccountName: '',
            corressBankAccountAddr: '',
            corressBankSwiftCode: '',
              
            isEdit : false

            
            
       };
    
    
/*    $scope.getFetchData = function(vendorCode) {
        

        var url = 'app/vendorMaster/EditList?vendorCode' + vendorCode;
        $http.get(url).success(function(data) {
            $scope.vendorlist = data.mulVendor;
               console.log("$scope.vendorlist");
               console.log($scope.vendorlist)
             

                
        });
    }*/
    $scope.FetchingValues = function(data) {
        console.log("ramya");
        console.log(data);
        $scope.vendorMaster.vendorCode  =    data.vendorCode;
      //  $scope.vendorMaster.mulVendor  = $scope.getFetchData($scope.vendorMaster.vendorCode);
/*        console.log("$scope.portMaster.mulPort");
        console.log($scope.portMaster.mulPort)*/

        $scope.vendorMaster.vendorName =  data.vendorName;
        $scope.vendorMaster.vendorShortName =     data.vendorShortName ;
        $scope.vendorMaster.vendorAddress = data.vendorAddress ;
        $scope.vendorMaster.vendorAddress1 = data.vendorAddress1 ;
        $scope.vendorMaster.countryId = data.countryId ;
        $scope.vendorMaster.vendorOfficTelephno = data.vendorOfficTelephno ;
        $scope.vendorMaster.vendorFaxNumber = data.vendorFaxNumber ;
        $scope.vendorMaster.telexNo= data.telexNo ;
        $scope.vendorMaster.vendorEmail = data.vendorEmail ;
        $scope.vendorMaster.vendorCreditLimit = data.vendorCreditLimit ;
        $scope.vendorMaster.currencyCode = data.currencyCode ;
        $scope.vendorMaster.exchangeRate = data.exchangeRate ;
        $scope.vendorMaster.bunkerSupplier= data.bunkerSupplier ;
        $scope.vendorMaster.vendorContactPerson = data.vendorContactPerson ;
        $scope.vendorMaster.vendorContactEmail = data.vendorContactEmail ;
        $scope.vendorMaster.vendorContatcTelephno= data.vendorContatcTelephno ;
        $scope.vendorMaster.vendorContactFaxNumber = data.vendorContactFaxNumber ;
        $scope.vendorMaster.vendorActive = data.vendorActive ;
        $scope.vendorMaster.vendorType = data.vendorType ;
        $scope.vendorMaster.slotOperator = data.slotOperator ;
        $scope.vendorMaster.vesselOperator = data.vesselOperator ;
        $scope.vendorMaster.vendorCreditPeriod = data.vendorCreditPeriod ;

        $scope.vendorMaster.subSlot = data.subSlot ;

        $scope.vendorMaster.servicePartner = data.servicePartner ;

        $scope.vendorMaster.agent = data.agent ;

        $scope.vendorMaster.jvTypeShareRVC = data.jvTypeShareRVC ;

        $scope.vendorMaster.jvTypeSlotSwap = data.jvTypeSlotSwap ;

        $scope.vendorMaster.jvTypeCost = data.jvTypeCost ;

        $scope.vendorMaster.jvTypeDeadFreight = data.jvTypeDeadFreight ;

        $scope.vendorMaster.vendorCreditPeriod = data.vendorCreditPeriod ;
        
        $scope.vendorMaster.vendorCreditPeriodType = data.vendorCreditPeriodType ;

        
        $scope.vendorMaster.vendorCreditAmount = data.vendorCreditAmount ;

        $scope.vendorMaster.vendorCreditAmtType = data.vendorCreditAmtType ;

        $scope.vendorMaster.beneBankAcctNumber = data.beneBankAcctNumber ;

        $scope.vendorMaster.beneBankAcctName = data.beneBankAcctName ;

        $scope.vendorMaster.beneAddress = data.beneAddress ;

        $scope.vendorMaster.beneSwiftCode = data.beneSwiftCode ;
        
        
        $scope.vendorMaster.corressBankAccountNumber = data.corressBankAccountNumber ;
        $scope.vendorMaster.corressBankAccountName = data.corressBankAccountName ;
        $scope.vendorMaster.corressBankAccountAddr = data.corressBankAccountAddr ;
        $scope.vendorMaster.corressBankSwiftCode = data.corressBankSwiftCode ;




          
    }
    
    $scope.FetchingValues(sharedProperties.getObject());
    
    $scope.cancelVendor=function(){
        $scope.vendorMasterObject = angular.copy($scope.vendorMasterObjectClear);
        $state.go('app.finance.controlscreen.vendormaster');
    };


  
});