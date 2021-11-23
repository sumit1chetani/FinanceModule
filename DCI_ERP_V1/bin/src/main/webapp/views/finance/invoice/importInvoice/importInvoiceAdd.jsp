<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}

.tooltip {
	background-color: #000;
	border: 1px solid #fff;
	padding: 10px 15px;
	width: 200px;
	display: none;
	color: #fff;
	text-align: left;
	font-size: 12px;
	/* outline radius for mozilla/firefox only */
	-moz-box-shadow: 0 0 10px #000;
	-webkit-box-shadow: 0 0 10px #000;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="generalInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<input type="hidden" ng-model="generalinvoice.ExchangeRateFrom"
						id="ExchangeRateFrom" /> <input type="hidden"
						ng-model="generalinvoice.ExchangeRateTo" id="ExchangeRateTo" /> <input
						type="hidden" ng-model="generalinvoice.currencyValue"
						id="currencyValue" /> <input type="hidden"
						ng-model="generalinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity ng-if="generalinvoice.isEdit"
											disabled="generalinvoice.isEdit" list="companyList"
											property="generalinvoice.CompanyCode" name="companyCode"
											ng-model="generalinvoice.CompanyCode" validation="required"
											friendly-name="Company" form-name="generalInvoiceForm"></selectivity>
									</div>
									<div class="col-md-7">
										<selectivity ng-if="!generalinvoice.isEdit" list="companyList"
											property="generalinvoice.CompanyCode" name="companyCode"
											ng-model="generalinvoice.CompanyCode" validation="required"
											friendly-name="Company" form-name="generalInvoiceForm"></selectivity>
									</div>
								</div>
							</div>
<div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">BL Wise Search<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right" property="generalinvoice.blSearch"
											name="blSearch" ng-model="generalinvoice.blSearch"
											id="blSearch" friendly-name="blSearch" />
										<!-- validation="required" friendly-name="Vessel" form-name = "generalInvoiceForm"  -->
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Invoice
										Date<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="generalinvoice.InvoiceDate"
											id="InvoiceDate" name="InvoiceDate"
											form-name="generalInvoiceForm"
											data-ng-change="checkDatesCL(generalinvoice.InvoiceDate)"
											friendly-name="Invoice Date" validation="required" />
										<!-- 	   									<div class="input-group input-append date" id="invoice_date"> -->
										<!-- 								          <input type="text" class="form-control input-sm" name="Invoice Date" id="txtInvoiceDate"  -->
										<!-- 								          ng-model="generalinvoice.InvoiceDate" placeholder='dd/mm/yyyy'  -->
										<!-- 								          friendly-name="Invoice Date" validation="required" /> -->
										<!-- 								          <span class="input-group-addon add-on"> -->
										<!-- 								           <span class="glyphicon glyphicon-calendar"></span> -->
										<!-- 								          </span> -->
										<!-- 								        </div>   									 -->
									</div>
								</div>
							</div>
							
							<div class="col-md-1">
								<div class="form-group">
									<label class="col-md-5 control-label"> </label> 
								</div>
							</div>

							<div class="col-md-2" style="padding-left: 109px;" >
								<div class="form-group">
									<label class="col-md-5 control-label">BL Related</label> <label
										class="col-md-1 control-label"> <input type="checkbox"
										name="blrelated" id="blrelated"
										ng-model="generalinvoice.BlRelated">
									</label>
								</div>
							</div>
								<div class="col-md-1">
								<div class="form-group">
									<label class="col-md-5 control-label" style="padding-right: 55px;">Survey Related</label>  <input type="checkbox"
										name="surveyorrelated" id="surveyorrelated"
										ng-model="generalinvoice.surveyorrelated">
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="VesselhdrList"
											property="generalinvoice.VesselName" id="VesselName"
											ng-model="generalinvoice.VesselName" name="VesselName"></selectivity>
										<!-- validation="required" friendly-name="Vessel" form-name = "generalInvoiceForm"  -->
									</div>
								</div>
							</div>
							<div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;"></span></label>
									<div class="col-md-7">

										<selectivity list="voyagehdrList"
											property="generalinvoice.Voyage"
											ng-model="generalinvoice.Voyage" name="Voyage" id="Voyage"></selectivity>
										<!-- validation="required" friendly-name="Voyage" form-name = "generalInvoiceForm" -->

									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
									<selectivity list="PorthdrList"
											property="generalinvoice.Pol" id="Pol"
											name="Pol" ng-model="generalinvoice.Pol"
											validation="required" friendly-name="Pol"
											form-name="generalInvoiceForm"></selectivity>
										<!-- <selectivity list="PorthdrList" property="generalinvoice.Pol" 
											id="Pol"></selectivity> -->



									</div>
								</div>
							</div>


						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="customerhdrList"
											property="generalinvoice.CustomerName" id="customer"
											name="customer" ng-model="generalinvoice.CustomerName"
											validation="required" friendly-name="Customer"
											form-name="generalInvoiceForm"></selectivity>


									</div>
								</div>
							</div>
							
							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Payer<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<ui-select ng-model="generalinvoice.MloName"
											ng-disabled="disabled" appendToBody="true"> <ui-select-match
											placeholder="Select a payer...">{{$select.selected.text}}</ui-select-match>
										<ui-select-choices
											repeat="mlo.id as mlo in mloList | propsFilter: {id: $select.search,text: $select.search, payerShortName: $select.search,payerAddress:$select.search} | limitTo: display_limit"
											buffered-scroll="increaseLimit();">
										<div class="col-md-12 col-sm-12 col-lg-12 pt-lr-0">
											<div class="col-md-4 pull-left pt-lr-1"
												ng-bind-html="mlo.payerShortName | highlight: $select.search"></div>
											<div class="col-md-4 pull-left pt-lr-1"
												ng-bind-html="mlo.text | highlight: $select.search"></div>
											<div class="col-md-2 pull-left pt-lr-1"
												ng-bind-html="mlo.Pol | highlight: $select.search"></div>
											<div class="col-md-2 pull-left pt-lr-1"
												ng-bind-html="mlo.Pod | highlight: $select.search"></div>
											<div class="col-md-4  pull-left pt-lr-1"
												ng-bind-html="mlo.payerAddress | highlight: $select.search"></div>
										</div>
										</ui-select-choices>
										<div></div>
										</ui-select>
										<selectivity list="mloList" property="generalinvoice.MloName" id="Mlo" object="MloName"
										 name="Mlo" ng-model="generalinvoice.MloName"
										 validation="required" friendly-name="Payer" form-name = "generalInvoiceForm"></selectivity>
									</div>
								</div>
							</div> -->


							<div class="col-md-4" id="blcheck">
								<div class="form-group" ng-if='generalinvoice.BlRelated'>
									<label class="col-md-5 control-label">BL</label>
									<div class="col-md-7" ng-if="!generalinvoice.isEdit">

										<selectivity list="blList" property="generalinvoice.bl"
											name="bl" validation="required" friendly-name="BL No."
											form-name="generalInvoiceForm" id="bl"
											ng-model="generalinvoice.bl" object="bl"></selectivity>

									</div>
									<div class="col-md-7" ng-if="generalinvoice.isEdit">
<input type="text" class="form-control input-sm text-right" property="generalinvoice.bl"
											name="exchangerate" ng-model="generalinvoice.bl"
											id="bl" friendly-name="bl" validation="required" disabled="true"/>
										

									</div>
								</div>
							</div>
							

							<div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label><span
										style="color: red;">*</span>
									<div class="col-md-7">
									<selectivity list="PorthdrList"
											property="generalinvoice.Pod" id="Pod"
											name="Pod" ng-model="generalinvoice.Pod"
											validation="required" friendly-name="Pod"
											form-name="generalInvoiceForm"></selectivity>
										<!-- <selectivity list="PorthdrList" property="generalinvoice.Pod"
											id="Pod"></selectivity> -->
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency<span
										style="color: red;">*</span></label>
									<div class="col-md-7" ng-if="isFeederCompanyCurrency">
										<!-- <input type="text" class="form-control input-sm" ng-model="generalinvoice.CurrencyName" 
										id="CurrencyName" name="Currency" ng-model="generalinvoice.CurrencyName"
										 validation="required" friendly-name="Currency" form-name = "generalInvoiceForm" /> -->
										<selectivity list="currencyList"
											property="generalinvoice.CurrencyName" name="CurrencyName"
											id="CurrencyName" 
											friendly-name="Currency" form-name="generalInvoiceForm"
											ng-model="generalinvoice.CurrencyName"
											disabled="isFeederCompanyCurrency"></selectivity>
									</div>
									<div class="col-md-7" ng-if="!isFeederCompanyCurrency">
										<selectivity list="currencyList"
											property="generalinvoice.CurrencyName" name="Currency"
											id="CurrencyName" object="currency" validation="required"
											friendly-name="Currency" form-name="generalInvoiceForm"
											ng-model="generalinvoice.CurrencyName"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Exchange Rate <span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											name="exchangerate" ng-model="generalinvoice.ExchangeRate"
											id="exchangerate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
											ng-blur="exchagerateGIhdr(generalinvoice.ExchangeRate)"
											friendly-name="Exchange Rate" validation="required" />
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Subject</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" id="subject"
											ng-model="generalinvoice.Subject" name="subject">
									</div>
								</div>
							</div>

						</fieldset>
					</div>





					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Units</label>
									<div class="col-md-7">
										<div class="row">
											<div class="col-md-6 custom-col-md-6 pull-left ">
												<label class="col-md-3 custom-col-md-3 control-label">20'</label>
												<input type="text" class="col-md-5 input-sm" id="unit20"
													ng-model="generalinvoice.Unit20" />
											</div>
											<div class="col-md-6 custom-col-md-6 pull-left">
												<label class="col-md-3 custom-col-md-3 control-label">40'</label>
												<input type="text" class="col-md-5 input-sm" id="unit40"
													ng-model="generalinvoice.Unit40" />
											</div>
										</div>
									</div>
								</div>
							</div>

 <div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">FPOD</label>
									<div class="col-md-7">
											<selectivity list="portList" property="generalinvoice.fpod"
												id="fpod" ng-model="generalinvoice.fpod"
												name="fpod"
												friendly-name="FPOD"
												form-name="generalInvoiceForm" ></selectivity>


									</div>
								</div>
							</div>

							

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Service</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="ServiceName" ng-model="generalinvoice.ServiceName"
											readonly>


									</div>
								</div>
							</div>

							<div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<!-- <selectivity list="quotationhdrList"
											property="generalinvoice.QuotationNumber"
											id="QuotationNumber" name="QuotationNumber"
											ng-model="generalinvoice.QuotationNumber"
											validation="required" friendly-name="QuotationNumber"
											form-name="generalInvoiceForm"
											title="Based On Customer,Pol,Pod and Validity"></selectivity> -->
										<input type="text" class="form-control input-sm"
											id="QuotationNumber" ng-model="generalinvoice.QuotationNumber">
									</div>
								</div>
							</div>
 
				<!-- 	<div class="col-sm-12 col-md-4 col-lg-4">
					
					<div class="form-group" ng-if="!dubai" >							
							<label class="col-md-5 control-label">File Upload</label>
								<div class="col-md-7">
								<div class="input-group">
								  <input type="file" class="form-control btn-primary" name="excelfile" 
								  ng-model="excelfile"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											<i class="fa fa-plus"></i>
										</button>
									</span>
									</div>
								</div>
							</div>
							
							<div class="form-group" ng-if ="dubai">							
							<label class="col-md-5 control-label">File Upload
<span style="color: red;">*</span></label>
								<div class="col-md-7">
								<div class="input-group">
								  <input type="file" class="form-control btn-primary" name="excelfile" 
								  ng-model="excelfile" validation="required" friendly-name="File Upload" form-name="generalInvoiceForm"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											<i class="fa fa-plus"></i>
										</button>
									</span>
									</div>
								</div>
							</div>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<div class="" ng-repeat="(tIndex, filelist) in generalinvoice.files">
								<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.invoiceno!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											</div>
											
											<div ng-if="filelist.invoiceno==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
											</div>
							
							</div>
					</div>
					  -->
					 
					
					 
						</fieldset>
					</div>
				</div>


				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<!-- <th colspan=1 class="width_13 text-center">Sub Group</th> -->
								<th colspan=1 class="width_2 text-center visible-left">Sl
									No</th>
								<th colspan=1 class="width_13 text-center">Charge Head<span
									style="color: red;">*</span></th>
								<!-- <th colspan=1 class="width_13 text-center">Sub Accout Code</th> -->
								<th colspan=1 class="width_13 text-center">Narration<span
									style="color: red;">*</span></th>
									<th colspan=1 class="width_13 text-center">Tax Amount<span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_10 text-center">TC Amount<span
									style="color: red;">*</span></th>
								<th colspan=1 class=" width_10 text-center">BC
									Amount({{companyCurrency}})<span style="color: red;">*</span>
								</th>
								
							</tr>
						</thead>

						<tbody ng-repeat="(trIndex, row) in generalinvoice.GIDtl"
							ng-controller="GItableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{$index}}"><i></i></label></td>
								<td class="visible-left"><label ng-model="row.slNo"
									id="slNo{{$index}}" ng-bind="row.slNo"></label></td>
								<!-- <td><selectivity list="subGroupList"
									property="row.subGroupCode" id="txtSubGroupCode{{$index}}"></selectivity></td> -->
								<td ><selectivity list="chargeHeadList"
										property="row.accountHead" id="accountHead{{$index}}"
										ng-model="row.accountHead" form-name="generalInvoiceForm"
										name="{{ 'accountHead' + $index }}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}"></selectivity></td>
										
										<td ng-show="!userCheck"><selectivity list="accdList"
										property="row.accountHead" id="accountHead{{$index}}"
										ng-model="row.accountHead" form-name="generalInvoiceForm"
										name="{{ 'accountHead' + $index }}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}"></selectivity></td>
										
								<!-- <td>
									<div class="col-xs-12" ng-if="!row.isSubAccountCode">
										<selectivity list="row.subAccountCodeList"
											property="row.subAccountCode"
											id="txtSubAccountCode{{$index}}"
											disabled="!row.isSubAccountCode"></selectivity>
									</div>
									<div class="col-xs-12" ng-if="row.isSubAccountCode">
										<seproperty="lectivity list="row.subAccountCodeList"
											row.subAccountCode"
											id="txtSubAccountCode{{$index}}"
											form-name="generalInvoiceForm" ng-model="row.subAccountCode"
											name="{{ 'SubAccount' + $index }}" validation="required"
											friendly-name="{{ 'Row' + $index + '(Sub Account)'}}"></selectivity>
									</div>
								</td> -->
								<td><input class="form-control input-sm" type="text"
									ng-model="row.narration" id="narration{{$index}}"
									name="narration{{$index}}" validation="required"
									friendly-name="{{ 'Row' + $index + '(Narration)'}}"></td>
<td><input class="form-control input-sm text-right"
									type="text" ng-model="row.taxAmount" id="taxAmount{{$index}}"
									step="0.01"
									ng-keyup="calculateBCtoTCAmount(row.taxAmount,$index,row)"
									name="taxAmount{{$index}}"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
									step="0.01" friendly-name="{{ 'Row' + $index + '(taxAmount)'}}">
								</td>
								<td><input class="form-control input-sm text-right"
									type="text" ng-model="row.tcAmount" id="TCamount{{$index}}"
									step="0.01"
									ng-keyup="calculateTCtoBCAmount(row.tcAmount,$index,row)"
									name="TCamount{{$index}}"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
									step="0.01" friendly-name="{{ 'Row' + $index + '(TCamount)'}}">
								</td>
								<td><input class="form-control input-sm text-right"
									type="text" ng-model="row.bcAmount" id="BCamount{{$index}}"
									step="0.01"
									ng-keyup="calculateBCtoTCAmount(row.bcAmount,$index,row)"
									name="BCamount{{$index}}"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
									step="0.01" friendly-name="{{ 'Row' + $index + '(BCamount)'}}">
								</td>
								
							</tr>



							<tr>
								<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list -->
										<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													validation="required" name="txtSubAccountCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isService && !row.isServiceMan">
											<label class="col-md-5 control-label"> Service </label>
											<div class="col-md-7">
												<selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service </label>
											<div class="col-md-7">
												<selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}" ng-model="row.sectorCode"
													validation="required" name="sectorCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Service)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>
										<!-- 		<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && !row.">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.isEmployee"
													id="employeeCode{{trIndex}}" ng-model="row.employeeCode"
													validation="required" name="employeeCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Employee)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>
										<!-- 			<div class="col-sm-2 padding-top-5" ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Port

											</label>
											<div class="col-md-7">
										           <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label"> Port </label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}" ng-model="row.portCode"
													 name="portCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Port)'}}"
													
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>

										<!-- 		<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence && !row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq

											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" validation="required"
													friendly-name="{{ 'Row' + $index + '(Port Seq)'}}" />
											</div>
										</div>

										<!-- 				<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && !row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"
													ng-model="row.departmentCode" validation="required"
													name="departmentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Department)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>

										<!-- 				<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && !row.isAgentMan">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										 -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}" ng-model="row.agentCode"
													validation="required" name="agentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Agent)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>

										<!-- 					<div class="col-sm-2 padding-top-5" ng-if="row.isLocation && !row.isLocationMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}" ng-model="row.countryCode"
													validation="required" name="countryCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Location)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>
										<!-- 										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && !row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										 -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}" ng-model="row.customerCode"
													validation="required" name="customerCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Customer)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>

										<!-- 		<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && !row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}" ng-model="row.supplierCode"
													validation="required" name="supplierCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Supplier)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>

										<!-- 					<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation && !row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"
													ng-model="row.designationCode" validation="required"
													name="designationCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}"
													form-name="generalInvoiceForm">
												</selectivity>
											</div>
										</div>


										<!-- 							<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter && !row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter{{trIndex}}"/>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
											<label class="col-md-5 control-label"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label">Qty(MT)GO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityGO{{trIndex}}" ng-model="row.quantityGO"
													name="QuantityGO" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label">Qty(MT)FO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityFO{{trIndex}}" ng-model="row.quantityFO"
													name="QuantityFO" />
											</div>
										</div>
									</div>
								</td>
							</tr>
