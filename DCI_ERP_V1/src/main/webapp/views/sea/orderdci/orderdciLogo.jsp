<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>

		<div class="row">
			
					<header class="ngdialog-header">
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2>PURCHASE ORDER LOG</h2>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="purchaseQuoteRequestForm"
								novalidate method="post">
								<div class="form-action">
									<button style="background-color: red; color: white;"
										ng-click="back()">BACK</button>
								</div>
								<br>
								<table width="50%"
									style="float: left; padding-top: 10px; padding-bottom: 15px;"
									class="table table-striped b-t b-light " align="left"
									border="1" bordercolor="" cellPadding="0" cellSpacing="0">

									<tr>
										<th>Changed HDR Values</th>
										<th>NEW PO</th>
										<th>OLD PO</th>
									</tr>
								</table>
								<table width="50%"
									style="float: left; padding-top: 10px; padding-bottom: 15px;"
									class="table table-striped b-t b-light " align="left"
									border="1" bordercolor="" cellPadding="0" cellSpacing="0">


									<tr
										ng-if="POvalues.purchaseOrderNum!= POAvalues.purchaseOrderNum">
										<td class="width_30" style="font-size: 13px;">Purchase
											Order No</td>

										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.purchaseOrderNum}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.purchaseOrderNum}}</b></td>
									</tr>

									<tr ng-if="POvalues.poType!= POAvalues.poType">
										<td class="width_30" style="font-size: 13px;">PO Type</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.poType}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.poType}}</b></td>

									</tr>

									<tr ng-if="POvalues.budgetTypeName!= POAvalues.budgetTypeName">
										<td class="width_30" style="font-size: 13px;">Budget Type</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.budgetTypeName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.budgetTypeName}}</b></td>

									</tr>

									<tr ng-if="POvalues.purchaseFor != POAvalues.purchaseFor">
										<td class="width_30" style="font-size: 13px;">Purchase
											For</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.purchaseFor}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.purchaseFor}}</b></td>

									</tr>
									<tr ng-if="POvalues.companyId != POAvalues.companyId">
										<td class="width_30" style="font-size: 13px;">Company</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.companyName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.companyName}}</b></td>

									</tr>
									<tr ng-if="POvalues.locationId != POAvalues.locationId">
										<td class="width_30" style="font-size: 13px;">Destination
											Location</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.locationName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.locationName}}</b></td>

									</tr>
									<!-- 	<tr>
						<td class="width_30" style="font-size: 13px;">Destination Address</td>
						<td style="font-size: 13px;">: <b>{{POvalues.locationName}}</b></td>
						<td style="font-size: 13px;">: <b>{{POAvalues.locationName}}</b></td>
				
					</tr> -->
									<!-- <tr>
						<td class="width_30" style="font-size: 13px;">Terms & Conditions</td>
						<td style="font-size: 13px;">: <b>{{POvalues.purchaseOrderNum}}</b></td>
						<td style="font-size: 13px;">: <b>{{POvalues.purchaseOrderNum}}</b></td>
				
					</tr> -->
									<tr ng-if="POvalues.paymentTerms != POAvalues.paymentTerms">
										<td class="width_30" style="font-size: 13px;">Payment
											Terms</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.paymentTerms}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.paymentTerms}}</b></td>

									</tr>



									<tr
										ng-if="POvalues.purchaseOrderDate != POAvalues.purchaseOrderDate">
										<td class="width_30" style="font-size: 13px;">PO Date</td>

										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.purchaseOrderDate}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.purchaseOrderDate}}</b></td>

									</tr>

									<tr
										ng-if="POvalues.purchaseTypeName != POAvalues.purchaseTypeName">
										<td class="width_30" style="font-size: 13px;">Purchase
											Type</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.purchaseTypeName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.purchaseTypeName}}</b></td>

									</tr>
									<tr ng-if="POvalues.costcenter != POAvalues.costcenter">
										<td class="width_30" style="font-size: 13px;">Cost Center</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.costcenterName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.costcenterName}}</b></td>

									</tr>

									<tr ng-if="POvalues.statusName != POAvalues.statusName">
										<td class="width_30" style="font-size: 13px;">Status</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.statusName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.statusName}}</b></td>

									</tr>

									<tr ng-if="POvalues.vendorName != POAvalues.vendorName">
										<td class="width_30" style="font-size: 13px;">Vendor</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.vendorName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.vendorName}}</b></td>

									</tr>
									<!-- 	<tr>
						<td class="width_30" style="font-size: 13px;">Vendor Address</td>
						<td style="font-size: 13px;">: <b>{{POvalues.vendorAddress}}</b></td>
						<td style="font-size: 13px;">: <b>{{POAvalues.vendorAddress}}</b></td>
				
					</tr> -->
									<tr ng-if="POvalues.remarks != POAvalues.remarks">
										<td class="width_30" style="font-size: 13px;">Remarks</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.remarks}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.remarks}}</b></td>

									</tr>
									<tr ng-if="POvalues.advanceamt != POAvalues.advanceamt">
										<td class="width_30" style="font-size: 13px;">Advance</td>
										<td style="font-size: 13px;">: <b>{{POvalues.advanceamt}}</b></td>
										<td style="font-size: 13px;">: <b>{{POAvalues.advanceamt}}</b></td>

									</tr>

									<tr ng-if="POvalues.currencyName != POAvalues.currencyName">
										<td class="width_30" style="font-size: 13px;">Currency</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.currencyName}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.currencyName}}</b></td>

									</tr>

									<tr ng-if="POvalues.subTotal != POAvalues.subTotal">
										<td class="width_30" style="font-size: 13px;">SubTotal</td>
										<td style="font-size: 13px;">: <b>{{POvalues.subTotal}}</b></td>
										<td style="font-size: 13px;">: <b>{{POAvalues.subTotal}}</b></td>

									</tr>
									<tr ng-if="POvalues.totalDiscount != POAvalues.totalDiscount">
										<td class="width_30" style="font-size: 13px;">Discount</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.totalDiscount}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.totalDiscount}}</b></td>

									</tr>
									<tr ng-if="POvalues.totalTaxCGST != POAvalues.totalTaxCGST">
										<td class="width_30" style="font-size: 13px;">CGST</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.totalTaxCGST}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.totalTaxCGST}}</b></td>

									</tr>
									<tr ng-if="POvalues.totalTaxSGST != POAvalues.totalTaxSGST">
										<td class="width_30" style="font-size: 13px;">SGST</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.totalTaxSGST}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.totalTaxSGST}}</b></td>

									</tr>
									<tr ng-if="POvalues.totalTaxIGST != POAvalues.totalTaxIGST">
										<td class="width_30" style="font-size: 13px;">IGST</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.totalTaxIGST}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.totalTaxIGST}}</b></td>

									</tr>
									<tr ng-if="POvalues.freightAmount != POAvalues.freightAmount">
										<td class="width_30" style="font-size: 13px;">Freight</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.freightAmount}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.freightAmount}}</b></td>

									</tr>

									<tr ng-if="POvalues.otherCharges != POAvalues.otherCharges">
										<td class="width_30" style="font-size: 13px;">Other
											Charges</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.otherCharges}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.otherCharges}}</b></td>

									</tr>

									<tr
										ng-if="POvalues.remarksforother != POAvalues.remarksforother">
										<td class="width_30" style="font-size: 13px;">Remark For
											Other</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.remarksforother}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.remarksforother}}</b></td>

									</tr>
									<tr ng-if="POvalues.totalAmount != POAvalues.totalAmount ">
										<td class="width_30" style="font-size: 13px;">Total</td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POvalues.totalAmount
												}}</b></td>
										<td class="width_30" style="font-size: 13px;">: <b>{{POAvalues.totalAmount
												}}</b></td>

									</tr>

								</table>
								<label
									style="left: 5%; color: black; font-size: 14px; font-weight: bolder;">ITEM
									DETAIL</label> <br> <br> <label
									style="left: 5%; color: black; font-size: 14px; font-weight: bolder;">NEW
									PO</label>
								<div class="col-sm-12 col-md-12 col-lg-12 ">
									<div role="content">
										<!-- <div class="panel-body"> -->
										<div class="widget-body no-padding">
											<div class="table-responsive">
												<div class="col-md-12" style="width: 250%;">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
														data-st-table="displayedCollectionItemA"
														data-st-safe-src="rowCollectionItemA">
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 table-heading text-center"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox" ng-model="selectedAll"
																			ng-change="checkAll(displayedCollectionItem,selectedAll)">
																			<i></i>
																	</label></th>
																	<th class="sorting width_10"
																		style="position: sticky; left: 0%; background-color: #f76060;color: white;">Purchase
																		Requisition Number</th>
																	<th class="sorting width_10"
																		style="position: sticky; left: 26%; background-color: #f76060;color: white;">Item
																		Code-Item Name</th>
																	<!--    <th class="sorting width_10" >Purchase Quote Number</th> -->

																	<th class="sorting width_8">Item Description</th>
																	<th class="sorting width_2">EDD</th>
																	<th class="sorting width_2">Vendor UOM</th>
																	<th class="sorting width_1">Vendor Qty</th>
																	<th class="sorting width_1">Available Qty</th>
																	<th class="sorting width_4"
																		style="padding: 0 !important; line-height: 34px;">Unit
																		Price</th>
																	<th class="sorting width_5">Old Unit Price</th>
																	<th class="sorting width_5">Price</th>
																	<th class="sorting width_5">Discount Type</th>
																	<th class="sorting width_4"
																		style="padding: 0 !important; line-height: 34px;">Discount</th>
																	<!-- <th class="sorting width_2"  style="padding: 0 !important;line-height: 34px;">Discount(%)</th>
			         -->
																	<!--   <th class="sorting width_7" >Tax Type</th>
			           <th class="sorting width_7" >Tax</th> -->
																	<th class="sorting width_4">Net Price</th>
																	<th class="sorting width_4">CGST</th>
																	<th class="sorting width_4">SGST</th>
																	<th class="sorting width_4">IGST</th>
																	<th class="sorting width_3">CGST(%)</th>
																	<th class="sorting width_3">SGST(%)</th>
																	<th class="sorting width_3">IGST(%)</th>
																	<th class="sorting width_5">Total</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-controller="parentCtrl"
																	ng-repeat="departmentCollections in displayedCollectionItemA track by $index"
																	ng-hide="departmentCollections.edit == '2'">
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox"
																			ng-model="departmentCollections.select"> <i></i>
																	</label></td>
																	<td
																		style="position: sticky; left: 0%; background-color: #efbea2;">{{departmentCollections.requisitionNo}}</td>
																	<td
																		style="position: sticky; left: 26%; background-color: #efbea2;">
																		{{departmentCollections.purchaseItemName}}</td>
																	<!-- <td>{{departmentCollections.purchaseQuoteId}}</td> -->

																	<td title={{departmentCollections.purchaseItemDesc}}>{{departmentCollections.purchaseItemDesc}}</td>
																	<td>{{departmentCollections.edd}}</td>
																	<td>{{departmentCollections.uomName}}</td>
																	<td><input type="text"
																		style="text-align: right; width: 50px;"
																		ng-model="departmentCollections.quantity"
																		ng-blur="checkPartiallyVerified(departmentCollections)"
																		placeholder="0"
																		ng-blur="calculateTaxDiscountEdit(departmentCollections)"
																		ng-pattern-restrict="^[0-9.]*$"
																		ng-init="calculateTaxDiscount(departmentCollections)"
																		maxlength="5" ng-pattern-restrict="{{numExp}}"
																		ng-keyup="validateQty(departmentCollections.quantity,$index);"
																		name="{{ 'quatity' + $index }}" validation="required"
																		friendly-name="{{ 'Row' + $index + '(Quantity)'}}"
																		disabled="disabled"></td>

																	<td style="text-align: right;">{{departmentCollections.availableQty}}</td>
																	<td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.price}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
																	<td style="text-align: right;">{{departmentCollections.discount}}</td>
																	<!-- 			           <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.dicountPercentage}}</td>
 -->
																	<!--   <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td>
			           <td  style="text-align: right;">{{departmentCollections.tax}}</td> -->
																	<td style="text-align: right;">{{departmentCollections.netPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGSTinPercent}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGSTinPercent}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGSTinPercent}}</td>
																	<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																	<!-- <td>{{departmentCollections.purchaseStatus}}</td> -->
																	<!-- <td>{{departmentCollections.purchaseItemDesc}}</td> -->
																	<!-- <td>{{departmentCollections.vendorName}}</td> -->
																	<!--  <td>{{departmentCollections.deliveryLeadTime}}</td> -->
																	<!-- <td class=" td-actions text-center">
					        <span>
					         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(departmentCollections)"></i>
					        </span>
					        <span>
					         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(departmentCollections)"></i>
					        </span>
			       </td> -->
																</tr>
															</tbody>
														</table>
														<!-- 			        <div class="dt-toolbar-footer" -->
														<!-- 			         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
													</div>
												</div>
												<!-- end widget content -->
											</div>
										</div>
										<!-- 		</div>
				</div> -->


										<br> <label
											style="left: 5%; color: black; font-size: 14px; font-weight: bolder;">OLD
											PO</label>
										<!-- <div class="col-sm-12 col-md-12 col-lg-12 ">
			      <div role="content"> -->
										<!-- <div class="panel-body"> -->
										<div class="widget-body no-padding">
											<div class="table-responsive">
												<div class="col-md-12" style="width: 250%;">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
														data-st-table="displayedCollectionItem"
														data-st-safe-src="rowCollectionItem">
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 table-heading text-center"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox" ng-model="selectedAll"
																			ng-change="checkAll(displayedCollectionItem,selectedAll)">
																			<i></i>
																	</label></th>
																	<th class="sorting width_10"
																		style="position: sticky; left: 0%; background-color: #f76060;color: white;'">Purchase
																		Requisition Number</th>
																	<th class="sorting width_10"
																		style="position: sticky; left: 26%; background-color: #f76060;color: white;">Item
																		Code-Item Name</th>
																	<!--    <th class="sorting width_10" >Purchase Quote Number</th> -->

																	<th class="sorting width_8">Item Description</th>
																	<th class="sorting width_2">EDD</th>
																	<th class="sorting width_2">Vendor UOM</th>
																	<th class="sorting width_1">Vendor Qty</th>
																	<th class="sorting width_1">Available Qty</th>
																	<th class="sorting width_4"
																		style="padding: 0 !important; line-height: 34px;">Unit
																		Price</th>
																	<th class="sorting width_5">Old Unit Price</th>
																	<th class="sorting width_5">Price</th>
																	<th class="sorting width_5">Discount Type</th>
																	<th class="sorting width_4"
																		style="padding: 0 !important; line-height: 34px;">Discount</th>
																	<!--  <th class="sorting width_2"  style="padding: 0 !important;line-height: 34px;">Discount(%)</th>
			        -->
																	<!--   <th class="sorting width_7" >Tax Type</th>
			           <th class="sorting width_7" >Tax</th> -->
																	<th class="sorting width_4">Net Price</th>
																	<th class="sorting width_4">CGST</th>
																	<th class="sorting width_4">SGST</th>
																	<th class="sorting width_4">IGST</th>
																	<th class="sorting width_3">CGST(%)</th>
																	<th class="sorting width_3">SGST(%)</th>
																	<th class="sorting width_3">IGST(%)</th>
																	<th class="sorting width_5">Total</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-controller="parentCtrl"
																	ng-repeat="departmentCollections in displayedCollectionItem track by $index"
																	ng-hide="departmentCollections.edit == '2'">
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox"
																			ng-model="departmentCollections.select"> <i></i>
																	</label></td>
																	<td
																		style="position: sticky; left: 0%; background-color: #efbea2;">{{departmentCollections.requisitionNo}}</td>
																	<td
																		style="position: sticky; left: 26%; background-color: #efbea2;">{{departmentCollections.purchaseItemName}}</td>
																	<!-- <td>{{departmentCollections.purchaseQuoteId}}</td> -->

																	<td title={{departmentCollections.purchaseItemDesc}}>{{departmentCollections.purchaseItemDesc}}</td>
																	<td>{{departmentCollections.edd}}</td>
																	<td>{{departmentCollections.uomName}}</td>
																	<td><input type="text"
																		style="text-align: right; width: 50px;"
																		ng-model="departmentCollections.quantity"
																		ng-blur="checkPartiallyVerified(departmentCollections)"
																		placeholder="0"
																		ng-blur="calculateTaxDiscountEdit(departmentCollections)"
																		ng-pattern-restrict="^[0-9.]*$"
																		ng-init="calculateTaxDiscount1(departmentCollections)"
																		maxlength="5" ng-pattern-restrict="{{numExp}}"
																		ng-keyup="validateQty(departmentCollections.quantity,$index);"
																		name="{{ 'quatity' + $index }}" validation="required"
																		friendly-name="{{ 'Row' + $index + '(Quantity)'}}"
																		disabled="disabled"></td>

																	<td style="text-align: right;">{{departmentCollections.availableQty}}</td>
																	<td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.price}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
																	<td style="text-align: right;">{{departmentCollections.discount}}</td>
																	<!-- 			           <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.dicountPercentage}}</td>
 -->
																	<!--   <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td>
			           <td  style="text-align: right;">{{departmentCollections.tax}}</td> -->
																	<td style="text-align: right;">{{departmentCollections.netPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGSTinPercent}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGSTinPercent}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGSTinPercent}}</td>
																	<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																	<!-- <td>{{departmentCollections.purchaseStatus}}</td> -->
																	<!-- <td>{{departmentCollections.purchaseItemDesc}}</td> -->
																	<!-- <td>{{departmentCollections.vendorName}}</td> -->
																	<!--  <td>{{departmentCollections.deliveryLeadTime}}</td> -->
																	<!-- <td class=" td-actions text-center">
					        <span>
					         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(departmentCollections)"></i>
					        </span>
					        <span>
					         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(departmentCollections)"></i>
					        </span>
			       </td> -->
																</tr>
															</tbody>
														</table>
														<br> <br>
														<!-- 			        <div class="dt-toolbar-footer" -->
														<!-- 			         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
													</div>
												</div>
												<!-- end widget content -->
											</div>
										</div>
									</div>

								</div>


								<!-- <div class="form-action"
								>
								<button style="background-color: red;color: white;left: 45%;" ng-click = "back()"> BACK
								</button></div> -->

							</form>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>