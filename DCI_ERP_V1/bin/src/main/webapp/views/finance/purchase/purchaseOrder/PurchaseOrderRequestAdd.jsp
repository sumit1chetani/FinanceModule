 <style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
	
       <form class="form-horizontal" name="purchaseOrderRequestForm"  novalidate  method="post">
        <div class="row">
         <div class="col-md-12">
          <fieldset>
           	<div class="form-group">
               
               <label class="col-md-2 control-label"> From Date
         		</label>
        		   <div class="col-md-3">
					 <div class='input-group date datetimepick'>
					    <div class="dropdown">
					      <a class="dropdown-toggle" id="requestFromDate" role="button"
					          data-toggle="dropdown" data-target="#" href="#">
					       <div class="input-group">
					         <input type="text" class="form-control"
					         placeholder="dd/mm/yyyy" name="requestFromDate"
					         validation="required" 
					         friendly-name="RequestFromDate"
					         data-ng-model="purchaseData.requestFromDate"><span
					         class="input-group-addon"><i
					         class="glyphicon glyphicon-calendar"></i></span>
					        </div>
					       </a>
					       <ul class="dropdown-menu" role="menu"
					          aria-labelledby="dLabel">
					          <datetimepicker data-ng-model="purchaseData.requestFromDate"
					          data-on-set-time="purchaseData.requestFromDate = onDateSet(newDate)"
					          data-datetimepicker-config="{ dropdownSelector: '#requestFromDate',startView:'day', minView:'day'}" />
					       </ul>
					      </div>
					  </div> 
				</div>
				<label class="col-md-2 control-label"> To Date
         		</label>
        		   <div class="col-md-3">
					 <!-- <div class='input-group date datetimepick'>
					    <div class="dropdown">
					      <a class="dropdown-toggle" id="reqToDate" role="button"
					          data-toggle="dropdown" data-target="#" href="#">
					       <div class="input-group">
					         <input type="text" class="form-control"
					         placeholder="dd/mm/yyyy" name="requestToDate"
					         validation="required" 
					         friendly-name="RequestToDate"
					         data-ng-model="purchaseData.requestToDate"><span
					         class="input-group-addon"><i
					         class="glyphicon glyphicon-calendar"></i></span>
					        </div>
					       </a>
					       <ul class="dropdown-menu" role="menu"
					          aria-labelledby="dLabel">
					          <datetimepicker data-ng-model="purchaseData.requestToDate"
					          data-on-set-time="purchaseData.requestToDate = onDateSet(newDate)"
					          data-datetimepicker-config="{ dropdownSelector: '#reqToDate',startView:'day', minView:'day'}" />
					       </ul>
					      </div>
					  </div> 
				</div> -->
				<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseData.requestToDate"
										id="Purchase Order Date" name="Purchase Order Date"
										data-ng-change="checkDatesCL(purchaseData.requestToDate)"
										friendly-name="Purchase Order Date"  />
			  </div>
				
			<div class="form-group">	
				<label class="col-md-2 control-label"> Vendor
	            </label>
	            <div class="col-md-3">
	              <input type="text" class="form-control" ng-model="vendorName" readonly />
	            </div>
	            
	            <label class="col-md-2 control-label"> Status
	            </label>
	            <div class="col-md-3">
	            <select class="form-control input-sm" id="status" name="status" data-ng-model="addQuoteStatus" disabled="disabled"
							        	data-ng-options="ac.id as ac.text for ac in statusList" ng-change="changeStatus(addQuoteStatus)">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
	              <button class="btn btn-success" type="button" style="position: absolute;top: 0;left: 98%;"ng-click="getApprovedPurchaseQuotation(purchaseData,purchaseOrderRequestForm)">Filter</button>
	            </div>
	            
<!-- 	            <button class="btn btn-success" type="button" -->
<!-- 	            ng-click="search(purchaseQuoteForm)" class="btn btn-success"> -->
<!-- 	            <i class="fa fa-search"></i> Search -->
<!-- 	           </button> -->
				
			</div> 
		   </fieldset>
         </div>
          </div>
		 <div class="col-md-12 padding-top-10">
		    
		       <div
		        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
		        data-st-table="displayedCollection"
		        data-st-safe-src="rowCollection">
		<!--         <div class="dt-toolbar" -->
		<!--          data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		        <table id="dt_basic"
		         class="table table-striped table-bordered table-hover dataTable no-footer"
		         role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           
		           <th class="width_1">
		            <label class="i-checks m-b-none">
		             <input type="checkbox">
		             <i></i>
		            </label>
		           </th>
		           <th class="sorting width_10" data-st-sort="">Req. No</th>
		           <th class="sorting width_10" data-st-sort="">Quote</th>
		           <th class="sorting width_10" data-st-sort="">Item Code-Item Name</th>
		           <th class="sorting width_15" data-st-sort="">Item Description</th>
		           <th class="sorting width_10" data-st-sort="">EDD</th>
		           <th class="sorting width_10" data-st-sort="">Status</th>
		          </tr>
		         </thead>
		         <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="departmentCollections in displayedCollection">
		           <td cs-select="departmentCollections"></td>
		           <td>{{departmentCollections.purchaseRequestNum}}</td>
		           <td>{{departmentCollections.purchaseQuoteId}}</td>
		           <td>{{departmentCollections.purchaseItemName}}</td>
		           <td>{{departmentCollections.purchaseItemDesc}}</td>
		           <td>{{departmentCollections.edd}}</td>
		           <td>{{departmentCollections.purchaseStatus}}</td>
		          </tr>
		         </tbody>
		        </table>
		<!--         <div class="dt-toolbar-footer" -->
		<!--          data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
		       </div>
		      </div>
		      <!-- end widget content -->
		     </div>
		    </div>    
         
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            class="btn btn-success"
            ng-click="getListValue(displayedCollection,addQuoteStatus)">
            <i class="fa fa-save">Save</i>
           </button>
           <button type="reset" class="btn btn-info"
            ng-click="reset(purchaseOrderRequestForm)">
            <i class="fa fa-undo">Reset</i>
            
           </button>
           <button class="btn btn-danger" type="reset"
            class="btn btn-success" ng-click="cancelReq()">
            <i class="fa fa-close">Cancel</i>
           
           </button>
          </div>
         </div>
        </div>
     </form>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   
   <!-- WIDGET END -->
  </div>

</div>
