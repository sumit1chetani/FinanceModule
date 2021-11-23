angular.module('ilantus.launchpadCtrl', [])
.controller('launchpadCtrl', function($scope,$rootScope) {
	
	console.log($rootScope);
	$scope.launchpadList1=[{
		launchName:"GoogleMail",
		imgUrl:"img/mail.png"
	},{
		launchName:"AASalesForce",
		imgUrl:"img/sales force2.jpg"
	},{
		launchName:"AccessRequest",
		imgUrl:"img/access.jpg"
	},{
		launchName:"BusinessManagement",
		imgUrl:"img/crm-icon.png"
	},{
		launchName:"LinkedIn",
		imgUrl:"img/linkedin.png"
	},{
		launchName:"Product License",
		imgUrl:"img/ilantus.jpg"
	},{
		launchName:"Putty",
		imgUrl:"img/PuTTY_icon_128px.png"
	}];
	
	$scope.launchpadList2=[{
		launchName : 'TFIM SP',
		imgUrl : 'img/generic.png'
	},{
		launchName : 'Gartner',
		imgUrl : 'img/gartner-tile.jpg'
	},{
		launchName : 'SonarQube',
		imgUrl : 'img/waves-sonarqube-96.png'
	},{
		launchName : 'Skype',
		imgUrl : 'img/skype_Logo.png'
	}];
	
/*	if($rootScope.userName=="Admin"){
		$scope.launchpadList=$scope.launchpadList1;
	}else if($rootScope.userName=="Pramod"){
		$scope.launchpadList=$scope.launchpadList2;
	*/
	

	
});