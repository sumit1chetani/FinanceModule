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

#Containerdetail {
	height: auto;
	max-height: 350px;
	overflow-y: scroll;
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Switch BL</title>
</head>
<body>
	<%@ taglib prefix="security"
		uri="http://www.springframework.org/security/tags"%>
	<div class="wrapper-md">
		<div class="panel panel-default panel-default-list">
			<%@include file="/views/templates/panel-header-form.jsp"%>

			<form class="" method="POST" name="blForm" novalidate>
				<div class="col-md-12" style="border: 1px solid rgba(45, 137, 197);">
					<div class="row" style="margin-top: 2%;">
						<h1 style="padding-left: 2%; color: #1f3113;">Source</h1>
						<br>
						<div class="col-sm-12 col-md-12 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">BL No.<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<input class="form-control" type="text" form-name="blForm"
											validation="required" friendly-name="B/L No Source"
											name="blNoSource" id="blNoSource"
											ng-model="blNoData.blNoSource" placeholder="B/L No">
										<!-- <selectivity list="blListDropDown" property="blNoData.blNoSource" id="blNoSource"
								ng-model="blNoData.blNoSource" name="blNoSource" form-name="blForm"
								validation="required" friendly-name="B/L No Source"></selectivity> -->
									</div>
									<div class="col-md-3">
										<button ng-click="searchSource(blNoData.blNoSource)"
											class="btn btn-success" tooltip="Add Row" type="button">
											<i class="fa fa-search"></i>Search
										</button>
									</div>
								</div>
							</fieldset>
						</div>
						<tabset justified="true" class="tab-container"
							style="width: 98%;margin-left:  1%;margin-top:  4%;"> <tab
							heading="B/L" style="background:#5da5d4;font-weight: bold;">
						<div class="panel-body">
							<div class="table-responsive">
								<div class="col-md-12" style="width: 130%;">

									<div class="row" id="items">
										<table class="table table-striped b-t b-light">
											<thead>
												<tr>
													<th colspan=1 class="width_4">Place of Issue</th>
													<th colspan=1 class="width_6 text-center">Date of
														Issue</th>
													<th colspan=1 class="width_6 text-center">Vessel/Voyage</th>
													<th colspan=1 class="width_6 text-center">Receipt at</th>
													<th colspan=1 class="width_4 text-center">POL</th>
													<th colspan=1 class="width_4 text-center">POD</th>
													<th colspan=1 class="width_6 text-center">Shipment
														Terms</th>
													<th colspan=1 class="width_6 text-center">Customer</th>
												</tr>
											</thead>
											<tbody
												ng-repeat="(trIndex1, blCharge) in blNoData.blListSource">
												<tr>
													<td class="text-center">{{blCharge.placeofIssueSrc}}</td>
													<td class="text-center">{{blCharge.dateofIssueSrc}}</td>
													<td class="text-center">{{blCharge.vsl_VoyageSrc}}</td>
													<td class="text-center">{{blCharge.receiptAtSrc}}</td>
													<td class="text-center">{{blCharge.polSrc}}</td>
													<td class="text-center">{{blCharge.podSrc}}</td>
													<td class="text-center">{{blCharge.shipmentTermsSrc}}</td>
													<td class="text-center">{{blCharge.customerSrc}}</td>
												</tr>
												<tr>
													<td></td>


												</tr>
											</tbody>
										</table>
									</div>
									<br>
								</div>
							</div>
						</div>
						</tab> <tab heading="Container" style="background:#5da5d4;font-weight: bold;">
						<div class="panel-body">
							<div class="table-responsive" id="Containerdetail">
								<div class="col-md-12" style="width: 130%;">

									<div class="row" id="items">
										<table class="table table-striped b-t b-light">
											<thead>
												<tr>
													<th
														ng-if="blNoData.button=='MERGE' || blNoData.button=='PART'"
														colspan=1 class="width_2">select</th>
													<th colspan=1 class="width_5 text-center">Container No.</th>
													<th colspan=1 class="width_5 text-center">Type</th>
													<th colspan=1 class="width_7 text-center">Seal No.</th>
													<th colspan=1 class="width_5 text-center">Net Weight (Kg)</th>
													<th colspan=1 class="width_5 text-center">Gross Weight (Kg)</th>
													<!-- <th colspan=1 class="width_6 text-center">CBM</th>
												<th colspan=1 class="width_6 text-center">Check Digit</th> -->
													<th colspan=1 class="width_8 text-center">Package</th>
													<th colspan=1 class="width_3 text-center">No. of Packages </th>
													<th colspan=1 class="width_5 text-center">Commodity</th>
													<!-- <th colspan=1 class="width_6 text-center">is OOG</th>
												<th colspan=1 class="width_10 text-center">Marks</th> -->
													<!-- <th colspan=1 class="width_4 text-center">Action</th> -->

												</tr>
											</thead>
											<tbody
												ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlListSrc">
												<tr>
													<td
														ng-if="blNoData.button=='MERGE' || blNoData.button=='PART'"><label
														class="i-checks m-b-none"> <input type="checkbox"
														ng-change="blockSelect(blNoData.blcntrDtlListSrc,trIndex)"	ng-model="blcntrDtl.selectSrc"><i></i></label></td>
													<td class="text-center">{{blcntrDtl.cntrNoSrc}}</td>
													<td class="text-center">{{blcntrDtl.conTypeSrc}}</td>
													<td class="text-center">{{blcntrDtl.sealNoSrc}}</td>
													<td class="text-center">{{blcntrDtl.twSrc}}</td>
													<td class="text-center">{{blcntrDtl.gwSrc}}</td>
													<!-- <td class="text-center">{{blcntrDtl.cbSrc}}</td>
												<td class="text-center">{{blcntrDtl.checkdigitSrc}}</td> -->
													<td class="text-center">{{blcntrDtl.packageTypeSrc}}</td>
													<td class="text-center">{{blcntrDtl.noOfPckgsSrc}}</td>
													<td class="text-center">{{blcntrDtl.goodsSrc}}</td>
													<!-- <td class="text-center">{{blcntrDtl.isoSrc}}</td>
												<td class="text-center">{{blcntrDtl.marksSrc}}</td> -->
													<!-- <td class="text-center">
													<button ng-click="addinnercntrDtl(blcntrDtl)"
														class="btn btn-info" tooltip="Add Row" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</td> -->

												</tr>
												<!-- <tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light">
														<tr>
															<th class="width_2 text-center subTable-brs">Charge
																Code</th>
															<th class="width_2 text-center subTable-brs">Currency</th>
															<th class="width_2 text-center subTable-brs">Rate</th>
															<th class="width_2 text-center subTable-brs">Terms</th>
															<th class="width_2 text-center subTable-brs">Action</th>
														</tr>
														<tr
															ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeListSrc track by bTrIndex">
															<td class="subTable-brs text-center">{{blcntrinnerDtl.chargeCodeSrc}}</td>
															<td class="subTable-brs text-center">{{blcntrinnerDtl.currencySrc}}</td>
															<td class="subTable-brs">{{blcntrinnerDtl.unitRateSrc}}</td>
															<td class="subTable-brs">{{blcntrinnerDtl.termsSrc}}</td>
															<td class="subTable-brs">
															<button
																	ng-click="deleteinnercntrDtl(blcntrDtl,bTrIndex)"
																	class="btn btn-sm btn-danger" type="button"
																	tooltip="Delete">
																	<i class="fa  fa-trash-o"></i>
																</button></td>
														</tr>
													</table>
												</td>

											</tr> -->
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
						</tab> </tabset>
						<br>
					</div>
				</div>

				<div class="col-md-12"
					style="border: 2px solid rgba(45, 137, 197); margin-top: 2%; background: #085c9247;height: 30px;">
					<div class="form-group">
						<div class="col-md-12" style="border-radius: 25px;">
							<div class="radio radio-inline">
								<label class="i-checks" style="font-weight: bold;"> <input type="radio"
									class="radiobox style-0" name="copy" ng_model="blNoData.button" ng-click="erase()" 
									value="SWITCH" checked="checked"> <i></i> SWITCH
								</label>
							</div>
							<div class="radio radio-inline" style="margin-left: 37%;">
								<label class="i-checks" style="font-weight: bold;"> <input type="radio"
									class="radiobox style-0" name="merge"
									ng_model="blNoData.button" value="MERGE"> <i></i> MERGE
								</label>
							</div>
							<div class="radio radio-inline" style="margin-left: 39%;">
								<label class="i-checks" style="font-weight: bold;"> <input type="radio"
									class="radiobox style-0" name="part"  ng-click="erase()"
									ng_model="blNoData.button" value="PART"> <i></i> PART BL


								</label>
							</div>
							<!-- <div class="radio radio-inline" style="margin-left: 29%;">
								<label class="i-checks" style="font-weight: bold;"> <input type="radio"
									class="radiobox style-0" name="rob"  ng-click="erase()"
									ng_model="blNoData.button" value="ROB"> <i></i> ROB


								</label>
							</div> -->
						</div>

					</div>
				</div>


				<div class="col-md-12"
					style="border: 1px solid rgba(45, 137, 197); margin-top: 2%; margin-bottom: 2%;">
					<div class="row" style="margin-top: 2%;">
						<h1 style="padding-left: 2%; color: #1f3113;">Destination</h1>
						<br>
						<div class="col-sm-12 col-md-12 col-lg-12">
							<fieldset>
								<div class="form-group">
									<label class="col-md-1 control-label">BL No.<span
										style="color: red;" ng-if="blNoData.button=='MERGE'">*</span>
									</label>
									<div class="col-md-2">
										<input class="form-control" type="text" form-name="blForm"
											validation="required" friendly-name="B/L No Destination"
											ng-disabled="blNoData.button=='SWITCH' || blNoData.button=='PART' || blNoData.button=='ROB'"
											name="blNoDestination" id="blNoDestination"
											ng-model="blNoData.blNoDestination" placeholder="B/L No">
									</div>
									<!-- <div class="col-md-2">
									<button ng-click="newBL(blNoData.pol,blNoData.pod,blNoData.fpod)"
											class="btn btn-danger" style="border-radius: 50%;" title="Add New B/L" tooltip="Add Row" type="button">
											<i class="fa fa-plus"></i>
									</button>
									
								</div> -->
									<div class="col-md-2" style="margin-right: -50px;">
										<button ng-click="searchDestination(blNoData.blNoDestination)"
											class="btn btn-success" tooltip="Add Row" type="button">
											<i class="fa fa-search"></i>Search
										</button>

									</div>
							
									 <div class="form-group" ng-if="blNoData.button=='PART'" >
								<label class="col-md-1 control-label">BL Count<span
										style="color: red;">*</span></label>
								<div class="col-md-2" >
								<input class="form-control" type="text" form-name="blForm"
											validation="required" friendly-name="Bl Count"
											name="blcount" id="blcount"
											ng-model="blNoData.blcount" placeholder="">
								</div>
							</div> 
							<div class="col-md-2">
										<button ng-click="transfer(blNoData)" class="btn btn-info"
											tooltip="Add Row" type="button">
											<i class="fa fa-exchange"></i>Apply
										</button>
									</div>
							
							<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" ng-if="blNoData.button=='ROB'">
						<div class="col-md-4" >
							<label class="control-label">ROB Vessel <span
								style="color: red;">*</span></label>
							<selectivity list="vesselList" property="blNoData.robVessel"
								id="robVessel" ng-model="blNoData.robVessel" name="robVessel"
								friendly-name="ROB Vessel" form-name="blForm" validation="required"></selectivity>
						</div>
						 <div class="col-md-4">
							<label class="control-label">ROB Voyage <span
								style="color: red;">*</span></label>
							<selectivity list="voyageList" property="blNoData.robVoyage" id="robVoyage"
								ng-model="blNoData.robVoyage" name="robVoyage" form-name="blForm"
								friendly-name="ROB Voyage" validation="required"></selectivity>
						</div>
						
						<div class="col-md-4" >
							<label class="control-label">ROB POL <span
								style="color: red;">*</span></label>
							<selectivity list="robPolList" property="blNoData.robPol"
								id="robPol" ng-model="blNoData.robPol" name="robPol"
								friendly-name="ROB Pol" form-name="blForm" validation="required"></selectivity>
						</div>
						

						</div>
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" ng-if="blNoData.button=='ROB'">
				
						<div class="col-md-4" >
								<label class="control-label">ROB POD <span
								style="color: red;">*</span></label>
							<selectivity list="robPolList" property="blNoData.robPod" id="robPod"
								ng-model="blNoData.robPod" name="robPod" form-name="blForm"
								friendly-name="ROB Pod"  validation="required"></selectivity>

						</div>
						
						<div class="col-md-4" >
								<label class="control-label">ROB FPOD <span
								style="color: red;">*</span></label>
							<selectivity list="rPodList" property="blNoData.robFpod" id="robFpod"
								ng-model="blNoData.robFpod" name="robFpod" form-name="blForm"
								friendly-name="ROB Fpod"  validation="required"></selectivity>

						</div>
						
						
						</div>
									
									
								</div>
							</fieldset>
						</div>
						<tabset justified="true" class="tab-container" style="width: 98%;margin-left:  1%;margin-top:  4%;">   
					<tab heading="B/L" style="background:#5da5d4;font-weight: bold;">
					<div class="panel-body">
						<div class="table-responsive">
							<div class="col-md-12" style="width: 130%;">

								<div class="row" id="items">
										<table class="table table-striped b-t b-light">
											<thead>
												<tr>
													<!-- <th colspan=1 class="width_1"></th> -->
													<th colspan=1 class="width_4">Place of Issue</th>
													<th colspan=1 class="width_6 text-center">Date of Issue</th>
													<th colspan=1 class="width_6 text-center">Vessel/Voyage</th>
													<th colspan=1 class="width_6 text-center">Receipt at</th>
													<th colspan=1 class="width_4 text-center">POL</th>
													<th colspan=1 class="width_4 text-center">POD</th>
													<th colspan=1 class="width_6 text-center">Shipment Terms</th>
													<th colspan=1 class="width_6 text-center">Customer</th>
												</tr>
											</thead>
											<tbody ng-repeat="(trIndex1, blCharge) in blNoData.blListDestination">
												<tr>
													<!-- <td><label class="i-checks m-b-none"> <input
															type="checkbox" ng-model="blCharge.select"><i></i></label></td> -->
													<td class="text-center">{{blCharge.placeofIssueDstn}}</td>
													<td class="text-center">{{blCharge.dateofIssueDstn}}</td>
													<td class="text-center">{{blCharge.vsl_VoyageDstn}}</td>
													<td class="text-center">{{blCharge.receiptAtDstn}}</td>
													<td class="text-center">{{blCharge.polDstn}}</td>
													<td class="text-center">{{blCharge.podDstn}}</td>
													<td class="text-center">{{blCharge.shipmentTermsDstn}}</td>
													<td class="text-center">{{blCharge.customerDstn}}</td>
												</tr>
												<tr>
													<td></td>


												</tr>
											</tbody>
										</table>
										</div>
								<br>
							</div>
						</div>
					</div>
					</tab>
					<tab heading="Container" style="background:#5da5d4;font-weight: bold;">
					<div class="panel-body">
						<div class="table-responsive"  id="Containerdetail">
							<div class="col-md-12" style="width: 130%;">

								<div class="row" id="items">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<!-- <th colspan=1 class="width_2">select</th> -->
												<th colspan=1 class="width_5 text-center">Container No.</th>
												<th colspan=1 class="width_5 text-center">Type</th>
												<th colspan=1 class="width_7 text-center">Seal No.</th>
												<th colspan=1 class="width_5 text-center">Net Weight (Kg)</th>
												<th colspan=1 class="width_5 text-center">Gross Weight (Kg)</th>
												<!-- <th colspan=1 class="width_6 text-center">CBM</th>
												<th colspan=1 class="width_6 text-center">Check Digit</th> -->
												<th colspan=1 class="width_8 text-center">Package</th>
												<th colspan=1 class="width_3 text-center">No. of Packages </th>
												<th colspan=1 class="width_5 text-center">Commodity</th>
												<!-- <th colspan=1 class="width_6 text-center">is OOG</th>
												<th colspan=1 class="width_10 text-center">Marks</th> -->
											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlListDstn">
											<tr>
												<!-- <td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.selectDstn"><i></i></label></td> -->
												<td class="text-center">{{blcntrDtl.cntrNoDstn}}</td>
												<td class="text-center">{{blcntrDtl.conTypeDstn}}</td>
												<td class="text-center">{{blcntrDtl.sealNoDstn}}</td>
												<td class="text-center">{{blcntrDtl.twDstn}}</td>
												<td class="text-center">{{blcntrDtl.gwDstn}}</td>
												<!-- <td class="text-center">{{blcntrDtl.cbDstn}}</td>
												<td class="text-center">{{blcntrDtl.checkdigitDstn}}</td> -->
												<td class="text-center">{{blcntrDtl.packageTypeDstn}}</td>
												<td class="text-center">{{blcntrDtl.noOfPckgsDstn}}</td>
												<td class="text-center">{{blcntrDtl.goodsDstn}}</td>
												<!-- <td class="text-center">{{blcntrDtl.isoDstn}}</td>
												<td class="text-center">{{blcntrDtl.marksDstn}}</td> -->
												<!-- <td class="text-center">
													<button ng-click="addinnercntrDtl(blcntrDtl)"
														class="btn btn-info" tooltip="Add Row" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</td> -->

											</tr>
											<!-- <tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light">
														<tr>
															<th class="width_2 text-center subTable-brs">Charge
																Code</th>
															<th class="width_2 text-center subTable-brs">Currency</th>
															<th class="width_2 text-center subTable-brs">Rate</th>
															<th class="width_2 text-center subTable-brs">Terms</th>
															<th class="width_2 text-center subTable-brs">Action</th>
														</tr>
														<tr
															ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeListDstn track by bTrIndex">
															<td class="subTable-brs text-center">{{blcntrinnerDtl.chargeCodeDstn}}</td>
															<td class="subTable-brs text-center">{{blcntrinnerDtl.currencyDstn}}</td>
															<td class="subTable-brs">{{blcntrinnerDtl.unitRateDstn}}</td>
															<td class="subTable-brs">{{blcntrinnerDtl.termsDstn}}</td>
															<td class="subTable-brs"><button
																	ng-click="deleteinnercntrDtl(blcntrDtl,bTrIndex)"
																	class="btn btn-sm btn-danger" type="button"
																	tooltip="Delete">
																	<i class="fa  fa-trash-o"></i>
																</button></td>
														</tr>
													</table>
												</td>

											</tr> -->
										</tbody>
									</table>
									<!-- <button type="button" class="btn btn-sm btn-success "
										ng-click="addcntrDtl()">
										<i class="fa fa-plus"></i>
									</button>
									<button type="button" class="btn btn-sm btn-danger"
										ng-click="removecntrDtl(blNoData.blcntrDtlList)">
										<i class="fa fa-minus"></i>
									</button>

									<div class="padding-right-5">
										<div class="col-md-4"></div>
									</div> -->


								</div>
								<br>



							</div>
						</div>
					</div>
					</tab>  
					</tabset>
					<br>
				</div>
				<div class="panel-body float-left padding-10" style="width: 100%;padding-left: 42%;padding-right: 42%;" ng-if="tempShow">
			 <div class="table-responsive" >
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							
 						<!-- 	<th ng-if="blNoData.button=='SWITCH'" >SWITCH B/L Number:</th>
                            <th ng-if="blNoData.button=='PART'">PART B/L Number:</th> -->
                                   <th> B/L Number:</th>

							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collec in tempList">
							<td>{{collec}}</td>
						</tr>
                     </tbody>
				</table>
			
		</div>		
</div>
</div>
			<br> <br>
			
			   
			<div align="center">
					<button type="button" class="btn btn-success"
						ng-click="save(blForm)" ng-disabled="check">Save</button>
					<button type="button" class="btn btn-info" ng-click="reset()">Reset</button>
					<button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
				</div>
				<br>
			</div>

		</form>
		</div>
	</div>
</body>
</html>

<script type="text/ng-template" id="saveCnfrm">
<div class="ngdialog-content"style="width:302px">
<div class="padding-0">
 <div class="panel panel-default padding-0">
  <div class="panel-heading font-bold">CONFIRMATION</div>
  <div class="panel-body">
   <div>Are you sure want to Save?</div>
   <div class="form-actions">
    <div class="row">
     <div class="col-md-12">
      <button ng-model="add" class="btn btn-success" type="submit" class="btn btn-success" ng-click="saveData()">
       <i class="fa fa-check"></i>
       Yes
      </button>
      <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="noCnfrm()">
       <i class="fa fa-close"></i>
       No
      </button>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
</div>
 </script>