<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form name="creditNoteForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
      <div class="col-sm-3">
        <div class="form-group">
				<label class="col-md-4 control-label p-l-0"> Company
					<span style="color: red;">*</span>
				</label>
				<div class="col-md-8">
					<selectivity ng-if="edit" disabled="edit" list="companyList" ng-model="creditnoteAcctData.companyCode" property="creditnoteAcctData.companyCode" 
					id="company_id" object="company" name="company_id"
					validation="required" friendly-name="Company" form-name = "creditNoteForm" disabled=true></selectivity>
				</div>
				<div class="col-md-8">
					<selectivity ng-if="!edit" list="companyList" ng-model="creditnoteAcctData.companyCode" property="creditnoteAcctData.companyCode" 
					id="company_id" object="company" name="company_id"
					validation="required" friendly-name="Company" form-name = "creditNoteForm" disabled=true></selectivity>
				</div>
			</div>
		<div class="form-group ">
		        <label class="col-md-4 control-label">Pol <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="portList" property="creditnoteAcctData.pol" id="vessel" object="pol" name="pol"
			        ng-model="creditnoteAcctData.pol" validation="required" friendly-name="pol" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>	
	    <div class="form-group ">
		        <label class="col-md-4 control-label">BL No. <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="blList" property="creditnoteAcctData.blNo" id="vessel" object="blNo" name="blNo"
			        ng-model="creditnoteAcctData.blNo" validation="required" friendly-name="blNo" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>	
	       	
	    <div class="form-group ">
		        <label class="col-md-4 control-label">Fee Type<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm" id="feeType" name="feeType"
		        	ng-model="creditnoteAcctData.feeType" readonly />
		        </div>
	       	</div>  
	       	
	       <div class="form-group ">
		      <label class="col-md-4 control-label">TC Amt<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm text-right" id="feeRate" name="totalTCFee"
		        	ng-model="creditnoteAcctData.totalTCFee"  validation="required" friendly-name="Total TCFee" readonly />
		        </div>
	       	</div>		       	 	    	
      
      </div>
       <div class="col-sm-3">
       <div class="form-group">
		        <label class="col-md-4 control-label">Inv Date<span style="color:red;"> *</span></label>
		        <div class="col-md-8">
					<div class="input-group input-append date" id="in_date" >
						<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" validation="required" friendly-name="Invoice Date" 
								ng-model="creditnoteAcctData.invoiceDate" name="Date" id="invoiceDate">
 									 <span class="input-group-addon add-on">
                  								<span class="glyphicon glyphicon-calendar"></span>
       								 </span>
				     </div>
				</div>
	     	</div>
	    <div class="form-group ">
		        <label class="col-md-4 control-label">Pot <span class="padding-right-10" style="color:red;">  </span></label>
		        <div class="col-md-8">
			        <selectivity list="portList" property="creditnoteAcctData.pot" id="vessel" object="pot" name="pot"
			        ng-model="creditnoteAcctData.pot" friendly-name="pot" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>  
	       	

	       	
	       		       	 
	     <div class="form-group ">
		        <label class="col-md-4 control-label">Payer	<span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="acctHeadList" property="creditnoteAcctData.accountName" id="accountName" object="accounts" name="accounts"
			        ng-model="creditnoteAcctData.accountName" validation="required" friendly-name="Payer" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>
	     	<div class="form-group ">
		        <label class="col-md-4 control-label">Rate<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm text-right" id="feeRate" name="feeRate"
		        	ng-model="creditnoteAcctData.feeRate"  validation="required" friendly-name="Fee" readonly />
		        </div>
	       	</div> 
	       	
	         <div class="form-group ">
		        <label class="col-md-4 control-label">BC Amt<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm text-right" id="totalBCFee" name="totalBCFee"
		        	ng-model="creditnoteAcctData.totalBCFee"  validation="required" friendly-name="Total BCFee" readonly />
		        </div>
	       	</div> 
	       	
	    	
	       	   		
       </div>
        <div class="col-sm-3">
        <div class="form-group ">
		        <label class="col-md-4 control-label">Vessel <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="vesselList" property="creditnoteAcctData.vessel" id="vessel" object="vessel" name="vessel"
			        ng-model="creditnoteAcctData.vessel" validation="required" friendly-name="vessel" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>
	      
	     <div class="form-group ">
		        <label class="col-md-4 control-label">Pod <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="portList" property="creditnoteAcctData.pod" id="vessel" object="pod" name="pod"
			        ng-model="creditnoteAcctData.pod" friendly-name="pod" form-name = "creditNoteForm" validation="required"></selectivity>
		        </div>
	       	</div>
	       	
	     	<div class="form-group ">
		        <label class="col-md-4 control-label">Currency<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
		        	ng-model="creditnoteAcctData.currencyCode"  validation="required" friendly-name="Currency" readonly />
		        </div>
	       	</div>  
	       	<div class="form-group">
		        <label class="col-md-4 control-label">No of Bill<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		         	<input type="text" class="form-control input-sm" id="noOfBill" ng-keyup="feeCalculation()"  name="noOfBill" validation="required" friendly-name="No Of Bill"
		         	ng-model="creditnoteAcctData.noOfBill" />
		        </div>
	       </div>		
	       	  	
        </div>
         <div class="col-sm-3">
         <div class="form-group ">
		        <label class="col-md-4 control-label">Voyage <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="voyageList" property="creditnoteAcctData.voyage" id="cmbAccountName" object="voyage" name="voyage"
			        ng-model="creditnoteAcctData.voyage" validation="required" friendly-name="voyage" form-name = "creditNoteForm"></selectivity>
		        </div>
	       	</div>
	      <div class="form-group ">
		        <label class="col-md-4 control-label p-l-0">Customer <span style="color:red;"> *</span></label>
		        <div class="col-md-8">
			        <selectivity list="mloList" property="creditnoteAcctData.customerCode" id="customerCode" object="customerCode" name="customerCode"
			        ng-model="creditnoteAcctData.customerCode"  friendly-name="Customer" form-name = "creditNoteForm" validation="required"></selectivity>
		        </div>
	       	</div> 	
	       	
	       	<div class="form-group">
		        <label class="col-md-4 control-label">Ex Rate<span style="color:red;"> *</span></label>
		        <div class="col-md-8">
		         	<input type="text" class="form-control input-sm text-right" id="exchangeRate" 
		         	name="exchangeRate" validation="required" friendly-name="Exchange Rate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
		         	ng-model="creditnoteAcctData.exchangeRate" ng-change="exchageratePHChdr(creditnoteAcctData.exchangeRate)" />
		        </div>
	       </div>
	       
             <div class="form-group ">
		        <label class="col-md-4 control-label">Leg <span class="padding-right-10" style="color:red;"></label>
		        <div class="col-md-8">
			        <input type="text" class="form-control input-sm" id="flag" name="flag"
		        	ng-model="creditnoteAcctData.flag"  friendly-name="flag" readonly />
		        </div>
	       	</div>
	       		       
	
         </div>
         
         
