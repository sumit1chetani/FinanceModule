<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
	
				       <form class="form-horizontal" name="PurchaseQuotationForm" novalidate method="post">
				        <div class="row">
				        	<div class="col-sm-12 col-md-12 col-lg-12">
					         	<div class="col-md-6">
					         		<div class="form-group" ng-if="edit">
						     			<label class="col-md-3 control-label"> Purchase Quote No
						     				</label>
						     				<div class="col-md-7">
											<input type="text" class="form-control input-sm" readonly
											ng-model="purchaseQuotation.quotationNo">
										</div>
									</div>
										<div class="form-group">
							            <label class="col-md-3 control-label"> Purchase For <spring:message
					             			code="label.asterisk.symbol"></spring:message></label>
							            <div class="col-md-7">
							            <!--   <select class="form-control" id="cmbPurchaseFor" name="Purchase For"
							              data-ng-model="purchaseQuotation.purchaseFor"
							               data-ng-options="purchaseFor.defTableId as purchaseFor.value for purchaseFor in purchaseForList"
							               validation="required" friendly-name="Purchase For">
								               <option value="">Select</option>
								          </select> -->
								          <!-- <selectivity list="purchaseForList" property="purchaseQuotation.purchaseFor" id="cmbPurchaseFor"></selectivity> -->
							           								          	<selectivity list="purchaseForList" ng-model="purchaseQuotation.purchaseFor" ng-if="!edit"
			        							property="purchaseQuotation.purchaseFor" id="purchaseFor"  object="purchaseFor"  name="purchaseFor"
			        							validation="required" friendly-name="PurchaseFor" form-name = "PurchaseQuotationForm"></selectivity>
			        							
			        							        	<selectivity list="purchaseForList" ng-model="purchaseQuotation.purchaseFor" ng-if="edit"
			        							property="purchaseQuotation.purchaseFor" id="purchaseFor"  object="purchaseFor"  name="purchaseFor"
			        							validation="required" friendly-name="PurchaseFor" form-name = "PurchaseQuotationForm"></selectivity>
							            </div>
						            </div>
						<%-- 		<div class="form-group">
							            <label class="col-md-3 control-label"> Purchase For <spring:message
					             			code="label.asterisk.symbol"></spring:message></label>
							            <div class="col-md-7">
						            <select class="form-control" id="cmbPurchaseFor" name="Purchase For"
							              data-ng-model="purchaseQuotation.purchaseFor"
							               data-ng-options="purchaseFor.defTableId as purchaseFor.value for purchaseFor in purchaseForList"
							               validation="required" friendly-name="Purchase For">
								               <option value="">Select</option>
								          </select>  
								          	<selectivity list="purchaseForList" ng-model="purchaseQuotation.purchaseFor" ng-if="!edit"
			        							property="purchaseQuotation.purchaseFor" id="purchaseFor"  object="purchaseFor"  name="purchaseFor"
			        							validation="required" friendly-name="PurchaseFor" form-name = "PurchaseQuotationForm"></selectivity>
			        							      	<selectivity list="purchaseForList" ng-model="purchaseQuotation.purchaseFor" ng-if="edit==true" 
			        							property="purchaseQuotation.purchaseFor" id="purchaseFor"  object="purchaseFor"  name="purchaseFor"
			        							validation="required" friendly-name="PurchaseFor" form-name = "PurchaseQuotationForm" disabled="true"></selectivity>
						 -->		    <!--   <selectivity list="purchaseForList" ng-model="purchaseQuotation.purchaseFor" ng-if="!edit"
			        							property="purchaseQuotation.purchaseFor" id="cmbPurchaseFor"  object="purchaseFor"  name="purchaseFor"
			        							validation="required" friendly-name="purchaseFor" form-name = "PurchaseQuotationForm"></selectivity>
								          <selectivity list="purchaseForList" property="purchaseQuotation.purchaseFor" id="cmbPurchaseFor"></selectivity>
							       -->      </div>
						            </div> --%>
									<div class="form-group">
					       				<label class="col-md-3 control-label"> Vendor <spring:message code="label.asterisk.symbol"></spring:message></label>
					       				<div class="col-md-7">
											<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId" ng-if="!edit"
			        							property="purchaseQuotation.vendorId" id="vendor"  object="vendor"  name="vendor"
			        							validation="required" friendly-name="vendor" form-name = "PurchaseQuotationForm"></selectivity>
			        							
			        							<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId"  ng-if="edit==true" 
			        							property="purchaseQuotation.vendorId" id="vendor"  object="vendor"  name="vendor"
			        							validation="required" friendly-name="vendor" form-name = "PurchaseQuotationForm" disabled="true"></selectivity>
			        							
			        						<!-- <select class="form-control input-sm" id="vendor" name="vendor" data-ng-model="purchaseQuotation.vendorId"
										        	data-ng-options="ac.id as ac.text for ac in vendorList" disabled ng-if="edit==true" 
										        	friendly-name="vendor" form-name = "PurchaseQuotationForm" validation="required" >
										          	<option value="" selected="selected">Select</option>
									     	</select>	 -->
										</div>
									</div>
									<div class="form-group">
					       				<label class="col-md-3 control-label"> Vendor Location</label>
					       				<div class="col-md-7">
											 <input type="hidden" class="form-control input-sm" ng-model="purchaseQuotation.vendorLocId" id="txtVenLocId" ng-disabled="true" />
											 <input type="text" class="form-control input-sm" ng-model="purchaseQuotation.vendorLocName" id="txtVenLocName" ng-disabled="true" />
										</div>
									</div>
									<div class="form-group">
						            	<label class="col-md-3 control-label"> Vendor Address</label>
							            <div class="col-md-7">
								            <div class="col-md-12 no-padding">
								             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" readonly ng-model="purchaseQuotation.vendorAddress"> </textarea>
								            </div>
									        <div class="col-md-12 no-padding">
										        <div class="col-md-5 no-padding padding-top-5">
													<input type="text" class="form-control input-sm" placeholder="city" ng-model="purchaseQuotation.cityName" readonly>
										        </div>
										        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
										        	<input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseQuotation.state" readonly>
										        </div>
										        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
										        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="purchaseQuotation.zipcode" readonly>
										        </div>
									        </div>
									        <div class="col-md-12 no-padding padding-top-5">
								             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseQuotation.country" readonly>
								            </div>
							            </div>
						            </div>
					        	</div>
					        	<div class="col-md-6">
					        		<div class="form-group">
					       				<label class="col-md-4 control-label"> PQ Date <spring:message
					             			code="label.asterisk.symbol"></spring:message></label>
					       				<div class="col-md-7">
											<div class='input-group date width_100 datetimepick'>
									            <div class="dropdown">
									             <a class="dropdown-toggle" id="curDate" role="button"
									              data-toggle="dropdown" data-target="#" href="#">
									              <div class="input-group">
									               <input type="text" class="form-control"
									                placeholder="dd/mm/yyyy" name="currentDate"
									                validation="date_euro_long|required" readonly
									                friendly-name="Purchase Quotation Date"
									                data-ng-model="purchaseQuotation.quoteDate"><span
									                class="input-group-addon"><i
									                class="glyphicon glyphicon-calendar"></i></span>
									              </div>
									             </a>
									             <!-- <ul class="dropdown-menu" role="menu"
									              aria-labelledby="dLabel">
									              <datetimepicker data-ng-model="purchaseQuotation.quoteDate"
									               data-on-set-time="purchaseQuotation.quoteDate = onDateSet(newDate)"
									               data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
									             </ul> -->
									            </div>
									        </div>
										</div>
									</div>
					<%-- 				<div class="form-group">
							            <label class="col-md-4 control-label"> Purchase Type <spring:message
					             			code="label.asterisk.symbol"></spring:message></label>
							            <div class="col-md-7">
							            	  <select class="form-control" id="cmbPurchaseType" name="Purchase Type" data-ng-model="purchaseQuotation.purchaseType"
							             	 ng-options="purchaseType.defTableId as purchaseType.value for purchaseType in purchaseTypeList"
							             	 ng-change="getPurchaseTypeDetails(purchaseQuotation.purchaseType,purchaseTypeList)"
							             	 validation="required" friendly-name="Purchase Type">
								              
								          	</select> 
								          	
								          	 <!-- 	<selectivity list="purchaseTypeList" ng-model="purchaseQuotation.purchaseType" ng-if="!edit"
			        							property="purchaseQuotation.purchaseType" id="purchaseType"  object="purchaseType"  name="purchaseType"
			        							validation="required" friendly-name="PurchaseType" form-name = "PurchaseQuotationForm"></selectivity>
			        							       	 	<selectivity list="purchaseTypeList" ng-model="purchaseQuotation.purchaseType" ng-if="edit==true" 
			        							property="purchaseQuotation.purchaseType" id="purchaseType"  object="purchaseType"  name="purchaseType"
			        							validation="required" friendly-name="PurchaseType" form-name = "PurchaseQuotationForm" disabled="true"></selectivity>
							 -->            </div>
						            </div> --%>
						            		<div class="form-group">
							            <label class="col-md-4 control-label"> Purchase Type <spring:message
					             			code="label.asterisk.symbol"></spring:message></label>
							            <div class="col-md-7">
