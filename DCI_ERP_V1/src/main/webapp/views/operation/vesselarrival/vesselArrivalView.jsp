<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%-- <security:authentication var="user" property="principal" /> --%>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="vessselArrivalForm" class="form-horizontal">
				<div class="row">


					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<!-- vessel -->
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel :</label>
									<div class="col-md-7">
									
									<label class="col-md-8 control-label">{{vesselArrival.vessel}}</label>
										
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<!-- voyage -->
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage :</label>
									<div class="col-md-7">
									<label class="col-md-8 control-label">{{vesselArrival.voyage}}</label>
									
									</div>
								</div>
							</div>


							<div class="col-md-4">
								<!-- port -->
								<div class="form-group">
									<label class="col-md-5 control-label">Port :</label>
									<div class="col-md-7">
									<label class="col-md-8 control-label">{{vesselArrival.port}}</label>
									</div>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<!-- <div class="col-md-4">
								terminal
								<div class="form-group">
									<label class="col-md-5 control-label">Terminal Name :</label>
									<div class="col-md-7">
								<label class="col-md-5 control-label">{{vesselArrival.terminal}}</label>
									</div>
								</div>
							</div> -->


							<div class="col-md-4">
								<!-- Arrival date -->
								<div class="form-group">
								<label class="col-md-5 control-label">Arrival Date :</label>
							<div class="col-md-7">
								<label class="col-md-8 control-label">{{vesselArrival.arrivalDate}}</label>
									</div>
								</div>
							</div>
							<!-- <div class="col-md-4">
								port
								<div class="form-group">
									<label class="col-md-5 control-label">MRN Number :</label>
									<div class="col-md-7">
									<label class="col-md-8 control-label">{{vesselArrival.mrnNo}}</label>
										
									</div>
								</div>
							</div> -->

                         <div class="col-md-4">
								<div class="form-group">
								<label class="col-md-5 control-label">Created By :</label>
							<div class="col-md-7">
								<label class="col-md-8 control-label">{{vesselArrival.created_by}}</label>
									</div>
								</div>
							</div>
							
							
							<div class="col-md-4">
								<div class="form-group">
								<label class="col-md-5 control-label">Created Date :</label>
							<div class="col-md-7">
								<label class="col-md-8 control-label">{{vesselArrival.createdDate}}</label>
									</div>
								</div>
							</div>

						</fieldset>
					</div>
<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<!-- vessel -->
								<div class="form-group">
									<label class="col-md-5 control-label">Mode :</label>
									<div class="col-md-7">
									
									<label class="col-md-8 control-label">{{vesselArrival.mode}}</label>
										
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<!-- voyage -->
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier :</label>
									<div class="col-md-7">
									<label class="col-md-16 control-label">{{vesselArrival.carrier}}</label>
									
									</div>
								</div>
							</div>


							
						</fieldset>
					</div>
<div class="col-sm-12">
						<fieldset>
						
						
						</fieldset>
					</div>

				</div>
<!-- 				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" ng-click="viewDetail()">
								<i class="fa fa-eye	"> </i>Show
							</button>
						</div>
					</div>
				</div> -->
				<br>
				<div class="breadcrumb-wrapper ng-scope">

					<div class="table-responsive" style="border: 1px solid #CCC;">
						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive"><br>
								<h3 style="margin-left:5px;">Loaded Container on Board Detail</h3><br>
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr role="row">
												<!-- <th class="width_1">Select</th> -->
												<th class="sorting width_5">Sl.No</th>
												<th class="sorting width_10">BL NO.</th>
												<th class="sorting width_10">Container Type</th>
												<th class="sorting width_10">Total No.of Containers</th>
												<th class="sorting width_10">No.of Full</th>												
												<th class="sorting width_10">No.of Empty</th>
												<th class="sorting width_10">Transit No.of Full</th>
												<th class="sorting width_5">Transit No.of Empty</th>

											</tr>
										</thead>

										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="(trIndex, listitems) in displayedCollection">
												
											 <td style="background-color: lightsalmon" class="sorting" 
											 data-toggle="tooltip">{{$index+1}}</td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.blno}}" class="tool-tip-span"
													ng-bind="listitems.blno"></span></td>

												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.containerType}}" class="tool-tip-span"
													ng-bind="listitems.containerType"></span></td>
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.totalCon}}" class="tool-tip-span"
													ng-bind="listitems.totalCon"></span></td>
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.fullDirect}}" class="tool-tip-span"
													ng-bind="listitems.fullDirect"></span></td>
												
												<td style="background-color: lightsalmon">
													<span tooltip="{{listitems.empDirect}}" class="tool-tip-span" 
													ng-bind="listitems.empDirect"></span></td> 
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.fullTransit}}"
													class="tool-tip-span" ng-bind="listitems.fullTransit"></span>
												</td>
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.empTransit}}" class="tool-tip-span"
													ng-bind="listitems.empTransit"></span></td>
										</tbody>
									</table>

								</div>

							</div>
						</div>

					</div>
				</div>





				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
						<!-- 	<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="saveData()">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-info" ng-if="!edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
 -->
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
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
