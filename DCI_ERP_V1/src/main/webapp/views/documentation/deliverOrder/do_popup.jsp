<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 100px !important;
	margin: 0 auto !important;
}
.bootstrap-datetimepicker-widget{
	z-index:10000 !important;
}
.ngdialog-overlay{
 
 }
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- <div class="breadcrumb-wrapper ng-scope"> -->
	<div class="panel panel-default panel-default-form ">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%> --%>
		<div class="panel-body">
			<form name="doPopUpForm" class="form-horizontal" novalidate>
				<br>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"> Cheque/Receipt
									No.<span
									style="color: red;">*</span> </label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="chequeNo" id="chequeNo"
										validation="required" friendly-name="Cheque/Receipt No." 
										ng-model="deliveryorder.chequeNo"
										form-name="doPopUpForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label"> Remarks </label>
								<div class="col-md-7">
									<textarea type="text" class="form-control input-sm"
										name="paymentRemarks" form-name="doPopUpForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.paymentRemarks">
									</textarea>
								</div>
							</div>


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"> Payment Date <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<div class="input-group input-append date">
			        			  	<input type="text" class="form-control input-sm" name="receiptDate" id="receiptDateId"
			        			  	ng-model="deliveryorder.receiptDate" placeholder='dd/mm/yyyy' validation="required" friendly-name="Paid Date" form-name="doPopUpForm"/>
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
									
									
									<!-- <ng-bs3-datepicker data-ng-model="deliveryorder.receiptDate"
										id="receiptDate" name="receiptDate"
										validation="required" friendly-name="Paid Date" 
										form-name="doPopUpForm"/> -->
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label"> Amount<span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="amount"
									validation="required" friendly-name="Amount" 
										id="amount" ng-model="deliveryorder.amount"
										form-name="doPopUpForm"/>
								</div>
							</div>
						</fieldset>
					</div>
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" type="button" 
									class="btn btn-success"
									ng-click="updateDoPop(doPopUpForm)">
									<i class="fa fa-save"></i> Save
								</button>
								<button class="btn btn-danger" type="button"
									class="btn btn-danger" ng-click="cancelDoPop()">
									<i class="fa fa-close"></i> Cancel
								</button>
							</div>
						</div>
					</div>
			</form>
		</div>
	</div>
<!-- </div> -->
<script>
$(".ngdialog-close").remove();
</script>