<!-- 							            	 <select class="form-control" id="cmbPurchaseType" name="Purchase Type" data-ng-model="purchaseQuotation.purchaseType"
							             	 ng-options="purchaseType.defTableId as purchaseType.value for purchaseType in purchaseTypeList"
							             	 ng-change="getPurchaseTypeDetails(purchaseQuotation.purchaseType,purchaseTypeList)"
							             	 validation="required" friendly-name="Purchase Type">
								               <option value="">Select</option>
								          	</select> -->
								          	
								          	<selectivity list="purchaseTypeList" ng-model="purchaseQuotation.purchaseType" 
			        							property="purchaseQuotation.purchaseType" id="purchaseType"  object="purchaseType"  name="purchaseType"
			        							validation="required" friendly-name="PurchaseType" form-name = "PurchaseQuotationForm"></selectivity>
							            </div>
						            </div>
					            	<div class="form-group width_100 padding-left-190" ng-if="fixedPriceAndQuantity">
					             		<div class="col-md-1">
							              		<div class="checkbox padding-top-0">
							               			<label>
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="purchaseQuotation.fixedPrice" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>

							             </div>
				            			<label class="col-md-4 text-aling-left control-label padding-top-0 line-height-20">Fixed Price</label>
					             		<div class="col-md-1">
						              		<div class="checkbox padding-top-0 min-height-18">
						               			<label>
						               				<input type="checkbox" class="checkbox style-0" data-ng-model="purchaseQuotation.fixedQty" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
						                			<span></span>
						               			</label>
						              		</div>
							             </div>
								        <label class="col-md-4 text-aling-left control-label padding-top-0 line-height-20">Fixed Qty</label>
					            	</div>
					            	<div class="form-group">
				        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name <spring:message
				              			code="label.asterisk.symbol"></spring:message></label>
				        				<div class="col-md-7">
					        				<selectivity list="companyList" property="purchaseQuotation.companyId" id="hospital"
					        				ng-model="purchaseQuotation.companyId" name="hospital" form-name = "PurchaseQuotationForm"
					        				validation="required" friendly-name="<spring:message
			              			code="label.company.name"></spring:message>"></selectivity>
										</div>
									</div>
									    	<!-- 	<div class="form-group">
											<label class="col-md-4 control-label"> Cost Center <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="costList" ng-model="purchaseQuotation.costcenter" property="purchaseQuotation.costcenter" id="costcenter" object="costcenter"  name="costcenter" validation="required" friendly-name="Cost Center" form-name = "PurchaseQuotationForm"></selectivity>

											</div>
										</div> -->
					            	<fieldset class="b-a width_75 margin-bottom-10 margin-left-16">
					            		<legend class="width_25 b-a margin-bottom-10 padding-left-10 margin-left-5">Validity</legend>
						            	<div class="form-group">
						       				<label class="col-md-3 control-label"> From Date <spring:message
					             			code="label.asterisk.symbol"></spring:message></label>
						       				<div class="col-md-8">
												<div class='input-group date width_100 datetimepick'>
										            <div class="dropdown">
										             <a class="dropdown-toggle" id="from_date" role="button"
										              data-toggle="dropdown" data-target="#" href="#">
										              <div class="input-group">
										               <input type="text" class="form-control"
										                placeholder="dd/mm/yyyy" name="From Date"
										                validation="date_euro_long|required"
										                friendly-name="From Date" readonly
										                data-ng-model="purchaseQuotation.validFromDate"><span
										                class="input-group-addon"><i
										                class="glyphicon glyphicon-calendar"></i></span>
										              </div>
										             </a>
										             <!-- <ul class="dropdown-menu" role="menu"
										              aria-labelledby="dLabel">
										              <datetimepicker data-ng-model="purchaseQuotation.validFromDate"
										               data-on-set-time="purchaseQuotation.validFromDate = onDateSet(newDate)"
										               data-datetimepicker-config="{ dropdownSelector: '#from_date',startView:'day', minView:'day'}" />
										             </ul> -->
										            </div>
										        </div>
											</div>
										</div>
										<div class="form-group">
						       				<label class="col-md-3 control-label"> To Date </label>
						       				<div class="col-md-8">
												<div class='input-group date width_100 datetimepick'>
										            <div class="dropdown">
										             <a class="dropdown-toggle" id="to_date" role="button"
										              data-toggle="dropdown" data-target="#" href="#">
										              <div class="input-group">
										               <input type="text" class="form-control"
										                placeholder="dd/mm/yyyy" name="To Date"
										                data-ng-model="purchaseQuotation.validToDate"><span
										                class="input-group-addon"><i
										                class="glyphicon glyphicon-calendar"></i></span>
										              </div>
										             </a>
										             <ul class="dropdown-menu" role="menu"
										              aria-labelledby="dLabel">
										              <datetimepicker data-ng-model="purchaseQuotation.validToDate"
										               data-on-set-time="purchaseQuotation.validToDate = onDateSet(newDate)"
										               data-datetimepicker-config="{ dropdownSelector: '#to_date',startView:'day', minView:'day'}" />
										             </ul>
										            </div>
										        </div>
											</div>
										</div>
					            	</fieldset>
					                                 <div class="form-group">
											<label class="col-md-4 control-label"> Cost Center <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="costList" ng-model="purchaseQuotation.costcenter" property="purchaseQuotation.costcenter" id="costcenter" object="costcenter"  name="costcenter" validation="required" friendly-name="Cost Center" form-name = "PurchaseQuotationForm"></selectivity>

											</div>
										</div>
					            	
					        	</div>
				        	</div> <!-- /col-sm-12 col-md-12 col-lg-12 -->
				        <!-- 	<div class="col-sm-12 col-md-12 col-lg-12"> -->
				        		<div class="col-sm-6 col-md-6 col-lg-6">
					        		<div class="form-group">
							            <label class="col-md-3 control-label"> Remarks
							            </label>
							            <div class="col-md-7">
							             <textarea class="text-left form-control input-sm" rows="4" cols="20" style="resize: none" ng-model="purchaseQuotation.remarks"> </textarea>
							            </div>
							        </div>
						        </div>
						        <div class="col-sm-6 col-md-6 col-lg-6">
						        	<div class="form-group" ng-if="isPmtTerms">
							            <label class="col-md-4 control-label"> Payment Terms (Days)
							            </label>
							            <div class="col-md-5">
							             <input class="text-left form-control input-sm text-right" id="paymentTerms" name="paymentTerms" ng-model="purchaseQuotation.paymentTerms" data-ng-keyup="onChangeNumber(purchaseQuotation.paymentTerms)" />
							            </div>
							             <!-- <span class="pull-left line-height-30">Days</span> -->
							        </div>
						        </div>
				        	</div>
				        	<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10 b-a" id="totalValues">
				        		<div role="content">
							      <div class="widget-body no-padding">
							       <div style="min-width:70%; overflow-x:scroll" 
							       	class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
							        data-st-table="displayedCollection" data-st-safe-src="rowCollection">
									<!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
									<div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
							           <button ng-click="addPurchaseRow()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="" type="button">
							            <i class="fa fa-plus"></i>
							           </button>
							           <button ng-click="removePurchaseRow()" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
							            <i class="fa  fa-trash-o"></i>
							           </button>
							        <!--        	 <div  align="center" style="
    margin-left: -84%;
    margin-top: -2%;
							               	 ">
		 <button class="btn btn-success"  type="button"
								ng-click="fileUpload()">
								<i class="fa fa-upload"></i> Upload
							</button>
							</div> -->
							      	</div>
							      	
							      	        <table id="dt_basic"  class="table table-striped table-bordered table-hover dataTable no-footer"
							         role="grid" aria-describedby="dt_basic_info">
							         
							         <thead class="dataTables-Main-Head">
							          <tr>
						          	  <th class="width_1 table-heading text-center">
							             <label class="i-checks m-b-none">
							             <input type="checkbox"  ng-model="selectedAll" ng-change="checkAllQuotation(selectedAll)">
							             <i></i>
							            </label>
							           </th>
							         <th class="sorting width_1 visible-left" data-st-sort="">Quot Dtl Id</th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Id</th>
							           <th class="sorting width_7" data-st-sort="" >Req. No1</th>
									   <!-- <th class="sorting width_10" data-st-sort="">Req. Location</th> -->
							           <th class="sorting width_15" data-st-sort="">Item Code - Item Name</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Item Name</th> -->
							           <th class="sorting width_5" data-st-sort="">EDD</th>
							           <th class="sorting width_8" data-st-sort="">Vendor UOM</th>
							           <th class="sorting width_12" data-st-sort="" data-ng-if="consignmentQtyLabel">Consignment Qty</th>
							           <th class="sorting width_5" data-st-sort="" data-ng-if="!consignmentQtyLabel">Vendor Qty</th>
							           <!-- <th class="sorting width_7" data-st-sort="">Lead Time</th> -->
							           <th class="sorting width_7" data-st-sort="">Unit Price</th>
							           <th class="sorting width_7" data-st-sort="">Price</th>
							           <th class="sorting width_12" data-st-sort="">Discount Type</th>
							           <th class="sorting width_7" data-st-sort="">Discount</th>
							           <th class="sorting width_7" data-st-sort="">Tax Type</th>
							           <th class="sorting width_7" data-st-sort="">Tax</th>
							           <th class="sorting width_7" data-st-sort="">Sub Total</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Discount</th> -->
							           <!-- <th class="sorting width_6" data-st-sort="">Tax</th> -->
							           <th class="sorting width_7" data-st-sort="">Status</th>
							         <%-- <th class="width_6 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
							          </tr>
							         </thead>

							         							        <tbody class="dataTables-Main-Body">
							         <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  ng-repeat="quotationDtl in purchaseQuotation.quotationDetailList">
							         	<td>
							         		<label class="i-checks m-b-none"> 
							         		<input type="checkbox" ng-model="quotationDtl.select" id="quotationDtl.select"><i></i>
							         		</label>
							         	</td>
							         	<td class="visible-left">{{quotationDtl.quotationDetailId}}</td>
							         	<td class="visible-left">{{quotationDtl.quotationId}}</td>
							         	
							         	<td class="text-aling-left">{{quotationDtl.requisitionNo}}</td>
						
							         	<td class="text-aling-left"> {{quotationDtl.itemName}}</td>
							         	<!-- <td class="text-aling-left">{{quotationDtl.itemName}}</td> -->
							         	<td class="text-aling-left">{{quotationDtl.eddDate}}</td>
							         	<td class="text-aling-left">{{quotationDtl.vendorUomName}}</td>
							         	<td class="text-aling-right">{{quotationDtl.vendorQuantity}}</td>
							         	<!-- <td>{{quotationDtl.deliveryLeadTime}}</td> -->
							         	<td class="text-aling-right">{{quotationDtl.unitPrice}}</td>
							         	<td class="text-aling-right">{{quotationDtl.amount}}</td>
										<td class="text-aling-left">{{quotationDtl.discountType}}</td>
										<td class="text-aling-right">{{quotationDtl.disAmt}}</td>
										<td class="text-aling-left">{{quotationDtl.taxCode}}</td>
										<td class="text-aling-right">{{quotationDtl.taxAmt}}</td>
										<td class="text-aling-right">{{quotationDtl.rowSubTotal}}</td>
								<td>
     										<select class="form-control input-sm" ng-if="quotationDtl.statuschange==true" disabled ="true" ng-model="quotationDtl.queryStatus" ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
											<select class="form-control input-sm" ng-if="quotationDtl.statuschange==false" ng-model="quotationDtl.queryStatus"  ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
   										</td>
				<!-- 			         	<td>{{quotationDtl.status}}</td> -->
							         </tr>
							         </tbody> 
							        </table>
							       </div>
							      </div>
							      <!-- end widget content -->
							    </div> <!-- /role[content] -->
							</div> <!-- /col-md-12 -- -->
							<!-- -->
														
					 		
						<div class="col-md-12 padding-top-20" id="totalValues">
				       			<div class="form-group">
				       				<label class="col-md-1 control-label"> SubTotal </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.subTotal" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Discount </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalDiscount" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Tax </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalTax" readonly />
									</div>
									<label class="col-md-1 control-label"> Freight </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm text-right" data-ng-model="purchaseQuotation.totalFreight" ng-keyup="calGrandTotalWithFreight(purchaseQuotation.totalFreight)" ng-pattern-restrict="{{numExp}}"/>
									</div>
									<label class="col-md-1 control-label"> Total </label>
				       				<div class="col-md-2">
										<input type="text" class="form-control input-sm"  data-ng-model="purchaseQuotation.grandTotal" readonly />
									</div>
								</div>
				       		</div>  
							      	<br><br>
							      	<tabset>
        			 	<!-- /Address tab -->
        				
        				<!-- /Address tab -->
        				<tab heading="Upload1">
        					<div class="row">
						  		<div class="col-sm-12 padding-top-10">								     			
						<div class="form-group">
					       				<label class="col-md-2 control-label"> Vendor <spring:message code="label.asterisk.symbol"></spring:message></label>
					       				<div class="col-md-2">
											<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId" ng-if="!edit"
			        							property="purchaseQuotation.vendorId1" id="vendor1"  object="vendor1"  name="vendor1"
			        						 friendly-name="vendor1" form-name = "PurchaseQuotationForm"></selectivity>
			        							
			        							<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId"  ng-if="edit==true" 
			        							property="purchaseQuotation.vendorId" id="vendor"  object="vendor"  name="vendor"
			        							 friendly-name="vendor" form-name = "PurchaseQuotationForm" disabled="true"></selectivity>
			        							
			        						<!-- <select class="form-control input-sm" id="vendor" name="vendor" data-ng-model="purchaseQuotation.vendorId"
										        	data-ng-options="ac.id as ac.text for ac in vendorList" disabled ng-if="edit==true" 
										        	friendly-name="vendor" form-name = "PurchaseQuotationForm" validation="required" >
										          	<option value="" selected="selected">Select</option>
									     	</select>	 -->
										</div>
										  	 <button class="btn btn-success"  type="button"
								ng-click="fileUpload()">
								<i class="fa fa-upload"></i> Upload
							</button>
							
									</div>
									    	<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10 b-a" id="totalValues">
				        		<div role="content">
							      <div class="widget-body no-padding">
							       <div style="min-width:70%; overflow-x:scroll" 
							       	class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
							        data-st-table="displayedCollection1" data-st-safe-src="rowCollection1">
									
									<table id="dt_basic"  class="table table-striped table-bordered table-hover dataTable no-footer"
							         role="grid" aria-describedby="dt_basic_info">
							         <thead class="dataTables-Main-Head">
							          <tr>
						          	  <th class="width_1 table-heading text-center">
							             <label class="i-checks m-b-none">
							             <input type="checkbox"  ng-model="selectedAll1" ng-change="checkAllQuotation(selectedAll1)">
							             <i></i>
							            </label>
							           </th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Dtl Id</th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Id</th>
							           <th class="sorting width_7" data-st-sort="" >Req. No2</th>
									   <!-- <th class="sorting width_10" data-st-sort="">Req. Location</th> -->
							           <th class="sorting width_15" data-st-sort="">Item Code - Item Name</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Item Name</th> -->
							           <th class="sorting width_5" data-st-sort="">EDD</th>
							           <th class="sorting width_8" data-st-sort="">Vendor UOM</th>
							           <th class="sorting width_12" data-st-sort="" data-ng-if="consignmentQtyLabel">Consignment Qty</th>
							           <th class="sorting width_5" data-st-sort="" data-ng-if="!consignmentQtyLabel">Vendor Qty</th>
							           <!-- <th class="sorting width_7" data-st-sort="">Lead Time</th> -->
							           <th class="sorting width_7" data-st-sort="">Unit Price</th>
							           <th class="sorting width_7" data-st-sort="">Price</th>
							           <th class="sorting width_12" data-st-sort="">Discount Type</th>
							           <th class="sorting width_7" data-st-sort="">Discount</th>
							           <th class="sorting width_7" data-st-sort="">Tax Type</th>
							           <th class="sorting width_7" data-st-sort="">Tax</th>
							           <th class="sorting width_7" data-st-sort="">Sub Total</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Discount</th> -->
							           <!-- <th class="sorting width_6" data-st-sort="">Tax</th> -->
							           <th class="sorting width_7" data-st-sort="">Status</th>
							           <%-- <th class="width_6 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
							          </tr>
							         </thead>
							        <tbody class="dataTables-Main-Body">
							         <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  ng-repeat="quotationDtl in displayedCollection1">
							         	<td>
							         		<label class="i-checks m-b-none"> 
							         		<input type="checkbox" ng-model="quotationDtl.select" id="quotationDtl.select"><i></i>
							         		</label>
							         	</td>
							         	<td class="visible-left">{{quotationDtl.quotationDetailId}}</td>
							         	<td class="visible-left">{{quotationDtl.quotationId}}</td>
							         	
							         	<td class="text-aling-left">{{quotationDtl.requisitionNo}}</td>
						
							         	<td class="text-aling-left"> {{quotationDtl.itemName}}</td>
							         	<!-- <td class="text-aling-left">{{quotationDtl.itemName}}</td> -->
							         	<td class="text-aling-left">{{quotationDtl.eddDate}}</td>
							         	<td class="text-aling-left">{{quotationDtl.vendorUomName}}</td>
							         	<td class="text-aling-right">{{quotationDtl.vendorQuantity}}</td>
							         	<!-- <td>{{quotationDtl.deliveryLeadTime}}</td> -->
							         	<td class="text-aling-right">{{quotationDtl.unitPrice}}</td>
							         	<td class="text-aling-right">{{quotationDtl.amount}}</td>
										<td class="text-aling-left">{{quotationDtl.discountType}}</td>
										<td class="text-aling-right">{{quotationDtl.disAmt}}</td>
										<td class="text-aling-left">{{quotationDtl.taxCode}}</td>
										<td class="text-aling-right">{{quotationDtl.taxAmt}}</td>
										<td class="text-aling-right">{{quotationDtl.rowSubTotal}}</td>
								<td>
     										<select class="form-control input-sm" ng-if="quotationDtl.statuschange==true" disabled ="true" ng-model="quotationDtl.queryStatus" ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
											<select class="form-control input-sm" ng-if="quotationDtl.statuschange==false" ng-model="quotationDtl.queryStatus"  ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
   										</td>
				<!-- 			         	<td>{{quotationDtl.status}}</td> -->
							         </tr>
							         </tbody> 
							        </table>
							        </div>
																				        </div>
																				        </div>
																        </div>
									
									<div class="col-md-12 padding-top-20" id="totalValues">
				       			<div class="form-group">
				       				<label class="col-md-1 control-label"> SubTotal </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.subTotal" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Discount </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalDiscount" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Tax </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalTax" readonly />
									</div>
									<label class="col-md-1 control-label"> Freight </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm text-right" data-ng-model="purchaseQuotation.totalFreight" ng-keyup="calGrandTotalWithFreight(purchaseQuotation.totalFreight)" ng-pattern-restrict="{{numExp}}"/>
									</div>
									<label class="col-md-1 control-label"> Total </label>
				       				<div class="col-md-2">
										<input type="text" class="form-control input-sm"  data-ng-model="purchaseQuotation.grandTotal" readonly />
									</div>
								</div>
				       		</div> 
								</div>											  
								 		
        					</div>
        				</tab>
        				<tab heading="Upload2">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
        							<fieldset>
				      				<div class="form-group">
					       				<label class="col-md-2 control-label"> Vendor <spring:message code="label.asterisk.symbol"></spring:message></label>
					       				<div class="col-md-2">
											<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId2" ng-if="!edit"
			        							property="purchaseQuotation.vendorId2" id="vendor2"  object="vendor"  name="vendor2"
			        						friendly-name="vendor2" form-name = "PurchaseQuotationForm"></selectivity>
			        							
			        							<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId"  ng-if="edit==true" 
			        							property="purchaseQuotation.vendorId" id="vendor"  object="vendor"  name="vendor"
			        						 friendly-name="vendor" form-name = "PurchaseQuotationForm" disabled="true"></selectivity>
			        							
			        						<!-- <select class="form-control input-sm" id="vendor" name="vendor" data-ng-model="purchaseQuotation.vendorId"
										        	data-ng-options="ac.id as ac.text for ac in vendorList" disabled ng-if="edit==true" 
										        	friendly-name="vendor" form-name = "PurchaseQuotationForm" validation="required" >
										          	<option value="" selected="selected">Select</option>
									     	</select>	 -->
										</div>
										       	 <button class="btn btn-danger"  type="button"
								ng-click="fileUpload1()">
								<i class="fa fa-upload"></i> Upload
							</button>
									</div>
										    	<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10 b-a" id="totalValues">
				        		<div role="content">
							      <div class="widget-body no-padding">
							       <div style="min-width:70%; overflow-x:scroll" 
							       	class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
							        data-st-table="displayedCollection2" data-st-safe-src="rowCollection2">
									
										<table id="dt_basic"  class="table table-striped table-bordered table-hover dataTable no-footer"
							         role="grid" aria-describedby="dt_basic_info">
							         <thead class="dataTables-Main-Head">
							          <tr>
						          	  <th class="width_1 table-heading text-center">
							             <label class="i-checks m-b-none">
							             <input type="checkbox"  ng-model="selectedAll2" ng-change="checkAllQuotation(selectedAll2)">
							             <i></i>
							            </label>
							           </th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Dtl Id</th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Id</th>
							           <th class="sorting width_7" data-st-sort="" >Req. No3</th>
									   <!-- <th class="sorting width_10" data-st-sort="">Req. Location</th> -->
							           <th class="sorting width_15" data-st-sort="">Item Code - Item Name</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Item Name</th> -->
							           <th class="sorting width_5" data-st-sort="">EDD</th>
							           <th class="sorting width_8" data-st-sort="">Vendor UOM</th>
							           <th class="sorting width_12" data-st-sort="" data-ng-if="consignmentQtyLabel">Consignment Qty</th>
							           <th class="sorting width_5" data-st-sort="" data-ng-if="!consignmentQtyLabel">Vendor Qty</th>
							           <!-- <th class="sorting width_7" data-st-sort="">Lead Time</th> -->
							           <th class="sorting width_7" data-st-sort="">Unit Price</th>
							           <th class="sorting width_7" data-st-sort="">Price</th>
							           <th class="sorting width_12" data-st-sort="">Discount Type</th>
							           <th class="sorting width_7" data-st-sort="">Discount</th>
							           <th class="sorting width_7" data-st-sort="">Tax Type</th>
							           <th class="sorting width_7" data-st-sort="">Tax</th>
							           <th class="sorting width_7" data-st-sort="">Sub Total</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Discount</th> -->
							           <!-- <th class="sorting width_6" data-st-sort="">Tax</th> -->
							           <th class="sorting width_7" data-st-sort="">Status</th>
