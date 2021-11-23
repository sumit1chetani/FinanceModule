<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<style>
			.wrapper-md {
			  padding: 4px 20px !important;
			}
			.panel-default {
			 /*  border-color: #ddd; */
			}
			.panel-default-form {
			  margin-bottom: 5px;
			  border: 0px;
			}
			.panel {
			  margin-bottom: 20px;
			  background-color: #fff;
			  /* border: 1px solid transparent; */
			  border-radius: 4px;
			  /* -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
			  box-shadow: 0 1px 1px rgba(0, 0, 0, .05); */
			}
			.row {
			  margin-right: -15px;
			  margin-left: -15px;
			}
			.col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
			  position: relative;
			  min-height: 1px;
			  padding-right: 15px;
			  padding-left: 15px;
			}
			.col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-10, .col-lg-11, .col-lg-12 {
			  float: left;
			}
			@media (min-width: 1200px){
				.col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-10, .col-lg-11, .col-lg-12 {
				  float: left;
				}
				.col-lg-12 {
				  width: 100%;
				}
			}
			@media (min-width: 1200px){
			.col-lg-6 {
			  width: 50%;
			}
			.col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-10, .col-lg-11, .col-lg-12 {
			  float: left;
			}
			}
			.text-center {
			  text-align: center !important;
			}
			.text-left {
			  text-align: left;
			}
			.text-right {
			  text-align: right;
			}
			.m-n {
			  margin: 0 !important;
			}
			.no-border {
			  border: 0px;
			}
			fieldset {
			  min-width: 0;
			  padding: 0;
			  margin: 0;
			  border: 0;
			}
			legend {
			  display: block;
			  width: 100%;
			  padding: 0;
			  margin-bottom: 20px;
			  font-size: 21px;
			  line-height: inherit;
			  color: #333;
			  border: 0;
			  border-bottom: 1px solid #e5e5e5;
			}
			table {
			  border-spacing: 0;
			  border-collapse: collapse;
			}
			table {
			  background-color: transparent;
			}
			td, th {
			  padding: 5px;
			}
			th {
			  text-align: left;
			}
			.width_20{
			  width: 20%;
			}
			.width_100{
				width: 100%;
			}
			.width_75 {
			  width: 75%;
			}
			.col-xs-12 {
			  width: 100%;
			}
			.col-xs-1, .col-xs-2, .col-xs-3, .col-xs-4, .col-xs-5, .col-xs-6, .col-xs-7, .col-xs-8, .col-xs-9, .col-xs-10, .col-xs-11, .col-xs-12 {
			  float: left;
			}
			.col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
			  position: relative;
			  min-height: 1px;
			  padding-right: 15px;
			  padding-left: 15px;
			}
			.padding-left-10 {
			  padding-left: 10px !important;
			}
			.col-xs-4 {
			  width: 33.33333333%;
			}
			.form-group {
			  margin-bottom: 5px !important;
			}
			.bold {
			  font-weight: bold;
			}
			.bg-bank-accounts{
			background-color:#cfdadd
			}
			.text-font-size-20p{
				font-size: 20px;
			}
			
			.height-38p{
				height: 38px;
			}
			.padding-top-10 {
				padding-top: 10px !important;
			}
			.padding-top-20 {
				padding-top: 20px !important;
			}
			.padding-top-30{
				padding-top: 30px !important;
			}
			.padding-top-40{
				padding-top: 40px !important;
			}
			.padding-top-50{
				padding-top: 50px !important;
			}
			.padding-top-55{
				padding-top: 55px !important;
			}
			.padding-top-60{
				padding-top: 60px !important;
			}
			
		@page {
		  size: A4;
		  margin: 0;
		}
		 .page {
	        width: 210mm;
	        min-height: 297mm;
	        padding: 20mm;
	        margin: 10mm auto;
	      
	        border-radius: 5px;
	        background: white;
	    }
		@media print {
				 html, body {
				    width: 210mm;
				    height: 297mm;
				  }
				
			  a[href]:after {
			    content: " (" attr(href) ")";
			  }
		  	#section-to-print {
				position: absolute !important;
				left: 0 !important;
				top: 10px !important;
			}
			
			
		}
			
			
		</style>
	</head>
	 
	<body>
		<c:set var="object1" value="${charterReportList}" />
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<div class="wrapper-md" style="padding: 20px;">
					  <div id="generatePdf">
						<div class="row page" id="section-to-print">
						     <div class="col-sm-12 col-md-12 col-lg-12 width_100 pull-left">
							     <div class="col-sm-6 col-md-6 col-lg-6 width_50">
								    <div class="form-group">
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;">Date: </label>
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;">${object1.charterDate}</label>					     		
							     	</div>
							     	<div class="form-group">					     		
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;">Charter Hire No: </label>
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;">${object1.charterHireNo} </label>
							     	</div>
							     </div>
						     </div>
						      
						      <div class="col-sm-12 col-md-12 col-lg-12 width_100" st-table="displayedCollection" st-safe-src="rowCollection">
					     		<fieldset class="b-a">
						      		<legend class="width_100 text-center no-border m-n">CHARTER HIRE STATEMENT</legend>
						      		<legend class="width_100 text-center no-border m-n text-font-size-20p">Vessel: 
						      		</legend>
						      		<legend class="width_100 text-center no-border m-n text-font-size-20p">${object1.vesselName} </legend>
						      	
									<table align="center" border=1 width="100%">
										<thead border="1">
											<tr>
												<th colspan=1 class="width_2 no-border height-38p"></th>
												<th colspan=1 class="width_70 height-38p text-center no-border"></th>
												<th colspan=1 class="width_20 text-center height-38p bold" style="background-color: #cfdadd;">
												Total in USD
												</th>							
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="width_2">A</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														Period
													</div>													
												</td>
												<td class="width_20"></td>
											</tr>
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<c:forEach var="ob"  items="${charterReportList.rowData}"> 
													
															<div class="padding-top-20 row">
															
																<div class="col-xs-12">
																	<div class="col-xs-4">
																		<div class="form-group">
																			From
																		</div>												
																	</div>
																	<div class="col-xs-4">
																		<div class="form-group">
																			<span><c:out value="${ob.chFromDate}"/></span>
																			<span><c:out value="${ob.currencyCode}"/></span>
																		</div>												
																	</div>
																</div>
																<div class="col-xs-12">
																	<div class="col-xs-4">
																		<div class="form-group">
																			Till
																		</div>												
																	</div>
																	<div class="col-xs-4">
																		<div class="form-group">
																			<span><c:out value="${ob.chToDate}"/></span>
																			<span><c:out value="${ob.currencyCode}"/></span>
																			
																		</div>												
																	</div>
																</div>
																<div class="col-xs-12">
																	<div class="col-xs-4">
																		<div class="form-group">
																			i.e.,
																		</div>												
																	</div>
																	<div class="col-xs-4">
																		<div class="form-group">
																			<span>
																			<c:out value="${ob.noOfDays}"/></span>
																			days * 
																			<span>
																			<c:out value="${ob.currencyCode}"/></span>
																			7300 pdpr
																		</div>												
																	</div>
																</div>
															</div>
													
													</c:forEach>
												</td>
												<td class="width_20">
													<c:forEach var="ob2"  items="${charterReportList.rowData}"> 
													<div class="padding-top-20 row">														
														<div class="col-xs-12">															
															<div class="form-group padding-top-55">
																<span><c:out value="${ob2.totalCharges}" /></span>																
															</div>
														</div>
													</div>
													</c:forEach>											 
												</td>
											</tr>
											
											<tr>
												<td class="width_2">B</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														LESS
													</div>
												</td>
												<td class="width_20"></td>	
											</tr>
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-4">
															<div class="form-group">
																Add commission 2.5%
															</div>												
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="row">														
														<div class="col-xs-12">															
															<div class="form-group font-red">
																<span>${object1.totalChargesWithCommission}</span>																
															</div>
														</div>
													</div>																						 
												</td>
											</tr>
											<tr>
												<td class="width_2">C</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														CHARTERERS' EXPENSE
													</div>
												</td>
												<td class="width_20"></td>	
											</tr>
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group">
																Communication (USD 600/month)
															</div>
															<div class="form-group">
																Representation (USD 500/month)
															</div>
															<div class="form-group">
																Lashing Expense (USD 1200/month)
															</div>												
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12">
														<div class="form-group">
															<span>${object1.charExpenseComn}</span>	
														</div>
														<div class="form-group">
															<span>${object1.charExpenRep}</span>	
														</div>
														<div class="form-group">
															<span>${object1.charLashingExpen}</span>	
														</div>
													</div>		
												</td>	
											</tr>
											<tr>
												<td class="width_2">D</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														OWNERS' EXPENSE
													</div>
												</td>
												<td class="width_20"></td>
											</tr>
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<div class="row">
														<div class="col-xs-12">
															<div class="col-xs-8">
																<div class="form-group">
																	Acct/01
																</div>		
																<div class="form-group">
																	Acct/02
																</div>		
																<div class="form-group">
																	Acct/03
																</div>												
															</div>		
															<div class="col-xs-4">
																<div class="form-group">															 
																	<span>${object1.ownersExpAcct1}</span>			
																</div>		
																<div class="form-group">
																	<span>${object1.ownersExpAcct2}</span>	
																</div>		
																<div class="form-group b-b b-black">
																	<span>${object1.ownersExpAcct3}</span>	
																</div>												
															</div>												
														</div>
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group">-
														</div>
														<div class="form-group">-
														</div>
														<div class="form-group font-red">
															<span>${object1.ownersExpenceCharges}</span>	
														</div>
													</div>											 
												</td>
											</tr>
											<tr>
												<td class="width_2">E</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														DELIVERY BUNKER
													</div>
												</td>
												<td class="width_20"></td>
											</tr>	
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group">
																FO:  169.2mt  x  USD 395 pmt
															</div>																									
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group">
																<span>${object1.deliveryBunkerCharges}</span>	
														</div>
													</div>											 
												</td>
											</tr>									
											<tr>
												<td class="width_2">F</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														PROVISION
													</div>
												</td>	
												<td class="width_20"></td>										
											</tr>
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group">
																Redelivery FO Bunker (Estimated):  (250mt  x  USD 420 pmt)  x  (1/2)
															</div>																									
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group font-red">
															<span>${object1.redeliveryBunkerCharges}</span>	
														</div>
													</div>											 
												</td>
											</tr>	
											<tr>
												<td class="width_2"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group bold">
																Nett Due To Owners
															</div>																									
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group bg-color-cfdadd">
															<span>${object1.nettDueToOwnerCharges}</span>															
														</div>
													</div>											 
												</td>
											</tr>	
										</tbody>
									</table>
								</fieldset>
							</div> <!-- /col-sm-12 -->
						    <div class="col-sm-12 col-md-12 col-lg-12 padding-top-20">
						    	<div class="col-sm-6 col-md-6 col-lg-6">
								    <div class="form-group">
								 		<label class="control-label">The above amount is being remitted thru our Bank. </label>					     		
							     	</div>
							     	<div class="form-group">
							     		<label class="control-label">Please confirm safe receipt of amount.</label>					     		
							     	</div>
							     </div>		
						    </div>
						    <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group padding-left-10" style="padding-left:10px">Owners Banking Details:</div>
									<div class="col-sm-12 col-md-12 col-lg-12 bg-color-cfdadd bg-bank-accounts">
										<div class="col-sm-3 col-md-3 col-lg-3">
											<div class="form-group text-right">Bank 		: </div>
											<div class="form-group text-right">Account Name : </div>
											<div class="form-group text-right">BIC 			: </div>
											<div class="form-group text-right">IBAN 		: </div>
											<div class="form-group text-right">Currency 	: </div>
										</div>
										<div class="col-sm-5 col-md-5 col-lg-5">
											<div class="form-group text-left">Deutsche Bank, Hamburg, Germany </div>
											<div class="form-group text-left">Ballachrink Navigation Limited</div>
											<div class="form-group text-left">DEUTDEHHXXX</div>
											<div class="form-group text-left">DE38 2007 0000 0139 7900 00</div>
											<div class="form-group text-left">USD</div>
										</div>
									</div>
								</div>
						    </div>
						    
						    </div> <!-- /row - /section-to-print -->						    
					   </div> <!-- /generatePdf -->
				 </div>
			</div>
		</div>
	</body>
</html>
