<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">

   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id">
  </div><!-- /panel-heading -->
  <div class="panel panel-default">
		<div class="form-body form-horizontal">
			<div class="row book-widget-row m-t-sm">
			<div class="col-sm-12 col-md-4 col-lg-4">
			<div class="form-group">
            <label class="col-md-3 control-label  vessel-text">Company</label>
            <div class="col-md-6" ">
	            <selectivity list="companyList" property="unAllocObj.companyCode" id="company_id"></selectivity>
            </div>
           </div>
           </div>
           <div align="center">
				<div class="row">
					<div class="col-md-12 ">
						<button class="btn btn-success" type="button"
							data-ng-click="searchUnAllocatedList();">
							<i class="fa fa-search"></i> Search
						</button>
					</div>
				</div>
			</div>
			</div>
	</div>
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="sorting width_15" st-sort="objUnAllocated.cashbankPmtDate">Payment No</th>
       <th class="sorting width_25" st-sort="objUnAllocated.cbVoucherNo">Supplier</th>
       <th class="sorting width_10" st-sort="objUnAllocated.accountName">BC Amount</th>
       <th class="sorting width_10" st-sort="objUnAllocated.accountName">TC Amount</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objUnAllocated in displayedCollection">
       <td><span >
       <a ng-click="viewCBP(objUnAllocated)">
		             <span tooltip="{{objUnAllocated.paymentNo}}" class="tool-tip-span font-blue">{{objUnAllocated.paymentNo}}</span>
		         </a></span>
       </td>
       <td class="width_15" ng-bind="objUnAllocated.vendorName"></td>
       <td class="width_15" ng-bind="objUnAllocated.bcAmount"></td>
       <td class="width_15" ng-bind="objUnAllocated.tcAmount"></td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
</div>
</div>
 <script type="text/ng-template" id="cbpaymentDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeCBPDialog()">Cancel</button>
</div>
 </script>
