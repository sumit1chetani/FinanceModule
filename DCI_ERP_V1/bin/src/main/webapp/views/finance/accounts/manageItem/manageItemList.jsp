

<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
 
 <div class="panel-body float-left padding-0" style="width: 100%;">

     <div role="content">
      <div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<div class="dt-toolbar">
<%-- 									<%@include file="/views/layout/toolbar-header.tpl.jsp"%>
 --%>									<button class="btn btn-primary" id="manageitemExcel"
										ng-click="exportExcel(displayedCollection)">
										<i class="fa fa-cloud-download"></i>
										Export Excel</button>

								</div>
								<!-- <a id="dpidetail" stype="display:none"
							href="filePath/Manageitem.xls"
							download="Manageitem.xls"></a> -->
						
						
								<div class="col-sm-4 col-md-4 col-lg-4">
									<div class="col-md-12 ">

										<!-- <button class="btn btn-primary" id="manageitemExcel"
											ng-click="exportExcel(displayedCollection)">
											<i class="fa fa-cloud-download"></i> Export Excel
										</button> -->
<!-- <button class="btn btn-primary" id="manageitemExcel"
										ng-click="exportExcel(displayedCollection)">
										<i class="fa fa-cloud-download"></i>
										Export Excel</button>
 -->

									</div>
								</div>
								<br> <br>
							<!-- </div> -->


							<table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 table-heading text-center"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th> -->
           <th class="sorting width_5" st-sort="itemName">  Item Name</th>
           <th class="sorting width_5" st-sort="itemCategory">Item Category</th>
           <th class="sorting width_5" st-sort="itemDescription">Item Description</th>
           <th class="sorting width_5" st-sort="itemType">Item Type</th>
           <th class="sorting width_5" st-sort="partNo">Item code</th>
           <th class="width_5 table-heading text-center">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="objManageItem in displayedCollection">
           <!-- <td cs-select="objManageItem" class="text-center"></td> -->
           <td>{{objManageItem.itemName}}</td>
           <td>{{objManageItem.itemCategory}}</td>
           <td>{{objManageItem.itemDescription}}</td>
           <td>{{objManageItem.itemType}}</td>
           <td>{{objManageItem.itemCode}}</td>
           <td class=" td-actions text-center">
<%--            <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>             <span> <i class="fa  fa-pencil text-success text"
              data-ng-click="editRow(objManageItem)"></i>
             </span>
           <%-- </security:authorize>
           <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
             <span> <i class="fa fa-trash-o text-danger-dker text"
              data-ng-click="deleteRow(objManageItem,$index)"></i>
             </span>
<%--            </security:authorize>
 --%>           <%-- <security:authorize access="hasRole('F0059_V')">
        		<span ng-if="objManageItem.itemType == 'Consumable'"><!-- ng-if="collections.manageItemStatus == 'Consumable'" -->
         			<i class="fa  fa-list-alt text-dark text"  data-ng-click="viewRow(objManageItem)"></i>
        		</span>
        	</security:authorize> --%>
           </td>
          </tr>
         </tbody>
        </table>
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->       </div>
      
      

<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
      
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
<!-- label.decease=Disease -->