
<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 85%;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -40px;
}

.multiselect-container {
	position: absolute;
	list-style-type: none;
	margin: 0;
	padding: 0
}


.multiselect-container .input-group {
	margin: 5px
}

.multiselect-container>li {
	padding: 0
}

.multiselect-container>li>a.multiselect-all label {
	font-weight: 700
}

.multiselect-container>li>label.multiselect-group {
	margin: 0;
	padding: 3px 20px;
	height: 100%;
	font-weight: 700
}

.multiselect-container>li>a {
	padding: 0
}

.multiselect-container>li>a>label {
	margin: 0;
	height: 100%;
	cursor: pointer;
	font-weight: 400;
	padding: 3px 20px 3px 40px
}

.multiselect-container>li>a>label.radio, .multiselect-container>li>a>label.checkbox
	{
	margin: 0
}

.multiselect-container>li>a>label>input[type=checkbox] {
	margin-bottom: 5px
}

.btn-group>.btn-group:nth-child(2)>.multiselect.btn {
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px
}

.form-inline .multiselect-container label.checkbox, .form-inline .multiselect-container label.radio
	{
	padding: 3px 20px 3px 40px
}

.form-inline .multiselect-container li a label.checkbox input[type=checkbox],
	.form-inline .multiselect-container li a label.radio input[type=radio]
	{
	margin-left: -20px;
	margin-right: 0
}

.tooltip {
	position: relative;
	display: inline-block;
	border-bottom: 5px dotted black;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 120px;
	background-color: black;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	/* Position the tooltip */
	position: absolute;
	z-index: 1;
	top: -5px;
	left: 105%;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
}
/* 
.tableFixHead          { width:100%;height:300px;overflow:auto; }
.tableFixHead thead th { position: sticky; top: 0; }

/* Just common table stuff. Really. */
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; }
th     { background:#eee; } */

.subcolor {
	background: #42a5f5 !important;
	color: #fff !important;
}

.custom-color-1 .table-striped>tbody>tr>td, .custom-color-1 .table-striped>tfoot>tr>th
	{
	border: 1px solid #000;
	border-bottom: 1px solid #000;
	color: #1a1a1a;
}

.custom-color-1 .table-striped>thead>tr>th {
	border: 1px solid #000;
	color: #fff;
	border-bottom: 1px solid #000;
	border-left: 1px solid #000;
	border-top: black;
}

.table>tbody>tr>td, .table>tfoot>tr>td {
	padding: 4px 10px;
	font-size: 11px;
}

.table>thead>tr>th {
	padding: 0px 10px 0px 10px;
	font-size: 11px;
}

.ls_flag_Color {
	background: #caef7a !important;
}


.inner {
width:100%;height:300px;overflow:auto;
}
.inner thead th { position: sticky; top: 0; }

#optable td, #optable th {
	border: 1px solid #fff;
	width: 200%;
	
}

#optable table {
	table-layout: fixed;
	width: 100%;
}
.freeze-class_hdr {
	position: sticky;
	left: 0;
	z-index: 1;
	background-color: #caef7a;
}
.freeze-class1 {
	position: sticky;
	left: 0;
	z-index: 1;
	background-color: #9dcced;
}

.freeze-class2 {
	position: sticky;
	left: 4%;
	z-index: 1;
	background-color: #9dcced;
}

.freeze-class3 {
	position: sticky;
	left: 17%;
	z-index: 1;
	background-color: #9dcced;
}

.freeze-class4 {
	position: sticky;
	left: 130px;
	z-index: 1;
	background-color: #caef7a;
}

.freeze-class5 {
	position: sticky;
	left: 170px;
	z-index: 1;
	background-color: #caef7a;
}

.freeze-class6 {
	position: sticky;
	left: 220px;
	z-index: 1;
	background-color: #caef7a;
}

#optable thead tr th {
	position: sticky;
	top: 0;
}

#optable th:first-child, #optable th:nth-child(2), #optable th:nth-child(3),
	#optable th:nth-child(4), #optable th:nth-child(5), #optable th:nth-child(6)
	{
	z-index: 2;
}

.Class1{

}
</style>
<!-- <div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header class="ngdialog-header">
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2>Add Purchase List</h2>
					</header>
					<div role="content">
						<div class="widget-body"> --%> -->
						
