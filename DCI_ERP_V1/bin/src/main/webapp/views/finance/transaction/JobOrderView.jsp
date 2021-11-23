<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
td{
border:1px solid #000 !important;
}
/* .scrollArea table th{
padding: 4px 15px !important;
} */
</style>
<div class="wrapper-md" ng-init="getDropdownvalue()">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb inline-block padding-left-10">
    <li>
     <a>Finance</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction.freightmanifest">Transaction</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction.freightmanifest.search">Freight Manifest</a>
    </li>
   </ol>
  </div>
  <div class="panel-body">
  <!-- <div class="row book-widget-row">
         <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group form-group-label-left">

            <label class="col-md-4 col-md-offset-1 control-label bold">Vessel: </label>
            <div class="col-md-7">
            {{vesselName}}
            
            </div>
            
            </div>
            </fieldset>
            </div>
            <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group form-group-label-left">

            <label class="col-md-4 col-md-offset-1 control-label bold">Voyage: </label>
            <div class="col-md-7">
            {{voyage}}
            
            </div>
            
            </div>
            </fieldset>
            </div>
              <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group form-group-label-left">

            <label class="col-md-4 col-md-offset-1 control-label bold">Service: </label>
            <div class="col-md-7">
            {{sectorId}}
            
            </div>
            
            </div>
            </fieldset>
            </div>
            </div> -->

  <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid" >
       <scrollable-table watch="containerTypeList">
        <table class="table table-striped table-bordered table-hover dataTable no-footer"  role="grid" style="width: 100%;">
         <thead>
          <tr role="row">
             <th rowspan=2 calss="text-center">Vessel</th>
                <th rowspan=2 calss="text-center">Voyage</th>
                <th rowspan=2 calss="text-center">Service</th>
           <th rowspan=2 calss="text-center">POL</th>
           <th rowspan=2>POD</th>
           <th rowspan=2>FPOD</th>
           <th rowspan=2>Loading No</th>
            <th rowspan=2>BL No</th>
           <th rowspan=2>Invoice No</th>
            <th rowspan=2>GInv. No</th>
            <th rowspan=2>PHC Inv NO</th>
            <th rowspan=2>Debit Inv NO</th>
            <th rowspan=2>Credit Inv NO</th>
           <th rowspan=2>Quotation No</th>
           <th rowspan=2>Customer</th>
           <th rowspan=2>Slot A/C</th>
           <th rowspan=2>Sub Slot</th>
           <th rowspan=2>Stack</th>
            <th rowspan=2>Shipment</th>
           
           <th rowspan=2 ng-repeat="containerType in containerTypeList">
         {{containerType}}
           </th>
           <!--  <th rowspan=2>M20</th>
            <th rowspan=2>M40</th>
            <th rowspan=2>M45</th>
            <th rowspan=2>D20</th>
            <th rowspan=2>D40</th>
            <th rowspan=2>D45</th>
            <th rowspan=2>R20</th>
            <th rowspan=2>R40</th>
            <th rowspan=2>OOG20</th>
            <th rowspan=2>OOG40</th>
           <th rowspan=2>RI20</th>
           <th rowspan=2>RI40</th> -->
           <th colspan=3 class="text-center">Total</th>
           <th rowspan=2>Wt</th>
           <th rowspan=2>MH40</th>
           <th rowspan=2>DH40</th>
           <th rowspan=2>RH40</th>
           <th rowspan=2>DI20</th>
           <th rowspan=2>DI40</th>
           <th rowspan=2>MI20</th>
           <th rowspan=2>MI40</th>          
           <th rowspan=2>OOG SLOT LOSS</th>
           <th rowspan=2>Ocean Freight(USD)</th>
           <th rowspan=2>Invoice Amt (USD)</th>
           <th rowspan=2>GInv Amt (USD)</th>
           <th rowspan=2>PHC Amt (USD)</th>
           <th rowspan=2>Debit Amt (USD)</th>
           <th rowspan=2>Credit Amt (USD)</th>
           <th rowspan=2>Total Amt (USD)</th>
           <th rowspan=2>Sailing Date</th>
           <th rowspan=2>T/S Leg</th>
           <th rowspan=2>ORIGINAL POL</th>
           <th rowspan=2>ORIGINAL POD</th>
           <th rowspan=2>Ex-Voyage</th>
           <th rowspan=2>Invoice No.</th>
           <th rowspan=2>Billing Terms</th>
           <th rowspan=2 class="text-center">Remarks</th>
           </tr>
        
   <tr>
   <th>20'</th>
           <th>40'</th>
           <th>Teus</th>            
          </tr>
          
         </thead>    
          <tbody ng-repeat="containerQty in containerQtyList">
                  <tr>
                   <td class="width_6" style="white-space: nowrap;"> <span class="tool-tip-span">{{containerQty.vesselName}}</span></td>
                   <td class="width_6" style="white-space: nowrap;"> <span class="tool-tip-span">{{containerQty.voyage}}</span></td>
                   <td class="width_6" style="white-space: nowrap;"> <span class="tool-tip-span">{{containerQty.sectorName}}</span></td>
                  <td style="display:none;">
                  {{polCur=containerQtyList[$index].polId}}
                    {{polNxt=containerQtyList[$index+1].polId}}
                    
                  </td>
                   <td class="width_20" >  
                   <!--    <span class="tool-tip-span" ng-show="containerQtyList[$index].polId != containerQtyList[$index-1].polId " >
       
                      </span> -->
                   <span class="tool-tip-span" ng-if="containerQtyList[$index].polId != containerQtyList[$index-1].polId || containerQtyList[$index].podId != containerQtyList[$index-1].podId" > 
 {{containerQty.polId}}
  </span>
