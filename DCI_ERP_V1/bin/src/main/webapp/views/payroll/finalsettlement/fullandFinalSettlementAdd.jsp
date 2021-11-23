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
							<form class="form-horizontal" name="fullfinalSettleAddForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group padding-top-10">
													<label class="col-md-5 control-label">Settlement Date
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-5 padding-left-25">
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
										</div>
									</div>
									</div>
									<div class="row">
									<div class="col-sm-12 col-md-11 col-lg-11 margin-left-4">
									
									<fieldset class="b-a">
									<legend class="width_12 margin-left-7 b-none">Employee Details</legend>
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="form-group">
												<label class="col-md-5 control-label"> Hospital
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control">
										   				 <option value=" ">--Select--</option>
													</select>
												</div>
											</div>
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
												<label class="col-md-5 control-label">Employee Name
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control">
										   				 <option value=" ">--Select--</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Details Of Last Salary Drawn
												</label>
												<div class="col-md-5">
						           				</div>
											</div>
									
											<div class="form-group" >
													<label class="col-md-5 control-label">Last Salary Drawn On
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
												<label class="col-md-5 control-label">Days Worked
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Days Worked"
					             							ng-model="daysWork" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Total Earnings
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Total Earnings"
					             							 ng-model="totEarning" required>
												</div>
											</div>
										</div>
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="form-group">
												<label class="col-md-5 control-label">Last Salary Structure
												</label>
												<div class="col-md-5">
						           				</div>
										</div>
										<div class="form-group">
												<label class="col-md-5 control-label">Basics
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Basics"
					             							 ng-model="basics" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">LTC
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="LTC"
					             							 ng-model="ltc" required>
												</div>
											</div>
											<div class="form-group ">
												<label class="col-md-5 control-label">HRA
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="HRA"
					             							 ng-model="hra" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Medical
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Medical"
					             							 ng-model="medical" required>
												</div>
											</div>
											<div class="form-group">
													<label class="col-md-6 control-label">Gratuity / Other Funda Details
													</label>
												</div>
												<div class="form-group">
												<label class="col-md-5 control-label">Gratuity Avail Period
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Gratuity Avail Period"
					             							ng-model="gratuityAvailPeriod" required>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Basic
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Basic"
					             							 ng-model="basic" required>
												</div>
											</div>
											<div class="form-group" >
													<label class="col-md-5 control-label">Cal. Stated On
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
									</fieldset>
									</div>
									</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-8">
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
								           <div class="col-md-4">
								           		<div class="form-group">
												<label class="col-md-6 control-label">Net Amount To Be Paid
												</label>
												<div class="col-md-4">
						           					<input type="text" class="form-control input-sm" name="Net Amount To Be Paid"
					             							 ng-model="netAmtPaid" required>
												</div>
											</div>
								           </div>
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