<style type="text/css">
.textareath {
	resize: vertical;
	max-height: 100px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 40px !important;
	margin: 2 auto !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%-- <%@include file="/views/templates/panel-header-form.jsp"%> --%>
		
		<div class="panel-heading font-bold" style="font-weight: bolder;">
					Purchase Order</div>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="POST"
			name="ratequotationForm" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<fieldset>
						

					</fieldset>
					<fieldset><span> </span>
						 <span style="color: blue;font-weight: bold;padding-left: 17%;">Budget Amount Exceeded For This Financial Year.</span> 
					<!-- 	<span>Budget Amount Exceeded For This Financial Year </span> -->
					<!-- 	<span style="color: blue;font-weight: bold;">{{rrrNo}}</span>  -->
					<br>
												<!-- ng-if = "row.budgetDefnId != null && row.budgetDefnId != '' 
								&& row.budgetDefnId == undefined " -->
								<div class="col-md-12" >
									<label class="col-md-3 control-label"> </label>
									<div class="col-md-9">
								    	<span> Budget Amount    : <b>{{budgetAmt}}</b></span>  
								    	<br>
								    	<span> Utilized Amount  : <b>{{budgetUtilizedAmt}}</b></span> 
								    	<br>
								    	<span>Balance Amount    : <b>{{budgetAmt - budgetUtilizedAmt}}</b></span>  
								    	</div>
								</div>
								
						<br>	
						<br>
						<span  style="font-weight: bold;padding-left: 30%;">                Do You Want To Proceed?
						</span>
					</fieldset>
				</div>
				 
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success"
							ng-click=Yes()
							type="button">
							<i class="fa fa-check  text"></i> Yes
						</button>

						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="Noo()">
							<i class="fa fa-close"></i> No
						</button>
					</div>
				</div>
			</div>
		</form>

	</div>
</div>


<!-- 

<style type="text/css">
.textareath {
	resize: vertical;
	max-height: 100px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 40px !important;
	margin: 2 auto !important;
}
</style>


<style type="text/css">
.textareath {
	resize: vertical;
	max-height: 100px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 40px !important;
	margin: 2 auto !important;
}
</style>
<div class="form-actions">
<div class="wrapper-md">
	<div class="row">
	
	<div class="panel panel-default panel-default-form">
	<div class="col-sm-12" >
	<span><b>
		RRR
	</b></span>
	</div>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="POST"
			name="ratequotationForm" novalidate>
			
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<fieldset><span>For </span>
						<span style="color: blue;font-weight: bold;">{{customerName}}</span>
						<span>   valid rate is already available  </span>
						<span style="color: blue;font-weight: bold;">{{rrrNo}}</span> 
						<span> for same port pair.. Do you want to deactivate that?
						</span>
					</fieldset>
				</div>
				 
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success"
							ng-click=RRRYes(rrrNo,saveFlag)
							type="button">
							<i class="fa fa-save"></i> Yes
						</button>

						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="RRRNoo()">
							<i class="fa fa-close"></i> No
						</button>
					</div>
				</div>
			</div>
		</form>
</div></div>
	</div>
</div>

 -->

