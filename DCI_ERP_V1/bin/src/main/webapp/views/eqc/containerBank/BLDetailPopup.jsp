<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />

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
						<label class="control-label" style="font-weight: bold;">Carrier :</label> {{blDetailList.carrier}}
				
					</div>
					<div class="col-md-4">
						<label class="control-label" style="font-weight: bold;">Booking No :</label> {{blDetailList.bookingno}}
				
					</div>



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
							<label class="control-label" style="font-weight: bold;">P.O.D / POT:</label> {{blDetailList.pod}}
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
							<label class="control-label" style="font-weight: bold;">No.Of BLs :</label> {{blDetailList.noBls}} <!-- <input type="number"
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
							<label class="control-label" style="font-weight: bold;">Customer :</label> {{blDetailList.clientName}}
							<!-- <selectivity list="customerList" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity> -->
						</div>
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label" style="font-weight: bold;">Customer :</label> {{blDetailList.clientName}}
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
							<label class="control-label" style="font-weight: bold;">Other BL Number :</label> {{blDetailList.otherblno}} <!-- <input class="form-control"
								type="text" class="form-control" id="otherblno"
								 ng-model="blNoData.otherblno" name="otherblno"
								form-name="blForm"> -->
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">HS Code :</label> {{blDetailList.hsCode}} <!-- <input class="form-control"
								type="text" class="form-control" id="otherblno"
								 ng-model="blNoData.otherblno" name="otherblno"
								form-name="blForm"> -->
						</div>
						
						<!-- <div class="col-md-4" style="padding-top: 27px;">
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
						</div> -->
						
						
						
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
							<label class="control-label" style="font-weight: bold;">Delivery Agent :</label> {{blDetailList.deliveryAgentName}}
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
							<label class="control-label" style="font-weight: bold;">Shipping Bill Doc :</label> 
							
						</div>
						 
						<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in exportShippingBillFiles">
								<a id="tbnewShippBill{{tIndex}}" style="display: none"
								href="{{filelist.filePath}}"
								download="{{filelist.filename}}"></a>
							<div ng-if="!isEdit" style="margin-left: -30px;  ">
								{{tIndex+1}} ) <a ng-click="openFileSample(filelist.filePath)"
									style="color: green">{{filelist.filename}}</a>
									<!-- <button class="btn btn-default input-sm" type="button"
									ng-click="deleteShippBillfiles(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button> -->
							</div>

						  </div>
						  
						  
						  <div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Export Declaration Doc :</label> 
							
						</div>
						
						
						<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in exportDeclarationDocFiles">
								<a id="tbnewExport{{tIndex}}" style="display: none"
								href="filePath/{{filelist.filename}}"
								download="{{filelist.filename}}"></a>
							<div ng-if="!isEdit" style="margin-left: -30px;    ">
								{{tIndex+1}} ) <a ng-click="openFileSample('filePath/'+filelist.filename)"
									style="color: green">{{filelist.filename}}</a>
									<!-- <button class="btn btn-default input-sm" type="button"
									ng-click="deleteuploadfiles(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button> -->
							</div>
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
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Consignee Name :</label> {{blDetailList.consigName}}
							
						</div>
						
						</div>
						
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Tax Number (GST / VAT ) :</label> {{blDetailList.consigTaxNumber}} 
							
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Country :</label> {{blDetailList.consigCountry}}
							
						</div>
						
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Address :</label> {{blDetailList.consigAddress}}
							
						</div>
						<br><br><br>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Shipper Name :</label> {{blDetailList.shipperName}}
							
						</div>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Shipper's Address :</label> {{blDetailList.shipperAddress}}
							
						</div><div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Shipper's Telephone No :</label> {{blDetailList.shipperTel}}
							
						</div><br><br><br>
						<div class="col-md-4">
							<label class="control-label" style="font-weight: bold;">Shipper's Email :</label> {{blDetailList.shipperEmail}}
							
						</div>
						<div class="col-md-4"> 
							<label class="control-label" style="font-weight: bold;">Shipper's Country :</label> {{blDetailList.shipperCountry}}
							
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
					</tab>
					
					 
					
					
					
					
					<tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 166%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<!-- <th colspan=1 class="width_2">select</th> -->
												<th colspan=1 class="width_9 text-center">Cntr No <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">Type <span
													style="color: red;"></span></th>
													<th colspan=1 class="width_3 text-center">SOC <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">Seal No <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">NW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">GW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">CBM <span
													style="color: red;"></span></th>
													
												<th colspan=1 class="width_6 text-center">Temperature<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">Vent<span
													style="color: red;"></span></th>	
												<th colspan=1 class="width_6 text-center">Humidity<span
													style="color: red;"></span></th>			
													
													
												<th colspan=1 class="width_6 text-center">Check Digit <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">Net <span style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">FLE <span style="color: red;"></span></th>
									<th colspan=1 class="width_6 text-center">SOC <span style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">Package <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">No of
													Packages <span style="color: red;"></span>
												</th>
												<th colspan=1 class="width_12 text-center">Commodity</th>
												<th colspan=1 class="width_4 text-center">is OOG</th>
												<th colspan=1 class="width_5 text-center">Hazardous</th>
												<th colspan=1 class="width_5 text-center">OWS</th>
												<th colspan=1 class="width_7 text-center">Marks</th>
												<th colspan=1 class="width_8 text-center">UN Code</th>
												<th colspan=1 class="width_8 text-center">IMCO Charge</th>
												<th colspan=1 class="width_6 text-center">POL Term <span style="color: red;"></span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;"></span></th>
											<!-- 	<th colspan=1 class="width_4 text-center">Action</th> -->

											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blDetailList.blcntrDtlList">
											<tr>
												<!-- <td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td> -->
												<td class="text-center">
												<!-- <selectivity
														list="containerList" property="blcntrDtl.cntrNo"
														id="cntrNo{{trIndex}}" ng-model="blcntrDtl.cntrNo"
														name="cntrNo{{trIndex}}" form-name="blForm"
														validation="required"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container No)'}}" disabled="true">
														</selectivity>  -->
								<!-- 									
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No" disabled="true"></selectivity> -->
               
               <label class="control-label" style="font-weight: bold;">{{blcntrDtl.containernumber}}</label>
												</td>
												
												
												
												<td class="text-center">
											<!-- 	<selectivity
														list="containerTypeList" property="blcntrDtl.type"
														id="type{{trIndex}}" name="type{{trIndex}}"
														ng-model="blcntrDtl.type" validation="required"
														validation="required" form-name="blForm"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container Type)'}}" disabled="true"></selectivity> -->
														<label class="control-label" style="font-weight: bold;">{{blcntrDtl.type}}</label>
												</td>
												<td class="text-center">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="blcntrDtl.soc" disabled="true"><i></i></label>
												</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(Seal No)'}}"
													name="sealNo{{trIndex}}" id="sealNo{{trIndex}}"
													ng-model="blcntrDtl.sealNo" placeholder="Seal No" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.sealNo}}</label>
													</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" friendly-name="tw"
													name="tw{{trIndex}}" id="tw{{trIndex}}"
													ng-model="blcntrDtl.tw" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.tw}}</label>
													</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(GW)'}}"
													name="gw{{trIndex}}" id="gw{{trIndex}}"
													ng-model="blcntrDtl.gw" disabled="true"> -->
														<label class="control-label" style="font-weight: bold;">{{blcntrDtl.gw}}</label>
													</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" friendly-name="cb"
													name="cb{{trIndex}}" id="cb{{trIndex}}"
													ng-model="blcntrDtl.cb" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.cb}}</label>
													
													</td>
													
													
													<td class="text-center">
												    <label class="control-label" style="font-weight: bold;">{{blcntrDtl.temperature}}</label>
													</td>
													
													<td class="text-center">
												    <label class="control-label" style="font-weight: bold;">{{blcntrDtl.vent}}</label>
													</td>
													
													
													<td class="text-center">
												    <label class="control-label" style="font-weight: bold;">{{blcntrDtl.humidity}}</label>
													</td>
													
													
													
													
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" name="checkdigit" form-name="blForm"
													id="checkdigit{{trIndex}}" ng-model="blcntrDtl.checkdigit" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.checkdigit}}</label>
													</td>
												<td class="text-center">
												<!-- <input class="form-control" type="text" name="net" form-name="blForm"    id="net{{trIndex}}" ng-model="blcntrDtl.net" disabled="true" > -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.net}}</label>
												</td>
									 <td class="text-center">
									<!--  <selectivity list="fleList" property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle" validation="required"
               							name="fle" form-name="blForm" 
                					friendly-name="FLE" disabled="true">
                					
                					</selectivity> -->
                					<label class="control-label" style="font-weight: bold;">{{blcntrDtl.fle}}</label>
									 </td>
									<td class="text-center">
									  <!--  <selectivity list="socList" property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so" validation="required"
              							 name="SOC" form-name="blForm" 
                						friendly-name="SOC" disabled="true">
                						</selectivity> -->
                						<label class="control-label" style="font-weight: bold;">{{blcntrDtl.so}}</label>
									 </td>
												<td class="text-center">
												<!-- <selectivity list="packageList"
														property="blcntrDtl.packageType"
														id="packageType{{trIndex}}"
														ng-model="blcntrDtl.packageType" name="packageType"
														form-name="blForm" friendly-name="Package Type"
														friendly-name="Package Type" disabled="true">
												</selectivity> -->
												<label class="control-label" style="font-weight: bold;">{{blcntrDtl.packageType}}</label>
												</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" name="noo{{trIndex}}" id="noo{{trIndex}}"
													ng-model="blcntrDtl.noOfPckgs" validation="required"
													form-name="blForm"
													friendly-name="{{ 'Row' + (trIndex+1) + '(No Of Package)'}}"
													placeholder="NoO" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.noOfPckgs}}</label>
													
												</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" name="g{{trIndex}}" id="g{{trIndex}}"
													ng-model="blcntrDtl.goods" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.goods}}</label>
												</td>
												<td class="text-center">
												<!-- <input type="checkbox"
													name="iso" id="iso{{trIndex}}" ng-model="blcntrDtl.iso" disabled="true">
													<i></i> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.iso}}</label>
												</td>
												<td class="text-center">
												 <input type="checkbox"
													name="hazardous" id="hazardous{{trIndex}}" ng-model="blcntrDtl.hazardous" disabled="true"><i></i> 
												</td>
												<td class="text-center">
												<input type="checkbox"
													name="ows" id="ows{{trIndex}}" ng-model="blcntrDtl.ows" disabled="true"><i></i> 
												</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" name="mar{{trIndex}}" id="mar{{trIndex}}"
													ng-model="blcntrDtl.marks" placeholder="MARKS" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.marks}}</label>
												</td>
													<td class="text-center">
													<!-- <input class="form-control"
													type="text" name="unCode" id="unCode" ng-model="blcntrDtl.unCode"
													placeholder="UN CODE" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.unCode}}</label>
													</td>
													
													<td class="text-center">
													<!-- <input class="form-control"
													type="text" name="imcoCharge" id="imcoCharge" ng-model="blcntrDtl.imcoCharge"
													placeholder="IMCO" disabled="true"> -->
													<label class="control-label" style="font-weight: bold;">{{blcntrDtl.imcoCharge}}</label>
													</td>
												<td class="text-center">
    								<!-- <selectivity list="termsOfPayment" property="blcntrDtl.polTer" id="polTer" ng-model="blcntrDtl.polTer"
         						 form-name="blForm" validation="required" friendly-name="POL Term"name="polTer"  disabled="true" >
         						 </selectivity>	 -->
         						 <label class="control-label" style="font-weight: bold;">{{blcntrDtl.polTer}}</label>
         						 </td>
									                 <td class="text-center">
									   <!--  <selectivity list="termsOfPayment" property="blcntrDtl.podTer" id="podTer" ng-model="blcntrDtl.podTer"
									         form-name="blForm" validation="required" friendly-name="POD Term"      name="podTer" disabled="true"  >
									         </selectivity>	 -->
									                 <label class="control-label" style="font-weight: bold;">{{blcntrDtl.podTer}}</label>
									         
									         </td>
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
									</button> -->

									<div class="padding-right-5">
										<div class="col-md-4"></div>
									</div>


								</div>
								<br>



							</div>
						</div>
					</div>
					</tab>
					<tab heading="Goods" style="background:#5F9EA0">
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
								  class="i-checks m-b-none" style="font-weight: bold; padding-left: 0px;!important">Print N.WGT  
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
					</tab>
					<tab heading="Quotation Details" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 150%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
