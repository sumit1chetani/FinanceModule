<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span> <state-breadcrumbs></state-breadcrumbs>
						</span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
     	<div role="content">
      		<div class="widget-body"> --%>
      		
      		<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       			<form class="form-horizontal" name="gatePassForm">
        			<div class="row">
        				<div class="col-sm-12 col-md-12 col-lg-12">
        				<fieldset>
        					<div class="col-md-6" >
        						<div class="form-group" ng-if="isEdit">
							    <label class="col-md-4 control-label"> Gate Pass No </label>
							     <div class="col-md-7">
							      <input type="text" class="form-control input-sm" ng-model="gatePass.gatePassNo" name="gatePassNo" data-message-id="gatePassNo"  data-validator="required" data-valid-method="save" readonly>
							     </div>
							   </div>
							   <div class="form-group">
			        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name</label>
			        				<div class="col-md-7">
				        				<selectivity list="companyList" property="gatePass.companyId" id="hospital"
				        				ng-model="gatePass.companyId" name="companyId" form-name = "gatePassForm"
				        				validation="required" friendly-name=""></selectivity>
									</div>
								</div>
        					   <div class="form-group">
							    <label class="col-md-4 control-label"> Location </label>
							     <div class="col-md-7">
							      <input type="text" class="form-control input-sm" ng-model="gatePass.location" name="gatePassNo" data-message-id="gatePassNo"  data-validator="required" data-valid-method="save" readonly>
							     </div>
							   </div>

							   <div class="form-group">
												<label class="col-md-4 control-label">
													Address</label>
												<div class="col-md-7">
													<div class="col-md-12 no-padding">
														<textarea class="text-left form-control input-sm" rows="2"
													cols="15" style="resize: none"
													ng-model="gatePass.cusStreet" readonly> </textarea>
													</div>
													<div class="col-md-12 no-padding">
														<div class="col-md-5 no-padding padding-top-5">
															<input type="text" class="form-control input-sm"
													placeholder="City" ng-model="gatePass.cusCity" readonly>
														</div>
														<div
															class="col-md-4 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
													placeholder="Zip" ng-model="gatePass.cusZipcode" readonly>
														</div>
														<div
															class="col-md-3 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
													placeholder="State" ng-model="gatePass.cusState" readonly>
														</div>
													</div>
													<div class="col-md-12 no-padding padding-top-5">
														<input type="text" class="form-control input-sm"
													placeholder="Country"
													ng-model="gatePass.cusCountry" readonly>
													</div>
												</div>
											</div>

            					<div class="form-group">
							    <label class="col-md-4 control-label"> Delivery Order No </label>
							     <div class="col-md-7">
							      <input type="text" class="form-control input-sm" ng-model="gatePass.deliveryorderNo" name="gatePassNo" data-message-id="gatePassNo"  data-validator="required" data-valid-method="save" readonly>
							     </div>
							   </div>
							   <div class="form-group">
							    <label class="col-md-4 control-label"> Invoice No </label>
							     <div class="col-md-7">
							      <input type="text" class="form-control input-sm" ng-model="gatePass.invoiceNo" name="gatePassNo" data-message-id="gatePassNo"  data-validator="required" data-valid-method="save">
							     </div>
							   </div>
							   
							<div class="form-group">
			        				<label class="col-md-4 control-label">Vendor</label>
			        				<div class="col-md-7">
				        				<selectivity list="vendorList" property="gatePass.vendorId" id="vendorId"
				        				ng-model="gatePass.vendorId" name="vendorId" form-name = "gatePassForm"
				        				friendly-name="vendor" ></selectivity>
									</div>
								</div>
							   <div class="form-group">
											<label class="col-md-4 control-label">Purchase Order</label>
											<div class="col-md-7">
												<selectivity list="poList" property="gatePass.poId" id="pOrderNo"></selectivity>
											</div>
						
										</div>
							   <div class="form-group" ng-if="gatePass.returnable == true">
						     <label class="col-md-4 control-label">Return Date
						     
						     </label>
						     <div class="col-md-7">
						        <!-- <div class="input-group date datetimepick col-md-12">
						              <div class="dropdown">
						               <a data-toggle="dropdown" class="dropdown-toggle" id="duedate" role="button" data-target="#" href="#">
						                <div class="input-group">
						                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="date" data-validator="required"
						                  data-valid-method="submit" data-message-id="DueDate" data-ng-model="gatePass.return_date"
						                    form-name = "gatePassForm"
				        					validation="required" friendly-name="Gate Pass Date"
						                	 >
						                 <span class="input-group-addon">
						                  <i class="glyphicon glyphicon-calendar" required></i>
						                 </span>
						                </div>
						               </a>
						               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
						                <datetimepicker data-ng-model="gatePass.return_date"
						                 data-on-set-time="gatePass.return_date = onDateSet(newDate)"
						                 data-datetimepicker-config="{ dropdownSelector: '#return_date',startView:'day', minView:'day'}" />
						               </ul>
						              </div>
						             </div>
						            </div> -->
						            <ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="gatePass.return_date"
										id="requisitionDate" name="requisitionDate"
										data-ng-change="checkDatesCL(gatePass.return_date)"
										friendly-name="Valid From" validation="required" />
						            
						           </div>
							   
		            		</div>

					<div class="col-md-6">
							<div class="form-group">
							    <label class="col-md-4 control-label">Manual Gate Pass Number</label>
							     <div class="col-md-7">
							     	<input type="text" class="form-control input-sm" name="Gate Pass Number" ng-model="gatePass.gatePassManualNo" >
							     </div>
							 </div>
						<div class="form-group">
						     <label class="col-md-4 control-label"> Gate Pass Date
						     
						     </label>
						     <div class="col-md-7">
						        <!-- <div class="input-group date datetimepick col-md-12">
						              <div class="dropdown">
						               <a data-toggle="dropdown" class="dropdown-toggle" id="duedate" role="button" data-target="#" href="#">
						                <div class="input-group">
						                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="date" data-validator="required"
						                  data-valid-method="submit" data-message-id="DueDate" data-ng-model="gatePass.date"
						                    form-name = "gatePassForm"
				        					validation="required" friendly-name="Gate Pass Date"
						                	 >
						                 <span class="input-group-addon">
						                  <i class="glyphicon glyphicon-calendar" required></i>
						                 </span>
						                </div>
						               </a>
						               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
						                <datetimepicker data-ng-model="gatePass.date"
						                 data-on-set-time="gatePass.date = onDateSet(newDate)"
						                 data-datetimepicker-config="{ dropdownSelector: '#duedate',startView:'day', minView:'day'}" />
						               </ul>
						              </div>
						             </div> -->
						             
						             <ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="gatePass.date"
										id="requisitionDate" name="requisitionDate"
										data-ng-change="checkDatesCL(gatePass.date)"
										friendly-name="Valid From" validation="required" />
						            </div>
						           </div>
								   <div class="form-group">
								    <label class="col-md-4 control-label"> Type </label>
								    <div class="col-md-7" >
									   <div class="radio">
										   <label class="i-checks" ng-init = "gatePass.wardType = 1">
										       <input type="radio" class="radiobox style-0" checked="checked" name="wardType" id="isInWard" ng_model="gatePass.wardType" value="1" data-ng-true-value="'YES'" data-ng-false-value="'NO'"> <i></i> Inward </label>
										   <label class="i-checks">
										       <input type="radio" class="radiobox style-0" checked="checked" name="wardType" id="isOutWard" ng_model="gatePass.wardType" value="2" data-ng-true-value="'NO'" data-ng-false-value="'YES'">
										       <i></i> Outward </label>
									   </div>
									 </div>
       							</div>
     						  <div class="form-group">
							      <label class="col-md-4 control-label"> Party </label>
							      <div class="col-md-7">
							       <select class="form-control input-sm" name="party" ng-model="gatePass.party">
							        <option value="">--Select--</option>
							         <option value="Customer">Customer</option>
							         <option value="Supplier">Supplier</option>
							         <option value="Others">Others</option>
							       </select>
							      </div>
							  </div>

						     <div class="form-group">
								<label class="col-md-4 control-label"> Mode of Delivery </label>
								<div class="col-md-7" ng-init="gatePass.modeofdelivery='Person'">
									<select class="form-control input-sm"  ng-model="gatePass.modeofdelivery" name="inWard"  id="type" data-validator="required" data-valid-method="submit" >
										<option value="Person">Person</option>
										<option value="Courier">Courier</option>
										<option value="Vehicle">Vehicle</option>
									</select>
								</div>
							</div>
							<div class="form-group"  ng-if="gatePass.modeofdelivery=='Person'">
								<label class="col-md-4 control-label">Person Name</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="AssetCode" ng-model="gatePass.personname" >
								</div>
							</div>
							<div class="form-group"  ng-if="gatePass.modeofdelivery=='Courier'">
								<label class="col-md-4 control-label">Courier Name</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="AssetCode" ng-model="gatePass.couriername" >
								</div>
							</div>
							<div class="form-group" ng-if="gatePass.modeofdelivery=='Courier'">
								<label class="col-md-4 control-label">Docket No</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="AssetCode" ng-model="gatePass.docno" >
								</div>
							</div>
							<div class="form-group" ng-if="gatePass.modeofdelivery=='Courier'">
								<label class="col-md-4 control-label"> No of Packages </label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="AssetCode" ng-model="gatePass.noofpackage" phonenumbers-only>
								</div>
							</div>
							
							<div class="form-group"  ng-if="gatePass.modeofdelivery=='Vehicle'">
								<label class="col-md-4 control-label">Vehicle No</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="AssetCode" ng-model="gatePass.vehicleno" >
								</div>
							</div>
							<div class="form-group">
							    <label class="col-md-4 control-label"> Remarks/Reason </label>
							     <div class="col-md-7">
							     	<textarea name="address" class="form-control input-sm" cols="5" rows="4" id="address" ng-model="gatePass.remarks"></textarea>
							     </div>
							 </div>
							 <div class="form-group">
							    <label class="col-md-4 control-label"> </label>
							     <div class="col-md-7">
							     	<div class="checkbox">
            								<label>
		             							<input class="checkbox style-0" type="checkbox" ng-model="gatePass.returnable"><span></span>Is Returnable
		           							</label>
              			 			</div>
							     </div>
							   </div>
          				</div>
          				</fieldset>
          				</div>

       <!-- <div class="col-sm-12 col-md-12 col-lg-12"><br>
				        		<div role="content">
							      <div class="widget-body no-padding">
							       <div
							        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
							        data-st-table="displayedCollectionItem"
							        data-st-safe-src="rowCollectionItem">
												<table id="dt_basic"
												         class="table table-striped table-bordered table-hover dataTable no-footer"
												         role="grid" aria-describedby="dt_basic_info">
													<thead class="dataTables-Main-Head">
														<tr>
															<th colspan=1 class="width_1 table-heading "></th>
															<th class="sorting width_10" st-sort="itemName">Item Name</th>
	                   										<th class="sorting width_12" st-sort="quantity">S.No/Batch No</th>
	                   										<th class="sorting width_12" st-sort="quantity">Quantity</th>
	                   										<th class="sorting width_12" st-sort="quantity">Approximate Value</th>
	                   										<th class="width_2 text-center table-heading">Action</th>
														</tr>
													</thead>

													<tbody ng-repeat="(trIndex, row) in gatePass.gatepassTables">
														<tr>
															<td>
																<label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label>
															</td>
															<td class="width_10">
																<div class="row">
																	<div class="col-xs-12">
																		<input type="text" class="form-control input-sm" ng-model="row.itemname" name="itemname"/>
																	</div>
																</div>
															</td>
															<td class="width_10">
																<div class="row">
																	<div class="col-xs-12">
																		<input type="text" class="form-control input-sm" ng-model="row.serialno" name="serialno" />
																	</div>
																</div>
															</td>
															<td class="width_10">
																<div class="row">
																	<div class="col-xs-12">
																		<input type="text" class="form-control input-sm" ng-model="row.quantity" name="quantity" />
																	</div>
																</div>
															</td>
															<td class="width_10">
																<div class="row">
																	<div class="col-xs-12">
																		<input type="text" class="form-control input-sm" ng-model="row.value" name="value" />
																	</div>
																</div>
															</td>
															<td class="width_10 text-center">
												        		<span>
												         			<i class="fa  fa-pencil text-success text" data-ng-click="editAddItem(gatePassItem.gatepassItemId)"></i>
												        		</span>
												        		<span>
												         			<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteAddItem(gatePassItem.gatepassItemId)"></i>
												        		</span>
															</td>
														</tr>
													</tbody>
												</table>
												<div class="padding-right-5" id="AddOrRmveMeritbtn" style=" padding-top: 1%; padding-left: 1%; padding-bottom: 1%;">
													<button ng-click="addgatepassRow(gatePass.gatepassTables)" ng-disabled="isDisable" class="btn btn-primary" type="button">
															<i class="fa fa-plus"></i> Add Row
													</button>
													<button ng-click="removegatepassRow(gatePass.gatepassTables)" ng-disabled="isDisable" class="btn btn-danger" type="button">
															<i class="fa fa-trash-o"></i> Delete Row
													</button>
												</div>
											</div>
										</div>
									</div>
								 </div> -->
       <div ng-show="gatePass.wardType==2 || gatePass.wardType==1">
         <section widget-grid id="widget-grid">
           <article class="col-sm-12">
            <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false"
             data-widget-deletebutton="false">
            
               <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
                st-table="displayedCollection" st-safe-src="rowCollectionItem">
                <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
                 <button ng-click="add()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="isDisable"
                  type="button">
                  <i class="fa fa-plus"></i>
                 </button>
                  <button ng-click="removeGateItem(displayedCollection)" class="btn btn-sm btn-danger" type="button" ng-disabled="isDisable"
                  tooltip="Delete">
                  <i class="fa  fa-trash-o"></i>
                 </button> 

                </div>
                <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer"
                 role="grid" aria-describedby="dt_basic_info">
                 <thead class="dataTables-Main-Head">
                  <tr>
                   <th class="width_1 text-center table-heading">
		           
		           </th>
	                   <th class="sorting width_10" st-sort="itemName">Out Item Name</th>
	                   <!-- <th class="sorting width_12" st-sort="quantity">S.No/Batch No</th> -->
	                   
	                   <th class="sorting width_12" st-sort="quantity">UOM</th>
	                   <th class="sorting width_12" st-sort="quantity">Quantity</th>
	                   
	                   <th class="sorting width_12" st-sort="quantity">Alternate UOM</th>
	                   <th class="sorting width_12" st-sort="quantity">Alternate Quantity</th>
	                   
	                   <th class="sorting width_12" st-sort="quantity">In Item Name</th>
	                   <th class="sorting width_12" st-sort="quantity">In Vendor UOM</th>
	                   <th class="sorting width_12" st-sort="quantity">Receiving Vendor Quantity</th>
	                   <th class="sorting width_12" st-sort="quantity">Converted Purchase Quantity</th>
	                   <th class="sorting width_12" st-sort="quantity">Approximate Value</th>
 <th class="sorting width_12" st-sort="description">Description</th>
	                   
	                   <th class="width_2 text-center table-heading">Action</th>
                  </tr>
                 </thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="gatePassItem in displayedCollection  track by $index"
					>
						<td> <label class="i-checks m-b-none">
		             <input type="checkbox" ng-model="gatePassItem.select">
		             <i></i>
		            </label></td>
						<!-- <td>{{gatePassItem.itemname}}</td> -->
						<td>{{gatePassItem.itemNamenew}}</td>
		         		<!-- <td>{{gatePassItem.serialno}}</td> -->
		         		<td>{{gatePassItem.uomName}}</td>
		         		<td>{{gatePassItem.quantity}}</td>
		         		<td>{{gatePassItem.altuomName}}</td>
		         		<td>{{gatePassItem.altquantity}}</td>
		         		<td>{{gatePassItem.convitemNamenew}}</td>
		         		<td>{{gatePassItem.convvendoruomName}}</td>
		         		<td>{{gatePassItem.receivingvendorQty}}</td>
		         		<td>{{gatePassItem.convertedpurchaseQty}}</td>
		         		<td>{{gatePassItem.value}}</td>
                        <td>{{gatePassItem.description1}}</td>
		         		
		           		<td class=" td-actions text-center">
		        		<span>
		         			<i class="fa  fa-pencil text-success text" data-ng-click="editAddItem(gatePassItem,$index)"></i>
		        		</span>
		        		<!-- <span>
		         			<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteAddItem(gatePassItem,$index)"></i>
		        		</span> -->
		        		<span title="Converted Detail Info" ng-if="gatePass.returnable == true">
		         			<i class="fa  fa-expand" data-ng-click="ItemConvertedQtyCalc(gatePassItem,$index)"></i>
		        		</span>
		        		
	       				</td>
	          		</tr>
         		</tbody>
                </table>
                <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
               </div>
              </div>
             </div>
            </div>
           </article>
         </section>
         </div>
         </div><br>
         <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         	<div class="col-md-5">
        		<div class="form-group">
        		</div>
        	</div>
        	<div class="col-md-5">
        		<div class="form-group">
        		<!-- <button ng-click="add()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="isDisable" type="button">
                  <i class="fa fa-plus"></i>
            	</button> -->
        		</div>
        	</div>

        	<div class="col-md-2">
        	 <div class="form-group" ng-show="gatePass.wardType==2 || gatePass.wardType==1" >
				<label class="col-md-5 control-label">Total</label>
					<div class="col-md-7">
						<input type="text" class="form-control input-sm" name="AssetCode" ng-model="gatePass.totalqty" >
					</div>
				</div>
				</div>
         	</div>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-success" type="button"
						class="btn btn-success"
						data-ng-click="save(gatePassForm)" data-ng-if="!isEdit">
						<i class="fa fa-save"></i>Save
					</button>
					<button class="btn btn-success" type="button"
						class="btn btn-success" id="update"
						data-ng-click="update(gatePassForm);"
						data-ng-if="isEdit == true">
						<i class="fa fa-save"></i>Upadte
					</button>
					<button class="btn btn-info" type="button"
						class="btn btn-success"
						data-ng-click="resetfun()">
						<i class="fa fa-undo"></i>Reset
					</button>
					<button class="btn btn-danger" type="button"
						class="btn btn-success" data-ng-click="cancel();">
						<i class="fa fa-close"></i>cancel
					</button>
				</div>
			</div>
		</div>
       </form>
      </div>
     </div>
    </div>
   </article>
  </div>
 </section>
</div>