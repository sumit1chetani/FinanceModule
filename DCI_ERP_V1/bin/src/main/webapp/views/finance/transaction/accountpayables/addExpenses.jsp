<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
   <div class="panel-body">
			<form class="form-horizontal" name="addExpensesForm" role="form">
				<div class="row book-widget-row">
					<div class="col12" align="center">
								<div class="form-group">
									<label class="col-md-5 control-label">Expenses Type
							    	</label>
									<div class="col-sm-3" ng-if="isEdit==false"> 
                                     <selectivity  list="expensesList" property="ExTypeData.exType" id="exType" ></selectivity>
									 </div>
                                      <div class="col-sm-3" ng-if="isEdit==true"> 
                                     	<input type="text" class="form-control input-sm" name="Notice Period" ng-model="ExTypeData.exTypeName" readonly>
                                      </div>
								</div>
					</div>
						<div class="col12" align="center">
								<div class="form-group">
									<label class="col-md-5 control-label">Expenses Name
								    </label>
									<div class="col-sm-3"> 
									 	<input type="text" class="form-control input-sm" name="Notice Period" ng-model="ExTypeData.exDesc" >
									 </div>
								</div>
						</div>
					
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-actions">
								<button class="btn btn-success" type="submit" ng-if="isEdit==false" ng-click="saveExpence()">
		       								<i class="fa fa-save"></i> Save
		     					</button>
                                <button class="btn btn-success" type="submit" ng-if="isEdit==true"  ng-click="editExpence()">
                                     <i class="fa fa-save"></i> Update
                                </button>
								<button class="btn btn-primary" type="reset" ng-if="isEdit==false">
									<i class="fa fa-undo"></i> Reset
								</button>
                                <button class="btn btn-danger" ng-click="cancel()">
                                 <i class="fa fa-arrow-left"></i> Back
                                </button>
                                 <button class="btn btn-danger" ng-click="goToDisbursementAcct()">
                                 <i class="fa fa-arrow-left"></i> Back To Disbursement Account
                                </button>
							</div>
						</div> 
				</div>
			</form>
		</div>
	</div>
</div>