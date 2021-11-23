<div class="breadcrumb-wrapper ng-scope">
<div class="panel panel-default panel-default-form"> 
	<div class="panel panel-default panel-default-form">
	<%@include file="/views/templates/panel-header-form.jsp"%>
		<!-- <div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-0">
				<li><a>Master</a></li>
				<li><a x-ui-sref="app.finance.controlscreen">Control Screen</a>
				</li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroupaccount">Sub Group</a></li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroup-add">Add</a>
				</li>
			</ol> -->
		</div>		
		<div class="panel-body">
			<form class="form-horizontal" name="subGroupAcctForm" novalidate method="POST">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-4 col-md-4 col-lg-4">								
							<div class="form-group" ng-if="subGroupData.edit">
								<label class="col-md-5 control-label">Group code<span style="color: red;"></span></label>
								<!-- <div class="col-md-7 inputGroupContainer"> --> 
								<label class="col-md-1 control-label" ng-if="subGroupData.edit">{{subGroupData.subGroupCode}}</label>
								
							</div>
							<div class="form-group">
     						   <label class="col-md-5 control-label">Category <span style="color: red;">*</span></label>
						       <div class="col-md-7 inputGroupContainer">
								 <selectivity list="grpHeadTypeList" property="subGroupData.grpHeadCode" id="grpHeadCode_id"
								validation="required"
								name ="grpHeadCode_id"
								ng-model ="subGroupData.grpHeadCode"
								friendly-name="Category" 
								form-name="subGroupAcctForm"></selectivity>
							   </div>
						   	</div>
						  <!-- Removed as per sedhu/Abbas discussion -->
						  <!-- 	<div class="form-group">
								<label class="col-md-5 control-label"> Type</label>
								<div class="col-md-7">
									<select class="form-control input-sm" name="sgType" ng-model="subGroupData.sgType" 
									id="sgType"
									validation="required"
									friendly-name="Type" >
						              <option value="">Select</option>
						              <option value="B">Business Associate</option>
						              <option value="G">General</option>
						              <option value="V">Vessel Related</option>
						              <option value="Q">Vessel Quantity Related</option>
						              <option value="E">Employee Related</option>
						            </select>
								</div>
							</div>	 -->
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> Group Name
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<!-- <input type="text" class="form-control input-sm"
									name="subGroupName"
									id="subGroupName"
									validation="required"
									friendly-name="Sub Group Account" 
									ng-model="subGroupData.subGroupName" ng-keyup="changeToUpperCase(subGroupData.subGroupName)" > -->
									
									<input type="text" class="form-control input-sm" id="subGroupName" name="Sub Group Account"  
									ng-model="subGroupData.subGroupName" 
									validation="required" friendly-name="Group Name" form-name="subGroupAcctForm"
									typeahead="ac.subGroupName as ac.subGroupName for ac in subGroupAcctList| filter:$viewValue |limitTo:10 | concatSubGrpName: $viewValue"  
									typeahead-min-length='1' typeahead-input-formatter="fetchSelectedSubGrpAccountName($model,subGroupData)"/>
								</div>
							</div>						
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> Group Desc <span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<textarea rows="2" cols="30" name="Description" 
									ng-model="subGroupData.subGroupDesc" 
									id="description"
									validation="required"
									friendly-name="Description" ></textarea>
								</div>
							</div>															
						</div>
					</div>
					
					 <div class="col-sm-12">
	      				<label class="col-md-2 control-label">Attributes :</label>
	     			</div>
	    			 <div class="col-sm-12" ><br>
					     <div class="col-sm-2">
					     
					     </div>
					     <div class="col-sm-9" id="checkboxDiv">
					     <div class="form-group" >
	        					<div class="form-group">
				                <label id="checkboxLabel" ng-repeat="obj in attributeList" class="col-sm-3">
							 	 <input type="checkbox"  checklist-model="subGroupData.lAttributes"   checklist-value="obj.attributeName"> {{obj.attributeName}}
							    </label><br>
					    	</div>
       						</div> 
					     </div>
					</div>
				</div> <!-- /book-widget-row -->
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-click="submit(subGroupAcctForm,subGroupData)"
								ng-if="!subGroupData.edit" class="btn btn-success">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button" ng-click="submit(subGroupAcctForm,subGroupData)"
								ng-if="subGroupData.edit" type="submit">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" type="button"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div> <!-- /panel-body -->			
	</div>  <!-- /panel-default -->
</div> <!-- /wrapper-md -->
