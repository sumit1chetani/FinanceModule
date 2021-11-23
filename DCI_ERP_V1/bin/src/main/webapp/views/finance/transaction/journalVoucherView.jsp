<style>
 table.dataTable thead .sorting:after { 
   content: ""; 
 } 
 select{ 
 -webkit-appearance: none; 
   padding: 0; 
  text-indent: 8px; 
   padding : 0 !important; 
 } 
 .input-group-addon{ 
 display:none !important; 
 }
 .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control 


 { 
  background-color:white !important; 
  border:0px !important; 
 } 
 .b-grey{ 
 border:0px !important;
}
.form-label-control{
line-height: 35px;
}
</style>

<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb padding-left-0">
    <li>
     <a>Finance</a>
    </li>
    <li>
     <a>Transaction</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction.journalvoucher.list">Journal Voucher</a>
    </li>
    <li ng-if="journalVoucher.isEdit">
     <a x-ui-sref="app.finance.transaction.journalvoucher.edit">View</a>
    </li>
   </ol>
  </div>
  <div class="panel-body">
   <form class="form-horizontal" name="journalVoucherForm" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-12 col-lg-12">
     <fieldset ng-disabled="viewDisable">
     	<div class="col-sm-4 col-md-4 col-lg-4" ng-if="viewJv">
	 		<div class="form-group">
	       		<label for="inputPassword" class="control-label col-md-6 bold">JV Number</label>
	       		<div class="col-md-6">
	       			<label for="inputPassword" class="form-label-control" ng-bind="journalVoucher.jvNumber"></label>
	       		</div>
	      	</div>
	    </div>
	    <div class="col-sm-4 col-msd-4 col-lg-4">
	    	<div class="form-group">
	        	<label for="inputPassword" class="control-label col-md-6 bold">JV Date</label>
		        <div class="col-md-6">
		          <div class='input-group date datetimepick' >
	                  <input type="text" class="form-control" ng-model="journalVoucher.dataOfIssue" 
	                  placeholder="dd/mm/yyyy" id="dataOfIssue" 
	                     value="{{journalVoucher.dataOfIssue}}" name="dataOfIssue" ng-disabled="true" />
	                  
	              </div>
		        </div>
	       	</div>
	    </div>
	    <div class="col-sm-4 col-msd-4 col-lg-4">
	    	<div class="form-group">
		       	<label for="inputPassword" class="control-label col-md-6 col-lg-6 bold">Narration</label>
		       	<div class="col-md-6">
		        	<label for="inputPassword" class="form-label-control" ng-bind="journalVoucher.narration"></label>
		       	</div>
	      	</div>
	    </div>
	    <div class="col-sm-4 col-md-4 col-lg-4">
	    	  <div class="form-group">
		      	<label for="inputPassword" class="control-label col-md-6 bold">Company</label>
		      	<div class="col-md-6">
		            <label for="inputPassword" class="form-label-control" ng-bind="journalVoucher.company"></label>
		      	</div>
		     </div>
	    </div>
	    </fieldset>
     </div> <!-- /col-sm-12 -->
   </div> <!-- /row -->
        
       <div class="table-responsive clear">
          <table class="table table-striped b-t b-light" st-table="row" st-safe-src="row">
	          <thead class="dataTables-Main-Head">
	          <tr>
			         <!--  <th class="width_1"></th> -->
			        <th class="sorting" st-sort="jvNumber">Account Head</th>
			          <th class="text-center width_5" st-sort="accountName">Sub Account Code</th>
			          <th class="text-center width_5" st-sort="accountName">Ref No.</th>
			          <th class="text-center width_5" st-sort="subAccountName">Narration</th>
			          <th class="text-center width_5"st-sort="narration">Cur</th>
			          <th class="text-center width_5" st-sort="currency">Rate</th>
			          <th class="text-center width_5" st-sort="tcDebitAmount">TC Debit</th>
			          <th class="text-center width_5" st-sort="bcDebitAmount">BC Debit</th>
			          <th class="text-center width_5" st-sort="tcCreditAmount">TC Credit</th>
			          <th class= "text-center width_5" st-sort="bcCreditAmount">BC Credit</th> 
		          </tr> 
	          </thead> 
	          <tbody ng-repeat="(trIndex, row) in journalVoucher.tables" ng-controller="tableViewCtrl">	          
		          <tr>
		        <!--   	<td class="padding-both-side-2 width_1">
		            	<label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}" /><i></i></label>						
		            </td> -->
		            <td class="padding-both-side-2 width_5">
		            	<!-- <select class="form-control input-sm" id="txtAccountCode{{trIndex}}" ng-model="row.accountCode" ng-disabled="viewDisable" ng-options="acc.id as acc.text for acc in accountHeadList">
		             	</select> -->
		             	<input type="hidden" class="form-label-control" ng-model="row.accountCode" />	
		             	<label class="form-label-control" ng-bind="row.accountName"></label>		             	
		            </td>
		            <td>
						<!-- <select class="form-control input-sm" id="txtSubAccountCode{{$index}}" ng-model="row.subAccountCode" ng-disabled="viewDisable" ng-options="subAcc.id as subAcc.text for subAcc in subAccountCodeList">
		             	</select> -->
		             	<label class="form-label-control" ng-bind="row.subAccountName"></label>
		            </td>
		            
		            <td>
						<!-- <select class="form-control input-sm" id="txtSubAccountCode{{$index}}" ng-model="row.subAccountCode" ng-disabled="viewDisable" ng-options="subAcc.id as subAcc.text for subAcc in subAccountCodeList">
		             	</select> -->
		             	<label class="form-label-control" ng-bind="row.refNo"></label>
		            </td>
		            
		            <td class="padding-both-side-2 width_5">
		            	<label class="form-label-control" ng-bind="row.narration"></label>
		            </td>
		            <td class="padding-both-side-2 width_5">
		             	<!-- <select class="form-control input-sm" ng-model="row.currency" ng-disabled="viewDisable" ng-options="cur.id as cur.text for cur in currencyList">
		             	</select> -->
		             	<label class="form-label-control" ng-bind="row.currency"></label>
		            </td>
		            <td class="padding-both-side-2 width_5" align="right">
		              <label class="form-label-control" ng-bind="row.exchangeRate"></label>
		            </td>
		            <td class="padding-both-side-2 width_5" align="right">
		            	
		            	<label class="form-label-control" ng-bind="row.tcDebitAmount"></label>
		            </td>
		            <td class="padding-both-side-2 width_5" align="right">
		            	<label class="form-label-control" ng-bind="row.bcDebitAmount"></label>
		            </td>
		            <td class="padding-both-side-2 width_5" align="right">
		            	<label class="form-label-control" ng-bind="row.tcCreditAmount"></label>
		            </td>
		            <td class="padding-both-side-2 width_5" align="right">
		            	<label class="form-label-control" ng-bind="row.bcCreditAmount"></label>
		            </td>
		          </tr>
		          <!-- Attributes list -->
		          <tr>
		        	<td colspan="12">
			        	<div class="col-sm-12">
			        	<fieldset ng-disabled="">
			        	
			        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
							<label class="col-md-5 control-label "> Vessel
								
							</label>
							<div class="col-md-7">
						           <select class="form-control input-sm" id="vesselCode{{trIndex}}" ng-model="row.vesselCode" ng-options="ves.id as ves.text for ves in vesselList">
								   </select>
								    <!-- <label class="form-label-control" ng-bind="row.vesselName"></label> -->
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
							<label class="col-md-5 control-label "> Voyage
								
							</label>
							<div class="col-md-7">
						              <select class="form-control input-sm" id="voyageCode{{trIndex}}" ng-model="row.voyageCode" ng-options="voy.id as voy.text for voy in voyageList">
								 	  </select>
								 	  <!-- <label class="form-label-control" ng-bind="row.voyageCode"></label> -->
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isService">
							<label class="col-md-5 control-label"> Service
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="sectorCode{{trIndex}}" ng-model="row.sectorCode" ng-options="sec.id as sec.text for sec in sectorList">
								 	 </select>
								 	   <!-- <label class="form-label-control" ng-bind="row.sectorName"></label> -->
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
							<label class="col-md-5 control-label"> Employee
								
							</label>
							<div class="col-md-7">
						           <select class="form-control input-sm" id="employeeCode{{trIndex}}" ng-model="row.employeeCode" ng-options="emp.id as emp.text for emp in employeeList">
								   </select>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
							<label class="col-md-5 control-label"> Port
								
							</label>
							<div class="col-md-7">
						           <select class="form-control input-sm" id="portCode{{trIndex}}" ng-model="row.portCode" ng-options="port.id as port.text for port in portList">
								   </select>
						     </div>
						</div>
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
							<label class="col-md-5 control-label"> Port.Seq
								
							</label>
							<div class="col-md-7">
						          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
						     </div>
						</div>
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
							<label class="col-md-5 control-label"> Department
								
							</label>
							<div class="col-md-7">
							
						           <select class="form-control input-sm" id="departmentCode{{trIndex}}" ng-model="row.departmentCode" ng-options="dep.id as dep.text for dep in departmentList">
								   </select>
						     </div>
						</div>
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
							<label class="col-md-5 control-label"> Agent
								
							</label>
							<div class="col-md-7">
						           <select class="form-control input-sm" id="agentCode{{trIndex}}" ng-model="row.agentCode" ng-options="agent.id as agent.text for agent in agentList">
								   </select>
						     </div>
						</div>
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
							<label class="col-md-5 control-label"> Location
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="countryCode{{trIndex}}" ng-model="row.countryCode" ng-options="country.id as country.text for country in countryList">
								 	 </select>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
							<label class="col-md-5 control-label"> Customer
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="customerCode{{trIndex}}" ng-model="row.customerCode" ng-options="cus.id as cus.text for cus in customerList">
								 	 </select>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
							<label class="col-md-5 control-label"> Supplier
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="supplierCode{{trIndex}}" ng-model="row.supplierCode" ng-options="sup.id as sup.text for sup in supplierList">
								 	 </select>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
							<label class="col-md-5 control-label"> Designation
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="designationCode{{trIndex}}" ng-model="row.designationCode" ng-options="desig.id as desig.text for desig in designationList">
								 	 </select>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
							<label class="col-md-5 control-label"> CostCtr
								
							</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
							<label class="col-md-5 control-label"> Company
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="companyCode{{trIndex}}" ng-model="row.companyCode" ng-options="company.id as company.text for company in companyList">
								 	 </select>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
							<label class="col-md-5 control-label">Qty(MT)GO</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
							<label class="col-md-5 control-label">Qty(MT)FO</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
						     </div>
						</div>
						</fieldset>
						</div>
				    </td> 		             	
		       </tr>
	     	</tbody>
         </table>
        <div class="row">
	        <div class="col-sm-12">
	        	<div class="form-group pull-right">
		          <label class="col-md-4 control-label bold">Total </label>		         
		         <div class="col-md-2" id="totals">
           
		         	<input type="text" class="form-control input-sm text-right" id="totaltcDebit" ng-model="journalVoucher.totalTcDebitAmt" readonly>
		         </div>
		         <div class="col-md-2" id="totals">
		         	<input type="text" class="form-control input-sm text-right" id="totalbcDebit" ng-model="journalVoucher.totalBcDebitAmt" readonly>
		         </div>
		         <div class="col-md-2" id="totals">
		          <input type="text" class="form-control input-sm text-right" id="totaltcCredit" ng-model="journalVoucher.totalTcCreditAmt" readonly>
		         </div>
		         <div class="col-md-2" id="totals">
		          <input type="text" class="form-control input-sm text-right" id="totalbcCredit" ng-model="journalVoucher.totalBcCreditAmt" readonly>
		         </div>
		       </div>
		       
	        </div> <!-- /col-sm-12 -->
        </div> <!-- /row -->
        
         <div class="row">
          <div class="col-md-12">
          	<div class="form-actions">
	           	<button class="btn btn-danger" ng-if="journalTable!=true" ng-click="cancel()" type="button"><i class="fa fa-close"></i>
	            Cancel
	           	</button>
             <button class="btn btn-danger" ng-if="journalTable==true" ng-click="cancel1()" type="button"><i class="fa fa-close"></i>
             Cancel
             </button>
	           	<button class="btn btn-success" ng-if="journalTable!=true" ng-click="printJournalVoucherDiv(journalVoucher.jvNumber)"  type="button">
	        	  Print
	          	</button>
           	</div> <!-- /form-actions -->
          </div> <!-- /col-sm-12 -->
         </div> <!-- /row -->        
       </div> <!-- /table-responsive -->     
   </form>
  </div>
 </div>
</div>
