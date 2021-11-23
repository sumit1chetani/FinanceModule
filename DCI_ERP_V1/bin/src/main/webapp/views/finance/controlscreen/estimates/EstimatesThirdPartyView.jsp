<style>
.table td {
	padding: 3px !important;
}

table.dataTable thead .sorting:after {
	content: "";
}

#formDiv .input-group-addon {
	display: none !important;
}

#formDiv .form-control {
	background-color: white !important;
	border: 0px !important;
}

#formDiv .b-grey {
	border: 0px !important;
}

#formDiv .form-label-control {
	line-height: 35px;
}

#formDiv .toggleBlock-currsor {
	cursor: pointer;
}
 
 .ngdialog-overlay{
 
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
     max-width: 100%;
    width: 75%;
    position: absolute;
    top: 20%;
    left: 7%;
    margin: 0 auto;
}
.bootstrap-datetimepicker-widget{
 z-index:10000 !important;
 }
</style>
<div class="wrapper-md">
 <!--  <div class="panel panel-default panel-default-form">
 -->
 <!-- <div class="panel-heading panel-heading-form font-bold"> -->
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <!-- <ol class="breadcrumb inline-block padding-left-10">
    <li><a>Finance</a></li>
    <li><a>Control Screen</a></li>
    <li><a x-ui-sref="#">Estimates</a>
    </li>
   </ol> -->
  <!-- </div> -->
  <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body" id="formDiv">
   <section widget-grid id="widget-grid">
    <div class="row">
     <article class="col-sm-12">
      <div class="panel-body">
       <form class="form-horizontal" name="estimatesForm" novalidate>
        <div class="row">
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold"> Company </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.companyName}}</label> <input ng-hide="true" type="text" class="form-control input-sm"
               data-ng-model="estimates.companyCode" />
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Vessel </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.vesselName}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Voyage </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.voyageId}}</label>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Service</label>
             <div class="col-md-6">
              <!-- <input type="text" class="form-control input-sm"
                                                   data-ng-model="estimates.sectorName" /> -->
              <label class="col-md-4 form-control b-none" ng-bind="estimates.sectorName"></label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Activity </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.activity}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Vessel Operator </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.vesselOperator}}</label>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Currency </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.currencyCode}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Exchange Rate </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.exchangeRate}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Entry Date </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.entryDate}}</label>
              <div class="input-group input-append date" id="tb_entryDate" ng-hide="true">
               <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="estimates.entryDate" name="entryDate" id="entryDate"> <span
                class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
               </span>
              </div>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Expected RV Days </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.expectedRvDays}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Actual RV Days </label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.actualRvDays}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-4 control-label bold">Remarks</label>
             <div class="col-md-5">
              <label class="col-md-1 control-label text-nowrap">{{estimates.remarks}}</label>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
         
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Voyage Start Date</label>
             <div class="col-md-7">
              <label  class="control-label col-md-8">{{estimates.voyCommenceDt}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Voyage End Date</label>
             <div class="col-md-7">
              <label  class="control-label col-md-8">{{estimates.voyCompletionDt}}</label>
             </div>
            </div>
           </div>
           
          </fieldset>
         </div>
        </div>
        <div class="row">
         <div class="col-lg-9 div-center">
          <!-- <table class="table table-striped b-t b-light">
           <thead>
            <tr>
             <th colspan=4 class="text-center">Charter Cost</th>
            </tr>
           </thead>
           <tbody>
            <tr>
             <td class="width_20">Charter Hire Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.charterHireCost}}</label>
              </div>
             </td>
             <td class="width_20">Charter Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
                 <label class="col-md-1 control-label text-nowrap" >{{estimates.charterRemarks}}</label>
              </div>
             </td>
            </tr>
           </tbody>
           <thead>
            <tr>
             <th colspan=4 class="text-center">Bunker Cost Total ({{bunkerCostTotal | number:2}})</th>
            </tr>
           </thead>
           <tbody>
            <tr>
             <td class="width_20">Fuel Oil Cost</td>
             <td class="width_30">
              <div class="col-xs-6">              
                <label class="col-md-1 control-label text-nowrap" >{{estimates.fuelOilCost}}</label>
              </div>
             </td>
             <td class="width_20">Fuel Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.fuelRemarks}}</label>
              </div>
             </td>
            </tr>
            <tr>
             <td class="width_20">Gas Oil Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.gasOilCost}}</label>
              </div>
             </td>
             <td class="width_20">Gas Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.gastOilRemarks}}</label>
              </div>
             </td>
            </tr>
            <tr>
             <td class="width_20">Port Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.portCost}}</label>
              </div>
             </td>
             <td class="width_20">Port Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.portRemarks}}</label>
              </div>
             </td>
            </tr>
            <tr>
             <td class="width_20">Agency Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.agencyCost}}</label>
              </div>
             </td>
             <td class="width_20">Agency Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <label class="col-md-1 control-label text-nowrap" >{{estimates.agencyRemarks}}</label>
              </div>
             </td>
            </tr>
            </tbody>
          </table>  
          -->
          <div class="table-responsive clear  div-center" ng-if="estimates.activity=='JV SLOT PURCHASE ACTIVITY' || estimates.activity=='SLOT PURCHASE OPERATIONS'">
        
          <table class="table table-striped b-t b-light toggleBlock-currsor" >
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.slotcostcheckap" ng-click="slotCostApCheckAll()"></th>
             <!-- <th class="width_5">JV Posting<input type="checkbox" ng-model="estimates.slotcostcheck"></th> -->
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('slotBlock')">POL</th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('slotBlock')">POD</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('slotBlock')">Slot Cost Total ({{slotCostTotal | number:2}})</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('slotBlock')">Remarks</th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="slotBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.slotCostList" ng-controller="tableCtrl">
             <tr>
              <td classs="width_5"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
              <td class="width_18">
               <div class="col-xs-6">
                <label class="col-md-1 control-label text-nowrap">{{row.port}}</label>
               </div>
              </td>
              <td class="width_20">
               <div class="col-xs-6">
                <label class="col-md-1 control-label text-nowrap">{{row.pod}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-6">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" readonly="readonly" />
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-8">
                <!-- <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea> -->
                <label class="col-md-1 control-label text-nowrap">{{row.otherRemarks}}</label>
               </div>
              </td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{row.approvedDt}}</label>
              </td>
             </tr>
            </tbody>
           </table>
          </div>
          </div>
          <table class="table table-striped b-t b-light toggleBlock-currsor" >
           <thead>
            <tr>
            <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.agentcostcheckap" ng-click="agencyCostApCheckAll()">
             </th>
             <!-- <th class="width_5">JV Posting<input type="checkbox" ng-model="estimates.agentcostcheck">
             </th> -->
             <th colspan=1 class="width_20 text-center" ng-click="toggleBlock('agencyBlock')">Port</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('agencyBlock')">Agency Cost Total ({{agentCostTotal | number:2}})</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('agencyBlock')">Remarks</th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="agencyBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.agencyCostList" ng-controller="tableCtrl">
             <tr>
             <td classs="width_5"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
              <td class="width_34">
               <div class="col-xs-6">
                <label class="col-md-1 control-label text-nowrap">{{row.port}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-6">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" readonly="readonly" />
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-8">
                <label class="col-md-1 control-label text-nowrap">{{row.otherRemarks}}</label>
                <!-- <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea> -->
               </div>
              </td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{row.approvedDt}}</label>
              </td>
             </tr>
            </tbody>
           </table>
          </div>
          <!--  
          <table class="table table-striped b-t b-light">
           <thead>
            <tr>             
             <th colspan=1 class="width_13 text-center">Insurance</th>        
             <th colspan=1 class="width_10 text-center">Insurance Cost Total ({{insuranceCostTotal | number:2}})</th>
             <th colspan=1 class="width_13 text-center">Remarks</th>
            </tr>
           </thead>
           <tbody ng-repeat="(trIndex, row) in estimates.insuranceCostList" ng-controller="tableCtrl">
            <tr>             
             <td class="width_30">
              <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="row.port" />
               <label class="col-md-1 control-label text-nowrap" >{{row.costType}}</label>
              </div>
             </td>
             <td class="width_30">
           <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" readonly="readonly"/>
              </div>
             </td>
             <td class="width_30">
              <div class="col-xs-8">
              <label class="col-md-1 control-label text-nowrap" >{{row.otherRemarks}}</label>
               <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
              </div>
             </td>
           
            </tr>
           </tbody>
          </table>
         -->
         </div>
         <div class="table-responsive clear col-lg-11 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor" >
           <thead>
            <tr>
            <th class="width_5">Actual Posting<input type="checkbox" ng-model="otherAccountCheckAllAp" ng-click="otherCostApCheckAll()"></th>
             <!-- <th class="width_5">JV Posting<input type="checkbox" ng-model="otherAccountCheckAllJv" ng-click="otherCostJvCheckAll()"></th> -->
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Dr.Account<span style="color: red;">*</span></th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Dr.Sub Account</th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Cr.Account<span style="color: red;">*</span></th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Cr.Sub Account</th>
             <th colspan=1 class=" width_8 text-center" ng-click="toggleBlock('otherBlock')">POL<span style="color: red;">*</span></th>
             <th colspan=1 class=" width_8 text-center" ng-click="toggleBlock('otherBlock')">POD</th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('otherBlock')">Other Cost Total ({{otherCostTotal | number:2}})</th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Other Remarks</th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="otherBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.otherCostList" ng-controller="tableCtrl">
             <tr>
              <td classs="width_5" style="padding-right: 7% !important;"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
              <!-- <td classs="width_5" style="padding-right: 7% !important;"><input type="checkbox" ng-model="row.otheraccountcheck"></td> -->
              <td class="width_13"><label class=" control-label text-left" >{{row.accountHeadName}}</label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.drSubAccountCode}}</label></td>
              <td class="width_13"><label class=" control-label text-left">{{row.crAccountHeadName}}</label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.crSubAccountCode}}</label></td>
              <td class="width_8"><label class=" control-label text-left text-nowrap">{{row.port}}</label></td>
              <td class="width_8"><label class=" control-label text-left text-nowrap">{{row.pod}}</label></td>
              <td class="width_10"><label class=" control-label text-left text-nowrap">{{row.bcAmount}}</label></td>
              <td class="width_13"><label class=" control-label text-left ">{{row.otherRemarks}}</label></td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{row.approvedDt}}</label>
              </td>
              <!-- <td>
                    <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency{{trIndex}}"
                         validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly>
                          <selectivity list="currencyList" ng-model="row.currency" property="row.currency" id="currency{{trIndex}}" object="currency"
                          validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" name="{{ 'Row' + $index + '(Currency)'}}" form-name = "lpoForm" ></selectivity>
                    </div>
                   </div>
                  </td>
                  <td> <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
                         name="exchangeRate{{trIndex}}"  ng-keyup ="calculateExchangeRateOnDtlTbl(row.exchangeRate,trIndex,row)"
                         validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}">
                    </div>
                   </div>
                  </td> -->
              <!-- <td> <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="tcAmount{{trIndex}}" ng-model="row.tcAmount"  name="tcAmount{{trIndex}}"
                         ng-keyup="amountCalculationTCTable(row.tcAmount,trIndex,row)"
                         validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="{{ 'Row' + $index + '(TC Amount)'}}">
                    </div>
                   </div>
                  </td> -->
              <!-- <td class="width_10">
              <div class="row">
               <div class="col-xs-12">
                <input type="text" class="form-control input-sm" id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}" readonly="readonly"
                 ng-keyup="amountCalculationBCTable(row.bcAmount,trIndex,row)" validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
                 friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
               </div>
              </div>
             </td>
             <td class="width_13">
              <div class="row">
               <div class="col-xs-12">
                <input type="text" class="form-control input-sm" id="otherRemarks{{trIndex}}" ng-model="row.otherRemarks" name="otherRemarks{{trIndex}}" readonly="readonly">
               </div>
              </div>
             </td> -->
             </tr>
            </tbody>
           </table>
           <!-- <div class="padding-right-5">
           <div class="col-md-4">
            <button ng-click="addRow(estimates.otherCostList)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
             <i class="fa fa-plus"></i>
            </button>
            <button ng-click="removeRow(estimates.otherCostList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
             <i class="fa  fa-trash-o"></i>
            </button>
           </div>
          </div> -->
          </div>
         </div>
         <div class="padding-right-5 col-md-10 pull-right">
          <div class="form-group">
           <label class="col-md-4 control-label bold">Total</label>
           <div class="col-md-2">
            <input type="text" class="form-control input-sm text-right" data-ng-model="estimatesTotal" readonly="readonly" />
           </div>
          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12 text-center">
              <!-- <button ng-model="approve" class="btn btn-info"  
               class="btn btn-info" ng-click="excel()">
               <i class="fa fa-excel"></i>
                Jv Cost Excel Export
              </button>    -->
           <button ng-model="approve" class="btn btn-success" ng-if="operation=='approve'" class="btn btn-success" ng-click="openDatePopup('','approve')">
            <i class="fa fa-save"></i> Approve
           </button>
                          <!-- <button ng-model="approve" class="btn btn-success"  ng-if="estimates.activity!='OWN OPERATING SHIPS'"
               class="btn btn-success" ng-click="openDatePopup('Approve','jvpost')">
               <i class="fa fa-save"></i>
                JV Cost Account Posting
              </button>  -->
           <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
            <i class="fa fa-close"></i> Cancel
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
     </article>
    </div>
   </section>
  </div>
 </div>
</div>

 <script type="text/ng-template" id="estimateacctpostingThirdParty">  
 
<div class="wrapper-md">
  <div class="panel-body float-left padding-0">
    <div class="row">
    <div class="col-sm-12 col-md-12 col-lg-12 ">
     <fieldset>
      <legend>JV Date </legend>
      <div class="form-group">
             <label class="col-md-2 control-label line-height-30">JV Date<span style="color:red;"> *</span></label>
             <div class="col-md-3">
                <div class="input-group input-append date" id="estimate_approve_Date">
                 <input type="text" class="form-control input-sm" name="approvedDt" id="approvedDt"
                 ng-model="estimates.jvDate" placeholder='dd/mm/yyyy' />
                 <span class="input-group-addon add-on">
                   <span class="glyphicon glyphicon-calendar"></span>
                 </span>
              </div>
             </div>
          </div>
        
     </fieldset>
    </div>
   </div>
   <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12">        
          <div class="form-actions m-b-none">          
            <button class="btn btn-info" type="button" ng-click="confirm()">OK</button>
      <button class="btn btn-danger" ng-click="closePopup()">Cancel</button>           
          </div>
        </div>
       </div>
  </div>
 </div>
  </script>