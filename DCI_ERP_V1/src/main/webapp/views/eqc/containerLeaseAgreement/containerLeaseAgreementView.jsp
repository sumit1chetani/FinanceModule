<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="surchargeMasterForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						
						<div class="form-group">
								<label class="col-md-4 control-label"> Agreement No :</label>
								<div class="col-md-5">
 
										<label class="col-md-1 control-label">{{leaseAgreement.agreementRefNo}}</label>				
										
										
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Lease Reference : </label>
								<div class="col-md-5">
								<label class="col-md-12 " style="padding-top: 6px;">{{leaseAgreement.leasereference}}</label>
									<!-- <textarea ng-model="leaseAgreement.description"
										class="form-control input-sm resize-none" rows="2"
										disabled="true"></textarea> -->
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Agreement Type : </label>
								<div class="col-md-5">
								<label class="col-md-12 " style="padding-top: 6px;">{{leaseAgreement.agreementterm}}</label>
									<!-- <textarea ng-model="leaseAgreement.description"
										class="form-control input-sm resize-none" rows="2"
										disabled="true"></textarea> -->
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Currency : </label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{leaseAgreement.currency}}</label>
									<!-- <textarea ng-model="leaseAgreement.description"
										class="form-control input-sm resize-none" rows="2"
										disabled="true"></textarea> -->
								</div>
							</div>
							
							

							<div class="form-group">
								<label class="col-md-4 control-label">To Date : </label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{leaseAgreement.toDate}}</label>
							
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Modified By : 
								</label>
								<div class="col-md-5">
								<label class="col-md-12 " style="padding-top: 6px;">{{leaseAgreement.modifiedBy}}</label>
						
								</div>
							</div>
							

					

							
							
							
</fieldset>

					</div>


				<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Lease Agreement No :
								</label>
								<div class="col-md-5">
									<label
									class="col-md-1 control-label">{{leaseAgreement.partyAgreementNo}}</label>
							
								</div>


							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Lease  Party :
								</label>
								<div class="col-md-5">
								<label class="col-md-12 " style="padding-top: 6px;">{{leaseAgreement.leaseparty}}</label>
						
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Agreement Date :
								</label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{leaseAgreement.agreementDate}}</label>
									
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">From Date : </label>
								<div class="col-md-5">
								<label
									class="col-md-1 control-label">{{leaseAgreement.fromDate}}</label>
									
							
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Created By :
								</label>
								<div class="col-md-5">
								<label class="col-md-12 " style="padding-top: 6px;">{{leaseAgreement.createdBy}}</label>
						
								</div>
							</div>
							
							
							


							<!-- <div class="form-group">
        <label class="col-md-4 control-label">Charge Declaration</label>
       
         <div class="col-md-5">
         <div class="radio radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" checked="checked" name="surDeclrn" ng_model="leaseAgreement.surDeclrn" value="Y" checked="checked"  ng-disabled="true">
           <i></i>
           Yes
          </label>
         </div>
         <div class="radio  radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0"  ng_model="leaseAgreement.surDeclrn" value="N" checked="checked" name="surDeclrn"  ng-disabled="true">
           <i></i>
           No
          </label>
         </div>
        </div>
        
       </div> -->

		 

                            
						</fieldset>
					</div>
				</div>
				<div class="panel panel-default panel-default-list" 
		st-table="displayedCollection" st-safe-src="rowCollection">
				<div class="panel-body padding-10" style="margin-top: 11px;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_10" st-sort="territoryCode">On hire location</th>
							<th class="sorting width_10" st-sort="region">Freedays</th>
							<th class="sorting width_10" st-sort="territoryHead">Size/Type</th>
							<th class="sorting width_10" st-sort="territoryPerson">Qty</th>
							<th class="sorting width_10" st-sort="territoryPerson">Current stock</th>
							<th class="sorting width_10" st-sort="territoryPerson">Pick Up Ref</th>
							
							
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="onhire in displayedCollection">
							
							
							
							<td class="sorting">{{onhire.onhirelocation}}</td>
							<td class="sorting">{{onhire.containerfreedays}}</td>
							<td class="sorting">{{onhire.size}}</td>
							<td class="sorting">{{onhire.qty}}</td>
							<td class="sorting">{{onhire.currentstock}}</td>
							<td class="sorting">{{onhire.pickupref}}</td>
							
								
						</tr>
					</tbody>
				</table>
			</div>
			</div>
			<%-- footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer> --%>
		</div>
		<div class="panel panel-default panel-default-list" 
		st-table="displayedCollection1" st-safe-src="rowCollection1">
		<div class="panel-body padding-10" style="margin-top: 11px;    width: 30%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_10" st-sort="offhirelocation">Off hire locations</th>
							<th class="sorting width_10" st-sort="quota">Quota</th>
							
							
							
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="offhire in displayedCollection1">
							
							
							
							<td class="sorting">{{offhire.offhirelocation}}</td>
							<td class="sorting">{{offhire.quota}}</td>
							
							
								
						</tr>
					</tbody>
				</table>
			</div>
			</div>
			<%-- footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer> --%>
		</div>
				<br>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" ng-click="cancel()" type="button">Cancel</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

