 <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       Add Depreciation Appreciation Method List
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="deprecationAppreciationMethodForm" method="post" novalidate>
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <fieldset>
           <div class="col-sm-6 col-md-6 col-lg-6">
            <div class="form-group" ng-init="depreciationMethod.valuationType='A'">
             <label class="col-md-5 control-label">Valuation Type<span style="color: red;">*</span></label>
             <div class="radio radio-inline">
              <label class="i-checks"> <input  ng-disabled="isEdit" type="radio" class="" name="valuationType" ng-click="setComputationMethod()"
               value="A" id="valuationTypeId" ng-model="depreciationMethod.valuationType"
               validation="required" friendly-name="Valuation type"> <i></i> Appreciation
              </label>
             </div>
             <div class="radio radio-inline">
              <label class="i-checks"> <input  ng-disabled="isEdit" type="radio" class="" name="valuationType" ng-click="setComputationMethod()"
               value="D" id="valuationTypeId" ng-model="depreciationMethod.valuationType"
               validation="required" friendly-name="Valuation type"> <i></i> Depreciation
              </label>
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"><spring:message
               code="label.computation.method"></spring:message> <spring:message
               code="label.asterisk.symbol"></spring:message> </label>
             <div class="col-md-6">
              <select class="form-control journalVoucher-textBox"
               ng-model="depreciationMethod.computationMethodId" name="computationMethodId"
               data-message-id="Computation Method" id="computationMethodId" validation="required"
               friendly-name="Computation method"  ng-options="d.id as d.computationMethod for d in computationMethodList" >
               <option value="" selected="selected">Select</option>
              </select>
             </div>
            </div>
            <div class="form-group" id="depFactor">
             <!-- id="depFactor" style = "display: none" -->
             <label class="col-md-5 control-label" ng-if="depreciationMethod.valuationType=='D'"> 
             <spring:message code="label.degressive.factor"></spring:message>
             <spring:message code="label.asterisk.symbol"></spring:message>
             </label>
             <label class="col-md-5 control-label" ng-if="depreciationMethod.valuationType=='A'"> 
             <spring:message code="label.aggressive.factor"></spring:message>
             <spring:message code="label.asterisk.symbol"></spring:message>
             </label>
             <div class="col-md-6">
              <input type="number" class="form-control input-sm text-right"
               name="<spring:message code="label.degressive.factor"></spring:message>"
               data-ng-model="depreciationMethod.aggressiveFactor" min=0 max=100
               validation="max:100|numeric|required" friendly-name="Factor">
             </div>%
            </div>
            
           </div>
           <div class="col-sm-6 col-md-6 col-lg-6">
            <div class="form-group">
             <label class="col-md-5 control-label"><spring:message code="label.method"></spring:message>
              <spring:message code="label.asterisk.symbol"></spring:message> </label>
             <div class="col-md-6 inputGroupContainer">
              <select class="form-control journalVoucher-textBox" ng-model="depreciationMethod.methodId"
               id="methodId" name="methodId" data-message-id="methodId" ng-options="d.id as d.method for d in methodsList" 
               validation="required" friendly-name="Method">
               <option value="" selected="selected">Select</option>
              </select>
             </div>
            </div>
            <div class="form-group" id="methodNoDepric"
             ng-if="(depreciationMethod.methodId=='159' && depreciationMethod.valuationType=='D') || (depreciationMethod.methodId=='157' && depreciationMethod.valuationType=='A')">
             <label class="col-md-5 control-label" 
             ng-if="depreciationMethod.methodId=='159'  && depreciationMethod.valuationType=='D'"> 
             No of Valuation
             <spring:message code="label.asterisk.symbol"></spring:message>
             </label>
             <label class="col-md-5 control-label"
             ng-if="depreciationMethod.methodId=='157'  && depreciationMethod.valuationType=='A'">
              No of Valuation<spring:message code="label.asterisk.symbol"></spring:message>
              </label>
             <div class="col-md-6">
              <input type="text" class="form-control input-sm text-right" name="no of val" id="noofDep"
               data-ng-model="depreciationMethod.noOfDepreciation" validation="numeric|required" friendly-name="No of Valuation">
             </div>
            </div>
           
            <div class="form-group" id="periodLen"
             ng-if="depreciationMethod.methodId=='157' || depreciationMethod.methodId=='159'">
             <label class="col-md-5 control-label"> Period Length<spring:message code="label.asterisk.symbol"></spring:message>
             </label>
             <div class="col-md-6">
              <input type="text" class="form-control input-sm text-right" name="Name" 
               data-ng-model="depreciationMethod.periodLength" validation="numeric|required" friendly-name="Period Length"> (In months)
             </div>
            </div>
            <div class="form-group" id="depricEndingDate"
             ng-if="depreciationMethod.methodId=='158' || depreciationMethod.methodId=='160'">
             <label class="col-md-5 control-label">Ending Date<spring:message
               code="label.asterisk.symbol"></spring:message></label>
             <div class="col-md-6">
              <div class='input-group date datetimepick col-md-12'>
               <div class="dropdown">
                <a class="dropdown-toggle" id="depricationEndingDate" role="button"
                 data-toggle="dropdown" data-target="#" href="#">
                 <div class="input-group">
                  <input type="text" class="form-control" placeholder="dd/mm/yyyy"
                   name="Ending Date" data-ng-model="depreciationMethod.endingDate"
                   validation="date_euro_long|required" friendly-name="Ending Date"><span
                   class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                 </div>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                 <datetimepicker data-ng-model="depreciationMethod.endingDate"
                  data-on-set-time="depreciationMethod.endingDate = onDateSet(newDate)"
                  data-datetimepicker-config="{ dropdownSelector: '#depricationEndingDate',startView:'day', minView:'day'}" />
                </ul>
               </div>
              </div>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
        </div>
        <br>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="validateDepreciation(deprecationAppreciationMethodForm,depreciationMethod)"
            data-ng-if="!isEditDepreciation">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="updateDepreciation(deprecationAppreciationMethodForm,depreciationMethod)" data-ng-if="isEditDepreciation == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-danger" type="button" data-ng-click="cancelDepreciationAppreciation();">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
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