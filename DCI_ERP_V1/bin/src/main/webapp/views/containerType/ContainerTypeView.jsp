
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
							<label class="col-md-5 control-label">Container Type</label>
							<div class="col-md-7">
								<label class="col-md-1 control-label">{{containerAddEditData.containertype}}</label>
							<!-- 	<input type="text" class=" form-control input-sm"
									property="containerAddEditData.containertype"
									data-ng-model="containerAddEditData.containertype"
									name="containerType" validation="required"
									friendly-name="containerType" disabled="true"/> -->
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Length</label>
							<div class="col-md-7">
							<label class="col-md-1 control-label">{{containerAddEditData.length}}</label>
							<!-- 	<input type="text" class=" form-control input-sm"
									property="containerAddEditData.length"
									data-ng-model="containerAddEditData.length"
									name="length" 
									friendly-name="length" disabled="true"/> -->
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Height</label>
							<div class="col-md-7">
							<label class="col-md-1 control-label">{{containerAddEditData.height}}</label>
							<!-- 	<input type="text" class=" form-control input-sm"
									property="containerAddEditData.height"
									data-ng-model="containerAddEditData.height"
									name="height" 
									friendly-name="height" disabled="true"/> -->
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Container Kind</label>
							<div class="col-md-7">
								<label class="col-md-1 control-label">{{containerAddEditData.containerkind}}</label>
							<!-- 	<input type="text" class=" form-control input-sm"
									property="containerAddEditData.containerkind"
									data-ng-model="containerAddEditData.containerkind"
									name="containerKind" 
									friendly-name="containerKind" disabled="true"/> -->
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Tare Weight</label>
							<div class="col-md-7">
							<label class="col-md-1 control-label">{{containerAddEditData.tareweight}}</label>
							<!-- 	<input type="text" class=" form-control input-sm"
									property="containerAddEditData.tareweight"
									data-ng-model="containerAddEditData.tareweight"
									name="tareWeight" 
									friendly-name="tareWeight" disabled="true"/> -->
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Material</label>
							<div class="col-md-7">
								<label class="col-md-1 control-label">{{containerAddEditData.material}}</label>
					<!-- 			<input type="text" class=" form-control input-sm"
									property="containerAddEditData.material"
									data-ng-model="containerAddEditData.material"
									name="material" 
									friendly-name="material" disabled="true"/> -->
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Max Capacity</label>
							<div class="col-md-7">
							<label class="col-md-1 control-label">{{containerAddEditData.maxcapacity}}</label>
					<!-- 			<input type="text" class=" form-control input-sm"
									property="containerAddEditData.maxcapacity"
									data-ng-model="containerAddEditData.maxcapacity"
									name="maxcapacity" 
									friendly-name="maxcapacity" disabled="true"/> -->
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Specification</label>
							<div class="col-md-7">
								<label class="col-md-1 control-label">{{containerAddEditData.specification}}</label>
					
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">TEU Factor</label>
							<div class="col-md-7">
							<label class="col-md-1 control-label">{{containerAddEditData.teufactor}}</label>
						<!-- 		<input type="text" class=" form-control input-sm"
									property="containerAddEditData.teufactor"
									data-ng-model="containerAddEditData.teufactor"
									name="factor" 
									friendly-name="factor" disabled="true"/> -->
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">ISO Code</label>
							<div class="col-md-7">
							<label class="col-md-1 control-label">{{containerAddEditData.isocode}}</label>
				<!-- 				<input type="text" class=" form-control input-sm"
									property="containerAddEditData.isocode"
									data-ng-model="containerAddEditData.isocode"
									name="isocode" 
									friendly-name="isocode" disabled="true"/> -->
							</div>
						</div>
					</div>
					<div class="col-md-4">
					<div class="form-group">
									<label class="col-md-4 control-label"> Created By</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedBy" ng-model="surchargeData.modifiedBy:" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerAddEditData.created_by}}</label>
									</div>
								</div>
								</div>
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Created Date</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerAddEditData.created_date}}</label>
									</div>
								</div>
					</div>


				</div>
				<div class="col-md-4">
					<div class="form-group">
									<label class="col-md-4 control-label"> Modified By</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedBy" ng-model="surchargeData.modifiedBy:" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerAddEditData.modified_by}}</label>
									</div>
								</div>
								</div>
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-4 control-label">Modified Date</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerAddEditData.modified_date}}</label>
									</div>
								</div>
					</div>
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							

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
