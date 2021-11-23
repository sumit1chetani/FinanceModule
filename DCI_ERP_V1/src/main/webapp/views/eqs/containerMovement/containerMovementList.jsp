<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.contMov
{
max-width:140% !important;
width:140% !important;
}
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 72%;
	position: absolute;
	top: 20%;
	left: 14%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}


.table-striped > tbody > tr:nth-child(odd) {
    background-color: #f1d445;
}

.table-striped > tbody > tr:nth-child(even) {
    background-color: #e6deb5;
}

.table>thead>tr>th {
    
    background: #0f3982 !important;
    color: #fff !important;
    }
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="containerMovementTable"
		st-table="displayedCollection" st-safe-src="detailList">
		<%@include file="/views/templates/panel-header.jsp"%>
		
 
<div class="wrapper-md">
<div class="panel panel-default panel-default-form ">
<%--  <div class="panel panel-default panel-default-form ">
		<%@include file="/views/layout/panel-header-form.jsp"%> --%>
  <div class="panel-body">
   <form name="containerMovementForm" method="post" class="form-horizontal" novalidate>
    <div class="row pl2pc pr10pc">
    
    
    
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label"><b>Booking No.</b></label>
       <div class="col-md-7">
    <selectivity list="bookingList" ng-model="containerMovement.bookingNo"
										property="containerMovement.bookingNo" id="bookingNo"
										name="bookingNo" form-name="containerMovementForm"
										friendly-name="bookingNo"></selectivity>
							
       </div>
      </div>
     </div>
     
     
     
      <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label"><b>BL No.</b></label>
       <div class="col-md-7">
    <selectivity list="blList" ng-model="containerMovement.blNo"
										property="containerMovement.blNo" id="blNo"
										name="blNo" form-name="containerMovementForm"
										friendly-name="blNo"></selectivity>
							
       </div>
      </div>
     </div>
     

     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label"><b>BL Container No.</b></label>
       <div class="col-md-7">
    <selectivity list="blContainerNumList" ng-model="containerMovement.blContainerNum"
										property="containerMovement.blContainerNum" id="blContainerNum"
										name="blContainerNum" form-name="containerMovementForm"
										friendly-name="blContainerNum"></selectivity>
							
       </div>
      </div>
     </div>
     
     
     
     </div>
     </div>
     <div class="panel-body">
     <div class="row pl2pc pr10pc">
     
     
       <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label"><b>Container No.</b></label>
       <div class="col-md-7">
    <selectivity list="containerNoList" ng-model="containerMovement.containerNum"
										property="containerMovement.containerNum" id="containerNum"
										name="containerNum" form-name="containerMovementForm"
										friendly-name="containerNum"></selectivity>
							
       </div>
      </div>
     </div>
     
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-5 control-label"><b>Container Status</b></label>
       <div class="col-md-7">
   <selectivity list="sequenceList"
										property="containerMovement.sequenceS" id="sequenceS"
										name="sequenceS" ng-model="containerMovement.sequenceS"
										validation="required" friendly-name="Sequence"
										form-name="containerMovementForm"></selectivity>
								</div>
							
       </div>
      </div>
     </div>
       <div class="col-md-4">
      <div class="form-group">
     
        	<button class="btn btn-success" type="button" 
							ng-click="search(containerMovement)">
							 Search
						</button>
						
						  </div>
     </div>
     
     
   <!--   <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-3 control-label"><b>Size/Type:</b></label>
       <div class="col-md-7">
      <label class="col-md-5 control-label"> {{containerMovement.containerType}} </label>
							
       </div>
      </div>
     </div> -->
     
    <!--  <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label"><b>ISO Code:</b></label>
       <div class="col-md-7">
   <label class="col-md-5 control-label">{{containerMovement.isoCode}} </label>
       </div>
      </div>
     </div> -->
     
     <!-- 
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label"><b>Lease Type:</b></label>
       <div class="col-md-5">
    <label class="col-md-14 control-label">{{containerMovement.leaseType}} </label>
							
       </div>
      </div>
     </div> -->
     
     </div>
    <div class="row pl2pc pr10pc">
   <!--  <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-3 control-label"><b>Owner:</b></label>
       <div class="col-md-7">
    <label class="col-md-10 control-label">{{containerMovement.owner}} </label>
							
       </div>
      </div>
     </div> -->
   <!--  <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label"><b>Agreement No:</b></label>
       <div class="col-md-4">
    <label class="col-md-7 control-label">{{containerMovement.agreementNo}} </label>
							
       </div>
      </div>
     </div> -->
    </div>
    
    </div>
   </form>
   </div>
   </div>
		<div class="table-responsive" >
				<table class="table table-striped table-hover dataTable no-footer contMov" >
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
						<th class="" style ="width:4%"  > S.No</th>
						<th class="" style ="width:6%"  > Container Number</th>
						<th class="" style ="width:6%"> Container Type</th>
						<th class="" style ="width:6%"  > Location</th>
						<th class=" " style ="width:9%"  >Movement Code</th>
						<th class=" " style ="width:9%"  >Movement Desc.</th>
						<th class=" " style ="width:5%"  >Sub Code</th>
						<th class=" " style ="width:9%"  >Status Date</th>
						<th class=" " style ="width:9%"  >Movement Date</th>
 						<th class="" style ="width:7%"   >Vessel</th>
 					    <th class="" style ="width:7%" >Voyage</th>
 					    <th class="" style ="width:4%"  >POL</th>
 					    <th class="" style ="width:4%"  >POD</th>
 					    <th class="" style ="width:5%"  >T'POD1</th>
 					    <th class="" style ="width:5%"  >T'POD2</th>
 					    <th class="" style ="width:5%" >T'POD3</th>
 					    <th class="" style ="width:4%"  >FPOD</th>
 					    <th class="" style ="width:8%"  >BL No.</th>
 					    <th class="" style ="width:8%"  >Booking No.</th>
 					    <th class="" style ="width:10%"  >Input By</th>
 					    <th class="" style ="width:13%" >Input Date</th>
 					    
 					    
							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">
	
	                     <td class="" data-toggle="tooltip" title="{{item.location}}">{{$index+1}}</td>
	                        <td class="" data-toggle="tooltip" title="{{item.depot}}">{{item.containerNo}}</td>
	                           <td class="" data-toggle="tooltip" title="{{item.depot}}">{{item.containerType}}</td>
                        <td class="" data-toggle="tooltip" title="{{item.depot}}">{{item.depot}}</td>
						<!-- <td class="sorting" data-toggle="tooltip" title="{{item.depot}}">{{item.depot}}</td> -->
		                <td class="" data-toggle="tooltip" title="{{item.movementCode}}">{{item.movementCode}}</td>
		                <td class="" data-toggle="tooltip" title="{{item.movementCode}}">{{item.status}}</td>
						<td class="" data-toggle="tooltip" title="{{item.subCode}}">{{item.subCode}}</td>
						
						<td class="" data-toggle="tooltip" title="{{item.statusDate}}">{{item.statusDate}}</td>
						<td class="" data-toggle="tooltip" title="{{item.statusDate}}">{{item.moveDate}}</td>
						<td class="" data-toggle="tooltip" title="{{item.vessel}}">{{item.vessel}}</td>
		                <td class="" data-toggle="tooltip" title="{{item.voyage}}">{{item.voyage}}</td>
						<td class="" data-toggle="tooltip" title="{{item.pol}}">{{item.pol}}</td>
						<td class="" data-toggle="tooltip" title="{{item.pol}}">{{item.pod}}</td>
						<td class="" data-toggle="tooltip" title="{{item.pod1}}">{{item.pod1}}</td>
						<td class="" data-toggle="tooltip" title="{{item.pod2}}">{{item.pod1}}</td>
		                <td class="" data-toggle="tooltip" title="{{item.pod3}}">{{item.pod3}}</td>
						<td class="" data-toggle="tooltip" title="{{item.fpod}}">{{item.fpod}}</td>
						
						<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item.blNo)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue">{{item.blNo}}</span>
		         					</a>
		         			</td>	
		         	
		         		<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBookingDetail(item.bookingNo)">
		             				<span tooltip="{{item.bookingNo}}" class="tool-tip-span font-blue">{{item.bookingNo}}</span>
		         					</a>
		         			</td>		
					 
 						<td class="sorting" data-toggle="tooltip" title="{{item.inputBy}}">{{item.inputBy}}</td>
						<td class="sorting" data-toggle="tooltip" title="{{item.inputDate}}">{{item.inputDate}}</td>
						
						
					<!-- 	<td>
					      
						 <bootstrapdatetimepicker  	property="item.inputDate" id="inputDate" name="inputDate"  ng-model="item.inputDate"  friendly-name="inputDate"
							   />
							
									
					    </td> -->
										
						</tr>
					</tbody> 

				</table>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
	</div>
	<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
</div>
</div>
