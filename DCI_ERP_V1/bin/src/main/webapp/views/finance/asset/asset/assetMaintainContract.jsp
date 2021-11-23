<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -100px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       <spring:message code="label.maintain.contract"></spring:message>
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="maintainContractForm">
        <div class="row">
         <div class="col-sm-10 col-md-5"><br>
          <fieldset style=" margin-left: 55px; ">           
			<div class="form-group">
			 <label class="col-md-6 control-label">
			 <spring:message code="label.maintenance.contract.no"></spring:message>						  					
			 </label>
			 <div class="col-md-6">
			   <input type="text" class="form-control input-sm" 
			   name="<spring:message code="label.maintenance.contract.no"></spring:message>"
			   data-ng-model="assetMasterData.maintainContractNo" style=" width: 150px; ">
			 </div>
			</div>
						   				  
			<div class="form-group">
			<!-- <label class="col-md-4 control-label">Maintenance Date</label> -->
			 <label class="col-md-6 control-label">Maintenance Contract Date<span
			style="color: red;"></span></label>
										<div class="col-md-4">
										<div class='input-group date datetimepick' style=" margin-bottom: -9px; ">
										<div class="dropdown">
											<a class="dropdown-toggle" id="contractDate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group" style=" margin-top: -16px; ">
												<input type="text" class="form-control"
												placeholder="dd/mm/yyyy" name="Contract Date"									
												data-ng-model="assetMasterData.contractDate" style=" width: 116px; "><span
												class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											</div>
											</a>
										<ul class="dropdown-menu" role="menu"
										aria-labelledby="dLabel">
										<datetimepicker data-ng-model="assetMasterData.contractDate"
										data-on-set-time="assetMasterData.contractDate = onDateSet(newDate)"
										data-datetimepicker-config="{ dropdownSelector: '#contractDate',startView:'day', minView:'day'}" />
										</ul>
										</div>
										</div>
										</div>
									</div>
									
									<div class="form-group">
											 <label class="col-md-6 control-label">
						  					<spring:message code="label.contact.person"></spring:message>						  					
						  					</label>
						  					<div class="col-md-6">
						   						<input type="text" class="form-control input-sm" 
						   						name="<spring:message code="label.contact.person"></spring:message>"
						   						data-ng-model="assetMasterData.contactPerson" style=" width: 150px; ">
						   					</div>
						   				  </div>
						   				  
						   				  <div class="form-group">
											 <label class="col-md-6 control-label">
						  					<spring:message code="label.contact.no"></spring:message>						  					
						  					</label>
						  					<div class="col-md-6">
						   						<input type="text" class="form-control input-sm" 
						   						name="<spring:message code="label.contact.no"></spring:message>"
						   						data-ng-model="assetMasterData.contactNo" style=" width: 150px; ">
						   					</div>
						   				  </div>
						   				  
						   				  <div class="form-group">
										<!-- <label class="col-md-4 control-label">Maintenance Date</label> -->
			 							<label class="col-md-6 control-label">Start Date<span
										style="color: red;"></span></label>
										<div class="col-md-4">
										<div class='input-group date datetimepick' style=" margin-bottom: -27px; ">
										<div class="dropdown">
											<a class="dropdown-toggle" id="startDate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group" style=" margin-top: -16px; ">
												<input type="text" class="form-control"
												placeholder="dd/mm/yyyy" name="Start Date"									
												data-ng-model="assetMasterData.startDate" style=" width: 116px; "><span
												class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											</div>
											</a>
										<ul class="dropdown-menu" role="menu"
										aria-labelledby="dLabel">
										<datetimepicker data-ng-model="assetMasterData.startDate"
										data-on-set-time="assetMasterData.startDate = onDateSet(newDate)"
										data-datetimepicker-config="{ dropdownSelector: '#startDate',startView:'day', minView:'day'}" />
										</ul>
										</div>
										</div>
										</div>
									</div>
		        			  </fieldset>
        		 			</div>
	         
    						     <div class="col-sm-10 col-md-5"><br>
          							<fieldset> 
          							<div class="form-group">
           								 <label class="col-md-6 control-label"><spring:message
              							code="label.vendor"></spring:message> </label>
            							<div class="col-md-4 inputGroupContainer">
             							  <select class="form-control journalVoucher-textBox"
              								ng-model="assetMasterData.contractVendor" ng-change="getVendorAdd(assetMasterData.contractVendor)"
              								name="Vendor" style=" width: 217px; ">
              								<option value="">Select</option>
								  			<option value="1">Paragon</option>
								  			<option value="2">ERP</option>
              								             								               
             							</select>
            							</div>
           							</div>
           							
           							<%-- <div class="form-group">
											 <label class="col-md-6 control-label">
						  					<spring:message code="label.vendor.address"></spring:message>						  					
						  					</label>
						  					<div class="col-md-6">						   												   						
						   						<textarea class="form-control input-sm" style="resize: none;width: 150px;"
              									name="<spring:message code="label.vendor.address"></spring:message>"
              									data-ng-model="assetMasterData.vendorAddress"></textarea>						   						
						   					</div>
						   			</div> --%>	
						   			
						   			<div class="form-group">
				            <label class="col-md-6 control-label"> <spring:message code="label.vendor.address"></spring:message>
				            </label>
				            <div class="col-md-6">
				             <div class="col-md-12 b b-grey no-padding" style=" width: 218px; ">
				             <div class="col-md-12 no-padding padding-top-5 padding-left-5 padding-right-5">
				             	<textarea class="text-left form-control input-sm" rows="2" cols="15" ng-model="assetMasterData.address" style="resize: none" readonly> </textarea>				             	
				             </div>
				             <div class="col-md-5 no-padding padding-top-5 padding-left-5">
								<input type="text" class="form-control input-sm" placeholder="city" ng-model="assetMasterData.city" readonly>
				             </div>
				             <div class="col-md-4 no-padding padding-top-5 padding-left-5">
				             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="assetMasterData.state" readonly>
				             </div>
				             <div class="col-md-3 no-padding padding-top-5 padding-left-5 padding-right-5">
				             	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="assetMasterData.zipcode" readonly>
				             </div>
				             <div class="col-md-12 no-padding padding-top-5 padding-bottom-5 padding-left-5 padding-right-5">
				             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="assetMasterData.country" readonly>
				             </div>
				            </div>
				            </div>
			            </div>
						<div class="form-group">
 							<label class="col-md-6 control-label">End Date<span
							style="color: red;"></span></label>
							<div class="col-md-4">
								<div class='input-group date datetimepick'>
									<div class="dropdown">
									<a class="dropdown-toggle" id="endDate" role="button"
									data-toggle="dropdown" data-target="#" href="#">
									<div class="input-group" style=" margin-top: -16px; ">
										<input type="text" class="form-control"
										placeholder="dd/mm/yyyy" name="End Date"									
										data-ng-model="assetMasterData.endDate" style=" width: 116px; "><span
										class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span>
									</div>
									</a>
									<ul class="dropdown-menu" role="menu"
									aria-labelledby="dLabel">
									<datetimepicker data-ng-model="assetMasterData.endDate"
									data-on-set-time="assetMasterData.endDate = onDateSet(newDate)"
									data-datetimepicker-config="{ dropdownSelector: '#endDate',startView:'day', minView:'day'}" />
									</ul>
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
           <button class="btn btn-success" type="button"
            data-ng-click="save(maintainContractForm)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(maintainContractForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(maintainContractForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancelpop();">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>