<tr>
							<th colspan=1 class="width_13 text-center">Charge Heads </th>
							<th colspan=1 class=" width_9 text-center">Unit </th>
														<th colspan=1 class=" width_9 text-center">Container Type </th>
							
							<th colspan=1 class=" width_8 text-center">Qty </th>
							<th colspan=1 class="width_10 text-center">Rate</th>
							<th colspan=1 class="width_10 text-center">Currency </th>
<!-- 								<th colspan=1 class=" width_10 text-center">Payment Method </th>
 -->							<th colspan=1 class=" width_6 text-center">Transaction Type </th>
								<th colspan=1 class=" width_14 text-center">Buy/Sell Party </th>
								<th colspan=1 class=" width_16 text-center">Notes </th>
						</tr>
</thead>
										<tbody ng-repeat="(trIndex, row) in blDetailList.quotationDtl"
							>
							<tr>
								
								<td class=" width_9">
								<label class="col-md-6 control-label  text-right">{{row.chargeHead}}</label>	
								</td>
								<td class=" width_9">
										<label class="col-md-6 control-label  text-right">{{row.unitName}}</label>
										
										</td>
											<td crlass="width_7">
											<label class="col-md-6 control-label  text-right">{{row.conType}}</label>
											</td>
						<td class=" width_6" ><label class="col-md-6 control-label  text-right">{{row.qty}}</label>
						
										</td>
											<td class=" width_6" ><label class="col-md-6 control-label  text-right">{{row.rate}}</label>
						
										</td>
								
								<td class=" width_8" ><label class="col-md-6 control-label  text-right">{{row.currencyName}}</label>
								
								</td>
								
										
										<td class=" width_8"><label class="col-md-6 control-label  text-right">{{row.transactionType1}}</label>
										</td>
										
													<td class=" width_12"><label class="col-md-6 control-label  text-right">{{row.tranType}}</label>
													</td>
										
										<td class=" width_8"  style="padding-left: -56px;">
										<label class="col-md-6 control-label  text-right">{{row.note}}</label>
										
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
					</tab> 
					<tab heading="Local Charges" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 150%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
