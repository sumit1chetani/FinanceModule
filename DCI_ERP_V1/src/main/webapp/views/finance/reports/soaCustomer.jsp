<%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
    	<input type="hidden" value="${form_code}" id="form_code_id">
 <div class="panel-body">
<section widget-grid id="widget-grid">
  <div class="row">
    <article class="col-sm-12 col-md-12 col-lg-12 ">
      <div class="widget-body">
       <form class="form-horizontal" name="soaCustomer">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
          <fieldset>
           <div class="form-group">
            <label class="col-md-4 control-label">Company</label>
            <div class="col-md-5">
             <div id="company_select" class="selectivity-input example-input selectivity-slot">
				<div class="selectivity-single-select">
				<input  type="text" class="selectivity-single-select-input">
				<div class="selectivity-single-result-container">
				<div class="selectivity-placeholder"></div>
				</div><i class="fa fa-sort-desc selectivity-caret"></i>
				</div>
				</div>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-4 control-label">MLO</label>
            <div class="col-md-5">
             <div id="mlo_select" class="selectivity-input example-input selectivity-slot">
				<div class="selectivity-single-select">
				<input  type="text" class="selectivity-single-select-input" >
				<div class="selectivity-single-result-container">
				<div class="selectivity-placeholder"></div>
				</div><i class="fa fa-sort-desc selectivity-caret"></i>
				</div>
				</div>
            </div>
           </div>
           <div class="form-group ">
            <label class="col-md-4 control-label">From Date</label>
            <div class="col-md-5 inputGroupContainer">
             <div class="input-group" ng-class="{'has-error' : objSoa.fromDate.$invalid   && submitted }">
              <input type="text" data-ng-model="objSoa.fromDate" class="form-control" placeholder="dd/mm/yyyy" show-button-bar="false" datepicker-popup="dd-MM-yyyy" name="validfromDate"
               is-open="openedvalidfromDate" datepicker-options="dateOptions"  close-text="Close" />
              <span class="input-group-btn">
               <button type="button" class="btn btn-default " ng-click="opentime($event,'openedvalidfromDate')">
                <i class="glyphicon glyphicon-calendar"></i>
               </button>
              </span>
             </div>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-4 control-label">To Date</label>
            <div class="col-md-5 inputGroupContainer">
             <div class="input-group" ng-class="{'has-error' : objSoa.toDate.$invalid   && submitted }">
              <input type="text" data-ng-model="objSoa.toDate" class="form-control input-sm" placeholder="dd/mm/yyyy" show-button-bar="false" datepicker-popup="dd-MM-yyyy" name="validtoDate"
                is-open="openedvalidtoDate" datepicker-options="dateOptions" close-text="Close" />
              <span class="input-group-btn">
               <button type="button" class="btn btn-default input-sm" ng-click="opentime($event,'openedvalidtoDate')">
                <i class="glyphicon glyphicon-calendar"></i>
               </button>
              </span>
             </div>
            </div>
           </div>

          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12 ">
           <security:authorize access="hasRole('${form_code}_${export}')">
           <button  type="button" class="btn btn-success" ng-click="exportData(objSoa);">Export Excel</button></security:authorize>
            <a id="tbPdfExport" stype="display:none" href="/assets/excelDocument/soaCustomerDtl.xls" download="soaCustomerDtl.xls"></a>
           <button class="btn btn-info" type="reset" class="btn btn-success" tooltip="Reset" ng-click="reset()">
            <i class="fa fa-undo"></i>
            Reset
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>


   </article>
  </div>
 </section>
 </div>
</div>
</div>
