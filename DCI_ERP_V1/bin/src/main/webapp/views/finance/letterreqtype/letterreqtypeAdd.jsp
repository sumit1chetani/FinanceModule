<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div role="content">
			<div class="widget-body">
				<form class="form-horizontal" name="letterReqTypeAddForm">
					<div class="row">
						<br>
						<div class="col-sm-12 col-md-10 col-lg-10">
							<fieldset>							
		
								<div class="form-group">
									<label class="col-md-6 control-label"> Letter Type <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-6">
										<input type="text" class="form-control input-sm"
											data-ng-model="letterreqType.letterReqTypeName"
											name="lettertype"
											data-message-id="lettertype"
											validation="required" friendly-name=" Letter Type"
											form-name="letterReqTypeAddForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label"> Description </label>
									<div class="col-md-6">
										<input type="text" class="form-control input-sm"
											data-ng-model="letterreqType.descripiton" name="description"
											data-message-id="description"
											form-name="letterReqTypeAddForm" />
									</div>
								</div>

								

							</fieldset>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" class="btn btn-success"
									type="button" data-ng-click="save(letterReqTypeAddForm)"
									data-ng-if="!isEdit">
									<i class="fa fa-save"></i> Save
								</button>
								<button class="btn btn-success" type="button"
									data-ng-click="update(letterReqTypeAddForm)"
									data-ng-if="isEdit">
									<i class="fa fa-save"></i> Update
								</button>
								<button class="btn btn-info" type="text" class="btn btn-success"
									ng-click="reset()">
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
			<!-- end widget content -->
		</div>
	</div>
</div>














