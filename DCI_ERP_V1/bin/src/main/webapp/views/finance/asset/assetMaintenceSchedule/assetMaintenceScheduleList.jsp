<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0072_D')" var="isDelete" />
<security:authorize access="hasRole('F0072_A')" var="isAdd" />
<security:authorize access="hasRole('F0072_UP')" var="isUpload" /> --%>
<div id="content">
 <!-- widget grid -->
 <section id="widget-grid" data-widget-grid> 
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"  > 
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <div>
				<span>
					<span class="button-icon" data-placement="bottom" data-reset-widgets rel="tooltip" title="<spring:message code='title.widget.reset'></spring:message>">
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" data-st-table="displayedCollection" data-st-safe-src="rowCollection">
        
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading">
           <label class="i-checks m-b-none">
            <input type="checkbox">
            <i></i>
           </label>
          </th>
           <th class="sorting width_20" data-st-sort="">Asset Schedule No</th>
           <th class="sorting width_20" data-st-sort="">Item</th>           
           <th class="sorting width_20" data-st-sort="">Item Category</th>
           <th class="width_5 text-center table-heading"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="assetschedule in displayedCollection">
           <td data-cs-select="assetschedule" class="text-center"></td>
           <td>{{assetschedule.assetScheduleNo}}</td>
           <td>{{assetschedule.itemName}}</td>           
           <td>{{assetschedule.categoryName}}</td>
            <td class=" td-actions text-center">
            <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <i class="fa  fa-list-alt text-dark  text" data-ng-click="editRow(assetschedule.assetScheduleId)"></i>
        </span>
        </security:authorize>
		<security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-hide=true data-ng-click="deleteRow(assetschedule)"></i>
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