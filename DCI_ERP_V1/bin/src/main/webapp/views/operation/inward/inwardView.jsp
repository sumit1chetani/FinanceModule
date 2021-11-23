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
					<!--    <div class="col-md-6">
          <label class="control-label">B/L No  <span style="color: red;">*</span></label>
             <div>
                <input class="form-control" type="text" placeholder="B/L No"  class="form-control" id="blNo"  
                ng-model="blNoData.blNo" name="blNo" form-name="blForm" validation="required"  friendly-name="B/L No" > </div>
              </div> -->


					<div class="col-md-4">
						<label class="control-label" style="font-weight: bold;">ShipmentOrder No :</label> {{blDetailList.jobNo}}
						<!-- <div>
						
							<selectivity list="jobList" property="blNoData.jobNo" id="jobNo"
								ng-model="blNoData.jobNo" name="jobNo" form-name="blForm"
								validation="required" friendly-name="Job No"></selectivity>
						</div> -->


					</div>
					
				<!-- 	<div class="col-md-5"  ng-if="isEdit">
						<label class="col-md-5  control-label">OBL Print Issue Date:</label>
						<div class="col-md-4">
					<label class="col-md-5 control-label">	{{blNoData.OBLPrintDate}}</label>
							</div>
					</div> -->
					
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
						<!-- 		<input class="form-control"
								type="text" placeholder="" class="form-control" id="issuePlace"
								friendly-name="issuePlace" ng-model="blNoData.issuePlace" name="issuePlace"
								form-name="blForm"> -->
						<!-- 	<selectivity list="polList" property="blNoData.issuePlace"
								id="issuePlace" ng-model="blNoData.issuePlace" name="issuePlace"
								form-name="blForm" validation="required"
								friendly-name="Issue Place"></selectivity> -->
							<!--  
                  <selectivity list="issuePlaceList" property="blNoData.issuePlace" id="issuePlace" ng-model="blNoData.issuePlace"
               name="issuePlace" form-name="blForm" validation="required" 
                friendly-name="Issue Place"></selectivity> -->
						</div>


						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Date of Issue :</label> {{blDetailList.issueDate}}
							<!-- <ng-bs3-datepicker data-ng-model="blNoData.issueDate"
								name="issueDate" form-name="blForm" validation="required"
								friendly-name="Issue Date" validation="required" /> -->
						</div>

						<!-- <div class="col-md-4">
              <label class="control-label">On Board</label>
              <ng-bs3-datepicker data-ng-model="blNoData.onBoard"
											name="onBoard" form-name="blForm" 
										   />
