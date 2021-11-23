 <style>
 .ngdialog-overlay{
 
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	    max-width: 150%;
    width: 150%;
    position: absolute;
    top: 20%;
    left: 2%;
    margin: 0 auto;
}
</style>
<div class="wrapper-md">
	
<div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollectionSummary">
   <div class="row">
   <div class="col-sm-20">
		   <div class="table-responsive" >
		  
		    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
  <tbody>
  <tr>
  	<td class="width_1"><label >Vessel</label></td>
  	<td class="width_1"><label >{{vesselCode}}</label></td>
  	<td class="width_1"><label >Voyage</label></td>
  	<td class="width_1"><label >{{voyageId}}</label></td>
  <!-- </tr>
  <tr> -->
  	<td class="width_1"><label >POL</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryPol}}</label></td>
  	<td class="width_1"><label >POD</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryPod}}</label></td>
  	</tr>
  <tr>
  <td class="width_1"><label >Customer</label></td>
  	<td class="width_1"><label >{{submitShortMlo}}</label></td>
  	<td class="width_1"><label >Payer</label></td>
  	<td class="width_1"><label >{{submitShortPayer}}</label></td>
  <!-- </tr>
  <tr> -->
  <td class="width_1"><label >Currency</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summaryCurrency}}</label></td>
  	<td class="width_1"><label >Exchange Rate</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryex_rate}}</label> </td>
  </tr>
  
  <tr>
  <td class="width_1"><label >Quotation No</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryQuotationNo}}</label>     
     </td>
  	<td class="width_1"> <label >Valid Till</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summaryValidTill}}</label></td>
  <!-- </tr>
  <tr> -->
  <td class="width_1"><label >Remarks</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryQuotationRemarks}}</label></td>
  </tr>
  </tbody>
		     
		    </table>
		    <table class="table table-striped b-t b-light table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th colspan="2" rowspan="2" class="text-center" valign="top">Charges</th>
      <!--  <th colspan="2" ng-repeat="objCont in containersList" class="text-center">{{objCont.containerType}} </th>  -->
      <th colspan="2" class="text-center" valign="top" >M20</th>
      <th colspan="2" class="text-center" valign="top" >M40</th>
      <th colspan="2" class="text-center" valign="top" >M45</th>
      
      <th colspan="2" class="text-center" valign="top" >D20</th>
      <th colspan="2" class="text-center" valign="top" >D40</th>
      <th colspan="2" class="text-center" valign="top" >D45</th>
      
      <th colspan="2" class="text-center" valign="top" >R20</th>
      <th colspan="2" class="text-center" valign="top" >R40</th>
      
      <th colspan="2" class="text-center" valign="top" >OOG20</th>
      <th colspan="2" class="text-center" valign="top" >OOG40</th>
      
      <th colspan="2" class="text-center" valign="top" >RI20</th>
      <th colspan="2" class="text-center" valign="top" >RI40</th>
      
      <th colspan="2" class="text-center" valign="top" >FLEXI 20</th>
      <th colspan="2" class="text-center" valign="top" >FLEXI 40</th>
      
      <th colspan="2" class="text-center" valign="top" >IM51 20</th>
      <th colspan="2" class="text-center" valign="top" >IM51 40</th>
      
      
     <!--  <th colspan="2" class="text-center" valign="top" >OOG SL </th> -->
      
      
      <th rowspan="2" colspan="2" class="text-center" valign="top" >MT Qty.</th>
      <th rowspan="2" colspan="2" class="text-center" valign="top" >MT Amt.</th>
      
      <th rowspan="2" colspan="2" class="text-center" valign="top" >LDN Qty.</th>
      <th rowspan="2" colspan="2" class="text-center" valign="top" >LDN Amt.</th>
      
      <th rowspan="2" colspan="2" class="text-center" valign="top" >Total Qty.</th>
      
<!--       <th colspan="2" class="text-center" valign="top" >R20</th>
      <th colspan="2" class="text-center" valign="top" >R40</th>
      
      <th colspan="2" class="text-center" valign="top" >OOG20</th>
      <th colspan="2" class="text-center" valign="top" >OOG40</th>
      
      <th colspan="2" class="text-center" valign="top" >RI20</th>
      <th colspan="2" class="text-center" valign="top" >RI40</th> -->
      
    	 <th rowspan="2" colspan="3" class="text-center" valign="top" >Total Amount</th>
      </tr>
       <tr class="width_20" >
           
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>
               
              <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th>               
               
<!--               <th colspan="2" >
              <table style="width: 100%">
              <tr>
               <th class="width_8 text-center">Qty</th>&nbsp;
               <th class="width_8 text-center">Rate</th>
               </tr>
               </table>
               </th> -->
               
                                                                                                                                                                                    
              </tr>
      
     </thead>
     <tbody>
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in rowCollectionSummary" >
       
       <td class="width_1">{{objItem.summarySlno}}</td>
       <td class="width_1">{{objItem.surchargeName}}</td>
       <td class="width_1" data-ng-class="$index % 2 == 0? 'rate_color' : 'qty_color'" ng-repeat="obj in objItem.ratelist track by $index">{{obj}}</td>  
       
       <td colspan="2" class="width_1 rate_color">{{objItem.mtQty}}</td>
       <td colspan="2" class="width_1 qty_color">{{objItem.mtAmt}}</td>
       
       <td colspan="2" class="width_1 rate_color">{{objItem.ldnQty}}</td>
       <td colspan="2" class="width_1 qty_color">{{objItem.ldnAmt}}</td>
       
       <td colspan="2" class="width_1 rate_color">{{objItem.totQty}}</td>
       <td colspan="2" class="width_1 qty_color">{{objItem.total}}</td>   
       </tr>  
      <tr x-ng-show="showEmptyLabel">
       <td colspan="6">No Records Found</td>
      </tr>
     </tbody>
    </table>
		   </div>
  
		 
		</div>
	</div>
	<div class="row"><br></div>

	
	 <div align="center">
				<div class="row">
					<div class="col-md-12">
	   					<button class="btn btn-danger" ng-click="cancelng()" type="button">Close</button>
	   				</div>
	   			</div>
	</div>
	<div class="row"><br></div>
  </div>
  <footer class="panel-footer">
   </footer>
</div>