<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>

<c:set var="object1" value="${paySlipReportList}" />
<c:set var="object2" value="${paySlipReportObj}" />
<c:set var="cmpyAddress" value="${companydetail}" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style type="text/css">
body {
    background-color: #FFFFFF;
    color: #000;
   
}

.table > tbody > tr > td {
  padding: 8px 15px;
  var
 
  
}
.table > thead > tr > th{
text-align:left !important;
padding: 8px 15px;

}

.form-horizontal{
  margin-right: -15px;
  margin-left: -15px;
}
.padding-20p{
    padding: 20px;

    border-style:dotted;
}
.padding-top-10{
	padding-top: 10px;
}
 
.width_auto {
	width: auto;
}

.width_10px {
	width: 10px;
}

.width_05 {
	width: 0.50%;
}

.width_1 {
	width: 1%;
}

.width_2 {
	width: 2%;
}

.width_3 {
	width: 3%;
}

.width_4 {
	width: 4%;
}

.width_5 {
	width: 5%;
}

.width_6 {
	width: 6%;
}

.width_7 {
	width: 7%;
}

.width_8 {
	width: 8%;
}

.width_9 {
	width: 9%;
}

.width_10 {
	width: 10%;
}

.width_11 {
	width: 11%;
}

.width_12 {
	width: 12%;
}

.width_13 {
	width: 13%;
}

.width_14 {
	width: 14%;
}

.width_15 {
	width: 15%;
}

.width_16 {
	width: 16%;
}

.width_17 {
	width: 17%;
}

.width_18 {
	width: 18%;
}

.width_19 {
	width: 19%;
}

.width_20 {
	width: 20%;
}

.width_21 {
	width: 21%;
}

.width_22 {
	width: 22%;
}

.width_23 {
	width: 23%;
}

.width_24 {
	width: 24%;
}

.width_25 {
	width: 25%;
}

.width_26 {
	width: 26%;
}

.width_27 {
	width: 27%;
}

.width_28 {
	width: 28%;
}

.width_29 {
	width: 29%;
}

.width_30 {
	width: 30%;
}

.width_31 {
	width: 31%;
}

.width_32 {
	width: 32%;
}

.width_33 {
	width: 33%;
}

.width_34 {
	width: 34%;
}

.width_35 {
	width: 35%;
}

.width_36 {
	width: 36%;
}

.width_37 {
	width: 37%;
}

.width_38 {
	width: 38%;
}

.width_39 {
	width: 39%;
}

.width_40 {
	width: 40%;
}

.width_41 {
	width: 41%;
}

.width_42 {
	width: 42%;
}

.width_43 {
	width: 43%;
}

.width_44 {
	width: 44%;
}

.width_45 {
	width: 45%;
}

.width_46 {
	width: 46%;
}

.width_47 {
	width: 47%;
}

.width_48 {
	width: 48%;
}

.width_49 {
	width: 49%;
}

.width_50 {
	width: 50%;
}

.width_51 {
	width: 51%;
}

.width_52 {
	width: 52%;
}

.width_53 {
	width: 53%;
}

.width_54 {
	width: 54%;
}

.width_55 {
	width: 55%;
}

.width_56 {
	width: 56%;
}

.width_57 {
	width: 57%;
}

.width_58 {
	width: 58%;
}

.width_59 {
	width: 59%;
}

.width_60 {
	width: 60%;
}

.width_61 {
	width: 61%;
}

.width_62 {
	width: 62%;
}

.width_63 {
	width: 63%;
}

.width_64 {
	width: 64%;
}

.width_65 {
	width: 65%;
}

.width_66 {
	width: 66%;
}

.width_67 {
	width: 67%;
}

.width_68 {
	width: 68%;
}

.width_69 {
	width: 69%;
}

.width_70 {
	width: 70%;
}

.width_71 {
	width: 71%;
}

.width_72 {
	width: 72%;
}

.width_73 {
	width: 73%;
}

.width_74 {
	width: 74%;
}

.width_75 {
	width: 75%;
}

.width_76 {
	width: 76%;
}

.width_77 {
	width: 77%;
}

.width_78 {
	width: 78%;
}

.width_79 {
	width: 79%;
}

.width_80 {
	width: 80%;
}

.width_81 {
	width: 81%;
}

.width_82 {
	width: 82%;
}

.width_83 {
	width: 83%;
}

.width_84 {
	width: 84%;
}

.width_85 {
	width: 85%;
}
.width_100 {
	width: 100%;
}
.footer{
    width: 100%;
    position: fixed;
    bottom: 0px;
     display: none !important
}
.footer-text{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    font-style: normal;
    font-weight: normal;
    color: #000000;
    text-decoration: none;
}

  
   
