<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-persist="shipmentOrderTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  
  
  
  <div class="panel-body">
			<form name="vessselArrivalForm" class="form-horizontal">
				<div class="row">					

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7">
										<selectivity list="polList" ng-model="shipmentOrder.pol"
											validation="required" friendly-name="pol"
											property="shipmentOrder.pol" id="pol" name="pol"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>



							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label>
									<div class="col-md-7">
										<selectivity list="podList" ng-model="shipmentOrder.pod"
											validation="required" friendly-name="pod"
											property="shipmentOrder.pod" id="port" name="pod"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							
							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">T/S</label>
									<div class="col-md-7">
										<selectivity list="tsStatusList" ng-model="shipmentOrder.bookingStatus"
											validation="required" friendly-name="pol"
											property="shipmentOrder.bookingStatus" id="bookingStatus" name="bookingStatus"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							
							
							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">Gate Out Status</label>
									<div class="col-md-7">
										<selectivity list="gateOutStatusList" ng-model="shipmentOrder.gateoutStatus"
											validation="required" friendly-name="gateoutStatus"
											property="shipmentOrder.gateoutStatus" id="port" name="gateoutStatus"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							<!-- <div class="col-md-3">

<div class="form-group ">
								<label  class="col-md-5 control-label">Mode 
								</label>
								<div class="col-md-7">

									<selectivity list="modeList"
										property="shipmentOrder.mode" id="mode"
										name="mode" ng-model="shipmentOrder.mode"
										object="mode" friendly-name="Mode"
										 form-name="vessselArrivalForm"
										></selectivity>

</div>

								</div>
							</div> -->
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="shipmentOrder.carrier"
											property="shipmentOrder.carrier" id="carrier" name="carrier"
											form-name="vessselArrivalForm" friendly-name="carrier"></selectivity>

									</div>
								</div>
							</div>
							
						</fieldset>
					</div>


				</div>
				<br>
				<div class="row ">
							<div class="col-md-12 ">
							
							<div class="col-md-12" style ="text-align:center;">									
								
										<button class="btn btn-success" type="button"
									ng-click="getSearchList()">
									<i class="fa fa-search"></i> Search
								</button>
								
								<!-- <button class="btn btn-primary" type="button" ng-click="exportExcelmain()">
        <span class="fa fa-file-excel-o"> </span> Export Excel 
        <a id="containerIdle" stype="display:none"
					href="filePath/ContainerIdleReportByLocation.xlsx" download="ContainerIdleReportByLocation.xlsx"></a>
       </button> -->
								
								<button class="btn btn-info" type="button"
									data-ng-click="reset()">
									<i class="fa fa-undo"></i> Reset
								</button>
                             </div>

							</div>
						</div>
			</form>

		</div>
					
  <div class="panel-body float-left padding-10" style="width: 100%;">
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead style="background-color: #e2e2e2;">
      <tr>
   
       <th class="sorting width_15" st-sort="shipmentNo">Job No.</th>
       <th class="sorting width_15" st-sort="bookingId">Booking No.</th>
       <th class="sorting width_15" st-sort="gateoutNo">Gate Out No.</th>
       <th class="sorting width_20" st-sort="customer">Customer</th>
         <th class="sorting width_15" st-sort="pol">POL</th>
           <th class="sorting width_15" st-sort="pod">POD</th>
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objdepartmentItem in displayedCollection">
       <!-- <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td> -->
       <td class="sorting"><a ng-click="viewRow(objdepartmentItem.shipmentNo)"> 
  			<span tooltip="{{objdepartmentItem.shipmentNo}}" class="tool-tip-span font-blue "> {{objdepartmentItem.shipmentNo}}</span></a> </td>
       <td ng-if="objdepartmentItem.shipmentNo==='' || objdepartmentItem.shipmentNo===null">  <a ng-click="editshipOrd(objdepartmentItem.bookingId )"> 
  			<span tooltip="{{objdepartmentItem.bookingId}}" class="tool-tip-span font-blue ">{{objdepartmentItem.bookingId}}</span>
	 </a> </td> 
 <td ng-if="objdepartmentItem.shipmentNo !='' && objdepartmentItem.shipmentNo !=null"> {{objdepartmentItem.bookingId}} </td>
       <!-- <td>{{objdepartmentItem.bookingId}}</td> -->
       <td>{{objdepartmentItem.gateoutNo}}</td>
       <td>{{objdepartmentItem.customer}}</td>
         <td>{{objdepartmentItem.pol}}</td>
           <td>{{objdepartmentItem.pod}}</td>
           
        <td class=" td-actions text-center" ng-show="objdepartmentItem.shipmentNo !='' && objdepartmentItem.shipmentNo !=null" >
<%--         <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>         <span ng-if='!objdepartmentItem.blCreated'>
          <i class="fa  fa-pencil text-success text"data-toggle="tooltip" title="Edit"
          data-ng-click="editRow(objdepartmentItem.shipmentNo)"></i>
         </span>
        <%-- </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"   
          data-ng-click="deleteRow(objdepartmentItem.shipmentNo)"></i>
         </span>
<%--         </security:authorize>
 --%>       </td>
       
       
     
       
       
        <td class=" td-actions text-center"  ng-show="objdepartmentItem.shipmentNo==='' || objdepartmentItem.shipmentNo===null"> 	</td>
       
      </tr>
     </tbody>
    </table>
   </div>
     <footer class="panel-footer panel-footer-list" style="padding:0px;">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div>