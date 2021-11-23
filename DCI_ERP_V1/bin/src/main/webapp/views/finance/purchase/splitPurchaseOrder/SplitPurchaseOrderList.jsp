<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<<%-- security:authorize access="hasRole('F0027_D')" var="isDelete" />
<security:authorize access="hasRole('F0027_A')" var="isAdd" />
<security:authorize access="hasRole('F0027_UP')" var="isUpload" /> --%>
<!-- #MAIN CONTENT -->
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span><state-breadcrumbs></state-breadcrumbs> </span>
      <div class="widget-toolbar">
       <!-- add: non-hidden - to disable auto hide -->
       <div>
        <span> <span class="button-icon" data-reset-widgets rel="tooltip"
         title="<spring:message code="title.widget.reset"></spring:message>" data-placement="bottom">
          <i class="fa fa-refresh"></i>
        </span>
        </span>
       </div>
      </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection" data-st-safe-src="rowCollection">
        
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th>
           <th class="sorting width_8" data-st-sort="">Purchase Order No</th>
           <th class="sorting width_7" data-st-sort="">Purchase Order Date</th>
           <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
           <th class="width_8 text-center table-heading"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
           <td cs-select="collections"></td>
            <td>{{collections.purchaseOrderNum}}</td>
            <td>{{collections.purchaseOrderDate}}</td>
            <td>{{collections.vendorName}}</td>
            <td>{{collections.purchaseTypeName}}</td>
            <td>{{collections.purchaseStatus}}</td>
            <td class=" td-actions text-center">
          <security:authorize access="hasRole('${form_code}_${modify}')">   
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collections)"></i>
        </span>
        </security:authorize>
        <%--  <security:authorize access="hasRole('F0027_V')">
        <span ng-if="collections.purchaseStatus == 'Approved' || collections.purchaseStatus == 'Rejected' ||  collections.purchaseStatus == 'Cancelled' ">
         <i class="fa  fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
        </span>
        </security:authorize>
         <security:authorize access="hasRole('F0027_D')">
        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' && collections.purchaseStatus !='Cancelled'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
        </span>
        </security:authorize> --%>
       </td>
          </tr>
     </tbody>
        </table>
        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>