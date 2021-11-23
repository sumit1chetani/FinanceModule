<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form name="customerinvoiceForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
      <div class="col-sm-4">
        <!-- <div class="form-group">
				<label class="col-md-4 control-label p-l-0"> Company
					<span style="color: red;">*</span>
				</label>
				<div class="col-md-8">
					<selectivity ng-if="edit" disabled="edit" list="companyList" ng-model="customerinvoice.companyCode" property="customerinvoice.companyCode" 
					id="company_id" object="company" name="company_id"
					validation="required" friendly-name="Company" form-name = "creditNoteForm" disabled=true></selectivity>
				</div>
				<div class="col-md-8">
					<selectivity ng-if="!edit" list="companyList" ng-model="customerinvoice.companyCode" property="customerinvoice.companyCode" 
					id="company_id" object="company" name="company_id"
					validation="required" friendly-name="Company" form-name = "creditNoteForm" disabled=true></selectivity>
				</div>
			</div> -->
			
			<div class="form-group ">
		        <label class="col-md-4 control-label">Invoice No. <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			       <input type="text" class="form-control input-sm" id="invNo" 
		         	name="invNo" validation="required" friendly-name="Invoice No"
		         	ng-model="customerinvoice.invoiceNo" disabled="disabled"/>
		        </div>
	       	</div>	
	       	
	       	 <div class="form-group">
		        <label class="col-md-4 control-label">Inv Date<span style="color:red;"> *</span></label>
		        <div class="col-md-8">
				     <ng-bs3-datepicker data-ng-model="customerinvoice.invDate" id="invDate" name="invDate" form-name="cashbankpaymentForm"
             friendly-name="Invoice Date" validation="required"/>
        
				</div>
	     	</div>
	       	
		<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">Customer <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="customerList" property="customerinvoice.customerCode" id="customerCode" object="customerCode" name="customerCode"
			        ng-model="customerinvoice.customerCode"  friendly-name="Customer" form-name = "customerinvoiceForm" validation="required"></selectivity>
		        </div>
	       	</div> 
	       	
	       	<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">TRIP No. <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="tripsList" property="customerinvoice.tripCode" id="tripCode" object="tripCode" name="tripCode"
			        ng-model="customerinvoice.tripCode"  friendly-name="Trip No" form-name = "customerinvoiceForm" validation="required"></selectivity>
		        </div>
	       	</div> 
	       	
      
      </div>
       <div class="col-sm-4">
       
	    <!-- <div class="form-group ">
		        <label class="col-md-4 control-label">Manual Invoice No.</label>
		        <div class="col-md-8">
			        <selectivity list="blList" property="customerinvoice.blNo" id="vessel" object="blNo" name="blNo"
			        ng-model="customerinvoice.blNo" validation="required" friendly-name="blNo" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>	 -->
	       	
	<div class="form-group ">
		        <label class="col-md-4 control-label">Currency<span style="color:red;"> *</span></label>
		        <div class="col-md-8">
		        	<selectivity list="currencyList" property="customerinvoice.currency" name="Currency"  
											id="currency" object="currency" validation="required" friendly-name="Currency" form-name = ""
											ng-model="customerinvoice.currency" disabled="isCurrencyBlocked"></selectivity>
		        </div>
	       	</div>
	       	
	       		       	 
	    <div class="form-group">
		        <label class="col-md-4 control-label">Ex Rate<span style="color:red;"> *</span></label>
		        <div class="col-md-8">
		         	<input type="text" class="form-control input-sm text-right" id="exchangeRate" 
		         	name="exchangeRate" validation="required" friendly-name="Exchange Rate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
		         	ng-model="customerinvoice.exchangeRate" ng-change="calculateTotalAmount(customerinvoice.GIDtl)" />
		        </div>
	       </div>
	     	
	     	<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">Work Order No </label>
		        <div class="col-md-8">
			       <input type="text" class="form-control input-sm" id="workNo" 
		         	name="workNo" disabled="disabled"
		         	ng-model="customerinvoice.workNo" />
		        </div>
	       	</div>
	       	
       	  <div class="form-group">
		        <label class="col-md-4 control-label">Remarks</label>
		        <div class="col-md-8">
		       	 	<textarea ng-model="customerinvoice.remarks" id="remarks" rows="2" class="form-control"></textarea>
		        </div>
	       </div>
	       	
	    	
	       	   		
       </div>
        <div class="col-sm-4">
       
	       	 <!-- <div class="form-group ">
		        <label class="col-md-4 control-label">BC Amt<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm text-right" id="totalBCFee" name="totalBCFee"
		        	ng-model="customerinvoice.totalBCFee"  validation="required" friendly-name="Total BCFee"  />
		        </div>
	       	</div> 
	       	
	        <div class="form-group ">
		      <label class="col-md-4 control-label">TC Amt<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm text-right" id="feeRate" name="totalTCFee"
		        	ng-model="customerinvoice.totalTCFee"  validation="required" friendly-name="Total TCFee"  />
		        </div>
	       	</div>	 -->
	       	
       		<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">LOL </label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm" id="pol" 
		         	name="pol" disabled="disabled"
		         	ng-model="customerinvoice.pol" />
		        </div>
	       	</div> 
	       	
	       	<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">LOD </label>
		        <div class="col-md-8">
			       <input type="text" class="form-control input-sm" id="pod" 
		         	name="pod" disabled="disabled"
		         	ng-model="customerinvoice.pod" />
		        </div>
	       	</div> 
	       	
	       	<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">Truck No </label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm" id="truckNo" 
		         	name="truckNo" disabled="disabled"
		         	ng-model="customerinvoice.truckNo" />
		        </div>
	       	</div> 
	       	
	       	<div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">Trailer No </label>
		        <div class="col-md-8">
			       <input type="text" class="form-control input-sm" id="trailerNo" 
		         	name="trailerNo" disabled="disabled"
		         	ng-model="customerinvoice.trailerNo" />
		        </div>
	       	</div> 
	       			
	       	  	
        </div>
        
         
         
