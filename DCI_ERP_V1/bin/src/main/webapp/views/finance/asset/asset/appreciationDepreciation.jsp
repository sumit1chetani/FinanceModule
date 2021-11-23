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
       <spring:message code="label.appreciation.depreciation"></spring:message>
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="depreciationForm">
        <div class="row">
         <div class="col-sm-10 col-md-5" style=" margin-left: 20px; "><br>
          <fieldset style=" margin-left: 78px; ">           
          <div class="form-group" ng-init="assetMasterData.depAppre='A'">
				<label class="col-md-6 control-label">Valuation Type<span style="color: red;">*</span></label>
				<div class="radio radio-inline">			 
			 		<label class="i-checks"> <input type="radio"
					class="" name="depAppre" value="A"	id="valuationTypeId" ng-click="showDepricAppric()"			
					ng-model="assetMasterData.depAppre"> <i></i>
					Appreciation 
					</label>
			 	</div>
				<div class="radio radio-inline">
				<label class="i-checks" style=" margin-left:-11px;"> <input type="radio"
				class="" name="depAppre" value="D"	id="valuationTypeDepId" ng-click="showDepricFields()"			
				ng-model="assetMasterData.depAppre"> <i></i>
				Depreciation
				</label>
				</div>
			</div>
		
		<div class="form-group">
          <label class="col-md-6 control-label"><spring:message
           code="label.computation.method"></spring:message> <spring:message
           code="label.asterisk.symbol"></spring:message> </label>
           <div class="col-md-4 inputGroupContainer">
            <select class="form-control journalVoucher-textBox"
            ng-model="assetMasterData.computationMethod" ng-change="showFactorFields()"
            name="Criticality" data-message-id="Computation Method" id="computationMethodId"
            data-validator="required" data-valid-method="submit" style=" width: 140px; margin-left: 8px;margin-top: 11px;">
            <option value="">--Select--</option>
            <option value ="linear">Linear</option>
            <option value ="degressive">Degressive</option>
            <option value ="aggressive">Aggressive</option>                           
          </select>
         </div>
        </div>
		
		<div class="form-group" id="depFactor" style = "display: none"> <!-- id="depFactor" style = "display: none" -->
		<label class="col-md-6 control-label">
		 <spring:message code="label.degressive.factor"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.degressive.factor"></spring:message>"
			data-ng-model="assetMasterData.degressiveFactor" style=" width: 144px; margin-left: 8px; ">
		 </div>
		</div>

		<div class="form-group" id="aggFactor" ><!-- style = "display: none" -->
		<label class="col-md-6 control-label">
		 <spring:message code="label.aggressive.factor"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.aggressive.factor"></spring:message>"
			data-ng-model="assetMasterData.aggresiveFactor" style=" margin-left: 8px; width: 144px; ">
		 </div>
		</div>
		
		
		
		 </fieldset>
        </div>
	         
		<div class="col-sm-10 col-md-5"><br>
        <fieldset>  
        <div class="form-group">
          <label class="col-md-6 control-label"><spring:message
           code="label.method"></spring:message> <spring:message
           code="label.asterisk.symbol"></spring:message> </label>
           <div class="col-md-4 inputGroupContainer">
            <select class="form-control journalVoucher-textBox"
            ng-model="assetMasterData.method" id="appricDepricId"
            name="Method" data-message-id="Method" ng-change="showAppricDepricFields()"
            data-validator="required" data-valid-method="submit" style=" width: 150px; ">
            <option value="">--Select--</option>
            <option value ="NOD">Number of Depreciation</option>
            <option value ="NOA">Number of Appreciation</option>
            <option value ="Ending Date">Ending Date</option>                           
          </select>
         </div>
        </div> 
        
        <div class="form-group"  id="methodNoDepric" style = "display: none">
		<label class="col-md-6 control-label"> No of Depreciation</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.noOfDepricValue">
			</div>
	  </div>
	  
	  <div class="form-group"  id="methodNoAppic" style = "display: none">
		<label class="col-md-6 control-label"> No of Appreciation</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.noOfAppricValue">
			</div>
	  </div>
	  
	  <div class="form-group"  id="periodLen" style = "display: none">
		<label class="col-md-6 control-label"> Period Length</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="Name" style=" width: 144px; "
			 data-ng-model="assetMasterData.periodLength">
			 (In months)
			</div>
	  </div>
	  
	  <div class="form-group" id="depricEndingDate" style = "display: none">										
		<label class="col-md-6 control-label">Ending Date<span
		style="color: red;"></span></label>
		<div class="col-md-6">
		 <div class='input-group date datetimepick col-md-12'>
		  <div class="dropdown">
			<a class="dropdown-toggle" id="depricationEndingDate" role="button"
			 data-toggle="dropdown" data-target="#" href="#">
			 <div class="input-group" style=" margin-top: -16px; ">
			 <input type="text" class="form-control" style=" width: 125px; "
			 placeholder="dd/mm/yyyy" name="Ending Date"									
			 data-ng-model="assetMasterData.depricationEndingDate"  "><span
			 class="input-group-addon"><i
			 class="glyphicon glyphicon-calendar"></i></span>
			 </div>
			</a>
			<ul class="dropdown-menu" role="menu"
			aria-labelledby="dLabel">
			<datetimepicker data-ng-model="assetMasterData.depricationEndingDate"
			data-on-set-time="assetMasterData.depricationEndingDate = onDateSet(newDate)"
			data-datetimepicker-config="{ dropdownSelector: '#depricationEndingDate',startView:'day', minView:'day'}" />
			</ul>
		 </div>
		</div>
	  </div>
	</div>
            
        <div class="form-group">
		<label class="col-md-6 control-label">
		 <spring:message code="label.purchase.value"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.purchase.value"></spring:message>"
			data-ng-model="assetMasterData.purchaseValue">
		 </div>
		</div>
		<br>
		<div class="form-group">
		<label class="col-md-6 control-label">
		 <spring:message code="label.salvage.value"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.salvage.value"></spring:message>"
			data-ng-model="assetMasterData.salvageValue">
		 </div>
		</div>
            <br> 							
		 <div class="form-group">
		<label class="col-md-6 control-label">
		 <spring:message code="label.residual.value"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.residual.value"></spring:message>"
			data-ng-model="assetMasterData.residual">
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