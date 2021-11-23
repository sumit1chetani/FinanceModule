 <!-- #MAIN CONTENT -->
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
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
         <form class="form-horizontal" name="vesselMasterForm" role="form" ng-submit="#" novalidate>
        
       
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
        <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1"></th>
           <th class="sorting width_15" st-sort="">Hospital</th>
           <th class="sorting width_15" st-sort="">Branch</th>
           <th class="sorting width_15" st-sort="">Employee </th>
           <th class="sorting width_15" st-sort="">Month</th>
           <th class="sorting width_15" st-sort="">Year</th>
           <th class="sorting width_15" st-sort="">Metro Rent</th>
           <th class="sorting width_15" st-sort="">Is Metro </th>
           <th class="sorting width_15">Action</th>
           
          </tr>
         
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objVesselMasterItem in displayedCollection">
           <td cs-select="objVesselMasterItem"></td>
<!--            <td>{{objVesselMasterItem.designationName}}</td> -->
<!--            <td>{{objVesselMasterItem.status}}</td> -->
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
