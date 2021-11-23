
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="containerOnHireForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Release Ref. No. <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="releaseRefNo"
										property="containerOnHire.releaseRefNo" id="releaseRefNo"
										ng-model="containerOnHire.releaseRefNo" name="releaseRefNo"
										validation="required" friendly-name="RELEASEREFNO"
										form-name="containerOnHireForm"></selectivity>
								</div>
							</div>
						
							<div class="form-group">
								<label class="col-md-4 control-label"> On Hire Ref. No. </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="onHireRefNo" id="onHireRefNo"
										ng-model="containerOnHire.onHireRefNo" 
										friendly-name="ONHIREREFNO" disabled="disabled" />
									<!-- 										 {{containerOnHire.onHireRefNo}}
 -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> No of OnHire Release Containers
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="noOfContainer" id="noOfContainer"
										ng-model="containerOnHire.noOfContainer"
										friendly-name="NOOFCONTAINER" disabled="disabled" />
								</div>
							</div>

								<div class="form-group">
								<label class="col-md-4 control-label"> No of Containers Already OnHired
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="noOfContainerAdded" id="noOfContainerAdded"
										ng-model="containerOnHire.noOfContainerAdded"
										friendly-name="noOfContainerAdded" disabled="disabled" />
								</div>
							</div>


							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Is Domestic </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="isdomestic" id="isdomestic"
											class="checkbox style-0" name="isdomestic"
											ng-model="containerOnHire.isdomestic"> <i></i>
										</label>
									</div>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">File Upload </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="fileupload" id="fileupload"
											class="checkbox style-0" name="fileupload"
											ng-model="containerOnHire.fileupload"> <i></i>
										</label>
									</div>
								</div>
							</div>

							<!-- <div class="form-group">
									<div class="col-md-5">
									<button type="button" class="btn btn-primary">Excel Export</button>
									<div class="form-control btn-primary"
										data-ng-click="fileUpload()">
										<span class="fa fa-upload"></span>
									</div>
								</div>
							</div> -->
							<div class="form-group" ng-if="containerOnHire.fileupload">
								<div class="col-md-5" style="padding-left: 35%">
									<button class="btn btn-primary" type="button"
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Upload Container Details
									</button>
									<div class="excel"></div>
	<a id="sampleDownload" type="display:none" href="assets/docs/SampleONHire.xlsx" download="SampleONHire.xlsx"></a>
									
									<!-- <a id="sampleDownload" style="display: none"
										href="/assets/docs/Sample.xlsx" download="Sample.xlsx"></a> -->
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>


							<div class="form-group">
								<label class="col-md-4 control-label">Agreement Party </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="agreementParty" id="agreementParty"
										ng-model="containerOnHire.agreementParty" disabled="disabled"
										friendly-name="AGREEMENTPARTY" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Lease Type </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="leaseType" id="leaseType" disabled="disabled"
										ng-model="containerOnHire.leaseType" friendly-name="LEASETYPE" />
								</div>
							</div>
							<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Agent</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="agent"
										id="agent" ng-model="containerOnHire.agent"
										friendly-name="AGENT" />
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Port<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="port"
										id="port" ng-model="containerOnHire.port" friendly-name="PORT" /> -->
									<selectivity list="portList" property="containerOnHire.port"
										id="port" ng-model="containerOnHire.port" name="port" validation ="required"
										friendly-name="port" form-name="containerOnHireForm"></selectivity>
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Depot<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									 
									<selectivity list="depotList" property="containerOnHire.depot"
										id="depot" ng-model="containerOnHire.depot" name="depot" validation ="required"
										friendly-name="depot" form-name="containerOnHireForm"></selectivity>
								</div>
							</div> -->
							
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-4 control-label">On-hire Date <span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="containerOnHire.date" id="date"
										name="date"  ng-model="containerOnHire.date"  friendly-name="date"
										form-name="containerOnHireForm" validation="required" />
										</div>
								</div>
							</div>
							
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-4 control-label">CCL OnHire Date <span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
								<div class="input-group  input-append date">
										<input type="text" class="form-control input-sm"
												id="date" name="date"
												ng-model="containerOnHire.date" validation="required"  disabled="disabled"
												friendly-name="date" /> <span
												class="input-group-addon add-on"><span
												form-name="containerOnHireForm" class="glyphicon glyphicon-calendar"></span></span>
										</div>
									 
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Sima Marine OnHire Date </label>
								<div class="col-md-5">
									<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="containerOnHire.date" id="date"
										name="date"  ng-model="containerOnHire.date"  friendly-name="date"
										form-name="containerOnHireForm"/>
										</div>
								</div>
							</div> -->
						</fieldset>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th class="width_1">Select</th> -->
								<th class="width_1 text-center"><label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -22px;"></i>
							</label> </th>
								<th class="width_7 text-center">Container Type<span style="color: red;"> *</span></th>
								<th class="width_8 text-center">Container No.<span style="color: red;"> *</span></th>
								<th class="width_6 text-center">Year of Manuf.<span style="color: red;">* </span></th>
								<th class="width_8 text-center">Payload<span style="color: red;">*</span></th> 
								<th class="width_8 text-center">Tare Weight<span style="color: red;"></span></th>
								<th class="width_8 text-center">Gross Weight<span style="color: red;"></span></th> 
								<th class="width_8 text-center" ng-if ="containerOnHire.checkRefer">Machine <span style="color: red;"></span></th>
								<th class="width_8 text-center" ng-if ="containerOnHire.checkRefer">Model <span style="color: red;"></span></th>
								<th class="width_15 text-center">Actual Pick-up Date</th>
								<th class="width_15 text-center">Agreement Return Date</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in containerOnHire.containerDtl" ng-controller="onHiretableCtrl">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}" ng-disabled="row.gateOutStatus" /><i></i></label></td>
								<td class="width_4">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerType"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="containerOnHireForm" disabled="row.gateOutStatus"></selectivity>

										</div>
									</div>
								</td>


								<td class="width_12">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=11 data-ng-model="row.containerNo"
												name="containerNo{{trIndex}}" data-ng-blur="validateContainer(row.containerNo,$index)"
												
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}"  ng-disabled="row.gateOutStatus"/>
										</div>
									</div>
								</td>
								 <td class="width_9">
									<div class="row">
									<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.yearOfManuf" id="yearOfManuf"
										name="yearOfManuf"  ng-model="row.yearOfManuf"  friendly-name="yearOfManuf"
										validation="required" />
										</div>
										<!-- <div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.yearOfManuf" name="yearOfManuf{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(yearOfManuf)'}}" />
										</div> -->
									</div>
								</td> 
								 <td class="width_9">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.payload" name="payload{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(payload)'}}" />
										</div>
									</div>
								</td> 
								<td class="width_9">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.tareWeight" name="tareWeight{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(tareWeight)'}}" />
										</div>
									</div>
								</td>
								<td class="width_8">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.grossWeight" name="grossWeight{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(grossWeight)'}}" />
										</div>
									</div>
								</td>
								<td class="width_9" ng-if ="containerOnHire.checkRefer">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.machine" name="machine{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(machine)'}}" />
										</div>
									</div>
								</td>
								<td class="width_8" ng-if ="containerOnHire.checkRefer">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.model" name="model{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(model)'}}" />
										</div>
									</div>
								</td>
								<!-- <td class="width_13" ng-if="!isEdit">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.actualPickupDate" id="actualPickupDate{{trIndex+1}}"
										name="actualPickupDate{{trIndex}}"  ng-model="row.actualPickupDate"  friendly-name="actualPickupDate"/>
										</div>
										</div></div>
								</td>
								<td class="width_13" ng-if="!row.gateOutStatus && isEdit">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.actualPickupDate" id="actualPickupDate{{trIndex+1}}"
										name="actualPickupDate{{trIndex}}"  ng-model="row.actualPickupDate"  friendly-name="actualPickupDate"/>
										</div>
										</div></div>
								</td> -->
								
								<td class="width_13"  >
								<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												 data-ng-model="row.actualPickupDate"
												name="actualPickupDate{{trIndex}}" 
												friendly-name="{{ 'Row' + $index + '(actualPickupDate)'}}" disabled="true"/>
								    </div>
								</td>
								
							
								<!-- <td class="width_15" ng-if="!isEdit">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.mtdDate" id="mtdDate{{trIndex+1}}"
										name="mtdDate{{trIndex}}"  ng-model="row.mtdDate"  friendly-name="mtdDate"/>
										</div>
										</div>
									</div>
								</td>
							
								<td class="width_15" ng-if="!row.gateOutStatus && isEdit">
									<div class="row">
										<div class="col-xs-12" >
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.mtdDate" id="mtdDate{{trIndex+1}}"
										name="mtdDate{{trIndex}}"  ng-model="row.mtdDate"  friendly-name="mtdDate"/>
										</div>
										</div>
									</div>
								</td> -->
								
								
								<td class="width_15" >
									<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												 data-ng-model="row.mtdDate"
												name="mtdDate{{trIndex}}" 
												friendly-name="{{ 'Row' + $index + '(mtdDate)'}}" disabled="true"/>
								    </div>
								</td>


							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button class="btn btn-sm btn-info" ng-click="addCredRow1()"
							style="display: none;" tooltip="ssssss Row" id="buttontemp"
							type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								class="btn btn-success"
								ng-click="save(containerOnHireForm,containerOnHire)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success"
								ng-click="update(containerOnHireForm,containerOnHire)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(containerOnHireForm)">
								<i class="fa fa-undo"></i> Reset
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
	</div>
</div>


<script type="text/ng-template" id="fileGenModal">
<div class="model-header">File Upload </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile"
            		onchange="angular.element(this).scope().uploadContainerExcel(this)" accept=".xls,.xlsx" />
            		
				</div>
			</div> 
		</div>
		<div class="model-footer" style="padding-left:9%;padding-top:8%">
			<button class="btn btn-success" type="button" ng-click="uploadContainer()">OK</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
			<button class="btn btn-info" type="button"  ng-click="downloadFile()">Download Sample</button>
		</div>
</script>


