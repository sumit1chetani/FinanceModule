<style>
.ngdialog-content {
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
							<form class="form-horizontal" name="frmReference"
								id="referenceForm" novalidate method="post"
								ng-init="setForm(this);">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<div class="form-group">
											<label class="col-md-4 control-label">Name <span
												style="color: red;">*</span></label>
											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="Name Ref" data-message-id="referenceName"
													validation="required" friendly-name="Name" maxlength="20"
													ng-model="EmployeeMasterDataRef.referenceName">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Occupation<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="occupationRef" maxlength="20"
													ng-model="EmployeeMasterDataRef.occupationRef">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Designation<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="relationshipRef" maxlength="20"
													ng-model="EmployeeMasterDataRef.relationshipRef">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Address<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<textarea ng-model="EmployeeMasterDataRef.referenceAddress"
													name="referenceAddress"
													class="form-control input-sm resize-none" rows="2">
	         										</textarea>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Pincode<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													maxlength="10" name="pincodeRef"
													ng-model="EmployeeMasterDataRef.pincodeRef" maxlength="6"
													phonenumbers-only>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Email<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													name="emailRef" ng-model="EmployeeMasterDataRef.emailRef"
													placeholder='your@email.com'>

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label">Phone Number<span
												style="color: red;"></span></label>

											<div class="col-md-5 inputGroupContainer">
												<input type="text" class="form-control input-sm"
													maxlength="20" name="emailRef"
													ng-model="EmployeeMasterDataRef.emergPhone" maxlength="10"
													phonenumbers-only>
											</div>
										</div>


										<!-- <div class="form-group">
												<label class="col-md-4 control-label">Mobile Number<span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="emailRef" ng-model="EmployeeMasterDataRef.emailRef">
												</div>
											</div> -->

										<!-- <div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a" >
										      	<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
											        <thead class="dataTables-Main-Head">
											          <tr>
											            <th colspan=1 class="width_1"></th>
											            <th colspan=1 class="width_5 text-center">Phone NO</th>
											          </tr>
											          <tr>
											         </thead>
											        <tbody ng-repeat=" row in EmployeeMasterDataRef.phoneRefMultiple">
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
									           <button ng-click="addEmpRefPhoneRow(EmployeeMasterDataRef.phoneRefMultiple)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
									            <i class="fa fa-plus"></i>
									           </button>
									           <button ng-click="removeEmpRefPhoneRow(EmployeeMasterDataRef.phoneRefMultiple)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									            <i class="fa  fa-trash-o"></i>
									           </button>
									      		</div>					
									  		 </div> -->
									</div>
									<div class="row" align="center">
										<div class="form-group">
											<div class="col-md-12" style="padding-top: 15px;"
												align="center">
												<button class="btn btn-success" data-ng-if="!ispop6Edit" type="button"
													ng-click="validateReference(frmReference,EmployeeMasterDataRef)">
													<i class="fa fa-save"></i> Save
												</button>
												<button class="btn btn-success" type="button"
													data-ng-click="validateReference(frmReference,EmployeeMasterDataRef);"
													data-ng-if="ispop6Edit==true">
													<i class="fa fa-save"></i> Update
												</button>
												<button class="btn btn-danger" type="button"
													data-ng-click="cancelEmployeeRef();">
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

