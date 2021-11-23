<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">

		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="manageTaxForm" novalidate
				method="POST">
				<fieldset>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">

							<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-5 control-label"> Tax Codeewrew <span
										style="color: red;">*</span></label>
									<div class="col-md-6">{{manageTax.code}}
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Tax Name <span
										style="color: red;">*</span></label>
									<div class="col-md-6">{{manageTax.taxName}}
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="col-md-5 control-label">Currency
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-6">{{manageTax.currency}}

									</div>
								</div>


								<div class="form-group">
									<label class="col-md-5 control-label"> Tax Method <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-3">{{manageTax.taxMethod}}
									</div>
									<div class="col-md-3">{{manageTax.taxMethodAmount}}
									</div>
									<div class="form-group" id="percentage">
										<label class="control-label"> % </label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Child Tax </label>
									<div class="col-md-6">{{manageTax.subTaxId}}
									</div>
								</div>





								<div class="form-group">
									<label class="col-md-5 control-label">From Date<span
										style="color: red;">*</span></label>
									<div class="col-md-6 inputGroupContainer">{{manageTax.fromDate}}



									</div>
								</div>




								<div class="form-group">
									<label class="col-md-5 control-label">To Date<span
										style="color: red;">*</span></label>
									<div class="col-md-6 inputGroupContainer">{{manageTax.toDate}}



									</div>
								</div>







							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-4 control-label"> Tax Type <span
										style="color: red;">*</span></label>
									<div class="col-md-6">{{manageTax.taxTypeId}}
									</div>
								</div>
								<div class="form-group" id="salesType">
									<label class="col-md-4 control-label">Sales Tax Account<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-6" data-ng-if="!haveCode">{{manageTax.taxAccount}}
									</div>
									<div class="col-md-6" data-ng-if="haveCode">{{manageTax.acctName}}
									</div>
								</div>
								<div class="form-group" id="purchaseType">
									<label class="col-md-4 control-label"> Purchase Tax
										Account<span style="color: red;">* </span>
									</label>
									<div class="col-md-6" data-ng-if="!haveCode">{{manageTax.taxAccount}}
									</div>
									<div class="col-md-6" data-ng-if="haveCode">{{manageTax.acctName}}
									</div>
								</div>
								<div class="form-group" id="serviceType">
									<label class="col-md-4 control-label"> Service Tax
										Account<span style="color: red;">*</span>
									</label>
									<div class="col-md-6" data-ng-if="!haveCode">{{manageTax.taxAccount}}
									</div>
									<div class="col-md-6" data-ng-if="haveCode">{{manageTax.acctName}}
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Is Active</label>
									<div class="col-md-6">
										<div class="checkbox">
											<label> <input class="checkbox style-0"
												type="checkbox" ng-model="manageTax.isactive" disabled><span></span>
											</label>
										</div>
									</div>
								</div>
<!-- 								<div class="form-group"> -->
<!-- 									<label class="col-md-4 control-label"> Child Tax Method -->
<!-- 									</label> -->
<!-- 									<div class="col-md-3"> -->
<!-- 										<label ng-bind="subTaxMethod" -->
<!-- 											class="form-control input-sm text-left"> </label> -->
<!-- 									</div> -->
<!-- 									<div class="col-md-3"> -->
<!-- 										<label class="form-control input-sm text-right" -->
<!-- 											ng-bind="subTaxValue"></label> -->
<!-- 									</div> -->
<!-- 									<div class="form-group" ng-if="isSubTaxPercentage"> -->
<!-- 										<label class="control-label"> % </label> -->
<!-- 									</div> -->
<!-- 								</div> -->
							</div>

						</div>

					</div>
				</fieldset>
		</div>
		<!-- /row -->
		<br>

		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
<!-- 					<button class="btn btn-success" ng-if="!edit" -->
<!-- 						ng-click="save(manageTaxForm,manageTax)"> -->
<!-- 						<i class="fa fa-save"></i> Save -->
<!-- 					</button> -->
<!-- 					<button class="btn btn-success" -->
<!-- 						ng-click="update(manageTaxForm,manageTax)" ng-if="edit" -->
<!-- 						type="submit"> -->
<!-- 						<i class="fa fa-save"></i> Update -->
<!-- 					</button> -->