<!--  <span class="tool-tip-span" ng-if="$scope.polCur!=$scope.polNxt"  > 

                   </span> --></td>
                   
                   <td class="width_6"> <span class="tool-tip-span" ng-if="containerQtyList[$index].polId != containerQtyList[$index-1].polId || containerQtyList[$index].podId != containerQtyList[$index-1].podId ">{{containerQty.podId}}</span></td>
                   <td class="width_6"> <span class="tool-tip-span">{{containerQty.fpod}}</span></td>
                   <td class="width_6"> <span class="tool-tip-span">{{containerQty.loadingNo}}</span></td>
                   <td class="width_6"> <span class="tool-tip-span">{{containerQty.blNo}}</span></td>
                   <td class="width_6">
                   	<a  href="javascript:void(0)"  tooltip="{{containerQty.invoiceNo}}" class="tool-tip-span font-blue" data-ng-bind="containerQty.invoiceNo" data-ng-click="printInvoice(containerQty.invoiceNo)"></a>
                  <!--   <span class="tool-tip-span">{{containerQty.invoiceNo}}</span> -->
                   </td>
                    <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.giNo}}</span>
                   </td>
                   <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.phcNo}}</span>
                   </td>
                   <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.debitNo}}</span>
                   </td>
                    <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.creditNoteNo}}</span>
                   </td>
                   <td class="width_6">
                      <a  href="javascript:void(0)" tooltip="{{containerQty.quotationNO}}" class="tool-tip-span font-blue" data-ng-bind="containerQty.quotationNO" data-ng-click="printQuote(containerQty.quotationNO)"></a>
                    <!-- <span class="tool-tip-span">{{ containerQty.quotationNO}}</span> -->
                   </td>
                   <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.mlo}}</span>
                   </td>
                   <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.slotAc}}</span>
                   </td>
                     <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.subSlotName}}</span>
                   </td>
                     <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.stackCode}}</span>
                   </td>
                   <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.shipment}}</span>
                   </td>
                   <td class="width_6 text-right" ng-repeat="quantity in containerQty.quantityList  track by $index">
             <span class="tool-tip-span "> {{quantity}}</span>
       </td>
                              
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.twenty}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.forty}}</span>
                   </td>
                   <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.totalTeus}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.weight}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.mh40}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.dh40}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.rh40}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.d120}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.d140}}</span>
                   </td>
                   <td class="width_6">
                    <span class="tool-tip-span">{{containerQty.mi20}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.mi40}}</span>
                   </td>
                   <!-- <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.flexi}}</span>
                   </td> -->
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.oogSlotAc}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.oceanFreight | number:2}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.invoiceAmt | number:2}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.giAmt | number:2}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.phcAmt | number:2}}</span>
                   </td>
                   
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.debitAmt | number:2}}</span>
                   </td>
                   <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.creditNoteAmt | number:2}}</span>
                   </td>
                    <td class="width_6 text-right">
                    <span class="tool-tip-span">{{containerQty.totalAmt | number:2}}</span>
                   </td>
                   <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.sailing_dt}}</span>
                   </td>
                   <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.tsFlag}}</span>
                   </td>
                    <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.originalPOL}}</span>
                   </td>
                    <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.originalPOD}}</span>
                   </td>
                   <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.exvoyage}}</span>
                   </td>
                   <td class="width_6 text-left">                
                      <a  href="javascript:void(0)"  tooltip="{{containerQty.tInvoiceNo}}" class="tool-tip-span font-blue" data-ng-bind="containerQty.tInvoiceNo" data-ng-click="printInvoice(containerQty.tInvoiceNo)"></a>
                   </td>
                   <td class="width_6 text-left">
                    <span class="tool-tip-span">{{containerQty.billingTerms}}</span>
                   </td>
                    <td style="white-space: nowrap;" class="text-left">
                    <span class="tool-tip-span">{{containerQty.remarks}}</span>
                   </td>               
                  </tr>
                  <tr ng-if="containerQtyList[$index].polId != containerQtyList[$index+1].polId  || containerQtyList[$index].podId != containerQtyList[$index+1].podId " >
                  
                  <th class="width_6" colspan="19"><span class="ng-hide">{{$scope.indx=$index}} </span> <span class="tool-tip-span">Total for {{containerQtyList[$index].polId}} to {{containerQtyList[$index].podId}}</span></th>
                      <th class="width_6 text-right padding-4p15p"  ng-repeat="containerQty1 in containerTypeList">
                    
              {{containerQtyList|sumByArr: $index:$scope.indx:containerQty.polId:containerQty.podId}}
       </th> 
       <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'twenty':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'forty':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'totalTeus':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'weight':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'mh40':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'dh40':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'rh40':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'d120':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'d140':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'mi20':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'mi40':containerQty.polId:containerQty.podId}}</th> 
                    <!-- <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'flexi':containerQty.polId:containerQty.podId}}</th>  -->
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKey:'oogSlotAc':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'oceanFreight':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'invoiceAmt':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'giAmt':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'phcAmt':containerQty.polId:containerQty.podId}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'debitAmt':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'creditNoteAmt':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumBySTKeyAmount:'totalAmt':containerQty.polId:containerQty.podId}}</th>
                    <th class="text-right padding-4p15p"></th> 
                    <th class="text-right padding-4p15p"></th>  
                  </tr>
                 </tbody>
                   <tfoot>
                <tr>
                     <th colspan="19">Grand Total</th>
                      <th class="width_6 text-right padding-4p15p"  ng-repeat="containerQty1 in containerTypeList">
                    <!-- {{ $index }} --> 
                              {{containerQtyList|sumByGTArr: $index}} 
                       </th> 
     
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'twenty'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'forty'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'totalTeus'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'weight'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'mh40'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'dh40'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'rh40'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'d120'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'d140'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'mi20'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'mi40'}}</th> 
                    <!-- <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'flexi'}}</th>  -->
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKey:'oogSlotAc'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'oceanFreight'}}</th> 
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'invoiceAmt'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'giAmt'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'phcAmt'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'debitAmt'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'creditNoteAmt'}}</th>
                    <th class="text-right padding-4p15p">{{containerQtyList|sumByKeyAmount:'totalAmt'}}</th>    
                    <th class="text-right padding-4p15p"></th> 
                    <th class="text-right padding-4p15p"></th>
                    <th class="text-right padding-4p15p"></th> 
                    <th class="text-right padding-4p15p"></th>
                    <th class="text-right padding-4p15p"></th> 
                    <th class="text-right padding-4p15p"></th>       
                </tr>
                
                <tr>
                     <th colspan="49">General Invoice Amount</th>                 
                    <th class="text-right padding-4p15p">{{generalInvAmount}}</th>
                    <th class="text-right"></th> 
                    <th class="text-right"></th> 
                    <th class="text-right"></th> 
                    <th class="text-right">{{containerQtyList|generalInvoiceTot:'totalAmt':generalInvAmount}}</th> 
                    <th class="text-right"></th> 
                    <th class="text-right"></th> 
                    <th class="text-right"></th> 
                    <th class="text-right"></th> 
                    <th class="text-right"></th>      
                </tr>
            </tfoot>
        </table>
        </scrollable-table>
        </div>
       <div style="width: 80%;max-height:400px; overflow: scroll;">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" style="width: 100%">
             <thead>
             <tr>
              <th class="width_6 text-center" >POL</th> 
              <th class="width_6 text-center" >POD</th>
              <th class="width_12 text-center" colspan="3" ng-repeat="containerQty1 in loadingList">
              {{containerQty1.slotValue}}
              </th>
             <th class="width_12 text-center"  colspan="3">Total</th>
         </tr>
          <tr class="width_12" >
              <th colspan=2>&nbsp;</th>
              <th colspan="3" ng-repeat="containerQty2 in loadingList">
              <table style="width: 100%">
              <tr>
               <th class="width_6">{{totContainerHdr[0]}}</th>
              
             <th  class="width_6">{{totContainerHdr[1]}}</th>
             <th  class="width_6">{{totContainerHdr[2]}}</th>
               </tr>
               </table>
               </th>
               <th>{{totContainerHdr[0]}}</th>
              
             <th>{{totContainerHdr[1]}}</th>
             <th>{{totContainerHdr[2]}}</th>
              </tr>
              
          </thead>
          <tbody ng-repeat="portlist in portList">
          <tr>
          <td style="border: 1px solid black;" class="width_6">{{portlist.pol}}</td>
          <td style="border: 1px solid black;" class="width_6" ng-init="calculateGrantTot(portlist.slotTotal)">{{portlist.pod}}</td>
          <td style="border: 1px solid black;" class="width_6 text-right" ng-repeat="slottotal in portlist.slotTotal  track by $index">
          <span >{{slottotal}}</span>
          </td>
          </tr>
          </tbody>
         
         <tfoot>
          <tr >
          <th style="border: 1px solid black;" class="width_6" colspan="2" >Grand Total </th>                 
           <th style="border: 1px solid black;" class="text-right" ng-repeat="grandTot in totalArray track by $index">       
         {{grandTot}} 
             </th>
          </tr>
         </tfoot>
       
        </table>
</div>
<div class="excel"></div>
  <div class="form-actions">
        <div class="row">
         <div class="col-md-12">
        <a id="freightManifestExcelLink" stype="display:none" href="filePath/FreightManifest.xlsx" download="FreightManifest.xlsx"></a>
         
          <security:authorize access="hasRole('${form_code}_${export}')">
       <button class="btn btn-primary" ng-click="exportExcel()">
   Export Excel
  </button>
 </security:authorize> 
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>
    </div>
 </div>
</div>
  
