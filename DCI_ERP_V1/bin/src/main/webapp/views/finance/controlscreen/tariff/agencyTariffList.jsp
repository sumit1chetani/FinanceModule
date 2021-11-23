<div class="wrapper-md">
 <div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
   <div class="panel panel-default panel-default-form">
  <div class="panel-body">
  <form class="form-horizontal" name="agencyTariffAddForm" role="form">
			<!-- 	<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-5 col-md-5 col-lg-5">
						  	<div class="form-group">
								<label class="col-md-6 control-label"> Agent
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
						        <selectivity  list="activeAgentNameList" property="agentId"></selectivity>
						        </div>
							</div>
						</div>
						<div class="col-sm-5 col-md-5 col-lg-5">
						  	<div class="form-group">
								<label class="col-md-6 control-label"> Copy Agent
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
						        <selectivity  list="agentNameList" property="copyAgentId"></selectivity>
						        </div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12">
						<button class="btn btn-primary" ng-click="copyAgent()">
							<i></i> COPY
						</button>
					</div> -->
		</form>
	</div>
	</div>
  <div class="panel-body float-left padding-0">
<div class="table-responsive ">
 <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
          <tr>
<!--             <th class="width_05"> -->
<!--             <label class="i-checks m-b-none"> -->
<!--             <input type="checkbox" name="post[]" > -->
<!--              <i></i> -->
<!--            </label> -->
<!--        </th> -->
           <th class="sorting width_05" st-sort="agentCode" ng-show="true">Agent Code</th>
           <th class="sorting width_3" st-sort="agentName" ng-show="true">Agent Name</th>
             <th class="sorting width_3" st-sort="agentName" ng-show="true">Port</th>
           <!-- <th class="sorting width_05" st-sort="port" ng-show="true">Port</th> -->
          <!--  <th class="sorting width_1" st-sort="sectorcode" ng-show="true">Sector Code</th> -->
           <th class="width_05">Action</th>
          </tr>
          </thead>
	      <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objAgencyTariffItem in displayedCollection">
<!-- 	       <td class=" "><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
<!-- 	       </label></td> -->
	       <td>
	  			<a ng-click="onView(objAgencyTariffItem)">
		             <span tooltip="{{objAgencyTariffItem.agentCode}}" class="tool-tip-span font-blue">{{objAgencyTariffItem.agentCode}}</span>
		         </a>
		        </td>
	       <td>{{objAgencyTariffItem.agentName}}</td>
	       <td>{{objAgencyTariffItem.pol}}</td>
	      <!--  <td>{{objAgencyTariffItem.service}}</td> -->
	       <td class=" td-actions text-center">
	        <span>
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objAgencyTariffItem,$index)"></i>
	        </span>
	        <span>
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objAgencyTariffItem,$index)"></i>
	        </span>
	       </td>
	      </tr>
	     </tbody>
          </table>
        </div>
      <footer class="panel-footer panel-footer-list">
   		 <%@include file="/views/templates/panel-footer-static.jsp"%>
   		<!--  <button class="btn btn-primary" type="button" ng-click="openFileModal()" >Upload Statement</button>  -->
   	  </footer>
       </div>
  </div>
  </div>
   <script type="text/ng-template" id="fileModal">

	<div class="modal-header"> File Upload</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadTariffFile(this)"  accept=".xls,.xlsx,.xlsm" />
				</div>
			</div> 
		</div>
		<div class="modal-footer">
			<button class="btn btn-info" type="button" ng-click="uploadTariff()">OK</button>
			<button class="btn btn-danger" ng-click="closeTariffDialog()">Cancel</button>
		</div>
 </script>