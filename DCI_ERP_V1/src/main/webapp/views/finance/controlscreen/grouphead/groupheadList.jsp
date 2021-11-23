
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
		<div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>
  </div>
  <div class="col-md-6 text-right padding-right-0">
   <div class="row">
    <div class="col-md-6 p-r-3">
<!--      <div class="btn btn-sm btn-info"> -->
<!--       <span ng-click="changeFont(3)" class="inline-block padding-both-side-2"> -->
<!--        <i class="fa fa-font"></i> -->
<!--       </span> -->
<!--       <span ng-click="changeFont(1)" class="inline-block padding-both-side-2"> -->
<!--        <i class="fa fa-plus"></i> -->
<!--       </span> -->
<!--       <span ng-click="changeFont(2)" class="inline-block padding-both-side-2"> -->
<!--        <i class="fa fa-minus"></i> -->
<!--       </span> -->
<!--      </div> -->
     <button class="btn btn-sm btn-info" ng-click="refresh()">
      <i class="icon-refresh"></i>
     </button>
    </div>
    <div class="col-md-6  p-l-0 p-r-0">
       <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
    </div>
   </div>
  </div>
 </div>
</div>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
<!-- 							<th class="width_1"><label class="i-checks m-b-none"> -->
<!-- 									<input type="checkbox" name="post[]"> <i></i> -->
<!-- 							</label></th> -->
							<th class="sorting width_40" st-sort="groupHeadCode">Group Head Code</th>
							<th class="sorting width_40" st-sort="groupHeadName">Group Head Name</th>
							<!-- <th class="text-center none">Action</th> -->
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objGrpHeadMasterBean in displayedCollection">
<!-- 							<td class=""><label class="i-checks m-b-none"> <input -->
<!-- 									type="checkbox" name="post[]"> <i></i> -->
<!-- 							</label></td> -->
							<!-- <td class="">{{objGrpHeadMasterBean.groupHeadId}}</td> -->
							<td class="sorting  width_25" ng-bind="objGrpHeadMasterBean.groupHeadCode"></td>
							<td class="sorting  width_50" ng-bind="objGrpHeadMasterBean.groupHeadName"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer.jsp"%>
			</footer>
		</div>
	</div>
</div>