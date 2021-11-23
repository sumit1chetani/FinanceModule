<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="breadcrumb-wrapper ng-scope">

 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">

   <%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
  
	 <div class="row  m-n">
	  <div class="col-md-4 padding-right-0 padding-left-0 header-with-breadcrumb font-bold" >
	   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>
	   <!-- <p>
	   <button type="button" class="btn btn-success" data-ng-hide="started" data-ng-click="start()">Start Demo</button>
	   <button type="button" class="btn btn-danger" data-ng-show="started" data-ng-click="stop()">Stop Demo</button>
	  </p> -->
	  </div>
	  <div class="col-md-8 text-right padding-right-0">
	   <div class="row">
	    <div class="col-md-8 p-r-2">
<!-- 	     <div class="btn btn-sm btn-info"> -->
<!-- 	      <span ng-click="changeFont(3)" class="inline-block padding-both-side-2"> -->
<!-- 	       <i class="fa fa-font"></i> -->
<!-- 	      </span> -->
<!-- 	      <span ng-click="changeFont(1)" class="inline-block padding-both-side-2"> -->
<!-- 	       <i class="fa fa-plus"></i> -->
<!-- 	      </span> -->
<!-- 	      <span ng-click="changeFont(2)" class="inline-block padding-both-side-2"> -->
<!-- 	       <i class="fa fa-minus"></i> -->
<!-- 	      </span> -->
<!-- 	     </div> -->
	     <!--  <button class="btn btn-sm btn-info" ng-click="refresh()">
	      <i class="icon-refresh"></i>
	     </button> -->
	    <%--  <security:authorize access="hasRole('${form_code}_${upload}')">
	     <button class="btn btn-sm btn-primary" ng-click="fileUpload()" ng-hide="hideUploadIcon">
	      <span class="fa fa-upload"></span>
	     </button>
	     </security:authorize> --%>
	     <security:authorize access="hasRole('${form_code}_${add}')">
	     <button class="btn btn-sm btn-success" ng-click="add()" ng-hide="hideAddIcon">
	      <span class="fa fa-plus"></span>
	     </button>
	     </security:authorize>
	 <security:authorize access="hasRole('${form_code}_${approve}')">
	     <button class="btn btn-sm btn-info" tooltip="FirstApproval" ng-click="ApproveCreditNotePartial(rowCollection)" ng-hide="hideAddIcon">
	      <span class="fa fa-check"></span>
	     </button>
	     </security:authorize> 
	     <security:authorize access="hasRole('${form_code}_${approve}')">
	     <button class="btn btn-sm btn-success" tooltip="FinalApproval" ng-click="ApproveCreditNote(rowCollection)" ng-hide="hideAddIcon">
	      <span class="fa fa-check"></span>
	     </button>
	     </security:authorize> 
<%-- 	      <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
<!-- 	     <button class="btn btn-sm btn-danger" ng-click="deleteSelected()" ng-hide="hideEditIcon"> -->
<!-- 	      <span class="fa fa-trash-o"></span> -->
<!-- 	     </button> -->
<%-- 	     </security:authorize> --%>
	   
	   <%--   <security:authorize access="hasRole('${form_code}_${approve}')">
	      <button class="btn btn-sm btn-info" ng-click="getPendingDataApproval(rowCollection)" ng-hide="hideEditIcon">First Approval
	     </button>
	     </security:authorize> --%>
	       <security:authorize access="hasRole('${form_code}_${approve}')">
	      <button class="btn btn-sm btn-success" ng-click="getPendingData(rowCollection)" ng-hide="hideEditIcon"> Approval
	     </button>
	     </security:authorize>
	     <button class="btn btn-sm btn-info" ng-click="getPendingApprovalList('${form_code}')" ng-hide="hideEditIcon">Pending Approval List
	     </button>
	     <!--  <button class="btn btn-sm btn-success"   id="btnStartStopWizard" value="Start Wizard" style="width:35mm" onClick="WizardScriptControl('START_STOP')">Sign
	     
	     </button> -->
	    </div>
	    <div class="col-sm-4  p-l-0 p-r-0">
	     <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
	    </div>
	   </div>
	  </div>
	 </div>
	
  </div><!-- /panel-heading -->
  <div class="form-body form-horizontal">
			<%-- <div class="row m-t-sm">
				<div class="col-sm-6 col-md-6 col-lg-6">					
					<div class="col-sm-3">
						<fieldset>
							<div class="form-group">			
							<security:authorize access="hasRole('${form_code}_${print}')">					
								<button class="btn btn-primary" type="button" data-ng-click="bulkPrint(rowCollection);">
									Bulk Print
								</button>
								</security:authorize>
							</div>
						</fieldset>				
					</div>
					<div class="col-sm-3">
					<fieldset>
							<div class="form-group">	
							<security:authorize access="hasRole('${form_code}_${bulkMail}')">								
								<button class="btn btn-primary" type="button" data-ng-click="bulkMail(rowCollection);">
									Bulk Mail
								</button>
								</security:authorize>
							</div>
					</fieldset>
					</div>
			</div>
 	</div>  --%>
   <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body"  st-table="displayedCollection" st-safe-src="rowCollection" >
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
      <tr role="row">
       <!-- <th class="width_1"></th> -->
       <th class="sorting width_8" st-sort="creditNoteCode">Cr Code</th>
       <th class="sorting width_8" st-sort="creditNoteDate">Date</th>
       <th class="sorting width_8" st-sort="mloName">Customer/Supplier</th>
       <th class="sorting width_8" st-sort="invoiceNo">Inv No</th>
     <!--   <th class="sorting width_9" st-sort="location">Locn</th> -->
       <th class="sorting width_8" st-sort="company">Company</th>
       <!-- <th class="sorting width_8 text-wrap" st-sort="creditAmount">TC Amt</th> -->
       <th class="sorting width_8 text-wrap text-wrap-amtusd" st-sort="creditAmountUSD">Amt</th>