<!-- 	    <div class="col-sm-12">
	       	<div class="form-group col-sm-3">
		        <label class="col-md-4 control-label">TC Amt<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm" id="feeRate" name="totalTCFee"
		        	ng-model="customerinvoice.totalTCFee"  validation="required" friendly-name="Total TCFee" readonly />
		        </div>
	       	</div>	       	
	    </div> -->
    </div>
   </div>
   <div class="row"></div><br/><br/>
    <div class="table-responsive clear">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <th colspan=1 class="width_1"></th>
            <th colspan=1 class="width_13 text-center">Container Type</th>
            <th colspan=1 class="width_10 text-center">Container Size</th>
<!--             <th colspan=1 class=" width_10 text-center">Quantity</th> -->
            <th colspan=1 class=" width_10 text-center">Container No.</th>
            <th colspan=1 class=" width_10 text-center">Quotation</th>
            <th colspan=1 class=" width_10 text-center">Rate Per Unit</th>
            <th colspan=1 class=" width_10 text-center">Amount</th>
            <th colspan=1 class=" width_10 text-center">VAT (%)</th>
            <th colspan=1 class=" width_10 text-center">VAT Amount</th>
            <th colspan=1 class=" width_10 text-center">Total Amount</th>
            <th colspan=1 class="width_1"></th>
          </tr>
          
        </thead>
        <tbody ng-repeat="(trIndex, row) in customerinvoice.GIDtl">
        	<tr>
	            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}" 
	             ng-change="calculateTotalAmount(customerinvoice.GIDtl)"><i></i></label></td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
							<input type="text" class="form-control input-sm" ng-model="row.contType" name ="contType{{$index}}" id="contType{{$index}}"  disabled="disabled" />
	        			</div>
	        		</div>
	        	</td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
							<input type="text" class="form-control input-sm" ng-model="row.contSize" name ="contSize{{$index}}" id="contSize{{$index}}"  disabled="disabled"  />
	        			</div>
	        		</div>
	        	</td>
	        	
