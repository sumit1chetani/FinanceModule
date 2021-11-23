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
		<!-- <div
			style="width: 30%; position: absolute; margin-top: -40px; margin-left: 80%;">
			<label style="color: #e25d5d; float: left;">Quick Links
				&nbsp;&nbsp; </label>
			
			<selectivity style="float: left;" list="qlList"
				ng-init="qlList='Select'" ng-model="qukLinkVal"
				property="qukLinkVal" name="qukLinkVal" friendly-name="qukLinkVal"></selectivity>
				<select ng-change="quickLinkMethd(mrg,qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
		 <option value="Select">Select</option>
		  <option value="SRG">Standard Routing Guide</option>
		  <option value="Cost Matrix">Cost Matrix</option>
		  <option value="Sailing schedule">Sailing schedule</option>
		  <option value="Feeder Matrix">Feeder Matrix</option>		  
		  <option value="Rate request">Rate request </option>
		</select>
		</div> -->
		<div class="panel-body">
			<form name="mrgForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
					<fieldset>

							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label" style="padding-top: 10px;">MRG No </label>
								<div class="col-md-7" style="padding-top: 15px;">
									<label style="padding-left: 14px; font-weight: bold;" >{{mrg.mrgNo}}</label>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Service</label>
								<div class="col-md-7">
								<span>{{mrg.serviceType}}</span>
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7">
								<span>{{mrg.customer}}</span>
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">POL</label>
								<div class="col-md-7">
								<span>{{mrg.pol}}</span>
								</div>
							</div>
							
					<div class="form-group" >
									<label class="col-md-5 control-label"> POT </label>
									<div class="col-md-7">
								<span>{{mrg.pot}}</span>
									</div>
						</div> 
					<div class="form-group ">
								<label class="col-md-5 control-label">FPOD</label>
								<div class="col-md-7">
								<span>{{mrg.pod}}</span>
								</div>
							</div>							
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
							<label class="col-md-5 control-label">Valid From</label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.mrgDate}}</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Valid Till </label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.validTill}}</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Contract Type </label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.contractType}}</span>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Created By</label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.created_by}}</span>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Created Date</label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.created_date}}</span>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Currency</label>
								<div class="col-md-7"  style="padding-top: 9px;" >
										<span>{{mrg.currencyName}}</span>
								</div>
							</div>
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Origin</label>
								<div class="col-md-7"  style="padding-top: 9px;">
										<span>{{mrg.originName}}</span>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Destination </label>
								<div class="col-md-7"  style="padding-top: 9px;">
										<span>{{mrg.destinationName}}</span>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Modified By</label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.modified_by}}</span>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Modified Date</label>
								<div class="col-md-7 "  style="padding-top: 9px;">
											<span>{{mrg.modified_date}}</span>
								</div>
							</div>
						</fieldset>
					</div>

				</div>
								<br>
				<br>
				<div>
					<tabset justified="true" class="tab-container"> <tab
						heading="Freight Charges"
						style="background:#5F9EA0;  ">
						<div>
					<table class="table table-striped b-t b-light">
						<tr>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_13 text-center">Charge Heads</th>
							<th colspan=1 class=" width_9 text-center">Unit</th>
							<th colspan=1 class="width_10 text-center">Currency</th>
							<th colspan=1 class=" width_6 text-center">Transaction Type</th>
							<th colspan=1 class=" width_14 text-center">Buy/Sell Party</th>
							<th colspan=1 class="width_10 text-center">MRG Rate</th>
						</tr>
						<tbody ng-repeat="(trIndex, row) in mrg.mrgDtl"
							ng-controller="mrgdetailtableCtrl">
							<tr>
								<td>
									<label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"
										ng-disabled="row.disabled"> <i></i>
									</label>
								</td>
								<td class=" width_9">
									<span>{{row.chargeHeads1}}</span>
								</td>
								<td class=" width_9">
									<span>{{row.unitName}}</span>
								</td>	
								<td class=" width_10" >
									<span>{{row.currencyName}}</span>
								</td>
								<td class=" width_10">
									<span>{{row.transactionTypeName}}</span>
								</td>									
								<td class=" width_10">
									<span>{{row.buySellName}}</span>
								</td>							
								<td class=" width_5" >
									<span>{{row.rate}}</span>
								</td>		
							</tr>
						</tbody>
					</table>
				</div><br><br>
							<div>
						<table class="table table-striped b-t b-light">
							<tr>

								<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAllFreeDays()" ng-model="quotation.checkAllFreeDays"> <i></i>
								</label></th>
 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								 
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POL Free Days<span
									style="color: red;"> </span></th>	
								<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POD Free Days<span
									style="color: red;"> </span></th>							 
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days<span
									style="color: red;"> </span>
								</th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days<span
									style="color: red;"> </span>
								</th>		

							</tr>
							<tbody ng-repeat="(trIndex1, row) in mrg.mrgDtlorigin"
								ng-controller="mrgdetailtableCtrl">
								<tr>
									<td>
										<label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex1}}">
											<i></i>
										</label>
									</td>
 									<td class=" width_9">
										<span>{{row.containerType}}</span>
									</td>
									<td class=" width_9">
										<span>{{row.polFreeDays}}</span>
									</td>
									<td class=" width_9">
										<span>{{row.podFreeDays}}</span>
									</td>
									<td class=" width_9">
										<span>{{row.polGRFreeDays}}</span>
									</td>
									<td class=" width_9">
										<span>{{row.podGRFreeDays}}</span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>				
					</tab></tabset>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-danger" ng-click="cancelDraft()"
											type="button">
											<i class="fa fa-close"></i> Back
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

	</div>
</div>



