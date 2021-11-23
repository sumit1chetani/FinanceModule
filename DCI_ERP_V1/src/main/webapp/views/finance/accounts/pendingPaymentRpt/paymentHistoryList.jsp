<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<style>
.dropdown-menu>li>a {
	padding: 5px 36px;
}

.form-control {
	border: 1px solid #DDD;
	border-radius: 7px;
	box-shadow: none;
	height: 42px;
	padding: 8px 12px 9px 12px;
}
</style>
<security:authentication var="user" property="principal" />
<%-- <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%> --%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="BLDraftTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>
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
   
  </div>
  <div class="col-md-6 text-right padding-right-0">
   <div class="row">
    <div class="col-md-6 p-r-3">
     
     <button class="btn btn-sm btn-success"  style ="color: #ffffff;background-color: #1f3113;" ng-click="add()" >
      <span class="fa fa-plus" data-toggle="tooltip" title="Create new record"></span>
     </button>
   
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
  <div class="panel-body padding-10">
    <div class="table-responsive" style=" border: 1px solid #CCC;">
   
		<div class="panel panel-default panel-default-form ">
				<div class="panel-body">
					
			<form id="pendingPaymentReportForm" name="pendingPaymentReportForm" class="form-horizontal" novalidate method="post">
				<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
					<div class="col-sm-4 col-md-4 col-lg-4">
					
						<button class="btn btn-primary" ng-click="exportPaymentHistoryExcel()">
							<i class="fa fa-download"> Export Excel</i>
						</button>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
					<div id="jqgrid">
						<table id="paymentHistoryReportGrid"></table>
						<div id="paymentHistoryReportPage"></div>
					</div>
		     	</div>
			</form>
		</div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>