<%-- 							           <th class="width_6 table-heading text-center"><spring:message code="label.action"></spring:message></th>
 --%>							          </tr>
							         </thead>
							          <tbody class="dataTables-Main-Body">
							         <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  ng-repeat="quotationDtl in displayedCollection2">
							         	<td>
							         		<label class="i-checks m-b-none"> 
							         		<input type="checkbox" ng-model="quotationDtl.select" id="quotationDtl.select"><i></i>
							         		</label>
							         	</td>
							         	<td class="visible-left">{{quotationDtl.quotationDetailId}}</td>
							         	<td class="visible-left">{{quotationDtl.quotationId}}</td>
							         	<td class="text-aling-left">{{quotationDtl.requisitionNo}}</td>
							         	<!-- <td>{{quotationDtl.requisitionNo}}</td> -->
							         	<td class="text-aling-left">{{quotationDtl.itemName}}</td>
							         	<!-- <td class="text-aling-left">{{quotationDtl.itemName}}</td> -->
							         	<td class="text-aling-left">{{quotationDtl.eddDate}}</td>
							         	<td class="text-aling-left">{{quotationDtl.vendorUomName}}</td>
							         	<td class="text-aling-right">{{quotationDtl.vendorQuantity}}</td>
							         	<!-- <td>{{quotationDtl.deliveryLeadTime}}</td> -->
							         	<td class="text-aling-right">{{quotationDtl.unitPrice}}</td>
							         	<td class="text-aling-right">{{quotationDtl.amount}}</td>
										<td class="text-aling-left">{{quotationDtl.discountType}}</td>
										<td class="text-aling-right">{{quotationDtl.disAmt}}</td>
										<td class="text-aling-left">{{quotationDtl.taxCode}}</td>
										<td class="text-aling-right">{{quotationDtl.taxAmt}}</td>
										<td class="text-aling-right">{{quotationDtl.rowSubTotal}}</td>
										<td>
     										<select class="form-control input-sm" ng-if="quotationDtl.statuschange==true" disabled ="true" ng-model="quotationDtl.queryStatus" ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
											<select class="form-control input-sm" ng-if="quotationDtl.statuschange==false" ng-model="quotationDtl.queryStatus"  ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
   										</td>
							         	<!-- <td>{{quotationDtl.status}}</td> -->
							         </tr>
							         </tbody>
							        </table>
							        	</div>
							        		</div>
							        			</div>
							        				</div>
									
								     	<div class="col-md-12 padding-top-20" id="totalValues">
				       			<div class="form-group">
				       				<label class="col-md-1 control-label"> SubTotal </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.subTotal" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Discount </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalDiscount" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Tax </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalTax" readonly />
									</div>
									<label class="col-md-1 control-label"> Freight </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm text-right" data-ng-model="purchaseQuotation.totalFreight" ng-keyup="calGrandTotalWithFreight(purchaseQuotation.totalFreight)" ng-pattern-restrict="{{numExp}}"/>
									</div>
									<label class="col-md-1 control-label"> Total </label>
				       				<div class="col-md-2">
										<input type="text" class="form-control input-sm"  data-ng-model="purchaseQuotation.grandTotal" readonly />
									</div>
								</div>
				       		</div>
								
					      			</fieldset>
				      			</div>
				     		</div>
        				</tab>
        				<tab heading="Upload3" id="purchaseTab">
        					<div class="row">
        				     <div class="form-group">
						             		<div class="form-group">
					       				<label class="col-md-2 control-label"> Vendor <spring:message code="label.asterisk.symbol"></spring:message></label>
					       				<div class="col-md-2">
											<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId3" ng-if="!edit"
			        							property="purchaseQuotation.vendorId3" id="vendor3"  object="vendor3"  name="vendor3"
			        					friendly-name="vendor3" form-name = "PurchaseQuotationForm"></selectivity>
			        							
			        							<selectivity list="vendorList" ng-model="purchaseQuotation.vendorId"  ng-if="edit==true" 
			        							property="purchaseQuotation.vendorId" id="vendor"  object="vendor"  name="vendor"
			        					 friendly-name="vendor" form-name = "PurchaseQuotationForm" disabled="true"></selectivity>
			        							
			        						<!-- <select class="form-control input-sm" id="vendor" name="vendor" data-ng-model="purchaseQuotation.vendorId"
										        	data-ng-options="ac.id as ac.text for ac in vendorList" disabled ng-if="edit==true" 
										        	friendly-name="vendor" form-name = "PurchaseQuotationForm" validation="required" >
										          	<option value="" selected="selected">Select</option>
									     	</select>	 -->
										</div>
										       	 <button class="btn btn-primary"  type="button"
								ng-click="fileUpload2()">
								<i class="fa fa-upload"></i> Upload
							</button>	
									</div>
								       </div>
								           	<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10 b-a" id="totalValues">
				        		<div role="content">
							      <div class="widget-body no-padding">
							       <div style="min-width:70%; overflow-x:scroll" 
							       	class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
							        data-st-table="displayedCollection3" data-st-safe-src="rowCollection3">
									
								       	<table id="dt_basic"  class="table table-striped table-bordered table-hover dataTable no-footer"
							         role="grid" aria-describedby="dt_basic_info">
							         <thead class="dataTables-Main-Head">
							          <tr>
						          	  <th class="width_1 table-heading text-center">
							             <label class="i-checks m-b-none">
							             <input type="checkbox"  ng-model="selectedAll3" ng-change="checkAllQuotation(selectedAll3)">
							             <i></i>
							            </label>
							           </th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Dtl Id</th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Id</th>
							           <th class="sorting width_7" data-st-sort="" >Req. No4</th>
									   <!-- <th class="sorting width_10" data-st-sort="">Req. Location</th> -->
							           <th class="sorting width_15" data-st-sort="">Item Code - Item Name</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Item Name</th> -->
							           <th class="sorting width_5" data-st-sort="">EDD</th>
							           <th class="sorting width_8" data-st-sort="">Vendor UOM</th>
							           <th class="sorting width_12" data-st-sort="" data-ng-if="consignmentQtyLabel">Consignment Qty</th>
							           <th class="sorting width_5" data-st-sort="" data-ng-if="!consignmentQtyLabel">Vendor Qty</th>
							           <!-- <th class="sorting width_7" data-st-sort="">Lead Time</th> -->
							           <th class="sorting width_7" data-st-sort="">Unit Price</th>
							           <th class="sorting width_7" data-st-sort="">Price</th>
							           <th class="sorting width_12" data-st-sort="">Discount Type</th>
							           <th class="sorting width_7" data-st-sort="">Discount</th>
							           <th class="sorting width_7" data-st-sort="">Tax Type</th>
							           <th class="sorting width_7" data-st-sort="">Tax</th>
							           <th class="sorting width_7" data-st-sort="">Sub Total</th>
							           <!-- <th class="sorting width_8" data-st-sort="">Discount</th> -->
							           <!-- <th class="sorting width_6" data-st-sort="">Tax</th> -->
							           <th class="sorting width_7" data-st-sort="">Status</th>
