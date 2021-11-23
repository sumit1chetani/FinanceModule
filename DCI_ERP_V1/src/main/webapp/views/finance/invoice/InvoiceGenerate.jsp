<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <!-- <div class="panel-heading panel-heading-form font-bold">	
 <ol class="breadcrumb inline-block padding-left-10">
    <li>
     <a x-ui-sref="app.finance">Finance</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.invoice">Invoice</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.invoice.invoiceGenerate">Invoice Generate</a>
    </li>
   </ol> -->
 </div>
 <div class="panel body">
  <form class="form-horizontal" name="invoiceGenerateForm" role="form" ng-submit="invoiceGenerateForm(invoiceGenerateForm,invoiceGenerateData)" novalidate>
   <div class="row book-widget-row">
    <br />
    <div class="col-sm-12 col-md-5 ol-lg-4">
     <fieldset>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Vessel</label>
       <div class="col-md-6">
        <selectivity list="vesselList" property="invoiceGenerateData.vesselCode" id="vessel_code"></selectivity>
       </div>
      </div>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Voyage</label>
       <div class="col-md-6">
        <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity list="voyageList" property="invoiceGenerateData.voyageId" id="voyage_id"></selectivity>
        </div>
       </div>
      </div>
      <div class="form-group form-group-label-left">
       <div class="row">
        <fieldset>
         <label class="col-md-5 control-label">POL</label>
         <div class="col-md-2" style="width: 19.66% !important" class="selectivity-input example-input selectivity-slot voyage_sel">
          <selectivity list="polList" property="invoiceGenerateData.pol" id="POL"></selectivity>
         </div>
         <label class="col-md-1 control-label">POD</label>
         <div class="col-md-2" style="width: 19.66% !important">
          <selectivity list="podList" property="invoiceGenerateData.pod" id="POD"></selectivity>
         </div>
        </fieldset>
       </div>
      </div>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Slot A/C</label>
       <div class="col-md-6">
        <div id="slot_select" class="selectivity-input example-input selectivity-slot slot_sel">
         <selectivity list="slotList" property="invoiceGenerateData.slot" id="mlo_short_name"></selectivity>
        </div>
       </div>
      </div>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Customer</label>
       <div class="col-md-6">
        <selectivity list="customerList" property="invoiceGenerateData.customer" id="mlo_short_name"></selectivity>
       </div>
      </div>
     </fieldset>
    </div>
    <div class="col-sm-12 col-md-5 ol-lg-4">
     <fieldset>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Company</label> <input type="text" ng-model="company" disabled="disabled"
        class="col-md-6 control-label text-left " />
       <!-- <label class="  control-label">{{company}} </label> -->
      </div>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Service</label> <input type="text" ng-model="service" disabled="disabled"
        class="col-md-6 control-label text-left " />
       <!-- <label class="  control-label">{{service}}</label> -->
      </div>
      <div class="form-group form-group-label-left">
       <label class="col-md-4 col-md-offset-1 control-label ">Activity</label> <input type="text" ng-model="activity" disabled="disabled"
        class="col-md-6 control-label text-left " />
       <!-- <label class="  control-label">{{activity}}</label> -->
      </div>
     </fieldset>
    </div>
   </div>
   <div class="form-actions">
    <div class="row">
     <div class="col-md-12">
      <div class="col-md-1">
       <span class="padding-left-10"> <a class="btn btn-success btn-sm" data-ng-click="helpVideo('Invoice_Generate','Invoice Generate Help')">Help video</a>
       </span>
      </div>
      <security:authorize access="hasRole('${form_code}_${view}')">
       <button class="btn btn-success" type="submit" ng-click="view(invoiceGenerateData)">Submit</button>
       <button class="btn btn-success" type="submit" ng-click="Bulkview(invoiceGenerateData)">Bulk Mail</button>
      </security:authorize>
      <button class="btn btn-info" type="button" ng-click="reset()">
       <i class="fa fa-undo"></i> Reset
      </button>
     </div>
    </div>
   </div>
  </form>
 </div>
 <div class="col-md-12">
  <div class="col-md-6" style="font-size: 14px; padding: 0; color: red;">
   <span>*Bulk Mail button using for sending bulk invoices of selected voyage!</span><br>
  </div>
 </div>
</div>
</div>