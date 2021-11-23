'use strict';

app.controller('switchBLCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog,
		utilsService,$state,sharedProperties,$window,$stateParams,$timeout,toaster,validationService) {

	$scope.displayedCollection = [];
	$scope.tableData = [];
	$scope.blcntrDtlList = [];

	$scope.select = false;
	$scope.submitted = false;
	$scope.listAdd= false;

	var date  = new Date();
	var dateString =  date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes();

	$scope.rowCollectionFollowup=[];
	$scope.referralList=[];
	$scope.isEdit = false;

	$scope.searchSrc= false;
	$scope.transfering = false;
	$scope.tairDetailList =[];

	$scope.blNoData = {
			blNo : '',
			blNoSource : '',
			blNoDestination : '',
			button : 'SWITCH',
			issuePlace : '',
			issueDate : '',
			onBoard : '',
			vslVoyage : '',
			robVessel:'',
			robVoyage:'',
			robPol:'',
			robPod:'',
			robFpod:'',
			receiptAt : '',
			pol : '',
			blcount:1,
			pod : '',
			pot : '',
			fpod : '',
			terms : '',
			noBls : 3,
			ref : '',
			mVoyage : '',
			loadType : '',
			service : '',
			client : '',
			jobNo : '',
			agent : '',
			remarks : '',
			shipment : '',
			payer : '',
			status : '',
			released : '',
			messers : '',
			shippers : '',
			cnee : '',
			notify1 : '',
			notify2 : '',
			forwarder : '' ,
			maincom : 'SHIPPERS LOAD STOW AND COUNT',
			twgt: '',
			gwgt : '',
			nwgt : '',
			cbm : '',
			pkgs : '',
			goods : '',
			marks : '',
			shipperId : '',
			cneeId : '',
			notify1Id : '',
			notify2Id : '',
			forwarderId : '',
			otherblno:'',
			unCode:'',
			imcoCharge:'',
			blListSource :[],
			blListDestination :[],
			blcntrDtlListSrc : [
				/*{selectSrc : false,
				 outwardCntrIdSrc : '',
				  cntrNoSrc : '',
				  sizeSrc : '',
				  typeSrc : '',
				  sealNoSrc : '',
				  twSrc : '',
				  gwSrc : '',
				  cbSrc : '',
				  netSrc : '',
				  checkdigitSrc :'',
				  fleSrc : '',
				  soSrc : '',
				  packageTypeSrc : '',
				  noOfPckgsSrc : '',
				  goodsSrc : '',
				  isoSrc : '',
				  marksSrc : '',
				  pol : '',
				  pod : '',
				  fpod : '',
				  polTerSrc : '',
				  podTerSrc : '',
				  actionSrc : '' }*/
				],
				blcntrDtlListDstn : [
					/* {
					 * selectDstn : true,
				  outwardCntrIdSrc : '',
				  outwardCntrIdDstn : '',
				  cntrNoSrc : '',
				  sizeSrc : '',
				  typeSrc : '',
				  sealNoSrc : '',
				  twSrc : '',
				  gwSrc : '',
				  cbSrc : '',
				  netSrc : '',
				  checkdigitSrc :'',
				  fleSrc : '',
				  soSrc : '',
				  packageTypeSrc : '',
				  noOfPckgsSrc : '',
				  goodsSrc : '',
				  isoSrc : '',
				  marksSrc : '',
				  polTerSrc : '',
				  podTerSrc : '',
				  actionSrc : ''
				   }*/
					],
					blCharges : [],
					removeCntr : [],
					removeCntrCharge : [],
					removeCntrPckg : [],
					removeCharge : []

	};

	$scope.blockSelect = function(list,index){/*
		if($scope.blNoData.button == 'PART'){
		var count=0;
		for(var i=0; i < list.length; i++){
			if(list[i].selectSrc){
				count++;
			}
		}
		if(count > 1 ){
			list[index].selectSrc=false;
			logger.logError( 'Only one container allowed to select for PART BL operation  !');
		}
		}
	*/}
	$http.get($stateParams.tenantid+'/api/switchbl/getblList').success(function(datas) {
		$scope.blListDropDown = datas;
	});

	 /// ROB Vessel drop down
    $http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});
    
    /// ROB Voyage drop down
    $scope.$watch('blNoData.robVessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	    });
    //// ROB POL & FPOD
    $scope.$watch('blNoData.robVoyage', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyNU',newValue).success(function(data) {
	    		  $scope.robPolList = data;
	    	  })

	      }
	})
	$http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
						$scope.rPodList = data.commonUtilityBean;

					});
	$scope.searchSource = function(blSourceValue) {
		if (blSourceValue != '' && blSourceValue != undefined && blSourceValue != null) {
			$http.get($stateParams.tenantid+ '/api/switchbl/edit?blNo='+blSourceValue+'&value=source').success(function(data) {
				if(data.isSuccess == true){
				$scope.blNoData.pol = data.pol;
				$scope.blNoData.pod = data.pod;
				$scope.blNoData.fpod = data.fpod;
				$scope.blNoData.blListSource = data.blListSource;
				$scope.blNoData.blcntrDtlListSrc = data.blcntrDtlListSrc;
				$scope.blNoData.blcntrDtlListSrc[0].chargeListSrc = data.blcntrDtlListSrc[0].chargeListSrc;
				}
				else{
					logger.logError(data.message);
				}
			});
		}
		$scope.searchSrc = true;
	};

	$scope.searchDestination = function(blDestinationValue) {
		if($scope.blNoData.blNoSource != '' && $scope.blNoData.blNoSource != undefined && $scope.blNoData.blNoSource != null){
			if ($scope.searchSrc) {
				if (blDestinationValue != '' && blDestinationValue != undefined && blDestinationValue != null || $scope.blNoData.button == 'SWITCH' || $scope.blNoData.button == 'PART') {
					if($scope.blNoData.button == 'SWITCH'){ 
						/*if($scope.blNoData.blNoDestination!=$scope.blNoData.blNoSource){
							$scope.getBLDetails(blDestinationValue);
						} else {
							logger.logError( 'Source B/L No and Destination B/L No should not match');
						}*/
					} else if ($scope.blNoData.button == 'MERGE') {
						if($scope.blNoData.blNoDestination!=$scope.blNoData.blNoSource){
									$scope.getBLDetails(blDestinationValue);
						} else {
							logger.logError( 'Source B/L No and Destination B/L No should not match');
						}

					} else if ($scope.blNoData.button == 'PART') {
						/*if($scope.blNoData.blNoDestination!=$scope.blNoData.blNoSource){
							$scope.getBLDetails(blDestinationValue);
						} else {
							logger.logError( 'Source B/L No and Destination B/L No should not match');
						}*/
					}
				} else {
					logger.logError( 'Please fill the Destination B/L Number');
				}
			}
		} else {
			logger.logError( 'Please fill the Source B/L Number');
		}
	};
	$scope.newBL = function(pol,pod,fpod) {
		if ($scope.blNoData.blNoDestination == '' || $scope.blNoData.blNoDestination == undefined) {
			$http.get($stateParams.tenantid+ '/api/switchbl/getBL?pol='+pol+'&pod='+pod+'&fpod='+fpod).success(function(data) {
				debugger
				$scope.blNoData.blNoDestination = data;
			});
		}

	};
	$scope.erase = function() {
	if($scope.blNoData.button == 'SWITCH' || $scope.blNoData.button == 'PART'){
		$scope.blNoData.blNoDestination = '';
		if($scope.blNoData.button == 'PART'){
			for(var i=0; i < $scope.blNoData.blcntrDtlListSrc.length; i++){
				$scope.blNoData.blcntrDtlListSrc[i].selectSrc=false;
			}
			}
		}
		
	}
	$scope.transfer = function(blData) {
		if($scope.blNoData.blNoSource != '' && $scope.blNoData.blNoSource != undefined && $scope.blNoData.blNoSource != null){
			if(!$scope.transfering){
				$scope.transfering = true;
				if($scope.blNoData.button == 'MERGE'){
					if ($scope.blNoData.blNoDestination != '' && $scope.blNoData.blNoDestination != undefined && $scope.blNoData.blNoDestination != null) {
						var transferValuesIn = [];
						for(var i=$scope.blNoData.blcntrDtlListSrc.length-1;i>=0;i--){
							if($scope.blNoData.blcntrDtlListSrc[i].selectSrc){
								transferValuesIn.push($scope.blNoData.blcntrDtlListSrc[i].outwardCntrIdSrc);
								var blcntrDtl = {
										cntrNoDstn : $scope.blNoData.blcntrDtlListSrc[i].cntrNoSrc,
										outwardCntrIdSrc : $scope.blNoData.blcntrDtlListSrc[i].outwardCntrIdSrc,
										sizeDstn : $scope.blNoData.blcntrDtlListSrc[i].sizeSrc,
										conTypeDstn : $scope.blNoData.blcntrDtlListSrc[i].conTypeSrc,
										sealNoDstn : $scope.blNoData.blcntrDtlListSrc[i].sealNoSrc,
										twDstn : $scope.blNoData.blcntrDtlListSrc[i].twSrc,
										gwDstn : $scope.blNoData.blcntrDtlListSrc[i].gwSrc,
										cbDstn : $scope.blNoData.blcntrDtlListSrc[i].cbSrc,
										netDstn : $scope.blNoData.blcntrDtlListSrc[i].netSrc,
										checkdigitDstn : $scope.blNoData.blcntrDtlListSrc[i].checkdigitSrc,
										unCodeDstn : $scope.blNoData.blcntrDtlListSrc[i].unCodeSrc,
										imcoChargeDstn : $scope.blNoData.blcntrDtlListSrc[i].imcoChargeSrc,
										fleDstn : $scope.blNoData.blcntrDtlListSrc[i].fleSrc,
										soDstn : $scope.blNoData.blcntrDtlListSrc[i].soSrc,
										packageTypeDstn : $scope.blNoData.blcntrDtlListSrc[i].packageTypeSrc,
										noOfPckgsDstn : $scope.blNoData.blcntrDtlListSrc[i].noOfPckgsSrc,
										goodsDstn : $scope.blNoData.blcntrDtlListSrc[i].goodsSrc,
										isoDstn : $scope.blNoData.blcntrDtlListSrc[i].isoSrc,
										marksDstn : $scope.blNoData.blcntrDtlListSrc[i].marksSrc,
										polTerDstn : $scope.blNoData.blcntrDtlListSrc[i].polTerSrc,
										podTerDstn : $scope.blNoData.blcntrDtlListSrc[i].podTerSrc,
										actionDstn : $scope.blNoData.blcntrDtlListSrc[i].actionSrc
								}
								$scope.blNoData.blcntrDtlListDstn.push(blcntrDtl);
								$scope.blNoData.blcntrDtlListSrc.splice(i,1);
							}
						}
						$scope.blNoData.transferValues = transferValuesIn;
						$scope.blNoData.blNo = $scope.blNoData.blNoSource;
					}	else {
						logger.logError( 'Please fill the Destination B/L Number');
					}
				}
				if($scope.blNoData.button == 'SWITCH' || $scope.blNoData.button == 'ROB'){
					var transferValuesIn = [];
					for(var i=0;i<$scope.blNoData.blListSource.length;i++){
						var blcntrDtl = {
								placeofIssueDstn : $scope.blNoData.blListSource[i].placeofIssueSrc,
								dateofIssueDstn : $scope.blNoData.blListSource[i].dateofIssueSrc,
								vsl_VoyageDstn : $scope.blNoData.blListSource[i].vsl_VoyageSrc,
								receiptAtDstn : $scope.blNoData.blListSource[i].receiptAtSrc,
								polDstn : $scope.blNoData.blListSource[i].polSrc,
								podDstn : $scope.blNoData.blListSource[i].podSrc,
								shipmentTermsDstn : $scope.blNoData.blListSource[i].shipmentTermsSrc,
								customerDstn : $scope.blNoData.blListSource[i].customerSrc
						}
						$scope.blNoData.blListDestination.push(blcntrDtl);
					}
					for(var j=0;j<$scope.blNoData.blcntrDtlListSrc.length;j++){
						var blcntrDtlSrc = {
								cntrNoDstn : $scope.blNoData.blcntrDtlListSrc[j].cntrNoSrc,
								outwardCntrIdSrc : $scope.blNoData.blcntrDtlListSrc[j].outwardCntrIdSrc,
								sizeDstn : $scope.blNoData.blcntrDtlListSrc[j].sizeSrc,
								conTypeDstn : $scope.blNoData.blcntrDtlListSrc[j].conTypeSrc,
								sealNoDstn : $scope.blNoData.blcntrDtlListSrc[j].sealNoSrc,
								twDstn : $scope.blNoData.blcntrDtlListSrc[j].twSrc,
								gwDstn : $scope.blNoData.blcntrDtlListSrc[j].gwSrc,
								cbDstn : $scope.blNoData.blcntrDtlListSrc[j].cbSrc,
								netDstn : $scope.blNoData.blcntrDtlListSrc[j].netSrc,
								checkdigitDstn : $scope.blNoData.blcntrDtlListSrc[j].checkdigitSrc,
								unCodeDstn : $scope.blNoData.blcntrDtlListSrc[j].unCodeSrc,
								imcoChargeDstn : $scope.blNoData.blcntrDtlListSrc[j].imcoChargeSrc,
								fleDstn : $scope.blNoData.blcntrDtlListSrc[j].fleSrc,
								soDstn : $scope.blNoData.blcntrDtlListSrc[j].soSrc,
								packageTypeDstn : $scope.blNoData.blcntrDtlListSrc[j].packageTypeSrc,
								noOfPckgsDstn : $scope.blNoData.blcntrDtlListSrc[j].noOfPckgsSrc,
								goodsDstn : $scope.blNoData.blcntrDtlListSrc[j].goodsSrc,
								isoDstn : $scope.blNoData.blcntrDtlListSrc[j].isoSrc,
								marksDstn : $scope.blNoData.blcntrDtlListSrc[j].marksSrc,
								polTerDstn : $scope.blNoData.blcntrDtlListSrc[j].polTerSrc,
								podTerDstn : $scope.blNoData.blcntrDtlListSrc[j].podTerSrc,
								actionDstn : $scope.blNoData.blcntrDtlListSrc[j].actionSrc
						}
						$scope.blNoData.blcntrDtlListDstn.push(blcntrDtlSrc);
					}
					/*$scope.blNoData.transferValues = transferValuesIn;*/
					$scope.blNoData.blNo = $scope.blNoData.blNoSource;
				}
				if($scope.blNoData.button == 'PART'){
					var transferValuesIn = [];
					for(var i=0;i<$scope.blNoData.blListSource.length;i++){
						var blcntrDtl = {
								placeofIssueDstn : $scope.blNoData.blListSource[i].placeofIssueSrc,
								dateofIssueDstn : $scope.blNoData.blListSource[i].dateofIssueSrc,
								vsl_VoyageDstn : $scope.blNoData.blListSource[i].vsl_VoyageSrc,
								receiptAtDstn : $scope.blNoData.blListSource[i].receiptAtSrc,
								polDstn : $scope.blNoData.blListSource[i].polSrc,
								podDstn : $scope.blNoData.blListSource[i].podSrc,
								shipmentTermsDstn : $scope.blNoData.blListSource[i].shipmentTermsSrc,
								customerDstn : $scope.blNoData.blListSource[i].customerSrc
						}
						$scope.blNoData.blListDestination.push(blcntrDtl);
					}

					for(var i=$scope.blNoData.blcntrDtlListSrc.length-1;i>=0;i--){
						if($scope.blNoData.blcntrDtlListSrc[i].selectSrc){
							transferValuesIn.push($scope.blNoData.blcntrDtlListSrc[i].outwardCntrIdSrc);
							var blcntrDtl = {
									cntrNoDstn : $scope.blNoData.blcntrDtlListSrc[i].cntrNoSrc,
									outwardCntrIdSrc : $scope.blNoData.blcntrDtlListSrc[i].outwardCntrIdSrc,
									sizeDstn : $scope.blNoData.blcntrDtlListSrc[i].sizeSrc,
									conTypeDstn : $scope.blNoData.blcntrDtlListSrc[i].conTypeSrc,
									sealNoDstn : $scope.blNoData.blcntrDtlListSrc[i].sealNoSrc,
									twDstn : $scope.blNoData.blcntrDtlListSrc[i].twSrc,
									gwDstn : $scope.blNoData.blcntrDtlListSrc[i].gwSrc,
									cbDstn : $scope.blNoData.blcntrDtlListSrc[i].cbSrc,
									netDstn : $scope.blNoData.blcntrDtlListSrc[i].netSrc,
									checkdigitDstn : $scope.blNoData.blcntrDtlListSrc[i].checkdigitSrc,
									unCodeDstn : $scope.blNoData.blcntrDtlListSrc[i].unCodeSrc,
									imcoChargeDstn : $scope.blNoData.blcntrDtlListSrc[i].imcoChargeSrc,
									fleDstn : $scope.blNoData.blcntrDtlListSrc[i].fleSrc,
									soDstn : $scope.blNoData.blcntrDtlListSrc[i].soSrc,
									packageTypeDstn : $scope.blNoData.blcntrDtlListSrc[i].packageTypeSrc,
									noOfPckgsDstn : $scope.blNoData.blcntrDtlListSrc[i].noOfPckgsSrc,
									goodsDstn : $scope.blNoData.blcntrDtlListSrc[i].goodsSrc,
									isoDstn : $scope.blNoData.blcntrDtlListSrc[i].isoSrc,
									marksDstn : $scope.blNoData.blcntrDtlListSrc[i].marksSrc,
									polTerDstn : $scope.blNoData.blcntrDtlListSrc[i].polTerSrc,
									podTerDstn : $scope.blNoData.blcntrDtlListSrc[i].podTerSrc,
									actionDstn : $scope.blNoData.blcntrDtlListSrc[i].actionSrc
							}
							$scope.blNoData.blcntrDtlListDstn.push(blcntrDtl);
							$scope.blNoData.blcntrDtlListSrc.splice(i,1);
						}
					}
					$scope.blNoData.transferValues = transferValuesIn;
					$scope.blNoData.blNo = $scope.blNoData.blNoSource;
				}
			}
		} else {
			logger.logError( 'Please fill the Destination B/L Number');
		}
	}
	$scope.save = function(blForm) {
		 $scope.check = true;
		ngDialog.open({
			template : 'saveCnfrm',
			scope : $scope
		});
	}
	$scope.noCnfrm = function() {
		ngDialog.close();
	}
	$scope.testFun = function(){
		$scope.tempShow=false;
	}
	$scope.tempList=[];
	$scope.tempShow=false;
	$scope.saveData = function(blForm) {
		if (new validationService().checkFormValidity($scope.blForm)) {
			if( $scope.blNoData.blcntrDtlListDstn.length != 0 ){
				
			
			 $scope.check = true;
		$http.post($stateParams.tenantid+'/api/switchbl/insert', $scope.blNoData).success(function(result) {
			console.log("result" + result);
			if (result.isSuccess) {
				$scope.blNoData.blNoDestination = result.blNos;
				$scope.tempList=result.blNos;
				logger.logSuccess("Saved successfully!");
				$scope.tempShow=true;
				 /* $timeout( function(){
					  $scope.tempShow=false;
			        }, 6000 );*/
				if($scope.blNoData.button=='SWITCH' || $scope.blNoData.button=='PART'){
					$scope.blNoData = {
							blNo : '',
							blNoSource : '',
							blNoDestination : '',
							button : 'SWITCH',
							issuePlace : '',
							issueDate : '',
							onBoard : '',
							vslVoyage : '',
							receiptAt : '',
							pol : '',
							pod : '',
							pot : '',
							fpod : '',
							terms : '',
							noBls : 3,
							ref : '',
							mVoyage : '',
							loadType : '',
							service : '',
							client : '',
							jobNo : '',
							agent : '',
							remarks : '',
							shipment : '',
							payer : '',
							status : '',
							released : '',
							messers : '',
							shippers : '',
							cnee : '',
							notify1 : '',
							notify2 : '',
							forwarder : '' ,
							maincom : 'SHIPPERS LOAD STOW AND COUNT',
							twgt: '',
							gwgt : '',
							nwgt : '',
							cbm : '',
							pkgs : '',
							goods : '',
							marks : '',
							shipperId : '',
							cneeId : '',
							notify1Id : '',
							notify2Id : '',
							forwarderId : '',
							otherblno:'',
							unCode:'',
							imcoCharge:'',
							blListSource :[],
							blListDestination :[],
							blcntrDtlListSrc : [{
								selectSrc : false,
								outwardCntrIdSrc : '',
								cntrNoSrc : '',
								sizeSrc : '',
								typeSrc : '',
								sealNoSrc : '',
								twSrc : '',
								gwSrc : '',
								cbSrc : '',
								netSrc : '',
								checkdigitSrc :'',
								unCodeSrc:'',
								imcoChargeSrc:'',
								fleSrc : '',
								soSrc : '',
								packageTypeSrc : '',
								noOfPckgsSrc : '',
								goodsSrc : '',
								isoSrc : '',
								marksSrc : '',
								pol : '',
								pod : '',
								fpod : '',
								polTerSrc : '',
								podTerSrc : '',
								actionSrc : ''
							}],
							blcntrDtlListDstn : [

								{selectDstn : true,
									outwardCntrIdSrc : '',
									outwardCntrIdDstn : '',
									cntrNoSrc : '',
									sizeSrc : '',
									typeSrc : '',
									sealNoSrc : '',
									twSrc : '',
									gwSrc : '',
									cbSrc : '',
									netSrc : '',
									checkdigitSrc :'',
									unCodeSrc:'',
									imcoChargeSrc:'',
									fleSrc : '',
									soSrc : '',
									packageTypeSrc : '',
									noOfPckgsSrc : '',
									goodsSrc : '',
									isoSrc : '',
									marksSrc : '',
									polTerSrc : '',
									podTerSrc : '',
									actionSrc : ''
								}
								],
								blCharges : [],
								removeCntr : [],
								removeCntrCharge : [],
								removeCntrPckg : [],
								removeCharge : []

					};
				} else {
					$scope.blNoData = {
							blNo : '',
							blNoSource : '',
							blNoDestination : '',
							button : 'SWITCH',
							issuePlace : '',
							issueDate : '',
							onBoard : '',
							vslVoyage : '',
							receiptAt : '',
							pol : '',
							pod : '',
							pot : '',
							fpod : '',
							terms : '',
							noBls : 3,
							ref : '',
							mVoyage : '',
							loadType : '',
							service : '',
							client : '',
							jobNo : '',
							agent : '',
							remarks : '',
							shipment : '',
							payer : '',
							status : '',
							released : '',
							messers : '',
							shippers : '',
							cnee : '',
							notify1 : '',
							notify2 : '',
							forwarder : '' ,
							maincom : 'SHIPPERS LOAD STOW AND COUNT',
							twgt: '',
							gwgt : '',
							nwgt : '',
							cbm : '',
							pkgs : '',
							goods : '',
							marks : '',
							shipperId : '',
							cneeId : '',
							notify1Id : '',
							notify2Id : '',
							forwarderId : '',
							otherblno:'',
							unCode:'',
							imcoCharge:'',
							blListSource :[],
							blListDestination :[],
							blcntrDtlListSrc : [{
								selectSrc : false,
								outwardCntrIdSrc : '',
								cntrNoSrc : '',
								sizeSrc : '',
								typeSrc : '',
								sealNoSrc : '',
								twSrc : '',
								gwSrc : '',
								cbSrc : '',
								netSrc : '',
								checkdigitSrc :'',
								unCodeSrc:'',
								imcoChargeSrc:'',
								fleSrc : '',
								soSrc : '',
								packageTypeSrc : '',
								noOfPckgsSrc : '',
								goodsSrc : '',
								isoSrc : '',
								marksSrc : '',
								pol : '',
								pod : '',
								fpod : '',
								polTerSrc : '',
								podTerSrc : '',
								actionSrc : ''
							}],
							blcntrDtlListDstn : [

								{selectDstn : true,
									outwardCntrIdSrc : '',
									outwardCntrIdDstn : '',
									cntrNoSrc : '',
									sizeSrc : '',
									typeSrc : '',
									sealNoSrc : '',
									twSrc : '',
									gwSrc : '',
									cbSrc : '',
									netSrc : '',
									checkdigitSrc :'',
									unCodeSrc:'',
									imcoChargeSrc:'',
									fleSrc : '',
									soSrc : '',
									packageTypeSrc : '',
									noOfPckgsSrc : '',
									goodsSrc : '',
									isoSrc : '',
									marksSrc : '',
									polTerSrc : '',
									podTerSrc : '',
									actionSrc : ''
								}
								],
								blCharges : [],
								removeCntr : [],
								removeCntrCharge : [],
								removeCntrPckg : [],
								removeCharge : []

					};
				}
				 $scope.check = false;
				$scope.noCnfrm();
				$scope.transfering = false;
			} else {
				logger.logError(result.message);
				 $scope.check = false;

			}
		
		
		}).error(function(result) {
			console.log("data" + result);
		});
			}else{
				logger.logError("Please Select Atleast One Container");
				 $scope.check = false;

			}
		}else {
			toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew($scope.blForm.$validationSummary),555000, 'trustedHtml');
		}
	}

	//Popup after save
	$scope.newBLCnfrm = function() {
		ngDialog.close();
		$scope.blNoData = {
				blNo : '',
				blNoSource : '',
				blNoDestination : '',
				button : 'SWITCH',
				issuePlace : '',
				issueDate : '',
				onBoard : '',
				vslVoyage : '',
				receiptAt : '',
				pol : '',
				pod : '',
				pot : '',
				fpod : '',
				terms : '',
				noBls : 3,
				ref : '',
				mVoyage : '',
				loadType : '',
				service : '',
				client : '',
				jobNo : '',
				agent : '',
				remarks : '',
				shipment : '',
				payer : '',
				status : '',
				released : '',
				messers : '',
				shippers : '',
				cnee : '',
				notify1 : '',
				notify2 : '',
				forwarder : '' ,
				maincom : 'SHIPPERS LOAD STOW AND COUNT',
				twgt: '',
				gwgt : '',
				nwgt : '',
				cbm : '',
				pkgs : '',
				goods : '',
				marks : '',
				unCode:'',
				imcoCharge:'',
				shipperId : '',
				cneeId : '',
				notify1Id : '',
				notify2Id : '',
				forwarderId : '',
				otherblno:'',
				blListSource :[],
				blListDestination :[],
				blcntrDtlListSrc : [{
					selectSrc : false,
					outwardCntrIdSrc : '',
					cntrNoSrc : '',
					sizeSrc : '',
					typeSrc : '',
					sealNoSrc : '',
					twSrc : '',
					gwSrc : '',
					cbSrc : '',
					netSrc : '',
					checkdigitSrc :'',
					unCodeSrc:'',
					imcoChargeSrc:'',
					fleSrc : '',
					soSrc : '',
					packageTypeSrc : '',
					noOfPckgsSrc : '',
					goodsSrc : '',
					isoSrc : '',
					marksSrc : '',
					pol : '',
					pod : '',
					fpod : '',
					polTerSrc : '',
					podTerSrc : '',
					actionSrc : ''
				}],
				blcntrDtlListDstn : [

					{selectDstn : true,
						outwardCntrIdSrc : '',
						outwardCntrIdDstn : '',
						cntrNoSrc : '',
						sizeSrc : '',
						typeSrc : '',
						sealNoSrc : '',
						twSrc : '',
						gwSrc : '',
						cbSrc : '',
						netSrc : '',
						checkdigitSrc :'',
						unCodeSrc:'',
						imcoChargeSrc:'',
						fleSrc : '',
						soSrc : '',
						packageTypeSrc : '',
						noOfPckgsSrc : '',
						goodsSrc : '',
						isoSrc : '',
						marksSrc : '',
						polTerSrc : '',
						podTerSrc : '',
						actionSrc : ''
					}
					],
					blCharges : [],
					removeCntr : [],
					removeCntrCharge : [],
					removeCntrPckg : [],
					removeCharge : []

		};
	};

	$scope.getBLDetails = function(blDestinationValue){
		$http.get($stateParams.tenantid+ '/api/switchbl/edit?blNo='+blDestinationValue+'&value=destination').success(function(data) {
			
			if(data.isSuccess == true){
				$scope.blNoData.blListDestination = data.blListDestination;
				$scope.blNoData.blcntrDtlListDstn = data.blcntrDtlListDstn;
			}else{
				logger.logError(data.message);
			}
			
		});
	}


	$scope.reset = function(){
		$scope.transfering = false;
		$scope.blNoData = {
				blNo : '',
				blNoSource : '',
				blNoDestination : '',
				button : 'SWITCH',
				issuePlace : '',
				issueDate : '',
				onBoard : '',
				vslVoyage : '',
				receiptAt : '',
				pol : '',
				pod : '',
				pot : '',
				fpod : '',
				terms : '',
				noBls : 3,
				ref : '',
				mVoyage : '',
				loadType : '',
				service : '',
				client : '',
				jobNo : '',
				agent : '',
				remarks : '',
				shipment : '',
				payer : '',
				status : '',
				released : '',
				messers : '',
				shippers : '',
				cnee : '',
				notify1 : '',
				notify2 : '',
				forwarder : '' ,
				maincom : 'SHIPPERS LOAD STOW AND COUNT',
				twgt: '',
				gwgt : '',
				nwgt : '',
				cbm : '',
				pkgs : '',
				goods : '',
				unCode:'',
				imcoCharge:'',
				marks : '',
				shipperId : '',
				cneeId : '',
				notify1Id : '',
				notify2Id : '',
				forwarderId : '',
				otherblno:'',
				blListSource :[],
				blListDestination :[],
				blcntrDtlListSrc : [{
					/* selectSrc : false,
    						 outwardCntrIdSrc : '',
    						  cntrNoSrc : '',
    						  sizeSrc : '',
    						  typeSrc : '',
    						  sealNoSrc : '',
    						  twSrc : '',
    						  gwSrc : '',
    						  cbSrc : '',
    						  netSrc : '',
    						  checkdigitSrc :'',
    						  fleSrc : '',
    						  soSrc : '',
    						  packageTypeSrc : '',
    						  noOfPckgsSrc : '',
    						  goodsSrc : '',
    						  isoSrc : '',
    						  marksSrc : '',
    						  pol : '',
    						  pod : '',
    						  fpod : '',
    						  polTerSrc : '',
    						  podTerSrc : '',
    						  actionSrc : ''*/
				}],
				blcntrDtlListDstn : [

					/*  {selectDstn : true,
    						  outwardCntrIdSrc : '',
    						  outwardCntrIdDstn : '',
    						  cntrNoSrc : '',
    						  sizeSrc : '',
    						  typeSrc : '',
    						  sealNoSrc : '',
    						  twSrc : '',
    						  gwSrc : '',
    						  cbSrc : '',
    						  netSrc : '',
    						  checkdigitSrc :'',
    						  fleSrc : '',
    						  soSrc : '',
    						  packageTypeSrc : '',
    						  noOfPckgsSrc : '',
    						  goodsSrc : '',
    						  isoSrc : '',
    						  marksSrc : '',
    						  polTerSrc : '',
    						  podTerSrc : '',
    						  actionSrc : ''
    						  }*/
					],
					blCharges : [],
					removeCntr : [],
					removeCntrCharge : [],
					removeCntrPckg : [],
					removeCharge : []

		};
	}

	$scope.cancel = function() {
		$state.go('dashboard.list',{tenantid:$stateParams.tenantid});
	};

});

