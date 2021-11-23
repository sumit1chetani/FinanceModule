<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
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
                          <label class="col-md-6 control-label">Organization<span style="color: red;">*</span>
                          </label>
                          <div class="col-md-6">
                             <selectivity list="companyList" property="generalLedger.companyCode"  ng-model="generalLedger.companyCode" 
								        id="companyCode" name="	organizationName" object="company" validation="required" 
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
								<button type="button" class="btn btn-primary"
									ng-click="exportGeneralLedgerExcel()">
									<i class="fa fa-search"></i>Export Excel
								</button> 
								
								   <button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/DayBook.pdf"
											download="DayBook.pdf"></a>
									</button>	
                        
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
        <table id="dt_basic" class="table table-layout-fixed table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
	      <tr>
	       <th class="sorting" st-sort="voucherDate">Voucher Date</th>
	       <th class="sorting" st-sort="jvNumber">Voucher No</th>
	       	<th class="sorting" st-sort="jvNumber">Fund Type</th>
 	        <th class="sorting" st-sort="voucherDate">Created By</th>
<!-- 	       <th class="sorting" st-sort="voucherDate">Created Date</th>
 -->	      
<!--              <th class="sorting" st-sort="narration">Party Inv No</th>
 -->	      
              <th class="sorting" st-sort="narration">Account Head Code</th>
              <th class="sorting" st-sort="narration">Account Head Name</th>
<!-- 	         <th class="sorting" st-sort="narration">SA Name</th>
	         <th class="sorting" st-sort="narration">Narration</th> -->
	         <th class="sorting" st-sort="narration">Debit Amount</th>
	         <th class="sorting" st-sort="narration" colspan="2">Credit Amount</th>
	      </tr>
	     </thead>
         <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
		       		<td>{{objTranslationItem.ledgerDate}}</td>
	       <td>{{objTranslationItem.transactionNo}}</td>
 	       	<td>{{objTranslationItem.costCentername}}</td>
 	       <td>{{objTranslationItem.userBy}}</td>
<!-- 	       <td>{{objTranslationItem.createdDate}}</td>
 -->	       <!--  <td></td> -->
<!-- 	       <td>{{objTranslationItem.subGroupAddress}}</td>
 -->	       
<!--   <td></td> -->
	       	    
	       	    
	       	       <td ng-if="objTranslationItem.toadd == true"> &nbsp;  &nbsp;&nbsp; &nbsp;<span style ="color:red";> TO </span> {{objTranslationItem.accountHeadCode}}</td>
	       	  <td  ng-if="objTranslationItem.toadd!= true"> {{objTranslationItem.accountHeadCode}}</td>
	       	      
	       <td ng-if="objTranslationItem.toadd == true"> &nbsp;&nbsp;&nbsp;&nbsp;<span style ="color:red";>TO </span>{{objTranslationItem.subGroupAddress2}}</td>
	       	<td ng-if="objTranslationItem.toadd!= true">{{objTranslationItem.subGroupAddress2}}</td>
	       


<!-- 	       row.cbpdtlPmtOrderNo.includes('POR')
 -->	       
<!-- 	       <td>{{objTranslationItem.subGroupName}}</td>
 -->
	      
	      <!--  <td>
	        <span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.narration}}</span>
	       </td> -->
	        <td align ="right">{{objTranslationItem.bcDebit|number:2}}</td><br>
	         <td align ="right">{{objTranslationItem.bcCredit|number:2}}</td>
	     	</tr>
	     </tbody>
        </table>
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->      
 
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
 
  </div> 
  
    <div style=" padding-left:52%;">
					<div class="col-sm-12 col-md-4 col-lg-4"
						style="width: 51%; padding-right: -6%;left: 194px;">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"
									style="font-size: 11px; font-weight: 500;"> <b>Total</b>
									 </label>
								<div class="col-md-7"
									style="font-size: 11px; padding-top: 7px; font-weight: 500;"><b>{{generalLedger.totalAmount|number:2}}</b></div>
							</div>
						</fieldset>
					</div>
					</div>
					</div>
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