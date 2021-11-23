<style>
#cityId\22 > div.selectivity-dropdown > div{
width:120px !important;
overflow:auto;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
	      <span class="widget-icon">
	       <i class="fa fa-table"></i>
	      </span>
  		  <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     
     <div class="row book-widget-row" style="padding-bottom: 12px;" ng-init="init()">
		<form class="form-horizontal" name="salesOrderForm" ng-submit="">
		
			<!-- Form field start -->		
		      <div class="row">
		      <div class="col-sm-12 col-md-12 col-lg-12 ">
			     <div class="col-sm-6 col-md-6 col-lg-6 ">
		         		 	
		         		 <div class="form-group" ng-show="isEdit">
								<label class="col-md-3 control-label">Sales Order No</label>
								 <div class="col-md-7">
								<label class="form-control no-border">{{salesOrder.salesOrderNo}}</label>
								</div>
					 	 	</div>
					 	 	
					 	 	<div class="form-group">
								<label class="col-md-3 control-label">Hospital<spring:message code="label.asterisk.symbol"></spring:message> </label>
						 		<div class="col-md-7">
							     	<select class="form-control input-sm" id="haspitalCode" name="haspitalCode" ng-model="salesOrder.haspitalCode" validation="required" friendly-name="Hospital"
								        ng-options="ac.id as ac.text for ac in companyList" >
								          	<option value="" selected="selected">--Select--</option>
								        </select>
							</div>
							
						  </div>
                            <div class="form-group">
								<label class="col-md-3 control-label">Customer<spring:message code="label.asterisk.symbol"></spring:message> </label>
					 				<div class="col-md-7" >
		        					<select class="form-control input-sm" id="customerCode" name="customer Code" ng-model="salesOrder.customerCode" validation="required" friendly-name="Customer"
								        ng-options="ac.customerCode as ac.customerName for ac in customerList" ng-change="getContactPerson(salesOrder.customerCode)">
								          	<option value="" selected="selected">--Select--</option>
								        </select>
								</div>
						  </div>		
					 	   <div class="form-group">
								<label class="col-md-3 control-label">Contact Person  </label>
						          <div class="col-md-7">
		        				<input type="text" class="form-control input-sm" id="contactPerson" name="contactPerson"
		        					ng-model="salesOrder.contactPerson"    readonly/>
								</div>
					 	 	</div>
					   			<div class="form-group" id = "delivery">
						            	<label class="col-md-3 control-label"> Bill Address</label>
							            <div class="col-md-7">
								            <div class="col-md-12 no-padding">
								             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" id="billingAddress" name="billingAddress" ng-model="salesOrder.billingAddress" readonly> </textarea>
								            </div>
									        <div class="col-md-12 no-padding">
										        <div class="col-md-5 no-padding padding-top-5">
										      <!-- <select class="form-control input-sm" id="billingCityCode" name="billingCity Code" ng-model="salesOrder.billingCityCode" readonly
											        ng-options="ac.billingCityCode as ac.billingCity for ac in cityList" ng-change="getBillingState(salesOrder.billingCityCode)">
											          	<option value="" selected="selected">--Select--</option>
											        </select> -->
											        
													<input type="text" class="form-control input-sm" placeholder="city" ng-model="salesOrder.deliveryCity" id="deliveryCity" name="deliveryCity"  readonly>
										        </div>
										        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
										        	<input type="text" class="form-control input-sm" placeholder="state" id="billingState" name="billingState" ng-model="salesOrder.billingState" readonly>
										        </div>
										        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
										        	<input type="text" class="form-control input-sm" placeholder="zipcode" id="billingPinCode" name="billingPinCode" ng-model="salesOrder.billingPinCode" readonly>
										        </div>
									        </div>
									        <div class="col-md-12 no-padding padding-top-5">
								             	<input type="text" class="form-control input-sm" placeholder="country"  id="billingCountry" name="billingCountry" ng-model="salesOrder.billingCountry" readonly>
								            </div>
							            </div>
						            </div>		
					 	 	    
			            	<%-- <div class="form-group" id = "delivery">
				            <label class="col-md-4 control-label"> Bill Address<spring:message code="label.asterisk.symbol"></spring:message>  
				            </label>
				            <div class="col-md-5 b b-grey margin-left-2">
				             <div class="col-md-12 no-padding padding-top-5">
				             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" id="billingAddress" name="billingAddress" ng-model="salesOrder.billingAddress" readonly > </textarea>
				             </div>
				             <div class="col-md-5 no-padding padding-top-5">
				             	<select class="form-control input-sm" id="billingCityCode" name="billingCity Code" ng-model="salesOrder.billingCityCode" readonly
								        ng-options="ac.billingCityCode as ac.billingCity for ac in cityList" ng-change="getBillingState(salesOrder.billingCityCode)">
								          	<option value="" selected="selected">--Select--</option>
								        </select>
				             </div>       
																         
				    
				             <div class="col-md-4 no-padding padding-top-5 padding-left-3">
				             	<input type="text" class="form-control input-sm" placeholder="state" id="billingState" name="billingState" ng-model="salesOrder.billingState" readonly>
				             </div>
				             <div class="col-md-3 no-padding padding-top-5 padding-left-3">
				             	<input type="text" class="form-control input-sm" placeholder="zipcode" id="billingPinCode" name="billingPinCode" ng-model="salesOrder.billingPinCode" readonly>
				             </div>
				             <div class="col-md-12 no-padding padding-top-5 padding-bottom-5">
				             	<input type="text" class="form-control input-sm" placeholder="country"  id="billingCountry" name="billingCountry" ng-model="salesOrder.billingCountry" readonly>
				             </div>
				            </div>
			            </div> --%>
				
						<%-- <div class="form-group">
								<label class="col-md-3 control-label">Status<spring:message code="label.asterisk.symbol"></spring:message> </label>
						 		<div class="col-md-7">
							     	<select class="form-control input-sm" id="status" name="status" ng-model="salesOrder.status" validation="required" friendly-name="Status">
								  <option value="">Select</option>
								  <option value="Pending">Pending</option>
								  <option value="Approved">Approved</option>
								   <option value="Ignored">Ignored</option>
								   <option value="Delivered">Delivered</option>
								</select>
							</div>
						  </div> --%>
			     </div>
		     
			     <div class="col-sm-6 col-md-6 col-lg-6">
			     	<fieldset>
			     	<div class="form-group" ng-show="isEdit" style="padding-top:22px;">
							
					 	 	</div>
					 	 	
					 	 	<div class="form-group">
			       				<label class="col-md-3 control-label"> Sales Order Date </label>
			       				<div class="col-md-7">					       				
				       				<div class='input-group date datetimepick col-md-12'>
										<div class="dropdown">
											<a class="dropdown-toggle" id="salesOrderDate" role="button"
												data-toggle="dropdown" data-target="#" href="#">
												<div class="input-group">
													<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Sales Order Date"
													 validation="date_euro_long|required" friendly-name="Sales Order Date" 
													data-ng-model="salesOrder.salesOrderDate" />
														<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
													
												</div>
											</a>
											<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
												<datetimepicker data-ng-model="salesOrder.salesOrderDate" data-on-set-time="salesOrder.salesOrderDate = onDateSet(newDate)"
													data-datetimepicker-config="{ dropdownSelector: '#salesOrderDate',startView:'day', minView:'day'}" />
											</ul>
										</div>
									</div>	
			       				</div>
						</div>
					 	 	
			     		 <%-- <div class="form-group">
								<label class="col-md-4 control-label">Sales Order Date<spring:message code="label.asterisk.symbol"></spring:message> </label>
                       	 		<div class="col-md-7">
									<div class='input-group date datetimepick col-md-12'>
										<div class="dropdown">
												<a class="dropdown-toggle" id="salesInvoicedate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="salesOrderDate" id="salesOrderDate" validation="required" friendly-name="Sales Order Date"
														data-validator="required" data-valid-method="submit" data-message-id="sales Order Date"
															data-ng-model="salesOrder.salesOrderDate"><span class="input-group-addon" 
															style=" width: 44px;"><i class="glyphicon glyphicon-calendar"></i></span>
													
														
													</div>
												</a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<datetimepicker data-ng-model="salesOrder.salesOrderDate" data-on-set-time="salesOrder.salesOrderDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#salesInvoicedate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>
									</div>
					 	  	</div> --%>
                             <%--  <div class="form-group">
								<label class="col-md-3 control-label">Created By<spring:message code="label.asterisk.symbol"></spring:message> </label>
						 		<div class="col-md-7">
								<select class="form-control input-sm" id="employeeId" name="employeeId" ng-model="salesOrder.employeeId" validation="required" friendly-name="Created By" 
								        ng-options="ac.employeeId as ac.employeeName for ac in employeeList" >
								          	<option value="" selected="selected">--Select--</option>
								        </select>
						       </div>
					 	 	</div> --%>
					 
						  <div class="form-group">
						    <label class="col-md-3 control-label">Job Title  </label>
						 	<div class="col-md-7">
							<input type="text" class="form-control input-sm" id="jobTitleName" name="jobTitleName" ng-model="salesOrder.jobTitleName"   readonly/>
						    </div>
					 	 	</div>

						  <div class="form-group">
						            	<label class="col-md-3 control-label"> Delivery Address</label>
							            <div class="col-md-7">
								            <div class="col-md-12 no-padding">
								             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" id="deliveryAddress" name="deliveryAddress" ng-model="salesOrder.deliveryAddress" readonly> </textarea>
								            </div>
									        <div class="col-md-12 no-padding">
										        <div class="col-md-5 no-padding padding-top-5">
										        <!-- <select class="form-control input-sm" id="deliveryCityCode" name="deliveryCity Code" ng-model="salesOrder.deliveryCityCode" readonly
											        ng-options="ac.deliveryCityCode as ac.deliveryCity for ac in cityList1" ng-change="getDeliveryState(salesOrder.deliveryCityCode)">
											          	<option value="" selected="selected">--Select--</option>
											        </select> -->
													<input type="text" class="form-control input-sm" placeholder="city" ng-model="salesOrder.deliveryCity" id="deliveryCity" name="deliveryCity"  readonly>
										        </div>
										        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
										        	<input type="text" class="form-control input-sm" placeholder="state" id="deliveryState" name="deliveryState" ng-model="salesOrder.deliveryState" readonly>
										        </div>
										        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
										        	<input type="text" class="form-control input-sm" placeholder="zipcode" id="deliveryPinCode" name="deliveryPinCode" ng-model="salesOrder.deliveryPinCode" readonly>
										        </div>
									        </div>
									        <div class="col-md-12 no-padding padding-top-5">
								             	<input type="text" class="form-control input-sm" placeholder="country"  id="deliveryCountry" name="deliveryCountry" ng-model="salesOrder.deliveryCountry" readonly>
								            </div>
							            </div>
						            </div>		
							<%-- <div class="form-group" id = "bill">
				            <label class="col-md-4 control-label"> Delivery Address<spring:message code="label.asterisk.symbol"></spring:message> 
				            </label>
				            <div class="col-md-5 b b-grey margin-left-2">
				             <div class="col-md-12 no-padding padding-top-5">
				             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" id="deliveryAddress" name="deliveryAddress" ng-model="salesOrder.deliveryAddress" readonly> </textarea>
				             </div>
				             <div class="col-md-5 no-padding padding-top-5">
				             	<select class="form-control input-sm" id="deliveryCityCode" name="deliveryCity Code" ng-model="salesOrder.deliveryCityCode" readonly
								        ng-options="ac.deliveryCityCode as ac.deliveryCity for ac in cityList1" ng-change="getDeliveryState(salesOrder.deliveryCityCode)">
								          	<option value="" selected="selected">--Select--</option>
								        </select>
				             </div>
				             <div class="col-md-4 no-padding padding-top-5 padding-left-3">
				             	<input type="text" class="form-control input-sm" placeholder="state" id="deliveryState" name="deliveryState" ng-model="salesOrder.deliveryState" readonly>
				             </div>
				             <div class="col-md-3 no-padding padding-top-5 padding-left-3">
				             	<input type="text" class="form-control input-sm" placeholder="zipcode" id="deliveryPinCode" name="deliveryPinCode" ng-model="salesOrder.deliveryPinCode" readonly>
				             </div>
				             <div class="col-md-12 no-padding padding-top-5 padding-bottom-5">
				             	<input type="text" class="form-control input-sm" placeholder="country"  id="deliveryCountry" name="deliveryCountry" ng-model="salesOrder.deliveryCountry" readonly>
				             </div>
				            </div>
			            </div> --%>
			        
			     	</fieldset>
			     </div>
			  </div>   	
			  <div class="col-sm-12 col-md-12 col-lg-12">
			     	<fieldset>
		     	 <div class="col-md-12">
								<label class="col-md-2 control-label " style = "width: 11% !important " > Customer Note</label>
						 		<div class="col-md-10" >
							<textarea class="form-control input-sm" name="customerNote" id="customerNote" maxlength="150" data-ng-model="salesOrder.customerNote" 
                              style="resize: none" message-id="customerNote" validator="required"></textarea>         
						         </div>
				  </div>
				  </fieldset>
			</div>
					  
			<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" > <!-- ng-repeat="(tIndex, salesTable) in salesOrder.salesOrderTables" -->
			      <div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
				      <table class="table table-striped table-bordered table-hover dataTable no-footer">
				      
				        <thead class="dataTables-Main-Head">
				          <tr>
				            <!-- <th colspan=1 class="width_1 table-heading"></th> -->
				            <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
				             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(selectedAll)"> <i></i>
				       		</label></th>
				            <th colspan=1 class="width_20 text-center table-heading ">Item Code-Item Name</th>			            
				            <!-- <th colspan=1 class="width_10 text-center table-heading">Item Description</th> -->
				            <th colspan=1 class="width_10 text-center table-heading">Item Category</th>
				           <!--  <th colspan=1 class="width_6 text-center table-heading">UOM</th> -->
				            <th colspan=1 class="width_8 text-center table-heading">Qty</th>
				            <th colspan=1 class="width_6 text-center table-heading">Unit Price</th>
				            <th colspan=1 class="width_6 text-center table-heading">Tax Code</th>
				            <th colspan=1 class="width_6 text-center table-heading">Tax Amount</th>			            
				             <th colspan=1 class="width_6 text-center table-heading">Amount</th>
				            </tr>
				              </thead>
				              <tbody style="height:100px;overflow: scroll;">
				         		 <tr ng-repeat="(trIndex, row) in salesOrder.salesOrderTables" >
				          
					            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
					           <td> 
						        	<div class="row">
					            		<div class="col-xs-12">
					            		 <!-- <select class="form-control input-sm" id="itemId{{trIndex}}" name="itemId" ng-model="row.itemId" validation="required" friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}"
									        ng-options="ac.itemId as ac.itemName for ac in itemList" ng-change="getItem(row,row.itemId)"> 
									          	<option value="" selected="selected">--Select--</option>
									        </select>  -->
									        
									        <select class="form-control input-sm" data-ng-model="row.itemId" name="Item Code" id="txtItemId{{trIndex}}" validation="required" friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}"
																		ng-options="c.itemId as c.itemName for c in itemList" ng-change="onChangeItem(trIndex,row.itemId)">
																				<option value="">Select</option>
											</select>
									      	
					        			</div>
					        		</div>
					        	</td> 
					        	<!-- <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<input type="text" class="form-control input-sm"  id="itemDesc{{trIndex}}" name="itemDesc" ng-model="row.itemDesc" readonly  />
					         	  			   	  			
					         	  		</div>
					              	</div>
					            </td> -->
					            
					            <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<input type="text" class="form-control input-sm"   id="itemCategory{{trIndex}}" name="itemCategory" ng-model="row.itemCategory" readonly/>
					         	  		</div>
					              	</div>
					            </td>	
					              <!-- <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<input type="text" class="form-control input-sm"   id="unit{{trIndex}}" name="unit" ng-model="row.unit" readonly/>
					         	  		</div>
					              	</div>
					            </td>	 -->
					                  	<td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<input type="text" class="form-control input-sm text-align-right"  id="qty{{trIndex}}" name="qty" ng-model="row.qty"  placeholder="0" validation="numeric" friendly-name="{{ 'Row ' + $index + ' Quantity on Detail table)'}}"
					         	  			 ng-keyup="calculateAmount(row)"/>
					         	  		</div>
					              	</div>
					            </td>
					                  	<td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			  <input type="text" class="form-control input-sm text-align-right"   id="price{{trIndex}}" name="price" ng-model="row.price"   placeholder="0.00"
												 validation="numeric"   friendly-name="{{ 'Row ' + $index + ' (Price on Detail table)'}}"
					         	  			  ng-keyup="calculateAmount(row)"/>
					         	  		</div>
					              	</div>
					            </td>
					                  	<td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<!--  <select class="form-control input-sm" id="taxId{{trIndex}}" name="taxCode" ng-model="row.taxId" validation="required" friendly-name="{{ 'Row ' + $index + ' (Tax on Detail table)'}}"
									        ng-options="ac.taxId as ac.taxCode for ac in taxList" ng-change="getTax(row,row.taxId)" readonly>
									          	<option value="" selected="selected">--Select--</option>
									        </select>  -->
									        
									        <input type="text" class="form-control input-sm"   id="unit{{trIndex}}" name="taxCodes" ng-model="row.taxCode" readonly/>
									        
					         	  		</div>
					              	</div>
					            </td>
					            <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<input type="text" class="form-control input-sm text-align-right"   id="taxAmount{{trIndex}}" name="taxAmount" ng-model="row.taxAmount" readonly/>
					         	  		</div>
					              	</div>
					            </td>
					            <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12"> 
					         	  			<input type="text" class="form-control input-sm text-align-right"   id="amount{{trIndex}}" name="amount" ng-model="row.amount" readonly />
					         	  		</div>
					              	</div>
					            </td>
					             
				          </tr>
				       	</tbody>   
				         
				        
				      </table> 
				   
			       <!-- <div class="padding-right-5" id="AddOrRmveMeritbtn">
			           <button ng-click="addsalesRow(salesOrder.salesOrderTables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
			            <i class="fa fa-plus"></i>
			           </button>
			           <button ng-click="removesalesRow(salesOrder.salesOrderTables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
			            <i class="fa  fa-trash-o"></i>
			           </button>
			      </div>    -->
			      <div class="padding-right-5">
						<div class="col-md-4">
							<button ng-click="addsalesRow(salesOrder.salesOrderTables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
			            <i class="fa fa-plus"></i>
			           </button>
							 <button ng-click="removesalesRow(salesOrder.salesOrderTables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
			            <i class="fa  fa-trash-o"></i>
			           </button>
			          
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group pull-right">
									<label class="col-md-4 control-label">Sub Total</label>
									<div class="col-md-4">
										<input type="text" class="form-control input-sm text-align-right"
											id="totalTax" name="totalTax"
											ng-model="salesOrder.totalTax" readonly>
									</div>
									<div class="col-md-4">
										<input type="text" class="form-control input-sm text-align-right"
											id="totalAmount" name="totalAmount"
											ng-model="salesOrder.totalAmount" readonly>
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group pull-right">
							        <label class="col-md-5 control-label">Total</label>
							        <div class="col-md-7">
							         		<input type="text" class="form-control input-sm text-align-right"
												id="netAmount" name="netAmount"
												ng-model="salesOrder.netAmount" readonly>
							        </div>
							        
						       </div>
							</div>
						</div>
					</div>  
				    
					</div> <!-- /table-striped -->
					 <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">
				           <button class="btn btn-success" type="button"
				            class="btn btn-success"
				            data-ng-click="validate(manageLocationAddForm,salesOrder)"
				            data-ng-if="!isEdit">
				            <i class="fa fa-save"></i>
				            <spring:message code="label.save"></spring:message>
				           </button>
				           <button class="btn btn-success" type="button"
				            class="btn btn-success" id="update"
				            data-ng-click="validate();"
				            data-ng-if="isEdit == true">
				            <i class="fa fa-save"></i>
				            <spring:message code="label.update"></spring:message>
				           </button>
				           <button class="btn btn-info" type="button"
				            class="btn btn-success"
				            data-ng-click="reset();">
				            <i class="fa fa-undo"></i>
				            <spring:message code="label.reset"></spring:message>
				           </button>
				           <button class="btn btn-danger" type="button"
				            class="btn btn-success" data-ng-click="cancel();">
				            <i class="fa fa-close"></i>
				            <spring:message code="label.cancel"></spring:message>
				           </button>
				          </div>
				         </div>
				        </div>
				</div>       
         
        </div><!-- /row -->
        
       </form>
      </div>
     </div>
     </article>
    </div>
</section>
</div>
<!-- <script>
$("#delivery").hide();
$('#dp').change(function() {
    var str = "";
    var mylist = document.getElementById("dp");
    str = mylist.options[mylist.selectedIndex].value;

     if(str == "0")
         {
         $("#bill").show();
        $("#delivery").hide();
         }
        
      else if (str == "1")
          {
          $("#delivery").show();
          $("#bill").hide();
          } 
      else
          {
          $("#delivery").show();
          $("#bill").show();
          }
      
}); 

</script>
 -->