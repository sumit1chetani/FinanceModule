<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 96%;
	position: absolute;
	top: 20%;
	left: 2%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
<div class="panel-body" style="background: #2d89c5bf;color: #fff;">
   <div class="row pl2pc pr10pc" >

     <div class="col-md-6">
      <div class="form-group">
       <div class="col-md-12">
<label class="col-md-5 control-label"><b> </b></label><span > </span>
							
       </div>
      </div>
     </div>
     <div class="col-md-6">
      <div class="form-group">
       <div class="col-md-12">
<label class="col-md-5 control-label"><b> </b></label><span > </span>							
       </div>
      </div>
     </div>
     <div class="col-md-6">
      <div class="form-group">
       <div class="col-md-12">
<label class="col-md-5 control-label"><b></b></label><span ></span>							
       </div>
      </div>
     </div>
     <div class="col-md-6">
      <div class="form-group">
       <div class="col-md-7">
       </div>
      </div>
     </div>
 </div>   <div class="ngdialog-close"></div></div>

<div class="wrapper-md">
	<div class="panel-body float-left padding-10" style="width: 100%;margin-top: 3%;">
	<tabset justified="true" class="tab-container">
	 <tab heading="Shipment Allocated Containers" style=" background: #a8ccce;">
	 <div class="panel panel-default panel-default-list" 
		st-table="displayedCollection1" st-safe-src="shipmentContainerList">
			 <div class="table-responsive" " border: 2px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>				
                           <th class="width_16">Booking No.</th>
                            <th class="width_16">CRO No.</th>
                           <th class="width_16">Job No.</th>
                           <th class="width_16">BL No.</th>
                           <th class="width_16">Container Number</th>
 						   <th class="width_14">Container Type</th>
 							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="(trIndex,item) in displayedCollection1">
							
							<td class="sorting" data-toggle="tooltip"
												title="{{item.bookingNo}}">{{item.bookingNo}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.croNo}}">{{item.croNo}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.jobNo}}">{{item.jobNo}}</td>
						     <td class="sorting" data-toggle="tooltip"
												title="{{item.blNo}}">{{item.blNo}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.containerNo}}">{{item.containerNo}}</td>
                            <td class="sorting" data-toggle="tooltip"
												title="{{item.containerType}}">{{item.containerType}}</td>
						</tr>
</tbody>
				</table>
			</div> 
			</div>
			</tab>
			 <tab heading="Gate-Out Containers Without Shipment" style=" background: #a8ccce;">
			 <div class="panel panel-default panel-default-list" 
		st-table="displayedCollect" st-safe-src="gateoutList">
			 <div class="table-responsive" " border: 2px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>				
                           <th class="width_16">Booking No.</th>
                            <th class="width_16">CRO No.</th>
                           <th class="width_16">Gate Out No.</th>
                            <th class="width_16">Container Number</th>
 						   <th class="width_14">Container Type</th>
 							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="(trIndex,item) in displayedCollect">
							
							<td class="sorting" data-toggle="tooltip"
												title="{{item.bookingNo}}">{{item.bookingNo}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.croNo}}">{{item.croNo}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.gateOutNo}}">{{item.gateOutNo}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.containerNo}}">{{item.containerNo}}</td>
                            <td class="sorting" data-toggle="tooltip"
												title="{{item.containerType}}">{{item.containerType}}</td>
						</tr>
</tbody>
				</table>
			</div> 
			</div>
			 </tab>
			</tabset>
		</div>
		<br>
		<br>
		<!-- <div class="model-footer" style="padding-left:47%" >
			<button class="btn btn-danger" align="center" ng-click="noCnfrm()"><i class="fa fa-close"></i>Cancel</button>
		</div> -->
		
	</div>
</div>

