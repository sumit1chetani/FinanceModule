<div class="wrapper-md">
 <div class="panel panel-default panel-default-form"  st-table="displayCollection" st-safe-src="rowCollection" >
  <div class="panel-heading padding-right-0 padding-left-0 panel-heading-list-page float-left font-bold">
  <ol class="breadcrumb inline-block padding-left-10">
    <li>
     <a x-ui-sref="app.finance">Finance</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.invoice">Invoice</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.invoice.invoiceGenerate">Invoice List</a>
    </li>
   </ol>
   </div>
   <div class="panel-body float-left padding-0">
   <div class="table-responsive ">
    <table class="table table-striped b-t b-light table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th colspan="1" >Vessel</th>
       <th colspan="3">{{invoiceGenerateData.vesselCode}}</th>
        <th colspan="1">Voyage</th>	
         <th colspan="3">{{invoiceGenerateData.voyageId}}</th>
       <th colspan="2"></th> 
      </tr>

     </thead>
     <tbody>
      <tr>
      <td class="width_1">Invoice No</td>
       <td class="width_1">Invoice Dt.</td>
      <td class="width_1">Cust.</td>
      <td class="width_1">Payer</td>
      <td class="width_1">Pol</td>
      <td class="width_1">Pod</td>
      <td class="width_1">BL No</td>
      <td class="width_1">Quot. No</td>
      <td class="width_5">Actions</td>
     <!--  <td class="width_4">Print</td> -->
      <!-- <td class="width_1">Select <input type="checkbox" name="selectedTypes[]" ng-click="bulkSelect(displayCollection)"></td> -->
                <td class="width_1 text-center"><label class="i-checks m-b-none">
             <!--  <input type="checkbox" ng-model="objItem[0].checkalt"> -->
              <input type="checkbox" name="selectedTypes[]"  ng-click="bulkSelect(displayCollection)">
              <i></i>
             </label></td>

      </tr>

      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in displayCollection" >

       <td class="sorting width_10">
       <a href ="#/invoice/invoiceview/{{objItem[0].invoiceNumber}}">
       <span tooltip="{{objItem[0].invoiceNumbe}}" class="tool-tip-span font-blue"></span></a>
       {{objItem[0].invoiceNumber}}
       </td>
       <td class="width_1">{{objItem[0].sailingDate}}</td>
       <td class="width_1"><a ng-click="gotosummay(objItem)">{{objItem[0].submitShortMlo}}</a></td>
       <td class="width_1"><a ng-click="gotosummay(objItem)">{{objItem[0].submitShortPayer}}</a></td>
       <td class="width_1">{{objItem[0].submitPol}}</td>
       <td class="width_1">{{objItem[0].submitPod}}</td>
       <td class="width_1"><a ng-click="gotosummay(objItem)">{{objItem[0].submitBlno}}</a></td>
       <td class="width_1"><a ng-click="gotosummay(objItem)">{{objItem[0].quotationNo}}</a></td>
	   <td>
		<select ng-model="objItem[0].printList" id ="printSelect{{$index}}" ng-init="objItem[0].printList = 'both'">
									<option value="both" >Both</option>
									<option value="usd">USD</option>
									<option value="local">Local</option>
							</select>
							&nbsp;&nbsp;<!-- <span><i class="icon-envelope red" data-ng-click="clickInvoiceMail(objItem[0].invoiceNumber,'both')" style="cursor: pointer; color: gray;"></i></span> --> 
							&nbsp;&nbsp;<span data-ng-click="clickInvoiceFunction(objItem[0].invoiceNumber,'both')"
								id="{{objItem[0].invoiceNumber}}"
								class=" glyphicon glyphicon-print "
								style="cursor: pointer; color: gray;"></span></td>
							

          <td class="width_1 text-center"><label class="i-checks m-b-none">
             <!--  <input type="checkbox" ng-model="objItem[0].checkalt"> -->
              <input type="checkbox" name="selectedTypes[]"  ng-model="objItem[0].checkalt1">
              <i></i>
             </label></td> 
       
         </tr>

      <tr x-ng-show="showEmptyLabel">
       <td colspan="6">No Records Found</td>
      </tr>
     </tbody>
    </table>
   </div>
   <div class="form-actions">
			<div class="row">
			<div class="col-md-12">
		<button class="btn btn-success"
		ng-click="bulkMail(displayCollection)"
		type="submit">
	Bulk Mail
	</button>
	
		<button class="btn btn-danger" ng-click="cancel()" type="button">
									<i class="fa fa-close"></i> Cancel
		</button>
								
								
	</div>
</div>
</div>
   <footer class="panel-footer">
    <%--  <%@include file="/views/templates/panel-footer-static.jsp"%> --%>
   </footer>
  </div>
</div>
 </div>
 