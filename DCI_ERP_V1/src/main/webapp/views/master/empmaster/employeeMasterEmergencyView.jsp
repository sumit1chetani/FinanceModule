<style>
.ngdialog-content {
	width: 75% !important;
	bottom: 105px !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-form">
					<%@include file="/views/templates/panel-header-form.jsp"%>
					<div class="panel-body">
						<div class="widget-body">
							<form class="form-horizontal" name="frmEmergency"
								id="emergencyForm" novalidate method="post"
								ng-init="setForm(this);">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Name <span
													style="color: red;">*</span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Name Emer" data-message-id="emergencyName" disabled
														validation="required" friendly-name="Name" maxlength="50"
														ng-model="EmployeeMasterDataEme.emergencyName"
														form-name="frmEmergency">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Relationship<span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="emergRelationship" maxlength="50" disabled
														ng-model="EmployeeMasterDataEme.emergRelationship">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Occupation <span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="emergencyOccu" maxlength="50" disabled
														ng-model="EmployeeMasterDataEme.emergencyOccu">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Email<span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														maxlength="70" name="emergEmail" disabled
														ng-model="EmployeeMasterDataEme.emergEmail"
														placeholder='your@email.com'>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Phone Number<span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														maxlength="30" name="emergEmail" disabled
														ng-model="EmployeeMasterDataEme.emergPhone"
														phonenumbers-only>
												</div>
											</div>

										</div>
										<div class="col-sm-6 col-md-6 col-lg-6"">
											<div class="form-group">
												<label class="col-md-4 control-label">Place<span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														maxlength="50" name="emergPlace" disabled
														ng-model="EmployeeMasterDataEme.emergPlace">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Address<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<textarea ng-model="EmployeeMasterDataEme.emerAddress"
														name="emerAddress" disabled
														class="form-control input-sm resize-none" rows="4">
	         										</textarea>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Pincode <span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="emergencyPincode" maxlength="10" disabled
														ng-model="EmployeeMasterDataEme.emergencyPincode"
														phonenumbers-only>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Mobile Number<span
													style="color: red;"></span></label>

												<div
													class="col-md-1 no-padding padding-left-4 padding-top-5">
													<label class="col-md-4 control-label">+91</label>
												</div>
												<div
													class="col-md-4 no-padding padding-left-4 padding-top-5">
													<input type="text" class="form-control input-sm" disabled
														style="width: 92%;" maxlength="30" name="emergEmail"
														ng-model="EmployeeMasterDataEme.emergMobile"
														phonenumbers-only>
												</div>

											</div>


										</div>
									</div>
									<!-- 
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
										      	<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
											        <thead class="dataTables-Main-Head">
											          <tr>
											            <th colspan=1 class="width_1"></th>
											            <th colspan=1 class="width_5 text-center">Phone NO</th>
											          </tr>
											          <tr>
											         </thead>
											        <tbody ng-repeat="row in EmployeeMasterDataEme.phoneNoMultiple">
											        	<tr>
											           		 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
												           	<td>
												           		<div class="col-xs-12">
													          		<div class="col-xs-6 padding-left-50" >
													         	  			<input type="text" class="form-control input-sm padding-0"
																	name="emergPhone" ng-model="row.emergPhone">
													              	</div>
													              	</div>
												             </td>
										            	</tr>
										           	</tbody>
										       </table>		
										       <div class="padding-right-5">
									           <button ng-click="addEmpEmePhoneRow(EmployeeMasterDataEme.phoneNoMultiple)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
									            <i class="fa fa-plus"></i>
									           </button>
									           <button ng-click="removeEmpEmePhoneRow(EmployeeMasterDataEme.phoneNoMultiple)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									            <i class="fa  fa-trash-o"></i>
									           </button>
									      		</div>					
									  		 </div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
										      	<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
											        <thead class="dataTables-Main-Head">
											          <tr>
											            <th colspan=1 class="width_1"></th>
											            <th colspan=1 class="width_5 text-center">Mobile NO</th>
											          </tr>
											          <tr>
											         </thead>
											        <tbody ng-repeat="row in EmployeeMasterDataEme.mobileNoMultiple">
											        	<tr>
											           		 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
												             <td>
													          		<div class="col-xs-12">
													          		<div class="col-xs-6 padding-left-50" >
																				<input type="text" class="form-control input-sm padding-0"
																	name="emergMobile"
																	ng-model="row.emergMobile">
													              	</div>
													              	</div>
												             </td>
										            	</tr>
										           	</tbody>
										       </table>		
										       <div class="padding-right-5">
									           <button ng-click="addEmpEmeMobileRow(EmployeeMasterDataEme.mobileNoMultiple)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
									            <i class="fa fa-plus"></i>
									           </button>
									           <button ng-click="removeEmpEmeMobileRow(EmployeeMasterDataEme.mobileNoMultiple)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									            <i class="fa  fa-trash-o"></i>
									           </button>
									      	</div>					
									   </div>
									</div>
								</div>	 -->
									<div class="row">
										
												<button class="btn btn-danger" type="button"
													data-ng-click="cancelEmployeeEme();">
													<i class="fa fa-close"></i> Cancel
												</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>
