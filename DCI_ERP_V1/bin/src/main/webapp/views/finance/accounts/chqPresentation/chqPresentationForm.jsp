<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">

			<form class="form-horizontal" name="presentationAdd"	ng-submit="return false">
				<div class="row">

					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
						
						
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Company Name<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<selectivity list="companyList" property="presentation.companyCode" id="companyName"
										ng-model="presentation.companyCode" name="<spring:message
			              			code="label.company.name"></spring:message>" form-name = "presentationAdd"
	        							validation="required" friendly-name="<spring:message
			              			code="label.company.name"></spring:message>" ></selectivity>
									</div>
								</div>
							</div>
							
						<!-- 	<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Received Date<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<div class='input-group date datetimepick'>
											<div class="dropdown">
												<a class="dropdown-toggle" id="txtchqRcvdDate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="Received Date"
															data-ng-model="presentation.chqRcvdDate"
															validation="required" friendly-name="Received Date" ><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<datetimepicker
														data-ng-model="presentation.chqRcvdDate"
														data-on-set-time="presentation.chqRcvdDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#txtchqRcvdDate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div> -->
							
							
							<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-4 control-label">Received Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="presentation.chqRcvdDate"
										id="txtchqRcvdDate" name="realisedDate"
										data-ng-change="checkDatesCL(presentation.chqRcvdDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
							
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Customer<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<selectivity list="customerList" property="presentation.customerCode" id="txtCustomerName"
										ng-model="presentation.customerCode" name="Customer" form-name = "presentationAdd"
	        							validation="required" friendly-name="Customer" ></selectivity>
									</div>
								</div>
							</div>
							
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
							<!-- div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Deposited Date<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<div class='input-group date datetimepick'>
											<div class="dropdown">
												<a class="dropdown-toggle" id="txtPrDate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">

														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="Deposited Date"
															data-ng-model="presentation.presentDate"
															validation="required" friendly-name="Deposited Date" ><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<datetimepicker
														data-ng-model="presentation.presentDate"
														data-on-set-time="presentation.presentDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#txtPrDate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div> -->
							
							
							
							
							<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-4 control-label">Deposited Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="presentation.presentDate "
										id="txtchqRcvdDate" name="Deposited Date"
										data-ng-change="checkDatesCL(presentation.presentDate )"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
							
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Cheque No<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="chqNo" name="chqNo" placeholder="" ng-pattern-restrict="^[0-9a-zA-Z]*$"
											ng-model="presentation.chqNo" validation="required" friendly-name="Cheque No">
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Drawn Bank</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="drwnBank" name="drwnBank" placeholder=""
											ng-model="presentation.drwnBank" friendly-name="Drawn Bank">
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>

							<!-- div class="col-md-4">

								<div class="form-group">
									<label class="col-md-4 control-label">Cheque Date<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<div class='input-group date datetimepick'>
											<div class="dropdown">
												<a class="dropdown-toggle" id="txtchqDate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="Cheque Date"
															data-ng-model="presentation.chqDate"
															validation="required" friendly-name="Cheque Date" ><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<datetimepicker
														data-ng-model="presentation.chqDate"
														data-on-set-time="presentation.chqDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#txtchqDate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div> -->


<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-4 control-label">Cheque Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="presentation.chqDate "
										id="txtchqRcvdDate" name="Deposited Date"
										data-ng-change="checkDatesCL(presentation.chqDate )"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
							
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Cheque Amount<span style= "color:red;"></span></label>
									<div class="col-md-7">
										<input class="form-control input-sm" id="prChqAmt" maxlength="12"
											name="chqAmnt" type="text" validation="required" friendly-name="Cheque Amount" ng-pattern-restrict="^[0-9.]*$"
											data-ng-model="presentation.chqAmnt" data-ng-keyup="onChangeNumber(presentation.chqAmnt)"/>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Deposit Bank</label>
									<div class="col-md-7">
									  <selectivity list="cashAccountList" id="depositBank" name="Deposit Bank" 
				        property="presentation.depositBank" ng-model="presentation.depositBank" 
				         friendly-name="depositBank" form-name = "cashBankcomPaymentForm" object="acctList"></selectivity>
										<!-- <input type="text" class="form-control input-sm"
											id="depositBank" name="depositBank" placeholder="" friendly-name="Deposit Bank"
											ng-model="presentation.depositBank"> -->
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="onSubmit(presentationAdd,presentation)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								ng-click="onSubmit(presentationAdd,presentation)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info ng-scope" type="button" 
							ng-click="reset()" ng-if="!isEdit"
				            class="btn btn-success">
				            <i class="fa fa-undo"></i>
Reset				           </button>
				           <button class="btn btn-info ng-scope" type="button" 
							ng-click="resetEdit()" ng-if="isEdit"
				            class="btn btn-success">
				            <i class="fa fa-undo"></i>
Reset				           </button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
				<!-- end widget div -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>
