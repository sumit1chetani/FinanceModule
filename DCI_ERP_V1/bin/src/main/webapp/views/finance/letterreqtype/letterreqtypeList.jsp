

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
						
								<th class="sorting width_35">Letter Type</th>
								<th class="sorting width_35">Description</th>
								<th class="sorting width_35">Action</th>
							</tr>
      </thead>
     <tbody class="dataTables-Main-Body">
   		<tr class="company" ng-repeat="lettertype in displayedCollection track by $index">
							
								<td>{{lettertype.letterReqTypeName}}</td>
								<td>{{lettertype.descripiton}}</td>
						
								<td class="td-actions text-center width_1"><span
									class="edit-button  padding-right-5"
									data-ng-click="editRow(lettertype)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span> <span class="delete-button"
									data-ng-click="deleteRow(lettertype)"
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