

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

	<div class="panel panel-default panel-default-list" st-persist="loanReportTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="payrollReportForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<!-- <div class="col-sm-6 col-md-6 col-lg-5">
											<div class="form-group">
												<label class="col-md-5 control-label">Month
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<selectivity list="monthList" ng-model="deduction.month"
														property="deduction.month" id="month" object="month"  name="month" validation="required"
			        				 friendly-name="Month" form-name = "vesselMasterForm"></selectivity>-->
						           					<!-- <select class="form-control" ng-model="deduction.month">
										   				 <option value="">--Select--</option>
										   				 <option value="01">January</option>
										   				 <option value="02">February</option>
										   				 <option value="03">March</option>
										   				 <option value="04">April</option>
										   				 <option value="05">May</option>
										   				 <option value="06">June</option>
										   				 <option value="07">July</option>
										   				 <option value="08">August</option>
										   				 <option value="09">September</option>
										   				 <option value="10">October</option>
										   				 <option value="11">November</option>
										   				 <option value="12">December</option>
													</select> -->
												<!-- </div>
											</div>	
											
											
										</div>-->
										
										<div class="col-sm-6 col-md-6 col-lg-5">
										
										<div class="form-group">
												<label class="col-md-5 control-label">Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<!--  <selectivity list="financialYearList" property="deduction.year" 
										                id="year" ng-model="deduction.year"
										               name="year" form-name="vesselMasterForm"
										               validation="required" friendly-name="Year">
										         </selectivity>-->
										         
										         <selectivity  list=department property="deduction.department" ng-model="deduction.department" id="department"  name="department" form-name = "payrollgenertaionForm" 
	        													validation="required" friendly-name="Department"></selectivity>
						           					<!-- <select class="form-control" ng-model="deduction.year">
										   				 <option value="">--Select--</option>
										   				 <option value="2015">2015</option>
										   					<option value="2016">2016</option>
										   				   <option value="2017">2017</option>
										   				   <option value="2018">2018</option>
													</select> -->
												</div>
											</div>	
											
										</div>
										</div>
										
										<!-- <div class="form-group">
											<div class="row">
										<label class="col-md-4 control-label">
													
												</label>
												<div class="col-md-4">
											<button class="btn btn-success" type="button" data-ng-click="getDeductedList(vesselMasterForm)"
												class="btn btn-success" >
												Deducted List
											</button>
											
											<button class="btn btn-success" type="button" data-ng-click="getTobeDeductedList(vesselMasterForm)"
												class="btn btn-success" >
												To be Deducted List
											</button>
											
										</div>
									</div>
								</div>-->
										
								</div>
										
         <br>
         <br>
         <br>
         <br>
    	  <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
        <%--   <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div> --%>
          
          <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
          
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="dt_basic_info">
         <thead>
          <tr>
<!--            <th class="width_1 text-center table-heading"> -->
<!--            <label class="i-checks m-b-none"> -->
<!--              <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(displayedCollection,selectedAll)"> -->
<!--              <i></i> -->
<!--             </label> -->
<!--            </th> -->
           <th class="sorting width_12" st-sort="employeeId">Employee Id</th>
           <th class="sorting width_15" st-sort="employeeName">Employee Name</th>
          <!-- <th class="sorting width_15" st-sort="loanTypeId">Loan Type Id</th>-->
           <th class="sorting width_15" st-sort="loanTypeName">Loan Type</th>
           <th class="sorting width_15" st-sort="deductFrom">Deduction From</th>
           <th class="sorting width_15" st-sort="installment">Installment</th>
           <th class="sorting width_15" st-sort="loanAmount">Loan Amount</th>
           <th class="sorting width_15" st-sort="deductAmount">Deduction Amount</th>
          </tr>
         
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="loanlist in displayedCollection">
<!--          <td> -->
<!-- 	           	<label class="i-checks m-b-none"> -->
<!-- 				  <input type="checkbox"  ng-model="loanlist.checkbox"> -->
<!-- 				   <i></i> -->
<!-- 				</label> -->
<!-- 				</td> -->
             <td>{{loanlist.employeeId}}</td>
             <td>{{loanlist.employeeName}}</td>
             <td>{{loanlist.loantypeName}} </td>
             <td>{{loanlist.deductFrom}} </td>
             <td>{{loanlist.installment}} </td>
             <td>{{loanlist.loanAmount}}</td>
             <td>{{loanlist.deductAmount}}</td>
           </tr>
         </tbody>
        </table>
      <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
       </div>
       <br>
<!--        <div class="form-group"> -->
<!-- 											<div class="row"> -->
<!-- 										<label class="col-md-6 control-label"> -->
													
<!-- 												</label> -->
<!-- 												<div class="col-md-6"> -->
												
												
<!-- 											 <button class="btn btn-success" type="button" data-ng-click="deductLoan()" -->
<!-- 												class="btn btn-success" ng-if= "deduction.isTobededucted"> -->
<!-- 												Deduct -->
<!-- 											</button> -->
										
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
         
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
