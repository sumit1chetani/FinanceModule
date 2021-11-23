
<div class="wrapper-md">
 <div class="panel panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
  <!-- <div class="panel panel-default panel-default-form "> -->
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
  </div>
 </div>
</div>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="row book-widget-row">
			<div class="col-sm-12 col-md-4 col-lg-4">
			<div class="form-group">
            <label class="col-md-3 control-label  vessel-text">Company</label>
            <div class="col-md-6" ">
	            <selectivity list="companyList" property="mReconObj.companyCode" id="vessel_id"></selectivity>
            </div>
           </div>
           </div>
           <div align="center">
				<div class="row">
					<div class="col-md-12 ">
						<button class="btn btn-success" type="button"
							data-ng-click="getListDetail();">
							<i class="fa fa-search"></i> Search
						</button>
					</div>
				</div>
			</div>
			</div>
   <div class="widget-body no-padding m-t-sm">
    <div class="table-responsive ">
     <table class="table table-striped b-t b-light table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
       <tr>
        <th class="width_15">Particulars</th>
        <th class="width_10">Company</th>
        <th class="width_10">Currency</th>
        <th class="width_10" >Ex-rate</th>
         <th class="width_10">TC Debit</th>
        <th class="width_10">TC Credit</th>
        <th class="width_10">BC Debit</th>
        <th class="width_10">BC Credit</th>
        <th class="width_10">Allocated Amount</th>
        <th class="width_10">Action</th>
       </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="mReconciliation in displayedCollection">
       <td>{{mReconciliation.particulars}}</td>
         <td>{{mReconciliation.company}}</td>
       <td>{{mReconciliation.currency}}</td>
        <td>{{mReconciliation.exRate}}</td>
       <td>{{mReconciliation.tcDebit}}</td>
        <td>{{mReconciliation.tcCredit}}</td>
       <td>{{mReconciliation.bcDebit}}</td>
        <td >{{mReconciliation.bcCredit}}</td>
        <td >{{mReconciliation.allocatedAmount}}</td>
        <td><span class="ng-scope">
          <i class="fa fa-check  text" title="JV Posting" data-ng-click="jvPost(mReconciliation)"></i>
         </span></td>
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
