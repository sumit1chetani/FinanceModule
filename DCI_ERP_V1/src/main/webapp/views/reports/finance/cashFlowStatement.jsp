<style>
.multiselect{
width: 294px !important
}

.main_head{
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
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
	       <form class="form-horizontal" name="cashFlowStatementForm">
		        <div class="row">
		    	   <div class="col-sm-12 col-md-12 col-lg-12">
			         	<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="companyList" property="cashflow.company" id="company" object="companyCode"></selectivity>
										 
										  <!-- <select ng-model="company" multiple="multiple"
              id="company_id"  name="company_id" ng-options="option.id as option.text for option in companyList">
         </select> -->
									</div>
								</div>
							</fieldset>
						</div>
			        	 <div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From Date
										<span style="color: red;">*</span></label>
										<div class="col-md-7">
												<div class="input-group input-append date" id="cf_fromDate">
			   									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
			   									data-ng-model="cashflow.fromDate" name="fromDate" id="fromDate">
												 <span class="input-group-addon add-on">
			           								<span class="glyphicon glyphicon-calendar"></span>
			       								 </span>
							     				</div>
										</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To Date
										<span style="color: red;">*</span></label>
										<div class="col-md-7">
												<div class="input-group input-append date" id="cf_toDate">
			   									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
			   									ng-model="cashflow.toDate" name="toDate" id="toDate">
												 <span class="input-group-addon add-on">
			           								<span class="glyphicon glyphicon-calendar"></span>
			       								 </span>
							     			</div>
										</div>
								</div>
							</fieldset>
						</div>
					</div>				
	        	</div>
	        	<a id="PLExport" stype="display:none"
						href="filePath/CashFlowStatement.xls"
						download="CashFlowStatement.xls"></a>
		        <div class="form-actions">
		         <div class="row">
		          <div class="col-md-12 ">
		           <security:authorize access="hasRole('${form_code}_${view}')">
		           <button class="btn btn-success" ng-click="viewProfitLoss()">
		            <i class="fa fa-search"></i>View Report
		           </button>
		           </security:authorize>
		           <!--  <button class="btn btn-primary" ng-click="exportPLExcel()">
            			<i class="fa fa-search">Export Excel</i>
           				</button> -->
		           <button class="btn btn-info" type="button" class="btn btn-success" ng-click="resetData()">
		            <i class="fa fa-undo"></i>Reset
		           </button>
		          </div>
		         </div>
		        </div>
		    				<div class="row" ng-if="cashflowdata.length>0">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
					  <div class="main_head  bold toggleBlock-currsor text-center fontSize16 " > CONSOLIDATED CASH FLOW STATEMENT </div>
					<table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr><th class="text-center width_50" style="background: #8C8CB5 !important;">Particulars</th>
		        <th class="text-center width_50"  style="background: #8C8CB5 !important;">{{currYear}}</th></tr>
		        </thead>
		        </table>
		           <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr ng-click="toggleBlock('operating-activity')"><th class=" width_50">OPERATING ACTIVITIES:</th>
		        <th class="text-center width_50 text-right"> </th></tr>
		        </thead>
		        <tbody id="operating-activity">
							<tr>
								<td class="sorting ">Profit for the Year
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'323233232'}}
								</td>
								
							</tr>
							<tr>
								<td class="sorting ">Adjustements for
								</td>
								<td class="sorting text-right"> 
								</td>
								
							</tr>
							
							<tr>
								<td class="sorting ">~ Depreciation on Vessels and Equipment
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>							
							<tr>
								<td class="sorting ">~ Depreciation on Investment properties
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'60140001'}}
								</td>								
							</tr>
							
							<tr>
								<td class="sorting ">~ Provision for Employees' end of service benefit
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'20060001'}}
								</td>
								
							</tr>
							
							<tr>
								<td class="sorting ">~ Loss / (Profit) on disposal of Vessels and Equipment and Investment in Properties
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'20060001'}}
								</td>
								
							</tr>
								<tr>
								<td class="sorting ">~ Finance Costs
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'90000001'}}
								</td>
								
							</tr>
							<tr>
								<td  class="sorting ">
										<b>TOTAL</b></td>
								<td class="sorting text-right"><b>{{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</b></td>
								 
							</tr>
						</tbody>
		        </table>
		        
		            <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr ng-click="toggleBlock('working_capital')"><th class=" width_50">WORKING CAPITAL CHANGES:</th>
		        <th class="text-center width_50 text-right"> </th></tr>
		        </thead>
		        <tbody id="working_capital">
							<tr>
								<td class="sorting ">~ Inventories
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'323233232'}}
								</td>
								
							</tr>
							
						 
							<tr>
								<td class="sorting ">~ Accounts Receivable and Prepayments
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
							
							<tr>
								<td class="sorting ">~ Amount due from Related Parties
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>	
							<tr>
								<td class="sorting ">~ Amount due to Related Parties
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>	
							<tr>
								<td class="sorting ">~ Accounts Payables and Accruals
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>							
							 
							<tr>
								<td  class="sorting ">
										<b>TOTAL</b></td>
								<td class="sorting text-right"><b>{{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</b></td>
								 
							</tr>
						</tbody>
		        </table>
		        
		        
		          <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr ng-click="toggleBlock('cash_operation')"><th class=" width_50">CASH FROM OPERATIONS:</th>
		        <th class="text-center width_50 text-right"> </th></tr>
		        </thead>
		        <tbody id="cash_operation">
							<tr>
								<td class="sorting "> ~ Finance Costs Paid
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'323233232'}}
								</td>
								
							</tr>
							
						 
							<tr>
								<td class="sorting ">~ Employees' end of service benefits paid
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
							
						 
							<tr>
								<td  class="sorting ">
										<b>Net Cash from operating activities -</b></td>
								<td class="sorting text-right"><b>{{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</b></td>
								 
							</tr>
						</tbody>
		        </table>
		        
		           <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr ng-click="toggleBlock('investing_activities')"><th class=" width_50">INVESTING ACTIVITIES:</th>
		        <th class="text-center width_50 text-right"> </th></tr>
		        </thead>
		        <tbody id="investing_activities">
							<tr>
								<td class="sorting "> ~ Purchase of Vessels and Equipments
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'323233232'}}
								</td>
								
							</tr>
							
						 
							<tr>
								<td class="sorting ">~ Purchase of Investment in Properties
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
								<tr>
								<td class="sorting ">~ Proceeds from sale of vessels and equipments
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
							
									<tr>
								<td class="sorting ">~ Proceeds from sale of investment in properties
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
 
							<tr>
								<td  class="sorting ">
										<b>Net cash used in investing activities</b></td>
								<td class="sorting text-right"><b>{{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</b></td>
								 
							</tr>
						</tbody>
		        </table>
		        
		        
		         <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr ng-click="toggleBlock('financing_activity')"><th class=" width_50">FINANCING ACTIVITIES:</th>
		        <th class="text-center width_50 text-right"> </th></tr>
		        </thead>
		        <tbody id="financing_activity">
	 			<tr>
								<td class="sorting "> Net Investment in shareholder's current account
								</td>
								<td class="sorting text-right">{{cashflowdata|finddata:'323233232'}}
								</td>
								
							</tr>
							
						 
							<tr>
								<td class="sorting ">Term Loans received / (repaid) net
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
								<tr>
								<td class="sorting ">Amount received from related party
								</td>
								<td class="sorting text-right"> {{cashflowdata|finddata:'50050001'}}
								</td>
								
							</tr>
							
							 
 
							<tr>
								<td  class="sorting ">
										<b>Net Cash from / (used in) financing activities</b></td>
								<td class="sorting text-right"><b>{{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</b></td>
								 
							</tr>
						</tbody>
		        </table>
		            <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr  ><th class=" width_50">INCREASE IN CASH AND CASH EQUIVALENTS:</th>
		        <th class="text-center width_50 text-right"> {{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</th></tr>
		        </thead>
		      
		        </table>
		        
		          <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr  ><th class=" width_50">Cash and cash equivalent as at 1st January:</th>
		        <th class="text-center width_50 text-right"> {{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</th></tr>
		        </thead>
		      
		        </table>
		        
		         <table class="table table-striped table-hover data-table no-footer">
		        <thead class="dataTables-Main-Head">
		        <tr  ><th class=" width_50">Cash and cash equivalent as at End of every month:</th>
		        <th class="text-center width_50 text-right"> {{cashflowdata|totaldata:'323233232':'50050001':'60140001':'90000001':'20060001':'4'}}</th></tr>
		        </thead>
		      
		        </table>
		        
					
					</div>
				</div>
	    	</form>
	    </div> <!-- /panel-body -->
	</div> <!-- /panel-default -->
   </div> <!-- /wrapper-md -->
   


