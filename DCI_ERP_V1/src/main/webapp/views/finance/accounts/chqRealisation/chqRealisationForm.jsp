<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="realisationAdd" class="form-horizontal" ng-submit="return false">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
							<div class="col-md-4">
								<!-- div class="form-group">
									<label class="col-md-4 control-label">Realized Date</label>
									<div class="col-md-7">
										<div class='input-group date datetimepick'>
											<div class="dropdown">
												<a class="dropdown-toggle" id="txtrealisedDate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="Realised Date"
															data-ng-model="realisation.realisedDate"
															validation="required" friendly-name="Realised Date" ><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<datetimepicker
														data-ng-model="realisation.realisedDate"
														data-on-set-time="realisation.realisedDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#txtrealisedDate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>
									</div>
								</div> -->
								
								
								<div class="form-group ">
								<label class="col-md-4 control-label">Realized Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="realisation.realisedDate"
										id="txtrealisedDate" name="realisedDate"
										data-ng-change="checkDatesCL(realisation.realisedDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Cheque No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="chqNoId" name="chqNo" placeholder=""
											ng-model="realisation.chqNo" readonly>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Cheque Amount</label>
									<div class="col-md-7">
											<input type="text" class="form-control input-sm"
											 name="chqAmnt" placeholder=""
											ng-model="realisation.chqAmnt" readonly>
									</div>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Presentation</label>
									<div class="col-md-7">
										<selectivity list="presentationList" property="realisation.prCode" id="presentId"  ng-if="!isEdit"
										ng-model="realisation.prCode" name="prCode" form-name = "realisationAdd"
	        							validation="required" friendly-name="Presentation" ></selectivity>
										<input type="text" class="form-control input-sm" id="presentId" name="presentCode" ng-model="realisation.prCode" ng-if="isEdit" readonly />
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Customer</label>
									<div class="col-md-7">
											<input type="text" class="form-control input-sm"
											id="customerId" name="customerName" placeholder=""  ng-if="!isEdit"
											ng-model="realisation.customerName" readonly>
											<input type="text" class="form-control input-sm"
											id="customerName" name="customerName" placeholder=""  ng-if="isEdit"
											ng-model="realisation.customerName" readonly>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Cheque Status</label>
									<div class="col-md-7">
										<selectivity list="statusList" property="realisation.status" id="statusId"
										ng-model="realisation.status" name="status" form-name = "realisationAdd"
	        							validation="required" friendly-name="Cheque Status" ></selectivity>
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
								ng-click="onSubmit(realisationAdd)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								ng-click="onSubmit(realisationAdd)">
								<i class="fa fa-save"></i> Update
							</button>
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
