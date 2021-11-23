<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="cashBankPaymentForm">
				<div class="row">

         <div class="col-sm-12">
		     <div class="col-sm-4">
		     	<!-- <div class="form-group" ng-if="!isEdit">
			        <label class="col-md-5 control-label">From Date<span style="color:red;"> *</span></label>
			        <div class="col-md-7">
			          <div class='input-group date datetimepick col-md-12' >
												<div class="dropdown">
															<a class="dropdown-toggle" id="fromdate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="fromDate"
																		data-valid-method="submit" data-message-id="From Date"  validation="required" friendly-name="From Date"
																		data-ng-model="paymentInformationData.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="paymentInformationData.fromDate"
																	data-on-set-time="paymentInformationData.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
															</ul>
														</div>														
													</div>     	
			        </div>
		     	</div> -->
		     	
		     	
		     	
		     	<div class="form-group " ng-if="!isEdit">
								<label class="col-md-5 control-label">From Date<span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="paymentInformationData.fromDate"
										id="fromdate" name="realisedDate"
										data-ng-change="checkDatesCL(paymentInformationData.fromDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
		     	<div class="form-group" ng-if="!isEdit">
			        <label class="col-md-5 control-label">Organization<span style="color:red;"> *</span></label>
			        <div class="col-md-7">
			        
			        
			        <selectivity list="companyList"  validation="required" ng-model="paymentInformationData.companyCode" 
			        	property="paymentInformationData.companyCode" friendly-name="company" name="organizationCode" form-name = "cashBankPaymentForm"></selectivity>
				              		   </div>
                                        </div>
		     	
		     	
		     	
		     	
		     	<div class="form-group" ng-if="isEdit">
		     	 <label class="col-md-5 control-label">Payment Order Number<span style="color:red;"> *</span></label>
		     	   <div class="col-md-7">
		     	 <input type="text" class="form-control input-sm" 
														ng-model="paymentInformationData.paymentOrderNo"
														name="Party Invoice No" 
														readonly />  
														</div>
		     	</div>
		     	
		    </div>
		    <div class="col-sm-4">
	 			<!-- <div class="form-group" ng-if="!isEdit">
			        <label class="col-md-5 control-label">To Date<span style="color:red;"> *</span></label>
			        <div class="col-md-7">
			        
			      <div class='input-group date datetimepick'>
               <div class="dropdown">
                <a class="dropdown-toggle" id="toDate" role="button" data-toggle="dropdown"
                 data-target="#" href="#">
                 <div class="input-group">
                  <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="toDate"
                   validation="required" friendly-name="To Date" id="toDate"
                   data-ng-model="paymentInformationData.toDate"><span
                   class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                 </div>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                 <datetimepicker data-ng-model="paymentInformationData.toDate"
                  data-on-set-time="paymentInformationData.toDate = onDateSet(newDate);"
                  data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
                </ul>
               </div>
              </div>
			        
			              <div class='input-group date datetimepick col-md-12' >
												<div class="dropdown">
															<a class="dropdown-toggle" id="toDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="To Date"
																		data-valid-method="submit" data-message-id="To Date"
																		data-ng-model="paymentInformationData.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="paymentInformationData.toDate"
																	data-on-set-time="paymentInformationData.toDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#todate',startView:'day', minView:'day'}" />
															</ul>
														</div>														
													</div>  
													
													 	          	
			        </div>
		     	</div> -->
		     	
		     		
		     	<div class="form-group " ng-if="!isEdit">
								<label class="col-md-4 control-label">To Date<span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="paymentInformationData.toDate"
										id="toDate" name="To Date"
										data-ng-change="checkDatesCL(paymentInformationData.toDate)"
										friendly-name="To Date" validation="required" />
								</div>
								</div>
		     	<div class="form-group" ng-if="isEdit">
		     	 <label class="col-md-5 control-label">Payment Order Date<span style="color:red;"> *</span></label>
		     	   <div class="col-md-7">
		     	 <input type="text" class="form-control input-sm" 
														ng-model="paymentInformationData.paymentOrderDate"
														name="paymentOrderDate" 
														readonly /> 
														</div> 
		     	</div>
		  </div>
		    <div class="col-sm-4">
		      <div class="form-group" >
			        <label class="col-md-5 control-label">Supplier<span style="color:red;"> *</span></label>
			        <div class="col-md-7" ng-if="!isEdit">
			        	<selectivity list="supplierList"  validation="required" ng-model="paymentInformationData.supplier" 
			        	property="paymentInformationData.supplier" friendly-name="Supplier" name="supplier" form-name = "cashBankPaymentForm" 
				              		  ></selectivity>
			           			
			        </div>
			         <div class="col-md-7" ng-if="isEdit">
			         	 <input type="text" class="form-control input-sm" ng-if="isEdit"
														ng-model="paymentInformationData.supplierName"
														readonly /> 
			         </div>
		       	</div>
		    </div>
	    </div> 
	     <div class="col-md-12">
	    	<div class="form-actions">
	    	  <button class="btn btn-success" type="button" ng-if="!isEdit" data-ng-click="validate(cashBankPaymentForm)" >
		          Get List
		          </button>
		 <button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
        <span class="fa fa-file-excel-o"> Export Excel</span>
         <a id="pendingExport" stype="display:none"
					href="tempdoc/PayamentInformation.xls" download="PayamentInformation.xls"></a>
       </button>
       
    
	    	</div>
	    	
	    	
	    	
	    
	    </div>
	    	
	    <!-- /col-sm-12 -->
	    <div class="col-md-12">
        	<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all">
        	<div style="min-width:80%; overflow-x:scroll">
				<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
				<thead class="dataTables-Main-Head">
		          <tr>
		            <th colspan="1" class="sorting width_1"></th>
		            <th ng-if="!isEdit" colspan="1" class="sorting width_7 text-center">Supplier</th>
		            <th colspan="1" class="sorting width_7 text-center">Due Date</th>
		            <th colspan="1" class="sorting width_9 text-center">Party Invoice no.</th>
		            <th colspan="1" class="sorting width_9 text-center">Party Invoice Date.</th>
		            <th colspan="1" class="sorting width_7 text-center">Invoice No.</th>
		            <th colspan="1" class="sorting width_9">Invoice Date</th>
