<!-- link and dropdown -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!-- / buttons -->
<style>
.leftMenu > li{
     list-style-type: none;
}
</style>
<security:authentication var="user" property="principal" />
<security:authorize access="isAuthenticated()">
 <c:set var="formMasterBeans" value="${user.lFormMasterBean}" />
 <div class="aside-wrap" style="background-color: #e08252 !important;margin-top: 10px;padding-bottom: 30px;">
  <div class="navi-wrap">
   <!-- nav -->
   <!-- <nav ui-nav class="navi"> -->


	<!-- <ul class="mzr-links leftMenu" style="-webkit-padding-start: 12px;line-height: 2.0em;"><h3><a>{{leftMenuHeader}}</a></h3>
	 <li class="sub-menu-padding-two-left"  ng-repeat="lmenu in leftMenuList">
    <a ng-click="popitup(lmenu.form_URL)"><i class="fa fa-angle-double-right"></i> {{lmenu.formName}} </a>
     
    </li>
	</ul> -->

				<%-- <c:forEach items="${formMasterBeans}" var="formMasterBean">
     <c:if test="${formMasterBean.enabled}">
      <ul data-smart-menu data-ng-show="subMenuId!='${formMasterBean.formCode}'">
       <c:forEach items="${formMasterBean.lFormMasterBean}" var="formMasterBean">
        <c:if test="${formMasterBean.enabled}">
         <li <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'data-menu-collapse':'data-ui-sref-active=active'}"/>>
          <c:set var="urlValue" value="class=menu-item-parent-single ng-click=popitup('${formMasterBean.formUrl}')" />
          <a <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'href=#':urlValue}"/>>
           <span class="menu-item-parent">
            <c:out value="${formMasterBean.formName}" />
           </span>
          </a>
          <c:if test="${fn:length(formMasterBean.lFormMasterBean) gt 0}">
           <ul>
            <c:forEach items="${formMasterBean.lFormMasterBean}" var="formMasterBean">
             <c:if test="${formMasterBean.enabled}">
              <li <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'data-menu-collapse':'data-ui-sref-active=active'}"/>>
               <c:set var="urlValue" value="class=menu-item-parent-single ng-click=popitup('${formMasterBean.formUrl}')" />
               <a <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'href=#':urlValue}"/>>
                <span class="menu-item-parent">
                 <c:out value="${formMasterBean.formName}" />
                </span>
               </a>
              </li>
             </c:if>
            </c:forEach>
           </ul>
          </c:if>
         </li>
        </c:if>
       </c:forEach>
      </ul>
     </c:if>
    </c:forEach> --%>
  <!--  </nav> -->
  </div>
 </div>
</security:authorize>
<%--
 <div class="aside-wrap"">
  <div class="navi-wrap">
   <!-- nav -->
   <nav ui-nav class="navi">
    <c:forEach items="formMasterBeans1" var="formMasterBean1">
     <c:out value="${formMasterBean1.enabled}" />
     <ul data-smart-menu data-ng-show="app.menuId==${formMasterBean1}">
       <c:out value="${user1.lFormMasterBean}" />
      <c:forEach items="${formMasterBean.lFormMasterBean}" var="formMasterBean">
       <li <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'data-menu-collapse':'data-ui-sref-active=active'}"/>>
        <c:set var="urlValue" value="class=menu-item-parent-single ng-click=popitup('${formMasterBean.formUrl}')" />
        <a <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'href=#':urlValue}"/>>
         <span class="menu-item-parent">
          <c:out value="${formMasterBean.formName}" />
         </span>
        </a>
        <c:if test="${fn:length(formMasterBean.lFormMasterBean) gt 0}">
         <ul>
          <c:forEach items="${formMasterBean.lFormMasterBean}" var="formMasterBean">
           <li <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'data-menu-collapse':'data-ui-sref-active=active'}"/>>
            <c:set var="urlValue" value="class=menu-item-parent-single ng-click=popitup('${formMasterBean.formUrl}')" />
            <a <c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? 'href=#':urlValue}"/>>
             <span class="menu-item-parent">
              <c:out value="${formMasterBean.formName}" />
             </span>
            </a>
            <c:if test="${fn:length(menuItems[subMenuItemTwo.menuId]) gt 0}">
             <ul>
              <c:forEach items="${menuItems[subMenuItemTwo.menuId]}" var="subMenuItemThree" varStatus="loopThree">
               <li <c:out value="${fn:length(menuItems[subMenuItemThree.menuId]) gt 0? 'data-menu-collapse':'data-ui-sref-active=active'}"/>>
                <c:set var="urlValue" value="class=menu-item-parent-single ng-click=popitup(${subMenuItemThree.menuUrl})" />
                <a <c:out value="${fn:length(menuItems[subMenuItemThree.menuId]) gt 0? 'href=#':urlValue}"/>>
                 <span class="menu-item-parent">
                  <c:out value="${subMenuItemThree.menuName}" />
                 </span>
                </a>
                <c:if test="${fn:length(menuItems[subMenuItemThree.menuId]) gt 0}">
                 <ul>
                  <c:forEach items="${menuItems[subMenuItemThree.menuId]}" var="subMenuItemFour" varStatus="loopFour">
                   <li <c:out value="${fn:length(menuItems[subMenuItemFour.menuId]) gt 0? 'data-menu-collapse':'data-ui-sref-active=active'}"/>>
                    <c:set var="urlValue" value="class=menu-item-parent-single ng-click=popitup(${subMenuItemFour.menuUrl})" />
                    <a <c:out value="${fn:length(menuItems[subMenuItemFour.menuId]) gt 0? 'href=#':urlValue}"/>>
                     <span class="menu-item-parent">
                      <c:out value="${subMenuItemFour.menuName}" />
                     </span>
                    </a>
                   </li>
                  </c:forEach>
                 </ul>
                </c:if>
               </li>
              </c:forEach>
             </ul>
            </c:if>
           </li>
          </c:forEach>
         </ul>
        </c:if>
       </li>
      </c:forEach>
     </ul>
    </c:forEach>
   </nav>
  </div>
 </div>
</security:authorize> --%>