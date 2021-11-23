<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}

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
    <form name="jvAccountForm" class="form-horizontal" >
    <div class="row book-widget-row">


		<div class="col-sm-12">
			<fieldset>
				<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Payment Order No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" id="paymentOrderNo" name="paymentOrderNo"
								ng-model="paymentOrder.paymentInformationNo" readonly/>
								
							</div>
						</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Payment Order Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="paymentOrderDate">
          					<input type="text" class="form-control " name="paymentOrderDate" id="paymentOrderDate" ng-model="paymentOrder.paymentInformationDate" placeholder='dd/mm/yyyy' readonly />
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
		            
		            <th class="width_9">Invoice No</th>
		            <th class="width_9 ">Invoice Date</th>
		            <th class="width_7 ">Currency</th>
		            <th class="width_7 ">Ex-Rate</th>
		            <th class="width_10 ">Pay TC Amount</th>
		            <th class="width_10 ">Pay BC Amount</th>
          		</tr>
          		
       		</thead>
       		
        	<tbody ng-repeat="(trIndex,objPaymentdetailRow) in paymentOrder.lDetaillist">
         	<tr>
         		 
   		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.invoiceNo"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.invoiceDate"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.currency"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="objPaymentdetailRow.exchangeRate"></span></td>
		        <td><input type="text" class="form-control input-sm"  ng-keyup="calculateBCAmount(objPaymentdetailRow,paymentOrder.detailList)" ng-model="objPaymentdetailRow.payTCAmount"/></td>
		        <td><input type="text" class="form-control input-sm"  ng-keyup="calculateTCAmount(objPaymentdetailRow,paymentOrder.detailList)" ng-model="objPaymentdetailRow.payAmount"/></td>
         	</tr>
         	</tbody>
        
      </table>
      
      	<div class="padding-right-5">
      		<div class="col-md-4">
          		 
          	</div>
          	<div class="col-md-8">
					<div class="form-group pull-right">
						<label class="col-md-2 control-label">Total TC</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm" id="totalTCAmount" name="totalTCAmount"
									ng-model="totalTCAmount" readonly>
						</div>
						
						<label class="col-md-2 control-label">Total BC</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm" id="totalBCAmount" name="totalBCAmount"
									ng-model="totalBCAmount" readonly>
						</div>
					</div>
			</div>
        </div>
        
       
      </div>
      
      <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" ng-click="update(paymentOrder)"  type="button">Update</button>
   					<button class="btn btn-danger" ng-click="cancel()"  type="button">Cancel</button>
   				</div>
   			</div>
   	</div>
	<!-- sub table Ends -->
   </form>
  </div>
 </div>
</div>
