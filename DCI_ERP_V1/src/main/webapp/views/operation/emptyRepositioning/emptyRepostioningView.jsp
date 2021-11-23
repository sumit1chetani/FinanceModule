<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="emptyrepositionForm" class="form-horizontal" novalidate>
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
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Mode<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="modeList" property="emptyreposition.mode"
										id="mode" name="mode" ng-model="emptyreposition.mode"
										object="dropoff" friendly-name="mode" disabled="true"
										form-name="emptyrepositionForm"></selectivity>

								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Vessel<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="vesselList" property="emptyreposition.vessel"
										id="vessel" name="vessel" ng-model="emptyreposition.vessel"
										object="dropoff" friendly-name="vessel" disabled="true"
										form-name="emptyrepositionForm"></selectivity>

								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Voyage<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="voyageList" property="emptyreposition.voyage"
										id="voyage" name="voyage" ng-model="emptyreposition.voyage"
										object="dropoff" friendly-name="voyage"  disabled="true"
										form-name="emptyrepositionForm"></selectivity>

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
								<label class="col-md-5 control-label">Agent<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="agentList" property="emptyreposition.agent"
										id="agent" name="agent" ng-model="emptyreposition.agent"
										object="dropoff" friendly-name="agent" validation="required"
										form-name="emptyrepositionForm" disabled="true"></selectivity>

								</div>
							</div>
							
							
							<div class="form-group ">
							<label class="col-md-5 control-label">POL<span
								style="color: red">*</span></label>
							<div class="col-md-7">
								<selectivity list="portList" property="emptyreposition.pol"
									id="pol" name="pol" ng-model="emptyreposition.pol"
									object="pol" friendly-name="pol"
									validation="required" form-name="emptyrepositionForm"disabled="true"></selectivity>
							</div>
						</div>
							
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
							 
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							
						<div class="form-group ">
								<label class="col-md-5 control-label">POD<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="portList" property="emptyreposition.pod" id="pod"
										name="pod" ng-model="emptyreposition.pod" object="pod"
										friendly-name="pod" validation="required"
										form-name="emptyrepositionForm"disabled="true"></selectivity>
								</div>
							</div>

						<div class="form-group ">
							<label class="col-md-5 control-label">ER Date<span
								style="color: red">*</span></label>
							<div class="col-md-7">
							<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="emptyreposition.exDate" id="exDate"
										name="exDate"  ng-model="emptyreposition.exDate"  friendly-name="exDate"
										form-name="emptyrepositionForm"  disabled="true"/>
										</div>
										</div>
						</div >
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
                 	
                
					 
						</fieldset>
					</div>


				</div>

<br>
		<div class="row">
			<table class="table table-striped b-t b-light">
				<tr style="background-color: #c1d6dd;">
					<th colspan=1 class="width_1 text-center"></th>
					<th colspan=1 class="width_13 text-center">Vessel<span
						style="color: red">*</span></th>
					<th colspan=1 class=" width_9 text-center">Voyage<span
						style="color: red">*</span></th>
					<th colspan=1 class=" width_8 text-center">POL<span
						style="color: red">*</span></th>
					<th colspan=1 class="width_1 text-center">POD<span
						style="color: red">*</span></th>
					<th colspan=1 class="width_1 text-center">LEG<span
						style="color: red">*</span></th>

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
								form-name="emptyrepositionForm"disabled="true"></selectivity></td>
						<td class=" width_9"><selectivity list="voyageList"
								property="row.voyage" id="voyage{{trIndex}}"
								ng-model="row.voyage" validation="required"
								name="voyage{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(voyage)'}}"
								form-name="emptyrepositionForm"disabled="true"></selectivity></td>
						<td class=" width_9"><selectivity list="portList"
								property="row.pol" id="pol{{trIndex}}" ng-model="row.pol"
								validation="required" name="pol{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(pol)'}}"
								form-name="emptyrepositionForm"disabled="true"></selectivity></td>
						<td class=" width_9"><selectivity list="portList"
								property="row.pod" id="pol{{trIndex}}" ng-model="row.pod"
								validation="required" name="pod{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(pod)'}}"
								form-name="emptyrepositionForm"disabled="true"></selectivity></td>
						<td class=" width_9"><selectivity list="legList"
								property="row.leg" id="leg{{trIndex}}" ng-model="row.leg"
								validation="required" name="leg{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(leg)'}}"
								form-name="emptyrepositionForm"disabled="true"></selectivity></td>
							</tr>

					<!-- detail -->

				</tbody>
			</table>

			 
		</div>
				<!-- second table -->
				<div class="row">
			<table class="table table-striped b-t b-light">
				<tr style="background-color: #c1d6dd;">
					<th colspan=1 class="width_1 text-center"></th>
					<th colspan=1 class="width_13 text-center">Depot/Yard<span
						style="color: red">*</span></th>
						<th colspan=1 class="width_13 text-center">BL No<span
						style="color: red"></span></th>
							<th colspan=1 class=" width_8 text-center">Container No<span
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
						<td><label class="i-checks m-b-none"> <input
								type="checkbox" ng-model="row.select" id="section{{trIndex}}">
								<i></i>
						</label></td>
						<td class=" width_9"><selectivity list="depotList"
								property="row.depot" id="depot{{trIndex}}"
								ng-model="row.depot" validation="required"
								name="depot{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
								form-name="emptyrepositionForm"disabled="true"></selectivity></td>
						<td class=" width_10"><input type="text" class="form-control input-sm"
								name="blNo" 
								property="row.vessel" id="blNo" ng-model="row.blNo" disabled="true"
										friendly-name="blNo" /></td>
						<td class=" width_11" ng-if="!edit" >
						<selectivity list="conList"
								property="row.containerNo" id="containerNo{{trIndex}}"
								ng-model="row.containerNo" validation="required"
								name="containerNo{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
								form-name="emptyrepositionForm"  ></selectivity>
								
								<td class=" width_11" ng-if="edit" >
						<selectivity list="conListEdit"
								property="row.containerNo" id="containerNo{{trIndex}}"
								ng-model="row.containerNo" validation="required"
								name="containerNo{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
								form-name="emptyrepositionForm" disabled="edit" ></selectivity>
						<td class=" width_11"><selectivity list="conTypeList"
								property="row.conType" id="depot{{trIndex}}"
								ng-model="row.conType" validation="required"
								name="conType{{trIndex}}"
								friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
								form-name="emptyrepositionForm" disabled="edit"></selectivity></td>
								</td>
						<!-- <td class=" width_9"><input type="text" class="form-control input-sm"
								name="tareWeight" 
								property="row.tareWeight" id="tareWeight" ng-model="row.tareWeight"
										friendly-name="tareWeight" disabled="true"/></td> -->
<td class=" width_7"><input type="text" class="form-control input-sm"
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

			 
		</div>
				
				
				
				<!-- second table end-->
				
				
				
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										 
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

