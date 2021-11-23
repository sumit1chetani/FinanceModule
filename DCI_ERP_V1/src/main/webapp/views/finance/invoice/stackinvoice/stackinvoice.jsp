
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">  <input type="hidden" value="${form_code}" id="form_code_id">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="stackusageForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7">
									<div class="input-group">
										<selectivity list="mloList" property="stackinvoice.mlo"
											id="mlo_id" ng-model="stackinvoice.mlo" name="mlo_id"
											validation="required" friendly-name="CUSTOMER"
											form-name="stackusageForm"  ></selectivity>
										<span class="input-group-btn ">
											<button class="btn btn-info input-sm" type="button"
												ng-click="clearData('MLO')" style="margin-top: -4px">
												<i class="fa fa-times"></i>
											</button>
										</span>
									</div>



								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">From Dt </label>
								<div class="col-md-7 inputGroupContainer">
									<div class="input-group input-append date" id="validFromDate">
										<input type="text" class="form-control input-sm"
											name="validFrom" id="validFrom"
											ng-model="stackinvoice.validfrom" placeholder='dd/mm/yyyy' /> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
							<div class="form-group">
								<label class="col-md-5 control-label">To Dt</label>
								<div class="col-md-6 inputGroupContainer">
									<div class="input-group input-append date" id="validToDate">
										<input type="text" class="form-control input-sm"
											name="validTo" id="validTo" ng-model="stackinvoice.validto"
											placeholder='dd/mm/yyyy' /> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
					

						</fieldset>
					</div>


				</div>

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" 
											ng-click="submit()">
											<i class="fa fa-search"></i> Search Pending Invoice
										</button>		
										<button class="btn btn-info" type="button" 
											ng-click="generateinvoice()" ng-if="rowCollection.length>0"    id="generateinvoice">
											<i class="fa fa-plus"></i> Generate Invoice
										</button>
										<button class="btn btn-danger" type="button" 
											ng-click="getTranslationList()"  >
											<i class="fa fa-search"></i> view
										</button>									 
									
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				
				
				<div class="wrapper-md">
				<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="listCollection" ng-if="type=='search'">
   <%@include file="/views/templates/panel-header.jsp"%>
   
  <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="listCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_12" st-sort="invoiceno">Invoice No</th>
       <th class="sorting width_12" st-sort="invoicedt">Invoice Date</th>
       <th class="sorting width_25" st-sort="customer">Customer</th>
       <th class="sorting width_25" st-sort="mlo">Payer</th>
       <th class="sorting width_12" st-sort="blrelated">BL Related</th>
       <th class="width_15">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
       <td cs-select="objTranslationItem"></td>
       <td><span ng-if="objTranslationItem.urIsView=='t'">
       <a ng-click="view(objTranslationItem.InvoiceNo)">
		 <span tooltip="{{objTranslationItem.InvoiceNo}}" class="tool-tip-span font-blue">{{objTranslationItem.InvoiceNo}}</span>
         </a></span>
         <span ng-if="objTranslationItem.urIsView=='f'">
         <span tooltip="{{objTranslationItem.InvoiceNo}}" class="tool-tip-span">{{objTranslationItem.InvoiceNo}}</span>
         </span>
       </td>
       <!-- <td>
         <span tooltip="{{objTranslationItem.InvoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.InvoiceNo"></span>
       </td> -->
       <td>
        <span tooltip="{{objTranslationItem.InvoiceDate}}" class="tool-tip-span" ng-bind="objTranslationItem.InvoiceDate"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.CustomerName}}" class="tool-tip-span" ng-bind="objTranslationItem.CustomerName"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.MloName}}" class="tool-tip-span" ng-bind="objTranslationItem.MloName"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.BlRelated}}" class="tool-tip-span" ng-bind="objTranslationItem.BlRelated"></span>
       </td>
       <td class="td-actions text-center">
      
           			   <security:authorize access="hasRole('${form_code}_${print}')">  
							    &nbsp;&nbsp;<span ng-click="printGeneralInvoiceDiv(objTranslationItem.InvoiceNo)" 
								id="{{objTranslationItem.InvoiceNo}}"
								class=" glyphicon glyphicon-print "
								style="cursor: pointer; color: gray;"></span>
							 	</security:authorize> 
								&nbsp;&nbsp;
								
       <%--  <security:authorize access="hasRole('${form_code}_${send_mail}')"> --%>
	  <!--  <span class="padding-both-side-2" ><i class="icon-envelope red" data-ng-click="sendMail(objTranslationItem.InvoiceNo)" style="cursor: pointer; color: gray;"></i></span> -->
	   <%--  </security:authorize> --%>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
  
  <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
				
	<div class="panel panel-default panel-default-list"  st-safe-src="displayedCollection1" st-safe-src="rowCollection" ng-if="type!='search'">
   
  <div class="panel-body float-left padding-0" st-table="displayedCollection1" st-safe-src="rowCollection" style="width:100%">
   <%@include file="/views/templates/panel-header.jsp"%>
   <div class="table-responsive ">
     <table id="dt_basic1" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic1_info">
 
      <thead class="dataTables-Main-Head">
       <tr>
       <th class="width_12" st-sort="">Select</th>
        <th class="width_12" st-sort="">Find Cont</th>
        <th class="width_12" st-sort="stackusageId">StackUsageId</th>
        <th class="width_12" st-sort="customer">Customer</th>
        <th class="width_12" st-sort="payername">Payer</th>
        <th class="width_12" st-sort="voyage">Voyage</th>
         <th class="width_12" st-sort="exvoyage">EX-Voyage</th>
         <th class="width_12" st-sort="pol">POL</th>
         <th class="width_12" st-sort="pod">POD</th>
         <th class="width_12" st-sort="stackcost">Stack Cost</th>
        <th class="width_12" st-sort="d20">D20</th>      
         <th class="width_12" st-sort="d40">D40</th>       
      <th class="width_12" st-sort="d45">D45</th>
        <th class="width_12" st-sort="m20">M20</th>      
         <th class="width_12" st-sort="m40">M40</th>       
      <th class="width_12" st-sort="m45">M45</th>   
        <th class="width_12" st-sort="r20">R20</th>      
         <th class="width_12" st-sort="r40">R40</th>
         <th class="width_12" st-sort="ri20">RI20</th>      
         <th class="width_12" st-sort="ri40">RI40</th>       
         <th class="width_12" st-sort="oog20">OOG20</th>      
         <th class="width_12" st-sort="oog40">OOG40</th>   
            <th class="width_12" st-sort="imco_20">IMCO20</th>      
         <th class="width_12" st-sort="imco_40">IMCO40</th>      
              
            
        
       </tr>
      </thead>
	  
	  <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="data in displayedCollection1 ">
	  <td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="data.select" id="section{{trIndex}}"
										 > <i></i>
								</label></td>
									  <td class="width_12"><button ng-click="findContainer(data.stackusageId)" 
										class="btn btn-sm  btn-primary" type="button"
										data-toggle="tooltip" title="Find Containers" ng-disabled="disabled">
									<i class="fa fa-list-alt"></i>
									</button></td>
									
       <td class="width_12"><span tooltip="{{data.stackusageId}}"
         class="tool-tip-span"> {{data.stackusageId}}</span></td>
        <td class="width_12"><span tooltip="{{data.customer}}"
         class="tool-tip-span"> {{data.customer}}</span></td>
           <td class="width_12"><span tooltip="{{data.customer}}"
         class="tool-tip-span"> {{data.payername}}</span></td> 
          <td class="width_12"><span tooltip="{{data.voyage}}"
         class="tool-tip-span"> {{data.voyage}}</span></td>
            <td class="width_12"><span tooltip="{{data.voyage}}"
         class="tool-tip-span"> {{data.exvoyage}}</span></td>
              <td class="width_12"><span tooltip="{{data.ppl"
         class="tool-tip-span"> {{data.pol}}</span></td>
              <td class="width_12"><span tooltip="{{data.pod}}"
         class="tool-tip-span"> {{data.pod}}</span></td>
          <td class="width_12"><span tooltip="{{data.stack_cost_id}}"
         class="tool-tip-span"> {{data.stack_cost_id}}</span></td> 
         
        <td class="width_12"><span tooltip="{{data.d20}}"
         class="tool-tip-span"> {{data.d20}}</span></td>        
       <td class="width_12"><span tooltip="{{data.d40}}"
         class="tool-tip-span"> {{data.d40}}</span></td>     
           <td class="width_12"><span tooltip="{{data.d45}}"
         class="tool-tip-span"> {{data.d45}}</span></td> 
         
         <td class="width_12"><span tooltip="{{data.m20}}"
         class="tool-tip-span"> {{data.m20}}</span></td>        
       <td class="width_12"><span tooltip="{{data.m40}}"
         class="tool-tip-span"> {{data.m40}}</span></td>     
           <td class="width_12"><span tooltip="{{data.m45}}"
         class="tool-tip-span"> {{data.m45}}</span></td>    
         
           <td class="width_12"><span tooltip="{{data.r20}}"
         class="tool-tip-span"> {{data.r20}}</span></td>        
       <td class="width_12"><span tooltip="{{data.r40}}"
         class="tool-tip-span"> {{data.r40}}</span></td>      
         
          <td class="width_12"><span tooltip="{{data.ri20}}"
         class="tool-tip-span"> {{data.ri20}}</span></td>        
       <td class="width_12"><span tooltip="{{data.ri40}}"
         class="tool-tip-span"> {{data.ri40}}</span></td>    
                 <td class="width_12"><span tooltip="{{data.oog20}}"
         class="tool-tip-span"> {{data.oog20}}</span></td>        
       <td class="width_12"><span tooltip="{{data.oog40}}"
         class="tool-tip-span"> {{data.oog40}}</span></td>    
         
            <td class="width_12"><span tooltip="{{data.imco_20}}"
         class="tool-tip-span"> {{data.imco_20}}</span></td>        
       <td class="width_12"><span tooltip="{{data.imco_40}}"
         class="tool-tip-span"> {{data.imco_40}}</span></td>  
             
         
      
       </tr>
      </tbody>
     </table>
    </div> 
    <footer class="panel-footer">
     <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
   </div>
  </div>
		
			
			
		</div>
	</div>

