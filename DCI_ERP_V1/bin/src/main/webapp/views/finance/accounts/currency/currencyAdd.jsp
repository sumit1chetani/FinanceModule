<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="currencyForm">
				<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-6 ">
									<fieldset>
										<div class="form-group" ng-if="!edit">
											<label class="col-md-5 control-label">Currency Code</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													id="txtCurrencyCode" name="Currency Code"
													ng-model="currencyMaster.currencyCode"
													validation="required" friendly-name="Currency Code"
													maxlength="3" />
											</div>
										</div>
										<div class="form-group" ng-if="edit">
											<label class="col-md-5 control-label">Currency Code</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													id="txtCurrencyCode" name="Currency Code"
													ng-model="currencyMaster.currencyCode"
													validation="required" friendly-name="Currency Code"
													ng-disabled="true" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label"><!-- Currency Rate
												to Base Currency</label> <label class="col-md-2 control-label-left"> -->
												From</label>	
											<div class="col-md-6	">
												<input type="text" class="form-control input-sm"
													ng-model="currencyMaster.fromCurrency"
													ng-pattern-restrict="{{numExp}}" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Symbol</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													ng-model="currencyMaster.symbol" maxlength="30" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Default Value</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													ng-model="currencyMaster.currencyDefault"
													ng-pattern-restrict="^[0-9.]*$" maxlength="25" />
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-5 control-label">Is Active </label>
											<div class="col-md-5">
												<div class="checkbox">
													<label> <input type="checkbox"
														class="checkbox style-0" id="chkActive" name="Is Active"
														data-ng-true-value="'Y'" data-ng-false-value="'N'"
														data-ng-model="currencyMaster.isActive"
														validation="required" friendly-name="Is Active" /> <span></span>
													</label>
												</div>
											</div>
										</div>
									</fieldset>
								</div>

								<div class="col-sm-12 col-md-12 col-lg-5">
									<fieldset>
										<div class="form-group">
											<label class="col-md-5 control-label">Currency Name</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													ng-model="currencyMaster.currencyName" maxlength="100" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">To</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													ng-model="currencyMaster.toCurrency"
													ng-pattern-restrict="{{numExp}}" maxlength="20" />
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-5 control-label">Fraction Part</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													ng-model="currencyMaster.currencyFraction"
													ng-pattern-restrict="{{numExp}}" maxlength="20" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label"> Book Currency</label>
											<div class="col-md-5">
												<div class="checkbox">
													<label> <input type="checkbox"
														class="checkbox style-0" is="chkBookCurrency"
														name="Book Currency"
														data-ng-model="currencyMaster.bookCurrency"
														data-ng-true-value="'Y'" data-ng-false-value="'N'"
														validation="required" friendly-name="Book Currency" /> <span></span>
													</label>
												</div>
											</div>
										</div>
									</fieldset>
								</div>
							</div>
							<!-- Form field end -->
							<!-- Button Action Div Start-->
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="submit"
											data-ng-click="validate(currencyForm,currencyMaster)"
											data-ng-if="!edit">
											<i class="fa fa-save"></i>Save
										</button>
										<button class="btn btn-success" type="submit"
											data-ng-click="validate(currencyForm,currencyMaster)"
											data-ng-if="edit">
											<i class="fa fa-save"></i>Update
										</button>
										<button class="btn btn-info ng-scope" type="button"
											class="btn btn-success" ng-click="reset()">
											<i class="fa fa-undo"></i>Reset
										</button>
										<button class="btn btn-danger" type="button"
											class="btn btn-success" ng-click="cancel()">
											<i class="fa fa-close"></i>
											Cancel
										</button>
									</div>
								</div>
							</div>
							<!-- Button Action Div End-->
						</form>
						<!-- Form end -->
					</div>
				</div>
				<!-- end widget div -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>












