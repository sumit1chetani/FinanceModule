<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
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
  <div class="panel-body">
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
             <label class="col-md-5 control-label bold">Company</label>
             <div class="col-md-7">
              <selectivity list="companyList" property="estimates.companyCode" id="companyCode"></selectivity>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Vessel</label>
             <div class="col-md-7">
              <!-- <selectivity list="vesselList" property="estimates.vesselCode" id="vesselCode" ></selectivity> -->
              <label class="col-md-4 form-control b-none" ng-bind="estimates.vesselName"></label> 
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Voyage</label>
             <div class="col-md-7">
              <!-- <selectivity list="voyageList" property="estimates.voyageId" id="voyage_id" ></selectivity> -->
              <label class="col-md-4 form-control b-none" ng-bind="estimates.voyageId"></label>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Service</label>
             <div class="col-md-7">
              <!-- <input type="text" class="form-control input-sm"
                                                   data-ng-model="estimates.sectorName" /> -->
              <label class="col-md-4 form-control b-none" ng-bind="estimates.sectorName"></label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Activity</label></label>
             <div class="col-md-7">
              <label class="control-label">{{estimates.activity}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Vessel Operator</label></label>
             <div class="col-md-7">
              <label class="control-label col-md-4">{{estimates.vesselOperator}}</label>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-lg-12">
          <fieldset>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Currency</label></label>
             <div class="col-md-7">
              <!-- <selectivity class="disableable" list="currencyList" property="estimates.currencyCode" id="currency_id"  ></selectivity> -->
              <label class="col-md-4 form-control b-none" ng-bind="estimates.currencyCode"></label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Exchange Rate</label></label>
             <div class="col-md-7">
              <label class="control-label col-md-4">{{estimates.exchangeRate}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="control-label col-md-5 bold">Entry Date <span style="color: red;">*</span>
             </label>
             <div class="col-md-7">
              <div class="input-group input-append date" id="tb_entryDate">
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
             <label class="col-md-5 control-label bold">Expected RV Days</label>
             <div class="col-md-7">
              <input type="text" class="form-control input-sm" data-ng-model="estimates.expectedRvDays" />
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Actual RV Days</label>
             <div class="col-md-7">
              <input type="text" class="form-control input-sm" data-ng-model="estimates.actualRvDays" />
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Remarks</label>
             <div class="col-md-7">
              <textarea class="form-control input-sm" style="width: 200px;" data-ng-model="estimates.remarks"></textarea>
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
              <label class="control-label col-md-8">{{estimates.voyCommenceDt}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Voyage End Date</label>
             <div class="col-md-7">
              <label class="control-label col-md-8">{{estimates.voyCompletionDt}}</label>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
        </div>
        <div class="row">
         <div class="col-lg-9 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor">
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.chartercostcheckap" /></th>
             <th class="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'">JV Posting<input type="checkbox" ng-model="estimates.chartercostcheck"></th>
             <th class="width_10 text-center"></th>
             <th colspan=3 class="text-center" ng-click="toggleBlock('charterBlock')">Charter Hire Cost Total ({{charterHireCost | number:2}})</th>
             <th class="width_30"></th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="charterBlock">
           <table class="table table-striped b-t b-light">
            <tbody>
             <tr>
              <td class="width_20">Charter Hire Cost</td>
              <td class="width_30">
               <!--  <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="estimates.charterHireCost" ng-keyup="totalCal('charter','')"/>
              </div> -->
               <div class="col-xs-6" ng-if="estimates.jvNoCH==null || estimates.jvNoCH==''">
                <input type="text" class="form-control input-sm" data-ng-model="estimates.charterHireCost" ng-keyup="totalCal('','all')" ng-disabled="isdisabled" />
               </div>
               <div class="col-xs-6" ng-if="estimates.jvNoCH!=null && estimates.jvNoCH!=''">
                <label class="col-md-1 control-label text-nowrap">{{estimates.charterHireCost}}</label>
               </div>
              </td>
              <td class="width_20">Charter Remarks</td>
              <td class="width_30">
               <!-- <div class="col-xs-8">
               <textarea type="text" class="form-control input-sm" data-ng-model="estimates.charterRemarks"></textarea>
              </div> -->
               <div class="col-xs-10" ng-if="estimates.jvNoCH==null || estimates.jvNoCH==''">
                <textarea type="text" class="form-control input-sm" data-ng-model="estimates.charterRemarks"></textarea>
               </div>
               <div class="col-xs-10" ng-if="estimates.jvNoCH!=null && estimates.jvNoCH!=''">
                <label class="col-md-1 control-label text-nowrap">{{estimates.charterRemarks}}</label>
               </div>
              </td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{estimates.chApprovedDt}}</label>
			  </td>
             </tr>
            </tbody>
           </table>
          </div>
          <table class="table table-striped b-t b-light toggleBlock-currsor">
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.bunkercostcheckap" ng-click="bunkercostcheckapCheckAll()"></th>
             <th class="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'">JV Posting<input type="checkbox" ng-model="estimates.bunkercostcheck"></th>
             <th class="width_10 text-center"></th>
             <th colspan=3 class="text-center" ng-click="toggleBlock('bunkerBlock')">Bunker Cost Total ({{bunkerCostTotal | number:2}})</th>
             <th class="width_30"></th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="bunkerBlock">
           <table class="table table-striped b-t b-light">
            <tbody>
             <tr>
              <td class="width_20"><input type="checkbox" ng-model="estimates.fuelOilCostcheckap"> Fuel Oil Cost</td>
              <td class="width_30">
               <!--  <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="estimates.fuelOilCost" id="fuelOilCost" name="fuelOilCost" validation="numeric|required"
               ng-keyup="totalCal('bunker','')"   friendly-name="Fuel Oil Cost" />
              </div> -->
               <div class="col-xs-6" ng-if="estimates.jvNoFO==null || estimates.jvNoFO==''">
                <input type="text" class="form-control input-sm" data-ng-model="estimates.fuelOilCost" id="fuelOilCost" name="fuelOilCost" validation="numeric|required"
                 ng-keyup="totalCal('','all')" friendly-name="Fuel Oil Cost" ng-disabled="isdisabled"/>
               </div>
               <div class="col-xs-6" ng-if="estimates.jvNoFO!=null && estimates.jvNoFO!=''">
                <label class="col-md-1 control-label text-nowrap">{{estimates.fuelOilCost}}</label>
               </div>
              </td>
              <td class="width_20">Fuel Remarks</td>
              <td class="width_30">
               <!-- <div class="col-xs-8">
                <textarea class="form-control input-sm" data-ng-model="estimates.fuelRemarks"></textarea>
               
              </div> -->
               <div class="col-xs-10" ng-if="estimates.jvNoFO==null || estimates.jvNoFO==''">
                <textarea class="form-control input-sm" data-ng-model="estimates.fuelRemarks" ></textarea>
               </div>
               <div class="col-xs-10" ng-if="estimates.jvNoFO!=null && estimates.jvNoFO!=''">
                <label class="col-md-1 control-label text-nowrap">{{estimates.fuelRemarks}}</label>
               </div>
              </td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{estimates.bukFOApprovedDt}}</label>
              </td>
             </tr>
             <tr>
              <td class="width_20"><input type="checkbox" ng-model="estimates.gasOilCostcheckap"> Gas Oil Cost</td>
              <td class="width_30">
               <!--  <div class="col-xs-6">
               <input type="text" class="form-control input-sm" name='gasOilCost' data-ng-model="estimates.gasOilCost"  validation="numeric|required"  ng-keyup="totalCal('bunker','')" friendly-name="Gas Oil Cost" />
              </div> -->
               <div class="col-xs-6" ng-if="estimates.jvNoGO==null || estimates.jvNoGO==''">
                <input type="text" class="form-control input-sm" name='gasOilCost' data-ng-model="estimates.gasOilCost" validation="numeric|required"
                 ng-keyup="totalCal('','all')" friendly-name="Gas Oil Cost" ng-disabled="isdisabled"/>
               </div>
               <div class="col-xs-6" ng-if="estimates.jvNoGO!=null && estimates.jvNoGO!=''">
                <label class="col-md-1 control-label text-nowrap">{{estimates.gasOilCost}}</label>
               </div>
              </td>
              <td class="width_20">Gas Remarks</td>
              <td class="width_30">
               <!--   <div class="col-xs-8">
               <textarea class="form-control input-sm" data-ng-model="estimates.gastOilRemarks"></textarea>
              </div>
               -->
               <div class="col-xs-10" ng-if="estimates.jvNoGO==null || estimates.jvNoGO==''">
                <textarea class="form-control input-sm" data-ng-model="estimates.gastOilRemarks"></textarea>
               </div>
               <div class="col-xs-10" ng-if="estimates.jvNoGO!=null && estimates.jvNoGO!=''">
                <label class="col-md-1 control-label text-nowrap">{{estimates.gastOilRemarks}}</label>
               </div>
              </td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{estimates.bukGOApprovedDt}}</label>
              </td>
             </tr>
             <!-- <tr>
             <td class="width_20">Port Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="estimates.portCost" />
              </div>
             </td>
             <td class="width_20">Port Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <textarea class="form-control input-sm" data-ng-model="estimates.portRemarks"></textarea>
              </div>
             </td>
            </tr>
            <tr>
             <td class="width_20">Agency Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="estimates.agencyCost" />
              </div>
             </td>
             <td class="width_20">Agency Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <textarea class="form-control input-sm" data-ng-model="estimates.agencyRemarks"></textarea>
              </div>
             </td>
            </tr> -->
            </tbody>
           </table>
          </div>
         </div>
         <div class="table-responsive clear col-lg-9 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor">
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.portcostcheckap" ng-click="portCostApCheckAll()"></th>
             <th class="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'">JV Posting<input type="checkbox" ng-model="estimates.portcostcheck"></th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('portBlock')">Port</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('portBlock')">Port Tariff Total ({{portCostTotal | number:2}})</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('portBlock')">Remarks</th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="portBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.portCostList" ng-controller="tableCtrl">
             <tr>
              <td classs="width_5"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
               <td class="width_30">
               <div class="col-xs-6">
                <!--  <input type="text" class="form-control input-sm" data-ng-model="row.port" /> -->
                <label class="col-md-1 control-label text-nowrap">{{row.port}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-6" ng-if="row.journalNo==null || row.journalNo==''">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('','all')" ng-disabled="isdisabled"/>
               </div>
               <div class="col-xs-6" ng-if="row.journalNo!=null && row.journalNo!=''">
                <label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label>
               </div>
              </td>
              <td class="width_30">
               <!-- <div class="col-xs-8">
               <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
              </div> -->
               <div class="col-xs-10" ng-if="row.journalNo==null || row.journalNo==''">
                <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
               </div>
               <div class="col-xs-10" ng-if="row.journalNo!=null && row.journalNo!=''">
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
         <div class="table-responsive clear col-lg-9 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor">
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.agentcostcheckap" ng-click="agencyCostApCheckAll()">
             </th>
             <th class="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'">JV Posting<input type="checkbox" ng-model="estimates.agentcostcheck">
             </th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('agencyBlock')">Port</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('agencyBlock')">Agency Tariff Total ({{agentCostTotal | number:2}})</th>
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
                <td class="width_30">
               <div class="col-xs-6">
                <!--  <input type="text" class="form-control input-sm" data-ng-model="row.port" /> -->
                <label class="col-md-1 control-label text-nowrap">{{row.port}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-6" ng-if="row.journalNo==null || row.journalNo==''">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('','all')" ng-disabled="isdisabled" />
               </div>
               <div class="col-xs-6" ng-if="row.journalNo!=null && row.journalNo!=''">
                <label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label>
               </div>
              </td>
              <td class="width_30">
               <!-- <div class="col-xs-8">
               <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
              </div> -->
               <div class="col-xs-10" ng-if="row.journalNo==null || row.journalNo==''">
                <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
               </div>
               <div class="col-xs-10" ng-if="row.journalNo!=null && row.journalNo!=''">
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
         <div class="table-responsive clear col-lg-9 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor">
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="insuranceCheckAllAp" ng-click="insuranceCostApCheckAll()"></th>
             <th class="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'">JV Posting<input type="checkbox" ng-model="insuranceCheckAllJv" ng-click="insuranceCostJvCheckAll()"></th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('insuranceBlock')">Insurance</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('insuranceBlock')">Insurance Cost Total ({{insuranceCostTotal | number:2}})</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('insuranceBlock')">Remarks</th>
             <th class="width_15">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="insuranceBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.insuranceCostList" ng-controller="tableCtrl">
             <tr>
              <td classs="width_5"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
              <td classs="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'"><input type="checkbox" ng-model="row.otheraccountcheck"></td>
              <td class="width_30">
               <div class="col-xs-6">
                <!--  <input type="text" class="form-control input-sm" data-ng-model="row.port" /> -->
                <label class="col-md-1 control-label text-nowrap">{{row.costType}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-6" ng-if="row.journalNo==null || row.journalNo==''">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('','all')" />
               </div>
               <div class="col-xs-6" ng-if="row.journalNo!=null && row.journalNo!=''">
                <label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label>
               </div>
              </td>
              <td class="width_30">
               <!-- <div class="col-xs-8">
               <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
              </div> -->
               <div class="col-xs-10" ng-if="row.journalNo==null || row.journalNo==''">
                <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
               </div>
               <div class="col-xs-10" ng-if="row.journalNo!=null && row.journalNo!=''">
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
         <div class="table-responsive clear col-lg-11 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor">
           <thead>
            <tr>
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="otherAccountCheckAllAp" ng-click="otherCostApCheckAll()"></th>
             <th class="width_5" ng-if="estimates.activity!='OWN OPERATING SHIPS'">JV Posting<input type="checkbox" ng-model="otherAccountCheckAllJv" ng-click="otherCostJvCheckAll()"></th>
             <th class="width_1"></th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Dr.Account <span style="color: red;">*</span></th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Dr.Sub Account</th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Cr.Account<span style="color: red;">*</span></th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Cr.Sub Account</th>
             <th colspan=1 class=" width_8 text-center" ng-click="toggleBlock('otherBlock')">Port<span style="color: red;">*</span></th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('otherBlock')">Other Cost Total ({{otherCostTotal | number:2}})</th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Other Remarks</th>
             <th colspan=1 class="width_13 text-center" ng-click="toggleBlock('otherBlock')">Approved Date</th>
            </tr>
           </thead>
          </table>
          <div id="otherBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.otherCostList" ng-controller="tableCtrl" ng-if="row.journalNo!=null && row.journalNo!=''">
             <tr>
              <td classs="width_5" style="padding-right: 4% !important; padding-left: 1% !important;"><input type="checkbox" ng-model="row.otheraccountcheckap"
               disabled="disabled"></td>
              <td classs="width_5" style="padding-right: 4% !important; padding-left: 1% !important;" ng-if="estimates.activity!='OWN OPERATING SHIPS'"><input type="checkbox" ng-model="row.otheraccountcheck"
               disabled="disabled"></td>
              <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" disabled="disabled"><i></i></label></td>
              <td class="width_16"><label class="col-md-1 control-label ">{{row.accountHeadName}}</label></td>
              <td class="width_16"><label class="col-md-1 control-label ">{{row.drSubAccountCode}}</label></td>
              <td class="width_16"><label class="col-md-1 control-label ">{{row.crAccountHeadName}}</label></td>
              <td class="width_16"><label class="col-md-1 control-label ">{{row.crSubAccountCode}}</label></td>
              <td class="width_10">
               <div class="row">
                <div class="col-xs-12">
                 <label class="col-md-1 control-label text-nowrap">{{row.port}}</label>
                </div>
               </div>
              </td>
              <td class="width_10">
               <div class="row">
                <div class="col-xs-12">
                 <label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label>
                </div>
               </div>
              </td>
              <td class="width_13">
               <div class="row">
                <div class="col-xs-12">
                 <label class="col-md-1 control-label ">{{row.otherRemarks}}</label>
                </div>
               </div>
              </td>
              <td class="width_13">
               <div class="row">
                <div class="col-xs-12">
                 <label class="col-md-1 control-label ">{{row.approvedDt}}</label>
                </div>
               </div>
              </td>
             </tr>
            </tbody>
            <tbody ng-repeat="(trIndex, row) in estimates.otherCostList" ng-controller="tableCtrl" ng-if="row.journalNo==null || row.journalNo==''">
             <tr>
              <td classs="width_5" style="padding-right: 5% !important; padding-left: 1% !important;"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
              <td classs="width_5" style="padding-right: 5% !important; padding-left: 1% !important;" ng-if="estimates.activity!='OWN OPERATING SHIPS'"><input type="checkbox" ng-model="row.otheraccountcheck"></td>
              <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
              <td class="width_15"><selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
                ng-model="row.accountHeadCode" name="accountHeadCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Dr Account Head)'}}"
                form-name="estimatesForm"></selectivity></td>
              <td class="width_16">
               <div class="col-xs-12" ng-if="!row.drIsSubAccountCode">
                <selectivity list="row.drSubAccountCodeList" property="row.drSubAccountCode" id="drSubAccountCode{{trIndex}}" ng-model="row.drSubAccountCode"
                 name="txtSubAccountCode{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Dr.Sub Account Code)'}}" form-name="estimatesForm"
                 disabled="!row.drIsSubAccountCode"> </selectivity>
               </div>
               <div class="col-xs-12" ng-if="row.drIsSubAccountCode">
                <selectivity list="row.drSubAccountCodeList" property="row.drSubAccountCode" id="txtSubAccountCode{{trIndex}}" ng-model="row.drSubAccountCode"
                 validation="required" name="txtSubAccountCode{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Dr.Sub Account Code)'}}" form-name="estimatesForm">
                </selectivity>
               </div>
              </td>
              <td class="width_16"><selectivity list="accountList" property="row.crAccountHeadCode" id="crAccountHeadCode{{trIndex}}" object="account"
                ng-model="row.crAccountHeadCode" name="crAccountHeadCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Cr Account Head)'}}"
                form-name="estimatesForm"></selectivity></td>
              <td class="width_16">
               <div class="col-xs-12" ng-if="!row.crIsSubAccountCode">
                <selectivity list="row.crSubAccountCodeList" property="row.crSubAccountCode" id="crSubAccountCode{{trIndex}}" ng-model="row.crSubAccountCode"
                 name="txtSubAccountCode{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Cr. Sub Account Code)'}}" form-name="estimatesForm"
                 disabled="!row.crIsSubAccountCode"> </selectivity>
               </div>
               <div class="col-xs-12" ng-if="row.crIsSubAccountCode">
                <selectivity list="row.crSubAccountCodeList" property="row.crSubAccountCode" id="txtSubAccountCode{{trIndex}}" ng-model="row.crSubAccountCode"
                 validation="required" name="txtSubAccountCode{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Cr.Sub Account Code)'}}" form-name="estimatesForm">
                </selectivity>
               </div>
              </td>
              <td class="width_10">
               <div class="row">
                <div class="col-xs-10">
                 <selectivity list="portList" ng-model="row.port" property="row.port" id="port{{trIndex}}" validation="required"
                  friendly-name="{{ 'Row' + $index + '(port)'}}" name="{{ 'Row' + $index + '(port)'}}" form-name="estimatesForm"></selectivity>
                </div>
               </div>
              </td>
              <!-- <td>
                    <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency{{trIndex}}"
                         validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly>
                          <selectivity list="currencyList" ng-model="row.currency" property="row.currency" id="currency{{trIndex}}" object="currency"
                          validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" name="{{ 'Row' + $index + '(Currency)'}}" form-name = "estimatesForm" ></selectivity>
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
              <td class="width_11">
               <div class="row">
                <div class="col-xs-10">
                 <input type="text" class="form-control input-sm" id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}" validation="numeric|required"
                  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="totalCal('','all')" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
                </div>
               </div>
              </td>
              <td class="width_15">
               <div class="row">
                <div class="col-xs-12">
                 <input type="text" class="form-control input-sm" id="otherRemarks{{trIndex}}" ng-model="row.otherRemarks" name="otherRemarks{{trIndex}}">
                </div>
               </div>
              </td>
             </tr>
            </tbody>
           </table>
           <div class="padding-right-5">
            <div class="col-md-4">
             <button ng-click="addRow(estimates.otherCostList)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
              <i class="fa fa-plus"></i>
             </button>
             <button ng-click="removeRow(estimates.otherCostList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
              <i class="fa  fa-trash-o"></i>
             </button>
            </div>
           </div>
          </div>
         </div>
        </div>
        <div class="padding-right-5 col-md-10 pull-right">
         <div class="form-group">
          <label class="col-md-4 control-label bold">Total</label>
          <div class="col-md-2">
           <input type="text" class="form-control input-sm text-right" data-ng-model="estimatesTotal" ng-disabled="isdisabled" />
          </div>
         </div>
        </div>
      </div>
          <div class="form-actions">
       <span ng-if="voyageCostingStatus=='N'" style="color:red">* Voyage is not closed .</span>
       </div>
      <div class="form-actions">
       <div class="row">
        <div class="col-md-12 text-center">
         <button ng-model="approve" class="btn btn-info" class="btn btn-info" ng-click="excel()">
          <i class="fa fa-excel"></i> Jv Cost Excel Export
         </button>
         <button ng-model="approve" class="btn btn-success" ng-if="voyageCostingStatus=='Y'" class="btn btn-success" ng-click="openDatePopup('Approve','saveapprove')">
          <i class="fa fa-save"></i> Approve
         </button>
         
         <button ng-model="approve" ng-if=" (estimates.status=='PA' || estimates.status=='A') && estimates.activity!='OWN OPERATING SHIPS'" class="btn btn-success" class="btn btn-success"
          ng-click="openDatePopup('Approve','jvpost')">
          <i class="fa fa-save"></i> JV Cost Account Posting
         </button>
         <button ng-model="add" class="btn btn-success" ng-if="!isEdit" class="btn btn-success" ng-click="openDatePopup('','save')">
          <i class="fa fa-save"></i> Save
         </button>
         <button class="btn btn-success" type="button" ng-if="isEdit" ng-click="openDatePopup('','save')">
          <i class="fa fa-save"></i> Update
         </button>
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
<script type="text/ng-template" id="estimateacctposting">  
 
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