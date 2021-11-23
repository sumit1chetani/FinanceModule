

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
     <tr>
<!--        <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
<!--        </label></th> -->
    		<tr>
						
								<th class="sorting width_20">Letter Type</th>
								<th class="sorting width_20">Employee Name</th>
								<th class="sorting width_10">Request Date</th>
									<th class="sorting width_10">HR Status</th>
										<th class="sorting width_10">Admin Status</th>
								<th class="sorting width_10">Issue Date</th>
									<!-- <th class="sorting width_35">Issue Status</th> -->
								<th class="sorting width_5">Action</th>
							</tr>
      </thead>
     <tbody class="dataTables-Main-Body">
   		<tr class="company" ng-repeat="letterRequest in displayedCollection track by $index">
							
								<td>{{letterRequest.letterReqTypeName}}</td>
								<td>{{letterRequest.employeeName}}</td>
							<td>{{letterRequest.requestDate}}</td>
							<td>{{letterRequest.hrStatus}}</td>
							<td>{{letterRequest.adminStatus}}</td>
								<td>{{letterRequest.issuedDate}}</td>
								<!-- 	<td>{{letterRequest.issueStatus}}</td> -->
								<td class="td-actions text-center width_1"><span
									class="edit-button  padding-right-5"
									ng-if = "letterRequest.hrStatus == 'Pending' && letterRequest.approveFlag != 'DS011'"
									data-ng-click="editRow(letterRequest.letterReqId)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span> 
								<span class="delete-button" title="Approve"
								ng-if = "letterRequest.approveFlag && letterRequest.hrStatus == 'Pending' "
									data-ng-click="viewRow(letterRequest.letterReqId)"
									tooltip="Approve"> <i
										class="fa fa-eye" style="color: black;"></i>
								</span>
								<span class="delete-button" title="View"
								ng-if = "letterRequest.hrStatus == 'Approved'"
									data-ng-click="viewRow(letterRequest.letterReqId)"
									tooltip="Approve"> <i
										class="fa fa-eye text-success text" ></i>
								</span>
								<!-- <span class="delete-button" title="View"
								ng-if = " letterRequest.designation == 'DS0001' || letterRequest.status"
									data-ng-click="viewRow(letterRequest.letterReqId)"
									tooltip="Approve"> <i
										class="fa fa-eye text-success text" ></i>
								</span> -->
								<!-- <span class="delete-button" title="View"
								ng-if = " letterRequest.designation == 'DS0001' || letterRequest.hrStatus == 'Approved'"
									data-ng-click="viewRow(letterRequest.letterReqId)"
									tooltip="Approve"> <i
										class="fa fa-eye text-success text" ></i>
								</span> -->
								<span class="delete-button" title="Issue"
								ng-if = "letterRequest.adminStatus == 'Pending' && letterRequest.hrStatus == 'Approved' && letterRequest.designation == 'DS001'"
									data-ng-click="Issue(letterRequest.letterReqId)"	
									tooltip="Approve"> <i
										class="fa fa-eye text-success text"  style="color: red;"></i>
								</span>
								<span class="delete-button"
									ng-if = "letterRequest.hrStatus == 'Pending' && letterRequest.approveFlag != 'DS011'"
									data-ng-click="deleteRow(letterRequest)"
									tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
								</span>
								
								</td>
							</tr>
     </tbody>           
     
    </table>
   </div>
      <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div>