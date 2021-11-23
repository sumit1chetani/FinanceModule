<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
<!-- 
								<div class="form-group ">
								<label class="col-md-5 control-label">Line<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerDropList"
										property="emptyreposition.customer" id="customer" name="customer"
										ng-model="emptyreposition.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="emptyrepositionForm"></selectivity>
								</div>
							</div> -->
							
							<div class="form-group " ng-if="!edit">
								<label class="col-md-5 control-label">Mode<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="modeList" property="emptyreposition.mode"
										id="mode" name="mode" ng-model="emptyreposition.mode"
										object="dropoff" friendly-name="mode" 
										form-name="emptyrepositionForm"></selectivity>

								</div>
							</div>
							<div class="form-group " ng-if="edit">
								<label class="col-md-5 control-label">Mode<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="modeList" property="emptyreposition.mode"
										id="mode" name="mode" ng-model="emptyreposition.mode"
										object="dropoff" friendly-name="mode" 
										form-name="emptyrepositionForm" disabled="true"></selectivity>

								</div>
							</div>
							
							<div class="form-group " ng-if="!edit">
								<label class="col-md-5 control-label">Vessel<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="vesselList" property="emptyreposition.vessel"
										id="vessel" name="vessel" ng-model="emptyreposition.vessel"
										object="dropoff" friendly-name="vessel"  validation="required"
										form-name="emptyrepositionForm"></selectivity>

								</div>
							</div>
							<div class="form-group " ng-if="edit">
								<label class="col-md-5 control-label">Vessel<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="vesselList" property="emptyreposition.vessel"
										id="vessel" name="vessel" ng-model="emptyreposition.vessel"
										object="dropoff" friendly-name="vessel"  validation="required"
										form-name="emptyrepositionForm" disabled="true"></selectivity>

								</div>
							</div>
							<div class="form-group " ng-if="!edit">
								<label class="col-md-5 control-label">Voyage<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="voyageList" property="emptyreposition.voyage"
										id="voyage" name="voyage" ng-model="emptyreposition.voyage"
										object="dropoff" friendly-name="voyage" validation="required"
										form-name="emptyrepositionForm"></selectivity>

								</div>
							</div>
							<div class="form-group " ng-if="edit">
								<label class="col-md-5 control-label">Voyage<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="voyageList" property="emptyreposition.voyage"
										id="voyage" name="voyage" ng-model="emptyreposition.voyage"
										object="dropoff" friendly-name="voyage" validation="required"
										form-name="emptyrepositionForm" disabled="true"></selectivity>

								</div>
							</div>
							
                        
							<!-- <div class="" style="margin-left: 41%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="emptyreposition.doType" value="SOC FIO" name="socfi"
										checked="checked"> <i></i> SOC FIO
									</label>
								</div>
							</div> -->
							
						</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
<!-- 
								<div class="form-group ">
								<label class="col-md-5 control-label">Line<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerDropList"
										property="emptyreposition.customer" id="customer" name="customer"
										ng-model="emptyreposition.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="emptyrepositionForm"></selectivity>
								</div>
							</div> -->
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Carrier<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="agentList" property="emptyreposition.agent"
										id="agent" name="agent" ng-model="emptyreposition.agent"
										object="dropoff" friendly-name="agent" 
										form-name="emptyrepositionForm"></selectivity>

								</div>
							</div>
							
							
							<div class="form-group " ng-if="!edit">
							<label class="col-md-5 control-label">From Depot<span
								style="color: red">*</span></label>
							<div class="col-md-7">
								<selectivity list="portList" property="emptyreposition.pol"
									id="pol" name="pol" ng-model="emptyreposition.pol"
									object="pol" friendly-name="pol"
									validation="required" form-name="emptyrepositionForm"></selectivity>
							</div>
						</div>
						<div class="form-group " ng-if="edit">
							<label class="col-md-5 control-label">From Depot<span
								style="color: red">*</span></label>
							<div class="col-md-7">
								<selectivity list="portList" property="emptyreposition.pol"
									id="pol" name="pol" ng-model="emptyreposition.pol"
									object="pol" friendly-name="pol"
									validation="required" form-name="emptyrepositionForm" disabled="true"></selectivity>
							</div>
						</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">To Depot<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="portList" property="emptyreposition.pod" id="pod"
										name="pod" ng-model="emptyreposition.pod" object="pod"
										friendly-name="pod" validation="required"
										form-name="emptyrepositionForm" ></selectivity>
								</div>
							</div>
                        
							<!-- <div class="" style="margin-left: 41%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="emptyreposition.doType" value="SOC FIO" name="socfi"
										checked="checked"> <i></i> SOC FIO
									</label>
								</div>
							</div> -->
							
						</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
							<div class="form-group ">
							<label class="col-md-5 control-label">ER Date<span
								style="color: red">*</span></label>
							<div class="col-md-7">
							<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="emptyreposition.exDate" id="exDate"
										name="exDate"  ng-model="emptyreposition.exDate"  friendly-name="exDate"
										form-name="emptyrepositionForm"  />
										</div>
										</div>
						</div >
						<div>
                        <label class="col-md-5 control-label">Service Type<span
								style="color: red">*</span></label>
							<div class="" style="margin-left: 5%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="emptyreposition.doType" value="COC" name="coc"
										checked="checked"> <i></i> COC
									</label>
								</div>
							</div>
							<!-- <div class="" style="margin-left: 5%;">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="emptyreposition.doType" value="SOC" name="soc"
										checked="checked"> <i></i> SOC
									</label>
								</div>
							</div> -->
							</div>
						
