<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="generalInvoiceForm">
				<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="col-sm-4 col-md-4 col-lg-4">
						<fieldset>
							<!-- <div class="form-group">
           						<label class="control-label col-md-5">Invoice Date <span style="color: red;">*</span></label>
           						<div class="col-md-7">
									<div class='input-group date datetimepick'>
										<div class="dropdown">
											<a class="dropdown-toggle" id="invoiceDate" role="button"
												data-toggle="dropdown" data-target="#" href="#">
												<div class="input-group">
													<input type="text" class="form-control" placeholder="dd/mm/yyyy" 
													name="Invoice Date" data-ng-model="invoiceData.invoiceDate"
													 validation="date_euro_long|required" friendly-name="Invoice Date"  />
														<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
												</div>
											</a>
											<ul class="dropdown-menu" role="menu"
												aria-labelledby="dLabel">
												<datetimepicker data-ng-model="invoiceData.invoiceDate" data-on-set-time="invoiceData.invoiceDate = onDateSet(newDate)"
													data-datetimepicker-config="{ dropdownSelector: '#invoiceDate',startView:'day', minView:'day'}" />
											</ul>
										</div>
									</div>
								</div>
	         				</div>	 -->
	         				
	         				
	         				<div class="form-group ">
								<label class="col-md-5 control-label">Invoice Date <span style="color: red;">*</span>  </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="true" data-ng-model="invoiceData.invoiceDate"
										id="invoiceDate" name="party Invoice Date"
										data-ng-change="checkDatesCL(invoiceData.invoiceDate)"
										friendly-name="Invoice Date" validation="required" />
								</div>
								</div>
	         				
	         				<!-- <div class="form-group">
								<label class="col-md-5 control-label"> GIN
								</label>
								<div class="col-md-7" ng-hide="isEdit">
									 <select class="form-control input-sm" name="Sales No" ng-model="invoiceData.salesOrderNo"
									data-ng-options="r.id as r.text for r in salesOrderList" ng-change="getsalesOrderDetail(invoiceData.salesOrderNo)">
										<option value="" selected="selected">--Select--</option>
									</select>
									<selectivity list="ginList" id="ginId" name="GIN" 
									property="invoiceData.ginId" object="ginObj"></selectivity>
								</div>
								<div class="col-md-7" ng-show="isEdit">
									<input type="text" class="form-control input-sm" readonly ng-model="invoiceData.ginCode"
										name="GIN">
								</div>
							</div> -->	
							<div class="form-group">
								<label class="col-md-5 control-label"> Customer <span style="color: red;">*</span>
								</label>
								<div class="col-md-7" ng-if="isEdit">
									<selectivity ng-if="isEdit" list="customerList" id="customer" name="customer" 
									property="invoiceData.customer" ng-model="invoiceData.customer" object="customer"
									validation="required" friendly-name="Hospital" form-name="generalInvoiceForm" disabled="true"></selectivity>
									
								</div>
								<div class="col-md-7" ng-if="!isEdit">
								<selectivity ng-if="!isSalesOrderNo" list="customerList" id="customer" name="customer" 
									property="invoiceData.customer" ng-model="invoiceData.customer" object="customer"
									validation="required" friendly-name="Hospital" form-name="generalInvoiceForm" ></selectivity>
									<selectivity ng-if="isSalesOrderNo" list="customerList" id="customer" name="customer" 
									property="invoiceData.customer" ng-model="invoiceData.customer" object="customer"
									validation="required" friendly-name="Hospital" form-name="generalInvoiceForm" disabled="true"></selectivity>
									
								
								</div>
							</div>								
						</fieldset>
					</div>
				   <!--  <div class="col-sm-4 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group" style = "display:none">
								<label class="col-md-5 control-label"> Company
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									 <select class="form-control input-sm" name="Company" ng-model="invoiceData.company" data-ng-options="r.id as r.text for r in companyList">
										<option value="" selected="selected">--Select--</option>
									</select> 
									<selectivity ng-if="!isEdit" list="companyList" id="company_id" name="companyName" 
									property="invoiceData.company" ng-model="invoiceData.company" object="company"
									validation="required" friendly-name="companyName" form-name="generalInvoiceForm"></selectivity>
									<selectivity ng-if="isEdit" list="companyList" id="company_id" name="companyName" 
									property="invoiceData.company" ng-model="invoiceData.company" object="company"
									validation="required" friendly-name="companyName" form-name="generalInvoiceForm" disabled="true"></selectivity>
									
								</div>
							</div>
							<div class="form-group">
							<label class="col-md-5 control-label"> Currency
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" readonly ng-model="invoiceData.currency"
									name="Currency">
								<select class="form-control input-sm" name="Currency" ng-model="purchaseInvoiceData.currency" 
								data-ng-options="r.id as r.text for r in currencyList"
								ng-change="getExchangeRate(purchaseInvoiceData.currency)" >
									<option value="" selected="selected">--Select--</option>
								</select>
								<selectivity list="currencyList" id="company_id" name="Currency" 
								property="invoiceData.currency" ng-model="invoiceData.currency" object="currencyObj"
								validation="required" friendly-name="Currency" form-name="generalInvoiceForm"></selectivity>
							</div>
						</div>
							
						<div class="form-group">
							<label class="col-md-5 control-label"> Exchange Rate</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" name="Exchange Rate"
								ng-model="invoiceData.exchangeRate" readonly />
							</div>
						</div>
							
							<div class="form-group">
								<label class="col-md-5 control-label">Amount <span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="invoiceData.amount" id="Amount"
										name="Amount" ng-keyup="amountCalculation(invoiceData.amount)" data-ng-change="onChangeNumber('Amount',invoiceData.amount)">
								</div>
							</div>
						</fieldset>
					</div> -->
					
					<div class="col-sm-4 col-md-4 col-lg-4">
						<div class="form-group">
								<label class="col-md-5 control-label"> Manual Invoice No 
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="Manual Invoice No" 
									ng-model="invoiceData.manualInvoiceNo" friendly-name="Manual Invoice No" maxlength="30"/>
								</div>
							</div>
							
							<!-- <div class="form-group">
	         				<label for="inputPassword" class="control-label col-md-5">Due Date<span style="color: red;">*</span></label>
	       					<div class="col-md-7">
								<div class='input-group date datetimepick'>
									<div class="dropdown">
										<a class="dropdown-toggle" id="dueDate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="due Date" 
												data-message-id="due Date"
												 validation="date_euro_long|required" friendly-name="Due Date" 
													data-ng-model="invoiceData.dueDate"><span class="input-group-addon" 
													style=" width: 44px;"><i class="glyphicon glyphicon-calendar"></i></span>
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="invoiceData.dueDate" data-on-set-time="invoiceData.dueDate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#dueDate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
	       				</div> -->
	       				
	       				<div class="form-group ">
								<label class="col-md-5 control-label">Due Date <span style="color: red;">*</span>  </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="invoiceData.dueDate"
										id="dueDate" name="Due Date"
										data-ng-change="checkDatesCL(invoiceData.dueDate)"
										friendly-name="Due Date" validation="required" />
								</div>
								</div>
	       				
	         				
						<!-- <div class="form-group">
							<label class="col-md-5 control-label">TC Amount</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" 
								ng-model="invoiceData.tcamount" name="TC Amount"
								 ng-keyup="amountLocalCalculation(invoiceData.tcamount)" />
							</div>
						</div> -->	
						<div class="form-group">
   							<label for="inputPassword" class="control-label col-md-5">Remarks</label>
 								<div class="col-md-7">
  									<textarea rows="2" class="form-control" name="Description" 
  									ng-model="invoiceData.remarks" maxlength="100"></textarea>
 								</div>
       					</div>			
					</div>
					
					<div class="form-group" style = "display:none">
								<label class="col-md-5 control-label"> Company
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<!--  <select class="form-control input-sm" name="Company" ng-model="invoiceData.company" data-ng-options="r.id as r.text for r in companyList">
										<option value="" selected="selected">--Select--</option>
									</select>  -->
									<selectivity ng-if="!isEdit" list="companyList" id="company_id" name="companyName" 
									property="invoiceData.company" ng-model="invoiceData.company" object="company"
									validation="required" friendly-name="companyName" form-name="generalInvoiceForm"></selectivity>
									<selectivity ng-if="isEdit" list="companyList" id="company_id" name="companyName" 
									property="invoiceData.company" ng-model="invoiceData.company" object="company"
									validation="required" friendly-name="companyName" form-name="generalInvoiceForm" disabled="true"></selectivity>
									
								</div>
							</div>
				</div> <!-- /col-sm-12 -->
			</div> <!-- /book-widget-row -->
			<!-- <div class="table-responsive clear"> Start of Product table
				<div class="legendStyle" >Item List</div>
			    <table class="table table-striped b-t b-light">
			    	<thead>
			        	<tr>
				            <th colspan=1 class="width_1" ng-if="!isEdit"></th>
				            <th colspan=1  class="width_1 text-center">SI.No</th>
				            <th colspan=1  class="width_13 text-center">Item</th>
				            <th colspan=1  class="width_10 text-center">Quantity</th>
				            <th colspan=1  class="width_10 text-center">Unit price</th>
				            <th colspan=1  class="width_10 text-center">Tax Amount</th>
				            <th colspan=1  class="width_10 text-center">Amount</th>
			        	</tr>
			        </thead>
			        <tbody ng-repeat="(trIndex, row) in invoiceData.invoiceProdDetail" ng-controller="parentCtrl">
				    	<tr>
				  			<td ng-if="!isEdit"><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
				   			<td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>
							<td ng-if="!isEdit">
								<select class="form-control input-sm" name="itemCode" ng-model="row.itemId" data-ng-options="r.id as r.text for r in itemList">
											<option value="" selected="selected">--Select--</option>
								</select> 
								<selectivity list="chargeList" id="cmbItemId" name="{{ 'Item' + $index }}" 
								 property="row.itemId"  ng-model="row.itemId" object="itemListObj" form-name="generalInvoiceForm"
								validation="required"  friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}" disabled="isSalesOrderNo"></selectivity>
							</td>
							<td ng-if="isEdit">
								<select class="form-control input-sm" name="itemCode" ng-model="row.itemId" data-ng-options="r.id as r.text for r in itemList">
											<option value="" selected="selected">--Select--</option>
								</select> 
								<selectivity list="itemList" id="cmbItemId" name="{{ 'Item' + $index }}" 
								 property="row.itemId"  ng-model="row.itemId" object="itemListObj" form-name="generalInvoiceForm"
								validation="required"  friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}" disabled="true"></selectivity>
							</td>
							
				       		<td> 
				       			<div class="row">
						            <div class="col-xs-12" ng-if="!isEdit">
							             <input type="text" class="form-control input-sm" id="quantity{{trIndex}}" ng-model="row.quantity"  name="quantity"
							             validation="integer" friendly-name="Quantity" ng-pattern-restrict="^[0-9]*$"
							             ng-keyup="calculateProductAmount(invoiceData.invoiceProdDetail)" ng-disabled="isSalesOrderNo" />
							             
							        </div>
							        <div class="col-xs-12" ng-if="isEdit">
							             <input type="text" class="form-control input-sm" id="quantity{{trIndex}}" ng-model="row.quantity"  name="quantity"
							             validation="integer" friendly-name="Quantity" ng-pattern-restrict="^[0-9]*$"
							             ng-keyup="calculateProductAmount(invoiceData.invoiceProdDetail)" disabled="true" />
							             
							        </div>
						        </div>
					        </td>
					        <td> 
					        	<div class="row">
					            	<div class="col-xs-12" ng-if="!isEdit">
						             <input type="text" class="form-control input-sm"  id="unitprice{{trIndex}}" ng-model="row.unitprice" name="unitprice"
						              validation="numeric" friendly-name="Product Unit Price" data-ng-blur="onChangeDecimal('unitprice'+trIndex,row.unitprice)"
						              step="0.01"  ng-keyup="calculateProductAmount(invoiceData.invoiceProdDetail)" ng-pattern-restrict="{{numExp}}" ng-disabled="isSalesOrderNo" />
						      		</div>
						      		
						      		<div class="col-xs-12" ng-if="isEdit">
						             <input type="text" class="form-control input-sm"  id="unitprice{{trIndex}}" ng-model="row.unitprice" name="unitprice"
						              validation="numeric" friendly-name="Product Unit Price" data-ng-blur="onChangeDecimal('unitprice'+trIndex,row.unitprice)"
						              step="0.01"  ng-keyup="calculateProductAmount(invoiceData.invoiceProdDetail)" ng-pattern-restrict="{{numExp}}" disabled="true" />
						      		</div>
						        </div>
					        </td>
					        <td> 
					        	<div class="row">
					            	<div class="col-xs-12" ng-if="!isEdit">
						             <input type="text" class="form-control input-sm"  ng-keyup="calculateProductAmount(invoiceData.invoiceProdDetail)"  id="taxamount{{trIndex}}" ng-model="row.taxAmount" name="taxamount" ng-disabled="isSalesOrderNo" />
						      		</div>
						      		<div class="col-xs-12" ng-if="isEdit">
						             <input type="text" class="form-control input-sm"  ng-keyup="calculateProductAmount(invoiceData.invoiceProdDetail)"  id="taxamount{{trIndex}}" ng-model="row.taxAmount" name="taxamount" disabled="true" />
						      		</div>
						      		
						        </div>
					        </td>
					        <td> 
					        	<div class="row">
					            	<div class="col-xs-12">
						             <input type="text" class="form-control input-sm"  id="amount{{trIndex}}" ng-model="row.amount" name="amount" readonly>
						      		</div>
						        </div>
					        </td>
				       	</tr>
			        </tbody>
			    </table>
			    <div class="padding-right-5" >
			    	<div class="col-md-4" ng-if="!isEdit">
		          		<button  ng-click="addProdRow(invoiceData.invoiceProdDetail)" class="btn btn-sm btn-info" tooltip="Add Row" type="button"  ng-if="!isSalesOrderNo">
				        <i class="fa fa-plus"></i>
				        </button>
				        <button  ng-click="removeProdRow(invoiceData.invoiceProdDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete"  ng-if="!isSalesOrderNo">
				        <i class="fa  fa-trash-o"></i>
				        </button>
			        </div>
			        <div class="col-md-4" ng-if="isEdit">
			        </div>
			        <div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Cost Center </label>
							<div class="col-md-7">
								<select class="form-control" ng-model="invoiceData.costCenter" 
								        					ng-options="ac.costCenter as ac.text for ac in costCenterList" >
								</select>
							</div>
						</div>
					</div>
			        <div class="col-md-4">
			       	 <div class="form-group">
						
							<label class="col-md-5 control-label">Total </label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" ng-model="invoiceData.productTotalWithoutTax" readonly
								name="BC Total" placeholder="0.0">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-5 control-label">Total </label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm" ng-model="invoiceData.productTotal" readonly
								name="BC Total" placeholder="0.0">
							</div>
						</div>
					</div>
			    </div>
			</div>  --><!-- /table-responsive -End of product table -->
			<div class="table-responsive clear"> <!-- /table-responsive - Start of charges table -->
				<div class="legendStyle" >Charges List</div>
			    <table class="table table-striped b-t b-light">
			    	<thead>
			        	<tr>
				            <th colspan=1 class="width_1" ng-if="!isEdit"></th>
				            <th colspan=1  class="width_1 text-center">SI.No</th>
				            <th colspan=1  class="width_13 text-center">Charges</th>
				            <th colspan=1  class="width_10 text-center">Short Details</th>
				             <th colspan=1  class="width_10 text-center">Tax(%)</th>
				            <th colspan=1  class="width_10 text-center">Amount</th>
				           	<!--  <th  colspan=1 class="width_1"></th> -->
			          	</tr>
			        </thead>
			        <tbody ng-repeat="(trIndex, row) in invoiceData.invoiceDetail"
			        ng-controller="tableCtrlnew">
				    	<tr>
				  			<td ng-if="!isEdit"><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
				   			<td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>				
							<td>
								<!-- <select class="form-control input-sm" name="accountheadcode" ng-model="row.accountHeadCode" data-ng-options="r.id as r.text for r in chargeList">
											<option value="" selected="selected">--Select--</option>
								</select>  -->
								<selectivity list="chargeList" ng-if="!isEdit" id="cmbChargeCode" name="{{ 'accountheadcode' + $index }}" 
								 property="row.accountHeadCode"  ng-model="row.accountHeadCode" object="chargeListObj" form-name="generalInvoiceForm"
								 friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"></selectivity>
								 
								 <selectivity list="chargeList" ng-if="isEdit" id="cmbChargeCode" name="{{ 'accountheadcode' + $index }}" 
								 property="row.accountHeadCode"  ng-model="row.accountHeadCode" object="chargeListObj" form-name="generalInvoiceForm"
								 friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}" disabled=true></selectivity>
							</td>				
				       		<td> 
				       			<div class="row">
						            <div class="col-xs-12">
							             <input type="text" ng-if="!isEdit" class="form-control input-sm" id="shortDetails{{trIndex}}" ng-model="row.shortDetail"  name="shortDetail">
							             
							              <input type="text" ng-if="isEdit" class="form-control input-sm" id="shortDetails{{trIndex}}" ng-model="row.shortDetail"  name="shortDetail" readonly>
							        </div>
						        </div>
					        </td>					       
					       <td> 
				       			<div class="row">
						            <div class="col-xs-12">
						            
						            
						            
							             <selectivity list="taxList" ng-if="!isEdit" id="tax" 
							             name="{{ 'tax' + $index }}" 
								 property="row.tax"  ng-model="row.tax" object="tax"
								  form-name="generalInvoiceForm"
								 friendly-name="{{ 'Row ' + $index + ' (Tax)'}}"></selectivity>
								 
								 
								    <input type="text" ng-if="isEdit" class="form-control input-sm"
								     id="tax{{trIndex}}" ng-model="row.tax"  name="tax" readonly>
								 
								<!--  <selectivity list="taxList" ng-if="isEdit" id="tax" name="{{ 'tax' + $index }}" 
								 property="row.tax"  ng-model="row.tax" object="tax" form-name="generalInvoiceForm"
								 friendly-name="{{ 'Row ' + $index + ' (Tax)'}}" disabled=true></selectivity> -->
						
							      
							        </div>
						        </div>
					        </td>	
					        <td> 
					        	<div class="row">
					            	<div class="col-xs-12">
						             <input type="text" class="text-right form-control input-sm"  id="amounts{{trIndex}}" ng-model="row.amount" name="amount" ng-if="!isEdit"
						             validation="numeric" friendly-name="Charge Amount" data-ng-blur="onChangeDecimal('amounts'+trIndex,row.amount)"
						              ng-keyup="calculateChargeAmount(invoiceData.invoiceDetail)" ng-pattern-restrict="{{numExp}}">
						              
						               <input type="text" ng-if="isEdit" class="form-control input-sm"  id="amounts{{trIndex}}" ng-model="row.amount" name="amount"
						             validation="numeric" friendly-name="Charge Amount" data-ng-blur="onChangeDecimal('amounts'+trIndex,row.amount)"
						              ng-keyup="calculateChargeAmount(invoiceData.invoiceDetail)" ng-pattern-restrict="{{numExp}}" readonly>
						              
						      		</div>
						        </div>
					        </td>
				       	</tr>
				       	<td colspan="12">
												<div class="col-sm-12">


													<div class="col-md-4" ng-if="row.isCostCenter"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> CostCtr</label>
														<div class="col-md-9">
															<selectivity list="costCenterListnew"
																ng-model="row.costCenter" property="row.costCenter"
																id="costCenterId{{trIndex}}">{{row.costCenter}}</selectivity>


														</div>
													</div>


													<div class="col-md-4" ng-if="row.isEmployee"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> Employee</label>
														<div class="col-md-9">
															<selectivity list="employeeList"
																ng-model="row.employeeCode" property="row.employeeCode"
																id="employeeCode{{trIndex}}">{{row.employeeCode}}</selectivity>


														</div>
													</div>
													
													<div class="col-md-4" ng-if="row.isDepartment"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> Students</label>
														<div class="col-md-9">
															<selectivity list="studentList"
																ng-model="row.departmentCode" property="row.departmentCode"
																id="departmentCode{{trIndex}}">{{row.departmentCode}}</selectivity>


														</div>
													</div>

												</div>
											</td>
			        </tbody>
			   	</table>
			   	
				<div class="padding-right-5">
			      	<div class="col-md-4">
		          		<button ng-if="!isEdit" ng-click="addRow(invoiceData.invoiceDetail)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
				        	<i class="fa fa-plus"></i>
				        </button>
				        <button ng-if="!isEdit" ng-click="removeRow(invoiceData.invoiceDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
				        <i class="fa  fa-trash-o"></i>
				        </button>
			        </div>
			        <div class="col-md-4" ng-if="isEdit">
			        </div>
			        <!-- <div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Cost Center </label>
							<div class="col-md-7">
								<select class="form-control" ng-model="invoiceData.costCenter" 
								        					ng-options="ac.costCenter as ac.text for ac in costCenterList" >
								</select>
							</div>
						</div>
					</div>  -->
					
					
												<!-- <div class="col-sm-12">


													


													<div class="col-md-4" ng-if="row.isEmployee"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> Employee</label>
														<div class="col-md-9">
															<selectivity list="employeeList"
																ng-model="row.employeeCode" property="row.employeeCode"
																id="employeeCode{{trIndex}}">{{row.employeeCode}}</selectivity>


														</div>
													</div>
													
													<div class="col-md-4" ng-if="row.isDepartment"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> Students</label>
														<div class="col-md-9">
															<selectivity list="studentList"
																ng-model="row.departmentCode" property="row.departmentCode"
																id="departmentCode{{trIndex}}">{{row.departmentCode}}</selectivity>


														</div>
													</div>

												</div> -->
											
					
					   
					<div class="col-md-4">					
			       	 <div class="form-group">					
							<label class="col-md-5 control-label">Total </label>
							<div class="col-md-7">
								<input type="text" class="text-right form-control input-sm" ng-model="invoiceData.chargeTotal|number:2" readonly
								name="BC Total" >
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-5 control-label"> Grand Total </label>
							<div class="col-md-7">
								<input type="text" class="text-right form-control input-sm" ng-model="invoiceData.grantamount|number:2" readonly
								name="BC Total" placeholder="0.00">
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
										<button ng-model="add" type="button" class="btn btn-success" ng-if="!isEdit"
											 class="btn btn-success" ng-click="validate(generalInvoiceForm,invoiceData)">
											<i class="fa fa-plus"></i> Save
										</button>
										<button class="btn btn-success"	ng-if="isEdit" type="button"
										ng-click="validate(generalInvoiceForm,invoiceData)">
											<i class="fa fa-save"></i> Update
										</button>
										<button class="btn btn-danger" type="button"
											class="btn btn-success" ng-click="cancel()">
											<i class="fa fa-close"></i> Cancel
										</button>
									</div>
								</div>
							</div><!-- /form-actions -->
						</div>
					</div> <!-- /col-sm-12 -->
				</div> <!-- /row -->
			</div> <!-- /table-responsive  - End of Charges Table -->	
		</form><!-- Form end -->
      </div> <!-- /row -->
    </div> <!-- /standard-datatable-widget -->
   </article> <!-- WIDGET END -->
  </div>
 </section>
</div>