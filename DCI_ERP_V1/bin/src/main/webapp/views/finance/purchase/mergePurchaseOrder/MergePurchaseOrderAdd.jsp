<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
       <form class="form-horizontal" name="mergePurchaseOrderForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <fieldset>
         <div class="col-md-6">
        
         		<div class="form-group">
        				<label class="col-md-3 control-label"> Purchase Order No
        				<spring:message
              			code="label.asterisk.symbol"></spring:message></label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" readonly>
						</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Vendor <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
								<input type="text" class="form-control input-sm" readonly>
							</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Destination Location </label>
	        				<div class="col-md-7">
								<input type="text" class="form-control input-sm" readonly>
							</div>
						</div>
						
						<div class="form-group">
				            <label class="col-md-3 control-label"> Destination Address
				            </label>
				            <div class="col-md-7">
				             <div class="col-md-12 b b-grey no-padding">
				             <div class="col-md-12 no-padding padding-top-5 padding-left-5 padding-right-5">
				             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" readonly> </textarea>
				             </div>
				             <div class="col-md-5 no-padding padding-top-5 padding-left-5">
				             	<input type="text" class="form-control input-sm" placeholder="city" readonly>
				             </div>
				             <div class="col-md-4 no-padding padding-top-5 padding-left-5">
				             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseData.desState" readonly>
				             </div>
				             <div class="col-md-3 no-padding padding-top-5 padding-left-5 padding-right-5">
				             	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="purchaseData.desZipcode" readonly>
				             </div>
				             <div class="col-md-12 no-padding padding-top-5 padding-bottom-5 padding-left-5 padding-right-5">
				             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseData.desCountry" readonly>
				             </div>
				            </div>
				            </div>
			            </div>
						<div class="form-group">
				            <label class="col-md-3 control-label "> Terms & Conditions
				            </label>
				            <div class="col-md-7">
				             <textarea class="text-left form-control input-sm " rows="4" cols="20" style="resize: none" readonly> </textarea>
				            </div>
			            </div>
        			
        	</div>
        	
        	<div class="col-md-6">
        		<div class="form-group">
        				<label class="col-md-4 control-label"> Purchase Order Date </label>
        				<div class="col-md-7">
					            <input type="text" class="form-control input-sm" readonly> 
						</div>
					</div>
						
						
						<div class="form-group">
			      				<label class="col-md-4 control-label"> Status
			      				</label>
			      				<div class="col-md-7">
								<input type="text" class="form-control input-sm" readonly>
							</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-4 control-label"> Hospital </label>
	        				<div class="col-md-7">
								<input type="text" class="form-control input-sm" readonly>
							</div>
						</div>
						
<!-- 					<div class="form-group" ng-show="venAddress == true"> -->
						<div class="form-group">
				            <label class="col-md-4 control-label"> Vendor Address
				            </label>
				            <div class="col-md-7">
				             <div class="col-md-12 b b-grey no-padding">
				             <div class="col-md-12 no-padding padding-top-5 padding-left-5 padding-right-5">
				             	<textarea class="text-left form-control input-sm" rows="2" cols="15" style="resize: none" readonly> </textarea>
				             </div>
				             <div class="col-md-5 no-padding padding-top-5 padding-left-5">
				             	<input type="text" class="form-control input-sm" placeholder="city" readonly>
				             </div>
				             <div class="col-md-4 no-padding padding-top-5 padding-left-5">
				             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseData.desState" readonly>
				             </div>
				             <div class="col-md-3 no-padding padding-top-5 padding-left-5 padding-right-5">
				             	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="purchaseData.desZipcode" readonly>
				             </div>
				             <div class="col-md-12 no-padding padding-top-5 padding-bottom-5 padding-left-5 padding-right-5">
				             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseData.desCountry" readonly>
				             </div>
				            </div>
				            </div>
			            </div>
			  <div class="form-group">
				       <label class="col-md-4 control-label "> Remarks
				        </label>
				            <div class="col-md-7">
				             <textarea class="text-left form-control input-sm " rows="4" cols="20" style="resize: none" readonly> </textarea>
				            </div>
			            </div>
			         </div>
			         </fieldset>
			         
        			<div class="table-responsive col-sm-12" ng-repeat="(tIndex, purchaseTable) in purchaseData.purchaseTables">
			      <table class="table table-striped b-t b-light">
			        <thead>
			          <tr>
			            <th colspan=1 class="width_1"></th>
			            <th colspan=1 class="width_8 text-center">Item Code</th>
			            <th colspan=1 class="width_10 text-center">Vendor Item Name</th>
			            <th colspan=1 class="width_10 text-center">Item Description</th>
			            <th colspan=1 class="width_10 text-center">EDD</th>
			            <th colspan=1 class="width_8 text-center">UOM</th>   
			            <th colspan=1 class="width_10 text-center">Qty</th> 
			            <th colspan=1 class="width_10 text-center">Delivery Lead Time</th> 
			            <th colspan=1 class="width_8 text-center">Unit Price</th> 
			            <th colspan=1 class="width_5 text-center">Discount</th> 
			            <th colspan=1 class="width_10 text-center">Tax</th> 
			            <th colspan=1 class="width_10 text-center">Status</th> 
			          </tr>
			        </thead>
			        <tbody ng-repeat="(trIndex, row) in purchaseTable.purchaseTableRow">
			        	<tr>
				            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
				            <td class="width_8"> 
					        	<div class="row">
				            		<div class="col-xs-12">
						       	     	<input type="text" class="form-control input-sm" readonly />
				        			</div>
				        		</div>
				        	</td>
				          	<td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>	
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>	
				            
				            <td class="width_8">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>	
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" />
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_8">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>
				            
				            <td class="width_5">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td>   
				            
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
				         	  		</div>
				              	</div>
				            </td> 
				            <td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12"> 
				         	  			<input type="text" class="form-control input-sm" readonly />
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
				
				<div class="col-md-12"><br>
        			<div class="form-group">
        				<label class="col-md-1 control-label"> SubTotal </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm" readonly>
						</div>
        				<label class="col-md-1 control-label"> Discount </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm" readonly>
						</div>
        				<label class="col-md-1 control-label"> Tax </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm" readonly>
						</div>
						<label class="col-md-1 control-label"> Freight </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm" readonly>
						</div>
						<label class="col-md-1 control-label"> Total </label>
        				<div class="col-md-2">
							<input type="text" class="form-control input-sm" readonly>
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
            data-ng-click="save(mergePurchaseOrderForm)"
            data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            class="btn btn-success" id="update"
            data-ng-click="update(mergePurchaseOrderForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            class="btn btn-success"
            data-ng-click="reset(mergePurchaseOrderForm);">
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