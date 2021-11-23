<style>
.calbody {
	margin: 40px 10px;
	padding: 0;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
.fc-license-message{
display: none;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" novalidate
				name="driverReportForm">

				<div class="panel-body">
					<div class="row pl2pc pr10pc">
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-md-5 control-label">Driver<span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<selectivity list="driverSelectivity" property="driverSelected"
										data-ng-model="driverSelected"
										form-name="driverReportForm" friendly-name="Table Name">
									</selectivity>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group" ng-init="select.category='trip'">
								<label class="col-md-5 control-label">Category<span
									style="color: red;">*</span></label>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="category" value="trip"
										ng-model="select.category"> <i></i> Trip
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="category" value="truck"
										ng-model="select.category"> <i></i> Truck
									</label>
								</div>
							</div>

						</div>
						
					</div>
					<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" type="button"
								ng-click="searchDriver()">
								<i class="fa fa-search"></i> Search
							</button>

						</div>
					</div>
				</div>
				<div class="form-actions" style="margin-top: 0px !important;"></div>
					
					
					

					<div class="calbody">

						<div id='calendar'></div>

					</div>
				</div>
			</form>
		</div>
	</div>
</div>