<br>
						
							<div  class="col-md-5 control-label" style="left: 36px;">
						     <label class="i-checks m-b-none"> In Transit </label> &nbsp
						     <input
								type="checkbox" ng-model="emptyreposition.isTransit" id="isTransit">
								<i></i>
							
							<!-- <label class="i-checks m-b-none">  Is chargeable </label> &nbsp
							<input
								type="checkbox" ng-model="emptyreposition.isChargable" id="isChargable">
							<i></i>	 -->
							
							</div>



						</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
                <!--  <!-- third column -->
                 	
                <!--  		<div class="form-group" ng-if="emptyreposition.isTransit">
								<label class="col-md-5 control-label">No. of Legs<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<selectivity list="nlegList"
										property="emptyreposition.nleg" id="nleg"
										name="nleg" ng-model="emptyreposition.nleg"
										object="nleg" friendly-name="nleg"
										 form-name="emptyrepositionForm" value="2"
										></selectivity>
								</div>
							</div> -->
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Agent<span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="employeeList"
										property="emptyreposition.agent" id="agent"
										name="agent" ng-model="emptyreposition.agent"
										object="agent" friendly-name="agent"
										 form-name="emptyrepositionForm"
										></selectivity>
							</div>
							</div>
							
								<div class="form-group ">
								<label class="col-md-5 control-label">Status<span
									style="color: red"></span></label>
								<div class="col-md-7">
										<input type="text" class="form-control input-sm"
										name="Status" 
										property="emptyreposition.Status" id="origin" ng-model="emptyreposition.Status"
										friendly-name="Status" />
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Currency<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="currencyList"
										property="emptyreposition.currencyName" id="currencyName"
										name="currencyName" ng-model="emptyreposition.currencyName"
										object="currencyName" friendly-name="currencyName"
										validation="required" form-name="emptyrepositionForm"></selectivity>
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Cont.Drop Off Mode<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="dropoffList"
										property="emptyreposition.dropoff" id="dropoff"
										name="dropoff" ng-model="emptyreposition.dropoff"
										object="dropoff" friendly-name="dropoff"
										validation="required" form-name="emptyrepositionForm"></selectivity>
										
								</div>
								</div>
								
									<div class="form-group ">
							
								<label class="col-md-5 control-label">Origin <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<input type="text" class="form-control input-sm"
										name="origin" 
										property="emptyreposition.origin" id="origin" ng-model="emptyreposition.origin"
										friendly-name="origin" />
							</div>
							
							</div> 
							 --><br>
							<div class="form-group" >
								<div class="col-md-5" style="padding-left: 35%">
									<button class="btn btn-primary" type="button"
										class="btn btn-primary" data-ng-click="fileUpload()">
										<i class="fa fa-file"></i>Upload Container Details
									</button>
									<div class="excel"></div>
									<a id="ERSDownload" style="display: none"
										href="/assets/docs/EmptyRepostioningSample.xlsx" download="EmptyRepostioningSample.xlsx"></a>
								</div>
							</div>
						</fieldset>
					</div>


						</div>
						<div class="form-actions text-center">
							<div class="row ">
								<div class="col-md-offset-3 col-md-5">
									<!-- <button class="btn btn-success help-button" type="button" data-ng-click="tdsHelpVideo('BookingVideo.mp4','BookingVideo')">