<!-- 	        	 <td class="width_10"> -->
<!-- 	          		<div class="row" > -->
<!-- 	            		<div class="col-xs-12"> -->
<!-- 	         	  			<input type="text" class="form-control input-sm text-right" ng-model="row.quantity" name ="quantity{{$index}}" id="quantity{{$index}}"  disabled="disabled" /> -->
<!-- 	              		</div> -->
<!-- 	              	</div> -->
<!-- 	            </td> -->
	            
	             <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm text-right" ng-model="row.containerNo" name ="quantity{{$index}}" id="containerNo{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td>
	            
	            <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm" ng-model="row.quotNo" name ="quotNo{{$index}}" id="quotNo{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td>
	            
              <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm text-right" ng-model="row.amount" name ="quotAmount{{$index}}" id="quotAmount{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td>
	            
	            <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm text-right" ng-model="row.amount" name ="amount{{$index}}" id="amount{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td>
	            
	            <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm text-right" ng-model="row.vatPerc" name ="vatPerc{{$index}}" id="vatPerc{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td>
	            
              <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm text-right" ng-model="row.vatAmount" name ="vatAmount{{$index}}" id="vatAmount{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td>
	            
	            <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm text-right" ng-model="row.totalAmount" name ="totalAmount{{$index}}" id="totalAmount{{$index}}"  disabled="disabled" />
	              		</div>
	              	</div>
	            </td> 
	            
	           <!--  <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm" ng-model="row.remarks" name ="remarks{{$index}}" id="remarks{{$index}}"  />
	              		</div>
	              	</div>
	            </td> -->
	           <!--  <td>
		           	<div class="row">
		           		<div class="col-xs-12">
		           		
		        	  	<input type="text" class="form-control input-sm text-right" name="TCamount{{$index}}" ng-model="row.tcamount" 
		        	  	ng-keyup="bcamountCalculation(row.tcamount,trIndex,row)" id="TCamount{{$index}}"
						validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(TC Amount)'}}"  />
		             	</div>
		            </div>
	            </td>
	            <td>
	            	<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm text-right" ng-model="row.bcamount" 
	         	  			ng-keyup="tcamountCalculation(row.bcamount,trIndex,row)" id="bcamount{{$index}}"
							name ="bcamount{{$index}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"  />
	              		</div>
	              	</div>
	            </td> -->
	            
     		</tr>     		
      	</tbody>
      </table>
      <!-- <div class="padding-right-5">
           <button ng-click="addRow(customerinvoice.GIDtl)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>
           </button>
           <button ng-click="removeRow(customerinvoice.GIDtl)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
      </div> --> <!-- /padding-right-5 - /AddOrRmvebtn -->
	</div>    <!-- /table-responsive -->
	<div class="row">
		<div class="col-sm-11">
			<div class="form-group pull-right">
		       <div class="col-sm-6">
	       			<div class="form-group">
				        <label class="col-md-5 control-label">Total TC Amnt</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="totalTCamount" data-ng-model="customerinvoice.tcAmount"
			         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
				        </div>
			        </div>
		        
		        
			         <div class="form-group">
				        <label class="col-md-5 control-label">VAT TC Amnt</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="totalTCamount" data-ng-model="customerinvoice.vatTCAmount"
			         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
				        </div>
			         </div>
			        
			         <div class="form-group">
			         	<label class="col-md-5 control-label">Grand TC Amnt</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="totalTCamount" data-ng-model="customerinvoice.totalTCamount"
			         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
				        </div>
			         </div>
		         </div>
		        
		         <div class="col-sm-6">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Total BC Amnt</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="totalBCamount" data-ng-model="customerinvoice.bcAmount"
			         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
				        </div>
			        </div>
			         <div class="form-group">
			         	<label class="col-md-5 control-label">VAT BC Amnt</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="totalBCamount" data-ng-model="customerinvoice.vatBCAmount"
			         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
				        </div>
			         </div>
			        
			         <div class="form-group">
			         	 <label class="col-md-5 control-label">Grand BC Amnt</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="totalBCamount" data-ng-model="customerinvoice.totalBCamount"
			         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
				        </div>
			         </div>
		        </div>
		  </div>
	     </div><div class="col-sm-1"></div>
	</div>
	
	 <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button id = "saveInvoice" class="btn btn-success" type="button" ng-if="!edit" ng-click="submit(customerinvoiceForm,customerinvoice)" >
           <i class="fa fa-save"></i>
           Save
          </button>
           <!-- <button id = "calculateInvoice" class="btn btn-info" type="button" ng-click="exchageratePHChdr(customerinvoice.exchangeRate)" >
           <i class="fa fa-reset"></i>
           Re-Calculate
          </button> -->
          <!-- <button class="btn btn-success" type="button" ng-if="edit" ng-click="submit()">
           <i class="fa fa-save"></i>
           Update
          </button> -->
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
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