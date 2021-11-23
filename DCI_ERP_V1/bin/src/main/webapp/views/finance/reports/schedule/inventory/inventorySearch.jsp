<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="inventrySearchForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">TRUCK <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="vesselList"
											property="inventory.truckId" id="truckId"
											object="tempDropDownObj"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">From
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="inventory_fromDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="inventory.fromDate"
												name="fromDate" id="fromDate"> <span
												class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">To
										Date <span style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="inventory_toDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="inventory.toDate" name="toDate"
												id="toDate"> <span class="input-group-addon add-on">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						  <security:authorize access="hasRole('${form_code}_${add}')">
							<button class="btn btn-success" ng-click="viewInventry()">
								<i class="fa fa-search"></i>Submit
							</button>
</security:authorize>
							<button class="btn btn-info" type="reset" ng-click="reset()"
								class="btn btn-success">
								<i class="fa fa-undo"></i>Reset
							</button>
						</div>
					</div>
				</div>
				<div class="row" ng-show="viewInventory">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10"
						id="jqgrid">
						<table id="inReportGrid" >
						</table>
						<div id="inReportGridPage">
						
						</div>
						
						
					</div>
					
					
					
					
				</div>
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->



