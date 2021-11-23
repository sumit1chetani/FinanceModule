<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       <form class="form-horizontal" name="manageStoresAddForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         	
         		<fieldset>
         		<div class="col-md-6">
         			<div class="form-group">
		             <label class="col-md-4 control-label">Store Name<span style= "color:red";> *</span></label>
		             <div class="col-md-7">
		              <input type="text" class="form-control input-sm"
		               name="manageName" id="manageName"
		               data-ng-model="manageStoresObj.manageName" 
		               validation="required" friendly-name="Store Name" ng-blur="checkStoreName(manageStoresObj.manageName)">
		             </div>
		            </div>
         		
         			<div class="form-group">
			             <label class="col-md-4 control-label">Store Type<span style= "color:red";>*</span></label>
			             <div class="col-md-7">
			              <select class="form-control"
			               name="lid" id="lid"
			               data-ng-model="manageStoresObj.lid" validation="required" friendly-name="Store Type"
			               ng-options="msto.lid as msto.locationType for msto in locationTypeList">
			               <option value="">Select</option>
			              </select>
			             </div>
		        </div>
         
         		<div class="form-group" >
	             <label class="col-md-4 control-label"> Store Parent Location
	             </label>
	             <div class="col-md-7">
	             <select class="form-control"
	               		name="pid" id="pid"
	              		data-ng-model="manageStoresObj.pid" ng-options="mst.id as mst.text for mst in parentLocationList">
	               		<option value="">Select</option>
	              </select>
	             </div>
	            </div>
        
         
         			<div class="form-group">
		             <label class="col-md-4 control-label">Store InCharge<span style= "color:red";>*</span> </label>
		             <div class="col-md-7">
		              	<select class="form-control"
		               		name="empId" id="empId"
		               		data-ng-model="manageStoresObj.empId"
		               		validation="required" friendly-name="Store InCharge"
		               		ng-options="msto.empId as msto.locationIncharge for msto in inChargeList">
		               	<option value="">Select</option>
		              </select>
		             </div>
		            </div>
		            
		            <div class="form-group">
		             <label class="col-md-4 control-label"> Is Active
		             </label>
		             <div class="col-md-7">
		              <div class="checkbox">
		               <label> <input type="checkbox" class="checkbox style-0"
		                data-ng-model="manageStoresObj.isActive" data-ng-true-value="'t'"
		                data-ng-false-value="'N'"> <span></span>
		               </label>
		              </div>
		             </div>
		            </div>
         			<div class="form-group">
		             <label class="col-md-4 control-label">Scrap Location
		              </label>
		             <div class="col-md-7">
		              <div class="checkbox">
		               <label> <input type="checkbox" class="checkbox style-0"
		                data-ng-model="manageStoresObj.scrapLocation" data-ng-true-value="'t'"
		                data-ng-false-value="'N'"> <span></span>
		               </label>
		              </div>
		             </div>
		            </div>
         		</div>
         		
         	<div class="col-md-6">
         	<div class="form-group">
		             <label class="col-md-4 control-label">Store Activity </label>
		             <div class="col-md-7">
		              <textarea type="text" class="form-control input-sm" rows="2" cols="25"
		               name="Store Activity"
		               ng-model="manageStoresObj.locationActivity" style="resize: none"></textarea>
		             </div>
		            </div>
         			<div class="form-group">
	             <label class="col-md-4 control-label">Use Parent Address</label>
	             <div class="col-md-7">
	              <div class="checkbox">
	               <label> 
	                    <input type="checkbox" class="checkbox style-0"
	                        data-ng-model="manageStoresObj.isParentAddress" data-ng-true-value="'t'" ng-click="getParentAddress(manageStoresObj.isParentAddress,manageStoresObj.pid)"
	                        data-ng-false-value="'N'"> <span></span>
	               </label>
	              </div>
	             </div>
	            </div>
         			<div class="form-group" id="parentAddress">
												<label class="col-md-4 control-label">Store Address<span style="color:red";>*</span></label>
												<div class="col-md-7">
													<div class="col-md-12 no-padding">
														<textarea class="text-left form-control input-sm" rows="2" cols="15" validation="required" friendly-name="Store Address"
		                 data-ng-model="manageStoresObj.address" id="address" name="address" style="resize: none"> 
		                </textarea>
													</div>
													<div class="col-md-12 no-padding">
														<div class="col-md-5 no-padding padding-top-5">
															<select class="form-control" data-ng-model="manageStoresObj.cityId" placeholder="city" validation="required" friendly-name="City"
		                ng-options="msto.cityId as msto.city for msto in cityList" ng-change="country(manageStoresObj.cityId)" id="cityId" name="cityId">
		                <option value="" disabled selected>City</option>
		                </select>
														</div>
														<div
															class="col-md-4 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm" placeholder="State"
		                 ng-model="manageStoresObj.state" readonly>
														</div>
														<div
															class="col-md-3 no-padding padding-left-5 padding-top-5">
															 <input type="text" class="form-control input-sm" placeholder="zip"
		                 ng-model="manageStoresObj.zipCode" readonly>
														</div>
													</div>
													<div class="col-md-12 no-padding padding-top-5">
														<input type="text" class="form-control input-sm" placeholder="country"
		                 ng-model="manageStoresObj.country" readonly>
													</div>
												</div>
											</div>
											
         			<div class="form-group" id="parentAddressReadonly">
												<label class="col-md-4 control-label">Store Address<span style="color:red";>*</span></label>
												<div class="col-md-7">
													<div class="col-md-12 no-padding">
														<textarea class="text-left form-control input-sm" rows="2" cols="15"
		                 data-ng-model="manageStoresObj.address" style="resize: none" readonly> 
		                </textarea>
													</div>
													<div class="col-md-12 no-padding">
														<div class="col-md-5 no-padding padding-top-5">
															<input type="text" class="form-control" ng-model="manageStoresObj.city" readonly>
														</div>
														<div
															class="col-md-4 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm" 
		                 ng-model="manageStoresObj.state" readonly>
														</div>
														<div
															class="col-md-3 no-padding padding-left-5 padding-top-5">
															 <input type="text" class="form-control input-sm" 
		                 ng-model="manageStoresObj.zipCode" readonly>
														</div>
													</div>
													<div class="col-md-12 no-padding padding-top-5">
														<input type="text" class="form-control input-sm" 
		                 ng-model="manageStoresObj.country" readonly>
													</div>
												</div>
											</div>
         			
         			
         		</div>
         		</fieldset>
         		</div>
         		</div>
         	
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" data-ng-if="!isEdit" type="submit"
            ng-click="validate(manageStoresAddForm,manageStoresObj)">
            <i class="fa fa-save"></i>Save
           </button>
           <button class="btn btn-success" data-ng-if="isEdit==true" type="submit"
            ng-click="validate(manageStoresAddForm,manageStoresObj)">
            <i class="fa fa-save"></i>
Update           </button>
           <button class="btn btn-info ng-scope" type="submit" ng-click="reset(manageStoresAddForm)"
            class="btn btn-success">
            <i class="fa fa-undo"></i>Reset
           </button>
           <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
            <i class="fa fa-close"></i>
Cancel           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
    </div>
   </article>
  </div>
 </section>
</div>