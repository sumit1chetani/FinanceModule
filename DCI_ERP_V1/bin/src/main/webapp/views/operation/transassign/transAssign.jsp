
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form " st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body"> 
			<form name="transAssignForm" class="form-horizontal" novalidate>
				<!--<div class="row">
					 <div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pot <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="portList" property="transAssign.pot"
										id="pot" ng-model="transAssign.pot" name="pot"
										validation="required" friendly-name="pot"
										form-name="transAssignForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>


							<div class="form-group">
								<label class="col-md-4 control-label">Fpod  <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="portList" property="transAssign.fpod"
										id="fpod" ng-model="transAssign.fpod" name="fpod"
										validation="required" friendly-name="Fpod"
										form-name="transAssignForm"></selectivity>
								</div>
							</div>
 
						</fieldset>
					</div>
				</div> 
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"  
								class="btn btn-success" ng-click="getData(transAssignForm,transAssign)">
								<i class="fa fa-search"></i> Search

							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(transAssignForm)">
								<i class="fa fa-undo"></i> Reset
							</button>
						</div>
					</div>
				</div>-->
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th class="width_1 text-center"><label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -30px;"></i>
							</label> </th>
							 <th class="sorting width_10" st-sort="bookingno">Booking No</th>
							<th class="sorting width_10" st-sort="exvoyage">Ex Voyage</th>
							<th class="sorting width_10" st-sort="custname">Cust Short Name</th>
							<th class="sorting width_10" st-sort="pol">POL</th>
							<th class="sorting width_10" st-sort="pot">POT</th>
							<th class="sorting width_10" st-sort="fpod">POD</th>
							<th class="sorting width_10" st-sort="noofcntrs">No of Cont</th>
							<th class="sorting width_10" st-sort="assignvessel">Assigned Vessel</th>
							<th class="sorting width_10" st-sort="assignvoyage">Assigned Voyage</th>
							<th class="sorting width_10" st-sort="assignvoyage">T/s Leg</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in transAssign.transAssignBeanList">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
							<td class="sorting" data-toggle="tooltip" title="{{row.bookingno}}">{{row.bookingno}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.exvoyage}}">{{row.exvoyage}}</td>
 							<td class="sorting" data-toggle="tooltip" title="{{row.custname}}">{{row.custname}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.pol}}">{{row.pol}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.pot}}">{{row.pot}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.fpod}}">{{row.fpod}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.noofcntrs}}">{{row.noofcntrs}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.assignvessel}}">{{row.assignvessel}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.assignvoyage}}">{{row.assignvoyage}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{row.assignvoyage}}">{{row.leg}}</td>
							</tr>
						</tbody>

					</table>
					<!-- <div class="row">
					<div class="padding-right-5" id="AddOrRmvebtn">
					 <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Assign Vessel <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="vesselList" property="transAssign.vessel"
										id="vessel" ng-model="transAssign.vessel" name="vessel"
										 friendly-name="vessel"
										form-name="transAssignForm"></selectivity>
								</div>
							</div>
							</fieldset>
					</div>
					</div>
					<div class="padding-right-5" id="AddOrRmvebtn">
					 <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
								<div class="form-group">
								<label class="col-md-4 control-label">Assign Voyage <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="voyageList" property="transAssign.voyage"
										id="voyage" ng-model="transAssign.voyage" name="voyage"
										 friendly-name="voyage"
										form-name="transAssignForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					</div>
					<br> <br> <br><br> <br> <br><br> <br> <br>
				</div> -->
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="transAssign.transAssignBeanList.length > 0"  
								class="btn btn-success" ng-click="Assign(row)">
								<i class="fa fa-save"  aria-hidden="true" ></i> Assign

							</button>

							  <button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>  
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
