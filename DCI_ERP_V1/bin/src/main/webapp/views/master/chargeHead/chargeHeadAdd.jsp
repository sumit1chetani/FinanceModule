<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="chargeHeadForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Head Code<span
									style="color: red;">*</span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										id="code" name="code" maxlength="6"
										ng-model="chargeHead.code" validation="required"
										friendly-name=" chargeHead Code"
										form-name="chargeHeadForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Charge Head Name<span
									style="color: red;">*</span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										id="name" name="name" maxlength="250"
										ng-model="chargeHead.name" validation="required"
										friendly-name="name" form-name="chargeHeadForm" />
								</div>
							</div>
							<div class="form-group">
								<!-- <label class="col-md-4 control-label">City<span
									style="color: red;">*</span></label> <label
									class="col-md- control-label text-left"></label>
								<div class="col-md-5 inputGroupContainer"> -->
								<label class="col-md-4 control-label">Charge Head Group <span
									style="color: red;">*</span></label>
									<div class="col-md-5">
									<selectivity list="groupList" id="group"
										name="group"
										property="chargeHead.group"
										ng-model="chargeHead.group" validation="required"
										friendly-name="group"
										form-name="chargeHeadForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Purchase Ledger Name <span
									style="color: red;">*</span></label>
								<div class="col-md-5">

										<selectivity list="accountHeadList" id="pName"
										name="pName"
										property="chargeHead.pName"
										ng-model="chargeHead.pName" validation="required"
										friendly-name="pName"
										form-name="chargeHeadForm"></selectivity>
									<!-- <input type="text" class="form-control input-sm"
										id="pName" name="pName" maxlength="255"
										ng-model="chargeHead.pName" validation="required"
										friendly-name="pName" form-name="chargeHeadForm" /> -->
								</div>
							</div>
							
							<div class="form-group">
							
								<label class="col-md-4 control-label">Sales Ledger Name<span
									style="color: red;">*</span></label>
									<div class="col-md-5">
									<selectivity list="accountHeadListRevenue" id="sName"
										name="sName"
										property="chargeHead.sName"
										ng-model="chargeHead.sName" validation="required"
										friendly-name="sName"
										form-name="chargeHeadForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">SAC No <span
									style="color: red;">*</span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										id="sacNo" name="sacNo" maxlength="100"
											property="chargeHead.sacNo"
										ng-model="chargeHead.sacNo"  validation="required"
												friendly-name="SAC No"
										 form-name="chargeHeadForm" />
								</div>
							</div>
							
							</fieldset>
								</div>
								<div class="col-sm-12 col-md-12 col-lg-6">
										<fieldset>
								
								<div class="form-group">
								<label class="col-md-4 control-label">CGST %</label>
								<div class="col-md-5">

									<select class="form-control input-sm" name="type"
											ng-model="chargeHead.cgst">
											<option value="">--Select--</option>
											<option value="2.5">2.5</option>
											
											<option value="6">6</option>
											
											<option value="9">9</option>
											
										</select>
								</div>
							</div>  
							<div class="form-group">
								<label class="col-md-4 control-label">SGST %</label>
								<div class="col-md-5">

									<select class="form-control input-sm" name="type"
											ng-model="chargeHead.sgst">
											<option value="">--Select--</option>
											<option value="2.5">2.5</option>
											
											<option value="6">6</option>
											
											<option value="9">9</option>
											
										</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">IGST %</label>
								<div class="col-md-5">

									<select class="form-control input-sm" name="type"
											ng-model="chargeHead.igst">
											<option value="">--Select--</option>
											<option value="5">5</option>
											
											<option value="12">12</option>
											
											<option value="18">18</option>
											
										</select>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">GST %<span
									style="color: red;"></span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm text-right"
										id="gst" name="gst" maxlength="6"
										ng-model="chargeHead.gst" 
										form-name="chargeHeadForm" />
								</div>
							</div> -->
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4 ">
									Description </label>
								<div class="col-md-5">
									<textarea ng-model="chargeHead.description"
										name="description" maxlength="255"
										class="custom-scroll width_100 resize-none" rows="3">
		          						</textarea>
								</div>
							</div>
                            
                            
                            
							<div class="form-group">
								<label class="col-md-4 control-label"> Active </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="isActive" class="checkbox style-0" name="isActive" validation="required"
											ng-model="chargeHead.isActive"/> <i></i>
										</label>
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
						<div class="col-md-11">
							<button class="btn btn-success" ng-if="edit" type="button"
								ng-click="validate(chargeHeadForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success"
								ng-click="validate(chargeHeadForm)"
								ng-if="!edit" type="button">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" ng-if="edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-info" ng-if="!edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>


							<button class="btn btn-danger" type="button"
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
