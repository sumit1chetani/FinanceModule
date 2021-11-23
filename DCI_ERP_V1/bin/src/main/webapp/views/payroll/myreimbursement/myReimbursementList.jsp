<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="payslipReportForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Status
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<select class="form-control" ng-model="reimbursementApproval.status">
										   				 <option value="1">Pending</option>
										   					<option value="2">Approved</option>
										   				   <option value="3">Rejected</option>
										   				   <option value="4">Closed</option>
													</select>
												</div>
											</div>	
										</div>
										
										
										<div class="col-sm-6 col-md-6 col-lg-4">
												<div class="col-md-5">
						           					 <button class="btn btn-success"  type="button" data-ng-click="showList(reimbursementApproval.status)">
									     			Submit
									       			</button>
												</div>
										</div>
										</div>
										
								</div>
										
								
																
							  <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		      <!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		       
		         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="width_1"></th>
		           <th class="sorting width_10" st-sort="employeeNo">Employee No</th>
		           <th class="sorting width_10" st-sort="employeeName">Employee Name</th>
		           <th class="sorting width_15" st-sort="reimbursementType">Reimbursement Type</th>
		           <th class="sorting width_10" st-sort="description">Description</th>
		           <th class="sorting width_10" st-sort="payMode">Payment Mode</th>
		           <th class="sorting width_10" st-sort="amt">Amount</th>
		           <th class="sorting width_10" st-sort="status">Status</th>
                   <th class="sorting width_5" data-st-sort="action">Action</th>
		          </tr>
		         </thead>
		         <tbody class="dataTables-Main-Body">
		         	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="reimburseMentList in displayedCollection">
		         		<td cs-select="objVesselMasterItem"></td>
		         		<td>{{reimburseMentList.employeeId}}</td>
					<td>{{reimburseMentList.employeeName}}</td>
		         	<td>{{reimburseMentList.reimbusementName}}</td>
					<td>{{reimburseMentList.description}}</td>
					<td>{{reimburseMentList.paymentMode}}</td>
					<td>{{reimburseMentList.amount}}</td>
		         		<td>
             	 	 <span ng-if="reimburseMentList.status == '1'">Pending</span>
                 <span ng-if="reimburseMentList.status == '2'">Approved</span>
                 <span ng-if="reimburseMentList.status == '3'">Rejected</span>
                 <span ng-if="reimburseMentList.status == '4'">Closed</span>
                     </td>
		         		
			          
          <td class=" td-actions text-center">
		 <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="view" ng-click="add(reimburseMentList.reimbursementId)">
									  <i class="fa fa-eye"></i>
									       View
						        </button>
	
       </td>
				     </tr>
		         </tbody>
		        </table>
		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
	        </div>
	        	</div>
								</div>
							</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>















































