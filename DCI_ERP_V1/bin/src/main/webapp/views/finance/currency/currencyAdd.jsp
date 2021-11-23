
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" name="currencyAddForm" role="form"
					novalidate>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-9 col-lg-offset-1">
							<fieldset>
								<div class="form-group">
									<label class="col-md-3 control-label"> Currency Code <span
										style="color: red;">*</span>
									</label> <label class="col-md-0 control-label"> </label>
									<div class="col-md-3">
										<label class="control-label"
											ng-show="currencyValidateData.isEdit">
											{{currencyData.currencyCode}} </label> <input type="text"
											class="form-control input-sm" id="txtCurrCode"
											name="Currency Code" ng-model="currencyData.currencyCode"
											validation="required" friendly-name="Currency Code"
											form-name="currencyAddForm"
											typeahead="ac.currencyCode as ac.currencyCode for ac in currencyList| filter:$viewValue |limitTo:10"
											typeahead-min-length='1'
											typeahead-input-formatter="fetchSelectedCurrencyCode($model,currencyData)"
											ng-hide="currencyValidateData.isEdit"  />
									</div>
									<label class="col-md-3 control-label"> Currency Name <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-3">
										<input type="text" class="form-control input-sm"
											id="txtCurrName" name="Currency Name"
											ng-model="currencyData.currencyName" validation="required"
											friendly-name="Currency Name" form-name="currencyAddForm"
											typeahead="ac.currencyName as ac.currencyName for ac in currencyList| filter:$viewValue |limitTo:10"
											typeahead-min-length='1'
											typeahead-input-formatter="fetchSelectedcurrencyName($model,currencyData)"
											maxlength="250" />
									</div>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-3 control-label"> Currency Rate To
										Base Currency <span style="color: red;"></span>
									</label> <label class="col-md-1 control-label"> From </label> <label
										class="col-md-0 control-label"> </label>
									<div class="col-md-2">
										<input type="text" class="text-right form-control input-sm"
											name="fromc" data-ng-model="currencyData.fromc"
											placeholder="0.00" name="fromc" id="fromc" object="fromc"
											>
									</div>
									<label class="col-md-3 control-label"> To <span
										style="color: red;"></span>
									</label>
									<div class="col-md-3">
										<input type="text" class="text-right form-control input-sm"
											name="toc" data-ng-model="currencyData.toc"
											placeholder="0.00" name="toc" id="toc" object="toc"
											>
									</div>
								</div> -->
								<!-- <div class="form-group">
									<label class="col-md-3 control-label"> Default Value <span
										style="color: red;"></span>
									</label> <label class="col-md-0 control-label"> </label>
									<div class="col-md-3">
										<input type="text" class="text-right form-control input-sm"
											placeholder="0.00" name="currencyDefault"
											ng-model="currencyData.currencyDefault"
											name="currencyDefault" id="currencyDefault"
											object="currencyDefault" >
									</div>
									<label class="col-md-3 control-label"> Fraction Part <span
										style="color: red;"></span>
									</label>
									<div class="col-md-3">
										<input type="text" class="text-right form-control input-sm"
											placeholder="0" name="currencyFraction"
											ng-model="currencyData.currencyFraction"
											name="currencyFraction" id="currencyFraction"
											
											friendly-name="Fraction Part ">
									</div>
								</div> -->
									<div class="form-group">
									<label class="col-md-3 control-label"> Currency Symbol<span
										style="color: red;">*</span>
									</label> 
									<div class="col-md-3">
										 <input type="text"
											class="form-control input-sm" id="symbol"
											name="Symbol" ng-model="currencyData.symbol"maxlength="50"
											validation="required" friendly-name="Currency Symbol"
											form-name="currencyAddForm" maxlength="50"
											 />
									</div>
									<label class="col-md-3 control-label"> Currency Sub Category <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-3">
										<input type="text" class="form-control input-sm"
											id="txtCurrName" name="Sub Category"
											ng-model="currencyData.category" validation="required"
											friendly-name="Sub Category" form-name="currencyAddForm"
											maxlength="20" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label"> Description<span
										style="color: red;"></span>
									</label> 
									<div class="col-md-3">
									
											<input type="text"
											class="form-control input-sm" id="txtCurrCode"
											name="Description" ng-model="currencyData.description"maxlength="255"
											
											form-name="currencyAddForm"
											  />
									</div>
									<label class="col-md-3 control-label">Round-off Invoice Final Amount <span
										style="color: red;"></span>
									</label>
									<div class="col-md-3">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
											id="active" class="checkbox style-0" name="isRound"
											ng-model="currencyData.isRound" /> <i></i>
										</label>
											
										</div>
									</div>
								</div>
							<div class="form-group">
									<label class="col-md-3 control-label"> From Currency Value<span
										style="color: red;">*</span>
									</label> 
									<div class="col-md-3">
									
											<input type="text"
											class="form-control input-sm" validation="required"
											name="fromCurrency" ng-model="currencyData.fromCurrency"maxlength="10"
											friendly-name="From Currency"
											form-name="currencyAddForm"
											  />
									</div>
									<label class="col-md-3 control-label"> To Currency Value<span
										style="color: red;">*</span>
									</label> 
									<div class="col-md-3">
									
											<input type="text"
											class="form-control input-sm" validation="required"
											friendly-name="To Currency"
											name="toCurrency" ng-model="currencyData.toCurrency" maxlength="10"
											form-name="currencyAddForm"
											  />
									</div>
								</div>
								<div class="form-group">
								<label class="col-md-3 control-label"> Default Currency Value<span
										style="color: red;">*</span>
									</label> 
									<div class="col-md-3">
									
											<input type="text" friendly-name="Default Currency"
											class="form-control input-sm" validation="required"
											name="defaultCurrency" ng-model="currencyData.defaultCurrency" maxlength="10"
											
											form-name="currencyAddForm"
											  />
									</div>
									<label class="col-md-3 control-label"> Active </label>
									<div class="col-md-3">
										<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="active" class="checkbox style-0" name="isActive"
											ng-model="currencyData.isActive" /> <i></i>
										</label>
											<!-- <label class="i-checks"> <input type="checkbox"
												validator="required" ng-true-value="'Y'"
												ng-false-value="'N'" message-id="isActive" id="isActive"
												class="checkbox style-0" name="isActive"
												ng-model="currencyData.isActive"> <i></i>
											</label> -->
										</div>
									</div>
									 <label class="col-md-3 control-label"> Book Currency </label>
									<div class="col-md-3">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												validator="required" ng-true-value="'Y'"
												ng-false-value="'N'" message-id="bookCurrency"
												id="bookCurrency" class="checkbox style-0"
												name="bookCurrency" ng-model="currencyData.bookCurrency">
												<i></i>
											</label>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success"
									ng-if="!currencyValidateData.isEdit" type="button"
									data-ng-click="validate(currencyAddForm, currencyData, currencyValidateData)"
									type="submit">
									<i class="fa fa-save"></i> Save
								</button>
								<button class="btn btn-success"
									ng-if="currencyValidateData.isEdit" type="button"
									data-ng-click="validate(currencyAddForm, currencyData, currencyValidateData)"
									type="submit">
									<i class="fa fa-save"></i> Update
								</button>
								<button class="btn btn-danger" ng-click="cancel()" type="button">
									<i class="fa fa-close"></i> Cancel
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
