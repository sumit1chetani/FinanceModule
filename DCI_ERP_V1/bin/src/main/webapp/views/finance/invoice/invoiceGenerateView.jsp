<style>
.multiple_qt
{
background: orange !important;
}
</style>

<div class="wrapper-md">
 <div class="panel panel-default panel-default-form"  st-table="displayCollection" st-safe-src="rowCollection"  >
  <div class="panel-heading panel-heading-form font-bold">
     <ol class="breadcrumb inline-block padding-left-10">
    <li>
     <a x-ui-sref="app.finance">Finance</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.invoice">Invoice</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.invoice.invoiceGenerate">Invoice View</a>
    </li>
   </ol>
   </div>
  
   <div class="panel-body float-left padding-0">
   <!-- <form class="form-horizontal" name="invoiceGenerateForm" role="form" ng-submit= "invoiceGenerateForm(invoiceGenerateForm,invoiceGenerateData)" novalidate> -->
   <form class="form-horizontal" name="invoiceGenerateForm" role="form" novalidate>
   <div class="table-responsive " >
    <table class="table table-striped b-t b-light table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th colspan="5">Vessel</th>
       <th colspan="5">{{getinvoiceGenerateData.vesselCode}}</th>
       <th colspan="6">Voyage</th>
       <th colspan="5">{{getinvoiceGenerateData.voyageId}}</th>
     </thead>
     <tbody>
      <tr>
      <td class="width_1">Select</td>
      <td class="width_1">Cust.</td>
      <td class="width_1">Payer</td>
      <td class="width_1">Pol</td>
      <td class="width_1">Pod</td>
      <td class="width_1">Slot A/C</td>
      <td class="width_1">Sub Slot</td>
      <td class="width_1">BL No</td>
      <td class="width_1">Quot. No</td>
      <td class="width_1">Sailing Dt.</td>
      <td class="width_2">WO No</td>
      <td class="width_1">T/S</td>
      <td class="width_1">FLS Ship.</td>
      <td class="width_1">Quot. Ship.</td>
       <td class="width_1">Cur.</td>
      <td class="width_1">Ex. Rate</td>
      <td class="width_1">LPO</td>
      <td class="width_1">Quot. Remark</td>
      <td class="width_1">FLS Remark</td>
       <td class="width_1">Special</td>
      <!-- <td class="width_1">Payment Center</td> -->

      </tr>

<tr ng-repeat="objItem in displayCollection" ng-class="{'multiple_qt': objItem.multiQuot === 'Y', 'odd': objItem.multiQuot !== 'Y'}">      <!-- <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in displayCollection" > -->
       <td class="width_1 text-center"><label class="i-checks m-b-none">
              <!-- <input type="checkbox" name="selectedTypes[]"  ng-model="objItem.checkalt1" ng-disabled="objItem.checkalt"> -->
               <input type="checkbox" name="selectedTypes[]"  ng-model="objItem.checkalt1" ng-click="checkAlert(objItem)">
              <i></i>
             </label></td>
       <td class="width_1">{{objItem.submitShortMlo}}</td>
       <td class="width_1">{{objItem.submitShortPayer}}</td>
       <td class="width_1">{{objItem.submitPol}}</td>
       <td class="width_1">{{objItem.submitPod}}</td>
       <td class="width_1">{{objItem.submitShortSlot}}</td>
       <td class="width_1">{{objItem.submitSubSlot}}</td>
       <td class="width_1">{{objItem.submitBlno}}</td>
       
     <!--   <td class="width_1"><a ng-click="gotoInvoiceSummary(objItem)">{{objItem.submitQuotationNo}}</a></td>  -->
        <td class="width_1"><a ng-click="showInvoiceSummary(objItem)">{{objItem.submitQuotationNo}}</a></td> 
       
       <td class="width_1">{{objItem.submitSailingDate}}</td>
       <td class="width_2">{{objItem.submitWoNo}}</td>
       <td class="width_1">{{objItem.submitTranshipment}}</td>
       <td class="width_1">{{objItem.bookShip}}</td>
        <td class="width_1">{{objItem.quotShip}}</td>
       <td class="width_1">{{objItem.submitCurrency}}</td>
       <td class="width_1">{{objItem.submitex_rate}}</td>
       <td class="width_1"><input type="text" class="form-control input-sm" name="lpo" ng-model="objItem.lpo" ></td>
       <td class="width_1">{{objItem.submitQuotRemarks}}</td>
       <td class="width_1">{{objItem.submitFLSRemarks}}</td>
        <td class="width_1">{{objItem.special}}</td>
       <!-- <td class="width_1"><select ng-model="objItem.companyCode" ng-options="Values.companyCode as Values.location  for Values in countryList">
       <option value="" selected="selected">Select</option>
       </select></td> -->
      </tr>
      <tr x-ng-show="showEmptyLabel">
       <td colspan="6">No Records Found</td>
      </tr>
     </tbody>
    </table>
   </div>
   <div class="form-actions">
			<div class="row">
			<div class="col-md-13">
		<button class="btn btn-success"
		type="submit" ng-click="generateInvoice(displayCollection)">
	 Generate Invoice
	</button>
	&nbsp;&nbsp;
	<button class="btn btn-danger" ng-click="cancel()" type="button">
									<i class="fa fa-close"></i> Cancel
								</button>

	</div>
</div>
</div>
   <footer class="panel-footer">
   <%--   <%@include file="/views/templates/panel-footer-static.jsp"%> --%>
   </footer>
   </form>
  </div>
 </div>
</div>