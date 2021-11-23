
<input type="hidden" value="${form_code}" id="form_code_id">
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
	
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
  	<%@include file="/views/templates/panel-header-form.jsp"%>
  	<div class="form-body form-horizontal">
   <div class="row m-t-sm">
    <div class="col-sm-12 col-md-12 col-lg-12">
    <div class="col-sm-12 col-md-3 col-lg-3" >
    </div>
    
     <div class="col-sm-12 col-md-4 col-lg-4" >
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">Subject</label>
        <div class="col-md-7">
         <input type="text" class="text-left form-control input-sm" ng-model="agencyCommision.subject">
        </div>
       </div>
      </fieldset>    
      
     </div>
     
     
     
     
    </div>
    
   </div>
  </div> 
  	
   <div class="widget-body no-padding ">
   
   
    <div class="table-responsive ">
     <table class="table table-striped b-t b-light table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
       <tr>
        <th class="width_10">Company</th>
        <th class="width_10">Invoice Date</th>
        <th class="width_10">Invoice No</th>
        <th class="width_10">Vessel</th>
        <th class="width_10">Vessel Owner</th>
        <th class="width_10" ng-hide=true>Vessel Owner Code</th>
        <!-- <th class="width_20" >Subject</th> -->
        <th class="width_20" >Description</th>
        <th class="width_6">Currency</th>
        <th class="width_6">Ex Rate</th>
        <th class="width_6">TC Amt</th>
        <th class="width_6">BC Amt</th>
       </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="ownExp in displayedCollection">
       <td>{{ownExp.companyName}}</td>
       <td>{{ownExp.invoiceDt}}</td>
       <td>{{ownExp.invoiceNo}}</td>
       <td>{{ownExp.vessel}}</td>
       <td>{{ownExp.vesselOwnerName}}</td>
       <td ng-hide=true>{{ownExp.vesselOwnerCode}}</td>
       <!-- <td>{{ownExp.hdrDescription}}</td> -->
       <td>{{ownExp.description}}</td>
       <td>{{ownExp.currencyCode}}</td>
       <td>{{ownExp.exchangeRate}}</td>
      <td class="sorting">
		<input type="text" class="form-control input-sm" ng-model="ownExp.tcAmount" 
				name="tcAmount" placeholder="0.0" ng-keyup="calculateBCAmount(ownExp)">
	  </td>
		<td class="sorting"> 
			<input type="text" class="form-control input-sm" ng-model="ownExp.bcAmount" 
					name="bcAmount" placeholder="0.0" ng-keyup="calculateTCAmount(ownExp)">
		</td>
       
       
      </tr>
     </tbody>    
     </table>
    </div>
    <br>
   <div class="panel-heading bold toggleBlock-currsor" > Agency Commision</div>
   <br>
				<div class="table-responsive"   style= "margin-bottom: 11px;">
					<table class="table table-striped table-hover dataTable no-footer" id="freightCostdiv">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" st-sort="sailedDate">Desciption</th>
								<th class="sorting width_20" st-sort="sailedDate">Currency</th>
								<th class="sorting width_20" st-sort="sailedDate">Exchange rate</th>
								<th class="sorting width_15" st-sort="amountLocal">TC Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="sorting">
									<input type="text" class="form-control input-sm" ng-model="agencyCommision.description" 
										name="description" >
								</td>
								<td class="sorting">
									<selectivity list="currencyList" property="agencyCommision.currency" name="Currency"  
											id="currency" object="currency" ng-model="agencyCommision.currency" ></selectivity>
								</td>
								<td class="sorting"> 
									<input type="text" class="form-control input-sm text-right" ng-model="agencyCommision.exchangeRate" 
										ng-blur="exchagerateCalculation(agencyCommision.exchangeRate)"	name="exchangeRate" placeholder="0.0">
								</td>
								<td class="sorting"> 
									<input type="text" class="form-control input-sm text-right" ng-model="agencyCommision.tcAmount" 
											name="tcAmount" placeholder="0.0" ng-blur="calculateBCAmount(agencyCommision)">
								</td>
								<td class="sorting"> 
									<input type="text" class="form-control input-sm text-right" ng-model="agencyCommision.bcAmount" 
											name="bcAmount" placeholder="0.0"  ng-blur="calculateTCAmount(agencyCommision)">
								</td>
							</tr>
						</tbody>
						
					</table>
				</div>
						<div class="row">
						<div class="col-sm-6 col-md-6 col-lg-6">
						</div>
			<div class="col-sm-6 col-md-6 col-lg-6">
				<div class="form-group">
					
					<label class="col-md-3 control-label"> Total TC Amt</label>
					<div class="col-md-2">
						<input type="text" class="form-control input-sm"
							ng-model="totalTC1Amount" readonly 
							name="TC Total">
					</div> 
					
					<label class="col-md-3 control-label"> Total BC Amt</label>
				<div class="col-md-2">
						<input type="text" class="form-control input-sm"
							ng-model="totalBC1Amount" readonly 
							name="BC Total">
					</div>
					
				</div>
			</div>
		</div>
    
     <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
				
		    	<button class="btn btn-success" ng-click="calculate()" type="button">View Total</button>
   					<button class="btn btn-success" ng-click="save(displayedCollection)"  type="button">Save</button>
   					
   					<button class="btn btn-danger" ng-click="cancel()"  type="button">Cancel</button>
   				</div>
   			</div>
   	</div>
   </div>
  </div>
 </div>

</div>
