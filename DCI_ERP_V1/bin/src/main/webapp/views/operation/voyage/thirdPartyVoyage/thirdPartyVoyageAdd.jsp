 <link href="/css/schedule-voyage-handson.css" rel="stylesheet" type="text/css">
 
 <script src="js/vendor/Handsonformula/numeric.js"></script>
<script src="js/vendor/Handsonformula/formula.js"></script>
<script src="js/vendor/Handsonformula/parser.js"></script>
<script src="js/vendor/Handsonformula/ruleJS.js"></script>
<script src="js/vendor/Handsonformula/handsontable.formula.js"></script>

 <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
 <input type="hidden" value="${form_code}" id="form_code_id">

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
 
		<div class="form-body form-horizontal">
		  <form class="form-horizontal" name="bookingRequestForm" role="form"   novalidate>
         <div class="row m-t-sm">
         
         
         
          <div class="col-sm-12">
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
			<!-- <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.vesselName1}}</label>
			</div> -->
           </div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
            <label class="col-md-5 control-label">Voyage<span style="color: red;">*</span></label>
            <div class="col-md-7" >
              <!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
               <!-- <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate" date-format="DD/MM/YYYY HH:mm" id="sch_start_date" /> -->
          <input type="text" class="form-control input-sm" 
              data-ng-model="voyage" name="Voyage"  
              data-message-id="Voyage" validation="required" 
              friendly-name=" Voyage" />
           
         <!-- <input type="text" class="form-control input-sm"
										   name="voyageId{{trIndex}}"
										property="row.voyageId12" id="voyageId12{{trIndex}}" ng-model="row.voyageId" 
										title = "{{row.voyageId}}"/> </div> -->
            <!-- <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.schEndDate}}</label>
			</div> -->
           </div>
						</fieldset>
					</div>
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-3 control-label">Voyage No<span
									style="color: red;"></span></label>
									<label class="col-md-5 control-label" style="text-align: left;">{{thirdPartyHeader.vesselCode1}}-{{voyage}}<span
									style="color: red;"></span>
									
											
								</div>
           
         <!-- <input type="text" class="form-control input-sm"
										   name="voyageId{{trIndex}}"
										property="row.voyageId12" id="voyageId12{{trIndex}}" ng-model="row.voyageId" 
										title = "{{row.voyageId}}"/> </div> -->
            <!-- <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.schEndDate}}</label>
			</div> -->
           
						</fieldset>
					</div>
					</div>
					<div class="col-sm-12">
         <div class="col-sm-4 col-md-4 col-lg-4">
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
			<!-- <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.sectorId}}</label>
			</div> -->
           </div>
						</fieldset>
					</div>
         
         
         <div class="col-sm-4 col-md-4 col-lg-4">
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
										friendly-name="Valid From" title = "{{thirdPartyHeader.schStartDate}}"/>
            </div>
            <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.schStartDate}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         
         </div>
         
                  	<div class="col-sm-12">
         <div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
            <label class="col-md-5 control-label" ng-if="!isView">Schedule End Date<span style="color: red;">*</span></label>
             <label class="col-md-5 control-label font-bold" ng-if="isView">Schedule End Date</label>
            <div class="col-md-7" ng-if="!isView">
              <!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
               <!-- <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schStartDate" date-format="DD/MM/YYYY HH:mm" id="sch_start_date" /> -->
          
         <ng-bs3-datepicker data-ng-model="thirdPartyHeader.schEndDate"
										id="schEndDate" name="schEndDate" 
										date-format="DD/MM/YYYY HH:mm" id="sch_end_date"
										friendly-name="Valid From" 
										title = "{{thirdPartyHeader.schEndDate}}"/>
            </div>
            <div class="col-md-7" ng-if="isView">
			    <label class="control-label">{{thirdPartyHeader.schEndDate}}</label>
			</div>
           </div>
						</fieldset>
					</div>
         </div>
              
         </div>
