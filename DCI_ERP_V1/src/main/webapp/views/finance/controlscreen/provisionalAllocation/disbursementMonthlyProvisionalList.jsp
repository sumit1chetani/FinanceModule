<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
 <%--   <%@include file="/views/templates/panel-header.jsp"%> --%>
   <input type="hidden" value="${form_code}" id="form_code_id" />
    <div class="panel panel-default">
	  <div class="panel-body float-left padding-0">
	   <div class="table-responsive ">
	    <table class="table table-striped table-hover dataTable no-footer">
	     <thead class="dataTables-Main-Head">
	      <tr>
	       <th class="sorting width_15" st-sort="monthOfYear">Month</th>
	       <th class="sorting width_40" st-sort="supplierName">Agent Name</th>
	       <th class="sorting width_15" st-sort="tcAmount">TC Amount</th>
	       <th class="sorting width_15" st-sort="bcAmount">BC Amount</th>
	       <th class="sorting width_15" st-sort="remarks">status</th>
	       <th class="text-center width_15">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="ObjList in displayedCollection">
	      <td class="sorting ">{{ObjList.monthOfYear}}</td>
	      <td>	      
			{{ObjList.supplierName}}	       
	       </td>
	       <td class="sorting ">{{ObjList.tcAmount}}</td>
	       <td class="sorting ">{{ObjList.bcAmount}}</td>
	       <td class="sorting ">{{ObjList.status}}</td>
	       <td class=" td-actions text-center">
	         <span ng-if="ObjList.status=='Pending'">
              <i class="fa fa-plus  text" data-ng-click="viewMonthlyDisbVoyageList(ObjList.supplier,ObjList.monthOfYear)"></i>
             </span>
              <span ng-if="ObjList.status=='Approved'">
               <i class="fa fa-eye  text" data-ng-click="viewMonthlyDisbVoyageList(ObjList.supplier,ObjList.monthOfYear)"></i>
              </span> 
	       </td>
	      </tr>
	     </tbody>
	    </table>
	   </div>
	   <footer class="panel-footer panel-footer-list">
	    <%@include file="/views/templates/panel-footer.jsp"%>
	   </footer>
	   <div class="form-actions">
					<div class="row">
						<div class="col-md-12">

							<span>
								<button class="btn btn-danger " type="button" ng-click="back()">
									<i class="fa fa-arrow-left"></i>&nbsp; Back
								</button>
							</span>

						</div>
					</div>
				</div>
	  </div> <!-- /panel-body -->
  </div>
 </div>
</div>
