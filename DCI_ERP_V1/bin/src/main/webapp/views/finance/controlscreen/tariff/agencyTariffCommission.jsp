<script type="text/javascript">
    $(document).ready(function() {
        $(".mnthYear").datepicker({
            dateFormat : 'MM yy',
            changeMonth : true,
            changeYear : true,
            showButtonPanel : true,

            onClose : function(dateText, inst) {
                var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                $(this).val($.datepicker.formatDate('MM yy', new Date(year, month, 1)));
            }
        });

        $(".mnthYear").focus(function() {
            $(".ui-datepicker-calendar").hide();
            $("#ui-datepicker-div").position({
                my : "center top",
                at : "center bottom",
                of : $(this)
            });
        });
    });
</script>
<style>
.ui-datepicker-calendar {
	display: none;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<form name="hmApprovalForm">
			<div class="row">
				<div class="col-md-12 padding-top-20 padding-bottom-20">
					<div class="row ">
						<div class="form-group">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-4 control-label  vessel-text">Agent</label>
									<div class="col-md-6">
										<selectivity list="agentList"
											property="traiffComObj.agentCode" id="agency_id"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-4 control-label  vessel-text">Voyage
										Hub</label>
									<div class="col-md-8">
										<select class="form-control input-sm"
											ng-model="traiffComObj.voyageHub"
											ng-options="yr.id as yr.text for yr in voyHubList"
											name="voyageHub" friendly-name="voyage Hub">
											<option value="">Select</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-4 control-label  vessel-text">Pol</label>
									<div class="col-md-8">
										<selectivity list="polList"
										property="traiffComObj.pol" name="pol"></selectivity>
										</select>
									</div>
								</div>
							</div>

						</div>
					</div>
					<br>
					<div class="row ">
						<div class="form-group">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-4 control-label"> Month & Year</label>
									<div class="col-md-6">
										<div class="input-group input-append date" id="mnthYear">
											<input type="text" class="form-control input-sm"
												name="mnthYears" id="mnthYears"
												ng-model="traiffComObj.mnthYears" placeholder='mm/yyyy'
												on-change="traiffComObj.fromDate='';traiffComObj.toDate=''"/> <span
												class="input-group-addon add-on"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>
									</div>
								</div>
							</div>

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">From
											Date </label>
										<div class="col-md-8">
											<ng-bs3-datepicker data-ng-model="traiffComObj.fromDate"
												date-format="DD/MM/YYYY" id="sch_start_date" 
												ng-change="traiffComObj.mnthYears=''"/>
										</div>
									</div>
								</fieldset>
							</div>

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">To
											Date </label>
										<div class="col-md-8">
											<ng-bs3-datepicker data-ng-model="traiffComObj.toDate"
												date-format="DD/MM/YYYY" id="sch_start_date" 
												ng-change="traiffComObj.mnthYears=''"/>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
					</div>
					<div align="center">
						<div class="row">
							<div class="col-md-12 m-t-sm">

								<button class="btn btn-success" type="button"
									data-ng-click="agencyTariffComm();">
									<i class="fa fa-search"></i> Search
								</button>
								<button id="exportXl" type="button"
									class="btn btn-primary btn-m"
									ng-click="exportData(traiffComObj)">Export To Excel</button>
								<a id="BQExport" stype="display:none"
									href="filePath/agencyCommission.xls"
									download="agencyCommission.xls"></a>
							</div>
						</div>
					</div>
				</div>



			</div>
			<div class="panel-body">
				<div class="row">
					<div class="table-responsive">
						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" style="width: 100%;">
							<thead>
								<tr role="row">
									<th rowspan=2 class="text-center">Agent</th>
									<th rowspan=2 class="text-center">Service</th>
									<th rowspan=2 class="text-center">Vessel</th>
									<th rowspan=2 class="text-center">Voyage</th>
									<th rowspan=2 class="text-center">Sailing Date</th>
									<!-- 	<th rowspan=2 class="text-center">Ex.Rate</th> -->
									<th rowspan=2 class="text-center">Pol</th>
									<th colspan=3 class="text-center">Import Commission</th>
									<th colspan=3 class="text-center">Export Commission</th>
									<!-- <th colspan=4 class="text-center">Slot Kill</th> -->
									<!-- <th rowspan=2 class="text-center">FD & D</th> -->
									<th rowspan=2 class="text-center">Husbandry Fee</th>
									<th rowspan=2 class="text-center">Communictaion</th>
									<th rowspan=2 class="text-center">Conveyance</th>
									<th rowspan=2 class="text-center">Others</th>
								</tr>

								<tr>
									<th class="text-center">LADEN</th>
									<th class="text-center">EMPTY</th>
									<th class="text-center">Total Import Commn USD</th>
									<!-- <th class="text-center">Total Import Commn</th> -->
									<th class="text-center">LADEN</th>
									<th class="text-center">EMPTY</th>
									<th class="text-center">Total Export Commn USD</th>
									<!-- <th class="text-center">Total Export Commn</th> -->
									<!-- <th class="text-center">Import</th>
									<th class="text-center">Export</th>
									<th class="text-center">Total Slot Kill Commn USD</th>
									<th class="text-center">Total Slot Kill Commn</th> -->
								</tr>
							</thead>
							<tbody>
								<tr data-ng-repeat="traffieComm in displayedCollection">
									<td>{{traffieComm.agentCode}}</td>
									<td>{{traffieComm.sectorCode}}</td>
									<td class="text-right">{{traffieComm.vesselName}}</td>
									<td class="text-right">{{traffieComm.voyageId}}</td>
									<td class="text-right">{{traffieComm.sailingDate}}</td>
									<!-- <td class="text-right">{{traffieComm.exRate | number:2}}</td> -->
									<td class="text-right">{{traffieComm.pol}}</td>
									<td class="text-right">{{traffieComm.ladenImport }}</td>
									<td class="text-right">{{traffieComm.emptyImport }}</td>
									<td class="text-right">{{traffieComm.importTotalUSD |
										number:2}}</td>
									<!-- <td class="text-right">{{traffieComm.importTotalINR |number:2}}</td> -->
									<td class="text-right">{{traffieComm.ladenExport }}</td>
									<td class="text-right">{{traffieComm.emptyExport }}</td>
									<td class="text-right">{{traffieComm.exportTotalUSD |
										number:2}}</td>
									<td class="text-right">{{traffieComm.husbandary_fee |
										number:2}}</td>
									<td class="text-right">{{traffieComm.communication |
										number:2}}</td>
									<td class="text-right">{{traffieComm.conyeyance |
										number:2}}</td>
									<td class="text-right">{{traffieComm.other | number:2}}</td>
									<!-- <td class="text-right">{{traffieComm.exportTotalINR |
										number:2}}</td> -->
									<!-- <td class="text-right">{{traffieComm.importSlot }}</td>
									<td class="text-right">{{traffieComm.exportSlot}}</td>
									<td class="text-right">{{traffieComm.totalSlotUSD |
										number:2}}</td>
									<td class="text-right">{{traffieComm.totalSlotINR |
										number:2}}</td> -->
								</tr>
							</tbody>
						</table>
					</div>
					<footer class="panel-footer panel-footer-list">
						<%@include file="/views/templates/panel-footer-static.jsp"%>
					</footer>
				</div>
			</div>
		</form>
	</div>
</div>