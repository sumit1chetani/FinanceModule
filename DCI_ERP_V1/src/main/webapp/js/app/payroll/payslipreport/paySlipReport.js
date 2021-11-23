//define([ 'payroll/payroll/payroll' ], function(module) {
    'use strict';
   // module.registerController('paySlipReportCtrl', function($scope, $state, $http, ngDialog, logger,$timeout, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {
   	app.controller('paySlipReportCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

    var day = new Date();
        var month = day.getMonth()+1;  
        var year = day.getFullYear();
        month = (month < 10 ? '0' : '') + month;
        
        $scope.payslipgeneration = {
            employeeId : '',
            departmentId : '',
            companyName : '',
            branchName : '',
            branchId : '',
            companyId : '',
            monthYear : '',
            month : '',
            year : year.toString(),
            isGenerate : false,
            isOnLoad : false

        };
        $rootScope.bulkmail = [];
        $scope.mailsend = [];

        $scope.monthList = [ {
            id : '01',
            text : 'January'
        }, {
            id : '02',
            text : 'February'
        }, {
            id : '03',
            text : 'March'
        }, {
            id : '04',
            text : 'April'
        }, {
            id : '05',
            text : 'May'
        }, {
            id : '06',
            text : 'June'
        }, {
            id : '07',
            text : 'July'
        }, {
            id : '08',
            text : 'August'
        }, {
            id : '09',
            text : 'September'
        }, {
            id : '10',
            text : 'October'
        }, {
            id : '11',
            text : 'November'
        }, {
            id : '12',
            text : 'December'
        }, ]

        console.log($scope.monthList)
        
        
        //mutiselectivity
        
        $timeout(function() { // You might need this timeout to be sure its run
            // after DOM render.
            $("#month").multiselect({
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : 'Select All',
                enableFiltering : true,
                enableCaseInsensitiveFiltering : true,
                filterPlaceholder : 'Search',
                onChange : function(element, checked) {
                    console.log(element);
                    var cc = "";
                    if ($scope.monthList.length > 0) {
                        $scope.payslipgeneration.month = '';
                        angular.forEach($scope.payslipgeneration.lmonth, function(item, key) {
                            if (cc == "") {
                                cc = item.id;
                            } else {
                                cc += "," + item.id;
                            }
                            $scope.payslipgeneration.month = cc;
                        });
                    }

                    else {
                        $scope.monthList = [];
                        $scope.monthList = 'Select';
                        $("#month").empty();
                    }
                }
            });
            $("#month").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5');
        }, 2, false);
        
        
        $scope.getMonthId = function(option) {
            return option.id;
        };

        $scope.isAuthorized = false;

        $scope.paySlipListDTO = [];

        $scope.getCompanyList = function() {
        	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
    				+ 'F0382').success(
    		function(datas) {  
           // $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                $scope.companyList = datas;
                
                if ($scope.companyList.length >= 1) {
                    $scope.payslipgeneration.companyId = $scope.companyList[0].id;
                    $scope.payslipgeneration.companyName = $scope.companyList[0].companyName;
                }
                
                
            })
        }

        $scope.$watch('payslipgeneration.companyId', function(newVal, oldVal) {
            var companyId = newVal;
            if ($scope.payslipgeneration.companyId != '' && $scope.payslipgeneration.isOnLoad == false) {
                $scope.payslipgeneration.branchId = '';
                $scope.payslipgeneration.branchName = '';
            }
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.payslipgeneration.isOnLoad = false;
                $scope.branchList = datas.branchList;
                if ($scope.branchList.length == 1) {
                    $scope.payslipgeneration.branchId = $scope.branchList[0].id;
                    $scope.payslipgeneration.branchName = $scope.branchList[0].text;
                }
                $scope.payslipgeneration.departmentId = '';
                $scope.departmentList = [];
                $scope.employeeList = [];
                console.log($scope.branchList);
            })
        });

        $scope.$watchCollection('[payslipgeneration.branchId,payslipgeneration.departmentId]', function(newValue, oldValue) {
            $scope.getEmployeeList($scope.payslipgeneration.branchId, $scope.payslipgeneration.departmentId);
        });

        $scope.getBranchList = function(companyId, branchID) {
            $http.post("payroll/payroll/payrollgeneration/getBranchList", companyId).success(function(datas) {
                if (datas.branchList.length == 1) {
                    $scope.branchList = datas.branchList;
                    $scope.payslipgeneration.branchId = datas.branchList[0].branchId;
                } else {
                    $scope.branchList = datas.branchList;
                    $scope.departmentList = [];
                    $scope.employeeList = [];
                }

            })
        }
        $scope.$watch('payslipgeneration.branchId', function(newValue, oldValue) {
            $scope.getDepartment($scope.payslipgeneration.branchId);
        });
        $scope.getDepartment = function(branchId) {
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList", branchId).success(function(datas) {
                $scope.departmentList = datas.departmentList;
                $scope.payslipgeneration.departmentId = '';
                $scope.employeeList = [];
            })
        }

        $scope.getEmployeeDetails = function() {
            debugger
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                $scope.getCompanyList();
                $scope.payslipgeneration.companyId = datas.companyId;
                $scope.payslipgeneration.companyName = datas.companyName;
                $scope.payslipgeneration.isOnLoad = true;
                $scope.getBranchList($scope.payslipgeneration.companyId, datas.branchId);
                $scope.payslipgeneration.branchName = datas.branchName;
                $scope.getDepartment(datas.branchId);

            })
        }

        $scope.getEmployeeDetails();

        $scope.getEmployeeList = function(branchId, departmentId) {
            var resultBean = {
                branchId : $scope.payslipgeneration.branchId,
                dept : $scope.payslipgeneration.departmentId
            };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList", resultBean).success(function(datas) {
                debugger
                $scope.employeeList = datas.employeeList;
                $scope.payslipgeneration.employeeId = '';
            })
        }

        $scope.getPaySlipYearList = function() {
            $http.get("payroll/payroll/payrollgeneration/getPaySlipYearList").success(function(datas) {
                $scope.paySlipYearList = datas.paySlipYearList;
            })
        }

        $scope.getPaySlipYearList();

        $scope.save = function(payslipReportForm) {
            if (new validationService().checkFormValidity($scope.payslipReportForm)) {
                if($scope.payslipgeneration.month!=null && $scope.payslipgeneration.month!=''){
            debugger
            $scope.payslipgeneration.isGenerate = false;
            var isValid = true;
            var companyId = $scope.payslipgeneration.companyId;
            var branchId = $scope.payslipgeneration.branchId;
            var dept = $scope.payslipgeneration.departmentId;
            if (dept == '' || dept == null || dept == undefined) {
            	dept = null;
            }
            var employeeId = $scope.payslipgeneration.employeeId;
            if (employeeId == '' || employeeId == null || employeeId == undefined) {
                employeeId = null;
            }
            var monthYear = $scope.payslipgeneration.month + $scope.payslipgeneration.year;
          //  var monthYear = $scope.payslipgeneration.month;
          //  var month = $scope.payslipgeneration.month;
           // var year =  $scope.payslipgeneration.year;
            var resultBean = {
                companyId : companyId,
                branchId : branchId,
                dept : dept,
                employeeId : employeeId,
                monthYear : monthYear,
               // month : month,
               // year : year
                
            }
            console.log("resultbean");
            console.log(resultBean);
            
            $http.post("payroll/payroll/payslip/generate", resultBean).success(function(response) {
                console.log("response");
                console.log(response);
                $scope.paySlipListDTO = response.paySlipListDTO.paySlipList;
                $rootScope.bulkmail = response.paySlipListDTO.paySlipList; // response.sample
                $scope.mailser = $rootScope.bulkmail;
                angular.forEach($scope.paySlipListDTO, function(value, key) {
                    value.totalEarnings = Math.round(value.totalEarnings);
                    value.totalDeductions = Math.round(value.totalDeductions);
                    value.lopAmount = Math.round(value.lopAmount);

                });

                if ($scope.paySlipListDTO.length == 0) {
                    logger.logError("Pay roll is not generated for the selected month and year!!!!")
                }
                $scope.payslipgeneration.isGenerate = true;

            });
                }else{
                    logger.logError("Pls Select Month.."); 
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.payslipReportForm.$validationSummary), 5000, 'trustedHtml');
            }  

        }

        $scope.printPaySlip = function(employeeId, departmentId) {

            $scope.payslipgeneration.isGenerate = true;
            var isValid = true;
            var companyId = $scope.payslipgeneration.companyId;
            var branchId = $scope.payslipgeneration.branchId;
            var dept = departmentId;
            /*
             * var departmentId = $scope.payslipgeneration.departmentId;
             * if(departmentId=='' || departmentId==null ||
             * departmentId==undefined){ departmentId=null; } var employeeId =
             * $scope.payslipgeneration.employeeId; if(employeeId==''||
             * employeeId==null || employeeId==undefined){ employeeId=null; }
             */
           //var monthYear = $scope.payslipgeneration.month;
           // var year =$scope.payslipgeneration.year;
            var monthYear = $scope.payslipgeneration.month + $scope.payslipgeneration.year;

            var url = 'payroll/payroll/payslip/print?companyId=' + companyId + '&branchId=' + branchId + '&dept=' + dept + '&employeeId=' + employeeId + '&monthYear=' + monthYear;
            var wnd = window.open(url, 'Title', 'width=500,height=700,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();

        }

        $scope.emailPaySlip = function(employeeId, departmentId) {
            // alert(employeeId, departmentId);
            $scope.callDialog($scope, employeeId, departmentId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, employeeId, departmentId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/payroll/payroll/payslipreport/paySlipReportMail',
                controller : $controller('paySlipMailCtrl', {
                    $scope : $scope,
                    employeeId : employeeId,
                    departmentId : departmentId,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        };

        $scope.bulkmail = function() {

            $scope.callDialog1($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog1 = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/payroll/payroll/payslipreport/paySlipReportBulkMail',
                controller : $controller('paySlipBulkMailCtrl', {
                    $scope : $scope,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        };

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

        $scope.exportExcel = function() {
            if (new validationService().checkFormValidity($scope.payslipReportForm)) {
                if($scope.payslipgeneration.month!=null && $scope.payslipgeneration.month!=''){
                var companyId = $scope.payslipgeneration.companyId;
                var branchId = $scope.payslipgeneration.branchId;
                var dept = $scope.payslipgeneration.departmentId;
                var employeeId = $scope.payslipgeneration.employeeId;
               // var monthYear = $scope.payslipgeneration.month;
              //  var month = $scope.payslipgeneration.month;
               // var year =  $scope.payslipgeneration.year;
                var  monthYear  = $scope.payslipgeneration.month + $scope.payslipgeneration.year;
                var isValid = true;
                if (companyId == '' || companyId == undefined) {
                    companyId = null;
                }
                if (branchId == '' || branchId == undefined) {
                    branchId = null;
                }
                if (dept == '' || dept == undefined) {
                	dept = null;
                }
                if (employeeId == '' || employeeId == undefined) {
                    employeeId = null;
                }
                var monthYear = $scope.payslipgeneration.month + $scope.payslipgeneration.year;

                var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    dept : dept,
                    employeeId : employeeId,
                    monthYear : monthYear,
                  //  month : month,
                   // year : year
                }

                console.log("exportResultBean");
                console.log(resultBean);
              /*  $http.post('payroll/payroll/payslip/exportExcel', resultBean).success(function(data) {

                    console.log("export report");
                    console.log(data);
                    if (data.success == true) {

                        logger.logSuccess("File Exported Successfully");
                        $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/PaySlip.xls" class="control-label" download="PaySlip.xls"></a>');
                        $("#captainMsglink").bind('click', function() {
                        });
                        $('#captainMsglink').simulateClick('click');
                    } else {

                        logger.logError("Error Please Try Again");

                    }
                }).error(function(data) {
                });
                
*/                
           	 $http.post('payroll/payroll/payslip/exportExcel', resultBean).success(function(data) {
                 if(data){
                     debugger;
                     $("#Export").bind('click', function() {
                     });
                     $('#Export').simulateClick('click');
                     logger.logSuccess("Exported successfully!");
                 }else{
                     logger.logError("Failed to export");
                     $scope.esiGeneration.Show = false;

                 }
                 
             }).error(function(data) {
                 logger.logError("Error Please Try Again");
             });
                
                }else{
                    logger.logError("Pls Select Month.."); 
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.payslipReportForm.$validationSummary), 5000, 'trustedHtml');
            }

        };

    });

    module.registerController('paySlipMailCtrl', function($scope, employeeId, departmentId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.paySlipReport = {
            emailAddress : ''
        };

        $scope.validateEmail = function(email) {
            var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if (reg.test(email)) {
                return true;
            } else {
                return false;
            }
        }

        $http.get('payroll/payroll/payslip/mailid?employeeId=' + employeeId).success(function(data) {

            $scope.paySlipReport.emailAddress = data.email;

        })

        var dept = departmentId;
        var employeeId = employeeId;
        $scope.cancelEmail = function() {
            ngDialog.close();
        }

        $scope.emailPaySlipReport = function(emailAddress) {
            debugger;

            var flag = true;
            flag = $scope.validateEmail(emailAddress);

            if (flag == false) {
                logger.logError("Please Enter Valid Email Address");
            } else {

                $scope.payslipgeneration.isGenerate = true;
                var isValid = true;
                var companyId = $scope.payslipgeneration.companyId;
                var branchId = $scope.payslipgeneration.branchId;

                if (dept == '' || dept == null || dept == undefined) {
                	dept = null;
                }

                if (employeeId == '' || employeeId == null || employeeId == undefined) {
                    employeeId = null;
                }
                var month = $scope.payslipgeneration.month;
                
                var year = $scope.payslipgeneration.year;
                var monthYear = $scope.payslipgeneration.monthYear + $scope.payslipgeneration.year;

                $http.get('payroll/payroll/payslip/sendMail?companyId=' + companyId + '&branchId=' + branchId + '&dept=' + dept + '&employeeId=' + employeeId + '&monthYear=' + monthYear  + '&emailAddress=' + emailAddress).success(function(data) {
                    if (data.success == true) {
                        logger.logSuccess("Mail Sent Successfully!");
                        ngDialog.close();
                    } else {
                        logger.logError("Unable to send mail!");
                        ngDialog.close();
                    }
                }).error(function(data) {
                    console.log("data" + data);
                });

            }
        };

    });

    module.registerController('paySlipBulkMailCtrl', function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.paySlipReport = {

            mailsend : [],

            emailAddress : '',

            mailId : []
        };
        $scope.test = [];

        $scope.validateEmail = function(email) {
            var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if (reg.test(email)) {
                return true;
            } else {
                return false;
            }
        }

        /*
         * $http.get('payroll/payroll/payslip/mailid?employeeId=' +
         * employeeId).success(function(data) { console.log(data);
         * $scope.paySlipReport.emailAddress = data.email; })
         */
        $scope.test = $rootScope.bulkmail;

        $http.post('payroll/payroll/payslip/bulkmailid', $scope.test).success(function(data) {
            console.log(data);
            $scope.paySlipReport.mailsend = data.emailList;

        })

        // $scope.chkAll = false;
        //           
        //           
        // $scope.checkAll = function(checkFull) {
        // if (checkFull) {
        // for (var i = 0; 1 < $scope.mailsend.length(); i++) {
        // $scope.Collection[i].select = true;
        // }
        //
        // } else {
        // for (var i = 0; 1 < Collection.length(); i++) {
        // $scope.Collection[i].select = false;
        // }
        // }
        //
        // angular.forEach($scope.rowCollection, function(paySlipReport) {
        // paySlipReport.select = $scope.chkAll;
        // });
        //
        // };

        $scope.checkAll = function(checkFull) {
            if (checkFull) {
                for (var i = 0; i < $scope.paySlipReport.mailsend.length; i++) {
                    $scope.paySlipReport.mailsend[i].select = true;
                }
            } else
                for (var i = 0; i < $scope.paySlipReport.mailsend.length; i++) {
                    $scope.paySlipReport.mailsend[i].select = false;

                }
        }

        var dept = departmentId;
        var employeeId = employeeId;
        $scope.cancelEmail = function() {
            ngDialog.close();
        }

        $scope.emailPaySlipReport = function(paySlipReport) {
            debugger;

            angular.forEach(paySlipReport.mailsend, function(value, key) {
                if (value.select == true) {
                    value.select == true
                } else {
                    value.select == false
                }
            });

            var data = {
                'companyId' : $scope.payslipgeneration.companyId,
                'branchId' : $scope.payslipgeneration.branchId,
               // 'month' : $scope.payslipgeneration.month,
             //   'year' : $scope.payslipgeneration.year,
                'monthYear' : $scope.payslipgeneration.monthYear + $scope.payslipgeneration.year,
                'mailSend' : paySlipReport.mailsend

            }

            $scope.payslipgeneration.isGenerate = true;
            var isValid = true;
            var companyId = $scope.payslipgeneration.companyId;
            var branchId = $scope.payslipgeneration.branchId;

            if (dept == '' || dept == null || dept == undefined) {
            	dept = null;
            }

            if (employeeId == '' || employeeId == null || employeeId == undefined) {
                employeeId = null;
            }
            var monthYear = $scope.payslipgeneration.monthYear + $scope.payslipgeneration.year;

            $http.post('payroll/payroll/payslip/sendMailBulk', data).success(function(data) {
                if (data.success == true) {

                    logger.logSuccess("Mail Sent Successfully!");
                    ngDialog.close();

                } else {
                    logger.logError("Unable to send mail!");
                    ngDialog.close();
                }
            }).error(function(data) {
                console.log("data" + data);
            });

        }
        // };

    
});