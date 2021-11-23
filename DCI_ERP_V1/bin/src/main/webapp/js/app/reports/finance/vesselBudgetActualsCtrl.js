'use strict';
app.controller('vbBudgetActualsCtrl', function($scope, ngDialog, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window,$stateParams) {
    $scope.pageCounters = [ 14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;

    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.budgetActuals = {
        vesselCode : '',
        vesselName : '',
        fromDate : '',
        toDate : '',
        budgetCode : '',
        budgetDesc : '',
        departmentName : '',
        allocatedTotalAmount : 0.0,
        firstQuarterAmount : 0.0,
        secondQuarterAmount : 0.0,
        thirdQuarterAmount : 0.0,
        fourthQuarterAmount : 0.0,
        budgetActualsDtlBeanList : []

    }
    $scope.hideUploadIcon = true;
    $scope.hideAddIcon = true;
    $scope.hideEditIcon = true;
    $scope.budgetActualsExport = function() {
        $state.go('app.reports.finance.budgetactuals.export',{tenantid:$stateParams.tenantid});
    };

    $scope.fileUpload = function() {
        ngDialog.close();
        ngDialog.open({
            template : 'fileModal',
            scope : $scope
        });
    };
    $scope.viewBudgetsActualOld = function(budgetActuals) {
        console.log("budgetActual view");
        console.log(budgetActuals);
        
        var budgetDesc=budgetActuals.budgetDesc.replace(/\//g, "~");
        var departmentName=budgetActuals.departmentName.replace(/\//g, "~");
        
        $location.path($stateParams.tenantid+"/reports/finance/budgetactuals/view/"+budgetActuals.vesselName+"/"+budgetActuals.fromDate+"/"+budgetActuals.toDate+"/"+departmentName+"/"+budgetActuals.budgetCode+"/"+budgetDesc+"/"+budgetActuals.allocatedTotalAmount);      
    }
    $scope.viewBudgetsActual = function(budgetActuals) {
        console.log("budgetActual view");
        console.log(budgetActuals);
        
        var budgetDesc=budgetActuals.budgetDesc.replace(/\//g, "~");
        var departmentName=budgetActuals.departmentName.replace(/\//g, "~");
        
        $location.path($stateParams.tenantid+"/reports/finance/budgetactuals/view/"+budgetActuals.vesselName+"/"+budgetActuals.fromDate+"/"+budgetActuals.toDate);      
    }
  /*  $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
        console.log($scope.excelfile);
    }

    $rootScope.closeFileDialog = function() {
        ngDialog.close();
    };

    $rootScope.uploadBudgetActuals = function() {
        ngDialog.close();
        var excelfile = $scope.excelfile;
        var fileExtension = excelfile.name;
        var fName = [];
        fName = fileExtension.split(".");
        for (var i = 0; i < fName.length; i++) {
            if (fName[i] == "xls" || fName[i] == "xlsx") {
                var frmData = new FormData();
                frmData.append("file", excelfile);
                $.ajax({
                    type : "POST",
                    url : "app/fibudgetactuals/uploadfile",
                    data : frmData,
                    contentType : false,
                    processData : false,
                    success : function(result) {
                        if (result.success) {
                            logger.logSuccess("File Uploaded Successfully");
                        } else {
                            logger.logError("Fail to Upload");
                        }

                    }
                });
            }

        }
    }*/


    $scope.fileUpload = function () {
            ngDialog.open({
                template : 'fileModal',
                scope :$scope
            });
        
    }
    
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
                    url : $stateParams.tenantid+"/app/fibudgetactuals/budgetUpload",
                    data : frmData,
                    contentType: false,
                    processData: false,
                    success : function(result) {
                        console.log(result);
                        if(result.success){
                            logger.logSuccess("Budget uploaded sucessfully");
                            $scope.getBudgetAllocationList();
                        }else{
                            logger.logError(result.message);                           
                        }                      
                    }
                   
                });
            }
            
        }
    }
    
   
   
    $scope.getBudgetActualsList = function(limit, offset) {
        $scope.rowCollection=[];
        var url = $stateParams.tenantid+'/app/fibudgetactuals/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            console.log(data);
            if (data.success == true) {
                $scope.rowCollection = $scope.rowCollection.concat(data.budgetActualsBeanList);
                console.log($scope.rowCollection);
            }

        }).error(function(data) {

            logger.logError("Error Please Try Again");
        });

        $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        sharedProperties.setObject($scope.emptyObject);

    };

    $scope.getBudgetActualsList();
    
    
    $scope.getBudgetAllocationList = function(limit, offset) {
        $scope.rowCollection=[];
        var url = $stateParams.tenantid+'/app/fibudgetactuals/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
        $http.get(url).success(function(data) {
            console.log(data);
            if (data.success == true && !utilsService.isUndefinedOrNull(data.budgetAllocationBeanList)) {
                $scope.rowCollection = $scope.rowCollection.concat(data.budgetAllocationBeanList);
                console.log($scope.rowCollection);
            }

        }).error(function(data) {

            logger.logError("Error Please Try Again");
        });

        $scope.offsetCount = $scope.offsetCount + $scope.limitCount;
        sharedProperties.setObject($scope.emptyObject);

    };

    $scope.getBudgetAllocationList();
})

