<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="commodityForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Commodity<span style="color:red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">


										<input type="text" class="form-control input-sm"
											id="commodity" validation="required"
											friendly-name="Commodity" form-name="commodityForm"
											name="commodity" ng-model="commodity.commodity">

									</div>
								</div>
	<!-- <div class="form-group">
								<label class="control-label col-md-4">Classification<span style="color:red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="classificationList" property="commodity.classification"
										id="classification" ng-model="commodity.classification"
										name="classification" form-name="commodityForm" validation="required"
										friendly-name="Classification"></selectivity>
								</div>
							</div>						
	 -->									
						
								<div class="form-group">
									
									<label class="col-md-4 control-label">Hazardous</label>
									<div class="col-md-5 inputGroupContainer">

										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" checked="checked"
												ng-true-value="'Y'" ng-false-value="'N'" name="hazardous"
												ng-model="commodity.hazardous"> <i></i>
											</label>
										</div>
									</div>
								</div>
								  <div class="form-group">
									
									<label class="col-md-4 control-label">UNNo.</label>
								<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="UNN0" form-name="commodityForm"
											id="unno"
											name="unno" ng-model="commodity.unno">

									</div>
								</div>
								
								
									 <div class="form-group">
									
									<label class="col-md-4 control-label">Flash Point</label>
								<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="Flash Point" form-name="commodityForm"
											id="flashPoint"
											name="flashPoint" ng-model="commodity.flashPoint">

									</div>
								</div>
								<div class="form-group">
									
									<label class="col-md-4 control-label">Tax Exemption</label>
									<div class="col-md-5 inputGroupContainer">

										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" checked="checked"
												ng-true-value="'Y'" ng-false-value="'N'" name="taxExem"
												ng-model="commodity.taxExem"> <i></i>
											</label>
										</div>
									</div>
								</div>
	</fieldset>
	</div>
		<div class="col-sm-6 col-md-6 col-lg-6">
		<fieldset>

                             

							
								
								 <div class="form-group">
									
									<label class="col-md-4 control-label">IMDG Class Code </label>
								<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="IMDG Class Code" form-name="commodityForm"
											id="imdgCode"
											name="imdgCode" ng-model="commodity.imdgCode">

									</div>
								</div>
								
								 <div class="form-group">
									
									<label class="col-md-4 control-label">IMDG Code Page</label>
								<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="IMDG Code Page" form-name="commodityForm"
											id="imdgPage"
											name="imdgPage" ng-model="commodity.imdgPage">

									</div>
								</div>
								
										 <div class="form-group">
									
									<label class="col-md-4 control-label">HS Code</label>
								<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="HS Code" form-name="commodityForm"
											id="hsCode"
											name="hsCode" ng-model="commodity.hsCode">

									</div>
								</div>

								<div class="form-group">

									<label class="col-md-4 control-label">BL Clause</label>
									<div class="col-md-5 inputGroupContainer">

										<textarea type="text" class="form-control input-sm"
											friendly-name="BL Clause" form-name="commodityForm"
											id="blClause" name="blClause" ng-model="commodity.blClause">
</textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Active </label>
									<div class="col-md-5">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" 
											 name="active"
												ng-model="commodity.active"> <i></i>
											</label>
										</div>
									</div>
								</div>

							</fieldset>
						</div>
					</div>

				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="save(commodityForm,commodity)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit"
								ng-click="update(commodityForm,commodity)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button" data-ng-click="reset()"">
								<i class="fa fa-undo"></i> Reset
							</button>

<!-- 							<button class="btn btn-info" ng-click="reset1()" ng-if="isEdit"> -->
<!-- 								<i class="fa fa-reply"></i> Reset -->
<!-- 							</button> -->

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