<%-- 							           <th class="width_6 table-heading text-center"><spring:message code="label.action"></spring:message></th>
 --%>							          </tr>
							         </thead>
					      <tbody class="dataTables-Main-Body">
							         <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  ng-repeat="quotationDtl in displayedCollection3">
							         	<td>
							         		<label class="i-checks m-b-none"> 
							         		<input type="checkbox" ng-model="quotationDtl.select" id="quotationDtl.select"><i></i>
							         		</label>
							         	</td>
							         	<td class="visible-left">s</td>
							         	<td class="visible-left">{{quotationDtl.quotationId}}</td>
							         	
							  <!--        <td class="text-aling-left">	<selectivity list="requisitionList"
															ng-model="quotationDtl.requisitionNo"
															property="quotationDtl.requisitionNo"
															id="requisitionNo" object="requisitionObj"
															name="requisitionNo" validation="required"
															friendly-name="Requisition No"
															form-name="purchaseQuoteRequestForm"></selectivity></td> -->
							       	<td class="text-aling-left">{{quotationDtl.requisitionNo}}</td>
							         	<!-- <td>{{quotationDtl.requisitionNo}}</td> -->
							         	<td class="text-aling-left">{{quotationDtl.itemCode}} - {{quotationDtl.itemName}}</td>
							         	<!-- <td class="text-aling-left">{{quotationDtl.itemName}}</td> -->
							         	<td class="text-aling-left">{{quotationDtl.eddDate}}</td>	
							         	<td class="text-aling-left">{{quotationDtl.vendorUomName}}</td>
							         	<td class="text-aling-right">{{quotationDtl.vendorQuantity}}</td>
							         	<!-- <td>{{quotationDtl.deliveryLeadTime}}</td> -->
							         	<td class="text-aling-right">{{quotationDtl.unitPrice}}</td>
							         	<td class="text-aling-right">{{quotationDtl.amount}}</td>
										<td class="text-aling-left">{{quotationDtl.discountType}}</td>
										<td class="text-aling-right">{{quotationDtl.disAmt}}</td>
										<td class="text-aling-left">{{quotationDtl.taxCode}}</td>
										<td class="text-aling-right">{{quotationDtl.taxAmt}}</td>
										<td class="text-aling-right">{{quotationDtl.rowSubTotal}}</td>
								<td>
     										<select class="form-control input-sm" ng-if="quotationDtl.statuschange==true" disabled ="true" ng-model="quotationDtl.queryStatus" ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
											<select class="form-control input-sm" ng-if="quotationDtl.statuschange==false" ng-model="quotationDtl.queryStatus"  ng-options="status.defTableId as status.value for status in statusList"> 
												<option value="">Select</option>
											</select>
   										</td>
				<!-- 			         	<td>{{quotationDtl.status}}</td> -->
							         </tr>
							         </tbody> 
							        </table>
							            </div>
							                </div>
							                    </div>
							                        </div>
									
								     	<div class="col-md-12 padding-top-20" id="totalValues">
				       			<div class="form-group">
				       				<label class="col-md-1 control-label"> SubTotal </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.subTotal" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Discount </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalDiscount" readonly />
									</div>
				       				<label class="col-md-1 control-label"> Tax </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalTax" readonly />
									</div>
									<label class="col-md-1 control-label"> Freight </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm text-right" data-ng-model="purchaseQuotation.totalFreight" ng-keyup="calGrandTotalWithFreight(purchaseQuotation.totalFreight)" ng-pattern-restrict="{{numExp}}"/>
									</div>
									<label class="col-md-1 control-label"> Total </label>
				       				<div class="col-md-2">
										<input type="text" class="form-control input-sm"  data-ng-model="purchaseQuotation.grandTotal" readonly />
									</div>
								</div>
				       		</div>
								         				
        					</div>
        				</tab>
        				
					</tabset> 
							 <!-- /col-md-12 -->
						</div> <!-- /row -->
				        <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">
				           <button class="btn btn-success" type="button" class="btn btn-success"
				           data-ng-click="validate(PurchaseQuotationForm,purchaseQuotation)" data-ng-if="!edit">
				            <i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
				           </button>
				           <button class="btn btn-success" type="button"
				            class="btn btn-success" id="update" data-ng-click="validate(PurchaseQuotationForm,purchaseQuotation)" data-ng-if="edit">
				            <i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
				           </button>
				           <button class="btn btn-info" type="button"
				            class="btn btn-success"
				            data-ng-click="reset(PurchaseQuotationForm);">
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
				        </div> <!-- /form-actions -->
				       </form> <!-- /form-horizontal -->
				      </div> <!-- /widget-body -->
				     </div><!-- /role="content" - end widget content -->
    			</div><!-- /standard-datatable-widget - end widget div -->
   			</article><!-- end widget -->
  		</div><!-- WIDGET END -->
 	</section>
