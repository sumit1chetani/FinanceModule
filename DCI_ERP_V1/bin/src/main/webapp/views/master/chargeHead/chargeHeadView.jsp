

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
			<form class="form-horizontal" name="chargeHeadForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Head Code</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="code" name="code" maxlength="20"
										ng-model="chargeHead.code" validation="required"
										friendly-name=" chargeHead Code"
										form-name="chargeHeadForm" disabled/> -->
										
							<label>{{chargeHead.code}}</label>				
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Charge Head Name</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="name" name="name" maxlength="100"
										ng-model="chargeHead.name" validation="required"
										friendly-name="name" form-name="chargeHeadForm" disabled/> -->
									<label>{{chargeHead.name}}</label>				
								
								</div>
							</div>
							<div class="form-group">
								<!-- <label class="col-md-4 control-label">City<span
									style="color: red;">*</span></label> <label
									class="col-md- control-label text-left"></label>
								<div class="col-md-5 inputGroupContainer"> -->
								<label class="col-md-4 control-label">Charge Head Group </label>
									<div class="col-md-3">
									<!-- <selectivity list="groupList" id="group"
										name="group"
										property="chargeHead.group"
										ng-model="chargeHead.group" validation="required"
										friendly-name="group"
										form-name="chargeHeadForm" disabled="true"></selectivity> -->
								<label>{{chargeHead.groupName1}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Purchase Ledger Name</label>
								<div class="col-md-3">
								
								<!-- <selectivity list="accountHeadList" id="pName"
										name="pName"
										property="chargeHead.pName"
										ng-model="chargeHead.pName" validation="required"
										friendly-name="pName"
										form-name="chargeHeadForm" disabled ="true"></selectivity> -->
										
					                <label>{{chargeHead.plName}}</label>				
										

									<!-- <input type="text" class="form-control input-sm"
										id="pName" name="pName" maxlength="100"
										ng-model="chargeHead.pName" validation="required"
										friendly-name="pName" form-name="chargeHeadForm" disabled/> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Sales Ledger Name</label>
								<div class="col-md-3">
								
								<!-- <selectivity list="accountHeadList" id="sName"
										name="sName"
										property="chargeHead.sName"
										ng-model="chargeHead.sName" validation="required"
										friendly-name="sName"
										form-name="chargeHeadForm" disabled ="true"></selectivity> -->

					                <label>{{chargeHead.slName}}</label>				


									<!-- <input type="text" class="form-control input-sm"
										id="sName" name="sName" maxlength="100"
										ng-model="chargeHead.sName" validation="required"
										friendly-name="sName" form-name="chargeHeadForm" disabled/> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">SAC No</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="sacNo" name="sacNo" maxlength="100"
										ng-model="chargeHead.sacNo" validation="required"
										friendly-name="sacNo" form-name="chargeHeadForm" disabled/> -->
										
					<label>{{chargeHead.sacNo}}</label>				
										
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Account Head</label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm"
										id="accountHead" name="accountHead" maxlength="100"
										ng-model="chargeHead.accountHeadName"  disabled/>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">CGST %</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="cgst" name="cgst" maxlength="100"
										ng-model="chargeHead.cgst" validation="required"
										friendly-name="cgst" form-name="chargeHeadForm" disabled/> -->
										
										<label>{{chargeHead.cgst}}</label>				
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">SGST %</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="sgst" name="sgst" maxlength="100"
										ng-model="chargeHead.sgst" validation="required"
										friendly-name="sgst" form-name="chargeHeadForm" disabled/> -->
									<label>{{chargeHead.sgst}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">IGST %</label>
								<div class="col-md-3">

									<!-- <input type="text" class="form-control input-sm"
										id="igst" name="igst" maxlength="100"
										ng-model="chargeHead.igst" validation="required"
										friendly-name="igst" form-name="chargeHeadForm" disabled/> -->
																<label>{{chargeHead.igst}}</label>				
								
								
								</div>
							</div>
                         <!-- <div class="form-group">
								<label class="col-md-4 control-label">GST %<span
									style="color: red;"></span></label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm "
										id="gst" name="gst" maxlength="6"
										ng-model="chargeHead.gst" 
										form-name="chargeHeadForm" disabled/>
										
								<label>{{chargeHead.gst}}</label>				
										
										
								</div>
							</div> -->
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Description </label>
								<div class="col-md-3">
									<!-- <textarea ng-model="chargeHead.description"
										name="description" maxlength="250"
										class="custom-scroll width_100 resize-none" rows="3" disabled>
		          						</textarea> -->
		          						
		          			<label>{{chargeHead.description}}</label>				
		          						
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Active </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="isActive" class="checkbox style-0" name="isActive" validation="required"
											ng-model="chargeHead.isActive"/> <i></i>
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
							

							

							<button class="btn btn-danger" type="reset"
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
