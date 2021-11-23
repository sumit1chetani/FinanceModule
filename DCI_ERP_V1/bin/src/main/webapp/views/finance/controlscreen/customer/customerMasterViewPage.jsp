<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>

		<!-- <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb inline-block padding-left-0">
    <li>
     <a>Master</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.controlscreen">Control Screen</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.controlscreen.customer">Customer List</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.controlscreen.customer-add">Add</a>
    </li>
   </ol> -->
	</div>
	<tabset justified="true" class="tab-container"> <tab
		heading="{{tabs[0].title}}">
	<div class="panel-body">
		<form class="form-horizontal" name="CustomerMasterForm">

			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="form-group" ng-if="CustomerMasterEditData.conIdEdit">
						<label class="col-md-4 control-label">Customer ID:<span
							style="color: red;"></span></label>
						<div class="col-md-5">
							<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.customerCode}}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label"> Customer Name: </label>
						<div class="col-md-5">
							<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.customerName}}</label>
						</div>
					</div>
				</div>

				<div class="col-sm-12 col-md-12 col-lg-6">

					<div class="form-group">
						<label class="col-md-4 control-label">Customer ShortName </label>
						<div class="col-md-5">
							<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.customerShortName}}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">Account Head Code </label>
						<div class="col-md-5">
							<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.acctHead}}</label>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="wrapper-md">
						<div class="panel panel-default">
							<section widget-grid id="widget-grid">
								<div class="row ">
									<article class="col-sm-12">
										<div>
											<div class="" st-table="" st-safe-src="">
												<div class="widget-body no-padding ">
													<div class=" ">
														<table
															class="table table-striped b-t b-light table-hover dataTable no-footer">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_20 text-center" background="red"
																		colspan="7">Customer Ranking</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<th class="width_20 text-center info" colspan="2">Teus</th>
																	<th class="width_20 text-center danger" colspan="2">Income</th>
																	<th class="width_20 text-center success" colspan="2">Outstanding
																		Amount</th>
																	<th class="width_20 text-center success">Outstanding
																		More Than 30 days</th>
																</tr>
																<tr>
																	<th class="width_10 text-center info">Rank</th>
																	<th class="width_10 text-center info">Total</th>
																	<th class="width_10 text-center danger">Rank</th>
																	<th class="width_10 text-center danger">Total(USD)</th>
																	<th class="width_10 text-center success">Rank</th>
																	<th class="width_10 text-center success">Total(USD)</th>
																	<th class="width_10 text-center success">Total(USD)</th>
																</tr>
																<tr>
																	<th class="width_10 text-center info">{{CustomerMasterData.customerTeusRank}}</th>
																	<th class="width_10 text-center info">{{CustomerMasterData.customerTeus}}</th>
																	<th class="width_10 text-center danger">{{CustomerMasterData.customerRank}}</th>
																	<th class="width_10 text-center danger">{{CustomerMasterData.customerAmount}}</th>
																	<th class="width_10 text-center success">{{CustomerMasterData.customerOutRank}}</th>
																	<th class="width_10 text-center success">{{CustomerMasterData.customerOutAmount}}</th>
																	<th class="width_10 text-center success">{{CustomerMasterData.outstandingLocal}}</th>
																</tr>
																<tr>
																	<th class="width_10 text-center" colspan="1">Credit
																		Rating</th>
																	<th class="width_90 text-left" colspan="6">{{CustomerMasterData.crediRating}}(Total
																		Billed Amount/Outstanding Amount)</th>

																</tr>
															</tbody>
														</table>

													</div>
												</div>
											</div>
										</div>
									</article>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<fieldset>


						<div class="form-group">
							<label class="control-label col-md-4">Address </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.address}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Area </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.area}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Country Name: </label>
							<div class="col-md-5">
								<selectivity list="countryList"
									property="CustomerMasterData.countryName" id="country_id"
									disabled="true"></selectivity>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Fax No: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.faxNo}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Email: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.email}}</label>
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-4 control-label"> Currency </label>
							<div class="col-md-5">
								<selectivity list="currencyList"
									property="CustomerMasterData.currency" id="currency_id"
									disabled="true"></selectivity>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Sales Person </label>
							<div class="col-md-5">
								<selectivity list="payerList"
									property="CustomerMasterData.salesPerson" id="salesPerson"
									disabled="true"></selectivity>
							</div>
						</div>
						<!-- 		<div class="form-group">
							<label class="col-md-4 control-label"> Booking Contact
								Person: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.bookingCntctPrsn}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Pricing/Sales
								Contact Person: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.pricingCntctPrsn}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Operations Contact
								Person: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.operationsCntctPrsn}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Finance Contact
								Person: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.financeCntctPrsn}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Tel Number: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.teleNumber}}</label>
							</div>
						</div> -->
						<!-- <div class="form-group">
							<label class="col-md-4 control-label">Type: </label>
							<div class="col-md-6">
								<div class="checkbox">
									<label class="i-checks checkbox-inline"> <input
										type="checkbox" class="checkbox style-0"
										onclick="return false" name="shipper"
										ng-model="CustomerMasterData.shipper"> <i></i>Shipper
									</label> <label class="i-checks checkbox-inline"> <input
										type="checkbox" class="checkbox style-0"
										onclick="return false" name="consignee"
										ng-model="CustomerMasterData.consignee"> <i></i>Consignee
									</label> <label class="i-checks checkbox-inline"> <input
										type="checkbox" class="checkbox style-0"
										onclick="return false" name="notifyParty"
										ng-model="CustomerMasterData.notifyParty"> <i></i>Notify
										Party
									</label> <label class="i-checks checkbox-inline"
										style="margin-left: 0px;"> <input type="checkbox"
										class="checkbox style-0" onclick="return false"
										name="agreementParty"
										ng-model="CustomerMasterData.agreementParty"> <i></i>Agreement
										Party
									</label> <label class="i-checks checkbox-inline"> <input
										type="checkbox" class="checkbox style-0"
										onclick="return false" name="jVPartner"
										ng-model="CustomerMasterData.jVPartner"> <i></i>JV
										Partner
									</label>
								</div>
							</div>
						</div> -->

						<div class="form-group" ng-if="CustomerMasterData.jVPartner">
							<label class="col-md-4 control-label"> JV Type: </label>
							<div class="col-md-5">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" onclick="return false"
									name="ShareofRVC" ng-true-value="'ShareofRVC'"
									ng-false-value="''" ng-model="CustomerMasterData.shareOfRVC">
									<i></i>Share of RVC
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" onclick="return false"
									name="SlotSwap" ng-true-value="'SlotSwap'" ng-false-value="''"
									ng-model="CustomerMasterData.slotSwap"> <i></i>Slot
									Swap
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" onclick="return false"
									name="CRSS" ng-true-value="'CRSS'" ng-false-value="''"
									ng-model="CustomerMasterData.costRevenueSpaceShare"> <i></i>Cost
									/ Revenue / Space Sharing
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" onclick="return false"
									name="DeadFreight" ng-true-value="'DeadFreight'"
									ng-false-value="''" ng-model="CustomerMasterData.deadFreight">
									<i></i>Dead Freight
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Payment Center: </label>
							<div class="col-md-5">
								<selectivity list="paymentCenterList"
									property="CustomerMasterData.paymentCenter"
									id="paymentCenter_id" disabled="true"></selectivity>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Active: </label>
							<div class="col-md-5">
								<div class="checkbox">
									<label class="i-checks"> <input type="checkbox"
										class="checkbox style-0" onclick="return false" name="active"
										onclick="return false" ng-model="CustomerMasterData.active"
										ng-true-value="'Y'" ng-false-value="'N'"> <i></i>
									</label>
								</div>
							</div>
						</div>
						<!-- 	<div class="form-group">
        <label class="col-md-4 control-label">Slot Operator:
         </label>
        <div class="col-md-5">
         <div class="checkbox">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="slotOperator" ng-model="CustomerMasterData.slotOperator"
            ng-true-value="'Y'" ng-false-value="'N'">
           <i></i>
          </label>
         </div>
        </div>
       </div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Email: </label>
							<div class="col-md-8">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" name="booking" onclick="return false"
									ng-model="CustomerMasterData.emailBooking" ng-true-value="'B'"
									ng-false-value="''"> <i></i>Booking
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="pricing" onclick="return false"
									ng-model="CustomerMasterData.emailPricing" ng-true-value="'P'"
									ng-false-value="''"> <i></i>Pricing/Sales
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="operations" onclick="return false"
									ng-model="CustomerMasterData.emailOperations"
									ng-true-value="'O'" ng-false-value="''"> <i></i>Operations
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="finance" onclick="return false"
									ng-model="CustomerMasterData.emailFinance" ng-true-value="'F'"
									ng-false-value="''"> <i></i>Finance
								</label>
							</div>
						</div>
						<!-- 	<div class="form-group">
        <label class="col-md-4 control-label">BL Related:
         </label>
        <div class="col-md-5">
         <label class="i-checks">
         <input type="checkbox"  name="blRelated" onclick="return false" ng-model="CustomerMasterData.blRelated" ng-true-value="'Y'" ng-false-value="'N'">
         <i></i></label>
        </div>
       </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label">City: </label>
							<div class="col-md-5">
								<selectivity list="portList" property="CustomerMasterData.city"
									id="city_id" disabled="true"></selectivity>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Attached File
								Format: </label>
							<div class="col-md-5">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.attachFileGroup" value="P"
										name="attachFileGroup" checked="checked"> <i></i>PDF
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.attachFileGroup" value="E"
										name="attachFileGroup" checked="checked"> <i></i>EDI
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.attachFileGroup" value="H"
										name="attachFileGroup" checked="checked"> <i></i>HTML
									</label>
								</div>
							</div>
						</div>

						<!--   <div class="form-group">
        <label class="col-md-4 control-label">Is Vessel Operator?
        </label>
        <div class="col-md-5">
         <div class="radio radio-inline" style="padding-left: 0px;">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0"  name="isVesselGrp" ng_model="CustomerMasterData.isVesselGrp" value="Y">
           <i></i>
           Yes
          </label>
         </div>
         <div class="radio  radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" name="isVesselGrp" ng_model="CustomerMasterData.isVesselGrp" value="N" checked="checked"
            name="gear">
           <i></i>
           No
          </label>
         </div>
        </div>
       </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label"> Created Date </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.createdDate}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Bank Name </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.bankName}}</label>
							</div>

						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Bank Account Number
							</label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.accountNumber}}</label>
							</div>

						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">RTGS </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.bankRTGS}}</label>
							</div>

						</div>

					</fieldset>
				</div>


				<div class="col-sm-12 col-md-12 col-lg-6">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label">Address1: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.address1}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Type
								CUSTOMER/PAYER: </label>
							<div class="col-md-5">
								<selectivity list="typeofCustomerList"
									property="CustomerMasterData.typeofCustomer"
									id="typeofCustomer_id" disabled="true"></selectivity>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Tel Office No: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.telOfficeNum}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Telex No: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.telexNum}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Cr-Limit(USD): </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.crLimit}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Exchange Rate: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.exchangeRate}}</label>
							</div>
						</div>

						<!-- 	<div class="form-group">
							<label class="col-md-4 control-label"> Booking Contact
								Person Email: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label"
									style="max-width: 200px; word-wrap: break-word; text-align: left;">{{CustomerMasterData.bookingCntctPrsnEmail}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Pricing/Sales
								Contact Person Email: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label"
									style="max-width: 200px; word-wrap: break-word; text-align: left;">{{CustomerMasterData.pricingCntctPrsnEmail}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Operations Contact
								Person Email: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label"
									style="max-width: 200px; word-wrap: break-word; text-align: left;">{{CustomerMasterData.operationsCntctPrsnEmail}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Finance Contact
								Person Email: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label"
									style="max-width: 200px; word-wrap: break-word; text-align: left;">{{CustomerMasterData.financeCntctPrsnEmail}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"> Fax Num: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.faxNum}}</label>
							</div>
						</div> -->

						<div class="form-group">
							<label class="col-md-4 control-label"> Customer Category:
							</label>
							<div class="col-md-5">
								<selectivity list="customerCategoryList"
									property="CustomerMasterData.customer_category"
									id="customer_category_id" disabled="true"></selectivity>

							</div>
						</div>

						<!-- <div class="form-group">
							<label class="col-md-4 control-label">Credit Customer
								Type: </label>
							<div class="col-md-5">
								<div class="checkbox">
									<label class="i-checks"> <input type="checkbox"
										name="creditCustType"
										ng-model="CustomerMasterData.creditCustType"
										ng-true-value="'Y'" ng-false-value="'N'"> <i></i></label>
								</div>
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Type Of Customer: </label>
							<div class="col-md-7">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.typeOfCustGrp" value="C"
										name="typeOfCustGrp" checked="checked"> <i></i>Credit
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.typeOfCustGrp" value="P"
										name="typeOfCustGrp" checked="checked"> <i></i>Prior
										Loading
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.typeOfCustGrp" value="D"
										name="typeOfCustGrp" checked="checked"> <i></i>Deposit
										Check
									</label>
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-if="CustomerMasterData.typeOfCustGrp=='D'">
							<label class="col-md-4 control-label"> Deposit Amount: </label>
							<div class="col-md-5">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.depositAmt}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Company Type: </label>
							<div class="col-md-7">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.companyTypeGrp" value="MLO"
										name="companyTypeGrp" checked="checked"> <i></i>MLO
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.companyTypeGrp" value="NVOCC"
										name="companyTypeGrp" checked="checked"> <i></i>NVOCC
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.companyTypeGrp" value="JV"
										name="Company TypeGrp" checked="checked"> <i></i>JV
									</label>
									<div class="radio radio-inline">
										<label class="i-checks"> <input type="radio"
											class="radiobox style-0"
											ng_model="CustomerMasterData.companyTypeGrp" value="AGENT"
											name="companyTypeGrp" checked="checked"> <i></i>AGENT
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-if="CustomerMasterData.companyTypeGrp=='NVOCC'">
							<label class="col-md-4 control-label"> Category : </label>
							<div class="col-md-5">
								<selectivity list="categoryWiseList"
									property="CustomerMasterData.categoryWise" id="categoryWise_id"
									disabled="true"></selectivity>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-md-4 control-label"> Controlling Agent
							</label>
							<div class="col-md-5">
								<selectivity list="controllingAgentList"
									property="CustomerMasterData.controllingAgent"
									id="controllingAgent_id" disabled="true"></selectivity>
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-md-4 control-label"> Modified By </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.modifiedBy}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Modified Date </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.modifiedDate}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Created By </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.createdBy}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Created Date </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.createdDate}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Customer VAT </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.vatNum}}</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Trade Regn No </label>
							<div class="col-md-4">
								<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.cinNum}}</label>
							</div>
						</div>


					</fieldset>
				</div>
			</div>


			<!--     <div class="wrapper-md" >
 <div class="panel panel-default">
  <section widget-grid id="widget-grid">
   <div class="row ">
    <article class="col-sm-12">
     <div>
      <div class="" st-table="displayedCollection" st-safe-src="rowCollection">
       <div class="widget-body no-padding ">
        <div class=" ">
         <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head">
           <tr>
            <th class="width_1 text-center" >Select</th>
             <th class="width_1 text-center" >S.No</th>
            <th class="width_20 text-center" >POL</th>
            <th class="width_20 text-center" >POD</th>
            <th class="width_30 text-center">Payer</th>
            <th class="width_5 text-center">Email Id</th>
           </tr>
          </thead>
          <tbody class="dataTables-Main-Body">
           <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  ng-repeat="customerVoyage in displayedCollection track by $index">
            <td class="width_1 text-center">
             <label class="i-checks m-b-none">
              <input type="checkbox" name="post[]" ng-model="customerVoyage.checked" class="bulk-delete">
              <i></i>
             </label>
            </td>
             <td class="width_1 text-center">
					{{$index+1}}
            </td>
            <td class="width_20 text-center">
 			<div class="col-md-6" style="width: 100%">
 			 <selectivity list="portList" property="customerVoyage.polCode" id="polCode{{$index}}" disabled="true"></selectivity>
        	      		  </div>
            </td>
             <td class="width_20 text-center">
      		  <div class="col-md-6" style="width: 100%">
				 <selectivity list="portList" property="customerVoyage.podCode" id="podCode{{$index}}" disabled="true"></selectivity>
     		 </div>
            </td>
             <td class="width_20 text-center">
 			<div class="col-md-6" style="width: 100%">
 			 <selectivity list="payerList" property="customerVoyage.payerCode" id="payerCode{{$index}}" disabled="true"></selectivity>
      		  </div>
            </td>
            <td class="width_20  text-center">
				<input type="text" class="form-control input-sm" name="Email" disabled="disabled"
        		  ng-model="customerVoyage.email" >
            </td>
           </tr>
            </tbody>
         </table>

        </div>
       </div>
      </div>
     </div>
    </article>
   </div>
  </section>
 </div>
</div> -->
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="cancel()">
							<i class="fa fa-arrow-left"></i> Back To Lists
						</button>


					</div>
				</div>
			</div>
		</form>
		<!--  </div>
</div>
</div> -->
	</div>
	</tab> <tab heading="{{tabs[1].title}}" active="tabs[1].active">
	<div class="panel-body" ng-hide="isShow">
		<form class="form-horizontal ng-pristine ng-pending"
			name="CustCommForm">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row" >
						<fieldset ng-disabled="customComm.isLead == 'true'">

							<div class="form-group">
								<label class="col-md-4 control-label"> Managing Director
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="subject"
										id="subject" ng-model="customComm.subject" maxlength="50">
								</div>
							</div>
							<!--  <div class="form-group">
        <label class="col-md-4 control-label">
         Turn Over
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" ng-model="customComm.referral" name="referral" message-id="referral" id="referral"
          typeahead="r.text as r.text for r in referralList| filter:$viewValue |limitTo:10" typeahead-min-length='1' maxlength="50" />
          <input type="text" class="form-control input-sm"  ng-model="customComm.referral" name="referral" message-id="referral"
	          id="referral"   validator="required"   valid-method="submit"/>
        </div>
       </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person"
										ng-model="customComm.bookingCntctPrsn" id="bookingCntctPrsn"
										maxlength="100"">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person"
										ng-model="customComm.pricingCntctPrsn" id="pricingCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person"
										ng-model="customComm.operationsCntctPrsn" maxlength="100"
										id="operationsCntctPrsn">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person"
										ng-model="customComm.financeCntctPrsn" id="financeCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Tel Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Tel Number" ng-model="customComm.teleNumber"
										id="teleNumber" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>

				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">
							<div class="form-group">
								<label class="col-md-4 control-label">Turn Over </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-model="customComm.assignedTo" name="assignedTo"
										id="assignedTo" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person Email"
										ng-model="customComm.bookingCntctPrsnEmail" maxlength="500"
										id="bookingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person Email"
										ng-model="customComm.pricingCntctPrsnEmail" maxlength="500"
										id="pricingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person Email"
										ng-model="customComm.operationsCntctPrsnEmail"
										id="operationsCntctPrsnEmail" validator="email"
										valid-method="submit" message-id="operationsCntctPrsnEmail"
										maxlength="500">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person Email"
										ng-model="customComm.financeCntctPrsnEmail"
										id="financeCntctPrsnEmail" validator="email"
										valid-method="submit" maxlength="500"
										message-id="financeCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Fax Num </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Fax No"
										id="faxNum" ng-model="customComm.faxNum" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>

			</div>
		</form>
		<div class="form-actions" ng-show="!isShow"
			ng-hide="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-success" type="button"
						ng-click="submitDetail(customComm)" class="btn btn-success">
						<i class="fa fa-plus"></i> Save
					</button>
					<button class="btn btn-danger" type="button" class="btn btn-success"
						ng-click="cancelCustomDetail()">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
		<div class="form-actions" ng-show="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-danger" type="button"
						ng-click="cancelCustomDetail()" class="btn btn-success">
						<i class="fa fa-arrow-left"></i> Back To Lists
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-body" ng-hide="!isShow">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<fieldset>
					<div class="wrapper-md">
						<div class="panel panel-default">
							<section widget-grid id="widget-grid">
								<div class="row ">
									<article class="col-sm-12">
										<div>
											<div class="" st-table="displayedCollectionFollowup"
												st-safe-src="rowCollectionFollowup">
												<div class="widget-body no-padding ">
													<div class=" " style="min-width: 100%; overflow-x: scroll;">
														<table
															class="table table-striped b-t b-light table-hover dataTable no-footer">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_5 text-center">Managing Director</th>
																	<th class="width_5 text-center">Turn Over</th>
																	<th class="width_5 text-center">Booking Contact
																		Person</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person</th>
																	<th class="width_20 text-center">Operations
																		Contact Person</th>
																	<th class="width_20 text-center">Finance Contact
																		Person</th>
																	<th class="width_20 text-center">Tel Number</th>
																	<th class="width_5 text-center">Booking Contact
																		Person Email</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person Email</th>
																	<th class="width_20 text-center">Operations
																		Contact Person Email</th>
																	<th class="width_20 text-center">Finance Contact
																		Person Email</th>
																	<th class="width_20 text-center">Fax Num</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">

																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-repeat="customComm in displayedCollectionFollowup track by $index">
																	<td class="width_20 text-center">{{customComm.subject}}</td>
																	<td class="width_20 text-center">{{customComm.assignedTo}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.teleNumber}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.faxNum}}</td>
																	<!-- 			<td class="td-actions text-center width_5">
																		<div ng-hide="customComm.isLead == 'true'">
																			<span> <i
																				class="fa  fa-pencil text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span> <span> <i
																				class="fa fa-trash-o text-danger-dker text"
																				data-ng-click="deleteFollow(customComm.customId,customComm.customCommId)"></i>
																			</span>
																		</div>
																		<div ng-show="customComm.isLead == 'true'">
																			<span> <i class="fa  fa-eye text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span>
																		</div>
																	</td> -->
																</tr>
															</tbody>
														</table>
														<table class="odd table-hover ">
															<tfoot>
																<tr>
																	<!-- <td class="width_100">
																		<button data-ng-click="addFollowUpRow()"
																			class="btn btn-primary" type="button">
																			<i class="fa fa-plus"></i> Add FollowUp
																		</button>
																	</td> -->
																</tr>
															</tfoot>
														</table>
													</div>
												</div>
											</div>
										</div>
									</article>
								</div>
							</section>
						</div>
					</div>
				</fieldset>
			</div>
		</div>

	</div>

	<div class="form-actions" ng-show="isShow">
		<div class="row">
			<div class="col-md-12">
				<button ng-model="add" class="btn btn-danger" type="submit"
					ng-click="cancel()" class="btn btn-success">
					<i class="fa fa-arrow-left"></i> Back To Lists
				</button>
			</div>
		</div>
	</div>

	</tab> </tabset>
</div>

