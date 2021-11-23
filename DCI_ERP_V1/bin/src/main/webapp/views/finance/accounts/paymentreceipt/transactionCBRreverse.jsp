 <style>
 .ngdialog-overlay{
 
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	    max-width: 100%;
    width: 75%;
    position: absolute;
    top: 20%;
    left: 7%;
    margin: 0 auto;
}
.bootstrap-datetimepicker-widget{
	z-index:10000 !important;
}
</style>
</style>
<div class="wrapper-md">
<div class="panel-body float-left padding-0" style=" width: 100%;">
<div class="row">
<div class="col-sm-12 col-md-12 col-lg-12 ">
<fieldset>
<legend>Are you sure ? </legend>

<div class="form-group" ng-if="screenNames=='receipt'">
<!-- <label class="col-md-4 control-label line-height-30">Receipt
Date<span style="color: red;"> *</span>
</label> -->
<!-- <div class="col-md-7">
 --><!-- <div class="dropdown">
														<a class="dropdown-toggle" id="receipt_date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Receipt Date" 
																	data-ng-model="objCBReceipt.cbReceiptDate" validation="date_euro_long|required" 
																	friendly-name="Receipt Date" />
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker data-ng-model="objCBReceipt.cbReceiptDate" data-on-set-time="objCBReceipt.cbReceiptDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#receipt_date',startView:'day', minView:'day'}" />
														</ul>
													</div> -->
													
													
													
														<div class="form-group ">
								<label class="col-md-4 control-label">Receipt
Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="objCBReceipt.cbReceiptDate"
										id="receipt_date" name="Receipt Date"
										data-ng-change="checkDatesCL(objCBReceipt.cbReceiptDate)"
										friendly-name="Receipt Date" validation="required" />
								</div>
								</div>
</div>
<!-- </div>
 --><!-- <div class="form-group" ng-if="screenNames=='DebitNote'">
<label class="col-md-4 control-label line-height-30">Debit Note
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-6">
<div class="dropdown">
														<a class="dropdown-toggle" id="debit_date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="debitDate" 
																	data-ng-model="debitNoteBean.debitDate" validation="date_euro_long|required" 
																	friendly-name="debitDate" />
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker data-ng-model="debitNoteBean.debitDate" data-on-set-time="debitNoteBean.debitDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#receipt_date',startView:'day', minView:'day'}" />
														</ul>
													</div>
</div>
</div> -->

<div class="form-group "  ng-if="screenNames=='DebitNote'">
								<label class="col-md-5 control-label">Debit Note <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="debitNoteBean.debitDate"
										id="debitDate" name="debitDate"
										data-ng-change="checkDatesCL(debitNoteBean.debitDate)"
										friendly-name="Receipt Date" validation="required" />
								</div>
								</div>
<div class="form-group" ng-if="screenNames=='payment'">
<label class="col-md-5 control-label">Payment
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-7">
<!-- <div class="dropdown">
														<a class="dropdown-toggle" id="receipt_date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Receipt Date" 
																	data-ng-model="objCBPayment.cbPaymenttDate" validation="date_euro_long|required" 
																	friendly-name="Payment Date" />
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker data-ng-model="objCBPayment.cbPaymenttDate" data-on-set-time="objCBPayment.cbPaymenttDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#receipt_date',startView:'day', minView:'day'}" />
														</ul>
													</div> -->
													
													
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="objCBPayment.cbPaymenttDate"
										id="paymentdate" name="Payment Date"
										data-ng-change="checkDatesCL(objCBPayment.cbPaymenttDate)"
										friendly-name="Payment Date" validation="required" />
</div>
</div>


<div class="form-group" ng-if="screenNames=='purchaseinvoice'">
<label class="col-md-2 control-label line-height-30">Invoice
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">
<div class="input-group input-append date">
<input type="text" class="form-control input-sm"
name="Inovoice Date" id="txtPinReverseDate"
ng-model="pinReverseObj.puchaseInvoiceDate"
placeholder='dd/mm/yyyy' /> <span
class="input-group-addon add-on"> <span
class="glyphicon glyphicon-calendar"></span>
</span>
</div>
</div>
</div>
<div class="form-group" ng-if="screenNames=='journalvoucher'">
<label class="col-md-1 control-label line-height-30">JV
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">
<div class="input-group input-append date">
<input type="text" class="form-control input-sm" name="JV Date"
id="txtJvReverseDate" ng-model="jvReverseObj.dataOfIssue"
placeholder='dd/mm/yyyy' />

