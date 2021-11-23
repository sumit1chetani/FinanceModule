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
		<%@include file="/views/templates/panel-header-form.jsp"%>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="POST"
			name="QuotationForm" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label"> Quotation NO  </span>
							</label>
							<div class="col-md-5">
								{{quotationNew.quotationNo}}
							</div>
						</div>
 
						<div class="form-group">
							<label class="control-label col-md-4">Delete Remarks <span
								style="color: red;">*</span>

							</label>
							<div class="col-md-5">
								<textarea data-ng-model="quotationNew.deleteRemarks"
									id="deleteRemarks" name="deleteRemarks"
									class="form-control custom-scroll width_100 textareath"
									rows="4"   maxlength="800" friendly-name="approve Remarks"
									validation="required"  >
			            </textarea>
							</div>
						</div>
 

					</fieldset>
				</div>
				 
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success"
							ng-click=deleteQuotation(quotationNew)
							type="button">
							<i class="fa fa-save"></i> Confirm
						</button>

						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="cancel()">
							<i class="fa fa-close"></i> Close
						</button>
					</div>
				</div>
			</div>
		</form>

	</div>
</div>

