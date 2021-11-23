<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection1">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<div class="panel panel-default panel-default-form ">

  <div class="panel-body">
   <form name="userLogForm" method="post" class="form-horizontal" novalidate>
   
    <div class="row pl2pc pr10pc">
        <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label">Status</label>
       <div class="col-md-7">
       	<selectivity list="statusList"
										property="quotation1.status" id="status" ng-model="quotation1.status"
										name="status" form-name="quotationForm"
										friendly-name="status"></selectivity>
       </div>
      </div>
     </div>
    
    </div>
    <!-- /row -->
    <div class="form-actions text-center">
     <div class="row ">
      <div class="col-md-offset-5 col-md-2">
       <button class="btn btn-success" type="button" ng-click="getList1(quotation1)">
        <i class="fa fa-search"></i>
        Search
       </button>
         <!--  <button class="btn btn-info" type="button"
								data-ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
			</button> -->
      </div>
     </div>
    </div>
   </form>
   </div>
   </div>
		
		
		
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
 							<th class="sorting width_8" st-sort="quotationNo">Quotation No</th>
							<th class="sorting width_10" st-sort="quotationDate">Quotation Date</th>
							<th class="sorting width_10" st-sort="validTill">Quote Valid Date</th>
							<th class="sorting width_10" st-sort="customer">Customer</th>
							<!-- <th class="width_2 text-center table-heading">Cntr.Dropoff</th> -->
							<th class="width_2 text-center table-heading">Origin</th>
							<th class="width_2 text-center table-heading">POL</th>
							<th class="width_2 text-center table-heading">FPOD</th>
							<th class="width_2 text-center table-heading">Is Valid</th>
							<th class="width_2 text-center table-heading">Submitted By</th>
							<th class="width_2 text-center table-heading">Location</th>
							<th class="width_2 text-center table-heading">Status</th>
							<th class="width_2 text-center table-heading">Action</th>

						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in displayedCollection">
							<!-- <td class="">
            <label class="i-checks m-b-none">
             <input type="checkbox" name="post[]">
             <i></i>
            </label>
           </td> -->

							<td class="sorting" st-sort="">{{collection.quotationNo}}</td>
							<td class="sorting" st-sort="">{{collection.quotationDate}}</td>
							<td class="sorting" st-sort="">{{collection.validTill}}</td>
							<td class="sorting" st-sort="">{{collection.customer}}</td>


							<!-- <td class="width_2 text-center table-heading">{{collection.dropoff}}</td> -->
							<td class="width_2 text-center table-heading">{{collection.origin}}</td>
							<td class="width_2 text-center table-heading">{{collection.pol}}</td>
							<td class="width_2 text-center table-heading">{{collection.pod}}</td>
							<td class="width_2 text-center table-heading">{{collection.status}}</td>
							<td class="width_2 text-center table-heading">{{collection.user}}</td>
							<td class="width_2 text-center table-heading">{{collection.location}}</td>
							<td class="width_2 text-center table-heading">{{collection.status1}}</td>
							<td class=" td-actions text-center">
							  <%--   <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span ng-if="collection.status1!='Pending'"> <i class="fa  fa-eye text-success text"
						data-toggle="tooltip" title="View" data-ng-click="approveRow(collection.quotationNo)"></i>
									</span>&nbsp&nbsp
							<%-- <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRowApprove(collection.quotationNo,collection.status1)"></i>
									</span>&nbsp
								<%-- </security:authorize> --%>
								<%-- <security:authorize access="hasRole('${form_code}_${approve}')"> --%>
									<span ng-if="collection.status1=='Pending'"> <i class="fa fa-check  text"
						data-toggle="tooltip" title="Approve" data-ng-click="approveRow(collection.quotationNo)"></i>
									</span>
								<%-- </security:authorize> --%>
								</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>