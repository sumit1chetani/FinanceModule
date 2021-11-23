<style>
.remarks-td{
	  padding: 0px 0px !important;
}
.input-remarks{
	height: 28px !important;
}

.brk{
width:120px;
     display:block;
    word-break:break-all;
}

</style>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
    <form name="paymentInformationForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">


		<div class="col-sm-12">
			<fieldset>
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">From Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="fromDate">
          					<input type="text" class="form-control " name="piFromDate" id="piFromDate" ng-model="paymentInformation.piFromDate" placeholder='dd/mm/yyyy' />
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
         					</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">To Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="toDate">
          					<input type="text" class="form-control " name="piToDate" id="piToDate" ng-model="paymentInformation.piToDate" placeholder='dd/mm/yyyy' />
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
         					</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Mode<span style="color: red">*</span></label>
						<div class="col-md-7">
							<!-- <select class="form-control input-sm input-sm" id="supplierCode" name="supplierCode"
								ng-model="paymentInformation.supplierCode"
								data-ng-options="r.supplierCode as r.supplierName for r in supplierList">
								<option value="" selected="selected">Select</option>
							</select> -->
							<selectivity list="modeList" property="paymentInformation.mode" ng-model="paymentInformation.mode" id="mode_id" name="mode" object="mode" validation="required"
												friendly-name="Mode" form-name="paymentInformationForm"></selectivity>
						</div>
					</div>
				</div>
			</fieldset>
			<fieldset>
			<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Supplier</label>
						<div class="col-md-7">
							<!-- <select class="form-control input-sm input-sm" id="supplierCode" name="supplierCode"
								ng-model="paymentInformation.supplierCode"
								data-ng-options="r.supplierCode as r.supplierName for r in supplierList">
								<option value="" selected="selected">Select</option>
							</select> -->
							<selectivity list="supplierList" property="paymentInformation.supplierCode" id="supplier_id" object="supplier"></selectivity>
						</div>
					</div>
				</div>
			<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Advance To Supplier</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="outAmount" name="outAmount"
								ng-model="paymentInformation.outAmount" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Trade Creditors</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="outAmount1" name="outAmount1"
								ng-model="paymentInformation.outAmount1" readonly/>
						</div>
					</div>
				</div>
				
				</fieldset>
		</div>
	</div>

		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-success" type="button" ng-click="onSubmit(paymentInformationForm,paymentInformation)">Submit</button>
					<button class="btn btn-info" ng-click="resetForm()" type="button">Reset</button>
					<button class="btn btn-info" type="button"
						data-ng-click="unallocatedAdvance();">
						Unallocated Advance
					</button>
				</div>
			</div>
		</div>
	</form>
  </div>
  
  <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive" >
  
   <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
        <th class="width_1"><!--<label class="width_1 i-checks m-b-none"> <input type="checkbox" ng-model="select" id="select" ng-change="SelectAll(select)"><i></i></label> --></th>
       <th class="sorting width_9 padding-both-side-5" st-sort="Supplier">Supplier</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="InvNo">Invoice No</th>
       <th class="sorting width_7 padding-both-side-8" st-sort="InvDt">Invoice Date</th>
       <th class="sorting width_3 padding-both-side-5" >Currency</th>
       <th class="sorting width_3 padding-both-side-5" >Ex-Rate</th>
       <th class="sorting width_5 padding-both-side-5" st-sort="InvAmount">Amount</th>
       <!-- <th class="sorting width_5 padding-both-side-5" st-sort="PayableAmount">Payable Amount</th> -->
       <th class="sorting width_7 padding-both-side-5" st-sort="PayAmount">Pay TC Amount</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="PayAmount">Pay BC Amount</th>
      </tr>
      
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objPaymentInformationItem) in displayedCollection">
       <td><label class="width_1 i-checks m-b-none"> <input type="checkbox" ng-model="objPaymentInformationItem.select" id="select{{trIndex}}" ng-change="checkMultiSupplier()"><i></i></label></td>
       <td  tooltip="{{objPaymentInformationItem.supplierName}}" class="width_9 tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.customerName">
       </td>
       
       <td tooltip="{{objPaymentInformationItem.invoiceNo}}" class="width_7 tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.invoiceNumber">
       </td>
       <td  tooltip="{{objPaymentInformationItem.invoiceDate}}" class="width_8 tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.invoiceDt">
       </td>
       <td tooltip="{{objPaymentInformationItem.currency}}" class="width_3 tool-tip-span" ng-bind="objPaymentInformationItem.currencyName">
       </td>
       <td tooltip="{{objPaymentInformationItem.exchangeRate}}" class="width_3 tool-tip-span" ng-bind="objPaymentInformationItem.exchangeRate">
       </td>
       <td  tooltip="{{objPaymentInformationItem.tcAmount}}" class="width_5 tool-tip-span" ng-bind="objPaymentInformationItem.amount">
       </td>
       
       <!-- <td  tooltip="{{objPaymentInformationItem.pendingAmount}}" class="width_5 tool-tip-span" ng-bind="objPaymentInformationItem.payamount">
       </td> -->
        <td class="width_7">
        <input type="text" class="form-control input-sm input-remarks padding-both-side-2" name="payTCAmount{{trIndex}}" id="payTCAmount{{trIndex}}"   ng-model="objPaymentInformationItem.payTCAmount"
        ng-keyup="calculateBCAmount(objPaymentInformationItem,objPaymentInformationItem.payTCAmount)" />
       	</td>
        <td class="width_7">
        <input type="text" class="form-control input-sm input-remarks padding-both-side-2" name="payAmount{{trIndex}}" id="payAmount{{trIndex}}"   ng-model="objPaymentInformationItem.payAmount" 
        ng-keyup="calculateTCAmount(objPaymentInformationItem,objPaymentInformationItem.payAmount)"/>
       	</td>
      
      </tr>
     </tbody>
    </table>
    <br>
    <div class="padding-right-5">
      		<div class="col-md-6">
          		  
          	</div>
          	<div class="col-md-6">
					<div class="form-group">
					<div class="col-md-3"></div>
					<div class="col-md-3">
					<label class="col-md-6 control-label ">Total
					</label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control input-sm" ng-model="totalTCAmount" readonly
						name="TC Total" placeholder="0.0">
					</div>

					<div class="col-md-3">
						<input type="text" class="form-control input-sm" ng-model="totalBCAmount" readonly
						name="BC Total" placeholder="0.0">
					</div>

				</div>
			</div>
    </div>
   </div>
  
  <%-- <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer> --%>
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" ng-click="savePaymentInformation(displayedCollection)"  type="button">Save</button>
   					<button class="btn btn-danger" ng-click="cancel()"  type="button">Cancel</button>
   				</div>
   			</div>
   	</div>
  </div>
 </div>
</div>