<i class="fa fa-video-camera"></i>
Help Video
</button> -->
<!-- 									<button class="btn btn-success help-button" type="button"
										data-ng-click="tdsHelpVideo('BookingVideo.mp4','BookingVideo')">
										<i class="fa fa-video-camera"></i> Help Video
									</button>
 -->
									<button class="btn btn-success" type="button"
										ng-click="search(emptyreposition)">
										<i class="fa fa-search"></i> Search
									</button>
									
																</div>
							</div>
						</div>
						<div class="row">
			<table class="table table-striped b-t b-light">
				<tr style="background-color: #c1d6dd;">
					<th colspan=1 class="width_1 text-center"></th>
					<th colspan=1 class="width_13 text-center">Vessel<span
						style="color: red"></span></th>
					<th colspan=1 class=" width_9 text-center">Voyage<span
						style="color: red"></span></th>
					<th colspan=1 class=" width_8 text-center">POL<span
						style="color: red"></span></th>
					<th colspan=1 class="width_1 text-center">POD<span
						style="color: red"></span></th>
					<th colspan=1 class="width_1 text-center">LEG<span
						style="color: red"></span></th>

				</tr>
				<tbody ng-repeat="(trIndex, row) in emptyreposition.transitDtl"
					ng-controller="emptyrepositiontableCtrl">
					<tr>
						<td><label class="i-checks m-b-none"> <input
								type="checkbox" ng-model="row.select" id="section{{trIndex}}">
								<i></i>
						</label></td>
						<td class=" width_9"><selectivity list="vesselList"
								property="row.vessel" id="vessel{{trIndex}}"
								ng-model="row.vessel" validation="required"
								name="vessel{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(vessel)'}}"
								form-name="emptyrepositionForm"></selectivity></td>
						<td class=" width_9"><selectivity list="voyageList"
								property="row.voyage" id="voyage{{trIndex}}"
								ng-model="row.voyage" validation="required"
								name="voyage{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(voyage)'}}"
								form-name="emptyrepositionForm"></selectivity></td>
						<td class=" width_9"><selectivity list="portList"
								property="row.pol" id="pol{{trIndex}}" ng-model="row.pol"
								validation="required" name="pol{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(pol)'}}"
								form-name="emptyrepositionForm"></selectivity></td>
						<td class=" width_9"><selectivity list="portList"
								property="row.pod" id="pol{{trIndex}}" ng-model="row.pod"
								validation="required" name="pod{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(pod)'}}"
								form-name="emptyrepositionForm"></selectivity></td>
						<td class=" width_9"><selectivity list="legList"
								property="row.leg" id="leg{{trIndex}}" ng-model="row.leg"
								validation="required" name="leg{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(leg)'}}"
								form-name="emptyrepositionForm"></selectivity></td>
							</tr>

					<!-- detail -->

				</tbody>
			</table>

			<button ng-click="addRow()" class="btn btn-sm btn-info"
				type="button">
				<i class="fa fa-plus"></i>
			</button>
			<button ng-click="removeRow()" class="btn btn-sm btn-danger"
				 type="button">
				<i class="fa  fa-trash-o"></i>
			</button>
		</div>
		<div class="row">
			<table class="table table-striped b-t b-light">
				<tr style="background-color: #c1d6dd;">

