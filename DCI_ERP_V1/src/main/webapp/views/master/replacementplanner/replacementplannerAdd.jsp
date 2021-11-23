<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
	<div class="wrapper-md">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
		
		<form name="addForm" class="form-horizontal" novalidate>
		<!-- 	<form  name="addForm" class="form-horizontal" 
				method="POST"> -->
				<script type="text/javascript">
			/*code: 48-57 Numbers
			  8  - Backspace,
			  35 - home key, 36 - End key
			  37-40: Arrow keys, 46 - Delete key*/
			function restrictAlphabets(e){
				var x=e.which||e.keycode;
				if((x>=48 && x<=57) || x==8 ||
					(x>=35 && x<=40)|| x==46)
					return true;
				else
					return false;
			}
		</script>
				<div class="row">
					<div class="col-md-12">
					<div class="col-md-6">
				
							<fieldset>
							
							<div class="form-group">
							<label class="col-md-4 control-label"> Item <span
								style="color: red;" >*</span>
							</label>
							<div class="col-md-6">  
								<selectivity list="itemList" ng-model="replacement.itemName"
									property="replacement.itemName" validation="required" friendly-name="Item"
									id="itemName" object="itemName" name="itemName" form-name="addForm"
									
									disabled="disabled"></selectivity>
							</div>
						</div>
						
					
									
									<div class="form-group" ng-if="!isCost" >
							<label class="col-md-4 control-label"> Alert Sent to  <span
								style="color: red;"></span>
							</label>
							<div class="col-md-6" >  
								<selectivity list="deptList" ng-model="replacement.dept"
									property="replacement.dept" 
									id="dept" object="dept" name="dept"
									friendly-name="Alert sent to"
									disabled="disabled"></selectivity>
							</div>
						</div>
						
						<div class="form-group"    ng-if="isCost">
							<label class="col-md-4 control-label"> Alert Sent to  <span
								style="color: red;"></span>
							</label>
							<div class="col-md-6">  
								<selectivity list="deptList" ng-model="replacement.dept"
									property="replacement.dept" form-name="addForm"
									id="dept" object="dept" name="dept"
									validation="required" friendly-name="Alert sent to"
									disabled="disabled"></selectivity>
							</div>
						</div>
						
						
						
						
						
						
							
						
						<div class="form-group">
									<label class="col-md-4 control-label"> Replacement Value (USD)</label>
									<div class="col-md-6 inputGroupContainer">


										<input type="text" class="form-control input-sm" id="replacementValue"
											friendly-name="replacementValue" style="text-align:right;" placeholder="0.00"
											maxlength="50" name="replacementValue"  onkeypress='return restrictAlphabets(event)' ng-model="replacement.replacementValue">

									</div>
								</div>
							
							</fieldset>
						</div>
						
					<div class="col-md-6">
							<fieldset>
							
							
							<!-- 	
						<div class="form-group">
										<label class="col-md-6 control-label "> Service Date <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-6 ">
											<div class="input-group input-append date">

												<ng-bs3-datepicker data-ng-model="workShop.serviceDate"
													id="serviceDate" validation="required" name="serviceDate"
													friendly-name="serviceDate" placeholder='dd/mm/yyyy' />

												<span class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>

									</div> -->
									
									
						<!-- 			
														<div class="form-group">
										<label class="col-md-4 control-label">EIR Date<span
											style="color: red;">*</span></label>
										<div class="col-md-8 inputGroupContainer">


											<div class="input-group input-append date">
												<input type="text" class="form-control input-sm"
													validation="required" id="eirDate" name="eirDate"
													ng-model="reportEir.eirDate" friendly-name="EIR Date" /> <span
													class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
											</div>

										</div>
									</div> -->
								
												<div class="form-group">
										<label class="col-md-4 control-label "> Warranty till
										</label>
										<div class="col-md-6 ">
											<div class="input-group input-append date">
											<input type="text" class="form-control input-sm"
													validation="required" id="warrenty" name="warrenty"
													ng-model="replacement.warrenty" friendly-name="warrenty" /> <span
													class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
													
												<!-- <ng-bs3-datepicker data-ng-model="replacement.warrenty"
													id="warrenty"  name="warrenty"
													friendly-name="warrenty" placeholder='dd/mm/yyyy' />

												<span class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span> -->
											</div>
										</div>

									</div>
						
								 <div class="form-group">
										<label class="col-md-4 control-label "> Approximate LifeTime
										</label>
										<div class="col-md-6 ">
											<div class="input-group input-append date">
											
											<input type="text" class="form-control input-sm"
													validation="required" id="lifetime" name="lifetime"
													ng-model="replacement.lifetime" friendly-name="lifetime" /> <span
													class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>

												<!-- <ng-bs3-datepicker data-ng-model="replacement.lifetime"
													id="lifetime"  name="lifetime"
													friendly-name="lifetime" placeholder='dd/mm/yyyy' />

												<span class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span> -->
										</div>
										</div>

									</div>
							
								
											 <div class="form-group">
										<label class="col-md-4 control-label "> Replacement Reminder
										</label>
										<div class="col-md-6 ">
											<div class="input-group input-append date">
											
											<input type="text" class="form-control input-sm"
													validation="required" id="remainder" name="remainder"
													ng-model="replacement.remainder" friendly-name="lifetime" /> <span
													class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
											
												<!-- <ng-bs3-datepicker data-ng-model="replacement.remainder"
													id="remainder"  name="remainder"
													friendly-name="remainder" placeholder='dd/mm/yyyy' />

												<span class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span> -->
										</div>
										</div>

									</div>
								
								
								
								
									



							</fieldset>
						</div>
					</div>


				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="save(addForm)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit"
								ng-click="update(addForm)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()"
								ng-if="!isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-info" ng-click="reset1()" ng-if="isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
</div>

