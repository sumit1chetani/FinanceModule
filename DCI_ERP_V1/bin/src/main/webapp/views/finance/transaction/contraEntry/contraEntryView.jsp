<div class="wrapper-md">
	<div class="panel panel-default">
		<div class="panel-heading font-bold"></div>
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label bold ">Customer</label>
							<label class="col-md-7 control-label  vessel-text" ng-bind="payerName"></label>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	
	 <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive" >
  
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
       <th class="sorting width_15" st-sort="invoiceNo">Invoice No</th>
       <th class="sorting width_14" st-sort="invoiceAmount">Invoice Amt</th>
       <th class="sorting width_9" st-sort="tcAmount">Received Amt TC</th>
       <th class="sorting width_9" st-sort="bcAmount">Received Amt BC</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
       <td>
         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceNo"></span>
       </td>
        <td  tooltip="{{objTranslationItem.invoiceAmount}}" class="width_10 text-right" ng-bind="objTranslationItem.invoiceAmount1">
       </td>
       <td tooltip="{{objTranslationItem.tcAmount}}" class="width_10 text-right" ng-bind="objTranslationItem.tcAmount1">
       </td>
       <td tooltip="{{objTranslationItem.bcAmount}}" class="width_10 text-right" ng-bind="objTranslationItem.bcAmount1">
       </td>
      
      </tr>
     </tbody>
    </table>
   </div>
  
 

   <div class="row"><br></div>
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-danger" ng-click="cancel()" type="button">Back to list</button>
   				</div>
   			</div>
   	</div>
  </div>
</div>