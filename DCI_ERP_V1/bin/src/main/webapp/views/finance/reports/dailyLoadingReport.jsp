<style>
.level_class2 {
	background: #6ca5ee;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class1, .level_class1:hover {
	background: #e58b90;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class3 {
	background: #79c07c;
	color: #fff;
	font-size: 15px;
}


</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">

					<form class="form-horizontal" name="dailyLoadingReportForm">


						<div class="row book-widget-row">
							<br/>

							<div class="col-sm-12 col-md-6 ol-lg-4">
								<fieldset>

									<div class="form-group form-group-label-left">

										<label class="col-md-3 col-md-offset-1 control-label ">Year<span
											style="color: red;">*</span></label>
										<div class="col-md-7">
											<selectivity list="yearList" id="year"
												property="dailyLoadingReport.year"
												ng-model="dailyLoadingReport.year" friendly-name="Year"
												form-name="dailyLoadingReportForm" validation="required"
												name="year"></selectivity>
										</div>
									</div>

								</fieldset>
							</div>

							<div class="col-sm-12 col-md-6 ol-lg-4">
								<fieldset>

									<div class="form-group form-group-label-left">

										<label class="col-md-3 col-md-offset-1 control-label ">Month<span
											style="color: red;">*</span></label>
										<div class="col-md-7">
											<selectivity list="monthList" id="month"
												property="dailyLoadingReport.month"
												ng-model="dailyLoadingReport.month" friendly-name="Month"
												form-name="dailyLoadingReportForm" validation="required"
												name="month"></selectivity>
										</div>
									</div>

								</fieldset>
							</div>

						</div>
												<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
									<button class="btn btn-success" type="submit" tooltip="View"
										ng-click="viewReport(dailyLoadingReportForm,dailyLoadingReport)">
										<i class="fa fa-search"></i> View
									</button>
									<button  class="btn btn-info" tooltip="Reset"
										ng-click="reset()">
										<i class="fa fa-undo"></i>Reset
									</button>
									
									<security:authorize access="hasRole('${form_code}_${export}')">

									<button class="btn btn-primary"
										ng-click="exportExcel(dailyLoadingReportForm,dailyLoadingReport)">
										<i class="fa fa-download"> </i> Export Excel
									</button>

									<a id="dailyExport" href="" download=""></a>
									
									</security:authorize>
								</div>
							</div>
						</div>

			<div class="panel-body float-left padding-0" style="width: 100%;">
				<div class="table-responsive" style="overflow: hidden;">
							<header id="btntoggle" data-role="heading" style="margin-bottom: 0px !important;"
								class="btn btn-default col-sm-12 col-md-12 col-lg-12"
								data-ng-click="isCollapsed = !isCollapsed">
								<div class="row">
									<a onmouseover="this.style.color='#0c308f'" onmouseout="this.style.color='#181818'">Report Header</a>
								</div>
							</header>
							</div>
						<div>
					</div>
				</div>
				<div class="panel-body float-left padding-0" style="width: 100%;border-top: none;">
				<div class="table-responsive" style="overflow: hidden;">
							<div data-role="content" class="form-horizontal panel"
								data-collapse="isCollapsed">
								<ul class="dragList row list-unstyled">
									<li class="col-md-3 col-sm-3 col-lg-3">
										<div class="row">
											<label class="control-label col-md-8" style="width: 61%">SELECT
												ALL :</label>
											<div class="col-md-4" style="padding-left: 36px;">
												<label class="i-checks m-b-none checkbox"> <input
													type="checkbox" data-ng-click="selectAll(selectall)"
													data-ng-model="selectall" /><i style="margin-left: -12px;"></i>
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

						
					
	<div class="panel panel-default panel-default-list"
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
					<thead >
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

						
						
						
						
						
						
						
			
						

					</form>

				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>