<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<section data-widget-grid id="widget-grid">
 <div class="padding-top-10">
  <article class="col-sm-12">
   <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
    <header>
     <span class="widget-icon">
      <i class="fa fa-table"></i>
     </span>
     <span>
      <state-breadcrumbs></state-breadcrumbs>
     </span>
    </header>
    <div role="content">
     <div class="widget-body">
      <form class="form-horizontal" name="requestEditForm" role="form" novalidate>
       <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12">
         <div class="padding-left-5" id="jqgrid">
          <div id="inventGrid">
           <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer ui-jqgrid" role="grid" aria-describedby="dt_basic_info">
            <thead class="dataTables-Main-Head">
             <tr>
              <th class="sorting sorting-no text-center"></th>
              <th class="sorting sorting-no text-center">Item Code</th>
              <th class="sorting sorting-no text-center">Item Name</th>
              <th class="sorting sorting-no text-center">Location</th>
              <th class="sorting sorting-no text-center">Requested Quantity</th>
              <th class="sorting sorting-no text-center">Required Quantity</th>
             </tr>
            </thead>
            <tbody class="dataTables-Main-Body" data-ng-repeat="rfqItemBean in lRFQItemBean">
             <tr>
              <td class="text-center">
               <span class="fa" data-ng-class="{'fa-plus-circle':showId!=$index,'fa-minus-circle':showId==$index}"
                data-ng-click="changeIndexValue($index,rfqItemBean.purchaseRequsitionNumber)"></span>
              </td>
              <td class="text-center">{{rfqItemBean.itemCode}}</td>
              <td class="text-center">{{rfqItemBean.itemName}}</td>
              <td class="text-center">{{rfqItemBean.stateName}}</td>
              <td class="text-center">{{rfqItemBean.qty}}</td>
              <td class="text-center">
               <input type="number" class="text-right" data-ng-model="rfqItemBean.qtyReq" validation="required,integer"
                name="Required Quantity" friendly-name="Required Quantity" />
              </td>
             </tr>
             <tr data-ng-show="showId==$index">
              <td colspan="7">
               <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
                <thead class="dataTables-Main-Head">
                 <tr>
                  <th class="sorting sorting-no text-center">Purchase Requisition No</th>
                  <th class="sorting sorting-no text-center">Requisition Date</th>
                  <th class="sorting sorting-no text-center">Location</th>
                  <th class="sorting sorting-no text-center">Quantity</th>
                 </tr>
                </thead>
                <tbody class="dataTables-Main-Body" data-ng-repeat="rfqItemSubBean in lRFQItemSubBean">
                 <tr>
                  <td class="text-center">{{rfqItemSubBean.requsitionNumber}}</td>
                  <td class="text-center">{{rfqItemSubBean.date}}</td>
                  <td class="text-center">{{rfqItemSubBean.locName}}</td>
                  <td class="text-center">{{rfqItemSubBean.quantity}}</td>
                 </tr>
                </tbody>
               </table>
              </td>
             </tr>
            </tbody>
           </table>
          </div>
         </div>
        </div>
       </div>
       <br>
       <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12">
         <table class="table table-striped table-bordered table-hover dataTable no-footer ui-jqgrid" data-ng-show="lRFQItemVendorBean.length>0">
          <thead class="dataTables-Main-Head">
           <tr>
            <th class="sorting sorting-no text-center">
             <input role="checkbox" type="checkbox" class="cbox" name="status" data-ng-model="vendorStatus" data-ng-change="changeVendorStatus()">
            </th>
            <th class="sorting sorting-no text-center">Vendor Code</th>
            <th class="sorting sorting-no text-center">Vendor Name</th>
            <th class="sorting sorting-no text-center">Vendor Mobile</th>
            <th class="sorting sorting-no text-center">Vendor Email</th>
           </tr>
          </thead>
          <tbody class="dataTables-Main-Body">
           <tr data-ng-repeat="rfqItemVendorBean in lRFQItemVendorBean" data-ng-class="$index % 2 == 0? 'even' : 'odd'">
            <td class="text-center">
             <input role="checkbox" type="checkbox" class="cbox" name="status" data-ng-model="rfqItemVendorBean.status" data-ng-change="setVendorStatus()">
            </td>
            <td class="text-center">{{rfqItemVendorBean.vendorCode}}</td>
            <td class="text-center">{{rfqItemVendorBean.vendorName}}</td>
            <td class="text-center">{{rfqItemVendorBean.mobile}}</td>
            <td class="text-center">{{rfqItemVendorBean.email}}</td>
           </tr>
           <tr>
            <td class="text-center" colspan="5" data-ng-show="lRFQItemVendorBean.length==0">lRFQItemVendorBean</td>
           </tr>
          </tbody>
         </table>
         <table class="table table-striped table-bordered table-hover dataTable no-footer ui-jqgrid" data-ng-show="lRFQItemVendorBean.length==0">
          <thead class="dataTables-Main-Head">
           <tr>
            <th class="sorting sorting-no text-center">Vendor Not Found</th>
           </tr>
          </thead>
         </table>
        </div>
       </div>
       <div class="form-actions">
        <div class="row">
         <div class="col-lg-12 col-md-12">
          <button class="btn btn-primary" type="save" data-ng-click="saveRfq('N')" data-ng-disabled="saveDisabled">
           <i class="fa fa-save"></i>
           <spring:message code="label.save"></spring:message>
          </button>
          <button class="btn btn-primary" type="button" data-ng-click="saveRfq('Y')" data-ng-disabled="saveDisabled">Save and Send Mail</button>
          <button class="btn btn-primary" type="back" data-ng-click="back()">Back</button>
         </div>
        </div>
       </div>
      </form>
     </div>
    </div>
   </div>
  </article>
 </div>
</section>
