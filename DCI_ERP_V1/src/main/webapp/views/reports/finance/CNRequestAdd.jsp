<div class="wrapper-md">

		<div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>

		</div>

		<div class="panel-body">
			<form class="form-horizontal" name="AssetMasterForm" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group" ng-show="!edit">
								<label class="col-md-4 control-label">Invoice No</label>
								<div class="col-md-5">
									<div id="invoice"
										class="selectivity-input example-input selectivity-slot invoiceNo">
										<input type="text"
											class="input-sm selectivity-single-select-input"
											nextvalue="validFromDate">
									</div>
									<!-- <selectivity list="invoiceNoList"
										property="cnReq.invoiceNo" id="invoiceNo"
										object="invoiceNo"></selectivity> -->
								</div>
							</div>
							<div class="form-group" ng-if="edit">
								<label class="col-md-4 control-label">Invoice No</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.invoiceNo"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Date Raised</label>
								<div class="col-md-5">
									<div class="input-group input-append date" id="date_raised">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="cnReq.dateRaised"
											name="dateRaised" id="dateRaised"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group">

								<label class="col-md-4 control-label">Customer</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.mlo"></label>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Payer</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.payer"></label>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Invoice Date
									Issued</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.invoiceDate"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Quotation No</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.quoNo"></label>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Rebilled Invoice
									No</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.rebInvNo"></label>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Shipment Date</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.shipDate"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Service</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.service"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.vessel"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Voyage</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.voyage"></label>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Currency</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.currencyCode"></label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">LOL</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.pol"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">LOD</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.pod"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">File Upload </label>
								<div class="col-md-5">
									<div class="input-group">
										<input type="file" class="form-control btn-primary"
											name="excelfile"
											onchange="angular.element(this).scope().uploadFile(this)" />

										<span class="input-group-btn ">
											<button class="btn btn-info input-sm" type="button"
												ng-click="adduploadfiles()" data-toggle="tooltip"
												title="Add File">
												<i class="fa fa-plus"></i>
											</button>
										</span>
									</div>
								</div>
								<div class="col-md-3"></div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-7">
									<div class="" ng-repeat="(tIndex, filelist) in cnReq.files">
										<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
										<div ng-if="filelist.cnno!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)"
												style="color: green">{{filelist.filename}}</a>
										</div>

										<div ng-if="filelist.cnno==''">
											{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
												ng-click="deleteuploadfiles(filelist.filename)"
												data-toggle="tooltip" title="Delete file">
												<i class="fa fa-trash"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<!-- <div class="form-group">
								<label class="col-md-4 control-label">POL</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.pol"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">POD</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.pod"></label>
								</div>
							</div> -->
							<!-- <div class="form-group"
								ng-if="userId=='E151' || userId=='E458' || userId=='E527'">
								<label class="col-md-4 control-label">Revised Quotation
									No</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="revQuo"
										ng-model="cnReq.revQuo">
								</div>
							</div> -->
						<!-- 	<div class="form-group"
								ng-if="userId!='E151' && userId!='E458' && userId!='E527'">
								<label class="col-md-4 control-label">Revised Quotation
									No</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="revQuo"
										ng-model="cnReq.revQuo" disabled>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">CN Type</label>
								<div class="col-md-5">
									<selectivity list="cnTypeList" property="cnReq.cnType"
										id="cnType" object="cnType"></selectivity>
								</div>
							</div>
							<div class="form-group"
								ng-if="cnReq.cnType=='F'  && (userId=='E0001')">
								<label class="col-md-4 control-label">Rebill Invoice</label>
								<div class="col-md-5">

									<label> <input type="radio" ng-model="cnReq.rebill"
										value="Yes"> Yes
									</label> <label> <input type="radio" ng-model="cnReq.rebill"
										value="No"> No
									</label><br />



								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Category Of CN</label>
								<div class="col-md-5">
									<selectivity list="catCNList" property="cnReq.catCN" id="catCN"
										object="catCN"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Detailed
									Explanation For The CN Request</label>
								<div class="col-md-5">
									<textarea rows="2" cols="35" name="expCN"
										class="form-control input-sm resize-vertical"
										ng-model="cnReq.expCN" maxlength="250"></textarea>
								</div>
							</div>



						<!-- 	<div class="form-group"
								ng-if="userId=='E151' || userId=='E458' || userId=='E527'">
								<label class="col-md-4 control-label">Pricing Comments</label>
								<div class="col-md-5">
									<textarea rows="2" cols="35" name="priCom"
										class="form-control input-sm resize-vertical"
										ng-model="cnReq.priCom" maxlength="250"></textarea>
								</div>
							</div> -->


							<!-- <div class="form-group"
								ng-if="userId!='E151' &&  userId!='E458' && userId!='E527'">
								<label class="col-md-4 control-label">Pricing Comments</label>
								<div class="col-md-5">
									<textarea rows="2" cols="35" name="priCom"
										class="form-control input-sm resize-vertical"
										ng-model="cnReq.priCom" maxlength="250" disabled></textarea>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Requesting Office</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="reqFee"
										ng-model="cnReq.reqFee">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Department</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="department" ng-model="cnReq.department">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Exchange Rate</label>
								<div class="col-md-5">
									<label class="control-label" ng-bind="cnReq.exchangeRate"></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Person</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="person"
										ng-model="cnReq.person">
								</div>
							</div>

						</fieldset>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_13 text-center">Account Head<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_10 text-center">Narration<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_10 text-center">TC Amt<span
									style="color: red;"> *</span></th>
								<th colspan=1 class=" width_10 text-center">BC
									Amt({{companyCurrency}})<span style="color: red;"> *</span>
								</th>
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in cnReq.credittables"
							ng-controller="cnRequesttablectrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="crdtlAcctHeadList"
												property="row.crdtlAccountHead"
												id="accountHeadCode{{trIndex}}" object="accHead"
												ng-model="row.crdtlAccountHead"
												name="accountHeadCode{{trIndex}}" validation="required"
												disabled="true"
												friendly-name="{{ 'Row' + $index + '(Account Head)'}}"
												form-name="creditNoteForm"></selectivity>
										</div>
									</div>
								</td>

								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="narration" data-ng-model="row.narration" disabled
												name="narration{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												name="tcamount" data-ng-model="row.tcamount"
												ng-keyup="bcamountCalculation(row.tcamount,trIndex,row)"
												ng-disabled="dtldisabled" name="tcAmount{{trIndex}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												data-ng-model="row.bcamount" step="0.01"
												ng-blur="tcamountCalculation(row.bcamount,trIndex,row)"
												ng-disabled="dtldisabled" name="bcamount{{trIndex}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
												friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" />
										</div>
									</div>
								</td>

							</tr>
						</tbody>
					</table>
				</div>

				<br>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button ng-model="add" class="btn btn-success" type="submit"
								ng-if="!edit" ng-click="save(cnReq)">
								<i class="fa fa-save"></i>Save
							</button>
							<!-- 	<button class="btn btn-primary"  ng-if="!cnReq.edit" type="button"  ng-click="reset()">
								<i class="fa fa-reply"></i>Reset
							</button> -->
							<button class="btn btn-success" ng-if="edit" type="submit"
								ng-click="update(AssetMasterForm)">
								<!-- ng-disabled="AssetMasterForm.$error.required -->
								<i class="fa fa-save"></i>Update
							</button>
							<!-- <button class="btn btn-primary"  ng-if="cnReq.edit" type="button"  ng-click="reset()">
								<i class="fa fa-reply"></i>Reset
							</button>  -->
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i>Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

