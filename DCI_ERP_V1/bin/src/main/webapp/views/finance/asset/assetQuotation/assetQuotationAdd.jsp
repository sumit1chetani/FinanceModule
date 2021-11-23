<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetQuotationForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-6">

											<div class="form-group">
												<label class="col-md-3 control-label"> Vendor <spring:message
														code="label.asterisk.symbol"></spring:message></label>
												<div class="col-md-7">
													<selectivity list="vendorList" ng-model="assetQuotation.vendorId"
														property="assetQuotation.vendorId" id="vendorId" object="vendorId"  name="vendorId"
			        				validation="required" friendly-name="Vendor" form-name = "assetQuotationForm"></selectivity>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-3 control-label"> Vendor
													Address</label>
												<div class="col-md-7">
													<div class="col-md-12 no-padding">
														<textarea class="text-left form-control input-sm" rows="2"
															cols="15" style="resize: none" readonly
															ng-model="assetQuotation.vendorAddress"> </textarea>
													</div>
													<div class="col-md-12 no-padding">
														<div class="col-md-5 no-padding padding-top-5">
															<input type="text" class="form-control input-sm"
																placeholder="city" ng-model="assetQuotation.cityName"
																readonly>
														</div>
														<div
															class="col-md-4 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
																placeholder="state" ng-model="assetQuotation.state"
																readonly>
														</div>
														<div
															class="col-md-3 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
																placeholder="zip" ng-model="assetQuotation.zipcode"
																readonly>
														</div>
													</div>
													<div class="col-md-12 no-padding padding-top-5">
														<input type="text" class="form-control input-sm"
															placeholder="country" ng-model="assetQuotation.country"
															readonly>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label"> Remarks </label>
												<div class="col-md-7">
													<textarea class="text-left form-control input-sm" rows="4"
														cols="20" style="resize: none"
														ng-model="assetQuotation.remarks"> </textarea>
												</div>
											</div>
											<br>
											<br>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label"> AQ Date </label>
												<div class="col-md-7">
													<div class='input-group date width_100 datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="curDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="currentDate"
																		data-validator="required" data-valid-method="submit"
																		data-message-id="currentDate"
																		data-ng-model="assetQuotation.quoteDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="assetQuotation.quoteDate"
																	data-on-set-time="assetQuotation.quoteDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-3 control-label"> Purchase Type </label>
												<div class="col-md-7">
												<input type="text" class="form-control input-sm" placeholder="Regular" Readonly>
												</div>
											</div>
											<div class="form-group">
					        				<label class="col-md-3 control-label"> Hospital <spring:message
					              			code="label.asterisk.symbol"></spring:message></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="assetQuotation.companyId" id="companyId"
						        				ng-model="assetQuotation.companyId" name="companyId" form-name = "assetQuotationForm"
						        				validation="required" friendly-name="Hospital"></selectivity>
											</div>
										</div>
											<div class="form-group width_100 padding-left-177"
												ng-if="fixedPriceAndQuantity">
												<div class="col-md-1">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="assetQuotation.fixedPrice"
															data-ng-true-value="'Y'" data-ng-false-value="'N'" /> <span></span>
														</label>
													</div>

												</div>
												<label
													class="col-md-4 text-aling-left control-label padding-top-10">Fixed
													Price</label>
												<div class="col-md-1">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="assetQuotation.fixedQty"
															data-ng-true-value="'Y'" data-ng-false-value="'N'" /> <span></span>
														</label>
													</div>

												</div>
												<label
													class="col-md-4 text-aling-left control-label padding-top-10">Fixed
													Qty</label>
											</div>

											
											<fieldset class="b-a width_72 margin-bottom-10 margin-left-12">
							            		<legend class="width_25 b-a margin-bottom-10 padding-left-10 margin-left-5">Validity</legend>
								            	<div class="form-group">
								       				<label class="col-md-3 control-label"> From Date <spring:message
							             			code="label.asterisk.symbol"></spring:message></label>
								       				<div class="col-md-7">
														<div class='input-group date width_100 datetimepick'>
												            <div class="dropdown">
												             <a class="dropdown-toggle" id="from_date" role="button"
												              data-toggle="dropdown" data-target="#" href="#">
												              <div class="input-group">
												               <input type="text" class="form-control"
												                placeholder="dd/mm/yyyy" name="From Date"
												                validation="date_euro_long|required"
												                friendly-name="From Date"
												                data-ng-model="assetQuotation.validFromDate"><span
												                class="input-group-addon"><i
												                class="glyphicon glyphicon-calendar"></i></span>
												              </div>
												             </a>
												             <ul class="dropdown-menu" role="menu"
												              aria-labelledby="dLabel">
												              <datetimepicker data-ng-model="assetQuotation.validFromDate"
												               data-on-set-time="assetQuotation.validFromDate = onDateSet(newDate)"
												               data-datetimepicker-config="{ dropdownSelector: '#from_date',startView:'day', minView:'day'}" />
												             </ul>
												            </div>
												        </div> 
													</div>
												</div>
												<div class="form-group">
								       				<label class="col-md-3 control-label"> To Date </label>
								       				<div class="col-md-7">
														<div class='input-group date width_100 datetimepick'>
												            <div class="dropdown">
												             <a class="dropdown-toggle" id="to_date" role="button"
												              data-toggle="dropdown" data-target="#" href="#">
												              <div class="input-group">
												               <input type="text" class="form-control"
												                placeholder="dd/mm/yyyy" name="To Date"									                
												                data-ng-model="assetQuotation.validToDate"><span
												                class="input-group-addon"><i
												                class="glyphicon glyphicon-calendar"></i></span>
												              </div>
												             </a>
												             <ul class="dropdown-menu" role="menu"
												              aria-labelledby="dLabel">
												              <datetimepicker data-ng-model="assetQuotation.validToDate"
												               data-on-set-time="assetQuotation.validToDate = onDateSet(newDate)"
												               data-datetimepicker-config="{ dropdownSelector: '#to_date',startView:'day', minView:'day'}" />
												             </ul>
												            </div>
												        </div> 
													</div>
												</div>
							            	</fieldset>
							            	<div class="form-group" ng-if="isPmtTerms">
									            <label class="col-md-3 control-label"> Payment Terms</label>
									            <div class="col-md-7">
									            	<input class="text-left form-control input-sm" ng-model="assetQuotation.paymentTerms" />
									            </div>
									            <span class="pull-left line-height-30">Days</span>
									        </div>	
										</div>
										<div class="col-sm-12 col-md-12 col-lg-12">											
											<div role="content">
												<div class="widget-body padding-top-10">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollection"
														data-st-safe-src="rowCollection">
														<div class="padding-left-10 padding-top-5"
															id="AddOrRmveMeritbtn">
															<button ng-click="addAssetRow()"
																class="btn btn-sm btn-primary" tooltip="Add"
																ng-disabled="" type="button">
																<i class="fa fa-plus"></i>
															</button>
															<button ng-click="removeAssetRow()"
																class="btn btn-sm btn-danger" type="button"
																tooltip="Delete">
																<i class="fa  fa-trash-o"></i>
															</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="sorting width_1" data-st-sort=""></th>
																	<th class="sorting width_1 visible-left"
																		data-st-sort="">Quot Dtl Id</th>
																	<th class="sorting width_1 visible-left"
																		data-st-sort="">Quot Id</th>
																	<th class="sorting width_7" data-st-sort="">Req.
																		No</th>
																	<!-- <th class="sorting width_10" data-st-sort="">Req. Location</th> -->
																	<th class="sorting width_8" data-st-sort="">Item
																		Code</th>
																	<th class="sorting width_8" data-st-sort="">Item
																		Name</th>
																	<th class="sorting width_5" data-st-sort="">EDD</th>
																	<th class="sorting width_5" data-st-sort="">UOM</th>
																	<th class="sorting width_12" data-st-sort=""
																		data-ng-if="consignmentQtyLabel">Consignment Qty</th>
																	<th class="sorting width_5" data-st-sort=""
																		data-ng-if="!consignmentQtyLabel">Qty</th>
																	<!-- <th class="sorting width_7" data-st-sort="">Lead Time</th> -->
																	<th class="sorting width_7" data-st-sort="">Unit
																		Price</th>
																	<th class="sorting width_7" data-st-sort="">Price</th>
																	<th class="sorting width_10" data-st-sort="">Discount
																		Type</th>
																	<th class="sorting width_7" data-st-sort="">Discount</th>
																	<th class="sorting width_7" data-st-sort="">Tax
																		Type</th>
																	<th class="sorting width_7" data-st-sort="">Tax</th>
																	 <th class="sorting width_7" data-st-sort="">Sub Total</th>
																</tr>
															</thead>
															<tbody>
																<tr
																	ng-repeat="quotationDtl in assetQuotation.assetDetailList">
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox" ng-model="tableSelection[$index]"
																			id="section$index"><i></i></label></td>
																	<td class="visible-left">{{quotationDtl.quotationDetailId}}</td>
																	<td class="visible-left">{{quotationDtl.quotationId}}</td>
																	<td>{{quotationDtl.requisitionNo}}</td>
																	<!-- <td>{{quotationDtl.requisitionNo}}</td> -->
																	<td>{{quotationDtl.itemCode}}</td>
																	<td>{{quotationDtl.itemName}}</td>
																	<td>{{quotationDtl.eddDate}}</td>
																	<td>{{quotationDtl.uomName}}</td>
																	<td>{{quotationDtl.quantity}}</td>
																	<!-- <td>{{quotationDtl.deliveryLeadTime}}</td> -->
																	<td>{{quotationDtl.unitPrice}}</td>
																	<td>{{quotationDtl.amount}}</td>
																	<td>{{quotationDtl.discountType}}</td>
																	<td>{{quotationDtl.disAmt}}</td>
																	<td>{{quotationDtl.taxType}}</td>
																	<td>{{quotationDtl.taxAmt}}</td>
																	<td class="text-aling-right">{{quotationDtl.rowSubTotal}}</td>
																	<!-- <td>{{quotationDtl.status}}</td> -->
																</tr>
															</tbody>
														</table>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<br>
										</div>
										<div class="col-md-12 padding-top-20" id="totalValues">
											<div class="form-group">
												<label class="col-md-1 control-label"> Price </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetQuotation.subTotal" readonly />
												</div>
												<label class="col-md-1 control-label"> Discount </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetQuotation.totalDiscount" readonly />
												</div>
												<label class="col-md-1 control-label"> Tax </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetQuotation.totalTax" readonly />
												</div>
												<label class="col-md-1 control-label"> Freight </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetQuotation.totalFreight"
														ng-keyup="calGrandTotalWithFreight(assetQuotation.totalFreight)" />
												</div>
												<label class="col-md-1 control-label"> Total </label>
												<div class="col-md-2">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetQuotation.grandTotal" readonly />
												</div>
											</div>
										</div>
										<!-- /col-md-12 -->
									</div>
								</div>
								<div class="form-actions">
									<div class="row" style="PADDING-BOTTOM: 60PX;">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="validate(assetQuotationForm,assetQuotation)"data-ng-if="!edit">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" id="update"
												data-ng-click="validate(assetQuotationForm,assetQuotation)" data-ng-if="edit">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												data-ng-click="reset(assetQuotationForm);">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												<spring:message code="label.cancel"></spring:message>
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