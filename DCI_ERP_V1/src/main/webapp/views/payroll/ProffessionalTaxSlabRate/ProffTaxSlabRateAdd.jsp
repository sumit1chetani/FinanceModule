<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="pffTaxSlabRate">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-5">
						<fieldset>


							<!-- <div class="form-group">
								<label class="col-md-4 control-label">From <spring:message code="label.asterisk.symbol"></spring:message></label>
					 			<div class="col-md-6">
					 			<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown" >
																<a class="dropdown-toggle" id="fromDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group" >
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="fromDate" form-name="pffTaxSlabRate"
																			validation="required" friendly-name="SlabRate From Date "
																			id="fromDate" 
																			data-ng-model="slabRate.fromDate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker 
																		data-ng-model="slabRate.fromDate"  
																		data-on-set-time="slabRate.fromDate= onDateSet(newDate); onFrmDateChg(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#disbursementdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
														</div>
						  </div>
									</div> -->

							<div class="form-group">
								<label class="col-md-6 control-label">From<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="slabRate.fromDate"
										id="fromDate" name="fromDate" form-name="pffTaxSlabRate"
										friendly-name="fromDate" validation="required" />
								</div>
							</div>


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-5">
						<fieldset>

							<!-- <div class="col-md-6">
													<div class="form-group">
								<label class="col-md-4 control-label">To <spring:message code="label.asterisk.symbol"></spring:message></label>
					 			<div class="col-md-6">
					 			<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown" >
																<a class="dropdown-toggle" id="toDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group" >
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="toDate" form-name="pffTaxSlabRate"
																			validation="required" friendly-name="SlabRate To"
																			id="toDate"
																			data-ng-model="slabRate.toDate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker 
																		data-ng-model="slabRate.toDate" 
																		data-on-set-time="slabRate.toDate= onDateSet(newDate); onFrmDateChg(newDate)" 
																		data-datetimepicker-config="{ dropdownSelector: '#disbursementdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
														</div>
						  </div>
						  
									</div> -->
							<div class="form-group">
								<label class="col-md-6 control-label">To<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="slabRate.toDate" id="toDate"
										name="toDate" form-name="pffTaxSlabRate"
										friendly-name="toDate" validation="required" />
								</div>
							</div>
						</fieldset>
					</div>
					<fieldset class="col-sm-12 col-md-12 col-lg-12 ">

						<div class="col-sm-12 col-md-12 col-lg-12 padding-bottom-10">
							<div class="content well">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-bottom-10">
										<table class="table table-bordered">
											<thead>
												<tr>

													<th class="width_1"><label>
															<i></i>
													</label></th>
													<th class="width_5">Slab</th>
													<th class="width_5">Range- From</th>
													<th class="width_2">Range - To</th>
													<th class="width_2">Professional Tax</th>


												</tr>
											</thead>
											<!-- 																 ng-controller="periodCtrl" -->
											<tbody ng-controller="slabrateDetailCtrl"
												ng-repeat="(trIndex, rate) in slabRate.rateTable"
												list="detailList">
												<tr>
													<td class="width_1"><label
														class="i-checks m-b-none padding-top-10"> <input
															type="checkbox" ng-model="rate.section"> <i></i>
													</label></td>
													<td class="width_8"><input type="text"
														ng-model="rate.slabName" class="form-control input-sm"
														name="Slab Name" disabled id="slabName"
														friendly-name="Slab Name"></td>


													<td class="width_8"><input type="text"
														class="form-control input-sm"
														ng-model="rate.rangeFromAmount" name="Range From"
														id="rangeFromAmount" friendly-name="bb" maxlength="8"
														onclick="myFunction()"
														onkeypress="return IsNumeric(event);"></td>
													<td class="width_8"><input type="text"
														class="form-control input-sm"
														ng-model="rate.rangeToAmount" name="Range To"
														id="rangeToAmount" friendly-name="bb" maxlength="8"
														onclick="myFunction3()"
														onkeypress="return IsNumeric(event);"></td>
													<td class="width_8"><input type="text"
														class="form-control input-sm"
														ng-model="rate.professionaltax" name="Professional Tax"
														id="professionaltax" friendly-name="dd" maxlength="8"
														onclick="myFunction2()"
														onkeypress="return IsNumeric(event);"></td>
											</tbody>
											<span id="error" style="color: Red; display: none">*
												Input digits (0 - 9)</span>
										</table>
										<button ng-click="slabRateAdd(slabRate.rateTable)"
											class="btn btn-primary" type="button">
											<i class="fa fa-plus"></i>
										</button>
										<button ng-click="slabRateRemove()" class="btn btn-danger"
											type="button">
											<i class="fa fa-trash-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</fieldset>

				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="submit"
								data-ng-click="save(pffTaxSlabRate)" data-ng-if="!isEdit">
								<i class="fa fa-save"></i>
								Save
							</button>
							<button class="btn btn-success" type="submit"
								data-ng-click="update(pffTaxSlabRate)" data-ng-if="isEdit">
								<i class="fa fa-save"></i>
								Update
							</button>
							<button class="btn btn-info ng-scope" type="button"
								class="btn btn-success" ng-click="reset()">
								<i class="fa fa-undo"></i>
								Reset
							</button>
							<button class="btn btn-danger" type="button"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i>
								Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


<script>
function myFunction() {
  var x = document.getElementById("rangeFromAmount").maxLength;
  
}
</script>

<script>
function myFunction3() {
  var x = document.getElementById("rangeToAmount").maxLength;
  //document.getElementById("demo").innerHTML = x;
}
</script>
<script>
function myFunction2() {
  var x = document.getElementById("professionaltax").maxLength;
 // document.getElementById("demo").innerHTML = x;
}
</script>
 <script type="text/javascript">
        var specialKeys = new Array();
        specialKeys.push(8); //Backspace
        function IsNumeric(e) {
            
            var keyCode = e.which ? e.which : e.keyCode
            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            document.getElementById("error").style.display = ret ? "none" : "inline";
            return ret;
        }
    </script>
    