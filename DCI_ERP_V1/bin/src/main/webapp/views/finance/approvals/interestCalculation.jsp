<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel  panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
  <!-- <div class="panel panel-default panel-default-form "> -->
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
  </div>
 </div>
	</div>
	<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">

  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="widget-body no-padding ">
    <div class="table-responsive ">
     <table class="table table-striped b-t b-light table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
       <tr>
       <th class="width_1"> </th>
        <th class="width_14">Company</th>
        <th class="width_8">Loan No</th>
        <th class="width_10">Loan Ref</th>
        <th class="width_8">Outstanding</th>
        <th class="width_8">From Dt</th>
        <th class="width_8">To Dt</th>
        <th class="width_4">Days</th>
        <th class="width_6">Intrst %</th>
        <th class="width_10">Intrst Amt</th>
       </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objLoan in displayedCollection">
      <td class="">
	        <label class="i-checks m-b-none">
	         <input type="checkbox" name="post[]" ng-model=objLoan.select>
	         <i></i>
	        </label>
        </td>
		<td>{{objLoan.companyName}}</td>
       <td>{{objLoan.loanCode}}</td>
        <td>{{objLoan.narration}}</td>
        <td>{{objLoan.outStandingAmount}}</td>
       <td>{{objLoan.fromDate}}</td>
        <td>{{objLoan.toDate}}</td>
       <td>{{objLoan.dayCount}}</td>
       <td>{{objLoan.interestPercentage}}</td>
       <td>{{objLoan.interestAmount}}</td>
      </tr>
     </tbody>    
     </table>
     
    </div>
    <footer class="panel-footer">
     <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
    
     <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" ng-click="approve(displayedCollection)" type="button">Approve</button>
   					<security:authorize access="hasRole('${form_code}_${export}')">
   					<button class="btn btn-primary"  ng-click="excel()"  type="button">
   					<i class="fa fa-download"> </i>
   					Export Excel</button>
   					</security:authorize>
   					</div>
   					
   					
   		 <div class="excels"> </div> 
   					</div>
   	</div>
   	
   </div>
  </div>
 </div>

</div>
