<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%--  <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id" /> --%>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row book-widget-row">

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-5">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-3 bold">Agent
										:</label>
									<div class="col-md-8">
										{{provisionalAllocation.agentName}}</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Month
										:</label>
									<div class="col-md-7">
										{{provisionalAllocation.monthOfYear}}</div>
								</div>
							</div>


						</fieldset>
					</div>
				</div>

			</div>

			<div class="panel-body float-left padding-0">
				<div class="table-responsive ">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="sorting width_20" st-sort="voyageNo">Voyage</th>
								<th class="sorting width_15" st-sort="portCode">Port</th>
								<th class="sorting width_20" st-sort="sailedDate">Sailing
									Date</th>
								<th class="sorting width_15" st-sort="amountLocal">TC
									Amount</th>
								<th class="sorting width_15" st-sort="amountUsd">BC Amount (USD)</th>
                                <th class="sorting width_15" st-sort="estimateAmt">Estimate Amount (USD)</th>
								<th class="sorting width_15" st-sort="status">Status</th>
                                <th class="sorting width_15" >PIA/PDA No.</th>
                                <!-- <th class="sorting width_15" >PDA No.</th> -->
								<th class="text-center width_15">Action</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="ObjList in displayedCollection">
								<td class="sorting ">{{ObjList.voyageNo}}</td>
								<td>{{ObjList.portCode}}</td>
								<td class="sorting ">{{ObjList.sailedDate}}</td>
								<td class="sorting text-right">{{ObjList.amountLocal}}</td>
								<td class="sorting text-right">{{ObjList.amountUsd}}</td>
         `                      <td class="sorting text-right">{{ObjList.estimateAmt}}</td>
								<td class="sorting ">{{ObjList.status}}</td>
                               <td>
                                <span ng-if="ObjList.status=='Approved'" ng-repeat="jvno1 in ObjList.invoiceList">
                                	<a ng-click="view(jvno1.text)"> 
                                      <span  class="tool-tip-span font-blue">{{jvno1.text}}</span>
                                    </a>
                                </span>
                                <span ng-if="ObjList.status=='Draft'" ng-repeat="inLPDA in ObjList.invoicedftList">
                                	<a ng-click="view(inLPDA.text)"> 
                                      <span  class="tool-tip-span">{{inLPDA.text}}</span>
                                    </a>
	                                		
	                            </span>
                               </td>
                               <!-- <td>
	                                <span ng-if="ObjList.status=='Draft'" ng-repeat="inLPDA in ObjList.invoicedftList">
	                                		<span  class="tool-tip-span">{{inLPDA.text}}</span>
	                                </span>
                               </td> -->
								<td class=" td-actions text-center"><span ng-if="ObjList.status=='Pending'"> <i
										class="fa fa-plus  text"
										data-ng-click="viewDisProvision(ObjList)"></i>
								</span>                            
                           </td>
                           
                           
                          
							</tr>
						</tbody>
					</table>
				</div>
				
				<footer class="panel-footer panel-footer-list">
					<%@include file="/views/templates/panel-footer.jsp"%>
				</footer>
			</div>
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
			<!-- /panel-body -->
		</div>
	</div>
</div>
