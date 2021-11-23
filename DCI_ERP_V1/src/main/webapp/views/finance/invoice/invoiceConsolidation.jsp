<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="bg-light lter b-b wrapper-md">
	<div class="row">
		<div class="col-sm-12 col-xs-12 col-md-12">
			<ol class="breadcrumb padding-left-0">
				<li><a> Finance </a></li>
				<li><a>Invoice</a></li>
				<li><a>Invoice Consolidation</a></li>
			</ol>
		</div>
	</div>
</div>
<div class="wrapper-md">
	<div class="panel panel-default">
		<div class="panel-heading font-bold">Invoice Consolidation</div>
		<div class="form-body form-horizontal">
				<div class="row m-t-sm">
	   <div class="col-sm-3 col-xs-6 ">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label  vessel-text">Voyage</label>
            <div class="col-md-6">
	            <selectivity list="voyageList" property="invoiceConsHeader.voyageId" id="voyage_id" object="vesselObj"></selectivity>
            </div>
           </div>
           
           <div class="form-group">
            <label class="col-md-5 control-label">Pol</label>
            <div class="col-md-6">
             <selectivity list="portList" property="invoiceConsHeader.pol" id="pol_id" ></selectivity>
            </div>
           </div>
           
             
          </fieldset>
         </div>
         <div class="col-sm-3 col-xs-6">
          <fieldset>
          <div class="form-group">
            <label class="col-md-5 control-label">Customer</label>
             <div class="col-md-6">
			   <selectivity list="customerList" property="invoiceConsHeader.customerId" id="customer_id"></selectivity>
			</div>
           </div>
            <div class="form-group">
            <label class="col-md-5 control-label">Pod</label>
             <div class="col-md-6">
			   <selectivity list="portList" property="invoiceConsHeader.pod" id="pod_id"></selectivity>
			</div>
           </div>
           
           
          </fieldset>
         </div>
         <div class="col-sm-3 col-xs-6 ">
        
            <div class="form-group">
            <label class="col-md-5 control-label">From Date</label>
            <div class="col-md-6 inputGroupContainer">
           <bootstrapdatetimepicker  property="invoiceConsHeader.fromDate" id="fromDate_id"></bootstrapdatetimepicker>
            </div>
            </div>
           <div class="form-group">
            <label class="col-md-5 control-label">Month</label>
             <div class="col-md-6">
			   <selectivity list="monthList" property="invoiceConsHeader.month" id="month_id"></selectivity>
			</div>
           </div> 
           
         </div>
         <div class="col-sm-3 col-xs-6">
         <div class="form-group">
            <label class="col-md-5 control-label">To Date</label>
            <div class="col-md-6 inputGroupContainer">
           <bootstrapdatetimepicker  property="invoiceConsHeader.toDate" id="toDate_id"></bootstrapdatetimepicker>
            </div>
            </div>
            <div class="form-group">
            <label class="col-md-5 control-label">Invoice</label>
             <div class="col-md-6">
			   <selectivity list="invoiceNumbers" property="invoiceConsHeader.invoiceNo" id="invoice_id"></selectivity>
			</div>
           </div>
         </div>
</div>
			</div>
			<div align="center">
				<div class="row panel-body">
					<div class="col-md-12 ">
						<!-- <button class="btn btn-success" type="button"
							data-ng-click="searchInvoiceDtl();">
							<i class="fa fa-search"></i> Search
						</button> -->
						<security:authorize access="hasRole('${form_code}_${add}')">
						<button class="btn btn-success" type="button"
							data-ng-click="generateInvoice();">
							<i class="fa "></i> Generate
						</button>
						</security:authorize>
					</div>
				</div>
			</div>
		</div>
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold">
			<%--  <%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%> --%>
		</div>
		<div class="panel-body float-left padding-0">
			<div class="table-responsive ">
				<table id="dt_basic"
								class="table table-striped table-bordered table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr>
									<th class="width_1"><label class="i-checks m-b-none">
									<input type="checkbox" name="post[]"> <i></i>
							</label></th>
										<th class="sorting width_15" st-sort="invoiceNo">Invoice
											No.</th>
											<th class="sorting width_15" st-sort="voyageId">Voyage
											</th>
											<th class="sorting width_15" st-sort="vesselName">Vessel
											</th>
										<th class="sorting width_15" st-sort="companyName">Payer
										</th>
										<th class="width_5">Action</th>
									</tr>
									
								</thead>
								<tbody>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="objTranslationItem in displayedCollection">
									<td class=""><label class="i-checks m-b-none"> <input
									type="checkbox" name="post[]"> <i></i>
							</label></td>
										
										<td>{{objTranslationItem.invoiceNo}}</td>
										<td>{{objTranslationItem.voyageId}}</td>
										<td>{{objTranslationItem.vesselName}}</td>
										<td>{{objTranslationItem.customerName}}</td>
										<td><span
											data-ng-click="clickInvoiceFunction(objTranslationItem.invoiceNo)"
											id="{{objTranslationItem.invoiceNo}}"
											class=" glyphicon glyphicon-print "
											style="cursor: pointer; color: gray; margin-left: 20px;"></span>
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
</div>