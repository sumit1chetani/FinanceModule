<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body"> 
     			<div role="content" style="padding-left: 0px;">
      				<div class="widget-body">
       					<form class="form-horizontal" name="bankAddForm">
       						<div class="row">
		        				<div class="col-sm-12 col-md-12 col-lg-12">
		        					<div class="col-sm-4 col-md-6 col-lg-6">
		        						<div class="form-group">
							             	<label class="col-md-4 control-label"><spring:message code="label.entity.bankName"></spring:message></label>
							             	<div class="col-md-7">
							              		<input type="text" class="form-control input-sm" 
							               			name="<spring:message code="label.bankName"></spring:message>" id="bankName"
							               			data-ng-model="customerBankobj.bankName"
							               			data-validator="required" data-valid-method="submit">
							             	</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-4 control-label"> <spring:message code="label.entity.accountNo"></spring:message></label>
							             		<div class="col-md-7">
									              	<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.accountNo"></spring:message>" id="accountNo"
								               			data-ng-model="customerBankobj.accountNo" 
								               			data-validator="required" data-valid-method="submit">
							             		</div>
								        </div>
								        <div class="form-group">
								           <label class="col-md-4 control-label"><spring:message code="label.entity.address"></spring:message></label></label>
								           <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="customerBankobj.bankDetAddress" rows="2" cols="15" style="resize: none"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="billingCityList" property="customerBankobj.bankCityId" id="txtCitybillingId"></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="customerBankobj.desStateCode" />
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="customerBankobj.desState" />
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="customerBankobj.desZipcode" />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="customerBankobj.desCountryCode" />
										            <input type="text" class="form-control input-sm" placeholder="country" ng-model="customerBankobj.desCountry" />	
									            </div>
								            </div>								           
						            	</div>
		        					</div>
		        					<div class="col-sm-6 col-md-6 col-lg-6">
		        						<div class="form-group">
							             	<label class="col-md-4 control-label"><spring:message code="label.entity.accountType"></spring:message> </label>
							             		<div class="col-md-7">
							                        <select class="form-control" data-ng-model="customerBankobj.accountTypeId" 
							                        data-ng-options="ci.accountTypeId as ci.accountType for ci in accountTypeList">
										            <option value="" selected="selected">Select</option>
										      </select> 
							             	</div>
								       </div>
								       <div class="form-group">
							             	<label class="col-md-4 control-label"> <spring:message code="label.entity.ifscCode"></spring:message></label>
							             		<div class="col-md-7">
									              	<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.ifscCode"></spring:message>" id="ifscCode"
								               			data-ng-model="customerBankobj.ifscCode" 
								               			data-validator="required" data-valid-method="submit">
							             		</div>
								        </div>
		        					</div>
		        				</div>
		        			</div>
       					</form>
      				</div>
     			</div>
     			<!-- end widget content -->
			     <div class="form-actions">
			      <div class="row">
			       <div class="col-md-12">
			        <button class="btn btn-success" type="submit"
			         data-ng-click="addRowBank(bankAddForm)">			        
			         <i class="fa fa-save"></i>
			         Add to List
			        </button>					
			        <button class="btn btn-danger" type="reset"
			         class="btn btn-success" ng-click="cancelBank()">
			         <i class="fa fa-close"></i>
			         <spring:message code="label.cancel"></spring:message>	
			        </button>
			       </div>
			      </div>
			     </div>
     <!-- end widget div -->
    		</div>
    <!-- end widget -->
   	</article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>