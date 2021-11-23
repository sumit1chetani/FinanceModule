<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -100px;
}
#desc
{
height:75px;
}
</style>
<!-- #MAIN CONTENT -->
<div>
<!-- widget grid -->
 <section data-widget-grid id="widget-grid">
   <div class="row">
	 <article class="col-sm-12">
		<div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
		  <header class="ngdialog-header">
			<span class="widget-icon"> <i class="fa fa-table"></i></span>
		    <h2>Add Item</h2>
		  </header>
		  <div role="content">
		   <div class="widget-body">
			 <form class="form-horizontal" name="permissionrequestForm" novalidate>
				<div class="row">
				 <div class="col-sm-10 col-md-5">
					<fieldset>
					  					                  
					  <div class="form-group">
						<label class="col-md-6 control-label">Item Code</label>
						<div class="col-md-6">
						<select class="form-control input-sm"  ng-model="AdminUserData.company" name="Hospital Name" id="itemcode"
						ng-change="itemchange()" ng-options="" data-validator="required" data-valid-method="submit" data-message-id="Hospital Id" >
						<option value="">Select</option>
						<option value="i001">I001</option>
						<option value="i002">I002</option>
						</select>
						</div>
					</div>
					
					<div class="form-group"  >
					<label class="col-md-6 control-label">Item Name</label>
					<div class="col-md-6">
					<input type="text" class="form-control input-sm" name="AssetCode" ng-model="" id="itemname" readonly>
					</div>
					</div>
					
					
					
					 <div class="form-group">
						<label class="col-md-6 control-label">Description </label>
							<div class="col-md-6">
								<textarea ng-model="PermissionRequestData.reason" name="Reason" class="custom-scroll width_100" style="resize: none" 
								data-validator="required" data-valid-method="submit" data-message-id="desc" id="desc" readonly></textarea>
							</div>
					 </div>
					
								
					</fieldset>
				  </div>
				   <div class="col-sm-10 col-md-5">
				   <fieldset>
				   
				   <div class="form-group" >
					<label class="col-md-6 control-label">Category</label>
					<div class="col-md-6">
					<input type="text" class="form-control input-sm" name="AssetCode" ng-model="" id="category" readonly>
					</div>
					</div>
					
					<!-- <div class="form-group" id="personname" >
					<label class="col-md-6 control-label">Unit Of Measurement</label>
					<div class="col-md-6">
					<input type="text" class="form-control input-sm" name="AssetCode" ng-model="PermissionRequestData.unit" >
					</div>
					</div> -->
					
					<div class="form-group">
					<label class="col-md-6 control-label"> Unit Of Measurement </label>
					<div class="col-md-6">
					<!-- <select class="form-control input-sm"  ng-model="AdminUserData.companyid" name="Hospital Name"  id="unit"
					 ng-change="transportationonchange()"
					data-validator="required" data-valid-method="submit" data-message-id="Company Id" >					
					</select> -->
					<input type="text" class="form-control input-sm" name="AssetCode" ng-model="PermissionRequestData.unit" id="unit" readonly>
					</div>
					</div>
					
					
					<div class="form-group" id="personname" >
					<label class="col-md-6 control-label">Quantity</label>
					<div class="col-md-6">
					<input type="text" class="form-control input-sm" name="AssetCode" ng-model="PermissionRequestData.quantity" >
					</div>
					</div>
					 
				   </fieldset>
				   </div>
			    </div>			    
				<div class="form-actions">
					<div class="row">
						<div class="col-sm-12">
							<button class="btn btn-success" type="submit" data-ng-click="save(permissionrequestForm)" ng-if="!PermissionRequestData.edit" >
								<i class="fa fa-save"></i>Save
							</button>
							<button class="btn btn-success" type="button" data-ng-click="update(permissionrequestForm);" ng-if="PermissionRequestData.edit" >
								<i class="fa fa-save"></i>Update
							</button>
							<button class="btn btn-info"    type="button" data-ng-click="reset()">
								<i class="fa fa-undo"></i>Reset
							</button>
							<button class="btn btn-danger"  type="button" data-ng-click="cancel();">
								<i class="fa fa-close"></i>Cancel
							</button>
						</div>									
				    </div>
				</div>
			  </form>
			</div><!-- end widget content -->
		   </div><!-- end widget div -->
		 </div><!-- end widget -->
	 </article><!-- WIDGET END -->
   </div>
  </section>
</div>