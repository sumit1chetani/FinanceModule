
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="voyageForm" class="form-horizontal" novalidate>
				<div class="row">
				<br>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel Code & Name<span
									style="color: red;">*</span>
								</label>
						
									<div class="form-group">
							
									<div class="col-md-5" ng-if="!isEdit">
							<selectivity list="vesselCode"
										property="voyageAdd.vesselCode" id="vesselCode" 
										ng-model="voyageAdd.vesselCode" name="vesselCode"
										validation="required" friendly-name="Vessel Code & Name"
										form-name="voyageForm" ng-disabled="disabled"></selectivity>
								</div>
								<div class="col-md-5" ng-if="isEdit">
								<label class="control-label" align="left" >{{voyageAdd.vesselCode}}
								</label>
								</div>
							</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Service<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="servicelist"
										property="voyageAdd.service" id="service" disabled="true"
										ng-model="voyageAdd.service" name="service"
										validation="required" friendly-name="service"
										form-name="voyageForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Voyage Code<span
									style="color: red;">*</span></label>
									<div class="col-md-5" ng-if="!isEdit">
									<input type="text" class="form-control input-sm"
										name="voyageCode" id="voyageCode" form-name="voyageForm"
										ng-model="voyageAdd.voyageCode" validation="required"
										friendly-name="Voyage Code" ng-disabled="disabled"/>
								</div>
								<div class="col-md-5" ng-if="isEdit">
								<label class="control-label" align="left" >{{voyageAdd.voyageCode}}
								</label>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>

							<div class="form-group">
								<label class="col-md-3 control-label">Voyage No<span
									style="color: red;"></span></label>
									<label class="col-md-5 control-label" style="text-align: left;">{{voyageAdd.vesselCode}}-{{voyageAdd.voyageCode}}<span
									style="color: red;"></span></label>
								</div>
								 
							</div>
					</div>
					</form>
				</div>
				<br>
				<div class="table-responsive clear" style="padding-bottom: 5%;">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_10 text-center">Port Code & Name</th>
								<th colspan=1 class="width_7 text-center">Port Seq</th>
								<th colspan=1 class="width_15 text-center">ETA</th>
								<th colspan=1 class="width_15 text-center" ng-if="isEdit">ATA</th>
								<th colspan=1 class="width_15 text-center">ETD</th>
								<th colspan=1 class="width_15 text-center" ng-if="isEdit">ATD</th>
								<th colspan=1 class="width_15 text-center">Cutoff Date</th>
									<th colspan=1 class="width_10 text-center">Rotation No</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in voyageAdd.voyagedetailList">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
							<!-- 	<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="portCode"
										property="row.portCode" id="portCode{{trIndex}}"
										data-ng-model="row.portCode" name="portCode{{trIndex}}"
										friendly-name="{{ 'Row' + $trindex + '(portCode)'}}"
										form-name="voyageForm" disabled="true"></selectivity>
										</div>
									</div>
								</td>	 -->
								<td style="text-align:center">{{row.portCodeName}}</td>							
							
								<td style="text-align:center">{{row.portSeq}}</td>	
								<td style="text-align:center">{{row.eta}}</td>	
							
								<td style="text-align:center">{{row.ata}}</td>	
							<td style="text-align:center">{{row.etd}}</td>	
								<td style="text-align:center">{{row.atd}}</td>	
								<td style="text-align:center">{{row.cutoffdt}}</td>	
								<td style="text-align:center">{{row.rotationNo}}</td>
							
							</tr>
						</tbody>

					</table>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
</div></div>