<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
     <form class="form-horizontal" name="departmentAddForm" role="form" novalidate method="post">
      <div class="row">
       <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
        <fieldset>
        <div class="form-group"  >
            <label class="col-md-4 control-label">Mode<span
             style="color: red;">*</span></label> 
             <div class="col-md-5">
                      <selectivity list="modeList" ng-model="vesselsailing.mode"
											validation="required" friendly-name="Mode"
											property="vesselsailing.mode" id="mode" name="mode"
											form-name="departmentAddForm"></selectivity></div>
           </div>
           <div class="form-group"  ng-if="vesselsailing.mode==4">
            <label class="col-md-4 control-label">Carrier<span
             style="color: red;">*</span></label> 
             <div class="col-md-5">
                      <selectivity list="carrierList" ng-model="vesselsailing.carrier"
											friendly-name="carrier"
											property="vesselsailing.carrier" id="carrier" name="carrier" validation="required"
											form-name="departmentAddForm"></selectivity></div>
           </div>
           <div class="form-group" ng-if="vesselsailing.mode!=4">
            <label class="col-md-4 control-label">Carrier</label> 
             <div class="col-md-5">
                      <selectivity list="carrierList" ng-model="vesselsailing.carrier"
											friendly-name="carrier"
											property="vesselsailing.carrier" id="carrier" name="carrier"
											form-name="departmentAddForm"></selectivity></div>
           </div>
           
           
        
        <div class="form-group"  >
            <label class="col-md-4 control-label">Vessel<span
             style="color: red;">*</span></label> 
             <div class="col-md-5">
                      <selectivity list="vessellist" property="vesselsailing.vessel" id="vessel" ng-model="vesselsailing.vessel"
               name="vessel" form-name="departmentAddForm" 
               validation="required" friendly-name="Vessel"></selectivity></div>
           </div>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Voyage
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-5"  >
 <selectivity list="voyagelist" property="vesselsailing.voyage" id="voyage" ng-model="vesselsailing.voyage"
               name="voyage" form-name="departmentAddForm" 
                ></selectivity>          </div>
         </div>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Sail Date
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-5">
           	<ng-bs3-datepicker data-ng-model="vesselsailing.sail_Date"  	name="sail_Date" form-name="departmentAddForm"
											friendly-name="Sail Date" validation="required" />
          </div>
         </div> 
          <div class="form-group">
          <label class="col-md-4 control-label"  >
           Port<span style="color: red;">*</span>
          </label> 
          <div class="col-md-5">
 <selectivity list="portlist" property="vesselsailing.port" id="port" ng-model="vesselsailing.port"
               name="port" form-name="departmentAddForm" 
                friendly-name="Port"></selectivity>           </div>
         </div>
           
         <div class="form-actions">
				
				
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								class="btn btn-success" ng-click="getData(departmentAddForm,vesselsailing)">
								<i class="fa fa-search"></i> Show

							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
						</div>
						<br>
						</div>
				</div>
         
        </fieldset>
       </div>
      </div>
      <div class="panel-body">
						<div class="table-responsive"  id="Containerdetail">
							<div class="col-md-12" style="width: 130%;">

								<div class="row" id="items">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
								<th colspan=1 class="width_1 text-center">SL No</th>
								<th colspan=1 class="width_5 text-center">BL No</th>
								<th colspan=1 class="width_5 text-center">Booking No</th>
								<th colspan=1 class="width_5 text-center">Customer Name</th>
						<!-- 		<th colspan=1 class="width_10 text-center">Customer Type</th> -->
								<th colspan=1 class="width_5 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Container No</th>
								<th colspan=1 class="width_5 text-center">SOC</th>
								<th colspan=1 class="width_5 text-center">Slot Operator</th>
								<th colspan=1 class="width_5 text-center">Seal No</th>
<!-- 								<th colspan=1 class="width_5 text-center">Package Type</th>
 -->								<th colspan=1 class="width_5 text-center">No Of Pkgs</th>
								<th colspan=1 class="width_5 text-center">Pod</th>
									<th colspan=1 class="width_1 text-center">T/s Leg</th>
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in vesselsailing.containerDtl"  ng-controller="onBoardtableCtrl">
											<tr>
								<td style="text-align:center">{{row.slnoInt}}</td>
								<td style="text-align:center">{{row.blno}}</td>
								<td style="text-align:center">{{row.bookingNo}}</td>
								<td style="text-align:center">{{row.customerName}}</td>
								<!-- <td style="text-align:center">{{row.customerType}}</td> -->
								<td style="text-align:center">{{row.containerTypeNew}}</td>
								<td style="text-align:center">{{row.containerNo}}</td>
								<td class="text-center">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="row.soc" disabled="true"><i></i></label>
												</td>
								<td style="text-align:center"><selectivity list="slotList"
										property="row.slotOperator" id="slotOperator{{trIndex}}" ng-model="row.slotOperator"
										name="slotOperator{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(slotOperator)'}}" disabled="true"></selectivity></td>
								<td style="text-align:center">{{row.sealNo}}</td>
<!-- 								<td style="text-align:center">{{row.packgeType}}</td>
 -->								<td style="text-align:center">{{row.noOfPkgs}}</td>
								<td style="text-align:center">{{row.pod}}</td>
								<td style="text-align:center">{{row.leg}}</td>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="table-responsive" style="width: 29%;">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
								<th colspan=1 class="width_1 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Count</th>
				
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in vesselsailing.countNew">
											<tr>
								<td style="text-align:center">{{row.containerCount}}</td>
								<td style="text-align:center">{{row.containerTypeCount}}</td>

										</tbody>
									</table>
								<br>


							</div>
      <div class="form-actions">
       <div class="row">
        <div class="col-md-12">
         <button class="btn btn-success" ng-if="!isEdit" type="button" ng-disabled="check" ng-click="save(departmentAddForm,vesselsailing,departmentValidateData)">
          <i class="fa fa-save"></i>
          Save
         </button>
         
               
 
      <!--    <button class="btn btn-success" type="button" 
											ng-click="getReport(vesselsailing)" id="vesselsailingsave">
											<i class="fa fa-save"></i> Export
										</button>
          -->
         <button class="btn btn-success"
            ng-if="isEdit" type="button" ng-click="update(departmentAddForm,vesselsailing,departmentValidateData)">
            <i class="fa fa-save"></i> Update
           </button>
           
            
         <button class="btn btn-danger" ng-click="cancel()" type="button">
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
 </div>
</div>
