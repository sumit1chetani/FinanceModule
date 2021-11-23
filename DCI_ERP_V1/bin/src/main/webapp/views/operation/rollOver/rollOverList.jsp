<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%-- <%@include file="/views/layout/panel-header-form.jsp"%> --%>
     <div class="panel-heading panel-heading-form font-bold">
              <ol class="breadcrumb inline-block padding-left-10">
                 <li>
                  <a x-ui-sref="app.finance">Operation</a>
                 </li>
                 <li>
                  <a x-ui-sref="app.finance.invoice">Roll Over</a>
                 </li>
                  <li>
                  <a x-ui-sref="app.finance.invoice">List</a>
                 </li>
                </ol>
               </div>
				<div class="panel-body">
					<form name="sailingsReportForm" class="form-horizontal">
					
  
      <div class="row">

     <!-- Shift From  -->
     
     <input type="hidden" value="${form_code}" id="form_code_id">
   <div class="col-sm-12">
   		<fieldset>
         	
         	
        <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">From Vessel<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <selectivity  list="vesselList" property="shiftBookingSearchData.vesselCode" ng-model="shiftBookingSearchData.vesselCode" 
         id="vesselCode" form-name="sailingsReportForm" name="vesselCode" validation="required" friendly-name="From Vessel" ></selectivity>
        </div>
       </div>
       </div>
   		
   		<div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">To Vessel<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <selectivity  list="vesselList" property="shiftBookingSearchData.vesselCodeTo"  ng-model="shiftBookingSearchData.vesselCodeTo" 
         id="vesselCodeTo" form-name="sailingsReportForm" validation="required" name="vesselCodeTo" friendly-name="To vessel" ></selectivity>
        </div>
       </div>
       </div>
       
        <!-- <div class="col-md-4" >
		<div class="form-group">
		<label class="col-md-5 control-label">ETA Date</label>
		<div class="col-md-7">
		<label class="col-md-8 control-label">{{shiftBookingSearchData.etasailDate}}</label>
		</div>
		</div>
		 </div> -->
		 </fieldset>
		 </div>
		 
		 
		  <div class="col-sm-12">
   		<fieldset>
       
        <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">From Voyage<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="voyageList" property="shiftBookingSearchData.voyageId" ng-model="shiftBookingSearchData.voyageId"  id="voyageId" 
          validation="required" form-name="sailingsReportForm" name="voyageId" friendly-name="From Voyage" ></selectivity>
			</div>
        </div>
       </div>
       </div>
       
       
        <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">To Voyage<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="voyageListTo" property="shiftBookingSearchData.voyageIdTo"  ng-model="shiftBookingSearchData.voyageIdTo" 
         id="voyageIdTo" form-name="sailingsReportForm" validation="required" name="voyageIdTo" friendly-name="To Voyage"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
         <!-- <div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">ETD Date</label>
									<div class="col-md-7">
										<label class="col-md-8 control-label">{{shiftBookingSearchData.etdsailDate}}</label>
									</div>

								</div>
							</div> -->
       
       </fieldset>
       </div>
       
        <div class="col-sm-12">
   		<fieldset>
        <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">From POL<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="polList" property="shiftBookingSearchData.pol" ng-model="shiftBookingSearchData.pol"  validation="required"
          id="pol" form-name="sailingsReportForm" name="pol" friendly-name="From Pol"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
       <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">To POL<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="polListTo" property="shiftBookingSearchData.polTo" ng-model="shiftBookingSearchData.polTo"  id="polTo"
         name="polTo" form-name="sailingsReportForm" validation="required" friendly-name="To Pol"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
       <!-- <div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">Cut-off Date</label>
								<div class="col-md-7" ng-if="!isEdit">
 						
									   <ng-bs3-datepicker data-ng-model="shiftBookingSearchData.cutoffDate"
										id="cutoffDate" name="schEndDate" 
										date-format="DD/MM/YYYY HH:mm" id="sch_end_date"
										friendly-name="cutoffDate" 
										title = "{{shiftBookingSearchData.cutoffDate}}"/>
										
 
								</div>
								</div>
								</div> -->
       
       
       </fieldset>
       </div>
       
       
        <div class="col-sm-12">
   		<fieldset>
       <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">From POD<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="polList" property="shiftBookingSearchData.pod" ng-model="shiftBookingSearchData.pod" id="pod"
         name="pod" form-name="sailingsReportForm" validation="required" friendly-name="From Pod"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
       <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">To POD<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="polListTo" property="shiftBookingSearchData.podTo" ng-model="shiftBookingSearchData.podTo" id="podTo"
          validation="required" form-name="sailingsReportForm" name="podTo" friendly-name="To Pod"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
       <!-- <div class="col-md-4" >
								<div class="form-group">
									<label class="col-md-5 control-label">Port Gate-In After</label>
								<div class="col-md-7">
 								
									   <ng-bs3-datepicker data-ng-model="shiftBookingSearchData.portgateinDate"
										id="portgateinDate" name="portgateinDate" 
										date-format="DD/MM/YYYY HH:mm" id="sch_end_date"
										friendly-name="shiftBookingSearchData" 
										title = "{{shiftBookingSearchData.portgateinDate}}"/>

								</div>
								</div>
								</div> -->
       
       </fieldset>
       </div>
       
       
        <div class="col-sm-12">
   		<fieldset>
       
      <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">From FPOD</label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="fpodList" property="shiftBookingSearchData.fpod" ng-model="shiftBookingSearchData.fpod" id="fpod"
         name="fpod" form-name="sailingsReportForm" validation="required" friendly-name="From Fpod"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
       <div class="col-md-6">
		<div class="form-group">
   		<label class="col-md-5 control-label">To FPOD</label>
        <div class="col-md-7">
         <div id="voyage_select" class="selectivity-input example-input selectivity-slot voyage_sel">
         <selectivity  list="fpodList" property="shiftBookingSearchData.fpodTo" ng-model="shiftBookingSearchData.fpodTo" id="fpodTo"
          validation="required" form-name="sailingsReportForm" name="fpodTo" friendly-name="To Fpod"></selectivity>
			</div>
        </div>
       </div>
       </div>
       
      </fieldset>
      </div>
   
  
  
   </div>
      <div class="form-actions">
	<div class="row">
		<div class="col-md-12">
