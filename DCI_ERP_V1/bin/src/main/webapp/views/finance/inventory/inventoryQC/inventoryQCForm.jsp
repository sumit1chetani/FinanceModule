<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">

					<div class="row book-widget-row" style="padding-bottom: 12px;"
						ng-init="init()">
						<form class="form-horizontal" name="grnAdd"
							ng-submit="return false">
							<input type="hidden" class="form-control input-sm" data-ng-model="grnData.grnId" >
							<!-- Form field start -->
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class ="col-md-6">
										<div class="form-group" data-ng-if="isEdit">
											<label class="col-md-4 control-label">GRN No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.grnCode" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">GRN Date<span style = "color:red">*</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.grnDate" readonly>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Source Location<span style = "color:red">*</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.locName" readonly>
												<!-- <selectivity list="locationList" property="grnData.locId" id="srclocation"></selectivity> -->
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Destination Location<span style = "color:red">*</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.dstLocName" readonly>
												<!-- <selectivity list="locationList" property="grnData.dstLocId" id="dstlocation"></selectivity> -->
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Vendor Name<span style = "color:red">*</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.vendorName" readonly>
												<!-- <selectivity list="vendorList" property="grnData.vendorId" id="ac.vendorName"></selectivity> -->
											</div>
										</div>

										<div class="form-group">
								            <label class="col-md-4 control-label"> Vendor Address
								            </label>
								            <div class="col-md-7">
									             <div class="col-md-12 no-padding ">
									             	<textarea class="text-left form-control input-sm" rows="2" cols="15"  style="resize: none" readonly ng-model="purchaseData.address"> </textarea>
									             </div>
									             <div class="col-md-12 no-padding">
										             <div class="col-md-6 no-padding padding-top-5 ">
															<input type="text" class="form-control input-sm" placeholder="city" readonly  ng-model="purchaseData.city">
										             </div>
										             <div class="col-md-6 no-padding padding-top-5 ">
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseData.state" readonly>
										             </div>
										             <div class="col-md-12 no-padding padding-top-5 ">
										             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseData.country" readonly>
										             </div>
									             </div>
								             </div>
							            </div>
							            </div>
									<div class ="col-md-6">
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
										<div class="form-group">
											<label class="col-md-4 control-label">Purchase Order<span style = "color:red">*</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.poNo" readonly>
												<!-- <selectivity list="poList" property="grnData.poId" id="pOrderNo"></selectivity> -->
											</div>

											<!-- <span> <i class="fa fa-list-alt text-dark text"
												title="View Purchase Quote"
												style="padding-left: 0px; padding-top: 7px;"
												data-ng-click="getPurchaseInfo()"></i>
											</span> -->
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
											<!-- <span> <i class="fa fa-list-alt text-dark text"
												title="View Requisition Details"
												style="padding-left: 0px; padding-top: 7px;"
												data-ng-click="getReqInfo()"></i>
											</span> -->
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Mode of
												Transport<span style = "color:red">*</span></label>
											<div class="col-md-7">
												<select class="form-control input-sm" data-ng-model="grnData.transMode" disabled="disabled">
													<option value>Select</option>
													<option value=1>Person</option>
													<option value=2>Courier</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Invoice No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.invoiceNo" readonly>
											</div>

										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Invoice Date </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="grnData.invoiceDate" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Delivery Order
												No</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" data-ng-model="grnData.delOrderNo" readonly>
											</div>

										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Delivery Order
												Date </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" data-ng-model="grnData.delOrderDate" readonly>
											</div>
										</div>
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
															<th  class="sorting width_7">Price</th>
															<th class="sorting width_7">Pending Qty</th>
															<th class="sorting  width_7">Receiving Qty</th>
															<th class="sorting  width_5">QC</th>
															<th  class="sorting width_5">Info</th>
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

															<td class="width_7">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlPrice" name="dtlPrice"
																			readonly="readonly" style="text-align: right;" />
															</td>
															<td class="width_7">
																		<input type="text" class="form-control input-sm" ng-model="row.pendingQty" name="pQty"
																			readonly="readonly" style="text-align: right;" />
															</td>
															<td class="width_7" data-ng-if="!isEdit">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlQty" name="dQty" style="text-align: right;" ng-disabled="grnData.poType!='Regular'" />
																		<input type="hidden" class="form-control input-sm" ng-model="row.dtlPODtlId" name="dtlPODtlId" />
															</td>
															<td class="width_7" data-ng-if="isEdit">
																		<input type="text" class="form-control input-sm" ng-model="row.dtlQty" name="dQty" readonly="readonly" style="text-align: right;" />
																		<input type="hidden" class="form-control input-sm" ng-model="row.dtlPODtlId" name="dtlPODtlId" />
															</td>
															<td class="width_5" data-ng-if="!row.qualityCheck">

															</td>
															<td class="width_5" data-ng-if="row.qualityCheck">
																	<button class="btn btn-sm ng-scope" type="button"
																		class="btn btn-success" ng-click="getQCInfo(trIndex)" ng-disabled="row.dtlStatus == 150" >
																		<i class="fa fa-check-circle-o"></i>
																	</button>
															</td>
															 <td class="width_5">
																	<label class="col-xs-12"
																		data-ng-click="getProductInfo(trIndex)"><span class="fa fa-expand"></span></label>
															</td>
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
													            <th class="sorting width_7">Receiving Qty</th>
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
																<td><input type="text" style="text-align: right;" ng-model="schCollectionsDelivery.scheduleItemQty" ng-disabled="isEdit"
					           										placeholder="0" ng-focus="getCurrentQty(schCollectionsDelivery)" ng-blur="getScheduleQty(schCollectionsDelivery,true)"></td>
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

							</div>
							<!-- Form field end -->


							<!-- Button Action Div Start-->

							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="submit"
											data-ng-click="onSubmit(grnData)"
											data-ng-if="!isEdit" >
											<i class="fa fa-save"></i>Save
										</button>
										<button class="btn btn-success" type="submit"
											data-ng-click="onSubmit(grnData)"
											data-ng-if="isEdit && grnData.grnStatus!=151">
											<i class="fa fa-save"></i>Update
										</button>
										<button class="btn btn-danger" type="button"
											class="btn btn-success" ng-click="cancel()">
											<i class="fa fa-close"></i>Cancel
										</button>
									</div>
								</div>
							</div>

							<!-- Button Action Div End-->
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
