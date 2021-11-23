
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
      <form name="PayableAgewiseForm" class="form-horizontal" >
 		
 		<div class="col-sm-6 col-md-3 col-lg-3">
				<fieldset>
					<!-- <div class="form-group">
						<label for="inputPassword" class="control-label col-md-5">Date
						<span style="color: red;">*</span></label>
						<div class="col-md-6">							
					   		<div class='input-group date datetimepick' style="width: 121%;">
								<div class="dropdown">
									<a class="dropdown-toggle" id="ap_fromDate" role="button"
										data-toggle="dropdown" data-target="#" href="#">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="From Date"  id="fromDate"
												data-ng-model="accountsRecivable.arDate">
												<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
											
										</div>
									</a>
									<ul class="dropdown-menu" role="menu"
										aria-labelledby="dLabel">
										<datetimepicker data-ng-model="accountsRecivable.arDate" data-on-set-time="accountsRecivable.arDate = onDateSet(newDate)"
											data-datetimepicker-config="{ dropdownSelector: '#ap_fromDate',startView:'day', minView:'day'}" />
									</ul>
								</div>
							</div>
						</div>
       				</div> -->
       				
       				
       				<div class="form-group ">
								<label class="col-md-4 control-label">Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="accountsRecivable.arDate"
										id="fromDate" name="arDate"
										data-ng-change="checkDatesCL(accountsRecivable.arDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
				</fieldset>
		</div>	
 		<div class="col-sm-8 col-md-3 col-lg-4">
 			<button class="btn btn-primary" ng-click="viewReceivableAgewiseReport()">
						<i class="fa fa-search"> View Report</i>
					</button>
					<a id="payableAgewiseExport" style="display: none"
													href="filePath/AccountReceivable.xls" download="AccountReceivable.xls"></a>
			<button class="btn btn-primary" ng-click="exportReceivableAgewiseExcel()">
						<i class="fa fa-download"> Export Excel</i>
					</button>
 		</div>
		<!-- <a id="payableAgewiseExport" style="display:none"
			href="{{filePath}}"
			download="AccountReceivable.xls"></a>
		    				 -->
		    				 
      	<div class="row">
	    	<div class="col-xs-12 padding-top-10">
	    		<div id="jqgrid">
					<table id="ReceivableAgewiseGrid"></table>
					<div id="ReceivableAgewisePage"></div>
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
   