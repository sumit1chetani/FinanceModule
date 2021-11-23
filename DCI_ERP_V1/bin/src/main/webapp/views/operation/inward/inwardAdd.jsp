<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
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
.table {
    width: 137% !important;
    max-width: 200% !important;
    margin-bottom: 20px;
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
								<div class="form-group">
									<label class="col-md-3 control-label">Carrier <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="blNoData.carrier"
										 property="blNoData.carrier"
										id="carrier" 
										friendly-name="Carrier"
										form-name="blForm"></selectivity>
								</div>
								</div>
							</div>
							<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-3 control-label">Branch <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="branchList"
										property="blNoData.branch" id="branch"
										name="branch" ng-model="blNoData.branch"
										object="branch" friendly-name="Branch"
										validation="required" form-name="quotationForm"></selectivity>
										
								</div>
								</div></div>
							<div class="col-md-4" style="margin-bottom: 10px;">
          <div class="form-group "><label  class="col-md-3 control-label">B/L No  <span style="color: red;">*</span></label>
             <div class="col-md-7">
                <input class="form-control" type="text" placeholder="B/L No"  class="form-control" id="blNo"  
                ng-model="blNoData.blNo" name="blNo" form-name="blForm" validation="required"  friendly-name="B/L No" > </div>
              </div></div>
					<div class="col-md-4" style="margin-bottom: 10px;">
						<label class="control-label">Booking No</label>
						<div>
						<input class="form-control"
								type="text" placeholder="" class="form-control" id="bookingNo"
								friendly-name="bookingNo" ng-model="blNoData.bookingNo" name="bookingNo"
								form-name="blForm">
						 
						 	<!-- <selectivity list="bookingNoList" property="blNoData.bookingNo" id="bookingNo"
								ng-model="blNoData.bookingNo" name="bookingNo" form-name="blForm"
								validation="required" friendly-name="bookingNo"></selectivity> -->
								<!-- 	<selectivity list="jobList" property="blNoData.jobNo" id="jobNo"
								ng-model="blNoData.jobNo" name="jobNo" form-name="blForm"
								validation="required" friendly-name="Job No"></selectivity> -->
						</div>


					</div>

					<!-- <div class="col-md-4"  style="margin-bottom: 10px;">
						<label class="control-label">ShipmentOrder No<span
							style="color: red;">*</span></label>
						<div>
							<selectivity list="jobList" property="blNoData.jobNo" id="jobNo"
								ng-model="blNoData.jobNo" name="jobNo" form-name="blForm" disabled = "true"
								validation="required" friendly-name="Job No"></selectivity>
						</div>


					</div> -->
					
				<!-- 	<div class="col-md-5"  ng-if="isEdit">
						<label class="col-md-5  control-label">OBL Print Issue Date:</label>
						<div class="col-md-4">
					<label class="col-md-5 control-label">	{{blNoData.OBLPrintDate}}</label>
							</div>
					</div> -->
					
						<div class="col-md-3" ng-if="isEdit">
						<label class="col-md-4 control-label">BL TYPE:</label>
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
							<label class="control-label"> Place of Issue <span
								style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							<!-- 	<input class="form-control"
								type="text" placeholder="" class="form-control" id="issuePlace"
								friendly-name="issuePlace" ng-model="blNoData.issuePlace" name="issuePlace"
								form-name="blForm"> -->
							<selectivity list="polList" property="blNoData.issuePlace"
								id="issuePlace" ng-model="blNoData.issuePlace" name="issuePlace"
								form-name="blForm" validation="required"
								friendly-name="Issue Place"></selectivity> 
							<!--  
                  <selectivity list="issuePlaceList" property="blNoData.issuePlace" id="issuePlace" ng-model="blNoData.issuePlace"
               name="issuePlace" form-name="blForm" validation="required" 
                friendly-name="Issue Place"></selectivity> -->
						</div>


						<div class="col-md-4">
							<label class="control-label">Date of Issue <span
								style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							<ng-bs3-datepicker data-ng-model="blNoData.issueDate"
								name="issueDate" form-name="blForm" validation="required"
								friendly-name="Issue Date" validation="required" />
						</div>

						<!-- <div class="col-md-4">
              <label class="control-label">On Board</label>
              <ng-bs3-datepicker data-ng-model="blNoData.onBoard"
											name="onBoard" form-name="blForm" 
										   />
</div> -->
						<!-- <div class="col-md-4">
							<label class="control-label">Vsl.Voyage <span
								style="color: red;">*</span></label>
							<selectivity list="vesselVoyageList"
								property="blNoData.vslVoyage" id="vslVoyage"
								ng-model="blNoData.vslVoyage" name="mVoyage" form-name="blForm"
								validation="required" friendly-name="Vsl.Voyage" disabled="true"></selectivity>
						</div> -->
						
						
						<br><br><br><br>
						<div class="col-md-4">
							<label class="control-label">Vessel <span
								style="color: red;">*</span></label>
							<selectivity list="vesselList"
								property="blNoData.vessel" id="vessel"
								ng-model="blNoData.vessel" name="vessel" form-name="blForm"
								validation="required" friendly-name="vessel" ></selectivity>
						</div><div class="col-md-4">
							<label class="control-label">Voyage <span
								style="color: red;">*</span></label>
							<selectivity list="voyageList"
								property="blNoData.voyage" id="voyage"
								ng-model="blNoData.voyage" name="voyage" form-name="blForm"
								validation="required" friendly-name="voyage" ></selectivity>
						</div><div class="col-md-4">
							<label class="control-label">Receipt at <span
								style="color: red;">*</span></label>
							<!--    <selectivity list="issuePlaceList" property="blNoData.receiptAt" id="receiptAt" ng-model="blNoData.receiptAt"
               name="receiptAt"  form-name="blForm" validation="required" 
                friendly-name="Receipt at"></selectivity> -->
							<selectivity list="polList" property="blNoData.receiptAt"
								id="receiptAt" ng-model="blNoData.receiptAt" name="receiptAt"
								form-name="blForm" validation="required"
								friendly-name="Receipt at "></selectivity>


						</div>
					</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">



						
						<div class="col-md-4">
							<label class="control-label">P.O.L <span
								style="color: red;">*</span></label>
							<selectivity list="polList" property="blNoData.pol" id="pol"
								ng-model="blNoData.pol" name="pol" form-name="blForm"
								validation="required" friendly-name="POL" ></selectivity>

						</div>
						<div class="col-md-4">
							<label class="control-label">P.O.D / POT<span
								style="color: red;">*</span></label>
							<selectivity list="portlist" property="blNoData.pod" id="pod"
								ng-model="blNoData.pod" name="pod" form-name="blForm"
								validation="required" friendly-name="POD" ></selectivity>
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
                <label class="control-label">F.P.O.D  <span style="color: red;"></span></label> 
              <selectivity list="portlist" property="blNoData.fpod" id="fpod" ng-model="blNoData.fpod"
               name="fpod" form-name="blForm"  
                friendly-name="FPOD" ></selectivity>     
              </div> 
						<div class="col-md-4">
							<label class="control-label">Shipment Terms <span
								style="color: red;">*</span></label>
							<selectivity list="termsOfPayment" property="blNoData.terms"
								id="terms" ng-model="blNoData.terms" name="terms"
								form-name="blForm" validation="required"
								friendly-name="Terms Of Payment"></selectivity>

						</div>
						<div class="col-md-4">
							<label class="control-label">No.Bls <span
								style="color: red;">*</span></label> <input type="number"
								placeholder="No.Bls" class="form-control" id="noBls"
								friendly-name="No.Bls" ng-model="blNoData.noBls" name="noBls"
								form-name="blForm" validation="required">
						</div>
						
					</div>
					<br>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label">Display Vessel <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> 
							<!-- 	<input class="form-control"
								type="text" placeholder="" class="form-control" id="disvessel"
								friendly-name="disvessel" ng-model="blNoData.disvessel" name="disvessel"
								form-name="blForm"> -->
								
									<selectivity list="vesselList" ng-model="blNoData.disvessel"
										validation="required" friendly-name="disvessel" disabled = "true"
											property="blNoData.disvessel" id="disvessel" name="vessel"
											form-name="blForm" ></selectivity>
						</div>
						 <div class="col-md-4">
							<label class="control-label">Display Voyage <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> 
								
										
								 <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvoyage" disabled = "true"
								friendly-name="disvoyage" ng-model="blNoData.disvoyage" name="disvoyage"
								form-name="blForm"> 
						</div> 
						<!-- <div class="col-md-4">
							<label class="control-label">Country of Origin of goods<span
								style="color: red;"></span></label>
							<input class="form-control"
								type="text" placeholder="" class="form-control" id="orginOfGoods"
								friendly-name="orginOfGoods" ng-model="blNoData.orginOfGoods" name="orginOfGoods"
								form-name="blForm">
						</div> -->
						<div class="col-md-4">
							<label class="control-label">Display P.O.R <span
								style="color: red;"></span></label> <!-- <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPor"
								friendly-name="disPor" ng-model="blNoData.disPor" name="disPor"
								form-name="blForm"> -->
								<selectivity list="portlist" property="blNoData.disPor" id="disPor" ng-model="blNoData.disPor"
               name="disPor" form-name="blForm"  
                friendly-name="disPor" ></selectivity>     
						</div>
						</div><br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label">Display P.O.L <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> 
							<!-- 	<input class="form-control"
								type="text" placeholder="" class="form-control" id="disPol"
								friendly-name="disPol" ng-model="blNoData.disPol" name="disPol"
								form-name="blForm"> -->
								
											<selectivity list="portlist" property="blNoData.disPol" id="disPol" ng-model="blNoData.disPol"
               name="disPol" form-name="blForm"  
                friendly-name="disPol" ></selectivity>  
						</div>
						<div class="col-md-4">
							<!-- <label class="control-label">Display P.O.D <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;">(9)</span></label> -->
								<label class="control-label">Port Of Discharge<span style="color: red;">*</span> <span style="color: #23b7e5;padding-left: 95px;"></span></label>
								
							<!-- 	 <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPod"
								friendly-name="disPod" ng-model="blNoData.disPod" name="disPod"
								form-name="blForm"> -->
								
								<selectivity list="portlist" property="blNoData.disPod" id="disPod" ng-model="blNoData.disPod"
               name="disPod" form-name="blForm"  
                friendly-name="disPod" ></selectivity>  
						</div>
						<div class="col-md-4">
							<!-- <label class="control-label">Display F.P.O.D <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>  -->
								<label class="control-label">Place Of Delivery/ Final Destination <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span> </label>
							<!-- 	
								<input class="form-control"
								type="text" placeholder="" class="form-control" id="disFpod"
								friendly-name="disFpod" ng-model="blNoData.disFpod" name="disFpod"
								form-name="blForm"> -->
								
											<selectivity list="portlist" property="blNoData.disFpod" id="disFpod" ng-model="blNoData.disFpod"
               name="disFpod" form-name="blForm"  
                friendly-name="disFpod" ></selectivity>  
						</div>
						</div>
					<br>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

						<div class="col-md-4" ng-if="!isEdit">
							<label class="control-label">Customer <span
								style="color: red;">*</span></label>
							<selectivity list="customerList" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity>
						</div>
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Customer <span
								style="color: red;">*</span></label>
							<selectivity list="customerList" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity>
						</div>
						<!--  <div class="col-md-4">
                <label class="control-label">Payer  <span style="color: red;"></span></label>
                   <selectivity list="payerList" property="blNoData.payer" id="payer" ng-model="blNoData.payer"
               name="payer"    form-name="blForm"   ></selectivity>   
              </div> -->
						<div class="col-md-4" ng-if ='!showSOBDate'>
							<label class="control-label">On Board <span
								style="color: red;"></span></label>
							<ng-bs3-datepicker data-ng-model="blNoData.onBoard" id="onBoard"
								friendly-name="On Board"  name="onBoard" 
								form-name="blForm" />
						</div>
						<div class="col-md-4" ng-if='showSOBDate'>
							<label class="control-label">On Board <span
								style="color: red;"></span></label>
							<ng-bs3-datepicker data-ng-model="blNoData.onBoard" id="onBoard"
								friendly-name="On Board"  name="onBoard" 
								form-name="blForm" />
								
						</div>
						
						
					

						<div class="col-md-4">
							<label class="control-label">Remarks</label> <input
								class="form-control" type="text" placeholder="Remarks"
								class="form-control" id="remarks" ng-model="blNoData.remarks"
								name="remarks">
						</div>
					</div>
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<!-- <div class="col-md-4">
							<label class="control-label">REF <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="REF" class="form-control" id="ref"
								friendly-name="Ref" ng-model="blNoData.ref" name="ref"
								form-name="blForm">
						</div>
						
						<div class="col-md-4">
							<label class="control-label">Other Bl No  </label> <input class="form-control"
								type="text" class="form-control" id="otherblno"
								 ng-model="blNoData.otherblno" name="otherblno"
								form-name="blForm">
						</div> -->
						
						<!-- <div class="col-md-4" style="padding-top: 27px;">
								 <label
								  class="i-checks m-b-none" style="padding-left: 12px;">Multi Model
									<input type="checkbox" id="multimodel" name ="multimodel" ng-model="blNoData.multimodel" form-name="blForm"><i style="margin-left: 20px;"></i>
							</label> 
							
							<label
								  class="i-checks m-b-none" style="padding-left: 12px;">RFS
									<input type="checkbox" id="multimodel" name ="multimodel" ng-model="blNoData.rfs" form-name="blForm"><i style="margin-left: 20px;"></i>
							</label>  
							
							<label
								  class="i-checks m-b-none"  style="padding-left: 8px;">Detention Tariff
									<input type="checkbox" id="detentionTariff" name ="detentionTariff" ng-model="blNoData.detentionTariff" form-name="blForm"><i style="margin-left: 20px;"></i>
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
			 
					<br>

				 
				</div>
				
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
				<div class="col-md-4" >
							<label class="control-label">Destination Agent <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							<selectivity list="agentList" property="blNoData.deliveryAgent"
								id="deliveryAgent" ng-model="blNoData.deliveryAgent" name="deliveryAgent"
								friendly-name="deliveryAgent" form-name="blForm" ></selectivity>
						</div>
						 <div class="col-md-4">
							<label class="control-label">P.O.D.1 <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.pod1" id="pod1"
								ng-model="blNoData.pod1" name="pod1" form-name="blForm"
								friendly-name="POD1" ></selectivity>
						</div>
						
						<div class="col-md-4">
							<label class="control-label">P.O.D.2 <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.pod2" id="pod2"
								ng-model="blNoData.pod2" name="pod1" form-name="blForm"
								friendly-name="POD2" ></selectivity>
						</div>
						
						
						

						</div>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						<div class="col-md-4" style="padding-top: 27px;" ng-if ="isEdit">
								 <label
								  class="i-checks m-b-none" style="padding-left: 12px;">Retain OnBoard
									<input type="checkbox" id="rob" name ="rob" ng-model="blNoData.rob" form-name="blForm" ng-disabled="true"><i style="margin-left: 20px;"></i>
							</label> 
							
						 
						</div>
						
							<div class="col-md-4">
							<label class="control-label">Country of Origin of goods<span
								style="color: red;"></span></label>
							<input class="form-control"
								type="text" placeholder="" class="form-control" id="orginOfGoods"
								friendly-name="orginOfGoods" ng-model="blNoData.orginOfGoods" name="orginOfGoods"
								form-name="blForm">
						</div>
						</div>
						
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						<div class="col-md-4">
							<label class="control-label">Export Declaration Doc<span
								style="color: red;"></span></label>
							<input type="file" class="form-control" name="exportDeclarationDoc" 
										id="exportDeclarationDoc" friendly-name="exportDeclarationDoc" data-ng-model="blNoData.exportDeclarationDoc"
										onchange="angular.element(this).scope().uploadFile(this)"
										multiple />
						</div>
						<div class= "col-md-1" style="    margin-top: 25px;">
									<button class="btn btn-primary" type="button"
										ng-click="addImage()">Add</button>
						</div>
							<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in exportDeclarationDocFiles">
								<a id="tbnewExport{{tIndex}}" style="display: none"
								href="filePath/{{filelist.filename}}"
								download="{{filelist.filename}}"></a>
							<div ng-if="isEdit" style="margin-left: -30px;    margin-top: 15px;">
								{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)"
									style="color: green">{{filelist.filename}}</a>
									<button class="btn btn-default input-sm" type="button"
									ng-click="deleteuploadfiles(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button>
							</div>

							<div ng-if="!isEdit" style="">
								{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
								<button class="btn btn-default input-sm" type="button"
									ng-click="deleteuploadfiles(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button>
							</div>

						  </div>
						
						
						</div>
						
<!-- 						Shipping bill -->
			<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;" >
						<div class="col-md-4">
							<label class="control-label">Shipping Bill Doc<span
								style="color: red;"></span></label>
							<input type="file" class="form-control" name="shippingBillDoc" 
										id="shippingBillDoc" friendly-name="shippingBillDoc" data-ng-model="blNoData.shippingBillDoc"
										onchange="angular.element(this).scope().uploadFile(this)"
										multiple />
						</div>
						<div class= "col-md-1" style="    margin-top: 25px;">
									<button class="btn btn-primary" type="button"
										ng-click="addShipFile()">Add</button>
						</div>
							<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in exportShippingBillFiles">
								<a id="tbnewShippBill{{tIndex}}" style="display: none"
								href="{{filelist.filePath}}"
								download="{{filelist.filename}}"></a>
							<div ng-if="isEdit" style="margin-left: -30px;    margin-top: 15px;">
								{{tIndex+1}} ) <a ng-click="downloadNewBillFile(tIndex)"
									style="color: green">{{filelist.filename}}</a>
									<button class="btn btn-default input-sm" type="button"
									ng-click="deleteShippBillfiles(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button>
							</div>

							<div ng-if="!isEdit" style="">
								{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
								<button class="btn btn-default input-sm" type="button"
									ng-click="deleteShippBillfiles(filelist.filename)"
									data-toggle="tooltip" title="Delete file">
									<i class="fa fa-trash"></i>
								</button>
							</div>
						  </div>					
						
						</div>
						
						
						
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4">
							<label class="control-label">Freight Payable at <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="freightAt"
								friendly-name="freightAt" ng-model="blNoData.freightAt" name="freightAt"
								form-name="blForm"  >
						</div>
						<div class="col-md-4">
							<label class="control-label">Freight Payable by <span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="freightBy"
								friendly-name="freightBy" ng-model="blNoData.freightBy" name="freightBy"
								form-name="blForm">
						</div>
						<!-- <div class="col-md-4">
							<label class="control-label">SOB Type<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="sobType"
								friendly-name="sobType" ng-model="blNoData.sobType" name="sobType"
								form-name="blForm">
						</div> -->
						<div class="col-md-4">
							<label class="control-label">Bill Type<span
								style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
								<selectivity list="blTypeList" ng-model="blNoData.billtype"
										 property="blNoData.billtype"
										id="billtype" object="billtype" name="billtype"
										friendly-name="billtype"
										form-name="blForm"></selectivity>
						</div>
					
						</div>
						
						
							
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					
					
						
							<div class="col-md-4">
							<label class="control-label">UOM <span
								style="color: red;">*</span></label>
								<selectivity list="GWList" ng-model="blNoData.gw_unit"
										 property="blNoData.gw_unit"
										id="gw" object="bltype" name="gw"
										friendly-name="gw"
										form-name="blForm" validation="required"></selectivity>
						</div>
							<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Notify Telephone No <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigTel1"
								friendly-name="Notify Telephone No" ng-model="blNoData.consigTel1" name="consigTel"
								form-name="blForm" >
						</div><div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Notify Telephone No <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigTel"
								friendly-name="Notify Telephone No" ng-model="blNoData.consigTel" name="consigTel"
								form-name="blForm" >
						</div>
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Notify Email <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							 <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigEmail1"
								friendly-name="Notify Email" ng-model="blNoData.consigEmail1" name="consigEmail"
								form-name="blForm" >
						</div>
						<div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Notify Email <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							 <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigEmail"
								friendly-name="Notify Email" ng-model="blNoData.consigEmail" name="consigEmail"
								form-name="blForm" >
						</div>
						</div>
						
						
						
						
						 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						<div class="col-md-4">
							<label class="control-label">Consignee Name <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> 
							<!-- <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigName"
								friendly-name="Consignee Name" ng-model="blNoData.consigName" name="consigName"
								form-name="blForm" validation="required"> -->
								<selectivity list="customerList" property="blNoData.consigCustName"
								id="consigCustName" ng-model="blNoData.consigCustName" name="consigCustName"
								friendly-name="consigCustName" form-name="blForm" validation="required"></selectivity>
								 <!-- <input class="form-control" type="text" placeholder="" class="form-control input-sm" id="consigName"
								friendly-name="Consignee Name" ng-model="blNoData.consigName" name="consigName" form-name="blForm" 
								typeahead="ac.text as ac.text for ac in consigneeList| filter:$viewValue |limitTo:50 "
							    typeahead-min-length='1'
								typeahead-input-formatter="fetchSelectedConsigneeName($model,blNoData)"
								validation="required" > -->
						</div>
				<!-- 			<div class="col-md-4">
							<label class="control-label">Customer Name <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigCustName"
								friendly-name="Customer Name" ng-model="blNoData.consigCustName" name="consigCustName"
								form-name="blForm">
						</div> -->
						<div class="col-md-4">
							<label class="control-label">Tax Number (GST / VAT ) <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigTaxNumber"
								friendly-name="Tax Number" ng-model="blNoData.consigTaxNumber" name="consigTaxNumber"
								form-name="blForm" >
						</div>
						
							<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Country <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigCountry1"
								friendly-name="Country" ng-model="blNoData.consigCountry1" name="consigCountry"
								form-name="blForm" validation="required">
						</div>
						<div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Country <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="consigCountry"
								friendly-name="Country" ng-model="blNoData.consigCountry" name="consigCountry"
								form-name="blForm" validation="required">
						</div>
		
						</div>
						
						 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						
							
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Address <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> 
							<textarea class="form-control" type="text" name="consigAddress1"
											id="consigAddress1" ng-model="blNoData.consigAddress1"
											placeholder="consignee Address" validation="required">
                            </textarea>
						</div>
						<div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Address <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> 
							<textarea class="form-control" type="text" name="consigAddress"
											id="consigAddress" ng-model="blNoData.consigAddress"
											placeholder="consignee Address" validation="required">
                            </textarea>
						</div>
					<div class="col-md-4">
							<label class="control-label">HS Code <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							<input class="form-control"
								type="text" placeholder="" class="form-control" id="hsCode"
								friendly-name="HS Code" ng-model="blNoData.hsCode" name="hsCode"
								form-name="blForm" >
								
						</div>
						<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						<div class="col-md-4">
							<label class="control-label">Shipper's Name  <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							
								
								 <!-- <input class="form-control" type="text" placeholder="" class="form-control input-sm" id="shipperName"
								friendly-name="Shipper Name" ng-model="blNoData.shipperName" name="shipperName" form-name="blForm" 
								typeahead="ac.text as ac.text for ac in shipperList| filter:$viewValue |limitTo:50 "
							    typeahead-min-length='1'
								typeahead-input-formatter="fetchSelectedShipperName($model,blNoData)"
								> -->
								<selectivity list="customerList" property="blNoData.shipperName"
								id="shipperName" ng-model="blNoData.shipperName" name="shipperName"
								friendly-name="shipperName" form-name="blForm" validation="required"></selectivity>
						</div>
						</div>
						
						
						 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						 <div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Shipper's Address <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							
								<textarea class="form-control" type="text" name="shipperAddress1"
											id="shipperAddress1" ng-model="blNoData.shipperAddress1"
											placeholder="Shipper Address">
                            </textarea>
						</div>
						<div class="col-md-4" ng-if="isEdit!=true" >
							<label class="control-label">Shipper's Address <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							
								<textarea class="form-control" type="text" name="shipperAddress"
											id="shipperAddress" ng-model="blNoData.shipperAddress"
											placeholder="Shipper Address">
                            </textarea>
						</div>
						
						
						<div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Shipper's Telephone No <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="shipperTel1"
								friendly-name="Shipper Telephone No" ng-model="blNoData.shipperTel1" name="shipperTel1"
								form-name="blForm" >
						</div>
						<div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Shipper's Telephone No <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="shipperTel"
								friendly-name="Shipper Telephone No" ng-model="blNoData.shipperTel" name="shipperTel"
								form-name="blForm" >
						</div>
						
						 <div class="col-md-4" ng-if="isEdit">
							<label class="control-label">Shipper's Email <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							 <input class="form-control"
								type="text" placeholder="" class="form-control" id="shipperEmail1"
								friendly-name="Shipper Email1" ng-model="blNoData.shipperEmail1" name="shipperEmail1"
								form-name="blForm" >
						</div>
						 <div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Shipper's Email <span style="color: red;"></span><span style="color: #23b7e5;padding-left: 95px;"></span></label>
							 <input class="form-control"
								type="text" placeholder="" class="form-control" id="shipperEmail"
								friendly-name="Shipper Email" ng-model="blNoData.shipperEmail" name="shipperEmail"
								form-name="blForm" >
						</div>
						 
						 
						 </div>
					
					
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					<div class="col-md-4" ng-if="isEdit">
							<label class="control-label" >Shipper's Country <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="shipperCountry1"
								friendly-name="Shipper Country" ng-model="blNoData.shipperCountry1" name="shipperCountry1"
								form-name="blForm">
						</div>
						<div class="col-md-4" ng-if="isEdit!=true">
							<label class="control-label">Shipper's Country <span style="color: red;">*</span><span style="color: #23b7e5;padding-left: 95px;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="shipperCountry"
								friendly-name="Shipper Country" ng-model="blNoData.shipperCountry" name="shipperCountry"
								form-name="blForm">
						</div>
					</div>
					
						
							<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
					
					
						</div> -->
						
						
						</div>
				<br> <br>
				<%-- <div class="col-md-12"
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

									<!-- <div class="col-md-6">
										<label class="control-label">Shippers<span
							style="color: red;">*</span></label>

										<selectivity list="customerList" property="blNoData.shipperId"
											id="shipperId" ng-model="blNoData.shipperId" name="shipperId"
											form-name="blForm" validation="required" friendly-name="Shippers"></selectivity>
									</div>

									<div class="col-md-6">
										<label class="control-label">Cnee<span
							style="color: red;">*</span></label>
										<selectivity list="customerList" property="blNoData.cneeId"
											id="cneeId" ng-model="blNoData.cneeId" name="cneeId"
											form-name="blForm" validation="required" friendly-name="Cnee"></selectivity>

									</div> -->

									<div class="col-md-6">
										<label class="control-label">Shippers Dtls <span style="color: #23b7e5;padding-left: 95px;"></span></label>
										<textarea class="form-control" type="text" name="shipper"
											id="shipper" ng-model="blNoData.shipper"
											placeholder="Shippers">
                            </textarea>

									</div>

									<div class="col-md-6">
										<label class="control-label">Cnee Dtls <span style="color: #23b7e5;padding-left: 95px;"></span></label>
										<textarea class="form-control" type="text" name="cnee"
											id="cnee" ng-model="blNoData.cnee" placeholder="Cnee">
                            </textarea>

									</div>

									<!-- <div class="col-md-6">
										<label class="control-label">Notify1</label>
										<selectivity list="customerList" property="blNoData.notify1Id"
											id="notify1Id" ng-model="blNoData.notify1Id" name="notify1Id"
											form-name="blForm"></selectivity>

									</div> -->
									<!-- <div class="col-md-6">
										<label class="control-label">Notify2</label>
										<selectivity list="customerList" property="blNoData.notify2Id"
											id="notify2Id" ng-model="blNoData.notify2Id" name="notify2Id"
											form-name="blForm"></selectivity>
									</div> -->

									<div class="col-md-6">
										<label class="control-label">Notify1 Dtls <span style="color: #23b7e5;padding-left: 95px;"></span></label>
										<textarea class="form-control" type="text" name="notify1"
											id="notify1" ng-model="blNoData.notify1"
											placeholder="Notify1">
                            </textarea>

									</div>
									<div class="col-md-6">
										<label class="control-label">Notify2 Dtls <span style="color: #23b7e5;padding-left: 95px;"></span></label>
										<textarea class="form-control" type="text" name="notify2"
											id="notify2" ng-model="blNoData.notify2"
											placeholder="Notify2">
                            </textarea>

									</div>
									<!-- <div class="col-md-6">
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
											placeholder="Forwarder">
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
					</tab> <tab heading="Goods" style="background:#5F9EA0		">
					<div class="panel-body">

						<div class="row">
							<div class="col-md-12">
								<label class="control-label">Main Commodity <span style="color: #23b7e5;padding-left: 95px;"></span></label> <input
									class="form-control" type="text" name="maincom" id="maincom"
									ng-model="blNoData.maincom" placeholder="Main Com">

							</div>

							<!--  <div class="col-md-2">
              <label class="control-label">T.WGT</label>
              <input class="form-control" type="text" name="t_wgt" id="t_wgt" ng-model="blNoData.t_wgt"  placeholder="T.WGT" validation="numeric">

            </div> -->

							<div class="col-md-2">
								<label class="control-label">NO OF PKGS <span style="color: #23b7e5;padding-left: 95px;"></span></label> <input
									class="form-control" type="number" name="pkgs" id="pkgs"
									ng-model="blNoData.pkgs" placeholder="PKGS"
									validation="numeric" >

							</div>

							<div class="col-md-2">
								<label class="control-label">N.WGT</label> <input
									class="form-control" type="number" name="n_wgt" id="n_wgt"
									ng-model="blNoData.n_wgt" placeholder="N.WGT"
									validation="numeric" >
					   
							</div>
							
                              <div class="col-md-3" style="padding-top: 30px;">
							<label
								  class="i-checks m-b-none">Print N.WGT  
									<input type="checkbox" id="checkNetWgt" name ="checkNetWgt" ng-model="blNoData.checkNetWgt" form-name="blForm"><i style="margin-left: 20px;"></i>
							</label>  
						</div>
							
							<div class="col-md-2">
								<label class="control-label">G.WGT <span style="color: #23b7e5;padding-left: 95px;"></span></label> <input
									class="form-control" type="number" name="g_wgt" id="g_wgt"
									ng-model="blNoData.g_wgt" placeholder="G.WGT"
									validation="numeric" >

							</div> 


							<div class="col-md-2">
								<label class="control-label">CBM <span style="color: #23b7e5;padding-left: 95px;"></span></label> <input
									class="form-control" type="text" name="cbm" id="cbm"
									ng-model="blNoData.cbm" placeholder="CBM" validation="numeric" >

							</div>



							<div class="col-md-6">
								<label class="control-label">Goods <span style="color: #23b7e5;padding-left: 95px;"></span></label>
								<textarea class="form-control" type="text" name="goods"
									id="goods" ng-model="blNoData.goods" placeholder="Goods">
                      </textarea>

							</div>

							<div class="col-md-6">
								<label class="control-label">Marks</label>
								<textarea class="form-control" type="text" name="marks"
									id="marks" ng-model="blNoData.marks" placeholder="Marks">
                      </textarea>

							</div>
						</div>
						<br>

					</div>
					</tab> <tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 150%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_1">select</th>
												<th colspan=1 class="width_7 text-center" >Cntr No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">Type <span
													style="color: red;">*</span></th>
													<th colspan=1 class="width_1 text-center">SOC <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">Seal No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">NW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">GW (KG)<span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">VGM<span
													style="color: red;"></span></th>	
												<th colspan=1 class="width_4 text-center">CBM <span
													style="color: red;"></span></th>
													
												<th colspan=1 class="width_5 text-center">Temperature<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">Vent<span
													style="color: red;"></span></th>	
												<th colspan=1 class="width_5 text-center">Humidity<span
													style="color: red;"></span></th>		
												<th colspan=1 class="width_5 text-center">Celsius / Fahrenheit<span
													style="color: red;"></span></th>	
													
													
												<th colspan=1 class="width_5 text-center">Check Digit <span
													style="color: red;"></span></th>
												<!-- <th colspan=1 class="width_6 text-center">Net <span style="color: red;"></span></th> -->
												<!-- <th colspan=1 class="width_6 text-center">FLE <span style="color: red;"></span></th>
									<th colspan=1 class="width_6 text-center">SOC <span style="color: red;"></span></th> -->
												<th colspan=1 class="width_5 text-center">Package <span
													style="color: red;"></span></th>
													
												<th colspan=1 class="width_5 text-center">No of
													Packages <span style="color: red;">*</span>
												</th>
												<th colspan=1 class="width_8 text-center">Commodity<span style="color: red;">*</span></th>
												<th colspan=1 class="width_1 text-center">is OOG</th>
												<th colspan=1 class="width_1 text-center">Hazardous</th>
												<th colspan=1 class="width_1 text-center">OWS</th>
												<th colspan=1 class="width_5 text-center">Marks</th>
												<th colspan=1 class="width_5 text-center">UN Code</th>
												<th colspan=1 class="width_5 text-center">IMCO Charge</th>
												<!-- <th colspan=1 class="width_6 text-center">POL Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;">*</span></th> -->
												<th colspan=1 class="width_ text-center">Action</th>

											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList">
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(cntrNo)'}}"
													name="cntrNo{{trIndex}}" id="cntrNo{{trIndex}}"
													ng-model="blcntrDtl.cntrNo" ><!-- <selectivity
														list="containerList" property="blcntrDtl.cntrNo"
														id="cntrNo{{trIndex}}" ng-model="blcntrDtl.cntrNo"
														name="cntrNo{{trIndex}}" form-name="blForm"
														validation="required"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container No)'}}" ></selectivity> -->
													<!-- 				
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No"></selectivity> -->
												</td>
												<td class="text-center"><!-- <input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(type)'}}"
													name="type{{trIndex}}" id="type{{trIndex}}"
													ng-model="blcntrDtl.type" > --><selectivity
														list="containerTypeList" property="blcntrDtl.type"
														id="type{{trIndex}}" name="type{{trIndex}}"
														ng-model="blcntrDtl.type" validation="required"
														validation="required" form-name="blForm"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container Type)'}}"></selectivity>
												</td>
												<td class="text-center">
														<input type="checkbox"
													name="soc" id="soc" ng-model="blcntrDtl.soc"  ><i></i>
												</td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(Seal No)'}}"
													name="sealNo{{trIndex}}" id="sealNo{{trIndex}}"
													ng-model="blcntrDtl.sealNo" placeholder="Seal No"></td>
												<td class="text-center"><input class="form-control"
													type="number" form-name="blForm" friendly-name="tw"
													name="tw{{trIndex}}" id="tw{{trIndex}}"
													ng-model="blcntrDtl.tw" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
												<td class="text-center"><input class="form-control"
													type="number" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(GW)'}}"
													name="gw{{trIndex}}" id="gw{{trIndex}}"
													ng-model="blcntrDtl.gw" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
													
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" 
													friendly-name="{{ 'Row' + (trIndex+1) + '(VGM)'}}"
													name="vgm{{trIndex}}" id="vgm{{trIndex}}"
													ng-model="blcntrDtl.vgm"></td>	
													
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="cb"
													name="cb{{trIndex}}" id="cb{{trIndex}}"
													ng-model="blcntrDtl.cb" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
													
													
													<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="temperature" name="temperature{{trIndex}}"
													id="temperature{{trIndex}}" ng-model="blcntrDtl.temperature" placeholder="Temperature"
													></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="vent" name="vent{{trIndex}}"
													id="vent{{trIndex}}" ng-model="blcntrDtl.vent" placeholder="Vent"
													></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="humidity" name="humidity{{trIndex}}"
													id="humidity{{trIndex}}" ng-model="blcntrDtl.humidity" placeholder="Humidity"
													></td>	
													
													
													<td class="text-center">
												<selectivity list="celfahList"
														property="blcntrDtl.celfah" id="celfah"
														ng-model="blcntrDtl.celfah" name="celfah"
														form-name="blForm" friendly-name="Celsius / Fahrenheit"
														friendly-name="Celsius / Fahrenheit"></selectivity>
												
												</td>			
													
												<td class="text-center"><input class="form-control"
													type="text" name="checkdigit" form-name="blForm"
													id="checkdigit{{trIndex}}" ng-model="blcntrDtl.checkdigit"></td>
												<!--<td class="text-center"><input class="form-control" type="text" name="net" form-name="blForm"    id="net{{trIndex}}" ng-model="blcntrDtl.net"  ></td>
									 <td class="text-center">
									 <selectivity list="fleList" property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity>
									 </td>
									<td class="text-center">
									   <selectivity list="socList" property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td> -->
												<td class="text-center"><selectivity list="packageList"
														property="blcntrDtl.packageType"
														id="packageType{{trIndex}}"
														ng-model="blcntrDtl.packageType" name="packageType"
														form-name="blForm" friendly-name="Package Type"
														friendly-name="Package Type"></selectivity></td>
												<td class="text-center"><input class="form-control"
													type="number" name="noo{{trIndex}}" id="noo{{trIndex}}"
													ng-model="blcntrDtl.noOfPckgs" validation="required"
													form-name="blForm"
													friendly-name="{{ 'Row' + (trIndex+1) + '(No Of Package)'}}"
													placeholder="NoO" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
												<td class="text-center"><input class="form-control"
													type="text" name="g{{trIndex}}" id="g{{trIndex}}"
													ng-model="blcntrDtl.goods" validation="required" friendly-name="{{ 'Row' + (trIndex+1) + '(goods)'}}"></td>
												<td class="text-center"><input type="checkbox"
													name="iso" id="iso{{trIndex}}" ng-model="blcntrDtl.iso" ><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="hazardous" id="hazardous{{trIndex}}" ng-model="blcntrDtl.hazardous" ><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="ows" id="ows{{trIndex}}" ng-model="blcntrDtl.ows" ><i></i>
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
												<!-- <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.polTer" id="polTer" ng-model="blcntrDtl.polTer"
          form-name="blForm" validation="required" friendly-name="POL Term"     name="polTer"   ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.podTer" id="podTer" ng-model="blcntrDtl.podTer"
         form-name="blForm" validation="required" friendly-name="POD Term"      name="podTer"   ></selectivity>	</td> -->
												<td class="text-center">
													<button ng-click="addinnercntrDtl(blcntrDtl)"
														class="btn btn-info" tooltip="Add Row" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</td>
