<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<div class="dataTables_wrapper for-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
							<form class="form-horizontal" name="gratuityAddForm" role="form" >
								<div class="row">
									<fieldset>
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Company
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control">
										   				 <option value=" ">--Select--</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control">
										   				 <option value=" ">--Select--</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Gross Salary
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="Gross Salary"
				             							 ng-model="grossSalary" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Basic Pay
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="Basic Pay"
				             							 ng-model="basicPay" required>
												</div>
											</div>
											<div class="form-group">
													<label class="col-md-5 control-label">Gratuity Period From
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-5 padding-left-25 padding-right-25">
														<div class="form-group">
												            <div class='input-group date' id='datetimepicker8'>
												                <input type='text' class="form-control" />
												                <span class="input-group-addon">
												                    <span class="fa fa-calendar">
												                    </span>
												                </span>
												            </div>
       												 </div>		
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Total Years Of Service
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm" name="Total Years Of Service"
					             							 ng-model="totYearsOfService" required>
													</div>
												</div>
													<div class="form-group">
													<label class="col-md-5 control-label">Comment
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<textarea class="form-control input-sm resize-none"
												              name="Name"
												              data-ng-model="name"></textarea>
													</div>
												</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control">
										   				 <option value=" ">--Select--</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee No
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control">
										   				 <option value=" ">--Select--</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Current Salary
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="Current Salary"
				             							 ng-model="crntSalary" required>
												</div>
											</div>
											<!-- <div class="form-group">
												<label class="col-md-5 control-label">
														 <span style="color: red;"></span>
													</label>
													<div class="col-md-5">
													<input type="text" class="form-control input-sm" style="visibility: hidden;">
												</div>
											</div> -->
											<div class="form-group">
													<label class="col-md-5 control-label">Gratuity Period To
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-5 padding-left-25 padding-right-25">
														<div class="form-group">
												            <div class='input-group date' id='datetimepicker8'>
												                <input type='text' class="form-control" />
												                <span class="input-group-addon">
												                    <span class="fa fa-calendar">
												                    </span>
												                </span>
												            </div>
       												 </div>		
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Gratuity Amount
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm" name="Gratuity Amount"
					             							 ng-model="gratuityAmt" required>
													</div>
												</div>
											
										</div>
										</div>
								<!--  	<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-3 col-md-3 col-lg-3">
											<label class="col-md-8 control-label">Comment
														 <span style="color: red;">*</span>
													</label>
										</div>
										<div class="col-md-8">
											<textarea class="form-control input-sm resize-none"
												              name="Name"
												              data-ng-model="name"></textarea>
										</div>
									</div>-->
								</fieldset> 
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="!isEdit == true" ng-click="submit(gradeMasterForm)">
									            <i class="fa fa-save"></i>
									            Save
									           </button>
									          <button class="btn btn-success"  type="button" data-ng-click="update()"
																					data-ng-if="isEdit == true" >
									        <i class="fa fa-save"></i>
									       Update
									       </button>
											<button class="btn btn-info" type="button"
												class="btn btn-success" >
												<i class="fa fa-refresh"></i> Reset
											</button>
											<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
								            	<i class="fa fa-close"></i>
								           		Cancel
								           </button>
										</div>
									</div>
								</div>
							</form>
							</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>