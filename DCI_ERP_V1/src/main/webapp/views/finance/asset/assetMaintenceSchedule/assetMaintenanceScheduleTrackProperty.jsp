<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					
					<div
						class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all padding-top-10"
						data-st-table="displayedCollection"
						data-st-safe-src="assetTrackDEtailList">
						<table id="dt_basic"
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dt_basic_info">
							<thead class="dataTables-Main-Head">
								<tr>
									<th class="width_1 table-heading text-center"><label
										class="i-checks m-b-none"> <input type="checkbox">
											<i></i>
									</label></th>
									<th class="table-heading width_7">Asset Track No</th>
									<th class="table-heading width_7">Asset Name</th>
									<th class="table-heading width_7">Serial No</th>
									<th class="table-heading width_7">Asset Location</th>
									<th class="table-heading width_7">Responsible</th>
									<th class="table-heading width_7">Asset User</th>
								</tr>
							</thead>

							<tbody>
								<tr  data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									data-ng-repeat="objAssetRequistion in displayedCollection">

									<td><label class="i-checks m-b-none"><input
											type="checkbox"
											data-ng-model="objAssetRequistion.assetTrackConfirm">
											<i></i></label></td>
									<td>{{objAssetRequistion.assettrackNo}}</td>
									<td>{{objAssetRequistion.assettrackName}}</td>
									<td>{{objAssetRequistion.serialNo}}</td>
									<td>{{objAssetRequistion.asstlocation}}</td>
									<td>{{objAssetRequistion.resAsset}}</td>
									<td>{{objAssetRequistion.user}}</td>
								</tr>
							</tbody>


						</table>
					</div>

					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" type="button"
									data-ng-if="!isEdit" data-ng-click="addAssetTrackDetails(assetTrackDEtailList)"
									class="btn btn-success">
									<i class="fa fa-save"></i>
									Add
								</button>
								<button class="btn btn-danger" type="reset"
									class="btn btn-success" data-ng-click="ngcancel()">
									<i class="fa fa-close"></i>
									<spring:message code="label.cancel"></spring:message>
								</button>
							</div>
						</div>
					</div>

					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>