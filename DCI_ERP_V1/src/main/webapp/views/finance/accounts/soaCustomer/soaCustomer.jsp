<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<style>
.dropdown-menu>li>a {
	padding: 5px 36px;
}

.form-control {
	border: 1px solid #DDD;
	border-radius: 7px;
	box-shadow: none;
	height: 42px;
	padding: 8px 12px 9px 12px;
}
</style>


<security:authentication var="user" property="principal" />


		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  					<input type="hidden" value="${form_code}" id="form_code_id">
  				<div class="panel-body">
					       <form class="form-horizontal" name="soaCustomer">
									<div class="row">
					
					
						<div class="col-sm-12 col-md-4 col-lg-4">
				          	<div class="form-group">
								<label class="col-md-6 control-label">Statement For</label>
								<div class="col-md-6">
									<select  class="form-control input-sm" ng-model="soa.type"  name="stmtType">
								        <option value=""> --Select--</option>
								        <option value="customer">Customer</option>
								        <option value="supplier">Supplier</option>
								    </select>
								</div>
							</div>

		          		</div>
		          		
		          		<div class="col-sm-12 col-md-4 col-lg-4">
											<fieldset>
											<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From
											Date <!-- <span style="color: red;">*</span> -->
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="tb_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="soa.fromDate"
													name="fromDate" id="fromDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
							
											</fieldset>
										</div>
										
											<div class="col-sm-12 col-md-4 col-lg-4">
											<fieldset>

<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-6">
											<div class="input-group input-append date" id="tb_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="soa.toDate"
													name="toDate" id="toDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
									

											</fieldset>
										</div>
										</div>
										
		          		
		          		<!-- <div class="col-sm-12 col-md-4 col-lg-4" >
			          		<div class="form-group" >
								<div class="col-md-12" style ="align:center";>
			            			<button class="btn btn-primary" ng-click="getSOACustomerReport();">
										<i class="fa fa-search"> View Report</i>
									</button>
		            				<button class="btn btn-primary" ng-click="exportChqExcel()">
										<i class="fa fa-search"> Export Excel</i>
									</button>
	            				</div>
            				</div>
		          		</div> -->
		          		
		          		
		          		<div class="form-actions">
										<div class="row">
											<div class="col-md-12 ">
                                          <button class="btn btn-primary" ng-click="getSOACustomerReport();">
										<i class="fa fa-search"> View Report</i>
									</button>
									<a id="TBExport" style="display: none"
													href="filePath/StatementOfAccounts.xls" download="StatementOfAccounts.xls"></a>
										<button class="btn btn-primary" ng-click="exportChqExcel()">
										<i class="fa fa-search"> Export Excel</i>
									</button>
												
												
											</div>
										</div>
									</div>



		      <div class="row">
					<div class="padding-left-5 padding-top-5" id="jqgrid">
						<div id="inventGrid">
			  				<table id="soagrid"></table>
			  				<div id="soapage"></div>
		  				</div>
					</div>
			  </div>

			  <div class="row" ng-if="soa.type!=''">
			  		<div class="col-xs-10 col-xs-offset-6 padding-top-5">
		          	<div class="form-group">
						<label class="col-md-5 control-label" ng-if="soa.type=='customer'">Debtors Outstanding</label>
						<label class="col-md-5 control-label" ng-if="soa.type=='supplier'">Creditors Outstanding</label>
						<div class="col-md-2">
							<input type="text" class="form-control input-sm text-right" id="totalQty" readonly="readonly">
						</div>
					</div>
					</div>
        	</div>
        	
   		 </form>
      <!-- end widget content -->
     <!-- end widget div -->
    </div>
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>