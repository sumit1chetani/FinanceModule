<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -100px;
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
       Valuation Detail
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="valuationDetailForm">
        <div class="row">
         <div class="col-sm-10 col-md-5" style=" margin-left: 20px; "><br>
          <fieldset style=" margin-left: 78px; ">           
          <div class="form-group" ng-init="assetMasterData.valdepAppre='A'">
				<label class="col-md-6 control-label">Valuation Type<span style="color: red;">*</span></label>
				<div class="radio radio-inline">			 
			 		<label class="i-checks"> <input type="radio"
					class="" name="depAppre" value="A"	id="valuationAppricId" ng-click="showAppricFields()"			
					ng-model="assetMasterData.valdepAppre"> <i></i>
					Appreciation 
					</label>
			 	</div>
				<div class="radio radio-inline">
				<label class="i-checks" style=" margin-left:-11px;"> <input type="radio"
				class="" name="depAppre" value="D"	id="valuationDepricId" ng-click="showDepreicFields()"			
				ng-model="assetMasterData.valdepAppre"> <i></i>
				Depreciation
				</label>
				</div>
			</div>
		
		<div class="form-group">										
			 <label class="col-md-6 control-label">Date<span
			style="color: red;"></span></label>
				<div class="col-md-4">
				 <div class='input-group date datetimepick'>
					 <div class="dropdown" style=" margin-left: 10px; ">
					 <a class="dropdown-toggle" id="maintenScheduleDate" role="button"
					 data-toggle="dropdown" data-target="#" href="#">
					 <div class="input-group" style=" margin-top: -16px; ">
					 <input type="text" class="form-control"
					 placeholder="dd/mm/yyyy" name="Start Date"									
					 data-ng-model="assetMasterData.maintenScheduleDate" style=" width: 114px; "><span
					 class="input-group-addon"><i
					 class="glyphicon glyphicon-calendar"></i></span>
					</div>
					</a>
					 <ul class="dropdown-menu" role="menu"
					 aria-labelledby="dLabel">
					 <datetimepicker data-ng-model="assetMasterData.maintenScheduleDate"
					 data-on-set-time="assetMasterData.maintenScheduleDate = onDateSet(newDate)"
					 data-datetimepicker-config="{ dropdownSelector: '#maintenScheduleDate',startView:'day', minView:'day'}" />
			  		 </ul>
					</div>
				</div>
	 		 </div>
			</div>
			<div class="form-group">
          		<label class="col-md-6 control-label"><spring:message
           		code="label.computation.method"></spring:message> <spring:message
           		code="label.asterisk.symbol"></spring:message> </label>
           		<div class="col-md-4 inputGroupContainer">
            		<select class="form-control journalVoucher-textBox"
            		ng-model="assetMasterData.computationMethodVal" 
            		name="Criticality" data-message-id="Computation Method" id="valComputDepApp" ng-change="showComputationDepApp()"
            		data-validator="required" data-valid-method="submit" style=" width: 151px; margin-left: 8px;margin-top: 11px;">
            		<option value="">--Select--</option>
            		<option value ="linear">Linear</option>
            		<option value ="degressive">Degressive</option>
            		<option value ="aggressive">Aggressive</option>                           
          		</select>
         		</div>
        	</div>		

		<div class="form-group"  id="currentDeprecation" style = "display: none">
		<label class="col-md-6 control-label">
		 Current Deprecation						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="Current Deprication"
			data-ng-model="assetMasterData.currDep" style=" margin-left: 8px; width: 151px; ">
		 </div>
		</div>
		<div class="form-group" id="currentAggrecation">
		<label class="col-md-6 control-label">
		 Current Aggrecation						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="Current Aggrecation"
			data-ng-model="assetMasterData.currAgg" style=" margin-left: 8px; width: 151px; ">
		 </div>
		</div>									
		
		<br><div class="form-group" >
		<label class="col-md-6 control-label">
		 Current Value						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.degressive.factor"></spring:message>"
			data-ng-model="assetMasterData.degressiveFactor" style=" width: 151px; margin-left: 8px; ">
		 </div>
		</div>
	   </fieldset>
        </div>
	         
		<div class="col-sm-10 col-md-5"><br>
        <fieldset>  
        <div class="form-group"  >
		<label class="col-md-6 control-label">Current Purchase Value</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.currentPurcValue">
			</div>
	  </div><br>
        <div class="form-group"  >
		<label class="col-md-6 control-label"> Amount Already Deprecated</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.amtdep">
			</div>
	  </div>
	  
	  <div class="form-group" >
		<label class="col-md-6 control-label"> Amount Already Aggrecated</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.amtaggr">
			</div>
	  </div>
	  
	  <div class="form-group"  >
		<label class="col-md-6 control-label" style=" padding-left: 20px; ">Next Period of Deprecation</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.nextPeriodDepric">
			</div>
	  </div>
	 
	 <div class="form-group"  >
		<label class="col-md-6 control-label">After Valuation</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.afterValuation">
			</div>
	  </div>	  
	  
            
      							
			</fieldset>
         </div>
         
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="save(depreciationForm)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(depreciationForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(depreciationForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancelDeprecation();">
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