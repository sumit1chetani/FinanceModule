<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		</div>
        <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>
       <!-- <th class="width_1 text-center table-heading">
        <label class="i-checks m-b-none">
         <input type="checkbox">
         <i></i>
        </label>
       </th> -->
       <th class="sorting width_20" st-sort="groupHeadCode">TDS CODE</th>
       <th class="sorting width_30" st-sort="subGroupAcctCode">TDS NAME</th>
       <th class="sorting width_30" st-sort="subGrpAcctName">TDS TYPE</th>
              <th class="sorting width_30" st-sort="subGrpAcctName">TDS DESC</th>
       
       <th class="text-center table-heading width_10">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">
       <!-- <td data-cs-select="objGroupHeadItem" class="text-center"></td> -->
        <td class="sorting">{{objGroupHeadItem.tdscode}}</td>
       <td class="">{{objGroupHeadItem.tdsname}}</td>
       <td class="sorting">{{objGroupHeadItem.tdsType}}</td>
              <td class="sorting">{{objGroupHeadItem.tdsDesc}}</td>
       

      <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <!-- <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem,$index)"></i> -->
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem.tdsauto,$index)"></i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objGroupHeadItem.tdsauto)"></i>
        </span>
        
        </security:authorize>
       </td> 
      </tr>
     </tbody>

    </table>
        <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
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