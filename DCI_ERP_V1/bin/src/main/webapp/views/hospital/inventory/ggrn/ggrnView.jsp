<style>
.main_container{
overflow:auto;
}
.datetimepicker{
width:auto;
}
select{
-webkit-appearance: none;
  padding: 0;
  text-indent: 8px;
  padding : 0 !important;
}
.input-group-addon{
display:none !important;
}
.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
{
 background-color:white !important;
 border:0px !important;
}
.b-grey{
border:0px !important;
}
.sorting:after{
  display : none !important;
}

#Address {
	height: 80px;
	resize: none;
}
.qc-btn{
color: #ffffff !important;
background-color: #A9C0EE;
border-color: #189ec8;
width: 33px;
height: 28px;
}

table.dataTable thead .sorting:after {
	content: "";
}

</style>


<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>

					<div class="row book-widget-row" style="padding-bottom: 12px;"
						ng-init="init()">
						<form class="form-horizontal" name="grnAdd"
							ng-submit="return false">
							<input type="hidden" class="form-control input-sm" data-ng-model="grnData.grnId" >
							<!-- Form field start -->
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class ="col-md-6">
									<fieldset ng-disabled="true">
										<div class="form-group" data-ng-if="isEdit">
											<label class="col-md-4 control-label">GRN No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.grnCode" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">GRN Date</label>
											<div class="col-md-7">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="grndate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="GRN Date"
																	data-validator="required" data-valid-method="submit"
																	data-message-id="GRN Date"
																	data-ng-model="grnData.grnDate"
																	style="padding-right: 107px;"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="grnData.grnDate"
																data-on-set-time="grnData.grnDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#grndate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
					        				<label class="col-md-4 control-label"> <spring:message
			              			code="label.company.name"></spring:message> </label>
					        				<div class="col-md-7">
						        				<select class="form-control input-sm" id="hospital" name="hospital" data-ng-model="grnData.companyId"
											        	data-ng-options="ac.id as ac.text for ac in companyList">
										    	 </select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Vendor Name</label>
											<div class="col-md-7">
												<select class="form-control input-sm" id="vendorName" name="vendorName" data-ng-model="grnData.vendorId"
											        	data-ng-options="ac.id as ac.text for ac in vendorList">
										    	 </select>
											</div>
										</div>

										<div class="form-group">
								            <label class="col-md-4 control-label"> Vendor Address
								            </label>
								            <div class="col-md-7 b b-grey">
									             <div class="col-md-12 no-padding ">
									             	<textarea class="text-left form-control input-sm" rows="1" cols="15"  style="resize: none" readonly ng-model="purchaseData.address"> </textarea>
									             </div>
									             <div class="col-md-12 no-padding">
										             <div class="col-md-4 no-padding ">
															<input type="text" class="form-control input-sm" placeholder="city" readonly  ng-model="purchaseData.city">
										             </div>
										             <div class="col-md-8 no-padding ">
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseData.state" readonly>
										             </div>
										             <div class="col-md-12 no-padding ">
										             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseData.country" readonly>
										             </div>
									             </div>
								             </div>
							            </div>

							            <div class="form-group">
											<label class="col-md-4 control-label">Source Location</label>
											<div class="col-md-7">
											<!--  <select class="form-control input-sm"  data-ng-model="grnData.locId" id="srclocation" name="srclocation" 
											        	data-ng-options="ac.id as ac.text for ac in locationList">
										    	 </select> -->
										    	 <select class="form-control input-sm" id="srclocation" name="srclocation" data-ng-model="grnData.locId"
											        	data-ng-options="ac.id as ac.text for ac in locationList">
										    	 </select>
										    </div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Destination Location</label>
											<div class="col-md-7">
												<select class="form-control input-sm" id="dstlocation" name="dstlocation" data-ng-model="grnData.dstLocId"
											        	data-ng-options="ac.id as ac.text for ac in locationList">
										    	 </select>
											</div>
										</div>
										
										<div class="form-group" data-ng-if="qc">
											<label class="col-md-4 control-label">QC Location</label>
											<div class="col-md-7">
												<select class="form-control input-sm" id="qclocation" name="qclocation" data-ng-model="grnData.qcLocationId"
											        	data-ng-options="ac.id as ac.text for ac in locationList">
										    	 </select>
											</div>
										</div>
										
										</fieldset>
							            </div>
									<div class ="col-md-6">
									<fieldset ng-disabled="true">
										<%-- <div class="form-group">
											<label class="col-md-4 control-label">Purchase Order<spring:message
													code="label.asterisk.symbol"></spring:message></label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
				 								name="purOrder" ng-model="grnData.poNo"
												id="pOrderNo" typeahead="ac.poId as ac.poNo for ac in poList| filter:$viewValue |limitTo:10"
				 								typeahead-min-length='1'   typeahead-input-formatter="formatLabel($model)"/>
											</div>
										</div> --%>
										<div class="form-group" ng-if = "grnData.poAmendNo != ''">
											<label class="col-md-4 control-label">Purchase Order (Amended POs)</label>
											<div class="col-md-7">
											<input type="text" class="form-control input-sm"
				 								name="poNo" ng-model="grnData.poNo"
											/>
											<!-- <select class="form-control input-sm" id="poId" name="poId" data-ng-model="grnData.poId"
											        	data-ng-options="ac.id as ac.text for ac in poList">
										    	 </select> -->
											
											<!-- 	<select class="form-control input-sm" id="pOrderNo" name="pOrderNo" data-ng-model="grnData.poId"
											        	data-ng-options="ac.id as ac.text for ac in poList">
										    	 </select> -->
											</div>
										</div>
										
										<div class="form-group" ng-if = "grnData.poAmendNo == ''">
											<label class="col-md-4 control-label">Purchase Order </label>
											<div class="col-md-7">
											<input type="text" class="form-control input-sm"
				 								name="poNo" ng-model="grnData.poNo"
											/>
											<!-- <select class="form-control input-sm" id="poId" name="poId" data-ng-model="grnData.poId"
											        	data-ng-options="ac.id as ac.text for ac in poList">
										    	 </select> -->
											
											<!-- 	<select class="form-control input-sm" id="pOrderNo" name="pOrderNo" data-ng-model="grnData.poId"
											        	data-ng-options="ac.id as ac.text for ac in poList">
										    	 </select> -->
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-md-4 control-label">Purchase Type</label>
											<div data-ng-if="grnData.poType=='Consignment Po'">
												<div class="col-md-4">
													<input type="text" class="form-control input-sm" ng-model="grnData.poType" readonly>
												</div>
												<div class="col-md-3 no-padding padding-right-12">
													<input type="text" class="form-control input-sm" ng-model="grnData.conTransferNo" readonly>
												</div>
											</div>
											<div class="col-md-7" data-ng-if="grnData.poType!='Consignment Po'">
												<input type="text" class="form-control input-sm" ng-model="grnData.poType" readonly>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Requisition No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.poRequisition" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Mode of
												Transport</label>
											<div class="col-md-7">
												<select class="form-control input-sm" data-ng-model="grnData.transMode">
													<option value>Select</option>
													<option value=1>Person</option>
													<option value=2>Courier</option>
													<option value=215>Transport</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Invoice No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.invoiceNo">
											</div>

										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Invoice Date </label>
											<div class="col-md-7">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="despatchdate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="Permission Date"
																	data-validator="required" data-valid-method="submit"
																	data-message-id="Despatched Date"
																	data-ng-model="grnData.invoiceDate"
																	style="padding-right: 107px;"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="grnData.invoiceDate"
																data-on-set-time="grnData.invoiceDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#despatchdate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Due Date </label>
											<div class="col-md-7">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="despatchdate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="Permission Date"
																	data-validator="required" data-valid-method="submit"
																	data-message-id="Despatched Date"
																	data-ng-model="grnData.dueDate"
																	style="padding-right: 107px;"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="grnData.dueDate"
																data-on-set-time="grnData.dueDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#despatchdate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Delivery Order
												No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" data-ng-model="grnData.delOrderNo">
											</div>

										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Delivery Order
												Date </label>
											<div class="col-md-7">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="deliverydate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="Permission Date"
																	data-validator="required" data-valid-method="submit"
																	data-message-id="Despatched Date"
																	data-ng-model="grnData.delOrderDate"
																	style="padding-right: 107px;"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="grnData.delOrderDate"
																data-on-set-time="grnData.delOrderDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#deliverydate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div>
										</fieldset>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="col-sm-12 col-md-12 col-lg-12">
					        		<tabset justified="true" class="tab-container">
								        <tab heading="Order Details" >
						        		<div role="content">
									    	<div class="widget-body no-padding">
									    	<div class="table-responsive clear col-sm-12 padding-top-10">
												<table id="dt_basic"
												         class="table table-striped table-bordered table-hover dataTable no-footer"
												         role="grid" aria-describedby="dt_basic_info">
													<thead class="dataTables-Main-Head">
														<tr>
															<th class="sorting  width_10">Item Code</th>
															<th  class="sorting  width_10">Item Name</th>
															<th  class="sorting  width_10">Item Description</th>
														<th  class="sorting  width_10">Cost Center</th>
															<th  class="sorting width_7">Unit Price</th>
															<th class="sorting width_7">Pending Qty</th>
															<th class="sorting  width_7">Receiving Qty</th>
															<th class="sorting  width_7">Converted Qty</th>
															<!-- <th class="sorting  width_5">QC</th> -->
															<!-- <th  class="sorting width_5">Info</th> -->
														</tr>
													</thead>

													<tbody ng-repeat="(trIndex, row) in grnData.grnTables">
														<tr>
															<td class="width_10">
																	<input type="hidden" class="form-control input-sm" ng-model="row.dtlItemId" name="dtlItemId" />
																	<input type="text" class="form-control input-sm" ng-model="row.dtlItemCode" name="dtlItemCode"
																		readonly="readonly" />
															</td>

															<td class="width_10">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlItemName" name="dtlItemName"
																			readonly="readonly" />
															</td>
															<td class="width_10" title={{row.dtlItemDesc}}>
																		<input type="text" class="form-control input-sm" ng-model="row.dtlItemDesc" name="dtlItemDesc"
																			readonly="readonly" />
															</td>
															
															<td class="width_10" title={{row.costcenter}}>
