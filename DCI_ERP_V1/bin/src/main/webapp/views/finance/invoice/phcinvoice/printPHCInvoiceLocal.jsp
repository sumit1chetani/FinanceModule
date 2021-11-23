<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
.description, .description td {
 border-bottom: 1pt solid #fff;
 border-top: 1pt solid #fff;
}

.description1, .description1 td {
 border-bottom: 0px solid #fff;
}
/*  tr,td {
}
 */
.blterms {
 font-family: Bookman OLD style;
 font-size: 5px;
 font-weight: bold;
 font: normal;
 font-style: normal;
 text-align: justify;
 width: 30%;
}

.note_hdr {
 font-style: italic;
 font-weight: bold;
 font-size: 12px;
 font-family: arial;
}

.gridheadercell {
 color: #000000;
 background: #ffe6a2;
 text-align: center;
 FONT-FAMILY: Arial;
 FONT-SIZE: 8pt;
 padding: 2px;
 font-weight: bold;
}

.blprint {
 vertical-align: top;
 font-family: verdana;
 font-size: 11px;
 font-weight: bold;
}

.blprint1 {
 font-family: verdana;
 font-size: 10px;
 line-height: 1.5;
 text-align: justify;
}

.text_center {
 text-align: center
}

.text_right {
 text-align: right
}

.text_left {
 text-align: left
}

.width_100 {
 width: 100%;
}

.width_90 {
 width: 90%;
}

.width_95 {
 width: 95%;
}

.width_70 {
 width: 70%;
}

.width_50 {
 width: 50%;
}

.width_40 {
 width: 40%;
}

.width_30 {
 width: 30%;
}

.width_25 {
 width: 25%;
}

.width_15 {
 width: 15%;
}

.text_decoration {
 text-decoration: underline
}

.tablespace {
 padding-left: 5px;
}

.tablespace1 {
 padding-top: 5px;
 padding-bottom: 5px;
}

.tablespace2 {
 padding-top: 5px;
 padding-bottom: 5px;
 padding-left: 10px;
}

@page {
 size: A4 portrait; /* auto is the initial value */
 margin: 2mm; /* this affects the margin in the printer settings */
}

.normal {
 font-family: Arial, Helvetica, sans-serif;
 font-size: 11px;
 font-style: normal;
 font-weight: normal;
 color: #000000;
 text-decoration: none
}

.bold {
 font-family: Arial, Helvetica, sans-serif;
 font-size: 11px;
 font-style: normal;
 font-weight: bold;
 color: #000000;
 text-decoration: none;
 padding-left: 6px;
}

.footer {
 width: 100%;
 bottom: 0px;
}

