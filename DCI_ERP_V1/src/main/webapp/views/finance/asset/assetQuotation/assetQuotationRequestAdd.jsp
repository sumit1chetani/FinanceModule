 <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       Add Quotation List
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="assetQuoteForm">
        <div class="row">
         <div class="col-sm-10 col-md-6">
          <fieldset>
           	<div class="form-group">
	            <label class="col-md-4 control-label"> Requisition No
	            <spring:message
	            code="label.asterisk.symbol"></spring:message>
	            </label>
	            <div class="col-md-7">
		              <selectivity list="requisitionList" ng-model="quotationDetail.requisitionId"
        				property="quotationDetail.requisitionId" id="txtRequisitionId"  object="requisitionObj"  name="Requisition"
        				validation="required" friendly-name="Requisition No" form-name = "assetQuoteForm"></selectivity>
	            </div>
            </div>
			
			<div class="form-group">
	             <label class="col-md-4 control-label"> Item Code
	             <spring:message
	             code="label.asterisk.symbol"></spring:message>
	             </label>
	             <div class="col-lg-7">
		              	<selectivity list="itemList" ng-model="quotationDetail.itemId"
        				property="quotationDetail.itemId" id="txtItem"  object="itemObj"  name="Item"
        				validation="required" friendly-name="Item Code" form-name = "assetQuoteForm"></selectivity>
	             </div>
             </div>
             
            <div class="form-group">
             <label class="col-md-4 control-label"> Item Description
             </label>
             <div class="col-lg-7">
	              <textarea class="text-left form-control input-sm" rows="4" cols="25" ng-model="quotationDetail.itemDescription"
		              style="resize: none"> </textarea>
              </div>
            </div>
            
            <div class="form-group">
	             <label class="col-md-4 control-label"> EDD
	             </label>
	              <div class="col-md-7">
    					<div class='input-group date width_100 datetimepick'>
				            <div class="dropdown">
				             <a class="dropdown-toggle" id="eddDate" role="button"
				              data-toggle="dropdown" data-target="#" href="#">
				              <div class="input-group">
				               <input type="text" class="form-control"
				                placeholder="dd/mm/yyyy" name="currentDate"
				                data-validator="required" data-valid-method="submit"
				                data-message-id="currentDate"
				                data-ng-model="quotationDetail.eddDate"><span
				                class="input-group-addon"><i
				                class="glyphicon glyphicon-calendar"></i></span>
				              </div>
				             </a>
				             <ul class="dropdown-menu" role="menu"
				              aria-labelledby="dLabel">
				              <datetimepicker data-ng-model="quotationDetail.eddDate"
				               data-on-set-time="quotationDetail.eddDate = onDateSet(newDate)"
				               data-datetimepicker-config="{ dropdownSelector: '#eddDate',startView:'day', minView:'day'}" />
				             </ul>
				            </div>
				        </div> 	    					
	             	</div>
            </div>
            
            <div class="form-group">
		             <label class="col-md-4 control-label"> Tax
		             <spring:message
		             code="label.asterisk.symbol"></spring:message>
		             </label>
		             <div class="col-md-7">
		              	<selectivity list="taxList" ng-model="quotationDetail.taxId"
        				property="quotationDetail.taxId" id="txtTaxId"  object="taxObj"  name="tax"
        				validation="required" friendly-name="Tax" form-name = "assetQuoteForm"></selectivity>
		              	
		              	<input type="hidden" data-ng-model="assetQuotationDetail.taxPercentage" />
		              	<input type="hidden" data-ng-model="assetQuotationDetail.taxAmount" />
		              	<input type="hidden" data-ng-model="assetQuotationDetail.subTaxPercentage" />
		              	<input type="hidden" data-ng-model="assetQuotationDetail.subTaxAmount" />
		              	
		             </div>		             
	            </div>
            
            
             <div class="form-group">
		             <label class="col-md-4 control-label"> Discount <spring:message code="label.asterisk.symbol"></spring:message>
		             </label>
		             <div class="col-md-5">
		              	<select class="form-control input-sm" ng-model="quotationDetail.discountTypeId" 
		             	ng-options="discount.defTableId as discount.value for discount in discountTypeList" 
		             	ng-change="getDiscountDetails(quotationDetail.discountTypeId,discountTypeList)"
		             	validation="required" friendly-name="Discount" name="discount">
		              		<option value="">Select</option>
		              	</select>
		             </div>
		             <div class="col-md-2" ng-show="discountPercent">
			             	<input class="form-control input-sm pull-left" ng-model="quotationDetail.discountPercent" /> <span class="pos-abs-top-4"> %</span>
			         </div>
		             <div class="col-md-2" ng-show="discountAmt">
		             	<input class="form-control input-sm" ng-model="quotationDetail.discountAmount" />
		             </div>
	            </div>   
            
            
            
            
            
            <div class="form-group">
             <label class="col-md-4 control-label"> Delivery Lead Time
             </label>
             <div class="col-lg-5">
				<input type="text" class="form-control input-sm" ng-model="quotationDetail.deliveryLeadTime"/>
             </div>
             <div class="col-lg-3">
             <label class="control-label">Days</label>
             </div>
            </div>
            
           <div class="form-group">
      				<label class="col-md-4 control-label"> Status
      				</label>
	      			<div class="col-md-7">
						<select class="form-control input-sm" ng-model="quotationDetail.queryStatus" ng-options="status.defTableId as status.value for status in statusList"> 
							<option value="">Select</option>
						</select>
					</div>
				</div>
                
		   </fieldset>
        </div>
	         
    	<div class="col-sm-10 col-md-6">
          <fieldset>
           	<div class="form-group">
        		<label class="col-md-4 control-label"> Requisition Date
         		</label>
        		     <div class="col-md-7">
						 <div class='input-group date width_100 datetimepick'>
				            <div class="dropdown">
				             <a class="dropdown-toggle" id="reqDate" role="button"
				              data-toggle="dropdown" data-target="#" href="#">
				              <div class="input-group">
				               <input type="text" class="form-control"
				                placeholder="dd/mm/yyyy" name="currentDate"
				                data-validator="required" data-valid-method="submit"
				                data-message-id="currentDate"
				                data-ng-model="quotationDetail.reqDate"><span
				                class="input-group-addon"><i
				                class="glyphicon glyphicon-calendar"></i></span>
				              </div>
				             </a>
				             <ul class="dropdown-menu" role="menu"
				              aria-labelledby="dLabel">
				              <datetimepicker data-ng-model="quotationDetail.reqDate"
				               data-on-set-time="quotationDetail.reqDate = onDateSet(newDate)"
				               data-datetimepicker-config="{ dropdownSelector: '#reqDate',startView:'day', minView:'day'}" />
				             </ul>
				            </div>
				        </div> 
					</div>
			</div>
			
			
			  <div class="form-group">
	             <label class="col-md-4 control-label"> Item Name
	             </label>
	             <div class="col-lg-7">
	             		<input type="text" class="form-control input-sm" ng-model="quotationDetail.itemName" />
	             </div>
             </div>

			<div class="form-group">
					<label class="col-md-4 control-label"> Location Address</label>
						<div class="col-md-7">
         				<div class="col-md-12 no-padding">
							<textarea class="text-left form-control input-sm" rows="2" cols="15" readonly ng-model="quotationDetail.locationName" style="resize: none"> 
		                </textarea>
						</div>
						<div class="col-md-12 no-padding">
						    <div class="col-md-5 no-padding padding-top-5">
						<input type="text" class="form-control input-sm" placeholder="city" ng-model="quotationDetail.cityName" readonly>
						    </div>
						<div class="col-md-4 no-padding padding-left-5 padding-top-5">
						   	<input type="text" class="form-control input-sm" placeholder="state" ng-model="quotationDetail.stateName" readonly>
						</div>
						<div class="col-md-3 no-padding padding-left-5 padding-top-5">
						   	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="quotationDetail.pincode" readonly>
						</div>
						</div>
						<div class="col-md-12 no-padding padding-top-5">
							<input type="text" class="form-control input-sm" placeholder="country" ng-model="quotationDetail.country" readonly>
						</div>
					 </div>
         		</div>
			       
            <div class="form-group">
	             <label class="col-md-4 control-label"> Unit of Measure
	             </label>
	             <div class="col-lg-7">
	             		<input type="hidden" class="form-control input-sm text-aling-right" ng-model="quotationDetail.uom" />
		             	<input type="text" class="form-control input-sm text-aling-right" ng-model="quotationDetail.uomName" />
	             </div>
            </div>
            
            
            <div class="form-group">
             <label class="col-md-4 control-label"> Quantity
             </label>
             <div class="col-lg-7">
             	<input type="text" class="form-control input-sm text-aling-right" ng-model="quotationDetail.quantity" />
             </div>
            </div>
            
            <div class="form-group">
             <label class="col-md-4 control-label"> Unit Price
             </label>
             <div class="col-lg-7">
             <!-- <input type="text" class="form-control input-sm" ng-model="quotationDetail.unitPrice"/> -->
             <input type="text" class="form-control input-sm text-aling-right" id="txtunitPrice"
	             	validation="required" friendly-name="Unit Price" name="unit Price" 
	             	ng-model="quotationDetail.unitPrice" 
	             	ng-blur="onChangeDecimal('unitPrice',quotationDetail.unitPrice)" />
             </div>
            </div>
           
          </fieldset>
         </div>
         
        </div>
          <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
            <button class="btn btn-success" type="button"
            data-ng-if="!isEdit"
            data-ng-click="validateAQDetail(assetQuoteForm,quotationDetail)" class="btn btn-success">
            <i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
           </button>
           <!-- -->
           <button class="btn btn-success" type="button"
            data-ng-if="isEdit == true" class="btn btn-success"
            ng-click="updateDetail()">
            <i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
           </button>
           
           <button type="reset" class="btn btn-info"
            ng-click="reset(assetQuoteForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="reset"
            class="btn btn-success" ng-click="cancelReq()">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
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