<button ng-click="addRow()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
											</tr>
											<tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light" style="    width: 67% !important;
													">
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
																	form-name="blForm" friendly-name="Terms Of Payment"></selectivity></td>
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
	</tab>  --> <tab heading="BL Charges" style="background:#5F9EA0">
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
													<!-- <th colspan=1 class="width_6 text-center"> From Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> To Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Invoice Amount<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Real Amount<span style="color: red;">*</span></th> -->


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
													<!-- 	<td class="text-center"><selectivity list="portlist" property="blCharge.fromPlace" id="fromPlace" ng-model="blCharge.fromPlace"
               name="fromPlace" form-name="blForm" validation="required"  friendly-name="From Place"  ></td>
									<td class="text-center"><selectivity list="portlist" property="blCharge.toPlace" id="toPlace" ng-model="blCharge.toPlace"
               name="toPlace" form-name="blForm" form-name="blForm" validation="required"  friendly-name="To Place" ></td>
										 <td class="text-center"><input class="form-control" type="text" name="invAmount" id="invAmount" ng-model="blCharge.invAmount"  form-name="blForm" validation="required"  friendly-name="Invoice Amount" ></td>
 									<td class="text-center"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blCharge.realAmount" form-name="blForm" validation="required"  friendly-name="Real Amount"></td>
									  -->


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
					</tab> 
					
					
						<tab heading="BL Log History" style="background:#5F9EA0" ng-if="isEdit">
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
										     <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer> 
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
					
					
					<tab heading="Destination Charges" style="background:#5F9EA0" ng-if="isEdit">
					  <div class="col-md-12" style="margin-top: 15px;">
									<div class="col-md-6" style="margin-top: 10px;margin-bottom: 10px;"><span style="font-weight: bold;">Freight Terms : </span> {{paymentTerms}}</div>
									<div class="col-md-6" style="margin-top: 10px;margin-bottom: 10px;"><span style="font-weight: bold;">Destination Charges : </span> {{destinationCharge}}</div>
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
										      <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer> 
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
					
					
					<tab heading="BL Attachments" style="background:#5F9EA0" ng-if="isEdit">
						<div class="col-md-12" style="margin-top: 2%;" >
					<div class="col-md-4">
										<label class="control-label">RRR Dual Approval <span
											style="color: red;"></span></label>
										<input type="file" class="form-control" name="rateDeviationApprovalDoc" 
													id="rateDeviationApprovalDoc" friendly-name="rateDeviationApprovalDoc" data-ng-model="blNoData.rateDeviationApprovalDoc"
													onchange="angular.element(this).scope().uploadFile(this)"
													multiple />
									</div>
									<div class= "col-md-1" style="    margin-top: 25px;">
												<button class="btn btn-primary" type="button"
													ng-click="addRateDeviationFile()">Add</button>
									</div>
										<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in rateDeviationFiles">
											<a id="rateDeviationBill{{tIndex}}" style="display: none"
											href="{{filelist.filePath}}"
											download="{{filelist.filename}}"></a>
										<div ng-if="isEdit" style="margin-left: -30px;    margin-top: 15px;">
											{{tIndex+1}} ) <a ng-click="downloadRateDeviationFile(tIndex)"
												style="color: green">{{filelist.filename}}</a>
												<button class="btn btn-default input-sm" type="button"
												ng-click="deleteRateDeviationfiles(filelist.filename)"
												data-toggle="tooltip" title="Delete file">
												<i class="fa fa-trash"></i>
											</button>
										</div>
			
										<div ng-if="!isEdit" style="">
											{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
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
										       <th class="sorting width_10" st-sort="date">File</th>
										       <th class="sorting width_10" st-sort="function">Function</th>
										      <th class="sorting width_10" st-sort="action">Action</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(tIndex, blAttachFiles) in blAttach">
										       <td>{{blAttachFiles.fileName}}</td>
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
										     <footer class="panel-footer">
										 				<%@include file="/views/templates/panel-footer-static.jsp"%>
										    </footer> 
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
					
					
					
					
					</tabset>
					<br>
					<center><span ng-show ="isPrintLimitExceed == true" style="color: red;">NOTE: BL print count limit exceeded. Data cannot be modified!!!</span></center>
				</div> --%>
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

									<!-- <div class="col-md-6">
										<label class="control-label">Shippers<span
							style="color: red;">*</span></label>

										<selectivity list="customerList" property="blNoData.shipperId"
											id="shipperId" ng-model="blNoData.shipperId" name="shipperId"
											form-name="blForm" validation="required" friendly-name="Shippers"></selectivity>
									</div>

									<div class="col-md-6">
										<label class="control-label">Cnee<span
							style="color: red;">*</span></label>
										<selectivity list="customerList" property="blNoData.cneeId"
											id="cneeId" ng-model="blNoData.cneeId" name="cneeId"
											form-name="blForm" validation="required" friendly-name="Cnee"></selectivity>

									</div> -->

									<div class="col-md-6">
										<label class="control-label">Shippers Dtls <span style="color: #23b7e5;padding-left: 95px;">(1)</span></label>
										<textarea class="form-control" type="text" name="shipper"
											id="shipper" ng-model="blNoData.shipper"
											placeholder="Shippers">
                            </textarea>

									</div>

									<div class="col-md-6">
										<label class="control-label">Cnee Dtls <span style="color: #23b7e5;padding-left: 95px;">(3)</span></label>
										<textarea class="form-control" type="text" name="cnee"
											id="cnee" ng-model="blNoData.cnee" placeholder="Cnee">
                            </textarea>

									</div>

									<!-- <div class="col-md-6">
										<label class="control-label">Notify1</label>
										<selectivity list="customerList" property="blNoData.notify1Id"
											id="notify1Id" ng-model="blNoData.notify1Id" name="notify1Id"
											form-name="blForm"></selectivity>

									</div> -->
									<!-- <div class="col-md-6">
										<label class="control-label">Notify2</label>
										<selectivity list="customerList" property="blNoData.notify2Id"
											id="notify2Id" ng-model="blNoData.notify2Id" name="notify2Id"
											form-name="blForm"></selectivity>
									</div> -->

									<div class="col-md-6">
										<label class="control-label">Notify1 Dtls <span style="color: #23b7e5;padding-left: 95px;">(5)</span></label>
										<textarea class="form-control" type="text" name="notify1"
											id="notify1" ng-model="blNoData.notify1"
											placeholder="Notify1">
                            </textarea>

									</div>
									<div class="col-md-6">
										<label class="control-label">Notify2 Dtls <span style="color: #23b7e5;padding-left: 95px;">(6)</span></label>
										<textarea class="form-control" type="text" name="notify2"
											id="notify2" ng-model="blNoData.notify2"
											placeholder="Notify2">
                            </textarea>

									</div>
									<!-- <div class="col-md-6">
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
											placeholder="Forwarder">
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
					</tab>  <tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 150%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_1">select</th>
												<th colspan=1 class="width_7 text-center" >Cntr No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">Type <span
													style="color: red;">*</span></th>
													<th colspan=1 class="width_1 text-center">SOC <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">Seal No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">NW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">GW (KG)<span
													style="color: red;">*</span></th>
													<th colspan=1 class="width_5 text-center">No of
													Packages <span style="color: red;">*</span>
												</th>
												<th colspan=1 class="width_5 text-center">Package <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_8 text-center">Commodity<span style="color: red;">*</span></th>
												
												<th colspan=1 class="width_5 text-center">VGM<span
													style="color: red;"></span></th>	
												<th colspan=1 class="width_4 text-center">CBM <span
													style="color: red;"></span></th>
													
												<th colspan=1 class="width_5 text-center">Temperature<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_5 text-center">Vent<span
													style="color: red;"></span></th>	
												<th colspan=1 class="width_5 text-center">Humidity<span
													style="color: red;"></span></th>		
												<th colspan=1 class="width_5 text-center">Celsius / Fahrenheit<span
													style="color: red;"></span></th>	
													
													
												<th colspan=1 class="width_5 text-center">Check Digit <span
													style="color: red;"></span></th>
												<!-- <th colspan=1 class="width_6 text-center">Net <span style="color: red;"></span></th> -->
												<!-- <th colspan=1 class="width_6 text-center">FLE <span style="color: red;"></span></th>
									<th colspan=1 class="width_6 text-center">SOC <span style="color: red;"></span></th> -->
												
													
												<th colspan=1 class="width_1 text-center">is OOG</th>
												<th colspan=1 class="width_1 text-center">Hazardous</th>
												<th colspan=1 class="width_1 text-center">OWS</th>
												<th colspan=1 class="width_5 text-center">Marks</th>
												<th colspan=1 class="width_5 text-center">UN Code</th>
												<th colspan=1 class="width_5 text-center">IMCO Charge</th>
												<!-- <th colspan=1 class="width_6 text-center">POL Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;">*</span></th> -->
												<th colspan=1 class="width_ text-center">Action</th>

											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList">
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
												<td class="text-center"><input class="form-control input-sm"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(cntrNo)'}}"
													name="cntrNo{{trIndex}}" id="cntrNo{{trIndex}}" data-ng-blur="validateContainer(blcntrDtl.cntrNo,trIndex)"
													ng-model="blcntrDtl.cntrNo"  maxlength="11" ><!-- <selectivity
														list="containerList" property="blcntrDtl.cntrNo"
														id="cntrNo{{trIndex}}" ng-model="blcntrDtl.cntrNo"
														name="cntrNo{{trIndex}}" form-name="blForm"
														validation="required"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container No)'}}" ></selectivity> -->
													<!-- 				
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No"></selectivity> -->
												</td>
												<td class="text-center"><!-- <input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(type)'}}"
													name="type{{trIndex}}" id="type{{trIndex}}"
													ng-model="blcntrDtl.type" > --><selectivity
														list="containerTypeList" property="blcntrDtl.type"
														id="type{{trIndex}}" name="type{{trIndex}}"
														ng-model="blcntrDtl.type" validation="required"
														validation="required" form-name="blForm"
														friendly-name="{{ 'Row' + (trIndex+1) + '(Container Type)'}}"></selectivity>
												</td>
												<td class="text-center">
														<input type="checkbox"
													name="soc" id="soc" ng-model="blcntrDtl.soc"  ><i></i>
												</td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(Seal No)'}}"
													name="sealNo{{trIndex}}" id="sealNo{{trIndex}}"
													ng-model="blcntrDtl.sealNo" placeholder="Seal No"></td>
												<td class="text-center"><input class="form-control"
													type="number" form-name="blForm" friendly-name="tw"
													name="tw{{trIndex}}" id="tw{{trIndex}}"
													ng-model="blcntrDtl.tw" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
												<td class="text-center"><input class="form-control"
													type="number" form-name="blForm" validation="required"
													friendly-name="{{ 'Row' + (trIndex+1) + '(GW)'}}"
													name="gw{{trIndex}}" id="gw{{trIndex}}"
													ng-model="blcntrDtl.gw" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
												<td class="text-center"><input class="form-control"
													type="number" name="noo{{trIndex}}" id="noo{{trIndex}}"
													ng-model="blcntrDtl.noOfPckgs" validation="required"
													form-name="blForm"
													friendly-name="{{ 'Row' + (trIndex+1) + '(No Of Package)'}}"
													placeholder="NoO" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
												<td class="text-center"><selectivity list="packageList"
														property="blcntrDtl.packageType"
														id="packageType{{trIndex}}"
														ng-model="blcntrDtl.packageType" name="packageType"
														form-name="blForm" friendly-name="Package Type"
														friendly-name="Package Type"></selectivity></td>
												<!-- <td class="text-center"><input class="form-control"
													type="text" name="g{{trIndex}}" id="g{{trIndex}}"
													ng-model="blcntrDtl.goods" validation="required" friendly-name="{{ 'Row' + (trIndex+1) + '(goods)'}}"></td>
												 -->
												 <td class="text-center">	<selectivity
														list="commodityList" property="blcntrDtl.goods"
														id="goods" ng-model="blcntrDtl.goods" name="goods"
														form-name="blForm" validation="required" 
														friendly-name="goods"></selectivity></td>	
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" 
													friendly-name="{{ 'Row' + (trIndex+1) + '(VGM)'}}"
													name="vgm{{trIndex}}" id="vgm{{trIndex}}"
													ng-model="blcntrDtl.vgm"></td>	
													
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="cb"
													name="cb{{trIndex}}" id="cb{{trIndex}}"
													ng-model="blcntrDtl.cb" data-ng-change="calcWeight(blcntrDtl,$index)"></td>
													
													
													<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="temperature" name="temperature{{trIndex}}"
													id="temperature{{trIndex}}" ng-model="blcntrDtl.temperature" placeholder="Temperature"
													></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="vent" name="vent{{trIndex}}"
													id="vent{{trIndex}}" ng-model="blcntrDtl.vent" placeholder="Vent"
													></td>
												<td class="text-center"><input class="form-control"
													type="text" form-name="blForm" friendly-name="humidity" name="humidity{{trIndex}}"
													id="humidity{{trIndex}}" ng-model="blcntrDtl.humidity" placeholder="Humidity"
													></td>	
													
													
													<td class="text-center">
												<selectivity list="celfahList"
														property="blcntrDtl.celfah" id="celfah"
														ng-model="blcntrDtl.celfah" name="celfah"
														form-name="blForm" friendly-name="Celsius / Fahrenheit"
														friendly-name="Celsius / Fahrenheit"></selectivity>
												
												</td>			
													
												<td class="text-center"><input class="form-control"
													type="text" name="checkdigit" form-name="blForm"
													id="checkdigit{{trIndex}}" ng-model="blcntrDtl.checkdigit"></td>
												<!--<td class="text-center"><input class="form-control" type="text" name="net" form-name="blForm"    id="net{{trIndex}}" ng-model="blcntrDtl.net"  ></td>
									 <td class="text-center">
									 <selectivity list="fleList" property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity>
									 </td>
									<td class="text-center">
									   <selectivity list="socList" property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td> -->
												
												<td class="text-center"><input type="checkbox"
													name="iso" id="iso{{trIndex}}" ng-model="blcntrDtl.iso" ><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="hazardous" id="hazardous{{trIndex}}" ng-model="blcntrDtl.hazardous" ><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="ows" id="ows{{trIndex}}" ng-model="blcntrDtl.ows" ><i></i>
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
												<!-- <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.polTer" id="polTer" ng-model="blcntrDtl.polTer"
          form-name="blForm" validation="required" friendly-name="POL Term"     name="polTer"   ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.podTer" id="podTer" ng-model="blcntrDtl.podTer"
         form-name="blForm" validation="required" friendly-name="POD Term"      name="podTer"   ></selectivity>	</td> -->
												<td class="text-center">
													<button ng-click="addinnercntrDtl(blcntrDtl)"
														class="btn btn-info" tooltip="Add Row" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</td>
