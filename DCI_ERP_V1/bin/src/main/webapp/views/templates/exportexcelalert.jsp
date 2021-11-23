<style>
.con-ele input {
	height: 30px;
}
.bookingDtlCls{
	 border-bottom: 2px solid #23b7e5 !important;
    border-top: 2px solid #23b7e5 !important;
   /*  border-left: 1px solid #23b7e5 !important;
    border-right: 1px solid #23b7e5 !important; */
}
tbody::before
{
  content: '';
  display: block;
  height: 15px;
 /*  border-left: 0px solid  !important;
   border-right: 1px solid #23b7e5 !important;
       width: 100%; */
}  

.ngdialog.ngdialog-theme-default .ngdialog-close {
    border-radius: 5px;
    cursor: pointer;
    position: absolute;
    right: 0;
    top: 0;
    /* margin-left: 18%; */
    margin-right: -20%;
}
   
</style>


<div class="padding-0" ng-controller="bookingAddPopupCtrl"  style="width: 142%;margin-left: -21%;">
 <div class="panel panel-default padding-0">
  <div class="panel-heading font-bold" align="center" style="color:white">TRUCK ALLOCATION TO BOOKING </div>
  <div class="panel-body">
  				   <marquee style="color: #FF4500;font-weight: 400;" onmouseover="this.stop();" onmouseout="this.start();"  scrolldelay="100" 
  ><span style="color :red">Note : Un Checked Containers will get UnAllocatted.</span></marquee>
  <div ><label class="control-label" align="center" style="padding: 3%;"><b>Booked Containers</b></label><input type="text" ng-model="bookingDtlList[count].quantity"style="border: 1px solid #DDD;border-radius: 7px;box-shadow: none;height: 37px;padding: 8px 12px 9px 12px;margin-left: 2%;" disabled="disabled"></div>
	<div class="table-responsive clear">
							<table class="table table-striped b-t b-light" >
								<thead>
									<tr>
									
										<th colspan=1 class="width_1"></th>
										<th colspan=1 class="width_10 text-center">Trip No</th>
										<th colspan=1 class="width_15 text-center">From Location<span
											style="color: red;">*</span></th>
										<th colspan=1 class="width_10 text-center">To Location<span
											style="color: red;">*</span></th>
<!-- 											<th colspan=1 class="width_15 text-center">Container No</th>
 -->				<th colspan=1 class="width_10 text-center">Total Capacity</th>
 							<th colspan=1 class="width_10 text-center">Available Capacity</th>
										<th colspan=1 class="width_20 text-center">Allotted Capacity</th>