<!-- 																		<input type="text" class="form-control input-sm" ng-model="row.costcenter" name="costcenter"
																			readonly="readonly" />
 -->															
 
 														<selectivity list="costList"
															ng-model="row.costcenter"
															property="row.costcenter" id="costcenter"
															object="costcenter" name="costcenter"
															validation="required" friendly-name="Cost Center"
															form-name="PurchaseOrderForm" disabled="true"></selectivity>
 
 </td>
															
															<td class="width_7">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlPrice" name="dtlPrice"
																			readonly="readonly" style="text-align: right;" />
															</td>
															<td class="width_7">
																		<input type="text" class="form-control input-sm" ng-model="row.pendingQty" name="pQty"
																			readonly="readonly" style="text-align: right;" />
															</td>
															<td class="width_7" data-ng-if="!isEdit">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlQty" 
																		ng-init = "calculateConvertedQuantity(row.dtlQty,row.convertedQty,$index,row.originalConvertedQty,row.purReqQuantity,row.vendorQuantity,row.pendingQty);calculateTaxDiscountEdit(row)"
																		ng-blur = "calculateConvertedQuantity(row.dtlQty,row.convertedQty,$index,row.originalConvertedQty,row.purReqQuantity,row.vendorQuantity,row.pendingQty);calculateTaxDiscountEdit(row)"
																		
																		name="dQty" style="text-align: right;" ng-disabled="grnData.poType!='Regular'" />
																		<input type="hidden" class="form-control input-sm" ng-model="row.dtlPODtlId" name="dtlPODtlId" />
															</td>
															<td class="width_7" data-ng-if="isEdit">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlQty" name="dQty" readonly="readonly" style="text-align: right;" 
																		ng-init = "calculateConvertedQuantity(row.dtlQty,row.convertedQty,$index,row.originalConvertedQty,row.purReqQuantity,row.vendorQuantity,row.pendingQty);calculateTaxDiscountEdit(row)"
																		ng-blur = "calculateConvertedQuantity(row.dtlQty,row.convertedQty,$index,row.originalConvertedQty,row.purReqQuantity,row.vendorQuantity,row.pendingQty);calculateTaxDiscountEdit(row)"
																		
																		/>
																		<input type="hidden" class="form-control input-sm" ng-model="row.dtlPODtlId" name="dtlPODtlId" />
															</td>
															<td class="width_7" data-ng-if="!isEdit">
																<input type="text" class="form-control input-sm" ng-model="row.cnvtQty" name="cnvtQty" style="text-align: right;" ng-disabled="grnData.poType!='Regular'" />
															</td>
															<td class="width_7" data-ng-if="isEdit">
																<input type="text" class="form-control input-sm" ng-model="row.cnvtQty" name="cnvtQty" readonly="readonly" style="text-align: right;" />
															</td>
															<!-- <td class="width_5" data-ng-if="!row.qualityCheck">

															</td> -->
															<!-- <td class="width_5" data-ng-if="row.qualityCheck">
																	<button class="btn btn-sm ng-scope" type="button"
																		class="btn btn-success" ng-click="getQCInfo(row)" ng-disabled="1==1" >
																		<i class="fa fa-check-circle-o"></i>
																	</button>
															</td> -->
															 <!-- <td class="width_5">
																	<label class="col-xs-12"
																		data-ng-click="getProductInfo(trIndex)"><span class="fa fa-expand"></span></label>
															</td> -->
														</tr>
													</tbody>
												</table>
												</div>
											</div>
										</div>
										</tab>
										<tab heading="Delivery Schedule" data-ng-if="isRate">
							        		<div  data-st-table="displayedCollectionDeliveryItem"
				        								data-st-safe-src="rowCollectionDeliveryItem">
													<table class="table table-striped table-bordered table-hover dataTable no-footer">
														 <thead class="dataTables-Main-Head">
													          <tr>
													          <th class="width_1 table-heading text-center">
													            <label class="i-checks m-b-none">
													             <input type="checkbox">
													             <i></i>
													            </label>
													           </th>
													          <th class="sorting width_7">Item Code</th>
													           <th class="sorting width_15">Item Name</th>
													            <th class="sorting width_7">Schedule Qty</th>
													            <th class="sorting width_7">Pending Qty</th>
													            <th class="sorting width_7">Received Qty</th>
													            <th class="sorting width_10" >Delivery Date</th>
													          </tr>
													     </thead>
														<tbody>
															<tr data-ng-repeat="schCollectionsDelivery in displayedCollectionDeliveryItem track by $index"
																ng-hide="schCollectionsDelivery.edit == '2'" >
																 <td >
														           <label class="i-checks m-b-none">
														             <input type="checkbox" ng-model="schCollectionsDelivery.select" ng-change="getScheduleQty(schCollectionsDelivery,false)"
														             ng-disabled="schCollectionsDelivery.schedulePendingQty == 0" >
														             <i></i>
														            </label></td>
																<td>{{schCollectionsDelivery.scheduleItemCode}}</td>
																<td>{{schCollectionsDelivery.scheduleItemName}}</td>
																<td style="text-align: right;">{{schCollectionsDelivery.scheduleQty}}</td>
																<td style="text-align: right;">{{schCollectionsDelivery.schedulePendingQty}}</td>
																<td style="text-align: right;">{{schCollectionsDelivery.scheduleReceivedQty}}</td>
																<!-- <td><input type="text" style="text-align: right;" ng-model="schCollectionsDelivery.scheduleItemQty" ng-disabled="isEdit"
					           										placeholder="0" ng-focus="getCurrentQty(schCollectionsDelivery)" ng-blur="getScheduleQty(schCollectionsDelivery,true)"></td> -->
					           									<td>{{schCollectionsDelivery.scheduleItemDate}}</td>
															</tr>

														</tbody>
													</table>
												</div>
        		 							</tab>
										</tabset>
										</div>
									</div>
								</div>
								<br>
