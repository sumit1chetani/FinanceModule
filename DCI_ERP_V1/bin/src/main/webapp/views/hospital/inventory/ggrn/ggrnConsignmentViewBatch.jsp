<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}

 .input-small {
height: 18px;
padding: 5px 0px;
font-size: 12px;
line-height: 1.5;
border-radius: 2px;
padding-left: 1px;
}

#dt_basic > thead > tr > th.width_1.table-heading.text-center > label{
margin-left: 10px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
	      <span class="widget-icon"> <i class="fa fa-table"></i></span>
	      <h2> Item Batch Details </h2>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
      <form class="form-horizontal" name="purchaseQuoteForm">
    	<div class="table-responsive clear col-sm-12 padding-top-10">
		<table id="dt_basic"
		         class="table table-striped table-bordered table-hover dataTable no-footer"
		         role="grid" aria-describedby="dt_basic_info">
			<thead class="dataTables-Main-Head">
				<tr>
			<!-- 	 <th class="width_1 table-heading text-center">
		            <label class="i-checks m-b-none" >
		             <input type="checkbox" ng-model="selectedAll" ng-change="checkItemAll(selectedAll)">
		             <i></i>
		            </label>
		           </th> -->
		           <th class="sorting text-center padding-both-side-2 width_10" >Item Name</th>
		           <th class="sorting text-center padding-both-side-2 width_10" ng-if="itemBatch">Batch No</th>
		           <th class="sorting text-center padding-both-side-2 width_6" >Batch Qty</th>
		            
		          <!--  <th class="sorting text-center padding-both-side-2 width_6" ng-if="itemMrp">MRP</th>
		           <th class="sorting text-center padding-both-side-2 width_7" ng-if="itemExpDate">Expiry Date</th>
		           <th class="sorting text-center padding-both-side-2 width_10" ng-if="itemManufacture" >Manufacture Dtls</th> -->
	          </tr>
	         </thead>

	         <tbody ng-repeat="(trIndex, row) in batchListItem">
				<tr>
					<!-- <td class="width_1 table-heading text-center"><label class="i-checks m-b-none"> <input
						type="checkbox" ng-model="row.select"
						id="section{{trIndex}}"><i></i></label></td> -->
					<td class="width_10">{{row.batchItemName}}
						<div class="row">
							<!-- <div class="">
								
								<input type="hidden" class="form-control input-small" ng-model="row.batchItemId" name="dtlItemId" />
								<input type="text" class="form-control input-small" ng-model="row.batchItemName" name="dtlItemCode"
								readonly="readonly" />
							</div> -->
						</div>
					</td>
					<td class="width_10" ng-if="itemBatch">{{row.lotNo}}
					</td>
				
					<td class="width_6">{{row.batchQty}}
					</td>
				</tr>
			</tbody>
        </table>
  
       </div>
       </form>
        </div>
        <div class="form-actions">
         <div class="row" >
          <div class="col-md-12">
         
           <button class="btn btn-danger" type="button"
            data-ng-click="ngcancel();">
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
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>