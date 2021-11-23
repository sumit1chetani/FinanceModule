

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
					<th class="sorting width_12" data-st-sort="uomcategoryId">Category Code</th>
					<th class="sorting width_12" data-st-sort="uomcategoryName">Category Name</th>
					<th class="sorting width_15" data-st-sort="uomcategoryDesc">Category Description</th>
					<th class="sorting width_2">Action</th>
				</tr>
			</thead>
			<tbody class="dataTables-Main-Body">
				<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="uomCategory in displayedCollection">
					<td>{{uomCategory.uomcategoryId}}</td>
					<td>{{uomCategory.uomcategoryName}}</td>
					<td>{{uomCategory.uomcategoryDesc}}</td>
					<td class="text-center">
						<span> <i class="fa fa-pencil text-success text"
							data-ng-click="editRow(uomCategory.uomId)"></i>
						</span>
							<span> <i class="fa fa-trash-o text-danger-dker text"
								data-ng-click="deleteRow(uomCategory.uomId,$index)"></i>
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