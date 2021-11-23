
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="ContainerType" method="post" class="form-horizontal"
			novalidate>
			<div class="panel-body">
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Container Type<span style="color: red;">*</span></label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.containertype"
									data-ng-model="containerAddEditData.containertype"
									name="containerType" validation="required"
									friendly-name="containerType" ng-disabled="isEdit"/>
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Length (Size)<span style="color:red;">*</span></label>
							<div class="col-md-7">
							   <selectivity list="sizeList" property="containerAddEditData.length" id="length" ng-model="containerAddEditData.length"
               name="length" form-name="blForm" validation="required" 
                friendly-name="length"></selectivity>  
								 <!-- input type="text" class=" form-control input-sm"
									property="containerAddEditData.length"
									data-ng-model="containerAddEditData.length"
									name="length" 
									friendly-name="length" /> -->
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Height</label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.height"
									data-ng-model="containerAddEditData.height"
									name="height" 
									friendly-name="height" />
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Container Kind</label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.containerkind"
									data-ng-model="containerAddEditData.containerkind"
									name="containerKind" 
									friendly-name="containerKind" />
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Tare Weight</label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.tareweight"
									data-ng-model="containerAddEditData.tareweight"
									name="tareWeight" 
									friendly-name="tareWeight" />
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Material</label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.material"
									data-ng-model="containerAddEditData.material"
									name="material" 
									friendly-name="material" />
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Max Capacity</label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.maxcapacity"
									data-ng-model="containerAddEditData.maxcapacity"
									name="maxcapacity" 
									friendly-name="maxcapacity" />
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Specification</label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.specification"
									data-ng-model="containerAddEditData.specification"
									name="specification" 
									friendly-name="specification" />
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">TEU Factor</label>
							<div class="col-md-7">
								<input type="number" class=" form-control input-sm"
									property="containerAddEditData.teufactor"
									data-ng-model="containerAddEditData.teufactor"
									name="factor" 
									friendly-name="factor" />
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">ISO Code<span style="color: red;">*</span></label>
							<div class="col-md-7">
								<input type="text" class=" form-control input-sm"
									property="containerAddEditData.isocode"
									data-ng-model="containerAddEditData.isocode"
									name="isocode" 
									friendly-name="isocode" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
					<div class="form-group">
					<label class="col-md-5 control-label">Container Category</label>
					<div class="col-md-7">
					<selectivity list="containerCategory"
										property="containerAddEditData.containerCategory" id="containerCategory"
										ng-model="containerAddEditData.containerCategory" name="containerCategory"
										 friendly-name="containerCategory"
										form-name="ContainerType"></selectivity>
								</div>	</div></div>
								
								<div class="col-md-4">
								<div class="form-group">
								<label class="col-md-5 control-label"> Active</label>
								<div class="col-md-7">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="isactive" class="checkbox style-0" name="isactive"
											ng-model="containerAddEditData.isactive" /> <i></i>
										</label>
									</div>
								</div>
							</div>
							</div>

				</div>
				
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="save()">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit"
								ng-click="update()">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()"
								ng-if="!isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-info" ng-click="reset()" ng-if="isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>

						</div>
					</div>
				</div>

			</div>


		</form>
	</div>
</div>