.footer-text {
 font-family: Arial, Helvetica, sans-serif;
 font-size: 8pt;
 font-style: normal;
 font-weight: normal;
 color: #000000;
 text-decoration: none;
}
.padding-bottom-15p{
padding-bottom: 15px;
}
.padding-bottom-20p{
padding-bottom: 20px;
}
.padding-left-5p{
padding-left: 5px;
}
.padding-5p{
 padding: 5px
}
.padding-top-50{
 padding-top: 50px;
}
.padding-top-40{
 padding-top: 40px;
}
.padding-top-90{
 padding-top: 90px;
}
.custom-color-1 .table-striped>thead>tr>th {
 color: #fff;
 border-bottom: 1px solid rgba(255, 255, 225, .15);
 border-left: 1px solid rgba(255, 255, 225, .15);
 border-top: 1px solid rgba(255, 255, 225, .15);
 background: #42a5f5 !important;
}
.padding-left-0{
 padding-left: 0px !important;
}
.padding-top-5{
  padding-top: 5px !important;
}
.padding-top-20{
    padding-top: 20px;
}
.padding-top-10{
    padding-top: 10px;
}
.bank-details{
border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;
}
.footer-details{
font-family: "bookman old style"; border: 0; overflow: auto; font-weight: normal; font-size: x-small; line-height: 1.5em;
}
</style>
</head>
<body marginheight=0 marginwidth=0 topmargin=0 leftmargin=0
 style="background-color: white">
 <c:set var="object1" value="${phcInvoiceList}" />
 <c:set var="payerForIndia" value="${payerIndia}" />
 <%-- <c:set var="billofladingobject" value="${billoflading}" />
  --%>

 <c:set var="locationName" scope="session" value="DUBAI" />
 <c:set var="locationName1" scope="session" value="SINGAPORE" />
 <c:set var="locationName2" scope="session" value="AMERICA" />
 <c:set var="locationName3" scope="session" value="MUMBAI" />

 <c:set var="clocationName" scope="session" value="C0001" />
 <c:set var="clocationName1" scope="session" value="C0002" />
 <c:set var="clocationName2" scope="session" value="C0003" />
 <c:set var="clocationName3" scope="session" value="C0004" />
 <c:set var="clocationName5" scope="session" value="C0005" />
 <c:set var="clocationName6" scope="session" value="C0007" /> 
 
 <TABLE align="center" border="0" cellPadding="0" cellSpacing="0" width="95%">

  <TR>
   <td><br> <br> <br>
    <table border="0" class="width_100" cellpadding="0" cellspacing="0"
     bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
     <tr>
      <td>
       <c:choose>
        <c:when test="${payerForIndia ==  clocationName6}">
         <img src="/shipping/img/sfpl_logo_226x57.jpg" />
        </c:when>
        <c:otherwise>
         <c:if test="${locationName == object1.locationName}">
          <img src="/shipping/img/sfpl_logo_315x54.jpg" />
         </c:if> <c:if test="${locationName1 == object1.locationName}">
          <img src="/shipping/img/sfpl_logo_232x55.jpg" />
         </c:if> <c:if test="${locationName2 == object1.locationName}">
          <img src="/shipping/img/America_logo.jpg" />
         </c:if> <c:if test="${locationName3 == object1.locationName}">
          <img src="/shipping/img/sfpl_logo_226x50.jpg">
         </c:if>
        </c:otherwise>
       </c:choose>
      
      </td>
     </tr>
    </table> <br>
    <font face="arial" size="4"><b>INVOICE</b></font>
    <table class="width_100" align="center" border="0" cellPadding="0" cellSpacing="0">
     <tr>
      <td></td>
     </tr>
     <TR>
      <TD width=24%>

       <TABLE align=left border="1" cellPadding="2" cellSpacing="0" width=100%
        style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
        <TR>

         <TD align=left height="100%" style="padding-top: 14px;"><span class="normal"><b>${object1.accountName}<br>
            ${object1.payerAddress} <br> ${object1.payerAddress1} <br>
            Fax No :${object1.payerFaxNo}<br> 
            Tel No:  <br><br>
          </b></span></td>

        </tr>
       </table>
      </td>

      <TD width=2%>&nbsp;</td>

      <TD width=24% height="100%">
       <TABLE align=left border="1" cellPadding="2" cellSpacing="0" width=100%
        height="100%"
        style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
        <TR>


         <TD align=left height="100%">
          <table width=100% border="0" cellpadding="0" cellspacing="0"
           height="100%"
           style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
           <tr>
            <td width=25% align=left><span class=bold>Customer</span></td>
            <td><span class=bold>: ${object1.customerName}</span></td>
           </tr>
           <tr>
            <td width=25% align=left><span class=bold>Inv.
              No</span></td>
            <td><span class=bold>: ${object1.PHCInvoiceCode}</span></td>
           </tr>
           <tr>
            <td width=25% align=left><span class=bold>Inv.
              Date</span></td>
            <td><span class=bold>: ${object1.PHCInvoiceDate} </span></td>
           </tr>
           <tr>
            <td width=25% align=left><span class=bold>Vessel</span></td>
            <td><span class=bold>: ${object1.vesselName}</span>
           </tr>
           <tr>
            <td width=25% align=left><span class=bold>Voyage</span></td>
            <td><span class=bold>: ${object1.voyage} </span>
           </tr>
           <tr>
            <td width=25% align=left><span class=bold>Invoice No</span></td>
            <td><span class=bold>: ${object1.invoiceNo}</span></td>
           </tr>
           <tr>
            <td width=25% align=left><span class=bold>B/L No</span></td>
            <td><span class=bold>: ${object1.blNo}</span></td>
           </tr>
          </table>
         </td>
        </tr>
       </table>
      </td>
     </tr>
     <tr>
      <td colspan="3"></td>
     </tr>   
     <tr>
      <td  class="padding-top-5" colspan="3" valign="top"> 
       <table align="left" border="1" cellPadding="2" cellSpacing="0" class="width_100" >
        <thead>
         <tr>
          <th class="width_70"  height="10" valign=top><span class=normal><b>Description
             of Charges</b></span></th>
          <th class="width_15" align="center" class="" height="10" valign=top style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
           class=normal><b>TC Amount (${object1.currencyCode})</b></span></th>          
         </tr>
        </thead>
        <tbody>
        <c:forEach var="ob" items="${phcInvoiceList.phcInvQtyDescList}" varStatus="theCount">
         <c:if test="${ ob.bcamount > 0 }">
          <tr class="description">
           <td class="width_70" height="10" align=left valign="top" style="border-right: 0pt;"><span
            class="normal">
             <c:if test="${theCount.count == 1}">
              <b>Subject: </b><c:out value="${ob.polISOCode}-${ob.podISOCode}" /><br>
             </c:if>               
             <b><c:out value="${ob.accountHeadName}" /> </b><br>
             <c:out value="${ob.description}" />
           </span></td>
           <td  class="width_15 normal" height="10"  style="border-right: 0pt;" align="right" valign="top">
            <c:out value="${ob.tcamount}" /></td>           
          </tr>
         </c:if>
        </c:forEach>
         <tr class="description">
          <td class="width_70 normal" height="250" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>
          <td class="width_15 normal" height="250" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>
         </tr> 
        </tbody>
        <tfoot>
        <tr height=10>
         <td class="width_70" align=left class="width_70" valign=top><span
          class=normal><b> Exchange Rate:
            ${object1.exchangeRate}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total </b></span></td>

         <%-- <td class="width_15" class="width_15" align="right" valign=top
          style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
          class=normal><b> ${object1.totalbc}</b></span></td> --%>
         <td class="width_15" align="right" valign=top><span
          class=normal><b> ${object1.totaltc} </b></span></td>
          
        </tr>
        </tfoot>
       </table>
      </td>
     </tr>
    </table></td>
  </tr>
  <tr>
   <td>
    <table align="center" border="0" cellPadding="0" cellSpacing="0"
     class="width_95">
     <tr>
      <td class="padding-top-10"><span class=normal><b>E &amp;O.E.</b> <br> <c:out
         value="${object1.bcamountWords}" /><br> <c:out
         value="${object1.tcamountWords}" /> </span></td>
     </tr>
    </table>
   </td>
  </tr>
  <tr>
   <td>
    <table align="center" border="0" cellPadding="0" cellSpacing="0"
     class="width_95">
     <tr>
      <td align=left><br> <span class="note_hdr">Note:
        IN CASE OF ANY DISCREPANCIES ,PLEASE NOTIFY WITHIN 10 DAYS FROM
        DATE OF RECEIPT</span></td>
     </tr>
    </table>
   </td>
  </tr>
  <tr>
   <td>
    <table align="center" border="0" cellPadding="0" cellSpacing="0" class="width_95 padding-top-20 bank-details" height="100%">
     <tr>
      <td><span class=normal class="text_decoration"><b><u>Bank Details :</u><br></b></span></td>
     </tr>
     <tr>
      <td class="padding-top-10">
       <table align="left" border="0" cellPadding="0" cellSpacing="0" class="width_100"
        style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
        <tr>
         <td width="58%">
          <table align="right" border="1" cellPadding="0" cellSpacing="0" class="width_100" height="100%"
           style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
           
           <c:choose>
            <c:when test="${payerForIndia ==  clocationName1}">
             <TR>
              <td class="width_100"><span class=normal>XXXXXXXXXXXXX
                LTD<br> &nbsp;&nbsp;BRANCH : XXXXXXXX<br>
                &nbsp;&nbsp;BRANCH ADDRESS :XXXXXXXXXXXXX
                XXXXXXXXXXXXX<br> &nbsp;&nbsp;A/C No : XXXXXXXXXXXXX <br>
                &nbsp;&nbsp;NEFT / RTGS / IFSC CODE : XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;MICR CODE : XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;BENEFICIARY : XXXXXXXXXXXXXXX<br>
              </span></td>
             </tr>
            </c:when>
            <c:when test="${payerForIndia ==  clocationName6}">
            <TR>
            <td class="width_100"><span class=normal>PLEASE DRAW ALL CHEQUES IN FAVOR OF PARAGON DYNAMICS INFO SYSTEMS (P) LTD.<br><br></span>
            
            </td>
            
            </TR>
             <TR>
              <td class="width_100"><span class=normal>XXXXXXXXXXXXX<br>
               &nbsp;&nbsp;BRANCH : XXXXXXX<br>
               &nbsp;&nbsp;BRANCH ADDRESS :XXXXXXXXXXXXX<br> 
               &nbsp;&nbsp;EAST BLOCK, XXXXXXXXXXXXX<br>
               &nbsp;&nbsp;SWIFT CODE : XXXXXXXXXXXXX<br>
               &nbsp;&nbsp;LKR ACCOUNT : XXXXXXXXXXXXX<br>
               &nbsp;&nbsp;USD ACCOUNT : XXXXXXXXXXXXX<br>
               &nbsp;&nbsp;BENEFICIARY : PARAGON DYNAMICS INFO SYSTEMS (P) LTD<br>
               &nbsp;&nbsp;BENEFICIARY ADDRESS : NO.99 ST MICHAELA��S ROAD, COLOMBO 03<br>
               </span></td>

             </tr>
            </c:when>
            <c:when test="${payerForIndia== clocationName}">
             <TR>
              <td class="width_100"><span class=normal>
                Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<br>
                Bene Bank: National Bank of Fujairah PSC, Dubai<br>
                Swift Code: NBFUAEAFDXB<br><br><br>
                <span style="text-decoration: underline;"><b>For USD Remittance:</b></span><br>
                USD Acct.Num:  01 20 00 694 396<br> 
                IBAN (USD Acct): AE 78 0380 0000 1200 0694 396<br>
                Intermediary Bank:  JP Morgan Chase, New York<br>
                Swift Code: XXXXXXXXXXXXX<br><br><br> 
                <span style="text-decoration: underline;"><b>For AED Remittance:</b></span><br>
                AED Acct. Num.: 01 20 00 694 388<br> 
                IBAN (AED Acct): AE 03 0380 0000 1200 0694 388.<br>   
              </span></td>
             </tr>

            </c:when>
            <c:when test="${object1.companyCode == clocationName}">
             <TR>              
               <td class="width_100"><span class=normal>
                Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<br>
                Bene Bank: National Bank of Fujairah PSC, Dubai<br>
                Swift Code: NBFUAEAFDXB<br><br><br>
                <span style="text-decoration: underline;"><b>For USD Remittance:</b></span><br>
                USD Acct.Num:  01 20 00 694 396<br> 
                IBAN (USD Acct): AE 78 0380 0000 1200 0694 396<br>
                Intermediary Bank:  JP Morgan Chase, New York<br>
                Swift Code: XXXXXXXXXXXXX<br><br><br> 
                <span style="text-decoration: underline;"><b>For AED Remittance:</b></span><br>
                AED Acct. Num.: 01 20 00 694 388<br> 
                IBAN (AED Acct): AE 03 0380 0000 1200 0694 388.<br>    
              </span></td>
             </tr>

            </c:when>
            <c:when
             test="${object1.companyCode == clocationName2 || object1.companyCode == clocationName3  || object1.companyCode == clocationName4 }">
             <tr><td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXX
              </span></td>
             </tr>
            </c:when>
            <c:when test="${object1.companyCode == clocationName1}">
             <TR>
              <td><span class=normal> &nbsp;&nbsp;STANDARD
                CHARTERED BANK<br> &nbsp;&nbsp;XXXXXXXXXXXXX
                XXXXXXXXXXXXX<br> &nbsp;&nbsp;IFSC/NEFT CODE :
                XXXXXXXXXXXXX MIRC CODE : XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;IRS Current A/c XXXXXXXXXXXXX<br>
                &nbsp;&nbsp;PAN :XXXXXXXXXXXXX , SERVICE TAX NO :
                AAJCS7502DST001
              </span></td>
             </tr>
            </c:when>
            <c:otherwise>
             <tr>
              <c:if test="${locationName == object1.locationName}">
               <td><span class=normal>
                Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<br>
                Bene Bank: National Bank of Fujairah PSC, Dubai<br>
                Swift Code: NBFUAEAFDXB<br><br><br>
                <span style="text-decoration: underline;"><b>For USD Remittance:</b></span><br>
                USD Acct.Num:  01 20 00 694 396<br> 
                IBAN (USD Acct): AE 78 0380 0000 1200 0694 396<br>
                Intermediary Bank:  JP Morgan Chase, New York<br>
                Swift Code: XXXXXXXXXXXXX<br><br><br> 
                <span style="text-decoration: underline;"><b>For AED Remittance:</b></span><br>
                AED Acct. Num.: 01 20 00 694 388<br> 
                IBAN (AED Acct): AE 03 0380 0000 1200 0694 388.<br>    
              </span></td>
              </c:if>
              <c:if test="${locationName1 == object1.locationName}">
               <br>
               <td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXX <br></span></td>
               <br>

              </c:if>
              <c:if test="${locationName2 == object1.locationName}">
               <td><span class=normal> &nbsp;&nbsp;
                 XXXXXXXX.<br> &nbsp;&nbsp;XXXXXXXXXXXXX,
                 N.A<br> &nbsp;&nbsp;Po BOX XXXXXXXX<br>
                 &nbsp;&nbsp;XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;Account number- XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;Chase SWIFT Code: XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;Routing No: XXXXXXXXXXXXX
               </span></td>

              </c:if>
              <c:if test="${locationName3 == object1.locationName}">
               <td><span class=normal> &nbsp;&nbsp;STANDARD
                 CHARTERED BANK<br> &nbsp;&nbsp;XXXXXXXXXXXXX
                 XXXXXXXXXXXXX<br> &nbsp;&nbsp;IFSC/NEFT CODE :
                 XXXXXXXXXXXXX MIRC CODE : XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;IRS Current A/c XXXXXXXXXXXXX<br>
                 &nbsp;&nbsp;PAN :XXXXXXXXXXXXX , SERVICE TAX NO :
                 AAJCS7502DST001
               </span></td>

              </c:if>
             </tr>
            </c:otherwise>
           </c:choose>
          </table>
         </td>
         <td width="65%">
          <table border="0" cellPadding="2" cellSpacing="0" class="width_100">
           <tr>
            <td>
             <table class="width_100" border="0" cellpadding="0" cellspacing="0">
              <tr>
               <td class="bold text_right"> PARAGON DYNAMICS INFO SYSTEMS (P) LTD</td>
              </tr>
                  <tr>
               <td class="bold text_right"><br><br> ${object1.invCreatedUser}</td>
              </tr>              
              <!-- <tr>
               <td class="bold text_right">FORWARDING L.L.C</td>
              </tr>
              <tr>
               <td class="bold text_right">ADMINISTRATOR</td>
              </tr> -->
             </table>
            </td>
           </tr>
          </table>
         </td>
        </tr> <!-- emd -->
        <!-- <tr>
         <td valign="bottom" class="padding-top-20"><span class=normal>Page No 1 of 1<br></span></td>
        </tr>
        <tr>
         <td colspan="2"><span class="normal"><br>THIS IS A COMPUTER GENERATED
          INVOICE.  NO SIGNATURE IS REQUIRED</span></td>
        </tr> --> <!-- computer generated invoice - end -->
        <tr>
         <td class="padding-top-90" colspan="2" align="center">
          <span class="footer-details">
          ${object1.companyAddress}<br>
           Tel.:${object1.companyPhoneNo}&nbsp;FAX:${object1.companyFaxNo}&nbsp;
           e-mail : <span
           style="text-transform: lowercase; text-decoration: underline;">${object1.companyEmail}</span><br>
           &nbsp;Website: www.paragondynamics.in&nbsp;
          </span>
         </td>
        </tr>
       </table>
      </td>
     </tr>
    </table></td>
  </tr>
  
 </table><br><br><br><br><br><br><br><br>  
 <table width="100%">
  <tr>
   <td class="normal">***This is a Computer Generated BL and does
    not requires signature and seal*****</td>
   <TD class="normal" style="text-align: right">Page 1 of 2</TD>
  </tr>
 </table><br><br><br><br><br><br> 
 <table border="1" width="90%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
  <tr>
   <td class="gridheadercell" colspan="12">CONTAINERS DETAILS</td>
  </tr>
  <tr>
   <td class="gridheadercell">S.No</td>
   <!-- <td class="gridheadercell">Ex-Voyage</td> -->
   <td class="gridheadercell">Voyage</td>
   <td class="gridheadercell">MLO</td>
   <td class="gridheadercell">POL</td>
   <td class="gridheadercell">POD</td>
   <td class="gridheadercell">TYPE</td>
   <td class="gridheadercell">CONTAINER_NO</td>
   <td class="gridheadercell">SLOT_SIZE</td>

   <td class="gridheadercell">WEIGHT</td>
   <td class="gridheadercell">IMCO</td>

   <td class="gridheadercell">REFER</td>
   <td class="gridheadercell">Remarks</td>
  </tr>
  <c:set var="index" value="0"></c:set>  
  <c:forEach var="slotmessageList" items="${phcInvoiceList.slotMsgList}" varStatus="theCount">
   <tr>
    <td class="tablespace"><span class=normal>${theCount.count}</span></td>
    <%-- <td class="tablespace"><span class=normal>${slotmessageList.voyageCode}</span></td> --%>
    <td class="tablespace"><span class=normal>${object1.voyage}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.mloName}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.polISOCode}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.podISOCode}</span></td>

    <td class="tablespace"><span class=normal>${slotmessageList.containerType}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.containerNumber}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.slotSize}</span></td>

    <td class="tablespace"><span class=normal>${slotmessageList.weight}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.imcoCode}</span></td>

    <td class="tablespace"><span class=normal>${slotmessageList.refer}</span></td>
    <td class="tablespace"><span class=normal>${slotmessageList.remarks}</span></td>
   </tr>
  </c:forEach>
 </table><br><br><br><br><br><br> <br><br><br><br><br><br> 
 <table width="100%">
  <tr>
   <TD class="normal" style="text-align: right">Page 2 of 2</TD>
  </tr>
 </table><br><br><br><br><br><br> 
</body>
</html>