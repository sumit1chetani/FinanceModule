<style>


.brk{
width:120px;
     display:block;
    word-break:break-all;
}

</style>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
    <div class="panel-body padding-0">
   <div class="table-responsive ">
   <table class="table table-striped b-t b-light table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th>
       <th class="sorting width_15" st-sort="cnReq">CN Request No</th>
       <th class="sorting width_11" st-sort="createdBy">Created By</th>
       <th class="sorting width_10" st-sort="createdDt">Created Date</th>
       <th class="sorting width_20" st-sort="department">Department</th>
       <th class="sorting width_20" st-sort="person">Person</th>
       <th class="sorting width_10" st-sort="approval">Approval</th>
       <th class="sorting width_10" st-sort="approval">Action</th>
         <!-- <th class="text-center">Action</th> -->
      </tr>
      <tr>
      <th>
      </th>
      <th>
         <input st-search="cnReq" placeholder="CN Request No" class="input-sm form-control" type="search" />
        </th>
         <th>
         <input st-search="createdBy" placeholder="Created By" class="input-sm form-control" type="search" />
        </th>
        <th>
         <input st-search="createdDt" placeholder="Created Date" class="input-sm form-control" type="search" />
        </th>
        <th>
         <input st-search="department" placeholder="Department" class="input-sm form-control" type="search" />
        </th>
        <th>
         <input st-search="person" placeholder="Person" class="input-sm form-control" type="search" />
        </th>
        <th>
         <input st-search="approval" placeholder="Approval" class="input-sm form-control" type="search" />
        </th>
        <th>
         
        </th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objempmasterItem in displayedCollection">
       <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td>
       <td><span>
	       <a ng-click="view(objempmasterItem.cnReqNo)">
			 <span tooltip="{{objempmasterItem.cnReqNo}}" class="tool-tip-span font-blue">{{objempmasterItem.cnReqNo}}</span>
	         </a></span>
       <td>{{objempmasterItem.createdBy}}</td>
       <td>{{objempmasterItem.createdDt}}</td>
       <td>{{objempmasterItem.department}}</td>
       <td>{{objempmasterItem.person}}</td>
       <td>{{objempmasterItem.approval}}</td>
	 <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')"> 
         <span ng-if="objempmasterItem.approval !='Approved' && objempmasterItem.approval !='Rejected'" data-toggle="tooltip" title="Edit">
          <i class="fa  fa-pencil text-info text" data-ng-click="editRow(objempmasterItem.cnReqNo)"></i>
         </span>
        </security:authorize> 
        
         <security:authorize access="hasRole('${form_code}_${approve}')"> 
         <span ng-if="objempmasterItem.approval !='Approved' && objempmasterItem.approval !='Rejected'" data-toggle="tooltip" title="Approve">
          <i class="fa  fa-check text-success text" data-ng-click="approveRow(objempmasterItem.cnReqNo)"></i>
         </span>
        </security:authorize>
           <security:authorize access="hasRole('${form_code}_${approve}')"> 
         <span ng-if="objempmasterItem.approval !='Approved' && objempmasterItem.approval !='Rejected'" data-toggle="tooltip" title="Reject">
          <i class="fa  fa-ban text-warning text" data-ng-click="rejectRow(objempmasterItem.cnReqNo)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')"> 
           <span  ng-if="objempmasterItem.approval !='Approved' && objempmasterItem.approval !='Rejected'" data-toggle="tooltip" title="Delete">
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objempmasterItem.cnReqNo)"></i>
         </span> 
         </security:authorize> 
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