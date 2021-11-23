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
				 <th class="width_1 table-heading text-center">
		            <label class="i-checks m-b-none" >
		             <input type="checkbox" ng-model="selectedAll" ng-change="checkItemAll(selectedAll)">
		             <i></i>
		            </label>
		           </th>
		           <th class="sorting text-center padding-both-side-2 width_10" >Item Name</th>
		           <th class="sorting text-center padding-both-side-2 width_10" ng-if="itemBatch">Batch No<spring:message
													code="label.asterisk.symbol"></spring:message></th>
		           <th class="sorting text-center padding-both-side-2 width_6" >Batch Qty <spring:message
													code="label.asterisk.symbol"></spring:message></th>
		           <th class="sorting text-center padding-both-side-2 width_6" ng-if="itemMrp">MRP</th>
		           <th class="sorting text-center padding-both-side-2 width_7" ng-if="itemExpDate">Expiry Date</th>
		           <th class="sorting text-center padding-both-side-2 width_10" ng-if="itemManufacture" >Manufacture Dtls</th>
	          </tr>
	         </thead>

	         <tbody ng-repeat="(trIndex, row) in batchListItem">
				<tr>
					<td class="width_1 table-heading text-center"><label class="i-checks m-b-none"> <input
						type="checkbox" ng-model="row.select"
						id="section{{trIndex}}"><i></i></label></td>
					<td class="width_10">
						<div class="row">
							<div class="">
								<input type="hidden" class="form-control input-small" ng-model="row.batchItemId" name="dtlItemId" />
								<input type="text" class="form-control input-small" ng-model="row.batchItemName" name="dtlItemCode"
								readonly="readonly" />
							</div>
						</div>
					</td>
					<!-- ng-blur="getOldBatchNumber(row)"  -->
					<td class="width_10" ng-if="itemBatch">
						<div class="row">
							<div class="">
								<input type="text"  maxlength="50" 
								ng-pattern-restrict="^[a-zA-Z0-9]*$" class="form-control input-small" ng-model="row.lotNo" name="batchNo" ng-disabled="isEdit"/>
							</div>
						</div>
					</td>
					<td class="width_6">
						<div class="row">
							<div class="">
								<input type="text" class="form-control input-small" ng-model="row.batchQty" name="batchQunty" id="bQty_{{trIndex}}"
								data-ng-blur="onChangeNumber('bQty_'+trIndex,row.batchQty)" style="text-align: right;" 
								ng-pattern-restrict="^[0-9.]*$"  ng-disabled="isEdit"/>
							</div>
						</div>
					</td>

					<td class="width_6" ng-if="itemMrp">
						<div class="row">
							<div class="">
								<input type="text" class="form-control input-small" ng-model="row.mrp" name="mrpDtl" id="retailPrice_{{trIndex}}"
								data-ng-blur="onChangeDecimal('retailPrice_'+trIndex,row.mrp)" style="text-align: right;" 
								ng-pattern-restrict="^[0-9.]*$"  ng-disabled="isEdit || isBatchMrp"/>
							</div>
						</div>
					</td>
					<td class="width_7" ng-if="itemExpDate">
						<div class="row">
							<div class="">
								<input type="text" class="form-control input-small" ng-model="row.expiryDate" name="expDate"   ng-disabled="isEdit || isBatchExpired"/>
							</div>
						</div>
					</td>
					<td class="width_10" ng-if="itemManufacture">
						<div class="row">
							<div class="">
								<input type="text" ng-pattern-restrict="^[a-zA-Z0-9_]*$" class="form-control input-small" ng-model="row.manufactureDef" name="manufactureDefnition"  ng-disabled="isEdit"/>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
        </table>
        <div class="padding-right-5" id="AddOrRmveMeritbtn" data-ng-if="!isEdit">
			<button ng-click="addBatchRow(grnData.batchDtls)"
				class="btn btn-sm btn-info" tooltip="Add Row"
				ng-disabled="" type="button">
				<i class="fa fa-plus"></i>
			</button>
			<button ng-click="removeBatchRow(grnData.batchDtls)"
				class="btn btn-sm btn-danger" type="button"
				tooltip="Delete">
				<i class="fa  fa-trash-o"></i>
			</button>
		</div>
       </div>
       </form>
        </div>
        <div class="form-actions">
         <div class="row" >
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="saveBtchDtls(grnBatchDtls)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
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