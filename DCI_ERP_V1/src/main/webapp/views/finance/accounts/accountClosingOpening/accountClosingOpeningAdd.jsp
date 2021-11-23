<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
<form class="form-horizontal" name="accountingyearcloseForm"
				ng-submit="save(accountingyearcloseForm)"
				novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>
 						<div class="form-group">
					        				<label class="col-md-5 control-label"> Organization <span style="color: red;">*</span></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="accountingYearClose.companyId" id="hospital"
						        				ng-model="accountingYearClose.companyId" name="hospital" form-name = "accountingyearcloseForm"
						        				validation="required" friendly-name="<spring:message
			              			code="label.company.name"></spring:message>"></selectivity>
											</div>
										</div>
           
							 
						<!-- <div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">From Date
							<span style="color: red;">*</span></label>
							<div class="col-md-7">							
						   		<div class='input-group date datetimepick' style="width: 69%;">
									<div class="dropdown">
										<a class="dropdown-toggle" id="tb_fromdate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="From date"  id="fromdate"
													data-ng-model="accountingYearClose.fromdate">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="accountingYearClose.fromdate" data-on-set-time="accountingYearClose.fromdate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#tb_fromdate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
	       				</div> -->
	       			<div class="form-group ">
								<label class="col-md-5 control-label">From Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="accountingYearClose.fromdate" form-name="accountingyearcloseForm"
										id="txtrealisedDate" name="realisedDate"
										data-ng-change="checkDatesCL(accountingYearClose.fromdate)"
										friendly-name="todate" validation="required" />
								</div>
								</div>       				
	       				<!-- <div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">To Date <span style="color: red;">*</span></label>
							<div class="col-md-7">							
				    			<div class='input-group date datetimepick' style="width: 69%;">
									<div class="dropdown">
										<a class="dropdown-toggle" id="tb_todate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="To date"  id="todate"
													data-ng-model="accountingYearClose.todate">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											</div>
										</a>
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="accountingYearClose.todate" data-on-set-time="accountingYearClose.todate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#tb_todate',startView:'day', minView:'day'}" />
										</ul>
									</div>
								</div>
							</div>
	       				</div> -->
							
						
							<div class="form-group ">
								<label class="col-md-5 control-label">To Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="accountingYearClose.todate" form-name="accountingyearcloseForm"
										id="txtrealisedDate" name="realisedDate"
										data-ng-change="checkDatesCL(accountingYearClose.todate)"
										friendly-name="todate" validation="required" />
								</div>
								</div>    		

					</fieldset>
					</div>
				</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
						 <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-click="submit(accountingyearcloseForm)" data-ng-if="!accountingYearClose.isEdit" >
            <i class="fa fa-save"></i>
            Save
           </button>
          
        <!--      <button class="btn btn-success" class="btn btn-success" type="button" c"
					data-ng-if="accountingYearClose.isEdit" >
        <i class="fa fa-save"></i>
       Update
       </button>  -->
       
           <button class="btn btn-success" type="button" data-ng-click="update(accountingyearcloseForm)" data-ng-if="accountingYearClose.isEdit">
								<i class="class="fa fa-save"></i> Update 
							</button>
	
							
							<button class="btn btn-info" type="reset" ng-click="reset()" data-ng-if="!accountingYearClose.isEdit">
								<i class="fa fa-undo"></i> Reset 
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div> 
</article>
</div>
</section>
</div>