</div>
<div class="row">
      <!-- <div class="col-sm-12 col-md-12 col-lg-12">
         <div style="overflow: inherit; height: auto; width: 100%">
         <div id="dateTimepicker" style="display:none">
         </div>
       <div id="thirdParty" class="handsontable scheduleVoyageTable"></div>
      </div> -->
     </div>
     <div class="table-responsive clear" style="padding-bottom: 5%;">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<!-- <th colspan=1 class="width_10 text-center" style="visibility: hidden">Vessel</th>
								<th colspan=1 class="width_10 text-center" style="visibility: hidden">Voyage</th> -->
								<th colspan=1 class="width_10 text-center">From Port</th>
								<th colspan=1 class="width_15 text-center">ETA</th>
								<th colspan=1 class="width_15 text-center" >ETB</th>
								<th colspan=1 class="width_15 text-center">ETD</th>
									<th colspan=1 class="width_15 text-center">Cutoff Date</th>
									<th colspan=1 class="width_10 text-center">To Port</th>
									<th colspan=1 class="width_5 text-center">Rotation No</th>
									<th colspan=1 class="width_5 text-center">Next Voyage</th>
									
									<th colspan=1 class="width_10 text-center">Remarks</th>
									<th colspan=1 class="width_10 text-center">Action</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in thirdPartyHeader.thirdPartyDetailList">
							<tr>
							<!-- <td class="width_10" style="visibility: hidden">
									<input type="text" class="form-control input-sm"
										   name="vesselCode{{trIndex}}" 
										property="row.vesselCode" id="vesselCode{{trIndex}}" ng-model="row.vesselCode" />
										</td>
										<td class="width_10" style="visibility: hidden">
									<input type="text" class="form-control input-sm"
										   name="voyageId{{trIndex}}"
										property="row.voyageId" id="voyageId{{trIndex}}" ng-model="row.voyageId" 
										title = "{{row.voyageId}}"/>
										</td> -->
							 <td class="width_5" >
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="portList"
										property="row.fromPort" id="fromPort{{trIndex}}"
										data-ng-model="row.fromPort" name="fromPort{{trIndex}}"
										friendly-name="{{ 'Row' + $trindex + '(fromPort)'}}"
										form-name="voyageForm"   ></selectivity>
									 	<!-- <span>{{row.fromPort}}</span>  -->
										</div>
									</div>
								</td>	 						
								<!-- <td class=" width_9"><selectivity list="fromPortList"
											property="row.fromPort" id="fromPort{{trIndex}}"
											ng-model="row.fromPort" 
											name="fromPort{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(fromPort)'}}"
											></selectivity></td> -->
								<td class="width_15" >
								<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.eta" id="eta{{trIndex+1}}"
										name="eta{{trIndex}}" 
										ng-model="row.eta"  friendly-name="ETA" 
										title = "{{row.eta}}" />
										</div>
								 
											</div>
									</div>
								</td>
								<!-- <td class="width_15" ng-if="row.vesselsailing_id === true">
								<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.eta}}
										</div>
								 
											</div>
									</div>
								</td> -->
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.etb" id="etb{{trIndex+1}}"
										name="etb{{trIndex}}"
										 ng-model="row.etb"  friendly-name="ETB" 
										 title = "{{row.etb}}" />
										</div>
										</div>
									</div>
								</td>
								<!-- <td class="width_15" ng-if="isEdit && row.vesselsailing_id === true">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.ata}}
										</div>
										</div>
									</div>
								</td> -->
								<td class="width_15" >
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.etd" id="etd{{trIndex+1}}"
										name="etd{{trIndex}}" ng-model="row.etd" 
										 friendly-name="ETD"   
										 title = "{{row.etd}}" />
										</div>
										</div>
									</div>
								</td>
								<!-- <td class="width_15" ng-if="row.vesselsailing_id === true">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										{{row.etd}}
										</div>
										</div>
									</div>
								</td> -->
								
									<td class="width_15" >
								<div class="row">
										<div class="col-xs-12">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.cutoffdt" id="cutoffdt{{trIndex+1}}"
										name="cutoffdt{{trIndex}}" ng-model="row.cutoffdt" 
										 friendly-name="cutoffdt" title = "{{row.cutoffdt}}"   />
										</div>
								 
											</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										 <div class="col-xs-12">
											<selectivity list="portList"
										property="row.toPort" id="toPort{{trIndex}}"
										data-ng-model="row.toPort" name="toPort{{trIndex}}"
										friendly-name="{{ 'Row' + $trindex + '(toPort)'}}"
										form-name="voyageForm"   ></selectivity> 
										<!-- <selectivity list="portList1"
											property="row.toPort" id="toPort{{trIndex}}"
											ng-model="row.toPort" 
											name="toPort{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(toPort)'}}"
											form-name="voyageForm" 
											></selectivity> -->
											<!-- <span>{{row.toPort}}</span> -->
										</div>
									</div>
								</td>	
								<!-- <td class=" width_9"><selectivity list="toPortList"
											property="row.toPort" id="toPort{{trIndex}}"
											ng-model="row.toPort" 
											name="toPort{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(toPort)'}}"
											></selectivity></td> -->
								<td class="width_5" >
									<input type="text" class="form-control input-sm"
										   name="rotationId{{trIndex}}"
										property="row.rotationId" id="rotationId{{trIndex}}" ng-model="row.rotationId" />
										</td>
										<td class="width_5" >
									<!-- <input type="text" class="form-control input-sm"
										   name="nextVoyage{{trIndex}}"
										property="row.nextVoyage" id="nextVoyage{{trIndex}}" ng-model="row.nextVoyage" />
										 --><input
											type="checkbox" ng-model="row.nextVoyage" 
											 id="nextVoyage{{trIndex}}">
										</td>	
										 <td class="width_10" >
									<!-- <input type="text" class="form-control input-sm"
										   name="remarks{{trIndex}}"
										property="row.remarks" id="remarks{{trIndex}}" ng-model="row.remarks" />
										</td> -->
							<textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex}}"   form-name="trailerForm"
															class="custom-scroll width_250 resize-none" rows="1"
															ng-model="row.remarks">
															</textarea>			
										<td><div class="padding-right-5" id="AddOrRmvebtn">
						<!-- <button ng-click="addRow(thirdPartyHeader.thirdPartyDetailList,trIndex)" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button> -->
						<span> <i
									class="fa  fa-plus text-success text"
									data-ng-click="addRow(thirdPartyHeader.thirdPartyDetailList,trIndex)"></i>
							</span>
						<!-- <button ng-click="removeCredRow(thirdPartyHeader,trIndex)" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button> --><span> </span>
						<span> <i class="fa fa-trash-o text-danger-dker text"
									data-ng-click="removeCredRow(thirdPartyHeader,trIndex)"></i>
							</span>
					</div>
								</td>		
							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table>
					<!-- <div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<br> <br> <br>
				</div>
     </div>
    <div class="form-actions">
          <!--<div class="row m-t-sm">
	   <div class="col-sm-12 col-md-4 col-lg-6">
	    <div class="form-group hidden-group">
            <label class="col-md-5 control-label" ng-if="!isView">Total Port Stay Time</label>
             <label class="col-md-5 control-label font-bold" ng-if="isView">Total Port Stay Time</label>
             <div class="col-md-3">
            <input type="text"   id="portTime" class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
            </div>
           </div>
	   </div>
	   <div class="col-sm-12 col-md-4 col-lg-6">
	    <div class="form-group hidden-group">
            <label class="col-md-7 control-label" ng-if="!isView">Total Steaming Time</label>
            <label class="col-md-7 control-label font-bold" ng-if="isView">Total Steaming Time</label>
             <div class="col-md-3">
            <input type="text"  id="steamingTime" class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
            </div>
           </div>
	   </div> 
	   </div>-->
	   <!-- <div class="row">
	   <div class="col-sm-12 col-md-4 col-lg-4"></div>
	    <div class="col-sm-12 col-md-4 col-lg-4">
	    <div class="form-group hidden-group">
            <label class="col-md-4 control-label" ng-if="!isView">Total Voyage Time</label>
            <label class="col-md-4 control-label font-bold" ng-if="isView">Total Voyage Time</label>
             <div class="col-md-7">
            <input type="text" id="voyageTime" 
            ng-keyup ="get_time_diff()"
            class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
            </div>
           </div>
	   </div>-->
	   
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" id="save" type="button" ng-click="saveThirdPartyVoyage()"  >
        <i class="fa fa-save"></i>
        Save
       </button>
            <a id="tbPdfExport" stype="display:none" href="/assets/excelDocument/scheduleVoyage.xls" download="scheduleVoyage.xls"></a>
       <button class="btn btn-danger " type="button" id="cancel" ng-model="cancel" ng-click="cancel();">
        <i class="fa fa-close"></i>
        Cancel
       </button>
      </div>
     </div>
    </div> 
   
    </form>
</div>
</div>

</div>
