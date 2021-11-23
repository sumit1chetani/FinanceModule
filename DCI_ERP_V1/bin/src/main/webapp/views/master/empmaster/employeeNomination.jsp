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
								<form class="form-horizontal" name="frmNomination"
									id="nominationForm" novalidate method="post"
									ng-init="setForm(this);">
									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-4 control-label">Name <span
														style="color: red;">*</span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															data-message-id="nominateName" validation="required"
															friendly-name="Name" name="Name" maxlength="20"
															ng-model="EmployeeMasterDataNomination.nominateName">
													</div>
												</div>

												<div class="form-group ">
													<label class="col-md-4 control-label">Gender<span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<select class="form-control journalVoucher-textBox"
															name="Gender in Nomination"
															ng-model="EmployeeMasterDataNomination.nominateGender"
															data-message-id="nominateGender" validation="required"
															friendly-name="Gender" name="Gender"
															data-message-id="Gender">
															<option value="">--Select--</option>
															<option value="Male">Male</option>
															<option value="Female">Female</option>
														</select>
													</div>
												</div>

					<!-- 							<div class="form-group">
													<label class="col-md-4 control-label">Date Of Birth<span
														style="color: red;"></span></label>
													<div class="col-md-5">
														<ng-bs3-datepicker
															data-ng-model="EmployeeMasterDataNomination.nomdateOfBirth"
															id="nomdateOfBirth" name="nomdateOfBirth"
															form-name="toForm" friendly-name="nomdateOfBirth" />

													</div>
												</div> -->

												<div class="form-group">
													<label class="col-md-4 control-label">Occupation<span
														style="color: red;"></span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															name="nominateOccupation" maxlength="20"
															ng-model="EmployeeMasterDataNomination.nominateOccupation">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Relationship<span
														style="color: red;"></span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															name="nominateRelationship" maxlength="20"
															ng-model="EmployeeMasterDataNomination.nominateRelationship">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Email<span
														style="color: red;"></span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															name="nominateEmail" maxlength="50"
															ng-model="EmployeeMasterDataNomination.nominateEmail">
													</div>
												</div>
													<div class="form-group ">
													<label class="col-md-4 control-label">Address<span
														style="color: red;"></span></label>
													<div class="col-md-5">
														<textarea
															ng-model="EmployeeMasterDataNomination.nomineAddress"
															name="nomineAddress"
															class="form-control input-sm resize-none" rows="4">
	        										 </textarea>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6"">
												<!-- <div class="form-group">
													<label class="col-md-5 control-label">Upload Photo</label>
													<div class="col-md-5 inputGroupContainer">
														<div class="input-group">
															<div id="image-holder"></div>
															<input type="file" class="form-control"
																name="uploadPhoto"
																ng-model="EmployeeMasterDataNomination.uploadPhotoNominee"
																id="fileUpload"
																onchange="angular.element(this).scope().uploadPhoto(this)"
																accept=".xls,.png,.jpg" /> <br>
														</div>
														<br>
														<button class="btn btn" type="button"
															ng-click="uploadNomineePhoto()">Upload</button>
													</div>
												</div> -->
											
												<div class="form-group">
													<label class="col-md-4 control-label">AADHAR NO</label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															data-message-id="aadharno2" 
															friendly-name="Aadhar no" name="aadharno2"
															ng-model="EmployeeMasterDataNomination.aadharno2"
															maxlength="30" ng-pattern-restrict="^[0-9.]*$">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Place<span
														style="color: red;"></span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															name="nominatePlace" maxlength="20"
															ng-model="EmployeeMasterDataNomination.nominatePlace">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Pincode<span
														style="color: red;"></span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															name="nominatePincode" maxlength="10"
															ng-model="EmployeeMasterDataNomination.nominatePincode"
															phonenumbers-only>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Phone Number<span
														style="color: red;"></span></label>
													<div class="col-md-5 inputGroupContainer">
														<input type="text" class="form-control input-sm"
															name="nominatePincode" maxlength="70"
															ng-model="EmployeeMasterDataNomination.emergPhone"
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
														<input type="text" class="form-control input-sm"
															name="nominatePincode" maxlength="70" style="width: 92%;"
															ng-model="EmployeeMasterDataNomination.emergMobile"
															phonenumbers-only>
													</div>
													<!-- <div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="countrycode"  maxlength="2"
														value="+91">
													<input type="text" class="form-control input-sm"
														name="nominatePincode"  maxlength="10"
														ng-model="EmployeeMasterDataNomination.emergMobile" phonenumbers-only>
												</div> -->
												</div>

											</div>
										</div>

										<!-- <div class="col-sm-12 col-md-12 col-lg-12">
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
											        <tbody ng-repeat="row in EmployeeMasterDataNomination.nominatePhoneMultiple">
											        	<tr>
											           		 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
												           	<td>
													          	<div class="col-xs-12">
													          		<div class="col-xs-6 padding-left-50" >
													         	  			<input type="text" class="form-control input-sm"
																	name="emergPhone" ng-model="row.emergPhone">
													              	</div>
													              	</div>
												             </td>
										            	</tr>
										           	</tbody>
										       </table>		
										       <div class="padding-right-5">
									           <button ng-click="addEmpNomPhoneRow(EmployeeMasterDataNomination.nominatePhoneMultiple)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
									            <i class="fa fa-plus"></i>
									           </button>
									           <button ng-click="removeEmpNomPhoneRow(EmployeeMasterDataNomination.nominatePhoneMultiple)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
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
											        <tbody ng-repeat="row in EmployeeMasterDataNomination.nominateMobileMultiple">
											        	<tr>
											           		 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
												             <td>
													          		<div class="col-xs-12">
													          		<div class="col-xs-6 padding-left-50" >
																				<input type="text" class="form-control input-sm"
																	name="emergMobile"
																	ng-model="row.emergMobile">
													              	</div>
													              	</div>
												             </td>
										            	</tr>
										           	</tbody>
										       </table>		
										       <div class="padding-right-5">
									           <button ng-click="addEmpNomMobileRow(EmployeeMasterDataNomination.nominateMobileMultiple)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
									            <i class="fa fa-plus"></i>
									           </button>
									           <button ng-click="removeEmpNomMobileRow(EmployeeMasterDataNomination.nominateMobileMultiple)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									            <i class="fa  fa-trash-o"></i>
									           </button>
									      	</div>					
									   </div>
									</div>
								</div>	 -->
										<div class="row" align="center">
											<div class="form-group">
												<div class="col-md-12" style="padding-top: 15px;"
													align="center">
													<button class="btn btn-success" data-ng-if="!ispop3Edit" type="button"
														ng-click="validateNomination(frmNomination,EmployeeMasterDataNomination)">
														<i class="fa fa-save"></i> Save
													</button>
													<button class="btn btn-success" type="button"
														data-ng-click="validateNomination(frmNomination,EmployeeMasterDataNomination);"
														data-ng-if="ispop3Edit==true">
														<i class="fa fa-save"></i>Update
													</button>
													<button class="btn btn-danger" type="button"
														data-ng-click="cancelEmployeeNom();">
														<i class="fa fa-close"></i> Cancel
													</button>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- end widget div -->
					</div>
					<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>




