
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
 	<%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-heading panel-heading-form font-bold">
  <!-- <div class="panel panel-default panel-default-form "> -->
	
		<input type="hidden" value="${form_code}" id="form_code_id">
  </div>
 </div>
</div>	

<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
	
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="form-body form-horizontal">
   <div class="row m-t-sm">
    <div class="col-sm-12 col-md-12 col-lg-12">
     
    
     
     
      <div class="col-sm-12 col-md-3 col-lg-3" ng-hide=true>
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">Show only</label>
        <div class="col-md-7">
         <selectivity list="typeList" property="type" id="typeFilter" ng-model="type"></selectivity>
        </div>
       </div>
      </fieldset>    
      
     </div>
     
     <div class="col-sm-12 col-md-3 col-lg-3" >
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">Vessel</label>
        <div class="col-md-7">
         <selectivity list="vesselList" property="ownersExpense.vessel" id="vessel" ng-model="ownersExpense.vessel"></selectivity>
        </div>
       </div>
      </fieldset>    
      
     </div>
     
     <div class="col-sm-12 col-md-3 col-lg-3" >
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">Vessel owner</label>
        <div class="col-md-7">
         <selectivity list="vesseOwnerList" property="ownersExpense.vesselOwnerCode" id="vesselOwner" ng-model="ownersExpense.vesselOwner"></selectivity>
        </div>
       </div>
      </fieldset>    
      
     </div>
     
     
     
     <div class="col-sm-12 col-md-6 col-lg-6">
      <div class="form-group">
       <button class="btn btn-success" type="button" data-ng-click="getUnAllocatedList();">
        Submit
       </button>
      </div>
      
     </div>
    </div>
    
   </div>
  </div> 
  	 <%@include file="/views/templates/panel-header_1.jsp"%>
  	
   <div class="widget-body no-padding ">
    <div class="table-responsive ">
     <table class="table table-striped b-t b-light table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
       <tr>
       <th class="width_1"></th>
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
      <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="ownExp.select" 
      ng-change="calculateTotalAmountForIA(displayedCollection)" id="select{{trIndex}}" ><i></i></label></td>
       <td>{{ownExp.companyName}}</td>
       <td>{{ownExp.invoiceDt}}</td>
       <td>{{ownExp.invoiceNo}}</td>
       <td>{{ownExp.vessel}}</td>
       <td>{{ownExp.vesselOwnerName}}</td>
       <td ng-hide=true>{{ownExp.vesselOwnerCode}}</td>
       <!--  <td>{{ownExp.hdrDescription}}</td> -->
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
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="form-group pull-right">
					
					<label class="col-md-3 control-label"> Total TC Amt</label>
					<div class="col-md-3">
						<input type="text" class="form-control input-sm"
							ng-model="totalTCAmount" readonly
							name="TC Total">
					</div> 
					
					<label class="col-md-3 control-label"> Total BC Amt</label>
				<div class="col-md-3">
						<input type="text" class="form-control input-sm"
							ng-model="totalBCAmount" readonly
							name="BC Total">
					</div>
					
				</div>
			</div>
		</div>
    <footer class="panel-footer">
     <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
    
     <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" ng-click="proceed(rowCollection)"  type="button">Proceed</button>
   					
   					<button class="btn btn-danger" ng-click="cancel()"  type="button">Cancel</button>
   				</div>
   			</div>
   	</div>
   </div>
  </div>
 </div>

</div>
