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
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       Add Purchase Quotation List
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="managePendingForm">
        <div class="row">
         <div class="col-md-12">
          <fieldset>
           	<div class="form-group">
               
               <label class="col-md-2 control-label"> From Date
         		</label>
        		   <div class="col-md-3">
					 <div class='input-group date datetimepick'>
					    <div class="dropdown">
					      <a class="dropdown-toggle" id="reqDate" role="button"
					          data-toggle="dropdown" data-target="#" href="#">
					       <div class="input-group">
					         <input type="text" class="form-control"
					         placeholder="dd/mm/yyyy" name="requestDate"
					         data-validator="required" data-valid-method="submit"
					         data-message-id="requestDate"
					         data-ng-model="purchaseData.requestDate"><span
					         class="input-group-addon"><i
					         class="glyphicon glyphicon-calendar"></i></span>
					        </div>
					       </a>
					       <ul class="dropdown-menu" role="menu"
					          aria-labelledby="dLabel">
					          <datetimepicker data-ng-model="purchaseData.requestDate"
					          data-on-set-time="purchaseData.requestDate = onDateSet(newDate)"
					          data-datetimepicker-config="{ dropdownSelector: '#reqDate',startView:'day', minView:'day'}" />
					       </ul>
					      </div>
					  </div> 
				</div>
				<label class="col-md-2 control-label"> To Date
         		</label>
        		   <div class="col-md-3">
					 <div class='input-group date datetimepick'>
					    <div class="dropdown">
					      <a class="dropdown-toggle" id="reqDate" role="button"
					          data-toggle="dropdown" data-target="#" href="#">
					       <div class="input-group">
					         <input type="text" class="form-control"
					         placeholder="dd/mm/yyyy" name="requestDate"
					         data-validator="required" data-valid-method="submit"
					         data-message-id="requestDate"
					         data-ng-model="purchaseData.requestDate"><span
					         class="input-group-addon"><i
					         class="glyphicon glyphicon-calendar"></i></span>
					        </div>
					       </a>
					       <ul class="dropdown-menu" role="menu"
					          aria-labelledby="dLabel">
					          <datetimepicker data-ng-model="purchaseData.requestDate"
					          data-on-set-time="purchaseData.requestDate = onDateSet(newDate)"
					          data-datetimepicker-config="{ dropdownSelector: '#reqDate',startView:'day', minView:'day'}" />
					       </ul>
					      </div>
					  </div> 
				</div>
			  </div>
				
			<div class="form-group">	
				<label class="col-md-2 control-label"> Vendor
	            </label>
	            <div class="col-md-3">
	              <input type="text" class="form-control" readonly />
	            </div>
	            
	            <label class="col-md-2 control-label"> Status
	            </label>
	            <div class="col-md-3">
	              <select class="form-control input-sm" ng-model="addQuoteList.status">
	              	<option value="">Select</option>
	              	<option value="1">Pending</option>
					<option value="2">Approved</option>
					<option value="3">Rejected</option>
	              </select>
	            </div>
	            
<!-- 	            <button class="btn btn-success" type="button" -->
<!-- 	            ng-click="search(purchaseQuoteForm)" class="btn btn-success"> -->
<!-- 	            <i class="fa fa-search"></i> Search -->
<!-- 	           </button> -->
				
			</div> 
		   </fieldset>
         </div>
		 <div class="col-md-12 padding-top-10">
		     <div role="content">
		      <div class="widget-body no-padding">
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
		           <th class="sorting width_10" data-st-sort="">Item Code</th>
		           <th class="sorting width_10" data-st-sort="">Item Name</th>
		           <th class="sorting width_15" data-st-sort="">Item Description</th>
		           <th class="sorting width_10" data-st-sort="">EDD</th>
		           <th class="sorting width_10" data-st-sort="">Status</th>
		          </tr>
		         </thead>
		<!--          <tbody class="dataTables-Main-Body"> -->
		<!--           <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="departmentCollections in displayedCollection"> -->
		        
		             
		<!--           </tr> -->
		<!--          </tbody> -->
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
            data-ng-if="!isEdit"
            ng-click="save(managePendingForm)" class="btn btn-success">
            <i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-if="isEdit == true" class="btn btn-success"
            ng-click="update(managePendingForm)">
            <i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
           </button>
           <button type="reset" class="btn btn-info"
            ng-click="reset(managePendingForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="reset"
            class="btn btn-success" ng-click="cancelReq()">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
