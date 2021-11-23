<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.div#gbox_balanceSheetGrid {
	width: 98%;
}
.table-border {
        border:1px solid black;
        padding: 10px;  
        border-collapse: collapse;      
    }
    .txtAlgCent {
	text-align: right;
}
</style>
<script>
    $("div#generalLeddialog").dialog({
        autoOpen : false

    });

    $(document).ready(function() {
        //Fixing jQuery Click Events for the iPad
        var ua = navigator.userAgent, event = (ua.match(/iPad/i)) ? "touchstart" : "click";
        if ($('.table').length > 0) {
            $('.table .header').on(event, function() {
                $(this).toggleClass("active", "").nextUntil('.header').css('display', function(i, v) {
                    return this.style.display === 'table-row' ? 'none' : 'table-row';
                });
            });
        }
    })
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
								<div class="col-sm-4 lg-6 md-6">
									<fieldset>
										<div class="form-group">
											<label class="col-md-4 control-label">Organization <span style = "color:red";>*</span>
											</label>
											<div class="col-md-6">
												<selectivity list="companyList" property="balsheet.company"
													data-ng-model="balsheet.company" id="company"
													object="company" name="organization"></selectivity>
											</div>
										</div>
										
											<div class="form-group">
											<label class="col-md-4 control-label">Fund Type 
											</label>
											<div class="col-md-6">
												<selectivity list="costList" id="costCenter"
														name="costCenter" form-name="permanentprobationhead"
														property="balsheet.costCenter"
														ng-model="balsheet.costCenter"
														friendly-name="Fund TYpe"  ></selectivity>
											</div>
										</div>
										
										
										
										
									</fieldset>
								</div>
								<div class="col-sm-4 lg-6 md-6">
									<fieldset>
									
										<div class="form-group ">
								<label class="col-md-6 control-label"> Date <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="balsheet.fromDate" form-name="permanentprobationhead"
										id="txtrealisedDate" name="realisedDate"
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
								</div><br></div>
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

							 
 							<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/BalanceSheet.pdf"
											download="BalanceSheet.pdf"></a>
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

							<div>
								<table width=50% border="1" align="left" cellpadding='5' cellspacing='1'>
									<tr style="background: #375785 !important; color: #FFF;">
										<!-- <td class="width_10" align="center" style="font-size: 11px;"><b>Group Code</b></td> -->
										<td colspan="3" class="width_50" align="left" height="40"
											style="font-size: 11px;"><center>
												<font size="2" face="arial"><b>LIABLITIES</b></font>
											</center></td>

									</tr>

									<tr ng-repeat-start="objTranslationItem in lGroupHeadLevelLiabilitiesList" style="background: #337ab7 !important; color: #FFB;">


										<td colspan=2 class="borderclass"><span
											class="tool-tip-span"><b>{{objTranslationItem.groupHeadName}} - Over All Total</b>
												</span></td>

										<td colspan=1 class="borderclass" align="right"><span
											class="tool-tip-span"><b>{{objTranslationItem.amount+currentPeriodEarning |number}}</b></span></td> 

									</tr>

									<tr class="active"
										ng-repeat-start="(tIndex, objTransrowItem) in objTranslationItem.lSubGroupLevelList">

										<!-- <th colspan=1 class="borderclass">Sub Account Code</th>
										<th colspan=1 class="borderclass">Sub Account Name</th>
										<th colspan=1 class="borderclass">Balance</th> -->
									</tr>
									<tr>

										<td colspan=2 class="borderclass"><b>{{objTransrowItem.groupHeadCode}} - {{objTransrowItem.groupHeadName}}</b></td>
										
										<td colspan=1 class="borderclass" align="right"><b>{{objTransrowItem.balance |number}}</b></td>


									</tr>

									<tr class="active">

<!-- 
										<th class="borderclass">Account Code</th>
										<th class="borderclass">Account Name</th>
										<th class="borderclass">Balance</th> -->


									</tr>
									<tr
										ng-repeat="objTranshandsonItem in objTransrowItem.lAccountHeadLevelList">


										<td colspan=2 class="width_20 borderclass"><span
											class="tool-tip-span">{{objTranshandsonItem.groupHeadCode}} - {{objTranshandsonItem.groupHeadName}}</span></td>
										
										<td class="width_6 borderclass" align="right"><span
											class="tool-tip-span">{{objTranshandsonItem.balance |number}}</span>
										</td>

									</tr>


									<tr ng-repeat-end></tr>
									<tr ng-repeat-end></tr>
									<tr ng-repeat-end></tr>
									<tr>