<!-- <style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style> -->

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
	
							<form class="form-horizontal" name="purchaseQuoteRequestForm"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="row">
											<div class="col-sm-12 col-md-12 col-lg-12">
												<div class="form-group">
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="quotationDetail.purchaserequest"
																ng-change="purchaserequest(quotationDetail.purchaserequest)"
																data-ng-true-value="true" data-ng-false-value="false">
																<span>Purchase Quotation</span>
															</label>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>

												<div class="form-group">
													<label ng-if="po_wo_check=='PO'"
														class="col-md-4 control-label">Requisition No <span style ="color:red";>*</span>
													</label> <label ng-if="po_wo_check=='WO'"
														class="col-md-4 control-label">Work Order No<span style ="color:red";>*</span>
													</label>
													<div class="col-md-7">
														<!-- <select class="form-control input-sm" ng-model="quotationDetail.requisitionId"  ng-change="getItemList()"
		              ng-options="requisition.purchaseRequisitionId as requisition.requisitionNumber for requisition in requisitionList">
		              	<option value="">Select</option>
		              </select> -->
														<!-- <selectivity list="requisitionList" property="quotationDetail.requisitionId" id="txtRequistionId"></selectivity> -->

														<selectivity list="requisitionList"
															ng-model="quotationDetail.requisitionId"
															property="quotationDetail.requisitionId"
															id="requisitionId" object="requisitionObj"
															name="requisitionId" validation="required"
															friendly-name="Requisition No"
															form-name="purchaseQuoteRequestForm"></selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Location
														Address </label>
													<div class="col-md-7">
														<div class="col-md-12 b b-grey no-padding">
															<div
																class="col-md-12 no-padding padding-top-5 padding-left-5 padding-right-5">
																<textarea class="text-left form-control input-sm"
																	rows="2" cols="15" style="resize: none" readonly
																	ng-model="quotationDetail.locationName"> </textarea>
															</div>
															<div
																class="col-md-5 no-padding padding-top-5 padding-left-5">
																<input type="text" class="form-control input-sm"
																	placeholder="city" ng-model="quotationDetail.cityName"
																	readonly>
															</div>
															<div
																class="col-md-4 no-padding padding-top-5 padding-left-5">
																<input type="text" class="form-control input-sm"
																	placeholder="state"
																	ng-model="quotationDetail.stateName" readonly>
															</div>
															<div
																class="col-md-3 no-padding padding-top-5 padding-left-5 padding-right-5">
																<input type="text" class="form-control input-sm"
																	placeholder="zip" ng-model="quotationDetail.pincode"
																	readonly>
															</div>
															<div
																class="col-md-12 no-padding padding-top-5 padding-bottom-5 padding-left-5 padding-right-5">
																<input type="text" class="form-control input-sm"
																	placeholder="country"
																	ng-model="quotationDetail.country" readonly>
															</div>
														</div>
													</div>
												</div>
												
											</fieldset>
										</div>

										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>

												<div class="form-group">
													<label ng-if="po_wo_check=='PO'"
														class="col-md-4 control-label"> Requisition Date </label>
													<label ng-if="po_wo_check=='WO'"
														class="col-md-4 control-label">Work Order Date </label>
													<div class="col-md-7">
														<div class='input-group date width_100 datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="reqDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="currentDate"
																			data-validator="required" data-valid-method="submit"
																			data-message-id="currentDate" readonly
																			data-ng-model="quotationDetail.reqDate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
															
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Status </label>
													<div class="col-md-7">
														<selectivity list="statusList"
															ng-model="quotationDetail.queryStatus"
															property="quotationDetail.queryStatus" id="queryStatus"
															object="queryStatus" name="queryStatus"
															friendly-name="Status" readonly="true"
															form-name="purchaseQuoteRequestForm"></selectivity>
														
													</div>
												</div>
												<div class="tooltip">
													Hover over me <span class="tooltiptext">Tooltip text</span>
												</div>
												
											</fieldset>
										</div>



											<br>
											<br>
											<br>
											<br>
										<!-- 	<div class="tableFixHead">
												
											<div class="panel-body">
												<div class="table-responsive">
													<div class="col-md-12" style="width: 200%;">

														<div class="row" id="items">
															<div class="col-sm-12 col-md-12 col-lg-12 padding-bottom-10"  style="overflow-x:auto;">
															
															<div class="tableFixHead">
															<table class="table table-striped b-t b-light">
																 -->
															<div class="row">
						<div class=" container col-sm-12 col-md-12 col-lg-12">
							<div>
								<div>
									<!-- <scrollable-table watch="messageHeaderList" resizable>  -->
									<div class="outer">
										<div class="inner" >
													<div class="col-md-12" style="width: 180%;">
											<!-- <table border=1 cellspacing=0 cellpadding=0
												bordercolor="#808080" id="optable"
												class="table table-striped   no-footer custom-tcolor">	 
												 -->		<table class="table table-striped b-t b-light">
																		 
																 <thead>
																	<tr >
																		<!-- <th class="width_1" rowspan="2">S.No</th> -->
																		<!-- <th class="text-center" style="width: 1%;"></th> -->
																		<th class="width_1 freeze-class1"  >
																		<button
																					type="button" class="btn btn-info"
																					ng-click="deleteUnselectItem()">
																					 <i class="fa fa-undo">Clear All</i>
																					<!-- Clear All -->
																				</button>
																				<i></i>
																				
																		
																		<label
																			class="i-checks m-b-none"> <input
																				type="checkbox" ng-model="selectAll"
																				id="selectAllRows"
																				ng-change="selectAllrows(selectAll)"><i></i></label>
																			
											
											</th>
																		
																		<th ng-if="po_wo_check=='PO'" class="text-center freeze-class2"
																			style="width: 8%;">PR Number<span style ="color:red";>*</span>
																		</th>
																		<th ng-if="po_wo_check=='WO'" class="text-center freeze-class2"
																			style="width: 10%;">WO Number<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center freeze-class3" style="width: 13%;">Item
																			Code - Item Name<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center" style="width: 10%;">Item
																			Description</th>
																		<th class="text-center" style="width: 4%;">EDD</th>
																		<th ng-if="po_wo_check=='PO'" class="text-center"
																			style="width: 1%;">Purchase UOM</th>
																		<th ng-if="po_wo_check=='WO'" class="text-center"
																			style="width: 1%;">Work Order UOM</th>
																		<th ng-if="po_wo_check=='PO'" class="text-center"
																			style="width: 1%;">Purchase Request Quantity<span style ="color:red";>*</span>
																		</th>
																		<th ng-if="po_wo_check=='WO'" class="text-center"
																			style="width: 1%;">Work Order Quantity<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center" style="width: 2%;">Vendor
																			UOM<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center" style="width: 1%;">Vendor
																			Quantity<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center" style="width: 1%;">Available
																			Quantity</th>
																		<th class="text-center" style="width: 5%;"> Unit
																			Price<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center" style="width: 5%;">Old Unit
																			Price<span style ="color:red";>*</span>
																		</th>
																		<th class="text-center" style="width: 2%;">CGST</th>
																		<th class="text-center" style="width: 2%;">SGST</th>
																		<th class="text-center" style="width: 2%;">IGST</th>
																		<th class="text-center" style="width: 6%;">Discount
																			Type</th>
																		<th class="text-center" style="width: 2%;">Discount</th>
																		<th class="text-center" style="width: 5%;">Cost Center
																			</th>
																		<th class="text-center" style="width: 2%;">Lead
																			Time</th>
																	</tr>
																</thead>
																<tbody ng-repeat="(trIndex, period) in tableDetails1" >
																	<tr>

																		<td class="width_1" style="position: sticky;left: 0%;" ><label
																			class="i-checks m-b-none padding-top-10"> <input
																				type="checkbox" ng-model="period.selectCheckBox">
																				<i></i>
																		</label></td>
																		
																		<td class="text-center " style="position: sticky;left: 2%;"><input type="text"
																			class="form-control input-sm" id="prRequestNo"
																			name="{{ 'PR Number' + (trIndex)}}"
																			ng-model="period.prRequestNo"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(PR Number)'}}"
																			disabled></td>
																		<td class="text-center " style="position: sticky;left: 18%;"><input type="text"
																			class="form-control input-sm" id="itemName"
																			name="{{ 'Item Name' + (trIndex)}}"
																			ng-model="period.itemName"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Item Name)'}}"
																			disabled></td>
																		<td class="text-center"
																			title={{period.itemDescription}}><input
																			type="text" data-toggle="tooltip"
																			class="form-control input-sm" id="itemDescription"
																			name="{{ 'Item Description' + (trIndex)}}"
																			ng-model="period.itemDescription"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Item Description)'}}"></td>
																		<td class="text-center"><input type="text"
																			placeholder='0.00' class="form-control input-sm"
																			id="EDD" name="{{ 'EDD' + (trIndex)}}"
																			ng-model="period.eddDate"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(EDD)'}}"
																			disabled></td>

																		<td class="text-center">
																			
																			<selectivity list="uomCategoryList"
																				property="period.uom" id="purchaseUOM{{trIndex}}"
																				ng-model="period.uom" name="purchaseUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(purchase UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>


																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm"
																			id="purchaseReqQuantity"
																			name="{{ 'Purchase Quantity' + (trIndex)}}"
																			ng-model="period.quantity"
																			    ng-pattern-restrict="^[0-9.]*$"	
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Purchase Quantity)'}}"
																			disabled></td>
																		<td class="text-center"><selectivity
																				list="uomCategoryList" property="period.vendorUOM"
																				id="vendorUOM{{trIndex}}"
																				ng-model="period.vendorUOM"
																				name="vendorUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(Vendor UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="vendorQuantity"
																			name="{{ 'Vendor Quantity' + (trIndex)}}"
																			ng-model="period.vendorQuantity"
																			ng-pattern-restrict="^[0-9.]*$"
																			ng-blur="validateVendorQuantity(period.quantity,period.vendorQuantity,trIndex);"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Vendor Quantity)'}}">
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="availableQty"
																			name="{{ 'availableQty' + (trIndex)}}"
																			ng-model="period.availableQty"
																			ng-pattern-restrict="^[0-9.]*$"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(availableQty)'}}"
																			disabled></td>
																		<td class="text-right"><input type="text"
																			class="form-control input-sm" id="unitPrice"
																			name="{{ 'Unit Price' + (trIndex)}}"
																			ng-model="period.unitPrice"
																			ng-pattern-restrict="^[0-9.]*$"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Unit Price)'}}">
																		</td>
																		<td class="text-right"><input type="text"
																			class="form-control input-sm" id="oldunitPrice"
																			name="{{ 'Old Unit Price' + (trIndex)}}"
																			ng-model="period.oldunitPrice" 
																			ng-pattern-restrict="^[0-9.]*$"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Old Unit Price)'}}" readonly>
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="taxCGST"
																			name="{{ 'Tax CGST' + (trIndex)}}"
																			ng-model="period.taxCGST"
																			ng-pattern-restrict="^[0-9.]*$"
																			ng-blur="checkgstexistIGST(trIndex,'CGST')"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Tax CGST)'}}">
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="taxSGST"
																			name="{{ 'Tax SGST' + (trIndex)}}"
																			ng-model="period.taxSGST"
																			ng-pattern-restrict="^[0-9.]*$"
																			ng-blur="checkgstexistIGST(trIndex,'SGST')"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Tax SGST)'}}">
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="taxIGST"
																			name="{{ 'Tax IGST' + (trIndex)}}"
																			ng-model="period.taxIGST"
																			ng-blur="checkgstexist(trIndex)"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Tax IGST)'}}">
																		</td>
																		<td class="text-center"><selectivity
																				list="discountTypeList"
																				ng-model="period.discountType"
																				property="period.discountType" id="discountType"
																				name="discountType"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(discountType)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="discount"
																			name="{{ 'Discount' + (trIndex)}}"
																			ng-model="period.discount"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Discount)'}}">
																		</td>
																		
																		<td class="text-center"><selectivity
																				list="costList"
																				ng-model="period.costcenter"
																				property="period.costcenter" id="costcenter"
																				name="costcenter"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(costcenter)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>
																		</td>
																		<td class="text-center"><input type="text"
																			class="form-control input-sm" id="leadTime"
																			name="{{ 'Lead Time' + (trIndex)}}"
																			ng-model="period.deliveryLeadTime" placeholder="0"
																			ng-pattern-restrict="{{numExp}}"
																			friendly-name="{{ 'Row' + (trIndex+1) + '(Lead Time)'}}">
																		</td>
																</tbody>
															</table>
															
														</div>
													</div>
												</div>
											</div>

									</div>
								</div>
								</div>
								</div>
								</div>
							
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											
											<button class="btn btn-success" type="button"
												data-ng-if="!isEdit"
												data-ng-click="validatePQDetail(purchaseQuoteRequestForm,tableDetails1)"
												class="btn btn-success">
												<i class="fa fa-save"></i> Add to List

											</button>
											<button class="btn btn-success" type="button"
												data-ng-if="isEdit == true" class="btn btn-success"
												ng-click="updateDetail()">
												<i class="fa fa-save"></i> Update
											</button>
											<button type="reset" class="btn btn-info"
												ng-click="resetPurchaseQuotationDetail(purchaseQuoteRequestForm)">
												<i class="fa fa-undo"></i> Reset
											</button>
											<button class="btn btn-danger" type="reset"
												class="btn btn-success" ng-click="cancelReq()">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>