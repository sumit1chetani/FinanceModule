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
       <th class="sorting width_15" st-sort="groupHeadCode">Voucher No</th>
       <th class="sorting width_15" st-sort="subGroupAcctCode">Date</th>
       <th class="sorting width_15" st-sort="subGrpAcctName">Truck No</th>       
       <th class="sorting width_15" st-sort="subGrpAcctName">Driver Name</th>
       <th class="sorting width_15" st-sort="subGrpAcctName">LOL</th>
       <th class="sorting width_15" st-sort="subGrpAcctName">LOD</th>
       <th class="text-center">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">       
       <td class="sorting"><a ng-click="view(objGroupHeadItem.rowId)"> <security:authorize access="hasRole('${form_code}_${view}')">	
		             <span tooltip="{{objGroupHeadItem.entryNo}}" class="tool-tip-span font-blue">{{objGroupHeadItem.entryNo}}</span>
		         </security:authorize></a>
       </td>
       <td class="">{{objGroupHeadItem.date}}</td>
       <td class="sorting">{{objGroupHeadItem.truckNo}}</td>      
       <td class="sorting">{{objGroupHeadItem.driversName}}</td>
       <td class="sorting">{{objGroupHeadItem.fromLocation}}</td>
       <td class="sorting">{{objGroupHeadItem.toLocation}}</td>
       <td class=" td-actions text-center">
         <security:authorize access="hasRole('${form_code}_${modify}')"> 
         <span ng-if="objGroupHeadItem.statusId=='false'">
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem.rowId)"></i>
         </span>
         </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="objGroupHeadItem.statusId=='false'">
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objGroupHeadItem.rowId)"></i>
         </span>
        </security:authorize>
          <security:authorize access="hasRole('${form_code}_${print}')"> 
           <span ng-if="objGroupHeadItem.statusId=='false'"> 
             <i class="fa fa-envelope"  data-ng-click="mail(objGroupHeadItem.rowId)"></i>
           </span>
           </security:authorize> 
              <security:authorize access="hasRole('${form_code}_${print}')"> 
           <span ng-if="objGroupHeadItem.statusId=='true'"> 
             <i class="fa fa-print"  data-ng-click="print(objGroupHeadItem.rowId)"></i>
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