<!--        <th class="sorting width_8 text-wrap" st-sort="approveStatus">Status</th> -->
         <th class="sorting width_8 text-wrap" st-sort="createdBy">Users</th>
       <th class="width_10">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCreditNoteListItem in displayedCollection">
       <!-- <td class="width_1" cs-select="objCreditNoteListItem"></td> -->
      <!--  <td class="width_1"> <label class="i-checks m-b-none">
       <input type="checkbox" ng-model="objCreditNoteListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
     
        <!-- <td class="width_1 text-center"><label class="i-checks m-b-none">
	          <input type="checkbox" name="selectedTypes[]"  ng-model="objCreditNoteListItem .check">
	          <i></i>
	          </label>
	          </td> -->
       <td ><span ng-if="objCreditNoteListItem.urIsView=='t'">
       
        <a ng-click="viewRow(objCreditNoteListItem.creditNoteCode)">
        <span tooltip="{{objCreditNoteListItem.creditNoteCode}}" class="tool-tip-span font-blue" ng-bind="objCreditNoteListItem.creditNoteCode">
         </span>
      	</a>
      	</span>
        <span ng-if="objCreditNoteListItem.urIsView=='f'">
        <span tooltip="{{objCreditNoteListItem.creditNoteCode}}" class="tool-tip-span" ng-bind="objCreditNoteListItem.creditNoteCode">
        </span>
        </span>
       </td>
       <td class="width_8" ng-bind="objCreditNoteListItem.creditNoteDate"></td>
       <td class="width_8">
        <span tooltip="{{objCreditNoteListItem.mloName}}"  ng-bind="objCreditNoteListItem.mloName"></span>
       </td> 
     <!--   <td class="width_8" ng-bind="objCreditNoteListItem.mloName"> -->
       <td class="width_8" ng-bind="objCreditNoteListItem.invoiceNo">
       </td>
       <!-- <td class="width_8" ng-bind="objCreditNoteListItem.location"></td> -->
       <td class="width_8">
        	<span tooltip="{{objCreditNoteListItem.company}}" class="tool-tip-span text-wrap" ng-bind="objCreditNoteListItem.company"></span>
       </td>
       <!-- <td class="width_8 text-right" ng-bind="objCreditNoteListItem.creditAmount"></td> -->
       <td class="width_8 text-right" ng-bind="objCreditNoteListItem.creditAmountUSD1"></td>
 <!--       <td class="width_8" ng-bind="objCreditNoteListItem.approveStatus"> -->
       </td>
<td class="width_8" ng-bind="objCreditNoteListItem.createdBy">
       </td>
       <td class="td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span class="width_15" data-ng-if="objCreditNoteListItem.approveStatus =='N' && objCreditNoteListItem.urIsEdit=='true' ">
         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objCreditNoteListItem.creditNoteCode)" tooltip="Edit"></i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span class="width_15" ng-if="objCreditNoteListItem.approveStatus == 'N' && objCreditNoteListItem.urIsDelete=='true' ">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objCreditNoteListItem.creditNoteCode,$index)" tooltip="Delete"></i>
        </span>
        </security:authorize>
         <security:authorize access="hasRole('${form_code}_${print}')"> 
		    &nbsp;&nbsp;<span data-ng-click="printDiv(objCreditNoteListItem.creditNoteCode)"
			id="{{objTranslationItem.invoiceNo}}"
			class=" glyphicon glyphicon-print "
			style="cursor: pointer; color: gray;"></span>
		</security:authorize>
        <%--  <security:authorize access="hasRole('${form_code}_${send_mail}')">
         	<span data-toggle="tooltip"  ng-if="objCreditNoteListItem.approveStatus == 'Y'" title="Mail" class="text-right" style="margin-left: 10px;">
       			<i class="icon-envelope red" data-ng-click="sendMail(objCreditNoteListItem.creditNoteCode,$index)" style="cursor: pointer; color: gray;"></i>
        	</span>
         </security:authorize> --%>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer" style="padding:0px;">
   		<!-- <span class="width_10 td-actions b-a r-5x"><i class="fa fa-check text-dark text" data-ng-click="ApproveCreditNote(displayedCollection)" tooltip="Approve"></i></span> -->
		<%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
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
</div>