<!-- 	    <div class="col-sm-12">
	       	<div class="form-group col-sm-3">
		        <label class="col-md-4 control-label">TC Amt<span class="padding-right-10" style="color:red;"></span></label>
		        <div class="col-md-8">
		        	<input type="text" class="form-control input-sm" id="feeRate" name="totalTCFee"
		        	ng-model="creditnoteAcctData.totalTCFee"  validation="required" friendly-name="Total TCFee" readonly />
		        </div>
	       	</div>	       	
	    </div> -->
    </div>
   </div>
    <div class="table-responsive clear">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <th colspan=1 class="width_1"></th>
            <th colspan=1 class="width_13 text-center">Account Head<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_10 text-center">Service<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_10 text-center">Con. Type<span style="color:red;"> *</span></th>
             <th colspan=1 class="width_10 text-center">Rate<span style="color:red;"> *</span></th>
              <th colspan=1 class="width_10 text-center">No of Con.<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_10 text-center">TC Amt<span style="color:red;"> *</span></th>
            <th colspan=1 class=" width_10 text-center">BC Amt({{companyCurrency}})<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_1"></th>
          </tr>
        </thead>
        <tbody ng-repeat="(trIndex, row) in creditnoteAcctData.credittables" ng-controller="tableCtrl">
        	<tr>
	            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<selectivity list="crdtlAcctHeadList" property="row.crdtlAccountHead" id="crdtlAccountHead{{trIndex}}" object="accHead"
		              		ng-model="row.crdtlAccountHead" name ="accountHeadCode{{trIndex}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "creditNoteForm"></selectivity>
	        			</div>
	        		</div>
	        	</td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<selectivity list="serviceList" property="row.service" id="service{{trIndex}}" object="service"
		              		ng-model="row.service" name ="service{{trIndex}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Service)'}}" form-name = "creditNoteForm"></selectivity>
	        			</div>
	        		</div>
	        	</td>
	        	
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<selectivity list="containerList" property="row.conType" id="conType{{$index}}" object="conType"
		              		ng-model="row.conType" name ="conType{{$index}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(ConType)'}}" form-name = "creditNoteForm"></selectivity>
	        			</div>
	        		</div>
	        	</td>	        	
	          	<td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm text-right" ng-model="row.conRate"  ng-keyup="rateCalculation(row.noOfCon,trIndex,row)"
	         	  			name ="conRate{{$index}}" id="conRate{{$index}}" validation="required" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" friendly-name="{{ 'Row' + $index + '(Rate)'}}" />
	              		</div>
	              	</div>
	            </td>
	            
	            <td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm" ng-model="row.noOfCon" ng-keyup="rateCalculation(row.noOfCon,trIndex,row)" validation="required"
	         	  			name ="noOfCon{{$index}}" id="noOfCon{{$index}}" friendly-name="{{ 'Row' + $index + '(No Of Con)'}}" />
	              		</div>
	              	</div>
	            </td>
	            <td>
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
	            </td>
	            
     		</tr>     		
      	</tbody>
      </table>
      <div class="padding-right-5" id="AddOrRmvebtn">
           <button ng-click="addCredRow(creditnoteAcctData.credittables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>
           </button>
           <button ng-click="removeCredRow(creditnoteAcctData.credittables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
      </div> <!-- /padding-right-5 - /AddOrRmvebtn -->
	</div>    <!-- /table-responsive -->
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group pull-right">
		       
		        <label class="col-md-3 control-label">Total TC Amt</label>
		        <div class="col-md-3">
		         	<input type="text" class="form-control input-sm text-right" name="totalTCAmount" data-ng-model="creditnoteAcctData.totalTCAmount"
	         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
		        </div>
		        
		         <label class="col-md-3 control-label">Total BC Amt</label>
		        <div class="col-md-3">
		         	<input type="text" class="form-control input-sm text-right" name="totalBCAmount" data-ng-model="creditnoteAcctData.totalBCAmount"
	         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
		        </div>
	       </div>
		</div>
	</div>
	 <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button id = "saveInvoice" class="btn btn-success" type="button" ng-if="!edit" ng-click="submit()" >
           <i class="fa fa-save"></i>
           Save
          </button>
           <!-- <button id = "calculateInvoice" class="btn btn-info" type="button" ng-click="exchageratePHChdr(creditnoteAcctData.exchangeRate)" >
           <i class="fa fa-reset"></i>
           Re-Calculate
          </button> -->
          <button class="btn btn-success" type="button" ng-if="edit" ng-click="submit()">
           <i class="fa fa-save"></i>
           Update
          </button>
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