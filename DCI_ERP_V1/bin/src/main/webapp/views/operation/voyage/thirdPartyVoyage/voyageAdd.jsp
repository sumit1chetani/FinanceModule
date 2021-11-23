
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="voyageForm" class="form-horizontal" novalidate>
			<div>
				<div class="row m-t-sm">
         
         
         
         
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							 <div class="form-group">
            <label class="col-md-5 control-label  vessel-text" ng-if="!isView">Vessel</label>
            <label class="col-md-5 control-label  vessel-text font-bold" ng-if="isView">Vessel</label>
            <div class="col-md-7" ng-if="isEdit === false && isView ===false">
	            <selectivity list="vesselList1" property="thirdPartyHeader.vesselCode1" id="vessel_id" ></selectivity>
            </div>
			<div class="col-md-7" ng-if="isEdit">
			   <input type="text" readOnly="readonly" data-ng-model="thirdPartyHeader.vesselName1" class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
			</div>
			<div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.vesselName1}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group hidden-group">
            <label class="col-md-5 control-label" ng-if="!isView">Service<span style="color: red;">*</span></label>
            <label class="col-md-5 control-label font-bold" ng-if="isView">Service<span style="color: red;">*</span></label>
             <div class="col-md-7" ng-if="isEdit === false && isView === false">
            <selectivity list="serviceList" property="thirdPartyHeader.sectorId" id="service_id"></selectivity>
            </div>
             <div class="col-md-7" ng-if="isEdit">
			   <input type="text" readOnly="readonly" data-ng-model="thirdPartyHeader.sectorId" class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
			</div>
			<div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.sectorId}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         
         
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group ">
            <label class="col-md-5 control-label" ng-if="!isView">Vessel Operator<span style="color: red;">*</span></label>
            <label class="col-md-5 control-label font-bold" ng-if="isView">Vessel Operator</label>
             <div class="col-md-7" ng-if="!isView">
            <selectivity list="mloShortNameList" property="thirdPartyHeader.mloShortName" id="mlo_id"></selectivity>
            </div>
			 <div class="col-md-7" ng-if="isView">
			  <label class="control-label">{{thirdPartyHeader.mloShortName1}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
            <label class="col-md-5 control-label" ng-if="!isView">Schedule Start Date<span style="color: red;">*</span></label>
             <label class="col-md-5 control-label font-bold" ng-if="isView">Schedule Start Date</label>
            <div class="col-md-7" ng-if="!isView">
              <!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
               <!-- <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate" date-format="DD/MM/YYYY HH:mm" id="sch_start_date" /> -->
          <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate"
										id="schStartDate" name="schStartDate"  date-format="DD/MM/YYYY HH:mm" id="sch_start_date"
										friendly-name="Valid From"/>
            </div>
            <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.schStartDate}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         
         
         
                  
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
            <label class="col-md-5 control-label" ng-if="!isView">Schedule Start Date<span style="color: red;">*</span></label>
             <label class="col-md-5 control-label font-bold" ng-if="isView">Schedule Start Date</label>
            <div class="col-md-7" ng-if="!isView">
              <!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
               <!-- <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate" date-format="DD/MM/YYYY HH:mm" id="sch_start_date" /> -->
          
         <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schEndDate"
										id="schEndDate" name="schEndDate" date-format="DD/MM/YYYY HH:mm" id="sch_end_date"
										friendly-name="Valid From"/>
            </div>
            <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.schEndDate}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         
         
         
         
         
     
    </fieldset>      
         </div>
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
										type="checkbox" ng-model="row.select" id="section{{trIndex}}" ><i></i></label></td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="portCode"
										property="row.portCode" id="portCode{{trIndex}}"
										data-ng-model="row.portCode" name="portCode{{trIndex}}"
										friendly-name="{{ 'Row' + $trindex + '(portCode)'}}"
										form-name="voyageForm"  disabled="row.vesselsailing_id === true"  ></selectivity>
										</div>
									</div>
								</td>								
								<td class="width_7">
									<div class="row">
										<div class="col-xs-12">
										<label class="control-label" style="margin-left:  30%;">{{row.portSeq}}
								</label>
									 
										</div>
									</div>
								</td>
								<td class="width_15" ng-if="row.vesselsailing_id === false">
								<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.eta" id="eta{{trIndex+1}}"
										name="eta{{trIndex}}" ng-model="row.eta"  friendly-name="ETA" disabled="row.vesselsailing_id === true"/>
										</div>
								 
											</div>
									</div>
								</td>
								<td class="width_15" ng-if="row.vesselsailing_id === true">
								<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.eta}}
										</div>
								 
											</div>
									</div>
								</td>
								<td class="width_15" ng-if="isEdit && row.vesselsailing_id === false">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.ata" id="ata{{trIndex+1}}"
										name="ata{{trIndex}}" disabled="disabled" ng-model="row.ata"  friendly-name="ATA" disabled="row.vesselsailing_id === true"/>
										</div>
										</div>
									</div>
								</td>
								<td class="width_15" ng-if="isEdit && row.vesselsailing_id === true">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.ata}}
										</div>
										</div>
									</div>
								</td>
								<td class="width_15" ng-if="row.vesselsailing_id === false">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.etd" id="etd{{trIndex+1}}"
										name="etd{{trIndex}}" ng-model="row.etd"  friendly-name="ETD"   ng-disabled="row.vesselsailing_id === true"/>
										</div>
										</div>
									</div>
								</td>
								<td class="width_15" ng-if="row.vesselsailing_id === true">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.etd}}
										</div>
										</div>
									</div>
								</td>
								<td class="width_15" ng-if="isEdit  && row.vesselsailing_id === false">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.atd" id="atd{{trIndex+1}}"  
										name="atd{{trIndex}}" ng-model="row.atd"  friendly-name="ATD"  ng-disabled="row.vesselsailing_id === true"/>
										</div>
										</div>
									</div>
								</td>
								<td class="width_15" ng-if="row.vesselsailing_id === true">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.atd}}
										</div>
										</div>
									</div>
								</td>
									<td class="width_15" >
								<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.cutoffdt" id="cutoffdt{{trIndex+1}}"
										name="cutoffdt{{trIndex}}" ng-model="row.cutoffdt"  friendly-name="cutoffdt"  />
										</div>
								 
											</div>
									</div>
								</td>
								<td class="width_15" >
									<input type="text" class="form-control input-sm"
										   name="rotationNo{{trIndex}}"
										property="row.rotationNo" id="rotationNo{{trIndex}}" ng-model="row.rotationNo" />
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
							<button class="btn btn-success" type="button"
								ng-if="!isEdit" class="btn btn-success"
								ng-click="save(voyageForm,voyageAdd)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button"
								ng-if="isEdit" class="btn btn-success"
								ng-click="update(voyageForm,voyageAdd)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(voyageAdd)">
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