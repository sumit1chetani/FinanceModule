<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0322_D')" var="isDelete" />
<security:authorize access="hasRole('F0322_A')" var="isAdd" />
<security:authorize access="hasRole('F0322_UP')" var="isUpload" /> --%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
      
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th>
           <th class="sorting width_8 text_center" data-st-sort="">Asset Requisition No</th>
           <th class="sorting width_7 text_center"  data-st-sort="">Asset Requested By</th>
           <th class="sorting width_12 text_center" data-st-sort="">Asset Requisition Date</th>
           <th class="sorting width_7 text_center" data-st-sort="">Requisition Location</th>
           <th class="sorting width_7 text_center" data-st-sort="">Status</th>
           <th class="width_5 text-center table-heading"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
         <tbody>
			 <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPurchaseAssetRequistion in displayedCollection">           
          <td cs-select="objPurchaseAssetRequistion" class="text-center"></td>        
           <td>{{objPurchaseAssetRequistion.purchaseAssetrequisitionNo}}</td>
           <td>{{objPurchaseAssetRequistion.employeeName}}</td>
           <td>{{objPurchaseAssetRequistion.purchaseAssetrequisitionDate}}</td>
           <td>{{objPurchaseAssetRequistion.designationLocationName}}</td>
           <td>{{objPurchaseAssetRequistion.assetApprovalStatus}}</td> 
          <td class=" td-actions text-center">
          <security:authorize access="hasRole('${form_code}_${view}')">
	        <span data-ng-if="objPurchaseAssetRequistion.assetApprovalStatus == 'Approved'">
	        <i class="fa  fa-list-alt text-dark text" data-ng-click="viewRow(objPurchaseAssetRequistion.purchaseAssetRequisitionId)"></i>
	        </span>
	        </security:authorize>
	        <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span data-ng-if="objPurchaseAssetRequistion.assetApprovalStatus != 'Approved'">
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPurchaseAssetRequistion.purchaseAssetRequisitionId)"></i>
	        </span>
	        </security:authorize>
	        
       	 </td>
          </tr>
          </tbody>
        </table>
        <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>
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