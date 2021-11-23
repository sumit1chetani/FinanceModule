<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
    
   <%@include file="/views/templates/panel-header.jsp"%>
  
  <div class="panel-body float-left padding-0" style="width: 100%;">
   
   
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>
       <th class="sorting width_30" st-sort="groupHeadCode">Charge Type Code</th>
       <th class="sorting width_35" st-sort="subGroupAcctCode">Charge  Type Name</th>
       <th class="sorting width_30" st-sort="subGrpAcctName">Description</th>
       <th class="text-center">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">
       <td class="wrapping"><a ng-click="view(objGroupHeadItem.chargeTypeid)">
       <security:authorize access="hasRole('${form_code}_${view}')"> 
		             <span tooltip="{{objGroupHeadItem.chargeTypecode}}" class="tool-tip-span font-blue">{{objGroupHeadItem.chargeTypecode}}</span>
		       </security:authorize>
		         </a>
		         
       </td>  
       
       <td class="wrapping">{{objGroupHeadItem.chargeTypename}}</td>
       <td class="wrapping">{{objGroupHeadItem.chargeTypedescription}}</td>
       
       <td class="td-actions text-center">
         <security:authorize access="hasRole('${form_code}_${modify}')"> 
         <span>
          <i class="fa fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem.chargeTypeid)"></i>
         </span>
         </security:authorize> 
         <security:authorize access="hasRole('${form_code}_${delete}')"> 
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objGroupHeadItem.chargeTypeid)"></i>
         </span>
         </security:authorize> 
       </td>
      </tr>
     </tbody>           
     
    </table>
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>      
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div>