app.controller('vbBudgetActualsViewCtrl', function($scope, $rootScope, $stateParams, $http, $location, logger, $log, ngDialog, $modal, utilsService, $window, $state, sharedProperties) {
    
    var path = $location.path();

    var splitPath = path.split("/");
    var selectedpath = splitPath[splitPath.length - 1];
    // alert("path"+selectedpath);
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.budgetAllocation = {
            vesselCode : '',
            vesselName : '',
            fromDate : '',
            toDate : '',
            allocatedTotalAmount :0.0,
            firstQuarterAmount : 0.0,
            secondQuarterAmount :0.0,
            thirdQuarterAmount : 0.0,
            fourthQuarterAmount : 0.0,
            actualTotalAmt:0.0,
            budgetTotalAmt:0.0,
            budgetAllocationDtlBeanList:[]

    }
    $scope.budgetAllocationDtl = {
            budgetCode : '',
            budgetDesc : '',
            allocatedAmount:0.0,
            firstQuarterAmount:0.0,
            secondQuarterAmount:0.0,
            thirdQuarterAmount:0.0,
            fourthQuarterAmount:0.0,
            creditAmt:0.0,
            debitAmt:0.0,
            acctHeadCode:'',
            actualAmt:0.0
    }
    $('#budget_from_date').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $('#budget_to_date').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    var purchaseData = selectedpath;
    $scope.budgetAllocation.vesselName = $stateParams.vesselName;
    $scope.budgetAllocation.fromDate = $stateParams.fromDate.replace(/-/g, "/");
    $scope.budgetAllocation.toDate = $stateParams.toDate.replace(/-/g, "/");
    console.log("budget allocation dtl request");
    console.log($scope.budgetAllocation);
    $http.post('app/fibudgetactuals/view', $scope.budgetAllocation).success(function(result) {
      console.log("budget allocation dtl");
      console.log(result);
      $scope.budgetAllocation=result;
    })
    
    $scope.search = function() {
        $scope.budgetAllocation.fromDate=$('#fromDate').val();
        $scope.budgetAllocation.toDate=$('#toDate').val();
        console.log($scope.budgetAllocation);
        $http.post($stateParams.tenantid+'/app/fibudgetactuals/view', $scope.budgetAllocation).success(function(result) {
            console.log("search budget allocation dtl");
            console.log(result);
            $scope.budgetAllocation=result;
          })
    };
    
    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/reports/finance/budgetactuals/list");
    };
})


