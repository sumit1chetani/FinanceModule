
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">  
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form name="jvTypeDefnForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
	    <div class="col-lg-12 col-sm-12 col-md-12">
	   			<div class="col-sm-4 col-lg-4 col-md-4">
			        <div class="form-group">
				        <label class="col-md-4 control-label"> JV Type Name<span style="color:red;"> *</span></label>
				        
				        <div class="col-md-8">
				        	<!-- <input type="text" class="form-control input-sm" ng-model="jvTypeData.jvTypeName" 
							id="Jv_Type_name" name="jvTypeName" ng-model="jvTypeData.jvTypeName"
							validation="required" friendly-name="Jv Type Name" > -->	
							<selectivity list="jvTypeList" ng-model="jvTypeData.jvTypeCode" property="jvTypeData.jvTypeCode" 
								id="txtJVTypeName"  name="JV Type Name" validation="required" friendly-name="service"
								form-name="jvTypeDefnForm"></selectivity>	       
				        </div>
		       		</div>
		       		<div class="form-group">
				        <label class="col-md-4 control-label"> Valid From<span style="color:red;"> *</span></label>
			            <div class="col-md-8">
			            	<div class="input-group input-append date" id="jv_validFromDate">
					          <input type="text" class="form-control input-sm" name="validFrom" id="txtFromDate"
					          ng-model="jvTypeData.validFromDate" placeholder='dd/mm/yyyy' 
					          validation="required" friendly-name="Valid From" />
					          <span class="input-group-addon add-on">
					           <span class="glyphicon glyphicon-calendar"></span>
					          </span>
					        </div>		            		
			            </div>
				    </div>
		       	</div>
		       	
	   			<div class="col-sm-4 col-lg-4 col-md-4">	  
		   			<div class="form-group ">
				        <label class="col-md-4 control-label"> JV Partner<span style="color:red;"> *</span></label>
				        <div class="col-md-8"> 
							<select id="txtJVPartner" multiple="multiple" name="multiselect[]" ng-model="jvTypeData.jvPartner"
							 ng-options="option.name for option in jvPartnerList" data-dropdownmultiselect ng-if="!edit">    
							   <option data-ng-repeat="option in jvPartnerList" value="{{getOptionId(option)}}" 
							   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.name}}"></option>
							</select>
							<select id="txtJVPartner" multiple="multiple" name="multiselect[]" ng-model="jvTypeData.jvPartner"
							 ng-options="option.name for option in jvPartnerList" data-dropdownmultiselect ng-if="edit">    
							   <option data-ng-repeat="option in jvPartnerList" value="{{getOptionId(option)}}" 
							   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.name}}"></option>
							</select>
				        </div>
				   </div>
				   <div class="form-group">
				        <label class="col-md-4 control-label"> Valid To<span style="color:red;"> *</span></label>
			            <div class="col-md-8">
		            		<div class="input-group input-append date" id="jv_validToDate">
								<input type="text" class="form-control input-sm"
									name="Valid To" id="txtToDate"
									ng-model="jvTypeData.validToDate" placeholder='dd/mm/yyyy' validation="required" 
									friendly-name="Valid To" /> <span
									class="input-group-addon add-on"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
			            </div>
				    </div>
				</div>
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="form-group">
				        <label class="col-md-4 control-label"> Service<span style="color:red;"> *</span></label>
				        <div class="col-md-8">		      
				        	<!-- <selectivity list="serviceList" ng-model="jvTypeData.serviceCode" property="jvTypeData.serviceCode" 
							id="service"  name="service" validation="required" friendly-name="service"
							form-name = "jvTypeDefnForm"></selectivity>		 -->
							
							 <select id="txtJVService" multiple="multiple" name="multiselect[]" ng-model="jvTypeData.jvService"
							 ng-options="option.id as option.text for option in serviceList" data-dropdownmultiselect>    
							   <option data-ng-repeat="option in serviceList" value="{{getOptionId(option)}}" 
							   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
							</select>       
				        </div>
		       		</div>
				</div>
	    </div>
	     <div class="col-lg-12 col-sm-12 col-md-12">
	     	<fieldset class="width_100 padding-left-10">
	     		<legend class="width_30 b-a padding-left-10 text-center">Percentage Of Sharing</legend>
	  			<div class="form-group">
			        <!-- <label class="col-md-3 control-label">Percentage Of Sharing</label> -->
			        <div class="col-md-8" id="shareOfJVCodeDiv">
			        	<!--dynamic field -->
			        </div>
			    </div>		   
	   		</fieldset>
	     </div>
   </div> 
	<div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="submit(jvTypeDefnForm,jvTypeData)" ng-if="!edit">
           <i class="fa fa-save"></i>
           Save
          </button>
          <button class="btn btn-success" type="button" ng-if="edit" ng-click="submit(jvTypeDefnForm,jvTypeData)">
           <i class="fa fa-save"></i>
           Update
          </button>
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div> <!-- /row -->
   </form>
  </div>
 </div>
</div>