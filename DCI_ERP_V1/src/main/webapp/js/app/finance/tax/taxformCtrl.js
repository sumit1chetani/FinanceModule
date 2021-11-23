'use strict';
app.controller('taxController', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $window, utilsService) {

    $scope.db = {};
    $scope.afterChange = function(data){
        console.log(data);
    };
    $scope.db.dynamicColumns = [ {
        data : 'id',
        title : 'ID'
    }, {
        data : 'name.first',
        title : 'First Name',
        readOnly : false,
        afterChange : function(data){
            console.log(data);
        }
    }, {
        data : 'name.last',
        title : 'Last Name',
        readOnly : true
    }, {
        data : 'address',
        title : 'Address',
        width : 150
    }, {
        data : 'product.description',
        type : 'autocomplete',
        title : 'Favorite food',
        width : 150,
        optionList : 'description in product.options'
    }, {
        data : 'price',
        title : 'Price',
        type : 'numeric',
        width : 80,
        format : '$ 0,0.00'
    }, {
        data : 'isActive',
        type : 'checkbox',
        title : 'Is active',
        checkedTemplate : 'Yes',
        uncheckedTemplate : 'No',
        width : 65
    } ];
    $scope.db.items = [ {
        "id" : 1,
        "name" : {
            "first" : "John",
            "last" : "Fancy"
        },
        "address" : "83777 Michigan",
        "price" : 274.49,
        "isActive" : "Yes",
        "product" : {
            "description" : "Big Mac",
            "options" : [ {
                "description" : "Big Mac",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Big Mac & Co",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "McRoyal",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Hamburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Cheeseburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Double Cheeseburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            } ]
        }
    }, {
        "id" : 2,
        "name" : {
            "first" : "Frank",
            "last" : "Kowalski"
        },
        "address" : "80018 USA",
        "price" : 459.88,
        "isActive" : "No",
        "product" : {
            "description" : "Big Mac",
            "options" : [ {
                "description" : "Big Mac",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Big Mac & Co",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "McRoyal",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Hamburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Cheeseburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Double Cheeseburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            } ]
        }
    }, {
        "id" : 3,
        "name" : {
            "first" : "Gwen",
            "last" : "Rocket"
        },
        "address" : "24829 Denmark",
        "price" : 634.8,
        "isActive" : "No",
        "product" : {
            "description" : "Big Mac",
            "options" : [ {
                "description" : "Big Mac",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Big Mac & Co",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "McRoyal",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Hamburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Cheeseburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            }, {
                "description" : "Double Cheeseburger",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                "Pick$" : null
            } ]
        }
    }, {
        "id" : 4,
        "name" : {
            "first" : "Fiona",
            "last" : "Manson"
        },
        "address" : "49152 Michigan",
        "price" : 460.39,
        "isActive" : "No",
        "product" : {
            "description" : "Fried Potatoes",
            "options" : [ {
                "description" : "Fried Potatoes",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/fries.png",
                "Pick$" : null
            }, {
                "description" : "Fried Onions",
                "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/fries.png",
                "Pick$" : null
            } ]
        }
    } ];


    $scope.addData = function(){
        var itemNew = {
            "id" : 1,
            "name" : {
                "first" : "John",
                "last" : "Fancy"
            },
            "address" : "83777 Michigan",
            "price" : 274.49,
            "isActive" : "Yes",
            "product" : {
                "description" : "Big Mac",
                "options" : [ {
                    "description" : "Big Mac",
                    "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                    "Pick$" : null
                }, {
                    "description" : "Big Mac & Co",
                    "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                    "Pick$" : null
                }, {
                    "description" : "McRoyal",
                    "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                    "Pick$" : null
                }, {
                    "description" : "Hamburger",
                    "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                    "Pick$" : null
                }, {
                    "description" : "Cheeseburger",
                    "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                    "Pick$" : null
                }, {
                    "description" : "Double Cheeseburger",
                    "image" : "//a248.e.akamai.net/assets.github.com/images/icons/emoji/hamburger.png",
                    "Pick$" : null
                } ]
            }
        };

        $scope.db.items.push(itemNew);
    };

});
