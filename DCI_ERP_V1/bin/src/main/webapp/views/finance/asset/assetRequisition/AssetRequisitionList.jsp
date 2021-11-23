<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0068_D')" var="isDelete" />
<security:authorize access="hasRole('F0068_A')" var="isAdd" />
<security:authorize access="hasRole('F0068_UP')" var="isUpload" /> --%>
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i
										class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<input type="hidden" value="${form_code}" id="form_code_id">
					<div role="content">
						<div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								data-st-table="displayedCollection"
								data-st-safe-src="rowCollection">								
		     
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="width_1 text-center table-heading"><label
												class="i-checks m-b-none"> <input type="checkbox">
													<i></i>
											</label></th>
											<th class="sorting width_8">Asset Requisition No</th>
											<th class="sorting width_7">Asset Requested By</th>
											<th class="sorting width_12">Asset Requisition Date</th>
											<th class="sorting width_7">Source Location</th>
											<th class="sorting width_7">Requisition Location</th>
											<th class="width_5 text-center table-heading"><spring:message
													code="label.action"></spring:message></th>
										</tr>
									</thead>
									<tbody>
									 <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objAssetRequistion in displayedCollection">           
					          <td cs-select="objAssetRequistion" class="text-center"></td>        
					           <td>{{objAssetRequistion.assetrequisitionNo}}</td>
					           <td>{{objAssetRequistion.employeeName}}</td>
					           <td>{{objAssetRequistion.assetrequisitionDate}}</td>
					           <td>{{objAssetRequistion.sourceLocationName}}</td> 
					           <td>{{objAssetRequistion.designationLocationName}}</td>
					          <td class=" td-actions text-center">
					           <security:authorize access="hasRole('${form_code}_${modify}')">
						        <span data-ng-if="objAssetRequistion.isEdit">
						         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objAssetRequistion.assetRequisitionId,objAssetRequistion.type)"></i>
						        </span>
						        </security:authorize>
								<security:authorize access="hasRole('${form_code}_${delete}')">
						        <span data-ng-if="objAssetRequistion.isDelete">
						         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objAssetRequistion.assetRequisitionId,$index)"></i>
						        </span>
						         </security:authorize>
					       	 </td>
					          </tr>
					          </tbody>
								</table>
								<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
							</div>
						</div>

					</div>

				</div>

			</article>

		</div>
	</section>
</div>