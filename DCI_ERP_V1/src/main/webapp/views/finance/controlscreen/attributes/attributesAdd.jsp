<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
    <form name="jvAccountForm" class="form-horizontal" >
    <div class="row book-widget-row">
					<div class="col-sm-12">
					<fieldset>
						<div class="col-md-5">
								<div class="form-group">
									<label class="col-md-5 control-label">Attribute Name</label>
									<div class="col-md-7">
										
										 <input type="text" id="attributeName" name="attributeName"
											ng-model ="attribute.attributeName" class="form-control input-sm"> 
									</div>
								</div>
						</div>
						<div class="col-md-5">
								<div class="form-group">
									<label class="col-md-5 control-label">Attribute Value</label>
									<div class="col-md-7">
										
										 <input type="text" id="attributeValue" name="attributeValue"
											ng-model ="attribute.attributeValue" class="form-control input-sm"> 
									</div>
								</div>
						</div>
						<div class="col-md-3"></div>
					</fieldset>
					
					</div>
					</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!isEdit" ng-click="save()">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								ng-if="isEdit" ng-click="save()">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
