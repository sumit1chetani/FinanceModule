<%-- <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header"> <span class="widget-icon"> <i class="fa fa-table"></i> </span> <h2> View Batch Details </h2> </header>
     	<div role="content">
      		<div class="widget-body"> --%>
      		<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       			<form class="form-horizontal" name="purchaseQuoteForm">
        			<div class="row">
                 		<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all auto-scroll"
        					data-st-table="displayedCollectionBatch" data-st-safe-src="rowCollectionBatch">
        					<table id="dt_basic"
         						class="table table-striped table-bordered table-hover dataTable no-footer"
         							role="grid" aria-describedby="dt_basic_info">
         						<thead class="dataTables-Main-Head">
           							<tr>
							           <th class="sorting text-center padding-both-side-2 width_10" >Item Name</th>
							           <th class="sorting text-center padding-both-side-2 width_10" ng-if="itemBatch">Batch No</th>
							           <th class="sorting text-center padding-both-side-2 width_6" >Receive Qty</th>
							          <!--  <th class="sorting text-center padding-both-side-2 width_6" ng-if="itemMrp">MRP</th>
							           <th class="sorting text-center padding-both-side-2 width_7" ng-if="itemExpDate">Expiry Date</th> -->
							          
						          </tr>
         					</thead>
         					<tbody class="dataTables-Main-Body">
              					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="batchData in displayedCollectionBatch">
								 
					               <td>{{batchData.itemName}}</td>
					               <td ng-if="itemBatch">{{batchData.batchNo}}</td>
					               <td>{{batchData.receiveQty}}</td>
					              <!--  <td ng-if="itemMrp">{{batchData.mrpPrice}}</td>
					               <td ng-if="itemExpDate">{{batchData.expiryDate}}</td> -->
					               
              					</tr>
             			</tbody>
        			</table>
       			</div>
     		</div>
	        <div class="form-actions">
	         <div class="row">
	          <div class="col-md-12">
	           <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancelBatch()"> 
	           		<i class="fa fa-close"></i>  Cancel
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