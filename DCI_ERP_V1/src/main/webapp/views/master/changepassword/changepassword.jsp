
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="changePasswordForm" method="post" class="form-horizontal"
			novalidate>

			<div class="panel-body">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
						<div class="form-group">
								<label class="col-md-5 control-label"> Password <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-2">

									<input type="password" class="text-left form-control input-sm"
										ng-model="changePwd.pwd" name="password" id="password"
										 friendly-name="password" maxlength="40" validation="required"
										form-name="changePasswordForm" />
								</div>
							</div>
							<br>
							<div class="form-group">
								<label class="col-md-5 control-label">Confirm Password <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-2">

									<input type="password" class="text-left form-control input-sm"
										ng-model="changePwd.cnfrmPwd" name="cnfrmPwd" id="cnfrmPwd"
										 friendly-name="Confirm Password" maxlength="40" validation="required"
										form-name="changePasswordForm" />
								</div>
							</div>

						</fieldset>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" type="button" ng-click="save(changePasswordForm,changePwd)">
								<i class="fa fa-save"></i> Change Password
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>

						</div>
					</div>
					<div class="form-actions">
					<div class="row"></div></div>
					<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
				</div>
			</div>

		</form>
	</div>
</div>
 