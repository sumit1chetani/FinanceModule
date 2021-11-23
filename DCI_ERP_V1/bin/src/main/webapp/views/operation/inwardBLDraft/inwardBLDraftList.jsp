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

/* .ngdialog.ngdialog-theme-default .ngdialog-content {
   
       width: 30% !important;
} */

button.btn.btn-success.help-button {
    
    background-color: #ff0000c4 !important;
}


.ngdialog.ngdialog-theme-default .ngdialog-content {
    -webkit-animation: ngdialog-flyin .5s;
    animation: ngdialog-flyin .5s;
    background: #f0f0f0;
    border-radius: 5px;
    color: #181818;
    /* font-family: 'Helvetica',sans-serif; */
    font-family: 'Open Sans';
    font-size: 13px;
    line-height: 19px;
    margin: 0 auto;
    max-width: 100%;
    padding: 1em;
    position: relative;
    /* width: 438px; */
    width: 52%;
}
.icontable table,.icontable th,.icontable td{
border: 1px solid #a0adaf;
font-size:13px !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="BLDraftTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" />
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${upload}')" var="isUpload" />
<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
<security:authorize access="hasRole('${form_code}_${export}')" var="isExport" />
<security:authorize access="hasRole('${form_code}_${mail}')" var="isMail" />
<security:authorize access="hasRole('${form_code}_${bulkMail}')" var="isBulkMail" />
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>
   
  </div>
  <div class="col-md-6 text-right padding-right-0">
   <div class="row">
    <div class="col-md-6 p-r-3">
     
     <button class="btn btn-sm btn-success"  style ="color: #ffffff;background-color: #1f3113;" ng-click="add()" >
      <span class="fa fa-plus" data-toggle="tooltip" title="Create new record"></span>
     </button>
   
    </div>
    <div class="col-md-6  p-l-0">
    <%-- ${isSearch} --%>
     <c:choose>
      <c:when test="true">
       <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
      </c:when>
      <c:otherwise>
       <input type="text" disabled="disabled" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
      </c:otherwise>
     </c:choose>
    </div>
   </div>
  </div>
 </div>
</div>		
  <div class="panel-body padding-10">
    <div class="table-responsive" style=" border: 1px solid #CCC;">
   
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
										<selectivity list="polList" ng-model="blSearch.pol"
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
									<security:authorize access="hasRole('${form_code}_${export}')">
								 <button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/BLDetails.xls" download="BLDetails.xls"></a>																						
								       </button> 
								     </security:authorize>  
								       
								       
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
					</form>
				</div>
			</div>
		
		
			

        <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
            <tr>
              <th class="sorting" style="width: 10%;" st-sort="blNo"> BL No.</th>
              <th class="sorting" style="width: 10%;" st-sort="jobNo"> Job No.</th>
              <th class="sorting" style="width: 9%;" st-sort="bookingno"> Booking No.</th>
              <th class="sorting" style="width: 9%;" st-sort="clientName"> Customer</th>
             <!--  <th style="width: 8%;" st-sort="issuePlace"> Issue Place</th> -->
               <th class="sorting" style="width: 8%;" st-sort="vessel">Vessel</th>
                <th class="sorting" style="width: 8%;" st-sort="vslVoyage">Voyage</th>
              <th  class="sorting" style="width: 8%;" st-sort="pol">POL</th>
              <th class="sorting" style="width: 8%;" st-sort="pod">POD</th>
              <th class="sorting" style="width: 10%;" st-sort="fpod">FPOD</th>
              <th class="sorting" style="width: 7%;" st-sort="noBls"> No. of BLs</th>
              <th class="sorting" style="width: 8%;" st-sort="bltype"> BL Type</th> 
              <th  style="width: 11%;">Action</th>
            </tr>
          </thead>

          <tbody class="dataTables-Main-Body">
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection">
             <!--  <td> {{item.blNo}}</td> -->
             	<td ng-style="{'color': item.fontColor,'background-color':item.bgColor}" >
									<a ng-click="viewBlDetail(item.blNo)">
		             				<span tooltip="{{item.blNo}}" class="tool-tip-span font-blue">{{item.blNo}}</span>
		         					</a>
		        </td>	
            <td ng-if="item.blNo==='' || item.blNo===null">  <a ng-click="editCro(item.jobNo )"> 
		             <span tooltip="{{item.jobNo}}" class="tool-tip-span font-blue ">{{item.jobNo}}</span>
		         </a> </td> 
		        <td ng-if="item.blNo !='' && item.blNo !=null"> {{item.jobNo}} </td>
		        <td>{{item.bookingno}}</td>
		        <td>{{item.clientName}}</td>
             <!--  <td>{{item.issuePlace}}</td> -->
               <td>{{item.vessel}}</td>
                <td>{{item.vslVoyage}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td>
              <td>{{item.fpod}}</td>
              <td>{{item.noBls}}</td>
                <td>{{item.bltype}}</td>
               <td class=" td-actions text-center"  ng-show="item.blNo !='' && item.blNo !=null">
               
               <table class ="icontable" style="width:120%;">
               <tr>
               
               
                 <security:authorize access="hasRole('${form_code}_${modify}')">
	               <td>
										<span> <i class="icon-edit text-success text"
											data-toggle="tooltip" title="Edit"
											ng-click="editRow(item.blNo)"></i>
										</span>
					</td>
				</security:authorize>
               
               <!-- <td>
                <span>
                <i class="icon-edit " data-toggle="tooltip" style="color: #e9680d;" title="Edit" ng-click="editRow(item.blNo)"></i> 
                  <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i>
               &nbsp;&nbsp;
                </span>
                </td> -->
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
                
                  <!-- <span> 
              <i class="fa  fa-print text-warning text" title="Print Original with Stationary" data-ng-click="printBLOriginalStationary(item.blNo)"></i>
			  </span>&nbsp;&nbsp; -->
                
                <!--  <span> 
                 <i class="fa  fa-print text-success text" title="Print Original with Normal Paper" data-ng-click="openBLPrint(item.blNo)"></i>
                 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span>&nbsp;&nbsp; -->
			
			<security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			   <span> 
<!--               <i class="fa  fa-print text-primary text" title="BL Print Draft" data-ng-click="printBLCopy(item.blNo)"></i> &nbsp;&nbsp;
 -->                <i class=" icon-print-3 printcol1" style="color: #2039b1;" title="BL Print Draft" data-ng-click="printBLCopy(item.blNo)"></i>
			  </span>
			  </td>
			  	</security:authorize>
			  
			  <security:authorize access="hasRole('${form_code}_${print}')">
			  <td>
			  <span>
<!-- 			    <i class="fa  fa-print text-primary text" title="Print Proforma Invoice" data-ng-click="printBLInvoice(item.blNo)"></i> &nbsp;&nbsp;
 -->			    <i class="icon-print-4 printcol2" style="color: #fb00d1;" title="Print Proforma Invoice" data-ng-click="printBLInvoice(item.blNo)"></i>
			  </span>
			  </td>
			  </security:authorize>
			   
			  </tr>
			  
			  <tr>
			  
			  <td>
			   <span> 
<!--               <i class="fa fa-envelope red" title="Draft BL and Invoice Mail" data-ng-click="sendMailprint(item.blNo)"></i> &nbsp;&nbsp; 
 -->              <i class="fa fa-envelope red "  style = "color: #353b64;" title="Draft BL and Invoice Mail" data-ng-click="sendMailprint(item.blNo)"></i>
			  </span>
			  </td>
			
			  
		<!-- 	  <span> 
              <i class="fa fa-envelope red" title="Draft BL Mail" data-ng-click="sendBLDraftMailprint(item.blNo)"></i> 
			  </span>&nbsp;&nbsp; 
			   -->
			   
			   <td>
			  <span>
                  <i class="fa  fa-check text-success text" data-toggle="tooltip" title="Confirm" ng-click="approveBLDraft(item.blNo,item.sobDate,item.hsCode,item.fpodcode,item.blFreedays)"></i>
                </span>
                </td>
                <security:authorize access="hasRole('${form_code}_${delete}')">
                <td>
                <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" ng-click="deleteBLDraft(item.blNo)"></i>
                </span>
                </td>
                </security:authorize>
                </tr>
                
                
                  <tr>
                  	<td><span class="fa fa-file-excel-o" style="color: blue"
											title="Export Draft BL"
											data-ng-click="exportDraftBL(item.blNo)"></span>
										 <!-- <a id="exportDraftBL" style="display:none"
											href="{{'filePath/BLDraft/' + item.blNo +'.pdf' }}"
											download="{{item.blNo+'.pdf'}}"></a>  -->
											
											<a id="exportDraftBL" style="display: none"
								href="filePath/{{filename}}.pdf"
								download="{{filename}}.pdf"></a>
					</td>
                  
                 </tr>
			  </table>
                
			  
			 <!--  <span> 
              <i class="fa  fa-print text-danger text" title="Print Arrival Notice" data-ng-click="printArrival(item.blNo)"></i>
			  </span> -->
			  <%--  <security:authorize access="hasRole('${form_code}_${admin_unlock}')"> 
			   
			    <span> 
              <i class="fa  fa-unlock text-warning text" title="Unlock Original Stationary" data-ng-click="unlockOgs(item.blNo)"></i>
			  </span>
			  <span> 
              <i class="fa  fa-unlock text-success text" title="Unlock Original Normal" data-ng-click="unlockOg(item.blNo)"></i>
			  </span>
			  
			    <span> 
              <i class="fa  fa-unlock text-primary text" title="Unlock Copy" data-ng-click="unlockCopy(item.blNo)"></i>
			  </span>
			  <span> <i class="fa  fa-envelope text-success text" data-toggle="tooltip" title="Email"
										data-ng-click="mailview(item.blNo)"></i>
			  </security:authorize> --%>
			<!--     <span> 
              <i class="fa fa-external-link"  data-ng-hide="item.blrelease== true" title="BL Surrender" data-ng-click="viewRemarks(item.blNo,item.pol,item.pod,item.fpod,item.fpodcode,item.vslVoyage,item.polcode)"></i>
			  </span>&nbsp;&nbsp; -->
		<%-- 	   <security:authorize access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="item.cancel_by == null || item.cancel_by == ''">
										<i class="fa fa-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel BL"
										data-ng-click="cancelBl(item.blNo)"></i>
									</span>&nbsp;&nbsp; 
			</security:authorize> --%>
			
              </td>
              <td class=" td-actions text-center"  ng-show="item.blNo==='' || item.blNo===null"> 	</td>
             
              
            </tr>
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


<script type="text/ng-template" id="BLDraftPrint">
<div class="modal-header" style="text-align: center;
    font-size: 17px;
    color: white;
    background-color: #08082c;border-radius: 5px 5px 0px 0px;">Check BL Draft</div>
<div>

 <div class="row"  style="margin:0px;    margin-top: 15px; margin-bottom:15px" >
 <div class="col-sm-12 col-md-12 col-lg-12 ">

<div class="form-group">
<label class="col-md-4 control-label" style="margin-left: -10px;">Remarks</label>
<div class="col-md-7">
<textarea class="form-control" type="text" name="blDraftDescription" 
id="blDraftDescription" ng-model="blDraftDescription" style="    margin-left: -21px;margin-top: 0px;margin-bottom: 0px;height: 120px;width: 140%;"></textarea>
</div>
</div>
</div>
<br>

</div>

 </div>



  <div class="modal-footer" style="    text-align: center;">
   <button class="btn btn-info" type="button" ng-click="CheckBLDraft(blDraftDescription)">Submit</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	
  </div>
 </script>
 
 
 
 
 
 
<script type="text/ng-template" id="BLFeeDetail">
<div class="modal-header" style="text-align: center;
    font-size: 17px;
    color: white;
    background-color: #08082c;border-radius: 5px 5px 0px 0px;">Check BL Draft</div>
<div>

 <div class="row"  style="margin:0px;    margin-top: 15px; margin-bottom:15px" >
 <div class="col-sm-12 col-md-12 col-lg-12 ">

<div class="form-group" ng-if='showInvoice'>
<label class="col-md-4 control-label" style="margin-left: -10px;">Enter Late BL fee Invoice No.</label>
<div class="col-md-7">
<input type="text" class="form-control"  name="blInvoiceNo" message-id="blInvoiceNo" style="text-align: left;" id=blInvoiceNo ng-model="ba.blInvoiceNo">
</div>
</div>
<br>
<br>

<div class="form-group">
<label class="col-md-4 control-label" style="margin-left: -10px;">Remarks</label>
<div class="col-md-7">
<textarea class="form-control" type="text" name="blDraftDescription" 
id="blDraftDescription" ng-model="ba.blDraftDescription" style="  margin-top: 0px;margin-bottom: 0px;height: 120px;width: 100%;"></textarea>
</div>
</div>


</div>
<br>

</div>

 </div>



  <div class="modal-footer" style="    text-align: center;">
   <button class="btn btn-info" type="button" ng-click="CheckBLDraft(ba.blDraftDescription,ba.blInvoiceNo)">Submit</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	
  </div>
 </script>
 
 
 
 

