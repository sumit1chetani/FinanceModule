<style>
.myform-group {
	margin-left: 0px;
	margin-bottom: 0px;
}
.ngdialog-content {
	width: 90% !important;
}
</style>

<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content" style="padding: 0px;margin-top: -70px;">
 	<section data-widget-grid id="widget-grid">
  		<div class="row">
   			<article class="col-sm-12">
    			<div data-jarvis-widget id="standard-datatable-widget">
 					<header class="ngdialog-header">
      					<span class="widget-icon"> <i class="fa fa-table"></i>
      					</span>
      				<h2>
       					<spring:message code="label.manageitem.itemCategory"></spring:message>
      				</h2>
     				</header>     
     			<div role="content" style="padding-left: 0px;">
      				<div class="widget-body">
       					<form class="form-horizontal" name="manageItemAddForm">
							 <div class="col-sm-12 col-md-12 col-lg-12">
	        					<div class="col-sm-6 col-md-6 col-lg-6">
	        						<div class="form-group">
						             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.itemCode"></spring:message></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="<spring:message code="label.itemCode"></spring:message>" id="itemCode"
						               			data-ng-model="manageItemObj.itemCode"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
	        						<div class="form-group">
						             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.itemNo"></spring:message></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="<spring:message code="label.itemNo"></spring:message>" id="itemNo"
						               			data-ng-model="manageItemObj.itemNo"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
							       <div class="form-group">
						             	<label class="col-md-6 control-label"> <spring:message code="label.manageitem.itemCategory"></spring:message></label>
						             		<div class="col-md-4">
								              	<select class="form-control" name="<spring:message code="label.itemCategory"></spring:message>" 
								               		data-ng-model="manageItemObj.itemCategory"
								               		data-validator="required" data-valid-method="submit">
								               		<option value="" selected="selected">Select</option>
								              	</select>
						             		</div>
								   </div>
	        					</div>
	        					<div class="col-sm-6 col-md-6 col-lg-6">
	        						<div class="form-group">
						             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.itemName"></spring:message></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="<spring:message code="label.itemName"></spring:message>" id="itemName"
						               			data-ng-model="manageItemObj.itemName"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
							       <div class="form-group">
						             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.itemUOM"></spring:message></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="<spring:message code="label.itemUOM"></spring:message>" id="itemUOM"
						               			data-ng-model="manageItemObj.itemUOM"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
							       <div class="form-group">
						             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.itemSubstitute"></spring:message></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="<spring:message code="label.itemSubstitute"></spring:message>" id="itemSubstitute"
						               			data-ng-model="manageItemObj.itemSubstitute"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
	        					</div>
	        				</div>       
       					</form>
      				</div>
     			</div>
     			<!-- end widget content -->
			     <div class="form-actions">
			      <div class="row">
			       <div class="col-md-12">
			        <button class="btn btn-success" type="button"
			         data-ng-click="save(testmasterForm,testMaster)"
			         data-ng-if="!testMaster.isEdit" class="btn btn-success">
			         <i class="fa fa-save"></i>
			         <spring:message code="label.save"></spring:message>
			        </button>
			        <button class="btn btn-success" type="button"
			         data-ng-click="update(testmasterForm,testMaster)"
			         data-ng-if="testMaster.isEdit" class="btn btn-success">
			         <i class="fa fa-save"></i>
			         <spring:message code="label.update"></spring:message>
			        </button>
			        <button class="btn btn-info" type="button"
			         data-ng-click="reset(testmasterForm)">
			         <i class="fa fa-undo"></i>
			         <spring:message code="label.reset"></spring:message>
			        </button>
			        <button class="btn btn-danger" type="button"
			         class="btn btn-success" ng-click="cancelCategory()">
			         <i class="fa fa-close"></i>
			         <spring:message code="label.cancel"></spring:message>
			        </button>
			        <br> <br>
			       </div>
			      </div>
			     </div>
     <!-- end widget div -->
    		</div>
    <!-- end widget -->
   	</article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>