<tr>

<th colspan=1 class="width_15 text-center">Surcharge<span
style="color: red;"> </span></th>

<!-- <th colspan=1 class="width_10 text-center">Charge Type<span
style="color: red;"> </span></th> -->
<th colspan=1 class="width_3 text-center">UOM</th>
<th colspan=1 class="width_5 text-center"
>Container Type<span
style="color: red;"> </span></th>

<th colspan=1 class="width_5 text-center">Hazardous<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">OOG Cargo<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">Currency<span
style="color: red;"> *</span></th>
<th colspan=1 class="width_5 text-center">Tax(%)<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">Quoted Rate<span
style="color: red;">*</span></th>
<th colspan=1 class="width_5 text-center">Quantity<span
style="color: red;">*</span></th>

<th colspan=1 class="width_10 text-center">Remarks<span
style="color: red;"></span></th>
</tr>
</thead>
										<tbody ng-repeat="(trIndex, row) in blDetailList.addchargeData track by trIndex">
<tr>




<td class="width_10">


<selectivity list="chargeHeadList" property="row.surcharge"
id="surcharge{{trIndex}}" data-ng-model="row.surcharge"
name="surcharge{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(surcharge)'}}"
form-name="surcharge"></selectivity>

</td>
<!-- <td class="width_10">


