<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<style>
.dropdown-menu>li>a {
	padding: 5px 36px;
}

.form-control {
	border: 1px solid #DDD;
	border-radius: 7px;
	box-shadow: none;
	height: 42px;
	padding: 8px 12px 9px 12px;
}
</style>
<security:authentication var="user" property="principal" />
<%-- <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%> --%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="BLDraftTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
										<selectivity list="vesselList" ng-model="plreport.vessel"
											friendly-name="vessel"
											property="plreport.vessel" id="vessel" name="vessel" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage </label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="plreport.voyage"
											 friendly-name="Voyage"
											property="plreport.voyage" id="voyage" name="voyage" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">From Date </label>
									<div class="col-md-7">
										 <ng-bs3-datepicker data-ng-model="plreport.dateFrom"
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
										 <ng-bs3-datepicker data-ng-model="plreport.dateTo"
										id="dateTo" name="dateTo"  date-format="DD/MM/YYYY" 
										id="dateTo"
											friendly-name="To Date"
											/>
									</div>
								</div>
							</div>
<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="plreport.customer"
											friendly-name="customer"
											property="plreport.customer" id="customer" name="customer" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div>
							<!-- <div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Vendor</label>
									<div class="col-md-7">
										<selectivity list="vendorList" ng-model="plreport.vendor"
											friendly-name="vendor"
											property="plreport.vendor" id="vendor" name="vendor" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div> -->
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Sales Person</label>
									<div class="col-md-7">
										<selectivity list="salesPersonList" ng-model="plreport.salesPerson"
											friendly-name="salesPerson"
											property="plreport.salesPerson" id="salesPerson" name="salesPerson" 
											form-name="blListForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="carrier" id="carrier" ng-model="plreport.carrier"
											friendly-name="carrier" />
									</div>
								</div>
							</div>
							
							

						
							
 
							<div class="col-md-6" style="padding-left: 121px;padding-top: 3px;">
								<button class="btn btn-success" type="button"
										ng-click="searchNEW()">
										<i class="fa fa-search"></i> Search
									</button>
									<button class="btn btn-info" type="button"
										data-ng-click="reset()">
										<i class="fa fa-undo"></i> Reset
									</button>
									<button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/plreport.xls" download="plreport.xls"></a>																						
								       </button>
									
									
							</div>
							
							
							
						</div>
						
						<div class="row" id="loader">
									<div class="padding-left-5 padding-top-5" id="jqgrid">
										<div id="bankbookJqGrid">
											<table id="bankbookGrid"></table>
											<div id="bankbookdiv"></div>
										</div>
									</div>
								</div>
						<div class="row">
					<div class="col-xs-12">
						<div id="jqgrid">
							<table id="generalLedgerGrid"></table>
							<div id="generalLedgerPage"></div>
						</div>
					</div>
				</div>
					</form>
				</div>
			</div>
		
		
			

       <!--  <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
            <tr>
              
              
              <th class="sorting" style="width: 9%;" st-sort="bookingno"> Booking No.</th>
              <th class="sorting" style="width: 10%;" st-sort="jobNo"> Job No.</th>
              <th class="sorting" style="width: 8%;" st-sort="vessel">Vessel</th>
              <th class="sorting" style="width: 8%;" st-sort="vslVoyage">Voyage</th>
              <th  class="sorting" style="width: 8%;" st-sort="pol">POL</th>
              <th class="sorting" style="width: 8%;" st-sort="pod">POD</th>
              <th class="sorting" style="width: 10%;" st-sort="fpod">Buy</th>
              <th class="sorting" style="width: 7%;" st-sort="noBls"> Sell</th>
              <th class="sorting" style="width: 8%;" st-sort="bltype"> Profit / Loss</th> 
              
            </tr>
          </thead>

          <tbody class="dataTables-Main-Body">
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection">
             	<td>{{item.bookingno}}</td>
		        <td >{{item.jobNo}} </td>
		        <td>{{item.vessel}}</td>
                <td>{{item.voyage}}</td>
              	<td>{{item.pol}}</td>
              	<td>{{item.pod}}</td>
             	<td>{{item.buy}}</td>
              	<td>{{item.sell}}</td>
                <td>{{item.total}}</td>
               
            </tr>
            <tr>
            <td><label><b>Total</b></label></td>
             <td colspan="5"> </td>
              <td><b>{{buy}}</b></td>
              <td><b>{{sell}}</b></td>
               <td><b>{{total}}</b></td>
            </tr>
          </tbody>
        </table> -->
			</div>
			<%-- <footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer> --%>
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
 
 
 
 

