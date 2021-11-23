<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>			
		</div>
		<div class="panel-body">
			<form  class="form-horizontal" name="chargetypeForm"  novalidate method="POST">
				<script language="javascript" type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    }
}
</script>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
					
						
							<fieldset>					
								
								<div class="form-group">
									<label class="col-md-4 control-label">Charge Type Code</label> 
									<div class="col-md-5">			
											
											<input type="text" class="form-control input-sm" id="chargeTypecode" name="chargeTypecode"  
											ng-model="chargemodel.chargeTypecode"  	onKeyDown="limitText(this,20);" onKeyUp="limitText(this,20);"
												validation="required" friendly-name="Charge Type Code" form-name="chargeTypeForm"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Charge  Type Name</label> 
									<div class="col-md-5">			
											
											<input type="text" class="form-control input-sm" id="chargeTypename" name="chargeTypename"  
											ng-model="chargemodel.chargeTypename"  	onKeyDown="limitText(this,100);" onKeyUp="limitText(this,100);"
												validation="required" friendly-name="Account Head Name" form-name="chargeTypeForm"/>
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										 Description </label>
									<div class="col-md-5">
										<textarea ng-model="chargemodel.chargeTypedescription"
											name="chargeTypedescription"
											class="custom-scroll width_100 resize-none" rows="3">
		          						</textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Active </label>
									<div class="col-md-3">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												id="isActive" class="checkbox style-0" name="isActive"
												ng-model="chargemodel.isActive" /> <i></i>
											</label>
										</div>
									</div>
								</div>								
							</fieldset>
						
						
						
					</div>		
					
				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
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


<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="chargetypeForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">


						<fieldset>							
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Type Code</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargemodel.chargeTypecode}}</label>								
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Type Name</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargemodel.chargeTypename}}</label>								
							</div>						
							
							<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										 Description </label>
									<div class="col-md-5">
										<textarea ng-model="chargemodel.chargeTypedescription"
											name="chargeTypedescription"
											class="custom-scroll width_100 resize-none" rows="3" disabled="true">
		            </textarea>
									</div>
								</div>							
							<div class="form-group">
								<label class="col-md-4 control-label">Active</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargemodel.isActive}}</label>								
							</div>							
						</fieldset>



					</div>

				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">


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
</div> --%>

