

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
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer"
     role="grid" aria-describedby="dt_basic_info" >
     <thead>
          <tr>
           <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th>
           <th class="sorting width_10" data-st-sort="">GRN No</th>
           <th class="sorting width_10" data-st-sort="">GRN Date</th>
           <th class="sorting width_10" data-st-sort="">Supplier</th>
           <th class="sorting width_10" data-st-sort="">Purchase Order</th>
           <th class="sorting width_10" data-st-sort="">Requisition</th>
           <th class="sorting width_10" data-st-sort="">QC Status</th>
           <th class="width_6 text-center table-heading"><spring:message code="label.action"></spring:message></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="objGrnList in displayedCollection">
           <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox"
             name="post[]"> <i></i>
           </label></td>
           <td class="sorting">{{objGrnList.grnCode}}</td>
           <td class="">{{objGrnList.grnDate}}</td>
           <td class="sorting">{{objGrnList.vendorName}}</td>
           <td class="">{{objGrnList.poNo}}</td>
           <td class="sorting">{{objGrnList.poRequisition}}</td>
           <td class="sorting">{{objGrnList.statusVal}}</td>
           <td class=" td-actions text-center">
           <security:authorize access="hasRole('${form_code}_${modify}')">
           <span data-ng-if="objGrnList.grnStatus!=151">
             <i class="fa  fa-pencil text-success text"
             data-ng-click="editRowBtn(objGrnList.grnCode)"></i>
           </span>
           </security:authorize>
           <security:authorize
				access="hasRole('${form_code}_${view}')">
				<span data-ng-if="objGrnList.grnStatus==151"> <i class="fa fa-list-alt text-dark text"
					data-ng-click="editRowBtn(objGrnList.grnCode)"></i>
				</span>
			</security:authorize>
           </td>
          </tr>
         </tbody>
        </table>
        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
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