<!-- 					<button class="btn btn-info" type="reset" ng-click="reset()"> -->
<!-- 						<i class="fa fa-reply"></i> Reset -->
<!-- 					</button> -->


					<button class="btn btn-danger" type="reset" class="btn btn-success"
						ng-click="cancel()">
						<i class="fa fa-close"></i> Cancel
					</button>


				</div>
			</div>
		</div>
		</form>
	</div>
</div>
</div>
<script type="text/ng-template" id="addtaxdetails">

<div class="padding-0">
 <div class="panel panel-default padding-0">
  <div class="panel-heading font-bold"><font  color="red">ADD TAX DETAILS</font></div>
  <div class="panel-body" style="
    display: list-item;
">

<div class="col-sm-6 col-md-6 col-lg-6">
							 
								<div class="form-group">
									<label class="col-md-4 control-label" style="
    margin-right: 16%;
"> From Date <span
										style="color: red;">*</span>
									</label>

										<div class='input-group date datetimepick col-md-6'>

														<div class="dropdown">
															<a class="dropdown-toggle" id="todate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group" style="
    margin-right: -55%;
">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="fromdate"
																		validation="date_euro_long|required"
																		friendly-name="Financial  Date"
																		data-ng-model="taxdetails.fromtaxdate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="taxdetails.fromtaxdate"
																	data-on-set-time="accountweek.finactodate = onDateSet(newDate);accountweek.type=''"
																	data-datetimepicker-config="{ dropdownSelector: '#todate',startView:'day', minView:'day'}" />
															</ul>
														</div>

													</div>


									</div>
								<div class="form-group">
									<label class="col-md-4 control-label" style="
    margin-right: 16%;
"> To Date <span
										style="color: red;">*</span>
									</label>

										<div class='input-group date datetimepick col-md-6'>

														<div class="dropdown">
															<a class="dropdown-toggle" id="todate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group" style="
    margin-right: -55%;
">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="fromdate"
																		validation="date_euro_long|required"
																		friendly-name="Financial  Date"
																		data-ng-model="taxdetails.totaxdate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="taxdetails.totaxdate"
																	data-on-set-time="accountweek.finactodate = onDateSet(newDate);accountweek.type=''"
																	data-datetimepicker-config="{ dropdownSelector: '#todate',startView:'day', minView:'day'}" />
															</ul>
														</div>

													</div>


									</div>

<div class="form-group">
	<label class="col-md-4 control-label" style="
    margin-top: 2%;
">Description<span
		style="color: red;">*</span>
	</label>
	<div class="col-md-8">

		<input type="text" style="
    margin-left: 20%;
    width: 132%;
" class="form-control input-sm" id="txtAcctHeadName"
			name="entryno" ng-model="taxdetails.taxdescription" validation="required"
			friendly-name="Entry No" form-name="fuelvoucherentryForm" />
	</div>
</div>

<div class="form-group">
									<label class="col-md-4 control-label" style="
    margin-top: 5%;
">Tax Percentage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-8" >

										<input type="text" style="
    margin-left: 20%;
    width: 132%;
    margin-top: 5%;
" class="form-control input-sm"
											id="txtAcctHeadName" name="entryno"
											ng-model="taxdetails.taxpercentage" validation="required"
											friendly-name="Entry No" form-name="fuelvoucherentryForm" />
									</div>
								</div>
</div>

   <div class="form-actions" style="
    margin-top: 30%;
">
    <div class="row">
 
     <div class="col-md-12">
      <button ng-model="add" class="btn btn-success" type="submit" class="btn btn-success" ng-click="confirmtax(taxdetails)">
       <i class="fa fa-check"></i>
       Save
      </button>
      <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="closeThisDialog('button')">
       <i class="fa fa-close"></i>
       Cancel
      </button>
     </div>
    </div>
   </div>
 
 </div>
</div>

</script>












