<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>


  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
             <th class="sorting width_15" data-st-sort="divisionName">Staff Notification ID
												</th>
																						
										<th class="sorting width_15" data-st-sort="departmentName">Content
												</th>
												<th class="sorting width_15" data-st-sort="designationName">Created By
												</th>
											<th class="sorting width_15" data-st-sort="gradeName">Created Date
												</th>
											<th class="sorting width_15" data-st-sort="reportingToName">Status
											</th>
												
											<th class="sorting width_10" data-st-sort="email">Action
											</th>
										<!-- 	<th class="sorting width_10" data-st-sort="action">Created Date
											</th>
											<th class="sorting width_7" data-st-sort="salution">Created By
											</th>
											<th class="sorting width_7" data-st-sort="salution">Status
											</th>
											<th class="sorting width_7" data-st-sort="action">Action
											</th> -->
          </tr>
         </thead>
       	<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="educationnotification in displayedCollection">
																						<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.divisionName}}">{{educationnotification.staffNotificationDetailId}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.departmentName}}">{{educationnotification.notificationContent}}</td>

																					<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.designationName}}">{{educationnotification.createdBy}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.gradeName}}">{{educationnotification.createdDate}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.reportingToName}}">{{educationnotification.status}}</td>
											<!-- <td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.notificationContent}}">{{educationnotification.notificationContent}}</td>
							                <td>{{educationnotification.createdDate}}</td>
											<td>{{educationnotification.credtedBy}}</td>
											
										   <td>{{educationnotification.status}}</td> -->
                                               
											<td class=" td-actions text-center">
												<span ng-if="educationnotification.status=='Pending'"> <i
													class="fa  fa-pencil text-success text"
													data-ng-click="editRow(educationnotification.staffNotificationDetailId,$index)"></i>
											</span> <span ng-if="educationnotification.status=='Pending'"> <i
													class="fa fa-trash-o text-danger-dker text"
													data-ng-click="deleteRow(educationnotification.staffNotificationDetailId,$index)"></i>
											<!-- </span> <span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa  fa-list-alt text-dark text"
													data-ng-click="Publish(educationnotification.staffNotificationId)"
													title="Send
													"></i>
											</span>
											<span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa fa-eye"
													data-ng-click="Publishflag(educationnotification.staffNotificationId)"
													title="Publish
													"></i>
											</span>
											<span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa fa-eye" style="color: red;"
													data-ng-click="unPublishflag(educationnotification.staffNotificationId)"
													title="unPublish
													"></i>
											</span> -->
											</td>							</tr>
									</tbody>
    </table>
     <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div> 