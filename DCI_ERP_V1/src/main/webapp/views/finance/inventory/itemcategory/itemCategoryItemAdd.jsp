<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       			<form class="form-horizontal" name="itemCategoryAddForm" novalidate method="post">
        			<div class="row">
         				<div class="col-sm-12 col-md-12 col-lg-12">
          					<fieldset>
          					<div class="col-md-6">
           						
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Category Name<span style="color:red">*</span></label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="categoryName" id="categoryName"
						               			data-ng-model="itemCategoryObj.categoryName"
						               			validation="required" friendly-name="Category Name" ng-blur="checkCatgeoryName(itemCategoryObj.categoryName)">
						             	</div>
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Category Type <span style="color:red">*</span></label>
						             		<div class="col-md-7">
						             			<select class="form-control" name="categoryTypeId" id="categoryTypeId"
									               data-ng-model="itemCategoryObj.categoryTypeId" validation="required" friendly-name="Category Type" data-ng-change="oncheckAsset()"
									               data-ng-options="categoryTypeValues.categoryTypeId as categoryTypeValues.categoryTypeName  for categoryTypeValues in categoryList" >
									               <option value="" selected="selected">Select</option>
									            </select>
						             		</div>
						    		</div>
						    </div>
			          	<div class="col-md-6">
			           			<div class="form-group">
					             	<label class="col-md-4 control-label">Parent Category
