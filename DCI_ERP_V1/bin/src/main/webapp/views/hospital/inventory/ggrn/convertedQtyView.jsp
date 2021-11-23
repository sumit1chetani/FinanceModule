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
     <header class="ngdialog-header"> <span class="widget-icon"> <i class="fa fa-table"></i> </span> <h2> Converted Quantity Details </h2> </header>
     	<div role="content">
      		<div class="widget-body">
       			<form class="form-horizontal" name="purchaseQuoteForm">
        			<div class="row">
        			<div class="col-md-12">
			
           
           <span title="cancel" style="left: 70% important;"> <i
						class="fa fa-close text-danger-dker text" style = "padding-left:97%;"
						data-ng-click="ngcancel()" ></i>
				</span> 
          </div>
         				<%-- <div class="col-sm-10 col-md-6">
          					<fieldset>
           					<div class="form-group">
	            			<label class="col-md-6 control-label"> Purchase Order No <spring:message code="label.asterisk.symbol"></spring:message> </label>
	            			<div class="col-md-5">
	              	<input type="text" class="form-control input-sm" ng-model="displayedCollection[0].poNo" readonly>
	            </div>
            </div>
			</fieldset>
        </div> --%>
    	<!-- <div class="col-sm-10 col-md-6">
          <fieldset>
           	<div class="form-group">
        		<label class="col-md-5 control-label"> Purchase  Order Date </label>
        		   <div class="col-md-5">
					 <input type="text" class="form-control input-sm"  ng-model="displayedCollection[0].poDate" readonly>
					</div>
			</div>

          </fieldset>
         </div> -->
                 <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all auto-scroll"
        data-st-table="displayedCollection"
        data-st-safe-src="rowdetailList">

        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info" style="width: 50% !important;">
         <thead class="dataTables-Main-Head">
          <tr>
           <tr>
           <th class="width_1 table-heading text-center" >
             <label class="i-checks m-b-none">
			         <input type="checkbox" name="post[]" ng-model="ggrnData.selectall" ng-change="chkAllPurchasefun(rowCollection,ggrnData.selectall)">
			         <i></i>
			         </label>
           </th><!-- 
           <th class="sorting width_10" data-st-sort="">Item Code</th> -->
           <th class="sorting width_10" data-st-sort="">Item Name</th><!-- 
           <th class="sorting width_10" data-st-sort="">Item Desc</th> -->
           <th class="sorting width_10" data-st-sort="">Purchase UOM</th>
           <th class="sorting width_10" data-st-sort="">Purchase Qty</th>
           <th class="sorting width_10" data-st-sort="">Vendor	UOM</th>
           <th class="sorting width_10" data-st-sort="">vendor Pending Qty</th>
           <th class="sorting width_10" data-st-sort="">Receiving Qty</th>
           <th class="sorting width_10" data-st-sort="">Converted Qty</th>
             <th class="sorting width_10" data-st-sort="">Action</th> 
          </tr>
         </thead>
         <tbody  ng-repeat="(trIndex, row) in displayedCollection">
              <tr >
			   <td class="" ng-show="row.pendingQty==0">
			        <label class="i-checks m-b-none">
			         <input type="checkbox" name="post[]" ng-model="row.select" disabled >
			         <i></i>
			        </label>
			   </td>
			   <td class="" ng-show="!row.pendingQty==0">
			        <label class="i-checks m-b-none">
			         <input type="checkbox" name="post[]" ng-model="row.select" >
			         <i></i>
			        </label>
			   </td>
               <!-- <td>{{row.dtlItemCode}}</td> -->
               <td>{{row.dtlItemName}}</td>
               <td hidden="true">{{row.rowId}}</td>
             <!--   <td>{{row.dtlItemDesc}}</td> -->
               <td class="text-left">{{row.purchaseUOMName}}</td>
               <td class="text-right">{{row.purchaseQty}}</td>
            <!--    <td class="text-right">{{row.vendorUOMName}}</td> -->
            <td class="text-left">
            <selectivity list="uomCategoryList"
																				property="row.vendorUOM" id="vendorUOM{{trIndex}}"
																				ng-model="row.vendorUOM" name="vendorUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(vendor) UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>
            </td>
               <td class="text-right">{{row.pendingQty}}</td>
				<td class="width_7"><input type="text"
				class="form-control input-sm" ng-model="row.receivingQtypop"
				name="pQty"  style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td>
				<td class="width_7"><input type="text"
				class="form-control input-sm" ng-model="row.convertedQtypop"
				name="pQty" style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td>
	<!-- <td class="width_7" hidden="true"><input type="text"
				class="form-control input-sm" ng-model="row.balanceconvertedQty"
				name="pQty" style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td> -->
			<td class=" td-actions text-center width_5">
               <span title="save"> <i class="fa fa-check text-success text"
						data-ng-click="addDtlRowValues(row,row.rowId)"></i>
				</span> 
				
				<br>
				 <!-- <span title="cancel"> <i
						class="fa fa-close text-danger-dker text"
						data-ng-click="ngcancel()" ></i>
				</span> --></td> 
              </tr>
             </tbody>
        </table>

       </div>
     	</div>

        <%-- <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
			<button class="btn btn-success" type="submit"
											data-ng-click="addDtlRowValues(displayedCollection)">
											<i class="fa fa-save"></i>
											<spring:message code="label.add"></spring:message>
										</button>
           <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="ngcancel()"> <i class="fa fa-close"></i>  <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div> --%>
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
