<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id">
    <div class="panel panel-default">
    <div class="form-body form-horizontal">
    
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
<!--        <th class="width_1"> -->
<!--        </th> -->

       <th class="sorting" st-sort="truckId">Truck Reg No.</th>
        <th class="sorting" st-sort="truckId">Truck Plate No.</th>
              <th class="sorting" st-sort="trailerId">Trailer</th>
       
       <th class="sorting" st-sort="fromDate">From</th>
       <th class="sorting" st-sort="toDate">To</th>
          
       
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="truckTrailerBean in displayedCollection">
<!--        <td class=""> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
      
<!--        <td class="sorting ">{{truckTrailerBean.locationName}}</td>

 -->       
 <td class="sorting"><a ng-click="view(truckTrailerBean.trucktrailerId)">
		             <security:authorize access="hasRole('${form_code}_${view}')"> 
		             <span tooltip="{{truckTrailerBean.truckRegNo}}" class="tool-tip-span font-blue">{{truckTrailerBean.truckName}}</span>
		         </security:authorize>
		         </a>
		           </td>  <td class="sorting ">{{truckTrailerBean.trucklicenseNo}}</td>
		            <td class="sorting ">{{truckTrailerBean.trailerName}}</td>
       </td>  <td class="sorting ">{{truckTrailerBean.fromDate}}</td>
       <td class="sorting ">{{truckTrailerBean.toDate}}</td>
       
    <%--    <td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(truckTrailerBean.trucktrailerId)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(truckTrailerBean.trucktrailerId)"></i>
									</span>
								 </security:authorize></td>  --%>
								 <td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(truckTrailerBean.trucktrailerId)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(truckTrailerBean.trucktrailerId)"></i>
									</span>
								 </security:authorize></td> 
      </tr>
     </tbody>
    </table>
   </div>
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
   <div class="col-md-1">
			<span class="padding-left-10" style=" margin-left: auto;">
		 		<a class="btn btn-success btn-sm" data-ng-click="helpVideo('Truck Trailer mapping','Truck Trailer mapping Help')">  Help video</a>	         	
		    </span>
		   
	   </div>
  </div>
  </div>
 </div>
</div>
</div>