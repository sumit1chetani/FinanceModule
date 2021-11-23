<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="gradeMasterForm" novalidate
				method="post">
			<!-- 	<script language="javascript" type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    }
}
</script> -->
				<div class="row">
					<div class="col-sm-12 col-md-10 col-lg-10">
						<fieldset>

							<div class="form-group">
								<label class="col-md-6 control-label"> Grade <span
									style="color: red;">*</span>

								</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										name="Grade Name" data-ng-model="gradeMaster.gradeName"
										data-message-id="gradeName" form-name="gradeMasterForm" maxlength="20"
											
										validation="required" friendly-name="Grade Name">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Description
								</label>
								<div class="col-md-3">
									<textarea class="form-control input-sm" rows="3"
										name="description" data-ng-model="gradeMaster.description"
										style="resize: none;"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Is Active
								</label>
								<div class="col-md-3">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0" ng-model="gradeMaster.status"
											name="status"> <span></span>
										</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" class="btn btn-success"
								type="button" data-ng-model="add" data-ng-if="!isEdit == true"
								ng-click="submit(gradeMaster,gradeMasterForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								data-ng-click="update(gradeMaster,gradeMasterForm)"
								data-ng-if="isEdit == true">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" class="btn btn-success"
								ng-click="reset(gradeMasterForm)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</div>