<!-- <tr ng-if="row.accountHead!='' && generalinvoice.CompanyCode=='C0001'">
								<td>Currency (AED) Ex Rate:3.67</td>
								<td class="visible-left"></td>
								<td><selectivity list="subGroupList"
									property="row.subGroupCode" id="txtSubGroupCode{{$index}}"></selectivity></td>
								<td><selectivity list="vatAccountList"
										property="row.vatAccount" id="vatAccount{{$index}}"
										ng-model="row.vatAccount" form-name="generalInvoiceForm"
										name="{{ 'accountHead' + $index }}"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}"></selectivity></td>
								<td>
									 <selectivity list="vatTypeList"
										property="row.vatType" id="vatType{{$index}}"
										ng-model="row.vatType" form-name="generalInvoiceForm"
										name="{{ 'vatType' + $index }}" 
										friendly-name="{{ 'Row' + $index + 'VAT Type)'}}">
								</td>
								<td> <selectivity list="vatPercList"
										property="row.vatPerc" id="vatPerc{{$index}}"
										ng-model="row.vatPerc" form-name="generalInvoiceForm"
										name="{{ 'vatPerc' + $index }}" 
										friendly-name="{{ 'Row' + $index + 'VAT PERC)'}}"></td>

								<td><input class="form-control input-sm text-right"
									type="text" ng-model="row.vatTcAmount" id="VATTCamount{{$index}}"
									step="0.01"
									name="TCamount{{$index}}" disabled									
									step="0.01" friendly-name="{{ 'Row' + $index + '(TCamount)'}}">
								</td>
								<td><input class="form-control input-sm text-right"
									type="text" ng-model="row.vatBcAmount" id="VATBCamount{{$index}}"
									step="0.01"
									ng-keyup="calculatevatBCtoTCAmount(row.bcAmount,$index,row)"
									name="BCamount{{$index}}"	 disabled								 
									step="0.01" friendly-name="{{ 'Row' + $index + '(VATBCamount)'}}">
								</td>
							</tr> -->
						</tbody>

					</table>

					<div class="padding-right-5">
						<div class="col-md-4">
							<button ng-click="addRow(generalinvoice.GIDtl)"
								class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
								type="button">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeRow(generalinvoice.GIDtl)"
								class="btn btn-sm btn-danger" type="button" tooltip="Delete">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
						
						<div class="col-md-12">
							<div class="form-group">
								<label class="col-md-2 control-label">TC Amount</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-right"
										id="TxtTotalTcAmt" name="totalTcAmt"
										ng-model="generalinvoice.TotalTC1amount" readonly>
								</div>
								<label class="col-md-2 control-label">BC Amount</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-right"
										id="TxtTotalBcAmt" name="totalBcAmt"
										ng-model="generalinvoice.TotalBC1amount" readonly>
								</div>
								<label class="col-md-2 control-label">Tax Amount</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-right"
										id="totalTaxAmt" name="totalTaxAmt"
										ng-model="generalinvoice.totalTaxAmt" readonly>
								</div>
								
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label class="col-md-2 control-label">Total TC Amount</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-right"
										id="TxtTotalTcAmt" name="totalTcAmt"
										ng-model="generalinvoice.TotalTCamount" readonly>
								</div>
								<label class="col-md-2 control-label">Total BC Amount</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-right"
										id="TxtTotalBcAmt" name="totalBcAmt"
										ng-model="generalinvoice.TotalBCamount" readonly>
								</div>
								
								
							</div>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!generalinvoice.isEdit"
								ng-click="onSubmit(generalInvoiceForm,generalinvoice)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								ng-if="generalinvoice.isEdit"
								ng-click="onSubmit(generalInvoiceForm,generalinvoice)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
							<!-- <button class="btn btn-success" type="button"
								ng-if="!generalinvoice.isEdit"
								ng-click="onSubmitPrintPreview(generalInvoiceForm,generalinvoice)">
								<i class="fa fa-print"></i> Print Preview
							</button> -->
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
<script>
//select all desired input fields and attach tooltips to them
$("#myform :input").tooltip({

// place tooltip on the right edge
position: "center right",

// a little tweaking of the position
offset: [-2, 10],

// use the built-in fadeIn/fadeOut effect
effect: "fade",

// custom opacity setting
opacity: 0.7

});


</script>
<script type="text/ng-template" id="myModalContentl">
<div class="modal-header"></div>
<div class="row">
<div class="col-lg-12">
		<div class="form-group">
<label class="control-label padder-v padder fontSize16">{{errorName}}</label>
		</div>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="generateConfirm()">OK</button>

	<button class="btn btn-warning" ng-click="closeErrorDialog()">Close</button>
</div>
</div>
</div>
</script>

<script type="text/ng-template" id="checkDuplicateInvoiceModal">

<div class="modal-header"> Invoice has been generated for the customer, Do you want to continue further Billing </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="ConfirmInvoice()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialogBox()">Cancel</button>
</div>
 </script>