</div>
<script type="text/ng-template" id="findcontainerstackusage">

<div class="modal-header"> Container Details </div>
<div class="row">
 <div class="col-lg-12">
  <div class="col-lg-12">  
  <div class="table-responsive tr-fixed">
	  <table border=1 cellspacing=0 cellpadding=0
	             bordercolor="#808080"
	             class="table table-striped table-hover dataTable no-footer booksfixed">
		     <thead class="tr-thead dataTables-Main-Head">
<tr>
<th>Container No</th>
<th>Check Digit</th>
<th>Origin Port</th>
<th>Load Port</th>
<th>Destination Port</th>
<th>Designation</th>
<th>OOG</th>
<th>IMCO</th>
<th>UNNO</th>
</tr>		     	


		     </thead>
	     
	     	<tbody class="tr-tbody" ng-repeat="container in lcontainerDetail" ng-init="$rowIndex = $index" ng-if="lcontainerDetail.length > 0">
		      <tr>
		    <td>{{container.containerNo}}</td>
<td>{{container.checkdigit}}</td>
<td>{{container.originport}}</td>
<td>{{container.loadport}}</td>
<td>{{container.disport}}</td>
<td>{{container.designation}}</td>
<td>{{container.oog}}</td>
<td>{{container.imco}}</td>
<td>{{container.unno}}</td>
		      </tr>
		    
	     	</tbody>
		    <tbody ng-repeat="bookingSummary in lBookingSummary" ng-if="lcontainerDetail.length < 0">
		       <tr>
		       <td colspan="6" class="text-center">No Records Found</td>
		       </tr>
		    </tbody>
		   
	   </table>
   </div> 
  </div>
 </div> 
</div>
<div class="modal-footer">

 
 <button class="btn btn-danger" type="button" ng-click="closeDialog()">Cancel</button>
</div>
 </script>