<style>
.toggleBlock-currsor {
	cursor: pointer;
}
#otherBlock table>tbody>tr>td{
padding:2px !important;
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
  <input type="hidden" value="F0246" id="form_code_id">
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
              <label for="inputPassword" class="control-label">{{estimates.activity}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label class="col-md-5 control-label bold">Vessel Operator</label></label>
             <div class="col-md-7">
              <label for="inputPassword" class="control-label col-md-4">{{estimates.vesselOperator}}</label>
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
              <label for="inputPassword" class="control-label col-md-4">{{estimates.exchangeRate}}</label>
             </div>
            </div>
           </div>
           <div class="col-lg-4">
            <div class="form-group">
             <label for="inputPassword" class="control-label col-md-5 bold">Entry Date <span style="color: red;">*</span>
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
              <textarea class="form-control input-sm" style="width: 150px;" data-ng-model="estimates.remarks"></textarea>
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
         <!-- <div class="col-lg-9 div-center">
          <table class="table table-striped b-t b-light">
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
               <input type="text" class="form-control input-sm" data-ng-model="estimates.charterHireCost" />
              </div>
             </td>
             <td class="width_20">Charter Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <textarea type="text" class="form-control input-sm" data-ng-model="estimates.charterRemarks"></textarea>
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
              <div class="col-xs-6">  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
               <input type="text" class="form-control input-sm" data-ng-model="estimates.fuelOilCost" id="fuelOilCost" name="fuelOilCost" validation="numeric|required"
               ng-keyup="totalCal('bunker','')"   friendly-name="Fuel Oil Cost" />
              </div>
             </td>
             <td class="width_20">Fuel Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <textarea class="form-control input-sm" data-ng-model="estimates.fuelRemarks"></textarea>
              </div>
             </td>
            </tr>
            <tr>
             <td class="width_20">Gas Oil Cost</td>
             <td class="width_30">
              <div class="col-xs-6">
               <input type="text" class="form-control input-sm" name='gasOilCost' data-ng-model="estimates.gasOilCost"  validation="numeric|required"  ng-keyup="totalCal('bunker','')" friendly-name="Gas Oil Cost" />
              </div>
             </td>
             <td class="width_20">Gas Remarks</td>
             <td class="width_30">
              <div class="col-xs-8">
               <textarea class="form-control input-sm" data-ng-model="estimates.gastOilRemarks"></textarea>
              </div>
             </td>
            </tr>
            <tr>
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
            </tr>
           </tbody>
          </table>
         </div>
         -->
         <div class="table-responsive clear col-lg-9 div-center" ng-if="estimates.activity=='JV SLOT PURCHASE ACTIVITY' || estimates.activity=='SLOT PURCHASE OPERATIONS'">
          <table class="table table-striped b-t b-light toggleBlock-currsor" >
           <thead>
            <tr>           
             <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.slotcostcheckap" ng-click="slotCostApCheckAll()"></th>
          <!--    <th class="width_5">JV Posting<input type="checkbox" ng-model="estimates.slotcostcheck"></th> -->
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('slotBlock')">POL</th>
             <th colspan=1 class="width_10 text-center" ng-click="toggleBlock('slotBlock')">POD</th>
             <th colspan=1 class="width_25 text-center" ng-click="toggleBlock('slotBlock')">Slot Cost Total ({{slotCostTotal | number:2}})</th>
             <th colspan=1 class="width_30 text-center" ng-click="toggleBlock('slotBlock')">Remarks</th>
             <th class="width_15">Approved Date</th>
             <th class="width_5"></th>
          
            </tr>
           </thead>
          </table>
          <div id="slotBlock">
           <table class="table table-striped b-t b-light">
            <tbody ng-repeat="(trIndex, row) in estimates.slotCostList" ng-controller="tableCtrl">
             <tr>
              <td classs="width_5"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
              <td class="width_10">
               <div class="col-xs-2">
                <label class="col-md-1 control-label text-nowrap">{{row.port}}</label>
               </div>
              </td>
              <td class="width_10">
               <div class="col-xs-2">
                <label class="col-md-1 control-label text-nowrap">{{row.pod}}</label>
               </div>
              </td>
              <td class="width_25">
               <div class="col-xs-6" ng-if="row.journalNo==null || row.journalNo==''">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('','all')" ng-disabled="isdisabled" />
               </div>
               <div class="col-xs-6" ng-if="row.journalNo!=null && row.journalNo!=''">
                <label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-11">
                <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
               </div>
              </td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{row.approvedDt}}</label>
              </td>
              
              <td class="width_3"> <button ng-click="getSlotCostDtl(row)" 
          class="btn btn-sm  btn-primary" type="button"
          data-toggle="tooltip" title="View Slot Cost" ng-disabled="disabled">
         <i class="fa fa-list-alt"></i>
         </button> 
         <br>
           <br>
         <button ng-click="slotcostExcel(row)" 
          class="btn btn-sm  btn-info" type="button"
          data-toggle="tooltip" title="Excel Slot Cost" ng-disabled="disabled">
         <i class="fa fa-file-excel-o"></i>
         </button>
         </td>
         
             </tr>
            </tbody>
           </table>
          </div>
         </div>
         <div class="table-responsive clear col-lg-9 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor" >
           <thead>
            <tr>
           <th class="width_5">Actual Posting<input type="checkbox" ng-model="estimates.agentcostcheckap" ng-click="agencyCostApCheckAll()">
             </th>
           <!--   <th class="width_5">JV Posting<input type="checkbox" ng-model="estimates.agentcostcheck">
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
               <!-- <div class="col-xs-6">
               <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('agent','')" />
              </div> -->
               <div class="col-xs-6" ng-if="row.journalNo==null || row.journalNo==''">
                <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('','all')"  ng-disabled="isdisabled"/>
               </div>
               <div class="col-xs-6" ng-if="row.journalNo!=null && row.journalNo!=''">
                <label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label>
               </div>
              </td>
              <td class="width_30">
               <div class="col-xs-8">
                <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
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
               <input type="text" class="form-control input-sm" data-ng-model="row.bcAmount" ng-keyup="totalCal('insurance','')"/>
              </div>
             </td>
             <td class="width_30">
              <div class="col-xs-8">
               <textarea type="text" class="form-control input-sm" data-ng-model="row.otherRemarks"></textarea>
              </div>
             </td>
           
            </tr>
           </tbody>
          </table> -->
         <div class="table-responsive clear col-lg-11 div-center">
          <table class="table table-striped b-t b-light toggleBlock-currsor" >
           <thead>
            <tr>
              <th class="width_5">Actual Posting<input type="checkbox" ng-model="otherAccountCheckAllAp" ng-click="otherCostApCheckAll()"></th>
            <!--  <th class="width_5">JV Posting<input type="checkbox" ng-model="otherAccountCheckAllJv" ng-click="otherCostJvCheckAll()"></th> -->
             <th class="width_1"></th>
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
            <tbody ng-repeat="(trIndex, row) in estimates.otherCostList" ng-controller="tableCtrl" ng-if="row.journalNo!=null && row.journalNo!=''">
             <tr>
             <td classs="width_5" style="padding-right: 4% !important;padding-left: 1% !important;"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
           <!--    <td classs="width_5" style="padding-right: 4% !important;padding-left: 1% !important;"><input type="checkbox" ng-model="row.otheraccountcheck"></td>
               -->
              <td class="width_5"><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" disabled="disabled"><i></i></label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.accountHeadName}}</label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.drSubAccountCode}}</label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.crAccountHeadName}}</label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.crSubAccountCode}}</label></td>
              <td class="width_8"><label class="col-md-1 control-label text-nowrap">{{row.port}}</label></td>
              <td class="width_8"><label class="col-md-1 control-label text-nowrap">{{row.pod}}</label></td>
              <td class="width_10"><label class="col-md-1 control-label text-nowrap">{{row.bcAmount}}</label></td>
              <td class="width_13"><label class="col-md-1 control-label ">{{row.otherRemarks}}</label></td>
              <td class="width_15">
              	<label class="col-md-1 control-label text-nowrap">{{row.approvedDt}}</label>
              </td>
             </tr>
            </tbody>
            <tbody ng-repeat="(trIndex, row) in estimates.otherCostList" ng-controller="tableCtrl" ng-if="row.journalNo==null || row.journalNo==''">
             <tr>
              <td classs="width_5" style="padding-right: 5% !important;padding-left: 1% !important;"><input type="checkbox" ng-model="row.otheraccountcheckap"></td>
             <!-- <td classs="width_5" style="padding-right: 5% !important;padding-left: 1% !important;"><input type="checkbox" ng-model="row.otheraccountcheck"></td> -->
              <td class="width_5"><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
              <td class="width_13"><selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
                ng-model="row.accountHeadCode" name="accountHeadCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Dr Account Head)'}}"
                form-name="estimatesForm"></selectivity></td>
              <td class="width_13">
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
              <td class="width_13"><selectivity list="accountList" property="row.crAccountHeadCode" id="crAccountHeadCode{{trIndex}}" object="account"
                ng-model="row.crAccountHeadCode" name="crAccountHeadCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Cr Account Head)'}}"
                form-name="estimatesForm"></selectivity></td>
              <td class="width_13">
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
              <td class="width_8">
               <div class="row">
                <div class="col-xs-12">
                 <selectivity list="portList" ng-model="row.port" property="row.port" id="port{{trIndex}}" validation="required"
                  friendly-name="{{ 'Row' + $index + '(port)'}}" name="{{ 'Row' + $index + '(port)'}}" form-name="estimatesForm"></selectivity>
                </div>
               </div>
              </td>
              <td class="width_8">
               <div class="row">
                <div class="col-xs-12">
                 <selectivity list="portList" ng-model="row.pod" property="row.pod" id="pod{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(pod)'}}"
                  name="{{ 'Row' + $index + '(pod)'}}" form-name="estimatesForm"></selectivity>
                </div>
               </div>
              </td>
              <td class="width_10">
               <div class="row">
                <div class="col-xs-12">
                 <input type="text" class="form-control input-sm" id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}" validation="numeric|required"
                  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="totalCal('','all')" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
                </div>
               </div>
              </td>
              <td class="width_13">
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
           <!--   <button ng-model="approve" class="btn btn-info"  
               class="btn btn-info" ng-click="excel()">
               <i class="fa fa-excel"></i>
                Jv Cost Excel Export
              </button>
               <button ng-model="approve" class="btn btn-success"  ng-if="estimates.status=='A'"
               class="btn btn-success" ng-click="jvcostAccountPosting()">
               <i class="fa fa-save"></i>
                JV Cost Account Posting
              </button>
               -->
          <!--  <button ng-model="approve" class="btn btn-success" class="btn btn-success" ng-click="saveEstimatesThirdParty('Approve')">
            <i class="fa fa-save"></i> Approve
           </button> -->
           
        <!--    <button ng-model="approve" class="btn btn-info"  
               class="btn btn-info" ng-click="excel()">
               <i class="fa fa-excel"></i>
                Jv Cost Excel Export
              </button>    -->
           <button ng-model="approve" class="btn btn-success"  class="btn btn-success" ng-click="openDatePopup('Approve','saveapprove')">
            <i class="fa fa-save"></i> Approve
           </button>
           <!-- <button ng-model="approve" class="btn btn-success"  ng-if=" estimates.activity!='OWN OPERATING SHIPS'"
            class="btn btn-success" ng-click="openDatePopup('Approve','jvpost')">
            <i class="fa fa-save"></i>
             JV Cost Account Posting
           </button> -->
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
<script type="text/ng-template" id="slotCostDtl">

