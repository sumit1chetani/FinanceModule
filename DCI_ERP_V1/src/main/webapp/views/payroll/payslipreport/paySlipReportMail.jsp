
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%; width: 850px; position: center; top: 10%; left: 0px; margin-top: -40px;
}
</style>
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
       PaySlip Report Mail
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="paySlipReportMailForm"  novalidate method="post">
        <div class="row">
        	<div class="col-sm-12 col-md-12 col-lg-12">
        		<div class="col-sm-10 col-md-10 col-lg-10">
        			<div class="form-group">
		             <label class="col-md-4 control-label"> Email Address </label>
		             <div class="col-md-5">
			             <input class="form-control input-sm" name="emailAddress" ng-model="paySlipReport.emailAddress" 
			             	validation="required" placeholder='your@email.com' friendly-name="Email Address" />
		              </div>
		            </div>
        		</div>
         	</div> <!-- /col-sm-12 col-md-12 col-lg-12 -->
        </div> <!-- /row -->
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-primary" type="button" data-ng-click="emailPaySlipReport(paySlipReport.emailAddress)"><i class="fa fa-envelope-o"></i> Email </button>
           <button class="btn btn-danger" type="button" data-ng-click="cancelEmail()"> Cancel </button>
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