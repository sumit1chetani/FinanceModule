
<!-- link and dropdown -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<%-- 
<security:authorize access="isAuthenticated()"> --%>

<style>
.conlmnMenu {
	width: 200% !important;
	max-height: 400px !important;
	overflow-x: hidden !important;
}

.conlmnMenu1 {
	width: 200%;
	max-height: 400px !important;
	overflow-x: hidden !important;
}

.conlmnMenu2 {
	width: 325px !important;
	max-height: 700px !important;
	margin-left: -150px !important;
	overflow-x: hidden !important;
}

.conlmnMenu3 {
	width: 550px !important;
	max-height: 500px !important;
	margin-left: -250px !important;
	overflow-x: hidden !important;
}

.conlmnMenu4 {
	width: 750px !important;
	max-height: 500px !important;
	margin-left: -500px !important;
	overflow-x: hidden !important;
	margin-left: -120px !important;
}

.conlmnMenu5 {
	width: 800px !important;
	max-height: 600px !important;
	margin-left: -550px !important;
	overflow-x: hidden !important;
}

.conlmnMenu6 {
	width: 950px !important;
	max-height: 500px !important;
	margin-left: -630px !important;
	overflow-x: hidden !important;
}

.conlmnMenu7 {
	width: 1050px !important;
	max-height: 500px !important;
	margin-left: -630px !important;
	overflow-x: hidden !important;
}
.mzr-content.conlmnMenu5 {
left: 300px;
}
</style>

<c:set var="formMasterBeans" value="${user.lFormMasterBean}" />

<ul class="meganizr mzr-slide mzr-responsive" data-mega-menu>
	<c:forEach items="${formMasterBeans}" var="formMasterBean"
		varStatus="loop">




		<c:if test="${formMasterBean.enabled}">
			<c:set var="count" value="0" scope="page" />

			<li class="mzr-drop mzr-levels" style="width: 9%"><c:set
					var="urlValue"
					value="data-ui-sref=${formMasterBean.formUrl} ({tenantid:tenantId})" />

				<a
				<c:out value="${fn:length(formMasterBean.lFormMasterBean) gt 0? '':urlValue}"/>
				data-ng-mouseover="showSubMenu=${formMasterBean.formCode}"> <c:out
						value="${formMasterBean.formName}" />

			</a> <c:set var="numOFMenuCols"
					value="${fn:substringBefore((fn:length(formMasterBean.lFormMasterBean))/15, '.')+1}" />
				<c:set var="formMasterBean1"
					value="${formMasterBean.lFormMasterBean}" /> <c:if
					test="${fn:length(formMasterBean.lFormMasterBean) > 0}">
					<%-- <c:if test="${loop.index == 0}">
						<div class="mzr-content " style="width:200%;max-height: 400px; overflow-x:hidden;">
						</c:if>
						<c:if test="${loop.index  == 2}">
						<div class="mzr-content " style="width: 325px;max-height: 700px;margin-left:-150px;   overflow-x:hidden;">
						</c:if>
						<c:if test="${loop.index  != 5 && loop.index  != 2 && loop.index != 0}">
						<div class="mzr-content " style="width: 200%;max-height: 400px;  overflow-x:hidden;">
						</c:if>
						<c:if test="${loop.index  == 5 && user.tenantId=='athena'}">
						<div class="mzr-content " style="width:750px;max-height: 500px;margin-left:-475px;  overflow-x:hidden;">
						</c:if>
						<c:if test="${loop.index  == 5 && user.tenantId=='unicon'}">
						<div class="mzr-content " style="width:800px;max-height: 600px;margin-left:-550px;  overflow-x:hidden;">
						</c:if> --%>
					<div
						class="mzr-content conlmnMenu${numOFMenuCols < 7 ? numOFMenuCols : ''}">
						<c:set var="count" value="0" scope="page" />
						<c:forEach begin="0"
							end="${(fn:length(formMasterBean.lFormMasterBean)/12)+1}"
							varStatus="loop">
							<div class="one-col">
								<ul class="mzr-links">
									<c:forEach begin="0" end="14" varStatus="innerloop">
										<c:set var="levelFourBean" value="${formMasterBean1[count]}"
											scope="page" />
										<%-- <c:if test="${levelFourBean.enabled}"> --%>
										<c:if
											test="${levelFourBean.parentForm == '' || levelFourBean.parentForm == false}">
											
											<c:if test="${levelFourBean.menuLevel == 2}">
												<li class="sub-menu-padding-two-left"><c:set
														var="urlValue"
														value="data-ui-sref=${levelFourBean.formUrl}({tenantid:tenantId})" />
													<a
													<c:out value="${fn:length(levelFourBean.lFormMasterBean) gt 0? '':urlValue}"/>
													data-ng-mouseover="showSubMenu=${levelFourBean.formCode}">
														<i class="fa fa-angle-double-right"></i>&nbsp;&nbsp; <c:out
															value="${levelFourBean.formName}" />
												</a></li>
											</c:if>
											<c:if test="${levelFourBean.menuLevel == 3}">
												<li class="sub-menu-padding-three-left"><c:set
														var="urlValue"
														value="data-ui-sref=${levelFourBean.formUrl}({tenantid:tenantId})" />
													<a
													<c:out value="${fn:length(levelFourBean.lFormMasterBean) gt 0? '':urlValue}"/>
													data-ng-mouseover="showSubMenu=${levelFourBean.formCode}">
														<i class="fa fa-angle-double-right"></i>&nbsp;&nbsp; <c:out
															value="${levelFourBean.formName}" />
												</a></li>
											</c:if>
											<c:if test="${levelFourBean.menuLevel == 4}">
												<li class="sub-menu-padding-four-left"><c:set
														var="urlValue"
														value="data-ui-sref=${levelFourBean.formUrl}({tenantid:tenantId})" />
													<a
													<c:out value="${fn:length(levelFourBean.lFormMasterBean) gt 0? '':urlValue}"/>
													data-ng-mouseover="showSubMenu=${levelFourBean.formCode}">
														<i class="fa fa-angle-double-right"></i>&nbsp;&nbsp; <c:out
															value="${levelFourBean.formName}" />
												</a></li>
											</c:if>

										</c:if>
										<c:set var="count" value="${count+1}" scope="page" />
										<c:if test="${levelFourBean.parentForm == true}">
											<h3>
												<c:if test="${levelFourBean.menuLevel == 1}">
													<a class="header_anch"
														style="color: #134d97; cursor: default;"
														<c:out value="${fn:length(levelFourBean.lFormMasterBean) gt 0? '':urlValue}"/>
														data-ng-mouseover="showSubMenu=${levelFourBean.formCode}">
														<i class="fa"></i>&nbsp;&nbsp;<c:out
															value="${levelFourBean.formName}" />
													</a>
												</c:if>
												<c:if test="${levelFourBean.menuLevel == 2}">
													<a class="header_anch sub-menu-padding-two-left"
														style="color: #134d97; cursor: default;"
														<c:out value="${fn:length(levelFourBean.lFormMasterBean) gt 0? '':urlValue}"/>
														data-ng-mouseover="showSubMenu=${levelFourBean.formCode}">
														<i class="fa"></i>&nbsp;&nbsp;<c:out
															value="${levelFourBean.formName}" />
													</a>
												</c:if>
											</h3>
										</c:if>
										<%-- </c:if> --%>
									</c:forEach>
								</ul>
							</div>
						</c:forEach>
					</div>

				</c:if></li>
		</c:if>

	</c:forEach>

</ul>


<%-- </security:authorize> --%>