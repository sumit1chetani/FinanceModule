define([ 'angular', 'angular-couch-potato', 'angular-ui-router', 'angular-resource', 'smart-table' ], function(ng, couchPotato) {

    "use strict";

    var module = ng.module('app.payroll.approval', [ 'ui.router', 'ngResource', 'smart-table' ]);

    couchPotato.configureApp(module)

    module.config(function($stateProvider, $couchPotatoProvider) {

        $stateProvider.state('app.payroll.approval', {
            abstract : true,
            data : {
                title : 'Approval'
            }
        }).state('app.payroll.approval.approvalmaster', {
            abstract : true,
            data : {
                title : 'Manage Approval'
            }
        }).state('app.payroll.approval.approvalmaster.list', {
            url : '/payroll/approval/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'approvalCtrl',
                    templateUrl : 'views/payroll/approval/approvalmaster/approvalmaster',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/approval/appmaster/approvalCtrl' ])
                    }
                }
            }
        })
        // AppMaster Add
        .state('app.payroll.approval.approvalmaster.add', {
            url : '/payroll/approval/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'approvalCtrl',
                    templateUrl : 'views/payroll/approval/approvalmaster/approvalmasterAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/approval/appmaster/approvalCtrl' ])
                    }
                }
            }
        })

        // Signature FOrm
        .state('app.payroll.approval.signaturemaster', {
            abstract : true,
            data : {
                title : 'Manage Signature'
            }
        }).state('app.payroll.approval.signaturemaster.list', {
            url : '/payroll/signature/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'signatureCtrl',
                    templateUrl : 'views/payroll/approval/signature/signaturemaster',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/approval/signature/signatureCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.approval.signaturemaster.add', {
            url : '/payroll/signature/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'signatureCtrl',
                    templateUrl : 'views/payroll/approval/signature/signaturemasterAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/approval/signature/signatureCtrl' ])
                    }
                }
            }
        })

    });

    module.run(function($couchPotato) {
        module.lazy = $couchPotato;
    });
    return module;
});