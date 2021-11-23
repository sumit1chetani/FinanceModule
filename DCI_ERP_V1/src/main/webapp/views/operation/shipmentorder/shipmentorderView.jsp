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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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

<div class="col-md-6"
					style="border: 1px solid rgba(0, 0, 0, 0.22);">
					<br>
<fieldset>
<div class="form-group">
									<label class="col-md-6 control-label"> Created By</label>
									<div class="col-md-5">
										<label class="col-md-12 control-label"
											style="text-align: left;">{{blNoData.created_by}}</label>
									</div>
								</div>
								</fieldset>
								<fieldset>
								<div class="form-group">
									<label class="col-md-6 control-label">Created Date</label>
									<div class="col-md-5">
										<label class="col-md-12 control-label"
											style="text-align: left;">{{blNoData.created_date}}</label>
									</div>
								</div>
</fieldset>
</div>
<div class="col-md-6"
					style="border: 1px solid rgba(0, 0, 0, 0.22);">
					<br>

<fieldset>
<div class="form-group">
									<label class="col-md-4 control-label"> Modified By</label>
									<div class="col-md-5">
										<label class="col-md-12 control-label"
											style="text-align: left;">{{blNoData.modified_by}}</label>
									</div>
								</div>
								</fieldset>
								
								<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Modified Date</label>
									<div class="col-md-5">
										<label class="col-md-12 control-label"
											style="text-align: left;">{{blNoData.modified_date}}</label>
									</div>
								</div>
</fieldset>
</div>


					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
</div>

				<div class="col-md-12"
					style="border: 1px solid rgba(0, 0, 0, 0.22);">
					<br>
					<!-- 	<div class="col-md-6">
						<label class="control-label">Shipmentorder No <span
							style="color: red;">*</span></label>
						<div>
							<input class="form-control" type="text" placeholder="Job No"
								class="form-control" id="shipmentNo"
								ng-model="blNoData.shipmentNo" name="shipmentNo"
								form-name="blForm" validation="required" friendly-name="B/L No"
								disabled="true">
						</div>
					</div> -->

					<input class="form-control" type="hidden" placeholder="Job No"
						class="form-control" id="shipmentNo"
						ng-model="blNoData.shipmentNo" name="shipmentNo"
						form-name="blForm" friendly-name="B/L No" disabled="true">
					<div class="col-md-6">
						<label class="control-label">Booking No<span
							style="color: red;">*</span></label>
						<div>
						<input class="form-control" type="text" placeholder="Job No"
								class="form-control" id="bookingNo"
								ng-model="blNoData.bookingNo" name="bookingNo"
								form-name="blForm" validation="required" friendly-name="B/L No"
								disabled="true">
							<!-- <selectivity list="bookingList" property="blNoData.bookingNo"
								id="bookingNo" ng-model="blNoData.bookingNo" name="bookingNo"
								form-name="blForm" validation="required"
								friendly-name="Booking No" disabled="true"></selectivity> -->
						</div>


					</div>
					<div class="col-md-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-6 control-label">File Upload </label>
								<div class="col-md-6">
									<button class="btn btn-primary" type="button"
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Import from Excel 
									</button>
									<a id="sampleDownload" style="display: none"
										href="/home/paragon/Downloads/export/shippinginstructionsamplefile.xlsx" 
										download="shippinginstructionsamplefile.xlsx"></a>
									 
								</div>
							</div>
						</fieldset>

					</div>
					<br>
				</div>
				<div class="col-md-12"
					style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<!--    <div class="col-md-4">
                 <label class="control-label">Issue Place  <span style="color: red;">*</span></label>
                <selectivity list="portlist" property="blNoData.issuePlace" id="issuePlace" ng-model="blNoData.issuePlace"
               name="issuePlace" form-name="blForm" validation="required" 
                friendly-name="Issue Place"></selectivity>  
                 
                  <selectivity list="issuePlaceList" property="blNoData.issuePlace" id="issuePlace" ng-model="blNoData.issuePlace"
               name="issuePlace" form-name="blForm" validation="required" 
                friendly-name="Issue Place"></selectivity>
                </div> -->


						<!--  <div class="col-md-4">
                  <label class="control-label">Issue Date  <span style="color: red;">*</span></label>
				<ng-bs3-datepicker data-ng-model="blNoData.issueDate"
											name="issueDate" form-name="blForm" validation="required" 
											friendly-name="Issue Date" validation="required" />
