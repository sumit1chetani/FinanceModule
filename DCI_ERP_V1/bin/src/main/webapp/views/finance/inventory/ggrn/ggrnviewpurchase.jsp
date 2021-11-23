<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header"> <span class="widget-icon"> <i class="fa fa-table"></i> </span> <h2> View Purchase Details </h2> </header>
     	<div role="content">
      		<div class="widget-body">
       			<form class="form-horizontal" name="purchaseQuoteForm">
        			<div class="row">
         				<div class="col-sm-10 col-md-6">
          					<fieldset>
           					<div class="form-group">
	            			<label class="col-md-6 control-label"> Purchase Order No<span style = "color:red">*</span> </label>
	            			<div class="col-md-5">
	              	<input type="text" class="form-control input-sm" ng-model="displayedCollection[0].poNo" readonly>
	            </div>
            </div>
			</fieldset>
        </div>
    	<div class="col-sm-10 col-md-6">
          <fieldset>
           	<div class="form-group">
        		<label class="col-md-5 control-label"> Purchase  Order Date </label>
        		   <div class="col-md-5">
					 <input type="text" class="form-control input-sm"  ng-model="displayedCollection[0].poDate" readonly>
					</div>
			</div>

          </fieldset>
         </div>
                 <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all auto-scroll"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">

        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <tr>
           <th class="width_1 table-heading text-center" >
             <label class="i-checks m-b-none">
			         <input type="checkbox" name="post[]" ng-model="ggrnData.selectall" ng-change="chkAllPurchasefun(rowCollection,ggrnData.selectall)">
			         <i></i>
			         </label>
           </th>
           <th class="sorting width_10" data-st-sort="">Item Code</th>
           <th class="sorting width_10" data-st-sort="">Item Name</th>
           <th class="sorting width_10" data-st-sort="">Item Desc</th>
           <th class="sorting width_10" data-st-sort="">Unit Price</th>
           <th class="sorting width_10" data-st-sort="">Ordered Qty</th>
           <th class="sorting width_10" data-st-sort="">Pending Qty</th>
            <!-- <th class="sorting width_10" data-st-sort="">Action</th> -->
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body" >
              <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="ggrnData in displayedCollection">
			   <td class="" ng-show="ggrnData.pendingQty==0">
			        <label class="i-checks m-b-none">
			         <input type="checkbox" name="post[]" ng-model="ggrnData.select" disabled >
			         <i></i>
			        </label>
			   </td>
			   <td class="" ng-show="!ggrnData.pendingQty==0">
			        <label class="i-checks m-b-none">
			         <input type="checkbox" name="post[]" ng-model="ggrnData.select" >
			         <i></i>
			        </label>
			   </td>
               <td>{{ggrnData.dtlItemCode}}</td>
               <td>{{ggrnData.dtlItemName}}</td>
               <td>{{ggrnData.dtlItemDesc}}</td>
               <td class="text-right">{{ggrnData.dtlPrice}}</td>
               <td class="text-right">{{ggrnData.dtlQty}}</td>
               <td class="text-right">{{ggrnData.pendingQty}}</td>
               <!-- <td class=" td-actions text-center width_5">
               <span> <i class="fa fa-pencil text-success text"
						data-ng-click="editRow(departmentCollections)"></i>
				</span> <span> <i
						class="fa fa-trash-o text-danger-dker text"
						data-ng-click="deleteRow(departmentCollections)"></i>
				</span></td> -->
              </tr>
             </tbody>
        </table>

       </div>
     	</div>

        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
			<button class="btn btn-success" type="submit"
											data-ng-click="fetchDetail(displayedCollection)">
											<i class="fa fa-save"></i>Add
										</button>
           <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="ngcancel()"> <i class="fa fa-close"></i> Cancel
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
