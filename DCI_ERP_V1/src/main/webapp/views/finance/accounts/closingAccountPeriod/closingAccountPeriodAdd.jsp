<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
<form class="form-horizontal" name="accountClosingForm"
				ng-submit="save(accountClosingForm)"
				novalidate>
				
				
				
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>
						
						
						
						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">Organization
							<span style="color: red;">*</span></label>
							<div class="col-md-5">
								<!-- <select class="form-control input-sm" id="companyCode"
									name="companyCode" ng-model="closeact.company"
									ng-options="option.text for option in companyList">
								</select> -->

								<selectivity list="companyListNew" property="closeact.company" id="company"
						        				ng-model="closeact.company" name="organization" form-name = "accountClosingForm"
						        				validation="required" ></selectivity>

							</div>
	       				</div>
 						<!-- <div class="form-group">
							<label class="col-md-5 control-label">From Date</label>
							
							<div class="col-md-7">							
						   		<div class='input-group date datetimepick' style="width: 69%;">
									<div class="dropdown">
										<a class="dropdown-toggle" id="tb_fromdate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="From date"  id="fromdate"
													data-ng-model="closeact.fromDate">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="closeact.fromDate" data-on-set-time="closeact.fromDate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#tb_fromdate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
							
							<div class="col-md-7 ">
								<div class="input-group input-append date" id="issueDate">
									<input type="text" class="form-control input-sm"
										name="issueDate" placeholder="dd/mm/yyyy" id="txtIssueDate"
										ng-model="closeact.fromDate" /> <span
										class="input-group-addon add-on"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>

							</div>
						</div>
            -->
							 
						
	       			<div class="form-group ">
								<label class="col-md-5 control-label">From Date <span
									style="color: red">*</span></label>
								<div class="col-md-5 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="closeact.fromDate"
										id="fromdate" name="From date"
										data-ng-change="checkDatesCL(closeact.fromDate)"
										friendly-name="From date" validation="required" />
								</div>
								</div>
		     	
	       				
	       				<!-- <div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">To Date <span style="color: red;">*</span></label>
				    			<div class="col-md-7 ">
								<div class="input-group input-append date" id="issueDate1">
									<input type="text" class="form-control " name="issueDate1"
										id="txtIssueDate1" data-ng-model="closeact.toDate"
										placeholder='dd/mm/yyyy' /> <span
										class="input-group-addon add-on"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							
							
							<div class="col-md-7">							
				    			<div class='input-group date datetimepick' style="width: 69%;">
									<div class="dropdown">
										<a class="dropdown-toggle" id="tb_todate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="To date"  id="todate"
													data-ng-model="closeact.toDate">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="closeact.toDate" data-on-set-time="closeact.toDate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#tb_todate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
	       				</div> -->
							
						 			<div class="form-group ">
								<label class="col-md-5 control-label">To Date <span
									style="color: red">*</span></label>
								<div class="col-md-5 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="closeact.toDate"
										id="fromdate" name="To date"
										data-ng-change="checkDatesCL(closeact.toDate)"
										friendly-name="To date" validation="required" />
								</div>
								</div>
									

					</fieldset>
					</div>
				</div>

<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button"
											ng-click="submitAccout(accountClosingForm)">
											<i class="fa fa-save"></i> Submit
										</button>
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Cancel
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="row" ng-if="rowCollection.length>0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<table
								class="table table-striped b-t b-light table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr><!-- <th class="sorting width_10" >Sub Group Code</th> -->
										<th class="sorting width_10">Acct. Code</th>
										<th class="sorting width_10" >Acct. Name</th>
										<th class="sorting width_10" >Debit</th>
										<th class="sorting width_10" >Credit</th>
										<th class="sorting width_10" >Balance</th>
										<th class="sorting width_10" >Local Debit</th>
										<th class="sorting width_10" >Local Credit</th>
										<th class="sorting width_10" >Local Balance</th>
									</tr>
								</thead>

								<tbody>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="objItem in rowCollection">
										<!-- <td class="sorting width_15" ng-bind="objItem.subgroupcode"></td> -->
										<td class="sorting width_20" ng-bind="objItem.accCode"></td>
										<td class="sorting width_20" ng-bind="objItem.accName"></td>
										<td class="sorting width_20" ng-bind="objItem.debit"></td>
										<td class="sorting width_20" ng-bind="objItem.credit"></td>
										<td class="sorting width_20" ng-bind="objItem.balance"></td>
										<td class="sorting width_20" ng-bind="objItem.localdebit"></td>
										<td class="sorting width_20" ng-bind="objItem.localcredit"></td>
										<td class="sorting width_20" ng-bind="objItem.localbalance"></td>
 
								</tbody>
							</table>
							
						</div>
						
					</div>
				</div>
				
				<div class="row" ng-if="rowCollection.length>0">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button"
											ng-click="saveData(rowCollection)">
											<i class="fa fa-save"></i> Close
										</button>
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Cancel
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div> 
</article>
</div>
</section>
</div>


