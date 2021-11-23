<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div role="content">
		   <div class="widget-body">
			 <form class="form-horizontal" name="permissionrequestForm" novalidate method="post">
				<div class="row">
				  <div class="col-sm-12 col-md-10 col-lg-10">
					<fieldset>
					
					<div class="form-group">
						<label class="col-md-6 control-label"> Employee No </label>
									<div class="col-md-3">
								 <input type="text"  ng-model="permissionRequestData.userId" name="userId" class="custom-scroll width_100"  style="resize: none" 
								validation="required" friendly-name="Employee No." data-message-id="userId"  disabled> 
								
							</div>
					</div>
											
					<div class="form-group">
						<label class="col-md-6 control-label"> Employee Name</label>
							<div class="col-md-3">
								 <input type="text" ng-model="permissionRequestData.userName" name="userName" class="custom-scroll width_100"  style="resize: none" 
								validation="required" friendly-name="Employee Name" data-message-id="userName"  disabled >
								
							</div>
					 </div>
					  					                  
					  <div class="form-group">
						<label class="col-md-6 control-label">
							Permission Date<span style="color:red;">*</span>
						</label>
						<div class="col-md-3">
									<ng-bs3-datepicker data-ng-model="permissionRequestData.permissiondate"
										id="permissiondate" name="Permission Date" form-name="Permission Date" friendly-name="permissiondate"
										validation="required" />
								</div>
						
						
						
					  </div>  
			<!-- 		<div class="form-group">
						<label class="col-md-6 control-label"> Shift Name</label>
							<div class="col-md-3">
								<input type="text" ng-model="permissionRequestData.shiftName" name="shiftName" class="custom-scroll width_100"  style="resize: none" 
								validation="required" friendly-name="shift Name" data-message-id="shiftName"  disabled >
								
							</div>
					 </div>		 -->		        
					  <div class="form-group">
					  <label class="col-md-6 control-label">
						Hours From<span style="color:red;">*</span>
					  </label>
					  
									<div class="col-md-3 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="hoursform" name="hoursform" 
           ng-model="permissionRequestData.hoursfrom" validation="required" friendly-name="hoursform"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
					  <div class="form-group">
						<label class="col-md-6 control-label">Hours To
							<span style="color:red;">*</span>
						</label>
						<div class="col-md-3 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="hoursto" name="hoursto" 
           ng-model="permissionRequestData.hoursto" validation="required" friendly-name="hoursto"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
						
						<!-- <div class="col-md-3">
							<div class="dropdown">
								<a class="dropdown-toggle" id="hoursto" role="button" data-toggle="dropdown" data-target="#" href="#">
									<div class="input-group">
									  <input type="text" class="form-control" placeholder="hh:mm"  
									  name="Hours To" data-message-id="Hours To" data-ng-model="permissionRequestData.hoursto"
									  validation="required" friendly-name="Hours To">
									  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
									</div>
								</a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
									<datetimepicker data-ng-model="permissionRequestData.hoursto" 
									data-on-set-time="permissionRequestData.hoursto = onTimeSet(newDate)" 
									data-datetimepicker-config="{ dropdownSelector: '#hoursto',startView:'hour', minView:'minute'}" />
								</ul>
							</div>
						</div> -->
					 </div>		
												
					  <div class="form-group">
						<label class="col-md-6 control-label"> Reason</label>
							<div class="col-md-3">
								<textarea ng-model="permissionRequestData.reason" name="Reason" class="custom-scroll width_100" style="resize: none" 
								data-validator="required" data-valid-method="submit" data-message-id="Reason"></textarea>
							</div>
					 </div>
											
					</fieldset>
				  </div>
			    </div>			    
				<div class="form-actions">
					<div class="row">
						<div class="col-sm-12">
						<!-- 	<button class="btn btn-success" type="submit" data-ng-click="save(permissionRequestData,permissionrequestForm)" ng-if="!permissionRequestData.edit" >
								<i class="fa fa-save"></i>Save
							</button> -->
							<button class="btn btn-success" type="button" data-ng-click="update(permissionRequestData,permissionrequestForm)" >
								<i class="fa fa-save"></i>update
							</button>
							<button class="btn btn-info"    type="button" data-ng-click="reset()">
								<i class="fa fa-undo"></i>Reset
							</button>
							<button class="btn btn-danger"  type="button" data-ng-click="cancel();">
								<i class="fa fa-close"></i>Cancel
							</button>
						</div><br><br>
									
						<div class="col-sm-12" style="padding-left:40px;">
							<fieldset>
								<div class="form-group">
									<!-- <label><span style="color: red;">*</span> Request Mail will be sent to the Reporting manager once saved.</label><br> -->
									<label><span style="color: red;">*</span> Reporting Manager has to approve your request.</label><br>
									<!-- <label><span style="color: red;">*</span> Your request will be escalated to executive Director if its not replied in 24 hours.</label> -->
								</div>
							</fieldset>
					   </div>
				    </div>
				</div>
			  </form>
			</div><!-- end widget content -->
		   </div>
						</form>
					</div>
	</div>
</div>