</div>
<a id="sampleDownload" style="display: none"
										href="/tempdoc/SamplePurchaseQuotation1.xlsx" download="SamplePurchaseQuotation.xlsx"></a>

<script type="text/ng-template" id="fileGenModal">
<div class="model-header">File Upload </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile"
            		onchange="angular.element(this).scope().uploadContainerExcel(this)" accept=".xls,.xlsx" />
            		
				</div>
			</div> 
		</div>
		<div class="model-footer" style="padding-left:9%;padding-top:8%">
			<button class="btn btn-success" type="button" ng-click="uploadContainer()">OK</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
			<button class="btn btn-info" type="button"  ng-click="downloadFile()">Download Sample</button>
		</div>
</script>
<a id="sampleDownload1" style="display: none"
										href="/tempdoc/SamplePurchaseQuotation2.xlsx" download="SamplePurchaseQuotation.xlsx"></a>

<script type="text/ng-template" id="fileGenModal1">
<div class="model-header">File Upload </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile"
            		onchange="angular.element(this).scope().uploadContainerExcel(this)" accept=".xls,.xlsx" />
            		
				</div>
			</div> 
		</div>
		<div class="model-footer" style="padding-left:9%;padding-top:8%">
			<button class="btn btn-success" type="button" ng-click="uploadContainer1()">OK</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
			<button class="btn btn-info" type="button"  ng-click="downloadFile1()">Download </button>
		</div>
</script>

<a id="sampleDownload2" style="display: none"
										href="/tempdoc/SamplePurchaseQuotation3.xlsx" download="SamplePurchaseQuotation.xlsx"></a>

<script type="text/ng-template" id="fileGenModal2">
<div class="model-header">File Upload </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile"
            		onchange="angular.element(this).scope().uploadContainerExcel(this)" accept=".xls,.xlsx" />
            		
				</div>
			</div> 
		</div>
		<div class="model-footer" style="padding-left:9%;padding-top:8%">
			<button class="btn btn-success" type="button" ng-click="uploadContainer2()">OK</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
			<button class="btn btn-info" type="button"  ng-click="downloadFile1()">Download </button>
		</div>
</script>
