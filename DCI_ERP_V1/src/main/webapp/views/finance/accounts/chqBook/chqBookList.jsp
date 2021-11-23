
<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
 
 <div class="panel-body float-left padding-0" style="width: 100%;">

     <div role="content">
     	<div class="form-body form-horizontal">
     		<div class="row">
				<div class="col-sm-10 col-md-4">
					<fieldset>
					<br>
						<!-- <div class="form-group">
							<label class="col-md-6 control-label">Valid From</label>
								<div class="col-md-6">
									<div class='input-group date datetimepick col-md-12'>
										<div class="dropdown">
											<a class="dropdown-toggle" id="validFromDate" role="button"
												data-toggle="dropdown" data-target="#" href="#">
												<div class="input-group">
													<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="validFrom" 
														data-ng-model="chqBookmodelData.validFrom">
														<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
												</div>
											</a>
											<ul class="dropdown-menu" role="menu"
												aria-labelledby="dLabel">
												<datetimepicker data-ng-model="chqBookmodelData.validFrom" data-on-set-time="chqBookmodelData.validFrom = onDateSet(newDate)"
													data-datetimepicker-config="{ dropdownSelector: '#validFromDate',startView:'day', minView:'day'}" />
											</ul>
										</div>
									</div>
								</div>
						</div> -->
						
						
							<div class="form-group ">
								<label class="col-md-6 control-label">Valid From <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="chqBookmodelData.validFrom"
										id="validFromDate" name="validFrom"
										data-ng-change="checkDatesCL(chqBookmodelData.validFrom)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
						<div class="form-group">
							<label class="col-md-6 control-label">Bank Account</label>
							<div class="col-md-6">
								<selectivity  list="bankAccountList" id="bankAccountId" name="bankAccountId" 
						        	property="chqBookmodelData.bankAccountId" ng-model="chqBookmodelData.bankAccountId">
						        </selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-10 col-md-4">
					<fieldset>
					<br>
						<!-- div class="form-group">
							<label class="col-md-6 control-label">Valid To</label>
								<div class="col-md-6">
									<div class='input-group date datetimepick col-md-12'>
										<div class="dropdown">
											<a class="dropdown-toggle" id="validToDate" role="button"
												data-toggle="dropdown" data-target="#" href="#">
												<div class="input-group">
													<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="validTo" 
														data-ng-model="chqBookmodelData.validTo">
														<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
												</div>
											</a>
											<ul class="dropdown-menu" role="menu"
												aria-labelledby="dLabel">
												<datetimepicker data-ng-model="chqBookmodelData.validTo" data-on-set-time="chqBookmodelData.validTo = onDateSet(newDate)"
													data-datetimepicker-config="{ dropdownSelector: '#validToDate',startView:'day', minView:'day'}" />
											</ul>
										</div>			
									</div>
								</div>
						</div> -->
						
						<div class="form-group ">
								<label class="col-md-6 control-label">Valid To <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="chqBookmodelData.validTo"
										id=validToDate name="validToDate"
										data-ng-change="checkDatesCL(chqBookmodelData.validTo)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
						<div class="form-group">
							<label class="col-md-6 control-label"> Status </label>
							<div class="col-md-6">
								<selectivity  list="statusList" id="statusId" name="statusId" 
						        	property="chqBookmodelData.statusId" ng-model="chqBookmodelData.statusId">
						        </selectivity>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"
							data-ng-click="viewSearchList(chqBookmodelData)">
							<i class="fa fa-save"></i> Submit
						</button>
					</div>
				</div>
			</div>
		</div>
		<br>
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        	st-table="displayedCollection" st-safe-src="rowCollection">
        <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
        <table id="dt_basic" class="table table-layout-fixed table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
	      <tr>
	       <th class="sorting width_20 text-center" st-sort="objChqBookList.bankAccountName">Bank Account</th>
	       <th class="sorting width_15 text-center" st-sort="objChqBookList.chqNo">Cheque Number</th>
	       <!-- <th class="sorting width_10 text-center" st-sort="objChqBookList.chequeDate">Cheque Date</th>  -->
	       <th class="sorting width_10 text-center" st-sort="objChqBookList.validFrom">Valid From</th>   
	       <th class="sorting width_10 text-center" st-sort="objChqBookList.validTo">Valid To</th>
	       <th class="sorting width_10 text-center" st-sort="objChqBookList.statusName">Status</th>
	       <th class="width_10 text-center table-heading">Action</th>
	      </tr>
	     </thead>
         <tbody class="dataTables-Main-Body">
	     	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objChqBookList in displayedCollection">
		       	<td class="width_20" ng-bind="objChqBookList.bankAccountName"></td>
		       	<td class="width_15" ng-bind="objChqBookList.chqNo"></td>
		       	<!-- <td class="width_10 text-right" ng-bind="objChqBookList.chequeDate"></td> -->
		       	<td class="width_10 text-right" ng-bind="objChqBookList.validFrom"></td>
		       	<td class="width_10 text-right" ng-bind="objChqBookList.validTo"></td>
		       	<td class="width_10" ng-bind="objChqBookList.statusName"></td>
		       	<td class="width_10 td-actions text-center">
			        <security:authorize access="hasRole('${form_code}_${modify}')">
				       	<span>
				       		<i class="fa  fa-pencil text-success text" data-ng-click="editChqBook(objChqBookList.chqBookId)" tooltip="Edit"></i>
				       	</span>
			       	</security:authorize>
		        	 <security:authorize access="hasRole('${form_code}_${delete}')">
				        <span>
				        <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteChqBook(objChqBookList.chqBookId,$index)" tooltip="Delete"></i>
				        </span>
			        </security:authorize>
		       	</td>
	     	</tr>
	     </tbody>
        </table>
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->      
 
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
 
  </div> <!-- /dataTables_wrapper -->
      </div> <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>