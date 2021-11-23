define([ 'angular', 'angular-couch-potato', 'angular-ui-router', 'angular-resource', 'smart-table' ], function(ng, couchPotato) {

    "use strict";

    
    
    var module = ng.module('app.hospital.accounts', [ 'ui.router', 'ngResource', 'smart-table' ]);

    couchPotato.configureApp(module);
    module.config(function($stateProvider, $couchPotatoProvider) {

        $stateProvider.state('app.hospital.accounts', {
            abstract : true,
            data : {
                title : 'Accounts'
            }
        })

        .state('app.hospital.accounts.accountHead', {
            abstract : true,
            data : {
                title : 'Account Head'
            }
        })

        .state('app.hospital.accounts.accountHead.list', {
            url : '/hospital/accounts/accountHead/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'accountHeadListCtrl',
                    templateUrl : 'views/hospital/accounts/accountHead/AccountHeadList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountHead/accountHeadListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.accountHead.add', {
            url : '/hospital/accounts/accountHead/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'accountHeadAddCtrl',
                    templateUrl : 'views/hospital/accounts/accountHead/AccountHeadAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountHead/accountHeadAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.subGroupAccount', {
            abstract : true,
            data : {
                title : 'Sub Group Account'
            }
        })

        .state('app.hospital.accounts.subGroupAccount.list', {
            url : '/hospital/accounts/subGroupAccount/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'subGroupAccountListCtrl',
                    templateUrl : 'views/hospital/accounts/subGroupAccount/subGroupAccountList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/subGroupAccount/subGroupAccountCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.subGroupAccount.add', {
            url : '/hospital/accounts/subGroupAccount/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'subGroupAccountAddCtrl',
                    templateUrl : 'views/hospital/accounts/subGroupAccount/subGroupAccountAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/subGroupAccount/subGroupAccountCtrl.js' ])
                    }
                }
            }
        })
        .state('app.hospital.accounts.subHeadGroupAccount', {
            abstract : true,
            data : {
                title : 'Sub Group Headings'
            }
        })

        .state('app.hospital.accounts.subHeadGroupAccount.list', {
            url : '/hospital/accounts/subHeadGroupAccount/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'subHeadGroupAccountListCtrl',
                    templateUrl : 'views/hospital/accounts/subHeadGroupAccount/subHeadGroupAccountList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/subHeadGroupAccount/subHeadGroupAccountCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.subHeadGroupAccount.add', {
            url : '/hospital/accounts/subHeadGroupAccount/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'subHeadGroupAccountAddCtrl',
                    templateUrl : 'views/hospital/accounts/subHeadGroupAccount/subHeadGroupAccountAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/subHeadGroupAccount/subHeadGroupAccountCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.exchangeRate', {
            abstract : true,
            data : {
                title : 'Exchange Rate'
            }
        })

        .state('app.hospital.accounts.exchangeRate.list', {
            url : '/hospital/accounts/exchangeRate/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'exchangeRateListCtrl',
                    templateUrl : 'views/hospital/accounts/exchangeRate/exchangeRateList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/exchangeRate/exchangeRateListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.exchangeRate.add', {
            url : '/hospital/accounts/exchangeRate/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'exchangeRateAddCtrl',
                    templateUrl : 'views/hospital/accounts/exchangeRate/exchangeRateAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/exchangeRate/exchangeRateAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.exchangeRate.edit', {
            url : '/hospital/accounts/exchangeRate/edit/:exchangeRateCode',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'exchangeRateAddCtrl',
                    templateUrl : 'views/hospital/accounts/exchangeRate/exchangeRateAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/exchangeRate/exchangeRateAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.groupHead', {
            abstract : true,
            data : {
                title : 'Group Head'
            }
        })

        .state('app.hospital.accounts.groupHead.list', {
            url : '/hospital/accounts/groupHead/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'groupHeadListCtrl',
                    templateUrl : 'views/hospital/accounts/groupHead/groupHeadList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/groupHead/groupHeadCtrl.js' ])
                    }
                }
            }
        })

     /*   .state('app.hospital.accounts.creditNote', {
            abstract : true,
            data : {
                title : 'Credit Note'
            }
        })

        .state('app.hospital.accounts.creditNote.list', {
            url : '/hospital/accounts/creditNote/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'creditNoteListCtrl',
                    templateUrl : 'views/hospital/accounts/creditNote/creditNoteList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.creditNote.add', {
            url : '/hospital/accounts/creditNote/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'creditNoteAddCtrl',
                    templateUrl : 'views/hospital/accounts/creditNote/creditNoteAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.creditNote.edit', {
            url : '/hospital/accounts/creditNote/edit/:creditNoteCode',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'creditNoteAddCtrl',
                    templateUrl : 'views/hospital/accounts/creditNote/creditNoteAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteAddCtrl.js' ])
                    }
                }
            }
        })
         .state('app.hospital.accounts.creditNote.view', {
            url : '/hospital/accounts/creditNote/view/:creditNoteCode',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'creditNoteAddCtrl',
                    templateUrl : 'views/hospital/accounts/creditNote/creditNoteView',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNote/creditNoteAddCtrl.js' ])
                    }
                }
            }
        })*/

        .state('app.hospital.accounts.debitNote', {
            abstract : true,
            data : {
                title : 'Debit Note'
            }
        })

        .state('app.hospital.accounts.debitNote.list', {
            url : '/hospital/accounts/debitNote/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'debitNoteListCtrl',
                    templateUrl : 'views/hospital/accounts/debitNote/debitNoteList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.debitNote.add', {
            url : '/hospital/accounts/debitNote/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'debitNoteAddCtrl',
                    templateUrl : 'views/hospital/accounts/debitNote/debitNoteAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.debitNote.edit', {
            url : '/hospital/accounts/debitNote/edit/:debitNoteCode',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'debitNoteAddCtrl',
                    templateUrl : 'views/hospital/accounts/debitNote/debitNoteAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
                    }
                }
            }
        })
         .state('app.hospital.accounts.debitNote.view', {
            url : '/hospital/accounts/debitNote/view/:debitNoteCode',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'debitNoteAddCtrl',
                    templateUrl : 'views/hospital/accounts/debitNote/debitNoteView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNote/debitNoteCtrl.js' ])
                    }
                }
            }
        })
        

        .state('app.hospital.accounts.salesorder', {
            abstract : true,
            data : {
                title : 'Sales Order'
            }
        }).state('app.hospital.accounts.salesorder.list', {
            url : '/hospital/accounts/salesorder/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'salesorderListCtrl',
                    templateUrl : 'views/hospital/accounts/salesorder/salesorderList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/salesorder/salesorderListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.salesorder.add', {
            url : '/hospital/accounts/salesorder/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'salesorderAddCtrl',
                    templateUrl : 'views/hospital/accounts/salesorder/salesorderAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/salesorder/salesorderAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.salesorder.edit', {
            url : '/hospital/accounts/salesorder/edit/:salesOrderId',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'salesorderAddCtrl',
                    templateUrl : 'views/hospital/accounts/salesorder/salesorderAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/salesorder/salesorderAddCtrl.js' ])
                    }
                }
            }
        })

        // Purchase Invoice
        .state('app.hospital.accounts.purchaseinvoice', {
            abstract : true,
            data : {
                title : 'Purchase Invoice'
            }
        }).state('app.hospital.accounts.purchaseinvoice.add', {
            url : '/hospital/accounts/purchaseInvoice/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'purchaseInvoiceAddCtrl',
                    templateUrl : 'views/hospital/accounts/purchaseInvoice/purchaseInvoiceAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseInvoice/purchaseInvoiceAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.purchaseinvoice.list', {
            url : '/hospital/accounts/purchaseInvoice/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'purchaseInvoiceListCtrl',
                    templateUrl : 'views/hospital/accounts/purchaseInvoice/purchaseInvoiceList',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseInvoice/purchaseInvoiceListCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.purchaseinvoice.edit', {
            url : '/hospital/accounts/purchaseInvoiceEdit/:purchaseInvoiceNo',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'purchaseInvoiceAddCtrl',
                    templateUrl : 'views/hospital/accounts/purchaseInvoice/purchaseInvoiceEdit',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseInvoice/purchaseInvoiceAddCtrl.js' ])
                    }
                }
            }
        })
        
        //general purchase invoice
        
        .state('app.hospital.accounts.generalpurchaseinvoice', {
            abstract : true,
            data : {
                title : 'Service Order'
            }
        }).state('app.hospital.accounts.generalpurchaseinvoice.add', {
            url : '/hospital/accounts/generalPurchaseInvoice/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'generalPurchaseInvoiceAddCtrl',
                    templateUrl : 'views/hospital/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.generalpurchaseinvoice.list', {
            url : '/hospital/accounts/generalPurchaseInvoice/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'generalPurchaseInvoiceListCtrl',
                    templateUrl : 'views/hospital/accounts/generalPurchaseInvoice/generalPurchaseInvoiceList',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/generalPurchaseInvoice/generalPurchaseInvoiceListCtrl.js' ])
                    }
                }
            }
        })
        
        .state('app.hospital.accounts.generalpurchaseinvoice.edit', {
            url : '/hospital/accounts/generalPurchaseInvoiceEdit/:purchaseInvoiceNo',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'generalPurchaseInvoiceAddCtrl',
                    templateUrl : 'views/hospital/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/generalPurchaseInvoice/generalPurchaseInvoiceAddCtrl.js' ])
                    }
                }
            }
        })
        

        // Domestic GRN
        .state('app.hospital.accounts.grn', {
            abstract : true,
            data : {
                title : 'Domestic GRN'
            }
        }).state('app.hospital.accounts.grn.add', {
            url : '/hospital/accounts/grn/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'grnAddCtrl',
                    templateUrl : 'views/hospital/accounts/grn/grnAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/grn/grnAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.grn.list', {
            url : '/hospital/accounts/grn/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'grnListCtrl',
                    templateUrl : 'views/hospital/accounts/grn/grnList',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/grn/grnListCtrl.js' ])
                    }
                }
            }
        })

        // Currency
        .state('app.hospital.accounts.currency', {
            abstract : true,
            data : {
                title : 'Currency'
            }
        }).state('app.hospital.accounts.currency.list', {
            url : '/hospital/accounts/currency/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'currencyListCtrl',
                    templateUrl : 'views/hospital/accounts/currency/currencyList',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/currency/currencyListCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.currency.add', {
            url : '/hospital/accounts/currency/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'currencyAddCtrl',
                    templateUrl : 'views/hospital/accounts/currency/currencyAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/currency/currencyAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.currency.edit', {
            url : '/hospital/accounts/currency/edit/:currencyCode',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'currencyAddCtrl',
                    templateUrl : 'views/hospital/accounts/currency/currencyAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/currency/currencyAddCtrl.js' ])
                    }
                }
            }
        })
        // Invoice//
        .state('app.hospital.accounts.invoice', {
            abstract : true,
            data : {
                title : 'General Invoice'
            }
        })

        .state('app.hospital.accounts.invoice.list', {
            url : '/hospital/accounts/invoice/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'generalInvoiceCtrl',
                    templateUrl : 'views/hospital/accounts/invoice/invoiceList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/invoice/generalInvoiceCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.invoice.add', {
            url : '/hospital/accounts/invoice/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'generalInvoiceCtrladd',
                    templateUrl : 'views/hospital/accounts/invoice/invoiceAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/invoice/generalInvoiceCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.invoice.edit', {
            url : '/hospital/accounts/invoiceedit/:invoiceNo',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'generalInvoiceCtrladd',
                    templateUrl : 'views/hospital/accounts/invoice/invoiceAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/invoice/generalInvoiceCtrl.js' ])
                    }
                }
            }
        })
        // Journal Voucher
        .state('app.hospital.accounts.journalvoucher', {
            abstract : true,
            data : {
                title : 'Journal Voucher'
            }
        })

        .state('app.hospital.accounts.journalvoucher.list', {
            url : '/hospital/accounts/journalvoucher/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'journalVoucherListCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.journalvoucher.add', {
            url : '/hospital/accounts/journalvoucher/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'journalVoucherAddCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.journalvoucher.edit', {
            url : '/hospital/accounts/journalvoucher/edit/:jvNumber',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'journalVoucherAddCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                    }
                }
            }
        })
        .state('app.hospital.accounts.journalvoucher.view', {
            url : '/hospital/accounts/journalvoucher/view/:jvNumber',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'journalVoucherAddCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                    }
                }
            }
        })
         
        .state('app.hospital.accounts.journalvoucher.copyJournalVoucher', {
            url : '/hospital/accounts/journalvoucher/copyJournalVoucher/:jvNumber',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'journalVoucherAddCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucher/journalVoucherAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucher/journalVoucherListCtrl.js' ])
                    }
                }
            }
        })
        
        
        
        
     
        // Manage Taxes
        .state('app.hospital.accounts.manageTaxes', {
            abstract : true,
            data : {
                title : 'Manage Taxes'
            }
        })

        .state('app.hospital.accounts.manageTaxes.list', {
            url : '/hospital/accounts/manageTaxes/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'manageTaxesListCtrl',
                    templateUrl : 'views/hospital/accounts/manageTaxes/manageTaxesList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageTaxes/manageTaxesListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageTaxes.add', {
            url : '/hospital/accounts/manageTaxes/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'manageTaxesAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageTaxes/manageTaxesAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageTaxes/manageTaxesAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageTaxes.edit', {
            url : '/hospital/accounts/manageTaxes/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'manageTaxesAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageTaxes/manageTaxesAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageTaxes/manageTaxesAddCtrl.js' ])
                    }
                }
            }
        })

        
        
        
        // Manage Cheque Book
        .state('app.hospital.accounts.chqBook', {
            abstract : true,
            data : {
                title : 'Manage Cheque Book'
            }
        })

        .state('app.hospital.accounts.chqBook.list', {
            url : '/hospital/accounts/chqBook/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'chqBookListCtrl',
                    templateUrl : 'views/hospital/accounts/chqBook/chqBookList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqBook/chqBookListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chqBook.add', {
            url : '/hospital/accounts/chqBook/add',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'chqBookAddCtrl',
                    templateUrl : 'views/hospital/accounts/chqBook/chqBookAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqBook/chqBookAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chqBook.edit', {
            url : '/hospital/accounts/chqBook/edit/:chqBookId',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'chqBookEditCtrl',
                    templateUrl : 'views/hospital/accounts/chqBook/chqBookAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqBook/chqBookAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageFinancialYear', {
            abstract : true,
            data : {
                title : 'Manage Financial Year'
            }
        })

        .state('app.hospital.accounts.manageFinancialYear.list', {
            url : '/hospital/accounts/manageFinancialYear/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'manageFinancialYearCtrl',
                    templateUrl : 'views/hospital/accounts/manageFinancialYear/manageFinancialYear',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageFinancialYear/manageFinancialYearCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageFinancialYear.add', {
            url : '/hospital/accounts/manageFinancialYear/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'manageFinancialYearAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageFinancialYear/manageFinancialYearAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageFinancialYear/manageFinancialYearAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.trialBalance', {
            abstract : true,
            data : {
                title : 'Trial Balance'
            }
        })

        .state('app.hospital.accounts.trialBalance.list', {
            url : '/hospital/accounts/trialBalance/view',
            data : {
                title : 'Trial Balance'
            },
            views : {
                "content@app" : {
                    controller : 'trialBalanceCtrl',
                    templateUrl : 'views/hospital/accounts/trialBalance/trialBalance',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/trialBalance/trialBalanceCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.accountPayableAgewise', {
            abstract : true,
            data : {
                title : 'Accounts Payable'
            }
        })

        .state('app.hospital.accounts.accountPayableAgewise.view', {
            url : '/hospital/accounts/accountspayable/view',
            data : {
                title : 'Accounts Payable'
            },
            views : {
                "content@app" : {
                    controller : 'accountspayableCtrl',
                    templateUrl : 'views/hospital/accounts/accountspayable/accountspayable',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountspayable/accountspayable.js' ])
                    }
                }
            }
        })

        // Accounts receivable

        .state('app.hospital.accounts.accountReceivable', {
            abstract : true,
            data : {
                title : 'Accounts Receivable'
            }
        })

        .state('app.finance.accounts.accountReceivable.view', {
            url : '/hospital/accounts/accountReceivable/view',
            data : {
                title : 'Accounts Receivable'
            },
            views : {
                "content@app" : {
                    controller : 'accountsRecivableCtrl',
                    templateUrl : 'views/hospital/accounts/accountReceivable/accountReceivable',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountReceivable/accountReceivable.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chartOfAccounts', {
            abstract : true,
            data : {
                title : 'Chart Of Accounts'
            }
        })

        .state('app.hospital.accounts.chartOfAccounts.viewlist', {
            url : '/hospital/accounts/chartOfAccounts/view',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'chartOfAccountCtrl',
                    templateUrl : 'views/hospital/accounts/chartOfAccount/chartOfAccount',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chartOfAccount/chartOfAccountCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.profit&Loss', {
            abstract : true,
            data : {
                title : 'Income and Expenditure Accounts'
            }
        })

        .state('app.hospital.accounts.profit&Loss.searchlist', {
            url : '/hospital/accounts/profit&Loss/searchlist',
            data : {
                title : 'Search '
            },
            views : {
                "content@app" : {
                    controller : 'profitLossSearchCtrl',
                    templateUrl : 'views/hospital/accounts/profit&Loss/profitLossSearch',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/profit&Loss/profitLossSearchCtrl.js' ])
                    }
                }
            }
        })
        
        .state('app.hospital.accounts.profitandloss', {
            abstract : true,
            data : {
                title : 'Income and Expenditure'
            }
        })

        .state('app.hospital.accounts.profitandloss.searchlist', {
            url : '/hospital/accounts/profitandloss/searchlist',
            data : {
                title : ''
            },
            views : {
                "content@app" : {
                    controller : 'profitAndLossController',
                    templateUrl : 'views/hospital/accounts/profitandloss/profitandloss',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/profitandloss/profitandlossCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.profit&Loss.list', {
            url : '/hospital/accounts/profit&Loss/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'profitLossListCtrl',
                    templateUrl : 'views/hospital/accounts/profit&Loss/profitLossList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/profit&Loss/profitLossListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.accountclosingopening', {
            abstract : true,
            data : {
                title : 'Closing Accounting Period'
            }
        }).state('app.hospital.accounts.accountclosingopening.list', {
            url : '/hospital/accounts/accountclosingopening/list',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'accountClosingOpeningListCtrl',
                    templateUrl : 'views/hospital/accounts/accountClosingOpening/accountClosingOpeningList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.accountclosingopening.add', {
            url : '/hospital/accounts/accountclosingopening/add',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'accountClosingOpeningAddCtrl',
                    templateUrl : 'views/hospital/accounts/accountClosingOpening/accountClosingOpeningAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ])
                    }
                }
            }
        })
        //edit
        .state('app.hospital.accounts.accountclosingopening.edit', {
            url : '/hospital/accounts/accountclosingopening/edit',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'accountClosingOpeningAddCtrl',
                    templateUrl : 'views/hospital/accounts/accountClosingOpening/accountClosingOpeningAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/accountClosingOpening/accountClosingOpeningAddCtrl.js' ])
                    }
                }
            }
        })

        
        
        
        
        
     //   
        
        
        
        
        
        .state('app.hospital.accounts.closingAccountPeriod', {
            abstract : true,
            data : {
                title : 'Account Year Closing & Opening'
            }
        }).state('app.hospital.accounts.closingAccountPeriod.list', {
            url : '/hospital/accounts/closingAccountPeriod/list',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'closingAccountPeriodListCtrl',
                    templateUrl : 'views/hospital/accounts/closingAccountPeriod/closingAccountPeriodList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/closingAccountPeriod/closingAccountPeriodListCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.closingAccountPeriod.add', {
            url : '/hospital/accounts/closingAccountPeriod/add',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'closingAccountPeriodAddCtrl',
                    templateUrl : 'views/hospital/accounts/closingAccountPeriod/closingAccountPeriodAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/closingAccountPeriod/closingAccountPeriodAddCtrl.js' ])
                    }
                }
            }
        })
        //edit
        .state('app.hospital.accounts.closingAccountPeriod.edit', {
            url : '/hospital/accounts/closingAccountPeriod/edit',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'closingAccountPeriodAddCtrl',
                    templateUrl : 'views/hospital/accounts/closingAccountPeriod/closingAccountPeriodAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/closingAccountPeriod/closingAccountPeriodAddCtrl.js' ])
                    }
                }
            }
        })

        // Manage Sub Taxes
        .state('app.hospital.accounts.manageSubTaxes', {
            abstract : true,
            data : {
                title : 'Manage Sub Taxes'
            }
        })

        .state('app.hospital.accounts.manageSubTaxes.list', {
            url : '/hospital/accounts/manageSubTaxes/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'manageSubTaxesListCtrl',
                    templateUrl : 'views/hospital/accounts/manageSubTaxes/manageSubTaxesList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageSubTaxes/manageSubTaxesListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageSubTaxes.add', {
            url : '/hospital/accounts/manageSubTaxes/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'manageSubTaxesAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageSubTaxes/manageSubTaxesAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageSubTaxes/manageSubTaxesAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageSubTaxes.edit', {
            url : '/hospital/accounts/manageSubTaxes/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'manageSubTaxesAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageSubTaxes/manageSubTaxesAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageSubTaxes/manageSubTaxesAddCtrl.js' ])
                    }
                }
            }
        })

        // CREDIT NOTE APPROVAL
        .state('app.hospital.accounts.creditNoteApproval', {
            abstract : true,
            data : {
                title : 'Credit Note Approval'
            }
        })

        .state('app.hospital.accounts.creditNoteApproval.list', {
            url : '/hospital/accounts/creditNoteApproval/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'creditNoteApprovalListCtrl',
                    templateUrl : 'views/hospital/accounts/creditNoteApproval/creditNoteApprovalList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNoteApproval/creditNoteApprovalCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.creditNoteApproval.approval', {
            url : '/hospital/accounts/creditNoteApproval/approval/:creditNoteCode',
            data : {
                title : 'Approval'
            },
            views : {
                "content@app" : {
                    controller : 'creditNoteApprovalCtrl',
                    templateUrl : 'views/hospital/accounts/creditNoteApproval/creditNoteApprovalForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/creditNoteApproval/creditNoteApprovalCtrl.js' ])
                    }
                }
            }
        })

        // DEBIT NOTE APPROVAL
        .state('app.hospital.accounts.debitNoteApproval', {
            abstract : true,
            data : {
                title : 'Debit Note Approval'
            }
        })

        .state('app.hospital.accounts.debitNoteApproval.list', {
            url : '/hospital/accounts/debitNoteApproval/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'debitNoteApprovalListCtrl',
                    templateUrl : 'views/hospital/accounts/debitNoteApproval/debitNoteApprovalList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNoteApproval/debitNoteApprovalListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.debitNoteApproval.edit', {
            url : '/hospital/accounts/debitNoteApproval/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'debitNoteApprovalEditCtrl',
                    templateUrl : 'views/hospital/accounts/debitNoteApproval/debitNoteApprovalEdit',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/debitNoteApproval/debitNoteApprovalEditCtrl.js' ])
                    }
                }
            }
        })

        // PAYMENT
        .state('app.hospital.accounts.payment', {
            abstract : true,
            data : {
                title : 'Cash Bank Payment'
            }
        })

        .state('app.hospital.accounts.payment.list', {
            url : '/hospital/accounts/payment/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'CashBankPaymentListCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentListCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.payment.add', {
            url : '/hospital/accounts/payment/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'CashBankPaymentAddCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentAddCtrl.js' ])
                    }
                }
            }
        }).state('app.hospital.accounts.payment.edit', {
            url : '/hospital/accounts/payment/edit/:voucherNo',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'CashBankPaymentAddCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentAddCtrl.js' ])
                    }
                }
            }
        })

        
        
         .state('app.hospital.accounts.payment.view', {
            url : '/hospital/accounts/payment/view/:voucherNo',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'CashBankPaymentAddCtrl',
                    templateUrl : 'views/hospital/accounts/payment/CashBankPaymentView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/payment/cashbankpaymentAddCtrl.js' ])
                    }
                }
            }
        })
        // CASH BANK RECEIPT
        .state('app.hospital.accounts.paymentreceipt', {
            abstract : true,
            data : {
                title : 'Cash Bank Receipt'
            }
        })

        .state('app.hospital.accounts.paymentreceipt.list', {
            url : '/hospital/accounts/paymentreceipt/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'cashBankReceiptListCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/CashBankReceiptList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/CashBankReceiptListCtrl.js' ])
                    }
                }
            }
        })

