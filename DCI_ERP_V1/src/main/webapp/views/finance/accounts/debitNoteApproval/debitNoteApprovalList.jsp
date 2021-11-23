<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('F0096_D')" var="isDelete" />
<security:authorize access="hasRole('F0096_A')" var="isAdd" />
<security:authorize access="hasRole('F0096_UP')" var="isUpload" />
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
        <!-- <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		</div>
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
           <th class="sorting width_10" data-st-sort="">Debit Code</th>
           <th class="sorting width_10" data-st-sort="">Date</th>
           <th class="sorting width_10" data-st-sort="">Account Head</th>
           <th class="sorting width_10" data-st-sort="">Invoice No</th>
           <th class="sorting width_10" data-st-sort="">Location</th>
           <th class="sorting width_10" data-st-sort="">Hospital</th>
           <th class="sorting width_10" data-st-sort="">Amount</th>
           <th class="sorting width_8" data-st-sort="">Status</th>
           <th class="width_6 text-center table-heading"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
       <tbody class="dataTables-Main-Body"> 
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" >
           <td class="text-center"cs-select="objVesselSectorItem"></td>
           <td>CNS245303</td>
           <td>26/08/2015</td>
           <td>CNSTEC</td>
           <td>PHCSI793410</td>
           <td>Chennai</td>
           <td>KMC</td>
           <td>1850.00</td>
           <td>Pending</td>
            <td class=" td-actions text-center">
        <security:authorize access="hasRole('F0096_M')">
	        <span>
	         	<i class="fa  fa-pencil text-success text" data-ng-click="editRow()"></i>
	        </span>
        </security:authorize>
        <security:authorize access="hasRole('F0096_D')">
	        <span>
	         	<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow()"></i>
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