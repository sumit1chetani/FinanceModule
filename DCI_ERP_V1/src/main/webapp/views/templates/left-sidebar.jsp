<!-- <style>
body{
	position:none;
}
</style> -->

<div class="sidebar-profile" xmlns:th="http://www.thymeleaf.org">
	<div class="avatar">
		<img class="img-circle profile-image" src="/img/profile.jpg"> <i
			class="on border-dark animated bounceIn"></i>
	</div>
	<script type="text/javascript">
		var tenantId = '';
		$(function() {
			$('#userNameText').html($('#userName').val());
			$('#logoutFormId').attr('action', "/"+$('#tenantId').val()+"/logout");
			$("#userNameText").attr('title', $('#userName').val());
		});
	</script>
	<div class="profile-body dropdown">
		<a href="javascript:void(0);" class="dropdown-toggle"
			data-toggle="dropdown" aria-expanded="false"><h4>
				<input type="hidden" id="idaasRoleId"> <span
					id="userNameText"
					style="display: inline-block; width: 92%; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; margin-left: 3px;">
				</span><span class="caret"></span>
			</h4></a>
		<ul class="dropdown-menu animated fadeInRight" role="menu">
			<li class="profile-progress">
				<h5>
					<span>80%</span> <small>Profile complete</small>
				</h5>
				<div class="progress progress-xs">
					<div class="progress-bar progress-bar-primary" style="width: 80%">
					</div>
				</div>
			</li>
			<li class="divider"></li>
			<li><a href="javascript:void(0);" ng-click="myAccount()"> <span class="icon"><i
						class="fa fa-user"></i> </span>My Account
			</a></li>
			<!--   <li>
                <a href="javascript:void(0);">
                    <span class="icon"><i class="fa fa-envelope"></i>
                                </span>Messages</a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <span class="icon"><i class="fa fa-cog"></i>
                                </span>Settings</a>
            </li> -->
			<li class="divider"></li>
			<li><a href="javascript:void(0);"
				onclick="$('#logoutFormId').submit()">
					<form class="form-horizontal" role="form" action="" method="post"
						id="logoutFormId">

						<span class="icon"><i class="fa fa-sign-out"></i> </span>Logout
					</form>
			</a></li>
		</ul>
	</div>
</div>
<nav>
	<h5 class="sidebar-header"></h5>
	<!-- location directive.js | data-nav-toggle-sub maps to -->
	<ul class="nav nav-pills nav-stacked" data-nav-toggle-sub ng-show="leftMenuBar" ng-if="isAdmin!='4'" data-smart-menu>
		<!-- <li ui-sref-active="active" class="tenantClass"
			ng-class="{active: $state.includes('ui')}"><a
			href="" title="Dashboard"
			ui-sref="dashboard.list({tenantid:tenantId})"> <i
				class="fa fa-fw fa-tachometer"></i> Dashboard
		</a></li> -->
<li ui-sref-active="active" class="adminClass" ng-if="isMaster == 'true'">
			<a href="javascript:" ui-sref="organization.show"
			title="Company List"><i class="fa fa-university"></i>Organization
		</a>
		</li>
<li ui-sref-active="active" class="adminClass" ng-if="isMaster == 'false'">
            <a href="javascript:" ui-sref="company.show({tenantid:tenantId})" title="Company List"><i class="fa fa-fw fa-user"></i> Company
            </a>
        </li>
		
		<li ui-sref-active="active" ng-if="isMaster == 'false'">
            <a href=""  title="Container Type" ui-sref="containerType.list({tenantid:tenantId})">
                <i class="fa fa-fw fa-tachometer"></i> Container Type

        </li>  
        
         </li> 
        	<li ui-sref-active="active" >
            <a href=""  title="Container Type" ui-sref="driver.list({tenantid:tenantId})">
                <i class="fa fa-fw fa-tachometer"></i> Driver </a>

        </li>  
        
         </li> 
        	<li ui-sref-active="active" >
            <a href=""  title="Container Type" ui-sref="truck.list({tenantid:tenantId})">
                <i class="fa fa-fw fa-tachometer"></i> Truck</a>

        </li>  
</ul>
</nav>
