<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">

	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('F6192_${add}')" var="isAdd" />
<security:authorize access="hasRole('F6192_${delete}')" var="isDelete" />
<security:authorize access="hasRole('F6192_${upload}')" var="isUpload" />
<security:authorize access="hasRole('F6192_${search}')" var="isSearch" />
<security:authorize access="hasRole('F6192_${export}')" var="isExport" />
<security:authorize access="hasRole('F6192_${mail}')" var="isMail" />
<security:authorize access="hasRole('F6192_${bulkMail}')" var="isBulkMail" />
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>
   <!-- <p>
   <button type="button" class="btn btn-success" data-ng-hide="started" data-ng-click="start()">Start Demo</button>
   <button type="button" class="btn btn-danger" data-ng-show="started" data-ng-click="stop()">Stop Demo</button>
  </p> -->
  </div>
  <div class="col-md-6 text-right padding-right-0">
   <div class="row">
    <div class="col-md-6 p-r-3">
    <!--  <div class="btn btn-sm btn-info">
      <span ng-click="changeFont(3)" class="inline-block padding-both-side-2">
       <i class="fa fa-font"></i>
      </span>
      <span ng-click="changeFont(1)" class="inline-block padding-both-side-2">
       <i class="fa fa-plus"></i>
      </span>
      <span ng-click="changeFont(2)" class="inline-block padding-both-side-2">
       <i class="fa fa-minus"></i>
      </span>
     </div>
     <button class="btn btn-sm btn-info" ng-click="refresh()">
      <i class="icon-refresh"></i>
     </button> -->
      <c:if test="${isUpload}">
     <button class="btn btn-sm btn-primary" ng-click="fileUpload()" ng-hide="hideUploadIcon">
      <span class="fa fa-upload"></span>
     </button>
     </c:if>
    <!--  <button class="btn btn-sm btn-dark" ng-click="fileDownload()" ng-show="hideDownloadIcon">
      <span class="fa fa-download"></span>
     </button> -->
      <c:if test="${isAdd}"> 
     <button class="btn btn-sm btn-success"  style ="color: #ffffff;background-color: #1f3113;" ng-click="add()" ng-hide="hideAddIcon">
      <span class="fa fa-plus" data-toggle="tooltip" title="Create new record"></span>
     </button>
     </c:if> 
    <%--   <c:if test="${isBulkMail}"> --%>
    <!--  <button class="btn btn-sm btn-success"   ng-click="bulkMail()" ng-hide="hideAddIcon">
      <span class="fa fa-envelope"> Bulk Mail</span>
     </button> -->
        <%--   </c:if> --%>
      <%-- <c:if test="${isDelete}">
     <button class="btn btn-sm btn-danger" ng-click="deleteSelected()" ng-hide="hideEditIcon">
      <span class="fa fa-trash-o"></span>
     </button>
     </c:if> --%>
    <!--  <button class="btn btn-sm btn-info"   id="exportXl" ng-click="excel()" ng-show = "showExcel">
      <span class="fa fa-file-excel-o"></span>
     </button> -->
    <!--   <button class="btn btn-sm btn-info"   id="exportXl" ng-click="excel1()" ng-show = "showExcel">
      <span class="fa fa-download"></span>
     </button> -->
    </div>
    <div class="col-md-6  p-l-0">
    <%-- ${isSearch} --%>
     <c:choose>
      <c:when test="true">
       <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
      </c:when>
      <c:otherwise>
       <input type="text" disabled="disabled" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
      </c:otherwise>
     </c:choose>
    </div>
   </div>
  </div>
 </div>
</div>
		<!-- <div class="class="col-sm-12 col-md-3 col-lg-3">
		
		 <button class="btn btn-sm btn-success"  style ="color: #ffffff;background-color: #1f3113;" ng-click="add()" ng-hide="hideAddIcon">
      <span class="fa fa-plus" data-toggle="tooltip" title="Create new record"></span>
     </button>

		  
		</div> -->
<form name="userLogForm" method="post" class="form-horizontal" novalidate>
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
     
   
    <div class="col-md-4">
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
   </div>
   <div class="col-md-4">
   <div class="form-group">
												<label class="col-md-5 control-label">Country
											 
												</label>
												<div class="col-md-7">
												 <selectivity  list="countryList"
												  property="mrgBean.country" 
												  ng-model="mrgBean.country" 
												  id="country"  
												  name="country" 
												  form-name = "payrollgenertaionForm" ></selectivity>
												</div>
												<div class="col-md-5">
        	</div></div>
   </div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label">POL</label>
       <div class="col-md-7">
       	<selectivity list="polList"
										property="mrgBean.pol" id="pol" ng-model="mrgBean.pol"
										name="pol" form-name="mrgBeanForm"
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
										name="pod" form-name="mrgBeanForm"
										friendly-name="pod"></selectivity>
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
							<th class="sorting width_15 text-center" st-sort="fromDate">MRG No</th>
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
									
									<span> <i class="fa fa-eye text-success text"
										data-ng-click="view(row.mrgHdrNo)"></i>
									</span>
									
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