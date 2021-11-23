<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  

   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- /panel-heading -->
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_30" st-sort="">JV Agreement No</th>
       <th class="sorting width_10" st-sort="">JV Partner</th>
       <th class="sorting width_10" st-sort="">Vessel</th>
       <th class="sorting width_15" st-sort="">Commencement Date</th>
       <th class="sorting width_15" st-sort="">Completion Date</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objJVAgreementListItem in displayedCollection">
       <td class="width_1" cs-select="objJVAgreementListItem"></td>
       <td class="width_20" ng-bind="objJVAgreementListItem.jvAgreementNo"></td>
       <!-- <td><a href="#/transaction/jvaccounts/jvagreement/view/{{objJVAgreementListItem.jvAgreementNo}}">
         <span tooltip="{{objJVAgreementListItem.jvAgreementNo}}" class="tool-tip-span" ng-bind="objJVAgreementListItem.jvAgreementNo">
         </span></a>
       </td> -->
       <td class="width_15" ng-bind="objJVAgreementListItem.jvPartnerShortName"></td>
       <td class="width_15">
        <span tooltip="{{objJVAgreementListItem.vesselName}}" class="tool-tip-span text-wrap" ng-bind="objJVAgreementListItem.vesselName"></span>
       </td>
       <td class="width_20" ng-bind="objJVAgreementListItem.commencementDate">
       </td>
       <td class="width_20" ng-bind="objJVAgreementListItem.completionDate">
       </td>
       <td class="td-actions text-center">
          <security:authorize access="hasRole('${form_code}_${modify}')">
       <span>
       		<i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objJVAgreementListItem.jvAgreementNo)" tooltip="Edit"></i>
       </span>
        </security:authorize>
           <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objJVAgreementListItem.jvAgreementNo,$index)" tooltip="Delete"></i>
        </span>
         </security:authorize>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
</div>