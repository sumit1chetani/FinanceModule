<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.div#gbox_balanceSheetGrid {
	width: 98%;
}

.table-border {
	border: 1px solid black;
	padding: 10px;
	border-collapse: collapse;
}

.txtAlgCent {
	text-align: right;
}

.table .th{
	font-style: normal;
}

.card{ background-color: #fff; border: 1px solid transparent; border-radius: 6px; }
.card > .card-link{ color: #333; }
.card > .card-link:hover{  text-decoration: none; }
.card > .card-link .card-img img{ border-radius: 6px 6px 0 0; }
.card .card-img{ position: relative; padding: 0; display: table; }
.card .card-img .card-caption{
  position: absolute;
  right: 0;
  bottom: 16px;
  left: 0;
}
.card .card-body{ display: table; width: 100%; padding: 12px; }
.card .card-header{ border-radius: 6px 6px 0 0; padding: 8px; }
.card .card-footer{ border-radius: 0 0 6px 6px; padding: 8px; }
.card .card-left{ position: relative; float: left; padding: 0 0 8px 0; }
.card .card-right{ position: relative; float: left; padding: 8px 0 0 0; }
.card .card-body h1:first-child,
.card .card-body h2:first-child,
.card .card-body h3:first-child, 
.card .card-body h4:first-child,
.card .card-body .h1,
.card .card-body .h2,
.card .card-body .h3, 
.card .card-body .h4{ margin-top: 0; }
.card .card-body .heading{ display: block;  }
.card .card-body .heading:last-child{ margin-bottom: 0; }

.card .card-body .lead{ text-align: center; }

@media( min-width: 768px ){
  .card .card-left{ float: left; padding: 0 8px 0 0; }
  .card .card-right{ float: left; padding: 0 0 0 8px; }
    
  .card .card-4-8 .card-left{ width: 33.33333333%; }
  .card .card-4-8 .card-right{ width: 66.66666667%; }

  .card .card-5-7 .card-left{ width: 41.66666667%; }
  .card .card-5-7 .card-right{ width: 58.33333333%; }
  
  .card .card-6-6 .card-left{ width: 50%; }
  .card .card-6-6 .card-right{ width: 50%; }
  
  .card .card-7-5 .card-left{ width: 58.33333333%; }
  .card .card-7-5 .card-right{ width: 41.66666667%; }
  
  .card .card-8-4 .card-left{ width: 66.66666667%; }
  .card .card-8-4 .card-right{ width: 33.33333333%; }
}

/* -- default theme ------ */
.card-default{ 
  border-color: #ddd;
  background-color: #fff;
  margin-bottom: 24px;
}
.card-default > .card-header,
.card-default > .card-footer{ color: #333; background-color: #ddd; }
.card-default > .card-header{ border-bottom: 1px solid #ddd; padding: 8px; }
.card-default > .card-footer{ border-top: 1px solid #ddd; padding: 8px; }
.card-default > .card-body{  }
.card-default > .card-img:first-child img{ border-radius: 6px 6px 0 0; }
.card-default > .card-left{ padding-right: 4px; }
.card-default > .card-right{ padding-left: 4px; }
.card-default p:last-child{ margin-bottom: 0; }
.card-default .card-caption { color: #fff; text-align: center; text-transform: uppercase; }

</style>
<script>
	$("div#generalLeddialog").dialog({
		autoOpen : false
	});

	$(document)
			.ready(
					function() {
						//Fixing jQuery Click Events for the iPad
						var ua = navigator.userAgent, event = (ua
								.match(/iPad/i)) ? "touchstart" : "click";
						if ($('.table').length > 0) {
							$('.table .header')
									.on(
											event,
											function() {
												$(this)
														.toggleClass("active",
																"")
														.nextUntil('.header')
														.css(
																'display',
																function(i, v) {
																	return this.style.display === 'table-row' ? 'none'
																			: 'table-row';
																});
											});
						}
					});
</script>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<head>
<style>
.main_head {
	background-color: #7E7EB8 !important;
	color: white;
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-radius: 2px 2px 0 0;
}

.data-table {
	margin-bottom: 7px !important;
}


</style>
</head>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">

		<div class="panel-body">
			<form class="form-horizontal" name="permanentprobationhead"
				role="form" ng-submit="#" validate>
				<div class="col-lg-12">
					<div class="col-sm-4 lg-4 md-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Organization <span
									style="color: red";>*</span>
								</label>
								<div class="col-md-6">
									<selectivity list="companyList" property="balsheet.company"
										data-ng-model="balsheet.company" id="company" object="company"
										name="organization"></selectivity>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-4 lg-4 md-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Fund Type </label>
								<div class="col-md-6">
									<selectivity list="costList" id="costCenter" name="costCenter"
										form-name="permanentprobationhead"
										property="balsheet.costCenter" ng-model="balsheet.costCenter"
										friendly-name="Fund TYpe"></selectivity>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-4 lg-4 md-4">
						<fieldset>

							<div class="form-group ">
								<label class="col-md-6 control-label"> Date <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker ng-disabled="createQuote"
										data-ng-model="balsheet.fromDate"
										form-name="permanentprobationhead" id="txtrealisedDate"
										name="realisedDate"
										data-ng-change="checkDatesCL(balsheet.fromDate)"
										friendly-name="date" validation="required" />
								</div>
							</div>





							<!-- div class="form-group">
											<label class="col-md-6 control-label"> Date  <span style = "color:red";>*</span>>
											</label>
											<div class="col-md-6">
												<div class='input-group date datetimepick col-md-12'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="Date"
																	data-validator="required" data-valid-method="submit"
																	data-message-id="Date"
																	data-ng-model="balsheet.fromDate" validation="required"
																	friendly-name="Date" form-name="permanentprobationhead"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker data-ng-model="balsheet.date"
																data-on-set-time="balsheet.fromDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div> -->
						</fieldset>
					</div>
					<div>
						<br>
						<div class="form-actions">

							<div class="row">
								<div class="col-md-12 ">
									<a id="GLExport" stype="display:none"
										href="filePath/GeneralLedger.xls" download="GeneralLedger.xls"></a>
									<button class="btn btn-success" type="submit"
										class="btn btn-success"
										data-ng-click="generateBalanceSheetReport(permanentprobationhead)">
										Generate</button>
									<!-- <div class="row">
						<div class="col-md-12 "> -->
									<a id="exportBS" stype="display:none" href="{{filePath}}"
										download="BalanceSheet.xls"></a>
									<button class="btn btn-success" class="btn btn-success"
										data-ng-click="excelBSExport()">Excel export</button>

									<!-- <a id="GLExport" stype="display:none"
					href="filePath/GeneralLedger.xls" download="GeneralLedger.xls"></a>
							<button class="btn btn-success" type="submit"
													class="btn btn-success"
													data-ng-click="generateBalanceSheetReport(permanentprobationhead)">
													Generate</button> -->

									<button class="btn btn-primary" ng-click="exportPDF()"
										type="button">
										<i class="fa fa-file-excel-o"></i> Export PDF<a id="exportPDF"
											href="filePath/BalanceSheet.pdf" download="BalanceSheet.pdf"></a>
									</button>
								</div>
							</div>
						</div>

						<!-- <div class="col-sm-12 lg-12 md-12" align="center">
									<fieldset>
										<div class="">																					
											<a id="exportBS" stype="display:none" href="{{filePath}}"
												download="BalanceSheet.xls"></a> 

											<div class="col-md-2 pull-right">
												<button class="btn btn-success" class="btn btn-success"
													data-ng-click="excelBSExport()">Excel export</button>
											</div>	

											<div class="col-md-2 pull-right">
												<button class="btn btn-success" type="submit"
													class="btn btn-success"
													data-ng-click="generateBalanceSheetReport(permanentprobationhead)">
													Generate</button>
											</div> 
											<div class="col-md-2 pull-right">
											<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/BalanceSheet.pdf"
											download="BalanceSheet.pdf"></a>
									</button>
											</div> 
											

 									</fieldset>
								</div> -->
					</div>
					<!-- end widget div -->
				</div>
				<br> <br>
				<!-- end widget -->
		</div>
		<!-- panel end -->

		<!-- report strat -->
		<div class="container-fluid">
			<div class="col col-md-12 col-sm-12 col-lg-12"><br><br>
				<!-- liabilities start -->
				<div class="col col-md-8 col-sm-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2 card card-default">
					<div class="text-center"><br>									  
                        <div align="center"><img src="/img/MBKHelpVideos/Dental_Council_of_India_logo1.png" width="90"></div>
                                <div class="   bold toggleBlock-currsor text-center  ">
                                     <h1 style="color: black;">Dental Council Of India</h1>
                                </div><b>Balance Sheet as on {{balsheet.fromDate}}</b>
                       </div><br>             
					 
					<p class="text-centere" style="font-size: 13px;margin-top: 5px;"><b>&emsp;&nbsp;&nbsp;Corpus/Capital Fund & Liabilities</b></p><br>
					 
						<p ng-repeat-start="objTranslationItem in lGroupHeadLevelLiabilitiesList"></p>
						<p ng-repeat-start="(tIndex, objTransrowItem) in objTranslationItem.lSubGroupLevelList"></p>						 
							 
							<table class="table" style="font-weight: bold;margin-top: -26px;">
								<tr data-toggle="collapse" data-target="#_{{objTransrowItem.groupHeadCode}}">
									<th colspan=2 class="width_20 borderclass" style="font-style: normal;color: black;"><a href="#" style="color: black;"> &nbsp;&nbsp;&nbsp;{{objTransrowItem.groupHeadCode}} - {{objTransrowItem.groupHeadName}}</a></th>
									<td class="width_6 borderclass" align="right">{{-objTransrowItem.balance | number}}</td>
								</tr>
							</table>		
							
							<div id="_{{objTransrowItem.groupHeadCode}}" class="collapse active" style="margin-top: -20px;">					 
								 <table class="table">
										<tr ng-repeat="objTranshandsonItem in objTransrowItem.lAccountHeadLevelList">
											<td colspan=2 class="width_20 borderclass"  style="border:none;"><span class="tool-tip-span">{{objTranshandsonItem.groupHeadCode}} - {{objTranshandsonItem.groupHeadName}}</span></td>
											<td class="width_6 borderclass" align="right"><span class="tool-tip-span">{{-objTranshandsonItem.balance |number}}</span></td>
										</tr>
								</table> 
							</div>
									 
						<p ng-repeat-end></p>
						<p ng-repeat-end></p>				 
					
				 	<table style="margin-top: -26px;font-weight: bold;" class="table">
						<tr>
							<th colspan=2 class="width_20 borderclass" > &nbsp;&nbsp;&nbsp;Current Period Earnings</th>
							<td class="width_6 borderclass" align="right"><span class="tool-tip-span">{{-currentPeriodEarning |number}}</span></td>
						</tr>
					</table>
					
					<table style="margin-top: -26px;font-weight: bold;" class="table">
						<tr>
							<th colspan=2 class="width_20 borderclass" style="border-top: 1px solid;"><b> &nbsp;&nbsp;&nbsp;Total</b></th>
							<td class="width_6 borderclass" align="right" style="border-top: 1px solid;"><b> {{-totalLiablities|number}}&nbsp;</b></td>
						</tr>
					</table><!-- liabilities end -->
					
				 	<!-- Assets start -->
				<!-- <div class="col col-md-6 col-sm-6 col-lg-6 card card-default" > -->
					 
					<p class="text-centere" style="font-size: 13px;margin-top: 5px; font-weight: bold;">&emsp;&nbsp;&nbsp;Assets</p>
					<br>
					<p ng-repeat-start="objTranslationItem in lGroupHeadLevelAssetList"></p>
					<p ng-repeat-start="(tIndex, objTransrowItem) in objTranslationItem.lSubGroupLevelList"></p>						 
							 
							<table class="table" style="font-weight: bold;margin-top: -26px;">
								<tr data-toggle="collapse" data-target="#_{{objTransrowItem.groupHeadCode}}">
									<th colspan=2 class="width_20 borderclass" ><a href="#" style="color: black;"> &nbsp;&nbsp;&nbsp;{{objTransrowItem.groupHeadCode}} - {{objTransrowItem.groupHeadName}}</a></th>
									<td class="width_6 borderclass" align="right">{{-objTransrowItem.balance | number}}</td>
								</tr>
							</table>		
							
							<div id="_{{objTransrowItem.groupHeadCode}}" class="collapse" style="margin-top: -20px;">					 
								 <table class="table">
										<tr ng-repeat="objTranshandsonItem in objTransrowItem.lAccountHeadLevelList">
											<td colspan=2 class="width_20 borderclass"  style="border:none;"><span class="tool-tip-span"> {{objTranshandsonItem.groupHeadCode}} - {{objTranshandsonItem.groupHeadName}}</span></td>
											<td class="width_6 borderclass" align="right"><span class="tool-tip-span">{{-objTranshandsonItem.balance |number}}</span></td>
										</tr>
								</table> 
							</div>
									 
						<p ng-repeat-end></p>
						<p ng-repeat-end></p>								  
					
					<table style="margin-top: -26px;font-weight: bold;" class="table">
						<tr>
							<th colspan=2 class="width_20 borderclass" style="border-top: 1px solid;"><b> &nbsp;&nbsp;&nbsp;Total</b></th>
							<td class="width_6 borderclass" align="right" style="border-top: 1px solid;"><b> {{-totalAssetWithCurrent|number}}&nbsp;</b></td>
						</tr>
					</table> 
					 
			<!-- 	</div> -->
				<!-- Assets end -->			
					  
				</div>
				<!-- liabilities end -->

				
			</div>
		</div>

		<!-- report end -->

	</div>

</div>