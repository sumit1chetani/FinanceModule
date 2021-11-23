<style>
table.dataTable thead .sorting:after {
	content: "";
}

.main_container {
	overflow: auto;
}

.datetimepicker {
	width: auto;
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}

.input-group-addon {
	display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
	{
	background-color: white !important;
	border: 0px !important;
}

.b-grey {
	border: 0px !important;
}
</style>
<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
								</span></span>
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
								id="stockReceiveForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label">Stock
													Receive No</label>
													<div class="col-md-7">
														<input type="hidden" id="receivedNo"
															class="form-control"
															ng-model="stockReceive.receivedNo" value=""
															ng-disabled="true" /> <input type="text"
															id="txtStockInNo" class="form-control"
															ng-model="stockReceive.receivedNo" value=""
															ng-disabled="true" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Receive Date
														</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<input type="text" class="form-control"
																placeholder="dd/mm/yyyy" name="From Date"
																data-ng-model="stockReceive.receivedDate"
																ng-disabled="true" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">
														</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<input type="text" class="form-control"
																name="From Date"
																data-ng-model="stockReceive.companyName"
																ng-disabled="true" />
														</div>
													</div>
												</div>


												<div class="form-group">
													<label class="col-md-4 control-label">Source
														Location</label>
													<div class="col-md-7">

														<input type="text" class="form-control input-sm"
														name="Source Location"
														ng-model="stockReceive.sourceLocName"
														id="sourceLocName" ng-disabled="true">


													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Destination
														Location</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
														name="destLocName"
														ng-model="stockReceive.destLocName"
														id="destLocName" ng-disabled="true">


													</div>
												</div>

											</fieldset>
										</div>
										<!-- /col-sm-6 -->
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>

												<div class="form-group">
													<label class="col-md-4 control-label">Stock
													Transfer No </label>
													<div class="col-md-7">
														<input type="hidden" id="transferNo"
															class="form-control"
															ng-model="stockReceive.transferNo" value=""
															ng-disabled="true" /> <input type="text"
															id="transferNo" class="form-control"
															ng-model="stockReceive.transferNo" value=""
															ng-disabled="true" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Transfer Date </label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
														name="Transfer Date"
														ng-model="stockReceive.transferDate"
														id="transferDate" ng-disabled="true" >
													</div>
												</div>


												<div class="form-group">
													<label class="col-md-4 control-label">
														Received By </label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
														name="receivedByName"
														ng-model="stockReceive.receivedByName"
														id="receivedByName" ng-disabled="true" >
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Received Note</label>
													<div class="col-md-7">
														<textarea rows=2 class="form-control input-sm resize-none"
														name="receivedNote"
														ng-model="stockReceive.receivedNote"
														id="receivedNote" ng-disabled="true" >
														</textarea>
													</div>
												</div>
											</fieldset>
										</div>
										<!-- /col-sm-6 -->
									</div>
									<!-- /col-sm-12 -->
								</div>
								<!-- /row -->
								<!-- <div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
						        		<div role="content">
									    	<div class="widget-body no-padding">
									      		<div class="table-responsive clear col-sm-12">
													<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
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
																<th class="sorting width_1"></th>
															 	<th class="sorting width_2 text-align-center">Item Code - Item Name</th>
																<th class="sorting width_2 text-align-center">Transfer Quantity</th>
																<th class="sorting width_2 text-align-center">Pending Quantity</th>
																<th class="sorting width_2 text-align-center">Received Quantity</th>
<!-- 																<th class="table-heading width_5">Batch No</th>
 -->																
															</tr>
														</thead>
														<tbody>
															<tr ng-repeat="(trIndex,receiveRow) in stockReceive.transferDtls">
																<td class="width_1" ng-bind="row.select">
																	<label class="i-checks m-b-none">
																	<input type="checkbox" data-ng-model="receiveRow.select" id="section{{trIndex}}"><i></i></label>
																</td>
																<td class="width_7" ng-bind="receiveRow.text"></td>
																<td colspan=1 class="width_7 text-align-right" ng-bind="receiveRow.transferQty" >
																</td>
																<td colspan=1 class="width_7 text-align-right" ng-bind="receiveRow.pendingQty">
																</td>
																<td colspan=1 class="width_7 text-align-right" ng-bind="receiveRow.receivedQty">
																</td>
																<!-- <td class="width_5" ng-show="receiveRow.isBatchNoExist==true" >
													<label class="col-xs-12"  data-ng-click="getBatchViewDetails(trIndex,receiveRow.itemId)">
														<span class="fa fa-plus"></span>
													</label>
													
													</td> -->
															</tr>
														</tbody>
													</table> <!-- /dt_basic -->
												</div> <!-- /dataTables_wrapper -->
											</div> <!-- /widget-body -->
										</div> <!-- /widget-content -->
									</div> <!-- /col-sm-12 -->
								</div>
								<!-- /row -->
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="backToList();">
												<i class="fa fa-close"></i>BackToList
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- /widget-body -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>