'use strict';
app.controller('ssfTsMovesCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {

    $scope.ssfMoves = [];
    $scope.ssfMovesXaxis = [];
    var lineChart;
    var date = new Date();
    var year1 = date.getFullYear();
    $scope.yearList = [];
    $scope.currentYear = parseInt(year1);
    $scope.getSsfMoves = function() {

        var url = 'app/csrreports/ssfmoves';
        $http.get(url).success(function(data) {
            $scope.ssfMoves = [];
            $scope.ssfMovesGraphs = [];
            $scope.ssfMoves = data;
           for(var index=11; index>=0; index--){
                var nYear = parseInt($scope.currentYear)-index;
                angular.forEach($scope.ssfMoves,function(row,ssfindex){
                    if( nYear == parseInt(row.year)){
                        $scope.ssfMovesGraphs.push([parseInt(row.total)]);
                        $scope.ssfMovesXaxis.push([parseInt(row.year)]);
                    }else{
                        $scope.ssfMovesGraphs.push([parseInt(0)]);
                        $scope.ssfMovesXaxis.push([parseInt(nYear)]);
                    }    
                });
                
            }
            $scope.createLineChat($scope.ssfMovesGraphs,$scope.ssfMovesXaxis);
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    };
   
    $scope.createLineChat=function(ssfMovesGraphs,ssfMovesXaxis){
        if(! $scope.lineIntialized){
            $scope.lineIntialized=true;
            var surveryInProgressBar=document.getElementById("surveryInProgressBar2").getContext("2d");
            var gradient = surveryInProgressBar.createLinearGradient(0, 0, 0, 400);
            gradient.addColorStop(0, 'rgb(255,78,80)');   
            gradient.addColorStop(1, 'rgb(249,212,35)');
            var data = {
                    labels:ssfMovesXaxis,
                    datasets: [
                        {
                           // label: "Booking",
                            fillColor:gradient,
                            strokeColor: "rgba(111,166,215,1)",
                            highlightStroke: "rgba(111,166,215,1)",
                            data: ssfMovesGraphs
                        }
                    ]
                };
            lineChart=new Chart(surveryInProgressBar).Bar(data,{
                pointDotRadius: 3,
            }); 
        }else{
            lineChart.destroy();
            $scope.lineIntialized = false;
            $scope.createLineChat($scope.ssfMovesGraphs,$scope.ssfMovesXaxis);
        } 
    }  
    $scope.getSsfMoves();
});
