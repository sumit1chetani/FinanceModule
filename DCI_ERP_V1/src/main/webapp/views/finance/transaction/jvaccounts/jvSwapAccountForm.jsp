<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="jvSwapAcctForm" class="form-horizontal">
				<div class="row book-widget-row">

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<select class="form-control input-sm input-sm" id="customerName"
											name="customerName" data-ng-model="swapAccount.customerCode"
											ng-change="onCustomerChange(swapAccount.customerCode);"
											ng-options="r.customerCode as r.customerName for r in customerList">
											<option value="" selected="selected">Select</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Payer</label>
									<div class="col-md-7">
										<select class="form-control input-sm input-sm" id="cmbpayerName"
											name="payerName" data-ng-model="swapAccount.payerCode"
											ng-options="r.payerCode as r.payerName for r in payerList">
											<option value="" selected="selected">Select</option>
										</select>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage</label>
									<div class="col-md-7">
										<select class="form-control input-sm" id="voyageCode"
											name="voyageCode" ng-model="swapAccount.voyageCode"
											ng-change="onVoyageChange(swapAccount.voyageCode);"
											ng-options="r.voyageCode as r.voyageCode for r in voyageList">
											<option value="" selected="selected">Select</option>
										</select>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="currencyCode" name="currencyCode" placeholder="INR"
											ng-model="swapAccount.currencyCode">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Exchange Rate</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											id="exRate" name="exRate" placeholder="45" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
											ng-model="swapAccount.exRate" />
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Swap Date</label>
									<div class="col-md-7 inputGroupContainer">
										<div class="input-group input-append date" id="swapDate">
				         					<input type="text" class="form-control " name="swapDate" id="swapDate" ng-model="swapAccount.swapDate" placeholder='dd/mm/yyyy' />
				         					<span class="input-group-addon add-on">
				         					 <span class="glyphicon glyphicon-calendar"></span>
				        					 </span>
				        					</div>
									</div>


								</div>
							</div>

							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Swap Date </label>
									<div class="col-md-7 inputGroupContainer">
										<input type="date" class="form-control input-sm"
											id="swapDate" name="swapDate"
											data-ng-model="swapAccount.swapDate">
									</div>
								</div>
							</div> -->
						</fieldset>
					</div>
				</div>

		<div class="" ng-repeat="(tIndex, swapRowDtlTbl) in swapAccount.jvSwapDetail">
		      <table class="table table-striped b-t b-light">
		        <thead>
		          <tr>
		            <th colspan=1 rowspan="2" class="width_1"></th>
		            <th colspan=1 rowspan="2" class="width_30 text-center">Swap Voyage</th>
		            <th colspan=1 rowspan="2" class="width_30 text-center">POL</th>
		            <th colspan=1 rowspan="2" class="width_30 text-center">POD</th>
		            <th colspan=1 rowspan="2" class="width_30 text-center">Slot_No</th>
		            <th colspan=1 rowspan="2" class="width_30 text-center">BL_No</th>
		            <th colspan=1 rowspan="2" class="width_25 text-center">Swap Vol</th>
		            <th colspan=1 rowspan="2" class="width_25 text-center">Swap WT</th>
		            <th colspan=4 rowspan="1" class="width_20 text-center">Actual Volume</th>
		            <th colspan=1 rowspan="2" class="width_25text-center">Total</th>
		            <th colspan=1 rowspan="2" class="width_25 text-center">Actual WT</th>
		            <th colspan=1 rowspan="2" class="width_25 text-center">Diff Vol</th>
		            <th colspan=1 rowspan="2" class="width_25 text-center">Diff WT</th>
		            <th colspan=1 rowspan="2" class="width_20 text-center">Laden</th>
		            <th colspan=1 rowspan="2" class="width_20 text-center">Empty</th>
		            <th colspan=1 rowspan="2" class="width_20 text-center">Amnt</th>

		          </tr>
		          <tr>
		            <th colspan=1 rowspan="2" class="width_20 text-center">D20</th>
		            <th colspan=1 rowspan="2" class="width_20 text-center">D40</th>
		            <th colspan=1 rowspan="2" class="width_20 text-center">M20</th>
		            <th colspan=1 rowspan="2" class="width_20 text-center">M40</th>

		          </tr>
		        </thead>
		        <tbody ng-repeat="(trIndex, row) in swapRowDtlTbl.DetailList">
		        <tr>
	  			 <td><label class="i-checks m-b-none"> <input id="swapSelect{{trIndex}}" type="checkbox" ng-model="row.swapSelect"><i></i></label></td>

              	<td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="swapVoyage{{trIndex}}" ng-model="row.swapVoyage" name="swapVoyage" data-ng-options="r.lswapVoyage as r.lswapVoyage for r in swapVoyageList">
		               <option value="">--Select--</option>
		              </select>
		              <input type="hidden" class="form-control input-sm padding-right-0 padding-left-3" id="swapDtlCode{{trIndex}}" ng-model="row.swapDtlCode"  name="swapDtlCode">
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="swapPol{{trIndex}}" ng-model="row.swapPol"
		            name="swapPol" data-ng-options="r.lswapPort as r.lswapPort for r in swapPortList" ng-change="checkPortValidation({{trIndex}},'swap',swapRowDtlTbl);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="swapPod{{trIndex}}"
		            ng-model="row.swapPod" name="swapPod" data-ng-options="r.lswapPort as r.lswapPort for r in swapPortList" ng-change="checkPortValidation({{trIndex}},'swap',swapRowDtlTbl);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="swapSlot{{trIndex}}" ng-model="row.swapSlot" name="swapSlot"
		            data-ng-options="r.lswapSlotCode as r.lswapSlotName for r in swapSlotList" ng-change="getVolumeAndWeight({{trIndex}},'swap',swapRowDtlTbl,swapAccount);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="swapBlno{{trIndex}}" ng-model="row.swapBlno" name="swapBlno"
		             data-ng-options="r.lswapBl as r.lswapBl for r in swapBlList" ng-change="getActualWeight({{trIndex}},'swap',swapRowDtlTbl,swapAccount);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="swapVolume{{trIndex}}" ng-model="row.swapVolume"  name="swapVolume">
		        </div>
		        </div>
		        </td>
		        <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" ng-model="row.swapWeight" id="swapWeight{{trIndex}}" name="swapWeight" >
		        </div>
		        </div>
		        </td>
		         <!-- <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm" id="swapActual{{trIndex}}" ng-model="row.swapActual"  name="swapActual">
		        </div>
		        </div>
		        </td> -->
		           <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="swapD20{{trIndex}}" ng-model="row.swapD20" name="swapD20">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3"  id="swapD40{{trIndex}}" ng-model="row.swapD40" name="swapD40">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="swapM20{{trIndex}}" ng-model="row.swapM20"  name="swapM20">
		        </div>
		        </div>
		        </td>
		               <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" ng-model="row.swapM40" id="swapM40{{trIndex}}" name="swapM40" >
		        </div>
		        </div>
		        </td>
               <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="swapTotal" id="swapTotal{{trIndex}}" ng-model="row.swapTotal" >
		        </div>
		        </div>
		        </td>
		        <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="swapActualWeight" id="swapActualWeight{{trIndex}}" ng-model="row.swapActualWeight" >
		        </div>
		        </div>
		        </td>
               <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="swapDifference" id="swapDifference{{trIndex}}" ng-model="row.swapDifference">
		        </div>
		        </div>
		        </td>
		        <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="swapDiffWeight" id="swapDiffWeight{{trIndex}}" ng-model="row.swapDiffWeight" >
		        </div>
		        </div>
		        </td>
		        <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="swapLaden{{trIndex}}" ng-model="row.swapLaden" name="swapLaden">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3"  id="swapEmpty{{trIndex}}" ng-model="row.swapEmpty" name="swapEmpty">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3 text-right" id="swapAmt{{trIndex}}" ng-model="row.swapAmt"  name="swapAmt" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount Should be 2 digit"  step="0.01" friendly-name="{{ 'Row' + $index + '(Amount)'}}">
		        </div>
		        </div>
		        </td>

		       </tr>

		        <!-- Swapped row values -->

	         <tr>
	  			 <td></td>
              	<td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            	<input style="display: none;" type="text" class="form-control input-sm padding-right-0 padding-left-3" id="ssfVoyage{{trIndex}}" ng-model="row.ssfVoyage"  name="ssfVoyage">
		            	<input type="hidden" class="form-control input-sm padding-right-0 padding-left-3" id="ssfDtlCode{{trIndex}}" ng-model="row.ssfDtlCode"  name="ssfDtlCode">
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="ssfPol{{trIndex}}" ng-model="row.ssfPol" name="ssfPol"
		            data-ng-options="r.lswapPort as r.lswapPort for r in swapPortList" ng-change="checkPortValidation({{trIndex}},'sfpl',swapRowDtlTbl);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="ssfPod{{trIndex}}" ng-model="row.ssfPod" name="ssfPod"
		            data-ng-options="r.lswapPort as r.lswapPort for r in swapPortList" ng-change="checkPortValidation({{trIndex}},'sfpl',swapRowDtlTbl);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="ssfSlot{{trIndex}}" ng-model="row.ssfSlot" name="ssfSlot"
		            data-ng-options="r.lswapSlotCode as r.lswapSlotName for r in swapSlotList" ng-change="getVolumeAndWeight({{trIndex}},'sfpl',swapRowDtlTbl,swapAccount);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td style=" text-align: center; ">
	              <div class="row">
		            <div class="col-xs-12">
		            <select class="form-control input-sm padding-right-0 padding-left-3" id="ssfBlno{{trIndex}}" ng-model="row.ssfBlno" name="ssfBlno"
		             data-ng-options="r.lswapBl as r.lswapBl for r in swapBlList" ng-change="getActualWeight({{trIndex}},'sfpl',swapRowDtlTbl,swapAccount);">
		               <option value="">--Select--</option>
		              </select>
			        </div>
			      </div>
		        </td>
		        <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="ssfVolume{{trIndex}}" ng-model="row.ssfVolume"  name="ssfVolume">
		        </div>
		        </div>
		        </td>
		        <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" ng-model="row.ssfWeight" id="ssfWeight{{trIndex}}" name="ssfWeight" >
		        </div>
		        </div>
		        </td>
		         <!-- <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm" id="ssfActual{{trIndex}}" ng-model="row.ssfActual"  name="ssfActual">
		        </div>
		        </div>
		        </td> -->
		           <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="ssfD20{{trIndex}}" ng-model="row.ssfD20" name="ssfD20">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3"  id="ssfD40{{trIndex}}" ng-model="row.ssfD40" name="ssfD40">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="ssfM20{{trIndex}}" ng-model="row.ssfM20"  name="ssfM20">
		        </div>
		        </div>
		        </td>
		               <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" ng-model="row.ssfM40" id="ssfM40{{trIndex}}" name="ssfM40" >
		        </div>
		        </div>
		        </td>
               <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="ssfTotal" id="ssfTotal{{trIndex}}" ng-model="row.ssfTotal" >
		        </div>
		        </div>
		        </td>
		        <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="ssfActualWeight" id="ssfActualWeight{{trIndex}}" ng-model="row.ssfActualWeight" >
		        </div>
		        </div>
		        </td>
               <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="ssfDifference" id="ssfDifference{{trIndex}}" ng-model="row.ssfDifference">
		        </div>
		        </div>
		        </td>
		        <td>
		              <div class="row">
		            <div class="col-xs-12">
		            <input type="text" class="form-control input-sm padding-right-0 padding-left-3" name="ssfDiffWeight" id="ssfDiffWeight{{trIndex}}" ng-model="row.ssfDiffWeight" >
		        </div>
		        </div>
		        </td>
		        <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3" id="ssfLaden{{trIndex}}" ng-model="row.ssfLaden" name="ssfLaden">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3"  id="ssfEmpty{{trIndex}}" ng-model="row.ssfEmpty" name="ssfEmpty">
		        </div>
		        </div>
		        </td>
		         <td> <div class="row">
		            <div class="col-xs-12">
		             <input type="text" class="form-control input-sm padding-right-0 padding-left-3 text-right" id="ssfAmt{{trIndex}}" ng-model="row.ssfAmt"  name="ssfAmt" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount Should be 2 digit"  step="0.01" friendly-name="{{ 'Row' + $index + '(Amount)'}}">
		        </div>
		        </div>
		        </td>

		       </tr>

		        </tbody>
		      </table>
				<div class="padding-right-5">
			           <button ng-click="addRow(swapRowDtlTbl)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
			            <i class="fa fa-plus"></i>
			           </button>
			           <button ng-click="removeRow(swapRowDtlTbl)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
			            <i class="fa  fa-trash-o"></i>
			           </button>
		      	<div>
		      </div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button" ng-if="!edit"
							ng-click="onSubmit(jvSwapAcctForm)">
							<i class="fa fa-save"></i> Save
						</button>
						<button class="btn btn-success" type="button" ng-if="edit"
							ng-click="onSubmit(jvSwapAcctForm)">
							<i class="fa fa-save"></i> Update
						</button>
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
