<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
 <style>
.dropdown-menu>li>a {
    padding: 5px 36px;
}
.form-control {
    border: 1px solid #DDD;
    border-radius: 7px;
    box-shadow: none;
    height: 42px;
    padding: 8px 12px 9px 12px;
}
</style> 
<security:authentication var="user" property="principal" />

		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  					<input type="hidden" value="${form_code}" id="form_code_id">
  				<div class="panel-body">
			<form class="form-horizontal" name="accountingyearcloseForm"
				ng-submit="save(accountingyearcloseForm)"
				novalidate>
				
				
				
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>
 						<div class="form-group">
					        				<label class="col-md-5 control-label"> Company <span style="color: red;">*</span></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="accountingYearClose.companyId" id="hospital"
						        				ng-model="accountingYearClose.companyId" name="hospital" form-name = "accountingyearcloseForm"
						        				validation="required" friendly-name="companyId"></selectivity>
											</div>
										</div>
           
							 
						<!-- <div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">From Date
							<span style="color: red;">*</span></label>
							<div class="col-md-7">							
						   		<div class='input-group date datetimepick' style="width: 69%;">
									<div class="dropdown">
										<a class="dropdown-toggle" id="tb_fromdate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="From date"  id="fromdate"
													data-ng-model="accountingYearClose.fromdate">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="accountingYearClose.fromdate" data-on-set-time="accountingYearClose.fromdate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#tb_fromdate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
	       				</div> -->
	       			
	       				<div class="form-group ">
								<label class="col-md-5 control-label">From Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="accountingYearClose.fromdate"
										id="fromdate" name="From date"
										data-ng-change="checkDatesCL(accountingYearClose.fromdate)"
										friendly-name="From date" validation="required" />
								</div>
								</div>
	       				<!-- <div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">To Date <span style="color: red;">*</span></label>
							<div class="col-md-7">							
				    			<div class='input-group date datetimepick' style="width: 69%;">
									<div class="dropdown">
										<a class="dropdown-toggle" id="tb_todate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="To date"  id="todate"
													data-ng-model="accountingYearClose.todate">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="accountingYearClose.todate" data-on-set-time="accountingYearClose.todate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#tb_todate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
	       				</div> -->
							
						
								<div class="form-group ">
								<label class="col-md-5 control-label">To Date  <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="accountingYearClose.todate"
										id="todate" name="To date"
										data-ng-change="checkDatesCL(accountingYearClose.todate)"
										friendly-name="To date" validation="required" />
								</div>
								</div>		

					</fieldset>
					</div>
				</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
						 <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-click="submit(accountingyearcloseForm)" data-ng-if="!accountingYearClose.isEdit" >
            <i class="fa fa-save"></i>
            Search
           </button>
          
        <!--      <button class="btn btn-success" class="btn btn-success" type="button" c"
					data-ng-if="accountingYearClose.isEdit" >
        <i class="fa fa-save"></i>
       Update
       </button>  -->
       
           <button class="btn btn-success" type="button" data-ng-click="update(accountingyearcloseForm)" data-ng-if="accountingYearClose.isEdit">
								<i class="class="fa fa-save"></i> Update 
							</button>
	
							
							<button class="btn btn-info" type="reset" ng-click="reset()" data-ng-if="!accountingYearClose.isEdit">
								<i class="fa fa-undo"></i> Reset 
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	











<div class="row" ng-if="rowCollection.length>0" data-st-table="displayedCollection">
					<div class="col-md-12">
						<div class="table-responsive ">
							<table
								class="table table-striped b-t b-light table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr>
							<th class="sorting width_2" st-sort="servicePartnerCode">Account Head Code</th>
						
						   <th class="sorting width_2" st-sort="servicePartnerCode">Account Head Name</th>
						
							<th class="sorting width_5" st-sort="servicePartnerLedgerName">Credit</th>
							<th class="sorting width_5" st-sort="servicePartnerLedgerName">Debit</th>
							
							<th class="sorting width_3" st-sort="country">Customer/Vendor</th>
							<th class="sorting width_3" st-sort="branchName">Company Name</th>
						</tr>
								</thead>

								<tbody>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="objItem in rowCollection">
										<!-- <td class="sorting width_15" ng-bind="objItem.subgroupcode"></td> -->
										<td class="sorting width_20" ng-bind="objItem.accountHeadName"></td>
										<td class="sorting width_20" ng-bind="objItem.accountHead"></td>
										<td class="sorting width_20" ng-bind="objItem.credit"></td>
										<td class="sorting width_20" ng-bind="objItem.debit"></td>
										<td class="sorting width_20" ng-bind="objItem.customerName"></td>
										<td class="sorting width_20" ng-bind="objItem.companyName"></td>
										<td class="sorting width_20" ng-bind="objItem.localcredit"></td>
										<td class="sorting width_20" ng-bind="objItem.localbalance"></td>
 
								</tbody>
							</table>
							
						</div>
						
					</div>
				</div>
				

</div>
</article>
</div>
</section>
</div>

<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								class="btn btn-success"
								ng-click="generateJv(rowCollection)">
								<i class="fa fa-save"></i> Generate JV

							</button>
							
						</div>
					</div>
				</div>
