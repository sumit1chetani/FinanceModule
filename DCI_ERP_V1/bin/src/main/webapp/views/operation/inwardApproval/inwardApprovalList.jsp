<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
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
	width: 52%;
	height: 37%;
	position: absolute;
	top: 12%;
	left: 23%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}

.ngdialog.ngdialog-theme-default .ngdialog-content {
   
       width: 30% !important;
}

.icontable table,.icontable th,.icontable td{
border: 1px solid #a0adaf;
}

.printcol1{

    color:#0021ff !important;
 font-size: 13px;

}

.printcol2{

   color:brown !important;
font-size: 13px;
   
}

.printcol3{

color:#d80bc1 !important;
font-size: 13px;

}

.printcol4{
color:midnightblue; !important;
font-size: 13px;

}
.printcol5{
color:#043808; !important;
font-size: 13px;

}

.printcol6{
color:#227224; !important;
font-size: 13px;

}

.printcol7{
color:#d20d5e; !important;
font-size: 13px;

}

.icon-edit{
font-size: 13px;
}

.icon-flag{
font-size: 13px;
}

.fa-window-close{
font-size: 13px;
}
.table-responsive {
    min-height: .01%;
       overflow-x: visible !important;
}

</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
    padding: 6px 2px;
    font-size: 12px;

</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="deliverOrderTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		 <%-- <%@include file="/views/templates/panel-header.jsp"%>  --%>
 <security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" />
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>

  </div>
  <div class="col-md-6 text-right padding-right-0">
   <div class="row">
    <div class="col-md-6 p-r-3">
     
     <!-- <button class="btn btn-sm btn-success"  style ="color: #ffffff;background-color: #4f9fc5fc;" ng-click="add()" ng-hide="hideAddIcon">
      <span class="fa fa-plus" data-toggle="tooltip" title="Create new record"></span>
     </button> -->
   
    </div>
    <div class="col-md-6  p-l-0">
       <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
    </div>
   </div>
  </div>
 </div>
</div> 
<div class="panel-body padding-10">
    <div class="table-responsive" style=" border: 1px solid #CCC;">
   <!--    <div class="pull-right">
        <div class="col-md-12">
          <nav class="navbar">
            <input class="form-control  pull-center" placeholder="Search.." name="search" [(ngModel)]="filter">
          </nav>

        </div>
      </div>
      <div>
        <button type="button" class="btn btn-primary pull-right" data-ng-click="add();"><i class="fa fa-plus"></i></button>
<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive "> -->
			
			<style>

button.btn.btn-success.help-button {
    
    background-color: #ff0000c4 !important;
}

</style>
		<div class="panel panel-default panel-default-form ">
				<div class="panel-body">
					<form name="blListForm" method="post" class="form-horizontal"
						novalidate>
						<div class="row pl2pc pr10pc">

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel </label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="blSearch.vessel"
											friendly-name="vessel"
											property="blSearch.vessel" id="vessel" name="vessel" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage </label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="blSearch.voyage"
											 friendly-name="Voyage"
											property="blSearch.voyage" id="voyage" name="voyage" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">POL </label>
									<div class="col-md-7">
										<selectivity list="podList" ng-model="blSearch.pol"
											property="blSearch.pol" id="pol" name="pol"
											form-name="blListForm" friendly-name="pol"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">FPOD </label>
									<div class="col-md-7">
										<selectivity list="podList" ng-model="blSearch.fpod"
											property="blSearch.fpod" id="fpod" name="fpod"
											form-name="blListForm" friendly-name="fpod"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">BL No. </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="blNo" id="blNo" ng-model="blSearch.blNo"
											friendly-name="Bl No" />
									</div>
								</div>
							</div>

						<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">From Date </label>
									<div class="col-md-7">
										 <ng-bs3-datepicker data-ng-model="blSearch.dateFrom"
										id="dateFrom" name="dateFrom"  date-format="DD/MM/YYYY" 
										id="dateFrom"
											friendly-name="From Date"
											/>
									</div>
								</div>
							</div>
							
							
							
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">To Date </label>
									<div class="col-md-7">
										 <ng-bs3-datepicker data-ng-model="blSearch.dateTo"
										id="dateTo" name="dateTo"  date-format="DD/MM/YYYY" 
										id="dateTo"
											friendly-name="To Date"
											/>
									</div>
								</div>
							</div>
						
							

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 i-checks m-b-none"
										style="padding-left: 119px; padding-top: 6px;"> <input
										type="checkbox" ng-model="blSearch.checked"
										id="select{{trIndex}}" ng-change="check(blSearch.checked)">
										<i></i></label> <label class="col-md-5 control-label"
										style="padding-right: 80px;">Cancelled </label>

								</div>
							</div>
							
						</div>
						<!-- /row -->
						<div class="form-actions text-center">
							<div class="row ">
								<div class="col-md-offset-3 col-md-5">
									<!-- <button class="btn btn-success help-button" type="button" data-ng-click="tdsHelpVideo('BookingVideo.mp4','BookingVideo')">
<i class="fa fa-video-camera"></i>
Help Video
</button> -->
									<button class="btn btn-success help-button" type="button" data-ng-click="tdsHelpVideo('BL Help Video.mp4','BL Help Video')">
      								  <i class="fa fa-video-camera"></i>
       										 Help Video
      								 </button>

									<button class="btn btn-success" type="button"
										ng-click="getBlList()">
										<i class="fa fa-search"></i> Search
									</button>
									<button class="btn btn-info" type="button"
										data-ng-click="reset(blListForm)">
										<i class="fa fa-undo"></i> Reset
									</button>
									 
