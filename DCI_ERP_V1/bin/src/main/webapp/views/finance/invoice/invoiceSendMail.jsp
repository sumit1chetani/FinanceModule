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
     <a x-ui-sref="app.finance.invoice.invoiceGenerate">Send Invoice</a>
    </li>
   </ol>
   </div>
   <div class="panel-body float-left padding-0">
   <div class="table-responsive ">
    <table class="table table-striped b-t b-light table-hover dataTable no-footer">
     
     <div class="col-sm-10 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group form-group-label-left">
    <label for="inputPassword" class="control-label col-md-5">Invoice Date </label>
        <div class="col-md-5">
         <div class="input-group input-append date" id="invoice_date">
            <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="invoiceDet.invoiceDate" name="invoiceDate" id="invoiceDate">
            <span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
        </div>
       </div>
          
       
      
      </fieldset>
     </div>
       <div class="col-sm-10 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group form-group-label-left">
    <label for="inputPassword" class="control-label col-md-5">Customer</label>
        <div class="col-md-5">
         <selectivity list="mloList" property="invoiceDet.customer"  id="mloshortname_id" ng-model="invoiceDet.customer"  ></selectivity>
        </div>
       </div>
       
       
      
      </fieldset>
     </div>
      
      <div class="col-sm-10 col-md-5 col-lg-5">
      <fieldset>
       <div class="form-group form-group-label-left">
            <div  class="col-md-4 col-md-offset-0 control-label">
        <div class="col-md-5">
     <button class="btn btn-success" ng-click="getList(invoiceDet)"	type="submit">Search</button>
        </div>
       </div>
       </div>
      </fieldset>
     </div>
    
    
    <!--   <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
      <div class="form-group">
        <label class="col-md-5 control-label">Vessel</label>
        <div class="col-md-7">
        <select class="form-control input-sm"
		ng-model="vessel"
		ng-options="yr.id as yr.text for yr in empList"
		name="vessel" friendly-name="vessel"
		validation="required" ng-change="getList()">
		<option value="">Select</option>
	</select>
        </div>
       </div>
      </fieldset>
     </div> -->
     <tbody>
      <tr>
      <td class="width_1">Invoice No</td>
      <td class="width_1">Invoice Dt.</td>
      <td class="width_1">Cust.</td>
      <td class="width_1">Payer</td>
      <td class="width_1">Pol</td>
      <td class="width_1">Pod</td>
      <td class="width_1">BL No</td>
      <td class="width_1">Created BY</td>
      <td class="width_5">Actions</td>
     <!--  <td class="width_4">Print</td> -->
      <!-- <td class="width_1">Select <input type="checkbox" name="selectedTypes[]" ng-click="bulkSelect(displayCollection)"></td> -->
                <td class="width_1 text-center"><label class="i-checks m-b-none">
             <!--  <input type="checkbox" ng-model="objItem.checkalt"> -->
              <input type="checkbox" name="selectedTypes[]"  ng-click="bulkSelect(displayCollection)">
              <i></i>
             </label></td>

      </tr>

      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in displayCollection" >

       <td class="sorting width_5">
       <a href ="#/invoice/invoiceview/{{objItem.invoiceNumber}}">
       <span tooltip="{{objItem.invoiceNumbe}}" class="tool-tip-span font-blue"></span></a>
       {{objItem.invoiceNo}}
       </td>
       
       <td class="width_1">{{objItem.invoiceDate}}</td>
       <td class="width_1">{{objItem.mloCode}}</td>
       <td class="width_1">{{objItem.actualPayer}}</td>
       <td class="width_1">{{objItem.pol}}</td>
       <td class="width_1">{{objItem.pod}}</td>
       <td class="width_1">{{objItem.blno}}</td>
              <td class="width_1">{{objItem.createdBy}}</td>
       
	   <td>
		<select ng-model="objItem.printList" id ="printSelect{{$index}}" ng-init="objItem.printList = 'both'">
									<option value="both" >Both</option>
									<option value="usd">USD</option>
									<option value="local">Local</option>
							</select>
							&nbsp;&nbsp; <span data-ng-click="clickInvoiceFunction(objItem.invoiceNo,'both')"
								id="{{objItem.invoiceNo}}"
								class=" glyphicon glyphicon-print "
								style="cursor: pointer; color: gray;"></span></td>
							

          <td class="width_1 text-center"><label class="i-checks m-b-none">
             <!--  <input type="checkbox" ng-model="objItem.checkalt"> -->
              <input type="checkbox" name="selectedTypes[]"  ng-model="objItem.checkalt1">
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
	</div>
</div>
</div>
   <footer class="panel-footer">
    <%--  <%@include file="/views/templates/panel-footer-static.jsp"%> --%>
   </footer>
  </div>
</div>
 </div>
 