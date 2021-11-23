<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list" st-persist="commidityListTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>		
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('F0323_${add}')" var="isAdd" />
<security:authorize access="hasRole('F0323_${delete}')" var="isDelete" />
<security:authorize access="hasRole('F0323_${upload}')" var="isUpload" />
<security:authorize access="hasRole('F0323_${search}')" var="isSearch" />
<security:authorize access="hasRole('F0323_${export}')" var="isExport" />
<security:authorize access="hasRole('F0323_${mail}')" var="isMail" />
<security:authorize access="hasRole('F0323_${bulkMail}')" var="isBulkMail" />
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
     <button class="btn btn-sm btn-info"   id="exportXl" ng-click="excel()" ng-show = "showExcel">
      <span class="fa fa-file-excel-o"></span>
     </button> 
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
 <style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<!-- <div class="table-responsive "> -->
			<table class="table table-striped table-hover dataTable no-footer">
			
				<thead class="dataTables-Main-Head">
					<tr>

						<th class="sorting width_2" st-sort="commodityCode">Commodity
							Code</th>
<!-- 						<th class="sorting width_2" st-sort="classification">Classification</th>
 -->						<th class="sorting width_2" st-sort="commodity">Commodity</th>
						<th class="sorting width_2" st-sort="classificationCode">Hazardous</th>
						<th class="sorting width_2" st-sort="commodityCode">UNNo.</th>
						<th class="sorting width_2" st-sort="classificationCode">Flash Point</th>

						<th class="width_2 text-center table-heading">Action</th>
					</tr>

				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="collection in displayedCollection">

						<td><a ng-click="view(collection.commodityCode)"> <span
								tooltip="{{collection.commodityCode}}"
								class="tool-tip-span font-blue">{{collection.commodityCode}}</span>
						</a></td>
<!-- 						<td>{{collection.classification}}</td>
 -->						<td>{{collection.commodity}}</td>
						<td><input type="checkbox"
												class="checkbox style-0" 
												ng-true-value="'Y'" ng-false-value="'N'" name="hazardous"
												ng-model="collection.hazardous" disabled="true"> </td>
						<td>{{collection.unno}}</td>
						<td>{{collection.flashPoint}}</td>


						<td class=" td-actions text-center"><security:authorize
								access="hasRole('F0323_${modify}')">
								<span> <i class="fa  fa-pencil text-success text"
									data-ng-click="editRow(collection.commodityCode)"></i>
								</span>
							</security:authorize> <security:authorize access="hasRole('F0323_${delete}')">
								<span> <i class="fa fa-trash-o text-danger-dker text"
									data-ng-click="deleteRow(collection.commodityCode)"></i>
								</span>
							</security:authorize></td>
					</tr>
				</tbody>
			</table>
			<!-- </div> -->
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>