//        .state('app.hospital.accounts.paymentreceipt.add', {
//            url : '/hospital/accounts/paymentreceipt/add',
//            data : {
//                title : 'Add'
//            },
//            views : {
//                "content@app" : {
//                    controller : 'cashBankReceiptAddCtrl',
//                    templateUrl : 'views/hospital/accounts/paymentreceipt/cashBankReceiptAdd',
//
//                    resolve : {
//                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ])
//                    }
//                }
//            }
//        })
       /* .state('app.hospital.accounts.paymentreceipt.edit', {
            url : '/hospital/accounts/paymentreceipt/edit/:voucherNo',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'cashBankReceiptAddCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/cashBankReceiptAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.paymentreceipt.view', {
            url : '/hospital/accounts/paymentreceipt/view/:voucherNo',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'cashBankReceiptAddCtrl',
                    templateUrl : 'views/hospital/accounts/paymentreceipt/cashBankReceiptView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentreceipt/cashBankReceiptAddCtrl.js' ])
                    }
                }
            }
        })*/

        // Pending Payment Report
        .state('app.hospital.accounts.pendingPaymentRpt', {
            abstract : true,
            data : {
                title : 'Pending Payment Report'
            }
        }).state('app.hospital.accounts.pendingPaymentRpt.list', {
            url : '/hospital/accounts/pendingPaymentRpt/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'pendingPaymentReportListCtrl',
                    templateUrl : 'views/hospital/accounts/pendingPaymentRpt/pendingPaymentReportList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/pendingPaymentRpt/pendingPaymentRptCtrl.js' ])
                    }
                }
            }
        })
        // Payment History
        .state('app.hospital.accounts.paymentHistory', {
            abstract : true,
            data : {
                title : 'Payment History'
            }
        }).state('app.hospital.accounts.paymentHistory.list', {
            url : '/hospital/accounts/paymentHistory/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'paymentHistoryCtrl',
                    templateUrl : 'views/hospital/accounts/pendingPaymentRpt/paymentHistoryList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/pendingPaymentRpt/paymentHistoryCtrl.js' ])
                    }
                }
            }
        })
        // BALANCE SHEET
        .state('app.hospital.accounts.balancesheet', {
            abstract : true,
            data : {
                title : 'Balance Sheet'
            }
        })

        .state('app.hospital.accounts.balancesheet.list', {
            url : '/hospital/accounts/balancesheet/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'balanceSheetListCtrl',
                    templateUrl : 'views/hospital/accounts/balanceSheet/balanceSheetList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/balanceSheet/balanceSheetListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chequeReconsideration', {
            abstract : true,
            data : {
                title : 'Cheque Reconsiliation'
            }
        })

        .state('app.hospital.accounts.chequeReconsideration.list', {
            url : '/hospital/accounts/chequeReconsideration/list',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'chequeReconsiderationCtrl',
                    templateUrl : 'views/hospital/accounts/chequeReconsideration/chequeReconsideration',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chequeReconsideration/chequeReconsideration.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.bankReconcillation', {
            abstract : true,
            data : {
                title : 'Bank Reconciliation'
            }
        })

        .state('app.hospital.accounts.bankReconcillation.list', {
            url : '/hospital/accounts/bankReconciliation/list',
            data : {

            },
            views : {
                "content@app" : {
                    controller : 'bankReconcillationCtrl',
                    templateUrl : 'views/hospital/accounts/bankReconcillation/bankReconcillationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankReconcillation/bankReconcillationListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.statementAccounts', {
            abstract : true,
            data : {
                title : 'Statement Of Accounts'
            }
        })

        .state('app.hospital.accounts.statementAccounts.list', {
            url : '/hospital/accounts/statementAccounts/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'soaCustomerCtrl',
                    templateUrl : 'views/hospital/accounts/soaCustomer/soaCustomer',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/soaCustomer/soaCustomerCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chequeStatusReport', {
            abstract : true,
            data : {
                title : 'chequeStatusReport'
            }
        })

        .state('app.hospital.accounts.chequeStatusReport.list', {
            url : '/hospital/accounts/chequeStatusReport/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'chequeStatusReportCtrl',
                    templateUrl : 'views/hospital/accounts/chequeStatusReport/chequeStatusReport',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chequeStatusReport/chequeStatusReportCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.bankbook', {
            abstract : true,
            data : {
                title : 'Bank Book'
            }
        })

        .state('app.hospital.accounts.bankbook.list', {
            url : '/hospital/accounts/bankbook/list',
            data : {
                title : 'Bank Book List'
            },
            views : {
                "content@app" : {
                    controller : 'bankbookCtrl',
                    templateUrl : 'views/hospital/accounts/cashandbankbook/bankbook',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/cashandbankbook/bankbook.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.cashbook', {
            abstract : true,
            data : {
                title : 'Cash Book'
            }
        })

        .state('app.hospital.accounts.cashbook.list', {
            url : '/hospital/accounts/cashbook/list',
            data : {
                title : 'Cash Book List'
            },
            views : {
                "content@app" : {
                    controller : 'cashbookCtrl',
                    templateUrl : 'views/hospital/accounts/cashandbankbook/cashbook',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/cashandbankbook/cashbook.js' ])
                    }
                }
            }
        })

        // Cheque Presentation
        .state('app.hospital.accounts.chqPresentation', {
            abstract : true,
            data : {
                title : 'Cheque Deposited'
            }
        })

        .state('app.hospital.accounts.chqPresentation.list', {
            url : '/hospital/accounts/chqPresentation/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'presentationCtrl',
                    templateUrl : 'views/hospital/accounts/chqPresentation/chqPresentation',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqPresentation/chqPresentationCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chqPresentation.add', {
            url : '/hospital/accounts/chqPresentation/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'presentationAddCtrl',
                    templateUrl : 'views/hospital/accounts/chqPresentation/chqPresentationForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqPresentation/chqPresentationCtrl.js' ])
                    }
                }
            }
        })

        // Cheque Realisation
        .state('app.hospital.accounts.chqRealisation', {
            abstract : true,
            data : {
                title : 'Cheque Realization'
            }
        })

        .state('app.hospital.accounts.chqRealisation.list', {
            url : '/hospital/accounts/chqRealisation/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'realisationCtrl',
                    templateUrl : 'views/hospital/accounts/chqRealisation/chqRealisation',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqRealisation/chqRealisationCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.chqRealisation.add', {
            url : '/hospital/accounts/chqRealisation/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'realisationAddCtrl',
                    templateUrl : 'views/hospital/accounts/chqRealisation/chqRealisationForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/chqRealisation/chqRealisationCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.attributes', {
            abstract : true,
            data : {
                title : 'Attributes'
            }
        })

        .state('app.hospital.accounts.attributes.list', {
            url : '/hospital/accounts/attributes/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'attributesListCtrl',
                    templateUrl : 'views/hospital/accounts/attributes/attributesList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/attributes/attributesCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.attributes.add', {
            url : '/hospital/accounts/attributes/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'attributesAddCtrl',
                    templateUrl : 'views/hospital/accounts/attributes/attributesAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/attributes/attributesCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.budgetAllocation', {
            abstract : true,
            data : {
                title : 'Budget Allocation'
            }
        })

        .state('app.hospital.accounts.budgetAllocation.list', {
            url : '/hospital/accounts/budgetAllocation/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetAllocationListCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetAllocationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetAllocationListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.budgetAllocation.add', {
            url : '/hospital/accounts/budgetAllocation/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'budgetAllocationAddCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetAllocationAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetAllocationAddCtrl.js' ])
                    }
                }
            }
        })
.state('app.hospital.accounts.budgetDefinitions', {
            abstract : true,
            data : {
                title : 'Budget Allocation'
            }
        })

        .state('app.hospital.accounts.budgetDefinitions.list', {
            url : '/hospital/accounts/budgetDefinitions/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetDefinitionListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionListCtrl.js' ])
                    }
                }
            }
        })
        
        
