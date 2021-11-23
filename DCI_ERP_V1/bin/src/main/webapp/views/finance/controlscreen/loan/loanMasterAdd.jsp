<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		 <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id" /> 
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row book-widget-row">

					<div class="col-sm-12">
						<fieldset>
						<div class="row">
							<div class="col-md-4">
						
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-3 bold">Company</label>
									<div class="col-md-8" ng-if="saveFlag=='S'">
										   <selectivity list="companyList" property="loanMainObj.loanHeader.companyCode" id="companyCode"></selectivity></div>
										   <div class="col-md-8" ng-if="saveFlag=='E'">
										   <label class="control-label">{{loanMainObj.loanHeader.companyCode}}</label>
										  </div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Loan Ref No.</label>
									<div class="col-md-7" ng-if="saveFlag=='S'">
										<input type="text"  data-ng-model="loanMainObj.loanHeader.loanRefNo" class="form-control input-sm ng-pristine ng-valid ng-touched"></input></div>
										 <div class="col-md-7" ng-if="saveFlag=='E'">
										   <label class="control-label">{{loanMainObj.loanHeader.loanRefNo}}</label>
										  </div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Loan Amount</label>
									<div class="col-md-7" ng-if="saveFlag=='S'">
										<input type="text"  data-ng-model="loanMainObj.loanHeader.loanAmount" class="form-control input-sm ng-pristine ng-valid ng-touched"></input></div>
										 <div class="col-md-7" ng-if="saveFlag=='E'">
										   <label class="control-label">{{loanMainObj.loanHeader.loanAmount1}}</label>
										  </div>
								</div>
							</div>
							</div>
							<div class="row m-t-sm">
							<div class="col-md-4">
								<div class="form-group">
									<label  class="control-label col-md-3 bold">Start Date</label>
									<div class="col-md-7" ng-if="saveFlag=='S'">
										<ng-bs3-datepicker data-ng-model="loanMainObj.loanHeader.startDate" date-format="DD/MM/YYYY" id="sch_end_date"/>
								</div>
								 <div class="col-md-7" ng-if="saveFlag=='E'">
										   <label class="control-label">{{loanMainObj.loanHeader.startDate}}</label>
										  </div>
							</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label  class="control-label col-md-5 bold">End Date</label>
									<div class="col-md-7" ng-if="saveFlag=='S'">
										<ng-bs3-datepicker data-ng-model="loanMainObj.loanHeader.endDate" date-format="DD/MM/YYYY" id="sch_end_date"/>
								</div>
								 <div class="col-md-7" ng-if="saveFlag=='E'">
										   <label class="control-label">{{loanMainObj.loanHeader.endDate}}</label>
										  </div>
							</div>
						</div>
						</div>
						</fieldset>
					</div>
				</div>
			
</div>
			<div class="panel-heading bold toggleBlock-currsor" ng-click="toggleBlock('rpDiv')"> Repayment Dtl </div>
					<div class="table-responsive col-md-8" id="rpDiv" >
					<table class="table table-striped b-t b-light toggleBlock-currsor"  >
						<thead class="dataTables-Main-Head">
							<tr>
								<th colspan=1 class="width_1"></th>
								<th class="sorting width_10" st-sort="sailedDate">Repayment Date</th>
								<th class="sorting width_10" >Repayment Amount</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in loanMainObj.lRepaymentDtl" >
							<tr>
								<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
								<td class="sorting ">
									<ng-bs3-datepicker data-ng-model="row.repaymentDate" date-format="DD/MM/YYYY" id="sch_end_date"/>
								</td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.repaymentAmount" 
											name="remitPaidExchangeRate" placeholder="0.0" ng-blur="remitPaidExRateCalc(row);">
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5">
			      		<div class="col-md-4">
			          		  <button ng-click="addRepaymentRow(loanMainObj.lRepaymentDtl)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					            <i class="fa fa-plus"></i>
					           </button>
					           <button ng-click="removeRepaymentRow(loanMainObj.lRepaymentDtl)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					            <i class="fa  fa-trash-o"></i>
					           </button>
			          	</div>
			        </div>
				</div>
			
			<div class="panel-heading bold toggleBlock-currsor col-md-12" ng-click="toggleBlock('interestdiv')"> Interest Dtl</div>
			
				<div class="table-responsive col-md-12" id="interestdiv">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th colspan=1 class="width_1"></th>
								<th class="sorting width_10" >Interest</th>
								<th class="sorting width_10" >From Date</th>
								<th class="sorting width_10" >To Date</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in loanMainObj.lInterestDtl" >
							<tr>
								<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
								<td class="sorting ">
									<input type="text" class="form-control input-sm" ng-model="row.interestPercentage" 
										name="interest" >
								</td>
								<td class="sorting ">
									<ng-bs3-datepicker data-ng-model="row.interestFromDate" date-format="DD/MM/YYYY " id="sch_end_date"/>
								</td>
								<td class="sorting ">
									<ng-bs3-datepicker data-ng-model="row.interestToDate" date-format="DD/MM/YYYY " id="sch_end_date"/>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5">
			      		<div class="col-md-4">
			          		  <button ng-click="addInterestDtlRow(loanMainObj.lInterestDtl)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					            <i class="fa fa-plus"></i>
					           </button>
					           <button ng-click="removeInterestDtlRow(loanMainObj.lInterestDtl)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					            <i class="fa  fa-trash-o"></i>
					           </button>
			          	</div>
			        </div>
				</div>
				</div>
			<!-- /panel-body -->
			<div class="row">
          <div class="col-md-12">
          	<div class="form-actions">
	           <button class="btn btn-success ng-scope ng-pristine ng-valid ng-touched" ng-click="saveLoan()" style="">
	        		<i class="fa fa-save"></i>Save
	       		</button>
	       		<button class="btn btn-danger  ng-pristine ng-valid ng-touched" type="button" id="cancel" ng-model="cancel" ng-click="cancel();" style="">
        <i class="fa fa-close"></i>
        Cancel
       </button>
           	</div> <!-- /form-actions -->
          </div> <!-- /col-sm-12 -->
         </div>
			</div>
		</div>
