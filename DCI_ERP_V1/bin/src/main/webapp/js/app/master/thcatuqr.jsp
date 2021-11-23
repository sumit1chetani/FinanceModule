<style>
.multiselect {
	width: 157px !important
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md" id="thcatuqr" style="display: none">
	<div class="panel panel-default panel-default-form ">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb padding-left-0">
				<li><a> Finance </a></li>
				<li><a>Control Screen</a></li>
				<li><a>Tariff</a></li>
				<li><a>THC Cost Tariff</a></li>
			</ol>
		</div>
		<div class="panel-body">
			<form class="form-horizontal">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7">
									<select ng-model="customer" multiple="multiple"
										id="customer_id" name="customer_id"
										ng-options="option.id as option.text for option in customerlist"
										ng-disabled="disabled">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Valid From </label>
								<div class="col-md-7 inputGroupContainer">
									<div class="input-group input-append date" id="validFromDate">
										<input type="text" class="form-control input-sm"
											name="validFrom" id="validFrom"
											ng-model="thcaatuqr.validFrom" /> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
									<!-- <input type="date" class="form-control input-sm" name="validFrom" data-ng-model="porttariff.validFrom" required> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">LADEN 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.d40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">EMPTY HC 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.mh40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">OOG 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.oog40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">RI40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.ri40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">MI40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.mi40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">General Mertic</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.generalMertic"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
						</fieldset>
					</div>



					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">Port</label>
								<div class="col-md-7">
									<selectivity list="portList" property="thcaatuqr.port"
										ng-if="!edit" id="port_id" name="port_id"
										ng-model="thcaatuqr.port"></selectivity>

									<input type="text" ng-model="thcaatuqr.port" ng-if="edit"
										disabled class="form-control input-sm ">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">EMPTY 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.m40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">LADEN 45</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.d45"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">IMCO 5.1 20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.imco20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">REEFER 20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.r20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">DI20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.di20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">RH40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.rh40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">stevedore</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.stevedore"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">Currency</label>
								<div class="col-md-7">
									<selectivity list="currencyList" property="thcaatuqr.currency"
										id="currency_id" name="currency_id"
										ng-model="thcaatuqr.currency"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">EMPTY 45</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.m45"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">LADEN 20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.d20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">IMCO 5.1 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.imco40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">REEFER 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.r40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">DI40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.di40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">OOGI20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.oogi20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">SHIPMENT</label>
								<div class="col-md-7">
									<selectivity list="termsofshipmentList"
										property="thcaatuqr.shipment" id="shipment_id"
										name="shipment_id" ng-model="thcaatuqr.shipment"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">EMPTY 20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.m20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">LADEN HC 40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.dh40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">OOG 20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.oog20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">RI20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.ri20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">MI20</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.mi20"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">OOGI40</label>
								<div class="col-md-7">
									<div class="input-group">
										<input type="text" ng-model="thcaatuqr.oogi40"
											class="form-control input-sm text-right">

									</div>
								</div>
							</div>
							<div class="form-group" style="display: none">
								<label class="col-md-5 control-label">Valid Till </label>
								<div class="col-md-7 inputGroupContainer">
									<div class="input-group input-append date" id="validToDate">
										<input type="text" class="form-control input-sm"
											name="validTo" id="validTo" ng-model="thcaatuqr.validTill" />
										<span class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="row text-center">
					<div class="row">
						<div class="col-md-12 ">

							<button class="btn btn-success" type="button" ng-if="!edit"
								ng-click="submit(thcaatuqr)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button" ng-if="edit"
								ng-click="submitupdate(thcaatuqr)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" type="button" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="wrapper-md" id="listthcatuqr" style="display: block">
	<div class="panel panel-default panel-default-form">

		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb padding-left-0">
				<li><a> Finance </a></li>
				<li><a>Control Screen</a></li>
				<li><a>Tariff</a></li>
				<li><a>THC Cost Tariff</a></li>
			</ol>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" ng-submit="search(reportBuilder)"
				name="Stackusageform" novalidate method="post">
				<div class="panel panel-default panel-default-list"
					st-table="displayedCollection" st-safe-src="rowCollection">
					<%@include file="/views/templates/panel-header.jsp"%>
					<div class="panel-body">
						<div class="table-responsive ">
							<table
								class="table table-striped b-t b-light table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr>

										<th class="width_12" st-sort="id">Id</th>
										<th class="width_12" st-sort="customerName">Customer</th>
										<th class="width_12" st-sort="port">PORT</th>
										<th class="width_12" st-sort="currency">Currency</th>
										<th class="width_12" st-sort="shipment">Shipment</th>
										<th class="width_18" st-sort="validFrom">Valid From</th>
										<th class="width_18" st-sort="validTill">Valid Till</th>
										<th class="width_12" st-sort="d20">D20</th>
										<th class="width_12" st-sort="d40">D40</th>
										<th class="width_12" st-sort="d45">D45</th>
										<th class="width_12" st-sort="dh40">DH40</th>
										<th class="width_12" st-sort="m20">M20</th>
										<th class="width_12" st-sort="m40">M40</th>
										<th class="width_12" st-sort="m45">M45</th>
										<th class="width_12" st-sort="mh40">MH40</th>
										<th class="width_12" st-sort="r20">R20</th>
										<th class="width_12" st-sort="r40">R40</th>
										<th class="width_12" st-sort="oog20">OOG20</th>
										<th class="width_12" st-sort="oog40">OOG40</th>
										<th class="width_12" st-sort="imco20">IMCO 5.1 20</th>
										<th class="width_12" st-sort="imco40">IMCO 5.1 40</th>
										<th class="width_12" st-sort="oog40">RI20</th>
										<th class="width_12" st-sort="oog40">RI40</th>
										<th class="width_12" st-sort="oog40">DI20</th>
										<th class="width_12" st-sort="oog40">DI40</th>
										<th class="width_12" st-sort="oog40">MI20</th>
										<th class="width_12" st-sort="oog40">MI40</th>
										<th class="width_12" st-sort="oog40">RH40</th>
										<th class="width_12" st-sort="oogi20">OOGI20</th>
										<th class="width_12" st-sort="oogi40">OOGI40</th>
										<th class="width_12" st-sort="generalMertic">General
											Metric</th>
										<th class="width_12" st-sort="Stevedore">Stevedore</th>

										<th class="width_12">Actions</th>

									</tr>
								</thead>
								<tbody ng-repeat="data in displayedCollection track by $index ">
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
										<td class="width_12"><span tooltip="{{data.stackCostId}}"
											class="tool-tip-span"> {{data.id}}</span></td>
										<td class="width_12"><span
											tooltip="{{data.customerName}}" class="tool-tip-span">
												{{data.customerName}}</span></td>
										<td class="width_12"><span tooltip="{{data.port}}"
											class="tool-tip-span"> {{data.port}}</span></td>
										<td class="width_12"><span tooltip="{{data.currency}}"
											class="tool-tip-span"> {{data.currency}}</span></td>
										<td class="width_12"><span tooltip="{{data.shipment}}"
											class="tool-tip-span"> {{data.shipment}}</span></td>
										<td class="width_15"><span tooltip="{{data.validFrom}}"
											class="tool-tip-span">{{data.validFrom}}</span></td>
										<td class="width_15"><span tooltip="{{data.validTill}}"
											class="tool-tip-span"> {{data.validTill}}</span></td>
										<td class="width_12"><span tooltip="{{data.d20}}"
											class="tool-tip-span"> {{data.d20}}</span></td>
										<td class="width_12"><span tooltip="{{data.d40}}"
											class="tool-tip-span"> {{data.d40}}</span></td>
										<td class="width_12"><span tooltip="{{data.d45}}"
											class="tool-tip-span"> {{data.d45}}</span></td>
										<td class="width_12"><span tooltip="{{data.dh40}}"
											class="tool-tip-span"> {{data.dh40}}</span></td>
										<td class="width_12"><span tooltip="{{data.m20}}"
											class="tool-tip-span"> {{data.m20}}</span></td>
										<td class="width_12"><span tooltip="{{data.m40}}"
											class="tool-tip-span"> {{data.m40}}</span></td>
										<td class="width_12"><span tooltip="{{data.m45}}"
											class="tool-tip-span"> {{data.m45}}</span></td>
										<td class="width_12"><span tooltip="{{data.mh40}}"
											class="tool-tip-span"> {{data.mh40}}</span></td>
										<td class="width_12"><span tooltip="{{data.r20}}"
											class="tool-tip-span"> {{data.r20}}</span></td>
										<td class="width_12"><span tooltip="{{data.r40}}"
											class="tool-tip-span"> {{data.r40}}</span></td>
										<td class="width_12"><span tooltip="{{data.oog20}}"
											class="tool-tip-span"> {{data.oog20}}</span></td>
										<td class="width_12"><span tooltip="{{data.oog40}}"
											class="tool-tip-span"> {{data.oog40}}</span></td>
										<td class="width_12"><span tooltip="{{data.imco20}}"
											class="tool-tip-span"> {{data.imco20}}</span></td>
										<td class="width_12"><span tooltip="{{data.imco40}}"
											class="tool-tip-span"> {{data.imco40}}</span></td>
										<td class="width_12"><span tooltip="{{data.ri20}}"
											class="tool-tip-span"> {{data.ri20}}</span></td>
										<td class="width_12"><span tooltip="{{data.ri40}}"
											class="tool-tip-span"> {{data.ri40}}</span></td>
										<td class="width_12"><span tooltip="{{data.di20}}"
											class="tool-tip-span"> {{data.di20}}</span></td>
										<td class="width_12"><span tooltip="{{data.di40}}"
											class="tool-tip-span"> {{data.di40}}</span></td>
										<td class="width_12"><span tooltip="{{data.mi20}}"
											class="tool-tip-span"> {{data.mi20}}</span></td>
										<td class="width_12"><span tooltip="{{data.mi40}}"
											class="tool-tip-span"> {{data.mi40}}</span></td>
										<td class="width_12"><span tooltip="{{data.rh40}}"
											class="tool-tip-span"> {{data.rh40}}</span></td>
										<td class="width_12"><span tooltip="{{data.oogi20}}"
											class="tool-tip-span"> {{data.oogi20}}</span></td>
										<td class="width_12"><span tooltip="{{data.oogi40}}"
											class="tool-tip-span"> {{data.oogi40}}</span></td>
										<td class="width_12"><span
											tooltip="{{data.generalMertic}}" class="tool-tip-span">{{data.generalMertic}}</span></td>
										<td class="width_12"><span tooltip="{{data.stevedore}}"
											class="tool-tip-span"> {{data.stevedore}}</span></td>
										<td class="width_10 td-actions text-center"><span
											ng-if="data.iconview"> <i
												class="fa  fa-pencil text-success text"
												data-ng-click="editrow(data)"></i>
										</span> <security:authorize
												access="hasRole('${form_code}_${modify}')">

											</security:authorize> <security:authorize
												access="hasRole('${form_code}_${delete}')">
												<span> <i class="fa fa-trash-o text-danger-dker text"
													data-ng-click="deleterow(data.id)"></i>
												</span>
											</security:authorize></td>

									</tr>
								</tbody>
							</table>
						</div>
						<footer class="panel-footer">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>