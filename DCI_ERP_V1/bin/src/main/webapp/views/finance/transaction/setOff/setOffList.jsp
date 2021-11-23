<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id" />
  <div class="panel-body float-left padding-0" style="width:100%" >
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1">
       </th>
       <th class="sorting" st-sort="setOffNo">Set Off No.</th>
       <th class="sorting" st-sort="setOffDate">Set off Date</th>
       <th class="sorting" st-sort="customerName">Customer</th>
       <th class="sorting" st-sort="supplier">Supplier</th>
       <th class="sorting" st-sort="supplier">Customer BC Amt</th>
       <th class="sorting" st-sort="supplier">Supplier BC Amt</th> 
      <th class="text-center">Excess Loss/Gain</th>  
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objSetoffBean in displayedCollection">
       <td class="">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
        <td>
        <a ng-click="view(objSetoffBean.setOffNo)">
			 <span tooltip="{{objSetoffBean.setOffNo}}" class="tool-tip-span font-blue">{{objSetoffBean.setOffNo}}</span>
	         </a>
       </td>
       <td class="sorting ">{{objSetoffBean.setOffDate}}</td>
       <td class="sorting ">{{objSetoffBean.customerName}}</td>
       <td class="sorting ">{{objSetoffBean.supplierName}}</td>
       <td class="sorting ">{{objSetoffBean.customerbc}}</td>
       <td class="sorting ">{{objSetoffBean.supplierbc}}</td>
       <td class="sorting ">{{objSetoffBean.amount}}</td>
     <%--   <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span ng-if="objSetoffBean.urIsEdit=='true'">
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objSetoffBean.setOffNo,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="objSetoffBean.urIsDelete=='true'">
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objSetoffBean.setOffNo,$index)"></i>
         </span>
        </security:authorize>
       </td> --%>
       
       
       
							<td class=" td-actions text-center">
							
								<security:authorize access="hasRole('${form_code}_${print}')">
								<span>
								 <i class="fa  fa-print text-success text" data-toggle="tooltip" title="Print"
									ng-click="printsetoff(objSetoffBean.setOffNo)"></i>
									</span>
									</security:authorize>
							
									</td>
									   <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
     
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objSetoffBean.setOffNo,$index)"></i>
        
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
       
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objSetoffBean.setOffNo,$index)"></i>
      
        </security:authorize>
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