.header-bg{
	background-color: #3299CC;
	color: #fff;
    font-weight: bold;
    font-family: sans-serif;
}
.text-wrap {
	white-space: -moz-pre-wrap; /* Firefox */
	white-space: -o-pre-wrap; /* Opera */
	white-space: pre-wrap; /* Chrome */
	word-wrap: break-word; /* IE */
}
.bold{
	font-weight: bold;
}
.dotted-border{
	border:1px dotted;
}
</style>
<body>
	<form class="form-horizontal" action="printpaySlipReport">
	
		<table width="100%" border="0" cellspacing="0" cellpadding="2">	
		<tr>		
			<!-- <td>
				<img src="/img/his.png" alt="ECS-logo" />
			</td> -->	
		</tr>
		<tr>
		  <td colspan=3 align="center" style="padding-bottom : 20px; ">
	   <font face="arial" size="4"><b>${cmpyAddress}</b></font> 
		 <%--  <span>${object1.cmpyadd}</span> --%>
		  </td> 	
		
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="2">	
		<tr>		
			<!-- <td>
				<img src="/img/his.png" alt="ECS-logo" />
			</td> -->	
		</tr>
		<tr>
		  <td colspan=3 align="center" style="padding-bottom : 20px;  color: #2e87ba;"><font face="arial" size="4"><b>PaySlip Report</b><font face="arial" size="4"><b>  ${monthdetail}</b></font> 
		   </font></td> 	
		</tr>
	</table>
	<%-- <c:if test="${object1.size() >= 1}"> --%>
	 <c:forEach items="${paySlipReportList}" var="payslip" >
			<table table width="60%" style="float: left; padding-top: 10px;padding-left: 10%;">
				<tbody>
				
				<tr>
							<td class="width_30" style="font-size: 14px;">ORGANISATION :</td>
							<td style="font-size: 14px;"><b>: ${payslip.company}</b></td>
						</tr>
						
						<tr>
							<td class="width_30" style="font-size: 14px;">MONTHYEAR  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.month_year}</b></td>
						</tr>
						
						<%-- <tr>
							<td class="width_30" style="font-size: 14px;">LOP DAYS  :</td>
							<td style="font-size: 14px;"><b>${payslip.lopDays}</b></td>
						</tr> --%>
						<tr>
							<td class="width_30" style="font-size: 14px;">EMPLOYEE ID  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.empId}</b></td>
						</tr>
						
						<tr>
							<td class="width_30" style="font-size: 14px;">DESIGNATION  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.desgination}</b></td>
						</tr>
						
						
						
						<tr>
							<td class="width_30" style="font-size: 14px;">NUMBER OF LEAVES TAKEN  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.leaveTaken}</b></td>
						</tr>
						
						<tr>
							<td class="width_30" style="font-size: 14px;">BANK NAME :</td>
							<td style="font-size: 14px;"><b>: ${payslip.paybankname}</b></td>
						</tr>
						
						
						<%-- <tr>
							<td class="width_30" style="font-size: 14px;">WORKING DAYS  :</td>
							<td style="font-size: 14px;"><b>${payslip.leaveTaken}</b></td>
	
					
						
						
						<tr> --%>
							<td class="width_30" style="font-size: 14px;">NUMBER OF LEAVES AVAILABLE  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.leaveAvailable}</b></td>
						</tr>
					
					</tbody>
			</table>
			<table table width="40%" style="float: right; padding-top: 10px;">
				<tbody>
							<tr>
							<td class="width_30" style="font-size: 14px;">PF NO  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.epfno}</b></td>
						</tr>
						
						<tr>
							<td class="width_30" style="font-size: 14px;">ESI NO  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.esicode}</b></td>
						</tr>
						
						<tr>
							<td class="width_30" style="font-size: 14px;">BANK NO :</td>
							<td style="font-size: 14px;"><b>: ${payslip.bankno}</b></td>
						</tr>
						
						
						 <tr>
							<td class="width_30" style="font-size: 14px;">LOP DAYS  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.lopDays}</b></td>
						</tr> 
						<tr>
							<td class="width_30" style="font-size: 14px;">UAN NO  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.uanno}</b></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 14px;">Date Of Joining :</td>
							<td style="font-size: 14px;"><b>: ${payslip.doj}</b></td>
						</tr>
						
						 <tr>
							<td class="width_30" style="font-size: 14px;">LOP AMOUNT  :</td>
							<td style="font-size: 14px;"><b>: ${payslip.lopAmount}</b></td>
						</tr> 
						
					</tbody>
			</table>
			<br>
			<br><br><br>
						<br><br><br>
			
					<!-- <tr class="b-l b-r"> -->

						<!-- 			   <table style="padding-left: 82px; width:90%;" >
 -->
						<!--   <table class="table table-striped " border ="1px solid black;" style ="padding-left: 82px;">  -->
						<table class="table table-striped table-hover dataTable no-footer" style="border: 1px solid black;border-collapse: collapse; margin-left: 10%; width:80%;">
							<thead class="dataTables-Main-Head">
								<tr  style="border: 1px solid black;border-collapse: collapse;">
									<th colspan="2" class="text-center"  style="border: 1px solid black;border-collapse: collapse;">EARNINGS</th>
									<th colspan="2" class="b-l text-center">DEDUCTIONS</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body"  style="border: 1px solid black;border-collapse: collapse;">
								<tr class="b-l b-r" >
								<td colspan="2"  style="border: 1px solid black;border-collapse: collapse;">
									<table width="92%" class="table table-striped">
										<c:forEach items="${payslip.earningsList}" var="earnings">
											<tr>
												<td style="width: 100%">${earnings.paycomponentname}</td>
												<td class="text-center">${earnings.printamount}</td>
											</tr>
										</c:forEach>
									</table>
								</td>
								<td colspan="2" class="b-l">
									<table width="89%" class="table table-striped">
										<c:forEach items="${payslip.deductionsList}" var="deduction">
											<tr>
												<td style="width: 100%">${deduction.paycomponentname}</td>
												<td class="text-center">${deduction.printamount}</td>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
							<tr  style="border: 1px solid black;border-collapse: collapse;"> 
								<th class="text-right"  >GROSS PAY</th>
 								<th class="text-right" style=" border: 1px solid black;border-collapse: collapse;">${object2.earnings}</th>
								<th class="text-right">NET PAY</th>
								<th class="text-right" style="border: 1px solid black;border-collapse: collapse;">${object2.deductions}</th>
							</tr>
							</tbody>
						</table>
		</c:forEach>
	<%-- </c:if> --%>
	</form>
</body>
</html>