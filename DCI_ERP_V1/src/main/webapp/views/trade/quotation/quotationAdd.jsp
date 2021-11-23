<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div
			style="width: 30%; position: absolute; margin-top: -40px; margin-left: 80%;">
			<label style="color: #e25d5d; float: left;">Quick Links
				&nbsp;&nbsp; </label>
			
			<selectivity style="float: left;" list="qlList"
				ng-init="qlList='Select'" ng-model="qukLinkVal"
				property="qukLinkVal" name="qukLinkVal" friendly-name="qukLinkVal"></selectivity>
		</div>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label" style="padding-top: 10px;">Quotation
									No <span style="color: red">*</span>
								</label>
								<div class="col-md-7" style="padding-top: 15px;">
									<label style="padding-left: 14px;">{{quotation.quotationNo}}</label>
								</div>
							</div>
							

							<div class="form-group " ng-if="!edit">
								<label class="col-md-5 control-label">Customer <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerDropList"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
								<div class="form-group " ng-if="edit">
								<label class="col-md-5 control-label">Customer <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerDropList1"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label"> Customer Category
									<span style="color: blue;"></span>
								</label>
								<div class="col-md-7">
									<!--      <selectivity list="customerCategoryList" property="customer.customer_category" id="customer_category_id"></selectivity> -->
									<selectivity list="CustList" ng-model="quotation.custcategory"
										disabled="true" property="quotation.custcategory"
										id="custcategory" object="custcategory" name="custcategory"
										friendly-name="Customer Category"
										form-name="CustomerMasterForm"></selectivity>
								</div>
							</div>



						
							<div class="form-group ">
								<label class="col-md-5 control-label">Address<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<textarea type="text" class="form-control input-sm"
										name="address" form-name="quotationForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="quotation.address">
															</textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-5 control-label"> Special
									<span style="color: blue;"></span>
								</label>
								<div class="col-md-7">
									<selectivity list="SpecialList" ng-model="quotation.special"
										 property="quotation.special"
										id="special" object="special" name="special"
										friendly-name="special"
										form-name="quotationForm"></selectivity>
								</div>
							</div>

                             <!-- <div class="form-group ">
								<label class="col-md-5 control-label">Special <span
									style="color: red"></span></label>
								<div class="col-md-7">
								
									<selectivity list="SpecialList" ng-model="quotation.special"
										 property="quotation.special"
										id="special" 
										friendly-name="special"
										form-name="quotationForm"></selectivity>
								</div>
							</div> -->
						

						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Quotation Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker data-ng-model="quotation.quotationDate"
										id="quotationDate" name="QuotationDate"
										data-ng-change="checkDatesCL(quotation.quotationDate)"
										friendly-name="Valid From" validation="required" />
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Quote Valid Date<span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker ng-disabled="createQuote"
										data-ng-model="quotation.validTill" id="validTill"
										name="validTill"
										data-ng-change="checkDatesCL(quotation.validTill)"
										friendly-name="Valid From" validation="required" />
								</div>
							</div>

									<div class="form-group ">
								<label class="col-md-5 control-label">Allow Other Port <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="quotation.allowOtherPort" id="allowOtherPort" 
											ng-change="loadAllPorts(quotation.allowOtherPort)">
											<i></i>
									</label>
								</div>
							</div>
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">FPOD <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="portList" property="quotation.pod" id="pod"
										name="pod" ng-model="quotation.pod" object="pod"
										friendly-name="pod" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>

 							<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="cargoType" ng-model="quotation.cargoType"
										 property="quotation.cargoType"
										id="cargoType" 
										friendly-name="cargoType"
										form-name="quotationForm"></selectivity>
								</div>
							</div> 
							<div class="form-group " ng-hide ="true";>
								<label class="col-md-5 control-label"> Detention Tariff Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="tariffList" ng-model="quotation.detentionTariffType"
										 property="quotation.detentionTariffType"
										id="detentionTariffType" 
										friendly-name="detentionTariffType"
										form-name="quotationForm" ></selectivity>
								</div>
							</div> 


