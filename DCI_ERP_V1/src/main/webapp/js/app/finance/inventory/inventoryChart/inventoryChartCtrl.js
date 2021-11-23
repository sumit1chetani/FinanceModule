define([ 'hospital/inventory/inventory', 'jqGrid' ], function(module) {
    'use strict';

    module.registerController('inventoryChartCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.consumptionModel = {
            itemId : '',
            itemName : '',
            locationId : '',
            locationName : '',
            totQty : '',
            rdoDays : ''
        };
        $scope.masterlist = [];
        $scope.datelist = [];
        $scope.maxlist = [];
        $scope.minlist = [];
        $scope.avglist = [];
        $scope.itemLists = [];
        $scope.locationLists = [];

        $scope.loadDropDownData = function() {
            $http.get('app/inventoryChart/getDropDowns').success(function(response) {
                console.log("Drop Down List :::::::::::::::::");
                console.log(response);
                var items = [], locations = [];

                angular.forEach(response.itemList, function(item, key) {
                    items.push({
                        'id' : item.itemId,
                        'text' : item.itemName
                    });
                });
                console.log(items);
                angular.forEach(response.locationList, function(item, key) {
                    locations.push({
                        'id' : item.locationId,
                        'text' : item.locationName
                    });
                });
                console.log(locations);
                $scope.itemLists = items;
                $scope.locationLists = locations;
            }).error(function(response) {
            });
        };

        $scope.loadDropDownData();

        $scope.getConsumptionReport = function() {
            var itm = 0, location = 0;
            var rdoDays = parseInt($scope.consumptionModel.rdoDays) - 1;
            var totQty = $scope.consumptionModel.totQty;
            $scope.masterlist = [];
            $scope.datelist = [];
            $scope.maxlist = [];
            $scope.minlist = [];
            $scope.avglist = [];
            if ($scope.consumptionModel.itemId != undefined && $scope.consumptionModel.itemId != '') {
                itm = $scope.consumptionModel.itemId;
            }
            if ($scope.consumptionModel.locationId != undefined && $scope.consumptionModel.locationId != '') {
                location = $scope.consumptionModel.locationId;
            }
            $http.get('app/inventoryChart/consumptionList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount + '&itm=' + itm + '&location=' + location + '&rdoDays=' + rdoDays).success(function(response) {
                console.log("getConsumptionReport :::::::::::::::::");
                console.log(response);

                angular.forEach(response.consumptionMasterList, function(value, index) {
                    $scope.masterlist.push(value.qty);
                    $scope.datelist.push(value.docDate);
                });
                angular.forEach(response.consumptionMax, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // maxQty = $scope.datelist[i];
                        $scope.maxlist.push(value.maxQty);
                    }
                });
                angular.forEach(response.consumptionMin, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // minQty = $scope.datelist[i];
                        $scope.minlist.push(value.minQty);
                    }
                });
                angular.forEach(response.consumptionAvg, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // avgQty = $scope.datelist[i];
                        $scope.avglist.push(value.avgQty);
                    }
                });

                console.log($scope.masterlist);

                // Basic Line Chart
                $scope.chartConfig = {
                    title : {
                        text : 'Consumption Pattern',
                        x : -20
                    // centers
                    },
                    subtitle : {
                        text : 'Item Type    :   Consumable',
                        x : -20
                    // centers
                    },
                    xAxis : {
                        title : {
                            text : 'Monthly Consumption'
                        },

                        categories : $scope.datelist
                    /*
                     * categories: ['20/10/2015', '20/10/2015', '20/10/2015',
                     * '20/10/2015', '20/10/2015', '20/10/2015', '20/10/2015',
                     * '20/10/2015', '20/10/2015', '20/10/2015', '20/10/2015',
                     * '20/10/2015','20/10/2015', '20/10/2015', '20/10/2015',
                     * '20/10/2015', '20/10/2015', '20/10/2015','20/10/2015',
                     * '20/10/2015', '20/10/2015', '20/10/2015', '20/10/2015',
                     * '20/10/2015','20/10/2015', '20/10/2015', '20/10/2015',
                     * '20/10/2015', '20/10/2015', '20/10/2015']
                     */
                    },
                    yAxis : {
                        title : {
                            text : 'Item Quantity(Qty)'
                        },
                        plotLines : [ {
                            value : 0,
                            width : 0.1,
                            color : '#808080'
                        } ]
                    },
                    tooltip : {
                        valueSuffix : 'Qty'
                    },
                    legend : {
                        layout : 'vertical',
                        align : 'right',
                        verticalAlign : 'middle',
                        borderWidth : 0
                    },
                    series : [ {

                        name : 'Minimum',
                        data : $scope.minlist
                    // data: [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10,
                    // 10, 10, 10, 10, 10, 10, 10]
                    }, {
                        name : 'Maximum',
                        data : $scope.maxlist
                    // data: [100, 100 , 100, 100,100, 100,100, 100,100,100,
                    // 100, 100,100, 100, 100, 100,100, 100,100, 100]
                    }, {
                        name : 'Average',
                        data : $scope.avglist
                    // data: [55 , 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55,55
                    // , 55, 55, 55, 55, 55, 55, 55]
                    }, {
                        name : 'Rate of Consumption',
                        data : $scope.masterlist
                    // data: [10, 13.9, 49.5, 25.2, 65.5, 100, 60, 75, 46.5,
                    // 38.3, 13.9, 9.6,10, 13.9, 49.5, 25.2, 65.5, 100, 60, 75,
                    // 46.5, 38.3, 13.9, 9.6,10, 13.9, 49.5, 25.2, 65.5, 100]
                    } ]
                }

            }).error(function(response) {
            });
        };
    });
});
