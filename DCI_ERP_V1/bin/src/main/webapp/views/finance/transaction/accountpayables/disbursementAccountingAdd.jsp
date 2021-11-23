<style>
.table td {
	padding: 3px !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="disbursementAccountForm"
				novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group" ng-if="isEdit=='true'" ng-hide="true">
								<label class="col-md-4 control-label"> Disbursement Code
									<span style="color: red;">*</span>
								</label> <label class="col-md-1 control-label">{{disbursementAccount.disbursemnetCode}}</label>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Agent <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<!-- 		         					<input type="text" placeholder="Search Supplier" ng-model="disbursementAccount.supplierCode" name="supplierCode"
                                          typeahead="c  as c.supplierName for c in supplierList | filter:$viewValue | limitTo:10" 
                                          typeahead-on-select='setCurrency($item, $model, $label)' 
                                          class="form-control input-sm" required >
                                           -->
									<selectivity list="supplierList"
										property="disbursementAccount.supplierCode"
										ng-model="disbursementAccount.supplierCode" id="supplierCode"
										name="supplierCode" object="tempDropDownObj"
										validation="required" friendly-name="Supplier"
										form-name="disbursementAccountForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Disbursement Date
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<div class='input-group date datetimepick'>
										<input type="text" class="form-control"
											ng-model="disbursementAccount.disdisbursemnetDate"
											placeholder="dd/mm/yyyy" id="disdisbursemnetDate"
											name="disdisbursemnetDate"
											value="{{disbursementAccount.disdisbursemnetDate}}"
											friendly-name="Date" form-name="disbursementAccountForm" />
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"> </span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="vesselList"
										property="disbursementAccount.vesselCode"
										ng-model="disbursementAccount.vesselCode" id="vesselCode"
										name="vesselCode" object="tempDropDownObj"
										validation="required" friendly-name="Vessel"
										form-name="disbursementAccountForm"></selectivity>
									<!--   <select ng-model="disbursementAccount.vesselCode"
                                   id="vessel_id"
                                   name="berthId"
                                   allow-single-deselect="true"
                                   chosen
                                   search_contains="true"     ng-change="getVoyage1(r)"                              
                                   ng-options="r as r.text for r in vesselList" style="width: 200px;">
                                   </select> -->
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Slot A/C <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<!--                  <input type="text" placeholder="Search Slot A/C" ng-model="disbursementAccount.slotAccCode" name="slotAccCode"
                                                        typeahead="c  as c.vesselName for c in vesselList | filter:$viewValue | limitTo:10"  typeahead-on-select='getVoyage($item, $model, $label)'
                                                        class="form-control input-sm" required > -->
									<selectivity list="slotAccList"
										property="disbursementAccount.slotAccCode"
										ng-model="disbursementAccount.slotAccCode" id="slotAccCode"
										name="slotAccCode" validation="required"
										friendly-name="Slot A/C" form-name="disbursementAccountForm"></selectivity>
								</div>
							</div>
							<!-- <div class="form-group">
	        					 <label class="col-md-4 control-label">Party Invoice No.
	         					 	 <span style="color: red;">*</span>
                                 </label>
	                             <div class="col-md-5">
		                             <input type="text" class="form-control input-sm" name="partyInvoiceNo"  ng-model="disbursementAccount.partyInvoiceNo"  
		                             validation="required" friendly-name="Party Invoice No." form-name="disbursementAccountForm" id="partyInvoiceNo">
	                             </div>
                            </div>  
                            <div class="form-group">
                              <label class="col-md-4 control-label">Purchase No.
                                
                                 </label>
                              <div class="col-md-5">
                               <input type="text" class="form-control input-sm" name="purchaseNo"  ng-model="disbursementAccount.purchaseNo"  
                               id="purchaseNo">
                              </div>
                            </div>   -->
							<div class="form-group">
								<label class="col-md-4 control-label">Currency </label>
								<div class="col-md-5">
									<label class="col-md-1 control-label">{{disbursementAccount.currencyCode}}</label>
									<!-- <selectivity  list="currencyList" property="disbursementAccount.currencyCode" ng-model="disbursementAccount.currencyCode" id="currencyCode"  name="currencyCode" object="tempDropDownObj" validation="required" friendly-name="Currency" form-name="disbursementAccountForm"></selectivity> -->
								</div>
							</div>
							<!-- <div class="form-group">
                              <label class="col-md-4 control-label">Description
                                 
                                 </label>
                              <div class="col-md-5">
                               <textarea ng-model="disbursementAccount.description" name="description" class="custom-scroll width_100" rows="2" 
                                     id="description"></textarea>
                              </div>
                            </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Arrival Date </label>
								<div class="col-md-5">
									<div class='input-group date datetimepick'>
										<input type="text" class="form-control"
											ng-model="disbursementAccount.arrivalDate"
											placeholder="dd/mm/yyyy" id="arrivalDate" name="arrivalDate"
											value="{{disbursementAccount.arrivalDate}}"
											friendly-name="Arrival Date"
											form-name="disbursementAccountForm" /> <span
											class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"> </span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">GRT </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="grt"
										ng-model="disbursementAccount.grt" id="grt">
								</div>
							</div>
								<div class="form-group" >							
							<label class="col-md-4 control-label">File Upload </label>
								<div class="col-md-7">
								<div class="input-group">
								 <input type="file" class="form-control btn-primary" name="excelfile"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											<i class="fa fa-plus"></i>
										</button>
									</span>
									</div>
									
									<div class="" ng-repeat="(tIndex, filelist) in disbursementAccount.files">
								<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.disbursementid!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											</div>
											
											<div ng-if="filelist.disbursementid==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											 
											</div>
							
							</div>
								</div>
							</div>
								
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Company <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="companyList"
										ng-model="disbursementAccount.companyCode"
										property="disbursementAccount.companyCode" id="companyCode"
										name="companyCode" validation="required"
										friendly-name="Company" form-name="disbursementAccountForm"></selectivity>
								</div>
							</div>
							<!-- <div class="form-group">
                               <label class="col-md-4 control-label">Type</label>
                               <div class="col-md-5">
                                 <div class="radio radio-inline">
                                   <label class="i-checks">
                                       <input type="radio" class="radiobox style-0" ng_model="disbursementAccount.disbursementMode" value="P" name="disbursementMode" checked="checked"   >
                                        <i></i>
                                     Proforma
                                   </label>
                                  </div>
                                  <div class="radio  radio-inline">
                                   <label class="i-checks">
                                     <input type="radio" class="radiobox style-0" ng_model="disbursementAccount.disbursementMode" value="F" name="voyageType" >
                                     <i></i>
                                      Final 
                                   </label>
                                 </div>
                               </div>
                              </div>  -->
							<div class="form-group">
								<label class="col-md-4 control-label">Month/Year <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-3">
									<selectivity list="monthList"
										property="disbursementAccount.month"
										ng-model="disbursementAccount.month" id="month" name="month"
										validation="required" friendly-name="Month"
										form-name="disbursementAccountForm"></selectivity>
								</div>
								<div class="col-md-2">
									<selectivity list="yearList"
										property="disbursementAccount.year"
										ng-model="disbursementAccount.year" id="year" name="year"
										validation="required" friendly-name="year"
										form-name="disbursementAccountForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Voyage <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<!-- <input type="text" placeholder="Search Voyage" ng-model="disbursementAccount.voyageNo" name="voyageNo" 
                                          typeahead="c  as c.voyageNo for c in voyageList | filter:$viewValue | limitTo:10"  typeahead-on-select='getPort($item, $model, $label)'
                                          class="form-control input-sm" required >   -->
									<selectivity list="voyageList"
										property="disbursementAccount.voyageNo"
										ng-model="disbursementAccount.voyageNo" id="voyageNo"
										name="voyageNo" validation="required" friendly-name="Voyage"
										form-name="disbursementAccountForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Port <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<!--                               <input type="text" placeholder="Search Port" ng-model="disbursementAccount.portCode" name="portCode"
                                                        typeahead="c  as c.portCode for c in portList | filter:$viewValue | limitTo:10"  
                                                        class="form-control input-sm" required > -->
									<selectivity list="portList"
										property="disbursementAccount.portCode"
										ng-model="disbursementAccount.portCode" id="portCode"
										name="portCode" object="tempDropDownObj" validation="required"
										friendly-name="Port" form-name="disbursementAccountForm"></selectivity>
								</div>
							</div>
							<!-- <div class="form-group">
        						<label class="col-md-4 control-label">Party Invoice Date
         							<span style="color: red;">*</span>
        						</label>
        						<div class="col-md-5">
                               <div class='input-group date datetimepick'>
                                 <input type="text" class="form-control" ng-model="disbursementAccount.partyInvoiceDate" placeholder="dd/mm/yyyy" id="partyInvoiceDate" name="partyInvoiceDate" friendly-name="Party Invoice Date" form-name="disbursementAccountForm"
                                   value="{{disbursementAccount.partyInvoiceDate}}" /> <span class="input-group-addon"> <span
                                   class="glyphicon glyphicon-calendar"> </span>
                                  </span>
                                </div>
	         					       						
        						</div>
       						</div>
                            <div class="form-group">
                             <label class="col-md-4 control-label">Due Date
                              
                             </label>
                             <div class="col-md-5">
                             <div class='input-group date datetimepick'>
                                 <input type="text" class="form-control" ng-model="disbursementAccount.dueDate" placeholder="dd/mm/yyyy" id="dueDate"
                                   value="{{disbursementAccount.dueDate}}" /> <span class="input-group-addon"> <span
                                   class="glyphicon glyphicon-calendar"> </span>
                                  </span>
                                </div>
                             </div>
                            </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Exchange Rate <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm text-right"
										name="exchangeRate"
										ng-model="disbursementAccount.exchangeRate"
										ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
										validation="required" friendly-name="Exchange Rate"
										form-name="disbursementAccountForm" id="exchangeRate"
										ng-keyup="exchageratehdr(disbursementAccount.exchangeRate)"
										ng-blur="exchageratehdrVal(disbursementAccount.exchangeRate)">
								</div>
							</div>
							<!-- <div class="form-group">
                             <label class="col-md-4 control-label">Amount TC
                               
                             </label>
                             <div class="col-md-5">
                               <input type="text" class="form-control input-sm" name="amountLocal"  ng-model="disbursementAccount.amountLocal" 
                               validator="required" valid-method="submit" message-id="amountLocal" id="amountLocal">    
                               
                                <input type="text" class="form-control input-sm text-right" ng-model="disbursementAccount.amountLocal" readonly="readonly"
                               name="amountLocal" ng-keyup="amountLocalCalculation(disbursementAccount.amountLocal)" form-name="disbursementAccountForm" 
                               validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="Amount TC" >            
                             </div>
                            </div> -->
							<!--  <div class="form-group">
                             <label class="col-md-4 control-label">Amount BC
                               
                             </label>
                             <div class="col-md-5">
                               <input type="text" class="form-control input-sm" name="amountUsd"  ng-model="disbursementAccount.amountUsd" 
                               validator="required" valid-method="submit" message-id="amountUsd" id="amountUsd">
                               
                                 <input type="text" class="form-control input-sm text-right" ng-model="disbursementAccount.amountUsd" readonly="readonly"
                               name="amountUsd" ng-keyup="amountCalculation(disbursementAccount.amountUsd)" form-name="disbursementAccountForm" 
                               validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="Amount BC" >                
                             </div>
                            </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Sailed Date </label>
								<div class="col-md-5">
									<div class='input-group date datetimepick'>
										<input type="text" class="form-control"
											ng-model="disbursementAccount.sailedDate"
											placeholder="dd/mm/yyyy" id="sailedDate"
											value="{{disbursementAccount.sailedDate}}" /> <span
											class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"> </span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">NRT </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="nrt"
										ng-model="disbursementAccount.nrt" id="nrt">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th class="width_10">NO.OF CONTAINERS</th>
								<th class="width_5 text-center">M20</th>
								<th class="width_5 text-center">M40</th>
								<th class="width_5 text-center">M45</th>
								<th class="width_5 text-center">D20</th>
								<th class="width_5 text-center">D40</th>
								<th class="width_5 text-center">D45</th>
								<th class="width_5 text-center">R20</th>
								<th class="width_5 text-center">R40</th>
								<th class="width_5 text-center">OOG20</th>
								<th class="width_5 text-center">OOG40</th>
								<th class="width_5 text-center">RI20</th>
								<th class="width_5 text-center">RI40</th>
								<th class="width_5 text-center">FLEXI20</th>
								<th class="width_5 text-center">FLEXI40</th>
								<th class="width_5 text-center">IM20</th>
								<th class="width_5 text-center">IM40</th>
								<th class="width_5 text-center">OOG SLOT LOSS</th>
								<th class="width_5 text-center">TOTAL20</th>
								<th class="width_5 text-center">TOTAL40</th>
								<th class="width_5 text-center">Total Teus</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row) in disbursementAccount.containerList"
							ng-if='disbursementAccount.containerList.length>2'>
							<tr>
								<td>
									<div class="row">
										<div class="col-xs-12">{{row.buttonOperation}}</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="m20"
												readonly="readonly" data-ng-model="row.m20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="m40"
												readonly="readonly" data-ng-model="row.m40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="m45"
												readonly="readonly" data-ng-model="row.m45" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="d20"
												readonly="readonly" data-ng-model="row.d20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="d40"
												readonly="readonly" data-ng-model="row.d40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="d45"
												readonly="readonly" data-ng-model="row.d45" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="r20"
												readonly="readonly" data-ng-model="row.r20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="r40"
												readonly="readonly" data-ng-model="row.r40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="oog20"
												readonly="readonly" data-ng-model="row.oog20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="oog40"
												readonly="readonly" data-ng-model="row.oog40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="ri20"
												readonly="readonly" data-ng-model="row.rI20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="ri40"
												readonly="readonly" data-ng-model="row.rI40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="flexi20" readonly="readonly"
												data-ng-model="row.flexi20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="flexi40" readonly="readonly"
												data-ng-model="row.flexi40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="im20"
												readonly="readonly" data-ng-model="row.im20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="im40"
												readonly="readonly" data-ng-model="row.im40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="oogslotLoss" readonly="readonly"
												data-ng-model="row.oogslotLoss" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="total20" readonly="readonly"
												data-ng-model="row.total20" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="total40" readonly="readonly"
												data-ng-model="row.total40" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="totalTues" readonly="readonly"
												data-ng-model="row.totalTues" />
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<!-- <th colspan=1  class="width_1 text-center">SI.No</th> -->
								<th colspan=1 class="width_13 text-center">Expense Type<span
									style="color: red;">*</span></label></th>
								<th colspan=1 class="width_13 text-center">Expense<span
									style="color: red;">*</span></label></th>
								<!-- <th colspan=1  class="width_13 text-center">Company<span style="color: red;">*</span></label></th> -->
								<!-- <th colspan=1  class="width_13 text-center">Account Name<span style="color: red;">*</span></label></th> -->
								<!-- <th colspan=1  class="width_10 text-center">Sub Account Code</th> -->
								<!-- <th colspan=1  class="width_10 text-center">Short Details<span style="color: red;">*</span></label></th> -->
								<th colspan=1 class="width_10 text-center">Invoice No.</th>
								<th colspan=1 class="width_8 text-center">Party Name</th>
								<th colspan=1 class=" width_8 text-center">Currency</label></th>
								<th colspan=1 class=" width_6 text-center">Rate<span
									style="color: red;">*</span></label></th>
								<th colspan=1 class="width_8 text-center">TC Amt<span
									style="color: red;">*</span></label></th>
								<th colspan=1 class="width_8 text-center">BC Amt (USD)<span
									style="color: red;">*</span></label></th>
								<!-- {{companyCurrency}} -->
								<!--  <th  colspan=1 class="width_1"></th> -->
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row) in disbursementAccount.credittables"
							ng-controller="tableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select"><i></i></label></td>
								<!--   <td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td> -->
								<!-- <td>
          <selectivity list="subGrpList" property="row.subGrpCode" id="subGroupCode{{trIndex}}" object="subGroup"></selectivity>
         </td> -->
								<td class="width_10 visible-left">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="dtlSeqId{{trIndex}}" name="dtlSeqId{{trIndex}}"
												data-ng-model="row.dtlSeqId" />
										</div>
									</div>
								</td>
								<td><selectivity list="expenseTypeList"
										property="row.expenseType" id="expenseType{{trIndex}}"
										object="tempDropDownObj" disabled="row.isDisabled">
									ng-model="row.expenseType" name ="expenseType{{trIndex}}"
									validation="required" friendly-name="{{ 'Row' + $index +
									'Expense Type)'}}" form-name = "disbursementAccountForm"></selectivity></td>
								<td><selectivity list="expenseList" property="row.expense"
										id="expense{{trIndex}}" object="tempDropDownObj"
										disabled="row.isDisabled">
									ng-model="row.expense" name ="expense{{trIndex}}"
									validation="required" friendly-name="{{ 'Row' + $index +
									'Expense)'}}" form-name = "disbursementAccountForm"></selectivity></td>
								<!-- <td>
              <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"
              ng-model="row.companyCode" name ="companyCode{{trIndex}}" validation="required"
              friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name = "disbursementAccountForm"></selectivity>
             </td> -->
								<!-- <td>
              <selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
              ng-model="row.accountHeadCode" name ="accountHeadCode{{trIndex}}" validation="required"
              friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "disbursementAccountForm"></selectivity>
             </td> -->
								<!-- <td>
              <selectivity list="row.subAccountCodeList" property="row.subAccountCode" id="subAccountCode{{trIndex}}" object="subAccount" disabled = "!row.isSubAccountCode"></selectivity>
             </td> -->
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="invoiceNo{{trIndex}}" name="invoiceNo{{trIndex}}"
												data-ng-model="row.invoiceNo" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="refId{{trIndex}}" name="refId{{trIndex}}"
												data-ng-model="row.refId" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											&nbsp;&nbsp;{{row.currency}}
											<!--      <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" name="currency{{trIndex}}"
                      validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" ng-model="row.currency" property="row.currency" form-name = "disbursementAccountForm"></selectivity> -->
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
												ng-keyup="amountCalculationexchange(row.exchangeRate,trIndex,row)"
												ng-keyup="amountCalculationexchange(row.exchangeRate,trIndex,row)"
												ng-blur="amountCalculationexchangeVal(row.exchangeRate,trIndex,row)"
												form-name="disbursementAccountForm"
												name="exchangeRate{{trIndex}}"
												ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}">
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="tcAmount{{trIndex}}" ng-model="row.tcAmount"
												name="tcAmount{{trIndex}}" ng-disabled="row.isDisabled"
												ng-keyup="amountCalculationTCTable(row.tcAmount,trIndex,row)"
												form-name="disbursementAccountForm"
												ng-pattern-restrict="^\d+(?:\.\d{0,6})?$"
												validation="required" step="0.01"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" readOnly>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="bcAmount{{trIndex}}" ng-model="row.bcAmount"
												name="bcAmount{{trIndex}}" ng-disabled="row.isDisabled"
												ng-keyup="amountCalculationBCTable(row.bcAmount,trIndex,row)"
												form-name="disbursementAccountForm"
												ng-pattern-restrict="^\d+(?:\.\d{0,6})?$"
												validation="required" step="0.01"
												friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" readOnly>
										</div>
									</div>
								</td>
							</tr>
							<!-- disbursementAccount.indiaPort -->
							<tr ng-show="disbursementAccount.indiaPort">

								<td><label class="i-checks m-b-none"> <label
										class="i-checks"> <input type="checkbox"
											class="checkbox style-0" checked="checked"
											ng-false-value="'N'" ng-true-value="'Y'" name="chkIndTax"
											id="chkIndTax" ng-model="row.chkIndTax"
											ng-click="chkIndTax(row)"> <i></i></label></td>

								<td colspan="1">
									<div class="col-sm-12 padding-top-5">
										<label class="col-md-6 control-label">Ser.Tax-14% </label>
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												id="serviceTax{{trIndex}}" ng-model="row.serviceTax"
												name="serviceTax" ng-disabled="true"
												friendly-name="{{ 'Row' + $index + '(Service Tax)'}}" />
										</div>
									</div>
								</td>
								<td colspan="2">
									<div class="padding-top-5">
										<label class="col-md-7 control-label"> Swachh.Tax -0.5
											% </label>
										<div class="col-md-5">
											<input type="text" class="form-control input-sm text-right"
												id="swachhBharatTax{{trIndex}}"
												ng-model="row.swachhBharatTax"
												name="swachhBharatTax{{trIndex}}" ng-disabled="true" />
										</div>
									</div>
								</td>
								<td colspan="2">
									<div class="padding-top-5">
										<label class="col-md-7 control-label"> Krishi.Tax-0.5%
										</label>
										<div class="col-md-5">
											<input type="text" class="form-control input-sm text-right"
												id="krishiKalyanTax{{trIndex}}"
												ng-model="row.krishiKalyanTax"
												name="krishiKalyanTax{{trIndex}}" ng-disabled="true"
												friendly-name="{{ 'Row' + $index + '(Krishi Kalyan Tax)'}}" />
										</div>
									</div>
								</td>
								<td></td>
								<td>
									<div class="padding-top-5">
										<input type="text" class="form-control input-sm text-right"
											id="tcTax{{trIndex}}" ng-model="row.tcTax"
											name="tcTax{{trIndex}}" ng-disabled="true"
											form-name="disbursementAccountForm">
									</div>

								</td>
								<td>
									<div class="padding-top-5">
										<input type="text" class="form-control input-sm text-right"
											id="bcTax{{trIndex}}" ng-model="row.bcTax"
											name="bcTax{{trIndex}}" ng-disabled="true"
											form-name="disbursementAccountForm">
									</div>

								</td>
							</tr>
						</tbody>
					</table>
					<div class="table-responsive">
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRow(disbursementAccount.credittables)"
									class="btn btn-sm btn-info" tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRow(disbursementAccount.credittables)"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
							<div class="col-md-8">
								<div class="form-group">
									<label class="col-md-6 control-label">Total </label>
									<div class="col-md-3">
										<input type="text" class="form-control input-sm text-right"
											ng-model="disbursementAccount.totalTCAmount" readonly
											name="TC Total" placeholder="0.0">
									</div>
									<div class="col-md-3">
										<input type="text" class="form-control input-sm text-right"
											ng-model="disbursementAccount.totalBCAmount" readonly
											name="BC Total" placeholder="0.0">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<table class="table table-striped b-t b-light">
							<tbody>
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-12"></div>
										</div>
									</td>
									<td>
										<div class="row">
											<label class="col-md-6 control-label bold">20'S </label>
										</div>
									</td>
									<td>
										<div class="row">
											<label class="col-md-6 control-label bold">40'S </label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-12">INBOUND LADEN</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="inboundladen" readonly
													ng-model="disbursementAccount.inBoundLaden"
													name="inBoundLaden">
											</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="inBoundLaden40" readonly
													ng-model="disbursementAccount.inBoundLaden40"
													name="inBoundLaden40">
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-12">INBOUND EMPTY</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="inboundempty" readonly
													ng-model="disbursementAccount.inBoundEmpty"
													name="inBoundEmpty">
											</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="inboundempty40" readonly
													ng-model="disbursementAccount.inBoundEmpty40"
													name="inBoundEmpty40">
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-12">OUTBOUND LADEN</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="outboundladen" readonly
													ng-model="disbursementAccount.outBoundLaden"
													name="outBoundLaden">
											</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="outboundladen40" readonly
													ng-model="disbursementAccount.outBoundLaden40"
													name="outBoundLaden40">
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="row">
											<div class="col-xs-12">OUTBOUND EMPTY</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="outboundempty" readonly
													ng-model="disbursementAccount.outBoundEmpty"
													name="outBoundEmpty">
											</div>
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm text-right"
													id="outboundempty40" readonly
													ng-model="disbursementAccount.outBoundEmpty40"
													name="outBoundEmpty40">
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- <div class="" ng-repeat="(tIndex, crtable) in disbursementAccount.credittables">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <th colspan=1 class="width_1"></th>
            <th colspan=1 class="width_10 text-center">Port Expences</th>
            <th colspan=1 class="width_10 text-center">Sub Group Acct.</th>
            <th colspan=1 class="width_13 text-center">Account Head</th>
            <th colspan=1 class="width_10 text-center">Invoice No.</th>
            <th colspan=1 class="width_10 text-center">Ref. ID</th>
            <th colspan=1 class=" width_10 text-center">Currency</th>
            <th colspan=1 class=" width_10 text-center">Rate</th>            
            <th colspan=1 class=" width_10 text-center">Amount</th>            
            <th colspan=1 class="width_10 text-center">Amount (USD)</th>
            <th colspan=1 class="width_1"></th>          
          </tr>
        </thead>
        <tbody ng-repeat="(trIndex, row) in crtable.crTblRow" >
         <tr>
             <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
                       
           <td>
              <div class="row">
               <div class="col-xs-12">
             <input type="text" placeholder="Search Account Head" ng-model="row.expenseType" name="expenseType0{{trIndex}}"
                                          typeahead="ac.id as ac.text for ac in portExpList | filter:$viewValue | limitTo:10" 
                                          class="form-control input-sm" required >
              <selectivity  list="portExpList" property="row.expenseType" id="expenseType0{{trIndex}}" object="tempDropDownObj"></selectivity>                              
   
            </div>
           </div>
          </td>
           <td>
              <div class="row">
               <div class="col-xs-12">
                             
                     <input type="text" placeholder="Search Sub Group Account" ng-model="row.subGroupAcct" id="subGroupAcct0{{trIndex}}"
                                          typeahead="ac  as ac.text for ac in subGroupAcctLsit | filter:$viewValue | limitTo:10"  typeahead-on-select='fetchAcctHeadDescription($item, row, $label)'
                                          class="form-control input-sm" required >
                                          
             <selectivity  list="subGroupAcctLsit" property="row.subGroupAcctCode" id="subGroupAcctCode0{{trIndex}}" object="tempDropDownObj"></selectivity>
                                          
            </div>
           </div>
          </td>
          <td>
              <div class="row">
               <div class="col-xs-12">
               <selectivity  list="acctHeadList" property="row.accountHeadCode" id="accountHeadCode0{{trIndex}}" object="tempDropDownObj"></selectivity>
                <input type="text" placeholder="Search Account Head" ng-model="row.accountHeadCode" name="accountHeadCode0{{trIndex}}"
                                          typeahead="ac as ac.text for ac in acctHeadList | filter:$viewValue | limitTo:10"  typeahead-on-select='setAcctHeadCode($item, row, $label)'
                                          class="form-control input-sm" required >               
          
            </div>
           </div>
          </td>
            <td class="width_10">
             <div class="row" >
               <div class="col-xs-12"> 
                <input type="text" class="form-control input-sm" name="invoiceNo0{{trIndex}}" data-ng-model="row.invoiceNo" required />
                 </div>
                </div>
             </td>
             <td class="width_10">
             <div class="row" >
               <div class="col-xs-12"> 
                <input type="text" class="form-control input-sm" name="refId0{{trIndex}}" data-ng-model="row.refId" required />
                 </div>
                </div>
             </td>
             <td class="width_10">
              <div class="row" >
               <div class="col-xs-12"> 
                <selectivity  list="currencyList" property="row.currencyCode" id="currencyCode0{{trIndex}}" object="tempDropDownObj"></selectivity>
                  <input type="text" placeholder="Search Currecny" ng-model="row.currencyCode" name="currencyCode0{{trIndex}}"
                                          typeahead="ac.id  as ac.id for ac in currencyList | filter:$viewValue | limitTo:10"  typeahead-on-select='setExchangeRate($item, $model, $label)'
                                          class="form-control input-sm" required >
                 </div>
                </div>
            
             </td>
             <td class="width_10">
             <div class="row" >
               <div class="col-xs-12"> 
                <input type="text" class="form-control input-sm" name="exchangeRate0{{trIndex}}" data-ng-model="row.exchangeRate" required />
                 </div>
                </div>
             </td>
             <td>
              <div class="row" >
               <div class="col-xs-12"> 
                <input type="text" class="form-control input-sm" name="localAmount0{{trIndex}}" data-ng-model="row.localAmount" 
                ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="amountCalculation(row.localAmount,trIndex,row)" required />
                 </div>
                </div>
             </td>
             <td>
              <div class="row" >
               <div class="col-xs-12"> 
                <input type="text" class="form-control input-sm" name="usdAmount0{{trIndex}}" data-ng-model="row.usdAmount" required />
                 </div>
                </div>
             </td>
       </tr>
       </tbody>
      </table>      
      <div class="padding-right-5" >
       <div class="col-xs-4"> 
           <button ng-click="addRow(crtable)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>
           </button>
           <button ng-click="removeRow(crtable)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
           </div>
            <div class="col-xs-5 text-right">
            SUB TOTAL
            </div>
           <div class="col-xs-3"> 
            <div class="col-xs-1"> </div>
            <div class="col-xs-5"> 
            <input type="text" class="form-control input-sm" name="totalLocalAmount" data-ng-model="disbursementAccount.totalLocalAmount" required />
            </div>
            <div class="col-xs-5"> 
             <input type="text" class="form-control input-sm" name="totalUsdAmount" data-ng-model="disbursementAccount.totalUsdAmount" required />
             </div>
             </div>
      </div> /padding-right-5 - /AddOrRmvebtn
 </div>  -->
					<!--      <div class="row">
           <div class="col-md-12">      
                     <div class="col-xs-4"> 
         
         </div>
            <div class="col-xs-5 text-right">
           GRAND TOTAL
            </div>
           <div class="col-xs-3"> 
            <div class="col-xs-1"> </div>
            <div class="col-xs-5"> 
            <input type="text" class="form-control input-sm" name="grandTotalLocalAmount" data-ng-model="disbursementAccount.grandTotalLocalAmount" required />
            </div>
            <div class="col-xs-5"> 
             <input type="text" class="form-control input-sm" name="grandTotalUsdAmount" data-ng-model="disbursementAccount.grandTotalUsdAmount" required />
             </div>
             </div>   
           </div>
         </div> -->
				</div>
				<br>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" id="savebt" ng-model="savebt"
								type="button"
								ng-click="submit(disbursementAccountForm,disbursementAccount)"
								ng-if="isEdit!='true'">
								<i class="fa fa-plus"></i> Save
							</button>
							<button class="btn btn-info" type="button" ng-if="isEdit!='true'"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-success" id="updatebt" ng-model="updatebt"
								type="button" ng-if="isEdit=='true'"
								ng-click="submit(disbursementAccountForm,disbursementAccount)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" type="reset" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
