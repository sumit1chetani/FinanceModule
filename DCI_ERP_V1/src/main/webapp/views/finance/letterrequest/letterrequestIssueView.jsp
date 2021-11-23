<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div role="content">
			<div class="widget-body">
				<form class="form-horizontal" name="letterRequestForm">
					<div class="row">

						<div class="col-sm-12 col-md-10 col-lg-10">
							<fieldset>
								<div class="form-group">
									<label class="col-md-6 control-label"> Letter Request
										Type <span style="color: red;">*</span>
									</label>
									<div class="col-md-5" style="margin-top: 1%;">
									 <!-- <selectivity list="letterReqTypeList"
										
											ng-model="letterrequest.letterReqTypeId"
											 id="letterReqTypeId"
											name="letterReqTypeId" 
											validation="letterReqTypeId"
											friendly-name="  Letter Request Type "
											form-name="letterRequestForm"></selectivity> 
								 -->
									<!-- <selectivity list="letterReqTypeList"
										ng-model="letterrequest.letterReqTypeId" validation="required"
										friendly-name="Request Type"
										property="letterrequest.letterReqTypeId" id="letterReqTypeId"
										name="letterReqTypeId" form-name="letterRequestForm"></selectivity> -->
								<label>{{letterrequest.letterReqTypeName}}</label>
									
									</div></div>

								<div class="form-group">
									<label class="col-md-6 control-label"> Address the
										letter to </label>
									<div class="col-md-5" style="margin-top: 1%;">
									<!-- 	<textarea type="text" class="form-control input-sm"
											name="Address" form-name="trailerForm"
											class="custom-scroll width_250 resize-none" rows="2"
											ng-model="letterrequest.address">
															</textarea> -->
											<label>{{letterrequest.address}}</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label"> Purpose of
										Letter </label>
									<div class="col-md-5" style="margin-top: 1%;">
										<!-- 	<input type="text" class="form-control input-sm"
											data-ng-model="letterrequest.purpose" name="purpose"
											data-message-id="purpose"
											form-name="letterRequestForm" /> -->
										<!-- <textarea type="text" class="form-control input-sm"
											name="purpose" form-name="trailerForm"
											class="custom-scroll width_250 resize-none" rows="3"
											ng-model="letterrequest.purpose">
															</textarea> -->
													<label>{{letterrequest.purpose}}</label>		
									</div>
								</div>

<div class="form-group">
            <label class="col-md-6 control-label">
            Issue Date<span style="color: red;">*</span>
           
            </label>
            <div class="col-md-3" style="margin-top: 1%;">
									<!-- <ng-bs3-datepicker data-ng-model="letterrequest.issuedDate"
										id="issueDate" name="issuedDate" form-name="issuedDate" friendly-name="issuedDate"  validation="required"
										 /> -->
										 <label>{{letterrequest.issuedDate}}</label>		
								</div>
           </div>
           
          
						<div class="form-group">
							<!-- <label class="col-md-6 control-label"style="text-align:left">Issued</label> -->
							<label class="col-md-6 control-label">
            Issued<span style="color: red;">*</span>
           
            </label>
							<div class="col-md-3" style="margin-top: 1%;">
								<label class="i-checks m-b-none"> <input type="checkbox"
									ng-model="letterrequest.issuedflag" id="Issued" ><i></i></label>
							</div>
						</div>
					

							</fieldset>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" class="btn btn-success"
									type="button" 
									data-ng-if="!letterrequest.status"
									data-ng-click="IssueVal(letterRequestForm)"
									>
									<i class="fa fa-save"></i> Submit
								</button>
								<!-- <button class="btn btn-success" type="button"
									data-ng-click="update(letterRequestForm)" data-ng-if="isEdit">
									<i class="fa fa-save"></i> Update
								</button>
								<button class="btn btn-info" type="text" class="btn btn-success"
									ng-click="reset()">
									<i class="fa fa-undo"></i> Reset
								</button> -->
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














