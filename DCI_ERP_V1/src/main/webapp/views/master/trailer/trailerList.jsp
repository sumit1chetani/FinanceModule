<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <!-- <div class="table-responsive "> -->
   
 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
   <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head"><tr>
								 <th class="sorting width_10" st-sort="trailerNo">Trailer No.
								 <th class="sorting width_10" st-sort="trailerType">Trailer Type
									</th>
							 <th class="sorting width_10" st-sort="numberofAxles">Number Of Axles</th>
									</th>
							 <th class="sorting width_10" st-sort="capacity">Capacity (Tonnes)</th>
								<!-- <th class="sorting width_3" st-sort="currency">Currency</th>
								<th class="sorting width_3" st-sort="status">Active</th> -->
															 <th class="sorting width_20" st-sort="remarks">Remarks</th>
								 <th class="sorting width_10 text-center table-heading"  st-sort="remarks">Action</th>
							</tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr class="route" data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="trailerBean in displayedCollection track by $index" >
<!--        <td class=""> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
      
<!--        <td class="sorting ">{{freeDaysBean.locationName}}</td>

 -->       
 <td class="wrapping"><a ng-click="view(trailerBean.trailerId)">
 								 <security:authorize access="hasRole('${form_code}_${view}')"> 
 								 <span tooltip="{{trailerBean.trailerNo}}" class="tool-tip-span font-blue">{{trailerBean.trailerNo}}</span>
  </security:authorize>
  </a></td>
 <td class="wrapping ">{{trailerBean.trailerType}}</td>
       <td class="wrapping ">{{trailerBean.numberofAxles}}</td>
       <td class="wrapping ">{{trailerBean.capacity}}</td>
              <td class="wrapping ">{{trailerBean.remarks}}</td>
              
       
    <%--    <td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(freeDaysBean.freedaysId)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(freeDaysBean.freedaysId)"></i>
									</span>
								 </security:authorize></td>  --%>
								 <td class=" td-actions text-center"> 
								  <security:authorize access="hasRole('${form_code}_${modify}')"> 
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(trailerBean.trailerId)"></i>
									</span>
									 </security:authorize>
								 <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(trailerBean.trailerId)"></i>
									</span>
								 </security:authorize></td> 
      </tr>
     </tbody>
    </table>
  <!--  </div> -->
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
   
   <div class="col-md-1">
			<span class="padding-left-10" style=" margin-left: auto;">
		 		<a class="btn btn-success btn-sm" data-ng-click="helpVideo('Add trailer','Trailer Help')">  Help video</a>	         	
		    </span>
		   
	   </div>
	   
  </div>
  </div>
 </div>
