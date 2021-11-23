<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" />
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${upload}')" var="isUpload" />
<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
 <div class=" padding-bottom-5">
 <div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
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
     <button class="btn btn-sm btn-success" ng-click="add()" ng-hide="hideAddIcon">
      <span class="fa fa-plus"></span>
     </button>
     </c:if>
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
     <c:choose>
      <c:when test="${isSearch}">
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