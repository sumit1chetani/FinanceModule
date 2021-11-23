<div class="wrapper-md">
 <div class="panel panel-default"  st-table="displayCollection" st-safe-src="rowCollection" >
  <div class="panel-heading padding-right-0 padding-left-0 panel-heading-list-page float-left font-bold">
   <div class="col-sm-3 col-md-9 padding-right-0 padding-left-0 header-with-breadcrumb">
   <!--  <span class="ui-separator"></span> -->
    <ol class="breadcrumb inline-block padding-left-10">
     <li>
      <a></a>
     </li>
    </ol>
   </div>
 
  </div>
   <div class="panel-body float-left padding-0">
   <form class="form-horizontal" name="invoiceGenerateForm" role="form"  
   ng-submit= "invoiceSummaryForm(invoiceSummaryForm,invoiceSummaryData)" novalidate>  
  <table border="1" cellspacing="2" cellpadding="3" class="text-center">
  <tbody>
  <tr>
  	<td class="width_1"><label >Vessel</label></td>
  	<td class="width_1"><label >{{vesselCode}}</label></td>
  	<td class="width_1"><label >Voyage</label></td>
  	<td class="width_1"><label >{{voyageId}}</label></td>
  </tr>
  <tr>
  	<td class="width_1"><label >POL</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryPol}}</label></td>
  	<td class="width_1"><label >POD</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summaryPod}}</label></td>
  	</tr>
  <tr>
  <td class="width_1"><label >Customer</label></td>
  	<td class="width_1"><label >{{submitShortMlo}}</label></td>
  	<td class="width_1"><label >Payer</label></td>
  	<td class="width_1"><label >{{submitShortPayer}}</label></td></tr>
  <tr>
  <td class="width_1"><label >Currency</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summaryCurrency}}</label></td>
  	<td class="width_1"><label >Exchange Rate</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summryex_rate}}</label> </td></tr>
  <tr>
  <td class="width_1"><label >Quotation No</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.sumaryQuotationNo}}</label>     
     </td>
  	<td class="width_1"> <label >Valid Till</label></td>
  	<td class="width_1"><label >{{invoiceSummaryResultData.summaryValidTill}}</label></td></tr>
  <tr>
  <td class="width_1"><label >Remarks</label></td>
  	<td class="width_1"><label >{{submitFLSRemarks}}</label></td>
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
      
      <!-- <th colspan="2" class="text-center" valign="top" >R20</th>
      <th colspan="2" class="text-center" valign="top" >R40</th>
      
      <th colspan="2" class="text-center" valign="top" >OOG20</th>
      <th colspan="2" class="text-center" valign="top" >OOG40</th>
      
      <th colspan="2" class="text-center" valign="top" >RI20</th>
      <th colspan="2" class="text-center" valign="top" >RI40</th> -->
      
    	 <th rowspan="2" colspan="2" class="text-center" valign="top" >MT Qty.</th>
    	 <th rowspan="2" colspan="2" class="text-center" valign="top" >LDN Qty.</th>
    	 <th rowspan="2" colspan="2" class="text-center" valign="top" >Total Qty.</th>
    	 
    	 <th rowspan="2" colspan="3" class="text-center" valign="top" >Total Amount</th>
    	 
      </tr>
       <tr class="width_12" >
           
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
               </th> -->
               
                                                                                                                                                                                    
              </tr>
      
     </thead>
     <tbody>
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in rowCollection" >
       
       <td class="width_1">{{objItem.summarySlno}}</td>
       <td class="width_1">{{objItem.surchargeName}}</td>
       <td class="width_1" ng-repeat="obj in objItem.ratelist track by $index">{{obj}}</td>  
       <td colspan="2" class="width_1">{{objItem.mtQty}}</td>
       
       <td colspan="2" class="width_1">{{objItem.ldnQty}}</td>
       <td colspan="2" class="width_1">{{objItem.totQty}}</td>
       <td colspan="2" class="width_1">{{objItem.total}}</td>
        
       <td class="width_1"></td>    
       </tr>  
      <tr x-ng-show="showEmptyLabel">
       <td colspan="6">No Records Found</td>
      </tr>
     </tbody>
    </table>



   
  <!--  <div class="form-actions">
			<div class="row">
			<div class="col-md-12">
															
	</div>
</div>
</div> -->

   <div class="form-actions">
			<div class="row">
			<div class="col-md-12">
		<button class="btn btn-success"
		type="button" ng-click="goBack()">
	 Close
	</button>

	</div>
</div>
</div>


   <footer class="panel-footer">  
    <%--  <%@include file="/views/templates/panel-footer-static.jsp"%> --%>
   </footer>	
   </form>				
  </div>
 </div>
</div>
