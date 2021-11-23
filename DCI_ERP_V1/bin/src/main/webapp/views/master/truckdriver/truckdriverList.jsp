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

       <th class="sorting" st-sort="truckId">Truck Reg No</th>
              <th class="sorting" st-sort="trucklicenseNo">Truck Plate No(VIN)</th>
       
              <th class="sorting" st-sort="driverId">Primary Driver</th>
       <th class="sorting" st-sort="sdriverId">Secondary Driver</th>
       
       <th class="sorting" st-sort="fromDate">From</th>
       <th class="sorting" st-sort="toDate">To</th>
          
       
       
       
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="truckDriverrBean in displayedCollection">
<!--        <td class=""> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
      
<!--        <td class="sorting ">{{truckDriverrBean.locationName}}</td>

 -->       
 <td class="sorting"><a ng-click="view(truckDriverrBean.truckdriverId)">
 					<security:authorize access="hasRole('${form_code}_${view}')"> 
		             <span tooltip="{{truckDriverrBean.truckRegNo}}" class="tool-tip-span font-blue">{{truckDriverrBean.truckName}}</span>
		        </security:authorize>
		         </a>
		           </td>  <td class="sorting ">{{truckDriverrBean.trucklicenseNo}}</td>
		           <td class="sorting ">{{truckDriverrBean.driverName}}</td>
		            <td class="sorting ">{{truckDriverrBean.sdriverName}}</td>
       </td>  <td class="sorting ">{{truckDriverrBean.fromDate}}</td>
       <td class="sorting ">{{truckDriverrBean.toDate}}</td>
       
  
								 <td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(truckDriverrBean.truckdriverId)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(truckDriverrBean.truckdriverId)"></i>
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
		 		<a class="btn btn-success btn-sm" data-ng-click="helpVideo('Truck Driver mapping','Truck Driver mapping Help')">  Help video</a>	         	
		    </span>
		   
	   </div>
  </div>
  </div>
 </div>
</div>
</div>