<div class="col-sm-12 col-md-12 col-lg-12 ">
			     					 <div role="content">
											<!-- <div class="panel-body"> -->
											 <div class="widget-body no-padding"> 
												<!-- <div class="table-responsive"> -->
													<div class="col-md-12" style="width: 100%;">
			       <div 
			        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
			        data-st-table="displayedCollectionItem"
			        data-st-safe-src="rowCollectionItem">
			        <table id="dt_basic"
			         class="table table-striped table-bordered table-hover dataTable no-footer"
			         role="grid" aria-describedby="dt_basic_info">
			         <thead class="dataTables-Main-Head">
			          <tr>
			           <th class="width_1 table-heading text-center">
			           </th>
			         
			           <th class="sorting width_7" >Item Code</th>
			           <th class="sorting width_5" >Price</th>
			           <th class="sorting width_4"  style="padding: 0 !important;line-height: 34px;">Discount</th>
			        <th class="sorting width_2"  style="padding: 0 !important;line-height: 34px;">Discount(%)</th>
			        
			           <th class="sorting width_5" >Net Price</th>
			           <th class="sorting width_4" >CGST</th>
			           <th class="sorting width_4" >SGST</th>
			           <th class="sorting width_4" >IGST</th>
			           <th class="sorting width_2" >CGST(%)</th>
			           <th class="sorting width_2" >SGST(%)</th>
			           <th class="sorting width_2" >IGST(%)</th>
			           <th class="sorting width_4" >Total</th>
			          </tr>
			         </thead>
			         <tbody class="dataTables-Main-Body">
			          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  ng-repeat="departmentCollections in grnData.grnTables"
			          ng-hide="departmentCollections.edit == '2'">
			           <td>
			           <label class="i-checks m-b-none">
			             <input type="checkbox" ng-model="departmentCollections.select">
			             <i></i>
			            </label></td>
			           <td>{{departmentCollections.dtlItemCode}}</td> 
			           <td  style="text-align: right;">{{departmentCollections.price}}</td>
                       <td  style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td  style="text-align: right;">{{departmentCollections.discountPercentage}}</td>
			          <td  style="text-align: right;">{{departmentCollections.netPrice}}</td>
                       	<td  style="text-align: right;">{{departmentCollections.taxCGST}}</td>
			            <td  style="text-align: right;">{{departmentCollections.taxSGST}}</td>
			            <td  style="text-align: right;">{{departmentCollections.taxIGST}}</td>
			            <td  style="text-align: right;">{{departmentCollections.taxCGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.taxSGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.taxIGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.finalTotal}}</td>
			          
			          </tr>
			         </tbody>
			        </table>
			       </div>
			      </div>
				     </div>
				</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="col-md-12" style="margin-top: 7px;padding-left:12px	">
        			<div class="form-group">
        				<label class="col-md-1 control-label" style="padding-left:12px"> SubTotal :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.subTotal"  style="text-align: right;padding-right: 0;color: black;" readonly>
						</div>
        				<label class="col-md-1 control-label" style="padding-left:12px"> Discount :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalDiscount" ng-blur = "TOtalCal(purchaseOrder.totalDiscount)"  style="text-align: right;padding-right: 0;color: black;" readonly>
						</div>
        					<label class="col-md-1 control-label" style="padding-left:15px"> CGST :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTaxCGST"  style="text-align: right;padding-right: 0;color: black;" readonly>
						</div>
							<label class="col-md-1 control-label" style="padding-left:15px"> SGST :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTaxSGST"  style="text-align: right;padding-right: 0;color: black;" readonly>
						</div>
							<label class="col-md-1 control-label" style="padding-left:15px"> IGST :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTaxIGST"  style="text-align: right;padding-right: 0;color: black;" readonly>
						</div>
						<label class="col-md-1 control-label" style="padding-left:12px"> Freight: </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  
							 ng-pattern-restrict="^[0-9.]*$" ng-model="grnData.freight"  ng-blur = "TOtalCal(purchaseOrder.freight)" placeholder="0" style="text-align: right;padding-right: 0;color: black;" readonly>
						</div>
						<br>
						<br>
						<label class="col-md-1 control-label" style="padding-left:12px"> Other Charges: </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"   
							ng-pattern-restrict="^[0-9.]*$" ng-model="grnData.otherCharges" ng-blur = "TOtalCal(purchaseOrder.otherCharges) placeholder="0" style="text-align: right;padding-right: 0;color: black;"readonly>
						</div>
						<!-- <br> -->
						<label class="col-md-1 control-label" style="padding-left:12px"> Remarks : </label>
        				<div class="col-md-3">
				             <textarea class="text-left form-control input-sm" name="remarks for OtherCharges"
				             data-ng-model="grnData.remarksforother" rows="1" cols="20" style="resize: none"
				              readonly> </textarea>
				            </div>
						<!-- <br> -->
						<label class="col-md-1 control-label" style="padding-left:12px"> Total :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="grnData.totalAmount" readonly  style="text-align: right;padding-right: 0;color: black;">
						</div>
					</div>
        		</div>
							</div>
							<!-- Form field end -->
							
								 <div class="form-actions">
								<div class="row">
									<button class="btn btn-dark" type="button" data-ng-click="GRNprint(grnData.grnCode)">
						           		<i class="fa fa-print"></i> Print
						          	</button>
								</div>
							</div> 
							<div class="form-actions">
								<div class="row">
									<button class="btn btn-danger" type="button"
										class="btn btn-success" ng-click="cancel()">
										<i class="fa fa-close"></i>
										<spring:message code="label.cancel"></spring:message>
									</button>
								</div>
							</div>

						</form>
						<!-- Form end -->
					</div>
				</div>
				<!-- end widget div -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>