<!-- 										<th colspan=1 class="width_6 text-center">Cont.Dtls</th>
 -->									</tr>
								</thead>
								<tbody ng-repeat="(trIndex, bookingDtl) in tripList" class="bookingDtlCls">
									<tr>
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="bookingDtl.select" ng-change="selected(bookingDtl.tripNo)"><i></i></label></td>
										<td class="text-center">{{bookingDtl.tripNo}}</td>
										<td class="text-center">
											<div class="radio radio-inline">
												<label class="i-checks"> {{bookingDtl.fromLocation}}
												</label>
											</div>
										</td>

										<td class="text-center">
													<div class="radio radio-inline">
												<label class="i-checks"> {{bookingDtl.toLocation}}
												</label>
											</div>
										</td>
									<!-- 				<td class="text-center">
													<selectivity id="commodityId{{bTrIndex}}"
															list="commodityList" property="bookingConDtl.commodityId" ng-disabled="true"
															ng-model="bookingConDtl.commodityId" name="commodityId"></selectivity>
										</td> -->
											<td class="text-center">
													<input type="text" class="form-control input-sm text-right"
														ng-model="bookingDtl.tempTotalCapacity" disabled="disabled">
										</td>
										<td class="text-center">
													<input type="text" class="form-control input-sm text-right"
														ng-model="bookingDtl.capacity" disabled="disabled">
										</td>
											<td class="text-center">
													<input type="text" class="form-control input-sm text-right"
														ng-model="bookingDtl.alloted" name="quantity{{trIndex}}" disabled="disabled" 
														validation="required|integer" form-name='bookingForm' maxlength="3"
														friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}">
										</td>
									

									</tr>
									<tr  class="con-ele">
										<td colspan="10">
											<table class="table table-striped b-t b-light" width="500">
												<tr>
												<th class="width_1 text-center subTable-brs"></th>
												<th class="width_2 text-center subTable-brs">Con.S.No</th>
													<th class="width_10 text-center subTable-brs">Container
														No</th>
													<th class="width_10 text-center subTable-brs">Seal No</th>
													<th class="width_10 text-center subTable-brs">Gross Wt</th>
													<th class="width_10 text-center subTable-brs">Net Wt</th>
													<th class="width_10 text-center subTable-brs">Commodity</th>
													<th class="width_10 text-center subTable-brs">Package
														Type</th>
													<th class="width_10 text-center subTable-brs">No.of
														packages</th>
													<th class="width_10 text-center subTable-brs">Is Haz</th>
													<th class="width_10 text-center subTable-brs">UN Name</th>
													<th class="width_10 text-center subTable-brs">UN Class</th>
												</tr>
												<tr
													ng-repeat="(bTrIndex, bookingConDtl) in bookingDtl.bookingConCargoDtlList track by bTrIndex">
															<td class="subTable-brs text-center"><label class="i-checks m-b-none"> <input name="select{{trIndex}}-{{bTrIndex}}" id="check" 
												type="checkbox" ng-model="bookingConDtl.select" ng-change="checked(bookingDtl.bookingConCargoDtlList,bTrIndex,bookingDtlList,trIndex,tripList)" ng-disabled="bookingConDtl.disabled"><i></i></label></td>
													<td class="subTable-brs text-center">{{bTrIndex+1}}</td>
													<td class="subTable-brs">{{bookingConDtl.containerNo}}</td>
													<td class="subTable-brs">{{bookingConDtl.sealNo}}</td>
													<td class="subTable-brs">{{bookingConDtl.grossWt}}</td>
													<td class="subTable-brs">{{bookingConDtl.netWt}}</td>
													<td class="subTable-brs" ng-init="bookingConDtl.commodityId = bookingConDtl.commodityId + ''"><selectivity id="commodityId{{bTrIndex}}"
															list="commodityList" property="bookingConDtl.commodityId" disabled="true"
															ng-model="bookingConDtl.commodityId" name="commodityId"></selectivity></td>
													<td class="subTable-brs" ng-init="bookingConDtl.packageType = bookingConDtl.packageType + ''"><selectivity id="packageType{{bTrIndex}}"
															list="packageTypeList" property="bookingConDtl.packageType" disabled="true"
															ng-model="bookingConDtl.packageType" name="packageType"></selectivity></td>
													<td class="subTable-brs"><input type="text" disabled="disabled"
														class="form-control input-sm text-right"
														ng-model="bookingConDtl.noOfPackages" name="noOfPackages{{trIndex}}-{{bTrIndex}}"
														validation="integer" form-name='bookingForm' 
														friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (No.of packages)'}}"
														></td>
													<td class="subTable-brs text-center"><label class="i-checks">
															<input type="checkbox" id="isActive" disabled="disabled"
															class="checkbox style-0" name="isHaz{{bTrIndex}}"
															ng-model="bookingConDtl.isHaz" /> <i></i>
													</label>
														</div></td>
													<td class="subTable-brs">{{bookingConDtl.unName}}</td>
													<td class="subTable-brs">{{bookingConDtl.unClass}}</td>
												</tr>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
			<!-- 				<div class="padding-right-5">
								<div class="col-md-4">
									<button ng-click="addBookingDtl()" class="btn btn-sm btn-info"
										tooltip="Add Row" type="button">
										<i class="fa fa-plus"></i>
									</button>
									<button
										ng-click="deleteBookingDtl()"
										class="btn btn-sm btn-danger" type="button" tooltip="Delete">
										<i class="fa  fa-trash-o"></i>
									</button>
								</div>
							</div> -->
						</div>   <div class="form-actions">
    <div class="row">
     <div class="col-md-12">
      <button ng-if="!CarEdit" ng-model="add" class="btn btn-success" type="submit" class="btn btn-success" ng-click="save(tripList,bookingDtl)">
       <i class="fa fa-check"></i>
       Save
      </button>
      
      <button ng-if="CarEdit" ng-model="Update" class="btn btn-success" type="submit" class="btn btn-success" ng-click="update(tripList,bookingDtl)">
       <i class="fa fa-check"></i>
       Update
      </button>
      
    <!--    <button class="btn btn-info" type="reset" class="btn btn-info" ng-click="resetToDefault()">
       <i class="fa fa-reply"></i>
       Reset
      </button> -->
      
      <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="closeThisDialog('button')">
       <i class="fa fa-close"></i>
       Cancel
      </button>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>