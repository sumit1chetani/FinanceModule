<!-- <div class="pageheader">
	<p class="description"></p>
	<div class="breadcrumb-wrapper hidden-xs">
		<span class="label">You are here:</span>
		<ol class="breadcrumb">
			<li>Customer</li>
			<li class="active">Add</li>
		</ol>
	</div>
</div> -->
<section id="main-content" class="animated fadeInRight">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default ">
				<div class="panel-body">
					<div class="tab-wrapper tab-primary">
						<div class="row">
							<div class="col-md-12">
								<div class="panel"> 
								 <style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style> 

<style type="text/css">

.nav-justified>li, .nav-tabs.nav-justified>li{background-color:#3B8A8A;}
.textareath{resize:vertical;max-height:124px;}
</style>
								
								<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		 <tabset justified="true" class="tab-container">
  <tab heading="{{tabs[0].title}}"> 
									<div class="panel-body">
										<div class="col-sm-12">
											<div class="col-sm-11 alert alert-success alert-dismissable"
												ng-if="thumbsAlert">
												<button ng-if="error" type="button" class="close"
													data-dismiss="alert" aria-hidden="true">×</button>
												{{successMsg}}
											</div>
											<div class="col-sm-11 alert alert-danger alert-dismissable"
												ng-if="error">
												<button ng-if="error" type="button" class="close"
													data-dismiss="alert" aria-hidden="true">×</button>
												{{errorMsg}}
											</div>
										</div>
										<form class="form-horizontal form-border" method="POST" name="trailerForm" novalidate">
											<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
						<div class="form-group">
													<label class="col-md-4 control-label">Trailer No
													</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="trailerNo" validation="required" friendly-name="Trailer No" form-name="trailerForm"
															ng-model="trailer.trailerNo" disabled="true">
													</div>
												</div>	
							
                                 <div class="form-group">
							<label class="col-md-4 control-label">Trailer Type
							</label>


							<div class="col-md-5">
								<select class="form-control input-sm"
									ng-options="wk.id as wk.text for wk in controllist"
									ng-model="trailer.trailerType"
									name="trailerType" 
									form-name="trailerForm" validation="required"
									friendly-name="trailerType" id="trailerType" disabled="true">
									<option value="">--Select--</option>
								</select>
							</div>
						</div>
								
							
															
							
					
																	<div class="form-group">
							<label class="col-md-4 control-label">Number of Axles
							</label>


							<div class="col-md-5">
								<select class="form-control input-sm"
									ng-options="wk.id as wk.text for wk in controllist1"
									ng-model="trailer.numberofAxles" name="numberofAxles" 
									
									form-name="trailerForm" validation="required"
									friendly-name="numberofAxles" id="numberofAxles" disabled="true"	>
									<option value="">--Select--</option>
								</select>
							</div>
						</div>
					
											
							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>	
						
												<div class="form-group">
													<label class="col-md-4 control-label">Capacity(Tonnes)
													</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="capacity" validation="required" friendly-name="Capacity" form-name="trailerForm"
															ng-model="trailer.capacity" disabled="true"	>
													</div>
												</div>	
								
						
								
								
								
															
						<div class="form-group">
													<label class="col-md-4 control-label">Remarks					</label>
													<div class="col-md-5">
														<textarea  type="text" class="form-control input-sm"
															name="remarks"  friendly-name="Remarks" form-name="trailerForm"
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="trailer.remarks" disabled="true"	>
															</textarea>
													</div>
												</div>

							</fieldset>
						</div>
					</div>
											<br>
											<div class="form-group" id="updateButtonId">
												<label class="col-sm-5 control-label"></label> 
												<div class="col-sm-4">
													
	

							
													<button class="btn btn-danger" type="button"
														ng-click="cancel()">
														<i class="fa fa-close"> </i> Cancel</button>
												</div>
											</div>
										</form>
									</div>
									</tab>
								<tab heading="{{tabs[1].title}}"  active="tabs[1].active "  ng-if="edit">
 <div class="panel-body"  ng-hide="isShow">
 <table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
     <tr>
								 <th class="sorting width_2" st-sort="customerName">Service Date</th>
								<th class="sorting width_3" st-sort="country">Nature Of Report</th>
								<th class="sorting width_3" st-sort="currency">Cost</th>
				
							</tr>
						</thead>
						
					</thead>
					
					
					<tbody class="dataTables-Main-Body">
					
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							 <td class="">{{objItem.serviceDate}}</td>
								<td class="">{{objItem.natureOfReport}}</td>
								<td class="">{{objItem.cost}}</td>
							
								<td class="td-actions text-center"><span
									class="edit-button  padding-right-5"
									data-ng-click="editRow(objItem)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span> <span class="delete-button"
									data-ng-click="deleteRow(objItem)"
									tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
								</span></td>
							</tr>
						</tbody>
				
				</table>
				
								</div>
								</tab> <tab heading="{{tabs[2].title}}" active="tabs[2].active"  ng-if="edit">
											<div class="panel-body" ng-hide="isShow">
												<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
												
												<table
													class="table table-striped table-hover dataTable no-footer">
													<thead class="dataTables-Main-Head">
													<thead>
														<tr>
															<th class="sorting width_2" st-sort="customerName">Trip ID
																</th>
							                         	<th class="sorting width_3" st-sort="country">Truck No
																
					                                   	<th class="sorting width_3" st-sort="country">Trailer No
										 						
															<th class="sorting width_3" st-sort="country">From Location
																 </th>
															<th class="sorting width_3" st-sort="currency">To Location</th>
															
		                                              	<th class="sorting width_3" st-sort="currency">ETD</th>
															
															
															<th class="sorting width_3" st-sort="currency">ETA</th>
															
									                    <th class="sorting width_3" st-sort="currency">Trip Start Date</th>
									                    
									                      <th class="sorting width_3" st-sort="currency">Driver Name</th>
															


														</tr>
													</thead>

													</thead>


													<tbody class="dataTables-Main-Body">

														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="collection in rowCollection track by $index">
															<td class="">{{collection.tripNo}}</td>
															<td class="">{{collection.truckNo}}</td>
															<td class="">{{collection.trailerNo}}</td>
											               	<td class="">{{collection.fromLocation}}</td>
											               <td class="">{{collection.toLocation}}</td>
											               <td class="">{{collection.etd}}</td>
											               <td class="">{{collection.eta}}</td>
											               <td class="">{{collection.tripStartDate}}</td>
											               <td class="">{{collection.driverName}}</td>

														</tr>
													</tbody>

												</table>
												</div>

											</div>
											</tab> 
											
											
											</tabset>								</div>
							</div>
						<!-- </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
 --> 