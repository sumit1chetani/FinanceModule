<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		
		<style>

button.btn.btn-success.help-button {
    
    background-color: #ff0000c4 !important;
}

</style>
		
		
		<button class="btn btn-success help-button" type="button" data-ng-click="tdsHelpVideo('CRO Help Video.mp4','CRO Help Video')">
        <i class="fa fa-video-camera"></i>
        Help Video
       </button>
     
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
							<th class="sorting width_2 text-center table-heading" st-sort="containerreleaseCode">Container Release Code</th>
							<th class="sorting width_2 text-center table-heading" st-sort="customer">Customer</th>
							<th class="sorting width_2 text-center table-heading" st-sort="bookingCode">Booking No </th>
							<th class="sorting width_2 text-center table-heading" st-sort="depot">Depot</th>
							<th class="sorting width_2 text-center table-heading" st-sort="gateInNo">Gate-In No</th>
							<th class="sorting width_2 text-center table-heading" st-sort="gateOutNo">Gate-Out No</th>
							<th class="sorting width_2 text-center table-heading" st-sort="gateInStatus">Gate-In Status</th>
							<th class="sorting width_2 text-center table-heading" st-sort="gateOutStatus">Gate-Out Status</th>
							<!-- <th class="width_2 text-center table-heading">POD</th> -->
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
					
							<td class="text-center" >{{collection.containerreleaseCode}}</td>
							<td class="text-center" >{{collection.customer}}</td>
							<td class="text-center" >{{collection.bookingCode}}</td>
							<td class="text-center" >{{collection.depot}}</td>
								<td class="text-center"> <a ng-click="viewGateIn(collection.gateInNo)"> 
		             <span tooltip="{{collection.gateInNo}}" class="tool-tip-span font-blue ">{{collection.gateInNo}}</span>
	 
		         </a></td>
									<td class="sorting" st-sort=""> <a ng-click="viewGateOut(collection.gateOutNo)"> 
		             <span tooltip="{{collection.gateOutNo}}" class="tool-tip-span font-blue ">{{collection.gateOutNo}}</span>
	 
		         </a></td>
										<td class="sorting" st-sort="">{{collection.gateInStatus}}</td>
											<td class="sorting" st-sort="">{{collection.gateOutStatus}}</td>
							<!-- <td class="width_2 text-center table-heading">{{collection.pod}}</td> -->
							<td class=" td-actions text-center">
								<security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(collection.containerreleaseCode,collection.gateOutStatus)"></i>
									</span>
								</security:authorize> 
								<security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(collection.containerreleaseCode,collection.gateOutStatus)"></i>
									</span>
								</security:authorize>
								
								 <!--<div class="fa fa-file-excel-o"  data-ng-click="excelexport(collection.containerreleaseCode)">
								</div>				
								<a id="emptyExport" stype="display:none"
							href="filePath/ContainerReleaseOrder.xlsx" download="ContainerReleaseOrder.xlsx"></a>
							
								   <span> 
               				 <i class="fa  fa-print text-success text" title="Booking Confirmation" data-ng-click="printBooking(collection.containerreleaseCode)"></i>
			 					 </span> -->
			 					  <span> 
               				 <i class="fa  fa-print text-primary text" title="CRO Print" data-ng-click="printCRO(collection.containerreleaseCode)"></i>
			 					 </span>
			 					  <!--  <span> 
               				 <i class="fa  fa-print text-success text" title="Release Order" data-ng-click="printreleaseorder(collection.containerreleaseCode)"></i>
			 					 </span>
			 					 <span> 
               				 <i class="icon-envelope red" title="CRO Mail" data-ng-click="sendMail(collection.containerreleaseCode)"></i>
			 					 </span> -->
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