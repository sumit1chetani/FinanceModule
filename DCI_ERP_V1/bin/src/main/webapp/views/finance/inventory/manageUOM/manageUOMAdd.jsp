<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>
			  <div class="panel-body">
      <h2 ng-if="!isEdit">
       Add Unit of Measurement
      </h2>
       <h2 ng-if="isEdit">
       Edit Unit of Measurement
      </h2>
     </header>
     <br>
     <div role="content">
      <div class="widget-body">
          <form name="ManageUoMForm" class="form-horizontal" novalidate method="post">
        		<div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
         					<fieldset>
         						<div class="form-group">
						            <label class="col-md-6 control-label"> Unit of Measurement Name <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						             <input type="text" class="form-control input-sm"
						              id="uomName" name="Unit of Measurement" ng-model="manageUomData.uomName" ng-blur="checkUOMName(manageUomData.uomName)"
						               validation="required|max_len:25" friendly-name="Unit of Measure Name"/>
						            </div>
						        </div>
						        <div class="form-group">
						            <label class="col-md-6 control-label"> UOM Category <span style="color: red;">*</span></label>
						            <div class="col-md-6">
						             	<selectivity list="uomCategoryList" property="manageUomData.uomCategoryId"
										 	ng-model="manageUomData.uomCategoryId" id="uomCategoryId" name="uomCategoryId" form-name="ManageUoMForm"
										 	validation="required" friendly-name="Uom Category">
										 </selectivity>
						            </div>
						        </div>
						        <div class="form-group">
								   <label class="col-md-6 control-label">Description</label>
									<div class="col-md-6">						   												   						
									<textarea class="text-left form-control input-sm resize-none" rows="3" cols="25"
						              name="Description" validation="max_len:250" ng-model="manageUomData.uomDescription"  
						             friendly-name="Description"> </textarea>						   						
									</div>
								</div>
         					</fieldset>
         			</div>
        		</div>
        		<div class="form-actions">
         			<div class="row">
          				<div class="col-md-12">
           					<button class="btn btn-success" type="button"
            					data-ng-if="!isEdit" data-ng-click="validate(ManageUoMForm)">
            					<i class="fa fa-save"></i> Save
           					</button>
           					<button class="btn btn-success" type="button"
            					data-ng-if="isEdit == true" ng-click="validate(ManageUoMForm)">
            					<i class="fa fa-save"></i> Update
           					</button>
           					<button type="reset" class="btn btn-info" data-ng-if="!isEdit" ng-click="reset(ManageUoMForm)">
            					<i class="fa fa-undo"></i> Reset
           					</button>
           					<button class="btn btn-info" type="button" data-ng-if="isEdit"
					            data-ng-click="resetEdit(ManageUoMForm);">
					            <i class="fa fa-undo"></i> Reset
					        </button>
           					<button class="btn btn-danger" type="button"
            					ng-click="cancel()">
            					<i class="fa fa-close"></i> Cancel
           					</button>
          				</div>
         			</div>
        		</div>
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