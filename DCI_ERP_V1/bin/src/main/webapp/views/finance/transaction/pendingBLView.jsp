<style>
.subcolor {
	background: #42a5f5 !important;
	color: #fff !important;
}

.ngdialog .ngdialog-content {
	width: 1124px !important;
}
.table>tbody>tr>td, .table>tfoot>tr>td {
    padding: 4px 10px;
    font-size: 12px;
}
.table>thead>tr>th {
    padding: 0px 10px 0px 10px;
    font-size: 12px;
}
</style>
<div id="FinalLoadingSummarySubmit">
	<div class="breadcrumb-wrapper ng-scope">
		<div class="panel panel-default panel-default-form">
			<div class="panel-heading panel-heading-form font-bold">
				<ol class="breadcrumb inline-block padding-left-10">
					<li><a>Operation</a></li>
					<li><a x-ui-sref="app.finance">Finance</a></li>
					<li><a x-ui-sref="app.finance.transaction">Transaction</a></li>
					<li><a x-ui-sref="app.finance.transaction.pendingBLView">Pending
							BL</a></li>
					<li><a x-ui-sref="">Pending To Be Invoiced View</a></li>
				</ol>
			</div>
			<div class="panel-body">

				<section widget-grid id="widget-grid">
					<div class="row">
						<article class="col-sm-12">

							<div class="panel-body" id="pendingBlSubmit">
								<form class="form-horizontal" name="pendingBlSummaryViewForm"
									novalidate>
									<div class="row">
										
									</div>
									<div data-ng-if="flsPendingBlMessageList.length > 0">
										<div>
											<header id="btntoggle" data-role="heading"
												class="btn btn-default col-sm-12 col-md-12 col-lg-12"
												data-ng-click="isCollapsed = !isCollapsed">
												<div class="row">
													<a>Report Header</a>
												</div>
											</header>
											<div data-role="content" class="form-horizontal"
												data-collapse="isCollapsed">
												<ul class="dragList row list-unstyled">
													<li data-ng-repeat="column in flsPendingBlMessageList"
														class="col-sm-3 col-md-3 col-lg-3">
														<div class="row" data-ng-drag="column.isDraggable"
															data-ng-drop="column.isDraggable"
															data-ng-drop-success="onDropComplete($index, $data,$event)"
															data-ng-drag-data="column" style="width: 100%">
															<label class="control-label col-md-8">{{column.title}}
																:</label>
															<div class="col-md-4">
																<label class="i-checks m-b-none checkbox"> <input
																	type="checkbox"
																	data-ng-click="getSelectedColumn(column)"
																	data-ng-model="column.visible"
																	data-ng-disabled="column.isDefault" /> <i></i>
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

									<div class="row">
										<div
											class="panel-body jarvis-content col-sm-12 col-md-12 col-lg-12">
											<div class="widget-body no-padding ">

												<div class="table-responsive ">
													<div id="LoadingSummaryDetails">
													<scrollable-table watch="globalLoadingSummaryDetails">
														<table border=1 cellspacing=0 cellpadding=0
															bordercolor="#808080"
															class="table table-striped table-bordered table-hover dataTable no-footer">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_7 text-center"
																		data-ng-repeat="column in flsPendingBlMessageList "
																		data-ng-class={hide:(!column.visible)}
																		rowspan={{column.rowspan}} colspan={{column.colspan}}>{{column.title}}</th>
																</tr>

															</thead>
															<tbody id="viewLoadingSummary">
															</tbody>
														</table>
														</scrollable-table>
													</div>
												</div>
											</div>
										</div>
									</div>

								<!-- 	<div class="widget-body no-padding margin-top-2">

										<table style="width: 100%" align=center>
											<tr>
												<td>
													<table bgcolor=white>
														<tr>
															<td>
																<table cellspacing="0" cellpadding="0"
																	bordercolor="#808080" border="1" bgcolor="#ffffff">
																	<thead>
																		<tr class="subcolor">
																		
																		<td class="text-center" rowspan=2><span
																				class=bold>VOYAGE_ID</span></td>
																			<td class="text-center" rowspan=2><span
																				class=bold>POL</span></td>
																			<td class="text-center" rowspan=2><span
																				class=bold>POD</span></td>
																			<td class="text-center" colspan=3
																				data-ng-repeat="objSlotvalue in slotHeadings"><span
																				class="bold">{{objSlotvalue.slot_NAME}}</span></td>
																			<td colspan=3 class="text-center"><span
																				class="bold">Total</span></td>
																		</tr>
																		<tr class="subcolor">
																			<td
																				class="text-center padding-both-side-2 padding-top-bottom-2"
																				data-ng-repeat-start="objSlotvalue in slotHeadings"><span
																				class="bold">{{objSlotvalue.column20 }}</span></td>
																			<td
																				class="text-center padding-both-side-2 padding-top-bottom-2"><span
																				class="bold">{{objSlotvalue.column40}}</span></td>
																			<td
																				class="text-center padding-both-side-2 padding-top-bottom-2"
																				data-ng-repeat-end><span class="bold">{{objSlotvalue.teus}}</span></td>
																			<td class="text-center padding-both-side-2"><span
																				class="bold">20'S</span></td>
																			<td class="text-center padding-both-side-2"><span
																				class="bold">40'S</span></td>
																			<td class="text-center padding-both-side-2"><span
																				class="bold">Total Teus</span></td>

																		</tr>
																	</thead>
																	<tbody class="dataTables-Main-Body" id="pendingSlotDetails">
																	</tbody>
																	</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
										</table>



									</div>
 -->


									<div class="form-actions">
										<div class="row">

											<button class="btn btn-danger" data-ng-click="cancelfls()"
												type="button">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</form>
							</div>


						</article>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>


