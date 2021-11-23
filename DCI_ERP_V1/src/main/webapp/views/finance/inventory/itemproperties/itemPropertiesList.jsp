

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
           <!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
           <th class="sorting width_5" st-sort="propertyTypeName">Property Type </th>
           <th class="sorting width_5" st-sort="propName">Property Name	 </th>
           <th class="sorting width_5" st-sort="typeName">Type </th>
           <th class="sorting width_5" st-sort="manditory">Is Mandatory	 </th>
           <th class="width_5 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItemProperties in displayedCollection">
           <!-- <td class="text-center" cs-select="objItemProperties"></td> -->
           <td>{{objItemProperties.propertyTypeName}}</td>
           <td>{{objItemProperties.propName}}</td>
           <td>{{objItemProperties.typeName}}</td>
           <td data-ng-if="objItemProperties.manditory=='t'">
	           <div class="">
	           	<label>
				  <input type="checkbox" checked="checked" disabled="disabled">
           </td>
           <td data-ng-if="objItemProperties.manditory!='t'">
           		<div class="">
	           	<label class="i-checks">
				  <input type="checkbox" disabled="disabled">
					<i></i>
				</label>
				</div>
           </td>
           <td class=" td-actions text-center">
		        <span>
	         		<i class="fa  fa-pencil text-success text" data-ng-click="editRow(objItemProperties.itemPropertiesId)"></i>
	        	</span>
		        <span>
	         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objItemProperties.itemPropertiesId)"></i>
	        	</span>
		   </td>
          </tr>
         </tbody>
        </table>
        <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
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