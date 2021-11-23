<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
  background-color: #eee;
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
  margin-bottom: 8px !important;
}
.bold {
  font-weight: bold;
}
.bg-header{
background-color:#cfdadd
}
.text-font-size-20p{
	font-size: 20px;
}
.height-38p{
	height: 38px;
}
@media print {
  a[href]:after {
    content: " (" attr(href) ")";
  }
}

.height_20p{
	height: 20px;
}
.height_30p{
	height: 30px;
}
.height_32p{
	height: 32px;
}

.padding-top-5 {
	padding-top: 5px !important;
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
.padding-left-10{
	padding-left: 10px;
}
.b-a {
  border: 1px solid #dee5e7;
}
.font-size-14p{
	font-size:14px;
}

</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md" style="padding: 20px;">
			<div id="generatePdf">				  				   
				<div class="row">				     
					<div class="col-sm-12 col-md-12 col-lg-12 width_100" st-table="displayedCollection" st-safe-src="rowCollection">
				      	<fieldset style="border:0px">
				      		<legend class="width_50 text-center b-a bg-header m-n text-font-size-20p" ng-bind="charterHireStmtData.vesselName"></legend>
				      	</fieldset>
				      </div>
				      <div class="col-sm-12 col-md-12 col-lg-12 width_100 pull-left"  st-table="displayedCollection" st-safe-src="rowCollection">
					     <div class="col-sm-2 col-md-2 col-lg-2">
						    <div class="form-group">
					     		<label class="control-label text-right" style="padding-top: 7px;margin-bottom: 0;text-align: right;">Delivery: </label>					     		
					     	</div>
					     	<div class="form-group">					     		
					     		<label class="control-label text-right" style="padding-top: 7px;margin-bottom: 0;text-align: right;">Redelivery: </label>
					     	</div>
					     </div>
					     <div class="col-sm-6 col-md-6 col-lg-6 width_50">
						     <div class="form-group">						     	
						     	<label class="control-label text-right" style="padding-top: 7px;margin-bottom: 0;text-align: right;">06/03/15 08:00 LT UAE </label>
						     </div>
						     <div class="form-group">
						     	<label class="control-label text-right" style="padding-top: 7px;margin-bottom: 0;text-align: right;">24/05/15 08:00 LT UAE </label>					     							     
						     </div>
					     </div>
				     </div>
				     <div class="col-sm-12 col-md-12 col-lg-12 width_100">
				      	<fieldset class="no-border">
				      		<legend class="width_100 text-center no-border m-n">CHARTER HIRE - SOA</legend>				      		
				      	</fieldset>
				      </div>
				    <div class="col-sm-12 col-md-12 col-lg-12 width_100"  st-table="displayedCollection" st-safe-src="rowCollection">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" align=center border=1 cellPadding=0 cellSpacing=0 width="100%">
							<thead class="no-border" style="border:0">
								<tr>
									<th colspan=1 class="width_5 text_center height-38p padding-left-10">Sl No.</th>
									<th colspan=1 class="width_45 text_center height-38p padding-left-10">Description</th>
									<th colspan=1 class="width_20 text_center height-38p padding-left-10">
									Amount Due To Charterers
									</th>					
									<th colspan=1 class="width_20 text_center height-38p padding-left-10">
									Amount Due To Owners
									</th>							
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="width_5" valign="top">1</td>
									<td class="width_45">
										<div class="padding-top-20 row" ng-repeat="objCharterHireBean in displayedCollection">
											<div class="col-xs-12">
												<div class="col-xs-4">
													<div class="form-group">
														From
													</div>												
												</div>
												<div class="col-xs-4">
													<div class="form-group">
														<span ng-bind="objCharterHireBean.chFromDate"></span>
														<span ng-bind="objCharterHireBean.currencyCode"></span>
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
														<span ng-bind="objCharterHireBean.chToDate"></span>
														<span ng-bind="objCharterHireBean.currencyCode"></span>
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
														<span ng-bind="objCharterHireBean.noOfDays"></span>
														days * 
														<span ng-bind="objCharterHireBean.currencyCode"></span>
														7300 pdpr
													</div>												
												</div>
											</div>
										<!-- <div class="col-xs-8 text-left">
											<p class="bold">Charter Hire</p>
											<p>From</p>
											<p>Till</p>
										</div> -->
										</div>
									</td>
									<td class="width_20">
										<div class="padding-top-20 row" ng-repeat="objCharterHireBean in displayedCollection">												
											<div class="col-xs-12">
												<div class="col-xs-4">															
													<div class="form-group padding-top-55 text-right">
														<span ng-bind="objCharterHireBean.totalCharges"></span>																
													</div>
												</div>
											</div>
										</div>	
									</td>
									<td class="width_20" align="right">
										<div class="padding-top-20 row" ng-repeat="objCharterHireBean in displayedCollection">
											<div class="col-xs-12">
												<div class="form-group height_20p padding-top-55">
													$5,76,700.00
												</div>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td class="width_5" valign="top">2</td>
									<td class="width_45">
										<div class="col-xs-8 text-left bold">
											Address Commission (2.5%)
										</div>													
									</td>
									<td class="width_20 text-right">
										<div class="row">														
											<div class="col-xs-12">															
												<div class="form-group">
													<span ng-bind="charterHireStmtData.totalChargesWithCommission"></span>																
												</div>
											</div>
										</div>										
									</td>
									<td class="width_20"></td>
								</tr>
								<tr>
									<td class="width_5" valign="top">3</td>
									<td class="width_45">
										<div class="col-xs-8 text-left bold">Bunkers</div>
										<div class="padding-top-20 row">
											<div class="col-xs-12">
												<div class="col-xs-6">
													<div class="form-group bold font-size-14p padding-top-20">
														Fuel Oil (as per survey report)			
													</div>
													<div class="form-group bold font-size-14p padding-top-10">
														On Delivery:
													</div>
													<div class="form-group bold font-size-14p padding-top-10">
														On Redelivery:
													</div>
													<div class="form-group bold font-size-14p">
														Provision for Redel bunkers:
													</div>												
												</div>
												<div class="col-xs-6">
													<div class="form-group height_32p padding-top-20">
													</div>
													<div class="form-group font-size-14p padding-top-20">
														169.200 mt * USD	=	395
													</div>
													<div class="form-group font-size-14p padding-top-10">
														300.000 mt * USD	=	420
													</div>
													<div class="form-group font-size-14p">
														250.000 mt * USD	=	420		(50%)											
													</div>
												</div>
											</div>
										</div>							
									</td>
									<td class="width_20">
										<div class="padding-top-20 row">
											<div class="col-xs-12">										
												<div class="form-group height_20p padding-top-20">																																								
												</div>
												<div class="form-group padding-top-40">
												</div>
												<div class="form-group height_20p text-right padding-top-20">
												$1,26,000.00						
												</div>
												<div class="form-group">
												</div>						
											</div>
										</div>				
									</td>
									<td class="width_20"  align="right">
										<div class="padding-top-20 row">
											<div class="col-xs-12">												
												<div class="form-group height_20p padding-top-20">																																								
												</div>
												<div class="form-group height_20p padding-top-30">
												$66,834.00													
												</div>
												<div class="form-group height_20p padding-top-10">
												</div>
												<div class="form-group">
												</div>
											</div>
										</div>								
									</td>
								</tr>
								<tr>
									<td class="width_5" valign="top">4</td>
									<td class="width_45">
										<div class="col-xs-8 text-left bold">Survey</div>
										<div class="col-xs-12">
											<div class="col-xs-6">
												<div class="form-group height_20p">
													On hire Survey fees																																											
												</div>
												<div class="form-group height_20p">
													Off hire Survey fees																																											
												</div>
											</div>
										</div>
									</td>
									<td class="width_20"></td>
									<td class="width_20"></td>
								</tr>	
								<tr>
									<td class="width_5" valign="top">5</td>
									<td class="width_45">
										<div class="col-xs-12 text-left bold height_30p">Owners Expenses</div>
										<div class="padding-top-20 row">
											<div class="col-xs-12">	
												<div class="col-xs-6">
													<div class="form-group height_20p">
														Acct 01 - 05																																										
													</div>
													<div class="form-group height_20p">
														Provision
													</div>
												</div>
											</div>
										</div>													
									</td>
									<td class="width_20" align="right">
											<!-- <div class="col-xs-12 text-left bold height_30p"></div> -->
										<div class="padding-top-20 row">
											<div class="col-xs-12">	
												<div class="form-group height_20p padding-top-10">
													$5,750.51																																										
												</div>
												<div class="form-group height_20p padding-top-10">
													$10,000.00
												</div>
											</div>
										</div>	
									</td>
									<td class="width_20"></td>
								</tr>	
								<tr>
									<td class="width_5" valign="top">6</td>
									<td class="width_45">
										<div class="col-xs-8 text-left bold">Charterers Expenses</div>		
										<div class="padding-top-20 row">
											<div class="col-xs-12">
												<div class="col-xs-6">
													<div class="form-group height_20p">
														Communication (USD 600/month)																																									
													</div>
													<div class="form-group height_20p">
														Representation (USD 500/month)
													</div>
													<div class="form-group height_20p">
														Lashing Expense (USD 1200/month)
													</div>
												</div>
											</div>	
										</div>
									</td>
									<td class="width_20"></td>
									<td class="width_20"  align="right">																					
										<div class="form-group height_20p padding-top-20">
											$1,853.33																																								
										</div>
										<div class="form-group height_20p padding-top-20">
											$1,544.45
										</div>
										<div class="form-group height_20p padding-top-20">
											$3,706.67
										</div>								
									</td>
								</tr>
								<tr>
									<td class="width_5" valign="top">7</td>
									<td class="width_45">
										<div class="padding-top-20 row">
											<div class="col-xs-12 text-left bold height_20p">Off-hire</div>
											<div class="col-xs-12 text-left height_20p">a.)  replacement of PS Anchor @ JEA Anchorage</div>
											<div class="col-xs-12">
												<div class="col-xs-2">												
													<div class="form-group bold">
														From
													</div>
													<div class="form-group bold">
														Till
													</div>
													<div class="form-group bold">
														i.e.,
													</div>
												</div>
												<div class="col-xs-6">												
													<div class="form-group">
														21/05/15 03:24													
													</div>
													<div class="form-group">
														21/05/15 16:30													
													</div>
													<div class="form-group">
														<span class="bold">0.5458</span> days  x  USD  
														<span class="bold"> 7,300.00</span>  pdpr		
													</div>
												</div>
											</div>
											<div class="col-xs-12 height_20p">Bunker consumed:</div>	
											<div class="col-xs-12 height_20p">(536.666mt - 532.2mt) = 4.466mt x USD 393.50</div>														
										</div>
									</td>
									<td class="width_20" align="right">
										<div class="padding-top-20 row">
											<div class="col-xs-12">
												<div class="form-group height_20p">											
												</div>
												<div class="form-group height_20p">											
												</div>
												<div class="form-group height_20p">													
												</div>
												<div class="form-group height_20p padding-top-10">
													$3,984.58
												</div>
												<div class="form-group height_20p padding-top-20">
													$1,757.37
												</div>
											</div>
										</div>
									</td>
									<td class="width_20"></td>
								</tr>
								<tr>
									<td class="width_5" valign="top">8</td>
									<td class="width_45">
										<div class="col-xs-8 text-left bold">Remittance</div>													
									</td>
									<td class="width_20" align="right">
										<div class="col-xs-12 height_20p">
											$5,76,922.63
										</div>									
									</td>
									<td class="width_20"></td>
								</tr>	
								<tr>
									<td class="width_5" valign="top"></td>
									<td class="width_45">																							
									</td>
									<td class="width_20" align="right">
											$  7,41,326.76
									</td>
									<td class="width_20" align="right">
											$  7,50,405.36											
									</td>
								</tr>
								<tr>
									<td class="width_5" valign="top"></td>
									<td class="width_45 padding-left-10">
									Balance due to/ (by) Owners.																							
									</td>
									<td class="width_20" align="right">
										<div class="col-xs-12 text_left height_20p">
										
											
										
										</div>									
									</td>
									<td class="width_20 bg-header" align="right">
											$  9,078.59 										
									</td>
								</tr>								
							</tbody>
						</table>
					</div> <!-- /col-sm-12 -->				    		    
				</div> <!-- /row -->
				 <div class="form-actions"><!-- Form Actions -->
			   		<div class="row">
						<div class="col-md-12 ">
							<button type="button" class="btn btn-success" ng-click="printCharterHireSOA(charterHireStmtData)">
				        	  Print
				          	</button>
		         			<button class="btn btn-danger" ng-click="cancel();">
		          				<i class="fa fa-close"> Cancel</i>
		         			</button>			         			  	
	         			</div>
      				</div>
     			</div>
			</div>
		</div>
	</div>
</div>