<!--   <div class="col-md-1">
        
        <span class ="padding-left-10">
     <a class="btn btn-success btn-sm" data-ng-click="helpVideo('Shift_Booking','Shift Booking Help')">Help video</a>           
      </span>
      </div> -->
       <div class="col-md-11">
		<button class="btn btn-success"
				  ng-click="getSearchList(shiftBookingSearchData)">View
						</button>
				<button class="btn btn-info"  
						ng-click="reset()">
					<i class="fa fa-undo"></i> Reset
					</button>
				</div>
					</div>
				</div>
    </div>
				
  <br/>
 <!--  </div> -->
  
  <!-- End Header -->
  
  <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="panel-body padding-0">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1">
       <!--  <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]" ng-click="multiSelect(displayedCollection)">
         <i></i>
        </label> -->
       </th>
       	<th class="sorting" st-sort="bookingNo">Booking No.</th>
       	<th class="sorting" st-sort="bookingDate">Booking Date</th>
       	<th class="sorting" st-sort="vessel">Vessel</th>
       	<th class="sorting" st-sort="voyage">Voyage</th>
        <th class="sorting" st-sort="pol">POL</th>
       	<th class="sorting" st-sort="pod">POD</th>
        <th class="sorting" st-sort="fpod">FPOD</th>
        <th class="sorting" st-sort="quotation">Quotation</th>
        <th class="sorting" st-sort="croStatus">CRO Status</th>
        <!-- <th class="sorting" st-sort="blStatus">BL Status</th> -->
        <th class="sorting" st-sort="gatoutstatus">Gate-out Status</th>
        
      
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in displayedCollection">
      <td>
	  <label class="i-checks m-b-none"> <input type="checkbox" ng-model="objItem.select"  ng-change="blockSelect(displayedCollection,$index)" id="select{{trIndex}}" ><i></i></label>
	  </td>
	  <td>
	  <span class="tool-tip-span" ng-bind="objItem.bookingNo"></span>
	  </td>
	  <td>
	  <span class="tool-tip-span" ng-bind="objItem.bookingDate"></span>
	  </td>
	
     <td>
     <span class="tool-tip-span" ng-bind="objItem.vessel"></span>
     </td>  	  
	  <td>
	  <span class="tool-tip-span" ng-bind="objItem.voyage"></span>
	  </td>
	  
	    <td>
	  <span class="tool-tip-span text-nowrap" ng-bind="objItem.pol"></span>
	  </td>
	  <td>
	  <span class="tool-tip-span text-nowrap" ng-bind="objItem.pod"></span>
	  </td>	 
	    <td>
	  <span class="tool-tip-span text-nowrap" ng-bind="objItem.fpod"></span>
	  </td>	  
	   <td>
	  <span class="tool-tip-span text-nowrap" ng-bind="objItem.quotation"></span>
	  </td>	 
	  <td>
	  <span class="tool-tip-span" ng-bind="objItem.croStatus"></span>
	  </td>
	   <!-- <td>
	  <span class="tool-tip-span" ng-bind="objItem.blStatus"></span>
	  </td> -->
	    <td>
	  <span class="tool-tip-span" ng-bind="objItem.gatoutstatus"></span>
	  </td>
	  
	  
	<!--  
	  <td>
	  <input type="text" class="form-control input-sm input-remarks" name="reason{{trIndex}}" id="reason{{trIndex}}"   ng-model="objItem.reason" />
	  </td>	  -->      
                      
      </tr>
      <tr x-ng-show="showEmptyLabel">
       <td colspan="10" class="text-center">No Records Found</td>
      </tr>
       <tr x-ng-show="!showEmptyLabel">
      <td colspan="10" align="center"> <button class="btn btn-success"
				type="submit" ng-click="dotShiftBooking(shiftBookingSearchData,displayedCollection,sailingsReportForm)">ROLL OVER
						</button>
						</td>
	</tr>					
      
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
<%--    <footer class="panel-footer">
    <%@include file="/views/layout/panel-footer-static.jsp"%>
   </footer> --%>
  </div>
 </div>
 </form>
 </div>
 </div>
 </div>
 </div>
 
</div>
 
 