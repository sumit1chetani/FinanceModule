<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
    <form name="jvAccountForm" class="form-horizontal" >
    <div class="row book-widget-row">


		<div class="col-sm-12">
			<fieldset>
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="JvAccountDate">
          					<input type="text" class="form-control " name="JvAccountDate" id="jvAccountDate" ng-model="JvAccount.jvAccountDate" placeholder='dd/mm/yyyy' />
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
         					</div>
						</div>
						
						
					</div>
				</div>
				
				<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Vessel</label>
							<div class="col-md-7">
								<!-- <select class="form-control input-sm" id="vessel" name="vessel"
								ng-model="JvAccount.vesselCode"
								ng-options="r.vesselCode as r.vesselName  for r in VesselList"
								ng-change="onVesselChange(JvAccount.vesselCode)">
								<option value="" selected="selected">Select</option>
								</select> -->
        
           <selectivity list="VesselList" property="JvAccount.vesselCode" id="vessel_id" object="vessel"></selectivity>
							</div>
						</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Voyage</label>
						<div class="col-md-7">
       <selectivity list="VoyageList" property="JvAccount.voyageCode" id="voyage_id" object="voyage"></selectivity>
							<!-- <select class="form-control input-sm" id="voyage" name="voyage"
								ng-model="JvAccount.voyageCode"
								ng-options="r.voyageCode as r.voyageCode for r in VoyageList"
								ng-change="onVoyageChange(JvAccount.voyageCode)">
								<option value="" selected="selected">Select</option>
							</select> -->
						</div>
					</div>
				</div>

			</fieldset>
		</div>

		<div class="col-sm-12">
			<fieldset>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Name of JV Partner</label>
						<div class="col-md-7">
         <selectivity list="PartnerList" property="JvAccount.partnerCode" id="partner_id" object="partner"></selectivity>
         
							<!-- <select class="form-control input-sm input-sm" id="partner" ng-model="JvAccount.partnerCode"
								ng-options="r.partnerCode as r.partnerName for r in PartnerList"
								ng-change="onPartnerChange(JvAccount.partnerCode)">
								<option value="" selected="selected">Select</option>
							</select> -->
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">JV Agreement No.</label>
						<div class="col-md-7">
      
        <selectivity list="JVAgreementList" property="JvAccount.agreementNo" id="agreementNo_id" object="agreementNo"></selectivity>
							<!-- <select class="form-control input-sm input-sm" id="agreementNo" name="agreementNo"
								ng-model="JvAccount.agreementNo" 
								data-ng-options="r.agreementNo as r.agreementNo for r in JVAgreementList"
								ng-change="onJvAgreementChange(JvAccount.agreementNo)">
								<option value="" selected="selected">Select</option>
							</select> -->
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Currency</label>
						<div class="col-md-7">
							<select class="form-control input-sm input-sm" id="CurrencyCode" name="CurrencyCode"
								ng-model="JvAccount.currencyCode" 
								data-ng-options="r.currencyCode as r.currencyName for r in CurrencyList">
								<option value="" selected="selected">Select</option>
							</select>
						</div>
					</div>
				</div>
				
			
			</fieldset>
		</div>

		<div class="col-sm-12">
			<fieldset>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Percentage of Sharing</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="SharingPercentage" name="SharingPercentage"
								placeholder="10%" readonly
								ng-model="JvAccount.sharingPercentage">
						</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label class="col-md-3 control-label padding-right-0">Type of JV</label>
						<div class="col-md-9 inputGroupContainer padding-left-30">
							<label class="radio radio-inline line-height-30 i-checks">
							<input type="radio" class="style-0" name="jvtypesCRP" checked="checked" ng-model="JvAccount.jvType" value="CRP" />
							<i></i>Cost & Revenue Pooling</label>
							<label class="radio radio-inline line-height-30 i-checks">
							<input type="radio" class="style-0" name="jvTypesS" ng_model="JvAccount.jvType" value="S" />
							<i></i>Swap</label>
							<label class="radio radio-inline line-height-30 i-checks">
							<input type="radio"  class="style-0" name="jvTypesRVC" ng_model="JvAccount.jvType" value="RVC" />
							<i></i>Share of RVC</label>
						</div>
					</div>
				</div>
			</fieldset>
		</div>
		
		<div class="col-sm-12">
			<fieldset>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Commencement Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="CommencementDate">
          					<input type="text" class="form-control " name="CommencementDate" id="commencementDate" ng-model="JvAccount.commencementDate" placeholder='dd/mm/yyyy' />
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
         					</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Completion Date </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="CompletionDate">
          					<input type="text" class="form-control " name="CompletionDate" id="completionDate" ng-model="JvAccount.completionDate" placeholder='dd/mm/yyyy' />
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
         					</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Vessel Operator</label>
						<div class="col-md-7">
								<select class="form-control input-sm" id="VesselOperator" name="VesselOperator"
								ng-model="JvAccount.vesselOperatorCode"
								ng-options="r.vesselOperatorCode as r.vesselOperatorName  for r in VesselOperatorList">
								<option value="" selected="selected">Select</option>
								</select>
							</div>
					</div>
				</div>

			</fieldset>
		</div>
	</div>
      
      <br>
      <div class="table-responsive" >
      	<table class="table table-striped b-t b-light">
        	<thead>
          		<tr>
		            <th rowspan=2 class="width_1"></th>
		            <th rowspan=2  class="width_10 text-center v-middle">Pol</th>
		            <th rowspan=2  class="width_10 text-center v-middle">Pod</th>
		            <th rowspan=2  class=" width_10 text-center v-middle">Slot Acc</th>
		            <th rowspan=2  class="width_10 text-center v-middle">Pool Quote</th>
		            <th colspan=4  class="width_25 text-center">Actual Volume</th>
		            <th rowspan=2  class="width_7 text-center v-middle">20's</th>
		            <th rowspan=2  class="width_7 text-center v-middle">40's</th>
		            <th rowspan=2  class="width_9 text-center v-middle">Total</th>
		            <th rowspan=2  class="width_12 text-center v-middle">Amount</th>
          		</tr>
		        <tr>
		            <th>D20</th>
		            <th>D40</th>
		            <th>M20</th>
		            <th>M40</th>
		        </tr>
          		
       		</thead>
        	<tbody ng-repeat="(trIndex, row) in JvAccount.detail" >
         		<tr>
         		 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
         		 <td>
	         		<select class="form-control input-sm" ng-model="row.pol" name="Pol" data-ng-options="r.portCode as r.portCode for r in PortList">
	                <option value="">--Select--</option>
	                </select>
		 		 </td>
		 		
		 		<td>
	         	<select class="form-control input-sm" ng-model="row.pod" name="Pod" data-ng-options="r.portCode as r.portCode for r in PortList">
	               <option value="">--Select--</option>
	              </select>
		 		</td>
		 		
		 		<td>
	         	<select class="form-control input-sm" ng-model="row.slotCode" name="SlotCode" data-ng-options="r.slotCode as r.slotName for r in SlotList"
	         	ng-change="onSlotChange(row)">
	               <option value="">--Select--</option>
	              </select>
		 		</td>
		 		
		 		<td>
	         	<select class="form-control input-sm" ng-model="row.poolQuoteCode" name="PoolQuote" data-ng-options="r.poolQuoteCode as r.poolQuoteCode for r in PoolQuoteList"
	         	ng-change="onPoolQuoteChange(row)" >
	               <option value="">--Select--</option>
	              </select>
		 		</td>
		 		
         		<td><input class="form-control input-sm" type="text" ng-model="row.d20" id="D20{{trIndex}}"></td>
         		<td><input class="form-control input-sm" type="text" ng-model="row.d40" id="D40{{trIndex}}"></td>
         		<td><input class="form-control input-sm" type="text" ng-model="row.m20" id="M20{{trIndex}}"></td>
         		<td><input class="form-control input-sm" type="text" ng-model="row.m40" id="M40{{trIndex}}"></td>
		        <td><input class="form-control input-sm" type="text" ng-model="row.unit20" id="Unit20{{trIndex}}"></td>
		        <td><input class="form-control input-sm" type="text" ng-model="row.unit40" id="Unit40{{trIndex}}"></td>
		        <td><input class="form-control input-sm text-right" type="text" ng-model="row.total" id="Total{{trIndex}}"></td>
		        <td><input class="form-control input-sm text-right" type="text" ng-model="row.amount" id="Amount{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-keyup="calculateRevenueTotal(JvAccount.detail)" ></td>
         	</tr>
         	</tbody>
        
      </table>
      
      	<div class="padding-right-5">
      		<div class="col-md-4">
          		 <button ng-click="addRow(JvAccount.detail)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            		<i class="fa fa-plus"></i>
           		</button>
           		<button ng-click="removeRow(JvAccount.detail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
           			 <i class="fa  fa-trash-o"></i>
          		 </button>
          	</div>
          	<div class="col-md-8">
					<div class="form-group">
						<label class="col-md-8 control-label">Operating Revenue Total</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm text-right" id="RevenueTotal" name="RevenueTotal"
									ng-model="JvAccount.revenueTotal" readonly>
						</div>
					</div>
			</div>
        </div>
        
        <div class="col-sm-12 padding-top-10">
         <div class="padding-right-5">
      		<div class="col-md-4">
      			<button ng-click="showOperatingCost()" class="btn btn-primary" type="button" ng-if="!isOperatingCost">
          		 Show Operating Cost</button>
          		 <button ng-click="showOperatingCost()" class="btn btn-primary" type="button" ng-if="isOperatingCost">
          		 Hide Operating Cost</button>
          	</div>
          	
          	<div class="col-md-8">
			</div>
        </div>
        </div>
        <!-- Operating Cost div -->
        <div class="col-sm-12 padding-top-10" ng-if="isOperatingCost">
			<fieldset class="b-a padding-top-10">
			<div class="col-sm-12">
				<div class="col-md-3">
					<div class="form-group">
						<label class="col-md-6 control-label">Port Cost</label>
						<div class="col-md-6">
							<input type="text" class="form-control input-sm" id="PortCost" name="PortCost"
								placeholder="100" 	ng-model="OperatingCost.portCost" ng-keyup="calculateOperatingCost(OperatingCost)" />
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker Fuel Oil</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerFuelOilQty" name="BunkerFuelOilQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerFuelOilQty" ng-keyup="calculateBunkerFuelOilCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerFuelOilRate" name="BunkerFuelOilRate"
								placeholder="100"  ng-model="OperatingCost.bunkerFuelOilRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" ng-keyup="calculateBunkerFuelOilCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerFuelOilAmt" name="BunkerFuelOilAmt"
								placeholder="100" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-model="OperatingCost.bunkerFuelOilAmt">
							</div>
						</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="col-md-3">
					<div class="form-group">
						<label class="col-md-6 control-label">Agency Cost</label>
						<div class="col-md-6">
							<input type="text" class="form-control input-sm" id="AgencyCost" name="AgencyCost"
								placeholder="100" 	ng-model="OperatingCost.agencyCost" ng-keyup="calculateOperatingCost(OperatingCost)">
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker Gas Oil</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerGasOilQty" name="BunkerGasOilQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerGasOilQty"  ng-keyup="calculateBunkerGasOilCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerGasOilRate" name="BunkerGasOilRate"
								placeholder="100"  ng-model="OperatingCost.bunkerGasOilRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" ng-keyup="calculateBunkerGasOilCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerGasOilAmount" name="BunkerGasOilAmount"
								placeholder="100" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-model="OperatingCost.bunkerGasOilAmount">
							</div>
						</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="col-md-3">
					<div class="form-group">
						<label class="col-md-6 control-label">Charters Liability</label>
						<div class="col-md-6">
							<input type="text" class="form-control input-sm" id="CharterLiability" name="CharterLiability"
								placeholder="100" 	ng-model="OperatingCost.charterLiability" ng-keyup="calculateOperatingCost(OperatingCost)">
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Charter Hire Cost</label>
							
							<label class="col-md-1 control-label">DD/HR/MI</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="CharterHireCostTime" name="CharterHireCostTime"
								placeholder="100" 	ng-model="OperatingCost.charterHireCostTime" ng-keyup="calculateCharterHireCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Rate/Day</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="CharterHireCostRate" name="CharterHireCostRate"
								placeholder="dd:hr:mi"  ng-model="OperatingCost.charterHireCostRate" ng-keyup="calculateCharterHireCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="CharterHireCostAmount" name="CharterHireCostAmount"
								placeholder="100" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-model="OperatingCost.charterHireCostAmount" >
							</div>
						</div>
				</div>
			</div>
			
			
			<div class="col-sm-12">
				<div class="col-md-3">
					<div class="form-group">
						<label class="col-md-6 control-label">Sundry Expenses</label>
						<div class="col-md-6">
							<input type="text" class="form-control input-sm" id="SundryExpenses" name="SundryExpenses"
								placeholder="100" 	ng-model="OperatingCost.sundryExpenses" ng-keyup="calculateOperatingCost(OperatingCost)">
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Off Hire Cost</label>
							
							<label class="col-md-1 control-label">DD/HR/MI</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="OffHireCostTime" name="OffHireCostTime"
								placeholder="100" 	ng-model="OperatingCost.offHireCostTime" ng-keyup="calculateOffHireCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Rate/Day</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="OffHireCostRate" name="OffHireCostRate"
								placeholder="dd:hr:mi"  ng-model="OperatingCost.offHireCostRate" ng-keyup="calculateOffHireCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="OffHireCostAmount" name="OffHireCostAmount"
								placeholder="100" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-model="OperatingCost.offHireCostAmount">
							</div>
						</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="col-md-3">
					<div class="form-group">
						<label class="col-md-6 control-label">Other Cost</label>
						<div class="col-md-6">
							<input type="text" class="form-control input-sm" id="OtherCost" name="OtherCost"
								placeholder="100" 	ng-model="OperatingCost.otherCost" ng-keyup="calculateOperatingCost(OperatingCost)">
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker FO Consumption</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerFOConsumptionQty" name="BunkerFOConsumptionQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerFOConsumptionQty" ng-keyup="calculateBunkerFOConsumptionCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerFOConsumptionRate" name="BunkerFOConsumptionRate"
								placeholder="100"  ng-model="OperatingCost.bunkerFOConsumptionRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" ng-keyup="calculateBunkerFOConsumptionCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerFOConsumptionAmount" name="BunkerFOConsumptionAmount"
								placeholder="100" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-model="OperatingCost.bunkerFOConsumptionAmount">
							</div>
						</div>
				</div>
			</div>
			
			<div class="col-sm-12">
				<div class="col-md-3">
					
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker GO Consumption</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerGOConsumptionQty" name="BunkerGOConsumptionQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerGOConsumptionQty" ng-keyup="calculateBunkerGOConsumptionCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerGOConsumptionRate" name="BunkerGOConsumptionRate"
								placeholder="100"  ng-model="OperatingCost.bunkerGOConsumptionRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" ng-keyup="calculateBunkerGOConsumptionCost(OperatingCost)">
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm text-right" id="BunkerGOConsumptionAmount" name="BunkerGOConsumptionAmount"
								placeholder="100" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" ng-model="OperatingCost.bunkerGOConsumptionAmount">
							</div>
						</div>
				</div>
			</div>
			
			</fieldset>
		</div>
		
		
		
		<!--  End of Operating cost div -->
		<div class="col-sm-12 padding-top-10">
		<div class="padding-right-5">
      		<div class="col-md-4">
      		<button ng-click="calculateOperatingCost(OperatingCost)" class="btn btn-primary" type="button" >
          		 Calculate Operating Cost</button>
          	</div>
          	
          	<div class="col-md-8">
					<div class="form-group">
						<label class="col-md-8 control-label">Operating Cost Amount</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm text-right" id="OperatingCostTotal" name="OperatingCostTotal"
									ng-model="JvAccount.operatingCostTotal" readonly>
						</div>
					</div>
			</div>
        </div>
        </div>
        
        <div class="col-sm-12">
        <div class="padding-right-5">
      		<div class="col-md-4">
          	</div>
          	<div class="col-md-8">
					<div class="form-group">
						<label class="col-md-8 control-label">Final Amount</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm text-right" id="FinalAmount" name="FinalAmount"
									ng-model="JvAccount.finalAmount" readonly>
						</div>
					</div>
			</div>
        </div>
      </div>
      </div>
      
      <div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-if="!isEdit" ng-click="save(JvAccount)">
           <i class="fa fa-save"></i>
           Save
          </button>
          <button class="btn btn-success" type="button" ng-if="isEdit" ng-click="save(JvAccount)">
           <i class="fa fa-save"></i>
           Update
          </button>
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>
	<!-- sub table Ends -->
   </form>
  </div>
 </div>
</div>
