<!-- #MAIN CONTENT -->
<style>
.datetimepicker{
width:326px;
}
.th-padding{
  padding: 9px 9px !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0019_D')" var="isDelete" />
<security:authorize access="hasRole('F0019_A')" var="isAdd" />
<security:authorize access="hasRole('F0019_UP')" var="isUpload" /> --%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
    
     <div role="content">
      <div class="widget-body no-padding">
      <form class="form-horizontal" name="PurchaseOrderForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
         <div class="col-md-6">
         <div class="form-group">
	            <label class="col-md-3 control-label"> PO From Date </label>
	            <div class="col-md-7">
							<div class='input-group datetimepick col-md-5 pull-left'>
					            <div class="dropdown">
					             <a class="dropdown-toggle" id="startDate" role="button"
					              data-toggle="dropdown" data-target="#" href="#">
					              <div class="input-group">
					               <input type="text" class="form-control padding-right-0"
					                placeholder="dd/mm/yyyy" name="postartDate"
					               data-ng-model="purchaseFilter.startDate"><span
					                class="input-group-addon"><i
					                class="glyphicon glyphicon-calendar"></i></span>
					              </div>
					             </a>
					             <ul class="dropdown-menu" role="menu"
					              aria-labelledby="dLabel">
					              <datetimepicker data-ng-model="purchaseFilter.startDate"
					               data-on-set-time="purchaseFilter.startDate = onDateSet(newDate)"
					               data-datetimepicker-config="{ dropdownSelector: '#startDate',startView:'day', minView:'day'}" />
					             </ul>
					            </div>
					           </div> 
					           <label class="col-md-2 control-label">To </label>
					           <div class='input-group datetimepick col-md-5'>
					            <div class="dropdown">
					             <a class="dropdown-toggle" id="endDate" role="button"
					              data-toggle="dropdown" data-target="#" href="#">
					              <div class="input-group">
					               <input type="text" class="form-control padding-right-0"
					                placeholder="dd/mm/yyyy" name="poendDate"
					               data-ng-model="purchaseFilter.endDate"><span
					                class="input-group-addon"><i
					                class="glyphicon glyphicon-calendar"></i></span>
					              </div>
					             </a>
					             <ul class="dropdown-menu" role="menu"
					              aria-labelledby="dLabel">
					              <datetimepicker data-ng-model="purchaseFilter.endDate"
					               data-on-set-time="purchaseFilter.endDate = onDateSet(newDate)"
					               data-datetimepicker-config="{ dropdownSelector: '#endDate',startView:'day', minView:'day'}" />
					             </ul>
					            </div>
					           </div> 
						</div>
			
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Item</label>
            <div class="col-md-5">
            <selectivity list="itemList" property="purchaseFilter.itemId"></selectivity>
           <!--  <select class="form-control input-sm" id="item" name="item" 
            data-ng-model="purchaseFilter.itemId"
			        	data-ng-options="ac.id as ac.text for ac in itemList">
			          	<option value="" selected="selected">--Select--</option>
		     </select> -->
            </div>
          </div>
         </div>
          <div class="col-md-6">
            <div class="form-group">
            <label class="col-md-4 control-label"> Vendor </label>
            <div class="col-md-5">
            <selectivity list="vendorList" property="purchaseFilter.vendorId"></selectivity>
            <!-- <select class="form-control input-sm" id="vendor" name="vendor" 
            data-ng-model="purchaseFilter.vendorId"
			        	data-ng-options="ac.id as ac.text for ac in vendorList">
			          	<option value="" selected="selected">--Select--</option>
		     </select> -->
            </div>
	          </div>
	           <div class="form-group">
	            <label class="col-md-4 control-label">Status</label>
	            <div class="col-md-5">
	            <select class="form-control input-sm" id="status" name="status" 
	            data-ng-model="purchaseFilter.statusId"
				        	data-ng-options="ac.id as ac.text for ac in statusList">
				          	<option value="" selected="selected">--Select--</option>
			     </select>
	            </div>
             </div>
          </div>
        
         
         
        
       
       </div>
       <div class="form-actions b-none bg-none">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success ng-scope" type="button" data-ng-click="filterPurchaseOrder(purchaseFilter)">
					Filter
           </button>
          </div>
         </div>
        </div>
       </div>
       </form>
    </div>
    </div>
    
     <div role="content" ng-hide="isShow">
      <div class="widget-body no-padding">
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
       <!--  <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
        
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 table-heading" style="padding: 9px 9px !important;">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
           <th class="sorting width_8 " data-st-sort="purchaseOrderNum" 
           style="padding-left: 8px !important;padding-right: 0px !important;">Purchase Order No</th>
           <th class="sorting width_7 " data-st-sort="purchaseOrderDate" 
           style="padding-left: 5px !important;padding-right: 0px !important;">Purchase Order Date</th>
           <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
           <th class="sorting width_12" data-st-sort="detailItemName">Item Name</th>
           <th class="sorting width_5" data-st-sort="detailQuantity">Quantity</th>
           <%-- <th class="width_8 text-center table-heading"><spring:message code="label.action"></spring:message></th> --%>
          </tr>
         </thead>
		<tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
           <!-- <td cs-select="collections" ></td> -->
            <td>{{collections.purchaseOrderNum}}</td>
            <td>{{collections.purchaseOrderDate}}</td>
            <td>{{collections.vendorName}}</td>
            <td>{{collections.purchaseTypeName}}</td>
            <td>{{collections.purchaseStatus}}</td>
            <td>{{collections.detailItemName}}</td>
            <td>{{collections.detailQuantity}}</td>
           <%--  <td class=" td-actions text-center">
          <security:authorize access="hasRole('F0021_M')">   
        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' && collections.purchaseStatus !='Cancelled' ">
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collections)"></i>
        </span>
        </security:authorize>
         <security:authorize access="hasRole('F0021_V')">
        <span ng-if="collections.purchaseStatus == 'Approved' || collections.purchaseStatus == 'Rejected' ||  collections.purchaseStatus == 'Cancelled' ">
         <i class="fa  fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
        </span>
        </security:authorize>
         <security:authorize access="hasRole('F0021_D')">
        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' && collections.purchaseStatus !='Cancelled'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
        </span>
        </security:authorize>
       </td> --%>
          </tr>
         </tbody>
        </table>
        <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>
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