</div> -->


					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<div class="col-md-4">
							<label class="control-label">Vsl.Voyage <span
								style="color: red;">*</span></label>
							<selectivity list="vesselVoyageList"
								property="blNoData.vslVoyage" id="vslVoyage"
								ng-model="blNoData.vslVoyage" name="mVoyage" form-name="blForm"
								validation="required" friendly-name="Vsl.Voyage" disabled="true"></selectivity>
						</div>

						<div class="col-md-4" ng-if="!isEdit">
							<label class="control-label">Customer <span
								style="color: red;">*</span></label>
							<selectivity list="customerList" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required" disabled="true"></selectivity>
						</div>
						
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Customer <span
								style="color: red;">*</span></label>
							<selectivity list="customerList1" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required" disabled="true"></selectivity>
						</div>
						<div class="col-md-4">
							<label class="control-label">REF <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="REF" class="form-control" id="ref"
								friendly-name="Ref" ng-model="blNoData.ref" name="ref"
								form-name="blForm" ng-disabled="true">
						</div>

						<!-- <div class="col-md-4">
							<label class="control-label">Payer <span
								style="color: red;"></span></label>
							<selectivity list="payerList" property="blNoData.payer"
								id="payer" ng-model="blNoData.payer" name="payer"
								form-name="blForm"></selectivity>
						</div> -->

						<!--           <div class="col-md-4">
                  <label class="control-label">Receipt at  <span style="color: red;">*</span></label>
                    <selectivity list="issuePlaceList" property="blNoData.receiptAt" id="receiptAt" ng-model="blNoData.receiptAt"
               name="receiptAt"  form-name="blForm" validation="required" 
                friendly-name="Receipt at"></selectivity>
                  <selectivity list="portlist" property="blNoData.receiptAt" id="receiptAt" ng-model="blNoData.receiptAt"
               name="receiptAt" form-name="blForm" validation="required" 
                friendly-name="Receipt at "></selectivity>    
                
                
          </div> -->

					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<div class="col-md-4">
							<label class="control-label">P.O.L <span
								style="color: red;">*</span></label>
							<selectivity list="polList" property="blNoData.pol" id="pol"
								ng-model="blNoData.pol" name="pol" form-name="blForm"
								validation="required" friendly-name="POL" disabled="true"></selectivity>

						</div>


						<div class="col-md-4">
							<label class="control-label">P.O.D <span
								style="color: red;">*</span></label>
							<selectivity list="portlist" property="blNoData.pod" id="pod"
								ng-model="blNoData.pod" name="pod" form-name="blForm"
								validation="required" friendly-name="POD" disabled="true"></selectivity>
						</div>

						<div class="col-md-4">
							<label class="control-label">F.P.O.D <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.fpod" id="fpod"
								ng-model="blNoData.fpod" name="fpod" form-name="blForm"
								friendly-name="FPOD" disabled="true"></selectivity>
						</div>

						<!-- <div class="col-md-4">
							<label class="control-label">P.O.T <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.pot" id="pot"
								ng-model="blNoData.pot" name="pot" form-name="blForm"
								friendly-name="POT"></selectivity>
						</div> -->
						<!-- <div class="col-md-4">
							<label class="control-label">On Board</label>
							<ng-bs3-datepicker data-ng-model="blNoData.onBoard"
								name="onBoard" form-name="blForm" />
						</div> -->


					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label">Display Vessel <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvessel"
								friendly-name="disvessel" ng-model="blNoData.disvessel" name="disvessel"
								form-name="blForm" ng-disabled="true">
						</div>
						<div class="col-md-4">
							<label class="control-label">Display Voyage <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvoyage"
								friendly-name="disvoyage" ng-model="blNoData.disvoyage" name="disvoyage"
								form-name="blForm" ng-disabled="true">
						</div>
						<div class="col-md-4">
							<label class="control-label">Display P.O.R <span
								style="color: red;"></span></label> 
								<selectivity list="portlist" property="blNoData.disPor" id="disPor"
								ng-model="blNoData.disPor" name="disPor" form-name="blForm"
								friendly-name="disPor"></selectivity>
						</div>
						</div>
						<br>
				<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label">Display P.O.L <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPol"
								friendly-name="disPol" ng-model="blNoData.disPol" name="disPol"
								form-name="blForm" ng-disabled="true">
						</div>
						<div class="col-md-4">
							<label class="control-label">Display P.O.D <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPod"
								friendly-name="disPod" ng-model="blNoData.disPod" name="disPod"
								form-name="blForm" ng-disabled="true">
						</div>
						<div class="col-md-4">
							<label class="control-label">Display F.P.O.D <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disFpod"
								friendly-name="disFpod" ng-model="blNoData.disFpod" name="disFpod"
								form-name="blForm" ng-disabled="true">
						</div>
						</div>
						<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						<!-- <div class="col-md-4">
							<label class="control-label">Terms <span
								style="color: red;">*</span></label>
							<selectivity list="termsOfPayment" property="blNoData.terms"
								id="terms" ng-model="blNoData.terms" name="terms"
								form-name="blForm" validation="required"
								friendly-name="Terms Of Payment"></selectivity>

						</div> -->


						<!--     <div class="col-md-4">
                <label class="control-label">No.Bls  <span style="color: red;">*</span></label>
                <input type="number" placeholder="No.Bls" class="form-control" id="noBls"  friendly-name="No.Bls"
                ng-model="blNoData.noBls" name="noBls"  form-name="blForm" validation="required" >  
              </div> -->




						<!-- <div class="col-md-4">
							<label class="control-label">Shipment Type <span
								style="color: red;">*</span></label>
							<selectivity list="serviceList" property="blNoData.service"
								id="service" ng-model="blNoData.service" name="service"
								friendly-name="Shipment Type" form-name="blForm"
								validation="required"></selectivity>


						</div> -->
						<div class="col-md-4" >
							<label class="control-label">Destination Agent <span
								style="color: red;">*</span></label>
							<selectivity list="agentList" property="blNoData.deliveryAgent"
								id="deliveryAgent" ng-model="blNoData.deliveryAgent" name="deliveryAgent"
								friendly-name="deliveryAgent" form-name="blForm" validation="required" disabled="true"></selectivity>
						</div>
						   <div class="col-md-4">
							<label class="control-label">P.O.D.1 <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.pod1" id="pod1"
								ng-model="blNoData.pod1" name="pod1" form-name="blForm"
								friendly-name="POD1" disabled="true"></selectivity>
						</div>
						
						
						
						  <div class="col-md-4">
							<label class="control-label">P.O.D.2 <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.pod2" id="pod2"
								ng-model="blNoData.pod2" name="pod1" form-name="blForm"
								friendly-name="POD2" disabled="true"></selectivity>
						</div>
							
						<!-- <div class="col-md-4" style="margin-top: 36px;">
							
								<label class="col-md-4 control-label" >SOC<span
									style="color: red"></span></label>
								<div class="col-md-4" style="margin-left: -77px;">
									<label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="blNoData.soc" id="soc" 
											ng-change="loadAllPorts(blNoData.soc)">
											<i></i>
									</label>
								</div>
							
						</div> -->
					</div>
					
					<br>
					<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						<div class="col-md-4">
							<label class="control-label">M.Voyage</label>
							<selectivity list="vesselVoyageList" property="blNoData.mVoyage"
								id="mVoyage" ng-model="blNoData.mVoyage" name="mVoyage"
								form-name="blForm"></selectivity>

						</div>


						<div class="col-md-4">
							<label class="control-label">Load Type <span
								style="color: red;">*</span></label>

							<selectivity list="load" property="blNoData.loadType"
								id="loadType" ng-model="blNoData.loadType" name="loadType"
								friendly-name="Load Type" form-name="blForm"
								validation="required"></selectivity>

						</div>
							<div class="col-md-4">
							<label class="control-label">Agent</label>
							<selectivity list="agentList" property="blNoData.agent"
								id="agent" ng-model="blNoData.agent" name="agent"
								form-name="blForm" friendly-name="Load Type"></selectivity>

						</div>
						

					</div> -->
					<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						
						
						
					
					</div> -->

					<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 2%;">


						<div class="col-md-4">
							<label class="control-label">Shipment <span
								style="color: red;">*</span></label>
							<selectivity list="shipmentList" property="blNoData.shipment"
								id="shipment" ng-model="blNoData.shipment" name="shipment"
								form-name="blForm" validation="required"
								friendly-name="Shipment"></selectivity>
						</div>

						<div class="col-md-4">
							<label class="control-label">Status</label>
							<selectivity list="statusList" property="blNoData.status"
								id="status" ng-model="blNoData.status" name="status"
								form-name="blForm" friendly-name="Staus"></selectivity>
						</div>
						<div class="col-md-4">
							<label class="control-label" style="margin-top: 8%;">Released</label>
							<input type="checkbox" id="released" ng-model="blNoData.released"
								name="released">
						</div>
					</div>
					<br> -->

					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

                 <div class="col-md-4">
							<label class="control-label">Remarks</label>
							<textarea class="form-control" type="text" name="remarks"
								id="remarks" ng-model="blNoData.remarks" placeholder="Remarks" ng-disabled="true">	 </textarea>
						</div>
