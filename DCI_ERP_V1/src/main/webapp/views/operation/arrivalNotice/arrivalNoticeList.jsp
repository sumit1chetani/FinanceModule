<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%-- <security:authentication var="user" property="principal" /> --%>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="vessselArrivalForm" class="form-horizontal">
				<div class="row">


					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="modeList" ng-model="discharge.mode"
											validation="required" friendly-name="Mode"
											property="discharge.mode" id="mode" name="mode"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							
							<div class="col-md-4" ng-if="discharge.mode==4">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="discharge.carrier"
											friendly-name="carrier"
											property="discharge.carrier" id="carrier" name="carrier" validation="required"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="discharge.mode!=4">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="discharge.carrier"
											friendly-name="carrier"
											property="discharge.carrier" id="carrier" name="carrier"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<!-- vessel -->
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="discharge.vessel"
											 friendly-name="vessel" validation ="required"
											property="discharge.vessel" id="vessel" name="vessel"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
								
							</div>

							<div class="col-md-4">
								<!-- voyage -->
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="discharge.voyage"
											friendly-name="Voyage" validation ="required"
											property="discharge.voyage" id="Voyage" name="Voyage" 
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>

							<!-- 	<div class="col-md-4">
								voyage
								<div class="form-group">
									<label class="col-md-5 control-label">Discharge Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="discharge.disVoyage"
											friendly-name="disVoyage" validation ="required"
											property="discharge.disVoyage" id="disVoyage" name="disVoyage" 
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div> -->
							
							<div class="col-md-4">
								<!-- voyage -->
								<div class="form-group">
									<label class="col-md-5 control-label">Discharge Port<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="fpodList" ng-model="discharge.port"
											friendly-name="port" validation ="required"
											property="discharge.port" id="port" name="port" 
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							
							 
							<!-- <div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">ETA Date</label>
									<div class="col-md-7">
										<label class="col-md-12 control-label" style=" text-align: left;">{{discharge.eta}}</label>
									</div>

								</div>
							</div> -->
							 
							<div class="col-md-4">
								<!-- port -->
								<div class="form-group">
									<label class="col-md-5 control-label">BL No.<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="blList" ng-model="discharge.blNo"
											 friendly-name="blNo" 
											property="discharge.blNo" id="port" name="blNo" 
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>

						</fieldset>
					</div>

	

				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						<button class="btn btn-success" title="Search" data-ng-click="search(discharge)">
								<i class="fa  fa-search"> </i> Search
							</button>
							<button class="btn btn-primary" title="Print Arrival Notice" data-ng-click="printArrival()">
								<i class="fa  fa-print"> </i> Arrival Notice
							</button>
						 	
							<!-- <button class="btn btn-primary" title="Send Mail Arrival Notice" data-ng-click="sendMailPrint(discharge.blNo)">
								<i class="fa fa-envelope"> </i> Send Mail
							</button> 
							<button class="btn btn-success" title="Send Mail Arrival Notice" data-ng-click="sendBulkMail()">
								<i class="fa fa-envelope"> </i> Send Bulk Mail
							</button>  -->
							<button class="btn btn-info"  type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							
						</div>
					</div>
				</div>
				<br>
				<div class="panel panel-default panel-default-list" st-table="listbl" st-safe-src="billoflad">
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
				<div class="panel-body">

				<div class="panel-body padding-0">
					<div class="table-responsive ">
						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dt_basic_info">
							<thead class="dataTables-Main-Head">
								<tr>
									<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAll()" ng-model="discharge.checkAll"> <i></i>
								</label></th>
									<th class="sorting txtUpperCs" st-sort="blno">BL No</th>									
									<th class="sorting txtUpperCs" st-sort="createdDate">ISSUE DATE</th>
								<!-- 	<th class="sorting txtUpperCs" st-sort="voyage">VOYAGE</th> -->
									<th class="sorting txtUpperCs" st-sort="pol">POL</th>
									<th class="sorting txtUpperCs" st-sort="pod">POD</th>
									<th class="sorting txtUpperCs" st-sort="eta">ETA DATE</th>	
									<th class="sorting txtUpperCs" st-sort="pol">CUSTOMER</th>	
									<th class="sorting txtUpperCs" st-sort="pol">CONSIGNEE</th>								
																
								<!-- <th class="text-center txtUpperCs">Action</th> -->	
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="item in listbl">
				
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="item.select" id="section{{trIndex}}">
											<i></i>
									</label></td>
									<td class="txtUpperCs"><span>{{item.blno}}</span></td>
									<td class="txtUpperCs"><span>{{item.createdDate}}</span></td>
									<!-- <td class="txtUpperCs"><span>{{item.voyage}}</span></td> -->
									<td class="txtUpperCs"><span>{{item.pol}}</span></td>
									<td class="txtUpperCs"><span>{{item.pod}}</span></td>
									<td class="txtUpperCs"><span>{{item.eta}}</span></td>
									<td class="txtUpperCs"><span>{{item.customer}}</span></td>
									<td class="txtUpperCs"><span>{{item.chargeName}}</span></td>
									
								<!-- <td>
								 	
							
							<span > <i class="fa fa-envelope red"
					              	data-toggle="tooltip" title="Send Mail" data-ng-click="sendMailPrint(item.blNo)"></i>
									</span>
									
							<span > <i class="fa  fa-print text-success text"
					              	data-toggle="tooltip" title="Print Arrival Notice" data-ng-click="printArrival()"></i>
									</span>
									<button class="btn btn-primary" title="Print Arrival Notice" data-ng-click="printArrival()">
								<i class="fa  fa-print"> </i> Arrival Notice
							</button>
							</td> -->
			

								</tr>
								<tr x-ng-show="showEmptyLabel">
									<td colspan="6" class="text-center">No Records Found</td>
								</tr>
							</tbody>
						</table>
					</div>
					<footer class="panel-footer panel-footer-list"
						style="padding: 0px;">
						<%@include file="/views/templates/panel-footer-static.jsp"%>
					</footer>
				</div>
			</div>
			</div>
			</div>
			</div>
				<!-- <div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="saveData()">
								<i class="fa fa-save"></i> Discharge
							</button>
							<button class="btn btn-success"  type="button" ng-if="isEdit"
								ng-click="update()">
								<i class="fa fa-save"></i> Discharge
							</button>
							<button class="btn btn-info" ng-if="!edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div> -->


			</form>

		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br> <br>
</div>
