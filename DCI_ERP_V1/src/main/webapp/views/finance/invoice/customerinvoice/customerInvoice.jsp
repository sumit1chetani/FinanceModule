<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
<!--   <div class="panel-heading panel-heading-list padding-right-0 padding-left-0"> -->

   <%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
   <div class="panel-heading panel-heading-list padding-right-0 padding-left-0" >
	 <div class="row  m-n">
	  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold" >
	   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>	   
	  </div>
	  <div class="col-md-6 text-right padding-right-0">
	   <div class="row">
	    <div class="col-md-6 p-r-3">
	     <div class="btn btn-sm btn-info">
	      <span ng-click="changeFont(3)" class="inline-block padding-both-side-2">
	       <i class="fa fa-font"></i>
	      </span>
	      <span ng-click="changeFont(1)" class="inline-block padding-both-side-2">
	       <i class="fa fa-plus"></i>
	      </span>
	      <span ng-click="changeFont(2)" class="inline-block padding-both-side-2">
	       <i class="fa fa-minus"></i>
	      </span>
	     </div>
	      <button class="btn btn-sm btn-info" ng-click="refresh()">
	      <i class="icon-refresh"></i>
	     </button>
	     <security:authorize access="hasRole('${form_code}_${upload}')">
	     <button class="btn btn-sm btn-primary" ng-click="fileUpload()" ng-hide="hideUploadIcon">
	      <span class="fa fa-upload"></span>
	     </button>
	     </security:authorize>
	     <%-- <security:authorize access="hasRole('${form_code}_${add}')"> --%>
	     <button class="btn btn-sm btn-success" ng-click="add()" ng-hide="hideAddIcon">
	      <span class="fa fa-plus"></span>
	     </button>
	     <security:authorize access="hasRole('${form_code}_${delete}')">
		     <button class="btn btn-sm btn-danger" ng-click="deleteSelected()" ng-hide="hideEditIcon">
		      <span class="fa fa-trash-o"></span>
		     </button>
	     </security:authorize>	    
	     <!--  <button class="btn btn-sm btn-success"   id="btnStartStopWizard" value="Start Wizard" style="width:35mm" onClick="WizardScriptControl('START_STOP')">Sign
	     
	     </button> -->
	    </div>
	    <div class="col-md-6  p-l-0 p-r-0">
	     <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
	    </div>
	   </div>
	  </div>
	 </div>
	</div>