<selectivity list="contTypeList" property="row.chargeType"
id="chargeType{{trIndex}}" data-ng-model="row.chargeType"
name="chargeType{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(chargeType)'}}"
></selectivity>
</td> -->
<td class="width_10">


<selectivity list="UnitList" property="row.uom"
id="uom{{trIndex}}" data-ng-model="row.uom"
name="uom{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(uom)'}}"
></selectivity>
</td>

<td class="width_5">
<div class="row">
<div class="col-xs-12">

<selectivity list="conTypeList"
property="row.conType" id="conType{{trIndex}}"
data-ng-model="row.conType"
name="conType{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(conType)'}}"
form-name="localForm"></selectivity>

</div>
</div>
</td>


<td class="width_5" align="center">
<div class="row">

<input type="checkbox" data-ng-model="row.hazardous"
id="hazardous" name="hazardous{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


</div>
</td>


<td class="width_5" align="center">
<div class="row">

<input type="checkbox" data-ng-model="row.oog" id="oog"
name="oog{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(oog)'}}">


</div>
</td>


<td class="width_10">
<div class="row">
<div class="col-xs-12">
<selectivity list="currencylist" property="row.addchrgcurrency"
id="addchrgcurrency{{trIndex}}" data-ng-model="row.addchrgcurrency"
name="addchrgcurrency{{trIndex}}" validation="required"
friendly-name="{{ 'Row' + $index + '(addchrgcurrency)'}}"
></selectivity>
</div>
</div>
</td>
<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.addchrgtax"
name="addchrgtax{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(addchrgtax)'}}" />
</div>
</div>
</td>
<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.bookingRate"
name="bookingRate{{trIndex}}"

