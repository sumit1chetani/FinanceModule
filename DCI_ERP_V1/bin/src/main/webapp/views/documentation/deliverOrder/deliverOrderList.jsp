<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="deliverOrderTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		 <%-- <%@include file="/views/templates/panel-header.jsp"%>  --%>
 <security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" />
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>

  </div>
  <div class="col-md-6 text-right padding-right-0">
   <div class="row">
    <div class="col-md-6 p-r-3">
     
     <button class="btn btn-sm btn-success"  style ="color: #ffffff;background-color: #4f9fc5fc;" ng-click="add()" ng-hide="hideAddIcon">
      <span class="fa fa-plus" data-toggle="tooltip" title="Create new record"></span>
     </button>
   
    </div>
    <div class="col-md-6  p-l-0">
       <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
    </div>
   </div>
  </div>
 </div>
</div> 
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
		<div class="panel-body float-left padding-10" style="width: 100%;">
		<div class="row" style="padding-bottom:2%;">
				<br>
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Mode</label>
								<div class="col-md-8">
									<selectivity list="modeList" ng-model="discharge.mode"
											validation="required" friendly-name="Mode"
											property="discharge.mode" id="mode" name="mode"
											form-name="vessselArrivalForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Carrier</label>
								<div class="col-md-8">
								<selectivity list="carrierList" ng-model="discharge.carrier"
											friendly-name="carrier"
											property="discharge.carrier" id="carrier" name="carrier" validation="required"
											form-name="vessselArrivalForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<div class="col-md-4">
									<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="search(discharge)">
								<i class="fa fa-search"></i> Search
							</button>
								</div>
								<!-- <div class="col-md-4" style="padding-left: 13px;">
									<button class="btn btn-danger" type="button" ng-if="!isEdit"
								ng-click="reset()">
								<i class="fa fa-refresh"></i>Reset
							</button>
								</div> -->
							<!-- 	<div class="col-md-4" style="padding-left: 0px;">
									<button class="btn btn-primary" type="button" 
								ng-click="exportExcel()">
								<i class="fa fa-file-excel-o"></i>Export Excel
								<a id="Export" stype="display:none" href="filePath/Discharge.xls" download="Discharge.xls"></a>
							</button>
								</div> -->
							</div>
						</fieldset>
					</div>
				</div>
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>

							<th class="sorting width_30" st-sort="deliveryCode">Delivery
								Order No</th>							
								<th class="sorting width_30" st-sort="blNo">Mode</th>
								<th class="sorting width_30" st-sort="blNo">BL No.</th>
								<th class="sorting width_30" st-sort="blNo">Booking No</th>
								
							<th class="sorting width_30" st-sort="blNo">Discharge Port</th>
							<th class="sorting width_30" st-sort="currenctDate">Date</th>
							<th class="sorting width_30" st-sort="vessel">Vessel</th>
			                <th class="sorting width_30" st-sort="voyage">Voyage</th>
							<th class="sorting width_30" text-center table-heading>Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">
							<td>
							<a ng-click="viewRow(item.rowId)">
									<span tooltip="{{item.deliveryCode}}"
									class="tool-tip-span font-blue">{{item.deliveryCode}}</span>
							</a>
                            </td>
							<!-- <td class="" data-toggle="tooltip" title="deliveryNo">{{item.deliveryCode}}</td> -->
							<td class="sorting" data-toggle="tooltip" title="{{item.invNo}}">{{item.mode}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.invNo}}">{{item.blNo}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.invNo}}">{{item.bookingNo}}</td>
							
							<td class="sorting" data-toggle="tooltip" title="{{item.invNo}}">{{item.dischargePort}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.blNo}}">{{item.currenctDate}} </td>
							<td class="sorting" data-toggle="tooltip" title="{{item.vessel}}">{{item.vessel}} </td>							
						   <td class="sorting" data-toggle="tooltip" title="{{item.voyage}}">{{item.voyage}} </td>							
							
							<td class=" td-actions"> <%-- <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(item.rowId)"></i>
									</span> 
									<span> <i class="fa fa-print text-success text"
										data-toggle="tooltip" title="Print"
										data-ng-click="print(item)"></i>
									</span>
									<!-- <span>
									<i class="fa fa-share-square text-success text" data-toggle="tooltip" 
									title="DO Revalidation" data-ng-click="doRevalidation(item)"></i>
									</span>
									
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Detention"
										data-ng-click="detentionInvoice(item)"></i>
									</span>  -->
								 <%-- </security:authorize> --%> <%-- <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.rowId)"></i>
									</span>
								</security:authorize> --%></td>
						</tr>
					</tbody>

				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding: 0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>

	</div>
</div>