<!--   </div>/panel-heading -->
   <input type="hidden" value="${form_code}" id="form_code_id">
   <div class="panel panel-default">
   <div class="form-body form-horizontal">
			<!-- <div class="row m-t-sm">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label  vessel-text">Vessel</label>
								<div class="col-md-6">
									<selectivity list="vesselList" property="phcInvoiceHeaderData.vesselid" 
									id="vessel_id" object="vesselObj"></selectivity>
								</div>
							</div>							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group hidden-group">
								<label class="col-md-5 control-label">Voyage</label>
								<div class="col-md-6">
									<selectivity list="voyageList"
										property="phcInvoiceHeaderData.voyageCode" id="voyage_id"></selectivity>
								</div>
							</div>
						</fieldset>				
					</div>					
				</div>				
			</div> -->
			<%-- <div class="row" align="left">
				<div class="col-md-12 ">
					<security:authorize access="hasRole('${form_code}_${search}')">
						</security:authorize>
						<!-- <button class="btn btn-success" type="button"
							data-ng-click="searchInvoiceDtl();">
							<i class="fa fa-search"></i> Search
						</button> -->
					     <!-- <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="formreset()">
							            <i class="fa fa-undo"> </i>Reset
						 </button> -->						
						<button class="btn btn-primary" type="button" data-ng-click="bulkPrint(rowCollection);">
							Bulk Print
						</button>
						 <button class="btn btn-primary" type="button" data-ng-click="bulkPHCInvoiceMail(rowCollection);">
							Bulk Mail
						</button>
				</div>
			</div> --%>
		</div> 
   
	  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
	   <div class="table-responsive ">
	    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head">
	      <tr role="row">
	       <th class="width_1"></th>
	       <th class="sorting text-center width_8" st-sort="">Invoice No</th>
	       <th class="sorting text-center width_9" st-sort="">Invoice Date</th>
	       <th class="sorting text-center width_15" st-sort="">Customer</th>
	       <th class="sorting text-center width_10" st-sort="">Trip No</th>
	       <th class="sorting text-center width_10" st-sort="">Remarks</th>
	       <th class="sorting text-center width_8" st-sort="">Currency</th>
	       <th class="sorting text-center width_8" st-sort="">Exg. Rate</th>
	       <th class="sorting text-center width_9" st-sort="">TC Amount</th>
	       <th class="sorting text-center width_9" st-sort="">BC Amount</th>
	       <th class="width_15 text-center">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
	       <!-- <td class="width_1" cs-select="objListItem"></td> -->
	       <td class="width_1"> <label class="i-checks m-b-none">
	       <input type="checkbox" ng-model="objListItem.select" id="select{{trIndex}}"><i></i></label></td>
	       
	       <td class="width_8">
	       		<span>
			     	<a ng-click="viewCustomerInvoice(objListItem.invoiceNo)">
			             <span tooltip="{{objListItem.invoiceNo}}" class="tool-tip-span font-blue" ng-bind="objListItem.invoiceNo"></span>
			        </a></span>		         
	       </td>
	       <td class="width_8" ng-bind="objListItem.invDate"></td>
	       <td class="width_15" ng-bind="objListItem.customerName"></td>
	       
	        <td class="width_10" ng-bind="objListItem.tripNo"></td>
	       
	       <td class="width_15" ng-bind="objListItem.remarks"></td>
	       <td class="width_8" ng-bind="objListItem.currency"></td>
	       <td class="width_8 text-right" ng-bind="objListItem.exchangeRate"></td>
	       <td class="width_8 text-right" ng-bind="objListItem.totalTCamount"></td>
	       <td class="width_8 text-right" ng-bind="objListItem.totalBCamount"></td>
	       <td class="width_18">
		       		<!-- <select class="input-sm" ng-model="objListItem.printList" id ="printSelect{{$index}}">
							<option value="both" >Both</option>
							<option value="usd">USD</option>
							<option value="local">Local</option>
					</select> -->
			    <%-- <security:authorize access="hasRole('${form_code}_${send_mail}')"> --%>
			  <!--    <span class="cursor-pointer padding-left-10 font-blue"><i class="icon-envelope red text-success" data-ng-click="sendMail(objListItem.invoiceNo,objListItem.printList)"></i></span> --> 
			    <%-- </security:authorize> --%>
			     <security:authorize access="hasRole('${form_code}_${print}')"> 
			    <span data-ng-click="printCustInvoiceDiv(objListItem.invoiceNo)"
					id="{{objListItem.invoiceNo}}"
					class=" glyphicon glyphicon-print cursor-pointer font-grey padding-left-10"></span>
				 </security:authorize> 	
				
				 <%-- <security:authorize access="hasRole('${form_code}_${delete}')">
					<span class="cursor-pointer  padding-left-10"> <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deletePHCInvoice(objListItem.invoiceNo,$index)"></i>
					</span>
				 </security:authorize> --%>
				 
				 <a id="fileExport" class="link" ng-if="objListItem.eirDoc!=null && objListItem.eirDoc!=''"
							href="{{objListItem.eirDoc}}" download title="EIR Documents" >
				<span> <i class="fa  fa-download text-success text"
					data-ng-click="fileDownload()"></i>
				</span></a>
				
				 <a id="fileExport1" class="link" ng-if="objListItem.consignDoc!=null && objListItem.consignDoc!=''"
							href="{{objListItem.consignDoc}}" download title="Cosignment Documents" >
				<span> <i class="fa  fa-download text-success text"
					data-ng-click="fileDownload1()"></i>
				</span></a>
									
									
			</td>
	       <%-- <td class="td-actions text-center">
	        <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span class="width_15">
	         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objListItem.invoiceNo)" tooltip="Edit"></i>
	        </span>
	        </security:authorize>
	        <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span class="width_15">
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objListItem.invoiceNo,$index)" tooltip="Delete"></i>
	        </span>
	        </security:authorize>
	       </td> --%>
	      </tr>
	     </tbody>
	    </table>
	   </div>
	   <footer class="panel-footer">
	   		<!-- <span class="width_10 td-actions b-a r-5x"><i class="fa fa-check text-dark text" data-ng-click="ApproveCreditNote(displayedCollection)" tooltip="Approve"></i></span> -->
			<%@include file="/views/templates/panel-footer-static.jsp"%>
	   </footer>
	  </div> <!-- /panel-body -->
  </div>
 <!--  <div id="not_ie_warning" style="display:none" >
        <h2>WARNING:</h2>
        This application is only supported by Internet Explorer<br/>
        (The Javascript uses ActiveX controls which are not supported by alternative browsers such as Firefox)<br/>
      </div>
			<div class="col-md-5" id="sign" style="display:none">
			<div  data-ng-click="DisplaySignatureDetails()" title="Double-click a signature to display its details">
              <object id="sigCtl1" style="width:60mm;height:35mm"
                type="application/x-florentis-signature">
              </object>
            </div> -->
            
           <!--  
            <div style="width:100%">
      <h2>Test Wizard Control</h2>
      <div id="not_ie_warning" style="display:none">
        <h2>WARNING:</h2>
        This application is only supported by Internet Explorer<br/>
        (The Javascript uses ActiveX controls which are not supported by alternative browsers such as Firefox)<br/>
      </div>
      <object id="SigCtl1" style="width:60mm;height:35mm" type="application/x-florentis-signature">
      </object>
      <br/>
      <div id="divWizCtl" style="position:absolute;right:10px;top:10px;display:none;">
        <object id="WizCtl" type="application/x-florentis-wizard" title="Buttons can only be activated on the pad !">
          <param name="BorderStyle" value="5" />
          <param name="Zoom" value="50" />
        </object>
      </div>
    <input type="button" value="About" style="width:35mm" onClick="WizardScriptControl('ABOUT')"
        title="Displays the Help About box" />
      <input type="button" id="btnCapture" value="Start Capture" style="width:35mm" onClick="WizardScriptControl('CAPTURE')"
        title="Starts signature control capture" />
  <input type="button" id="btnStartStopWizard" value="Start Wizard" style="width:35mm" onClick="WizardScriptControl('START_STOP')"
        title="Starts/Stops a Wizard Script" />
      <input type="checkbox" id="chkDisplayWizard" checked="checked"/>Display IE Wizard Control
      <br/>
      <textarea cols="125" rows="15" id="txtDisplay"></textarea>
    </div>
             -->
            
			</div>
 </div>
  <script type="text/ng-template" id="invoiceMail">
<div class="modal-header"> Are you sure to send Email? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="SendConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
 
   <script type="text/ng-template" id="invoiceDelete">
<div class="modal-header"> Are you sure to delete Invoice? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="deleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
 
 