friendly-name="{{ 'Row' + $index + '(bookingRate)'}}" />
</div>
</div>
</td>

<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.bookingqty"
name="bookingqty{{trIndex}}" validation="required"

friendly-name="{{ 'Row' + $index + '(bookingqty)'}}" />
</div>
</div>
</td>

<td class="width_10">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
data-ng-model="row.bookremarks"
name="bookremarks{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(bookremarks)'}}" />
</div>
</div>
</td>



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
					</tab>
					
					<tab heading="BL Log History" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">

									<div class="table-responsive clear">
									
									<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection"> 
										<div class="panel-body float-left padding-0" style="width: 100%">
										  <div class="table-responsive" style ="margin-bottom:30px;">
										    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red">
										     <thead class="dataTables-Main-Head">
										      <tr>
										       <th class="sorting width_10" st-sort="date">Date</th>
										       <th class="sorting width_10" st-sort="function">Function</th>
										       <th class="sorting width_10" st-sort="userName">User Name</th>
										       <th class="sorting width_10" st-sort="action">Action</th>
										       <th class="sorting width_10" st-sort="description">Description</th>
										       <th class="sorting width_10" st-sort="logDetailDescription">Log Description</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="blLogHistoryItem in displayedCollection">
										       <td>{{blLogHistoryItem.log_date}}</td>
											   <td>{{blLogHistoryItem.formName}}</td>
										       <td> {{blLogHistoryItem.userName}}</td>
										       <td>{{blLogHistoryItem.actionType}}</td>
										       <td>{{blLogHistoryItem.log_description}}</td>
										        <td ng-if="blLogHistoryItem.actionType=='UPDATE'">{{blLogHistoryItem.logDetailDescription}}</td>
										        <td ng-if="blLogHistoryItem.actionType!='UPDATE'"></td>				
										      </tr>
										     </tbody>
										    </table>
										    <%--  <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer>  --%>
										  </div>
										 </div>
										  </div>
									
								

										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									</div>

								</div>
								<br>


							</div>
						</div>
					</div>
					</tab>
					
					
					<tab heading="Destination Charges" style="background:#5F9EA0" >
					  <div class="col-md-12" style="margin-top: 15px;">
									<div class="col-md-6" style="margin-top: 10px;margin-bottom: 10px;"><span style="font-weight: bold;">Freight Terms : </span> {{paymentTerms}}</div>
									<div class="col-md-6" style="margin-top: 10px;margin-bottom: 10px;"><span style="font-weight: bold;">Destination Charges : </span> {{destinationCharge}} </div>
									</div>
					<div class="col-md-12">
				
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">
									<div class="table-responsive clear">
									
									<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection"> 
										<div class="panel-body float-left padding-0" style="width: 100%">
										  <div class="table-responsive" >
										    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red">
										     <thead class="dataTables-Main-Head">
										      <tr>
										       <th class="sorting width_10" st-sort="chargeName">Freight & Charges</th>
										       <th class="sorting width_10" st-sort="function">P/C</th>
										       <th class="sorting width_10" st-sort="userName">Amount</th>
										       <th class="sorting width_10" st-sort="exchangeRate">Exchange Rate</th>
										         <th class="sorting width_10" st-sort="tax">Tax</th>
										       <th class="sorting width_10" st-sort="description">Amount({{bldesCurrency}})</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="blDestinationCharges in bldesChargesList">
										       <td>{{blDestinationCharges.chargeName}}</td>
										        <td ng-if="blDestinationCharges.uom != 'PER CTR'">1 x {{blDestinationCharges.rate}} {{blDestinationCharges.uom}}</td>
											   <td ng-if="blDestinationCharges.uom == 'PER CTR'">{{blDestinationCharges.containerType}} / {{blDestinationCharges.quantity}} x {{blDestinationCharges.rate}} {{blDestinationCharges.uom}}</td>
										       <td ng-if="blDestinationCharges.uom != 'PER CTR'"> {{blDestinationCharges.rate*1}}</td>
										       <td ng-if="blDestinationCharges.uom == 'PER CTR'"> {{blDestinationCharges.rate*blDestinationCharges.quantity}}</td>
										       <td>{{blDestinationCharges.exchangeRate}}</td>
										       <td>{{blDestinationCharges.tax}}</td>
										        <td ng-if="blDestinationCharges.uom != 'PER CTR'">{{(blDestinationCharges.rate*blDestinationCharges.exchangeRate*1) | number : 2}}</td>	
										       <td ng-if="blDestinationCharges.uom == 'PER CTR'">{{(blDestinationCharges.rate*blDestinationCharges.quantity*blDestinationCharges.exchangeRate) | number : 2}}</td>
										       				
										      </tr>
										     </tbody>
										    </table>
										      <%-- <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer>  --%>
										  </div>
										 </div>
										  </div>
									 
								

										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									</div>

								</div>
								<br>


							</div>
						</div>
					</div>
					</tab>
					
					
					<tab heading="BL Attachments" style="background:#5F9EA0">
					
					<div class="col-md-12" style="margin-top: 2%; " >
					
					<div class="col-md-3">
							<label class="control-label" style="font-weight: bold;">RRR Dual Approval :</label> 
							<input type="file" class="form-control" name="rateDeviationApprovalDoc" 
													id="rateDeviationApprovalDoc" friendly-name="rateDeviationApprovalDoc" data-ng-model="blNoData.rateDeviationApprovalDoc"
													onchange="angular.element(this).scope().uploadFile(this)"
													multiple />
						</div>
						<div class= "col-md-1" style="    margin-top: 25px;">
												<button class="btn btn-primary" type="button"
													ng-click="addRateDeviationFile()">Add</button>
						</div>
						<div id="dialog" style="display: none">
     </div>
						
