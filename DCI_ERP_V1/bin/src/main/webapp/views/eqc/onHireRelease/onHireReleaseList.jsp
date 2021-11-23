<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="onHireReleaseTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
<form name="userLogForm" method="post" class="form-horizontal" novalidate>
     
    
    <!-- /row -->
    <div class="form-actions text-center">
     <div class="row ">
     
      <div class="col-md-offset-3 col-md-5">
    
       <button class="btn btn-primary" data-ng-click="exportExcel()">
										<i class="fa fa-file-excel-o"> </i> Export to Excel <a
											id="onHireExport" stype="display:none"
											href="filePath/Container_On_Hire_Release.xls"
											download="Container_On_Hire_Release.xls"></a>
									</button>
													     
      </div>
        
     </div>
     
    </div>
   </form>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			 <div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_10" st-sort="releaseRefno">Release Ref. No.</th>
							<th class="sorting width_10" st-sort="agreementRefno"> Agreement Ref. No.</th>
<!--  							<th class="sorting width_10" st-sort="port">Port</th>
 -->							
 		                     <th class="sorting width_10" st-sort="referenceNo">Reference No.</th>
                               <th class="sorting width_10" st-sort="leaseType">Lease Type</th>
							<th class="sorting width_10" st-sort="leasingParty">Lessor</th>
<!-- 							<th class="sorting width_10" st-sort="party_agreement_refno">Lease Ref No</th>
 -->							<th class="sorting width_10" st-sort="agreementpPartyName">Agreement Party</th>
		                    <th class="sorting width_7" st-sort="freeDays">Free Days</th>
		                     <th class="sorting width_6" st-sort="port">Port</th>
							<th class="sorting width_6 text-center table-heading ">Action</th>	
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">
	
							<td class="sorting" data-toggle="tooltip"
												title="{{item.releaseRefno}}"><a ng-click="View(item.releaseRefno)">
		             <span tooltip="{{item.releaseRefno}}" class="tool-tip-span font-blue">{{item.releaseRefno}}</span></a></td>
							<td class="sorting" ng-if="item.releaseRefno==='' || item.releaseRefno===null">  <a ng-click="editCro(item.agreementRefno )"> 
		             			<span tooltip="{{item.agreementRefno}}" class="tool-tip-span font-blue ">{{item.agreementRefno}}</span>
		        				 </a> </td> 
		       				 <td  class="sorting" ng-if="item.releaseRefno !='' && item.releaseRefno !=null"> {{item.agreementRefno}} </td>
		       				  <td  class="sorting" data-toggle="tooltip" title="{{item.referenceNo}}"> {{item.referenceNo}} </td>
							 <!-- <td class="sorting" data-toggle="tooltip" title="{{item.agreementRefno}}">{{item.agreementRefno}}</td>
                            <td class="sorting" data-toggle="tooltip"	title="{{item.agent}}">{{item.agent}}</td> 
							<td class="sorting" data-toggle="tooltip" title="{{item.port}}">{{item.port}}</td>-->
							<td class="sorting" data-toggle="tooltip" title="{{item.leaseType}}">{{item.leaseType}}</td>
							
								<td class="sorting" data-toggle="tooltip" title="{{item.leasingParty}}">{{item.leasingParty}}</td>
<!-- 									<td class="sorting" data-toggle="tooltip" title="{{item.party_agreement_refno}}">{{item.party_agreement_refno}}</td>
 -->										<td class="sorting" data-toggle="tooltip" title="{{item.agreementpPartyName}}">{{item.agreementpPartyName}}</td>
										
							<td class="sorting" data-toggle="tooltip" title="{{item.freeDays}}">{{item.freeDays}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.port}}">{{item.port}}</td>
							<td class=" td-actions text-center"  ng-show="item.releaseRefno !='' && item.releaseRefno !=null"> <%-- <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(item.releaseRefno)"></i>
									</span>
<%-- 								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
 --%>									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.releaseRefno)"></i>
									</span>
<%-- 								 </security:authorize>
 --%>								 </td> 
						 <td class=" td-actions text-center"  ng-show="item.releaseRefno==='' || item.releaseRefno===null"> 	</td>		 
						</tr>
					</tbody> 

				</table>
			</div> 
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>