<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />

 <div class="row  m-n">
  
  <div class="col-md-12 ">
   <div class="row">
    
    <div class="col-md-3  text-right padding-right-0"  style="float: right;">
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
