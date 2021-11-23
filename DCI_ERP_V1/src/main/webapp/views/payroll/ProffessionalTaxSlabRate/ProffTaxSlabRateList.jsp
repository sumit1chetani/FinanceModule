

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="proftTaxTable"
  st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
          <tr >
        <%-- <th st-sort="companyName"><spring:message
													code="label.company.name"></spring:message>Organization Name</th>
											<th st-sort="branchName">Branch Name</th> --%>
										<th class="sorting width_20" st-sort="fromDate"> From Date </th>
											<th class="sorting width_20" st-sort="toDate">To Date</th>
											<th>Action</th>
          </tr>
         </thead>
        <tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="loanEntryCollection in displayedCollection">

											
											<td>{{loanEntryCollection.fromDate|date:'DD-MM-YYY'}}</td>
											<td>{{loanEntryCollection.toDate | date:'DD-MM-YYY'}}</td>
												
											
											<td   class=" td-actions text-left">
													<span> <i
														
														class="fa  fa-pencil text-success text"
														data-ng-click="editRow(loanEntryCollection.slabHdrId,loanEntryCollection.fromDate,loanEntryCollection.toDate)"></i>
													</span>
													<span>
													<i
													
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(loanEntryCollection.slabHdrId)"></i>
															</span>
												</td>
												
												
										</tr>
									</tbody>
    </table>
     <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div> 