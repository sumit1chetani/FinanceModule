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
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
           
                                        <th class="sorting width_7" data-st-sort="divisionName">Content
												</th>
																						
										<th class="sorting width_7" data-st-sort="departmentName">Status
												</th>
												<!-- <th class="sorting width_7" data-st-sort="designationName">Designation
												</th> -->
										<!-- 	<th class="sorting width_7" data-st-sort="gradeName">Grade
												</th>
											<th class="sorting width_7" data-st-sort="reportingToName">Reporting To
											</th> -->
												<th class="sorting width_10" data-st-sort="action">Title
											</th>
											<th class="sorting width_10" data-st-sort="email">Form date
											</th>
											<th class="sorting width_10" data-st-sort="action">TO Date
											</th>
											
											<th class="sorting width_7" data-st-sort="action">Action
											</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="educationnotification in displayedCollection">
																						<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.divisionName}}">{{educationnotification.publish}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.departmentName}}">{{educationnotification.status}}</td>

																		<!-- 			<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.designationName}}">{{educationnotification.designationName}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.gradeName}}">{{educationnotification.gradeName}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.reportingToName}}">{{educationnotification.reportingToName}}</td> -->
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.title}}">{{educationnotification.title}}</td>
							              
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.notificationContent}}">{{educationnotification.fromDate}}</td>
							             <!--    <td>{{educationnotification.createdDate}}</td>
											<td>{{educationnotification.credtedBy}}</td> -->
											
										   <td>{{educationnotification.toDate}}</td>
                                               
											<td class=" td-actions text-center">
												<span > <i
													class="fa  fa-pencil text-success text"
													data-ng-click="editRow(educationnotification.staffCircularId,$index)"></i>
											</span> <span > <i
													class="fa fa-trash-o text-danger-dker text"
													data-ng-click="deleteRow(educationnotification.staffCircularId,$index)"></i>
											</span> <!-- <span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa  fa-list-alt text-dark text"
													data-ng-click="Publish(educationnotification.staffNotificationId)"
													title="Send
													"></i>
											</span> --></td>							</tr>
									</tbody>
    </table>
     <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div> 