


<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list"  st-persist="advanceListTable"
  st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
										<tr>


											<%-- <th st-sort="companyName"><spring:message
													code="label.company.name"></spring:message>Organization Name</th>
											<th st-sort="branchName">Branch Name</th> --%>
											<th st-sort="advanceCode">Advance Code</th>
											<th st-sort="employeeCode">Employee Code</th>
											<th st-sort="employeeName">Employee Name</th>
											<th st-sort="amount">Advance Amount (Opening Balance) </th>
											<th st-sort="recoverytype">Recovery Type</th>	
											<th st-sort="installmentAmount">Installment Amount</th>										
											<th st-sort="deductFrom "> start From</th>
											<th st-sort="numberOfInstallments">Number of Installments</th>
											 <!-- <th st-sort="status">Status</th>  -->
											<th st-sort="">Action</th>

										</tr>

									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="loanEntryCollection in displayedCollection">

											<td>{{loanEntryCollection.advanceCode}}</td>
											<td>{{loanEntryCollection.employeeCode}}</td>
											<td>{{loanEntryCollection.employeeName}}</td>
											<td style="text-align: right;">{{loanEntryCollection.amount}}</td>
											<td>{{loanEntryCollection.recoverytype}}</td>
											<td style="text-align: right;">{{loanEntryCollection.installmentAmount}}</td>
											<td>{{loanEntryCollection.deductFrom | date:'MMyyyy'}}</td>
											<td>{{loanEntryCollection.numberOfInstallments}}</td>
											<%-- <td><span ng-if="loanEntryCollection.status == '1'"><spring:message
														code="label.training.pending"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '2'"><spring:message
														code="label.training.approved"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '3'"><spring:message
														code="label.training.cancelled"></spring:message></span></td> --%>
											<td class=" ">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(loanEntryCollection.advanceCode)"></i>
													</span>
											
													<span> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(loanEntryCollection.advanceCode)"></i>
													</span>
												</td>
										</tr>
									</tbody>
								</table>
								    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>

							</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				<!-- end widget -->
			<!-- WIDGET END -->
