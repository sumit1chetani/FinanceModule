<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" />
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${upload}')" var="isUpload" />
<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
<div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold">
 <div class="col-md-7 padding-right-0 padding-left-0 header-with-breadcrumb"></div>
 <div class="col-md-2 text-right padding-right-0 padding-left-0">
  <div class="btn btn-sm btn-info">
   <span ng-click="changeFont(1)" class="inline-block padding-both-side-2">
    <i class="fa fa-font"></i>
    <i class="fa fa-plus"></i>
   </span>
   <span ng-click="changeFont(2)" class="inline-block padding-both-side-2">
    <i class="fa fa-font"></i>
    <i class="fa fa-minus"></i>
   </span>
   <span ng-click="changeFont(3)" class="inline-block padding-both-side-2">
    <i class="fa fa-font"></i>
   </span>
  </div>
 </div>
 <div class="col-md-1 text-right padding-left-0">
  <c:if test="${isAdd}">
   <button class="btn btn-sm btn-success" ng-click="add()">
    <span class="fa fa-plus"></span>
   </button>
  </c:if>
  <c:if test="${isUpload}">
   <button class="btn btn-sm btn-danger" ng-click="deleteSelected()">
    <span class="fa fa-trash-o"></span>
   </button>
  </c:if>
 </div>
 <div class="col-md-2 padding-right-0 padding-left-0">
  <div class="input-group">
   <c:choose>
    <c:when test="${isSearch}">
     <span class="input-group-btn">
      <button class="glyphicon glyphicon-search btn btn-sm btn-default" type="button"></button>
     </span>
     <input type="text" st-search="" class="input-sm form-control" placeholder="Search">
    </c:when>
    <c:otherwise>
     <span class="input-group-btn">
      <button class="glyphicon glyphicon-search btn btn-sm btn-default" type="button" disabled="disabled"></button>
     </span>
     <input type="text" st-search="" disabled="disabled" class="input-sm form-control" placeholder="Search">
    </c:otherwise>
   </c:choose>
  </div>
 </div>
</div>