<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="containerBankForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-2 control-label">From Depot<span
										style="color: red;">*</span></label>
									<div class="col-md-4 inputGroupContainer">

											<div class="col-md-7" >
										<selectivity list="portList1" ng-model="containerBankobj.fromPort"
										    friendly-name="fromPort"
											property="containerBankobj.fromPort" id="fromPort" name="fromPort" 
											form-name="containerBankForm"></selectivity>
									</div>

									</div>
							

							
									<div class="form-group">
									<label class="col-md-2 control-label">To Depot<span
										style="color: red;">*</span></label>
									<div class="col-md-4 inputGroupContainer">

											<div class="col-md-7" >
										<selectivity list="portList1" ng-model="containerBankobj.toPort"
										    friendly-name="toPort"
											property="containerBankobj.toPort" id="toPort" name="toPort" 
											form-name="containerBankForm"></selectivity>
									</div>

									</div>
								</div>
								
									</div>

							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								
								
							<button class="btn btn-success" 
								ng-click="move(containerBankobj)">
								<i class="fa fa-save"></i> Move
							</button>

							</fieldset>
						</div>
					</div>

				</div>
				<!-- /row -->
				<br>
				
				<div class="panel-body float-left padding-0" style="width: 100%;">
		
			<!-- <div class="table-responsive "> -->
			<table class="table table-striped table-hover dataTable no-footer">
				
				<thead class="dataTables-Main-Head">
					<tr>
						<th class="width_1" >  </th>
					<!-- 	<th class="width_2" >Container Id</th> -->
						<th class="width_2" >Container Type</th>
						<th class="width_2" >Container Number</th>
						<th class="width_2" >Port</th>
					    <th class="width_2">Pay Load</th>
						<th class="width_2">Is Soc</th>
						
					</tr>

				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="(trIndex, collection) in containerBankobj.containerList">
						
					<td><input type="checkbox" checked="checked"
							 ng-model="collection.select"></td>
						<!-- <td>{{collection.containerId}}</td> -->
						<td>{{collection.cntrType}}</td>
						
						<td>{{collection.containerNo}}</td>
							<td>{{collection.port1}}</td>
						
						<td class="wrapping" data-toggle="tooltip"
												title="{{collection.payLoad}}">{{collection.payLoad}}</td>
						
						<td><input type="checkbox" checked="checked"
							disabled="disabled" ng-model="collection.soc"></td>
							
						
					</tr>
				</tbody>
			</table>
		
		<%-- 	<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer> --%>
		</div>
				<br>
					<br>
					<br>
					<br>
					<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
						

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

