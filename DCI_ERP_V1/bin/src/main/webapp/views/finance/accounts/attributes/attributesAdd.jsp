<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="attributeForm">
						       <fieldset>
						        <div class="row">
						         <div class="col-sm-12 col-md-10 col-lg-10">
						          <div class="col-sm-3 col-md-3 col-lg-3"></div>
								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group">
									   <label class="col-md-4 control-label">Attribute Name<span style="color: red;">*</span> </label>
								       <div class="col-md-7 inputGroupContainer">
										  <input type="text" id="attributeName" name="attributeName" validation="required" friendly-name="Attribute Name" 
													ng-disabled = "isEdit"	ng-model ="attribute.attributeName" class="form-control input-sm" maxlength="30"> 
									   </div>
								   	</div>
									<div class="form-group">
										<label class="col-md-4 control-label"> Attribute Value
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<input type="text" id="attributeValue" name="attributeValue" validation="required" friendly-name="Attribute Value" 
																	ng-model ="attribute.attributeValue" class="form-control input-sm" maxlength="30"> 
										</div>
									</div>
								</div>
								 <div class="col-sm-3 col-md-3 col-lg-3"></div>
						         </div>
						        </div>
						         </fieldset>
						        <div class="form-actions">
						         <div class="row">
						          <div class="col-md-12">
						    			<button class="btn btn-success" type="submit" ng-click="save()"
											ng-if="!isEdit" class="btn btn-success">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="submit" ng-click="save()"
											ng-if="isEdit" type="submit">
											<i class="fa fa-save"></i> Update
										</button>
										<button class="btn btn-danger" type="reset"
											class="btn btn-success" ng-click="cancel()">
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