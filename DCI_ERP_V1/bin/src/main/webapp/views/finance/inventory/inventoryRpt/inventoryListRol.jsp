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
                          data-placement="bottom">
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
        <!-- <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
      <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
	        <thead class="dataTables-Main-Head">
	        	<tr>
		           <th class="width_1 text-center table-heading">
		            <label class="i-checks m-b-none">
		             <input type="checkbox">
		             <i></i>
		            </label>
		           </th>
		           <th class="sorting width_25" data-st-sort="creditNoteCode">Item Code - Item Name</th>
		           <th class="sorting width_25" data-st-sort="creditNoteDate">Item Type</th>
		           <th class="sorting width_15" data-st-sort="accountName">Available Qty</th>
		           <th class="sorting width_15" data-st-sort="invoiceNo">ROL Qty</th>
	        	</tr>
	        </thead>
			<tbody class="dataTables-Main-Body">
		    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objInventoryROLListItem in displayedCollection">
			       	<td class="width_1"> <label class="i-checks m-b-none">
			       		<input type="checkbox" ng-model="objInventoryROLListItem.select" id="select{{trIndex}}"><i></i></label></td>
			       	<td class="width_25" ng-bind="objInventoryROLListItem.itemName"></td>
			       	<td class="width_25" ng-bind="objInventoryROLListItem.itemType"></td>
			       	<td class="width_15 text-right" ng-bind="objInventoryROLListItem.qty"></td>
					<td class="width_15 text-right" ng-bind="objInventoryROLListItem.reorderLevel"></td>
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