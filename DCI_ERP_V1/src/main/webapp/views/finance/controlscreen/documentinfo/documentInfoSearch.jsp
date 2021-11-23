<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 	<div class="panel panel-default panel-default-form">
  		<%@include file="/views/templates/panel-header-form.jsp"%>
  			<div class="panel-body">
   				<form class="form-horizontal" name="documentInfoForm" role="form">
    				<div class="row">
     					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
      						<fieldset>
						       <div class="form-group">
						        <label class="col-md-4 control-label"> Document Type <span style="color: red;">*</span>
						        </label> <label class="col-md-1 control-label"> </label>
						        <div class="col-md-5">
						         	<select class="form-control" ng-model="doumentInfoData.documentTypeCode" ng-options="doc.documentTypeCode as doc.documentTypeName for doc in documentTypeList">
						         		<option value="" selected="selected">Select</option>
						         	</select>
						        </div>
						       </div>
						       <div class="form-group">
						        <label class="col-md-4 control-label"> Year <span style="color: red;">*</span></label> <label class="col-md-1 control-label"> </label>
							        <div class="col-md-5">
							          	<input class="form-control" id="year" name="year" data-ng-model="doumentInfoData.year">
							        </div>
						       </div>
						       <div class="form-group">
						        <label class="col-md-4 control-label"> Location <span style="color: red;">*</span></label> <label class="col-md-1 control-label"> </label>
							        <div class="col-md-5">
							         	<selectivity list="locationList" property="doumentInfoData.locationName" id="locationName"></selectivity>
							        </div>
						       </div>
      						</fieldset>
     					</div>
    				</div>
				    <div class="form-actions">
				      <div class="row">
				      	<div class="col-md-12">
				      	<security:authorize access="hasRole('${form_code}_${search}')">
					       <button class="btn btn-success" ng-click="search(doumentInfoData)" type="submit">
					        	<i class="fa fa-search"></i> Search
					       </button>
					       </security:authorize>
					       <button class="btn btn-info" ng-click="reset()" type="button">
					       		<i class="fa fa-undo"></i> Reset
					       </button>
				          </div>
				       </div>
				    </div>
   				</form>
  			</div>
 		 </div>
	  </div>
   </div>
</div>