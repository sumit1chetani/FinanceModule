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
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
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
       <form class="form-horizontal" name="VendingRatingsForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         <fieldset>
         <div class="col-md-6">
         
         		<div class="form-group">
        				<label class="col-md-3 control-label"> GRN No
        				<spring:message
              			code="label.asterisk.symbol"></spring:message></label>
        				<div class="col-md-7">
							<select class="form-control input-sm" ng-model="vendorRatings.grnNo" ng-change="getVenRatings(vendorRatings.grnNo)">
								  <option value="">select</option>
								  <option value="1">1144</option>
								  <option value="2">5064</option>
							</select>
						</div>
					</div>
         		
         		<div class="form-group">
        				<label class="col-md-3 control-label"> Purchase Order No
        				</label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" ng-model="vendorRatings.poNo" readonly>
						</div>
				</div>
				
				<div class="form-group">
        				<label class="col-md-3 control-label"> PO Date </label>
        				<div class="col-md-7">
							<div class='input-group date width_100 datetimepick'>
					            <div class="dropdown">
					             <a class="dropdown-toggle" id="curDate" role="button"
					              data-toggle="dropdown" data-target="#" href="#">
					              <div class="input-group">
					               <input type="text" class="form-control"
					                placeholder="dd/mm/yyyy" name="Date"
					                data-validator="required" data-valid-method="submit"
					                data-message-id="date"
					                data-ng-model="vendorRatings.date" readonly><span
					                class="input-group-addon"><i
					                class="glyphicon glyphicon-calendar"></i></span>
					              </div>
					             </a>
					             <ul class="dropdown-menu" role="menu"
					              aria-labelledby="dLabel">
					              <datetimepicker data-ng-model="vendorRatings.date"
					               data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
					             </ul>
					            </div>
					           </div> 
						</div>
					</div>
					
					<div class="form-group">
        				<label class="col-md-3 control-label"> Status
        				</label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" ng-model="vendorRatings.status" readonly>
						</div>
					</div>
	   	</div>
        	
        	<div class="col-md-6">
        		<div class="form-group">
        				<label class="col-md-4 control-label"> Vendor
        				</label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" ng-model="vendorRatings.vendor" readonly>
						</div>
				</div>
				<div class="form-group">
        				<label class="col-md-4 control-label"> Price
        				</label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" ng-model="vendorRatings.price" readonly>
						</div>
				</div>
				<div class="form-group">
        				<label class="col-md-4 control-label"> Quantity
        				</label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" ng-model="vendorRatings.quantity" readonly>
						</div>
				</div>
        	</div>
        		
        		</fieldset>
        		
        		<div class="table-responsive col-sm-12" ng-repeat="(tIndex, purchaseTable) in vendorRatings.purchaseTables">
			      <table class="table table-striped b-t b-light">
			        <thead>
			          <tr>
			            <th colspan=1 class="width_1"></th>
			            <th colspan=1 class="width_8 text-center">Rating</th>
			            <th colspan=1 class="width_10 text-center">Quality</th>
			            <th colspan=1 class="width_10 text-center">Package</th>
			            <th colspan=1 class="width_10 text-center">Delivery</th>
			            <th colspan=1 class="width_8 text-center">Pricing</th>   
			            <th colspan=1 class="width_10 text-center">Payment Terms</th> 
			            <th colspan=1 class="width_10 text-center">Availability</th> 
			            <th colspan=1 class="width_8 text-center">Support & Services</th> 
			          </tr>
			        </thead>
			        <tbody ng-repeat="(trIndex, row) in purchaseTable.purchaseTableRow">
			        	<tr>
				            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="purchaseTableRow.select" id="section{{trIndex}}"><i></i></label></td>
				            <td class="width_8"> 
					        	<div class="row">
				            		<div class="col-xs-12">
							       	    <select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				        			</div>
				        		</div>
				        	</td>
				          	<td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>	
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>	
				            
				            <td class="width_8">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>	
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_8">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<select class="form-control input-sm">
										  <option value="">select</option>
										  <option value="5">5</option>
										  <option value="4">4</option>
										  <option value="3">3</option>
										  <option value="2">2</option>
										  <option value="1">1</option>
										</select>
				         	  		</div>
				              	</div>
				            </td>
			     		</tr>
			      	</tbody>
			      </table>      
<!-- 			      <div class="padding-right-5" id="AddOrRmveMeritbtn"> -->
<!-- 			           <button ng-click="addPurchaseRow(purchaseTable)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button"> -->
<!-- 			            <i class="fa fa-plus"></i> -->
<!-- 			           </button> -->
<!-- 			           <button ng-click="removePurchaseRow(purchaseTable)" class="btn btn-sm btn-danger" type="button" tooltip="Delete"> -->
<!-- 			            <i class="fa  fa-trash-o"></i> -->
<!-- 			           </button> -->
<!-- 			      </div> -->
				</div>
				
        	 </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="save(VendingRatingsForm)"
            data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            class="btn btn-success" id="update"
            data-ng-click="update(VendingRatingsForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            class="btn btn-success"
            data-ng-click="reset(VendingRatingsForm);">
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