<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id" />
  <div class="panel-body float-left padding-0" style="width:100%">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
      <!--  <th class="width_1"> -->
       </th>
       <th class="sorting" st-sort="contraNo">Contra No.</th>
       <th class="sorting" st-sort="contraDate">Contra Date</th>
       <th class="sorting" st-sort="payerName">Payer / Supplier</th>
       <th class="sorting" st-sort="company">Company</th>
      <th class="text-center">Amount</th>  
       
     <th class="text-center">Action</th> 
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objContraBean in displayedCollection">
       <!-- <td class="">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
        </td> -->
        <td>
        <a ng-click="view(objContraBean.contraNo)">
			 <span tooltip="{{objContraBean.contraNo}}" class="tool-tip-span font-blue" >{{objContraBean.contraNo}}</span>
	         </a>
       </td>
       <td class="sorting ">{{objContraBean.contraDate}}</td>
       <td class="sorting ">{{objContraBean.payerName}}</td>
       <td class="sorting ">{{objContraBean.company}}</td>
         <td class="sorting ">{{objContraBean.amount}}</td>
      <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
     
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objContraBean.contraNo,$index)"></i>
        
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
       
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objContraBean.contraNo,$index)"></i>
      
        </security:authorize>
       </td> 
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
  </div>
 </div>
</div>
