'use strict';
app.controller('ssfVolCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {


    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.rowCurrentYears=[];
    $scope.fromYear = '';
    $scope.toYear = '';
 
    $scope.ssfIwstotal=0;
    
$scope.getSsfVol = function() {
   
    var url = 'app/csrreports/ssfvol';
    $http.get(url).success(function(data) {
        console.log(data);
        $scope.ssfVol=[];
        $scope.ssfVol1=[];
    	 $scope.rowCollection =data[0];
    	 $scope.rowCurrentYears=data[1];
    	 $scope.yearVal=$scope.rowCurrentYears[0].year;
    	 var total=0;
    	 var iwsTot=0;
    	 var ssfTot=0;
    	 for(var i=0;i<$scope.rowCurrentYears.length;i++){
    	     if($scope.rowCurrentYears[i].slotAc==='SSF'){
    	         ssfTot=ssfTot+parseInt($scope.rowCurrentYears[i].total);  
    	     }else{
    	         iwsTot=iwsTot+parseInt($scope.rowCurrentYears[i].total);  
    	     }
    	     total=total+parseInt($scope.rowCurrentYears[i].total);  
    	 }
    	 var min = 0;
    	 var max = 0;
       for(var i = 0; i <  $scope.rowCollection.length; i++){
           var year = $scope.rowCollection[i].year;
           if(i==0){
               $scope.fromYear = year;
           }
           if(i == $scope.rowCollection.length-1){
               $scope.toYear = year;
           }
           
           $scope.ssfVol.push(parseInt($scope.rowCollection[i].year));
           $scope.ssfVol1.push(parseInt($scope.rowCollection[i].total));
       }
       console.log($scope.ssfVol);
       $scope.createBarChart($scope.ssfVol,$scope.ssfVol1);
       $scope.ssfIwstotal=total;
       $scope.ssfTot=ssfTot;
       $scope.iwsTot=iwsTot;
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
};
var barChart;
$scope.createBarChart = function(ssfVol,ssfVol1){
   
    if(!$scope.isIntialized){
        $scope.isIntialized = true;
        var surveryInProgressBar=document.getElementById("surveryInProgressBar2").getContext("2d");
        var gradient = surveryInProgressBar.createLinearGradient(0, 0, 0, 400);
        gradient.addColorStop(0, 'rgb(255,78,80)');   
        gradient.addColorStop(1, 'rgb(249,212,35)');
        var surveryInProgressBarData = {
            labels: ssfVol,
            datasets: [
                {
                    label: "Completed",
                    fillColor:gradient,
                    strokeColor: "rgba(111,166,215,1)",
                    highlightStroke: "rgba(111,166,215,1)",
                    data: ssfVol1
                }
            ]
        };
        barChart= new Chart(surveryInProgressBar).Bar(surveryInProgressBarData,{
        pointDotRadius: 10,
    });
  }else{
      barChart.destroy();
      $scope.isIntialized = false;
      $scope.createBarChart($scope.ssfVol,$scope.ssfVol1);
  } 
};

$scope.getSsfVol();
});
