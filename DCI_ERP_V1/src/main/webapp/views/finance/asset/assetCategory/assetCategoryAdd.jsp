
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
 	<div class="panel-body">   
       	<form class="form-horizontal" name="assetCategoryAddForm" novalidate method="post">
        	<div class="row">
         		<div class="col-sm-12 col-md-12 col-lg-12">
           			<fieldset>
          				<div class="col-md-6">
          					<div class="form-group">
					          	<label class="col-md-4 control-label">Category Name<span class="font-red"> *</span></label>
					           	<div class="col-md-7">
					           		<input type="text" class="form-control input-sm" 
					              			name="categoryName" id="categoryName" maxlength="40"
					               			data-ng-model="assetCategoryObj.assetCategoryName"
					               			validation="required" friendly-name="Category Name" >
					          	</div>
					        </div>
					        
          				</div>
						
	           			</fieldset>
	          		</div>         		
        	</div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success"
            ng-if="!isEdit" type="submit"
            ng-click="validate(assetCategoryAddForm,assetCategoryObj)">
            <i class="fa fa-save"></i>
           Save
           </button>
           <button class="btn btn-success"
            ng-if="isEdit" type="submit"
            ng-click="validate(assetCategoryAddForm,assetCategoryObj)">
            <i class="fa fa-save"></i>
            Update
           </button>
           <button class="btn btn-info ng-scope" type="submit"
            ng-click="reset(assetCategoryAddForm)" class="btn btn-success">
            <i class="fa fa-undo"></i>
            Reset
           </button>
           <button class="btn btn-danger" type="button"
            class="btn btn-success" ng-click="cancelAsset()">
            <i class="fa fa-close"></i>
            Cancel
           </button>
          </div>
         </div>
        </div>
       </form>     
  </div> <!-- /panel-body -->
 </div>
</div>