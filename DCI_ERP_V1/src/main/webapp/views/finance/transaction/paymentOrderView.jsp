<style>
.brk{
width:120px;
     display:block;
    word-break:break-all;
}

</style>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}
</style>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
    <form name="jvAccountForm" class="form-horizontal" >
    <div class="row book-widget-row">


		<div class="col-sm-12">
			<fieldset>
				<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Payment Order No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" id="paymentOrderNo" name="paymentOrderNo"
								ng-model="paymentOrder.paymentOrderNo" readonly/>
								
							</div>
						</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Payment Order Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="paymentOrderDate">
          						<input type="text" class="form-control " name="paymentOrderDate" id="paymentOrderDate" ng-model="paymentOrder.paymentOrderDate" placeholder='dd/mm/yyyy' readonly />
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
          					</div>
						</div>
						
						
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Supplier</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="supplier" name="supplier"
								ng-model="paymentOrder.supplierName" readonly/>
						</div>
					</div>
				</div>
				

			</fieldset>
			<fieldset>
			
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Status</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="supplier" name="supplier"
								ng-model="paymentOrder.status" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Advance To Supplier</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="outAmount" name="outAmount"
								ng-model="paymentOrder.outAmount" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Trade Creditors</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="outAmount1" name="outAmount1"
								ng-model="paymentOrder.outAmount1" readonly/>
						</div>
					</div>
				</div>
			</fieldset>
		</div>

	</div>
      
      <br>
      <div class="table-responsive" >
      	<table class="table table-striped b-t b-light">
        	<thead>
          		<tr>
		            <th class="width_9 text-center v-middle">Due Date</th>
		            <th class=" width_10 text-center v-middle">Party Inv. No.</th>
		            <th class="width_9 text-center v-middle">Party Inv. Dt.</th>
		            <th class="width_10 text-center">Invoice No</th>
		            <th class="width_9 text-center v-middle">Invoice Date</th>
		            <th class="width_7 text-center v-middle">Currency</th>
		             <th class="width_7 text-center v-middle">Ex-Rate</th>
		            <th class="width_9 text-center v-middle">Inv TC Amount </th>
		            <th class="width_9 text-center v-middle">Inv BC Amount </th>
		            <th class="width_12 text-center v-middle">Payable Amount</th>
		            <th class="width_12 text-center v-middle">Pay TC Amount</th>
		            <th class="width_12 text-center v-middle">Pay BC Amount</th>
          		</tr>
          		
       		</thead>
       		
        	<tbody ng-repeat="(trIndex,objPaymentdetailRow) in paymentOrder.detailList">
         	<tr>
         		 
         		<td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.dueDate"></span></td>
         		<td><span class="brk tool-tip-span"  ng-bind="objPaymentdetailRow.partyInvoiceNo"></span></td>
         		<td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.partyInvoiceDate"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.invoiceNo"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.invoiceDate"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.currency"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.exchangeRate"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.tcAmount"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.bcAmount"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.pendingAmount"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.payTCAmount"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.payAmount"></span></td>
         	</tr>
         	</tbody>
        
      </table>
      
      	<div class="padding-right-5">
      		<div class="col-md-4">
          		 
          	</div>
          	<div class="col-md-12" ng-repeat="(trIndex,rowTotal) in listTotalAmtGroupByCurr">
					<div class="form-group pull-right">
						<label class="col-md-2 control-label bold">Total {{rowTotal.currency}} :</label>
						<label class="col-md-2 control-label">TC Amount</label>
						<div class="col-md-3">
								<input type="text" class="form-control input-sm" id="totalTCAmount" name="totalTCAmount"
									ng-model="rowTotal.payTCAmount" readonly>
						</div>
						<label class="col-md-2 control-label">BC Amount</label>
						<div class="col-md-3">
								<input type="text" class="form-control input-sm" id="totalBCAmount" name="totalBCAmount"
									ng-model="rowTotal.payAmount" readonly>
						</div>
					</div>
			</div>
        </div>
        
       
      </div>
      
      <div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-danger" ng-click="close()" type="button">
           <i class="fa fa-close"></i>
           Close
          </button>
           <button class="btn btn-success" ng-click="printPaymentInfoDiv(paymentOrder.paymentOrderNo)"  type="button">
        	  Print
          </button>
            <button  class="btn btn-primary"
            id="exportXl"   data-ng-click="excel(paymentOrder.paymentOrderNo);"
            type="button">
            <i class="fa fa-print"></i> Export Excel
            </button>
             <security:authorize access="hasRole('F0257_${approve}')">
            <button ng-if="paymentOrder.status == 'Pending'" class="btn btn-info" ng-click="approvePaymentInformation(paymentOrder.paymentOrderNo)"  type="button">
        	  Approve
          	</button>
          </security:authorize>
         </div>
        </div>
      </div>
	<!-- sub table Ends -->
   </form>
  </div>
 </div>
</div>
