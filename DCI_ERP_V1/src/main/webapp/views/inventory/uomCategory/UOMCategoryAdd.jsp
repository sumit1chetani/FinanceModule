<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="UOMCategory">
        <div class="row">
        
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>

												<div class="form-group" ng-if="isEdit==true">
													<label class="col-md-6 control-label">UOM Category Code</label>
													<div class="col-md-3">
														<input type="text" class="form-control input-sm"
															name="uomcategoryId" ng-model="uomcategory.uomcategoryId" readonly>
													</div>
												</div>
													<div class="form-group">
													<label class="col-md-6 control-label">Category Name <span
														style="color: red;">*</span></label>
													<div class="col-md-3">
														<input type="text" class="form-control input-sm"
															name="uomcategoryName" validation="required"
															friendly-name="Category Name" 
															ng-blur="checkCategoryName(uomcategory.uomcategoryName)"
															ng-model="uomcategory.uomcategoryName">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-6 control-label">Category Description</label>
													<div class="col-md-3">
														<textarea id="reason" rows="3" cols="35"
															name="uomcategoryDesc" class="form-control input-sm"
															style="resize: none" ng-model="uomcategory.uomcategoryDesc">
														 </textarea>
													</div>
												</div>
												<!-- <div class="form-group">
													<label class="col-md-4 control-label">Active</label>
													<div class="col-md-1">
														<div class="checkbox">
															<label> <input class="checkbox style-0" 
																type="checkbox" name="Active" ng-model="uomcategory.status"> 
																<span></span></label>
														</div>
													</div>
												</div> -->
											</fieldset>
										</div>

								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button" ng-click="submit(UOMCategory,uomcategory)"
												ng-if="!isEdit==true">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button" ng-click="submit(UOMCategory,uomcategory)" 
												ng-if="isEdit==true">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-info ng-scope" type="button" ng-click="reset()">
												<i class="fa fa-undo"></i> Reset
											</button>
											<button class="btn btn-danger" type="button" ng-click="cancel()">
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