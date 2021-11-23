 <style>
 .ngdialog-overlay{
 
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	    max-width: 100%;
    width: 75%;
    position: absolute;
    top: 20%;
    left: 7%;
    margin: 0 auto;
}
.bootstrap-datetimepicker-widget{
	z-index:10000 !important;
}
</style>
<div class="wrapper-md">
	 <div class="panel-body float-left padding-0">
	 		<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
					<fieldset>
						<legend>Are you sure ? </legend>
						<div class="form-group" ng-if="screenNames=='payment'">
		        			<label class="col-md-2 control-label line-height-30">Payment Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
			        			  	<input type="text" class="form-control input-sm" name="PaymentDate" id="txtcbPmtReverseDate"
			        			  	ng-model="cbReverseObj.cashbankPmtDate" placeholder='dd/mm/yyyy' />
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
	     				<div class="form-group" ng-if="screenNames=='receipt'">
		        			<label class="col-md-2 control-label line-height-30">Receipt Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
			        			  	<input type="text" class="form-control input-sm" name="Receipt Date" id="txtcbRcptReverseDate"
			        			  	ng-model="cbrcptReverseObj.cbReceiptDate" placeholder='dd/mm/yyyy' />
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
	     				<div class="form-group" ng-if="screenNames=='purchaseinvoice'">
		        			<label class="col-md-2 control-label line-height-30">Invoice Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
			        			  	<input type="text" class="form-control input-sm" name="Inovoice Date" id="txtPinReverseDate"
			        			  	ng-model="pinReverseObj.puchaseInvoiceDate" placeholder='dd/mm/yyyy' />
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
	     				<div class="form-group" ng-if="screenNames=='provisionforwriteoff'">
		        			<label class="col-md-2 control-label line-height-30">Invoice Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
			        			  	<input type="text" class="form-control input-sm" name="Invoice Date" id="txtPinReverseDate"
			        			  	ng-model="pinReverseObj.reversedWriteoffDate" placeholder='dd/mm/yyyy' />
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
			       				
		        			</div>
		        							<div class="col-md-12" style="padding-top: 20px;"></div>
		        					        			<label class="col-md-2 control-label line-height-30" style="padding-left: 1px;">Reason for Writeoff<span style="color:red;"> *</span></label>
		        					        			<div class="col-md-5">
		        					        			<textarea ng-model="pinReverseObj.reverseWriteoff"
											name="reasonForWriteoff" maxlength="250"
											class="custom-scroll width_100 resize-none" rows="3">
		          						</textarea></div>
		        			
	     				</div>
	     				
	     				
	     				<div class="form-group" ng-if="screenNames=='journalvoucher'">
		        			<label class="col-md-2 control-label line-height-30">JV Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
		          					<input type="text" class="form-control input-sm" name="JV Date" id="txtJvReverseDate"
			        			  	ng-model="jvReverseObj.dataOfIssue" placeholder='dd/mm/yyyy' />
			        			  	
			        			  	<!-- <input type="text" class="form-control input-sm" name="JV Date" id="txtJvReverseDate"
			        			  	ng-model="jvReverseObj.dataOfIssue" placeholder='dd/mm/yyyy' /> -->
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
	     				<div class="form-group" ng-if="screenNames=='approvalDialog'">
		        			<label class="col-md-2 control-label line-height-30">Approval Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date" id="approval_Date">
			        			  	<input type="text" class="form-control input-sm" name="Approval Date" id="approvalDate"
			        			  	ng-model="prepaidExp.approvalDate" placeholder='dd/mm/yyyy' />
			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
	     				<div class="form-group" ng-if="screenNames=='lpo'">
		        			<label class="col-md-2 control-label line-height-30">LPO Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
		          					<input type="text" class="form-control input-sm" name="LPO Date" id="txtLpoReverseDate"
			        			  	ng-model="lpoData.lpoDate" placeholder='dd/mm/yyyy' />

			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
	     				<div class="form-group" ng-if="screenNames=='pcn'">
		        			<label class="col-md-2 control-label line-height-30">PCN Date<span style="color:red;"> *</span></label>
		        			<div class="col-md-3">
		          				<div class="input-group input-append date">
		          					<input type="text" class="form-control input-sm" name="PCN Date" id="txtpcnDate"
			        			  	ng-model="pcnData.pcnDate" placeholder='dd/mm/yyyy' />

			         				 <span class="input-group-addon add-on">
			         			  		<span class="glyphicon glyphicon-calendar"></span>
			         			 	</span>
			       				</div>
		        			</div>
	     				</div>
					</fieldset>
				</div>
			</div>
			<div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-12">			     
			      	<div class="form-actions m-b-none">			       
			       		<button class="btn btn-info" type="button" ng-click="reverseConfirm()">OK</button>
						<button class="btn btn-danger" ng-click="closeCBPReverseDialog()">Cancel</button>			        
			       </div>
			     </div>
			    </div>
	 </div>
 </div>