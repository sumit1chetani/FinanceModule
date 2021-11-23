<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span><state-breadcrumbs></state-breadcrumbs></span>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="debitNoteApprovalForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-md-4">
           <fieldset>
            <div class="form-group">
             <label class="col-md-6 control-label"> Debit Code</label>
             <div class="col-md-6">
              <input type="text" class="form-control input-sm" value="CNS245303" readonly>
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-6 control-label"> Account Head
              <spring:message code="label.asterisk.symbol"></spring:message>
             </label>
             <div class="col-md-6">
              <input type="text" class="form-control input-sm" value="CNSTEC" readonly>
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-6 control-label"> Invoice
              Number <spring:message code="label.asterisk.symbol"></spring:message>
             </label>
             <div class="col-md-6">
              <input type="text" class="form-control input-sm" value="PHCSI793410" readonly>
             </div>
            </div>
           </fieldset>
          </div>
          <div class="col-md-4">
           <div class="form-group">
            <label class="col-md-6 control-label"> Debit Note
             Date <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-6">
             <div class="input-group input-append date">
              <input type="text" class="form-control input-sm"
               name="Credit Note Date" id="creditNoteDate"
               value="26/08/2015" readonly> <span
               class="input-group-addon add-on"><span
               class="glyphicon glyphicon-calendar"></span></span>
             </div>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Invoice Date
            </label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm" value="26/08/2015" readonly>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Location</label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm" value="Chennai" readonly>
            </div>
           </div>
          </div>
          <div class="col-md-4">
           <div class="form-group">
            <label class="col-md-5 control-label"> Hospital </label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm" value="KMC" readonly>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-5 control-label"> Amount</label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm" value="1850.00" readonly>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-5 control-label"> Status </label>
            <div class="col-md-6">
             <select class="form-control input-sm" name="Service"
              ng-model="OnDutyRequestApprovalData.status" id="status" required>
              <option value="">--Select--</option>
              <option value="Pending">Pending</option>
              <option value="Approved">Approved</option>
              <option value="Cancelled">Cancelled</option>
             </select>
            </div>
           </div>
          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="update(debitNoteApprovalForm)">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(debitNoteApprovalForm);">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancel();">
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