.state('app.hospital.accounts.budgetDefinitionsApprove', {
            abstract : true,
            data : {
                title : 'Budget Allocation Approve'
            }
        })

        .state('app.hospital.accounts.budgetDefinitionsApprove.list', {
            url : '/hospital/accounts/budgetDefinitionsApprove/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetDefinitionApproveListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionApproveList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionApproveListCtrl.js' ])
                    }
                }
            }
        })
        
        .state('app.hospital.accounts.budgetDefinitions.add', {
            url : '/hospital/accounts/budgetDefinitions/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'budgetDefinitionAddCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.budgetDefinitions.edit', {
            url : '/hospital/accounts/budgetDefinitions/edit/:budgetDefinitionId',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'budgetDefinitionEditCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }
        })
        
        .state('app.hospital.accounts.budgetDefinitions.approve', {
            url : '/hospital/accounts/budgetDefinitions/approve/:budgetDefinitionId',
            data : {
                title : 'approve'
            },
            views : {
                "content@app" : {
                    controller : 'budgetDefinitionEditCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionApprove',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }
        })
        .state('app.hospital.accounts.budgetDefinitions.view', {
            url : '/hospital/accounts/budgetDefinitions/view/:budgetDefinitionId',
            data : {
                title : 'approve'
            },
            views : {
                "content@app" : {
                    controller : 'budgetDefinitionEditCtrl',
                    templateUrl : 'views/hospital/accounts/budgetDefinition/budgetDefinitionView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetDefinition/budgetDefinitionAddCtrl.js' ])
                    }
                }
            }
        })
        .state('app.hospital.accounts.approval', {
            abstract : true,
            data : {
                title : 'Budget Allocation Approval'
            }
        })

        .state('app.hospital.accounts.approval.list', {
            url : '/hospital/accounts/approval/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetApprovalListCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetApprovalList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetAllocationListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.approval.add', {
            url : '/hospital/accounts/approval/add',
            data : {
                title : 'Approval'
            },
            views : {
                "content@app" : {
                    controller : 'budgetApprovalAddCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetApprovalAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetAllocationAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.approval.view', {
            url : '/hospital/accounts/budgetAllocation/view',
            data : {
                title : 'View'
            },
            views : {
                "content@app" : {
                    controller : 'budgetApprovalAddCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetAllocationView',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetAllocationAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.budgetType', {
            abstract : true,
            data : {
                title : 'Budget Type'
            }
        })

        .state('app.hospital.accounts.budgetType.list', {
            url : '/hospital/accounts/budgetType/list',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetTypeListCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetTypeList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetTypeCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.budgetType.add', {
            url : '/hospital/accounts/budgetType/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'budgetTypeAddCtrl',
                    templateUrl : 'views/hospital/accounts/budget/budgetTypeForm',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budget/budgetTypeCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageCostCenter', {
            abstract : true,
            data : {
                title : 'Manage Fund Type'
            }
        })

        .state('app.hospital.accounts.manageCostCenter.list', {
            url : '/hospital/accounts/manageCostCenter/manageCostCenterList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'manageCostCenterListCtrl',
                    templateUrl : 'views/hospital/accounts/manageCostCenter/manageCostCenterList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageCostCenter/manageCostCenterListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageCostCenter.add', {
            url : '/hospital/accounts/manageCostCenter/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'manageCostCenterAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageCostCenter/manageCostCenterAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageCostCenter/manageCostCenterAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.manageCostCenter.edit', {
            url : '/hospital/accounts/manageCostCenter/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'manageCostCenterAddCtrl',
                    templateUrl : 'views/hospital/accounts/manageCostCenter/manageCostCenterAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/manageCostCenter/manageCostCenterAddCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.budgetOverview', {
            abstract : true,
            data : {
                title : 'Budget Overview'
            }
        })

        .state('app.hospital.accounts.budgetOverview.list', {
            url : '/hospital/accounts/budgetOverview/budgetOverviewList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetOverviewListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetOverview/budgetOverviewList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetOverview/budgetOverviewListCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.journalVoucherType', {
            abstract : true,
            data : {
                title : 'Journal Voucher Type'
            }
        })

        .state('app.hospital.accounts.journalVoucherType.list', {
            url : '/hospital/accounts/journalVoucherType/journalVoucherTypeList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'journalVoucherTypeCtrl',
                    templateUrl : 'views/hospital/accounts/journalVoucherType/journalVoucherTypeList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/journalVoucherType/journalVoucherTypeCtrl.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.pendingReceiptReport', {
            abstract : true,
            data : {
                title : 'Pending Receipt Report'
            }
        })

        .state('app.hospital.accounts.pendingReceiptReport.list', {
            url : '/hospital/accounts/pendingReceiptReport/pendingReceiptReportList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'pendingReceiptReport',
                    templateUrl : 'views/hospital/accounts/pendingReceiptReport/pendingReceiptReportList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/pendingReceiptReport/pendingReceiptReport.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.paymentInformation', {
            abstract : true,
            data : {
                title : 'Payment Information'
            }
        })

        .state('app.hospital.accounts.paymentInformation.list', {
            url : '/hospital/accounts/paymentInformation/paymentInformationList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'paymentInformationList',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationList.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.paymentInformation.add', {
            url : '/hospital/accounts/paymentInformation/paymentInformationAdd',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'paymentInformationAdd',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationAdd.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.paymentInformation.edit', {
            url : '/hospital/accounts/paymentInformation/paymentInformationEdit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'paymentInformationAdd',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationAdd.js' ])
                    }
                }
            }
        })
        
         .state('app.hospital.accounts.paymentInformation.draft', {
            url : '/hospital/accounts/paymentInformation/paymentInformationDraftList',
            data : {
                title : 'Draft List'
            },
            views : {
                "content@app" : {
                    controller : 'paymentInformationDraftList',
                    templateUrl : 'views/hospital/accounts/paymentInformation/paymentInformationDraftList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentInformation/paymentInformationDraftList.js' ])
                    }
                }
            }
        })


        .state('app.hospital.accounts.paymentOrder', {
            abstract : true,
            data : {
                title : 'Payment Order'
            }
        })

        .state('app.hospital.accounts.paymentOrder.list', {
            url : '/hospital/accounts/paymentOrder/paymentOrderList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'paymentOrderList',
                    templateUrl : 'views/hospital/accounts/paymentOrder/paymentOrderList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/paymentOrder/paymentOrderList.js' ])
                    }
                }
            }
        })
        
        
        
        
         .state('app.hospital.accounts.bankCompanymapping', {
            abstract : true,
            data : {
                title : 'Cash/Bank Company Mapping'
            }
        })

        .state('app.hospital.accounts.bankCompanymapping.list', {
            url : '/hospital/accounts/bankCompanymapping/bankCompanymappingList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'bankCompanymappingListCtrl',
                    templateUrl : 'views/hospital/accounts/bankCompanymapping/bankCompanymappingList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankCompanymapping/bankCompanymappingList.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.bankCompanymapping.Add', {
            url : '/hospital/accounts/bankCompanymapping/bankCompanymappingAdd',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'bankCompanymappingAddCtrl',
                    templateUrl : 'views/hospital/accounts/bankCompanymapping/bankCompanymappingAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankCompanymapping/bankCompanymappingAdd.js' ])
                    }
                }
            }
        })
        .state('app.hospital.accounts.bankCompanymapping.edit', {
            url : '/hospital/accounts/bankCompanymapping/bankCompanymappingEdit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'bankCompanymappingAddCtrl',
                    templateUrl : 'views/hospital/accounts/bankCompanymapping/bankCompanymappingAdd',
                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/bankCompanymapping/bankCompanymappingAdd.js' ])
                    }
                }
            }
        })
        
      

         .state('app.hospital.accounts.formAccountCenter', {
            abstract : true,
            data : {
                title : 'Tds Form'
            }
        })

        .state('app.hospital.accounts.formAccountCenter.list', {
            url : '/hospital/accounts/formAccountCenter/formAccountCenterList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'formAccountCenterList',
                    templateUrl : 'views/hospital/accounts/formAccountCenter/formAccountCenterList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/formAccountCenter/formAccountCenterList.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.formAccountCenter.add', {
            url : '/hospital/accounts/formAccountCenter/add',
            data : {
                title : 'Add'
            },
            views : {
                "content@app" : {
                    controller : 'formAccountCenterAddCtrl',
                    templateUrl : 'views/hospital/accounts/formAccountCenter/formAccountCenterAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/formAccountCenter/formAccountCenterAdd.js' ])
                    }
                }
            }
        })

        .state('app.hospital.accounts.formAccountCenter.edit', {
            url : '/hospital/accounts/formAccountCenter/edit',
            data : {
                title : 'Edit'
            },
            views : {
                "content@app" : {
                    controller : 'formAccountCenterAddCtrl',
                    templateUrl : 'views/hospital/accounts/formAccountCenter/formAccountCenterAdd',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/formAccountCenter/formAccountCenterAdd.js' ])
                    }
                }
            }
        })
        
        
        
        
        
        //TDS REPORTS
        
        
    

         .state('app.hospital.accounts.TDSReport', {
            abstract : true,
            data : {
                title : 'Tds Reports'
            }
        })

        .state('app.hospital.accounts.TDSReport.list', {
            url : '/hospital/accounts/tdsReport/tdsReportList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'TDSReportListCtrl',
                    templateUrl : 'views/hospital/accounts/TDSReport/TDSReportList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/TDSReport/TDSReportList.js' ])
                    }
                }
            }
        })

       
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        .state('app.hospital.accounts.budgetReport', {
            abstract : true,
            data : {
                title : 'budgetReport'
            }
        })

        .state('app.hospital.accounts.budgetReport.list', {
            url : '/hospital/accounts/budgetReport/budgetReportList',
            data : {
                title : 'List'
            },
            views : {
                "content@app" : {
                    controller : 'budgetReportListCtrl',
                    templateUrl : 'views/hospital/accounts/budgetReport/budgetReportList',

                    resolve : {
                        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/budgetReport/budgetReportList.js' ])
                    }
                }
            }
        })

       
        
        
        
        
        
        //Purchase Credit Note
        
        
        

                    $stateProvider.state('app.hospital.accounts.purchaseCreditNote', {
          abstract : true,
           data : {
         title : 'Purchase Credit Note'
          }
                 })


                      .state('app.hospital.accounts.purchaseCreditNote.list', {
                  url : '/hospital/accounts/purchaseCreditNote/purchaseCreditNoteList',
                   data : {
                      title : 'List'
                     },
                        views : {
                    "content@app" : {
                controller : 'purchaseCreditNoteCTRL',
              templateUrl : '/views/hrms/purchasecreditNote/purchasecreditNoteListPage',

            resolve : {
                   deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseCreditNote/PurchaseCreditNoteCtrl.js' ])
        }
          }
           }
         })



           .state('app.hospital.accounts.purchaseCreditNote.Add', {
            url : '/hospital/accounts/purchaseCreditNote/purchaseCreditNoteAdd',

                   data : {
                  title : 'Add'
                },
             views : {
            "content@app" : {
           controller : 'purchaseCreditnoteAddCTRL',
               templateUrl : '/views/hrms/purchasecreditNote/purchaseCreditNoteForm',

               resolve : {
        deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/purchaseCreditNote/PurchaseCreditNoteCtrl.js' ])
       }
         }
        }
          })
          
          
          
          
          
          
          
          
          
          
          .state('app.hospital.accounts.openBalanceUpload', {
              abstract : true,
              data : {
                  title : 'Opening Balance'
              }
          })
  .state('app.hospital.accounts.openBalanceUpload.list', {
              url : '/hospital/accounts/openBalanceUpload/list',
              data : {
                  title : 'List'
              },
              views : {
                  "content@app" : {
                      controller : 'openingBalanceListCtrl',
                      templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUpload',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadCtrl.js' ])
                      }
                  }
              }
          })
         .state('app.hospital.accounts.openBalanceUpload.add', {
              url : '/hospital/accounts/openBalanceUpload/add',
              data : {
                  title : 'Add'
              },
              views : {
                  "content@app" : {
                      controller : 'openBalanceUploadAddCtrl',
                      templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUploadAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadAddCtrl.js' ])
                      }
                  }
              }
          })   
               .state('app.hospital.accounts.openBalanceUpload.edit', {
              url : '/hospital/accounts/openBalanceUpload/edit',
              data : {
                  title : 'Edit'
              },
              views : {
                  "content@app" : {
                      controller : 'openBalanceUploadAddCtrl',
                      templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUploadAdd',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadAddCtrl.js' ])
                      }
                  }
              }
          })   
          
          
            .state('app.hospital.accounts.openBalanceUpload.jvList', {
              url : '/hospital/accounts/openBalanceUpload/jvlist',
              data : {
                  title : 'Genarate JV'
              },
              views : {
                  "content@app" : {
                      controller : 'openingBalanceListCtrl',
                      templateUrl : 'views/hospital/accounts/openingBalance/openingBalanceUploadJv',

                      resolve : {
                          deps : $couchPotatoProvider.resolveDependencies([ 'js/app/hospital/accounts/openingBalance/openingBalanceUploadCtrl.js' ])
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