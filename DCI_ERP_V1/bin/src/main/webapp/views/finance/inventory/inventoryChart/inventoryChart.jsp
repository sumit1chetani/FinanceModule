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
									data-placement="bottom"> <i
										class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<form class="form-horizontal" name="invRprtForm" role="form"
							novalidate>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12 panel-body">
									<div class="col-md-4">
										<div class="form-group">
											<label class="col-md-3 control-label">Item</label>
											<div class="col-md-6">
												<selectivity list="itemLists"
													property="consumptionModel.itemId" id="itemName"></selectivity>
												<!-- <select  class="form-control input-sm" ng-model="consumptionModel.itemId" ng-options="itm.itemId as itm.itemName for itm in itemLists"  name="itemCode">
								        <option value=""> --Select--</option>
								    </select> -->
											</div>
										</div>

									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="col-md-3 control-label">Location</label>
											<div class="col-md-6">
												<selectivity list="locationLists"
													property="consumptionModel.locationId" id="locationName"></selectivity>
												<!-- <select  class="form-control input-sm" ng-model="consumptionModel.locationId" ng-options="loc.locationId as loc.locationName for loc in locationLists"  name="locationCode">
								        <option value=""> --Select--</option>
								    </select> -->

											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<div class="col-md-12">
												<button class="btn btn-success width_25"
													data-ng-click="getConsumptionReport();">Submit</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"> Rate of
									Consumption </label>
								<div class="col-md-6">
									<div class="radio">
										<label class="i-checks"> <input type="radio"
											class="radiobox style-0" checked="checked" name="wardType"
											id="thirty" ng_model="consumptionModel.rdoDays" value="30"
											data-ng-true-value="'YES'" data-ng-false-value="'NO'">
											<i></i> 30 Days
										</label> <label class="i-checks"> <input type="radio"
											class="radiobox style-0" checked="checked" name="wardType"
											id="sixty" ng_model="consumptionModel.rdoDays" value="60"
											data-ng-true-value="'NO'" data-ng-false-value="'YES'">
											<i></i> 60 Days
										</label> <label class="i-checks"> <input type="radio"
											class="radiobox style-0" checked="checked" name="wardType"
											id="ninty" ng_model="consumptionModel.rdoDays" value="90"
											data-ng-true-value="'NO'" data-ng-false-value="'YES'">
											<i></i> 90 Days
										</label>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="padding-left-5 padding-top-5" id="jqgrid">
									<div id="inventGrid">
										<table id="grid"></table>
										<div id="inventorypage"></div>
									</div>
								</div>
							</div>

							<!-- <div class="row">
			  		<div class="col-xs-5 col-xs-offset-9 padding-top-5">
		          	<div class="form-group">
						<label class="col-md-3 control-label">Total Qty</label>
						<div class="col-md-3">
							<input type="text" class="form-control input-sm" data-ng-model="consumptionModel.totQty" id="totalQty" readonly="readonly">
						</div>
					</div>
					</div>
        	</div> -->
						</form>
						<!-- end widget content -->
						<!-- end widget div -->
					</div>
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>
<div class="row">
	<highchart id="chart1" config="chartConfig" class="span7"></highchart>
</div>