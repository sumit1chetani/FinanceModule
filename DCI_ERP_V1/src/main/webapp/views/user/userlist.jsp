
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
								<th>UserId</th>
								<th>User Name</th>
								<th>Address</th>
								<th>Telephone Number</th>
								<th>Email</th>
								<th>Action</th>
							</tr>
      </thead>
     	<tbody>
							<tr class="company" ng-repeat="company in userlist track by $index">
								<td>{{company.userId}}</td>
								<td>{{company.userName}}</td>
								<td>{{company.address}}</td>
								<td>{{company.phoneNo}}</td>
								<td>{{company.email}}</td>
								<td class="td-actions text-center width_1"><span
									class="edit-button  padding-right-5"
									data-ng-click="editRow(company)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span> <span class="delete-button"
									data-ng-click="deleteRow(company)"
									tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
								</span></td>
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