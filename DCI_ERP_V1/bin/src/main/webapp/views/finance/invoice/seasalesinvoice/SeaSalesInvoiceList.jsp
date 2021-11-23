<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="salesInvoiceList" st-safe-src="salesInvoiceListDraft">
		<%@include file="/views/templates/panel-header.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id" />
		
		<div class="panel panel-default">
			<div class="form-body form-horizontal">
				<div class="row m-t-sm"></div>
			</div>
			<!-- <button class="btn btn-success" type="button" data-ng-click="viewDraft();">
								View Draft Records
								</button> -->
								<div class="row" style="padding-bottom:2%;">
				<br>
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">Mode</label>
								<div class="col-md-7">
									<selectivity list="modeList" ng-model="purchaseInvoiceData.mode"
											validation="required" friendly-name="Mode"
											property="purchaseInvoiceData.mode" id="mode" name="mode"
											form-name="purchaseInvoiceDataListForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>

							<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="purchaseInvoiceData.vessel"
										validation="required" friendly-name="vessel"
											property="purchaseInvoiceData.vessel" id="vessel" name="vessel"
											form-name="purchaseInvoiceDataListForm" ></selectivity>

									</div>
								</div>
						</fieldset>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
									<label class="col-md-5 control-label">Voyage</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="purchaseInvoiceData.voyage"
											property="purchaseInvoiceData.voyage" id="voyage" name="voyage"
											form-name="purchaseInvoiceDataListForm" friendly-name="voyage"></selectivity>

									</div>
								</div>
						</fieldset>
					</div>
					<br><br><br>
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<selectivity list="customerDropList" ng-model="purchaseInvoiceData.customer"
											property="purchaseInvoiceData.customer" id="customer" name="customer"
											form-name="purchaseInvoiceDataListForm" friendly-name="customer"></selectivity>

									</div>
								</div>
						</fieldset>
					</div>
					
					<br><br>
					
					<div class="row ">
								<div class="col-md-offset-3 col-md-5">
									<!-- <button class="btn btn-success help-button" type="button" data-ng-click="tdsHelpVideo('purchaseInvoiceDataVideo.mp4','purchaseInvoiceDataVideo')">
<i class="fa fa-video-camera"></i>
Help Video
</button> -->
<!-- 									<button class="btn btn-success help-button" type="button"
										data-ng-click="tdsHelpVideo('purchaseInvoiceDataVideo.mp4','purchaseInvoiceDataVideo')">
										<i class="fa fa-video-camera"></i> Help Video
									</button>
 -->
									<button class="btn btn-success" type="button"
										ng-click="search(purchaseInvoiceData)">
										<i class="fa fa-search"></i> Search
									</button>
									</div>
						
					</div>
				</div>
			<div class="row" >
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading" style="height: 37px;">
					<h3 class="panel-title txtUpperCs"
						style="margin-top: 8px; font-size: 12px;">Draft Invoice</h3>
					<div class="actions pull-right List">

						<i data-fullscreen-widget
							class="fa fa-expand"></i> <i data-widget-toggle
							class="fa fa-chevron-down"></i>
					</div>
				</div>
				<div class="panel-body float-left padding-10" style="width: 100%">
				
				<div class="table-responsive" style=" border: 1px solid #CCC;">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
							<tr>
								
								<th class="sorting" st-sort="puchaseInvoiceNo">Sales
									Invoice No</th>
								<th class="sorting" st-sort="puchaseInvoiceDate">Sales
									Invoice Date</th>
								<th class="sorting" st-sort="jobName">Job No</th>
								<th class="sorting" st-sort="party">Party</th>
								<th class="sorting" st-sort="polName">POL</th>
								<th class="sorting" st-sort="podName">POD</th>
								<th class="sorting" st-sort="totalAmount">Total Amount</th>
								<th class="sorting" st-sort="createdBy">Created By</th>
								<th class="sorting" st-sort="createdOn">Created Date</th>
								<th class="sorting" st-sort="invoiceStatus">Status</th>
								<th class="text-center">Action</th>
								<!-- <th class="sorting" st-sort="action">Action</th> -->

							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="sales in salesInvoiceList">

								<%-- <td><a ng-click="view(purchaseInvoiceList.salesSNo)"><security:authorize access="hasRole('${form_code}_${view}')"> <span
										tooltip="{{purchaseInvoiceList.puchaseInvoiceNo}}"
										class="tool-tip-span font-blue">{{purchaseInvoiceList.puchaseInvoiceNo}}</span></security:authorize>
										
								</a></td> --%>
								 <td class="sorting ">{{sales.puchaseInvoiceNo}}</td> 
								<td class="sorting ">{{sales.puchaseInvoiceDate}}</td>
								<td class="sorting ">{{sales.jobName}}</td>
								<td class="sorting ">{{sales.party}}</td>
								<td class="sorting ">{{sales.polName}}</td>
								<td class="sorting ">{{sales.podName}}</td>
								<td class="sorting ">{{sales.totalAmount}}</td>
								<td class="sorting ">{{sales.createdBy}}</td>
								<td class="sorting ">{{sales.createdOn}}</td>
								<td class="sorting ">{{sales.invoiceStatus}}</td>
								<td class=" td-actions text-center">
									<span> <i
										class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="saveDraft(sales.salesSNo)"></i>
									</span>
									<security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i
										class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteInvoice(sales.salesSNo)"></i>
									</span>
								</security:authorize>
	       </td>
								<!-- <td class="td-actions text-center"><span><i
										class="icon-envelope red" title="Test Email"
										data-ng-click="clickTestInvoiceMail(salesInvoiceList.salesSNO)"
										style="cursor: pointer; color: gray;"></i></span></td> -->
							</tr>
						</tbody>
					</table>
				</div>
				<footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer.jsp"%>
				</footer>
				
			</div>

			</div>
		</div>
	</div>
			</div>
	</div>
