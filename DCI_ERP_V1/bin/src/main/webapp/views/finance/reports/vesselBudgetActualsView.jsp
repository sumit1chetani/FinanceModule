<div class="wrapper-md" ng-init="getVessel()">
 <div class="panel panel-default panel-default-form" st-table="displayedCollection" st-safe-src="rowCollection">
 		<%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="CrewAllocationViewForm" role="form">
    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="col-sm-3 col-md-3 col-lg-3">
       <div class="form-group">
        <label class="col-md-3 control-label padding-top-0 bold"> Company </label>
        <div class="col-md-5">{{budgetAllocation.vesselName}}</div>
       </div>
      </div>
      <!-- <div class="col-sm-4 col-md-4 col-lg-4">
       <div class="form-group">
        <label class="col-md-3 control-label padding-top-0 bold">From Date </label>
        <div class="col-md-5">{{budgetAllocation.fromDate}}</div>
       </div>
      </div>
      <div class="col-sm-4 col-md-4 col-lg-4">
       <div class="form-group">
        <label class="col-md-4 control-label padding-top-0 bold"> To Date </label>
        <div class="col-md-5">{{budgetAllocation.toDate}}</div>
       </div>
      </div> -->
      
      <div class="col-sm-12 col-md-12 col-lg-4">
      <fieldset>
        <div class="form-group form-group-label-left">
          <label for="inputPassword" class="control-label col-md-5">From Date </label>
          <div class="col-md-7">
           <div class="input-group input-append date" id="budget_from_date">
            <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="budgetAllocation.fromDate" name="fromDate" id="fromDate">
            <span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
          </div>
         </div>
      </fieldset>
     </div>
       <div class="col-sm-12 col-md-12 col-lg-4">
      <fieldset>
         <div class="form-group form-group-label-left">
          <label for="inputPassword" class="control-label col-md-5">To Date </label>
          <div class="col-md-7">
           <div class="input-group input-append date" id="budget_to_date">
            <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="budgetAllocation.toDate" name="toDate" id="toDate">
            <span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
          </div>
         </div>
      </fieldset>
     </div>
     </div>
    </div>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" type="button" ng-click="search()">
        <i class="fa fa-search"></i> View
       </button>
         <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
          <i class="fa fa-close"></i> Cancel
         </button>
      </div>
     </div>
    </div>
   </form>
   <div class="table-responsive " style="border: 0px solid red">
    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border: 0px solid Red" style="border:0px solid red">
     <thead class="dataTables-Main-Head">
      <tr>
       <th>Sl.No.</th>
       <th>Account Code</th>
       <th>Budget Description</th>       
       <th>Actual</th>
       <th>Budget</th>
       <th>Variance</th>
       <th>Variance %</th>
     </thead>
     <tbody>
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in budgetAllocation.budgetAllocationDtlBeanList" class="lpo_cls">
      <td class=" width_5">{{$index+1}}</td>
       <td class=" width_15">{{objItem.acctHeadCode}}</td>
       <td class=" width_28">{{objItem.budgetDesc}}</td>
       <td class=" width_13" align="right">{{objItem.actualAmt | number:2}}</td>
       <td class=" width_13" align="right">{{objItem.allocatedAmount | number:2}}</td>
       <td class=" width_13" align="right">{{objItem.actualAmt-objItem.allocatedAmount | number:2}}</td>
       <td class=" width_13" align="right"><span ng-if="objItem.allocatedAmount!=0">{{ ((objItem.actualAmt-objItem.allocatedAmount)/ objItem.allocatedAmount)*100 | number:3}}</span>
       <span ng-if="objItem.allocatedAmount==0">{{ ((objItem.actualAmt-objItem.allocatedAmount)/ 1)*100 | number:2}}</span>
        </td>
       
      </tr>
      <tr>
       <td colspan="3" align="right" class="wpr-text-bold">Total</td>
       <td class=" width_13 wpr-text-bold" align="right">{{budgetAllocation.actualTotalAmt | number:2}}</td>
       <td class=" width_13 wpr-text-bold" align="right">{{budgetAllocation.budgetTotalAmt | number:2}}</td>
       <td class=" width_13 wpr-text-bold" align="right">{{budgetAllocation.actualTotalAmt-budgetAllocation.budgetTotalAmt | number:2}}</td>
       <td class=" width_13 wpr-text-bold" align="right"><span ng-if="budgetAllocation.budgetTotalAmt!=0"> {{ ((budgetAllocation.actualTotalAmt-budgetAllocation.budgetTotalAmt)/ budgetAllocation.budgetTotalAmt)*100 | number:2}}</span>
       <span ng-if="budgetAllocation.budgetTotalAmt==0"> {{ ((budgetAllocation.actualTotalAmt-budgetAllocation.budgetTotalAmt)/ 1)*100 | number:2}}</span>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   
  </div>
 </div>
</div>