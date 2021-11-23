

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="loanEntryTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
										<tr>

											<th st-sort="companyName"><%-- <spring:message
													code="label.company.name"></spring:message> --%>Organization Name</th>
											<th st-sort="branchName">Branch Name</th>
											<th st-sort="employeeName">Employee Name</th>
											<th st-sort="loanTypeId">Loan Type</th>
											<th st-sort="amount">Loan Amount</th>
											<th st-sort="deductFrom">Deduct From</th>
											<th st-sort="numberOfInstalments">Total Installments</th>
											<th st-sort="deductionAmount">Monthly Deduction</th>
											<th st-sort="status">Status</th>
											<th st-sort="">Action</th>

										</tr>

									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="loanEntryCollection in displayedCollection">

											<td>{{loanEntryCollection.companyName}}</td>
											<td>{{loanEntryCollection.branchName}}</td>
											<td>{{loanEntryCollection.employeeName}}</td>
											<td>{{loanEntryCollection.loanTypeId}}</td>
											<td>{{loanEntryCollection.amount}}</td>
											<td>{{loanEntryCollection.deductFrom}}</td>
											<td>{{loanEntryCollection.numberOfInstalments}}</td>
											<td>{{loanEntryCollection.deductionAmount}}</td>
											<td><span ng-if="loanEntryCollection.status == '1'"><spring:message
														code="label.training.pending"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '2'"><spring:message
														code="label.training.approved"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '3'"><spring:message
														code="label.training.cancelled"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '4'">Closed</span></td>
											<td class=" td-actions text-center"><security:authorize
													access="hasRole('${form_code}_${modify}')">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(loanEntryCollection.loanId)"></i>
													</span>
												</security:authorize> <security:authorize
													access="hasRole('${form_code}_${delete}')">
													<span> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(loanEntryCollection.loanId)"></i>
													</span>
												</security:authorize></td>
										</tr>
									</tbody>
								</table>
										<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
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
