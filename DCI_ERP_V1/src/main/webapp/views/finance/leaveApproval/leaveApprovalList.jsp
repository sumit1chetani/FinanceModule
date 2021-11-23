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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${upload}')" var="isUpload" />
<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
<security:authorize access="hasRole('${form_code}_${export}')" var="isExport" />
<security:authorize access="hasRole('${form_code}_${mail}')" var="isMail" />
<security:authorize access="hasRole('${form_code}_${bulkMail}')" var="isBulkMail" />
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
</div>		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
<!-- 		           <th class="width_1"></th> -->
		           <th class="sorting width_12" st-sort="empId">Employee No.</th>
		           <th class="sorting width_12" st-sort="firstName">Employee Name</th>
		           <th class="sorting width_10" st-sort="leaveType">Leave Type</th>
		           <th class="sorting width_10" st-sort="fromDate">From Date</th>
		           <th class="sorting width_8" st-sort="toDate">To Date</th>
		           <th class="sorting width_10" st-sort="noofDays">No of Days</th>
		           <th class="sorting width_14" st-sort="leaveReason">Reason for Leave</th>
		           <th class="sorting width_8" st-sort="status">Status</th>
		           <th class="sorting width_9" st-sort="comments">Comments</th>
		           <th class="sorting width_9" >Action</th>
		          </tr>
		         </thead>
		         <tbody>
		         	 <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="leaveObj in displayedCollection">
<!-- 		         	<td cs-select="objVesselMasterItem"></td> -->
		         		<td>{{leaveObj.empId}}</td>
		         		<td>{{leaveObj.firstName}}</td>
		         		<td>{{leaveObj.leaveType}}</td>
		         		<td>{{leaveObj.dateFrom}}</td>
		         		<td>{{leaveObj.dateTo}}</td>
		         		<td>{{leaveObj.nofDays}}</td>
		         		<td>{{leaveObj.reason}}</td>
		         		<td>
			                <span ng-if="leaveObj.status == '0'">Pending</span>
			                <span ng-if="leaveObj.status == '1'">Approved</span>
			                <span ng-if="leaveObj.status == '2'">Cancelled</span>
			             </td>
		         		<td>{{leaveObj.comments}}</td>
		         	
			          <td class=" td-actions text-center">
			          <security:authorize access="hasRole('${form_code}_${modify}')">
				        <span >
				         <i class="fa  fa-pencil text-success text"  data-ng-click="editRow(leaveObj.leaveRequestId ,leaveObj.stepOrder)"></i>
				        </span>
				      </security:authorize>
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
	