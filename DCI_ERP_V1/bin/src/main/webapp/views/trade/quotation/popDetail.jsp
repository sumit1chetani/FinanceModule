<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate> 
			<div>
					<table class="table table-striped b-t b-light">
						<tr>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_13 text-center">Freight Element<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Currency<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_8 text-center">Quoted Rate<span
								style="color: red">*</span></th>
						
								
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr>
										<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"
										ng-disabled="row.disabled"> <i></i>
									</label></td>
										<td class=" width_9"><selectivity list="chargeHeadList"
										property="row.freightelement" id="freightelement{{trIndex}}" ng-model="row.freightelement"
										 validation="required"
										name="freightelement{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(freightelement)'}}"
										form-name="quotationForm" ></selectivity></td>
										<td class=" width_9">
										<selectivity list="chargeHeadList"
										property="row.currency" id="currency{{trIndex}}" ng-model="row.currency"
										 validation="required"
										name="currency{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(currency)'}}"
										form-name="quotationForm" ></selectivity>
										</td>
									<td class=" width_9" ><input type="text" class="form-control input-sm text-right"
										name="quotedRate" 
										property="row.quotedRate" id="quotedRate{{trIndex}}" ng-model="row.quotedRate"
										friendly-name="{{ 'Row' + ($index+1) + '(quotedRate)'}}" />
										</td>
								
					
							</tr>
						</tbody>
					</table>

					<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>

			</form>
		</div>
	</div>
</div>