<!-- 		            <th colspan="1" class="sorting width_7 text-center">Currency</th>
 -->		          <!--   <th colspan="1" class="sorting width_9 text-center">Exchange Rate</th> -->
		            <th colspan="1" class="sorting width_6 text-center"> Amount</th>
		            <!-- <th colspan="1" class="sorting width_7 text-center"> TC Amount</th> -->
		             <th colspan="1" class="sorting width_9 text-center" ng-if="!isEdit">Payable Amount</th>
		          	 <th colspan="1" class="sorting width_7 text-center">Pay  Amount</th>
		       <!--      <th colspan="1" class="sorting width_9 text-center">Pay TC Amount</th> -->
		          </tr>
		        </thead>
		        <!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->
		        <tbody ng-repeat="parameterCollection in paymentInformationData.detailBeans" >
		        <tr>
		        	<td>
		            	<label class="i-checks m-b-none" ng-if="!isEdit">
				  <input type="checkbox"  ng-model="parameterCollection.select">
				   <i></i>
				</label>
				</td>
		         <td  ng-if="!isEdit" >{{parameterCollection.supplier}}</td>
		        	<td>{{parameterCollection.dueDt}}</td>
					 <td>{{parameterCollection.partyInvoiceNo}}</td>
					<td>{{parameterCollection.partyInvoiceDt}}</td>
					<td>{{parameterCollection.invoiceNo}}</td>
					 <td>{{parameterCollection.invoiceDate}}</td>
<!-- 		     	 	<td>{{parameterCollection.currencyCode}}</td>
 -->		             <!-- <td>{{parameterCollection.exchangeRate}}</td> -->
		              <td>{{parameterCollection.invBcAmt}}</td>
		              <!--  <td>{{parameterCollection.invTcAmt}}</td> -->
		          	<td ng-if="!isEdit">{{parameterCollection.bcBalanceAmt}}</td>
		          	 <td><input type="text" class="form-control input-sm" ng-pattern-restrict="^[0-9.]*$" ng-blur="calculateTotalBC()" ng-model="parameterCollection.payableBcAmt" ></td>
		         	<!-- <td><input type="text" class="form-control input-sm" ng-pattern-restrict="^[0-9.]*$" ng-model="parameterCollection.payableTcAmt" disabled></td>
		        -->
		        </tr>
		        	
		      	</tbody>
		      </table>
			</div>
<!-- 			     <div class="row"> -->
					
					<br>
										<br>
					
						<!-- div class="col-sm-12">
														<div class="form-group pull-right">
															<label class="col-md-3 control-label">Total  Amt</label>
													        <div class="col-md-3">
													         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="paymentInformationData.poBcamt"
												         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
													        </div>
													        <label class="col-md-3 control-label">Total TC Amt</label>
													        <div class="col-md-3">
													         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="paymentInformationData.poTcamt"
												         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
													        </div>	        
												       </div>
													</div> -->
													
													<div class="col-sm-12">
							<div class="form-group pull-right">
								<!-- <label class="col-md-3 control-label">Total TC Amt</label>
						        <div class="col-md-3">
						         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="creditnoteDtlTotalAmt.totalTCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div> -->
						        <br><br>
						        <label class="col-md-5 control-label">Total  Amount</label>
						        <div class="col-md-5">
						         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="paymentInformationData.totalBCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div>	        
					       </div>
						</div>
					
					
					<!-- <div class="col-sm-6 col-md-6 col-md-offset-6 padding-top-10">
						<div class="form-group">
					        <label class="col-md-3 control-label">Total BC Amt</label>
					        <div class="col-md-2">
					         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="paymentInformationData.poBcamt"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div>
					        <label class="col-md-3 control-label">Total TC Amt</label>
					        <div class="col-md-2">
					         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="paymentInformationData.poTcamt"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div>
				       </div>
					</div> -->
					
<!-- 				</div> -->
		 	</div>    <!-- /table-responsive -->
		 	<div class="form-actions">
		     	      
		          <button class="btn btn-success" type="button" ng-if="!isEdit" data-ng-click="save()" >
		           <i class="fa fa-save"></i>
		           Save
		          </button>
		          <button class="btn btn-success" type="button" ng-if="isEdit" data-ng-click="update()" >
		           <i class="fa fa-save"></i>
		           Update
		          </button>
		          <button class="btn btn-danger" data-ng-click="cancel()" type="button">
		           <i class="fa fa-close"></i>
		           Cancel
		          </button>
		     
		 	</div>
		</div><!-- /col-md-12 -->
		</div> <!-- /row -->
       
       </form>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>  <!-- /standard-datatable-widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>

<script type="text/ng-template" id="modalDialogId">
	
	<div style="border: solid 2px #666; padding : 4px;">
		<div class="ngdialog-message">
			<h3 style="text-align: center;">Budget Alert !!!</h3>
			<p>Payment Exceeding Budget Limit, Are you sure want to continue</p>
		</div>
		<div class="ngdialog-buttons">
			<button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="confirm(confirmValue)">Confirm</button>
			<button type="button" class="ngdialog-button btn-danger" ng-click="closeThisDialog('button')">Cancel</button>
		</div>
	</div>
	
</script>