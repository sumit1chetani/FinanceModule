<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal"
				ng-submit="save(phcinvoice,phcinvoicevalidation)">
				<div class="row">
					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Company</label>
								<div class="col-md-7">
									 <selectivity list="companyList"
										property="phcinvoice.customerName" id="customerName"> 
								</div>
							</div>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Voyage
								</label>
								<div class="col-md-7">
									 <selectivity list="voyageList"
										property="phcinvoice.voyageName" id="voyageName"> 
								</div>
							</div>
							
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Pot
									 </label>
								<div class="col-md-7">
									<selectivity list="portList"
										property="phcinvoice.pot" id="pot">  
								</div>
							</div>
							
							
							
							
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">BL NO
									 </label>
								<div class="col-md-7">
									 <selectivity list="blList"
										property="phcinvoice.blNo" id="blNo">  
								</div>
							</div>
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
						
						<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Invoice Date
								</label>
								<div class="col-md-7">
							 	
								</div>
							</div>
							
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Pol
									 </label>
								<div class="col-md-7">
									 <selectivity list="portList"
										property="phcinvoice.pol" id="pol"> 
								</div>
							</div>
							
						
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Mlo
									 </label>
								<div class="col-md-7">
									  <selectivity list="mloList"
										property="phcinvoice.mlo" id="mlo"> 
								</div>
							</div>
							
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
						<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Vessel
								</label>
								<div class="col-md-7">
									 <selectivity list="vesselList"
										property="phcinvoice.vesselName" id="vesselName"> 
								</div>
							</div>
							
						
						
								<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Pod
									 </label>
								<div class="col-md-7">
									  <selectivity list="portList"
										property="phcinvoice.pod" id="pod"> 
								</div>
							</div>
							
							
							
							
							
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Payer
									 </label>
								<div class="col-md-7">
								 <selectivity list="customerList"
										property="phcinvoice.payer" id="payer">  
								</div>
							</div> 
							

						</fieldset>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>
	