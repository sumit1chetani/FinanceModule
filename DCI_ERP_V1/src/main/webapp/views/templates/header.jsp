<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet"> -->
<style>
.avatar img {
	width: 76%;
	border-radius: 500px;
}

.top-menu-welcome{
font-family: "Montserrat", sans-serif !important;
}
</style>
<script type="text/javascript">
	var tenantId = '';	
	$(function() {
		$('#userNameText').html($('#userName').val());
		$('#logoutFormId').attr('action', $('#tenantId').val() + "/logout");
	});
</script>
<!-- link and dropdown -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<security:authentication var="user" property="principal" />
<!-- Left nav -->
<script src="js/app/general/directives/megaMenu.js"></script>
<script src="js/vendor/smartmenu/jquery.smartmenus.bootstrap.js"></script>

<!-- navbar header 
<div class="navbar-header {{app.settings.navbarHeaderColor}}" >-->
<div
	style="background-color: #c3e3ef; color: #FFF; float: left; width: 17%; height: 65px">
	<input type="hidden" value="${user.tenantId}" id="userId"> <a
		href="/#/${user.tenantId}/dashboard/dashboard"> <span
		class="hidden-folded m-l-xs">{{app.nsfame}}</span> <img
		src="/img/MBKHelpVideos/Dental_Council_of_India_logo.png"
		style="width: 29% !important;height: 102% !important;">
	</a>
	<!-- <label style="
    font-size: 22px;
    margin-top: 14px; font-style: oblique !important;font-weight: bold !important;">FREE SEAS </label> -->
	<button class="pull-right visible-xs dk" ui-toggle-class="show"
		data-target=".navbar-collapse">
		<i class="glyphicon glyphicon-align-justify"></i>
	</button>
	<!-- brand -->



	<!-- / brand -->
</div>
<!-- / navbar header -->
<!-- navbar collapse -->

<div style="background-color: #c3e3ef;"
	class="collapse pos-rlt navbar-collapse box-shadow {{app.settings.navbarCollapseColor}}" >


	<div ng-include="'views/templates/menu.jsp'"
		ng-if="isMaster == 'false'"></div>



	<!-- / link and dropdown -->
	<!-- nabar right -->
	<ul class="nav navbar-nav navbar-right top-menu-profile">

	</ul>




	<ul class="nav navbar-nav navbar-right top-menu-welcome">
		<li class="hidden-xs pull-right" tooltip=""><span
			style="color: #071d86 ;" class="padding-top-0 padding-bottom-0">
				Welcome! <span class="text-capitalize"><c:out
						value="${fn:toLowerCase(user.username)}" /></span>
		</span></li>

	</ul>
	<!-- User Profile -->
	<ul class="nav navbar-nav navbar-right">
		<li class="dropdown"><a href class="dropdown-toggle clear"
			dropdown-toggle> <span
				class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
					<img src="img/profile.jpg" style="max-height: 100%;" ." class="">
					<i class="on md b-white bottom"></i>
			</span> <b class="caret"></b>
		</a> <!-- dropdown -->
			<ul class="dropdown-menu animated fadeInRight w">
				<li><a href="#/{{tenantId}}/userupdate"> <span
						class="text-capitalize"> <c:out
								value="${fn:toLowerCase(user.username)}" />
					</span>

				</a></li>
				<li class="divider"></li>
				<!-- 	<li><a href="#/{{tenantId}}/changePassword"> <span
						class="icon"><i class="fa fa-reply"></i> </span>Change Password
				</a></li> -->
				<li><a href="javascript:void(0);"
					onclick="$('#logoutFormId').submit();logoutJS();">
						<form class="form-horizontal" role="form" action="" method="post"
							id="logoutFormId">

							<span class="icon"><i class="fa fa-sign-out"></i> </span>Logout
						</form>
				</a></li>
			</ul> <!-- / dropdown --></li>
	</ul>
	<!-- / navbar right -->
</div>
<!-- / navbar collapse -->