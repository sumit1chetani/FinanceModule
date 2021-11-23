<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id"> --%>
		<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
			<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
		
			       <form class="form-horizontal" name="revenuecompForm" method="POST>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">VESSEL</label>
								<div class="col-md-7">
									<selectivity list="vesselList" property="search.vessel"
										id="vessel_id" name="vessel_id" ng-model="search.vessel"
										friendly-name="VESSEL" form-name="revenuecompForm" 
										></selectivity>
<!-- validation="required" -->
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-5 control-label">POL</label>
								<div class="col-md-7">
									<selectivity list="portList" property="search.pol" id="pol_id"
										name="pol_id" ng-model="search.pol" friendly-name="POL"
										form-name="revenuecompForm"></selectivity>

								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">FROM DATE</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="fromDateId">
										<input type="text" class="form-control " name="fromDate"
											id="fromDate" ng-model="search.fromDate"
											placeholder='dd/mm/yyyy' /> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">VOYAGE</label>
								<div class="col-md-7">
									<selectivity list="voyageList" property="search.voyage"
										id="voyage_id" name="voyage_id" ng-model="search.voyage"
										friendly-name="VOYAGE" form-name="revenuecompForm" ></selectivity>
          <!-- validation="required" -->

								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">POD</label>
								<div class="col-md-7">
									<selectivity list="portList" property="search.pod" id="pod_id"
										name="pod_id" ng-model="search.pod" friendly-name="POD"
										form-name="revenuecompForm"></selectivity>

								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">TO DATE</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="toDateId">
										<input type="text" class="form-control " name="toDate"
											id="toDate" ng-model="search.toDate" placeholder='dd/mm/yyyy' />
										<span class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">SECTOR</label>
								<div class="col-md-7">
									<selectivity list="serviceList" property="search.service"
										id="service_id" name="service_id" ng-model="search.service"
										friendly-name="SECTOR" form-name="revenuecompForm"></selectivity>

								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">SLOT A/C</label>
								<div class="col-md-7">
									<selectivity list="slotList" property="search.slotact"
										id="slotact_id" name="slotact_id" ng-model="search.slotact"
										friendly-name="SLOT A/C" form-name="revenuecompForm"></selectivity>

								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" 
											ng-click="add(revenuecompForm)">
											 Add
										</button>
										<button class="btn btn-info" type="button"
										 ng-click="edit(revenuecompForm)">
											Edit
										</button>
										<button class="btn btn-success" type="button"
										 ng-click="view(revenuecompForm)">
											View
										</button>
									<!-- 	<button class="btn btn-info" type="button"
										 ng-click="view(revenuecompForm)">
											EXCEL TO EXPORT
										</button> -->
										<button class="btn btn-info" 
											type="reset">
											Reset
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