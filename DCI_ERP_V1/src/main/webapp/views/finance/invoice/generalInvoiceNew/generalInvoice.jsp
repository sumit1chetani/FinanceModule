<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id">
   <div class="panel panel-default">
		<!-- 		<div class="panel-heading font-bold">Invoice View</div>
 -->
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Vessel</label>
							<div class="col-md-6">
								<selectivity list="vesselList"
									property="generalinvoice.vesselid" id="vesselid"
									object="vesselObj"></selectivity>
							</div>
						</div>

						<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Pol</label>
							<div class="col-md-6">
								<selectivity list="portList" property="generalinvoice.pol"
									id="pol"></selectivity>
							</div>
						</div>

					</fieldset>
				</div>
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Voyage</label>
							<div class="col-md-6">
								<selectivity list="voyageList"
									property="generalinvoice.voyageCode" id="voyageCode"></selectivity>
							</div>
						</div>

						<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Pod</label>
							<div class="col-md-6">
								<selectivity list="portList" property="generalinvoice.pod"
									id="pod"></selectivity>
							</div>
						</div>



					</fieldset>
				</div>
				<div class="col-sm-12 col-md-4 col-lg-4 ">


					<!-- <div class="form-group">
						<label class="col-md-5 control-label">Payer</label>
						<div class="col-md-6">
							<selectivity list="payerList" property="generalinvoice.payerCode"
								id="payerCode"></selectivity>
						</div>
					</div> -->
					<div class="form-group">
						<label class="col-md-5 control-label">Customer</label>
						<div class="col-md-6">
							<selectivity list="customerList"
								property="generalinvoice.mloCode" id="mloCode"></selectivity>
						</div>
					</div>

						<div class="form-group">
							<label class="col-md-5 control-label">Invoice</label>
							<div class="col-md-6 inputGroupContainer">
								<input type="text" data-ng-model="generalinvoice.invoiceNo"
									class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
							</div>
						</div>
				</div>
			</div>
		</div>
		<div align="center">
			<div class="row panel-body">

				<div class="col-md-12 ">
					<security:authorize access="hasRole('${form_code}_${search}')">
						<button class="btn btn-success" type="button"
							data-ng-click="searchInvoiceDtl();">
							<i class="fa fa-search"></i> Search
						</button>

						<button class="btn btn-info" type="reset" class="btn btn-success"
							ng-click="formreset()">
							<i class="fa fa-undo"> </i>Reset
						</button>


						<button class="btn btn-primary" type="button"
							data-ng-click="bulkPrint(rowCollection);">Bulk Print</button>
			
									<button class="btn btn-primary" type="button"
										data-ng-click="bulkMail(rowCollection);">Bulk Mail</button>
					
							
						<!-- <button id="exportXl" class="btn btn-primary"
							data-ng-click="excelNew(generalinvoice);" type="button">
							<i class="fa fa-print"></i> Export Excel
						</button> -->


						<!-- 
						 		<button class="btn btn-info" style=" background-color: #ec694a; border-color: #ec694a;" ng-click="sendEDI();"  type="button">
        <i class="fa"></i>
        Send EDI
       </button>		 -->
					</security:authorize>
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-default panel-default-list" st-persist="generalInvoiceListTable" 
		st-table="displayedCollection" st-safe-src="rowCollection" >
		<%-- <div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold">
			<%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%>
		</div> --%>


		<div class="panel-body float-left padding-0" st-persist="generalInvoiceListTable" 
			st-table="displayedCollection" st-safe-src="rowCollection">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					width="100%" role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr role="row">
								<th class="width_1"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectAll" ng-model="invView.selAll" ng-click="viewSelectAll()">
									<i></i>
							</label></th>
							<th class="sorting width_10" st-sort="InvoiceNo">Inv No</th>
							<th class="sorting width_20" st-sort="InvoiceDate">Inv Date</th>
							<th class="sorting width_25" st-sort="CustomerName">Customer</th>
							<!-- <th class="sorting width_25" st-sort="MloName">Payer</th> -->
							<th class="sorting width_25" st-sort="Subject">Narration</th>
							<th class="sorting width_8"  st-sort="BlRelated">BL Rel</th>
							<th class="sorting width_8"  st-sort="surveyorrelated">Survey Rel</th>
							<th class="sorting width_10" st-sort="VesselCode">Vessel</th>
							<th class="sorting width_12" st-sort="Voyage">Voyage</th>
							<th class="sorting width_8" st-sort="bl">BL No</th>
							<th class="sorting width_8" st-sort="QuotationNumber">Quotation No</th>
							<th class="width_15">Action</th>
							<security:authorize access="hasRole('${form_code}_${loc_flag}')">
								<th class="width_15">Verify</th>
							</security:authorize>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objTranslationItem in displayedCollection">
							<td class="width_1 text-center"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectedTypes[]" ng-model="objTranslationItem.check">
									<i></i>
							</label></td>
							<!-- <td class="" cs-select="objTranslationItem"></td> -->
							<td><span > <a
									ng-click="view(objTranslationItem.InvoiceNo)"> <span
										tooltip="{{objTranslationItem.InvoiceNo}}"
										class="tool-tip-span font-blue">{{objTranslationItem.InvoiceNo}}</span>
								</a></span> <span ng-if="objTranslationItem.urIsView=='f'"> <span
									tooltip="{{objTranslationItem.InvoiceNo}}"
									class="tool-tip-span">{{objTranslationItem.InvoiceNo}}</span>
							</span></td>
							<!-- <td>
	         <span tooltip="{{objTranslationItem.InvoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.InvoiceNo"></span>
	       </td> -->
							<td><span tooltip="{{objTranslationItem.InvoiceDate}}"
								class="tool-tip-span" ng-bind="objTranslationItem.InvoiceDate"></span>
							</td>
							<td><span tooltip="{{objTranslationItem.CustomerName}}"
								class="tool-tip-span" ng-bind="objTranslationItem.CustomerName"></span>
							</td>
							<!-- <td><span tooltip="{{objTranslationItem.MloName}}"
								class="tool-tip-span" ng-bind="objTranslationItem.MloName"></span>
							</td> -->
							<td><span tooltip="{{objTranslationItem.Subject}}"
								class="tool-tip-span" ng-bind="objTranslationItem.Subject"></span>
							</td>
							<td><span tooltip="{{objTranslationItem.BlRelated}}"
								class="tool-tip-span" ng-bind="objTranslationItem.BlRelated"></span>
							</td>
							<td><span tooltip="{{objTranslationItem.surveyorrelated}}"
								class="tool-tip-span" ng-bind="objTranslationItem.surveyorrelated"></span>
							</td>
							<td><span tooltip="{{objTranslationItem.VesselCode}}"
								class="tool-tip-span" ng-bind="objTranslationItem.VesselCode"></span>
							</td>
							<td><span tooltip="{{objTranslationItem.Voyage}}"
								class="tool-tip-span" ng-bind="objTranslationItem.Voyage"></span>
							</td>
							<td><span tooltip="{{objTranslationItem.bl}}"
								class="tool-tip-span" ng-bind="objTranslationItem.bl"></span></td>
							<td><span tooltip="{{objTranslationItem.QuotationNumber}}"
								class="tool-tip-span"
								ng-bind="objTranslationItem.QuotationNumber"></span></td>

							<td class="td-actions text-center"><!-- <access="hasRole('${form_code}_${modify}')">
									<span class="padding-both-side-2"
										> <i
										class="fa fa-pencil text-success text"
										data-ng-click="editRowBtn(objTranslationItem.InvoiceNo)"
										tooltip="Edit"></i>
									</span>
								</access>  --><access="hasRole('${form_code}_${delete}')">
									<span class="padding-both-side-2"
										ng-if="objTranslationItem.urIsDelete=='true'"> <i
										class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(objTranslationItem.InvoiceNo)"
										tooltip="Delete"></i>
									</span>
								</access> <access="hasRole('${form_code}_${print}')">  
								    &nbsp;&nbsp;<span
										ng-click="printGeneralInvoiceDiv(objTranslationItem.InvoiceNo)"
										id="{{objTranslationItem.InvoiceNo}}"
										class=" glyphicon glyphicon-print "
										style="cursor: pointer; color: gray;"></span>
								</access> &nbsp;&nbsp; <%--  <security:authorize access="hasRole('${form_code}_${send_mail}')"> --%>
								<span class="padding-both-side-2"><i
									class="icon-envelope red"
									data-ng-click="sendMail(objTranslationItem.InvoiceNo)"
									style="cursor: pointer; color: gray;"></i></span></td>
							<td class="td-actions text-center"
								ng-if="objTranslationItem.verified"><security:authorize
									access="hasRole('${form_code}_${loc_flag}')">
									<i class="glyphicon glyphicon-ok-sign text-success text"></i>Verified
	       </security:authorize></td>
							<td class="td-actions text-center"
								ng-if="!objTranslationItem.verified"><security:authorize
									access="hasRole('${form_code}_${loc_flag}')">
									<button ng-model="add" class="btn btn-success"
										class="btn btn-success"
										ng-click="verified(objTranslationItem)">Verify</button>
								</security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>

	  
	  <footer class="panel-footer" style="padding:0px;">
	    <%@include file="/views/templates/panel-footer-static.jsp"%>
	   </footer>
	  </div>
  </div>
 </div>
</div>
<script type="text/ng-template" id="generalInvoiceDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeGeneralInvoiceDeleteDialog()">Cancel</button>
</div>
 </script>