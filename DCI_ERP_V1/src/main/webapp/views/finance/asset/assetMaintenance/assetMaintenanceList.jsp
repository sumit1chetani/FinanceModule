<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
        <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div>
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
           <th class="sorting width_10" data-st-sort="">Maintenance Type Code</th>
           <th class="sorting width_15" data-st-sort="">Maintenance Type Name</th>
           <th class="sorting width_10" data-st-sort="">Description</th>
           <th class="sorting width_10" data-st-sort="">Active</th>
           <th class="width_8 text-center table-heading"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collection in displayedCollection">
       <td class="">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </td>
       <td class="">{{collection.assetCode}}</td>
       <td class="">{{collection.assetName}}</td>
       <td class="">{{collection.description}}</td>
       <td >
           <input type="checkbox" checked="checked" disabled="disabled" ng-model = "collection.active" >
           </td>
           <td class=" td-actions text-center">
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collection)"></i>
        </span>
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collection)"></i>
        </span>
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