<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
			<form class="form-horizontal" name="prepaidExpMappingForm" role="form">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group">
								<label class="col-md-6 control-label"> Prepaid Expenses Code
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
        <selectivity list="prepaidExpList" id="preExpCode" name ="preExpCode"
           property="prepaidExpMap.preExpCode" ng-model="prepaidExpMap.preExpCode"
           validation="required" 
           friendly-name="Prepaid Expenses Code" form-name="prepaidExpMappingForm"></selectivity>
        							 <!-- <selectivity  list="prepaidExpList" property="prepaidExpMap.preExpCode" id="prepaidExpMapCode"></selectivity> -->
        						</div>
								</div>
								</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group">
								<label class="col-md-6 control-label">Expenses Code
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
        <selectivity list="expList" id="preExpCode" name ="expCode"
           property="prepaidExpMap.expCode" ng-model="prepaidExpMap.expCode"
           validation="required" 
           friendly-name="Expenses Code" form-name="prepaidExpMappingForm"></selectivity>
        							<!--  <selectivity  list="expList" property="prepaidExpMap.expCode" id="expMap"></selectivity> -->
        						</div>
								</div>
						   </div>		
					</div>
					</div>
			</form>
			<div class="form-actions">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<button class="btn btn-success" type="submit" ng-click="submit(prepaidExpMappingForm)">
       								<i class="fa fa-save"></i> SAVE
     					</button>
						<button class="btn btn-info" ng-if="!AgencyTariffData.editFix" ng-click="cancel()">
							<i class="fa fa-reply"></i> CANCEL
						</button>
					</div>
				</div>
			</div> 
		</div>
			
	</div>
</div>
