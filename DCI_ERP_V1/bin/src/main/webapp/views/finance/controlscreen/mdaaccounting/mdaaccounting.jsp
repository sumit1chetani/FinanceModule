<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
    <input type="hidden" value="F0413" id="form_code_id" />
  <div class="panel-body">
   <div class="table-responsive ">
   
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
      <th class="sorting width_15" st-sort="companyName">Company</th>
       <th class="sorting width_20" st-sort="monthOfYear">Month/Year</th>
       <th class="sorting width_20" st-sort="supplierCode">Agent Code</th>
       <th class="sorting width_30" st-sort="supplierName">Agent Name</th>
       <th class="text-center width_15">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objMdaBean in displayedCollection">
      <td class="sorting width_20">{{objMdaBean.companyName}}</td>
       <td class="sorting width_20">{{objMdaBean.monthOfYear}}</td>
       <td class="sorting width_20">{{objMdaBean.supplierCode}}</td>
       <td class="sorting width_30">{{objMdaBean.supplierName}}</td>
       <td class=" td-actions text-center">
	        <span ng-if="objMdaBean.isAdd=='Y'">
              <i class="fa fa-plus  text" data-ng-click="addMonthlyDisbursement(objMdaBean)"></i>
             </span> 
              <span ng-if="objMdaBean.isAdd=='N'">
              <i class="fa fa-eye  text" data-ng-click="viewMonthlyDisbursement(objMdaBean)"></i>
             </span> 
            <security:authorize access="hasRole('F0413_${approve}')">
	        <span ng-if="objMdaBean.status=='P' || objMdaBean.status=='PA'">
	          <t></t><i class="fa fa-check padding-both-side-5  text" data-ng-click="approve(objMdaBean)"></i>
	         </span>
	         </security:authorize> 
	         <span ng-if="objMdaBean.status=='P'">
	          <t></t><i class="fa fa-pencil text-success padding-both-side-5  text" data-ng-click="editMonthlyDisbursement(objMdaBean)"></i>
	         </span>
        	
	    </td>
      </tr>
     </tbody>
    </table>
    
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
   <div class="form-actions">
     <div class="row">
      <div class="col-md-12">       
       <span>
        <button class="btn btn-danger " type="button" ng-click="back()">
         <i class="fa fa-arrow-left"></i>&nbsp; Back
        </button>
       </span>

      </div>
     </div>
    </div>
  </div>
 </div>
</div>
