<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="surchargeMasterForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						
						<div class="form-group">
								<label class="col-md-4 control-label"> Release Ref No :</label>
								<div class="col-md-5">
 
										<label class="col-md-1 control-label">{{onhireReleaseAdd.releaseRefno}}</label>				
										
										
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Agreement Ref No
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.agreementRefno}}</label>
									<!--  <input type="text" class="form-control input-sm" name="surchargeName"  ng-model="onhireReleaseAdd.surchargeName" validation="required" friendly-name="Surcharge Name"> -->

								<!-- 	<input type="text" class="form-control input-sm"
										id="txtSurchargeName" name="surchargeName"
										ng-model="onhireReleaseAdd.surchargeName" validation="required"
										friendly-name="Surcharge Name" form-name="surchargeMasterForm"
										typeahead="ac.surchargeName as ac.surchargeName for ac in surchargeList| filter:$viewValue |limitTo:10"
										typeahead-min-length='1'
										typeahead-input-formatter="fetchSelectedSurchargeName($model,onhireReleaseAdd)"
										disabled="true" /> -->
								</div>
							</div>

<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Reference No</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.referenceNo}}</label>
									<!-- <textarea ng-model="onhireReleaseAdd.description"
										class="form-control input-sm resize-none" rows="2"
										disabled="true"></textarea> -->
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Lease  Party
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.agent}}</label>
						
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Created By
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.created_by}}</label>
						
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Created Date
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.created_date}}</label>
						
								</div>
							</div>
							
</fieldset>

					</div>


<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Lease Type
								</label>
								<div class="col-md-5">
									<label
									class="col-md-1 control-label">{{onhireReleaseAdd.leaseType}}</label>
							
								</div>


							</div>


							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Agreement Party</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.agreementParty}}</label>
									<!-- <textarea ng-model="onhireReleaseAdd.description"
										class="form-control input-sm resize-none" rows="2"
										disabled="true"></textarea> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Free Days</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.freeDays}}</label>
									
							
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Port</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.port}}</label>
							
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Modified By
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.modified_by}}</label>
						
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Modified Date
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{onhireReleaseAdd.modified_date}}</label>
						
								</div>
							</div>
							


							<!-- <div class="form-group">
        <label class="col-md-4 control-label">Charge Declaration</label>
       
         <div class="col-md-5">
         <div class="radio radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" checked="checked" name="surDeclrn" ng_model="onhireReleaseAdd.surDeclrn" value="Y" checked="checked"  ng-disabled="true">
           <i></i>
           Yes
          </label>
         </div>
         <div class="radio  radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0"  ng_model="onhireReleaseAdd.surDeclrn" value="N" checked="checked" name="surDeclrn"  ng-disabled="true">
           <i></i>
           No
          </label>
         </div>
        </div>
        
       </div> -->

		 

                            
						</fieldset>
					</div>
				</div>
				<br>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" ng-click="cancel()" type="button">Cancel</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

