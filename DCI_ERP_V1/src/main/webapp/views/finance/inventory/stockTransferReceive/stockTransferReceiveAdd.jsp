<%-- <style>
table.dataTable thead .sorting:after {
	content: "";
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->

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
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body"> --%>
						
						<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="stockReceiveForm"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
									<fieldset>
										<div class="col-md-6">
											<div class="form-group" ng-show="isEdit">
												<label class="col-md-4 control-label">Stock
													Transfer No</label> <label class="col-md-1 control-label">{{stockReceive.stockId}}
												</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="stockId" ng-model="stockReceive.receivedNo"
														ng-show="!isEdit">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Receive Date</label>
												<div class="col-md-7">
													<!-- <div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="fromdate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		data-valid-method="submit" data-message-id="From Date"
																		data-ng-model="stockReceive.receivedDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="stockReceive.receivedDate"
																	data-on-set-time="stockReceive.receivedDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div> -->
													
													 <ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="stockReceive.receivedDate"
										id="requisitionDate" name="requisitionDate"
										data-ng-change="checkDatesCL(stockReceive.receivedDate)"
										friendly-name="Valid From" validation="required" />
												</div>
											</div>
										<div class="form-group">
					        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name</label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="stockReceive.companyId" id="hospital"
						        				ng-model="stockReceive.companyId" name="hospital" form-name ="stockReceiveForm"
						        				validation="required" friendly-name=""></selectivity>
											</div>
										</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Source
													Location</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Source Location"
														ng-model="stockReceive.sourceLocName"
														id="sourceLocName" readonly="readonly">

												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Destination
													Location</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Destination Location"
														ng-model="stockReceive.destLocName" id="destLocName"
														readonly="readonly">

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Requested By</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="AssetCode"
														ng-model="stockReceive.requestedBy"
														id="requestedby" readonly="readonly">
												</div>
											</div>
									</div>
										<div class="col-md-6">
										<div class="form-group">
												<label class="col-md-4 control-label"> Stock Transfer No<span style="color:red;">*</span> </label>
												<div class="col-md-7">
													<selectivity list="stockTransferList"
														property="stockReceive.transferId"
														ng-model="stockReceive.transferId"
														name="requisition" form-name="stockReceiveForm"
														validation="required" friendly-name="Transfer No"
														id="transNo"></selectivity>

												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Transfer Date</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Requisition Date"
														ng-model="stockReceive.transferDate"
														id="requisitiondate" readonly="readonly">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Received By</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="AssetCode"
														ng-model="stockReceive.receivedByCode"
														id="requestedby" readonly="readonly">
												</div>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label ">Received Note</label>
												<div class="col-md-7">
													<textarea rows=2 class="form-control input-sm resize-none"
														name="AssetCode"
														ng-model="stockReceive.receivedNote"
														id="requestedby">
														</textarea>
												</div>
										</div>
										</div>
										</fieldset>
										</div>
										</div>

								<!-- <div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<br>
										<div role="content">
											<div class="widget-body no-padding">
												<div
													class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
													data-st-table="displayedCollection"
													data-st-safe-src="transferDtls">
													<table id="dt_basic"
														class="table table-striped table-bordered table-hover dataTable no-footer"
														role="grid" aria-describedby="dt_basic_info">
														<thead class="dataTables-Main-Head"> -->
														<div class="row">
										
																	<div class="table-responsive" >
															<div
																class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
																data-st-table="displayedCollectionItem"
																data-st-safe-src="rowCollectionItem">
																<table id="dt_basic"
																	class="table table-striped table-bordered table-hover dataTable no-footer"
																	role="grid" aria-describedby="dt_basic_info"  style="width: 220%;">
																	<thead class="dataTables-Main-Head">
														
															<tr>
																<th class="sorting width_15" data-st-sort="">Item
																	Code-Item Name</th>
																<th class="sorting width_10" data-st-sort="">
																	Transfer Quantity</th>
																<th class="sorting width_10" data-st-sort="">
																	Pending Quantity</th>
																<th class="sorting width_10" data-st-sort="">
																	Received Quantity</th>
																	<!-- <th class="table-heading width_5">Batch No</th> -->

															</tr>
															<tr ng-repeat="(trIndex,receiveRow) in stockReceive.transferDtls" >
																<td colspan=1 class="width_5">
																	<input type="hidden" ng-model="receiveRow.itemId">
																	<input type="text" ng-model="receiveRow.text"
																	class="form-control input-sm" readonly="readonly" style="width:340px;"></td>

																<td colspan=1 class="width_2"><input type="text"
																	ng-model="receiveRow.transferQty"
																	class="form-control input-sm text-right"
																	readonly="readonly"></td>

																<td colspan=1 class="width_2"><input type="text"
																	ng-model="receiveRow.pendingQty"
																	class="form-control input-sm text-right"
																	 readonly></td>

																<td colspan=1 class="width_2"><input ng-if="receiveRow.isBatchNoExist==true" type="text"
																	ng-model="receiveRow.receivedQty"
																	class="form-control input-sm text-right"
																	readonly>
																	<input type="text" ng-if="receiveRow.isBatchNoExist!=true"
																	ng-model="receiveRow.receivedQty"
																	class="form-control input-sm text-right"
																	>
																</td>
																	
																	
															<!-- <td class="width_5" ng-show="receiveRow.isBatchNoExist==true" >
													<label class="col-xs-12"  data-ng-click="getBatchDetails(trIndex,receiveRow.itemId)">
														<span class="fa fa-plus"></span>
													</label>
													
													</td> -->
															</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>


								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button" ng-if="!isEdit"
												data-ng-click="save(stockReceiveForm,stockReceive)">
												<i class="fa fa-save"></i>Save
											</button>
											<button class="btn btn-success" type="button" ng-if="isEdit"
												data-ng-click="update(stockReceiveForm,stockReceive);"
												ng-hide="status=='Approved'">
												<i class="fa fa-save"></i>Update
											</button>
											<button class="btn btn-info" type="button" ng-if="!isEdit"
												data-ng-click="reset();">
												<i class="fa fa-undo"></i>Reset
											</button>
											<button class="btn btn-info" type="button" ng-if="isEdit"
												data-ng-click="reset1();">
												<i class="fa fa-undo"></i>Reset1
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel1();">
												<i class="fa fa-close"></i>Cancel
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