<th colspan=1 class="width_1 text-center" ng-if="!edit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
									<th colspan=1 class="width_1 text-center" ng-if="edit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)" disabled="true"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
			<th colspan=1 class="width_13 text-center">Depot/Yard<span
						style="color: red">*</span></th>
						<th colspan=1 class="width_13 text-center">BL No<span
						style="color: red"></span></th>
				
							<th colspan=1 class=" width_10 text-center">Container No<span
						style="color: red">*</span></th>
					<th colspan=1 class=" width_9 text-center">Container Type<span
						style="color: red">*</span></th>
				<th colspan=1 class="width_13 text-center">Vessel<span
						style="color: red"></span></th>
					<th colspan=1 class=" width_9 text-center">Voyage<span
						style="color: red"></span></th>
						<th colspan=1 class=" width_9 text-center">Gate Out Date<span
						style="color: red"></span></th>
						<th colspan=1 class=" width_9 text-center">Gate In Date<span
						style="color: red"></span></th>
					<!-- <th colspan=1 class="width_1 text-center">Tare Weight<span
						style="color: red">*</span></th> -->
				</tr>
				<tbody ng-repeat="(trIndex, row) in emptyreposition.depotDetail"
					ng-controller="emptyrepositionContainerCtrl">
					<tr>
						<td><label class="i-checks m-b-none" ng-if="!edit"> <input
								type="checkbox" ng-model="row.select" id="section{{trIndex}}">
								<i></i>
						</label></td>
						<!-- <td><label class="i-checks m-b-none" ng-if="edit"> <input
								type="checkbox" ng-model="row.select" id="section{{trIndex}}" disabled="true">
								<i></i>
						</label></td> -->
						<td class=" width_9"><selectivity list="depotList"
								property="row.depot" id="depot{{trIndex}}"
								ng-model="row.depot" validation="required"
								name="depot{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}" disabled="true"
								form-name="emptyrepositionForm"></selectivity></td>
						<td class=" width_9"><input type="text" class="form-control input-sm"
								name="blNo" 
								property="row.vessel" id="blNo" ng-model="row.blNo" disabled="true"
										friendly-name="blNo" /></td>
						<td class=" width_11" ng-if="!edit" >
						<selectivity list="conList"
								property="row.containerNo" id="containerNo{{trIndex}}"
								ng-model="row.containerNo" validation="required"
								name="containerNo{{trIndex}}" disabled="true"
								friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
								form-name="emptyrepositionForm"  ></selectivity>
								
								<td class=" width_11" ng-if="edit" >
						<selectivity list="conListEdit"
								property="row.containerNo" id="containerNo{{trIndex}}"
								ng-model="row.containerNo" validation="required"
								name="containerNo{{trIndex}}" disabled="true"
								friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
								form-name="emptyrepositionForm" disabled="edit" ></selectivity>
						<td class=" width_9"><selectivity list="conTypeList" 
								property="row.conType" id="depot{{trIndex}}"
								ng-model="row.conType" validation="required" disabled="true"
								name="conType{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
								form-name="emptyrepositionForm" disabled="edit"></selectivity></td>
								</td>
						<td class=" width_9"><input type="text" class="form-control input-sm"
								name="vessel" 
								property="row.vessel" id="vessel" ng-model="row.vessel" disabled="true"
										friendly-name="vessel" /></td>
										<td class=" width_9"><input type="text" class="form-control input-sm"
								name="voyage" 
								property="row.voyage" id="voyage" ng-model="row.voyage" disabled="true"
										friendly-name="voyage" /></td>
							<td class=" width_9"><input type="text" class="form-control input-sm"
								name="gateInDate" 
								property="row.gateInDate" id="gateInDate" ng-model="row.gateInDate" disabled="true"
										friendly-name="gateInDate" /></td>

<td class=" width_9"><input type="text" class="form-control input-sm"
								name="gateOutDate" 
								property="row.gateOutDate" id="gateOutDate" ng-model="row.gateOutDate" disabled="true"
										friendly-name="gateOutDate" /></td>


					</tr>

					<!-- detail -->

				</tbody>
			</table>

			<button ng-click="addRow1()" class="btn btn-sm btn-info"
				type="button">
				<i class="fa fa-plus"></i>
			</button>
			<button class="btn btn-sm btn-info" ng-click="addCredRow1()"
							style="display: none;" tooltip="ssssss Row" id="buttontemp"
							type="button">
							<i class="fa fa-plus"></i>
						</button>
			<button ng-click="removeRow1()" class="btn btn-sm btn-danger"
				 type="button">
				<i class="fa  fa-trash-o"></i>
			</button>
		</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="submit(emptyrepositionForm,emptyreposition)" id="emptyrepositionsave">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(emptyrepositionForm,emptyreposition)" id="emptyrepositionsave">
											<i class="fa fa-save"></i> Update
										</button>
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Back
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
						<!-- /table-responsive -->
					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
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
