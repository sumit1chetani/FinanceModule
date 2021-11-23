<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
				<%@include file="/views/templates/panel-header-form.jsp"%>
			<!-- <ol class="breadcrumb inline-block padding-left-0">
				<li><a>Master</a></li>
				<li><a x-ui-sref="app.master.user">User</a></li>
				<li><a x-ui-sref="app.master.user.resetpassword">Reset Password </a></li>				
			</ol> -->
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="resetPasswordForm"  novalidate method="post"> 
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> User Id <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-2">
										<!-- <input type="text" class="text-left form-control input-sm" 
											name="userId" ng-model="resetPasswordData.userId"
											 data-message-id="userId" validation="required"
														friendly-name="User Id">	 -->
									<selectivity list="userList" ng-model="resetPasswordData.userId"  property="resetPasswordData.userId" validation="required"
														name ="userId" form-name ="resetPasswordForm" friendly-name="User Name"></selectivity>
																																			
									</div>
								</div>
								<br>
								<div class="form-group">
									<label class="col-md-5 control-label"> Password <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-2">
										<input type="password" class="text-left form-control input-sm"
											name="pwdName" ng-model="resetPasswordData.pwdName"
											id="pwdName" validation="required"
													form-name="resetPasswordForm" friendly-name="Password">
									</div>
								</div>

							</fieldset>
						</div>   					
				</div>
				<br>   
				<div class="form-actions">
					<div class="row">
						

						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-click="save()">
								<i class="fa fa-save"></i> Submit
							</button>
							<button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i>
        Cancel
       </button>
						</div>



					</div>
				</div>
			</form>
		</div>
	</div>
</div>      





















<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/layout/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="resetPasswordForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> User Id <span
										style="color: red;"></span>
									</label>
									<div class="col-md-2">
										<input type="text" class="text-left form-control input-sm"
											name="userId" ng-model="resetPasswordData.userId">
									</div>
								</div>
								<br>
								<div class="form-group">
									<label class="col-md-5 control-label"> Password <span
										style="color: red;"></span>
									</label>
									<div class="col-md-2">
										<input type="text" class="text-left form-control input-sm"
											name="pwdName" ng-model="resetPasswordData.pwdName">
									</div>
								</div>

							</fieldset>
						</div>
					</div>


				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" type="button"
								ng-click="save(resetPasswordForm,resetPasswordData)">
								<i class="fa fa-save"></i> Submit
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md --> --%>



