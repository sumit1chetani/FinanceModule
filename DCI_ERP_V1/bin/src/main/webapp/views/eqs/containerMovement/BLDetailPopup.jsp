<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}

nav-tabs>li>a:hover {
	color: #000000 !important;
}

nav-tabs>li>a {
	color: #000000 !important;
}

a {
	color: #423e3e;
	/* color: white; */
	text-decoration: none;
	cursor: pointer;
}
</style>
<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 66%;
	position: absolute;
	top: 20%;
	left: 17%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Outward BL</title>
</head>
<body>
	<%@ taglib prefix="security"
		uri="http://www.springframework.org/security/tags"%>
	<div class="wrapper-md">
		<div class="panel panel-default panel-default-list">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<form class="" method="POST" name="blForm" novalidate>
			<div class="col-md-12">

				<div class="col-md-12"
					style="border: 1px solid rgba(0, 0, 0, 0.22);">
					<br>
					 

					<div class="col-md-4">
						<label class="control-label" style="font-weight: bold;">Booking No :</label> {{blDetailList.bookingno}}
				
					</div>



					<div class="col-md-4">
						<label class="control-label" style="font-weight: bold;">ShipmentOrder No :</label> {{blDetailList.jobNo}}
						 
						<div class="col-md-3" ng-if="isEdit">
						<label class="col-md-4 control-label">BL TYPE :</label> 
									<div class="col-md-4">
										<label control-label">{{bltype}}</label>
									</div>


					</div>
					<br>
				</div>
				<div class="col-md-12"
					style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;"> Place of Issue :</label> {{blDetailList.issuePlace}}
					 
						</div>


						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Date of Issue :</label> {{blDetailList.issueDate}}
							 
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Vsl.Voyage :</label> {{blDetailList.vslVoyage}}
						</div>
					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">



						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Receipt at :</label> {{blDetailList.receiptAt}}
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.L :</label> {{blDetailList.pol}}
						 
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.D :</label> {{blDetailList.pod}}
							 
						</div>

					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
               <div class="col-md-4">
                <label class="control-label" style="font-weight: bold;">F.P.O.D :</label> {{blDetailList.fpod}}
             
              </div> 
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Shipment Terms :</label> {{blDetailList.terms}}
						 

						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">No.Bls :</label> {{blDetailList.noBls}}  
						</div>
						
					</div>
					<br>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display Vessel :</label> {{blDetailList.disvessel}}  
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display Voyage :</label> {{blDetailList.disvoyage}}  
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display P.O.R :</label> {{blDetailList.disPor}}  
						</div>
						</div><br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display P.O.L :</label> {{blDetailList.disPol}} 
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display P.O.D :</label>{{blDetailList.disPod}} 
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display F.P.O.D :</label> {{blDetailList.disFpod}}  
						</div>
						</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<div class="col-md-4" ng-if="!isEdit">
							<label class="control-label" style="font-weight: bold;">Customer :</label> {{blDetailList.client}}
							 
						</div>
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label" style="font-weight: bold;">Customer :</label> {{blDetailList.client}}
						 
						</div>
						 
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">On Board :</label> {{blDetailList.onBoard}}
						 
						</div>

						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Remarks :</label> {{blDetailList.remarks}}  
						</div>
					</div>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">REF :</label> {{blDetailList.ref}} 
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Other Bl No  :</label> {{blDetailList.otherblno}}  
						</div>
						 <div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.D.1 :</label> {{blDetailList.pod1}}
							 

						</div>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
				<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.D.2 :</label> {{blDetailList.pod2}}
							 
						</div></div>
						
						
						</div>
				<br> <br>
				<div class="col-md-12"
					style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
					<br>
					<tabset justified="true" class="tab-container"> <tab
						heading="Names " style="background:#5F9EA0;  ">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<fieldset>
								 

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Shippers :</label> {{blDetailList.shipperId}}

										 
									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Cnee :</label> {{blDetailList.cnee}}
										 
									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Shippers Dtls :</label> 
										<label class="control-label" ng-bind-html="blDetailList.shipper"></label>
								 

									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Cnee Dtls :</label> {{blDetailList.cneeId}}
										 

									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify1 :</label> {{blDetailList.notify1Id}}
										 
									</div>
									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify2 :</label> {{blDetailList.notify2Id}}
									 
									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify1 Dtls :</label> {{blDetailList.notify1}}
									 
									</div>
									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify2 Dtls :</label> {{blDetailList.notify2}}
										 

									</div>
									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Forwarder :</label> {{blDetailList.forwarderId}}
										 

									</div>

									<div class="col-md-6"> 
										<label class="control-label" style="font-weight: bold;">Forwarder Dtls :</label> {{blDetailList.forwarder}}
										 
									</div>
								</fieldset>
							</div>

						</div>
						<br>

					 
					</div>
					</tab> <tab heading="Goods" style="background:#5F9EA0">
					<div class="panel-body">

						<div class="row">
							<div class="col-md-12">
								<label class="control-label" style="font-weight: bold;">Main Commodity :</label> {{blDetailList.maincom}} 

							</div>

						 
							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">NO OF PKGS :</label> {{blDetailList.pkgs}}  

							</div>

							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">N.WGT :</label> {{blDetailList.n_wgt}}  
					   
							</div>
							
                              <div class="col-md-6" >
							<label
								  class="i-checks m-b-none" style="font-weight: bold; padding-left: 0px;!important">Print N.WGT  
									<input type="checkbox" id="checkNetWgt" name ="checkNetWgt" ng-model="blDetailList.checkNetWgt" form-name="blForm" disabled ><i style="margin-left: 20px;"></i>
							</label>  
						</div>
							
							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">G.WGT :</label> {{blDetailList.g_wgt}} 

							</div> 


							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">CBM :</label> {{blDetailList.cbm}} 

							</div>



							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">Goods :</label> {{blDetailList.goods}}
								 

							</div>

							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">Marks :</label> {{blDetailList.marks}}
								 

							</div>
						</div>
						<br>

					</div>
					</tab>  <tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 166%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												 
												<th colspan=1 class="width_9 text-center">Cntr No  </th>
												<th colspan=1 class="width_5 text-center">Type  </th>
												<th colspan=1 class="width_7 text-center">Seal No </th>
												<th colspan=1 class="width_7 text-center">NW (KG) </th>
												<th colspan=1 class="width_7 text-center">GW (KG) </th>
												<th colspan=1 class="width_6 text-center">CBM  </th>
												<th colspan=1 class="width_6 text-center">Check Digit  </th>
												<th colspan=1 class="width_6 text-center">Net </th>
												<th colspan=1 class="width_6 text-center">FLE  </th>
									
												<th colspan=1 class="width_7 text-center">Package </th>
												<th colspan=1 class="width_6 text-center">No of Packages </th>
												<th colspan=1 class="width_12 text-center">Commodity</th>
												<th colspan=1 class="width_4 text-center">is OOG</th>
												<th colspan=1 class="width_5 text-center">Hazardous</th>
												<th colspan=1 class="width_5 text-center">OWS</th>
												<th colspan=1 class="width_8 text-center">UN Code</th>
												<th colspan=1 class="width_8 text-center">IMCO Charge</th>
												 
									 
											 

											</tr>
										</thead>
										<tbody
											ng-repeat="trIndex in blDetailList.blcntrDtlList"> 
											<tr>
												 
												<td class="text-center">  {{trIndex.containernumber}} </td>
												<td class="text-center">{{trIndex.conType}} </td> 
											 
												<td class="text-center">{{trIndex.sealNo}} </td>
												<td class="text-center">{{trIndex.tw}} </td>
												<td class="text-center">{{trIndex.gw}} </td>
												<td class="text-center">{{trIndex.cb}} </td>
												<td class="text-center">{{trIndex.checkdigit}} </td>
												<td class="text-center">{{trIndex.net}} </td>
									               <td class="text-center"> {{trIndex.fle}}   </td>
									 
												<td class="text-center">{{trIndex.packageType}} </td>
												<td class="text-center">{{trIndex.noOfPckgs}} </td>
												<td class="text-center">{{trIndex.goods}}</td>
												<td class="text-center">{{trIndex.isOog}}</td>
												<td class="text-center">{{trIndex.hazardous}} </td>
												<td class="text-center">{{trIndex.ows}}</td>
												<td class="text-center">{{trIndex.unCode}}</td>
													
													<td class="text-center">{{trIndex.imcoCharge}}</td>
												 

											</tr>
											 
										</tbody>
									</table>
									 

									<div class="padding-right-5">
										<div class="col-md-4"></div>
									</div>


								</div>
								<br>



							</div>
						</div>
					</div>
					</tab>   </tabset>
					<br>
					<center><span ng-show ="isPrintLimitExceed == true" style="color: red;">NOTE: BL print count limit exceeded. Data cannot be modified!!!</span></center>
				</div>

			</div>
			<br> <br>
			<div align="center">
				<div >
					 
					<button type="button" class="btn btn-danger" ng-click="cancel()" style="margin-top: 10px;">Cancel</button>
				</div>
			 
				<br>
			</div>

		</form>
	</div>
	</div>
</body>
</html>