<!-- 						<div  style="cursor: pointer; " ng-if="fileList.file_type != 'Folder'" ng-click="openFileSample(fileList.filePath)">  -->
<!--        <img   ng-src="{{fileList.fileIcon}}" style="padding: 0px 8px 0px 0px; height: 40px;"> -->
<!--        <a id="fileExport{{tIndex}}" style="display:none" -->
<!-- href="{{fileList.filePath}}" -->
<!-- download="{{fileList.fileName}}.{{fileList.file_type}}" ></a> -->
<!--        {{fileList.fileName}}</div> -->
						 
						<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in rateDeviationFiles">
								<a id="rateDeviationBill{{tIndex}}" style="display: none"
								href="{{filelist.filePath}}"
								download="{{filelist.filename}}"></a>
							<div ng-if="!isEdit" style="margin-left: -30px;  ">
								{{tIndex+1}} ) <a 
									style="color: green"  ng-click="openFileSample('filePath/'+filelist.filename)">{{filelist.filename}}</a>
								<button class="btn btn-default input-sm" type="button"
												ng-click="deleteRateDeviationfiles(filelist.filename)"
												data-toggle="tooltip" title="Delete file">
												<i class="fa fa-trash"></i>
											</button>
							</div>

						  </div>
						  
					
					</div>
					
					
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">

									<div class="table-responsive clear">
									
									<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection"> 
										<div class="panel-body float-left padding-0" style="width: 100%">
										  <div class="table-responsive" style ="margin-bottom:30px;">
										    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red">
										     <thead class="dataTables-Main-Head">
										      <tr>
										       <th class="sorting width_10" st-sort="fileName">File</th>
										       <th class="sorting width_10" st-sort="function">Function</th>
										      <th class="sorting width_10" st-sort="action">Action</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(tIndex, blAttachFiles) in blAttach">
										       <td style="cursor: pointer; " ng-if="fileList.file_type != 'Folder'" ng-click="openFileSample(blAttachFiles.filePath)"> 
      											 <img   ng-src="{{fileList.fileIcon}}" style="padding: 0px 8px 0px 0px; height: 40px;">
     											  <a id="fileExport{{tIndex}}" style="display:none"
													href="{{blAttachFiles.filePath}}"
													download="{{blAttachFiles.fileName}}.{{fileList.file_type}}" ></a>{{blAttachFiles.fileName}}</td>
										        <td>{{blAttachFiles.formName}}</td>

										       <td>	
										       <a id="bldownloadFiles{{tIndex}}" style="display: none"
												href="{{blAttachFiles.filePath}}"
												download="{{blAttachFiles.fileName}}"></a>
										       <span> <i class="fa fa-download text-primary text"
													data-toggle="tooltip" title="Download"
													ng-click="downloadblAttachFile(tIndex)"></i>
												</span> 
												</td>
												
												
												
												
												
												
												
												     		
										      </tr>
										     </tbody>
										    </table>
										    <%--  <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer>  --%>
										  </div>
										 </div>
										  </div>
									
								

										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									</div>

								</div>
								<br>


							</div>
						</div>
					</div>
					</tab>
					
					
					
					
					<tab heading="Invoice" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">

									<div class="table-responsive clear">
									
									<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection"> 
										<div class="panel-body float-left padding-0" style="width: 100%">
										  <div class="table-responsive" style ="margin-bottom:30px;">
										    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red">
										     <thead class="dataTables-Main-Head">
										      <tr>
										       <th class="sorting width_10" st-sort="invoiceNo">Invoice No</th>
										       <th class="sorting width_10" st-sort="blNo">BL No</th>
										       <th class="sorting width_13" st-sort="quotationNo">Quotation No.</th>
										       <th class="sorting width_12" st-sort="createdOn">Invoice Date</th>
										       <th class="sorting width_10" st-sort="agentName">Agent</th>
										       <th class="sorting width_10" st-sort="customerName">Customer</th>
										       <th class="sorting width_10" st-sort="vesselName">Vessel/Voyage</th>
										       <th class="sorting width_10" st-sort="createdBy">Created By</th>
										       <th class="sorting width_10" st-sort="totalTcAmt">Total Amt</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="blInvoiceData in blInvoiceDataList">
										       <td>{{blInvoiceData.invoiceNo}}</td>
											   <td>{{blInvoiceData.blNo}}</td>
										       <td> {{blInvoiceData.quotationNo}}</td>
										       <td>{{blInvoiceData.createdOn}}</td>
										       <td>{{blInvoiceData.agentName}}</td>
										       <td>{{blInvoiceData.customerName}}</td>
										       <td>{{blInvoiceData.vesselName}}</td>
										       <td>{{blInvoiceData.createdBy}}</td>
										      	<td>{{blInvoiceData.totalTcAmt}}</td>	
										      </tr>
										     </tbody>
										    </table>
										    <%--  <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer>  --%>
										  </div>
										 </div>
										  </div>
									
								

										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									</div>

								</div>
								<br>


							</div>
						</div>
					</div>
					</tab>
					
					
					
					
				 <tab heading="Collections" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">

									<div class="table-responsive clear">
									
									<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection"> 
										<div class="panel-body float-left padding-0" style="width: 100%">
										  <div class="table-responsive" style ="margin-bottom:30px;">
										    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red">
										     <thead class="dataTables-Main-Head">
										      <tr>
										       <th class="sorting width_10" st-sort="voucherNo">Voucher No</th>
										       <th class="sorting width_10" st-sort="voucherDate">Voucher Date</th>
										       <th class="sorting width_13" st-sort="accountHeadName">Bank/Cash</th>
										       <th class="sorting width_12" st-sort="chequeNo">Cheque No</th>
										       <th class="sorting width_10" st-sort="customerName">Customer Name</th>
										       <th class="sorting width_10" st-sort="totalAmtTC">Total Amount-TC</th>
										       <th class="sorting width_10" st-sort="totalAmtBC">Total Amount-BC</th>
										       <th class="sorting width_10" st-sort="createdBy">Created By</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="blCollectionsData in blCollectionsDataList">
										       <td>{{blCollectionsData.voucherNo}}</td>
											   <td>{{blCollectionsData.voucherDate}}</td>
										       <td>{{blCollectionsData.accountHeadName}}</td>
										       <td>{{blCollectionsData.chequeNo}}</td>
										       <td>{{blCollectionsData.customerName}}</td>
										       <td>{{blCollectionsData.totalAmtTC}}</td>
										       <td>{{blCollectionsData.totalAmtBC}}</td>
										      	<td>{{blCollectionsData.createdBy}}</td>	
										      </tr>
										     </tbody>
										    </table>
										    <%--  <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer>  --%>
										  </div>
										 </div>
										  </div>
									
								

										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									</div>

								</div>
								<br>


							</div>
						</div>
					</div>
					</tab>
					
					
					
					
					
					
					
					.
					   </tabset>
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
		
		<div id="dialog" style="display: none">
     </div>
		
	</div>
	</div>
</body>
</html>
