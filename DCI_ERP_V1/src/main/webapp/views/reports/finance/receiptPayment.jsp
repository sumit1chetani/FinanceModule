<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<div class="panel panel-default panel-default-list"
		st-table="displayedCollection1" st-safe-src="rowCollection1">
		<div class="panel panel-default panel-default-list"
		st-table="displayedCollection2" st-safe-src="rowCollection2">
		<div class="panel panel-default panel-default-list"
		st-table="displayedCollection3" st-safe-src="rowCollection3">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel panel-default">
			<div class="form-body form-horizontal">
				<div class="row m-t-sm">
       <form class="form-horizontal" name="employeeAttendanceReportForm" role="form" novalidate>
     <div role="content">
     	 <div class="col-lg-12">
          		<fieldset>
                    <div class="col-sm-4 col-md-4">
                       <div class="form-group">
                          <label class="col-md-6 control-label">Company<span style="color: red;">*</span>
                          </label>
                          <div class="col-md-6">
                             <selectivity list="companyList" property="generalLedger.companyCode"  ng-model="generalLedger.companyCode" 
								        id="companyCode" name="	companyName" object="company" validation="required" 
								        friendly-name="	companyName" form-name = "cashBankcomPaymentForm"></selectivity>					        
                          </div>
                        </div>
                     </div>
                      <div class="col-sm-4 col-md-4">
                       <!-- <div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">From Date<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<a class="dropdown-toggle" id="fromDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		data-valid-method="submit" data-message-id="From Date"
																		data-ng-model="generalLedger.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="generalLedger.fromDate"
																	data-on-set-time="generalLedger.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" />
															</ul>  	
					        <ng-bs3-datepicker data-ng-model="bankReconcile.fromDate" id="fromDate" name="fromDate" name="fromdate"
       data-ng-change="checkDatesCL(bankReconcile.fromDate)" 
        friendly-name="From Date"/>								
  							</div>
       				</div> -->
       				
       				
       				<div class="form-group ">
								<label class="col-md-5 control-label">From
Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="generalLedger.fromDate"
										id="fromDate" name="From Date"
										data-ng-change="checkDatesCL(generalLedger.fromDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
       				
                     </div>
                     
                     
                     <div class="col-sm-4 col-md-4">
                       <!-- <div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">To Date<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<a class="dropdown-toggle" id="fromDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="To Date"
																		data-valid-method="submit" data-message-id="To Date"
																		data-ng-model="generalLedger.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="generalLedger.toDate"
																	data-on-set-time="generalLedger.toDate = onDateSet(newDate)" 
																	data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
															</ul>  	
					        <ng-bs3-datepicker data-ng-model="bankReconcile.fromDate" id="fromDate" name="fromDate" name="fromdate"
       data-ng-change="checkDatesCL(bankReconcile.fromDate)" 
        friendly-name="From Date"/>								
  							</div>
       				</div> -->
       				
       				
       				
       				<div class="form-group ">
								<label class="col-md-5 control-label">To
Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="generalLedger.toDate"
										id="todate" name="To Date"
										data-ng-change="checkDatesCL(generalLedger.toDate)"
										friendly-name="To Date" validation="required" />
								</div>
								</div>
       				
       				
       				
                     </div>
                     <br>
                     <br>
                     <div class="col-sm-4 col-md-4">
                      <div class="form-group">
                        <label class="col-md-6 control-label">Fund Type
                        </label>
                        <div class="col-md-6">
                           <selectivity list="costList" id="costCenter"
														name="costCenter" form-name="trialBalanceForm"
														property="generalLedger.costCenter"
														ng-model="generalLedger.costCenter"
														friendly-name="Costcenter"  ></selectivity>
                        </div>
                      </div>
                     </div>
                    
                    <br>
                    <br>
                    
                   <!--  <a id="GLExport" stype="display:none"
					href="tempdoc/DayBook.xlsx" download="DayBook.xlsx"></a>
					 -->
					
                    <div class="form-group">
						<div class="row">
                      <div class="col-md-5 col-md-offset-5">
                       <button type="button" class="btn btn-success"
									ng-click="viewGeneralLedgerReport()">
									<i class="fa fa-search"></i>View Report
								</button>
									<a id="GLExport" style="display: none"
													href="filePath/DayBook.xls" download="DayBook.xls"></a>
								
								<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/ReceiptPayment.pdf"
											download="ReceiptPayment.pdf"></a>
									</button>
								<!-- <button type="button" class="btn btn-primary"
									ng-click="exportGeneralLedgerExcel()">
									<i class="fa fa-search"></i>Export Excel
								</button>  -->
                        
                      <!--   <button id="GLExport"  class="btn btn-primary"
           data-ng-click="exportGeneralLedgerExcel()"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button> -->
                        
                      </div>
                    </div>
                    </div>
                      </fieldset>
                      </div>
                      
                      
                      <div>
                      </div>
                      </div>
		<br>
      <div class="widget-body no-padding">
       <div >
        <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
         
				<div class="panel-body" style="width: 50%;float: center; position:relative; float:left">
							<div class="table-responsive">
									<div st-table="displayedCollection10" st-safe-src="rowCollection10">
										<table class="table table-striped table-hover dataTable no-footer">
											<thead>
											<tr>
	       <th style="text-align:center;" class="sorting" colspan="4" st-sort="voucherDate">Receipt</th></tr>
											<tr>
											
					<th class="sorting" st-sort="voucherDate">Previous Year</th>
	       <!-- <th class="sorting" st-sort="jvNumber">Account Code</th> -->
	       	<th colspan="2" class="sorting" st-sort="jvNumber">Account Name</th>
	        <th class="sorting" st-sort="voucherDate">Amount</th>
					</tr>
										
				</thead><tbody >
				<tr >
	     <td> </td>
	       <!-- <td> </td> -->
	       	<td>Balance from last year A/C  </td>
	       <td> </td></tr>
				<tr ng-repeat="objTranslationItem in displayedCollection2">
	     <td>{{objTranslationItem.preAmount}}</td>
	       <!-- <td>{{objTranslationItem.acctCode}}</td> -->
	        <td >{{objTranslationItem.acctName}}</td>  <td >{{objTranslationItem.amoount}}</td>
	       <td  style="text-align:right;">{{objTranslationItem.amount}}</td></tr>
	       <tr>
							<td  >{{preTotalAmount2}}</td>
	       
	       	<td colspan="2" > </td>
	       <td style="text-align:right;">{{totalAmount2}}</td>
												</tr>
					<tr><td> </td>
	       
	       	<td>  </td>
	       <td> </td></tr> 
	       	<tr><td> </td>
	        
	       	<td>  </td>
	       <td> </td></tr> 
	       
											 <tr ng-repeat="objTranslationItem in displayedCollection">
					<td>{{objTranslationItem.preAmount}}</td>
	       <!-- <td>{{objTranslationItem.acctCode}}</td> -->
	       	<td  colspan="2">{{objTranslationItem.acctName}}</td>
	       <td style="text-align:right;">{{objTranslationItem.amount}}</td>
					</tr></tbody>
					<tr>
							<td  ><b>{{preTotalAmount}}</b></td>
	       
	       	<td colspan="2" > </td>
	       <td style="text-align:right;"><b> {{totalAmount}}</b></td>
												</tr>
												
					
					</table>
					</div>
					<br>
					</div>
					</div>
					</div>
					
							
						
						
					 
				<div class="panel-body" style="width: 50%;float: center; position:relative; float:right">
							<div class="table-responsive">
								

									<div  >
										<table class="table table-striped table-hover dataTable no-footer">
											<thead>
											<tr>
	       <th style="text-align:center;" class="sorting" colspan="4" st-sort="voucherDate">Payment</th></tr>
											<tr>
				
					<th class="sorting" st-sort="voucherDate">Previous Year</th>
	      <!--  <th class="sorting" st-sort="jvNumber">Account Code</th> -->
	       	<th colspan="2" class="sorting" st-sort="jvNumber">Account Name</th>
	        <th class="sorting" st-sort="voucherDate">Amount</th>
		
				</tr>
					</thead>
						<tbody ng-repeat="objTranslationItem in displayedCollection1">
						<tr>
							<td>{{objTranslationItem.preAmount}}</td>
	      <!--  <td>{{objTranslationItem.acctCode}}</td> -->
	       	<td  colspan="2" >{{objTranslationItem.acctName}}</td>
	       <td style="text-align:right;">{{objTranslationItem.amount}}</td>
												</tr>	</tbody>
												
											
										<tr >
	     <td> </td>
	       <!-- <td> </td> -->
	       	<td>Balance In Hand </td>
	       <td> </td></tr>
				<tr ng-repeat="objTranslationItem in displayedCollection3">
	     <td>{{objTranslationItem.preAmount}}</td>
	       <!-- <td>{{objTranslationItem.acctCode}}</td> -->
	        <td >{{objTranslationItem.acctName}}</td>  <td >{{objTranslationItem.amoount}}</td>
	       <td  style="text-align:right;">{{objTranslationItem.amount}}</td></tr>
	       <tr>
							<td  >{{preTotalAmount3}}</td>
	       
	       	<td colspan="2" > </td>
	       <td style="text-align:right;">{{totalAmount3}}</td>
												</tr>
												<tr>
							<td><b>{{preTotalAmount1}}</b></td>
	      <!--  <td> </td> -->
	       	<td colspan="2"> </td>
	       <td style="text-align:right;"><b>{{totalAmount1}}</b></td>
												</tr>
										</table>
									</div>
									<br>
								
							</div>
						</div>
        <!-- <table   id="dt_basic" class="table table-layout-fixed table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
	       <th style="text-align:center;" class="sorting" colspan="4" st-sort="voucherDate">Receipt</th>
	       <th style="text-align:center;"  class="sorting"  colspan="4" st-sort="jvNumber">Payment</th>
	        
	      </tr>
	      <tr>
	       <th class="sorting" st-sort="voucherDate">Previous Year</th>
	       <th class="sorting" st-sort="jvNumber">Account Code</th>
	       	<th class="sorting" st-sort="jvNumber">Account Name</th>
	        <th class="sorting" st-sort="voucherDate">Amount</th>
	        <th class="sorting" st-sort="voucherDate">Previous Year</th>
	       <th class="sorting" st-sort="jvNumber">Account Code</th>
	       	<th class="sorting" st-sort="jvNumber">Account Name</th>
	        <th class="sorting" st-sort="voucherDate">Amount</th> 
	      </tr>
	     </thead>
         <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
		   <span ng-repeat="objTranslationItem1 in displayedCollection1">
		       		<td>{{objTranslationItem.preAmount}}</td>
	       <td>{{objTranslationItem.acctCode}}</td>
	       	<td>{{objTranslationItem.acctName}}</td>
	       <td>{{objTranslationItem.amount}}</td>
	       	<td>{{objTranslationItem1.preAmount}}</td>
	       <td>{{objTranslationItem1.acctCode}}</td>
	       	<td>{{objTranslationItem1.acctName}}</td>
	       <td>{{objTranslationItem1.amount}}</td> 
 
	       <td>
	        <span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.narration}}</span>
	       </td>
	        <td>{{objTranslationItem.bcDebit}}</td><br>
	         <td>{{objTranslationItem.bcCredit}}</td>
	     	</tr>
	     </tbody>
        </table> -->
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->      
 

 
  </div> 
  
    <!-- <div style=" padding-left:52%;">
					<div class="col-sm-12 col-md-4 col-lg-4"
						style="width: 51%; padding-right: -6%;left: 194px;">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"
									style="font-size: 11px; font-weight: 500;"> <b>Total</b>
									 </label>
								<div class="col-md-7"
									style="font-size: 11px; padding-top: 7px; font-weight: 500;"><b>{{generalLedger.totalAmount}}</b></div>
							</div>
						</fieldset>
					</div>
					</div> -->
					</div>
					<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
					</form>
					
  
  <!-- /dataTables_wrapper -->
      </div> <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>