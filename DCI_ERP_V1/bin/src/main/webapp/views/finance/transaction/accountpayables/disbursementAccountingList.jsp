<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <input type="hidden" value="${form_code}" id="form_code_id">
  <%-- <security:authorize access="hasRole('${form_code}_${add}')">
    <button class="btn btn-sm btn-success" ng-click="addExpenseType()" >
      <span class="fa fa-plus">Add Expense Type</span>      
     </button>
     </security:authorize> --%>
  <div class="panel-body float-left padding-0">
  <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <span class="padding-left-10"> <a class="btn btn-success btn-sm" data-ng-click="helpVideo('Disbursement_Accounting','Disbursement Accounting Help')"> Help
        video </a>
      </span>
     </div>
    </div>
   <div class="table-responsive ">
    
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th>
       <th class="sorting width_05" st-sort="disbursemnetCode" ng-show="hide">Disbursement Code</th>
       <th class="sorting width_15" st-sort="supplierName" ng-show="true">Agent</th>
       <th class="sorting width_8" st-sort="monthOfYear" ng-show="true">Month-Year</th>
       <th class="sorting width_5" st-sort="disdisbursemnetDate" ng-show="true">Disb.Date</th>
       <th class="sorting width_5" st-sort="voyageNo" ng-show="true">Voyage</th>
       <th class="sorting width_5" st-sort="portCode" ng-show="true">Port</th>
      <!--  <th class="sorting width_5" st-sort="partyInvoiceNo" ng-show="true">Party Inv.No.</th>
       <th class="sorting width_5" st-sort="partyInvoiceDate" ng-show="true">Party Inv.Date.</th> -->
       <th class="sorting width_5" st-sort="amountUsd" ng-show="true">Disb. Amount(USD)</th>
       <!-- <th class="sorting width_05" st-sort="disbursementMode" ng-show="true">Disbursement Mode</th>
                               <th class="sorting width_05" st-sort="status" ng-show="true">Status</th> -->
       <th class="width_05">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="CompanyDetailsCollections in displayedCollection" data-ng-click="CheckboxSelect({{$index}})">
       <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]" ng-model="CompanyDetailsCollections.selected"> <i></i>
       </label></td>
       <td ng-show="false"><a href="#/transaction/accountpayables/disbursementaccountingt/view/{{CompanyDetailsCollections.disbursemnetCode}}/true/view"> <span
         tooltip="{{CompanyDetailsCollections.disbursemnetCode}}" class="tool-tip-span font-blue">{{CompanyDetailsCollections.disbursemnetCode}}</span>
       </a></td>
       <td ng-show="true"><a href="#/transaction/accountpayables/disbursementaccountingt/view/{{CompanyDetailsCollections.disbursemnetCode}}/true/view"> <span
         tooltip="{{CompanyDetailsCollections.supplierName}}" class="tool-tip-span font-blue">{{CompanyDetailsCollections.supplierName}}</span></a></td>
     <td ng-show="true">{{CompanyDetailsCollections.monthOfYear}}</td>    
       <td ng-show="true">{{CompanyDetailsCollections.disdisbursemnetDate}}</td>
       <td ng-show="true">{{CompanyDetailsCollections.voyageNo}}</td>
       <td ng-show="true">{{CompanyDetailsCollections.portCode}}</td>
       <!-- <td ng-show="true">{{CompanyDetailsCollections.partyInvoiceNo}}</td>
       <td ng-show="true">{{CompanyDetailsCollections.partyInvoiceDate}}</td> -->
       <td ng-show="true">{{CompanyDetailsCollections.amountUsd}}</td>
       <!-- <td ng-show="true">{{CompanyDetailsCollections.disbursementMode}}</td>   
           						<td ng-show="true">{{CompanyDetailsCollections.status}}</td>    -->
       <td class=" td-actions text-left"><security:authorize access="hasRole('${form_code}_${modify}')">
         <span ng-if="CompanyDetailsCollections.status=='PENDING'"> <i class="fa  fa-pencil text-success text"
          data-ng-click="edit(CompanyDetailsCollections.disbursemnetCode)"></i>
         </span>
        </security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="CompanyDetailsCollections.status=='PENDING'"> <i class="fa fa-trash-o text-danger-dker text"
          data-ng-click="deleteRow(CompanyDetailsCollections.companycode,$index)"></i>
         </span>
        </security:authorize> <%--  <security:authorize access="hasRole('${form_code}_${approve}')">
                                  <span ng-if="CompanyDetailsCollections.status=='PENDING'">
                                    <i class="fa fa-check  text" data-ng-click="approve(CompanyDetailsCollections.disbursemnetCode)"></i>
                                   </span>
                                  </security:authorize>
                                  
                                  
                                  <span ng-if="CompanyDetailsCollections.status=='APPROVED'">
                                    <i class="fa fa-plus  text" data-ng-click="viewAllocation(CompanyDetailsCollections)"></i>
                                   </span> --%></td>
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