app.controller('vbBudgetActualsExportCtrl', function($scope, $rootScope, $stateParams, $http, $location, logger, $log, ngDialog, $modal, utilsService, $window, $state,$timeout, sharedProperties) {
    $scope.budgetActuals = {
        vesselCode : '',
        vesselCodeList:[],
        vesselName : '',
        fromDate : '',
        toDate : '',
        year : '',
        budgetCode : '',
        budgetDesc : '',
        companyCode:'',
        departmentName : '',
        allocatedTotalAmount : 0.0,
        invoiceLpoAmount : 0.0,
        openingAmount : 0.0,
        totalSpendAmount : 0.0,
        pctAmount : 0.0,
        balanceAmount : 0.0,
        budgetActualsDtlBeanList : []

    }
    $scope.budgetActualsDtl = {
        terms : '',
        allocatedAmount : 0.0,
        invoiceLpoAmount : 0.0,
        openingAmount : 0.0,
        totalSpendAmount : 0.0,
        pctAmount : 0.0,
        balanceAmount : 0.0,

    }
  /*  $('.datetimepick').datetimepicker({
        format : "YYYY",
        viewMode : "months",

    });*/
    
    $('#budget_from_date').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $('#budget_to_date').datetimepicker({
        format : 'DD/MM/YYYY'
    });
    
    $scope.getInitVesselMultiselect = function() {
        $("#vesselCode").multiselect({
            maxHeight: 200,   
            includeSelectAllOption: true,
            disableIfEmpty: true,
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            filterPlaceholder: 'Search',
            onDropdownHide: function (event) {
              //  $scope.getMloByPort();
            }
          });
        $("#multiselect-button").addClass("width_100 input-sm line-height-5");
        }
        $scope.getInitVesselMultiselect();
    
    $scope.getVessel = function() {
        $http.get($stateParams.tenantid+'/app/fibudgetactuals/getVessel').success(function(datas) {
            console.log("vessel");
            console.log(datas);
            $scope.vesselCodeList = datas;
            $timeout(function() {
                $('#vesselCode').multiselect('deselectAll', false);
                $('#vesselCode').multiselect('updateButtonText');
                $("#vesselCode").multiselect('rebuild');                
             
            }, 2, false);
            
        }).error(function(data) {
        });
    }
    $scope.getVessel();
    $scope.yearList=[];
    for(var i=2015;i<=2020;i++){
        var year={};
        year=i;
        $scope.yearList.push(year);
    }

    $scope.exportToExcel = function() {
       
        console.log("export budget actual");
        console.log($scope.budgetActuals);
        var errorMsg = "";
        $scope.budgetActuals.fromDate=$('#fromDate').val();
        $scope.budgetActuals.toDate=$('#toDate').val();
        
        if ($scope.budgetActuals.vesselCodeList == null || $scope.budgetActuals.vesselCodeList == "" || $scope.budgetActuals.vesselCodeList.length==0) {
            errorMsg = "Please select the Company"
        } else if ($scope.budgetActuals.fromDate == null || $scope.budgetActuals.fromDate == "") {
            errorMsg = "Please select the From Date "
        }
        
        else if ($scope.budgetActuals.toDate == null || $scope.budgetActuals.toDate == "") {
            errorMsg = "Please select the To Date "
        }
        
        if (errorMsg != "") {
            logger.logError(errorMsg);
        } else {
            $http.post($stateParams.tenantid+'/app/fibudgetactuals/budgetActualsExcelExport', $scope.budgetActuals).success(function(data) {
                console.log("avg report data");
                console.log(data);
                if (data.success == true) {
                    if (data.message == "1") {
                        $('#budgetActualsExportId').append('<a id="budgetActualsLink" stype="display:block" href="filePath/BudgetActuals.xls" download="BudgetActuals.xls"></a>');
                        $("#budgetActualsLink").bind('click', function() {
                        });
                        $('#budgetActualsLink').simulateClick('click');

                        logger.logSuccess("Excel Exported Successfully!");
                    } else {
                        logger.logError("Data Not Fount!");
                    }
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
            });
        }
        ;
    }
    $scope.cancel = function() {
        $location.path($stateParams.tenantid+"/reports/finance/budgetactuals/list");
    };
})

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
