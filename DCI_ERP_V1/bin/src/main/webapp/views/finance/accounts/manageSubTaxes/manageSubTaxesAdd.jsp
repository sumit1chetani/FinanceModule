<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
	<div role="content">
     	<div class="widget-body">
       		<form class="form-horizontal" name="manageSubTaxForm" novalidate method="post">
       			<fieldset>
       				<div class="row">
       					<div class="col-sm-12 col-md-12 col-lg-12">
       						<div class="col-md-6">
       							 <div class="form-group">
						        	<label class="col-md-5 control-label"> Sub Tax Code <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						            	<input type="text" class="form-control input-sm" ng-pattern="/^[a-zA-Z0-9]*$/" 
						              ng-model="manageSubTax.subTaxCode" name="subTaxCode" data-message-id="subTaxCode" 
						              data-valid-method="save" validation="required" friendly-name="SubTax Code" maxlength="20">
						            </div>
						        </div>
						        <div class="form-group">
						        	<label class="col-md-5 control-label"> Sub Tax Name <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						            	<input type="text" class="form-control input-sm"
						              ng-model="manageSubTax.subTaxName" name="subTaxName" data-message-id="subTaxName"  validation="required" friendly-name="SubTax Name" data-valid-method="save" maxlength="40">
						            </div>
						        </div>
						        <div class="form-group">
						        	<label class="col-md-5 control-label"> Sub Tax Method <span style="color: red;">*</span> </label>
						            <div class="col-md-3">
						             	 <select class="form-control input-sm" name="subTaxMethodId" ng-model="manageSubTax.subTaxMethodId " 
						             	 	ng-options=" value.subTaxMethodId as value.subTaxMethod for value in ValueList" 
						             	 	ng-change="onchange1(manageSubTax.subTaxMethodId)"
						        			id="manageSubTax" form-name = "manageSubTaxForm"
						        			validation="required" friendly-name="Sub Tax Method">
							          	</select>
						             </div>
									<div class="col-md-3">
						             <input type="text" class="form-control input-sm text-right"
						              ng-model="manageSubTax.subTaxMethodAmount" name="subTaxMthdAmount" id="subTaxAmount" 
						              data-valid-method="save" ng-blur="changeAmountDiscount(manageSubTax.subTaxMethodAmount)"
						              validation="numeric|required" ng-pattern-restrict="^[0-9.]*$"
									  friendly-name="Tax Amount" maxlength="10" placeholder="100"
						              data-ng-keyup="onChangeNumber(manageSubTax.subTaxMethodAmount)">
									</div>
									<div class="form-group" id="percentage">
						        	<label class="control-label"> % </label>
						        </div>
						      </div>

					      	</div>
						   <div class="col-md-6">
						      	<div class="form-group">
						        	<label class="col-md-4 control-label"> Sub Tax Type <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						        		 <select class="form-control input-sm" name="subTaxTypeId" ng-model="manageSubTax.subTaxTypeId " ng-options=" type.subTaxTypeId as type.subTaxType for type in ValueList1" ng-change="focusTypes(manageSubTax.subTaxTypeId)"
						        		id="manageSubTax">
							          </select>
						        	</div>
						        </div>
						         <div class="form-group" id="salesType">
									<label class="col-md-4 control-label" >Sales SubTax Account <span style="color: red;">*</span></label>
									<div class="col-md-6" data-ng-if="!haveCode">
										<selectivity list="taxAccountList" property="manageSubTax.subTaxAccount" id="salesTypeId" 
											ng-model="manageSubTax.subTaxAccount" name="saleSub" form-name = "manageSubTaxForm"
						        				validation="required" friendly-name="Sub Tax Account"></selectivity>
									</div>
									<div class="col-md-6" data-ng-if="haveCode">
										 <input type="text" class="form-control input-sm" ng-model="manageSubTax.acctName" readonly>
									</div>
								</div>
						      	<div class="form-group" id="purchaseType" >
						        	<label class="col-md-4 control-label"> Purchase SubTax Account <span style="color: red;">*</span></label>
						            <div class="col-md-6" data-ng-if="!haveCode">
						            	<selectivity list="taxAccountList" property="manageSubTax.subTaxAccount" id="purTypeId"></selectivity>
					             	</div>
					             	<div class="col-md-6" data-ng-if="haveCode">
										 <input type="text" class="form-control input-sm" ng-model="manageSubTax.acctName" readonly>
									</div>
						        </div>
						        <div class="form-group"  id="serviceType">
						        	<label class="col-md-4 control-label"> Service SubTax Account <span style="color: red;">*</span></label>
						            <div class="col-md-6" data-ng-if="!haveCode">
						            	<selectivity list="taxAccountList" property="manageSubTax.subTaxAccount" id="serTypeId"></selectivity>
						            </div>
						            <div class="col-md-6" data-ng-if="haveCode">
										 <input type="text" class="form-control input-sm" ng-model="manageSubTax.acctName" readonly>
									</div>
						        </div>

						        <div class="form-group">
       								<label class="col-md-4 control-label">Is Active</label>
        							<div class="col-md-6">
        								<div class="checkbox">
            								<label>
		             							<input class="checkbox style-0" type="checkbox" ng-model="manageSubTax.isactive"><span></span>
		           							</label>
              			 				</div>
									</div>
       							</div>
       						</div>
       					 </div>

       				</div>
       			</fieldset>
       			<fieldset>

       			</fieldset>
       			<div class="form-actions">
			      <div class="row">
				       <div class="col-lg-12 col-md-12">
				      		<button class="btn btn-success" type="button" ng-if="!manageSubTax.edit" data-ng-click="validate(manageSubTaxForm)">
								<i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
							</button>
							<button class="btn btn-success" type="button" ng-if="manageSubTax.edit" data-ng-click="validate(manageSubTaxForm)">
								<i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
							</button>
             			 	<button class="btn btn-info ng-scope" type="button"
				           		class="btn btn-success" ng-click="reset(manageSubTaxForm)">
								<i class="fa fa-undo"></i> <spring:message code="label.reset"></spring:message>
							</button>
							<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
				          		<i class="fa fa-close"></i> <spring:message code="label.cancel"></spring:message>
				            </button>
		             	</div>
			      </div>
			     </div>
       		</form>
      </div>
    </div>
    </div>
    </article>
    </div>
    </section>
    </div>

