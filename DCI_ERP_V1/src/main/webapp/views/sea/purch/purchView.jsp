<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
table.dataTable thead .sorting:after {
  content: "";
}
select{
-webkit-appearance: none;
  padding: 0;
  text-indent: 8px;
  padding : 0 !important;
}
.input-group-addon{
display:none !important;
}
.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
{
 background-color:white !important;
 border:0px !important;
}
.b-grey{
border:0px !important;
}
</style>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
				      <div class="widget-body">
				       <form class="form-horizontal" name="PurchaseQuotationForm" novalidate method="post">
				        <div class="row">
				        	<div class="col-sm-12 col-md-12 col-lg-12">
					         	<div class="col-md-6">
						         		<div class="form-group" ng-if="!isEdit">
							     			<label class="col-md-3 control-label bold"> Purchase Quote No
							     				</label>
							     				<div class="col-md-7">
												<input type="text" class="form-control input-sm" readonly 
												ng-model="purchaseQuotation.quotationNo">
											</div>
										</div>
												
										<div class="form-group">
								            <label class="col-md-3 control-label bold"> Purchase For </label>
								            <div class="col-md-7">
								              <select class="form-control"  ng-model="purchaseQuotation.purchaseFor" ng-options="purchaseFor.defTableId as purchaseFor.value for purchaseFor in purchaseForList" data-ng-disabled="true">
									               <option value="">select</option>
									          </select>
									          <!-- <selectivity list="purchaseForList" property="purchaseQuotation.purchaseFor" id="cmbPurchaseFor"></selectivity> -->
								            </div>
							            </div>
												
										<div class="form-group">
						       				<label class="col-md-3 control-label bold"> Vendor </label>
						       				<div class="col-md-7">
						       				<select class="form-control input-sm"
												ng-model="purchaseQuotation.vendorId" name="vendor" id="txtSourceLocn"
												ng-options="c.id as c.text for c in vendorList" ng-disabled="true" >
											</select>
											</div>
										</div>
										<div class="form-group">
						       				<label class="col-md-3 control-label bold"> Vendor Location</label>
						       				<div class="col-md-7">
						       					<input type="hidden" class="form-control input-sm" ng-model="purchaseQuotation.vendorLocId" id="txtVenLocId" ng-disabled="true" />
											 	<input type="text" class="form-control input-sm" ng-model="purchaseQuotation.vendorLocName" id="txtVenLocName" ng-disabled="true" />
											</div>
										</div>
										<div class="form-group">
							            	<label class="col-md-3 control-label bold"> Vendor Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" rows="1" cols="15" style="resize: none" readonly ng-model="purchaseQuotation.vendorAddress"> </textarea>
									             	<span class="form-control" ng-disabled="true">{{purchaseQuotation.cityName}}, {{purchaseQuotation.state}}, {{purchaseQuotation.zipcode}}, {{purchaseQuotation.country}}</span>
									             	<!-- <input type="text" class="form-control input-sm" placeholder="city" ng-model="purchaseQuotation.cityName" readonly />
									             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseQuotation.state" readonly />
									             	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="purchaseQuotation.zipcode" readonly /> 
									             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseQuotation.country" readonly />-->
									            </div>										       
								            </div>
							            </div>											
					        	</div>        	
					        	<div class="col-md-6">
					        		<div class="form-group">
					       				<label class="col-md-4 control-label bold"> PQ Date </label>
					       				<div class="col-md-7">
											<input type="text" class="form-control"
									                placeholder="dd/mm/yyyy" name="currentDate"
									                validation="date_euro_long|required" readonly
									                friendly-name="Purchase Quotation Date"
									                data-ng-model="purchaseQuotation.quoteDate">
										</div>
									</div>
									<div class="form-group">
							            <label class="col-md-4 control-label bold"> Purchase Type </label>
							            <div class="col-md-7">
							            	<!-- <selectivity list="purchaseTypeList" property="purchaseQuotation.purchaseType" id="cmbPurchaseType"></selectivity> -->
							             	 <select class="form-control" ng-model="purchaseQuotation.purchaseType" 
							             	 ng-options="purchaseType.defTableId as purchaseType.value for purchaseType in purchaseTypeList"
							             	 ng-change="getPurchaseTypeDetails(purchaseQuotation.purchaseType,purchaseTypeList)" data-ng-disabled="true">
								               <option value="">Select</option>
								          	</select>
							            </div>
						            </div>
					            	<div class="form-group width_100 padding-left-177" ng-if="fixedPriceAndQuantity">
						             		<div class="col-md-1">
								              		<div class="checkbox">
								               			<label> 
								               				<input type="checkbox" class="checkbox style-0" data-ng-model="purchaseQuotation.fixedPrice" data-ng-true-value="'Y'" data-ng-false-value="'N'" ng-disabled="true" />
								                			<span></span>
								               			</label>
								              		</div>
								              		
								             </div>
					            			<label class="col-md-4 text-aling-left control-label bold padding-top-10">Fixed Price</label>
						             		<div class="col-md-1">
								              		<div class="checkbox">
								               			<label> 
								               				<input type="checkbox" class="checkbox style-0" data-ng-model="purchaseQuotation.fixedQty" data-ng-true-value="'Y'" data-ng-false-value="'N'" ng-disabled="true" />
								                			<span></span>
								               			</label>
								              		</div>
								              		
								             </div>
								             <label class="col-md-4 text-aling-left control-label bold padding-top-10">Fixed Qty</label>
					            	</div>
					            	
					            		<fieldset class="b-a width_75 margin-bottom-10 margin-left-16">
					            		<legend class="width_25 b-a margin-bottom-10 padding-left-10 margin-left-5">Validity</legend>
						            	<div class="form-group">
						       				<label class="col-md-4 control-label bold"> From Date </label>
						       				 <div class="col-md-5">
								             <input type="text" class="form-control input-sm" readonly 
												ng-model="purchaseQuotation.validFromDate">
								              </div>
						       				<!-- <div class="col-md-8">
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
										            </div>
										        </div>
											</div> -->
										</div>
										<div class="form-group">
						       			<label class="col-md-4 control-label bold"> To Date </label>
						       			 <div class="col-md-5">
								             <input type="text" class="form-control input-sm" readonly 
												ng-model="purchaseQuotation.validToDate">
								              </div>
						       			</div>
					            	</fieldset>
					            	
					            	
									<div class="form-group">
							            <label class="col-md-4 control-label bold"> Remarks
							            </label>
							            <div class="col-md-7">
							             <textarea class="text-left form-control input-sm" rows="4" cols="20" style="resize: none" ng-model="purchaseQuotation.remarks"  ng-disabled="true"> </textarea>
							            </div>
						            </div>
							            <div class="form-group">
								            <label class="col-md-4 control-label bold"> Payment Terms (Days)
								            </label>
								             <div class="col-md-5">
								             
								             <input type="text" class="form-control input-sm" readonly 
												ng-model="purchaseQuotation.paymentTerms">
								            	
								             </div>
							            </div>		
					        	</div>
				        	</div> <!-- /col-sm-12 col-md-12 col-lg-12 -->
				        	
				        	<div class="col-md-12 padding-top-10 b-a" id="totalValues">
				        		<div role="content">
							      <div class="widget-body no-padding">
							       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
							        data-st-table="displayedCollection" data-st-safe-src="rowCollection">
									<!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
									
							        <table id="dt_basic"  class="table table-striped table-bordered table-hover dataTable no-footer"
							         role="grid" aria-describedby="dt_basic_info">
							         <thead class="dataTables-Main-Head">
							          <tr>
							          	 <th class="sorting width_1" data-st-sort=""></th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Dtl Id</th>
							           <th class="sorting width_1 visible-left" data-st-sort="">Quot Id</th>
							           <th class="sorting width_7" data-st-sort="">Req. No</th>
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
							          <!--  <th class="sorting width_7" data-st-sort="">Status</th> -->
							           <%-- <th class="width_6 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
							          </tr>
							         </thead>
							         <tbody>
							         <tr ng-repeat="quotationDtl in purchaseQuotation.quotationDetailList">
							         	<td>
							         		<label class="i-checks m-b-none"> <input type="checkbox" ng-model="tableSelection[$index]" id="section$index"><i></i></label></td>
							         	<td class="visible-left">{{quotationDtl.quotationDetailId}}</td>
							         	<td class="visible-left">{{quotationDtl.quotationId}}</td>
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
							         	<!-- <td>{{quotationDtl.status}}</td> -->
							         </tr>
							         </tbody>
							        </table>
							       </div>
							      </div>
							      <!-- end widget content -->
							    </div> <!-- /role[content] -->
							</div> <!-- /col-md-12 -->
							<!-- -->
							<div class="col-md-12 padding-top-20" id="totalValues">
				       			<div class="form-group">
				       				<label class="col-md-1 control-label bold"> SubTotal </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.subTotal" readonly />
									</div>
				       				<label class="col-md-1 control-label bold"> Discount </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalDiscount" readonly />
									</div>
				       				<label class="col-md-1 control-label bold"> Tax </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalTax" readonly />
									</div>
									<label class="col-md-1 control-label bold"> Freight </label>
				       				<div class="col-md-1">
										<input type="text" class="form-control input-sm" data-ng-model="purchaseQuotation.totalFreight" ng-keyup="calGrandTotalWithFreight(purchaseQuotation.totalFreight,purchaseQuotation)" data-ng-disabled="true" />
									</div>
									<label class="col-md-1 control-label bold"> Total </label>
				       				<div class="col-md-2">
										<input type="text" class="form-control input-sm"  data-ng-model="purchaseQuotation.grandTotal" readonly />
									</div>
								</div>
				       		</div> <!-- /col-md-12 -->       			
							
				        </div> <!-- /row -->
				        <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">				           
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