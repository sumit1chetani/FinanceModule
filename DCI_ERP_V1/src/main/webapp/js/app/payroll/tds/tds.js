define([ 'angular', 'angular-couch-potato', 'angular-ui-router', 'angular-resource', 'smart-table' ], function(ng, couchPotato) {

    "use strict";

    var module = ng.module('app.payroll.tds', [ 'ui.router', 'ngResource', 'smart-table' ]);

    couchPotato.configureApp(module)
    module.config(function($stateProvider, $couchPotatoProvider) {

        $stateProvider.state('app.payroll.tds', {
            abstract : true,
            data : {
                title : 'TDS'
            }
        })

        $stateProvider.state('app.payroll.tds.taxsection', {
            abstract : true,
            data : {
                title : 'TAX Section'
            }
        })

        .state('app.payroll.tds.taxsection.list', {
            url : '/payroll/taxsection/list',
            data : {
                title : 'Tax Section'
            },
            views : {
                "content@app" : {
                    controller : 'taxSection',
                    templateUrl : 'views/payroll/tds/taxsection/taxSection',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/taxsection/taxSection' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.taxsection.edit', {
            url : '/payroll/taxsection/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'taxSectionAddCtrl',
                    templateUrl : 'views/payroll/tds/taxsection/taxSectionAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/taxsection/taxSectionAddCtrl' ])
                    }
                }
            }
        })

        $stateProvider.state('app.payroll.tds.taxsubsection', {
            abstract : true,
            data : {
                title : 'Tax Sub Section'
            }
        })

        .state('app.payroll.tds.taxsubsection.list', {
            url : '/payroll/taxsubsection/list',
            data : {
                title : 'Tax Sub Section'
            },
            views : {
                "content@app" : {
                    controller : 'taxSubSectionCtrl',
                    templateUrl : 'views/payroll/tds/taxsubsection/taxSubSection',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/taxsubsection/taxSubSection' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.taxsubsection.edit', {
            url : '/payroll/taxsubsection/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'taxSubSectionAddCtrl',
                    templateUrl : 'views/payroll/tds/taxsubsection/taxSubSectionAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/taxsubsection/taxSubSectionAddCtrl' ])
                    }
                }
            }
        })

        // Slab Rate

        .state('app.payroll.tds.slabrate', {
            abstract : true,
            data : {
                title : 'Slab Rate'
            }
        })

        .state('app.payroll.tds.slabrate.list', {
            url : '/payroll/slabrate/list',
            data : {
                title : 'Slab Rate'
            },
            views : {
                "content@app" : {
                    controller : 'slapRateCtrl',
                    templateUrl : 'views/payroll/tds/slabrate/slabRate',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/slabrate/slabRate' ])
                    }
                }
            }
        }).state('app.payroll.tds.slabrate.add', {
            url : '/payroll/slabrate/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'slabRateAddCtrl',
                    templateUrl : 'views/payroll/tds/slabrate/slabRateAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/slabrate/slabRateAddCtrl' ])
                    }
                }
            }
        }).state('app.payroll.tds.slabrate.edit', {
            url : '/payroll/slabrate/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'slabRateAddCtrl',
                    templateUrl : 'views/payroll/tds/slabrate/slabRateAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/slabrate/slabRateAddCtrl' ])
                    }
                }
            }
        })

        $stateProvider.state('app.payroll.tds.ptslab', {
            abstract : true,
            data : {
                title : 'PT Slab'
            }
        })

        .state('app.payroll.tds.ptslab.list', {
            url : '/payroll/ptslab/list',
            data : {
                title : 'PT Slab'
            },
            views : {
                "content@app" : {
                    controller : 'ptSlapCtrl',
                    templateUrl : 'views/payroll/tds/ptslab/ptSlab',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/ptslab/ptSlab' ])
                    }
                }
            }
        })
        // PT Slap Add Form
        .state('app.payroll.tds.ptslab.add', {
            url : '/payroll/ptslab/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'ptSlabAddCtrl',
                    templateUrl : 'views/payroll/tds/ptslab/ptSlabAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/ptslab/ptSlabAddCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.ptslab.edit', {
            url : '/payroll/ptslab/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'ptSlabAddCtrl',
                    templateUrl : 'views/payroll/tds/ptslab/ptSlabAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/ptslab/ptSlabAddCtrl' ])
                    }
                }
            }
        })

        $stateProvider.state('app.payroll.tds.otherheadentry', {
            abstract : true,
            data : {
                title : 'Employee Other Income Declaration'
            }
        })

        .state('app.payroll.tds.otherheadentry.list', {
            url : '/payroll/otherheadentry/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'otherHeadEntryCtrl',
                    templateUrl : 'views/payroll/tds/otherheadentry/otherHeadEntry',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/otherheadentry/otherHeadEntry' ])
                    }
                }
            }
        })

        // EMPLOYEE TDS DECLARATION

        $stateProvider.state('app.payroll.tds.emptdsdeclaration', {
            abstract : true,
            data : {
                title : 'Employee TDS Declaration'
            }
        })

        $stateProvider.state('app.payroll.tds.emptdsactuval', {
            abstract : true,
            data : {
                title : 'Employee TDS Actuval'
            }
        })

        .state('app.payroll.tds.emptdsactuval.list', {
            url : '/payroll/emptdsactuval/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'employeeTdsDeclarationCtrl',
                    templateUrl : 'views/payroll/tds/emptdsdeclaration/employeeTdsActual',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/emptdsdeclaration/employeeTdsDeclarationCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.emptdsdeclaration.list', {
            url : '/payroll/emptdsdeclaration/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'employeeTdsDeclarationCtrl',
                    templateUrl : 'views/payroll/tds/emptdsdeclaration/empTdsDeclarationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/emptdsdeclaration/employeeTdsDeclarationCtrl' ])
                    }
                }
            }
        })

        $stateProvider.state('app.payroll.tds.tdsdecuted', {
            abstract : true,
            data : {
                title : 'TDS Deducted'
            }
        })

        .state('app.payroll.tds.tdsdecuted.list', {
            url : '/payroll/tdsdecuted/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'tdsdecutedCtrl',
                    templateUrl : 'views/payroll/tds/tdsdecuted/TdsDeductedList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/tdsdecuted/tdsdecutedCtrl' ])
                    }
                }
            }
        })

        /*
         * .state('app.payroll.tds.emptdsdeclaration.actuallist', { url :
         * '/payroll/emptdsdeclaration/actuallist', data : { title : 'List' },
         * views : { "content@app" : { controller :
         * 'employeeTdsDeclarationCtrl', templateUrl :
         * 'views/payroll/tds/emptdsdeclaration/employeeTdsActual',
         * 
         * resolve : { deps : $couchPotatoProvider.resolveDependencies([
         * 'payroll/tds/emptdsdeclaration/employeeTdsDeclarationCtrl' ]) } } } })
         */

        // HrA entry
        .state('app.payroll.tds.hraentry', {
            url : '/payroll/hraentry/list',
            data : {
                title : 'Hra Entry'
            },
            views : {
                "content@app" : {
                    controller : 'hraEntryCtrl',
                    templateUrl : 'views/payroll/tds/hraentry/hraEntryList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/hraentry/hraEntryCtrl' ])
                    }
                }
            }
        })

        // Hra Entry Add
        .state('app.payroll.tds.hraentry.add', {
            url : '/payroll/hraentry/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'hraEntryCtrl',
                    templateUrl : 'views/payroll/tds/hraentry/hraEntryAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/hraentry/hraEntryCtrl' ])
                    }
                }
            }
        })

        $stateProvider.state('app.payroll.tds.otherincome', {
            abstract : true,
            data : {
                title : 'Other Income Master'
            }
        })

        // other INcome Tax
        .state('app.payroll.tds.otherincome.list', {
            url : '/payroll/otherincometax/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'otherincomeCtrl',
                    templateUrl : 'views/payroll/tds/otherincometax/otherincomeList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/otherincome/otherincomeCtrl' ])
                    }
                }
            }
        })

        // other Income Tax Add
        .state('app.payroll.tds.otherincome.add', {
            url : '/payroll/otherincometax/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'otherincomeAddCtrl',
                    templateUrl : 'views/payroll/tds/otherincometax/otherincomeAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/otherincome/otherincomeCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.nscinterset', {
            abstract : true,
            data : {
                title : 'NSC Interset'
            }
        })

        // nsc Intrest Rate

        .state('app.payroll.tds.nscinterset.list', {
            url : '/payroll/nscinterset/list',
            data : {
                title : 'NSC Interest'
            },
            views : {
                "content@app" : {
                    controller : 'nscintersetCtrl',
                    templateUrl : 'views/payroll/tds/nscinterset/nscintersetList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/nscinterset/nscintersetCtrl' ])
                    }
                }
            }
        })

        // nsc Intrest Rate

        .state('app.payroll.tds.nscinterset.edit', {
            url : '/payroll/nscinterset/edit',
            data : {
                title : 'NSC Interest'
            },
            views : {
                "content@app" : {
                    controller : 'nscintersetCtrl',
                    templateUrl : 'views/payroll/tds/nscinterset/nscintersetList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/nscinterset/nscintersetCtrl' ])
                    }
                }
            }
        })

        // Employee Tax Parameter

        .state('app.payroll.tds.employeetax', {
            abstract : true,
            data : {
                title : 'Employee Tax Parameter'
            }
        })

        .state('app.payroll.tds.employeetax.list', {
            url : '/payroll/employeetax/list',
            data : {
                title : 'Employee Tax Parameter'
            },
            views : {
                "content@app" : {
                    controller : 'employeetaxCtrl',
                    templateUrl : 'views/payroll/tds/employeetax/employeetaxList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeetax/employeetaxCtrl' ])
                    }
                }
            }
        })

        // Employee Tax Add
        .state('app.payroll.tds.employeetax.add', {
            url : '/payroll/employeetax/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'employeeTaxAddCtrl',
                    templateUrl : 'views/payroll/tds/employeetax/employeetaxAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeetax/employeeTaxAddCtrl' ])
                    }
                }
            }
        })

        // Employee Tax Edit
        .state('app.payroll.tds.employeetax.edit', {
            url : '/payroll/employeetax/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'employeeTaxAddCtrl',
                    templateUrl : 'views/payroll/tds/employeetax/employeetaxAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeetax/employeeTaxAddCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.employeehra', {
            abstract : true,
            data : {
                title : 'Employee HRA'
            }
        })

        // Employee Hra

        .state('app.payroll.tds.employeehra.list', {
            url : '/payroll/employeehra/list',
            data : {
                title : 'Employee HRA'
            },
            views : {
                "content@app" : {
                    controller : 'employeehraCtrl',
                    templateUrl : 'views/payroll/tds/employeehra/employeehraList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeehra/employeehraCtrl' ])
                    }
                }
            }
        })

        // Employee HRA Add

        .state('app.payroll.tds.employeehra.add', {
            url : '/payroll/tds/employeehra/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'employeehraaddCtrl',
                    templateUrl : 'views/payroll/tds/employeehra/employeehraAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeehra/employeehraaddCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.employeehra.edit', {
            url : '/payroll/tds/employeehra/edit',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'employeehraaddCtrl',
                    templateUrl : 'views/payroll/tds/employeehra/employeehraAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeehra/employeehraaddCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.employeehra.approve', {
            url : '/payroll/tds/employeehra/approve',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'employeehraapproveCtrl',
                    templateUrl : 'views/payroll/tds/employeehra/employeehraApprove',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeehra/employeehraapproveCtrl' ])
                    }
                }
            }
        })

        // Employee TDS Generation

        .state('app.payroll.tds.employeetdsgeneration', {
            abstract : true,
            data : {
                title : 'Employee Tds Generation'
            }
        })

        // Employee Hra

        .state('app.payroll.tds.employeetdsgeneration.list', {
            url : '/payroll/employeetdsgeneration/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'employeeTdsGenerationCtrl',
                    templateUrl : 'views/payroll/tds/employeetdsgeneration/employeeTdsGenerationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeetdsgeneration/employeeTdsGenerationCtrl' ])
                    }
                }
            }
        })

        // Employee TDS Generation

        .state('app.payroll.tds.employeeepfgeneration', {
            abstract : true,
            data : {
                title : 'Employee EPF Generation'
            }
        })

        // Employee Hra

        .state('app.payroll.tds.employeeepfgeneration.list', {
            url : '/payroll/employeeepfgeneration/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'employeeEpfGenerationCtrl',
                    templateUrl : 'views/payroll/tds/employeeepfgeneration/employeeEpfGenerationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeeepfgeneration/employeeEpfGenerationCtrl' ])
                    }
                }
            }
        })

        // Employee TDS
        .state('app.payroll.tds.employeetds', {
            url : '/payroll/employeetds/list',
            data : {
                title : 'Employee TDS'
            },
            views : {
                "content@app" : {
                    controller : 'employeetdsCtrl',
                    templateUrl : 'views/payroll/tds/employeetds/employeetdsList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeetds/employeetdsCtrl' ])
                    }
                }
            }
        })

        .state('app.payroll.tds.employeetds.add', {
            url : '/payroll/employeetds/add',
            data : {
                title : 'Employee TDS Add'
            },
            views : {
                "content@app" : {
                    controller : 'employeetdsAddCtrl',
                    templateUrl : 'views/payroll/tds/employeetds/employeetdsAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'payroll/tds/employeetds/employeetdsAddCtrl' ])
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