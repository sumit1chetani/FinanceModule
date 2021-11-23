
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">  
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form name="jvTypeForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
	    <div class="col-lg-12 col-sm-12 col-md-12">
	    	<div class="col-lg-6 col-sm-6 col-md-6">
	    		<div class="form-group">
			        <label class="col-md-3 control-label padding-right-0">Type of JV</label>
			        <div class="col-md-9 padding-left-30">
						<label class="radio radio-inline line-height-30 i-checks">
							<input type="radio" class="style-0" name="jvtypesCRP" checked="checked" ng-model="jvTypeData.jvType" value="CRP" />
							<i></i>Cost & Revenue Pooling</label>
						<label class="radio radio-inline line-height-30 i-checks">
							<input type="radio" class="style-0" name="jvTypesS" ng_model="jvTypeData.jvType" value="S" />
							<i></i>Swap</label>
						<label class="radio radio-inline line-height-30 i-checks">
							<input type="radio"  class="style-0" name="jvTypesRVC" ng_model="jvTypeData.jvType" value="RVC" />
							<i></i>Share of RVC</label>
					</div>
		     	</div>
	   		</div>
	   		
	   		
   			<div class="col-sm-6 col-lg-6 col-md-6">
		        <div class="form-group">
			        <label class="col-md-5 control-label"> JV Type Name<span style="color:red;"> *</span></label>
			        <div class="col-md-7">		      
			        	<input type="text" class="form-control input-sm" ng-model="jvTypeData.jvTypeName" 
						id="Jv_Type_name" name="jvTypeName" ng-model="jvTypeData.jvTypeName"
						validation="required" friendly-name="Jv Type Name" >	       
			        </div>
	       		</div>
	       	</div>
	    </div>
   </div> 
	<div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="submit(jvTypeForm,jvTypeData)" ng-if="!edit">
           <i class="fa fa-save"></i>
           Save
          </button>
          <button class="btn btn-success" type="button" ng-if="edit" ng-click="submit(jvTypeForm,jvTypeData)">
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