<div class="modal-header bold"> Slot Cost Details </div>
<div class="row">
 <div class="col-lg-12">
  <div class="col-lg-12">  
  <div class="table-responsive tr-fixed">
<div ng-if="slotCostDtlList.length == 0 || slotCostDtlObj.totalCost==0">

<span style="color:red;" class="bold">Slot cost details not found!. </span>

</div>
   <table border=1 cellspacing=0 cellpadding=0
              bordercolor="#808080"
              class="table table-striped table-hover dataTable no-footer booksfixed">
       <thead class="tr-thead dataTables-Main-Head" ng-if="slotCostDtlList.length > 0 && slotCostDtlObj.totalCost>0">

        <tr>
<th class="width_6">Quotation No.</th>
<th class="width_6">Customer</th>
<th class="width_6">Slot</th>
<th class="width_6" ng-if="slotCostDtlObj.m20>0">M20</th>
<th class="width_6" ng-if="slotCostDtlObj.m40>0">M40</th>
<th class="width_6" ng-if="slotCostDtlObj.m45>0">M45</th>
<th class="width_6" ng-if="slotCostDtlObj.d20>0">D20</th>
<th class="width_6" ng-if="slotCostDtlObj.d40>0">D40</th>
<th class="width_6" ng-if="slotCostDtlObj.d45>0">D45</th>
<th class="width_6" ng-if="slotCostDtlObj.r20>0">R20</th>
<th class="width_6" ng-if="slotCostDtlObj.r40>0">R40</th>
<th class="width_6" ng-if="slotCostDtlObj.oog20>0">OOG20</th>
<th class="width_6" ng-if="slotCostDtlObj.oog40>0">OOG40</th>
<th class="width_6" ng-if="slotCostDtlObj.rI20>0">RI20</th>
<th class="width_6" ng-if="slotCostDtlObj.rI40>0">RI40</th>
<th class="width_6" ng-if="slotCostDtlObj.flexi20>0">FLEXI_20</th>
<th class="width_6" ng-if="slotCostDtlObj.flexi40>0">FLEXI_40</th>
<th class="width_6" ng-if="slotCostDtlObj.im20>0">IMCO_20</th>
<th class="width_6" ng-if="slotCostDtlObj.im40>0">IMCO_40</th>
<th class="width_6" ng-if="slotCostDtlObj.oogSlotLoss>0">OOG Slot Loss</th>