<div class="col-md-4">
							<label class="control-label">Freight At</label>
							
							<input class="form-control"
								type="text" placeholder="" class="form-control" id="freightAt"
								friendly-name="freightAt" ng-model="blNoData.freightAt" name="freightAt"
								form-name="blForm" ng-disabled="true">
								
							
						</div><div class="col-md-4">
							<label class="control-label">Freight By</label>
							
							<input class="form-control"
								type="text" placeholder="" class="form-control" id="freightBy"
								friendly-name="freightBy" ng-model="blNoData.freightBy" name="freightBy"
								form-name="blForm" ng-disabled="true">
								
							
						</div>


					</div>
					
				 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<!-- <div class="col-md-4">
							<label class="control-label">SOB Type<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="sobType"
								friendly-name="sobType" ng-model="blNoData.sobType" name="sobType"
								form-name="blForm" ng-disabled="true">
						</div> -->
						<div class="col-md-4">
							<label class="control-label">BL Type<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="billtype"
								friendly-name="billtype" ng-model="blNoData.billtype" name="billtype"
								form-name="blForm" ng-disabled="true">
						</div>
						<div class="col-md-4">
							<label class="control-label">UOM<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="gw"
								friendly-name="gw" ng-model="blNoData.gw_unit" name="gw"
								form-name="blForm" ng-disabled="true">
						</div>
						<div class="col-md-4">
							<label class="control-label">Notify Telephone No<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigTel"
								friendly-name="consigTel" ng-model="blNoData.consigTel" name="consigTel"
								form-name="blForm" ng-disabled="true">
						</div>
						</div>
						
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					
						<div class="col-md-4">
							<label class="control-label">Notify Email<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigEmail"
								friendly-name="consigEmail" ng-model="blNoData.consigEmail" name="consigEmail"
								form-name="blForm" ng-disabled="true">
						</div>
						
						</div>
						

                      

 


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
									<!-- <div class="col-md-12">
										<label class="control-label">Messers</label> <input
											class="form-control" type="text" name="messers" id="messers"
											ng-model="blNoData.messers" placeholder="Messers">

									</div> -->

									<!-- <div class="col-md-6">
										<label class="control-label">Shippers<span
							style="color: red;">*</span></label>

										<selectivity list="customerList" property="blNoData.shipperId"
											id="shipperId" ng-model="blNoData.shipperId" name="shipperId"
											form-name="blForm" validation ="required" friendly-name="Shippers"></selectivity>
									</div>

									<div class="col-md-6">
										<label class="control-label">Cnee<span
							style="color: red;">*</span></label>
										<selectivity list="customerList" property="blNoData.cneeId"
											id="cneeId" ng-model="blNoData.cneeId" name="cneeId"
											form-name="blForm" validation="required" friendly-name="Cnee"></selectivity>

									</div> -->

									<div class="col-md-6">
										<label class="control-label">Shippers Dtls</label>
										<textarea class="form-control" type="text" name="shipper"
											id="shipper" ng-model="blNoData.shipper"
											placeholder="Shippers" ng-disabled="true">
                            </textarea>

									</div>

									<div class="col-md-6">
										<label class="control-label">Cnee Dtls</label>
										<textarea class="form-control" type="text" name="cnee"
											id="cnee" ng-model="blNoData.cnee" placeholder="Cnee" ng-disabled="true">
                            </textarea>

									</div>

									<!-- <div class="col-md-6">
										<label class="control-label">Notify1</label>
										<selectivity list="customerList" property="blNoData.notify1Id"
											id="notify1Id" ng-model="blNoData.notify1Id" name="notify1Id"
											form-name="blForm"></selectivity>

									</div>
									<div class="col-md-6">
										<label class="control-label">Notify2</label>
										<selectivity list="customerList" property="blNoData.notify2Id"
											id="notify2Id" ng-model="blNoData.notify2Id" name="notify2Id"
											form-name="blForm"></selectivity>
									</div> -->

									<div class="col-md-6">
										<label class="control-label">Notify1 Dtls</label>
										<textarea class="form-control" type="text" name="notify1"
											id="notify1" ng-model="blNoData.notify1"
											placeholder="Notify1" ng-disabled="true">
                            </textarea>

									</div>
									<div class="col-md-6">
										<label class="control-label">Notify2 Dtls</label>
										<textarea class="form-control" type="text" name="notify2"
											id="notify2" ng-model="blNoData.notify2"
											placeholder="Notify2" ng-disabled="true">
                            </textarea>

									</div>

								<!-- 	<div class="col-md-6">
										<label class="control-label">Forwarder</label>
										<selectivity list="customerList"
											property="blNoData.forwarderId" id="forwarderId"
											ng-model="blNoData.forwarderId" name="forwarderId"
											form-name="blForm"></selectivity>

									</div> --> 
 

									<div class="col-md-6">
										<label class="control-label">Forwarder Dtls</label>
										<textarea class="form-control" type="text" name="forwarder"
											id="forwarder" ng-model="blNoData.forwarder"
											placeholder="Forwarder" ng-disabled="true">
                            </textarea>


									</div>
								</fieldset>
							</div>

						</div>
						<br>

						<!--  </div>
	</div>
	</div> -->
					</div>
					</tab> <!--  --> <tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 166%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_2">Select</th>
												<th colspan=1 class="width_9 text-center">Cntr No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">Type<span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_3 text-center">SOC<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">Seal No <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">NW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">GW (KG)<span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_6 text-center">CBM <span
													style="color: red;"></span></th>
													
													<th colspan=1 class="width_5 text-center">Temperature <span
													style="color: red;"></span></th>
													<th colspan=1 class="width_5 text-center">Vent <span
													style="color: red;"></span></th>
													<th colspan=1 class="width_5 text-center">Humidity <span
													style="color: red;"></span></th>
													
												<!-- <th colspan=1 class="width_6 text-center">Net <span
													style="color: red;"></span></th> -->
												<!-- <th colspan=1 class="width_6 text-center">FLE <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_6 text-center">SOC <span
													style="color: red;">*</span></th> -->
												<th colspan=1 class="width_7 text-center">Package <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">No of
													Packages <span style="color: red;">*</span>
												</th>
												<th colspan=1 class="width_12 text-center">Commodity</th>
												<th colspan=1 class="width_4 text-center">is OOG</th>
												<th colspan=1 class="width_5 text-center">Hazardous</th>
												<th colspan=1 class="width_5 text-center">OWS</th>
												<th colspan=1 class="width_7 text-center">Marks</th>
												<th colspan=1 class="width_8 text-center">UN Code</th>
												<th colspan=1 class="width_8 text-center">IMCO Class</th>
												<!-- <th colspan=1 class="width_6 text-center">POL Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;">*</span></th> -->
												<th colspan=1 class="width_4 text-center">Action</th>

											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList track by trIndex"
											ng-controller="shipmenttableCtrl">
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
												<td class="text-center"><selectivity
														list="containerList" property="blcntrDtl.cntrNo"
														id="cntrNo" ng-model="blcntrDtl.cntrNo" name="cntrNo"
														form-name="blForm" validation="required" disabled ="true" 
														friendly-name="Contaier No"></selectivity> <!-- 				
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No"></selectivity> -->
												</td>
												<td class="text-center"><selectivity
														list="containerTypeList" property="blcntrDtl.type"
														id="type" ng-model="blcntrDtl.type" name="type"
														friendly-name="Con Type" form-name="blForm"
														validation="required" disabled="true"></selectivity></td>
														<td class="text-center">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="blcntrDtl.soc" disabled="true"><i></i></label>
												</td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" 
													friendly-name="Seal No" name="sealNo" id="sealNo"
													ng-model="blcntrDtl.sealNo" placeholder="Seal No" ng-disabled="true"></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="tw" name="tw"
													id="tw" ng-model="blcntrDtl.tw" placeholder="Net Weight" 
													data-ng-keyup="calcWeight(blcntrDtl,$index)" ng-disabled="true"></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="gw" name="gw"
													id="gw" ng-model="blcntrDtl.gw" validation="required"
													placeholder="Gross Weight"
													data-ng-keyup="calcWeight(blcntrDtl,$index)" ng-disabled="true"></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="cb" name="cb"
													id="cb" ng-model="blcntrDtl.cb" placeholder="CBM"
													data-ng-keyup="calcWeight(blcntrDtl,$index)" ng-disabled="true"></td>
													
													<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="temperature" name="temperature"
													id="temperature" ng-model="blcntrDtl.temperature" placeholder="Temperature"
													ng-disabled="true"></td>
													
													<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="vent" name="vent"
													id="vent" ng-model="blcntrDtl.vent" placeholder="Vent"
													 ng-disabled="true"></td>
													
													<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="humidity" name="humidity"
													id="humidity" ng-model="blcntrDtl.humidity" placeholder="Humidity"
													 ng-disabled="true"></td>
													
												<!--<td class="text-center"><input class="form-control"
													type="text" name="net" form-name="blForm"
													 friendly-name="net" id="net"
													ng-model="blcntrDtl.net" placeholder="NET"></td>
												 <td class="text-center"><selectivity list="fleList"
														property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle"
														validation="required" name="fle" form-name="blForm"
														friendly-name="FLE"></selectivity></td>
												<td class="text-center"><selectivity list="socList"
														property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so"
														validation="required" name="SOC" form-name="blForm"
														friendly-name="SOC"></selectivity></td> -->
												<td class="text-center"><selectivity list="packageList"
														property="blcntrDtl.packageType" id="packageType"
														ng-model="blcntrDtl.packageType" name="packageType"
														form-name="blForm" friendly-name="Package Type"
														friendly-name="Package Type" disabled="true"></selectivity></td>
												<td class="text-center"><input class="form-control"
													type="text" name="noo" id="noo"
													ng-model="blcntrDtl.noOfPckgs" form-name="blForm"
													friendly-name="No Of Package" placeholder="No Of Package"
													form-name="blForm" validation="required" data-ng-keyup="calcWeight(blcntrDtl,$index)" ng-disabled="true"></td>
												<td class="text-center"><input class="form-control"
													type="text" name="g" id="g" ng-model="blcntrDtl.goods"
													placeholder="Goods Desc" ng-disabled="true"></td>
												<td class="text-center"><input type="checkbox"
													name="iso" id="iso" ng-model="blcntrDtl.iso" ng-disabled="true"><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="hazardous" id="hazardous" ng-model="blcntrDtl.hazardous" ng-disabled="true"><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="ows" id="ows" ng-model="blcntrDtl.ows" ng-disabled="true"><i></i>
												</td>
												<td class="text-center"><input class="form-control"
													type="text" name="mar" id="mar" ng-model="blcntrDtl.marks"
													placeholder="MARKS" ng-disabled="true"></td>
													<td class="text-center"><input class="form-control"
													type="text" name="unCode" id="unCode" ng-model="blcntrDtl.unCode"
													placeholder="UN CODE" ng-disabled="true"></td>
													
													<td class="text-center"><input class="form-control"
													type="text" name="imcoCharge" id="imcoCharge" ng-model="blcntrDtl.imcoCharge"
													placeholder="IMCO" ng-disabled="true"></td>
											 
												<td class="text-center">
													<button ng-click="addinnercntrDtl(blcntrDtl)"
														class="btn btn-info" tooltip="Add Row" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</td>

											</tr>
											<tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light">
														<tr>
															<th class="width_2 text-center subTable-brs">Charge
																Code</th>
															<th class="width_2 text-center subTable-brs">Currency</th>
															<th class="width_2 text-center subTable-brs">Rate</th>
															<!-- 												<th class="width_6 text-center subTable-brs">MEA Rate</th>
 -->
															<!-- <th class="width_6 text-center subTable-brs">WG Rate</th>
												<th class="width_8 text-center subTable-brs">From Place</th>
												<th class="width_8 text-center subTable-brs">To Place</th>
												<th class="width_6 text-center subTable-brs">Min Rate</th> -->
															<th class="width_2 text-center subTable-brs">Terms</th>
															<!-- 												<th class="width_6 text-center subTable-brs">Real Amount</th>
 -->
															<th class="width_2 text-center subTable-brs">Action</th>
														</tr>
														<tr
															ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeList track by bTrIndex">
															<td class="subTable-brs text-center"><selectivity
																	list="surchargeList"
																	property="blcntrinnerDtl.chargeCode" id="chargeCode"
																	ng-model="blcntrinnerDtl.chargeCode" name="chargeCode"></td>
															<td class="subTable-brs text-center"><selectivity
																	list="currencyList" property="blcntrinnerDtl.currency"
																	id="currency" ng-model="blcntrinnerDtl.currency"
																	name="currency" disabled="true"/></td>
															<td class="subTable-brs"><input class="form-control"
																type="text" name="unitRate" id="unitRate"
																ng-model="blcntrinnerDtl.unitRate" placeholder=" Rate" ng-disabled="true"></td>
															<!-- <td class="subTable-brs"><input class="form-control" type="text" name="meaRate" id="meaRate" ng-model="blcntrinnerDtl.meaRate"  placeholder="MEA Rate"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="wgRate" id="wgRate" ng-model="blcntrinnerDtl.wgRate"  placeholder="WG Rate"></td>
												<td class="subTable-brs">  <selectivity list="portlist" property="blcntrinnerDtl.fromPlace" id="fromPlace" ng-model="blcntrinnerDtl.fromPlace"
               name="fromPlace" form-name="blForm" 
                friendly-name="From Place"> </td>
												<td class="subTable-brs"><selectivity list="portlist" property="blcntrinnerDtl.toPlace" id="toPlace" ng-model="blcntrinnerDtl.toPlace"
               name="toPlace" form-name="blForm" 
                friendly-name="To Place"> </td>
												<td class="subTable-brs"><input class="form-control" type="text" name="minRate" id="minRate" ng-model="blcntrinnerDtl.minRate"  placeholder="Min Rate"></td> -->
															<td class="subTable-brs"><selectivity
																	list="termsOfPayment" property="blcntrinnerDtl.terms"
																	id="terms" ng-model="blcntrinnerDtl.terms" name="terms"
																	form-name="blForm" friendly-name="Terms Of Payment" disabled="true"></selectivity></td>
															<!-- 												<td class="subTable-brs"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blcntrinnerDtl.realAmount"  placeholder="Real Amount"></td>
 -->
															<td class="subTable-brs"><button
																	ng-click="deleteinnercntrDtl(blcntrDtl,bTrIndex)"
																	class="btn btn-sm btn-danger" type="button"
																	tooltip="Delete">
																	<i class="fa  fa-trash-o"></i>
																</button></td>
														</tr>
													</table>
												</td>

											</tr>
										</tbody>
									</table>
								<!-- 	<button type="button" class="btn btn-sm btn-success "
										ng-click="addcntrDtl()">
										<i class="fa fa-plus"></i>
									</button> -->
																							       	
									<div class="padding-right-5">										
									<div class="col-md-4"></div>
									</div>


								</div>
								<br>



							</div>
						</div>
					</div>
					</tab> <tab heading="Goods" style="background:#5F9EA0		">
					<div class="panel-body">

						<div class="row">
							<div class="col-md-12">
								<label class="control-label">Main Commodity</label> <input
									class="form-control" type="text" name="maincom" id="maincom"
									ng-model="blNoData.maincom" placeholder="Main Commodity" ng-disabled="true">

							</div>
							<div class="col-md-2">
								<label class="control-label">NO OF PKGS</label> <input
									class="form-control" type="text" name="pkgs" id="pkgs"
									ng-model="blNoData.pkgs" placeholder="PKGS"
									validation="numeric" ng-disabled="true">

							</div>

							<div class="col-md-3">
								<label class="control-label">N.WGT</label> <input
									class="form-control" type="text" name="n_wgt" id="n_wgt"
									ng-model="blNoData.n_wgt" placeholder="N.WGT"
									validation="numeric" ng-disabled="true">

							</div>

							<!-- <div class="col-md-2">
								<label class="control-label">T.WGT</label> <input
									class="form-control" type="text" name="t_wgt" id="t_wgt"
									ng-model="blNoData.t_wgt" placeholder="T.WGT"
									validation="numeric">

							</div> -->

							<div class="col-md-3">
								<label class="control-label">G.WGT</label> <input
									class="form-control" type="text" name="g_wgt" id="g_wgt"
									ng-model="blNoData.g_wgt" placeholder="G.WGT"
									validation="numeric" ng-disabled="true">

							</div>


							<div class="col-md-2">
								<label class="control-label">CBM</label> <input
									class="form-control" type="text" name="cbm" id="cbm"
									ng-model="blNoData.cbm" placeholder="CBM" validation="numeric" ng-disabled="true">

							</div>

							<div class="col-md-6">
								<label class="control-label">Goods</label>
								<textarea class="form-control" type="text" name="goods"
									id="goods" ng-model="blNoData.goods" placeholder="Goods" ng-disabled="true">
                      </textarea>

							</div>

							<div class="col-md-6">
								<label class="control-label">Marks</label>
								<textarea class="form-control" type="text" name="marks"
									id="marks" ng-model="blNoData.marks" placeholder="Marks" ng-disabled="true">
                      </textarea>

							</div>
						</div>
						<br>

					</div>
					</tab> <!-- <tab heading="Package" style="background:#5F9EA0">
 <div class="col-md-12">
	 <div class="table-responsive ">
	<div class="panel-body" style="width: 220%;">
		 
			<div class="row" id="items">
			
			 <div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_2">select</th>
									<th colspan=1 class="width_6 text-center">Cntr No<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Type<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Seal No<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> TW<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> GW<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> CB<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Net<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> FLE<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> SOC<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Package<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> No of Packages<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Goods<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">is OOG</th>
									<th colspan=1 class="width_6 text-center">Marks</th>
									<th colspan=1 class="width_6 text-center">POL Term<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">Action</th>

								</tr>
							</thead>
							<tbody ng-repeat="(trIndex1, blpckDtl) in blNoData.blpckDtlList">
								<tr>
