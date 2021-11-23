
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list" st-persist="loanAppTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body float-left padding-0" style="width: 100%;">
		<br>
         	<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Status
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control" ng-model="loantype.status">
										   				 <option value="">--Select--</option>
										   				 <option value="1">Pending</option>
										   					<option value="2">Approved</option>
										   				   <option value="3">Reject</option>
										   				   <option value="4">Closed</option>
													</select>
												</div>
											</div>	
										</div>
										
										<div class="col-sm-6 col-md-6 col-lg-4">
												<div class="col-md-5">
						           					 <button class="btn btn-success"  type="button" data-ng-click="showList(loantype.status)">
									     			Submit
									       			</button>
												</div>
										</div>
										</div>
										
								</div>
										
         
         
    	  <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
         <!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
         
         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		 </div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head ">
          <tr>
           <!-- <th class="width_1"></th> -->
           <th class="sorting width_10" st-sort="companyName">Organization</th>
           <th class="sorting width_10" st-sort="branchName">Branch Name</th>
           <th class="sorting width_12" st-sort="employeeName">Employee Name</th>
           <th class="sorting width_10" st-sort="loanTypeId">Loan Type</th>
           <th class="sorting width_10" st-sort="amount">Loan Amount</th>
           <th class="sorting width_10" st-sort="deductFrom">Ded.St Date</th>
           <th class="sorting width_12" st-sort="numberOfInstalments">Total Installments</th>
           <th class="sorting width_12" st-sort="deductionAmount">Monthly Deduction</th>
           <th class="sorting width_8" st-sort="status">Status</th>
           <th class="sorting width_8" st-sort="">Action</th>
           
          </tr>
         
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="myloanlist in displayedCollection">
           <!-- <td cs-select="objVesselMasterItem"></td> -->
            <td>{{myloanlist.companyName}}</td>
           <td>{{myloanlist.branchName}}</td>
            <td>{{myloanlist.employeeName}}</td>
             <td>{{myloanlist.loanTypeId}}</td>
              <td>{{myloanlist.amount}}</td>
               <td>{{myloanlist.deductFrom}}</td>
                <td>{{myloanlist.numberOfInstalments}}</td>
                <td>{{myloanlist.deductionAmount}}</td>
                <td>
                  <span ng-if="myloanlist.status == '1'">Pending</span>
                 <span ng-if="myloanlist.status == '2'">Approved</span>
                 <span ng-if="myloanlist.status == '3'">Reject</span>
                   <span ng-if="myloanlist.status == '4'">Closed</span>
                 </td>
        
         
          <td class=" td-actions text-center">
          
            <security:authorize access="hasRole('${form_code}_${modify}')">   
		<i class="fa  fa-pencil text-success text" ng-if="myloanlist.status == '1'" data-ng-click="editRow(myloanlist.loanId)"></i>
		</security:authorize>
									
	
       </td>
           </tr>
         </tbody>
        </table>
       
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
