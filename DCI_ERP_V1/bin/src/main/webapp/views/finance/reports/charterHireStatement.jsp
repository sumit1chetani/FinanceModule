<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  				<div class="panel-body">
    				<form name="charterHireStmtForm" class="form-horizontal" >
		    			<div class="row">
					     	<div class="col-sm-12 col-md-12 col-lg-12">
					     		<div class="col-sm-4 col-md-4 col-lg-4">
									<fieldset>
										<div class="form-group">
		            							<label for="inputPassword" class="control-label col-md-5">From Date
		            							<span style="color: red;">*</span></label>
		           								<div class="col-md-7">
		            									<div class="input-group input-append date" id="chs_fromDate">
		               									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
		               									ng-model="charterHireStmt.chFromDate" name="fromDate" id="txtFromDate">
			           									 <span class="input-group-addon add-on">
		                       								<span class="glyphicon glyphicon-calendar"></span>
		                   								 </span>
		       									     </div>
		           								</div>
		          							</div>
									</fieldset>
								</div>
								<div class="col-sm-4 col-md-4 col-lg-4">
									<fieldset>
											<div class="form-group">
		             							<label for="toDate" class="control-label col-md-5">To Date
		             							<span style="color: red;">*</span></label>
		            								<div class="col-md-7">
		             									<div class="input-group input-append date" id="chs_toDate">
		                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
		                									ng-model="charterHireStmt.chToDate" name="toDate" id="txtToDate">
				           									 <span class="input-group-addon add-on">
		                        								<span class="glyphicon glyphicon-calendar"></span>
		                    								 </span>
		        									     </div>
		            								</div>
		           							</div>
		           					</fieldset>
								</div>
								<div class="col-sm-4 col-md-4 col-lg-4">
									<fieldset>
										<div class="form-group">
											<label for="inputPassword" class="control-label col-md-5">Vessel<span style="color: red;"> </span></label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="charterHireStmt.vesselCode" id="txtVesselCode"></selectivity>
											</div>
										</div>
									</fieldset>
								</div>								    
					     	</div>
						</div>
						<div class="form-actions"><!-- Form Actions -->
					   		<div class="row">
								<div class="col-md-12 ">
									  <security:authorize access="hasRole('${form_code}_${view}')">
				         			<button type="button" class="btn btn-primary" ng-click="viewReport(charterHireStmtForm,charterHireStmt.chFromDate)">
				          				<i class="fa fa-search"> </i>View Charter Statement
				         			</button>
				         			</security:authorize>
				         				  <security:authorize access="hasRole('${form_code}_${view}')">
				         			<button type="button" class="btn btn-primary" ng-click="viewSOAReport(charterHireStmtForm,charterHireStmt.chFromDate)">
				          				<i class="fa fa-search"> </i>View Charter Hire SOA
				         			</button>	         			  	
						          	</security:authorize>
			         			</div>
		      				</div>
		     			</div>
         			</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>