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
          					<input type="text" class="form-control " name="JvAccountDate" id="JvAccountDate" ng-model="JvAccount.jvAccountDate" placeholder='dd/mm/yyyy' readonly />
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
								<input type="text" class="form-control input-sm" id="vessel" name="vessel"
								ng-model="JvAccount.vesselCode" readonly/>
								
							</div>
						</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Voyage</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="voyage" name="voyage"
								ng-model="JvAccount.voyageCode" readonly/>
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
							<input type="text" class="form-control input-sm" id="jvPartner" name="jvPartner"
								ng-model="JvAccount.partnerCode" readonly/>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">JV Agreement No.</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="agreementNo" name="agreementNo"
								ng-model="JvAccount.agreementNo" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Currency</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="CurrencyCode" name="CurrencyCode"
								ng-model="JvAccount.currencyCode" readonly/>
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
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Type of JV</label>
						<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="jvType" name="jvType"
								ng-model="JvAccount.jvType" readonly/>
						</div>
					</div>
				</div>
			</fieldset>
		</div>
		
		<div class="col-sm-12">
			<fieldset>

				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Commencement Period </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="CommencementDate">
          					<input type="text" class="form-control " name="CommencementDate" id="CommencementDate" ng-model="JvAccount.commencementDate" placeholder='dd/mm/yyyy' readonly/>
          					<span class="input-group-addon add-on">
          					 <span class="glyphicon glyphicon-calendar"></span>
         					 </span>
         					</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Completion period </label>
						<div class="col-md-7 inputGroupContainer">
							<div class="input-group input-append date" id="CompletionDate">
          					<input type="text" class="form-control " name="CompletionDate" id="CompletionDate" ng-model="JvAccount.completionDate" placeholder='dd/mm/yyyy' readonly/>
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
								<input type="text" class="form-control input-sm" id="vesselOperatorCode" name="vesselOperatorCode"
								ng-model="JvAccount.vesselOperatorCode" readonly/>
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
       		
        	<tbody ng-repeat="row in displayedCollection" >
         		<tr>
         		 
         		 <td>
	         		<span class="tool-tip-span"  ng-bind="row.pol"></span>
		 		 </td>
		 		
		 		<td>
	         	<span class="tool-tip-span"  ng-bind="row.pod"></span>
		 		</td>
		 		
		 		<td>
	         	<span class="tool-tip-span"  ng-bind="row.slotCode"></span>
		 		</td>
		 		
		 		<td>
	         	<span class="tool-tip-span"  ng-bind="row.poolQuoteCode"></span>
		 		</td>
		 		
         		<td><span class="tool-tip-span"  ng-bind="row.d20"></span></td>
         		<td><span class="tool-tip-span"  ng-bind="row.d40"></span></td>
         		<td><span class="tool-tip-span"  ng-bind="row.m20"></span></td>
         		<td><span class="tool-tip-span"  ng-bind="row.m40"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="row.unit20"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="row.unit40"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="row.total"></span></td>
		        <td><span class="tool-tip-span"  ng-bind="row.amount"></span></td>
         	</tr>
         	</tbody>
        
      </table>
      
      	<div class="padding-right-5">
      		<div class="col-md-4">
          		 
          	</div>
          	<div class="col-md-8">
					<div class="form-group">
						<label class="col-md-8 control-label">Operating Revenue Total</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm" id="RevenueTotal" name="RevenueTotal"
									ng-model="JvAccount.revenueTotal" readonly>
						</div>
					</div>
			</div>
        </div>
        
        <div class="col-sm-12 padding-top-10">
         <div class="padding-right-5">
      		<div class="col-md-4">
          	</div>
          	
          	<div class="col-md-8">
			</div>
        </div>
        </div>
        <!-- Operating Cost div -->
        <div class="col-sm-12 padding-top-10" >
			<fieldset class="b-a padding-top-10">
			<div class="col-sm-12">
				<div class="col-md-3">
					<div class="form-group">
						<label class="col-md-6 control-label">Port Cost</label>
						<div class="col-md-6">
							<input type="text" class="form-control input-sm" id="PortCost" name="PortCost"
								placeholder="100" 	ng-model="OperatingCost.portCost" ng-keyup="calculateOperatingCost(OperatingCost)" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker Fuel Oil</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerFuelOilQty" name="BunkerFuelOilQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerFuelOilQty" ng-keyup="calculateBunkerFuelOilCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerFuelOilRate" name="BunkerFuelOilRate"
								placeholder="100"  ng-model="OperatingCost.bunkerFuelOilRate" ng-keyup="calculateBunkerFuelOilCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerFuelOilAmt" name="BunkerFuelOilAmt"
								placeholder="100" ng-model="OperatingCost.bunkerFuelOilAmt" readonly/>
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
								placeholder="100" 	ng-model="OperatingCost.agencyCost" ng-keyup="calculateOperatingCost(OperatingCost)" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker Gas Oil</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerGasOilQty" name="BunkerGasOilQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerGasOilQty" ng-keyup="calculateBunkerGasOilCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerGasOilRate" name="BunkerGasOilRate"
								placeholder="100"  ng-model="OperatingCost.bunkerGasOilRate" ng-keyup="calculateBunkerGasOilCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerGasOilAmount" name="BunkerGasOilAmount"
								placeholder="100" ng-model="OperatingCost.bunkerGasOilAmount" readonly/>
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
								placeholder="100" 	ng-model="OperatingCost.charterLiability" ng-keyup="calculateOperatingCost(OperatingCost)" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Charter Hire Cost</label>
							
							<label class="col-md-1 control-label">DD/HR/MI</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="CharterHireCostTime" name="CharterHireCostTime"
								placeholder="100" 	ng-model="OperatingCost.charterHireCostTime" ng-keyup="calculateCharterHireCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Rate/Day</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="CharterHireCostRate" name="CharterHireCostRate"
								placeholder="dd:hr:mi"  ng-model="OperatingCost.charterHireCostRate" ng-keyup="calculateCharterHireCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="CharterHireCostAmount" name="CharterHireCostAmount"
								placeholder="100" ng-model="OperatingCost.charterHireCostAmount" readonly/>
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
								placeholder="100" 	ng-model="OperatingCost.sundryExpenses" ng-keyup="calculateOperatingCost(OperatingCost)" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Off Hire Cost</label>
							
							<label class="col-md-1 control-label">DD/HR/MI</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="OffHireCostTime" name="OffHireCostTime"
								placeholder="100" 	ng-model="OperatingCost.offHireCostTime" ng-keyup="calculateOffHireCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Rate/Day</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="OffHireCostRate" name="OffHireCostRate"
								placeholder="dd:hr:mi"  ng-model="OperatingCost.offHireCostRate" ng-keyup="calculateOffHireCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="OffHireCostAmount" name="OffHireCostAmount"
								placeholder="100" ng-model="OperatingCost.offHireCostAmount" readonly/>
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
								placeholder="100" 	ng-model="OperatingCost.otherCost" ng-keyup="calculateOperatingCost(OperatingCost)" readonly/>
						</div>
					</div>
				</div>
				
				<div class="col-md-9">
						<div class="form-group">
							<label class="col-md-3 control-label">Bunker FO Consumption</label>
							
							<label class="col-md-1 control-label">Qty</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerFOConsumptionQty" name="BunkerFOConsumptionQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerFOConsumptionQty" ng-keyup="calculateBunkerFOConsumptionCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerFOConsumptionRate" name="BunkerFOConsumptionRate"
								placeholder="100"  ng-model="OperatingCost.bunkerFOConsumptionRate" ng-keyup="calculateBunkerFOConsumptionCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerFOConsumptionAmount" name="BunkerFOConsumptionAmount"
								placeholder="100" ng-model="OperatingCost.bunkerFOConsumptionAmount" readonly/>
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
								<input type="text" class="form-control input-sm" id="BunkerGOConsumptionQty" name="BunkerGOConsumptionQty"
								placeholder="100" 	ng-model="OperatingCost.bunkerGOConsumptionQty" ng-keyup="calculateBunkerGOConsumptionCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Rate</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerGOConsumptionRate" name="BunkerGOConsumptionRate"
								placeholder="100"  ng-model="OperatingCost.bunkerGOConsumptionRate" ng-keyup="calculateBunkerGOConsumptionCost(OperatingCost)" readonly/>
							</div>
							
							<label class="col-md-1 control-label">Amount</label>
							<div class="col-md-2">
								<input type="text" class="form-control input-sm" id="BunkerGOConsumptionAmount" name="BunkerGOConsumptionAmount"
								placeholder="100" ng-model="OperatingCost.bunkerGOConsumptionAmount" readonly/>
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
      		</div>
          	
          	<div class="col-md-8">
					<div class="form-group">
						<label class="col-md-8 control-label">Operating Cost Amount</label>
						<div class="col-md-4">
								<input type="text" class="form-control input-sm" id="OperatingCostTotal" name="OperatingCostTotal"
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
								<input type="text" class="form-control input-sm" id="FinalAmount" name="FinalAmount"
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
          <button class="btn btn-danger" ng-click="close()" type="button">
           <i class="fa fa-close"></i>
           Close
          </button>
         </div>
        </div>
       </div>
	<!-- sub table Ends -->
   </form>
  </div>
 </div>
</div>
