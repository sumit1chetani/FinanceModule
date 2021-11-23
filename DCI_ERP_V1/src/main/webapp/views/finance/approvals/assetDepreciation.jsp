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
        <th class="width_10">Company</th>
        <th class="width_15">Asset </th>
        <th class="width_15">Depreciation Acct</th>
        <th class="width_15" >Acc. Depreciation Acct</th>
        <th class="width_7">Currency</th>
        <th class="width_7">Ex-Rate</th>
        <th class="width_7">Tc Amt</th>
        <th class="width_7">Bc Amt</th>
        <th class="width_7">Start Dt</th>
        <th class="width_7">End Dt</th>
       </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="assetDepreciation in displayedCollection">
       <td class="">
	        <label class="i-checks m-b-none">
	         <input type="checkbox" name="post[]" ng-model=assetDepreciation.select>
	         <i></i>
	        </label>
        </td>
       <td>{{assetDepreciation.companyName}}</td>
       <td>{{assetDepreciation.assetName}}</td>
        <td>{{assetDepreciation.depreciationName}}</td>
       <td>{{assetDepreciation.accdepreciationName}}</td>
       <td>{{assetDepreciation.currencyCode}}</td>
       <td>{{assetDepreciation.exchangeRate}}</td>
       <td>{{assetDepreciation.tcAmount}}</td>
        <td>{{assetDepreciation.bcAmount}}</td>
       <td>{{assetDepreciation.startDate}}</td>
        <td >{{assetDepreciation.endDate}}</td>
       
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
