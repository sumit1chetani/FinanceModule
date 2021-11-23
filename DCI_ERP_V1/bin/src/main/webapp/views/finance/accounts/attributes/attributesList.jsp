

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
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <!--  <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
          	<th class="sorting width_50" st-sort="attributeName">Attribute Name</th>
			<th class="sorting width_50" st-sort="attributeValue">Attribute Value</th>
           <th class="width_8 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objAttribute in displayedCollection">
      <!--  <td class="">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </td> -->
        <td class="sorting  width_50" ng-bind="objAttribute.attributeName"></td>
		<td class="sorting  width_50" ng-bind="objAttribute.attributeValue"></td>
       <td class=" td-actions text-center">
         <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objAttribute)"></i>
        </span>
        </security:authorize>
         <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objAttribute)"></i>
        </span>
        </security:authorize>
       </td>
      </tr>
     </tbody>
        </table>
        <!-- <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div> -->
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