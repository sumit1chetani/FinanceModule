<style>
#assetTrackDetails thead tr:first-child {
	color: #000 !important;
	position: absolute !important;
}

#assetTrackDetails tbody tr:first-child td {
	padding-top: 35px !important;
}
.nav-justified>li, .nav-tabs.nav-justified>li {
    background-color: #3B8A8A;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
	<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body padding-top-10">			
			<form class="form-horizontal" name="assetForm" novalidate method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="form-group">
									<label class="col-md-4 control-label"> Asset No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="Asset No" data-ng-model="assetMasterData.assetNo" disabled>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Asset Name</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"  maxlength="250"
											name="Asset Name" data-ng-model="assetMasterData.assetName" 
											validation="required" friendly-name="Asset Name">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Category <span class="font-red"> *</span></label>
									<div class="col-md-7">
										
										<selectivity list="categoryList"
											property="assetMasterData.categoryNo" id=""
											ng-model="assetMasterData.categoryNo" name="categoryNo"
											form-name="assetForm" validation="required"
											friendly-name="Category"></selectivity>
									</div>
								</div>
								
							</div>
	
							<div class="col-sm-6 col-md-6 col-lg-6">
								
								<div class="form-group">
									<label class="col-md-4 control-label"> No of Similar Asset</label>
									<div class="col-md-7">
										<input type="text" maxlength="4"
											class="form-control input-sm text" name="quantity"   validation = "numeric" friendly-name="No of Similar Asset"
											data-ng-model="assetMasterData.noOfSimilarAsset" />
									</div>`
								</div>
								
								<div class="form-group">
									<label class="col-md-4 control-label"> Company<span class="font-red"> *</span></label>
									<div class="col-md-7">
										<selectivity list="companyList"
											property="assetMasterData.companyId" id="companyId"
											ng-model="assetMasterData.companyId" name="company"
											form-name="assetForm" validation="required"
											friendly-name="Company"></selectivity>
									</div>
								</div>
							</div> <!-- /col-sm-6 -->
						</fieldset>
					</div> <!-- /col-sm-12 -->
				</div><!-- /row -->
	
	
				<br>
				<tabset justified="true" class="tab-container">  
				<tab heading="Asset Details" id="assetTrackDetails"> <br>	
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="col-sm-6 col-md-6 col-lg-6">
								
								<div class="form-group">
									<label class="col-md-3 control-label"> Asset Account<span class="font-red"> *</span></label>
									<div class="col-md-6">
										<selectivity list="accountHeadList"
											property="assetMasterData.accountHeadCode" id="accounthead"
											ng-model="assetMasterData.accountHeadCode" name="Asset Account"
											form-name="assetForm" validation="required"
											friendly-name="Asset Account">
										</selectivity>
									</div>
								</div>
								
								<div class="form-group">
										
										<label class="col-md-3 control-label"> Description
										</label>
										<div class="col-md-9">
											<textarea class="form-control input-sm" style="resize: none; width: 285px;"
												name="description" maxlength="300"
												data-ng-model="assetMasterData.description"></textarea>
										</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								
								<div class="form-group">
											<label class="col-md-3 control-label"> Quantity</label>
											<div class="col-md-6"> 
												<input type="text" class="form-control input-sm text-right" maxlength="5"
													name="Asset No" data-ng-model="assetMasterData.quantity" 
													validation="numeric" friendly-name="Quantity" >
											</div>
								</div>
								<div class="form-group">
							        <label class="col-md-3 control-label">Capitalisation Date</label>
							        <div class="col-md-6">
							          	<ng-bs3-datepicker data-ng-model="assetMasterData.capitalisationDate" name="Capitalisation Date" id="capitalisationDatetxt"
							          	validation="required" friendly-name="Capitalisation Date"/>
							        </div>
						     	</div>
								
							</div>
					</div>
				</div>
				</tab> 
				<tab heading="Vendor Detail"> 
				<br>
					<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="form-group">
									<label class="col-md-3 control-label"> Supplier<span class="font-red"> *</span></label>
									<div class="col-md-6">
										<selectivity list="supplierList"
											property="assetMasterData.supplierCode" id="supplier"
											ng-model="assetMasterData.supplierCode" name="supplier"
											form-name="assetForm" validation="required"
											friendly-name="Supplier">
										</selectivity>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"> Purchase type<span class="font-red"> *</span></label>
									<div class="col-md-6">
										<selectivity list="purchaseTypeList"
											property="assetMasterData.purchaseType" id="purchaseType"
											ng-model="assetMasterData.purchaseType" name="purchaseType"
											form-name="assetForm" validation="required"
											friendly-name="Asset Account">
										</selectivity>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"> Party Invoice No.</label>
									<div class="col-md-6">
												<input type="text" class="form-control input-sm" name="Party Invoice No"
													friendly-name="Party Invoice No" maxlength="40"
												data-ng-model="assetMasterData.partyInvoiceNo" >
									</div>
								</div>
								
								<div class="form-group">
							        <label class="col-md-3 control-label">Party inv Date</label>
							        <div class="col-md-6">
							          	<ng-bs3-datepicker data-ng-model="assetMasterData.partyInvoiceDate" name="Party Invoice Date" id="capitalisationDatetxt"
							          	validation="required"	friendly-name="Party Invoice Date" />
							        </div>
						     	</div>
						  </div>
						  <div class="col-sm-6 col-md-6 col-lg-6">
								<div class="form-group">
									<label class="col-md-3 control-label"> Currency<span class="font-red"> *</span></label>
									<div class="col-md-6">
										<selectivity list="currencyList"
											property="assetMasterData.currencyCode" id="currency"
											ng-model="assetMasterData.currencyCode" name="currency"
											form-name="assetForm" validation="required"
											friendly-name="Currency">
										</selectivity>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"> Exchange Rate<span class="font-red"> *</span></label>
									<div class="col-md-6">
												<input type="text" class="form-control input-sm text-right" maxlength="7"
													name="Exchange Rate" data-ng-model="assetMasterData.exchangeRate" disabled="disable"
													validation="required|required"	friendly-name="Exchange Rate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-3 control-label"> Total TC Amount<span class="font-red"> *</span></label>
									<div class="col-md-6">
												<input type="text" class="form-control input-sm text-right" maxlength="15" 
													name="TC Amount" data-ng-model="assetMasterData.totalTCAmount" ng-keyup="calculateBCAmount(assetMasterData.totalTCAmount)"
													validation="numeric|required"  friendly-name="TC Amount">
									</div>
								</div>
<!-- 								validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Total TC Amount Should be 2 digit|required"	
 -->								
								<div class="form-group">
									<label class="col-md-3 control-label"> Total BC Amount<span class="font-red"> *</span></label>
									<div class="col-md-6">
												<input type="text" class="form-control input-sm text-right" disabled="disable"
													name="BC Amount" data-ng-model="assetMasterData.totalBCAmount" ng-keyup="calculateEXrate(assetMasterData.totalBCAmount)"
											validation="numeric|required" friendly-name="BC Amount" >
									</div>
								</div>
<!-- 								ng-keyup="calculateEXrate(assetMasterData.totalBCAmount)"
 --><!-- 								validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Total BC Amount Should be 2 digit|required"
 -->								
								
								
						  </div>
						</div>
					</div>
				</tab> 
				<tab heading="Depreciation">
				<br>
					<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Asset useful period<span class="font-red"> *</span></label>
									<div class="col-md-6">
												<input type="text" class="form-control input-sm" maxlength="6"
													name="Asset useful period" data-ng-model="assetMasterData.assetUsefulPeriod"
													validation="numeric|required"	friendly-name="Asset useful period" >
									</div>
								</div>
							</div>
							<div class="col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-3 control-label"> Start Date<span class="font-red"> *</span></label>
									<div class="col-md-6">
											<ng-bs3-datepicker data-ng-model="assetMasterData.depStartDate" name="depStartDate" 
											id="depStartDate" validation="required"	friendly-name="Dep. Start Date" />
             									
            						</div>
								</div>
							</div>
							<div class="col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-3 control-label"> End Date<span class="font-red"> *</span></label>
									<div class="col-md-6">
										<ng-bs3-datepicker data-ng-model="assetMasterData.depEndDate" name="depEndDate" 
										id="depEndDate" validation="required"	friendly-name="Dep. End Date"/>
             									
            						</div>
								</div>
							</div>
						  </div>
					  </div>
					  	<div class="row"></div>
				</tab> 
				</tabset>
			
	
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								data-ng-click="submit(assetForm,assetMasterData)"
								data-ng-if="!isEdit">
								<i class="fa fa-save"></i>
								Save
							</button>
	
							<button class="btn btn-success" type="button"
								data-ng-click="update(assetForm,assetMasterData);"
								data-ng-if="isEdit == true">
								<i class="fa fa-save"></i>
								Update
							</button>
	
							<button class="btn btn-info" type="button"
								data-ng-click="resetedit(assetForm)"
								data-ng-if="isEdit == true">
								<i class="fa fa-undo"></i>
								Reset
							</button>
	
							<button class="btn btn-info" type="button"
								data-ng-click="reset(assetForm)" data-ng-if="!isEdit">
								<i class="fa fa-undo"></i>
								Reset
							</button>
	
							<button class="btn btn-danger" type="button"
								data-ng-click="cancel();">
								<i class="fa fa-close"></i>
								Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div> <!-- /panel-body -->			
	</div> <!-- /panel-default-form -->
</div> <!-- /wrapper-md -->