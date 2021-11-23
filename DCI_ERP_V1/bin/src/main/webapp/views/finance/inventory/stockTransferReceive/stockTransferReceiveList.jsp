<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								data-st-table="displayedCollection"
								data-st-safe-src="rowCollection">
								<div class="dt-toolbar">
									<%@include file="/views/layout/toolbar-header.tpl.jsp"%>
								</div> --%>
								
								 <style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection"  st-persist="usermasterTable" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-10">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<!-- <th class="width_1 text-center table-heading">
								            <label class="i-checks m-b-none">
								             <input type="checkbox">
								             <i></i>
								            </label></th> -->
											<th class="sorting width_13" data-st-sort="receivedNo">
												Transfer Receive No</th>
											<th class="sorting width_13" data-st-sort="transferNo">
											Transfer No</th>
											<th class="sorting width_13" data-st-sort="receivedByName">Received By</th>
											<th class="sorting width_13" data-st-sort="receivedDate">Received Date</th>
											<th class="sorting width_13" data-st-sort="sourceLocName">Source
												Location</th>
											<th class="sorting width_13" data-st-sort="destLocName">Destination
												Location</th>

											<th class="width_05 text-center table-heading">Action</th>
										</tr>

									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="row in displayedCollection">
											<!-- <td cs-select="row" class="text-center"></td> -->
											<td>{{row.receivedNo}}</td>
											<td>{{row.transferNo}}</td>
											<td>{{row.receivedByName}}</td>
											<td>{{row.receivedDate}}</td>
											<td>{{row.sourceLocName}}</td>
											<td>{{row.destLocName}}</td>
											<td class=" td-actions text-center"><security:authorize
													access="hasRole('${form_code}_${view}')">
													<span> <i class="fa fa-list-alt text-dark text"
														data-ng-click="viewRow(row.receivedId)"></i>
													</span>
												</security:authorize>

											</td>
										</tr>
									</tbody>
								</table>
								 <footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
							</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>