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
<form name="mrgForm" method="post" class="form-horizontal" novalidate>
<br>
<br>
    <div class="row pl2pc pr10pc">

      <!--<div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label">Customer</label>
       <div class="col-md-7">
    <selectivity list="customerDropList" ng-model="mrgBean.customer"
										property="mrgBean.customer" id="customer"
										name="customer" form-name="mrgBeanForm"
										friendly-name="customer"></selectivity>
							
       </div>
      </div> 
     </div>-->
     
   
    <!-- <div class="col-md-4">
   <div class="form-group">
												<label class="col-md-5 control-label">Region
											 
												</label>
												<div class="col-md-7">
												 <selectivity  list="regionList"
												  property="mrgBean.region" 
												  ng-model="mrgBean.region" 
												  id="region"  
												  name="region" 
												  form-name = "payrollgenertaionForm" ></selectivity>
												</div>
												<div class="col-md-5">
        	</div></div>
   </div> -->
   <div class="col-md-4">
  <div class="form-group ">
								<label class="col-md-5 control-label">Service</label>
								<div class="col-md-7">
										<selectivity list="servicePartnerTypelist"
										property="mrgBean.serviceType" id="serviceType"
										name="serviceType" ng-model="mrgBean.serviceType"
										object="serviceType" friendly-name="service"
										validation="required" form-name="mrgForm"
										></selectivity>
										
								</div>
								</div>	
								</div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label">POL</label>
       <div class="col-md-7">
       	<selectivity list="portList"
										property="mrgBean.pol" id="pol" ng-model="mrgBean.pol"
										name="pol" form-name="mrgForm"
										friendly-name="pol"></selectivity>
       </div>
      </div>
     </div>
     
     <div class="col-md-4">   
          <!--   <div class="form-group">
       <label class="col-md-5 control-label">POD</label>
       <div class="col-md-7">
       	<selectivity list="portList"
										property="mrgBean.pod" id="pod" ng-model="mrgBean.pod"
										name="pod" form-name="mrgBeanForm"
										friendly-name="pod"></selectivity>
       </div>
      </div> -->
     </div>
     <div class="col-md-4">   
            <div class="form-group">
       <label class="col-md-5 control-label">POD</label>
       <div class="col-md-7">
       	<selectivity list="portList"
										property="mrgBean.pod" id="pod" ng-model="mrgBean.pod"
										name="pod" form-name="mrgForm"
										friendly-name="pod"></selectivity>
       </div>
      </div>
     </div>
     <div class="col-md-4">
     <div class="form-group ">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7">
										<selectivity list="customerDropList"
										property="mrgBean.customer" id="customer"
										name="customer" ng-model="mrgBean.customer"
										object="customer" friendly-name="Customer"
										validation="required" form-name="mrgForm"
										></selectivity>
							</div>
							</div>
							</div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label">Valid From </label>
       <div class="col-md-7">
       <ng-bs3-datepicker
									    data-ng-model="mrgBean.fromDate" 
										id="fromdate" name="fromdate"
										friendly-name="fromdate" />
       </div>
      </div>
     </div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label">Valid To </label>
       <div class="col-md-7">
       <ng-bs3-datepicker
									    data-ng-model="mrgBean.toDate" 
										id="todate" name="todate"
										friendly-name="todate" />
       </div>
      </div>
     </div>
    </div>
     
    
    <!-- /row -->
    <div class="form-actions text-center">
     <div class="row ">
     
      <div class="col-md-offset-3 col-md-5">
    
       
       <button class="btn btn-success" type="button" ng-click="getlist(mrgBean)">
        <i class="fa fa-search"></i>
        Search
       </button>
          <button class="btn btn-info" type="button"
								data-ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
			</button>
			<security:authorize access="hasRole('F6192_${upload}')">
				<button class="btn btn-success" type="button" ng-click="fileUpload()">
        <i class="fa fa-save"></i>
        Import
       </button>
       </security:authorize>
       			<%-- <security:authorize access="hasRole('F6192_${add}')">
       <button class="btn btn-warning" type="button"
										data-ng-click="copyMRG();">
										<i class="fa fa-files-o"></i> Copy MRG
									</button>
			</security:authorize> --%>
       <!-- <button class="btn btn-success" type="button" ng-click="getlist(mrgBean)">
        <i class="fa fa-file-excel-o"></i>
        PDF Export
       </button> -->
       <security:authorize access="hasRole('F6192_${export}')">
       <button class="btn btn-primary" ng-click="exportPDF(mrgBean)">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="sailingsch" stype="display:none"
											href="filePath/Freight Rates.pdf"
											download="Freight Rates.pdf"></a>
									</button> 
									</security:authorize>
									  <security:authorize access="hasRole('F6192_${export}')">
									<button class="btn btn-primary" ng-click="exportExcel(mrgBean)">
										<i class="fa fa-file-excel-o"> </i> Export Excel<a
											id="mrgdtl" style="display:none"
											href="filePath/Freight Rates.xls"
											download="Freight Rates.xls"></a>
									</button>	
									</security:authorize>
									  <security:authorize access="hasRole('F6192_${export}')">
									<button class="btn btn-primary" data-ng-click="sendMailwithPDF(mrgBean)">
										<i class="icon-envelope "> </i>Send Mail <!-- <a
											id="sailingsch" stype="display:none"
											href="filePath/MRG.pdf"
											download="MRG.pdf"></a> -->
									</button>	
									</security:authorize>
									  <security:authorize access="hasRole('F6192_${view}')">
									<button class="btn btn-primary"ng-click="importLog()" style="background-color: orange;">
										<i class="fa fa-expand "> </i>File Import History 
									</button>	
									</security:authorize>	
												     
      </div>
        
     </div>
     
    </div>
   </form>
   
   
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">

				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<!-- <th class="sorting width_20 text-center" st-sort="customer">Customer</th> -->
							<th class="sorting width_15 text-center" st-sort="fromDate">MRG No.</th>
							<th class="sorting width_15 text-center" st-sort="fromDate">From Date</th>
							<th class="sorting width_15 text-center" st-sort="toDate">To Date</th>
							<th class="sorting width_13 text-center" st-sort="origin">Origin</th>
							<th class="sorting width_13 text-center" st-sort="pol">POL</th>
							<th class="sorting width_13 text-center" st-sort="pod">POD</th>
							<th class="sorting width_11 text-center">Actions</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="row in displayedCollection">
							<!-- <td class="sorting">{{row.customer}}</td> -->
			
