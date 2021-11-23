<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  	<%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel panel-default">
   <div class="panel-body">
    <div class="table-responsive">     
     
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <th class="sorting width_10" data-st-sort="companyName">Loan Code </th>  
           <th class="sorting width_10" data-st-sort="companyName">Company </th>        
           <th class="sorting width_10" data-st-sort="loanRefNo">Loan Ref No</th>
            <th class="sorting width_10" data-st-sort="loanAmount">Loan Amount</th>
           <th class="sorting width_10" data-st-sort="startDate">Start Date </th>               
           <th class="width_10 text-center table-heading" data-st-sort="endDate">End Date</th>
            <th class="sorting width_5">
           Action</th>   
           
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="loan in displayedCollection">
          <td>{{loan.loanCode}}</td>
           <td>{{loan.companyName}}</td>
           <td>{{loan.loanRefNo}}</td>      
           <td style="text-align: right;">{{loan.loanAmount1}}</td>
           <td>{{loan.startDate}}</td>
           <td>{{loan.endDate}}</td>      
           
            <td class=" td-actions text-center">
            <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(loan.loanCode)"></i>
        </span>
        </security:authorize>
		<%-- <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(loan)"></i>
        </span>
        </security:authorize> --%>
       </td>
          </tr>
         </tbody>
        </table>
    </div> <!-- /table-responsive -->
     <footer class="panel-footer">
	    <%@include file="/views/templates/panel-footer-static.jsp"%>
	   </footer>
   </div> <!-- /panel-body -->
  </div> <!-- /panel-default -->
 </div>
</div>