</div>
<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-invoice.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id" />
		
		<div class="panel panel-default">
			<div class="form-body form-horizontal">
				<div class="row m-t-sm"></div>
			</div>
	<div class="row" >
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading" style="height: 37px;">
					<h3 class="panel-title txtUpperCs"
						style="margin-top: 8px; font-size: 12px;">Invoice</h3>
					<div class="actions pull-right List">

						<i data-fullscreen-widget
							class="fa fa-expand"></i> <i data-widget-toggle
							class="fa fa-chevron-down"></i>
					</div>
				</div>
				<div class="panel-body float-left padding-10" style="width: 100%">
				
				<div class="table-responsive" style=" border: 1px solid #CCC;">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
							<tr>
								
								<th class="sorting" st-sort="puchaseInvoiceNo">Sales
									Invoice No</th>
								<th class="sorting" st-sort="puchaseInvoiceDate">Sales
									Invoice Date</th>
								<th class="sorting" st-sort="jobName">Job No</th>
								<th class="sorting" st-sort="party">Party</th>
								<th class="sorting" st-sort="polName">POL</th>
								<th class="sorting" st-sort="podName">POD</th>
								<th class="sorting" st-sort="totalAmount">Total Amount</th>
								<th class="sorting" st-sort="createdBy">Created By</th>
								<th class="sorting" st-sort="createdOn">Created Date</th>
								
								<!-- <th class="sorting" st-sort="action">Action</th> -->

							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="purchaseInvoiceList in displayedCollection">

								<td><a ng-click="view(purchaseInvoiceList.salesSNo)"><security:authorize access="hasRole('${form_code}_${view}')"> <span
										tooltip="{{purchaseInvoiceList.puchaseInvoiceNo}}"
										class="tool-tip-span font-blue">{{purchaseInvoiceList.puchaseInvoiceNo}}</span></security:authorize>
										
								</a></td>
								<!-- <td class="sorting ">{{purchaseInvoiceList.puchaseInvoiceNo}}</td> -->
								<td class="sorting ">{{purchaseInvoiceList.puchaseInvoiceDate}}</td>
								<td class="sorting ">{{purchaseInvoiceList.jobName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.party}}</td>
								<td class="sorting ">{{purchaseInvoiceList.polName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.podName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.totalAmount}}</td>
								<td class="sorting ">{{purchaseInvoiceList.createdBy}}</td>
								<td class="sorting ">{{purchaseInvoiceList.createdOn}}</td>
								
								<!-- <td class="td-actions text-center"><span><i
										class="icon-envelope red" title="Test Email"
										data-ng-click="clickTestInvoiceMail(salesInvoiceList.salesSNO)"
										style="cursor: pointer; color: gray;"></i></span></td> -->
							</tr>
						</tbody>
					</table>
				</div>
				<footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer.jsp"%>
				</footer>
			
           </div>
			</div>
		</div>
	</div>
</div>
</div>

