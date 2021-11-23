<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
<form class="form-horizontal" name="accountClosingForm"
				ng-submit="save(accountClosingForm)"
				novalidate>
				
				<div class="row">

					<div class="">
						<div class="col-md-4">
				          	<div class="form-group padding-left-10">
								<label class="col-md-5 control-label">Organization Name</label>
								<div class="col-md-6">
									<selectivity list="companyList" property="chqStatusRprt.companyCode" id="txtcompany"></selectivity>
								</div>
							</div>

		          		</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-3 control-label">Customer</label>
								<div class="col-md-6">
									<selectivity list="customerList" property="chqStatusRprt.customerCode" id="txtCustomer"></selectivity>
								</div>
							</div>
						</div>
		          		<div class="col-md-4">
			          		<div class="form-group">
								<div class="col-md-12">
			            			<button class="btn btn-primary" ng-click="getChequeReport();">
										<i class="fa fa-search"> </i> View Report
									</button>
		            				<button class="btn btn-primary" ng-click="exportChqExcel()">
										<i class="fa fa-search"> </i>Export Excel
									</button>
								</div>
            				</div>
		          		</div>
		          </div>
				</div>
   		 </form>

   		 <div class="widget-body no-padding">
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
        <!-- <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
         <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="sorting width_10" st-sort="chqNo">Cheque No</th>
       <th class="sorting width_9" st-sort="chqDate">Cheque Date</th>
       <th class="sorting width_9" st-sort="chqAmnt">Cheque Amount</th>
       <th class="sorting width_12" st-sort="chqRcvdDate">Cheque Received Date</th>
       <th class="sorting width_9" st-sort="isPresented">Is Deposited</th>
       <th class="sorting width_12" st-sort="depositBank">Deposit Bank</th>
       <th class="sorting width_10" st-sort="presentDate">Deposit Date</th>
       <th class="sorting width_9" st-sort="isRealised">Is Realized</th>
       <th class="sorting width_10" st-sort="realisedDate">Realized Date</th>
       <th class="sorting width_9" st-sort="status">Cheque Status</th>

      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPresentationList in displayedCollection">
       <td class="width_10" ng-bind="objPresentationList.chqNo"></td>
       <td class="width_9" ng-bind="objPresentationList.chqDate"></td>
       <td align ="right" class="width_9 text-right" ng-bind="objPresentationList.chqAmnt|number:2"></td>
       <td class="width_10" ng-bind="objPresentationList.chqRcvdDate"></td>
       <td class="width_9" ng-bind="objPresentationList.isPresented"></td>
       <td class="width_15" ng-bind="objPresentationList.depositBank">
       <td class="width_10" ng-bind="objPresentationList.presentDate"></td>
       <td class="width_9" ng-bind="objPresentationList.isRealised"></td>
       <td class="width_10" ng-bind="objPresentationList.realisedDate"></td>
       <td class="width_9" ng-bind="objPresentationList.status"></td>
      </tr>
     </tbody>
    </table>
  

<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
       </div>
      </div>
      <!-- end widget content -->
     <!-- end widget div -->
    </div>
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>