<td class=""><a ng-click="view(row.mrgHdrNo)">
							 <security:authorize access="true"> 
		             <span tooltip="{{row.mrgHdrNo}}" class="tool-tip-span font-blue">{{row.mrgHdrNo}}</span>
		         </security:authorize> 
		         </a></td>				
							
							<!-- <td class="sorting" style="color: blue;" data-ng-click="view(row.mrgHdrNo)">{{row.mrgHdrNo}}</td> -->
							<td class="sorting">{{row.fromDate}}</td>
							<td class="sorting">{{row.toDate}}</td>
							<td class="sorting">{{row.origin}}</td>
							<td class="sorting">{{row.pol}}</td>
							<td class="sorting">{{row.pod}}</td>
							<td class=" td-actions text-center"><%-- <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<security:authorize access="hasRole('F0298_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(row.mrgHdrNo)"></i>
									</span>
									</security:authorize>
									<security:authorize access="hasRole('F0298_${modify}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(row.mrgHdrNo)"></i>
									</span>
									 </security:authorize>
									<%--<security:authorize access="hasRole('F0298_${view}')">
									<span> <i class="fa fa-eye text-success text"
										data-ng-click="view(row.mrgHdrNo)"></i>
									</span>
									</security:authorize>
									<security:authorize access="hasRole('F0298_${view}')">
									<span > <i class="icon-envelope red"
					              	data-toggle="tooltip" title="Send Mail" data-ng-click="sendMail(row.mrgHdrNo)"></i>
									</span>
									</security:authorize>
									<security:authorize access="hasRole('F0298_${modify}')">
									<span > <i class="fa fa-files-o"
					              	data-toggle="tooltip" title="Copy MRG" data-ng-click="copyMRG(row)"></i>
									</span>
									</security:authorize> --%>
									<!-- <span data-ng-click="exportPDFnew(mrgBean,row.mrgHdrNo)"> <i class="fa  fa-download text-success text" title="pdf download"> </i> <a
											id="sailingsch" stype="display:none"
											href="filePath/MRG.pdf"
											download="MRG.pdf"></a>
									</span> -->
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
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
		<!-- end widget content -->
	</div>
	<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
</div>
<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
	<a class="btn btn-success" href="/assets/docs/MRG_IMPORT_FORMAT.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadMRG()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>