<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<textarea type="text" class="form-control input-sm"
										name="cargoType" form-name="quotationForm"
										class="custom-scroll width_250 resize-none" rows="3" disabled="true"
										ng-model="quotation.cargoType">
															</textarea>
								</div>
							</div> -->
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
							<div class="form-group ">
								<label class="col-md-5 control-label">Currency<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="currencyList"
										property="quotation.currencyName" id="currencyName"
										name="currencyName" ng-model="quotation.currencyName"
										object="currencyName" friendly-name="currencyName"
										validation="required" form-name="quotationForm"></selectivity>
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-5 control-label">Freight Terms<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="shipmentTermlist"
										property="quotation.freight" id="freight" name="freight"
										ng-model="quotation.freight" object="freight"
										friendly-name="freight" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">POL <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="polList" property="quotation.pol" id="pol"
										name="pol" ng-model="quotation.pol" object="pol"
										friendly-name="pol" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Other Charges<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="shipmentTermlist"
										property="quotation.otCharge" id="otCharge" name="otCharge"
										ng-model="quotation.otCharge" object="otCharge"
										friendly-name="otCharge" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">SOC<span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="quotation.soc" id="soc" 
											ng-change="loadAllPorts(quotation.soc)">
											<i></i>
									</label>
								</div>
							</div>
						
							<div class="form-group" ng-if="edit">

								<label class="col-md-5 control-label">Status <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="status"
										property="quotation.status" id="origin"
										ng-model="quotation.status" friendly-name="status"
										disabled="true" />
								</div>

							</div>



						</fieldset>
					</div>


				</div>

				<br>
				<div>
					<tabset justified="true" class="tab-container"> <tab
						heading="Freight Charges & Local Charges"
						style="background:#5F9EA0;  ">
					<div>
						<table class="table table-striped b-t b-light">
							<tr>

								<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAll()" ng-model="quotation.checkAll"> <i></i>
								</label></th>

								<th colspan=1 class=" width_8 text-center">Charge Type<span
									style="color: red">*</span></th>
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
									<th colspan=1 class="width_8 text-center">Hazardous<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_8 text-center">Is OOG<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_8 text-center">Tariff<span
									style="color: red"></span></th>
									<th colspan=1 class="width_8 text-center">Currency<span
									style="color: red"></span></th>
								<th colspan=1 class=" width_8 text-center">Quoted Rate<span
									style="color: red">*</span></th>
								
								<!-- 	<th colspan=1 class="width_8 text-center">Free Days<span
									style="color: red;"> </span></th>	 -->

							</tr>
							<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
								ng-controller="quotationtableCtrl">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex}}">
											<i></i>
									</label></td>


									<td class=" width_9"><selectivity list="chargeTypeList"
											property="row.chargeType" id="chargeType{{trIndex}}"
											ng-model="row.chargeType" validation="required"
											name="chargeType{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(chargeType)'}}"
											form-name="quotationForm"></selectivity></td>
									<td class=" width_9"><selectivity list="conTypeList"
											property="row.conType"  
											ng-model="row.conType"  
											name="conType{{trIndex}}" ></selectivity></td>
											<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row.hazardous"
												id="hazardous{{trIndex}}" name="hazardous{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


										</div>
									</td>
									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row.oog" id="oog"
												name="oog{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(oog)'}}">


										</div>
									</td>
									<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="tariff"
										property="row.tariff" id="tariff{{trIndex}}"
										ng-model="row.tariff"
										friendly-name="{{ 'Row' + ($index+1) + '(tariff)'}}"
										disabled="true" /></td>
										<td class=" width_9"><selectivity list="currencyList"
											property="row.localCurrency" 
											ng-model="row.localCurrency"  
											name="localCurrency{{trIndex}}"></selectivity></td>
									<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="quotedRate"
										property="row.quotedRate" id="quotedRate{{trIndex}}"
										ng-model="row.quotedRate"
										ng-keyup = "quoterate(trIndex,row,quotation)"
										friendly-name="{{ 'Row' + ($index+1) + '(quotedRate)'}}" /></td>

									
									
										<!-- <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.freeDays" id="freeDays{{trIndex}}"
										ng-model="row.freeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(freeDays)'}}"
										 /></td> -->
								</tr>
							</tbody>
						</table>

						<button ng-click="addRow()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br><br>
					<div>
						<table class="table table-striped b-t b-light">
							<tr>

								<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAllFreeDays()" ng-model="quotation.checkAllFreeDays"> <i></i>
								</label></th>
 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								 
									<th colspan=1 class="width_8 text-center">POL Free Days<span
									style="color: red;"> </span></th>	
								<th colspan=1 class="width_8 text-center">POD Free Days<span
									style="color: red;"> </span></th>			

							</tr>
							<tbody ng-repeat="(trIndex1, row) in quotation.quotationFreeDaysDtl"
								ng-controller="quotationtableCtrl">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex1}}">
											<i></i>
									</label></td>
 
									<td class=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" ></selectivity></td>
									  
									 
									
									 

									
										<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays" id="polFreeDays{{trIndex}}"
										ng-model="row.polFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays" id="podFreeDays{{trIndex1}}"
										ng-model="row.podFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
								</tr>
							</tbody>
						</table>

						<!-- <button ng-click="addRowFreeDays()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button> -->
						<button ng-click="removeRowFreeDays()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					
					</tab></tabset>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<!-- <button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="draftSubmit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save as Draft
										</button> -->
										<button class="btn btn-success" type="button" ng-if="!edit" ng-disabled="check"
											ng-click="Submit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save
										</button>
										<!-- <button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdatePending(quotationForm,quotation)">
											<i class="fa fa-save"></i> Submit
										</button> -->
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(quotationForm,quotation)">
											<i class="fa fa-save"></i> Update
										</button>
										<button class="btn btn-danger" ng-click="cancelDraft()"
											type="button">
											<i class="fa fa-close"></i> Back
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

	</div>
</div>
<script type="text/ng-template" id="algorithmModal">
<div class="modal-header"> Quotation Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='Quotation Algorithm' class='' 
        width='625' height='500' src='assets/algorithm_Docs/Quotation_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script>


<script type="text/ng-template" id="mrgRateCheck">
 <div class="modal-header">QuotedRate Alert </div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <span style="font-weight:bold;"> MRG Rate - {{mrgRate}} </span>
<br>
<span>Please make QuotedRate as Equal or Less then MRG Rate..</span>
	</div>
   </div> 
  </div>
  <div class="modal-footer">
	
   <button class="btn btn-info" type="button" ng-click="closeFileDialog()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
 
 

<script type="text/ng-template" id="tariffRateCheck">
 <div class="modal-header">Are You Sure ! </div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
<br>
<span>Your QuotedRate is Less then Tariff Rate..</span>
	</div>
   </div> 
  </div>
  <div class="modal-footer">
	
   <button class="btn btn-info" type="button" ng-click="closeFileDialog()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>