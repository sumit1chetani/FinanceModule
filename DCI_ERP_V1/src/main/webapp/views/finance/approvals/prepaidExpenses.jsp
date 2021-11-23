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
        <th class="width_10">Voucher No</th>
        <th class="width_10">Prepaid Code</th>
        <th class="width_10" >Posting Account Code</th>
         <th class="width_15">Narration</th>
        <th class="width_6">Currency</th>
        <th class="width_6">Ex Rate</th>
        <th class="width_6">TC Amount</th>
        <th class="width_6">BC Amount</th>
       </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="preExp in displayedCollection">
      <td class="">
	        <label class="i-checks m-b-none">
	         <input type="checkbox" name="post[]" ng-model=preExp.select>
	         <i></i>
	        </label>
        </td>
       <td>{{preExp.companyName}}</td>
         <td>{{preExp.voucherNo}}</td>
       <td>{{preExp.prepaidName}}</td>
        <td>{{preExp.postName}}</td>
       <td>{{preExp.narration}}</td>
        <td>{{preExp.currecyCode}}</td>
       <td>{{preExp.exchangeRate}}</td>
        <td >{{preExp.tcAmt}}</td>
       <td>{{preExp.bcAmt}}</td>
       
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
