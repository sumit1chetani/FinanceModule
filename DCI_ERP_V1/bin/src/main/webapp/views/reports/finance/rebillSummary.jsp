<style>
.brk{
width:120px;
     display:block;
    word-break:break-all;
}
.body {
    background-color: #00ff00;
}
</style>

<%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
    	<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form class="form-horizontal" novalidate name="arform">

    <div class="row ">
					<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="col-sm-1 ">
					</div>

						<div class="col-sm-3 ">
							<div class="form-group">
								<label class="col-md-4 control-label"> Company <!-- 	<span style="color: red;">*</span> -->
								</label>
								<div class="col-md-6">
									<selectivity list="companyList"
										property="corgReport.companyCode" id="companyCode"
										object="tempDropDownObj"></selectivity>

								</div>
							</div>
						</div>

						

						
						<div class="col-sm-3 " style="margin-left: -85px;">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> Year </label>
								<div class="col-md-6 col-sm-push-2 nopadding" style="margin-left: -46px;">
										<selectivity list="yearList" property="corgReport.year"
											id="year"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<div class="col-md-12">
									<label class="col-md-3 control-label">From Week </label>
									<div class="col-md-1 nopadding">
										<selectivity list="weekList" property="corgReport.fromWeek"
											id="week"></selectivity>
									</div>
									<label class="col-md-3 control-label"> To Week </label>
									<div class="col-md-1 nopadding">
										<selectivity list="weekList" property="corgReport.toWeek"
											id="week"></selectivity>
									</div>
									<label class="col-md-3 control-label"> {{weekEndDate}}
									</label>
								</div>

							</div>
						</div>
						
						
					</div>
				</div>
  
           <a id="summaryExcel" stype="display:none"
					href="filePath/CreditnoteSummary.xls" download="CreditnoteSummary.xls"></a>
			<div class="form-actions">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
							<button class="btn btn-success" type="submit"
										ng-click="viewSummary()">
										<i class="fa fa-search"></i>View Summary
									</button>
							<button class="btn btn-success" type="submit"
								ng-click="viewDetails()">
								<i class="fa fa-search"></i>View Details
							</button>
							
							<button class="btn btn-primary" type="submit"
								ng-click="exportSummary()">
								<i class="fa fa-search"></i>Export Excel
							</button>
						<button class="btn btn-info" type="reset" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
					</div>
				</div>
			</div>
    <div ng-if = "viewSummary1"> <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
							 <th class=" width_5">Week</th>
							 <th class=" width_5 text-center">Number Of CN</th>
								<th class=" width_5 text-center">Sum Of CN</th>
								<th class=" width_5 text-center">Sum Of Rebilled</th>
								<th class=" width_5 text-center">Sum Of GainorLoss</th>
								<th class=" width_5 text-center">Sum Of CN Amount for THC Billing Error</th>
								<th class=" width_5 text-center">Sum Of CN Amount for DF/Swap Billing Error (USD)</th>
						</tr>
          
       </thead>
      
       <tbody class="tr-tbody"  data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
        <tr ng-show="objTranslationItem.week=='Total'">
								<td class = "body">  {{objTranslationItem.week}}</td>
								<td class = "text-right body">  {{objTranslationItem.numOfCN}}</td>
								<td class="text-right body">{{objTranslationItem.sumOfCN}}</td>
								<td class="text-right body">{{objTranslationItem.sumOfRebill}}</td>
								<td class="text-right body">{{objTranslationItem.sumOfGRL}}</td>
								<td class="text-right body">{{objTranslationItem.thc}}</td>
								<td class="text-right body">{{objTranslationItem.df}}</td></tr>
								
								  <tr ng-hide="objTranslationItem.week=='Total'">
								<td >{{objTranslationItem.week}}</td>
								<td class = "text-right">  {{objTranslationItem.numOfCN}}</td>
								<td class="text-right">{{objTranslationItem.sumOfCN}}</td>
								<td class="text-right">{{objTranslationItem.sumOfRebill}}</td>
								<td class="text-right">{{objTranslationItem.sumOfGRL}}</td>
								<td class="text-right">{{objTranslationItem.thc}}</td>
								<td class="text-right">{{objTranslationItem.df}}</td></tr>
							
							
            </tbody> 
     </table>
   
    </div>
   <footer class="panel-footer">
    	<%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  </div>
  </div>
  
  <div ng-if = "viewDetails1" class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%-- <div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold">
			 <%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%>
		</div> --%>
		<div class="panel-body float-left padding-0" style="width:100%;">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
							<tr role="row">
								<!-- <th class=" width_9">Year</th> -->
								<th class=" width_12">Week</th>
								<th class=" width_9">Creditnote No</th>
								<th class=" width_9">Invoice No</th>
								<th class=" width_9">Company Name</th>
								<th class=" width_12">Invoice Date</th>
								<th class=" width_9">Vessel</th>
								<th class=" width_9">Voyage</th>
								<th class=" width_9">POL</th>
								<th class=" width_9">POD</th>
								<th class=" width_9">Creditnote Amt</th>
								<th class=" width_9">Rebill invoice No</th>
								<th class=" width_9">Rebilled Amount</th>
								<th class=" width_9">Gain/Loss</th>
								<th class=" width_9">Reason For Creditnote</th>
								<th class=" width_9">CN Amount for THC Billing Error</th>
								<th class=" width_9">CN Amount for DF/Swap Billing Error (USD)</th>
								<th class=" width_9">Person Applied For CN</th>
								<th class=" width_9">Status</th>
								
							</tr>
						</thead>
					<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
								
								<td class = "brk">{{objTranslationItem.week}}</td>
								<td >{{objTranslationItem.creditnoteNo}}</td>
								<td >{{objTranslationItem.invoiceNo}}</td>
								<td >{{objTranslationItem.cmpyName}}</td>
								<td class = "brk">{{objTranslationItem.invoiceDt}}</td>
								<td >{{objTranslationItem.vessel}}</td>
								<td class = "brk">{{objTranslationItem.voyage}}</td>
								<td >{{objTranslationItem.pol}}</td>
								<td >{{objTranslationItem.pod}}</td>
								<td class="text-right">{{objTranslationItem.creditnoteAmt}}</td>
								<td >{{objTranslationItem.rebilledInv}}</td>
								<td class="text-right">{{objTranslationItem.rebilledAmt}}</td>
								<td class="text-right">{{objTranslationItem.gainorloss}}</td>
								<td class = "brk">{{objTranslationItem.narration}}</td>		
								<td >{{objTranslationItem.thc}}</td>
								<td >{{objTranslationItem.df}}</td>
								<td >{{objTranslationItem.createdBy}}</td>
								<td >{{objTranslationItem.status}}</td>				
							</tr>
						</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
	
			
  
  </form>
  </div>
</div>
</div>