</div> -->
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Vsl.Voyage :</label> {{blDetailList.vslVoyage}}
							<!-- <selectivity list="vesselVoyageList"
								property="blNoData.vslVoyage" id="vslVoyage"
								ng-model="blNoData.vslVoyage" name="mVoyage" form-name="blForm"
								validation="required" friendly-name="Vsl.Voyage" disabled="true"></selectivity> -->
						</div>
					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">



						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Receipt at :</label> {{blDetailList.receiptAt}}
							<!--    <selectivity list="issuePlaceList" property="blNoData.receiptAt" id="receiptAt" ng-model="blNoData.receiptAt"
               name="receiptAt"  form-name="blForm" validation="required" 
                friendly-name="Receipt at"></selectivity> -->
							<!-- selectivity list="polList" property="blNoData.receiptAt"
								id="receiptAt" ng-model="blNoData.receiptAt" name="receiptAt"
								form-name="blForm" validation="required"
								friendly-name="Receipt at "></selectivity> -->


						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.L :</label> {{blDetailList.pol}}
							<!-- <selectivity list="polList" property="blNoData.pol" id="pol"
								ng-model="blNoData.pol" name="pol" form-name="blForm"
								validation="required" friendly-name="POL" disabled="true"></selectivity>
 -->
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.D / POT :</label> {{blDetailList.pod}}
							<!-- <selectivity list="portlist" property="blNoData.pod" id="pod"
								ng-model="blNoData.pod" name="pod" form-name="blForm"
								validation="required" friendly-name="POD" disabled="true"></selectivity> -->
						</div>

					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">


						<!--  <div class="col-md-4">
                <label class="control-label">P.O.T  <span style="color: red;"></span></label>
               <selectivity list="portlist" property="blNoData.pot" id="pot" ng-model="blNoData.pot"
               name="pot" form-name="blForm" 
                friendly-name="POT"></selectivity>                            </div> -->

               <div class="col-md-4">
                <label class="control-label" style="font-weight: bold;">F.P.O.D :</label> {{blDetailList.fpod}}
              <!-- <selectivity list="portlist" property="blNoData.fpod" id="fpod" ng-model="blNoData.fpod"
               name="fpod" form-name="blForm"  
                friendly-name="FPOD" disabled="true"></selectivity>  -->    
              </div> 
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Shipment Terms :</label> {{blDetailList.terms}}
							<!-- <selectivity list="termsOfPayment" property="blNoData.terms"
								id="terms" ng-model="blNoData.terms" name="terms"
								form-name="blForm" validation="required"
								friendly-name="Terms Of Payment"></selectivity> -->

						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">No.Bls :</label> {{blDetailList.noBls}} <!-- <input type="number"
								placeholder="No.Bls" class="form-control" id="noBls"
								friendly-name="No.Bls" ng-model="blNoData.noBls" name="noBls"
								form-name="blForm" validation="required"> -->
						</div>
						
					</div>
					<br>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display Vessel :</label> {{blDetailList.disvessel}} <!-- <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvessel"
								friendly-name="disvessel" ng-model="blNoData.disvessel" name="disvessel"
								form-name="blForm"> -->
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display Voyage :</label> {{blDetailList.disvoyage}} <!-- <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvoyage"
								friendly-name="disvoyage" ng-model="blNoData.disvoyage" name="disvoyage"
								form-name="blForm"> -->
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display P.O.R :</label> {{blDetailList.disPor}} <!-- <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPor"
								friendly-name="disPor" ng-model="blNoData.disPor" name="disPor"
								form-name="blForm"> -->
						</div>
						</div><br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display P.O.L :</label> {{blDetailList.disPol}}<!--  <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPol"
								friendly-name="disPol" ng-model="blNoData.disPol" name="disPol"
								form-name="blForm"> -->
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display P.O.D :</label>{{blDetailList.disPod}}<!--  <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPod"
								friendly-name="disPod" ng-model="blNoData.disPod" name="disPod"
								form-name="blForm"> -->
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Display F.P.O.D :</label> {{blDetailList.disFpod}} <!-- <input class="form-control"
								type="text" placeholder="" class="form-control" id="disFpod"
								friendly-name="disFpod" ng-model="blNoData.disFpod" name="disFpod"
								form-name="blForm"> -->
						</div>
						</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<div class="col-md-4" ng-if="!isEdit">
							<label class="control-label" style="font-weight: bold;">Customer :</label> {{blDetailList.client}}
							<!-- <selectivity list="customerList" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity> -->
						</div>
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label" style="font-weight: bold;">Customer :</label> {{blDetailList.client}}
						<!-- 	<selectivity list="customerList1" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity> -->
						</div>
						<!--  <div class="col-md-4">
                <label class="control-label">Payer  <span style="color: red;"></span></label>
                   <selectivity list="payerList" property="blNoData.payer" id="payer" ng-model="blNoData.payer"
               name="payer"    form-name="blForm"   ></selectivity>   
              </div> -->
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">On Board :</label> {{blDetailList.onBoard}}
							<!-- <ng-bs3-datepicker data-ng-model="blNoData.onBoard" id="onBoard"
								friendly-name="On Board"  name="onBoard" disabled ="true"
								form-name="blForm" /> -->
						</div>

						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Remarks :</label> {{blDetailList.remarks}} <!-- <input
								class="form-control" type="text" placeholder="Remarks"
								class="form-control" id="remarks" ng-model="blNoData.remarks"
								name="remarks"> -->
						</div>
					</div>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">REF :</label> {{blDetailList.ref}}<!--  <input class="form-control"
								type="text" placeholder="REF" class="form-control" id="ref"
								friendly-name="Ref" ng-model="blNoData.ref" name="ref"
								form-name="blForm"> -->
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Other Bl No  :</label> {{blDetailList.otherblno}} <!-- <input class="form-control"
								type="text" class="form-control" id="otherblno"
								 ng-model="blNoData.otherblno" name="otherblno"
								form-name="blForm"> -->
						</div>
						
						<div class="col-md-4" style="padding-top: 27px;">
								 <label
								  class="i-checks m-b-none" style="padding-left: 12px;">Multi Model
									<input type="checkbox" id="multimodel" name ="multimodel" ng-model="blDetailList.multimodel" form-name="blForm" disabled><i style="margin-left: 20px;"></i>
							</label> 
							
							<label
								  class="i-checks m-b-none" style="padding-left: 12px;">RFS
									<input type="checkbox" id="multimodel" name ="multimodel" ng-model="blDetailList.rfs" form-name="blForm" disabled><i style="margin-left: 20px;"></i>
							</label>  
							
							<label
								  class="i-checks m-b-none"  style="padding-left: 8px;">Detention Tariff
									<input type="checkbox" id="detentionTariff" name ="detentionTariff" ng-model="blDetailList.detentionTariff" form-name="blForm" disabled><i style="margin-left: 20px;"></i>
							</label>  
						</div>
						
						
						
						<!-- <div class="col-md-4" style="padding-top: 30px;">
								 <label
								  class="i-checks m-b-none">BL Release
									<input type="checkbox" id="blrelease" name ="blrelease" ng-model="blNoData.blrelease" form-name="blForm"><i style="margin-left: 20px;"></i>
							</label>  
						</div>
						
						</div>
						
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						<div class="col-md-4">
							<label class="control-label">BL Release Remarks  </label>
									<textarea class="form-control" type="text" name="blreleaseremeraks" ng-disabled="blNoData.blrelease ===false "
											id="blreleaseremeraks" ng-model="blNoData.blreleaseremeraks" ></textarea>
						</div>
						</div>	
						
					<br> -->
					<!--   <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
    
