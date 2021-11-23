<style>
.myform-group {
	margin-left: 0px;
	margin-bottom: 0px;
}
.ngdialog-content {
	width: 50% !important;
}
</style>

<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content" style="">
 	<section data-widget-grid id="widget-grid">
  		<div class="row">
   			<article class="col-sm-12">
    			<div data-jarvis-widget id="standard-datatable-widget">
 					<header class="ngdialog-header">
      					<span class="widget-icon"> <i class="fa fa-table"></i>
      					</span>
      				<h2>
       					<spring:message code="label.entity.address"></spring:message>
      				</h2>
     				</header>     
     			<div role="content" style="padding-left: 0px;">
      				<div class="widget-body">
       					<form class="form-horizontal" name="bankAddForm" novalidate method="post">
       						<div class="row">
		        				<div class="col-sm-12 col-md-12 col-lg-12">
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		           						<fieldset>
								            <div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.name"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.contactName"></spring:message>" id="contactName"
								               			data-ng-model="customerContactobj.contactName"
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
								            <div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.email"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.email"></spring:message>" id="email"
								               			data-ng-model="customerContactobj.email" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
								            <div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.mobile"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.mobile"></spring:message>" id="mobileC"
								               			data-ng-model="customerContactobj.mobile" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
		           						</fieldset>
		          					</div>
					          		<div class="col-sm-6 col-md-6 col-lg-6">
					           			<fieldset>
					           				<div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.jobPosition"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.jobPosition"></spring:message>" id="jobPosition"
								               			data-ng-model="customerContactobj.jobPosition"
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
								            <div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.phone"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.phone"></spring:message>" id="phone"
								               			data-ng-model="customerContactobj.phone" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
								            <%-- <div class="form-group">
							             		<label class="col-md-4 control-label"> <spring:message code="label.entity.active"></spring:message></label>
							             			<div class="col-md-7">
									              		<div class="checkbox">
									               			<label> 
									               				<input type="checkbox" class="checkbox style-0" data-ng-model="entityObj.hospitalAddress" data-ng-true-value="'Y'" data-ng-false-value="'N'" ng-init="entityObj.hospitalAddress=='N'">
									                			<span></span>
									               			</label>
									              		</div>
									             	</div>
							            	</div> --%>
			           					</fieldset>
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
			        <button class="btn btn-success" type="submit"
			         data-ng-click="saveRowContact(bankAddForm)">
			         <i class="fa fa-save"></i>
			         Add to List
			     <%--     <spring:message code="label.save"></spring:message> --%>
			        </button>
			         <button class="btn btn-danger" type="reset"
			         class="btn btn-success" ng-click="cancelAddress()">
			         <i class="fa fa-close"></i>
			         <spring:message code="label.cancel"></spring:message>	
			        </button>
			        
			       <%--  <button class="btn btn-success" type="submit"
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
			        <button class="btn btn-danger" type="reset"
			         class="btn btn-success" ng-click="cancelAddress()">
			         <i class="fa fa-close"></i>
			         <spring:message code="label.cancel"></spring:message>	
			        </button> --%>
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