<!-- <input type="text" class="form-control input-sm" name="JV Date" id="txtJvReverseDate"
ng-model="jvReverseObj.dataOfIssue" placeholder='dd/mm/yyyy' /> -->
<span class="input-group-addon add-on"> <span
class="glyphicon glyphicon-calendar"></span>
</span>
</div>
</div>
<div class="form-group">
<label class="col-md-1 control-label line-height-30">Remarks<span
style="color: red;">*</span></label>
<!-- <label for="inputPassword" class="control-label col-md-6 col-lg-6">Narration<span style="color: red;">*</span></label> -->
<div class="col-md-6">
<textarea id="txtNarration" ng-model="jvReverseObj.narration"
name="Narration" friendly-name="Narration"
validation="required"
class="form-control input-sm journalVoucher-textBox" rows="1.5"></textarea>
</div>
</div>
</div>
<div class="form-group" ng-if="screenNames=='approvalDialog'">
<label class="col-md-2 control-label line-height-30">Approval
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">
<div class="input-group input-append date" id="approval_Date">
<input type="text" class="form-control input-sm"
name="Approval Date" id="approvalDate"
ng-model="prepaidExp.approvalDate" placeholder='dd/mm/yyyy' />
<span class="input-group-addon add-on"> <span
class="glyphicon glyphicon-calendar"></span>
</span>
</div>
</div>
</div>
<div class="form-group" ng-if="screenNames=='lpo'">
<label class="col-md-2 control-label line-height-30">LPO
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">
<div class="input-group input-append date">
<input type="text" class="form-control input-sm" name="LPO Date"
id="txtLpoReverseDate" ng-model="lpoData.lpoDate"
placeholder='dd/mm/yyyy' /> <span
class="input-group-addon add-on"> <span
class="glyphicon glyphicon-calendar"></span>
</span>
</div>
</div>
</div>
<div class="form-group" ng-if="screenNames=='pcn'">
<label class="col-md-2 control-label line-height-30">PCN
Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">
<div class="input-group input-append date">
<input type="text" class="form-control input-sm" name="PCN Date"
id="txtpcnDate" ng-model="pcnData.pcnDate"
placeholder='dd/mm/yyyy' /> <span
class="input-group-addon add-on"> <span
class="glyphicon glyphicon-calendar"></span>
</span>
</div>
</div>
</div>

<div class="form-group" ng-if="screenNames=='provisionalinvoice'">
<label class="col-md-2 control-label line-height-30">Prov
Inv Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">

<ng-bs3-datepicker data-ng-model="provDateobj.dateOfIssue" />

</div>
</div>



<!-- <div class="form-group" ng-if="screenNames=='freightinvoice'">
<label class="col-md-2 control-label line-height-30">Freight
Inv Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">

<ng-bs3-datepicker data-ng-model="FreightDateobj.dateOfIssue" />

</div>
</div> -->


<!-- <div class="form-group" ng-if="screenNames=='importinvoice'">
<label class="col-md-2 control-label line-height-30">Import
Inv Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">

<ng-bs3-datepicker data-ng-model="FreightDateobj.dateOfIssue" />

</div>
</div>
-->

<div class="col-md-12">
<!-- <div class="form-group">
<label class="col-md-4 control-label">Customer Tax No </label>
<div class="col-md-6">
<input type="text" class="form-control input-sm "
ng-model="FreightDateobj.custaxnum"
name=" custaxnum" id="custaxnum"
friendly-name="custaxnum" />
</div>
</div> -->
</div>
<br>
<br>
<div class="col-md-12" ng-if="screenNames=='importinvoice'">
<div class="form-group">
<label class="col-md-4 control-label">Consignee Name </label>
<div class="col-md-6">
<!-- <input type="text" class="form-control input-sm text-right"
ng-model="FreightDateobj.consignee"
name="consignee" id="consignee"
friendly-name="consignee" /> -->


<selectivity list="consigneeList"
ng-model="FreightDateobj.consignee" friendly-name="consignee"
property="FreightDateobj.consignee" id="consignee" disabled="value"
name="consignee" form-name="blForm"></selectivity>

<!-- <input class="form-control" type="text" placeholder="" class="form-control input-sm" id="consignee"
friendly-name="Consignee Name" ng-model="FreightDateobj.consignee" name="consignee" form-name="blForm"

typeahead="ac.text as ac.text for ac in consigneeList| filter:$viewValue |limitTo:50 "
typeahead-min-length='1'
typeahead-input-formatter="fetchSelectedConsigneeName($model,invoiceData)"
validation="required"
> -->
</div>
</div>
</div>

<br>
<br>
<div class="col-md-12" ng-if="screenNames=='importinvoice'">
<div class="form-group">
<label class="col-md-4 control-label">Consignee Details </label>
<div class="col-md-6">

<textarea type="text" class="form-control input-sm"
name="consignee"
class="custom-scroll width_250 resize-none" rows="3"
ng-model="FreightDateobj.consigneeDetails" disabled>
</textarea>


</div>
</div>
</div>





<div class="form-group" ng-if="screenNames=='singleinvoice'">
<label class="col-md-2 control-label line-height-30">Single
Inv Date<span style="color: red;"> *</span>
</label>
<div class="col-md-3">

<ng-bs3-datepicker data-ng-model="SingleDateobj.dateOfIssue" />

</div>
</div>
</div>

</div>
</div>
<div class="row">
<div class="col-sm-12 col-md-12 col-lg-12">
<div class="form-actions m-b-none">
<button class="btn btn-info" type="button"
ng-click="reverseConfirm()">OK</button>
<button class="btn btn-danger" ng-click="closeCBPReverseDialog()">Cancel</button>
</div>
</div>
</div>
</div>
</div>