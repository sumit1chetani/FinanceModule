<style>
.hideByDefault{
    display: none;
}
#showdiv:hover {
  color: red;
  background-color: yellow;
}

</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="loadingSummaryForm" class="form-horizontal" novalidate>
				<div class="row">
				<br>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Mode<span style="color:red">*</span></label>
								<div class="col-md-5">
									<selectivity list="modeList"
										property="loadingReport.mode" id="mode"
										name="mode" ng-model="loadingReport.mode"
										object="mode" friendly-name="Mode"
										 form-name="loadingSummaryForm" validatin="required"
										></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					
					<div class="col-sm-12 col-md-12 col-lg-6" ng-if="loadingReport.mode==4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Carrier<span style="color:red">*</span></label>
								<div class="col-md-5">
								<selectivity list="carrierList" ng-model="loadingReport.carrier"
											property="loadingReport.carrier" id="carrier" name="carrier" validation="required"
											form-name="loadingSummaryForm" friendly-name="carrier"></selectivity>
									
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-6" ng-if="loadingReport.mode!=4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Carrier</label>
								<div class="col-md-5">
								<selectivity list="carrierList" ng-model="loadingReport.carrier"
											property="loadingReport.carrier" id="carrier" name="carrier"
											form-name="loadingSummaryForm" friendly-name="carrier"></selectivity>
									
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Customer</label>
								<div class="col-md-5">
									<selectivity list="customer"
										property="loadingReport.customerHdr" id="customerHdr"
										ng-model="loadingReport.customerHdr" name="customerHdr"
										friendly-name="Customer"
										form-name="loadingSummaryForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Date From</label>
								<div class="col-md-5">
								<div class="row">
									<div class="col-xs-12">
											<ng-bs3-datepicker data-ng-model="loadingReport.datefromHdr"
											id="datefromHdr" name="datefromHdr"
											form-name="loadingSummaryForm"
											friendly-name="Date From"/>
										</div>
										</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Voyage</label>
								<div class="col-md-5">
									<selectivity list="voyage"
										property="loadingReport.voyageHdr" id="voyageHdr"
										ng-model="loadingReport.voyageHdr" name="voyageHdr"
										friendly-name="Voyage"
										form-name="loadingSummaryForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Date To</label>
								<div class="col-md-5">
									<div class="row">
									<div class="col-xs-12">
											<ng-bs3-datepicker data-ng-model="loadingReport.datetoHdr"
											id="datetoHdr" name="datetoHdr"
											form-name="loadingSummaryForm"
											friendly-name="Date To"/>
										</div>
										</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Week</label>
								<div class="col-md-5">
									<selectivity list="week"
										property="loadingReport.weekHdr" id="weekHdr"
										ng-model="loadingReport.weekHdr" name="weekHdr"
										friendly-name="Week"
										form-name="loadingSummaryForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Month</label>
								<div class="col-md-5">
									<selectivity list="month"
										property="loadingReport.monthHdr" id="monthHdr"
										ng-model="loadingReport.monthHdr" name="monthHdr"
										friendly-name="Month"
										form-name="loadingSummaryForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
										<label class="col-md-4 control-label"> Job No 
										</label>
										<div class="col-md-5">
											<selectivity list="jobNoList"
												ng-model="loadingReport.jobNo"
												property="loadingReport.jobNo" id="job_no"
												object="jobNo" name="job_no" 
												friendly-name="jobNo" form-name="loadingSummaryForm"></selectivity>
										</div>

									</div>
						</fieldset>
					</div>
					<!-- <div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Loading Type</label>
								<div class="col-md-5">
									<selectivity list="loadingType"
										property="loadingReport.loadingTypeHdr" id="loadingTypeHdr"
										ng-model="loadingReport.loadingTypeHdr" name="loadingTypeHdr"
										friendly-name="Loading Type"
										form-name="loadingSummaryForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div> -->
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						<div class="form-group"  style="margin-left: 38%;">
							<button class="btn btn-success" type="submit" tooltip="View"
									ng-click="getLoadingSummaryData(loadingSummaryForm,loadingReport);">
									<i class="fa fa-search"></i>MBK Summary Report</button>
						</div>
						</fieldset>
					</div>
				</div>
				<br>
				<div class="row-fluid">
					<div class="span12">	
						<div class="accordion" id="accordion2">
							<div class="accordion-group">
								<div class="panel-body float-left padding-0" style="width: 100%;">
							<div class="table-responsive" style="overflow: hidden;">
								<header id="btntoggle" data-role="heading"
									style="margin-bottom: 0px !important;"
									class="btn btn-default col-sm-12 col-md-12 col-lg-12"
									data-ng-click="isCollapsed = !isCollapsed">
									<div class="row">
										<a onmouseover="this.style.color='#0c308f'" style="color: rgb(45, 137, 197);font-size: 15px;"
											onmouseout="this.style.color='#181818'">Report Header</a>
									</div>
								</header>
							</div>
							<div></div>
						</div>
						<div class="panel-body float-left padding-0"
							style="width: 100%; border-top: none;">
							<div class="table-responsive" style="overflow: hidden;">
								<div data-role="content" class="form-horizontal panel"
									data-collapse="!isCollapsed">
									<ul class="dragList row list-unstyled">
										<li class="col-md-3 col-sm-3 col-lg-3">
											<div class="row">
												<label class="control-label col-md-8" style="width: 61%">SELECT
													ALL :</label>
												<div class="col-md-4" style="padding-left: 36px;">
													<label class="i-checks m-b-none checkbox"> <input
														type="checkbox" data-ng-click="selectAll(selectall)"
														data-ng-model="selectall" /><i
														style="margin-left: -12px;"></i>
													</label>
												</div>
											</div>
										</li>
										<li data-ng-repeat="column in dailyLoadingHeaderList"
											class="col-sm-3 col-md-3 col-lg-3">
											<div class="row" data-ng-drag="column.isDraggable"
												data-ng-drop="column.isDraggable"
												data-ng-drop-success="onDropComplete($index, $data,$event)"
												data-ng-drag-data="column" style="width: 100%">
												<label class="control-label col-md-8">{{column.title}}
													:</label>
												<div class="col-md-4">
													<label class="i-checks m-b-none checkbox"> <input
														type="checkbox" data-ng-click="getSelectedColumn(column)"
														data-ng-model="column.visible"
														data-ng-disabled="column.isDefault" /><i></i>
													</label>
												</div>
											</div>
										</li>
										<li class="col-md-3 col-sm-3 col-lg-3 last-child"
											data-ng-drop="true"
											data-ng-drop-success="onDropComplete($index, $data,$event)">
											<div class="row">
												<div class="col-md-4">
													<label class="i-checks m-b-none checkbox"> </label>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
						
						<div ng-if="isExport" class="panel panel-default panel-default-list" st-persist="loadingSummaryTable"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
							<%@include file="/views/templates/panel-header.jsp"%>
							<!-- </div> -->
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive ">
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
										<thead>
											<!-- 										<thead style="background-color:#42a5f5">
 -->
											<th class="width_6"
												data-ng-repeat="column in dailyLoadingHeaderList"
												data-ng-class={hide:(!column.visible)}>{{column.title}}</th>
										</thead>

										<tbody>
											<tr ng-repeat="dailyReport in displayedCollection">
												<td class="width_6 padding-number-align text-center "
													data-ng-repeat="column in dailyLoadingHeaderList"
													data-ng-class={hide:(!column.visible)}><span>{{dailyReport[column.id]}}</span>

												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<footer class="panel-footer panel-footer-list">
									<%@include file="/views/templates/panel-footer-static.jsp"%>
								</footer>
							</div>
							<!-- end widget content -->
						</div>
							</div>
						</div>
					</div>  <!-- /span12 ends -->
					
				<!-- 	<div class="span12" id="jqgrid">
						<div id="enid">
							<table id="containerlistgrid"></table>
							<div id="containerlistgridpage"></div>
						</div>
					</div>
					<div class="span12"></div>
					<div class="span10 offset5">
							<div class="controls" id="expBtn" style="display: none;">
								<button class="btn btn-success" type="button" onclick="getExcelReport();">Export</button>
								<button class="btn btn" type="button" onclick="javascript:cancel();">Cancel</button>
							</div>
					</div>	 -->
				</div>
				
					<div class="form-actions">
					<div class="row">
						<div class="col-md-12" style="margin-top: 1%;">
						<div class="form-group" style="margin-left: 1%;">
						<button ng-if="isExport" class="btn btn-primary" type="submit" tooltip="View"
									ng-click="exportExcel(loadingSummaryForm,loadingReport);">
									<i class="fa fa-search"></i>Excel Export</button>
									<a id="loadingsummaryExport" stype="display:none"
							href="filePath/LoadingSummaryReport.xls" download="LoadingSummaryReport.xls"></a>
						<button class="btn btn-info" type="reset"
								data-ng-click="reset(loadingSummaryForm,loadingReport)">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button ng-if="isExport" class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
						</div>
					</div>
				</div>
				
				
			</form>
		</div>
	</div>
</div>