</div>
 <br> -->
					<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
            <div class="col-md-4">
                <label class="control-label">M.Voyage</label>
                 <selectivity list="vesselVoyageList" property="blNoData.mVoyage" id="mVoyage" ng-model="blNoData.mVoyage"
               name="mVoyage" form-name="blForm" 
                 ></selectivity> 
               
                </div>
              
             
              <div class="col-md-4">
                  <label class="control-label">Load Type  <span style="color: red;">*</span></label>  
                  
                  <selectivity list="load" property="blNoData.loadType" id="loadType" ng-model="blNoData.loadType"
               name="loadType"friendly-name="Load Type"
                form-name="blForm" validation="required" ></selectivity>
        
                </div>
<div class="col-md-4">
                  <label class="control-label">Shipment Type  <span style="color: red;">*</span></label> 
                   <selectivity list="serviceList" property="blNoData.service" id="service" ng-model="blNoData.service"
               name="service"  friendly-name="Shipment Type"
                form-name="blForm" validation="required" ></selectivity>
                
               
 </div>
 
</div> -->
					<!-- 
 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

  
          <div class="col-md-4">
                  <label class="control-label">Agent</label>
                <selectivity list="agentList" property="blNoData.agent" id="agent" ng-model="blNoData.agent"
               name="agent" form-name="blForm" 
                friendly-name="Load Type"></selectivity>        
                  
              </div>
 </div>
             <br> -->
					<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 2%;">
             
             

           <div class="col-md-4">
                <label class="control-label">Shipment  <span style="color: red;">*</span></label>
                   <selectivity list="shipmentList" property="blNoData.shipment" id="shipment" ng-model="blNoData.shipment"
               name="shipment"    form-name="blForm" validation="required" friendly-name="Shipment"></selectivity>   
              </div>
               
             <div class="col-md-4">
                <label class="control-label">Status</label>
                <selectivity list="statusList" property="blNoData.status" id="status" ng-model="blNoData.status"
               name="status" form-name="blForm" 
                friendly-name="Staus"></selectivity>
                  </div>
                  <div class="col-md-4">
                      <label class="control-label" style="margin-top: 8%;">Released</label>                 
                    <input  type="checkbox" id="released"  ng-model="blNoData.released" name="released">       
       </div>
             </div> -->
					<br>

					<!--  <div class="col-md-12" style="margin-top: 1%; margin-bottom: 2%;">
             

          
               
                   
             </div> -->


				</div>
				
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
				<div class="col-md-4" >
							<label class="control-label" style="font-weight: bold;">Destination Agent :</label> {{blDetailList.deliveryAgent}}
							<!-- <selectivity list="vendorList" property="blNoData.deliveryAgent"
								id="deliveryAgent" ng-model="blNoData.deliveryAgent" name="deliveryAgent"
								friendly-name="deliveryAgent" form-name="blForm" validation="required"></selectivity> -->
						</div>
						 <div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.D.1 :</label> {{blDetailList.pod1}}
							<!-- <selectivity list="portlist" property="blNoData.pod1" id="pod1"
								ng-model="blNoData.pod1" name="pod1" form-name="blForm"
								friendly-name="POD1" disabled="true"></selectivity> -->
						</div>
						
						<div class="col-md-4" style="padding-top: 27px;" ng-if ="isEdit">
								 <label
								  class="i-checks m-b-none" style="padding-left: 12px;">Retain OnBoard
									<input type="checkbox" id="rob" name ="rob" ng-model="blNoData.rob" form-name="blForm" ng-disabled="true"><i style="margin-left: 20px;"></i>
							</label> 
							
						 
						</div>
						

						</div>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">P.O.D.2 :</label> {{blDetailList.pod2}}
							<!-- <selectivity list="portlist" property="blNoData.pod2" id="pod2"
								ng-model="blNoData.pod2" name="pod1" form-name="blForm"
								friendly-name="POD2" disabled="true"></selectivity> -->
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Country of Origin of goods :</label> {{blDetailList.orginOfGoods}} 
							
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Freight Payable at :</label> {{blDetailList.freightAt}}
							
						</div>
						
						
						</div>
						
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Freight Payable by :</label> {{blDetailList.freightBy}}
							
						</div>
						
						<!-- <div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">SOB Type :</label> {{blDetailList.sobType}}
							
						</div> -->
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Bill Type :</label> {{blDetailList.billtype}}
							
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">UOM :</label> {{blDetailList.gw_unit}}
							
						</div>
						
						</div>
						
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Notify Telephone No :</label> {{blDetailList.consigTel}} 
							
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Notify Email :</label> {{blDetailList.consigEmail}}
							
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
									<!-- 	 <div class="col-md-12">
              <label class="control-label">Messers</label>
              <input class="form-control" type="text"  name="messers" id="messers" ng-model="blNoData.messers" placeholder="Messers">

            </div> -->

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Shippers :</label> {{blDetailList.shipperId}}

										<!-- <selectivity list="customerList" property="blNoData.shipperId"
											id="shipperId" ng-model="blNoData.shipperId" name="shipperId"
											form-name="blForm" validation="required" friendly-name="Shippers"></selectivity> -->
									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Cnee :</label> {{blDetailList.cnee}}
										<!-- <selectivity list="customerList" property="blNoData.cneeId"
											id="cneeId" ng-model="blNoData.cneeId" name="cneeId"
											form-name="blForm" validation="required" friendly-name="Cnee"></selectivity> -->

									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Shippers Dtls :</label> 
										<label class="control-label" ng-bind-html="blDetailList.shipper"></label>
										<!-- <textarea class="form-control" type="text" name="shipper"
											id="shipper" ng-model="blNoData.shipper"
											placeholder="Shippers">
                            </textarea> -->

									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Cnee Dtls :</label> {{blDetailList.cneeId}}
										<!-- <textarea class="form-control" type="text" name="cnee"
											id="cnee" ng-model="blNoData.cnee" placeholder="Cnee">
                            </textarea> -->

									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify1 :</label> {{blDetailList.notify1Id}}
										<!-- <selectivity list="customerList" property="blNoData.notify1Id"
											id="notify1Id" ng-model="blNoData.notify1Id" name="notify1Id"
											form-name="blForm"></selectivity>
 -->
									</div>
									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify2 :</label> {{blDetailList.notify2Id}}
									<!-- 	<selectivity list="customerList" property="blNoData.notify2Id"
											id="notify2Id" ng-model="blNoData.notify2Id" name="notify2Id"
											form-name="blForm"></selectivity> -->
									</div>

									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify1 Dtls :</label> {{blDetailList.notify1}}
									<!-- 	<textarea class="form-control" type="text" name="notify1"
											id="notify1" ng-model="blNoData.notify1"
											placeholder="Notify1">
                            </textarea> -->

									</div>
									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Notify2 Dtls :</label> {{blDetailList.notify2}}
										<!-- <textarea class="form-control" type="text" name="notify2"
											id="notify2" ng-model="blNoData.notify2"
											placeholder="Notify2">
                            </textarea> -->

									</div>
									<div class="col-md-6">
										<label class="control-label" style="font-weight: bold;">Forwarder :</label> {{blDetailList.forwarderId}}
										<!-- <selectivity list="customerList"
											property="blNoData.forwarderId" id="forwarderId"
											ng-model="blNoData.forwarderId" name="forwarderId"
											form-name="blForm"></selectivity> -->

									</div>

									<div class="col-md-6"> 
										<label class="control-label" style="font-weight: bold;">Forwarder Dtls :</label> {{blDetailList.forwarder}}
										<!-- <textarea class="form-control" type="text" name="forwarder"
											id="forwarder" ng-model="blNoData.forwarder"
											placeholder="Forwarder">
                           	 			</textarea> -->
									</div>
								</fieldset>
							</div>

						</div>
						<br>

						<!--  </div>
	</div>
	</div> -->
					</div>
					</tab> <tab heading="Goods" style="background:#5F9EA0">
					<div class="panel-body">

						<div class="row">
							<div class="col-md-12">
								<label class="control-label" style="font-weight: bold;">Main Commodity :</label> {{blDetailList.maincom}} <!-- <input
									class="form-control" type="text" name="maincom" id="maincom"
									ng-model="blNoData.maincom" placeholder="Main Com"> -->

							</div>

							<!--  <div class="col-md-2">
              <label class="control-label">T.WGT</label>
              <input class="form-control" type="text" name="t_wgt" id="t_wgt" ng-model="blNoData.t_wgt"  placeholder="T.WGT" validation="numeric">

            </div> -->

							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">NO OF PKGS :</label> {{blDetailList.pkgs}} <!-- <input
									class="form-control" type="text" name="pkgs" id="pkgs"
									ng-model="blNoData.pkgs" placeholder="PKGS"
									validation="numeric"> -->

							</div>

							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">N.WGT :</label> {{blDetailList.n_wgt}} <!-- <input
									class="form-control" type="text" name="n_wgt" id="n_wgt"
									ng-model="blNoData.n_wgt" placeholder="N.WGT"
									validation="numeric"> -->
					   
							</div>
							
                              <div class="col-md-6" >
							<label
								  class="i-checks m-b-none" style="font-weight: bold; padding-left: 20px;!important">Print N.WGT  
									<input type="checkbox" id="checkNetWgt" name ="checkNetWgt" ng-model="blDetailList.checkNetWgt" form-name="blForm" disabled ><i style="margin-left: 20px;"></i>
							</label>  
						</div>
							
							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">G.WGT :</label> {{blDetailList.g_wgt}}<!-- <input
									class="form-control" type="text" name="g_wgt" id="g_wgt"
									ng-model="blNoData.g_wgt" placeholder="G.WGT"
									validation="numeric"> -->

							</div> 


							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">CBM :</label> {{blDetailList.cbm}}<!-- <input
									class="form-control" type="text" name="cbm" id="cbm"
									ng-model="blNoData.cbm" placeholder="CBM" validation="numeric"> -->

							</div>



							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">Goods :</label> {{blDetailList.goods}}
								<!-- <textarea class="form-control" type="text" name="goods"
									id="goods" ng-model="blNoData.goods" placeholder="Goods">
                      </textarea> -->

							</div>

							<div class="col-md-6">
								<label class="control-label" style="font-weight: bold;">Marks :</label> {{blDetailList.marks}}
								<!-- <textarea class="form-control" type="text" name="marks"
									id="marks" ng-model="blNoData.marks" placeholder="Marks">
                      </textarea> -->

							</div>
						</div>
						<br>

					</div>
					</tab> <!-- <tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 166%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_2">select</th>
												<th colspan=1 class="width_9 text-center">Cntr No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">Type <span
													style="color: red;">*</span></th>
													<th colspan=1 class="width_3 text-center">SOC <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">Seal No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_7 text-center">NW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">GW (KG)<span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_6 text-center">CBM <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">Check Digit <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">Net <span style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">FLE <span style="color: red;"></span></th>
									<th colspan=1 class="width_6 text-center">SOC <span style="color: red;"></span></th>
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
												<th colspan=1 class="width_8 text-center">IMCO Charge</th>
												<th colspan=1 class="width_6 text-center">POL Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;">*</span></th>
												<th colspan=1 class="width_4 text-center">Action</th>

											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList">
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
												<td class="text-center"><selectivity
														list="containerList" property="blcntrDtl.cntrNo"
														id="cntrNo{{trIndex}}" ng-model="blcntrDtl.cntrNo"
														name="cntrNo{{trIndex}}" form-name="blForm"
														validation="required"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container No)'}}" disabled="true"></selectivity>
																	
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No"></selectivity>
												</td>
												<td class="text-center"><selectivity
														list="containerTypeList" property="blcntrDtl.type"
														id="type{{trIndex}}" name="type{{trIndex}}"
														ng-model="blcntrDtl.type" validation="required"
														validation="required" form-name="blForm"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container Type)'}}"></selectivity>
												</td>
												<td class="text-center">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="blcntrDtl.soc" disabled="true"><i></i></label>
												</td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(Seal No)'}}"
													name="sealNo{{trIndex}}" id="sealNo{{trIndex}}"
													ng-model="blcntrDtl.sealNo" placeholder="Seal No"></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="tw"
													name="tw{{trIndex}}" id="tw{{trIndex}}"
													ng-model="blcntrDtl.tw"></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(GW)'}}"
													name="gw{{trIndex}}" id="gw{{trIndex}}"
													ng-model="blcntrDtl.gw"></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="cb"
													name="cb{{trIndex}}" id="cb{{trIndex}}"
													ng-model="blcntrDtl.cb"></td>
												<td class="text-center"><input class="form-control"
													type="text" name="checkdigit" form-name="blForm"
													id="checkdigit{{trIndex}}" ng-model="blcntrDtl.checkdigit"></td>
												<td class="text-center"><input class="form-control" type="text" name="net" form-name="blForm"    id="net{{trIndex}}" ng-model="blcntrDtl.net"  ></td>
									 <td class="text-center">
									 <selectivity list="fleList" property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity>
									 </td>
									<td class="text-center">
									   <selectivity list="socList" property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td>
												<td class="text-center"><selectivity list="packageList"
														property="blcntrDtl.packageType"
														id="packageType{{trIndex}}"
														ng-model="blcntrDtl.packageType" name="packageType"
														form-name="blForm" friendly-name="Package Type"
														friendly-name="Package Type"></selectivity></td>
												<td class="text-center"><input class="form-control"
													type="text" name="noo{{trIndex}}" id="noo{{trIndex}}"
													ng-model="blcntrDtl.noOfPckgs" validation="required"
													form-name="blForm"
													friendly-name="{{ 'Row' + (trIndex+1) + '(No Of Package)'}}"
													placeholder="NoO"></td>
												<td class="text-center"><input class="form-control"
													type="text" name="g{{trIndex}}" id="g{{trIndex}}"
													ng-model="blcntrDtl.goods"></td>
												<td class="text-center"><input type="checkbox"
													name="iso" id="iso{{trIndex}}" ng-model="blcntrDtl.iso" disabled="true"><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="hazardous" id="hazardous{{trIndex}}" ng-model="blcntrDtl.hazardous" disabled="true"><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="ows" id="ows{{trIndex}}" ng-model="blcntrDtl.ows" disabled="true"><i></i>
												</td>
												<td class="text-center"><input class="form-control"
													type="text" name="mar{{trIndex}}" id="mar{{trIndex}}"
													ng-model="blcntrDtl.marks" placeholder="MARKS"></td>
													<td class="text-center"><input class="form-control"
													type="text" name="unCode" id="unCode" ng-model="blcntrDtl.unCode"
													placeholder="UN CODE"></td>
													
													<td class="text-center"><input class="form-control"
													type="text" name="imcoCharge" id="imcoCharge" ng-model="blcntrDtl.imcoCharge"
													placeholder="IMCO"></td>
												<td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.polTer" id="polTer" ng-model="blcntrDtl.polTer"
          form-name="blForm" validation="required" friendly-name="POL Term"     name="polTer"   ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.podTer" id="podTer" ng-model="blcntrDtl.podTer"
         form-name="blForm" validation="required" friendly-name="POD Term"      name="podTer"   ></selectivity>	</td>
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
																											<th class="width_6 text-center subTable-brs">MEA Rate</th>

															<th class="width_6 text-center subTable-brs">WG Rate</th>
												<th class="width_8 text-center subTable-brs">From Place</th>
												<th class="width_8 text-center subTable-brs">To Place</th>
												<th class="width_6 text-center subTable-brs">Min Rate</th>
															<th class="width_2 text-center subTable-brs">Terms</th>
																											<th class="width_6 text-center subTable-brs">Real Amount</th>

															<th class="width_2 text-center subTable-brs">Action</th>
														</tr>
														<tr
															ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeList track by bTrIndex">
															<td class="subTable-brs text-center"><selectivity
																	list="CntrsurchargeList"
																	property="blcntrinnerDtl.chargeCode" id="chargeCode"
																	ng-model="blcntrinnerDtl.chargeCode" name="chargeCode"></td>
															<td class="subTable-brs text-center"><selectivity
																	list="currencyList" property="blcntrinnerDtl.currency"
																	id="currency" ng-model="blcntrinnerDtl.currency"
																	name="currency"></td>
															<td class="subTable-brs"><input class="form-control"
																type="text" name="unitRate" id="unitRate"
																ng-model="blcntrinnerDtl.unitRate" placeholder=" Rate"></td>
															<td class="subTable-brs"><input class="form-control" type="text" name="meaRate" id="meaRate" ng-model="blcntrinnerDtl.meaRate"  placeholder="MEA Rate"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="wgRate" id="wgRate" ng-model="blcntrinnerDtl.wgRate"  placeholder="WG Rate"></td>
												<td class="subTable-brs">  <selectivity list="portlist" property="blcntrinnerDtl.fromPlace" id="fromPlace" ng-model="blcntrinnerDtl.fromPlace"
               name="fromPlace" form-name="blForm" 
                friendly-name="From Place"> </td>
												<td class="subTable-brs"><selectivity list="portlist" property="blcntrinnerDtl.toPlace" id="toPlace" ng-model="blcntrinnerDtl.toPlace"
               name="toPlace" form-name="blForm" 
                friendly-name="To Place"> </td>
												<td class="subTable-brs"><input class="form-control" type="text" name="minRate" id="minRate" ng-model="blcntrinnerDtl.minRate"  placeholder="Min Rate"></td>
															<td class="subTable-brs"><selectivity
																	list="termsOfPayment" property="blcntrinnerDtl.terms"
																	id="terms" ng-model="blcntrinnerDtl.terms" name="terms"
																	form-name="blForm" friendly-name="Terms Of Payment"></selectivity></td>
																											<td class="subTable-brs"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blcntrinnerDtl.realAmount"  placeholder="Real Amount"></td>

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
									<button type="button" class="btn btn-sm btn-success "
										ng-click="addcntrDtl()">
										<i class="fa fa-plus"></i>
									</button>
									<button type="button" class="btn btn-sm btn-danger"
										ng-click="removecntrDtl(blNoData.blcntrDtlList)">
										<i class="fa fa-minus"></i>
									</button>

									<div class="padding-right-5">
										<div class="col-md-4"></div>
									</div>


								</div>
								<br>



							</div>
						</div>
					</div>
					</tab> --> <!--  <tab heading="BL Charges" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">

									<div class="table-responsive clear">
										<table class="table table-striped b-t b-light">
											<thead>
												<tr>
													<th colspan=1 class="width_1"></th>
													<th colspan=1 class="width_4">Seq<span
														style="color: red;">*</span></th>
													<th colspan=1 class="width_6 text-center">Charges Code<span
														style="color: red;">*</span>
													</th>
													<th colspan=1 class="width_6 text-center">Currency <span
														style="color: red;">*</span></th>
													<th colspan=1 class="width_6 text-center">Qty <span
														style="color: red;">*</span></th>
													<th colspan=1 class="width_4 text-center">Rate<span
														style="color: red;">*</span>
													</th>
													<th colspan=1 class="width_4 text-center">Amount<span
														style="color: red;">*</span>
													</th>
													<th colspan=1 class="width_6 text-center">PayAt <span
														style="color: red;"></span></th>
													<th colspan=1 class="width_6 text-center">Terms<span
														style="color: red;"></span>
													</th>
													<th colspan=1 class="width_6 text-center"> From Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> To Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Invoice Amount<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Real Amount<span style="color: red;">*</span></th>


												</tr>
											</thead>
											<tbody ng-repeat="(trIndex1, blCharge) in blNoData.blCharges">
												<tr>
													<td><label class="i-checks m-b-none"> <input
															type="checkbox" ng-model="blCharge.select"><i></i></label></td>

													<td><input class="form-control" type="text" name="seq"
														id="seq" ng-model="blCharge.seq" form-name="blForm"
														form-name="blForm" validation="required"
														friendly-name="Sequence"></td>
													<td class="text-center"><selectivity
															list="BlsurchargeList" property="blCharge.chargeCode"
															id="chargeCode" ng-model="blCharge.chargeCode"
															name="chargeCode" form-name="blForm"
															validation="required" friendly-name="Charge Code"></td>
													<td class="text-center"><selectivity
															list="currencyList" property="blCharge.currency"
															id="currency" ng-model="blCharge.currency"
															name="currency" form-name="blForm" validation="required"
															friendly-name="Currency"></td>
													<td class="text-center"><input class="form-control"
														type="text" name="qty" id="qty" ng-model="blCharge.qty"
														form-name="blForm" validation="required"
														friendly-name="Qty"></td>
													<td class="text-center"><input class="form-control"
														type="text" name="rate" id="rate" ng-model="blCharge.rate"
														form-name="blForm" validation="required"
														friendly-name="Rate"></td>
													<td class="text-center"><input class="form-control"
														type="text" name="amount" id="amount"
														ng-model="blCharge.amount" form-name="blForm"
														validation="required" friendly-name="Amount"></td>
													<td class="text-center"><selectivity list="portlist"
															property="blCharge.payAt" id="payAt"
															ng-model="blCharge.payAt" name="payAt" form-name="blForm"
															friendly-name="PayAt"></selectivity></td>
													<td class="text-center"><selectivity
															list="termsOfPayment" property="blCharge.terms"
															id="terms" ng-model="blCharge.terms" name="terms"
															form-name="blForm" friendly-name="Terms"></selectivity></td>
														<td class="text-center"><selectivity list="portlist" property="blCharge.fromPlace" id="fromPlace" ng-model="blCharge.fromPlace"
               name="fromPlace" form-name="blForm" validation="required"  friendly-name="From Place"  ></td>
									<td class="text-center"><selectivity list="portlist" property="blCharge.toPlace" id="toPlace" ng-model="blCharge.toPlace"
               name="toPlace" form-name="blForm" form-name="blForm" validation="required"  friendly-name="To Place" ></td>
										 <td class="text-center"><input class="form-control" type="text" name="invAmount" id="invAmount" ng-model="blCharge.invAmount"  form-name="blForm" validation="required"  friendly-name="Invoice Amount" ></td>
 									<td class="text-center"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blCharge.realAmount" form-name="blForm" validation="required"  friendly-name="Real Amount"></td>
									 


												</tr>
												<tr>
													<td></td>


												</tr>
											</tbody>
										</table>
										<button type="button" class="btn btn-sm btn-success"
											ng-click="addcharges()">
											<i class="fa fa-plus"></i>
										</button>
										<button type="button" class="btn btn-sm btn-danger"
											ng-click="removepckCharge(blNoData.blCharges)">
											<i class="fa fa-minus"></i>
										</button>

										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									</div>

								</div>
								<br>


							</div>
						</div>
					</div>
					</tab> --> </tabset>
					<br>
					<center><span ng-show ="isPrintLimitExceed == true" style="color: red;">NOTE: BL print count limit exceeded. Data cannot be modified!!!</span></center>
				</div>

			</div>
			<br> <br>
			<div align="center">
				<div >
					<!-- <button type="button" class="btn btn-success"
						ng-click="saveData(blForm)">Save</button>
					<button type="reset" class="btn btn-info">Reset</button> -->
					<button type="button" class="btn btn-danger" ng-click="cancel()" style="margin-top: 10px;">Cancel</button>
				</div>
			<!-- 	<div >
					<button type="button" class="btn btn-success" data-ng-disabled="(isPrintLimitExceed == true || sailing == true)"
						ng-click="updateData(blForm)" >Update</button>
					<button type="button" class="btn btn-info" ng-click="Reset()">Reset</button>
					<button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
				</div> -->
				<br>
			</div>

		</form>
	</div>
	</div>
</body>
</html>
