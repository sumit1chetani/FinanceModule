app.controller('MainCtrl', function($scope,$state,$http,$modal,ngDialog) {	
  $scope.tenantId = $('#tenantId').val();
  $scope.userId = $('#userName').val();
  $scope.isMaster = $('#isMaster').val();
  $scope.empId = $('#empId').val();
  $scope.leftMenuBar=true;
  if($scope.isMaster == 'true'){
	  $state.go('organization.show');
  }else{
	  $state.go('dashboard.list',{tenantid:$scope.tenantId});
  }
  $scope.subMenuId = '0';
  $scope.showSubMenu = function(id){
      $scope.subMenuId = id;
  };
  $scope.getCurrentDate = function(){
      var d=new Date();
      var year=d.getFullYear();
      var month=d.getMonth()+1;
      if (month<10){
          month="0" + month;
      };
      var day=d.getDate();
      if(day<10){
          day="0" + day;
      }
      $scope.currentDate=day + "/" + month + "/" + year;
 }
  $scope.getCurrentDate();
  
  $scope.tdsHelpVideo = function(helpVideoName,headerName) {
	  debugger
      ngDialog.close();
      ngDialog.open({
          template : 'tdsHelpVideoTemplate',
          scope : $scope,
          controller : [ '$scope', 'ngDialog', function($scope, ngDialog) {
              $scope.helpVideoPath = '/filePath/'+helpVideoName;
              $scope.headerName = headerName;
              $scope.closeHelpDialog = function() {
                  ngDialog.close();
              };
          } ]
      });
  };
  
});
