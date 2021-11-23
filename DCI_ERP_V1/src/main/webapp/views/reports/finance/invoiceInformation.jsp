<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  				<div class="panel-body">
    			<form name="trialBalanceForm" class="form-horizontal" >
    			<div class="row">
					     	<div class="col-sm-12 col-md-5 col-lg-5">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Credit Note
											
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm"
       ng-model="invoiceInformation.creditNote"
           name="creditNote" id="creditNote" 
           >
											
											 
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Invoice
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
            ng-model="invoiceInformation.invoice"
           name="invoice" id="invoice" 
           >
											
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Voucher 
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
          ng-model="invoiceInformation.voucher"
           name="voucher" id="voucher" 
           >
											
											 
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Purchase Invoice
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
          ng-model="invoiceInformation.purchaseInvoice"
           name="purchaseInvoice" id="purchaseInvoice" 
           >
											
											 
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Payment
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
          ng-model="invoiceInformation.payment"
           name="payment" id="payment" 
           >
											
											 
										</div>
									</div>
								</fieldset>
							</div>
					     	
					
					     	<div class="col-sm-12 col-md-5 col-lg-5">
								<fieldset>
								<div class="form-group">
										<label class="col-md-5 control-label"> Debit Note
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
            ng-model="invoiceInformation.debitNote"
           name="debitNote" id="debitNote" 
           >
											
											 
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> General Invoice
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
           ng-model="invoiceInformation.generalInvoice"
           name="generalInvoice" id="generalInvoice" 
           >
											
											 
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Journal Voucher
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
          ng-model="invoiceInformation.generalVoucher"
           name="generalVoucher" id="generalVoucher" 
           >
											
											 
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-5 control-label"> Payment Order
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
          ng-model="invoiceInformation.paymentOrder"
           name="paymentOrder" id="paymentOrder" 
           >
											
											 
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Receipt
											
										</label>
										<div class="col-md-7">
          <input type="text" class="form-control input-sm"
          ng-model="invoiceInformation.receipt"
           name="receipt" id="receipt" 
           >
											
											 
										</div>
									</div>
								</fieldset>
							</div>
				</div>
						<a id="GLExport" stype="display:none"
						href="filePath/invoiceInformation.xls"
						download="invoiceInformation.xls"></a>
						<!-- Form Action -->
						<div class="form-actions">
					         <div class="row">
						          <div class="col-md-12 ">
						          		 <security:authorize access="hasRole('${form_code}_${view}')">
           							<button class="btn btn-success" ng-click="viewinvoiceInformationReport(invoiceInformation)">
            								<i class="fa fa-search"></i>View Report
           							</button>
           							</security:authorize>
           							 
           							
						           <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="formreset()">
						            <i class="fa fa-undo"></i>Reset
						           </button>
         						 </div>
        						 </div>
       					</div>
         				<br>
         				<div class="row" ng-if="creditTable == true && (invoiceTable == false || generalInvoiceTable == false) && invoiceInformation.invoice == '' && invoiceInformation.generalInvoice == ''||debitTable == true && (invoiceTable == false || generalInvoiceTable == false) && invoiceInformation.invoice == '' && invoiceInformation.generalInvoice == ''">
							<div class="col-xs-12">


								<div class="panel panel-default panel-default-list"
									st-table="displayedCollection" st-safe-src="detailList">
									<div class="col-md-4  p-l-0 p-r-0 pull-right">
										
									</div>
									<div class="panel-body float-left padding-0">
										<div class="table-responsive ">
											<table
												class="table table-striped table-hover dataTable no-footer">
												<thead class="dataTables-Main-Head">
													<tr>
                                                      <!-- <th class="sorting width_12" ng-if="invoiceInformation.creditNote != '' && invoiceInformation.debitNote == ''" st-sort="week">Credit Note No.</th>
														<th class="sorting width_10" ng-if="invoiceInformation.debitNote != '' && invoiceInformation.creditNote == ''" st-sort="week">Debit Note No.</th>
 -->                                                        <th class="sorting width_10" st-sort="week">Invoice No.</th>
                                                        <th class="sorting width_10" st-sort="week">Invoice Date</th>
                                                        <th class="sorting width_10" st-sort="week">Credit/Debit Note</th>
                                                        <th class="sorting width_22" st-sort="week">Company</th>
                                                        <th class="sorting width_22" st-sort="week">Payer</th>
                                                        <th class="sorting width_12" st-sort="week">Voyage</th>
                                                        <th class="sorting width_12" st-sort="week">Amount</th>
                                                        <!-- <th class="sorting width_10" ng-if="invoiceInformation.creditNote != '' && invoiceInformation.debitNote == ''" st-sort="week">Debit Note No.</th>
                                                        <th class="sorting width_12" ng-if="invoiceInformation.debitNote != '' && invoiceInformation.creditNote == ''" st-sort="week" >Credit Note No.</th>
 -->                                                                     </tr>
												</thead>
												<tbody class="dataTables-Main-Body">
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="information in displayedCollection"
														data-ng-click="CheckboxSelect({{$index}})">
                                                     <!-- <td ng-if="invoiceInformation.creditNote != '' && invoiceInformation.debitNote == ''">
                                                         <a ng-click="add(information.creditNoteNo)">
                                                         <span tooltip="{{information.creditNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.creditNoteNo">
                                                          </span>
                                                        </a>
                                                     </td>
                                                     <td ng-if="invoiceInformation.debitNote != '' && invoiceInformation.creditNote == ''">
                                                        
                                                         <a ng-click="debit(information.debitNoteNo)">
              <span tooltip="{{information.debitNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.debitNoteNo"></span>
         </a>
                                                     
                                                     </td> -->
                                                     
                                                     <td ><a ng-click="invoice(information.invoiceNo)" >
               <span tooltip="{{information.invoiceNo}}" class="tool-tip-span font-blue">{{information.invoiceNo}}</span>
              </a></td>
                                                     <td >{{information.invoiceDate}}</td>
                                                     <td ng-if="invoiceInformation.creditNote != '' && invoiceInformation.debitNote == ''">
                                                     <a ng-click="creditNote(information.creditNoteNo)">
        <span tooltip="{{information.creditNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.creditNoteNo">
         </span>
      	</a>
                                                     </td>
                                                     <td ng-if="invoiceInformation.debitNote != '' && invoiceInformation.creditNote == ''">
                                                     <a ng-click="debit(information.debitNoteNo)">
	             <span tooltip="{{information.debitNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.debitNoteNo"></span>
	        </a>
                                                     </td>
                                                     
                                                     
                                                      <td ng-if="creditTable ==true && invoiceInformation.voucher != ''">
                                                     <a ng-click="creditNote(information.creditNoteNo)">
        <span tooltip="{{information.creditNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.creditNoteNo">
         </span>
      	</a>
                                                     </td>
                                                     <td ng-if="debitTable == true && invoiceInformation.voucher != ''">
                                                     <a ng-click="debit(information.debitNoteNo)">
	             <span tooltip="{{information.debitNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.debitNoteNo"></span>
	        </a>
                                                     </td>
                                                     
                                                     <td>{{information.companyName}}</td>
                                                     <td>{{information.payerName}}</td>
                                                     <td >{{information.voyage}}</td>
                                                     <td >{{information.amount}}</td>
                                                     <!-- <td ng-if="invoiceInformation.creditNote != '' && invoiceInformation.debitNote == ''">{{information.debitNoteNo}}</td>
                                                     <td ng-if="invoiceInformation.debitNote != '' && invoiceInformation.creditNote == ''">{{information.creditNoteNo}}</td>
 -->                                                     
                                                                                               
													</tr>
												</tbody>
											</table>
										</div>
										<footer class="panel-footer panel-footer-list">
											<%@include file="/views/templates/panel-footer.jsp"%>
										</footer>
									</div>
								</div>
        </div>
        </div>	
        
        <div class="row" ng-if="invoiceTable == true && (creditTable == false || generalInvoiceTable == false) && invoiceInformation.creditNote == '' && invoiceInformation.debitNote == '' || generalInvoiceTable == true && (creditTable == false || generalInvoiceTable == false) && invoiceInformation.creditNote == '' && invoiceInformation.debitNote == ''">
       <div class="col-xs-12">


        <div class="panel panel-default panel-default-list"
         st-table="displayedCollection" st-safe-src="detailList">
         <div class="col-md-4  p-l-0 p-r-0 pull-right">
          
         </div>
         <div class="panel-body float-left padding-0">
          <div class="table-responsive ">
           <table
            class="table table-striped table-hover dataTable no-footer">
            <thead class="dataTables-Main-Head">
             <tr>
             <th class="sorting width_10" ng-if="invoiceInformation.invoice != '' && invoiceInformation.generalInvoice == '' " st-sort="week" >Invoice No.</th>
             <th class="sorting width_10" ng-if="invoiceInformation.generalInvoice != '' && invoiceInformation.invoice == ''" st-sort="week" >Invoice No.</th>
             <th class="sorting width_10" ng-if="invoiceInformation.voucher != ''">Invoice No.</th>
                                                        <th class="sorting width_10" st-sort="week">Invoice Date</th>
                                                        <th class="sorting width_10" st-sort="week">Credit Note</th>
                                                        <th class="sorting width_10" st-sort="week">Debit Note</th>
                                                        
                                                        <th class="sorting width_20" st-sort="week">Customer</th>
                                                        <th class="sorting width_20" st-sort="week">Payer</th>
                                                        <th class="sorting width_10" st-sort="week">Voyage</th>
                                                        <th class="sorting width_10" st-sort="week">Vessel</th>
                                                        <th class="sorting width_10" st-sort="week">Amount</th>
                    </tr>
            </thead>
            <tbody class="dataTables-Main-Body">
             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
              ng-repeat="information in displayedCollection"
              data-ng-click="CheckboxSelect({{$index}})">
                                                     
                                                     <td ng-if="invoiceInformation.invoice != '' && invoiceInformation.generalInvoice == ''">
                                                     <a ng-click="invoice(information.invoiceNo)" >
               <span tooltip="{{information.invoiceNo}}" class="tool-tip-span font-blue">{{information.invoiceNo}}</span>
              </a>
                                                    </td>
                                                    <td ng-if="invoiceInformation.generalInvoice != '' && invoiceInformation.invoice == '' ">
                                                     <a ng-click="generalView(invoiceInformation.generalInvoice)">
                <span tooltip="{{invoiceInformation.generalInvoice}}" class="tool-tip-span font-blue">{{invoiceInformation.generalInvoice}}</span>
              </a>
                                                    </td>
                                                    <td ng-if="invoiceInformation.voucher != ''">
                                                     <a ng-click="invoice(information.invoiceNo)" >
               <span tooltip="{{information.invoiceNo}}" class="tool-tip-span font-blue">{{information.invoiceNo}}</span>
              </a>
                                                    </td>
                                                    <td >{{information.invoiceDate}}</td>
                                                    <td >
                                                    <a ng-click="creditNote(information.creditNoteNo)">
        <span tooltip="{{information.creditNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.creditNoteNo">
         </span>
      	</a>
                                                    </td>
                                                    <td >
                                                    <a ng-click="debit(information.debitNoteNo)">
              <span tooltip="{{information.debitNoteNo}}" class="tool-tip-span font-blue" ng-bind="information.debitNoteNo"></span>
         </a>
                                                    </td>
                                                     <td >{{information.customerName}}</td>
                                                     <td >{{information.payerName}}</td>
                                                     <td >{{information.voyage}}</td>
                                                     <td >{{information.vessel}}</td>
                                                     <td >{{information.amount}}</td>
                                                     
                                                                  </tr>
            </tbody>
           </table>
          </div>
          <footer class="panel-footer panel-footer-list">
           <%@include file="/views/templates/panel-footer.jsp"%>
          </footer>
         </div>
        </div>
        </div>
        </div> 
        
        <div class="row" ng-if="journalVoucherTable == true">
       <div class="col-xs-12">


        <div class="panel panel-default panel-default-list"
         st-table="displayedCollection" st-safe-src="detailList">
         <div class="col-md-4  p-l-0 p-r-0 pull-right">
          
         </div>
         <div class="panel-body float-left padding-0">
          <div class="table-responsive ">
           <table
            class="table table-striped table-hover dataTable no-footer">
            <thead class="dataTables-Main-Head">
             <tr>
             <th class="sorting width_14" ng-if="invoiceInformation.voucher != '' && invoiceInformation.generalVoucher == ''" st-sort="week" >Journal Voucher No.</th>
             <th class="sorting width_14" ng-if="invoiceInformation.generalVoucher != '' && invoiceInformation.voucher == ''" st-sort="week" >Journal Voucher No.</th>
                                                        <th class="sorting width_14" st-sort="week" >Journal Voucher Date</th>
                                                        <th class="sorting width_8" st-sort="week" >Narration</th>
                                                        <th class="sorting width_20" st-sort="week" >Company</th>
                                                        <th class="sorting width_10" st-sort="week">Voyage</th>
                                                        <th class="sorting width_10" st-sort="week">Vessel</th>
                                                        <th class="sorting width_10" st-sort="week">Sector</th>
                                                        <th class="sorting width_20" st-sort="week">Acct Head</th>
                                                        <th class="sorting width_20" st-sort="week">Amount</th>
                    </tr>
            </thead>
            <tbody class="dataTables-Main-Body">
             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
              ng-repeat="information in displayedCollection"
              data-ng-click="CheckboxSelect({{$index}})">
                                                     
                                                     <td ng-if="invoiceInformation.voucher != '' && invoiceInformation.generalVoucher == ''">
                                                     <a ng-click="journalVoucher(information.generalVoucher)">
                <span tooltip="{{information.generalVoucher}}" class="tool-tip-span font-blue">{{information.generalVoucher}}</span>
              </a>
                                                    </td>
                                                    <td ng-if="invoiceInformation.generalVoucher != '' && invoiceInformation.voucher == ''">
                                                     <a ng-click="journalVoucher(information.generalVoucher)"> 
		             <span tooltip="{{information.generalVoucher}}" class="tool-tip-span font-blue">{{information.generalVoucher}}</span>
		         </a>
                                                    </td>
                                                     <td >{{information.jvDate}}</td>
                                                     <td >{{information.narration}}</td>
                                                     <td >{{information.companyName}}</td>
                                                     <td >{{information.voyage}}</td>
                                                     <td >{{information.vessel}}</td>
                                                     <td >{{information.sector}}</td>
                                                     <td >{{information.acctHeadName}}</td>
                                                     <td >{{information.amount}}</td>
                                                     
                                                                  </tr>
            </tbody>
           </table>
          </div>
          <footer class="panel-footer panel-footer-list">
           <%@include file="/views/templates/panel-footer.jsp"%>
          </footer>
         </div>
        </div>
        </div>
        </div>
        
        
        <div class="row" ng-if="purchaseInvoiceTable == true">
       <div class="col-xs-12">


        <div class="panel panel-default panel-default-list"
         st-table="displayedCollection" st-safe-src="detailList">
         <div class="col-md-4  p-l-0 p-r-0 pull-right">
          
         </div>
         <div class="panel-body float-left padding-0">
          <div class="table-responsive ">
           <table
            class="table table-striped table-hover dataTable no-footer">
            <thead class="dataTables-Main-Head">
             <tr>
             
                                                        <th class="sorting width_10" st-sort="week" >Purchase Invoice No</th>
                                                        <th class="sorting width_10" st-sort="week" >Purchase Invoice Date</th>
                                                        <th class="sorting width_10" st-sort="week">Credit Note</th>
                                                        <th class="sorting width_10" st-sort="week">Debit Note</th>
                                                        <th class="sorting width_15" st-sort="week" >Supplier</th>
                                                        <th class="sorting width_15" st-sort="week">Company</th>
                                                        <th class="sorting width_10" st-sort="week">Purchase Order No</th>
                                                        <th class="sorting width_10" st-sort="week">Amount</th>
                                                       
                    </tr>
            </thead>
            <tbody class="dataTables-Main-Body">
             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
              ng-repeat="information in displayedCollection"
              data-ng-click="CheckboxSelect({{$index}})">
                                                     
                                                    
                                                     <td><a ng-click="purchaseInvoice(information.purchaseInvoiceNo)"><span tooltip="{{information.purchaseInvoiceNo}}" class="tool-tip-span font-blue">{{information.purchaseInvoiceNo}}</span></a></td>
                                                     <td >{{information.invoiceDate}}</td>
                                                     <td >{{information.creditNoteNo}}</td>
                                                     <td >{{information.debitNoteNo}}</td>
                                                     <td >{{information.supplier}}</td>
                                                     <td >{{information.company}}</td>
                                                     <td >{{information.purchaseOrderNo}}</td>
                                                     <td >{{information.amount}}</td>
                                                    
                                                     
                                                                  </tr>
            </tbody>
           </table>
          </div>
          <footer class="panel-footer panel-footer-list">
           <%@include file="/views/templates/panel-footer.jsp"%>
          </footer>
         </div>
        </div>
        </div>
        </div>
        
        <div class="row" ng-if="paymentOrderTable == true">
       <div class="col-xs-12">


        <div class="panel panel-default panel-default-list"
         st-table="displayedCollection" st-safe-src="detailList">
         <div class="col-md-4  p-l-0 p-r-0 pull-right">
          
         </div>
         <div class="panel-body float-left padding-0">
          <div class="table-responsive ">
           <table
            class="table table-striped table-hover dataTable no-footer">
            <thead class="dataTables-Main-Head">
             <tr>
             
                                                        <th class="sorting width_10" st-sort="week" >Payment Order No</th>
                                                        <th class="sorting width_10" st-sort="week" >Payment Order Date</th>
                                                        <th class="sorting width_10" st-sort="week" >Purchase Invoice No</th>
                                                        <th class="sorting width_15" st-sort="week">Company</th>
                                                        <th class="sorting width_15" st-sort="week">Amount</th>
                                                       
                    </tr>
            </thead>
            <tbody class="dataTables-Main-Body">
             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
              ng-repeat="information in displayedCollection"
              data-ng-click="CheckboxSelect({{$index}})">
                                                     
                                                    
                                                     <td >{{information.paymentOrderNO}}</td>
                                                     <td >{{information.paymentOrderDate}}</td>
                                                     <td><a ng-click="purchaseInvoice(information.purchaseInvoiceNo)"><span tooltip="{{information.purchaseInvoiceNo}}" class="tool-tip-span font-blue">{{information.purchaseInvoiceNo}}</span></a></td>
                                                     <td >{{information.company}}</td>
                                                     <td >{{information.amount}}</td>
                                                    
                                                     
                                                                  </tr>
            </tbody>
           </table>
          </div>
          <footer class="panel-footer panel-footer-list">
           <%@include file="/views/templates/panel-footer.jsp"%>
          </footer>
         </div>
        </div>
        </div>
        </div>
        
        <div class="row" ng-if="paymentTable == true">
       <div class="col-xs-12">


        <div class="panel panel-default panel-default-list"
         st-table="displayedCollection" st-safe-src="detailList">
         <div class="col-md-4  p-l-0 p-r-0 pull-right">
          
         </div>
         <div class="panel-body float-left padding-0">
          <div class="table-responsive ">
           <table
            class="table table-striped table-hover dataTable no-footer">
            <thead class="dataTables-Main-Head">
             <tr>
             
                                                        <th class="sorting width_14" st-sort="week" >Voucher No</th>
                                                        <th class="sorting width_8" st-sort="week" >Voucher Date</th>
                                                        <th class="sorting width_20" st-sort="week" >Payment Type</th>
                                                        <th class="sorting width_10" st-sort="week">Paid To</th>
                                                       <th class="sorting width_10" st-sort="week">Cheque No</th>
                                                       <th class="sorting width_10" st-sort="week">Cheque Date</th>
                                                       <th class="sorting width_10" st-sort="week">Company</th>
                                                       <th class="sorting width_10" st-sort="week">Amount</th>
                    </tr>
            </thead>
            <tbody class="dataTables-Main-Body">
             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
              ng-repeat="information in displayedCollection"
              data-ng-click="CheckboxSelect({{$index}})">
                                                     
                                                    
                                                     <td ><a ng-click="payment(information.voucherNo)"><span tooltip="{{information.voucherNo}}" class="tool-tip-span font-blue">{{information.voucherNo}}</span></a></td>
                                                     <td >{{information.voucherDate}}</td>
                                                     <td >{{information.paymentType}}</td>
                                                     <td >{{information.paidTo}}</td>
                                                     <td >{{information.chequeNo}}</td>
                                                      <td >{{information.chequeDate}}</td>
                                                       <td >{{information.company}}</td>
                                                        <td >{{information.amount}}</td>
                                                    
                                                     
                                                                  </tr>
            </tbody>
           </table>
          </div>
          <footer class="panel-footer panel-footer-list">
           <%@include file="/views/templates/panel-footer.jsp"%>
          </footer>
         </div>
        </div>
        </div>
        </div>
        
        <div class="row" ng-if="receiptTable == true">
       <div class="col-xs-12">


        <div class="panel panel-default panel-default-list"
         st-table="displayedCollection" st-safe-src="detailList">
         <div class="col-md-4  p-l-0 p-r-0 pull-right">
          
         </div>
         <div class="panel-body float-left padding-0">
          <div class="table-responsive ">
           <table
            class="table table-striped table-hover dataTable no-footer">
            <thead class="dataTables-Main-Head">
             <tr>
             
                                                        <th class="sorting width_12" st-sort="week" >Voucher No</th>
                                                        <th class="sorting width_10" st-sort="week" >Voucher Date</th>
                                                        <th class="sorting width_10" st-sort="week" >Payment Type</th>
                                                        <th class="sorting width_12" st-sort="week">Received From</th>
                                                       <th class="sorting width_10" st-sort="week">Cheque No</th>
                                                       <th class="sorting width_10" st-sort="week">Cheque Date</th>
                                                       <th class="sorting width_12" st-sort="week">Company</th>
                                                       <th class="sorting width_12" st-sort="week">Amount</th>
                    </tr>
            </thead>
            <tbody class="dataTables-Main-Body">
             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
              ng-repeat="information in displayedCollection"
              data-ng-click="CheckboxSelect({{$index}})">
                                                     
                                                    
                                                     <td ><a ng-click="receipt(information.voucherNo)"><span tooltip="{{information.voucherNo}}" class="tool-tip-span font-blue">{{information.voucherNo}}</span></a></td>
                                                     <td >{{information.voucherDate}}</td>
                                                     <td >{{information.paymentType}}</td>
                                                     <td >{{information.receivedFrom}}</td>
                                                     <td >{{information.chequeNo}}</td>
                                                      <td >{{information.chequeNo}}</td>
                                                       <td >{{information.company}}</td>
                                                       <td >{{information.amount}}</td>
                                                    
                                                     
                                                                  </tr>
            </tbody>
           </table>
          </div>
          <footer class="panel-footer panel-footer-list">
           <%@include file="/views/templates/panel-footer.jsp"%>
          </footer>
         </div>
        </div>
        </div>
        </div>
        
        
					</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>
