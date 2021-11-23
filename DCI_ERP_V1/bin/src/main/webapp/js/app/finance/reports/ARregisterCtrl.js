
app.controller('ARregisterCtrl', function($scope, $window, $rootScope, $location, $http, $filter,
        logger, $log, ngDialog, $modal, utilsService,$state , $timeout,$stateParams) {
    
    $scope.companyList = [];  
    $scope.serviceList = [];
    $scope.excelList = [];
    $scope.displayedCollection = [];
    $scope.messageHeaderList = [];
    
    $scope.ARregister={

             payer :'',
             grp_invoice_no:'',
             grp_invoice_dt:'',
             balance:'',
             balance_usd:'',
             voyage:'',
             pol:'',
             pod:'',
             sailingDt:'',
             aging:'',
             mloname:'',
             servicename:'',
             country:'',
             mloCity:'',
             customerShortName:''
               
    }  
    
    
    
    $scope.getReprtHeader = function(){
        
        $http.get($stateParams.tenantid+'/app/ARreport/getReprtHeader').success(function(datas) {
                console.log("ar header")
                console.log(datas)
           $scope.messageHeaderList =  datas.getheaderList;
            }).error(function(datas) {
        });
        
    }
    
    $scope.getReprtHeader();
    //plugin add
    $scope.selectall = true;
    $scope.selectAll = function(value){
        console.log("value")
        for(var index in $scope.messageHeaderList){
            console.log($scope.messageHeaderList[index])
            var colum = $scope.messageHeaderList[index];
            if(colum.isDefault == false){
                if(value == true){
                    colum.visible = true;
                }else{
                    colum.visible = false;
                }
            }
        }
            
    }
    $scope.selectedVisibility = [];
    $scope.getSelectedColumn=function(index){
        
        var value = $scope.messageHeaderList.indexOf(index);
        var indexExsists = $scope.selectedVisibility.indexOf(index);
        if(indexExsists ==-1)
            {
                $scope.selectedVisibility.push(value);
            }
    };
    
    $scope.onDropComplete = function (index, obj, evt) {
        var otherIndex = $scope.messageHeaderList.indexOf(obj);
        
        if(index !=undefined){
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice(index, 0, obj);
        }

        else if(index = "undefined"){
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice($scope.messageHeaderList.length, 0, obj);
        }
    };
    
    //company

    $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
        $scope.companyList=data;
    }).error(function(data) {
    });
    
    //company
/*    $http.get('app/commonUtility/getCompanyList').success(function(datas) {
        $scope.companyList = datas;
        console.log("company list")
              console.log($scope.companyList)
        }).error(function(datas) {
    });*/
    
    // service
    
    
    
    $http.get($stateParams.tenantid+'/app/agencyTariff/service').success(function(datas) {
        $scope.serviceList = datas.serviceList;
        console.log("serviceList")
        console.log($scope.serviceList)
    }).error(function(data) {
    });
    
    $scope.onSearch = function(ARregister) {
        console.log("ARregister");
        console.log(ARregister);
        $http.post($stateParams.tenantid+"/app/ARreport/getARReport",ARregister).success(function(response) {
                  console.log("get ar report");
                  console.log(response);
                 $scope.rowCollection  = response.lARregisterlists;
                 $scope.excelList  = response.lARregisterlists;

              }).error(function(result) {
                  logger.logError("Error Please Try Again");
              });
              
            
          }
    
    $scope.reset = function()
    {
        $scope.ARregister.sectorId= '';
        $scope.ARregister.company= '';
        $scope.ARregister.fromDate= '';
        $scope.ARregister.toDate = '';


    }
    
    
    //excel export 
      $scope.excel=function(){    
          
          var groupHeaderSelectedList= $filter('filter')($scope.messageHeaderList, { visible: true}, true);

          var objWholeData = {

                   'lARregisterlists'  :  $scope.excelList,
                   'getheaderList'  : groupHeaderSelectedList,
                   
              };  
                  
          console.log("AR excel")
          console.log(objWholeData);
  $http.post($stateParams.tenantid+"/app/ARreport/generateExcel",objWholeData).success(function(response) {
          
             $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/ARRegister.xlsx" download="ARRegister.xlsx"></a>');
             $("#tbExcelExport").bind('click', function() {
             });
             $('#tbExcelExport').simulateClick('click');

      }).error(function(result) {
          logger.logError("Error Please Try Again");
      });
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

            
      }

});


