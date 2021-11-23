<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 85%;
	position: absolute;
	top: 5%;
	left: 9%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection1" st-safe-src="poplist">
		<security:authorize access="hasRole('${form_code}_${search}')"
			var="isSearch" />

		<div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0">
			<div class="row  m-n">
				<div
					class="col-md-5 padding-right-0 padding-left-0 header-with-breadcrumb font-bold"
					style="font-size: 18px;">Container List</div>
				<div class="col-md-6 text-right padding-right-0">
					<div class="row">
						<div class="col-md-6 p-r-3"></div>
						<div class="col-md-6  p-l-0">
							<c:choose>
								<c:when test="${isSearch}">
									<input type="text" st-search=""
										class="form-control input-sm p-tb-14 bg-white rounded padder"
										placeholder="Search">
								</c:when>
								<c:otherwise>
									<input type="text" st-search=""
										class="form-control input-sm p-tb-14 bg-white rounded padder"
										placeholder="Search">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="ngdialog-close"></div>
			</div>
		</div>
		<div class="panel-body" style="background: #353b64; color: #fff;">
			<div class="row pl2pc pr12pc">

				<div class="col-sm-12">
					<fieldset>

						<div class="col-md-5">
							<div class="form-group">
								<label class="col-md-4 control-label"><b>EX -VESSEL : </b></label><span>{{routing.vesselRouting}}</span>

								<!-- <label class="col-md-5 control-label">{{routing.vesselRouting}}</label> -->


							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"><b>EX-VOYAGE :
								</b></label><span>{{routing.voyageRouting}}</span>

								<!-- <label class="col-md-5 control-label">{{routing.voyageRouting}}</label> -->


							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label class="col-md-5 control-label"><b>EX-POT : </b></label><span>{{routing.fromPort}}</span>

								<!-- 	<label class="col-md-5 control-label">{{routing.fromPort}}</label> -->


							</div>
						</div>

					</fieldset>
				</div>


				<div class="col-sm-12">
					<fieldset>
						<div class="col-md-5">
							<div class="form-group">
								<label class="col-md-4 control-label"><b>VESSEL :</b></label><span>{{routing.vessel}}</span>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"><b>VOYAGE :</b></label><span>{{routing.voyage}}</span>
							</div>
						</div>

					</fieldset>
				</div>
			</div>
		</div>
		<br>

<div class="row pl0pc pr12pc">
		<div class="col-md-3">
			<div class="form-group">
				<label class="col-md-5 control-label"><b>Vessel</b><span
					style="color: red;">*</span></label>
				<div class="col-md-7">
					<selectivity list="vesselList" property="routing.vessel"
						id="vessel" ng-model="routing.vessel" name="vessel"
						form-name="departmentAddForm" validation="required"
						friendly-name="Vessel"></selectivity>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="col-md-5 control-label"> <b>Voyage</b> <span style="color: red;">*</span>
				</label>
				<div class="col-md-7">
					<selectivity list="voyageList" property="routing.voyage"
						id="voyage" ng-model="routing.voyage" name="voyage"
						form-name="departmentAddForm" validation="required">
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div class="form-group">
				<label class="col-md-5 control-label"> <b>POT</b> <span style="color: red;">*</span>
				</label>
				<div class="col-md-7">
					<selectivity list="portTSList" property="routing.tsPot" id="tsPot"
						ng-model="routing.tsPot" name="tsPot" form-name="departmentAddForm">
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="col-md-5 control-label"> <b>Next Port</b> <span style="color: red;"></span>
				</label>
				<div class="col-md-7">
					<selectivity list="portTSList" property="routing.port" id="voyage"
						ng-model="routing.port" name="port" form-name="departmentAddForm">
				</div>
			</div>
		</div>

		<!-- <div class="col-md-3">
			<div class="form-group">
				<label class="col-md-5 control-label"> <b>ETA</b> <span style="color: red;">*</span>
				</label>
				<div class="col-md-7">
					<label class="col-md-5 control-label">{{routing.etasailDate}}</label>
				</div>
			</div>
		</div> -->
</div>
	<br>
<div class="row pl0pc pr10pc">
			<div class="col-md-3">
			<div class="form-group">
			<label class="col-md-5 control-label"> <b>DF :</b>  </label> <label>{{routing.dfFlag}}</label>
			</div>
			</div>
			 
			<div class="col-md-4">
			<div class="form-group">
			<label class="col-md-5 control-label"> <b>ETD at POT :</b>  </label> <label>{{routing.etdAtPot}}</label>
				 
			</div>
			</div>
			
			<div class="col-md-5">
			<div class="form-group">
			<label class="col-md-5 control-label"> <b>ETA at Next Port :</b> </label><label>{{routing.etasailDate}}</label>
				 
			</div>
			</div>
</div>

		 
		<div style="text-align: center; font-size: 15px;" ng-if="DepotFlag">
			<label style="color: red;">Note: Origin Vessel not yet
				Discharged.</label>
		</div>
 
		<div class="wrapper-md">

			<div class="panel-body float-left padding-10" style="width: 100%;">
				<div class="table-responsive" " border: 2pxsolid #CCC;">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
						<thead style="background-color: #e2e2e2;">
							<tr>
								<th class="width_1"><label class="i-checks m-b-none">
										<input type="checkbox" ng-model="selection"
										data-ng-click="selectall(selection)"><i
										style="margin-left: -19px;"></i>
								</label></th>
								<th class="width_10">Sl No</th>
								<th class="width_15">Container Number</th>
								<th class="width_14">BL Number</th>
								<th class="width_17">Booking Number</th>
								<th class="width_17">Customer Name</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex,item) in displayedCollection1">

								<td><label class="i-checks m-b-none"> <input
										type="checkbox" name="selectedTypes[]" ng-model="item.select1"
										id="section{{$index}}"><i></i></label></td>
								<td class="sorting" data-toggle="tooltip" title="{{item.slno}}"
									style="padding-left: 4%;">{{item.slno}}</td>
								<td class="sorting" data-toggle="tooltip"
									title="{{item.containerNumber}}">{{item.containerNumber}}</td>
								<!--      <td class="sorting" data-toggle="tooltip"
												title="{{item.dischargePort}}">{{item.pod}}</td> -->
								<td class="sorting" data-toggle="tooltip" title="{{item.blNo}}">{{item.blNo}}</td>
								<td class="sorting" data-toggle="tooltip"
									title="{{item.bookingNo}}">{{item.bookingNo}}</td>
								<!-- <td class="sorting" data-toggle="tooltip"
												title="{{item.vessel}}">{{item.vessel}}</td> -->
								<!-- <td class="sorting" data-toggle="tooltip"
												title="{{item.xVessel}}">{{item.xVessel}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.xVoyage}}">{{item.xVoyage}}</td> -->
								<td class="sorting" data-toggle="tooltip"
									title="{{item.customerName}}">{{item.customerName}}</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<br> <br>
			<div class="model-footer" style="padding-left: 39%; padding-top: 29%">
				<button class="btn btn-success" type="button" ng-click="saveData()">
					<i class="fa fa-save"></i> Save
				</button>
				<button class="btn btn-danger" ng-click="noCnfrm()">
					<i class="fa fa-close"></i>Cancel
				</button>
			</div>

			<!-- end widget content -->
		</div>
	</div>
</div>
