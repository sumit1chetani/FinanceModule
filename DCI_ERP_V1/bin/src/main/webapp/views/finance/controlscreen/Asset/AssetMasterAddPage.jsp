<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
 <div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>
	
		<!-- <div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-0">
				<li><a>Finance</a></li>
				<li><a x-ui-sref="app.finance.controlscreen">Control Screen</a></li>
				<li><a x-ui-sref="app.finance.controlscreen.assetmaster">Asset Master</a></li>
				<li><a>Add</a></li>
			</ol> -->
   
		</div>
  
		<div class="panel-body">
			<form class="form-horizontal" name="AssetMasterForm" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Asset Code <span style="color: red;">*</span></label>
								<label class="col-md-1 control-label" ng-if="AssetMasterData.edit">{{AssetMasterData.assetcode}}</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="AssetCode" ng-model="AssetMasterData.assetcode" 
									ng-blur="Duplicate(AssetMasterForm.assetcode)" typeahead-min-length='1' ng-if="!AssetMasterData.edit"
									typeahead="r.assetcode for r in assetnameList | filter:$viewValue | limitTo:10" validator="required" 
									valid-method="submit" message-id="assetcode" id="assetcode" id="AssetCode"> -->
									
									<input type="text" class="form-control input-sm" id="assetcode" name="assetcode"  
									ng-model="AssetMasterData.assetcode" 
									validation="required" friendly-name="Asset Code" form-name="AssetMasterForm"
									typeahead="ac.assetcode as ac.assetcode for ac in assetTypeHeadList| filter:$viewValue |limitTo:10"  
									typeahead-min-length='1' typeahead-input-formatter="fetchSelectedAssetCode($model,AssetMasterData)"/>
								</div>
							</div>          
							<div class="form-group">
								<label class="col-md-4 control-label">Asset Name<span style="color: red;">*</span></label>
								<label class="col-md-1 control-label" ng-if="AssetMasterData.edit">{{AssetMasterData.assetname}}</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="AssetName" ng-model="AssetMasterData.assetname"
									ng-if="!AssetMasterData.edit" validator="required" valid-method="submit" message-id="assetname" id="assetname"
									typeahead-min-length='1' typeahead="r.assetname for r in assetnameList | filter:$viewValue | limitTo:10"> -->
									
									<input type="text" class="form-control input-sm" id="txtAssetName" name="Asset Name"  
									ng-model="AssetMasterData.assetname" 
									validation="required" friendly-name="Asset Name" form-name="AssetMasterForm"
									typeahead="ac.assetname as ac.assetname for ac in assetTypeHeadList| filter:$viewValue |limitTo:10"  
									typeahead-min-length='1' typeahead-input-formatter="fetchSelectedAssetName($model,AssetMasterData)"/>
								</div>
							</div>	                               		 			
           					<div class="form-group">
       							<label class="col-md-4 control-label">Location<span style="color: red;">*</span></label>
		      				    <div class="col-md-5 inputGroupContainer">
                <selectivity list="locationList" id="location" name ="location"
           property="AssetMasterData.location" ng-model="AssetMasterData.location"
           validation="required" 
           friendly-name="Location" form-name="AssetMasterForm"></selectivity>
									
								</div>
							</div>  
						 	<div class="form-group">
								<label class="col-md-4 control-label">Purchase Date<span style="color: red;">*</span></label>							
	              				<div class="col-md-5">
			              			<div class='input-group date datetimepick' >
					                    <input type="text" class="form-control" ng-model="AssetMasterData.purchasedate" placeholder="dd/mm/yyyy" id="purchasedate" ng-blur="purchasedate()"
					                    value="{{AssetMasterData.purchasedate}}" name="purchasedate" validation="required" 
           friendly-name="Purchase Date" valid-method="submit" message-id="purcdate"/>
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                        </div>
	                            </div>
							</div>								 	                 
							<div class="form-group">
								<label class="col-md-4 control-label">Purchase Value<span style="color: red;">*</span></label>	
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="purchasevalue"  ng-model="AssetMasterData.purchasevalue"
									validation="required||numeric" 
           friendly-name="Purchase Value" valid-method="submit" message-id="purchasevalue" id="purchasevalue"
                                    style="text-align:right;">
								</div>
							</div>          
						</fieldset>
					</div>    
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>     
							<div class="form-group">
       							<label class="col-md-4 control-label">Supplier Name </label>
		      				    <div class="col-md-5 inputGroupContainer">
                <selectivity list="supplierList" id="supplier_id" name ="supplier_id"
           property="AssetMasterData.vendorcode" ng-model="AssetMasterData.vendorcode"
           validation="required" 
           friendly-name="Supplier Name" form-name="AssetMasterForm"></selectivity>
									
								</div>
							</div>   
							<div class="form-group"  >
								<label class="col-md-4 control-label">Depreciation Type <span style="color: red;">*</span></label>
								<div class="col-md-5">
									<div class="radio">
										<label class="i-checks">
											<input type="radio" class="radiobox style-0" ng-model="AssetMasterData.depreciationtype" value="PERCENTAGE" id="depreciationtype" name="depreciationtype" validation="required" 
           friendly-name="Depreciation Type" ng-click="viewDepreciationType()"
											checked="checked" ><i></i>Percentage
										</label>
										<label class="i-checks">
											<input type="radio" class="radiobox style-0" ng-model="AssetMasterData.depreciationtype" value="VALUE" id="depreciationtype" name="depreciationtype" validation="required" 
           friendly-name="Depreciation Type" ng-click="viewDepreciationType1()"
											checked="checked" ><i></i>Value
										</label>          
									</div>
								</div >        
							</div>        
							<div class="form-group" style="display: none;">
								<label class="col-md-4 control-label">Depreciation Type <span style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Depreciation Type"  ng-model="AssetMasterData.depreciationtype"
									validator="required" valid-method="submit" message-id="depreciationtype" id="depreciationtype">
								</div>
							</div>   	
							<div class="form-group" name="Percentage" id="Percentage" style="display: none;">
								<label class="col-md-4 control-label">Percentage <span style="color: red;">*</span></label>
								<div class="col-md-5" >
									<input type="text" class="form-control input-sm" name="Percentage"  ng-model="AssetMasterData.value"
                                     style="text-align:right;">         
								</div>
							</div> 
							<div class="form-group" id="Value" style="display: none;">
								<label class="col-md-4 control-label">Value<span style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Percentage"   ng-model="AssetMasterData.value" 
                                    style="text-align:right;">          
								</div>
							</div>      
							<div class="form-group" style="display: none;">
								<label class="col-md-4 control-label">Percentage or Value<span style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Percentage or Value"  ng-model="AssetMasterData.value" ng-if="AssetMasterData.depreciationtype!=''"
									validator="required,numbersonly" valid-method="submit" message-id="percentage or value" id="percentage or value">
								</div>
							</div>       							
							<div class="form-group" id="Percentage1"  ng-if="AssetMasterData.edit " ng-show="AssetMasterData.depreciationtype=='PERCENTAGE'">
								<label class="col-md-4 control-label">Percentage <span style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Percentage"  ng-model="AssetMasterData.value"
                                    style="text-align:right;" >         
								</div>
							</div>       
							<div class="form-group" id="Value1"  ng-if="AssetMasterData.edit " ng-show="AssetMasterData.depreciationtype=='VALUE'">
								<label class="col-md-4 control-label">Value <span style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Value"   ng-model="AssetMasterData.value" style="text-align:right;">
								</div>
							</div>                
							<div class="form-group">
       							<label class="col-md-4 control-label">Account Head Allocation</label>
		      				    <div class="col-md-5 inputGroupContainer">
                
									<selectivity  list="accountheadList" property="AssetMasterData.acctheadcode" ng-model="AssetMasterData.acctheadcode" id="acctheadcode"></selectivity>	
								</div>
							</div>         	 
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Description</label>
								<div class="col-md-5">
									<textarea ng-model="AssetMasterData.description" name="Description" class="custom-scroll width_100" rows="2" 
									validator="required" valid-method="submit" message-id="description" id="description"></textarea>
								</div>
							</div>                       
						</fieldset>
					</div>
				</div>
				<br>   
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">      
							<button ng-model="add" class="btn btn-success" type="submit" ng-if="!AssetMasterData.edit" ng-click="save(AssetMasterForm)">
								<i class="fa fa-save"></i>Save
							</button>
						<!-- 	<button class="btn btn-primary"  ng-if="!AssetMasterData.edit" type="button"  ng-click="reset()">
								<i class="fa fa-reply"></i>Reset
							</button> -->       
							<button class="btn btn-success" ng-if="AssetMasterData.edit"  type="submit" ng-click="save(AssetMasterForm)"> <!-- ng-disabled="AssetMasterForm.$error.required -->
								<i class="fa fa-save"></i>Update
							</button>    
							<!-- <button class="btn btn-primary"  ng-if="AssetMasterData.edit" type="button"  ng-click="reset()">
								<i class="fa fa-reply"></i>Reset
							</button>  -->      
							<button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i>Cancel
							</button>      
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
      
