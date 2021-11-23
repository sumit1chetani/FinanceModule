<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id" />
  <div class="panel-body">
  <div class="row">
  <div class="col-sm-12 col-md-12 col-lg-12">
   <span class ="padding-left-10">
     <a class="btn btn-success btn-sm" data-ng-click="helpVideo('MDA','MDA Help')">Help video </a>           
      </span>
     
     </div>
 </div>
   <div class="table-responsive ">
    
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       
       <th class="sorting width_20" st-sort="supplierCode">Agent Code</th>
       <th class="sorting width_60" st-sort="supplierName">Agent Name</th>
       <th class="text-center width_20">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objMdaBean in displayedCollection">
       
       <td class="sorting width_20">{{objMdaBean.supplierCode}}</td>
       <td class="sorting width_30">{{objMdaBean.supplierName}}</td>
       <td class=" td-actions text-center">
	        <span ng-if="objMdaBean.isAdd=='Y'">
              <i class="fa fa-plus  text" data-ng-click="addMonthlyDisbursement(objMdaBean)"></i>
             </span> 
              <span ng-if="objMdaBean.isAdd=='N'">
              <i class="fa fa-eye  text" data-ng-click="viewMonthlyDisbursement(objMdaBean)"></i>
             </span> 
           <%--   <security:authorize access="hasRole('${form_code}_${approve}')">
		        <span ng-if="objMdaBean.status=='P'">
		          <t></t><i class="fa fa-check padding-both-side-5  text" data-ng-click="approve(objMdaBean)"></i>
		         </span>
        	</security:authorize> --%>
	    </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
  </div>
 </div>
</div>
