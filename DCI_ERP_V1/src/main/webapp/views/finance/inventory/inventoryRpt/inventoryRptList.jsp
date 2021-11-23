<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
			    <div class id="panel-body">
			   		<form class="form-horizontal" name="invRprtForm" role="form" novalidate>
				      <div class="row padding-top-10">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-md-4">
						          	<div class="form-group">
										<label class="col-md-3 control-label">Item</label>
										<div class="col-md-6">
											<selectivity list="itemLists" property="inventoryModel.itemId" id="itemName"></selectivity>
										</div>
									</div>
			
				          		</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-md-3 control-label">Location</label>
										<div class="col-md-6">
											<selectivity list="locationLists" property="inventoryModel.locationId" id="locationName"></selectivity>
										</div>
									</div>
								</div>
				          		<div class="col-md-4">
					          		<div class="form-group">
										<div class="col-md-12">
											<button class="btn btn-success" ng-click="getInventoryReport();">
		            								<i class="fa fa-search"> </i>Submit
		           							</button>
			            				</div>
			           				</div>
				          		</div>
				          </div>
						</div>			
				      <div class="row padding-top-10">
						<div class="padding-top-5" id="jqgrid">
							<div id="inventGrid">
				  				<table id="grid"></table>
				  				<div id="inventorypage"></div>
			  				</div>
						</div>
					  </div>			
					  <div class="row padding-top-10">
					  		<div class="col-xs-5 col-xs-offset-9 padding-top-5">
				          	<div class="form-group">
								<label class="col-md-3 control-label">Total Qty</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm" data-ng-model="inventoryModel.totQty" id="totalQty" readonly="readonly">
								</div>
							</div>
							</div>
			       	</div>
			   		 </form>
			    </div>
	  		</div>
		</div>
	</div>
</div>