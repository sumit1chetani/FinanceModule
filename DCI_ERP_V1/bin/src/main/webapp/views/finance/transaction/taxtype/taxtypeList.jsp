<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" novalidate name="freightmanifestform">

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<div style="float: right;">
								<security:authorize access="hasRole('${form_code}_${export}')">

									<button id="exportXl" class="btn btn-primary"
										data-ng-click="exportExcel();" type="button">
										<i class="fa fa-print"></i> Export Excel
									</button>
								</security:authorize>
								<security:authorize access="hasRole('${form_code}_${export}')">
									<button id="exportXl" class="btn btn-primary"
										data-ng-click="printReport();" type="button">
										<i class="fa fa-print"></i>Print
									</button>
								</security:authorize>
								
							</div>
						</div>
					</div>
				</div>


				<div class="panel panel-default panel-default-list"
					st-table="displayedCollection" st-safe-src="rowCollection">

					<div class="panel-body float-left padding-0" style="width: 100%;">
						<div class="table-responsive " style=" border: 1px solid #CCC;">
							<table
								class="table table-striped table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head"  style="background-color: #e2e2e2;">
									<tr>
										<th class="width_6 text-center">Type Code</th>
										<th class="width_6 text-center">Type Name</th>
										<th class="width_6 text-center">Type Ledger Name</th>
										<th class="width_6 text-center">Branch</th>
										<th class="width_6 text-center">Tax in %</th>
										<th class="width_6 text-center">Charge Head</th>
									</tr>
								</thead>
								<tbody class="dataTables-Main-Body">
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="FreightManifest in displayedCollection">
										<td class="width_6 padding-number-align text-center">{{FreightManifest.code}}</td>
										<td class="width_6 padding-number-align text-center">{{FreightManifest.name}}</td>
										<td class="width_6 padding-number-align text-center">{{FreightManifest.lname}}</td>
										<td class="width_6 padding-number-align text-center">{{FreightManifest.branchname}}</td>
										<td class="width_6 padding-number-align text-center">{{FreightManifest.taxp}}</td>
										<td class="width_6 padding-number-align text-center">{{FreightManifest.chargeHeads}}</td>


									</tr>
								</tbody>
							</table>
						</div>
						<footer class="panel-footer panel-footer-list" style="padding:0px;">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>
					</div>
				</div>


			</form>
		</div>
	</div>
</div>

