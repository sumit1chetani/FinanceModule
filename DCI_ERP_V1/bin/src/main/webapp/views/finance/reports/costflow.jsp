<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" novalidate name="jvreportform">
    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label">Voyage</label>
        <div class="col-md-8">
         <!-- <multiselectivity list="voyageList" property="jvtariff.voyage" id="voyage_id" ng-model="jvtariff.voyage"  ></multiselectivity>
          -->
       
          <select ng-model="voyage" multiple="multiple"
              id="voyage_id"  name="voyage_id" ng-options="option.id as option.text for option in voyageList">
         </select>
            
        </div>
       </div>
       
      
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label">Jv Type</label>
        <div class="col-md-8">
         <selectivity list="jvPartnerList" property="costflow.jvtype" id="jvtype_id" ng-model="costflow.jvtype" name="jvtype_id" friendly-name="JV TYPE"
          form-name="jvreportform"></selectivity>
        </div>
       </div>
       
      
      </fieldset>
     </div>
<!--      <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
     
      	<div class="form-group">
								<label class="col-md-4 control-label">SECTOR</label>
								<div class="col-md-8">
									<selectivity list="sectorList" property="costflow.sector"
										id="sector_id" ng-model="costflow.sector" name="sector_id"
										friendly-name="SECTOR" form-name="jvreportform"></selectivity>
								</div>
							</div>
      
      </fieldset>
     </div> -->
    </div>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12 "> 
       <button type="button" ng-click="reset()" class="btn btn-info" tooltip="Reset">
        <i class="fa fa-undo"></i>
        Reset
       </button>
       <button type="button" class="btn btn-primary" ng-click="excel()">Export Excel</button>
        
      </div>
     </div>
    </div>
   </form> 
  </div>
 </div>
</div>
