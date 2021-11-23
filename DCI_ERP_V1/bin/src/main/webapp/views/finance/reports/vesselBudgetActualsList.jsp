<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%> --%>
<div class="wrapper-md">
<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
<%@include file="/views/templates/panel-header.jsp"%>
<security:authorize access="hasRole('${form_code}_${export}')">
 <button class="btn btn-sm btn-primary" ng-click="budgetActualsExport()" >
      <span class="fa fa-download">Export</span>      
     </button>
</security:authorize>
<%-- <security:authorize access="hasRole('${form_code}_${upload}')"> --%>
 <button class="btn btn-sm btn-primary" ng-click="fileUpload()" >
      <span class="fa fa-upload">Upload</span>      
     </button>
<%-- </security:authorize> --%>

  <div class="panel-body float-left padding-0" style="
    width: 100%;"
>
  
    <div class="table-responsive " style="border:0px solid red;  width: 100%;">
    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border:0px solid Red" style="border:0px solid red">
     <thead class="dataTables-Main-Head">
      <tr>
        <th class="width_1">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </th>
        
         <th class="sorting " st-sort="vesselName">Company</th>
       <th class="sorting " st-sort="fromDate">From Date</th>
      <th class="sorting " st-sort="toDate">To Date</th>
      
    
        </tr>
     </thead>
      <tbody>
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="budgetAllocation in displayedCollection" class="lpo_cls">
      <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td>
    
           <td class=" width_10">
       <a href=" #/reports/finance/budgetactuals/view/{{budgetAllocation.vesselName}}/{{budgetAllocation.fromDate}}/{{budgetAllocation.toDate}}">
      
         <span tooltip="{{budgetAllocation.vesselName}}"  class="tool-tip-span font-blue">{{budgetAllocation.vesselName}}</span>
        </a>
       </td>
        
          <td class=" width_10" >{{budgetAllocation.fromDate}}</td>
           <td class=" width_10">{{budgetAllocation.toDate}}</td>
         
       </tr>
       <tr x-ng-show="showEmptyLabel">
       <td colspan="6">No Records Found</td>
      </tr>
       </tbody>
    </table>
     <footer class="panel-footer">
      
  
     <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
    </div>

  </div>
  </div>
  </div>


<script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
 <div class="col-lg-12">
  <div class="col-lg-12">
   <!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
   <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadPIFile(this)"  accept=".xls,.xlsx,.xlsm" />
  </div>
 </div> 
</div>
<div class="modal-footer">
<a href="assets/docs/BUDGET_UPLOAD.xlsx" class="control-label">Download sample excel file</a>
 <button class="btn btn-info" type="button" ng-click="uploadPIStatement()">OK</button>
 <button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>