<th class="width_6" ng-if="slotCostDtlObj.m20Rate>0">M20 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.m40Rate>0">M40 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.m45Rate>0">M45 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.d20Rate>0">D20 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.d40Rate>0">D40 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.d45Rate>0">D45 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.r20Rate>0">R20 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.r40Rate>0">R40 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.oog20Rate>0">OOG20 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.oog40Rate>0">OOG40 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.rI20Rate>0">RI20 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.rI40Rate>0">RI40 Rate</th>
<th class="width_6" ng-if="slotCostDtlObj.rev>0">Cost</th>
<th class="width_6" ng-if="slotCostDtlObj.rebate>0">Rebate</th>
<th class="width_6" ng-if="slotCostDtlObj.totalCost>0">Cost-Rebate</th>
           </tr>
       </thead>
      
       <tbody class="tr-tbody" >
        <tr ng-repeat="slotCostDtl in slotCostDtlList" ng-init="$rowIndex = $index" ng-if="slotCostDtlList.length > 0  &&  slotCostDtl.stack=='VERESK' " style="background-color:#98fb98 !important">
 <td class="width_6 padding-text-align text-left "  >
            <span>{{slotCostDtl.pqNo}}</span>            
         </td>
         <td class="width_6 padding-text-align text-left " >
            <span>{{slotCostDtl.mloName}}</span>            
         </td>
  			<td class="width_6 padding-text-align text-center " >
            <span>{{slotCostDtl.slotName}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m20>0 ">
            <span>{{slotCostDtl.m20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m40>0">
            <span>{{slotCostDtl.m40}}</span>            
         </td>
  		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m45>0">
            <span>{{slotCostDtl.m45}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d20>0">
            <span>{{slotCostDtl.d20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d40>0">
            <span>{{slotCostDtl.d40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d45>0" >
            <span>{{slotCostDtl.d45}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r20>0" >
            <span>{{slotCostDtl.r20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.r40>0">
            <span>{{slotCostDtl.r40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog20>0">
            <span>{{slotCostDtl.oog20}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.oog40>0">
            <span>{{slotCostDtl.oog40}}</span>            
         </td>

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI20>0">
            <span>{{slotCostDtl.rI20}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.rI40>0">
            <span>{{slotCostDtl.rI40}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.flexi20>0" >
            <span>{{slotCostDtl.flexi20}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.flexi40>0">
            <span>{{slotCostDtl.flexi40}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.im20>0">
            <span>{{slotCostDtl.im20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.im40>0">
            <span>{{slotCostDtl.im40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oogSlotLoss>0">
            <span>{{slotCostDtl.oogSlotLoss}}</span>            
         </td>
  		

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m20Rate>0">
            <span>{{slotCostDtl.m20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m40Rate>0">
            <span>{{slotCostDtl.m40Rate}}</span>            
         </td>
  		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m45Rate>0">
            <span>{{slotCostDtl.m45Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d20Rate>0">
            <span>{{slotCostDtl.d20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d40Rate>0">
            <span>{{slotCostDtl.d40Rate}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d45Rate>0">
            <span>{{slotCostDtl.d45Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r20Rate>0">
            <span>{{slotCostDtl.r20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r40Rate>0">
            <span>{{slotCostDtl.r40Rate}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog20Rate>0">
            <span>{{slotCostDtl.oog20Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog40Rate>0">
            <span>{{slotCostDtl.oog40Rate}}</span>            
         </td>

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI20Rate>0">
            <span>{{slotCostDtl.rI20Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI40Rate>0">
            <span>{{slotCostDtl.rI40Rate}}</span>            
         </td>
<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.rev>0">
            <span class="bold">{{slotCostDtl.rev}}</span>            
         </td>
<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.rebate>0">
            <span class="bold">{{slotCostDtl.rebate}}</span>            
         </td>
  			<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.totalCost>0">
            <span>{{slotCostDtl.totalCost}}</span>            
         </td>
        </tr>

     <tr ng-repeat="slotCostDtl in slotCostDtlList" ng-init="$rowIndex = $index" ng-if="slotCostDtlList.length > 0  &&  slotCostDtl.stack!='VERESK' " >
 <td class="width_6 padding-text-align text-left "  >
            <span>{{slotCostDtl.pqNo}}</span>            
         </td>
         <td class="width_6 padding-text-align text-left " >
            <span>{{slotCostDtl.mloName}}</span>            
         </td>
  			<td class="width_6 padding-text-align text-center " >
            <span>{{slotCostDtl.slotName}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m20>0 ">
            <span>{{slotCostDtl.m20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m40>0">
            <span>{{slotCostDtl.m40}}</span>            
         </td>
  		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m45>0">
            <span>{{slotCostDtl.m45}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d20>0">
            <span>{{slotCostDtl.d20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d40>0">
            <span>{{slotCostDtl.d40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d45>0" >
            <span>{{slotCostDtl.d45}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r20>0" >
            <span>{{slotCostDtl.r20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.r40>0">
            <span>{{slotCostDtl.r40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog20>0">
            <span>{{slotCostDtl.oog20}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.oog40>0">
            <span>{{slotCostDtl.oog40}}</span>            
         </td>

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI20>0">
            <span>{{slotCostDtl.rI20}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.rI40>0">
            <span>{{slotCostDtl.rI40}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.flexi20>0" >
            <span>{{slotCostDtl.flexi20}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.flexi40>0">
            <span>{{slotCostDtl.flexi40}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.im20>0">
            <span>{{slotCostDtl.im20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.im40>0">
            <span>{{slotCostDtl.im40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oogSlotLoss>0">
            <span>{{slotCostDtl.oogSlotLoss}}</span>            
         </td>
  		

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m20Rate>0">
            <span>{{slotCostDtl.m20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m40Rate>0">
            <span>{{slotCostDtl.m40Rate}}</span>            
         </td>
  		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m45Rate>0">
            <span>{{slotCostDtl.m45Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d20Rate>0">
            <span>{{slotCostDtl.d20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d40Rate>0">
            <span>{{slotCostDtl.d40Rate}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d45Rate>0">
            <span>{{slotCostDtl.d45Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r20Rate>0">
            <span>{{slotCostDtl.r20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r40Rate>0">
            <span>{{slotCostDtl.r40Rate}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog20Rate>0">
            <span>{{slotCostDtl.oog20Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog40Rate>0">
            <span>{{slotCostDtl.oog40Rate}}</span>            
         </td>

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI20Rate>0">
            <span>{{slotCostDtl.rI20Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI40Rate>0">
            <span>{{slotCostDtl.rI40Rate}}</span>            
         </td>
<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.rev>0">
            <span class="bold">{{slotCostDtl.rev}}</span>            
         </td>
<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.rebate>0">
            <span class="bold">{{slotCostDtl.rebate}}</span>            
         </td>
  			<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.totalCost>0">
            <span>{{slotCostDtl.totalCost}}</span>            
         </td>
        </tr>
      

<tr ng-if="slotCostDtlList.length > 0 && slotCostDtlObj.totalCost>0">
         <td class="width_6 padding-text-align text-left " colspan="3" >          
            <span class="bold">Total</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m20>0">
            <span class="bold">{{slotCostDtlObj.m20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m40>0">
            <span class="bold">{{slotCostDtlObj.m40}}</span>            
         </td>
  		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m45>0">
            <span class="bold">{{slotCostDtlObj.m45}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d20>0">
            <span class="bold">{{slotCostDtlObj.d20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d40>0">
            <span class="bold">{{slotCostDtlObj.d40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d45>0" >
            <span class="bold">{{slotCostDtlObj.d45}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r20>0" >
            <span class="bold">{{slotCostDtlObj.r20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.r40>0">
            <span class="bold">{{slotCostDtlObj.r40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog20>0">
            <span class="bold">{{slotCostDtlObj.oog20}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.oog40>0">
            <span class="bold">{{slotCostDtlObj.oog40}}</span>            
         </td>

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI20>0">
            <span class="bold">{{slotCostDtlObj.rI20}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right "  ng-if="slotCostDtlObj.rI40>0">
            <span class="bold">{{slotCostDtlObj.rI40}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.flexi20>0" >
            <span class="bold">{{slotCostDtlObj.flexi20}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.flexi40>0">
            <span class="bold">{{slotCostDtlObj.flexi40}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.im20>0">
            <span class="bold">{{slotCostDtlObj.im20}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.im40>0">
            <span class="bold">{{slotCostDtlObj.im40}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oogSlotLoss>0">
            <span class="bold">{{slotCostDtlObj.oogSlotLoss}}</span>            
         </td>
  		

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m20Rate>0">
            <span class="bold">{{slotCostDtlObj.m20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m40Rate>0">
            <span class="bold">{{slotCostDtlObj.m40Rate}}</span>            
         </td>
  		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.m45Rate>0">
            <span class="bold">{{slotCostDtlObj.m45Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d20Rate>0">
            <span class="bold">{{slotCostDtlObj.d20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d40Rate>0">
            <span class="bold">{{slotCostDtlObj.d40Rate}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.d45Rate>0">
            <span class="bold">{{slotCostDtlObj.d45Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r20Rate>0">
            <span class="bold">{{slotCostDtlObj.r20Rate}}</span>            
         </td>
        <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.r40Rate>0">
            <span class="bold">{{slotCostDtlObj.r40Rate}}</span>            
         </td>
  			<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog20Rate>0">
            <span class="bold">{{slotCostDtlObj.oog20Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.oog40Rate>0">
            <span class="bold">{{slotCostDtlObj.oog40Rate}}</span>            
         </td>

		<td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI20Rate>0">
            <span class="bold">{{slotCostDtlObj.rI20Rate}}</span>            
         </td>
  		 <td class="width_6 padding-number-align text-right " ng-if="slotCostDtlObj.rI40Rate>0">
            <span class="bold">{{slotCostDtlObj.rI40Rate}}</span>            
         </td>
<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.rev>0">
            <span class="bold">{{slotCostDtlObj.rev}}</span>            
         </td>
<td class="width_6 padding-number-align-right text-right "  ng-if="slotCostDtlObj.rebate>0">
            <span class="bold">{{slotCostDtlObj.rebate}}</span>            
         </td>
  			<td class="width_6 padding-number-align-right text-right " ng-if="slotCostDtlObj.totalCost>0">
            <span class="bold">{{slotCostDtlObj.totalCost}}</span>            
         </td>
	
        </tr>
       </tbody>
 
    </table>
<br>
 <span style="width: 15px; height: 15px; float: left; background-color:#98fb98 !important"></span><span>
           * VERESK LOADING.</span>
<br>
   </div> 
  </div>
 </div> 
</div>
<div class="modal-footer">

 
 <button class="btn btn-danger" type="button" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
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