
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">


 <div class="panel panel-default panel-default-list" st-persist="withHoldTable" 
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
										<th st-sort="withHoldCode"> Code </th>
											<th st-sort="employee">Employee Code </th>
											<th st-sort="employeeName">Employee </th>
											<th st-sort="withholdDate">Withhold Date </th>
											<th st-sort="withholdFrom">Withhold From </th>
											<th st-sort="withholdTo">Withhold Till </th>
											<th>Is Active</th>
											
											
											 <!-- <th st-sort="status">Status</th>  -->
																						<th>Status</th>
											
											<th>Action</th>

										</tr>

									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="loanEntryCollection in displayedCollection">

												<td>{{loanEntryCollection.withHoldCode}}</td>
											<td>{{loanEntryCollection.employee}}</td>
											
											<td>{{loanEntryCollection.employeeName}}</td>
											<td>{{loanEntryCollection.withholdDate|date:'DD-MM-YYY'}}</td>
											<td>{{loanEntryCollection.withholdFrom | date:'MM/yyyy'}}</td>
											<td>{{loanEntryCollection.withholdTo | date:'MM/yyyy'}}</td>
											
												<td class="sorting" data-toggle="tooltip">
												
												<label class="i-checks">
												<input type="checkbox"
											message-id="check" id="check"
											class="checkbox style-0" name="check"
											ng-model="loanEntryCollection.check" disabled="disabled"><i></i></label>
												</td> 
																							<td>{{loanEntryCollection.status | date:'MM/yyyy'}}</td>
												
											
											<%-- <td><span ng-if="loanEntryCollection.status == '1'"><spring:message
														code="label.training.pending"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '2'"><spring:message
														code="label.training.approved"></spring:message></span> <span
												ng-if="loanEntryCollection.status == '3'"><spring:message
														code="label.training.cancelled"></spring:message></span></td> --%>
											<td   class=" td-actions text-left"><%-- <security:authorize
													access="hasRole('${form_code}_${modify}')"> --%>
													<span> <i  ng-if="loanEntryCollection.check"  class="fa  fa-pencil text-success text"
														data-ng-click="editRow(loanEntryCollection.withHoldCode,loanEntryCollection.check)"></i>
													</span>
													<span> <i  ng-if="!loanEntryCollection.check"  class="fa  fa-eye text-success text-center"
														data-ng-click="editRow1(loanEntryCollection.withHoldCode)"></i>
													</span>
													
													
										<%-- 		</security:authorize> <security:authorize
													access="hasRole('${form_code}_${delete}')"> --%>
													<span> <i ng-if="loanEntryCollection.check" 
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(loanEntryCollection.withHoldCode)"></i>
													</span>
<%-- 												</security:authorize>
 --%>												</td>
												
												
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
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>



