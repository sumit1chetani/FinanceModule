


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
	     	<form class="form-horizontal" name="journalVocherTypeAdd" role="form" >
								
				</form>
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		      <!--   <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>  -->
		        <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		       </div>
		       <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <!-- <th class="width_1"></th> -->
		           <th class="sorting width_15" st-sort="name">Name</th>
		           <th class="sorting width_15" st-sort="description">Description</th>
		          <th class="sorting width_5" st-sort="active">Active</th>
		             <th class="sorting width_3" st-sort="action">Action</th>
		          </tr>
		         </thead>
		       	   <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="parameterCollection in displayedCollection">
		          <!--  <td cs-select="objVesselMasterItem"></td> -->
					 <td>{{parameterCollection.name}}</td>
					<td>{{parameterCollection.description}}</td>
					<td data-ng-if="parameterCollection.active==true">
				            <div class="">
				             <label>
				      <input type="checkbox" checked="checked" disabled="disabled">
				    <span></span>
				    </label>
				    </div>
				           </td>
				           <td data-ng-if="parameterCollection.active!=true">
				             <div class="">
				             <label class="i-checks">
				      <input type="checkbox" disabled="disabled">
				     <i></i>
				    </label>
				    </div>
				           </td>
					
					<td class=" td-actions text-center">
			         	   <security:authorize access="hasRole('${form_code}_${modify}')"> 
			         	 <span>
				         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(parameterCollection.journalVoucherTypeId)"></i>
				        </span>
				        </security:authorize>
				           <security:authorize access="hasRole('${form_code}_${delete}')"> 
				       	<span>
				         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(parameterCollection.journalVoucherTypeId)"></i>
				        </span>
				       </security:authorize>
				       </td>
		          </tr>
         		</tbody>
		        </table>
<!-- 		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->	     
 
 
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
    </div>
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>