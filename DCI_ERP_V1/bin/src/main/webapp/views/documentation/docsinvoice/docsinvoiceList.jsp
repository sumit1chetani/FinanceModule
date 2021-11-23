<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 66%;
	position: absolute;
	top: 20%;
	left: 17%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}

.cndone{
color:red !important;

}
</style>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="invoiceListTableimp"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-10">
		
						<div class="col-sm-2">
							<fieldset>
								<div class="form-group">
									<button class="btn btn-primary" type="button"
										data-ng-click="bulkMail(rowCollection);">Bulk Mail</button>
								</div>
							</fieldset>
						</div>

					</div>

		
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head"
						style="background-color: #e2e2e2;">
						<tr>
						<th class="width_1"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectAll" ng-model="invView.selAll" ng-click="viewSelectAll()">
									<i></i>
							</label></th>
							<th class="sorting" st-sort="invoiceNo">Invoice No.</th>
							<th class="sorting" st-sort="blNo">BL No.</th>
							<th class="sorting" st-sort="quotation">Quotation No.</th>
							<th class="sorting" st-sort="createdOn">Invoice Date</th>
							<th class="sorting" st-sort="agentName">Agent</th>
							<th class="sorting" st-sort="customerName">Consignee</th>
							<th class="sorting" st-sort="vesselName">Vessel/Voyage</th>
							<th class="sorting" st-sort="createdBy">Created By</th>
							<th class="sorting" st-sort="totalTcAmt">Total Amt</th>
							<th class="sorting" st-sort="printoption">Print</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr ng-class="{cndone:inv.iscn=='Y',cnnotdone:inv.iscn=='N'}"
							ng-repeat="inv in displayedCollection">
							
							<td class="width_1 text-center"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectedTypes[]" ng-model="inv.check">
									<i></i>
							</label></td>
							
							<td class="sorting "><a ng-click="viewInvoice(inv.invoiceNo)" >
									<span tooltip="{{inv.invoiceNo}}"
									class="tool-tip-span font-blue">{{inv.invoiceNo}}</span>
							</a></td>
							<td>{{inv.blNo}}</td>
							<td class="sorting ">
								<a
									href="#/cordelia/master/inventory/quotation/view?quotationNo={{inv.quotation}}" target="_blank">
										<span tooltip="{{inv.quotation}}"
										class="tool-tip-span font-blue" 
										ng-bind="inv.quotation"> </span>
								</a>
									
									</td>
							<td>{{inv.createdOn}}</td>
							<td>{{inv.agentName}}</td>
							<td>{{inv.customerName}}</td>
							<td>{{inv.vesselName}}</td>
<!-- 							<td>{{inv.voyage}}</td> -->
							<td>{{inv.createdBy}}</td>
							<td>{{inv.totalTcAmt}}</td>
							  <td>
								<select  ng-model="inv[0].printList" id ="printSelect{{$index}}" ng-init="inv[0].printList = 'local'">
									<option value="both" >Both</option>
									<option value="usd">USD</option>
									<option value="local">Local</option>
							</select>
								
								</td>
							<td class="td-actions text-center">
							
<!-- 							<span> <i -->
<!-- 									class="fa  fa-print text-success text" -->
<!-- 									data-ng-click="printInvoice(inv.invoiceNo)"></i> -->
<!-- 							</span> -->
							
						<span> <i
									class="fa  fa-print text-success text"
									data-ng-click="clickInvoiceFunction(inv.invoiceNo,inv[0].printList)" id="{{inv[0].invoiceNo}}"></i>
							</span>
							
							 <span class="padding-both-side-2"><i
									class="fa fa-envelope red"
									data-ng-click="sendMail(inv.invoiceNo)"
									style="cursor: pointer; color: gray;"></i></span>
									
									
								<span class="padding-both-side-2"><i
									class="fa  fa-pencil text-success text"
									data-ng-click="datechangeinv(inv.invoiceNo,inv)"
									style="cursor: pointer; color: green;"></i></span>
									
									 </td>
							
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer" style="padding: 0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
</div>



 <script type="text/ng-template" id="deliveryOrderpop"> 

<div class="wrapper-md">
	<div class="panel-body float-left padding-0">
		<form class="form-horizontal" name="invoiceListForm">
			<div class="row">
				<fieldset>
					<legend>D.O Office Information :</legend>

					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="col-sm-6 col-md-6 col-lg-6 ">
							<div class="form-group">
								<label class="col-md-3 control-label">Office<span
									style="color: red;">*</span></label>
								<div class="col-md-8">
									<selectivity list="branchlist" property="dodata.officeName"
										id="officeNameId" ng-model="dodata.officeName"
										name="officeName" form-name="invoiceListForm"
										validation="required" friendly-name="Office" form-name="invoiceListForm"></selectivity>

								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6 ">
							<div class="form-group">
								<label class="col-md-4 control-label">Issued Date<span
									style="color: red;">*</span></label>
								<div class="col-md-8">

									<ng-bs3-datepicker data-ng-model="dodata.issuedDate"
										id="issuedDate" name="issuedDate" form-name="invoiceListForm"
										validation="required" friendly-name="Issued Date" />
								</div>
							</div>
						</div>

					</div>
				</fieldset>
				<fieldset>
					<legend>D.O Issue To :</legend>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<label class="col-md-2 control-label">Show T.I.P. In
								Print</label>
							<div class="col-md-5" style="margin-top: -1%;">
								<div class="checkbox">
									<label class="i-checks"> <input type="checkbox"
										class="checkbox style-0" ng-disabled="disabled" name="showtip"
										ng-model="dodata.showtip"> <i></i>
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="dodata.doType" value="M" name="doType"
										checked="checked"> <i></i> Messers
									</label>
								</div>
							</div>

						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%; color: red;">
								{{dodata.messers}}</div>
						</div>
					</div>

					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="dodata.doType" value="C" name="doType"
										checked="checked"> <i></i> Cnee
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%; color: red;">
								{{dodata.cnee}}</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">

							<div class="col-md-5" style="margin-left: 5%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="dodata.doType" value="N1" name="doType"
										checked="checked"> <i></i> Notify Party(1)
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%; color: red;">
								{{dodata.notify1}}</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="dodata.doType" value="N2" name="doType"
										checked="checked"> <i></i> Notify Party(2)
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 ">
						<div class="form-group">
							<div class="col-md-5" style="margin-left: 5%; color: red;">
								{{dodata.notify2}}</div>
						</div>
					</div>

				</fieldset>
			</div>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="form-actions m-b-none">
						<button class="btn btn-success" type="button"
							ng-click="save(invoiceListForm,dodata)">Save</button>
						<button class="btn btn-info" type="button" ng-click="print()">Print</button>
						<button class="btn btn-danger" ng-click="closePopup()">Cancel</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
    </script> 
<!--   
  
  <input type="text" class="form-control input-sm" maxlength=6
									ng-model="dodata.issuedDate" name="issuedDate"
									validation="required" form-name="invoiceListForm"
									friendly-name="Issued Date"> -->