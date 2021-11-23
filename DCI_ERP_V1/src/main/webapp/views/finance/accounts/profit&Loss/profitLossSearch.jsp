<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
div#gbox_profitAndLossGrid{
	width: 98%;
}
</style>

<div>
 <section data-widget-grid id="widget-grid">
  <div class="padding-top-10">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header>
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span> <state-breadcrumbs></state-breadcrumbs>
      </span>
      <div class="widget-toolbar">
       <div>
        <span> <span class="button-icon" data-reset-widgets rel="tooltip"
         title="<spring:message code="title.widget.reset"></spring:message>" data-placement="bottom">
          <i class="fa fa-refresh"></i>
        </span>
        </span>
       </div>
      </div>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="profitLossSearchForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
          <fieldset>
           <div class="form-group">
            <label class="col-md-4 control-label">Company
            <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-5 inputGroupContainer">
          <selectivity list="companyList" property="pl.company"
											 data-ng-model="pl.company"
											 id="company" object="company" name="company"></selectivity>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-4 control-label">From Date
            <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-5">
             <div class="input-group date datetimepick col-md-12">
              <div class="dropdown">
               <a data-toggle="dropdown" class="dropdown-toggle" id="date" role="button"
                data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Date"
                  data-validator="required" data-valid-method="submit" data-message-id="Date"
                  data-ng-model="pl.fromDate" validation="date_euro_long|required" friendly-name="From Date">
                   <span class="input-group-addon">
                  <i class="glyphicon glyphicon-calendar" required></i>
                 </span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                <datetimepicker data-ng-model="pl.fromDate"
                 data-on-set-time="pl.fromDate = onDateSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
               </ul>
              </div>
             </div>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-4 control-label">To Date
            <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-5">
             <div class="input-group date datetimepick col-md-12">
              <div class="dropdown">
               <a data-toggle="dropdown" class="dropdown-toggle" id="todate" role="button"
                data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="toDate"
                  data-validator="required" data-valid-method="submit" data-message-id="Date"
                  data-ng-model="pl.toDate" validation="date_euro_long|required" friendly-name="To Date" >
                   <span class="input-group-addon">
                  <i class="glyphicon glyphicon-calendar" required></i>
                 </span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                <datetimepicker data-ng-model="pl.toDate"
                 data-on-set-time="pl.toDate = onDateSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#todate',startView:'day', minView:'day'}" />
               </ul>
              </div>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
        </div> <!-- /row -->
        <a id="exportPL" stype="display:none"
		href="{{filePath}}"
		download="ProfitAndLoss.xls"></a>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12 ">
           <!--  <button class="btn btn-primary" type="button" ng-click="viewTrialBalance()">
            <i class="fa fa-search">View Report Jasper</i>
           </button> -->
           <button class="btn btn-primary" ng-click="viewProfitLoss()">
            <i class="fa fa-search">View Report</i>
           </button>
            <button class="btn btn-primary" ng-click="exportExcel()">
            <i class="fa fa-search">Excel Export</i>
           </button>
           <button class="btn btn-danger" ng-click="resetPL()">
            <i class="fa fa-undo">Reset</i>
           </button>
          </div>
         </div>
        </div>
        <div class="row">
	      	<div class="col-md-12" id="jqgrid">
				<table id="profitAndLossGrid"></table>
				<div id="profitAndLossPage"></div>
			</div>
		</div>
       </form> <!-- /form-horizontal -->
      </div> <!-- /widget-body -->
     </div> <!-- /content -->
    </div> <!-- /standard-datatable-widget -->
   </article>
  </div>
 </section>
</div>