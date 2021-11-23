
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
<%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel panel-default panel-default-form">
  <!-- <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb padding-left-0">
    <li>
     <a> Finance </a>
    </li>
    <li>
     <a>Control Screen</a>
    </li>
    <li>
     <a>Tariff</a>
    </li>
     <li>
     <a>Agency Tariff Detail</a>
    </li>
   </ol> -->
  </div>
  <div class="panel-body">
   <form class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label">Vessel</label>
        <div class="col-md-7">
          <selectivity list="vesselList" property="agencyTariff.vessel" id="vessel_id"></selectivity>
          
       <!--   <select class="form-control input-sm" id="vessel" ng-model="porttariff.vessel" ng-options="c.vesselName for c in vesselList"
          ng-change="onSelectVessel(porttariff.vessel)">
          <option value="" selected="selected">Select</option>
         </select> -->
        </div>
       </div>
      <!--  <div class="form-group">
        <label class="col-md-5 control-label">Port Seq No </label>
        <div class="col-md-7 inputGroupContainer">
         <select class="form-control input-sm" id="portseq" ng-model="porttariff.portseq" ng-options="c.portseq for c in portseqList"
          ng-change="onSelectportseq(porttariff.portseq)">
          <option value="" selected="selected">Select</option>
         </select>
        </div>
       </div> -->
     
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label">Voyage</label>
        <div class="col-md-7">
        <!--  <select class="form-control input-sm" id="voyage" ng-model="porttariff.voyage" ng-options="c.voyageCode for c in voyageList"
          ng-change="onSelectVoyage(porttariff.voyage)">
          <option value="" selected="selected">Select</option>
         </select> -->
          <selectivity list="voyageList" property="agencyTariff.voyage" id="voyage_id"></selectivity>
        </div>
       </div>
     
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label">Port Code</label>
        <div class="col-md-6 inputGroupContainer">
        <!--  <select class="form-control input-sm" id="port" ng-model="porttariff.port" ng-options="c.portCode for c in  portList" ng-change="onSelectPort(porttariff.port)">
          <option value="" selected="selected">Select</option>
         </select> -->
         
          <selectivity list="portList" property="agencyTariff.port" id="port_id" ></selectivity>
        </div>
       </div>
      
      </fieldset>
     </div>
    </div>

   <div class="row text-center">
     <div class="row">
      <div class="col-md-12 ">
       <button class="btn btn-success" type="button" tooltip="Search" ng-click="onSearch(agencyTariff)">
        <i class="fa fa-search"></i>
        Search
       </button>
      
       <button type="button" class="btn btn-info" tooltip="Reset"  ng-click="resetValue()">
        <i class="fa fa-undo"></i>
        Reset
       </button>
     
      <button class="btn btn-danger" type="button"   ng-click="refreshdata(agencyTariff)">
        <i class="fa fa-refresh"></i>
        Refresh
       </button>
        <button class="btn btn-primary" type="button"   ng-click="agencyComm()">
        <i class="fa "></i>
        Agency Commission
       </button>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb padding-left-0">
    <li>
     <a>Agency Tariff Detail</a>
    </li>
   </ol>
  </div>
  <div class="panel-body " st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="widget-body no-padding ">
    <div class="table-responsive ">
     <table class="table table-striped b-t b-light table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
       <tr>
        <th class="width_12" st-sort="port">Agency Tariff Code</th>
        <th class="width_12" st-sort="validFrom">Port Code</th>
        <th class="width_12" st-sort="validTo">Port Seq.</th>
        <th class="width_12" st-sort="chargeType">Vessel</th>
        <th class="width_12" st-sort="currency">Voyage</th>
        <th class="width_12" st-sort="currency">Amount</th>
       <!--  <th class="width_12" st-sort="currency">USD</th>         -->
        <th class="width_12">Action</th>
       </tr>
      </thead>
      <tbody ng-repeat="objPorttariffItem in displayedCollection ">
       <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
        <td class="width_12">
         <span tooltip="{{objPorttariffItem.tariffCode}}" class="tool-tip-span"> {{objPorttariffItem.agencyTariffCode}}</span>
        </td>
        <td class="width_12">
         <span tooltip="{{objPorttariffItem.port}}" class="tool-tip-span"> {{objPorttariffItem.portCode}}</span>
        </td>
        <td class="width_12">
         <span tooltip="{{objPorttariffItem.portSequence}}" class="tool-tip-span"> {{objPorttariffItem.portseq}}</span>
        </td>
        <td class="width_12">
         <span tooltip="{{objPorttariffItem.vesselName}}" class="tool-tip-span">{{objPorttariffItem.vessel}}</span>
        </td>
        <td class="width_12">
         <span tooltip="{{objPorttariffItem.voyage}}" class="tool-tip-span">{{objPorttariffItem.voyage}}</span>
        </td>
            <td class="width_12 text-right">
         <span tooltip="{{objPorttariffItem.calctariff}}" class="tool-tip-span ">{{objPorttariffItem.amount | number:2}}</span>
        </td>
            <!-- <td class="width_12">
         <span tooltip="{{objPorttariffItem.calcUsd}}" class="tool-tip-span">{{objPorttariffItem.calcUsd}}</span>
        </td> -->
         <td class="td-actions text-center">
             <span>
              <i class="fa  fa-eye text-success text" data-ng-click="viewRowBtn(objPorttariffItem.agencyTariffCode)" tooltip="View"></i>
             </span>
            <!-- <span>
              <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPorttariffItem.tariffCode,$index)" tooltip="Delete"></i>
             </span>-->
              <security:authorize access="hasRole('${form_code}_${approve}')">
                 <span>
                  <i class="fa fa-check text-info-dker text padding-left-10" data-ng-click="approveRow(objPorttariffItem,$index)" tooltip="Approve"></i>
                 </span>
              </security:authorize>
       </td> 
       </tr>
      </tbody>
     </table>
    </div>
    <footer class="panel-footer">
     <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
   </div>
  </div>
 </div>

</div>