</label>
					             		<div class="col-md-7">
					             			<!-- <select class="form-control" name="<spring:message code="label.parentCategory"></spring:message>"
								               data-message-id="Parent Category" 
								               data-ng-model="itemCategoryObj.parentCategoryId"
								                ng-change="getGrnAttributeValues(itemCategoryObj.parentCategoryId)"
								               data-validator="required"
								                data-valid-method="submit" 
								               data-ng-options="parentCategoryValues.parentCategoryId as parentCategoryValues.parentCategoryName  for parentCategoryValues in parentCategoryList" >
								               <option value="" selected="selected">Select</option>
								            </select> -->
								            
				<selectivity list="parentCategoryList"  class="col7-select"
	             property="itemCategoryObj.parentCategoryId" 
	             name="parentCategory" id="parentCategory"
				 data-message-id="Parent Category"
				 data-ng-model="itemCategoryObj.parentCategoryId" 
				 validation="required"></selectivity>
				 
					             		</div>
						        </div>
						        <div class="form-group">
			             			<label class="col-md-4 control-label">Incoming Quality Check</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="itemCategoryObj.qualityCheck" data-ng-true-value="'Y'" data-ng-false-value="'N'">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
	           			</div>
	           			</fieldset>
	           			</div>
	           			
         		<tabset><br>
         			<tab heading="Accounting"><br>
         				<div class="col-sm-12 col-md-12 col-lg-12">
         					<div class="col-sm-6 col-md-6 col-lg-6">
         						<div class="form-group">
					             	<label class="col-md-4 control-label"> Sales Taxes<span style = "color:red";>*</span></label>
					             		<div class="col-md-7">
					             			<select class="form-control" name="salesTaxesId" id="salesTaxesId"
								               data-ng-model="itemCategoryObj.salesTaxesId" validation="required" friendly-name="Sales Taxes"
								               data-ng-options="saleTaxValues.salesTaxesId as saleTaxValues.salesTaxesName  for saleTaxValues in salesList" >
								               <option value="" selected="selected">Select</option>
								            </select>
					             		</div>
						        </div>
						        <div class="form-group">
					             	<label class="col-md-4 control-label">Income Account<span style = "color:red";>*</span></label>
					             		<div class="col-md-7">
					             			<!-- <select class="form-control" name="incomeAccountId" id="incomeAccountId"
								               data-ng-model="itemCategoryObj.incomeAccountId" validation="required" friendly-name="Income Account"
								               data-ng-options="incomeAccountValues.incomeAccountId as incomeAccountValues.incomeAccountName  for incomeAccountValues in incomeAccountList" >
								               <option value="" selected="selected">Select</option>
								            </select> -->
								            
								               <selectivity list="incomeAccountList" property="itemCategoryObj.incomeAccountId"
												ng-model="itemCategoryObj.incomeAccountId" form-name="itemCategoryAddForm" 
												validation="required" friendly-name="Income Account in Accounting Tab"
												name="incomeAccountId" id="incomeAccountId"></selectivity>
								            
								        
				
					             		</div>
						        </div>
         					</div>
         					<div class="col-sm-6 col-md-6 col-lg-6">
         						<div class="form-group">
					             	<label class="col-md-4 control-label">Purchase Taxes<span style = "color:red";>*</span></label>
					             		<div class="col-md-7">
					             			<select class="form-control" name="purchaseTaxesId" id="purchaseTaxesId"
								               data-ng-model="itemCategoryObj.purchaseTaxesId" validation="required" friendly-name="Purchase Taxes"
								               data-ng-options="purchaseTaxValues.purchaseTaxesId as purchaseTaxValues.purchaseTaxesName  for purchaseTaxValues in purchaseList" >
								               <option value="" selected="selected">Select</option>
								            </select>
					             		</div>
						        </div>
						        <div class="form-group">
					             	<label class="col-md-4 control-label">Expense Account<span style = "color:red";>*</span></label>
				             		<div class="col-md-7">
				             			<!-- <select class="form-control" name="expenseAccountId" id="expenseAccountId"
							               data-ng-model="itemCategoryObj.expenseAccountId" validation="required" friendly-name="Expense Account"
							               data-ng-options="expenseAccountValues.expenseAccountId as expenseAccountValues.expenseAccountName  for expenseAccountValues in expenseAccountList" >
							               <option value="" selected="selected">Select</option>
							            </select> -->
							            
							         
							            
							           <selectivity list="expenseAccountList" property="itemCategoryObj.expenseAccountId"
												ng-model="itemCategoryObj.expenseAccountId" form-name="itemCategoryAddForm" 
												validation="required" friendly-name="Expense Account in Accounting Tab"
												name="expenseAccountId" id="expenseAccountId"></selectivity>
				             		</div>
						        </div>
         					</div>
         				</div>
	        		</tab>
	        		<tab heading="Item Properties"><br>
        				<div id="content">
						 	<section data-widget-grid id="widget-grid">
						  		<div class="row">
						   			<article class="col-sm-12">
						    			<div data-jarvis-widget id="standard-datatable-widget">
									     <div role="content">
									      <div class="widget-body no-padding">
									       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
									        	data-st-table="displayedCollectionItem"
									        	data-st-safe-src="rowCollectionItem">
									         <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
										           <button ng-click="addNewRow()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="" type="button">
										            <i class="fa fa-plus"></i>
										           </button>
										           <button ng-click="removePropertyRow()" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
										            <i class="fa  fa-trash-o"></i>
										           </button>
										      </div>
										      <div style=" height: 250px; overflow-y: auto;">
									        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
										         <thead class="dataTables-Main-Head">
										          <tr>
										           <th class="width_1 text-center table-heading">
										            <label class="i-checks m-b-none">
										             <input  type="checkbox" ng-model="selectedAll" ng-change="checkAll(rowCollection,selectedAll)">
										             <i></i>
										            </label>
										           </th>
										           <th class="sorting width_5" st-sort="propName">Property Name	 </th>
										            <th class="sorting width_5" st-sort="propertyType">Property  Type </th>
										           <th class="sorting width_5" st-sort="propLength">Length </th>
										           <th class="sorting width_5" st-sort="manditory">Is Mandatory </th>
										          </tr>
										          
										          
										         </thead>
										         <tbody class="dataTables-Main-Body">
										          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="itemDetail in displayedCollectionItem">           
										          <td  style="padding-left: 2%">
										           <label class="i-checks m-b-none" style="margin-left: 6px;">
										             <input type="checkbox" ng-model="itemDetail.isSelected">
										             <i></i>
										            </label></td>       
										           <td>{{itemDetail.propName}}</td>
										           <td>{{itemDetail.propertyTypeName}}</td>
										           <td>{{itemDetail.typeName}}</td>
										           <td data-ng-if="itemDetail.manditory=='t'">
											           <div class="checkbox">
											           	<label>
														  <input type="checkbox" checked="checked" disabled="disabled">
														<span></span>
														</label>
														</div>
										           </td>
										           <td data-ng-if="itemDetail.manditory!='t'">
										           		<div class="checkbox">
											           	<label class="i-checks">
														  <input type="checkbox" disabled="disabled">
															<i></i>
														</label>
														</div>
										           </td>
										          </tr>
										         </tbody>
										        </table>
										        </div>
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>									       </div>
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
	        		</tab>
	        		<tab heading="GRN Attribute"><br>
	        			<div class="col-sm-12 col-md-12 col-lg-12">
	        				<div class="col-sm-6 col-md-6 col-lg-6">
	        					<div class="form-group">
			             			<label class="col-md-4 control-label">Batch No</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="itemCategoryObj.batchNo" data-ng-true-value="'Y'" data-ng-false-value="'N'">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
			            		<div class="form-group">
			             			<label class="col-md-4 control-label">MRP</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="itemCategoryObj.mrp" data-ng-true-value="'Y'" data-ng-false-value="'N'">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
	        				</div>
	        				<div class="col-sm-6 col-md-6 col-lg-6">
	        					<div class="form-group">
			             			<label class="col-md-4 control-label">Expiry Date</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="itemCategoryObj.expiryDate" data-ng-true-value="'Y'" data-ng-false-value="'N'">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
			            		<div class="form-group">
			             			<label class="col-md-4 control-label">Manufacture Details</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="itemCategoryObj.manufactureDetails" data-ng-true-value="'Y'" data-ng-false-value="'N'">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
	        				</div>
	        			</div>
	        		</tab>
         		</tabset>
        	</div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success"
            ng-if="!isEdit" type="button"
            ng-click="validate(itemCategoryAddForm,itemCategoryObj,itemDetail)">
            <i class="fa fa-save"></i>Save
           </button>
           <button class="btn btn-success"
            ng-if="isEdit==true" type="button"
            ng-click="validate(itemCategoryAddForm,itemCategoryObj,itemDetail)">
            <i class="fa fa-save"></i>Update
           </button>
           <button class="btn btn-info ng-scope" type="button"
            ng-click="reset(itemCategoryAddForm)" class="btn btn-success">
            <i class="fa fa-undo"></i>Reset
           </button>
           <button class="btn btn-danger" type="button"
            class="btn btn-success" ng-click="cancelItem()">
            <i class="fa fa-close"></i>Cancel
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