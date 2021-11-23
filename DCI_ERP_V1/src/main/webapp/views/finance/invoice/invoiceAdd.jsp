<style type="text/css">
.ngdialog-content{
	width: 50% !important;
  	bottom: 160px !important;
  	margin: 0 auto !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
	  	<%@include file="/views/templates/panel-header-form.jsp"%>			  
		<div class="panel-body">
  			<form class="form-horizontal" name="invoiceAddForm" role="form">
	  			<div class="row book-widget-row">   			 
	   			 	<div class="col-sm-12 col-md-12 col-lg-12">
				      <div class="col-sm-4 col-md-4 col-lg-4">
	      				<fieldset>
	      					<div class="form-group">
						        <label class="col-md-5 control-label">
						         Location
						         <span style="color: red;">*</span>
						        </label>
						        <div class="col-md-6">
									<selectivity list="companyList" property="vesselData.companyCode" id="company" object="companyObj"></selectivity>
						        </div>
						     </div>
						     <div class="form-group">
					             <label for="inputPassword" class="control-label col-md-5">Invoice Date</label>
					            <div class="col-md-6">
					             <div class="input-group">
									 <div class='input-group date datetimepick' >
						                 <input type="text" class="form-control" ng-model="vesselData.invoicedate" placeholder="dd/mm/yyyy" id="invoiceDate" 
						                     value="{{vesselData.invoicedate}}" />
						                  <span class="input-group-addon">
						                     <span class="glyphicon glyphicon-calendar">
						                     </span>
						                  </span>
						              </div>
					             </div>
					            </div>
				           	 </div>
						     <div class="form-group">
						        <label class="col-md-5 control-label">
						         POL
						        </label>
						        <div class="col-md-6">
									<selectivity list="polList" property="vesselData.portid" id="portid" object="portObj"></selectivity>
						        </div>
					         </div>
						     <div class="form-group">
						        <label class="col-md-5 control-label">
						         Customer
						        </label>
						        <div class="col-md-6">
									 <selectivity list="mloList" property="vesselData.mlo" id="mlo"></selectivity>
						        </div>
					         </div>
						  </fieldset>
				      </div>
				      <div class="col-sm-4 col-md-4 col-lg-4 margin-top-3">
	      				<fieldset>
	      					  <div class="form-group">
						        <label class="col-md-5 control-label">
						         Vessel
						         <span style="color: red;">*</span>
						        </label>
						        <div class="col-md-6">
									<selectivity list="vesselList" property="vesselData.vesselid" id="vesselid" object="vessel"></selectivity>
						        </div>
									
					         </div>
						     <div class="form-group">
						        <label class="col-md-5 control-label">
						         Slot A/C
						        </label>
						        <div class="col-md-6">
										<selectivity list="slotList" property="vesselData.slot" id="slot"></selectivity>
						        </div>
					         </div>
						     <div class="form-group">
						        <label class="col-md-5 control-label">
						         BL No
						         <span style="color: red;">*</span>
						        </label>
						        <div class="col-md-6">
									<selectivity list="blnoList" property="vesselData.blno" id="blno"></selectivity>
						        </div>
					         </div>
						  </fieldset>
				      </div>
				      <div class="col-sm-4 col-md-4 col-lg-4 margin-top-3">
	      				<fieldset>
					         <div class="form-group form-group-label-left">
						        <label class="col-md-5 control-label">Voyage
						        <span style="color: red;">*</span></label>
						        <div class="col-md-6">
									<selectivity list="voyageList" property="vesselData.voyageNo" id="voyageNo"></selectivity>
						       </div>
						      </div>
					          <div class="form-group form-group-label-left">
						        <label class="col-md-5 control-label">Service</label>
						        <div class="col-md-6">
						         <input type="text" class="form-control input-sm" id="serviceId" ng-model="vesselData.service" readonly>
						        </div>
						       </div>
						     <div class="form-group form-group-label-left">
						        <label class="col-md-5 control-label">Activity</label>
						        <div class="col-md-6">
									<input type="text" class="form-control input-sm" name="activity" ng-model="vesselData.activity" id="activityId"
												          readonly>
								</div>
					         </div>
						  </fieldset>
				      </div> <!-- /col-sm-4 col-md-4 col-lg-4 -->
				   </div> <!-- /col-sm-12 col-md-12 col-lg-12 -->
				<div class="col-md-12 col-md-offset-6"  ng-hide = "IsVisible">
					      <button class="btn btn-success" type="button"
						  ng-click="show()"><span class="glyphicon glyphicon-floppy-disk" style="color: white;"></span> Generate</button>
				</div>
			
			<div ng-show = "IsVisible">
				   		<div class="col-sm-12 col-md-12 col-lg-12" >
	      				<fieldset>
	      					<div class="col-sm-4 col-md-4 col-lg-4 padding-left-0 padding-right-0">
		      					<div class="form-group">
							        <label class="col-md-5 control-label">
							         POL
							        </label>
							        <div class="col-md-6 width_47">
										<input type="text" class="form-control input-sm" name="polgen" ng-model="vesselData.polgen"
													          readonly>
									</div>
							     </div>
						     </div>
						     <div class="col-sm-4 col-md-4 col-lg-4 padding-left-0 padding-right-0">
							     <div class="form-group">
							        <label class="col-md-5 control-label">
							         POD
							        </label>
							        <div class="col-md-6 width_47">
										<input type="text" class="form-control input-sm" name="podgen" ng-model="vesselData.podgen"
													          readonly>
									</div>
							     </div>
						     </div>
						     <div class="col-sm-4 col-md-4 col-lg-4 padding-left-0 padding-right-0">
							     <div class="form-group">
							        <label class="col-md-5 control-label">
							         POT
							        </label>
							        <div class="col-md-6 width_47">
										<input type="text" class="form-control input-sm" name="potgen" ng-model="vesselData.potgen"
													          readonly>
									</div>
							     </div>
						     </div>
	      				</fieldset>
	      				</div>
	      			<div class="col-sm-12 col-md-12 col-lg-12" >
				      <div class="col-sm-6 col-md-6 col-lg-6 padding-left-30 padding-right-0">
	      				<fieldset>
	      					<div class="form-group">
						        <label class="col-md-3 control-label">
						         Quotation
						        </label>
	
						        <div class="col-md-4" ng-if="quotationList.length == 1">
						          	<input type="text" class="form-control input-sm" name="quotation" ng-model="vesselData.quotation"
												          readonly>
						        </div>
						        <div class="col-md-4" ng-if="quotationList.length > 1">
						        	<selectivity list="quotationList" property="vesselData.quotation" id="quotation" object="quotationObj"></selectivity>
						        </div>
						        
						     </div>
						     <div class="form-group">
						        <label class="col-md-3 control-label">
						         Currency
						        </label>
						        <div class="col-md-4">
						         <input type="text" class="form-control input-sm" name="currency" ng-model="vesselData.currency"
						          message-id="currency" id="currency" readonly>
						        </div>
						     </div>
						     <div class="form-group">
						        <label class="col-md-3 control-label">
						         Customer
						        </label>
						        <div class="col-md-8">
						         <input type="text" class="form-control input-sm" name="mlotxt" ng-model="vesselData.mlotxt"
						          message-id="mlotxt" id="mlotxt" readonly>
						        </div>
						     </div>
					          <div class="form-group">
					           <label class="control-label col-md-3 col-lg-3">Remarks</label>
					           <div class="col-md-8">
					           <textarea rows="2" cols="35" class="form-control text-left" ng-model="vesselData.remarks" name="remarks" style="resize:none" readonly></textarea>
					           </div>
					          </div>
	      				</fieldset>
				      </div> <!-- /col-sm-6 col-md-6 col-lg-6 -->
				      <div class="col-sm-6 col-md-6 col-lg-6 padding-left-30 padding-right-0">
	      				<fieldset>
	      					<div class="form-group">
						        <label class="col-md-3 control-label margin-left-33-5">
						         Valid Till
						        </label>
						        <div class="col-md-4">
						         <input type="text" class="form-control input-sm" name="validtill" ng-model="vesselData.validtill"
						          message-id="validtill" id="validtill" readonly>
						        </div>
						     </div>
						     <div class="form-group">
						        <label class="col-md-3 control-label margin-left-33-5">
						         Exchange Rate
						        </label>
						        <div class="col-md-4">
						         <input type="text" class="form-control input-sm" name="exchangerate" ng-model="vesselData.exchangerate"
						          message-id="exchangerate" id="exchangerate" readonly>
						        </div>
						     </div>
						     <div class="form-group">
						        <label class="col-md-3 control-label">
						         Payer
						        </label>
						        <div class="col-md-8">
						         <input type="text" class="form-control input-sm" name="payer" ng-model="vesselData.payer"
						          message-id="payer" id="payer" readonly>
						        </div>
						     </div>
						     <div class="form-group">
					           <label class="control-label col-md-3 col-lg-3">Reason</label>
					           <div class="col-md-8">
					           <textarea id="reason" rows="2" cols="35" class="form-control text-left" name="reason" style="resize:none"></textarea>
					           </div>
					          </div>
	      				</fieldset>
	      			</div> <!-- /col-sm-6 col-md-6 col-lg-6 -->
				</div> <!-- /col-sm-12 col-md-12 col-lg-12 -->
	      			<div class="panel-body jarvis-content col-sm-12 col-md-12 col-lg-12">
						<div class="widget-body no-padding ">
	
							<div class="table-responsive ">
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer">
			      					<thead class="dataTables-Main-Head">
			      						<tr>
											<th class="width_12" rowspan="2" colspan="2">Charges</th>
											<th class="width_7" colspan="2" ng-repeat="objInvoiceItem in tableRowColl.containerType">{{objInvoiceItem.text}}</th>
											<!-- <th class="width_7" colspan="2">M40</th> -->
											<!-- <th class="width_7" colspan="2">M45</th> -->
											<!-- <th class="width_7" colspan="2">D20</th> -->
											<!-- <th class="width_7" colspan="2">D40</th> -->
											<!-- <th class="width_7" colspan="2">D45</th> -->
											<!-- <th class="width_7" colspan="2">R20</th> -->
											<!-- <th class="width_7" colspan="2">R40</th> -->
											<!-- <th class="width_7" colspan="2">OOG20</th> -->
											<!-- <th class="width_7" colspan="2">OOG40</th> -->
											<!-- <th class="width_7" colspan="2">RI20</th> -->
											<!-- <th class="width_7" colspan="2">RI40</th> -->
											<th class="width_12" rowspan="2">Total&nbsp;&nbsp;</th>
										</tr>
										<tr >
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
											<th class="width_1">Qty</th>
											<th class="width_1">Rate</th>
										</tr>
								</thead>
								<tbody>
			      						<tr ng-repeat="objInvoiceItem in tableCollection">
											<td><input type="checkbox" ng-checked="objInvoiceItem.active"><input type="hidden" ng-checked="objInvoiceItem.select"></td>
											<td>{{objInvoiceItem.surChrgNam}}</td>	
											<td>{{objInvoiceItem.rateList[0]}}</td>
											<td>{{objInvoiceItem.rateList[1]}}</td>
											<td>{{objInvoiceItem.rateList[2]}}</td>
											<td>{{objInvoiceItem.rateList[3]}}</td>
											<td>{{objInvoiceItem.rateList[4]}}</td>
											<td>{{objInvoiceItem.rateList[5]}}</td>
											<td>{{objInvoiceItem.rateList[6]}}</td>
											<td>{{objInvoiceItem.rateList[7]}}</td>
											<td>{{objInvoiceItem.rateList[8]}}</td>
											<td>{{objInvoiceItem.rateList[9]}}</td>
											<td>{{objInvoiceItem.rateList[10]}}</td>
											<td>{{objInvoiceItem.rateList[11]}}</td>
											<td>{{objInvoiceItem.rateList[12]}}</td>
											<td>{{objInvoiceItem.rateList[13]}}</td>
											<td>{{objInvoiceItem.rateList[14]}}</td>
											<td>{{objInvoiceItem.rateList[15]}}</td>
											<td>{{objInvoiceItem.rateList[16]}}</td>
											<td>{{objInvoiceItem.rateList[17]}}</td>
											<td>{{objInvoiceItem.rateList[18]}}</td>
											<td>{{objInvoiceItem.rateList[19]}}</td>
											<td>{{objInvoiceItem.rateList[20]}}</td>
											<td>{{objInvoiceItem.rateList[21]}}</td>	   
											<td>{{objInvoiceItem.rateList[22]}}</td>
											<td>{{objInvoiceItem.rateList[23]}}</td>
											<td>{{objInvoiceItem.total}}</td>   						
			      						</tr>
			      					</tbody>
	      						</table>
	      					</div>
	      				</div>
	      			</div>
				     <div>
				      <div class="col-md-7 col-md-offset-5">
				       <button class="btn btn-success" class="btn btn-success" ng-click="save()">
				        <span class="glyphicon glyphicon-floppy-disk" style="color: white;"></span>
				        Save
				       </button>
				       <button class="btn btn-danger" class="btn btn-success" ng-click="cancel()">
				        <i class="fa fa-close"></i>
				        Cancel
				       </button>
				       <button class="btn btn-info" class="btn btn-success" ng-click="reset()">
				        <i class="fa fa-undo"></i>
				        Reset
				       </button>
				      </div>
				     </div>
				   </div> 
				</div> <!-- /row - /book-widget-row -->
			</form>
			<div class="row">
		 	<div class="col-sm-12 col-md-12 col-lg-12">
		        <span class ="padding-left-10">
			 		<a class="btn btn-primary btn-sm" data-ng-click="algorithmView()"> Algorithm </a>	         	
		        </span>
		       </div>
		 </div> 
		</div>  
	 </div> <!-- /panel-default-form -->
</div>
<script type="text/ng-template" id="algorithmModal">
<div class="modal-header"> Invoice Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='Invoice Algorithm' class='' 
        width='625' height='500' src='assets/algorithm_Docs/Invoice_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script> 