<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="blpckDtl.select"><i></i></label></td>
					 <td class="text-center">
					 <selectivity list="containerList" property="blpckDtl.cntrNo" id="cntrNo" ng-model="blpckDtl.cntrNo"
               name="cntrNo" form-name="blForm" validation="required"  
                friendly-name="Cntr No"></selectivity>
                 <selectivity list="containerList" property="blpckDtl.cntrNo" id="cntrNo" ng-model="blpckDtl.cntrNo"
               name="cntrNo" form-name="blForm" validation="required"  
                friendly-name="Cntr No"></selectivity>
                	</td>
                 <td class="text-center">
    <selectivity list="containerTypeList" property="blpckDtl.type" id="type" ng-model="blpckDtl.type"
               name="type"  form-name="blForm" validation="required"   
                friendly-name="Container Type"></selectivity>	</td>
 									<td class="text-center"><input class="form-control" type="text" name="sealNo" id="sealNo" ng-model="blpckDtl.sealNo"  form-name="blForm" validation="required" friendly-name="Seal No" placeholder="Seal No"></td>
									<td class="text-center"><input class="form-control" type="text" name="tw" id="tw" ng-model="blpckDtl.tw"  form-name="blForm" validation="required|numeric" friendly-name="TW" placeholder="TW"></td>
									<td class="text-center"><input class="form-control" type="text" name="gw" id="gw" ng-model="blpckDtl.gw"  form-name="blForm" validation="required|numeric" friendly-name="GW" placeholder="GW"></td>
									<td class="text-center"><input class="form-control" type="text" name="cb" id="cb" ng-model="blpckDtl.cb" form-name="blForm" validation="required|numeric" friendly-name="CB" placeholder="CB"></td>
									<td class="text-center"><input class="form-control" type="text" name="net" id="net" ng-model="blpckDtl.net"  form-name="blForm" validation="required|numeric" friendly-name="NET" placeholder="NET"></td>
									<td class="text-center"> <selectivity list="fleList" property="blpckDtl.fle" id="fle" ng-model="blpckDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity></td>
									<td class="text-center">
									 <selectivity list="socList" property="blpckDtl.so" id="SOC" ng-model="blpckDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td>
										 <td class="text-center">
    <selectivity list="packageList" property="blpckDtl.packageType" form-name="blForm" id="packageType" ng-model="blpckDtl.packageType"
               name="packageType"  
                friendly-name="Package Type"></selectivity>	</td>
 									<td class="text-center"><input class="form-control" type="text" name="no" id="no" ng-model="blpckDtl.noOfPckgs"  form-name="blForm" validation="required" friendly-name="No of Package"    placeholder="NO"></td>
									<td class="text-center"><input class="form-control" type="text" name="g" id="g" ng-model="blpckDtl.goods"   validation="required"></td>
									<td class="text-center"> <input type="checkbox" name="iso" id="iso" ng-model="blpckDtl.iso"><i></i> </td>
									<td class="text-center"><input class="form-control" type="text" name="mar" id="mar" ng-model="blpckDtl.marks"  placeholder="MARKS"></td>
								<td class="text-center">
    <selectivity list="termsOfPayment" property="blpckDtl.polTer" id="polTer" ng-model="blpckDtl.polTer"
               name="polTer"  form-name="blForm" validation="required" friendly-name="Pol Term"    ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blpckDtl.podTer" id="podTer" ng-model="blpckDtl.podTer"
               name="podTer"  form-name="blForm"  validation="required" friendly-name="Pod Term"   ></selectivity>	</td>
