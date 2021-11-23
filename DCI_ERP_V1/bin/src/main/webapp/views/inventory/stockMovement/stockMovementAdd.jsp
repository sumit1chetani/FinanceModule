<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="ondutyrequestForm"  novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
										<div class="col-md-6">
											<div class="form-group" ng-if="edit">
												<label class="col-md-4 control-label">Stock Transfer
													No</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="AssetCode" ng-model="StockTransfor.stockId" readonly>
												</div>
											</div>



											<div class="form-group">
												<label class="col-md-4 control-label">Transfer Date<span style = "color:red">*</span></label>
												<div class="col-md-7">
												             <!-- <a class="dropdown-toggle" id="fromdate" role="button"
												              data-toggle="dropdown" data-target="#" href="#">
												              <div class="input-group">
												               <input type="text" class="form-control"
												                placeholder="dd/mm/yyyy" name="fromdate"
												                validation="date_euro_long|required"
												                friendly-name="Transfer Date"
												                data-ng-model="StockTransfor.date"><span
												                class="input-group-addon"><i
												                class="glyphicon glyphicon-calendar"></i></span>
												              </div>
												             </a>
												             <ul class="dropdown-menu" role="menu"
												              aria-labelledby="dLabel">
												              <datetimepicker data-ng-model="StockTransfor.date"
												               data-on-set-time="StockTransfor.date = onDateSet(newDate)"
												               data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
												             </ul>
												     -->       
												     <ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="StockTransfor.date"
										id="fromdate" name="Transfer"
										data-ng-change="checkDatesCL(StockTransfor.date)" 
										friendly-name="Transfer Date" validation="required" />
												     
												     
												     
												      </div>
													</div>
											<div class="form-group">
													<label class="col-md-4 control-label"> Transfer Type<span style = "color:red">*</span></label>
													<div class="col-md-7">
														<selectivity list="issueList" property="StockTransfor.issueType" ng-model="StockTransfor.status" id="issueType" name="issueType" 
														validation="required" friendly-name="issueType" form-name="ondutyrequestForm"></selectivity>
													</div>
												</div>
											<div class="form-group">
						        				<label class="col-md-4 control-label"> 		<%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name <span style = "color:red">*</span></label>
						        				<div class="col-md-7" >
							        				<selectivity list="companyList" property="StockTransfor.companyId" id="hospital"
								        				ng-model="StockTransfor.companyId" name="hospital" form-name = "ondutyrequestForm"
							        				validation="required" friendly-name="Organization Name"></selectivity>
												</div>
												<!-- <div class="col-md-7" ng-if="!edit">
							        				<input type="text" class="form-control input-sm"
														name="AssetCode" ng-model="StockTransfor.companyName" readonly>
												</div> -->
											</div>


				<%-- 							<div class="form-group">
												<label class="col-md-4 control-label">
													Transportation Type<spring:message
              									code="label.asterisk.symbol"></spring:message> </label>
												<div class="col-md-7">
													<selectivity list="Transportation" property="StockTransfor.transportType" id=""
	        				ng-model="StockTransfor.transportType" name="transportType" form-name = "ondutyrequestForm"
	        				validation="required" friendly-name="Transportation Type"></selectivity>


													<!-- <select class="form-control input-sm"
														ng-model="StockTransfor.transportType"
														name="Hospital Name" id="type"
														ng-change="transportationonchange(StockTransfor.transportType)"
														 data-valid-method="submit"
														data-message-id="Transportation Type" ng-options="c.id as c.name for c in Transportation">
														<option value="">Select</option>

													</select> -->
												</div>
											</div>
 --%>
											<div class="form-group" id="personname"
												style="display: none;">
												<label class="col-md-4 control-label">Person Name</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="AssetCode" ng-model="StockTransfor.personName">
												</div>
											</div>

											<div class="form-group" id="servicename"
												style="display: none;">
												<label class="col-md-4 control-label">Service Name</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="AssetCode" ng-model="StockTransfor.serviceName">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Source
													Location <span style = "color:red">*</span></label>
												<div class="col-md-7">
												
												<selectivity ng-if = "!materialIssueflag" list="destinationList" property="StockTransfor.sourceLocName" id="sourceLocName" 
								        				ng-model="StockTransfor.sourceLocName" name="Destination Location"" form-name = "ondutyrequestForm"
							        				validation="required" 
							        				
							        				></selectivity> 
							        				
													<input ng-if = "materialIssueflag" type="hidden" ng-model="StockTransfor.sourceLoc" />
													<input ng-if = "materialIssueflag" type="text" class="form-control input-sm"
														name="Source Location"
														ng-model="StockTransfor.sourceLocName"
														id="sourceLocName" readonly>

												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Destination
													Location  <span style = "color:red">*</span></label>
												<div class="col-md-7">
												 <selectivity ng-if = "!materialIssueflag" list="destinationList" property="StockTransfor.destLocName" id="destLocName" 
								        				ng-model="StockTransfor.destLocName" name="Destination Location"" 
								        					validation="required"
								        				form-name = "ondutyrequestForm"
							        				validation="required" ></selectivity> 
												 	<input ng-if = "materialIssueflag" type="hidden" ng-model="StockTransfor.destLoc" />
													<input ng-if = "materialIssueflag" type="text" class="form-control input-sm"
														name="Destination Location"
														ng-model="StockTransfor.destLocName"
														id="destLocName" readonly> 
													
												</div>
											</div>
								</div>
									<div class="col-md-6">

											<div class="form-group" ng-if = "materialIssueflag">
												<label class="col-md-4 control-label"> Requisition
													No</label>
												<div class="col-md-7">
												<selectivity ng-if="!edit" list="RequisitionList" property="StockTransfor.requisition" 
					        							ng-model="StockTransfor.requisition" name="requisition" form-name = "ondutyrequestForm"
					        							validation="required" friendly-name="Requisition No"></selectivity>
					        					<selectivity list="RequisitionList" property="StockTransfor.requisition" ng-if="edit" disabled=true
					        							ng-model="StockTransfor.requisition" name="requisition" form-name = "ondutyrequestForm"
					        						validation="required" friendly-name="Requisition No"></selectivity>
												</div>
											</div>

											<div class="form-group" ng-if = "materialIssueflag">
												<label class="col-md-4 control-label">Requisition
													Date</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Requisition Date"
														ng-model="StockTransfor.requisitionDate"
														id="requisitiondate" readonly>
												</div>
											</div>

											<div class="form-group">
												<!-- <label class="col-md-4 control-label">Requested By</label> -->
												<label class="col-md-4 control-label">Requested By <span style = "color:red">*</span></label>
												
												<div class="col-md-7">
												<selectivity ng-if = "!materialIssueflag" list="employeeList" 
												property="StockTransfor.requisitionBy" id="requisitionBy" 
								        				ng-model="StockTransfor.requisitionBy" name="requisitionBy" 
								        				form-name = "ondutyrequestForm"
							        					validation="required" ></selectivity> 
												 
												
													<input ng-if = "materialIssueflag" type="text" class="form-control input-sm"
														name="AssetCode" ng-model="StockTransfor.requisitionBy"
														id="requestedby">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label"> Delivery
													Method <span style = "color:red">*</span> </label>
												<div class="col-md-7">
									<selectivity list="Delivery" property="StockTransfor.deliveryMet" id=""
	        				ng-model="StockTransfor.deliveryMet" name="deliveryMet" form-name = "ondutyrequestForm"
	        				validation="required" friendly-name="Delivery Method"></selectivity>

											<!-- 	<select class="form-control input-sm"
														ng-model="StockTransfor.deliveryMet"
														name="Requisition Location"
														data-valid-method="submit"
														data-message-id="Delivery Method"
														ng-options="c.id as c.name for c in Delivery">
														<option value="">Select</option>

													</select>
													 -->
												</div>
											</div>




											<div class="form-group">
												<label class="col-md-4 control-label"> Status  <span style = "color:red">*</span></label>
												<div class="col-md-7">
													<select class="form-control input-sm" id="Status"
														ng-model="StockTransfor.status" name="Status"
														validation="required" friendly-name="Status">
														<option value="">Select</option>
														<option value="Pending">Pending</option>
														<option value="Approved">Approved</option>
													</select>
												</div>
											</div>
											
											<div class="form-group">
										
											<label class="col-md-4 control-label"> Issue Slip No<label/>
												</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														ng-model="StockTransfor.issueSlip"
														name="Issue Slip" 
														friendly-name="Issue Slip"  />
												</div>
											</div>
									
									
										
										
										
										
										
										
										
										
										</div>
										</fieldset>
										</div>
										</div>

								<br>
								<br>
									<div class="col-sm-12 col-md-12 col-lg-12"><br>
        		<div role="content">
			      <div class="widget-body no-padding">
			       <div class="" data-st-table="displayedCollection" data-st-safe-src="rowCollection">
									  <table id="dt_basic"
			         class="table table-striped table-bordered table-hover dataTable no-footer"
			         role="grid" aria-describedby="dt_basic_info">
			         <thead class="dataTables-Main-Head">
										<tr>
											<th class="width_1 text-center table-heading">
		            											<!-- <label class="i-checks m-b-none">
		            												 <input type="checkbox">
		           													  <i></i>
		           												 </label> -->
	          													 </th>
										 <th class="sorting width_10" data-st-sort="">Item Code - Item Name</th>
					                    <th  ng-if = "materialIssueflag"  class="sorting width_10" data-st-sort="">Requisition No</th>
										 
										 <th class="sorting width_10" data-st-sort="">Item Description</th>
											 <th class="sorting width_7" data-st-sort="">Unit Of Measurement</th>
											 <th class="sorting width_7" data-st-sort="">PR Original Quantity</th>
											 	 <th class="sorting width_7" data-st-sort="">PR Quantity</th>
											 
						             	 <th class="sorting width_7" data-st-sort="">Available Qty</th>
											 
											 <th class="sorting width_7" data-st-sort="">Quantity</th>
											<!--  <th class="table-heading width_5" >Batch No</th> -->
										</tr>
										<tr ng-repeat="(trIndex, row) in StockTransfor.rowCollection"  ng-controller="stockTransferItemCtrlAdd">
											<td colspan=1 class="width_1"><label 
												class="i-checks m-b-none" style="margin-left: 20px;"> <input type="checkbox"
													ng-model="tableSelection[$index]" id="section{{trIndex}}"><i></i></label></td>
													
								
												
											<td colspan=1 class="width_1" >
											<selectivity list="ItemList" property="row.itemCode" id=""
	        								ng-model="row.itemCode" name="{{ 'Item' + trIndex }}" form-name = "ondutyrequestForm"
	        										validation="required" friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"></selectivity>
											</td>
											
														
													
												<td  ng-if = "materialIssueflag" colspan=1 class="width_1" title={{row.requisitionNo}}><input type="text" ng-model="row.requisitionNo" class="form-control input-sm"   name="{{ 'Requisition No' + trIndex  }}"
			           							friendly-name="{{ 'Row' + (trIndex+1) + '(Requisition No)'}}" readonly >
			           						</td>
													
													
											<td colspan=1 class="width_1" title={{row.itemDesc}}><input type="text" ng-model="row.itemDesc" class="form-control input-sm"   name="{{ 'Item Description' + trIndex  }}"
			           							friendly-name="{{ 'Row' + (trIndex+1) + '(Item Description)'}}" readonly >
			           						</td>
											
											<td colspan=1 class="width_1"><input type="text"
												ng-model="row.uom" class="form-control input-sm" readonly></td>
											<td colspan=1 class="width_1"><input type="text" 
											ng-model="row.originalQty" class="form-control input-sm"  
											 name="{{ 'originalQty' + trIndex  }}"
			           							validation="required"
			           							 friendly-name="{{ 'Row' + (trIndex+1) + '(PROrginalQuantity)'}}"
			           							  readonly></td>
			           							
											<td colspan=1 class="width_1"><input type="text" 
											ng-model="row.prquantity" class="form-control input-sm"  
											 name="{{ 'prquantity' + trIndex  }}"
			           							validation="required"
			           							 friendly-name="{{ 'Row' + (trIndex+1) + '(PRQuantity)'}}"
			           							  readonly></td>
			           							
			           							
			           							
										<td colspan=1 class="width_1"><input type="text" ng-model="row.availableQTY" class="form-control input-sm"   name="{{ 'availableQTY' + trIndex  }}"
			           							validation="required" friendly-name="{{ 'Row' + (trIndex+1) + '(Available Qty)'}}" readonly ></td>
			           						
			           						
											<td colspan=1 class="width_1"><input type="text" ng-blur="validateQuantity(row.quantity,row.prquantity,row.availableQTY,trIndex)"
												ng-model="row.quantity" class="form-control input-sm"   name="{{ 'quatity' + trIndex  }}"
			           							validation="required" friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}"   ng-pattern-restrict="^[0-9.]*$"	></td>
											<!-- <td class="width_5" ng-show="row.batchNoExist==true" >
												<label class="col-xs-12"  data-ng-click="getBatchDetails(trIndex,row.itemCode)">
													<span class="fa fa-plus"></span>
												</label>
												
											</td> -->
											
											
										</tr>
									</table>
						<div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
				           <button ng-click="add()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="" type="button">
				            <i class="fa fa-plus"></i>
				           </button>
				           <button ng-click="deleteRow()"  class="btn btn-sm btn-danger" type="button" tooltip="Delete">
				            <i class="fa  fa-trash-o"></i>
				           </button>
				        </div>
								</div>
</div></div></div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												ng-if="!edit && materialIssueflag"
												data-ng-click="save(ondutyrequestForm,StockTransfor)">
												<i class="fa fa-save"></i> Save
											</button>
											
											<button class="btn btn-success" type="button"
												ng-if="!edit && !materialIssueflag"
												data-ng-click="saveKitchenbased(ondutyrequestForm,StockTransfor)">
												<i class="fa fa-save"></i>Save
											</button>
											<button class="btn btn-success" type="button"
												ng-if="edit"
												data-ng-click="update(ondutyrequestForm,StockTransfor);" ng-hide="status=='Approved'">
												<i class="fa fa-save"></i>Update
											</button>
											<button class="btn btn-info" type="button"
												ng-if="!edit" data-ng-click="reset();" >
												<i class="fa fa-undo"></i>Reset
											</button>
											<button class="btn btn-info" type="button"
												ng-if="edit" data-ng-click="reset1();">
												<i class="fa fa-undo"></i>Reset
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel1();">
												<i class="fa fa-close"></i>Cancel
											</button>
											<!-- <button class="btn btn-danger" type="button"
class="btn btn-success" data-ng-click="back();">
<i class="fa fa-backward"></i> Back
</button> -->
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>