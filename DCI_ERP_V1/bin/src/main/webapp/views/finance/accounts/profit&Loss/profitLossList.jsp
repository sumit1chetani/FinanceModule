<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false"
     data-widget-deletebutton="false">
     <header>
      <!-- <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
      <span class="ui-separator"></span>
      <span>
       <state-breadcrumbs></state-breadcrumbs>
      </span> -->
      
      
      		<%@include file="/views/templates/panel-header-form.jsp"%>
      <div class="widget-toolbar">
       <div>
        <span>
        <%--  <span class="button-icon" data-reset-widgets rel="tooltip"
          title="<spring:message code="title.widget.reset"></spring:message>" data-placement="bottom">
          <i class="fa fa-refresh"></i>
         </span> --%>
        </span>
       </div>
      </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        st-table="displayedCollection" st-safe-src="rowCollection">
        <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th>
           <th class="sorting width_12" st-sort=" "> Ledger Date
           </th>
           <th class="sorting width_12" st-sort=" ">Income and Expenditure	 
           </th>
           <th class="sorting width_12" st-sort=" ">Group Head Name
           </th>
           <th class="sorting width_12" st-sort=" ">Balance
           </th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <!-- <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat=" ">
           <td cs-select=" "></td>
           <td>{{}}</td>
           <td>{{}}</td>
           <td>{{}}</td>
           <td>{{}}</td>
          </tr> -->
         </tbody>
        </table>
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->    
 
 

<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
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
  <div class="col-md-6  col-md-offset-7">
  <div class="form-group"></div>
        			<div class="form-group">
						<label class="col-md-5 control-label"> Total </label>
        				<div class="col-md-4">
							<input type="text" class="form-control input-sm" readonly>
						</div>
        			</div>	
        		</div>
  <div class="row">
     <div class="col-sm-12 col-md-12 ">
      <div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>  
     </div>
     </div>
 </section>
</div>

			
	