<td>
									<button ng-click="addinnerpckDtl(blpckDtl)" class="btn btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button></i> </td>					
									
								</tr>
								<tr  >
									<td></td>
									<td colspan="15">
										<table class="table table-striped b-t b-light">
											<tr>
												<th class="width_2 text-center subTable-brs"> HSCode<span style="color: red;">*</span></th>
												<th class="width_8 text-center subTable-brs"> Package Type<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs"> No of Packages<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs"> GW<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs">Goods</th>
												<th class="width_3 text-center subTable-brs">Action</th>
											</tr>
											<tr ng-repeat="($index, blpckinnerDtl) in blpckDtl.packageList track by $index">
												 
												<td class="subTable-brs text-center"><input class="form-control" type="text" name="hsCode" id="hsCode" ng-model="blpckinnerDtl.hsCode"  form-name="blForm" validation="required" friendly-name="HSCode"   placeholder="HSCode"></td>
												<td class="subTable-brs text-center">
    <selectivity list="packageList" property="blpckinnerDtl.packageType" id="packageType" ng-model="blpckinnerDtl.packageType"  name="packageType"     form-name="blForm" validation="required"  friendly-name="Package Type"></selectivity>	</td>
                
 												<td class="subTable-brs"><input class="form-control" type="text" name="noofPcks" id="noofPcks" ng-model="blpckinnerDtl.noofPcks" form-name="blForm" validation="required" friendly-name="No of Packages"    placeholder="No of Packages"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="gw_" id="gw_" ng-model="blpckinnerDtl.gw_"  form-name="blForm" validation="required" friendly-name="GW"   placeholder="GW"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="goods" id="goods" ng-model="blpckinnerDtl.goods"  placeholder="Goods"></td>
									
										<td class="subTable-brs"><button ng-click="deleteinnerpckDtl(blpckDtl,$index)"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button></td>
											</tr>
										</table>
									</td>
									
								</tr>
							</tbody>
						</table>
				  <button type="button" class="btn btn-sm btn-success" ng-click="addpckDtl()"><i class="fa fa-plus"></i></button>
									  <button type="button" class="btn btn-sm btn-danger" ng-click="removepckDtl(blNoData.blpckDtlList)"><i class="fa fa-minus"></i></button>
						
						<div class="padding-right-5">
							<div class="col-md-4">
								
								
							</div>
						</div>
					</div>
			
			</div>
			<br>
			 
	 
	</div>
	</div>
	</div>
	</tab>  --> </tabset>
					<br>
				</div>

			</div>
			<br> <br>
			<div align="center">
				<div ng-if="!isEdit">
					<button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
				</div>
				<div ng-if="isEdit">
					<button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
				</div>
				<br>
			</div>

		</form>
	</div>
	</div>
</body>
</html>

<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile1(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
 <button class="btn btn-info" type="button" ng-click="exportSampleExcel()">Download Sample</button>
   <button class="btn btn-info" type="button" ng-click="uploadFile()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	<div id="btnRowDivIdsamp"> </div>
	</div>
  </div>
 </script>