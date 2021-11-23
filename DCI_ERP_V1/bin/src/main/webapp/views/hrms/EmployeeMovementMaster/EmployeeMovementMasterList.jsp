<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
					<span class="button-icon" data-reset-widgets rel="tooltip" title="reset"
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
<!--        <div class="col-md-12 panel-body"> -->
<!--        		<div> -->
<!-- 	       		<label class="col-md-2 control-label-right">Company</label> -->
<!-- 				<div class="col-md-2"> -->
<!-- 				  <input type="text" class="form-control input-sm"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 	       		<label class="col-md-1 control-label-right">Branch</label> -->
<!-- 				<div class="col-md-2"> -->
<!-- 					<select class="form-control"> -->
<!-- 					  <option value="select">select</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 		    </div> -->
<!-- 		    <div> -->
<!-- 			    <label class="col-md-1 control-label-right">Employee</label> -->
<!-- 				<div class="col-md-2"> -->
<!-- 					<select class="form-control"> -->
<!-- 					  <option value="select">select</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 		    </div> -->
<!-- 		    </div> -->
<!-- 	  <div class="col-md-12 panel-body"> -->
<!-- 		    <div> -->
<!-- 	       		<label class="col-md-2 control-label-right">From Date</label> -->
<!-- 				<div class="col-md-2"> -->
<!-- 					<input type="date" class="form-control input-sm"/> -->
<!-- 			    </div> -->
<!-- 		    </div> -->
<!-- 		    <div> -->
<!-- 			    <label class="col-md-1 control-label-right">To Date</label> -->
<!-- 				<div class="col-md-2"> -->
<!-- 					<input type="date" class="form-control input-sm"/> -->
<!-- 			    </div> -->
<!-- 		    </div> -->
<!-- 		    <div class="col-md-4 col-md-offset-1"> -->
<!-- 					<button class="btn btn-success" type="submit" class="btn btn-success"> -->
<!-- 		            <i class="fa fa-search"></i> -->
<!-- 		            Search -->
<!-- 		           </button> -->
<!-- 		           <button class="btn btn-success" type="submit" class="btn btn-success"> -->
<!-- 		            <i class="fa fa-undo"></i> -->
<!-- 		            Refresh -->
<!-- 		           </button> -->
<!-- 		        </div> -->
<!-- 		</div> -->
		
       
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
<!--         <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 table-heading"></th> -->
           <th class="sorting width_10" st-sort="hospital">Organization</th>
           <th class="sorting width_10" st-sort="branch">Branch</th>
           <th class="sorting width_10" st-sort="departmentName">Department</th>
           <th class="sorting width_7" st-sort="employee">Emp. Id</th>
           <th class="sorting width_10" st-sort="empName">Emp. Name</th>
           <th class="sorting width_8" st-sort="empDate">Date</th>
           <th class="sorting width_8" st-sort="empOutTime">Time Out</th>
           <th class="sorting width_13" st-sort="empPurposeofVisit">Place And Purpose</th>
<!--            <th class="sorting width_10" st-sort="">Time In</th> -->
           <th class="width_2 table-heading">Action</th>
          </tr>
         
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objMovementItem in displayedCollection">
           <!-- <td></td> -->
           <td>{{objMovementItem.hospital}}</td>
           <td>{{objMovementItem.branch}}</td>
           <td>{{objMovementItem.departmentName}}</td>
           <td>{{objMovementItem.employee}}</td>
           <td>{{objMovementItem.empName}}</td>
           <td>{{objMovementItem.empDate}}</td>
           <td>{{objMovementItem.empOutTime}}</td>
           <td>{{objMovementItem.empPurposeofVisit}}</td>
<!--            <td>{{objVesselMasterItem.empInTime}}</td> -->
           <td class=" td-actions text-center">
	          <security:authorize access="hasRole('${form_code}_${modify}')">
		        <span>
	         		<i class="fa fa-pencil text-success text" data-ng-click="editRow(objMovementItem)"></i>
	        	</span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
		        <span>
	         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objMovementItem)"></i>
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