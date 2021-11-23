<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<form class="form-horizontal" name="agencyTariffAddForm" role="form">
			<div class="row book-widget-row">
				<div class="form-group padder-v">
					<div class="col-sm-10 col-md-10 col-lg-10 p-l-20">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_10 text-center">Vessel - <span data-ng-bind="agencyTariffView.vessel"></span></th>
									<th colspan=1 class="width_10 text-center">Voyage - <span data-ng-bind="agencyTariffView.voyage"></span></th>
									<th colspan=1 class="width_10 text-center">Port - <span data-ng-bind="agencyTariffView.port"></span></th>
								</tr>
								<tr>
									<th colspan=1 class="width_10"></th>
									<th colspan=1 class="width_10 text-center">Calculation</th>
									<th colspan=1 class="width_10 text-center">Result</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>EMPTY IMPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffView.emptyImport}} *
										{{agencyTariffView.emptyImportRates}}</td>
									<td class="width_10" align="right">
										<div>{{agencyTariffView.totalEmptyImport}}</div>
									</td>

								</tr>
								<tr>
									<td>EMPTY EXPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffView.emptyExport}} *
										{{agencyTariffView.emptyExportRates}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.totalEmptyExport}}</td>
								</tr>
								<tr>
									<td>LADEN IMPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffView.ladenImport}}*
										{{agencyTariffView.ladenImportRates}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.totalLadenImport}}</td>
								</tr>
								<tr>
									<td>LADEN EXPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffView.ladenExport}} *
										{{agencyTariffView.ladenExportRates}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.totalLadenExport}}</td>
								</tr>
								<tr>
									<td>HUSBANDRY FEE</td>
									<td class="width_10" align="center">
										{{agencyTariffView.husbandaryFee}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.husbandaryFee}}</td>
								</tr>
								<tr>
									<td>COMMUNICATION</td>
									<td class="width_10" align="center">
										{{agencyTariffView.communication}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.communication}}</td>
								</tr>
								<tr>
									<td>CONVEYANCE</td>
									<td class="width_10" align="center">
										{{agencyTariffView.conveyance}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.conveyance}}</td>
								</tr>
								<tr>
									<td>COURIER</td>
									<td class="width_10" align="center">
										{{agencyTariffView.courier}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.courier}}</td>
								</tr>
								<tr>
									<td>OTHER</td>
									<td class="width_10" align="center">
										{{agencyTariffView.other}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.other}}</td>
								</tr>
								<tr>
								<tr>
									<td>SERVICE TAX</td>
									<td class="width_10" align="center">
										{{agencyTariffView.serviceTax}}</td>
									<td class="width_10" align="right">
										{{agencyTariffView.serviceTax}}</td>
								</tr>
								<tr>

									<td colspan="2" align="right">
										<div>Total Amount</div>
									</td>
									<td class="width_10" align="right">
										{{agencyTariffView.total}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="form-group"
					data-ng-if="agencyTariffViewNextVoyList.length > 0">
					
					<div class="col-sm-10 col-md-10 col-lg-10 p-l-20">
						<table class="table table-striped b-t b-light">
							<thead>
							<tr>
									<th colspan=1 class="width_10 text-center">Vessel - <span data-ng-bind="agencyTariffViewNextVoy.vessel"></span></th>
									<th colspan=1 class="width_10 text-center">Voyage - <span data-ng-bind="agencyTariffViewNextVoy.voyage"></span></th>
									<th colspan=1 class="width_10 text-center">Port - <span data-ng-bind="agencyTariffViewNextVoy.port"></span></th>
								</tr>
								<tr>
									<th colspan=1 class="width_10"></th>
									<th colspan=1 class="width_10 text-center">Calculation</th>
									<th colspan=1 class="width_10 text-center">Result</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>EMPTY IMPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.emptyImport}} *
										{{agencyTariffViewNextVoy.emptyImportRates}}</td>
									<td class="width_10" align="right">
										<div>{{agencyTariffViewNextVoy.totalEmptyImport}}</div>
									</td>

								</tr>
								<tr>
									<td>EMPTY EXPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.emptyExport}} *
										{{agencyTariffViewNextVoy.emptyExportRates}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.totalEmptyExport}}</td>
								</tr>
								<tr>
									<td>LADEN IMPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.ladenImport}}*
										{{agencyTariffViewNextVoy.ladenImportRates}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.totalLadenImport}}</td>
								</tr>
								<tr>
									<td>LADEN EXPORT</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.ladenExport}} *
										{{agencyTariffViewNextVoy.ladenExportRates}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.totalLadenExport}}</td>
								</tr>
								<tr>
									<td>HUSBANDRY FEE</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.husbandaryFee}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.husbandaryFee}}</td>
								</tr>
								<tr>
									<td>COMMUNICATION</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.communication}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.communication}}</td>
								</tr>
								<tr>
									<td>CONVEYANCE</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.conveyance}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.conveyance}}</td>
								</tr>
								<tr>
									<td>COURIER</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.courier}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.courier}}</td>
								</tr>
								<tr>
									<td>OTHER</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.other}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.other}}</td>
								</tr>
								<tr>
								
								<tr>
									<td>SERVICE TAX</td>
									<td class="width_10" align="center">
										{{agencyTariffViewNextVoy.serviceTax}}</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.serviceTax }}</td>
								</tr>
								<tr>

									<td colspan="2" align="right">
										<div>Total Amount</div>
									</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.total}}</td>
								</tr>
							</tbody>
						</table>
						<table class="table table-striped b-t b-light">
							<tbody>
								<tr>

									<td colspan="2" align="right">
										<div>Total</div>
									</td>
									<td class="width_10" align="right">
										{{agencyTariffViewNextVoy.total + agencyTariffView.total}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
		<div class="form-actions">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<button class="btn btn-danger" type="submit" data-ng-click="cancel();">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>

</div>
