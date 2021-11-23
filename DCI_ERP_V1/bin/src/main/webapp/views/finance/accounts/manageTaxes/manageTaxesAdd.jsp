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
       		<form class="form-horizontal" name="manageTaxForm" novalidate method="post">
       			<fieldset>
       				<div class="row">
       					<div class="col-sm-12 col-md-12 col-lg-12">

       						<div class="col-md-6">
       							 <div class="form-group">
						        	<label class="col-md-5 control-label"> Tax Code <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						            	<input type="text" class="form-control input-sm" data-message-id="code"
						              		ng-model="manageTax.code" name="code" validation="required" id="code"
						              		data-valid-method="save" validation="required"
						              		maxlength="20" >
						            </div>
						        </div>
						        <div class="form-group">
						        	<label class="col-md-5 control-label"> Tax Name <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						            	<input type="text" class="form-control input-sm"
						              ng-model="manageTax.taxName" name="taxName" data-message-id="taxName"  validation="required" friendly-name="Tax Name" data-valid-method="save"
						              maxlength="40">
						            </div>
						        </div>
						        <div class="form-group">
						        	<label class="col-md-5 control-label"> Tax Method <span style="color: red;">*</span> </label>
						            <div class="col-md-3">
						            	<select class="form-control input-sm" name="taxMethodId" ng-model="manageTax.taxMethodId" ng-options="value.taxMethodId as value.taxMethod for value in ValueList" ng-change="onchange1(manageTax.taxMethodId)"
						        			id="manageTaxMethod" form-name = "manageTaxForm"
						        				validation="required" friendly-name="Tax Method">
							          	</select>
						             </div>
						             <div class="col-md-3">
						             <input type="text" class="form-control input-sm text-right"
						              ng-model="manageTax.taxMethodAmount" name="taxMethodAmount" id="taxMethodAmount"
						              validation="numeric|required" ng-blur="changeAmountDiscount(manageTax.taxMethodAmount)"
									  friendly-name="Tax Amount" placeholder="" ng-pattern-restrict="^[0-9.]*$"
						              data-ng-keyup="onChangeNumber(manageTax.taxMethodAmount)"
						               data-valid-method="save" maxlength="10">
									</div>
									<div class="form-group" id="percentage">
						        	<label class="control-label"> % </label>
						        </div>
								</div>
						        <div class="form-group">
							 		<label class="col-md-5 control-label"> Child Tax </label>
							 		<div class="col-md-6">
						             	<selectivity list="SubTaxList" property="manageTax.subTaxId" ng-model="manageTax.subTaxId" name="subTaxId" id="subTaxId">
										</selectivity>
										</div>
           						</div>
						   </div>
						   <div class="col-md-6">
						      	<div class="form-group">
						        	<label class="col-md-4 control-label"> Tax Type <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						        		 <select class="form-control input-sm" name="taxTypeId" ng-model="manageTax.taxTypeId"
						        		 ng-options="type.taxTypeId as type.taxType for type in ValueList1" validation="required" friendly-name="Tax Type"  ng-change="focusTypes(manageTax.taxTypeId)" id="manageSubTax">
						             	</select>
						        	</div>
						        </div>
						        <div class="form-group" id="salesType">
									<label class="col-md-4 control-label" >Sales Tax Account<span style="color: red;">*</span></label>
									<div class="col-md-6" data-ng-if="!haveCode">
										<selectivity list="taxAccountList" property="manageTax.taxAccount" id="salesTypeId" 
											ng-model="manageTax.taxAccount" name="saleAcc" form-name="manageTaxForm"
						        				validation="required" friendly-name="Tax Account"></selectivity>
									</div>
									<div class="col-md-6" data-ng-if="haveCode">
										 <input type="text" class="form-control input-sm" ng-model="manageTax.acctName" readonly>
									</div>
								</div>
						      	<div class="form-group" id="purchaseType" >
						        	<label class="col-md-4 control-label"> Purchase Tax Account<span style="color: red;">* </span> </label>
						            <div class="col-md-6" data-ng-if="!haveCode">
						            	<selectivity list="taxAccountList" property="manageTax.taxAccount" id="purTypeId"></selectivity>
					             	</div>
					             	<div class="col-md-6" data-ng-if="haveCode">
										 <input type="text" class="form-control input-sm" ng-model="manageTax.acctName" readonly>
									</div>
						        </div>
						        <div class="form-group"  id="serviceType">
						        	<label class="col-md-4 control-label"> Service Tax Account<span style="color: red;">*</span> </label>
						            <div class="col-md-6" data-ng-if="!haveCode">
						            	<selectivity list="taxAccountList" property="manageTax.taxAccount" id="serTypeId"></selectivity>
						            </div>
						            <div class="col-md-6" data-ng-if="haveCode">
										 <input type="text" class="form-control input-sm" ng-model="manageTax.acctName" readonly>
									</div>
						        </div>
						        <div class="form-group">
       								<label class="col-md-4 control-label">Is Active</label>
        							<div class="col-md-6">
        								<div class="checkbox">
            								<label>
		             							<input class="checkbox style-0" type="checkbox" ng-model="manageTax.isactive"><span></span>
		           							</label>
              			 				</div>
									</div>
       							</div>
       							<div class="form-group">
						        	<label class="col-md-4 control-label"> Child Tax Method </label>
						            <div class="col-md-3">
						            	<label ng-bind="subTaxMethod" class="form-control input-sm text-left">
						            	</label>
						            </div>
						            <div class="col-md-3">
						            	<label class="form-control input-sm text-right" ng-bind="subTaxValue"></label>
							        </div>
									<div class="form-group" ng-if="isSubTaxPercentage">
						        		<label class="control-label"> % </label>
						        	</div>
						  		</div>
       						</div>

       					 </div>

       				</div>
       			</fieldset>

       			<div class="form-actions">
			      <div class="row">
				       <div class="col-lg-12 col-md-12">
				      		<button class="btn btn-success" type="button" ng-if="!edit" data-ng-click="save(manageTaxForm,manageTax)">
								<i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
							</button>
							<button class="btn btn-success" type="button" ng-if="edit" data-ng-click="update(manageTaxForm,manageTax)">
								<i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
							</button>
             			 	<button class="btn btn-info ng-scope" type="button"
				           		class="btn btn-success" ng-click="reset(manageTaxForm)">
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

