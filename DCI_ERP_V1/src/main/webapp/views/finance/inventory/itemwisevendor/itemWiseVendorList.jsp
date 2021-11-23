<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
        st-table="displayedCollection" st-safe-src="rowCollection">
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th>
           <th class="sorting width_5" st-sort="itemName"><spring:message code="label.manageitem.itemName"></spring:message></th>
           <th class="sorting width_5" st-sort="itemCategory"><spring:message code="label.manageitem.itemCategory"></spring:message></th>
           <th class="sorting width_5" st-sort="itemDescription"><spring:message code="label.manageitem.itemDescription"></spring:message></th>
           <th class="sorting width_5" st-sort="itemType"><spring:message code="label.manageitem.itemType"></spring:message></th>
           <th class="sorting width_5" st-sort="itemCode"><spring:message code="label.manageitem.partNo"></spring:message></th>
           <th class="width_5 table-heading text-center"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="objItemWiseVendorMapping in displayedCollection">
           <td cs-select="objItemWiseVendorMapping" class="text-center"></td>
           <td>{{objItemWiseVendorMapping.itemName}}</td>
           <td>{{objItemWiseVendorMapping.itemCategory}}</td>
           <td>{{objItemWiseVendorMapping.itemDescription}}</td>
           <td>{{objItemWiseVendorMapping.itemType}}</td>
           <td>{{objItemWiseVendorMapping.itemCode}}</td>
           <td class=" td-actions text-center">
           <security:authorize access="hasRole('${form_code}_${modify}')">
           <span> <i
             class="fa  fa-pencil text-success text"
             data-ng-click="editRow(objItemWiseVendorMapping.itemId)"></i>
           </span>
           </security:authorize>
           <security:authorize access="hasRole('${form_code}_${delete}')">
           <span> <i class="fa fa-trash-o text-danger-dker text"
             data-ng-click="deleteRow(objItemWiseVendorMapping.itemId)"></i>
           </span>
           </security:authorize>
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