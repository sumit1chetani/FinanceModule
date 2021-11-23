 <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 75%;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
      Cash Denomination
      </h2>
     </header>
    
      <div class="col-md-12">
        	<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
				<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
				<thead class="dataTables-Main-Head">
		          <tr>
		          		            <th colspan="1" class="sorting width_1"></th>
		          
		            <th colspan="1" class="visible-left sorting width_5 text-center">CB Pmt Dtl Id</th>
		            <th colspan="1" class="sorting width_13 text-center">Denomination<span style="color:red;"> *</span></th>
		            <th colspan="1" class="sorting width_13 text-center">Count</th>
                        <th colspan="1" class="sorting width_8 text-center">Rupees</th>
  
		          </tr>
		        </thead>
		        <!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->
		        <tbody ng-repeat="(trIndex, row) in cashbankpaymentModelData.cbptablescash" ng-controller="tableCtrl">
		        
		        	<tr>
			            <td><label class="i-checks m-b-none"> <input type="checkbox" 
			            ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>  
			            <td class="visible-left"><div class="row"><div class="col-xs-12">
			            	<input type="text" class="form-control" id="cashBankPmtDtlId" ng-model="row.cashBankPmtDtlId" value="" />
			            </div></div></td>
			            <td class="padding-both-side-2">
			            <div class="row">
				           		<div class="col-xs-10" ng-if="!row.isInvoiceNo">
				        	  		<input type="text" class="form-control input-sm" name="denomAmt" data-ng-model="row.denomAmt"
				        	  		validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt= Amount Should be 2 digit|required"  step="0.01"  required />
				             	</div>
				             	<div class="col-xs-12" ng-if="row.isInvoiceNo">
				             		<input type="text" class="form-control input-sm" name="denomAmt" data-ng-model="row.denomAmt"
				        	  		validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt= Amount Should be 2 digit|required"  step="0.01"  ng-disabled="true" required />
				             	</div>
				            </div>
			        	</td>
			        	<!-- Sub Account Code -->
			        	<td class="padding-both-side-2">
			            	<div class="row">
				           		<div class="col-xs-10" ng-if="!row.isInvoiceNo">
				        	  		<input type="text" class="form-control input-sm" name="countamt" data-ng-model="row.countamt"
				        	  		validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt= Amount Should be 2 digit|required"  step="0.01" ng-blur="calculateTotalAmountCash(row.countamt,trIndex,row)" required />
				             	</div>
				             	<div class="col-xs-12" ng-if="row.isInvoiceNo">
				             		<input type="text" class="form-control input-sm" name="countamt" data-ng-model="row.countamt"
				        	  		validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt= Amount Should be 2 digit|required"  step="0.01" ng-blur="calculateTotalAmountCash(row.countamt,trIndex,row)" ng-disabled="true" required />
				             	</div>
				            </div>
			        	</td>
			            <td>
				           	<div class="row">
				           		<div class="col-xs-10" ng-if="!row.isInvoiceNo">
				        	  		<input type="text" class="form-control input-sm" name="rupessAmt" data-ng-model="row.rupessAmt"
				        	  		validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount Should be 2 digit|required"  step="0.01"  					      
				        	  		   	ng-keyup="calculateAHAmount(cashbankpaymentModelData.cbptablescash)"
				        	  		 required />
				             	</div>
				             	<div class="col-xs-12" ng-if="row.isInvoiceNo">
				             		<input type="text" class="form-control input-sm" name="rupessAmt" data-ng-model="row.rupessAmt"
				        	  		validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt= Amount Should be 2 digit|required"  step="0.01"  					    
				        	  		     	ng-keyup="calculateAHAmount(cashbankpaymentModelData.cbptablescash)"
				        	  		ng-disabled="true" required />
				             	</div>
				            </div>
			            </td>
			            
			            
			    
	           
			         
			            <td class="visible-left">
			            	<input type="hidden" ng-model="row.invoicePaymentList" />
			            </td>
			           </tr>
			           <tr>
			        	             	
			       </tr> 
		      	</tbody>
		      </table>
			     <div class="padding-right-5" id="AddOrRmvebtn">
			      
			      
			           <button ng-click="addProdRow(cashbankpaymentModelData.cbptablescash)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
			            <i class="fa fa-plus"></i>
			           </button>
			           <button ng-click="removeProdRow(cashbankpaymentModelData.cbptablescash)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
			            <i class="fa  fa-trash-o"></i>
			           </button>
<div class="form-group pull-right">
					        <label class="col-md-3 control-label">Total Amount</label>
					        <div class="col-md-6">
					         	<input type="text" class="form-control input-sm" name="totalCashAmount" 
					         	data-ng-model="cashbankpaymentModelData.totalCashAmount"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" readonly />
					        </div>
<!-- 					        <label class="col-md-3 control-label">Total TC Amt</label>
 -->					       <!--  <div class="col-md-3">
					         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="cbpmtDtlTotalAmt.totalTCAmount"
				         	  			 ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div> -->
				       </div>			     </div> <!-- /padding-right-5 - /AddOrRmvebtn -->
			     <div class="row">
					<div class="col-sm-12">
						
					</div>
				</div>
		 	</div>    <!-- /table-responsive -->
		 	<div class="form-actions">
		     	      
		          <button class="btn btn-success" type="button" ng-if="!edit" 
		          data-ng-click="ok()" >
		           OK
		          </button>
		          <button class="btn btn-success" type="button" ng-if="edit" data-ng-click="okedit()" >
		           <i class="fa fa-save"></i>
		           Ok
		          </button>
		          
		          
		         <!--  <button class="btn btn-danger" data-ng-click="cancel()" type="button">
		           <i class="fa fa-close"></i>
		           Cancel
		          </button>
		      -->
		 	</div>
		</div>
       <!-- end widget content -->
     </div> <!--/standard-datatable-widget -->
   </article> <!-- WIDGET END -->
  </div>
 </section>
</div>
