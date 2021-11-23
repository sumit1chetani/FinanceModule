<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  				<input type="hidden" value="${form_code}" id="form_code_id">
  				<div class="panel-body">
    			<form name="purchaseAssetForm" class="form-horizontal" novalidate>
    				<div class="row book-widget-row">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>

									<div class="form-group">
										<label class="col-md-5 control-label"> Asset
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity  list="AssetList" ng-model="purchaseAssetData.AssetNo" property="purchaseAssetData.AssetNo"
											id="Asset" object="Asset" name="Asset"
											validation="required" friendly-name="Asset" form-name = "purchaseAssetForm"></selectivity>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-5 control-label"> Company
											<span style="color: red;">*</span>
										</label>
										
										<div class="col-md-7" >
											<selectivity  list="companyList" ng-model="purchaseAssetData.company" property="purchaseAssetData.company"
											id="company_id" object="company" name="company_id"
											validation="required" friendly-name="Company" form-name = "purchaseAssetForm" disabled=true></selectivity>
										</div>
									</div>


           							<div class="form-group">
										<label class="col-md-5 control-label"> Party Invoice No
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm" ng-model="purchaseAssetData.partyInvoiceNo"
											name="Party Invoice No" readonly >
										</div>
									</div>


								   <div class="form-group">
										<label class="col-md-5 control-label"> Currency
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											 <input type="text" class="form-control input-sm" readonly ng-model="purchaseAssetData.currency"
												name="Currency" validation="required" friendly-name="Currency" readonly>
											<!-- <selectivity list="currencyList" property="purchaseAssetData.currency" name="Currency"  
											id="currency" object="currency" validation="required" friendly-name="Currency" form-name = "purchaseAssetForm"
											ng-model="purchaseAssetData.currency"></selectivity> -->
										</div>
									</div>

           							

								</fieldset>
							</div>
					     	<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>

									<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-5">Invoice Date
             							<span style="color: red;">*</span></label>
            								<div class="col-md-7">
             									<div class="input-group input-append date" id="pi_date">
                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                									ng-model="purchaseAssetData.puchaseInvoiceDate" name="Date" id="purchase_invoice_date"
                									validation="required" friendly-name="Invoice Date">
		           									 <span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span>
        									     </div>
            								</div>
           							</div>


									<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-5">Party Invoice Date
             							<span style="color: red;">*</span></label>
            								<div class="col-md-7">
             									<div class="input-group input-append date" id="party_date">
                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                									 ng-model="purchaseAssetData.partyInvoiceDate" name="Party Invoice Date" id="party_invoice_date"
                									 validation="required" friendly-name="Party Invoice Date" readonly>
                									 <!-- <span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span> -->
		                     				     </div>
            								</div>
           							</div>

									<div class="form-group">
											<label class="col-md-5 control-label"> Exchange Rate
												<span style="color: red;">*</span>
											</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"  ng-model="purchaseAssetData.exchangeRate"
													name="Exchange Rate" validation="required" friendly-name="Exchange Rate" readonly>
											</div>
									</div>

									<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-5">Description</label>
            								<div class="col-md-7">
             									<textarea rows="2" class="form-control" name="Description" ng-model="purchaseAssetData.description" readonly/>
            								</div>
           							</div>
           							
           						</fieldset>
							</div>
							    <div class="col-sm-12 col-md-4 col-lg-4">

									<div class="form-group">
										<label class="col-md-5 control-label"> Supplier
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<!-- <select class="form-control input-sm" name="Suppliername" ng-model="purchaseAssetData.supplier" data-ng-options="r.supplier as r.supplierName for r in supplierList"
											ng-change="getSupplierCurrency(purchaseAssetData.supplier)" >
												<option value="" selected="selected">--Select--</option>
											</select> -->

											<!-- <selectivity list="supplierList" property="purchaseAssetData.supplier" ng-model="purchaseAssetData.supplier"  id="supplier_id" name="supplier_id"
											object="supplier" validation="required" friendly-name="supplier" form-name = "purchaseAssetForm"></selectivity> -->
											<input type="text" class="form-control input-sm" ng-model="purchaseAssetData.supplierName"
												name="Amount" ng-keyup="amountCalculation(purchaseAssetData.bcAmount)" friendly-name="BC Amount" readonly>
												
										</div>
									</div>

							 		

							    	<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-5">Due Date</label>
            								<div class="col-md-7">
             									<div class="input-group input-append date" id="du_date">
                									<input type="text" class="form-control input-sm" name="Due Date"
                									placeholder="dd/mm/yyyy" id="due_date"
                									ng-model="purchaseAssetData.dueDate" validation="required" friendly-name="Due Date" >
                									<span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span>
		                     				     </div>
            								</div>
           							</div>

									<div class="form-group">
										<label class="col-md-5 control-label"> BC Amount({{companyCurrency}})
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm" ng-model="purchaseAssetData.bcAmount"
												name="Amount" ng-keyup="amountCalculation(purchaseAssetData.bcAmount)" validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="BC Amount" readonly>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-5 control-label"> TC Amount
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm" ng-model="purchaseAssetData.tcAmount"
												name="Amount(USD)" ng-keyup="amountLocalCalculation(purchaseAssetData.tcAmount)"
												validation="numeric|required" friendly-name="TC Amount" readonly>
										</div>
									</div>

							  </div>
						</div>
						<div class="table-responsive clear">
					        <div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
						   			<div class="content">
						     			<div class="form-actions">
											<div class="row">
												<div class="col-md-12">
													<button ng-model="add" class="btn btn-success" ng-if="!edit"
														 class="btn btn-success" ng-click="onSubmit(purchaseAssetForm,purchaseAssetData)">
														<i class="fa fa-save"></i> Save
													</button>
													<button class="btn btn-success"	ng-if="edit"
													ng-click="onSubmit(purchaseAssetForm,purchaseAssetData)">
														<i class="fa fa-save"></i> Update
													</button>
													<button class="btn btn-danger" type="reset"
														class="btn btn-success" ng-click="cancel()">
														<i class="fa fa-close"></i> Cancel
													</button>
												</div>
											</div>
										</div><!-- /form-actions -->
									</div>
								</div>
							</div>
					      </div> <!-- /table-responsive -->
					</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>