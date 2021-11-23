<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form id="pendingPaymentReportForm" name="pendingPaymentReportForm" class="form-horizontal">

				
				<div class="row">

 
 <div class="panel-body float-left padding-0" style="width: 100%;">
			
			
			
			<br>
			<div class="col-sm-12 col-md-12 col-lg-12">
					
						<div class="col-md-4">
						<div class="form-group">
												<label class="col-md-5 control-label"> Organization <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">

													<selectivity list="companyList" ng-if="!edit"
														id="company_id" name="Hospital"
														form-name="purchaseInvoiceForm"
														property="pendingPaymentData.company"
														ng-model="pendingPaymentData.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj" disabled="isGRNNo"></selectivity>

													
												</div>
											</div>
						</div>
			</div>
				<div class="col-sm-12 col-md-12 col-lg-12">
					
						<div class="col-md-4">
				
							<div class="form-group">
								<label class="col-md-5 control-label"> Vendor <span style="color: red;">*</span></label>
								<div class="col-md-7">
									<selectivity list="supplierList" id="supplier_id" name="Suppliername" form-name="pendingPaymentReportForm" 
									property="pendingPaymentData.supplier" ng-model="pendingPaymentData.supplier" 
									validation="required" friendly-name="Supplier" object="supplierobj"></selectivity>
								</div>
							</div>	
							</div>
							<div class="col-md-4">
											<!-- <div class="form-group">
												<label class="col-md-4 control-label">From Date</label>
												<div class="col-md-7">
								
														<div class="dropdown">
															<a class="dropdown-toggle" id="fromdate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		data-valid-method="submit" data-message-id="From Date"
																		data-ng-model="pendingPaymentData.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="pendingPaymentData.fromDate"
																	data-on-set-time="pendingPaymentData.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
															</ul>
														</div>
												
												</div>
											</div> -->
											
											
											<div class="form-group ">
								<label class="col-md-6 control-label">From Date <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="pendingPaymentData.fromDate"
										id=fromDate name="From Date"
										data-ng-change="checkDatesCL(pendingPaymentData.fromDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
														</div>
       					<div class="col-md-4">
       						<!-- <div class="form-group">
												<label class="col-md-4 control-label">To Date</label>
												<div class="col-md-7">
													
														<div class="dropdown">
															<a class="dropdown-toggle" id="todate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="To Date"
																		data-valid-method="submit" data-message-id="To Date"
																		data-ng-model="pendingPaymentData.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="pendingPaymentData.toDate"
																	data-on-set-time="pendingPaymentData.toDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#todate',startView:'day', minView:'day'}" />
															</ul>
														</div>
												
												</div>
											</div>	 -->		
											
											
											
											<div class="form-group ">
								<label class="col-md-6 control-label">To Date <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="pendingPaymentData.toDate"
										id=fromDate name="To Date"
										data-ng-change="checkDatesCL(pendingPaymentData.toDate)"
										friendly-name="To Date" validation="required" />
								</div>
								</div>
											
											
																	</div>
       				
			
					</div>
					<br><br>		<br>
					
					
				<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-md-6">
				</div>
				<div class="col-md-6" style= margin-left:-10%;>
				
				        
			     		<button class="btn btn-primary" type="button" ng-click="getSearchList()">
							<i class="fa fa-search"> View Report</i>
						</button>
						
			     		<button class="btn btn-primary" type="button" ng-click="exportPendingPaymentExcel()">
							<i class="fa fa-download"> Export Excel</i>
						</button>
			     	
			     	
						
						<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/PendingPayment.pdf"
											download="PendingPayment.pdf"></a>
									</button>
						
										</div>
						
		</div>
				</div>
					<br>					<br>
				
				  <div
        class=""
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
        <!-- <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
       
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="sorting width_15" st-sort="purInvoiceNo">Invoice No</th>
       <th class="sorting width_15" st-sort="purInvoiceDate">Invoice Date</th>
       <th class="sorting width_15" st-sort="invoiceBCAmt">Invoice Amount</th>

<!--        <th class="sorting width_10" st-sort="currency">Currency</th>
 -->       <!-- <th class="sorting width_15" st-sort="">Exchange Rate</th> -->
       <th class="sorting width_15" st-sort="paidAmountBC">Paid Amount<!-- (BC) --></th>

       <th class="sorting width_15" st-sort="bcAmountHdr">Balance Amount<!-- (BC) --></th>


      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPresentationList in displayedCollection">
       <td class="width_10" ng-bind="objPresentationList.purInvoiceNo"></td>
       <td class="width_9" ng-bind="objPresentationList.purInvoiceDate"></td>
       <td class="width_9 text-right" ng-bind="objPresentationList.invoiceBCAmt|number:2"></td>
<!--        <td class="width_9 text-right" ng-bind="objPresentationList.currency"></td>
 -->     <!--   <td class="width_9 text-right" ng-bind="objPresentationList.exchangeRate"></td> -->
       <td class="width_9 text-right" ng-bind="objPresentationList.paidAmountBC|number:2"></td>
       <td class="width_9 text-right" ng-bind="objPresentationList.bcAmountHdr|number:2"></td>

      </tr>
     </tbody>
    </table>
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
       </div>
				<!-- <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
					<div id="jqgrid">
						<table id="pendingPaymentReportGrid"></table>
						<div id="pendingPaymentReportPage"></div>
					</div>
		     	</div> -->
		     	
			</form>
		</div>
       	
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
