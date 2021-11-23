<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id">
   <div class="panel panel-default">
	  <!--  <div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-12 col-lg-12">					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">								
								<button class="btn btn-primary" type="button" data-ng-click="bulkPrint(rowCollection);">
									Bulk Print
								</button>
							</div>
						</fieldset>				
					</div>
				</div>
			</div>
	 	</div>  -->
	  <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
	   <div class="table-responsive ">
	    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head">
	      <tr role="row">
	       <th class="width_1"></th>
	       <th class="sorting width_10" st-sort="invoiceno">Inv No</th>
	       <th class="sorting width_10" st-sort="invoicedt">Inv Date</th>
	       <th class="sorting width_25" st-sort="customer">Customer</th>
	       <th class="sorting width_25" st-sort="mlo">Payer</th>
	       <th class="sorting width_8" st-sort="blrelated">BL Rel</th>
	        <th class="sorting width_10" st-sort="VesselCode">Vessel</th>
	         <th class="sorting width_12" st-sort="Voyage">Voyage</th>
	         <th class="sorting width_8" st-sort="Voyage">BL No</th>
	       <th class="width_15">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
	        <td class="width_1 text-center"><label class="i-checks m-b-none">
	          <input type="checkbox" name="selectedTypes[]"  ng-model="objTranslationItem.check">
	          <i></i>
	          </label>
	          </td>
	       <!-- <td class="" cs-select="objTranslationItem"></td> -->
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
	        <td>
	        <span tooltip="{{objTranslationItem.VesselCode}}" class="tool-tip-span" ng-bind="objTranslationItem.VesselCode"></span>
	       </td>
	        <td>
	        <span tooltip="{{objTranslationItem.Voyage}}" class="tool-tip-span" ng-bind="objTranslationItem.Voyage"></span>
	       </td>
	       <td>
	        <span tooltip="{{objTranslationItem.bl}}" class="tool-tip-span" ng-bind="objTranslationItem.bl"></span>
	       </td>
	       <td class="td-actions text-center">
	        <security:authorize access="hasRole('${form_code}_${modify}')">
	         <span class="padding-both-side-2" ng-if="objTranslationItem.urIsEdit=='true'">
	         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objTranslationItem.InvoiceNo)" tooltip="Edit"></i>
	        </span>
	        </security:authorize>
	         <security:authorize access="hasRole('${form_code}_${delete}')">
	       <span class="padding-both-side-2" ng-if="objTranslationItem.urIsDelete=='true'">
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objTranslationItem.InvoiceNo)" tooltip="Delete"></i>
	        </span>
	        </security:authorize>
	           			   <security:authorize access="hasRole('${form_code}_${print}')">  
								    &nbsp;&nbsp;<span ng-click="printinvoiceForOwner(objTranslationItem.InvoiceNo)" 
									id="{{objTranslationItem.InvoiceNo}}"
									class=" glyphicon glyphicon-print "
									style="cursor: pointer; color: gray;"></span>
								 	</security:authorize> 
									&nbsp;&nbsp;
									
	       <%--  <security:authorize access="hasRole('${form_code}_${send_mail}')"> --%>
<!-- 		   <span class="padding-both-side-2" ><i class="icon-envelope red" data-ng-click="sendMail(objTranslationItem.InvoiceNo)" style="cursor: pointer; color: gray;"></i></span>
 -->		   <%--  </security:authorize> --%>
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
 </div>
</div>
<script type="text/ng-template" id="generalInvoiceDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeGeneralInvoiceDeleteDialog()">Cancel</button>
</div>
 </script>