
<style>
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
</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
	
							<form class="form-horizontal" name="purchaseQuoteRequestForm"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label"> Requisition
														No <spring:message code="label.asterisk.symbol"></spring:message>
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
													<label class="col-md-4 control-label"> Item Code<spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<!-- <selectivity list="itemList" property="quotationDetail.itemId" id="txtItemId" object="itemobj"></selectivity> -->
														<!-- <select class="form-control input-sm" ng-model="quotationDetail.itemId" ng-change="getItem()"
		             	ng-options="item.itemId as item.itemCode for item in itemList">
		              		<option value="">Select</option>
		              	</select> -->
														<selectivity list="itemList"
															ng-model="quotationDetail.itemId"
															property="quotationDetail.itemId" id="txtItem"
															object="itemObj" name="Item" validation="required"
															friendly-name="Item Code"
															form-name="purchaseQuoteRequestForm"></selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Item
														Description </label>
													<div class="col-md-7">
														<textarea class="text-left form-control input-sm" rows="4"
															cols="25" ng-model="quotationDetail.itemDescription"
															style="resize: none"> </textarea>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> EDD </label>
													<div class="col-md-7">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="currentDate"
															data-ng-model="quotationDetail.eddDate" readonly />
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Tax <spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<!-- 	<selectivity list="taxList" ng-model="quotationDetail.taxId"
        				property="quotationDetail.taxId" id="txtTaxId"  object="taxObj"  name="tax"
        				validation="required" friendly-name="Tax" form-name = "purchaseQuoteRequestForm"></selectivity>  -->
														<!-- <ui-select multiple ng-model="quotationDetail.taxIdslist" 
							ng-disabled="disabled" name="taxIdslist" validation="required" friendly-name="Tax" form-name = "purchaseQuoteRequestForm">
						<ui-select-match placeholder="Select..." >{{$item.text}}</ui-select-match>
						<ui-select-choices
							 repeat="ed.id as ed in taxList | filter:$select.search">{{ed.text}}</ui-select-choices>
						</ui-select> -->
														<select id="txtTaxId" multiple="multiple" name="txtTaxId"
															ng-model="quotationDetail.taxIdslist"
															validation="required" friendly-name="Tax"
															form-name="purchaseQuoteRequestForm"
															data-dropdownmultiselect>
															<option ng-repeat="obj in taxList" value="{{obj.id}}">{{obj.text}}</option>
														</select> <input type="hidden"
															data-ng-model="purchaseQuotationDetail.taxPercentage" />
														<input type="hidden"
															data-ng-model="purchaseQuotationDetail.taxAmount" /> <input
															type="hidden"
															data-ng-model="purchaseQuotationDetail.subTaxPercentage" />
														<input type="hidden"
															data-ng-model="purchaseQuotationDetail.subTaxAmount" />
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Discount </label>
													<div class="col-md-4">
													<select class="form-control input-sm"
															ng-model="quotationDetail.discountTypeId"
															style="width: 116% !important"
															ng-options="discount.defTableId as discount.value for discount in discountTypeList"
															ng-change="getDiscountDetails(quotationDetail.discountTypeId,discountTypeList)">
															<option value="">Select</option>
														</select>
												<!-- 	<selectivity list="discountTypeList"
															ng-model="quotationDetail.discountTypeId"
															property="quotationDetail.discountTypeId" id="discountTypeId"
															object="discountTypeId" name="discountTypeId" 
															ng-change="getDiscountDetails(quotationDetail.discountTypeId,discountTypeList)"
															friendly-name="Status"
															form-name="purchaseQuoteRequestForm"></selectivity> -->
													</div>
													<div class="col-md-3" ng-if="discountPercent">
														<input class="form-control input-sm pull-left"
															style="width: 100% !important"
															ng-pattern-restrict="^[0-9.]*$"
															ng-model="quotationDetail.discountPercent"
															ng-keyup="changeAmountDiscount(quotationDetail.discountPercent)"
															name="discountpercent" /> <span class="pos-abs-top-4">
															%</span>
													</div>
													<div class="col-md-3" ng-if="discountAmt">
														<input class="form-control input-sm pull-left"
															ng-blur="changeAmount(quotationDetail.discountAmount)"
															style="width: 100% !important" name="discountamount"
															ng-model="quotationDetail.discountAmount"
															ng-pattern-restrict="^[0-9.]*$" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Lead Time </label>
													<div class="col-lg-7">
														<input type="text"
															class="form-control input-sm text-aling-right"
															ng-blur="changeLeadAmount(quotationDetail.deliveryLeadTime)"
															ng-model="quotationDetail.deliveryLeadTime"
															placeholder="0" ng-pattern-restrict="{{numExp}}" />
													</div>
													<label class="control-label">Days</label>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Status </label>
													<div class="col-md-7">
															<selectivity list="statusList"
															ng-model="quotationDetail.queryStatus"
															property="quotationDetail.queryStatus" id="queryStatus"
															object="queryStatus" name="queryStatus" 
															friendly-name="Status"
															form-name="purchaseQuoteRequestForm"></selectivity>
													<!-- 	<select class="form-control input-sm"
															ng-model="quotationDetail.queryStatus"
															ng-options="status.defTableId as status.value for status in statusList">
															<option value="">Select</option>
														</select> -->
													</div>
												</div>
											</fieldset>
										</div>

										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label"> Requisition
														Date </label>
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
																<!-- <ul class="dropdown-menu" role="menu"
				              aria-labelledby="dLabel">
				              <datetimepicker data-ng-model="quotationDetail.reqDate"
				               data-on-set-time="quotationDetail.reqDate = onDateSet(newDate)"
				               data-datetimepicker-config="{ dropdownSelector: '#reqDate',startView:'day', minView:'day'}" />
				             </ul> -->
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Item Name </label>
													<div class="col-lg-7">
														<input type="text" class="form-control input-sm"
															ng-model="quotationDetail.itemName" />
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
												<div class="form-group">
													<label class="col-md-4 control-label"> Purchase UOM</label>
													<div class="col-md-7">
														<input type="hidden"
															class="form-control input-sm text-aling-right"
															ng-model="quotationDetail.uom" /> <input type="text"
															class="form-control input-sm text-aling-right"
															ng-model="quotationDetail.uomName" readonly />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label" style="width: 33.7%;">
														Purchase Request Quantity<spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<input type="text" maxlength="5"
															class="form-control input-sm text-aling-right"
															name="quantity" id="quantity"
															ng-model="quotationDetail.quantity" validation="required"
															friendly-name="Quantity" ng-pattern-restrict="{{numExp}}"
															ng-blur="validateQuantity(quotationDetail.quantity);"  />	
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Vendor UOM <spring:message
															code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<!-- <input type="hidden" class="form-control input-sm text-aling-right" ng-model="quotationDetail.vendoruom" />
		             	<input type="text" class="form-control input-sm text-aling-right" ng-model="quotationDetail.vendorUomName" readonly /> -->
														<selectivity list="uomCategoryList"
															ng-model="quotationDetail.vendoruom"
															property="quotationDetail.vendoruom" id="vendoruom"
															name="vendoruom" object="vendorUomId"
															validation="required" friendly-name="Vendor UOM"
															form-name="purchaseQuoteRequestForm"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Vendor
														Quantity<spring:message code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<input type="hidden"
															class="form-control input-sm text-aling-right"
															ng-model="quotationDetail.vendorConvertedQuantity" /> <input
															type="text" maxlength="5"
															class="form-control input-sm text-aling-right"
															name="vendorQuantity" id="vendorQuantity"
															ng-model="quotationDetail.vendorQuantity"
															validation="required" friendly-name="Vendor Quantity"
															ng-pattern-restrict="{{numExp}}"
															ng-blur="validateVendorQuantity(quotationDetail.vendorQuantity);" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Unit Price<spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-aling-right"
															id="unitPrice" validation="required"
															friendly-name="Unit Price" name="unitPrice"
															ng-model="quotationDetail.unitPrice"
															ng-pattern-restrict="^[0-9.]*$"
															ng-blur="onChangeDecimal('unitPrice',quotationDetail.unitPrice)" />
													</div>
												</div>
											</fieldset>
										</div>
									</div>
									<!-- /col-sm-12 col-md-12 col-lg-12 -->
								</div>
								<!-- /row -->
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<%-- <button class="btn btn-success" type="button"
            data-ng-if="!isEdit"
            ng-click="saveDetail()" class="btn btn-success">
            <i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
           </button> --%>
											<button class="btn btn-success" type="button"
												data-ng-if="!isEdit"
												data-ng-click="validatePQDetail(purchaseQuoteRequestForm,quotationDetail)"
												class="btn btn-success">
												<i class="fa fa-save"></i> Add to List
											</button>
											<!-- -->
											<button class="btn btn-success" type="button"
												data-ng-if="isEdit == true" class="btn btn-success"
												ng-click="updateDetail()">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button type="reset" class="btn btn-info"
												ng-click="resetPurchaseQuotationDetail(purchaseQuoteRequestForm)">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="reset"
												class="btn btn-success" ng-click="cancelReq()">
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