<button ng-click="addRow()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
											</tr>
											<tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light" style="    width: 67% !important;
													">
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
																	form-name="blForm" friendly-name="Terms Of Payment"></selectivity></td>
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
					</tab><tab heading="Goods" style="background:#5F9EA0		">
					<div class="panel-body">

						<div class="row">
							<div class="col-md-12">
								<label class="control-label">Main Commodity <span style="color: #23b7e5;padding-left: 95px;">(16)</span></label> <input
									class="form-control" type="text" name="maincom" id="maincom"
									ng-model="blNoData.maincom" placeholder="Main Com">

							</div>

							<!--  <div class="col-md-2">
              <label class="control-label">T.WGT</label>
              <input class="form-control" type="text" name="t_wgt" id="t_wgt" ng-model="blNoData.t_wgt"  placeholder="T.WGT" validation="numeric">

            </div> -->

							<div class="col-md-2">
								<label class="control-label">NO OF PKGS <span style="color: #23b7e5;padding-left: 95px;">(15)</span></label> <input
									class="form-control" type="number" name="pkgs" id="pkgs"
									ng-model="blNoData.pkgs" placeholder="PKGS"
									validation="numeric" disabled="true">

							</div>

							<div class="col-md-2">
								<label class="control-label">N.WGT</label> <input
									class="form-control" type="number" name="n_wgt" id="n_wgt"
									ng-model="blNoData.n_wgt" placeholder="N.WGT"
									validation="numeric" disabled="true">
					   
							</div>
							
                              <div class="col-md-3" style="padding-top: 30px;">
							<label
								  class="i-checks m-b-none">Print N.WGT  
									<input type="checkbox" id="checkNetWgt" name ="checkNetWgt" ng-model="blNoData.checkNetWgt" form-name="blForm"><i style="margin-left: 20px;"></i>
							</label>  
						</div>
							
							<div class="col-md-2">
								<label class="control-label">G.WGT <span style="color: #23b7e5;padding-left: 95px;">(17)</span></label> <input
									class="form-control" type="number" name="g_wgt" id="g_wgt"
									ng-model="blNoData.g_wgt" placeholder="G.WGT"
									validation="numeric" disabled="true">

							</div> 


							<div class="col-md-2">
								<label class="control-label">CBM <span style="color: #23b7e5;padding-left: 95px;">(18)</span></label> <input
									class="form-control" type="text" name="cbm" id="cbm"
									ng-model="blNoData.cbm" placeholder="CBM" validation="numeric" disabled="true">

							</div>



							<div class="col-md-6">
								<label class="control-label">Goods <span style="color: #23b7e5;padding-left: 95px;">(16)</span></label>
								<textarea class="form-control" type="text" name="goods"
									id="goods" ng-model="blNoData.goods" placeholder="Goods">
                      </textarea>

							</div>

							<div class="col-md-6">
								<label class="control-label">Marks</label>
								<textarea class="form-control" type="text" name="marks"
									id="marks" ng-model="blNoData.marks" placeholder="Marks">
                      </textarea>

							</div>
						</div>
						<br>

					</div>
					</tab>
					<!-- <tab heading="Package" style="background:#5F9EA0">
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
	</tab>  --> <tab heading="BL Charges" style="background:#5F9EA0" >
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
													<th colspan=1 class="width_6 text-center" >Charges Code<span
														style="color: red;">*</span>
													</th>
													<th colspan=1 class="width_6 text-center" >Currency <span
														style="color: red;">*</span></th>
													<th colspan=1 class="width_6 text-center" >Qty <span
														style="color: red;">*</span></th>
													<th colspan=1 class="width_4 text-center" >Rate<span
														style="color: red;">*</span>
													</th>
													<th colspan=1 class="width_4 text-center" >Amount<span
														style="color: red;">*</span>
													</th>
													<th colspan=1 class="width_6 text-center" >PayAt <span
														style="color: red;"></span></th>
													<th colspan=1 class="width_6 text-center" >Terms<span
														style="color: red;"></span>
													</th>
													<!-- <th colspan=1 class="width_6 text-center"> From Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> To Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Invoice Amount<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Real Amount<span style="color: red;">*</span></th> -->


												</tr>
											</thead>
											<tbody ng-repeat="(trIndex1, blCharge) in blNoData.blCharges" ng-controller="chargeableCtrl">
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
													<!-- 	<td class="text-center"><selectivity list="portlist" property="blCharge.fromPlace" id="fromPlace" ng-model="blCharge.fromPlace"
               name="fromPlace" form-name="blForm" validation="required"  friendly-name="From Place"  ></td>
									<td class="text-center"><selectivity list="portlist" property="blCharge.toPlace" id="toPlace" ng-model="blCharge.toPlace"
               name="toPlace" form-name="blForm" form-name="blForm" validation="required"  friendly-name="To Place" ></td>
										 <td class="text-center"><input class="form-control" type="text" name="invAmount" id="invAmount" ng-model="blCharge.invAmount"  form-name="blForm" validation="required"  friendly-name="Invoice Amount" ></td>
 									<td class="text-center"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blCharge.realAmount" form-name="blForm" validation="required"  friendly-name="Real Amount"></td>
									  -->


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
					</tab> 
					
					
						<tab heading="BL Log History" style="background:#5F9EA0" ng-if="isEdit">
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
										       <td ng-if="blLogHistoryItem.actionType=='UPDATE' || blLogHistoryItem.actionType=='ROLL-OVER'">{{blLogHistoryItem.logDetailDescription}}</td>
										        <!-- <td ng-if="blLogHistoryItem.actionType!='UPDATE' || blLogHistoryItem.actionType !='ROLL-OVER'"></td> -->
										      			
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
					
					
					<tab heading="Rate" style="background:#5F9EA0" ng-if="isEdit">
					 <!--  <div class="col-md-12" style="margin-top: 15px;">
									<div class="col-md-6" style="margin-top: 10px;margin-bottom: 10px;"><span style="font-weight: bold;">Freight Terms : </span> {{paymentTerms}}</div>
									<div class="col-md-6" style="margin-top: 10px;margin-bottom: 10px;"><span style="font-weight: bold;">Destination Charges : </span> {{destinationCharge}}</div>
									</div>
						 -->
						<div class="tableFixHead"  st-table="displayedCollection" st-safe-src="rowCollection">
					<div class="col-md-12">
						<table class="table-tab" style="width: 100%;">
							<thead >

								
								<tr >
								
									
									<th colspan="1" class="text-center" ></th>
									<th colspan="1" class="text-center"  style="color: white;">BL No</th>
									
									<th colspan="3" class="text-center"  style="color: white;background-color: {{booking.color}} !important">
									<a ng-click="viewBL(blNo)"> 
									<span tooltip="{{blNo}}"class="tool-tip-span font-blue" style="color: white;">{{blNo}}</span></a></th>
									
									
								   <th colspan="2" class="text-center"  style="color: white;">RRR No</th>
									<th colspan="1" class="text-center"  style="color: white; background-color: {{booking.color}} !important">
									<a ng-click="viewQuotation(quotationNo)"> 
									<span tooltip="{{quotationNo}}"class="tool-tip-span font-blue" style="color: white;">{{quotationNo}}</span></a></th>
									
								
									<th colspan="1" class="text-center"  style="color: white;">Date of Sailing</th>
									<th colspan="3" class="text-center"  style="color: white;">{{sailingDate}}</th>
									<th colspan="1" class="text-center"  style="color: white;">Discharge Date at Final Destination</th>
									<th colspan="2" class="text-center"  style="color: white;">{{dischargeDate}}</th>

								</tr>
																	
								<br>
								<tr>
									
									<th colspan="1" rowspan="2" class="text-center" style="color: white;" >Sl. No</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Invoice #</th>
									
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Receipt #</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Invoice User ID</th>
									
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Receipt User ID</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Kind</th>
									
									<th colspan="1" rowspan="2"  class="text-center"  style="color: white;">Ctr Type</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Rate</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Qty</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">PP / CC</th>
									<th colspan="2"  class="text-center"  style="color: white;">Freight & Local Charges</th>
									
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Curr</th>
									<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Agent/Loc</th>
									
									
							
									
								</tr>
								
									<tr>
									
									
									<th colspan="1" class="text-center"  style="color: white;">Prepaid</th>
									<th colspan="1" class="text-center"  style="color: white;">Collect</th>
									
									
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="blDestinationCharges in bldesChargesList" ng-if="blDestinationCharges.chargeFlag=='PP'">

									<td class="text-center" >{{$index+1}}</td>
									<td class="text-center" >{{blDestinationCharges.invoiceNo}}</td>
									<td class="text-center" >{{blDestinationCharges.receiptNo}}</td>
									<td class="text-center" >{{blDestinationCharges.invoiceUserId}}</td>
									
									<td class="text-center" >{{blDestinationCharges.receiptUserId}}</td>
								    <td class="text-center" >{{blDestinationCharges.chargeName}}</td>
								    <td class="text-center" >{{blDestinationCharges.containerType}}</td>
									<td class="text-center" >{{blDestinationCharges.rate}}</td>
									<td class="text-center" >{{blDestinationCharges.quantity}}</td>
									<td class="text-center" >{{blDestinationCharges.chargeFlag}}</td>					
									<td class="text-center" >{{blDestinationCharges.quantity * blDestinationCharges.rate}}</td>
									<td class="text-center" ></td> 
									<td class="text-center" >{{blDestinationCharges.currency}}</td>
									<td class="text-center" >{{blDestinationCharges.agentLocation}}</td>
								
								</tr>
								
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="blDestinationCharges in bldesChargesList" ng-if="blDestinationCharges.chargeFlag=='CC'">

									<td class="text-center" >{{$index+1}}</td>
									<td class="text-center" >{{blDestinationCharges.invoiceNo}}</td>
									<td class="text-center" >{{blDestinationCharges.receiptNo}}</td>
									<td class="text-center" >{{blDestinationCharges.invoiceUserId}}</td>
									
									<td class="text-center" >{{blDestinationCharges.receiptUserId}}</td>
								    <td class="text-center" >{{blDestinationCharges.chargeName}}</td>
								    <td class="text-center" >{{blDestinationCharges.containerType}}</td>
									<td class="text-center" >{{blDestinationCharges.rate}}</td>
									<td class="text-center" >{{blDestinationCharges.quantity}}</td>
									<td class="text-center" >{{blDestinationCharges.chargeFlag}}</td>					
									<td class="text-center"></td>
									<td class="text-center">{{blDestinationCharges.quantity * blDestinationCharges.rate}}</td> 
									<td class="text-center" >{{blDestinationCharges.currency}}</td>
									<td class="text-center" >{{blDestinationCharges.agentLocation}}</td>
								
								</tr>
								<br>
					
							</tbody>
						</table>
						<tr>
						
						<td class="text-center" ><label style=" margin-top: 18px;margin-left: 57px;"><b>TOTAL</b></label></td>
						<td class="text-center" ><label style=" margin-top: 18px;margin-left: 57px;"><b>PREPAID : </b> </label> NSA</td>
						<td class="text-center" ><label style=" margin-top: 18px;margin-left: 100px;"><b>COLLECT : </b> </label> DXB</td>
					
						
						
						
						</tr>
						
						<div class="col-md-12">
						<div class="col-md-3">
						<table class="table-tab" style="width: 83%;">
							<thead>
								<tr>
								<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Curr</th>
								<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Amount</th>
								</tr>
						
							</thead>
							<tbody class="dataTables-Main-Body">
							
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
									<td class="text-center" >USD</td>
									<td class="text-center" >{{prepaidUSD}}</td>
								
								</tr>
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
									<td class="text-center" >INR</td>
									<td class="text-center" >{{prepaidINR}}</td>
								
								</tr>
								<br>
					
							</tbody>
						</table>
						</div>
						<div class="col-md-6">
						<table class="table-tab" style="width: 40%;">
							<thead>
								<tr>
								<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Curr</th>
								<th colspan="1" rowspan="2" class="text-center"  style="color: white;">Amount</th>
								</tr>
						
							</thead>
							<tbody class="dataTables-Main-Body">
							
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
									<td class="text-center" >AED</td>
									<td class="text-center" >{{collectAED}}</td>
								
								</tr>
								
								
								<br>
					
							</tbody>
						</table>
						</div>
						</div>	
					</div>
				</div>		
					
					</tab>
					
					
					<tab heading="BL Attachments" style="background:#5F9EA0" ng-if="isEdit">
						<div class="col-md-12" style="margin-top: 2%;" >
					<div class="col-md-4">
										<label class="control-label">RRR Dual Approval <span
											style="color: red;"></span></label>
										<input type="file" class="form-control" name="rateDeviationApprovalDoc" 
													id="rateDeviationApprovalDoc" friendly-name="rateDeviationApprovalDoc" data-ng-model="blNoData.rateDeviationApprovalDoc"
													onchange="angular.element(this).scope().uploadFile(this)"
													multiple />
									</div>
									<div class= "col-md-1" style="    margin-top: 25px;">
												<button class="btn btn-primary" type="button"
													ng-click="addRateDeviationFile()">Add</button>
									</div>
										<div  class= "col-md-3" style="" ng-repeat="(tIndex, filelist) in rateDeviationFiles">
											<a id="rateDeviationBill{{tIndex}}" style="display: none"
											href="{{filelist.filePath}}"
											download="{{filelist.filename}}"></a>
										<div ng-if="isEdit" style="margin-left: -30px;    margin-top: 15px;">
											{{tIndex+1}} ) <a ng-click="downloadRateDeviationFile(tIndex)"
												style="color: green">{{filelist.filename}}</a>
												<button class="btn btn-default input-sm" type="button"
												ng-click="deleteRateDeviationfiles(filelist.filename)"
												data-toggle="tooltip" title="Delete file">
												<i class="fa fa-trash"></i>
											</button>
										</div>
			
										<div ng-if="!isEdit" style="">
											{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
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
										       <th class="sorting width_10" st-sort="date">File</th>
										       <th class="sorting width_10" st-sort="function">Function</th>
										      <th class="sorting width_10" st-sort="action">Action</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(tIndex, blAttachFiles) in blAttach">
										       <td>{{blAttachFiles.fileName}}</td>
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
										   <%--   <footer class="panel-footer">
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
					
					
					
			<tab heading="Origin Charges" style="background:#5F9EA0" ng-if="isEdit">
					 
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
										       <th class="sorting width_10" st-sort="invoiceNo">Invoice No</th>
										       <th class="sorting width_10" st-sort="containerNo">Container No</th>
										       <th class="sorting width_10" st-sort="containerTypeName">Container Type</th>
										       <th class="sorting width_10" st-sort="quantity">Qty</th>
										       <th class="sorting width_10" st-sort="currency">Currency</th>
										       <th class="sorting width_10" st-sort="rate">Rate/unit</th>
										       <th class="sorting width_10" st-sort="exchangeRate">Ex.Rt</th>
										        <th class="sorting width_10" st-sort="amount">Amount({{currency}})</th>
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="blfreightInvoiceCharges in freightInvoiceCharges">
										       <td>{{blfreightInvoiceCharges.invoiceNo}}</td>
										        <td>{{blfreightInvoiceCharges.containerNo}}</td>
										         <td>{{blfreightInvoiceCharges.containerTypeName}}</td>
										          <td>{{blfreightInvoiceCharges.quantity}}</td>
										           <td>{{blfreightInvoiceCharges.currency}}</td>
										            <td>{{blfreightInvoiceCharges.rate | number : 2}}</td>
										             <td>{{blfreightInvoiceCharges.exchangeRate | number : 2}}</td>
										              <td>{{blfreightInvoiceCharges.tcAmount | number : 2}}</td>
										       
										      </tr>
										     </tbody>
										    </table>
										     
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
					
					
					
					
					<tab heading="Detention and Demurrage" style="background:#5F9EA0" ng-if="isEdit">
					 
					<div class="col-md-12">
				
						<div class="table-responsive ">
							<div class="panel-body">

								<div class="row" id="items">
								
								 
									<div class="table-responsive clear">
									
									<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection"> 
										<div class="panel-body float-left padding-0" style="width: 100%">
										  <div class="table-responsive" >
										    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red;width: 100% !important;">
										     <thead class="dataTables-Main-Head">
										      <tr>
										       <th class="sorting width_4" st-sort="rate">Invoice No</th>
										       <th class="sorting width_3" st-sort="invoiceNo">Cont Type</th>
										       <th class="sorting width_5" st-sort="containerNo">No. of days on Detention</th>
										       <th class="sorting width_5" st-sort="containerTypeName">No. of containers on detention</th>
										       <th class="sorting width_5" st-sort="quantity">Applicable Detention Tariff </th>
										       <th class="sorting width_4" st-sort="currency">Amount </th>
										      
										     
										      </tr>
										     </thead>
										     <tbody class="dataTables-Main-Body">
										      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="blDetDemCharges in blDetDem">
										       <td>{{blDetDemCharges.detentionCode}}</td>
										        <td>{{blDetDemCharges.containerType}}</td>
										         <td>{{blDetDemCharges.detentionDays}}</td>
										          <td>{{blDetDemCharges.noOfContainer}}</td>
										           <td>{{blDetDemCharges.chargeTypeName}}</td>
										            <td>{{blDetDemCharges.amount}}</td>
										            
										       
										      </tr>
										     </tbody>
										    </table>
										     
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
					
					
					
					
					</tabset>
					<br>
					<center><span ng-show ="isPrintLimitExceed == true" style="color: red;">NOTE: BL print count limit exceeded. Data cannot be modified!!!</span></center>
				</div>

			</div>
			<br> <br>
			<div align="center">
				<div ng-if="!isEdit">
					<button type="button" class="btn btn-success"
						ng-click="saveWithUpload(blForm)">Save</button>
					<button type="reset" class="btn btn-info">Reset</button>
					<button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
				</div>
				<div ng-if="isEdit">
					<button type="button" class="btn btn-success" data-ng-disabled="(isPrintLimitExceed == true || sailing == true)"
						ng-click="updateWithUpload(blForm)" >Update</button>
					<button type="button" class="btn btn-info" ng-click="Reset()">Reset</button>
					<button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
				</div>
				<br>
			</div>

		</form>
	</div>
	</div>
</body>
</html>
