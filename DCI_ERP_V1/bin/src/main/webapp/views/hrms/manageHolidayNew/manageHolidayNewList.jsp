<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
                                   <th class="sorting width_3" st-sort="companyName">Company Name </th>
            
                       <th class="sorting width_3" st-sort="branch">Branch </th>
                      <th class="sorting width_3" st-sort="holidayName">Holiday Name </th>
                      <th class="sorting width_3" st-sort="date">Date</th>
<!--                       <th class="sorting width_3" st-sort="branchCode">Day</th>
 -->                      
                       <th class="width_2 text-center table-heading">Action </th>
           
          </tr>
         </thead>
      <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="holidayCollection in displayedCollection">
<!--            <td cs-select="objVesselMasterItem" class="text-center"></td> -->
<!-- 			<td>{{holidayCollection.branch}}</td> -->  
<td>{{holidayCollection.companyName}}</td> 
<td>{{holidayCollection.branch}}</td> 
         <td>{{holidayCollection.holidayName}}</td> 
            <td>{{holidayCollection.date}}</td> 
<!--              <td>{{holidayCollection.day}}</td> 
 -->             <td class=" td-actions text-center">
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(holidayCollection)"></i>
        </span>
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(holidayCollection.holidayId)"></i>
        </span>
       </td>
          </tr>
         </tbody>
	       </td>
	      </tr>
	     </tbody>
    </table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
		<!-- end widget content -->
	</div>
	</div>
	