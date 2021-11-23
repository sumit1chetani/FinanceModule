<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="row">
		<div class="col-sm-12 col-xs-12 col-md-12">
		<div class="panel panel-default panel-default-form ">
		   <%@include file="/views/templates/panel-header-form.jsp"%>
		</div><!-- /panel-heading -->
		<%-- <div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
			<!-- <ol class="breadcrumb padding-left-0">
				<li><a> Finance </a></li>
				<li><a>Invoice</a></li>
				<li><a>Invoice View</a></li>
			</ol> -->
		</div> --%>
	</div>
	</div>
		<div class="panel-heading font-bold">Invoice View</div>
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Vessel</label>
							<div class="col-md-6">
								<selectivity list="vesselList"
									property="invoiceViewHeader.vesselid" id="vessel_id"
									object="vesselObj"></selectivity>
							</div>
						</div>
						
						<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Pol</label>
							<div class="col-md-6">
								<selectivity list="portList"
									property="invoiceViewHeader.pol" id="pol"></selectivity>
							</div>
						</div>						

						<div class="form-group">
							<label class="col-md-5 control-label">Customer</label>
							<div class="col-md-6">
								<selectivity list="customerList"
									property="invoiceViewHeader.mloCode" id="customer_id"></selectivity>
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
									property="invoiceViewHeader.voyageCode" id="voyage_id"></selectivity>
							</div>
						</div>
						
						<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Pod</label>
							<div class="col-md-6">
								<selectivity list="portList"
									property="invoiceViewHeader.pod" id="pod"></selectivity>
							</div>
						</div>
												
						<div class="form-group">
							<label class="col-md-5 control-label">Invoice</label>
							<div class="col-md-6 inputGroupContainer">
								<input type="text" data-ng-model="invoiceViewHeader.invoiceNo"
									class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
							</div>
						</div>

					</fieldset>
				</div>
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<div class="form-group">
						<label class="col-md-5 control-label">Quotation No</label>
						<div class="col-md-6">
							<input type="text" data-ng-model="invoiceViewHeader.quationNo"
								class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
						</div>
					</div>
					
								<div class="form-group">
						<label class="col-md-5 control-label">Payer</label>
					<div class="col-md-6">
								<selectivity list="payerList"
									property="invoiceViewHeader.payerCode" id="payerCode"></selectivity>
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
						
					     <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="formreset()">
							            <i class="fa fa-undo"> </i>Reset
						 </button>
						 
	
								<button class="btn btn-primary" type="button" data-ng-click="bulkPrint(rowCollection);">
									Bulk Print
								</button>
								<!-- 
						 		<button class="btn btn-info" style=" background-color: #ec694a; border-color: #ec694a;" ng-click="sendEDI();"  type="button">
        <i class="fa"></i>
        Send EDI
       </button>		 -->
					</security:authorize>
				</div>
			</div>
	</div>
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<div>
			<%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%>
		</div>
		<div class="panel-body float-left padding-0">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="width_1"></th>
							<th class="sorting width_6" st-sort="invoiceNo">Invoice No.</th>
							<th class="sorting width_6" st-sort="blno">BL No.</th>
							<th class="sorting width_6" st-sort="quotationNo">Quotation</th>
							<th class="sorting width_8" st-sort="invoiceDate">Invoice Dt.</th>
							<th class="sorting width_10" st-sort="vessel">Vessel</th>
							<th class="sorting width_10" st-sort="voyage">Voyage</th>
							<th class="sorting width_5" st-sort="pol">Pol</th>
							<th class="sorting width_5" st-sort="pod">pod</th>
							<th class="sorting width_8" st-sort="customer">Customer</th>
							<th class="sorting width_8" st-sort="payerName">Payer</th>
							<th class="sorting width_4" st-sort="flsCont">Inv</th>
							<th class="sorting width_4" st-sort="slotCont">Slt</th>
							<th class="sorting width_8">Wo No</th>
							
							
							<th class="width_15">Action</th>
						</tr>

					</thead>
					<tbody>
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="($index,objTranslationItem) in displayedCollection">
							
							<!-- <td class="width_1"></td> -->
							
							          <td class="width_1 text-center"><label class="i-checks m-b-none">
                                      <input type="checkbox" name="selectedTypes[]"  ng-model="objTranslationItem.check">
                                      <i></i>
                                      </label>
                                      </td>

							<td class="sorting width_6"  >
						       <a href="#/invoice/singleInvoiceView/{{objTranslationItem.invoiceNo}}" >
						         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span font-blue">{{objTranslationItem.invoiceNo}}</span>
						        </a>
						        
						       </td>
							
							<td class="width_6" ng-bind="objTranslationItem.blno"></td>
							<td class="width_6" ng-bind="objTranslationItem.quotationNo"></td>
							<td class="width_8" ng-bind="objTranslationItem.invoiceDate"></td>
							<td class="width_10" ng-bind="objTranslationItem.vessel"></td>
							<td class="width_8" ng-bind="objTranslationItem.voyage"></td>
							<td class="width_4" ng-bind="objTranslationItem.pol"></td>
							<td class="width_4" ng-bind="objTranslationItem.pod"></td>
							<td class="width_6" ng-bind="objTranslationItem.customer"></td>
							<td class="width_8" ng-bind="objTranslationItem.payerName"></td>
							<td class="width_4" ng-bind="objTranslationItem.flsCont"></td>
							<td class="width_4" ng-bind="objTranslationItem.slotCont"></td>
							
							<td class="width_8" ng-bind="objTranslationItem.woNo"></td>
							
							<td class="width_20"><select ng-model="objTranslationItem.printList" id ="printSelect{{$index}}">
									<option value="both" >Both</option>
									<option value="usd">USD</option>
									<option value="local">Local</option>
							</select>
							    &nbsp;&nbsp;
							    <security:authorize access="hasRole('${form_code}_${send_mail}')">
							    <span><i class="icon-envelope red" title="Email" data-ng-click="clickInvoiceMail(objTranslationItem.invoiceNo,objTranslationItem.printList)" style="cursor: pointer; color: gray;"></i></span>
							    </security:authorize>
							    <security:authorize access="hasRole('${form_code}_${print}')"> 
							    &nbsp;&nbsp;<span data-ng-click="clickInvoiceFunction(objTranslationItem.invoiceNo,objTranslationItem.printList)"
								id="{{objTranslationItem.invoiceNo}}" title="Print"
								class=" glyphicon glyphicon-print "
								style="cursor: pointer; color: gray;"></span>
								&nbsp;&nbsp;
								</security:authorize>
								<%-- <security:authorize access="hasRole('${form_code}_${delete}')">
								<span> <i
									class="fa fa-trash-o text-danger-dker text"
									style="cursor: pointer;" data-ng-click="deleteInvoice(objTranslationItem.invoiceNo)"></i>
							</span>
							</security:authorize> --%>
							<security:authorize access="hasRole('${form_code}_${delete}')">
								<span> <i
									class="fa fa-undo text-danger-dker text" title="Reverse Invoice"
									style="cursor: pointer;" data-ng-click="reverseInvoiceView(objTranslationItem.invoiceNo)"></i>
							</span>
							&nbsp;&nbsp;
							</security:authorize>
							  <security:authorize access="hasRole('${form_code}_${send_mail}')">
							  <a id="ediExport{{objTranslationItem.invoiceNo}}" stype="display:none" href="" download=""></a>
							<span ng-if="objTranslationItem.customer=='HMM'"> <i
									class="fa fa-file text" title="EDI"
									style="cursor: pointer;" data-ng-click="sendEDI(objTranslationItem.invoiceNo)"></i>
							</span>
							</security:authorize>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>

</div>

 <script type="text/ng-template" id="invoiceDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
  <script type="text/ng-template" id="invoiceMail">

<div class="modal-header"> Are you sure to send Email? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="SendConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
 
   <script type="text/ng-template" id="invoiceReverse">

<div class="modal-header"> Are you sure to reverse Invoice? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="ReverseConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
 
 
 