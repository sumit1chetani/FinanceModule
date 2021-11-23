<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="permissionrequestapprovalForm" novalidate method="post">
								<div class="row">
									<div class="col-sm-10 col-md-5">
										<fieldset>
											
											<div class="form-group">
												<label class="col-md-6 control-label">Permission Date</label>							
	              									<div class="col-md-6">
			              								<div class='input-group date datetimepick' >
					                    					<input type="text" class="form-control"  placeholder="dd/mm/yyyy" id="purcdate" ng-model="PermissionApprovalData.permissiondate"
					                    					disabled>					                   
					                    					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                        					</div>
	                            					</div>
											</div>
											
										
											<div class="form-group">
												<label class="col-md-6 control-label"> Hours To</label>
													<div class="col-md-6">
														<div class='input-group date timepick'>
															<input type='text' class="form-control" placeholder="hh:mm" id="tug_birthing_id" ng-model="PermissionApprovalData.totime" disabled /> 
															<span class="input-group-addon"> 
															<span class="glyphicon glyphicon-time"></span>
															</span>
														</div>
													</div>
											</div>
												<div class="form-group">
											       <label class="col-md-6 control-label"> Remarks </label>
											         <div class="col-md-6">         												
	            											<textarea ng-model="PermissionApprovalData.remarks" name="Address" class="custom-scroll width_100" style="resize:none"
	            											id="remarks"></textarea>
          				        						</div>
                             				</div>
												</fieldset>
									</div>
								<div class="col-sm-10 col-md-5">
									<fieldset>
											<div class="form-group">
												<label class="col-md-6 control-label">Hours From</label>
													<div class="col-md-6">
														<div class='input-group date timepick'>
															<input type='text' class="form-control" placeholder="hh:mm" id="tug_birthing_id" ng-model="PermissionApprovalData.fromtime" disabled/> 
															<span class="input-group-addon"> 
															<span class="glyphicon glyphicon-time"></span>
															</span>
														</div>
													</div>
											</div>
									<div class="form-group">
											       <label class="col-md-6 control-label"> Reason </label>
											         <div class="col-md-6">         												
	            											<textarea ng-model="PermissionApprovalData.reason" name="Address" class="custom-scroll width_100" style="resize:none" disabled></textarea>
          				        						</div>
                             				</div>
                             				
                             				<div class="form-group">
												<label class="col-md-6 control-label"> Status 
												<spring:message code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-6">
														<select class="form-control input-sm"  name="Service" ng-model="PermissionApprovalData.status" id="status"
														validation="required" friendly-name="Status">
															<option value="">Select</option>
															<option value="Pending">Pending</option>
															<option value="Approved">Approved</option>
															<option value="Cancelled">Cancelled</option>
														</select>
													</div>
											</div>
										</fieldset>
									</div>
										
									</div>
				
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												 data-ng-click="update(PermissionApprovalData,permissionrequestapprovalForm)" >
												 Update
											</button>
											<button class="btn btn-info" type="button"
												 data-ng-click="reset();">
												 Reset
											</button>
											<button class="btn btn-danger" type="button"
												 data-ng-click="cancel();">
												  </i>Cancel
											</button>
										</div><br><br><br>
											<div class="col-sm-12">
									<fieldset>
										<div class="form-group">
											<label><span style="color: red;">*</span> Mail will be sent to the respective employee stating the status once updated.</label><br>
											<label><span style="color: red;">*</span> Request sent by will be escalated to executive Director if you are not responding in 24 hours.</label><br>
											<label><span style="color: red;">*</span> Your access rights will get Cancelled after escalation.</label>
										</div>
									</fieldset>
								</div>
									</div>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
	</div>
</div>

