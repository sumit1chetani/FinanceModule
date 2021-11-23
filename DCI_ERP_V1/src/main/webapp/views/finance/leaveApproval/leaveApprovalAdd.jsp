<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="widget-body">
					<form class="form-horizontal" name="leaveApproveAddForm"
						role="form" ng-submit="#" novalidate>
						<div class="container">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group">
										<label class="col-md-4 control-label">Employee
											Name</label>
										<div class="col-md-5 inputGroupContainer"
											style="border: 0px solid red">
											<input type="text" class="form-control input-sm" name="firm"
												data-ng-model="leaveAppCancel.firstName"
												data-message-id="employee" readonly>

										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">Applied On</label>
										<div class="col-md-5 inputGroupContainer"
											style="border: 0px solid red">
											<input type="text" class="form-control input-sm"
												name="appliedOn" data-ng-model="leaveAppCancel.appliedOn"
												data-message-id="employee" readonly>

										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">From </label>
										<div class="col-md-5">
											<select class="form-control" disabled
												ng-model="leaveAppCancel.halfFrom">
												<option value="">--Select--</option>
												<option value="1">First Half</option>
												<option value="2">Second Half</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">To </label>
										<div class="col-md-5">
											<select class="form-control" disabled
												ng-model="leaveAppCancel.halfTo">
												<option value="">--Select--</option>
												<option value="1">First Half</option>
												<option value="2">Second Half</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">Status 
										</label>
										<div class="col-md-5">
											<select class="form-control" name="status"
												ng-model="leaveAppCancel.status" validation="required"
												friendly-name="Status">
												<option value="">--Select--</option>
												<option value="0">Pending</option>
												<option value="1">Approved</option>
												<option value="2">Cancelled</option>
											</select>
										</div>
									</div>

								</div>

								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group">
										<label class="col-md-4 control-label">Leave Type</label>
										<div class="col-md-5 inputGroupContainer"
											style="border: 0px solid red">
											<input type="text" class="form-control input-sm" name="firm"
												data-ng-model="leaveAppCancel.leaveType"
												data-message-id="employee" readonly>

										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">Reason For
											Leave</label>
										<div class="col-md-5 inputGroupContainer"
											style="border: 0px solid red">
											<input type="text" class="form-control input-sm" name="firm"
												data-ng-model="leaveAppCancel.reason" readonly
												data-message-id="employee">

										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Date From </label>
										<div class="col-md-5">
											<div class="dropdown">
												<a class="dropdown-toggle" id="permissiondate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="dateFrom"
															data-validator="required" data-valid-method="submit"
															data-message-id="dateFrom" readonly
															data-ng-model="leaveAppCancel.dateFrom"><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>

											</div>

											<!--   <input type="text" class="form-control" ng-model="leaveRequestObj.toDate" placeholder="dd/mm/yyyy" id="date"> -->
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">To Date</label>
										<div class="col-md-5">
											<div class="dropdown">
												<a class="dropdown-toggle" id="permissiondate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="dateTo"
															data-validator="required" data-valid-method="submit"
															data-message-id="dateTo"
															data-ng-model="leaveAppCancel.dateTo" readonly><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>

											</div>


										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Description</label>
										<div class="col-md-5">
											<textarea class="form-control input-sm" name="Description"
												data-ng-model="leaveAppCancel.descrip"
												data-message-id="descrip" data-validator="required"
												data-valid-method="submit" rows="2" style="resize: none;"></textarea>

										</div>
									</div>


								</div>





							</div>


						</div>
						<!-- end container -->

						<div class="form-actions">
							<div class="row">

								<div class="col-md-12">


									<button class="btn btn-success" type="button"
										data-ng-click="update(leaveAppCancel,leaveApproveAddForm);">
										<i class="fa fa-save"></i>
										Update
									</button>
									<button class="btn btn-info ng-scope" type="submit"
										class="btn btn-success" ng-click="reset(employeeLeaveDecObj)">
										<i class="fa fa-undo"></i>
										Reset
									</button>
									<button class="btn btn-danger" type="button"
										class="btn btn-success" ng-click="cancel()">
										<i class="fa fa-close"></i>
										Cancel
									</button>

								</div>


								<!--     				 </div>  -->
							</div>
						</div>



					</form>

				</div>
						</form>
					</div>
	</div>
</div>