<%-- 									<security:authorize access="hasRole('${form_code}_${export}')">
 --%>									<button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/BLDetails.xls" download="BLDetails.xls"></a>																						
								       </button>
<%-- 								     </security:authorize>  
 --%>								     
								    
								    
								     
								       
									<!-- <button class="btn btn-primary" type="button"
										data-ng-click="exportExcel()">
										<span class="fa fa-file-excel-o"> Export Excel with
											details</span> <a id="Export" stype="display:none"
											href="filePath/BookingDetails.xls"
											download="BookingDetails.xls"></a>


									</button>

									<button class="btn btn-primary" type="button"
										data-ng-click="exportExcel1()">
										<span class="fa fa-file-excel-o"> Export Excel</span> <a
											id="newExport" stype="display:none"
											href="filePath/Booking.xls" download="Booking.xls"></a>


									</button> -->
								</div>
							</div>
						</div>
						
						
						
						<!-- <div class="row " style="margin-top: 15px;">
								<div class="col-md-12">
								
								<div class="col-md-3">
								<i class="fa fa-circle" aria-hidden="true" style="color: #17DDFC;"></i> <span style="color: #17DDFC;font-weight: bold;" > Ocean BL</span>
								</div>
								<div class="col-md-3">
								   <i class="fa fa-circle" aria-hidden="true" style="color: #DEA80E;"></i> <span style="color:  #DEA80E;font-weight: bold;" > Sea Way BL </span>
								</div>
								<div class="col-md-2">
								<i class="fa fa-circle" aria-hidden="true" style="color: #ff8fec;"></i> <span style="color: #ff8fec;font-weight: bold;" > RFS BL</span>
								</div>
								<div class="col-md-2">
								<i class="fa fa-circle" aria-hidden="true" style="color: #92DE0E;"></i> <span style="color: #92DE0E;font-weight: bold;" > BL Surrender</span> 
								</div>
								<div class="col-md-2">
								<i class="fa fa-circle" aria-hidden="true" style="color: #F1948A;"></i> <span style="color: #F1948A;font-weight: bold;" > T/S BL</span>
								</div>
								
						</div>
						</div> -->		
						
						
						
						
						
						
					</form>
				</div>
			</div>
		
		
			

        <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
          <tr>
              <th class="sorting text-center" style="width: 3%;" st-sort="blNo"> BL No.</th>
              <th class="sorting text-center" style="width: 3%;    display: none;" st-sort="jobNo"> Job No.</th>
              <th class="sorting text-center" style="width: 3%;" st-sort="bookingno">Booking No.</th>
               <th class="sorting" style="width: 9%;" st-sort="clientName"> Customer</th>
               <th class="sorting" style="width: 9%;" st-sort="carrier">Carrier</th>
             <!--  <th style="width: 8%;" st-sort="issuePlace"> Issue Place</th> -->
               <th class="sorting text-center" style="width: 1%;" st-sort="vessel">Vessel</th>
                <th class="sorting text-center" style="width: 4%;" st-sort="vslVoyage">Voyage</th>
              <th class="sorting text-center" style="width: 3%;" st-sort="pol"> POL</th>
              <th class="sorting text-center" style="width: 3%;" st-sort="pod"> POD</th>
              <th class="sorting text-center" style="width: 3%;" st-sort="pod"> Arrival Date</th>
              <th class="sorting text-center" style="width: 3%;" st-sort="fpod"> FPOD</th>
              <th class="sorting text-center" style="width: 7%;" st-sort="noBls">No. of BLs</th>
              <th class="sorting text-center" style="width: 8%;" st-sort="bltype">BL Type</th>
               <th class="sorting text-center" style="width: 8%;" st-sort="issueDate"> Issue Date</th>
                <th class="sorting text-center" style="width: 8%;" st-sort="surrenderDate"> Surrender Date</th> 
                 <th class="sorting text-center" style="width: 8%;" st-sort="ststus">Status</th> 
              <th class= "text-center" style="width: 5%;">Action</th>
            </tr>
          </thead>

          <tbody class="dataTables-Main-Body">
          
          
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection" >
							
			 				
             <!--  <td> {{item.blNo}}</td>  -->
              	<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item,item.inwardId)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue" ng-if="item.contType!='R40H' && item.haz!='true'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-green" ng-if="item.contType=='R40H'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-red" ng-if="item.haz=='true'">{{item.blNo}}</span>
		         					</a>
		        </td>		
              
            <td ng-if="item.blNo==='' || item.blNo===null" style=" display: none;">  <a ng-click="editCro(item.jobNo )" > 
		             <span tooltip="{{item.jobNo}}" class="tool-tip-span font-blue ">{{item.jobNo}}</span>
		         </a> </td> 
		        <td ng-if="item.blNo !='' && item.blNo !=null" style=" display: none;"> {{item.jobNo}} </td>
		        <td>{{item.bookingno}}</td>
		        <td>{{item.clientName}}</td><td>{{item.carrier}}</td>
             <!--  <td>{{item.issuePlace}}</td> -->
               <td>{{item.vessel}}</td>
                <td>{{item.vslVoyage}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td> <td>{{item.arrivalDate}}</td>
              <td>{{item.fpod}}</td>
              <td>{{item.noBls}}</td>
                <td ng-if='!item.typeOfBl'>Normal BL - OBL</td>
                 <td ng-if='item.typeOfBl'>{{item.typeOfBl}} - OBL</td>
                  <td>{{item.issueDate}}</td>
                    <td>{{item.surrenderDate}}</td> 
                    <td>{{item.status}}</td>
               <td class=" td-actions text-center"  ng-show="item.blNo !='' && item.blNo !=null">
               <span ng-if="item.status!='Approved'"> <i class="fa fa-check text-success text"
										data-toggle="tooltip" title="Edit"
										ng-click="editRow(item,item.inwardId)"></i>
									</span>
									 <span> 
               				 <i class="fa  fa-print text-primary text" title="Print" data-ng-click="printBLCopy(item,item.blNo)"></i>
			 					 </span>
               <%-- <table class ="icontable" style="width:100%;">
               <tr>
               
                 <security:authorize access="hasRole('${form_code}_${modify}')">
               <td>
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										ng-click="editRow(item,item.inwardId)"></i>
									</span>
									
									 </td>
				</security:authorize>
              <!--   <span >
                 <i class="icon-edit " data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i> 
                  
                
                </span> -->
                
               
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
                 <security:authorize access="hasRole('${form_code}_${print}')">
                <td>
  <span> 
               				 <i class="fa  fa-print text-primary text" title="Print" data-ng-click="printBLCopy(item,item.blNo)"></i>
			 					 </span>
 <!-- <button class="fa  fa-print text-primary text"  title="Print Original with Stationary" type="button" data-ng-click="printBLCopy(item.blNo)">
								        <span class="fa fa-file-print-o"></span> 
								         																						
								       </button> -->
                  <!-- <span> 
                  
         <i class=" icon-print-3 printcol1" title="Print Original with Stationary" data-ng-click="openBLPrint(item.blNo)"></i>
               
			  </span> --></td>
			  </security:authorize>
			    <security:authorize access="hasRole('${form_code}_${print}')">
                <!-- <td>
                 <span > 
               <i class="fa  fa-print text-primary text"  title="Print Original with Normal Paper" data-ng-click="printBLOriginal(item.blNo)"></i>
                 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span></td> -->
			   </security:authorize>
			  </tr>
			  
			  <tr>
			  <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			     <span> 
             <i class="fa  fa-print text-primary text" title="Print Copy" data-ng-click="printBLCopy(item.blNo)"></i>  
             
			  </span>
			  </td> -->
			   </security:authorize>
			   <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			   <span> 
			  
             <i class="fa  fa-print text-primary text" title="Print Copy with Stationary" data-ng-click="printBLCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td> -->
			  </security:authorize>
			  
			  <td>
			   <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
            <i class="icon-lock-open-1 printcol1" title="Unlock Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
			  </span>
			  </security:authorize>
			  </td>
			   
			  </tr>
			  <tr>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			  <td>
			
			   <span> 
               <i class=" icon-lock-open-filled printcol2" title="Unlock Original Normal" data-ng-click="unlockOg(item.blNo)"></i> 
			  </span>
			  
			  </td>
			  
			  <td>
			     <span> 
			     
             <i class="icon-lock-open-4 printcol3" title="Unlock Copy" data-ng-click="unlockCopy(item.blNo)"></i> 
			  </span>
			  
			  
			  </td>
			  
			  <td>
			     <span> 
			      
              <i class=" icon-lock-open-5 printcol4" title="Unlock Copy with Stationary" data-ng-click="unlockCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td>
			 </security:authorize>
			   
			  </tr>
			  
			  <tr>
			  <td>
			 <security:authorize access="hasRole('${form_code}_${surrender}')">
			   <span ng-if="item.surrenderPermission == 'Y'"> 
	          <i class="icon-flag"  data-ng-hide="item.blrelease== true" title="BL Surrender" data-ng-click="viewRemarks(item.blNo,item.pol,item.pod,item.fpod,item.fpodcode,item.vslVoyage,item.polcode)"></i> 
			  </span>
			  </security:authorize>
			  </td>
			    <td>
			     <security:authorize access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="item.cancel_by == null || item.cancel_by == ''">
										<i class="fa fa-window-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel BL"
										data-ng-click="cancelBl(item.blNo)"></i> 
									</span>
				</security:authorize>
			
			  
			  </td>
			  
			
			 <security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			   <span> 
			  
             <i class="icon-print-6 printcol5" title=" Print Consolidated with Stationary" data-ng-click="openConsolidatedPrint(item.blNo)"></i> 
			  </span>
			  </td>
			  </security:authorize>
			 
			 
			  
			
			 
			  </tr>
			  <tr>
			    <td>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
	            <i class="icon-lock-open-1 printcol6" title="Unlock Consolidated Original Stationary" data-ng-click="unlockConsolidatedOgs(item.blNo)"></i>
				  </span>
				 </security:authorize>
				  </td>
				  
				  	  <td>
			    <security:authorize access="hasRole('${form_code}_${sea_way}')"> 
			   <span> 
			   
	            <i class="fa fa-file-text printcol7" title="Convert Sea Waybill" data-ng-click="convertSWB(item.blNo)"></i>
				  </span>
				 </security:authorize>
				 </td>
				 
			    </tr>
			  
			
			  </table>
			 --%>
			  
			 
			  
			 <!--  <span> 
              <i class="fa  fa-print text-danger text" title="Print Arrival Notice" data-ng-click="printArrival(item.blNo)"></i>
			  </span> -->
<%-- 			   <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
 --%>			   
			   
			 
			  
			 
			 
			  
<%-- 			  </security:authorize>
 --%>			  <!-- <span> 
			  
			 <i class="fa  fa-envelope text-success text" data-toggle="tooltip" title="Email"
										data-ng-click="mailview(item.blNo)"></i>
			  
			    </span>  -->
			    
			
              </td>
              <td class=" td-actions text-center"  ng-show="item.blNo==='' || item.blNo===null"> 	</td>
             
              
            </tr>
            
            
            
           
            
            
            
            
            
            
            
           <%--  <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection"  ng-if="item.typeOfBl == 'Sea WayBill' && item.blrelease != true && item.pod == item.fpod && item.rfs != 'RFS'" style="background:#f9dd8e;">
							
			 				
             <!--  <td> {{item.blNo}}</td>  -->
              	<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item,item.inwardId)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue" ng-if="item.contType!='R40H' && item.haz!='true'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-green" ng-if="item.contType=='R40H'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-red" ng-if="item.haz=='true'">{{item.blNo}}</span>
		         					</a>
		        </td>		
              
            <td ng-if="item.blNo==='' || item.blNo===null" style=" display: none;">  <a ng-click="editCro(item.jobNo )" > 
		             <span tooltip="{{item.jobNo}}" class="tool-tip-span font-blue ">{{item.jobNo}}</span>
		         </a> </td> 
		        <td ng-if="item.blNo !='' && item.blNo !=null" style=" display: none;"> {{item.jobNo}} </td>
		        <td>{{item.bookingno}}</td>
		         <td>{{item.clientName}}</td>
             <!--  <td>{{item.issuePlace}}</td> -->
               <td>{{item.vessel}}</td>
                <td>{{item.vslVoyage}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td>
              <td>{{item.fpod}}</td>
              <td>{{item.noBls}}</td>
                
                 <td ng-if='item.typeOfBl'>{{item.typeOfBl}}</td>
                  <td>{{item.issueDate}}</td>
                    <td>{{item.surrenderDate}}</td>
               <td class=" td-actions text-center"  ng-show="item.blNo !='' && item.blNo !=null">
               <table class ="icontable" style="width:100%;">
               <tr>
               
               
              
                <!-- <span >
                 <i class="icon-edit " data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i> 
                  
                
                </span> -->
                  <security:authorize access="hasRole('${form_code}_${modify}')">
               <td>
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										ng-click="editRow(item,item.blNo)"></i>
									</span>
									 </td>
				</security:authorize>
               
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
                 <security:authorize access="hasRole('${form_code}_${print}')">
                <td>
                  <span> 
                  
         <i class=" icon-print-3 printcol1" title="Print" data-ng-click="openBLPrint(item.blNo)"></i>
               
			  </span></td>
			  </security:authorize>
 --%><%-- 			  <security:authorize access="hasRole('${form_code}_${print}')">
                <!-- <td>
                 <span > 
               <i class="fa  fa-print text-primary text" title="Print Original with Normal Paper" data-ng-click="printBLOriginal(item.blNo)"></i>
                 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span></td> -->
			  </security:authorize>
			  </tr>
			  
			  <tr>
			   <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			     <span> 
             <i class="fa  fa-print text-primary text" title="Print Copy" data-ng-click="printBLCopy(item.blNo)"></i>  
             
			  </span>
			  </td> -->
			   </security:authorize>
			    <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			   <span> 
			  
             <i class="fa  fa-print text-primary text" title="Print Copy with Stationary" data-ng-click="printBLCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td> -->
			  </security:authorize>
			  <td>
			   <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
            <i class="icon-lock-open-1 printcol1" title="Unlock Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
			  </span>
			   </security:authorize>
			  </td>
			 
			  </tr>
			  <tr>
			  <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			  <td>
			   <span> 
               <i class=" icon-lock-open-filled printcol2" title="Unlock Original Normal" data-ng-click="unlockOg(item.blNo)"></i> 
			  </span>
			  
			  </td>
			  
			  <td>
			     <span> 
			     
             <i class="icon-lock-open-4 printcol3" title="Unlock Copy" data-ng-click="unlockCopy(item.blNo)"></i> 
			  </span>
			  
			  
			  </td>
			  
			  <td>
			     <span> 
			      
              <i class=" icon-lock-open-5 printcol4" title="Unlock Copy with Stationary" data-ng-click="unlockCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td>
			 
			   </security:authorize>
			  </tr>
			  
			  <tr>
			  <td>
			   <security:authorize access="hasRole('${form_code}_${surrender}')">
			  <!--  <span ng-if="item.surrenderPermission == 'Y'">  -->
	          <i class="icon-flag"  data-ng-hide="item.blrelease== true" title="BL Surrender" data-ng-click="viewRemarks(item.blNo,item.pol,item.pod,item.fpod,item.fpodcode,item.vslVoyage,item.polcode)"></i> 
			  <!-- </span> -->
			  </security:authorize>
			  
			  </td>
			    <td>
			     <security:authorize access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="item.cancel_by == null || item.cancel_by == ''">
										<i class="fa fa-window-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel BL"
										data-ng-click="cancelBl(item.blNo)"></i> 
									</span>
</security:authorize>
			
			  
			  </td>
			  
			 
			 <security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			   <span> 
			  
             <i class="icon-print-6 printcol5" title=" Print Consolidated with Stationary" data-ng-click="openConsolidatedPrint(item.blNo)"></i> 
			  </span>
			  </td>
			  </security:authorize>
			
			 
			
			 
			  </tr>
			  
			  <tr>
			  
			    <td>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
	            <i class="icon-lock-open-1 printcol6" title="Unlock Consolidated Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
				  </span>
				 </security:authorize>
				  </td>
				  
				  
				  <td>
			    <security:authorize access="hasRole('${form_code}_${sea_way}')"> 
			   <span> 
			   
	            <i class="fa fa-file-text printcol7" title="Convert Sea Waybill" data-ng-click="convertSWB(item.blNo)"></i>
				  </span>
				 </security:authorize>
				 </td>
				  
				  
				  
			    </tr>
		
			  </table>
              </td>
              <td class=" td-actions text-center"  ng-show="item.blNo==='' || item.blNo===null"> 	</td>
             
              
            </tr>
            
            
            
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection"  ng-if="item.blrelease == true && item.rfs != 'RFS'" style="background:#d0fb83;">
							
			 				
             <!--  <td> {{item.blNo}}</td>  -->
              	<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item,item.inwardId)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue" ng-if="item.contType!='R40H' && item.haz!='true'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-green" ng-if="item.contType=='R40H'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-red" ng-if="item.haz=='true'">{{item.blNo}}</span>
		         					</a>
		        </td>		
              
            <td ng-if="item.blNo==='' || item.blNo===null" style=" display: none;">  <a ng-click="editCro(item.jobNo )" > 
		             <span tooltip="{{item.jobNo}}" class="tool-tip-span font-blue ">{{item.jobNo}}</span>
		         </a> </td> 
		        <td ng-if="item.blNo !='' && item.blNo !=null" style=" display: none;"> {{item.jobNo}} </td>
		        <td>{{item.bookingno}}</td>
		        <td>{{item.clientName}}</td>
             <!--  <td>{{item.issuePlace}}</td> -->
               <td>{{item.vessel}}</td>
                <td>{{item.vslVoyage}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td>
              <td>{{item.fpod}}</td>
              <td>{{item.noBls}}</td>
                
                 <td ng-if='!item.typeOfBl'>Normal BL - Surrender</td>
                 <td ng-if='item.typeOfBl'>{{item.typeOfBl}} - Surrender</td>
                  <td>{{item.issueDate}}</td>
                    <td>{{item.surrenderDate}}</td>
               <td class=" td-actions text-center"  ng-show="item.blNo !='' && item.blNo !=null">
                   <table class ="icontable" style="width:100%;">
               <tr>
               
               
              
             <!--    <span >
                 <i class="icon-edit " data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i> 
                  
                
                </span> -->
               <security:authorize access="hasRole('${form_code}_${modify}')">
               <td>
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										ng-click="editRow(item,item.blNo)"></i>
									</span>
									 </td>
				</security:authorize>
               
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
                 <security:authorize access="hasRole('${form_code}_${print}')">
                <td>
                  <span> 
                  
         <i class=" icon-print-3 printcol1" title="Print" data-ng-click="openBLPrint(item.blNo)"></i>
               
			  </span></td>
			  </security:authorize>
			   <security:authorize access="hasRole('${form_code}_${print}')">
                <!-- <td>
                 <span >
               <i class="fa  fa-print text-primary text" title="Print Original with Normal Paper" data-ng-click="printBLOriginal(item.blNo)"></i>
                 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span></td> -->
			   </security:authorize>
			  
			  </tr>
			  
			  <tr>
			   <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			     <span> 
             <i class="fa  fa-print text-primary text" title="Print Copy" data-ng-click="printBLCopy(item.blNo)"></i>  
             
			  </span>
			  </td> -->
			    </security:authorize>
			  <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			   <span> 
			  
             <i class="fa  fa-print text-primary text" title="Print Copy with Stationary" data-ng-click="printBLCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td> -->
			   </security:authorize>
			  <td>
			   <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
            <i class="icon-lock-open-1 printcol1" title="Unlock Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
			  </span>
			    </security:authorize>
			  </td>
			
			   
			  </tr>
			  <tr>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			  <td>
			   <span> 
               <i class=" icon-lock-open-filled printcol2" title="Unlock Original Normal" data-ng-click="unlockOg(item.blNo)"></i> 
			  </span>
			  
			  </td>
			  
			  <td>
			     <span> 
			     
             <i class="icon-lock-open-4 printcol3" title="Unlock Copy" data-ng-click="unlockCopy(item.blNo)"></i> 
			  </span>
			  
			  
			  </td>
			  
			  <td>
			     <span > 
			      
              <i class=" icon-lock-open-5 printcol4" title="Unlock Copy with Stationary" data-ng-click="unlockCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td>
			 
			   </security:authorize>
			  </tr>
			  
			  <tr>
			  <td>
			  
			  <security:authorize access="hasRole('${form_code}_${surrender}')">
			  <!--  <span ng-if="item.surrenderPermission == 'Y'">  -->
	          <i class="icon-flag"  data-ng-hide="item.blrelease== true" title="BL Surrender" data-ng-click="viewRemarks(item.blNo,item.pol,item.pod,item.fpod,item.fpodcode,item.vslVoyage,item.polcode)"></i> 
			  <!-- </span> -->
			  </security:authorize>
			  </td>
			    <td>
			     <security:authorize access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="item.cancel_by == null || item.cancel_by == ''">
										<i class="fa fa-window-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel BL"
										data-ng-click="cancelBl(item.blNo)"></i> 
									</span>
</security:authorize>
			
			  
			  </td>
			  
			
			 <security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			   <span> 
			  
        <i class="icon-print-6 printcol5" title=" Print Consolidated with Stationary" data-ng-click="openConsolidatedPrint(item.blNo)"></i> 
			  </span>
			  </td>
			  </security:authorize>
			
			 
			 
			  </tr>
			  
			  <tr>
			    <td>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
	            <i class="icon-lock-open-1 printcol6" title="Unlock Consolidated Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
				  </span>
				 </security:authorize>
				  </td>
				  
				    <td>
			    <security:authorize access="hasRole('${form_code}_${sea_way}')"> 
			   <span> 
			   
	            <i class="fa fa-file-text printcol7" title="Convert Sea Waybill" data-ng-click="convertSWB(item.blNo)"></i>
				  </span>
				 </security:authorize>
				 </td>
			    </tr>
		
			  </table>
              </td>
              <td class=" td-actions text-center"  ng-show="item.blNo==='' || item.blNo===null"> 	</td>
             
              
            </tr>
            
            
            
                
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection"  ng-if="item.pod != item.fpod && item.blrelease != true && item.rfs != 'RFS'" style="background:#ff9999fa;">
							
			 				
             <!--  <td> {{item.blNo}}</td>  -->
              	<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item,item.inwardId)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue" ng-if="item.contType!='R40H' && item.haz!='true'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-green" ng-if="item.contType=='R40H'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-red" ng-if="item.haz=='true'">{{item.blNo}}</span>
		         					</a>
		        </td>		
              
            <td ng-if="item.blNo==='' || item.blNo===null" style=" display: none;">  <a ng-click="editCro(item.jobNo )"> 
		             <span tooltip="{{item.jobNo}}" class="tool-tip-span font-blue ">{{item.jobNo}}</span>
		         </a> </td> 
		        <td ng-if="item.blNo !='' && item.blNo !=null" style=" display: none;"> {{item.jobNo}} </td>
		        <td>{{item.bookingno}}</td>
		        <td>{{item.clientName}}</td>
             <!--  <td>{{item.issuePlace}}</td> -->
               <td>{{item.vessel}}</td>
                <td>{{item.vslVoyage}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td>
              <td>{{item.fpod}}</td>
              <td>{{item.noBls}}</td>
               
                 <td ng-if='!item.typeOfBl'>Normal BL - T/S</td>
                 <td ng-if='item.typeOfBl'>{{item.typeOfBl}} - T/S</td>
                  <td>{{item.issueDate}}</td>
                    <td>{{item.surrenderDate}}</td>
               <td class=" td-actions text-center"  ng-show="item.blNo !='' && item.blNo !=null">
                 <table class ="icontable" style="width:100%;">
               <tr>
               
               
            <!--   
                <span >
                 <i class="icon-edit " data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i> 
                  
                
                </span> -->
                 <security:authorize access="hasRole('${form_code}_${modify}')">
               <td>
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										ng-click="editRow(item,item.blNo)"></i>
									</span>
									 </td>
				</security:authorize>
                
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
                 <security:authorize access="hasRole('${form_code}_${print}')">
                <td>
                  <span> 
                  
         <i class=" icon-print-3 printcol1" title="Print" data-ng-click="openBLPrint(item.blNo)"></i>
               
			  </span></td>
			  </security:authorize>
			   <security:authorize access="hasRole('${form_code}_${print}')">
                <!-- <td>
                 <span > 
               <i class="fa  fa-print text-primary text" title="Print Original with Normal Paper" data-ng-click="printBLOriginal(item.blNo)"></i>
                 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span></td> -->
			  </security:authorize>
			  
			  </tr>
			  
			  <tr>
			   <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			     <span> 
             <i class="fa  fa-print text-primary text" title="Print Copy" data-ng-click="printBLCopy(item.blNo)"></i>  
             
			  </span>
			  </td> -->
			  </security:authorize>
			    <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			   <span> 
			  
             <i class="fa  fa-print text-primary text" title="Print Copy with Stationary" data-ng-click="printBLCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td> -->
			  </security:authorize>
			  <td>
			   <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
            <i class="icon-lock-open-1 printcol1" title="Unlock Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
			  </span>
			   </security:authorize>
			  </td>
			   
			  </tr>
			  <tr>
			   <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			  <td>
			   <span> 
               <i class=" icon-lock-open-filled printcol2" title="Unlock Original Normal" data-ng-click="unlockOg(item.blNo)"></i> 
			  </span>
			  
			  </td>
			  
			  <td>
			     <span> 
			     
             <i class="icon-lock-open-4 printcol3" title="Unlock Copy" data-ng-click="unlockCopy(item.blNo)"></i> 
			  </span>
			  
			  
			  </td>
			  
			  <td>
			     <span> 
			      
              <i class=" icon-lock-open-5 printcol4" title="Unlock Copy with Stationary" data-ng-click="unlockCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td>
			  </security:authorize>
			  
			  </tr>
			  
			  <tr>
			  <td>
			  
			  <security:authorize access="hasRole('${form_code}_${surrender}')">
			  <!--  <span ng-if="item.surrenderPermission == 'Y'">  -->
	          <i class="icon-flag"  data-ng-hide="item.blrelease== true" title="BL Surrender" data-ng-click="viewRemarks(item.blNo,item.pol,item.pod,item.fpod,item.fpodcode,item.vslVoyage,item.polcode)"></i> 
			  <!-- </span> -->
			  </security:authorize>
			  
			  </td>
			    <td>
			     <security:authorize access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="item.cancel_by == null || item.cancel_by == ''">
										<i class="fa fa-window-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel BL"
										data-ng-click="cancelBl(item.blNo)"></i> 
									</span>
</security:authorize>
			
			  
			  </td>
			  
			
			 <security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			   <span> 
			  
              <i class="icon-print-6 printcol5" title=" Print Consolidated with Stationary" data-ng-click="openConsolidatedPrint(item.blNo)"></i> 
			  </span>
			  </td>
			  </security:authorize>
			
			 
			
			 
			  </tr>
			  
			  <tr>
			    <td>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
	            <i class="icon-lock-open-1 printcol6" title="Unlock Consolidated Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
				  </span>
				 </security:authorize>
				  </td>
				  
				    <td>
			    <security:authorize access="hasRole('${form_code}_${sea_way}')"> 
			   <span> 
			   
	            <i class="fa fa-file-text printcol7" title="Convert Sea Waybill" data-ng-click="convertSWB(item.blNo)"></i>
				  </span>
				 </security:authorize>
				 </td>
				 
			    </tr>
			  </table>
              </td>
              <td class=" td-actions text-center"  ng-show="item.blNo==='' || item.blNo===null"> 	</td>
             
              
            </tr>
            
            
            
            
                   
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection"  ng-if=" item.rfs == 'RFS'" style="background:#ffbbf3e3;">
							
			 				
             <!--  <td> {{item.blNo}}</td>  -->
              	<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item,item.inwardId)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue" ng-if="item.contType!='R40H' && item.haz!='true'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-green" ng-if="item.contType=='R40H'">{{item.blNo}}</span>
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-red" ng-if="item.haz=='true'">{{item.blNo}}</span>
		         					</a>
		        </td>		
              
            <td ng-if="item.blNo==='' || item.blNo===null" style=" display: none;">  <a ng-click="editCro(item.jobNo )"> 
		             <span tooltip="{{item.jobNo}}" class="tool-tip-span font-blue ">{{item.jobNo}}</span>
		         </a> </td> 
		        <td ng-if="item.blNo !='' && item.blNo !=null" style=" display: none;"> {{item.jobNo}} </td>
		        <td>{{item.bookingno}}</td>
		        <td>{{item.clientName}}</td>
             <!--  <td>{{item.issuePlace}}</td> -->
               <td>{{item.vessel}}</td>
                <td>{{item.vslVoyage}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td>
              <td>{{item.fpod}}</td>
              <td>{{item.noBls}}</td>
                
                 <td ng-if='!item.typeOfBl'>Normal BL - RFS</td>
                 <td ng-if='item.typeOfBl'>{{item.typeOfBl}} - RFS</td>
                  <td>{{item.issueDate}}</td>
                    <td>{{item.surrenderDate}}</td>
               <td class=" td-actions text-center"  ng-show="item.blNo !='' && item.blNo !=null">
                     <table class ="icontable" style="width:100%;">
               <tr>
               
               
               
               
               
               
            
               
               <security:authorize access="hasRole('${form_code}_${modify}')">
               <td>
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										ng-click="editRow(item,item.blNo)"></i>
									</span>
									 </td>
				</security:authorize>
              
                <!-- <span >
                 <i class="icon-edit " data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i> 
                  
                
                </span> -->
               
                
                
                
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
                 <security:authorize access="hasRole('${form_code}_${print}')">
                <td>
                  <span> 
                  
         <i class=" icon-print-3 printcol1" title="Print" data-ng-click="openBLPrint(item.blNo)"></i>
               
			  </span></td>
			  </security:authorize>
			  <security:authorize access="hasRole('${form_code}_${print}')">
			  
                <!-- <td>
                 <span > 
               <i class="fa  fa-print text-primary text" title="Print Original with Normal Paper" data-ng-click="printBLOriginal(item.blNo)"></i>
                 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span></td> -->
			    </security:authorize>
			  
			  </tr>
			  
			  <tr>
			   <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			     <span> 
             <i class="fa  fa-print text-primary text" title="Print Copy" data-ng-click="printBLCopy(item.blNo)"></i>  
             
			  </span>
			  </td> -->
			   </security:authorize>
			  <security:authorize access="hasRole('${form_code}_${print}')">
			  <!-- <td>
			   <span> 
			  
             <i class="fa  fa-print text-primary text" title="Print Copy with Stationary" data-ng-click="printBLCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td> -->
			  </security:authorize>
			  <td>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
            <i class="icon-lock-open-1 printcol1" title="Unlock Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
			  </span>
			 </security:authorize>
			  </td>
			   
			  </tr>
			  <tr>
			  <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			  <td>
			   <span> 
               <i class=" icon-lock-open-filled printcol2" title="Unlock Original Normal" data-ng-click="unlockOg(item.blNo)"></i> 
			  </span>
			  
			  </td>
			  
			  <td>
			     <span> 
			     
             <i class="icon-lock-open-4 printcol3" title="Unlock Copy" data-ng-click="unlockCopy(item.blNo)"></i> 
			  </span>
			  
			  
			  </td>
			  
			  <td>
			     <span> 
			      
              <i class=" icon-lock-open-5 printcol4" title="Unlock Copy with Stationary" data-ng-click="unlockCopyWithStationary(item.blNo)"></i> 
			  </span>
			  </td>
			 </security:authorize>
			  
			  </tr>
			  
			  <tr>
			  <td>
			  <security:authorize access="hasRole('${form_code}_${surrender}')">
			  <!--  <span ng-if="item.surrenderPermission == 'Y'">  -->
	          <i class="icon-flag"  data-ng-hide="item.blrelease== true" title="BL Surrender" data-ng-click="viewRemarks(item.blNo,item.pol,item.pod,item.fpod,item.fpodcode,item.vslVoyage,item.polcode)"></i> 
			  <!-- </span> -->
			  </security:authorize>
			  </td>
			    <td>
			     
									<span
										ng-if="item.cancel_by == null || item.cancel_by == ''">
										<i class="fa fa-window-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel BL"
										data-ng-click="cancelBl(item.blNo)"></i> 
									</span>
 
			
			  
			  </td>
			  
			 
			 <security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			   <span> 
			  
             <i class="icon-print-6 printcol5" title=" Print Consolidated with Stationary" data-ng-click="openConsolidatedPrint(item.blNo)"></i> 
			  </span>
			  </td>
			  </security:authorize>
			  
			  
			  </tr>
			  
			    <tr>
			    <td>
			    <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   <span> 
			   
	            <i class="icon-lock-open-1 printcol6" title="Unlock Consolidated Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
				  </span>
				 </security:authorize>
				  </td>
				  
				    <td>
			    <security:authorize access="hasRole('${form_code}_${sea_way}')"> 
			   <span> 
			   
	            <i class="fa fa-file-text printcol7" title="Convert Sea Waybill" data-ng-click="convertSWB(item.blNo)"></i>
				  </span>
				 </security:authorize>
				 </td>
			    </tr>
			    
			  </table>
              </td>
              <td class=" td-actions text-center"  ng-show="item.blNo==='' || item.blNo===null"> 	</td>
             
              
            </tr>
            
             --%>
            
            
          </tbody>
        </table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			</div>
      </div>
      <br>
      <br>
    </div>
</body>
</html>
<script type="text/ng-template" id="deliveryOrderpop"> 
<div class="model-header"></div>
					<legend>BL Surrender</legend>
		<form class="" method="POST" name="blForm1" novalidate>

<div class="col-sm-12 col-md-12 col-lg-12 ">
                         
						
					<div class="col-sm-8 col-md-8 col-lg-8 " style="padding-left: 189px;">
							<div class="form-group">
							<label class="control-label">BL Surrender Remarks  </label>
									<textarea class="form-control" type="text" name="blreleaseremeraks" ng-disabled="blNoData.blrelease ===false "
											id="blreleaseremeraks" ng-model="blNoData.blreleaseremeraks" form-name="blForm1" ></textarea>
						</div>
						</div>	

					</div>
<div class="model-footer" style="padding-left:35%;padding-top:17%">
<button type="button" class="btn btn-success"
						ng-click="saveData(blForm1)">Update</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
		</div>
	</div>
</form
</div>



    </script> 
    
    
    
<script type="text/ng-template" id="BlCancelPopup"> 
<div class="model-header"></div>
<legend>Cancel BL</legend>
<form class="" method="POST" name="blCancelForm" novalidate>

<div class="col-sm-12 col-md-12 col-lg-12 ">


<div class="col-sm-6 col-md-6 col-lg-6 ">
<div class="form-group">
<label class="control-label">BL Cancel Reason</label>
<textarea class="form-control" type="text" name="blCancelreason" 
id="blCancelreason" ng-model="bl.blCancelreason" form-name="blCancelForm" style="margin-top: 0px;margin-bottom: 0px;height: 120px;width: 140%;"></textarea>
</div>
</div>	

</div>
<div class="model-footer" style="padding-left:35%;padding-top:17%">
<button type="button" class="btn btn-success"
ng-click="saveData(blCancelForm)">Confirm Cancel BL</button>
<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
</div>
</div>
</form
</div>

</script>


<script type="text/ng-template" id="BLPrint">
<div class="modal-header" style="text-align: center;
    font-size: 17px;
    color: white;
    background-color: #08082c;border-radius: 5px 5px 0px 0px;">Check Serial Number</div>
<div>

 <div class="row"  style="margin:0px;    margin-top: 15px; margin-bottom:15px" >
 <div class="col-sm-12 col-md-12 col-lg-12 ">

<div class="form-group">
<label class="col-md-3 control-label" style="margin-left: -10px;">Serial No</label>
<div class="col-md-8"><input type="number" class="form-control input-sm" name="blSerialNo" style="text-align: left;" id="blSerialNo" ng-model="blInventroy" ></div>
</div>
</div>
<br>
<br>
<br>
<div class="form-group">
<label class="col-md-3 control-label">Location</label>
<div class="col-md-8"><selectivity list="portList" ng-model="blLocation" property="blLocation" id="location"
name="location" form-name="BLInventoryForm" friendly-name="location"></selectivity></div>
</div>
</div>

 </div>



  <div class="modal-footer" style="    text-align: center;">
   <button class="btn btn-info" type="button" ng-click="CheckBLNumber(blLocation,blInventroy)">Check Serial No</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	
  </div>
 </script>
 
 
 <script type="text/ng-template" id="ConsolidatedBLPrint">
<div class="modal-header" style="text-align: center;
    font-size: 17px;
    color: white;
    background-color: #08082c;border-radius: 5px 5px 0px 0px;">Check Serial Number</div>
<div>

 <div class="row"  style="margin:0px;    margin-top: 15px; margin-bottom:15px" >
 <div class="col-sm-12 col-md-12 col-lg-12 ">

<div class="form-group">
<label class="col-md-3 control-label" style="margin-left: -10px;">Serial No</label>
<div class="col-md-8"><input type="text" class="form-control input-sm" name="blSerialNo" style="text-align: left;" id="blSerialNo" ng-model="blInventroy" ></div>
</div>
</div>
<br>
<br>
<br>
<div class="form-group">
<label class="col-md-3 control-label">Location</label>
<div class="col-md-8"><selectivity list="portList" ng-model="blLocation" property="blLocation" id="location"
name="location" form-name="BLInventoryForm" friendly-name="location"></selectivity></div>
</div>
</div>

 </div>



  <div class="modal-footer" style="    text-align: center;">
   <button class="btn btn-info" type="button" ng-click="CheckConsolidatedBLNumber(blLocation,blInventroy)">Check Serial No</button>
   <button class="btn btn-danger" ng-click="closeConsolFileDialog()">Cancel</button>
	
  </div>
 </script>
 
 

