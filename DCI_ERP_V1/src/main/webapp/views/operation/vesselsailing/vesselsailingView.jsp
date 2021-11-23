<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="departmentAddForm" role="form"
				novalidate method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>
						<div class="form-group">
								<label class="col-md-4 control-label"><b>Mode</b><span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<!-- <selectivity list="vessellist" property="vesselsailing.vessel"
										id="vessel" ng-model="vesselsailing.vessel" name="vessel"
										form-name="departmentAddForm" validation="required"
										friendly-name="Vessel" disabled="true"></selectivity> -->
										
										<label class="control-label">{{vesselsailing.mode}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b>Carrier</b><span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<!-- <selectivity list="vessellist" property="vesselsailing.vessel"
										id="vessel" ng-model="vesselsailing.vessel" name="vessel"
										form-name="departmentAddForm" validation="required"
										friendly-name="Vessel" disabled="true"></selectivity> -->
										
										<label class="control-label">{{vesselsailing.carrier}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b>Vessel</b><span
									style="color: red;"></span></label>
								<div class="col-md-5">
									<!-- <selectivity list="vessellist" property="vesselsailing.vessel"
										id="vessel" ng-model="vesselsailing.vessel" name="vessel"
										form-name="departmentAddForm" validation="required"
										friendly-name="Vessel" disabled="true"></selectivity> -->
										
										<label class="control-label">{{vesselsailing.vessel}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Voyage </b><span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="voyagelist" property="vesselsailing.voyage"
										id="voyage" ng-model="vesselsailing.voyage" name="voyage"
										form-name="departmentAddForm" disabled="true"></selectivity> -->
										
									<label class="control-label">{{vesselsailing.voyage}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Sail Date </b><span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <ng-bs3-datepicker data-ng-model="vesselsailing.sail_Date"
										name="sail_Date" form-name="departmentAddForm"
										friendly-name="Sail Date" validation="required"
										disabled="true" /> -->
										
									<label class="control-label">{{vesselsailing.sail_Date}}</label>		
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Port</b><span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="portlist" property="vesselsailing.port"
										id="port" ng-model="vesselsailing.port" name="port"
										form-name="departmentAddForm" friendly-name="Port"
										disabled="true"></selectivity> -->
										
										<label class="control-label">{{vesselsailing.port}}</label>
								</div>
							</div>

						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">


							<!--    <button class="btn btn-success" type="button" 
											ng-click="getReport(vesselsailing)" id="vesselsailingsave">
											<i class="fa fa-save"></i> Export
										</button>
          -->

							<!--  <div class="btn btn-primary"  data-ng-click="getReport(vesselsailing)">
       <span class="fa fa-file-excel-o"> Export TDR</span>
  <a id="vesselsailingsave" stype="display:none"
					href="filePath/VesselSailling.xlsx" download="VesselSailling.xlsx"></a>
      </div>
          <button class="btn btn-success" 
												 ng-click="printsailingportDiv(vesselsailing)"  
												 type="button">
									        	  Print
									         </button> -->

							<div class="btn btn-primary" data-ng-click="getReport()">
								<span class="fa fa-file-excel-o"> Export Excel</span> <a
									id="vesselsailingsave" stype="display:none"
									href="filePath/VesselSailling.xlsx" download="TDR_REPORT.xlsx"></a>
							</div>
							<button class="btn btn-info" type="button"
								data-ng-click="sendMail()">
								<i class="fa fa-envelope"></i> Send Mail
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</div>
