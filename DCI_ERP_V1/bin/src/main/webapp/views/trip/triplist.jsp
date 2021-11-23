<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
    	<thead>
    	 <input type="hidden" value="${user.userId}" id="userId">
							<tr>
								<th>Trip No</th>
								<th>From Location</th>
								<th>To Location</th>
								<th>Truck Reg No</th>
								<th>Truck Plate No</th>
								<th>Trailer No</th>
								<th>Trip Start Date</th>
								<th>Driver Mobile No</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="trip in displayedCollection track by $index">
								<td><a ng-click="viewTrip(trip.planTripId)"><security:authorize access="hasRole('${form_code}_${view}')">
								 <span tooltip="{{trip.tripNo}}" class="tool-tip-span font-blue">{{trip.tripNo}}</span>
								 </security:authorize> </a></td>
								<td>{{trip.fromLocation}}</td>
								<td>{{trip.toLocation}}</td>
								<td>{{trip.truckRegNo}}</td>
								<td>{{trip.plateNo}}</td>
								<td>{{trip.trailerNo}}</td>
										<td>{{trip.tripStartDate}}</td>
										<td>{{trip.mobileNo}}</td>
											<td><a ng-click="viewBookings(trip.tripNo)">
									        <security:authorize access="hasRole('${form_code}_${view}')">
	
								 <span tooltip="{{trip.tripStatus}}" class="tool-tip-span font-blue">{{trip.tripStatus}}</span>
								</security:authorize>
								  </a></td>
       
       <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(trip.planTripId,trip.refId)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(trip.planTripId)"></i>
         </span>
        </security:authorize>
             <security:authorize access="hasRole('${form_code}_${view}')">
           <span ng-if="trip.tripStatus == 'OnGoing' && trip.refId == null ">
          <i class="fa fa-reply text-info text" data-toggle="tooltip"
												title="ReAllocate" data-ng-click="reallocateTrip(trip)"></i>
         </span>
        </security:authorize>
                <security:authorize access="hasRole('${form_code}_${view}')">
         <span ng-if="trip.deAllocateFlag == true">
          <i class="fa fa-thumbs-down text-danger-dker text" data-toggle="tooltip"
												title="DeAllocate" data-ng-click="deallocateTrip(trip.planTripId)"></i>
         </span>
        </security:authorize>
        <span ng-if="userId == 'E0050'  && (trip.approvedStatus == null && tripCompletedDate == null)">
          <i class="fa  fa-thumbs-up text-success text" data-ng-click="approveTrip(trip.tripNo)"></i>
         </span>
        		<!-- <button class="btn btn-info" 	ng-click="reset()">
								 UnAllocate
							</button> -->
       </td>
      </tr>
     </tbody>           
     
    </table>
   </div>
      <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
   
<!--    <div class="col-md-1"> -->
<!-- 			<span class="padding-left-10" style=" margin-left: auto;"> -->
<!-- 		 		<a class="btn btn-success btn-sm" data-ng-click="helpVideo('Plantrip_Process','Plan Trip Help')">  Help video</a>	         	 -->
<!-- 		    </span> -->
		   
<!-- 	   </div> -->
  </div>
  <!-- end widget content -->
 </div>
</div>








<!-- 






<div class="pageheader">
	<div class="breadcrumb-wrapper hidden-xs">
		<span class="label">You are here:</span>
		<ol class="breadcrumb">
			<li>Manage Trip</li>
			<li class="active">List</li>
		</ol>
	</div>
</div>
<section id="main-content" class="animated fadeInRight">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Trip List</h3>
					<div class="actions pull-right">
						<i data-fullscreen-widget class="fa fa-expand"></i> <i
							data-widget-toggle class="fa fa-chevron-down"></i> <i
							data-widget-close class="fa fa-times"></i>
					</div>
				</div>
				<span id="errorMobVerifySpan" class="errorspan" style="color: red">{{errorMessage}}</span>
				<span id="qrSpan" class="errorspan" style="color: red">{{errorMessage}}</span>
				<div class="panel-body" ng-controller="tripListCtrl"
					>
						<button class="btn btn-info" ng-click="tripnew()">Add</button>
					<table id="manageStoppingListCtrl" class="table table-striped table-bordered"
						datatable="" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Trip Name</th>
								<th>Description</th>
								<th>Trip Type</th>
								<th>Active</th>
								<th>Action</th>
							</tr>
						</thead>

						<tbody>
							<tr class="route" ng-repeat="stopping in stoppingList track by $index">
								<td>{{stopping.stoppingName}}</td>
								<td>{{stopping.landMark}}</td>
								<td>{{stopping.description}}</td>
								<td>{{stopping.lattitude}}</td>
								<td><i class="icon-pencil"></i> Edit <i class="fa fa-times"></i>
									Delete</td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
</section> -->