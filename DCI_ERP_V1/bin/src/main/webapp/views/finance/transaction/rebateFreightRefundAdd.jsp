<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="vesselInformationForm" novalidate>
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <fieldset>
      
       <div class="form-group">
        <label class="col-md-3 control-label">Customer <span style="color: red;">*</span>
        </label>
        <div class="col-md-3">
         <selectivity list="customerList" property="RebateFreightRefund.customerCode" id="customerCode" object="tempDropDownObj"></selectivity>
        </div>
       </div>
       
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-12 col-lg-12">
      <fieldset>
     <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
        <div class="form-group">
        <label class="col-md-12 control-label">Period of Rebate </label>
       </div>
        <div class="form-group">
        <label class="col-md-12 control-label">Slabs Based On</label>
       </div>
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-5">From Date <span style="color: red;">*</span>
        </label>
        <div class="col-md-7">
         <div class="input-group input-append date" id="tb_fromDate">
          <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="RebateFreightRefund.fromDate" name="fromDate" id="fromDate"> <span
           class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div>
        </div>
       </div>
        <div class="form-group" >
         <div class="checkbox col-sm-12 col-md-4 col-lg-4">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked"  validation="required" id="slabVolume" value="N"
            name="slabVolume" ng-model="RebateFreightRefund.slabVolume"  friendly-name="Slab Volume">
           <i></i>Volume
          </label>
         </div>
          <div class="checkbox col-sm-12 col-md-4 col-lg-4">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked"  validation="required" id="slabRevenue" value="N"
            name="slabRevenue" ng-model="RebateFreightRefund.slabRevenue"  friendly-name="Slab Revenue">
           <i></i>Revenue
          </label>
         </div>
          <div class="checkbox col-sm-12 col-md-4 col-lg-4">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked"  validation="required" id="slabPeriod" value="N"
            name="slabPeriod" ng-model="RebateFreightRefund.slabPeriod"  friendly-name="Slab Period">
           <i></i>Period
          </label>
         </div>
         </div>
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-5">To Date </label>
        <div class="col-md-7">
         <div class="input-group input-append date" id="tb_toDate">
          <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="RebateFreightRefund.toDate" name="toDate" id="toDate"> <span
           class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div>
        </div>
       </div>
      </fieldset>
     </div>
     </fieldset>
     </div>
    </div>
    
    <div class="col-sm-12 col-md-12 col-lg-12">
     <table class="table table-striped b-t b-light">
      <thead>
       <tr>
        <th colspan=1 class="width_05"></th>
          <th colspan=1 class="width_10 text-center">From</th>
        <th colspan=1 class="width_10 text-center">To</th>
        <th colspan=1 class="width_10 text-center">Value</th>
        <th colspan=1 class="width_10 text-center">Currency</th>
        <th colspan=1 class="width_10 text-center">Percentage</th>
       </tr>
      </thead>
      <tbody ng-repeat="(trIndex, row) in RebateFreightRefund.slabsVolumeBasedList">
       <tr>
        <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm" name="from{{trIndex}}" data-ng-model="row.from" required />
          </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm" name="to{{trIndex}}" data-ng-model="row.to" required />
          </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm" name="value{{trIndex}}" data-ng-model="row.value" required />
          </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
            <selectivity  list="currencyList" property="row.currencyCode" id="currencyCode"  object="tempDropDownObj"></selectivity>
          </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm" name="percentage{{trIndex}}" data-ng-model="row.percentage" required />
          </div>
         </div>
        </td>
       </tr>
      </tbody>
     </table>
     <div class="padding-right-5 ">
      <div class="col-xs-4">
       <button ng-click="addRow(RebateFreightRefund.slabsVolumeBasedList)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
        <i class="fa fa-plus"></i>
       </button>
       <button ng-click="removeRow(RebateFreightRefund.slabsVolumeBasedList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
        <i class="fa  fa-trash-o"></i>
       </button>
      </div>
     </div>
     <!-- /padding-right-5 - /AddOrRmvebtn -->
    </div>
    <br>
    <br>
    
    <div class="">
     <table class="table table-striped b-t b-light">
      <thead>
       <tr>
        <th colspan=1 class="width_05"></th>
        <th colspan=1 class="width_10 text-center">From Date</th>
        <th colspan=1 class="width_10 text-center">To Date</th>
        <th colspan=1 class="width_10 text-center">Value</th>
        <th colspan=1 class="width_10 text-center">Currency</th>
        <th colspan=1 class="width_10 text-center">Percentage</th>
       </tr>
      </thead>
     
      <tbody ng-repeat="(trIndex, row) in RebateFreightRefund.slabsBasedPeriodList">
       <tr>
        <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
        <td class="width_10">
         <div class="row">
         <div class="input-group input-append date" id="tb_from{{trIndex}}">
          <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="row.from" name="from{{trIndex}}" id="from{{trIndex}}"> <span
           class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="input-group input-append date" id="tb_to{{trIndex}}">
          <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="row.to" name="to{{trIndex}}" id="to{{trIndex}}"> <span
           class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm" name="value{{trIndex}}" data-ng-model="row.value"  />
          </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <selectivity  list="currencyList" property="row.currencyCode" id="currencyCode"  object="tempDropDownObj"></selectivity>
          </div>
         </div>
        </td>
        <td class="width_10">
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm" name="percentage{{trIndex}}" data-ng-model="row.percentage"  />
          </div>
         </div>
        </td>
       </tr>
      </tbody>
     </table>
     <div class="padding-right-5">
      <div class="col-xs-4">
       <button ng-click="addRow1(RebateFreightRefund.slabsBasedPeriodList)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
        <i class="fa fa-plus"></i>
       </button>
       <button ng-click="removeRow1(RebateFreightRefund.slabsBasedPeriodList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
        <i class="fa  fa-trash-o"></i>
       </button>
      </div>
     </div>
     <!-- /padding-right-5 - /AddOrRmvebtn -->
    </div>
    
    <div class="col-sm-12 col-md-12 col-lg-12">
    <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
        <div class="form-group">
        <label class="col-md-12 control-label">Exceptions </label>
       </div>
       <div class="form-group">
        <label class="col-md-12 control-label">Ports Excluded</label>
       </div>
       <div class="form-group">
        <label class="col-md-12 control-label">Invoices Excluded </label>
       </div>
       <div class="form-group">
        <label class="col-md-12 control-label">One Off Rate</label>
       </div>
       <div class="form-group">
        <label class="col-md-12 control-label">One Off Sailings</label>
       </div>
       <div class="form-group">
        <label class="col-md-12 control-label">Rebate Approved</label>
       </div>
       <div class="form-group">
        <label class="col-md-12 control-label">Remarks</label>
       </div>
       
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-6 col-lg-6">
      <fieldset>
       
        <div class="form-group" >
         <div class="checkbox col-sm-12 col-md-4 col-lg-4">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked"  validation="required" id="exceptionPortsExcluded"
            name="exceptionPortsExcluded" ng-model="RebateFreightRefund.exceptionPortsExcluded"  friendly-name="Exception Ports Excluded">
           <i></i>Ports Excluded 
          </label>
         </div>
          <div class="checkbox col-sm-12 col-md-4 col-lg-4">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked"  validation="required" id="exceptionInvoicesExcluded"
            name="exceptionInvoicesExcluded" ng-model="RebateFreightRefund.exceptionInvoicesExcluded"  friendly-name="Exception Invoices Excluded">
           <i></i>Invoices Excluded
          </label>
         </div>
          <div class="checkbox col-sm-12 col-md-4 col-lg-4">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked"  validation="required" id="exceptionOthers"
            name="exceptionOthers" ng-model="RebateFreightRefund.exceptionOthers"  friendly-name="Exception Others">
           <i></i>Others
          </label>
         </div>
         </div>
          <div class="form-group">        
           <div class="col-md-6">
            <selectivity list="portList" property="RebateFreightRefund.portsExcluded" id="portsExcluded" object="tempDropDownObj"></selectivity>
           </div>
          </div>
           <div class="form-group">        
           <div class="col-md-6">
            <selectivity list="invoiceList" property="RebateFreightRefund.invoicesExcluded" id="invoicesExcluded" object="tempDropDownObj"></selectivity>
           </div>
         </div>
         <div class="form-group">        
           <div class="col-md-6">
            <selectivity list="voyageList" property="RebateFreightRefund.oneOffSailings" id="oneOffSailings" object="tempDropDownObj"></selectivity>
           </div>
         </div>
         <div class="form-group">        
           <div class="col-md-6">
            <selectivity list="quotationList" property="RebateFreightRefund.oneOffRate" id="oneOffRate" object="tempDropDownObj"></selectivity>
           </div>
         </div>
         <div class="col-md-12">
         <div class="radio radio-inline" style="padding-left: 0px;">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0"  name="rebateApproved" ng_model="RebateFreightRefund.rebateApproved" value="Y">
           <i></i>
           Approved
          </label>
         </div>
         <div class="radio  radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" name="rebateApproved" ng_model="RebateFreightRefund.rebateApproved" value="N" checked="checked"
            name="gear">
           <i></i>
           Not Approved
          </label>
         </div>
        </div>
         <div class="form-group">   
        <div class="col-md-6">
                   <textarea data-ng-model="RebateFreightRefund.address" id="remarks"  name="remarks" 
            class="custom-scroll width_100 textareath" rows="2"  friendly-name="Remarks"    >
            </textarea>
           </div>
           </div>
      </fieldset>
     </div>
     </div>
    <br>
    <div class="col-sm-12 col-md-12 col-lg-12">
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" type="button" ng-if="isEdit=='false'" ng-click="submit(disbursementAccountForm)" ng-if="!RebateFreightRefund.edit">
        <i class="fa fa-plus"></i> Save
       </button>
       <button class="btn btn-primary" type="reset" ng-if="isEdit=='false'">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button class="btn btn-success" type="button" ng-if="isEdit=='true'" ng-click="submit(disbursementAccountForm)">
        <i class="fa fa-save"></i> Update
       </button>
       <button class="btn btn-danger" type="button" ng-click="cancel()">
        <i class="fa fa-close"></i> Cancel
       </button>
      </div>
     </div>
    </div>
    </div>
   </form>
  </div>
 </div>
</div>
