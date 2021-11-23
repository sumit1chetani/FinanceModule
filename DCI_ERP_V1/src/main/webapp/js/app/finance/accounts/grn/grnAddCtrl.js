define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';

    module.registerController('grnAddCtrl', function($scope, $state, $http, $location, sharedProperties, toaster, $injector, logger) {
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0
        $scope.isEdit = false;

        $scope.add = function() {
            $state.go("app.hospital.accounts.grn.add");
        };

        $scope.cancel = function() {
            $state.go("app.hospital.accounts.grn.list");
        };
        $scope.grnData = {
            grnTables : [],
        }

        // load table
        $scope.loadgrnTable = function() {
            var grnTable = {};

            grnTable.grnTableRow = [ {} ];
            $scope.grnData.grnTables.push(grnTable);
        }
        $scope.loadgrnTable();

        // add Row
        $scope.addgrnRow = function(tables) {
            var len = tables.grnTableRow.length;
            var table = {
                rowheader : []
            };
            tables.grnTableRow.push(table);
        };

        // remove Row
        $scope.removegrnRow = function(table) {
            $scope.tablerow = [];
            angular.forEach(table.grnTableRow, function(row, index) {
                var check = row.select;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {

                }
            });
            table.grnTableRow = $scope.tablerow;
        };
    });

});