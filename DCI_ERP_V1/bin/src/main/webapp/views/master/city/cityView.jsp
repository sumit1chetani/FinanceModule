

<script>


</script>
<style>
.con-ele input {
	height: 30px;
}

.bookingDtlCls {
	border-bottom: 2px solid #23b7e5 !important;
/* 	border-top: 2px solid #23b7e5 !important; */
	/*  border-left: 1px solid #23b7e5 !important;
    border-right: 1px solid #23b7e5 !important; */
}

tbody::before {
	content: '';
	display: block;
	height: 15px;
	/*  border-left: 0px solid  !imNSA-NHAVA SHEVA, INDIA	portant;
   border-right: 1px solid #23b7e5 !important;
       width: 100%; */
}

<
style>a:hover {
	color: black;
}

srrs
.panel .actions {
	right: 8%;
}

.subTable-brs {
	padding: 8px !important;
}
.form-horizontal .control-label{
padding-top :0px !important;
}
</style>


<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="cityForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
						
											
							<div class="form-group">
								<label class="col-md-4 control-label"> City Code :</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="code" name="code" maxlength="20"
										ng-model="city.code" validation="required"
										friendly-name=" city Code"
										form-name="cityForm" disabled /> -->
										
														<label>{{city.code}}</label>				
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> City Name</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="name" name="name" maxlength="100"
										ng-model="city.name" validation="required"
										friendly-name="name" form-name="cityForm" disabled/> -->
										
									<label>{{city.name}}</label>				
										
								</div>
							</div>
							
								<div class="form-group">
								<label class="col-md-4 control-label"> Zip/Postal Code</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="name" name="name" maxlength="100"
										ng-model="city.pin" validation="required"
										friendly-name="name" form-name="cityForm" disabled /> -->
										
											<label>{{city.pin}}</label>				
										
								</div>
							</div>
							<div class="form-group">
								
								<label class="col-md-4 control-label"> State Code</label>
									<div class="col-md-3">
								<!-- 	<selectivity list="stateList" id="city"
										name=city
										property="city.state"
										ng-model="city.state" validation="required"
										friendly-name="state"
										form-name="cityForm" disabled="true"></selectivity> -->
									<label>{{city.stateName}}</label>				
										
										
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"><spring:message
										code="label.country"></spring:message> <spring:message
										code="label.asterisk.symbol"></spring:message> </label>
								<div class="col-md-6 inputGroupContainer">
									<selectivity list="changetypeList"
										property="port.changetype" id="changetype"
										ng-model="port.changetype" name="changetype"
										form-name="cityForm" validation="required"
										friendly-name="Country"></selectivity>
								</div>
							</div> -->

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Description </label>
								<div class="col-md-3" >
									<!-- <textarea ng-model="city.description"
										name="description" maxlength="250"
										class="custom-scroll width_100 resize-none" rows="3" disabled>
		          						</textarea> -->
		          												<label>{{city.description}}</label>				
		          						
		          						
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Active</label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="active" class="checkbox style-0" name="isActive"
											ng-model="city.isActive" disabled/> <i></i>
										</label>
									</div>
								</div>
							</div>
						</fieldset>

					</div>

				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-11">
						
							 <button class="btn btn-danger" type="button"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button> 


						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