<td colspan=2 class="width_6 borderclass"><span
											class="tool-tip-span">Current Period Earnings</span></td>
<td class="width_6 borderclass" align="right"><span
											class="tool-tip-span">{{currentPeriodEarning |number}}</span></td>
											</tr>
								</table>
								
								<table width=50% border="1" align="right" cellpadding='5' cellspacing='1'>
									<tr style="background: #375785 !important; color: #FFF;">
										<!-- <td class="width_10" align="center" style="font-size: 11px;"><b>Group Code</b></td> -->
										<td colspan="3" class="width_50" align="left" height="40"
											style="font-size: 11px;"><center>
												<font size="2" face="arial"><b>ASSETS</b></font>
											</center></td>

									</tr>

									<tr ng-repeat-start="objTranslationItem in lGroupHeadLevelAssetList" style="background: #337ab7 !important; color: #FFB;">


										<td colspan=2 class="borderclass"><span
											class="tool-tip-span"><b>{{objTranslationItem.groupHeadName}} - Over All Total</b>
												</span></td>

										<td colspan=1 class="borderclass" align="right"><span
											class="tool-tip-span"><b>{{objTranslationItem.amount |number}}</b></span></td>

									</tr>

									<tr class="active"
										ng-repeat-start="(tIndex, objTransrowItem) in objTranslationItem.lSubGroupLevelList">

										<!-- <th colspan=1 class="borderclass">Sub Account Code</th>
										<th colspan=1 class="borderclass">Sub Account Name</th>
										<th colspan=1 class="borderclass">Balance</th> -->
									</tr>
									<tr>

										<td colspan=2 class="borderclass"><b>{{objTransrowItem.groupHeadCode}} - {{objTransrowItem.groupHeadName}}</b></td>
										
										<td colspan=1 class="borderclass" align="right"> <b>{{objTransrowItem.balance |number}}</b></td>


									</tr>

									<tr class="active">


										<!-- <th class="borderclass">Account Code</th>
										<th class="borderclass">Account Name</th>
										<th class="borderclass">Balance</th> -->


									</tr>
									<tr
										ng-repeat="objTranshandsonItem in objTransrowItem.lAccountHeadLevelList">


										<td colspan=2 class="width_6 borderclass"><span
											class="tool-tip-span">{{objTranshandsonItem.groupHeadCode}} - {{objTranshandsonItem.groupHeadName}}</span></td>
										
										<td class="width_6 borderclass" align="right"><span
											class="tool-tip-span" >{{objTranshandsonItem.balance |number}}</span>
										</td>

									</tr>

									
									<tr ng-repeat-end></tr>
									<tr ng-repeat-end></tr>
									<tr ng-repeat-end></tr>
										<!-- <tr>
<td colspan=2 class="width_6 borderclass"><span
											class="tool-tip-span">Current Period Earnings</span></td>
<td class="width_6 borderclass" align="right"><span
											class="tool-tip-span">{{currentPeriodEarning |number}}</span></td>
											</tr> -->
								</table>



						
							</div>

							<!-- end widget div -->
					</div>
					<br><br><div>
								<table width=50% border="1" align="left" cellpadding='5' cellspacing='1'>
							<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 11px;"><font
								size="2" face="arial"><b style="color:white">&nbsp SUBTOTAL FOR
										LIABILITIES</b></font></td>
							<td   class="width_10" align="right" height="30"
								style="background: #D37878 !important" style="font-size: 11px;" ><b style="color:white">
								{{totalLiablities|number}}&nbsp</b></td>
								</table>
								<table width=50% border="1" align="left" cellpadding='5' cellspacing='1'>
								<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 11px;"><font
								size="2" face="arial"><b style="color:white">&nbsp SUBTOTAL FOR
										ASSET</b></font></td>
							<td   class="width_10" align="right" height="30"
								style="background: #D37878 !important" style="font-size: 11px;" >
								<b style="color:white" align="right">{{totalAssetWithCurrent|number}}&nbsp</b></td>
								
								
								
											
							
<!-- 								{{-totalone | number:2}}&nbsp </b></td> -->
							
<!-- 								{{-totalone | number:2}}&nbsp </b></td> -->
							
</table>

</div>
					<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>