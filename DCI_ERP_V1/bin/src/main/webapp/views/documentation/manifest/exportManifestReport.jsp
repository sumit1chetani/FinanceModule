<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%-- <security:authentication var="user" property="principal" /> --%>

<div class="wrapper-md">

	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="inwardmanifestReportForm" class="form-horizontal">
				<div class="row">
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>

							<div class="form-group">
								<label class="col-md-5 control-label"> Vessel <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity list="vesselList"
										property="inwardmanifestReport.vessel" id="vessel"
										object="vessel"></selectivity>
								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="control-label col-md-5"> Voyage <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity list="vList"
										property="inwardmanifestReport.voyage" id="voyage"
										object="voyage"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<!-- <div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"> Pod <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity list="podList"
										property="inwardmanifestReport.pod" id="pod"
										object="pod"></selectivity>
								</div>
							</div>

						</fieldset>
					</div> -->
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="control-label col-md-5">  POL <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity list="portList"
										property="inwardmanifestReport.pol" id="pol"
										object="pol"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<%-- 						<security:authorize access="hasRole('${form_code}_${search}')">  --%>
							<button class="btn btn-success" ng-click="viewManifest()">
								<i class="fa fa-eye	"> </i>View Manifest
							</button>
							<%-- 							</security:authorize> --%>


							<%-- 							<security:authorize access="hasRole('${form_code}_${print}')">  --%>
							<button class="btn btn-primary"
								ng-click="printManifest(rowCollection)">
								<i class="fa fa-file-pdf-o"> </i>Download Manifest
							</button>
							<%-- 							</security:authorize> --%>
						</div>
					</div>
				</div>
				<br>
				<div class="breadcrumb-wrapper ng-scope">

					<div class="table-responsive" style="border: 1px solid #CCC;">
						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive">
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr role="row">
												<!-- <th class="width_7">Select All</th> -->
												<th class="width_7 "><label class="i-checks m-b-none">
												<b>Select All </b><input type="checkbox" ng-model="selection"
														data-ng-click="selectall(selection)"><i
														style="margin-left: 0px;"></i>
												</label></th>
												<!-- <th class=" width_10">Service</th> -->
												<th class="sorting width_10" style="text-align:center;">BL No</th>
												<th class="sorting width_10" style="text-align:center;">Booking No</th>
												<!-- <th class="sorting width_10" style="text-align:center;" >Issue Place</th> -->
												<th class="sorting width_10" style="text-align:center;">Voyage Code</th>
												<th class="sorting width_5" style="text-align:center;">POL</th>
												<th class="sorting width_5" style="text-align:center;">POD</th>
												<th class="sorting width_5" style="text-align:center;">FPOD</th>
											</tr>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="(trIndex, listitems) in displayedCollection">
												<td class="width_1 text-center"><label
													class="i-checks m-b-none"> <input type="checkbox"
														name="selectedTypes[]" ng-model="listitems.check">
														<i></i>
												</label></td>
											<!-- 	<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.service}}" class="tool-tip-span"
													ng-bind="listitems.service"></span></td> -->

												<td style="background-color: lightsalmon; text-align:center;" ><span
													tooltip="{{listitems.blno}}" class="tool-tip-span"
													ng-bind="listitems.blno"></span></td>

												<td style="background-color: lightsalmon; text-align:center;"><span
													tooltip="{{listitems.bookingNo}}" class="tool-tip-span"
													ng-bind="listitems.bookingNo"></span></td>

											<!-- 	<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.issueplace}}" class="tool-tip-span"
													ng-bind="listitems.issueplace"></span></td> -->

												<td style="background-color: lightsalmon; text-align:center;"><span
													tooltip="{{listitems.voyage}}" class="tool-tip-span"
													ng-bind="listitems.voyage"></span></td>

												<td style="background-color: lightsalmon; text-align:center;"><span
													tooltip="{{listitems.pol}}" class="tool-tip-span"
													ng-bind="listitems.pol"></span></td>

												<td style="background-color: lightsalmon; text-align:center;"><span
													tooltip="{{listitems.pod}}" class="tool-tip-span"
													ng-bind="listitems.pod"></span></td>
													
													<td style="background-color: lightsalmon; text-align:center;"><span
													tooltip="{{listitems.fpod}}" class="tool-tip-span"
													ng-bind="listitems.fpod"></span></td>
										</tbody>
									</table>

								</div>

							</div>
						</div>

					</div>
				</div>
			</form>

		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br> <br>
</div>
