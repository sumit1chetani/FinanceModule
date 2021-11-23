<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="wrapper-md">
    <div class="panel panel-default panel-default-form">
      <%@include file="/views/templates/panel-header-form.jsp"%>
      <div class="panel-body">
       <form name="trialBalanceForm" class="form-horizontal" >
       <div class="row">
           <div class="col-sm-12 col-md-3 col-lg-3">
        <fieldset>
         <div class="form-group">
          <label class="col-md-5 control-label"> Agent Name
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7">
           <selectivity list="vendorList" property="monthlyDisbursement.vendorCode" id="vendorCode" object="vendorCode"></selectivity>
          </div>
         </div>
        </fieldset>
       </div>
           
     
           <div class="col-sm-12 col-md-3 col-lg-3">
        <fieldset>
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">From Date
                    <span style="color: red;">*</span></label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="gl_fromDate">
                         <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                         ng-model="monthlyDisbursement.fromDate" name="fromDate" id="fromDate">
                       <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                      </div>
                    </div>
                  </div>
        </fieldset>
       </div>
       
       <div class="col-sm-12 col-md-3 col-lg-3">
        <fieldset>
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">To Date
                    <span style="color: red;">*</span></label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="gl_toDate">
                         <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                         ng-model="monthlyDisbursement.toDate" name="toDate" id="toDate">
                       <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                      </div>
                    </div>
                  </div>
                </fieldset>
      </div>
      
      
      </div>
      <a id="GLExport" stype="display:none"
      href="filePath/MonthlyDisbursement.xls"
      download="MonthlyDisbursement.xls"></a>
      <!-- Form Action -->
      <div class="form-actions">
              <div class="row">
                <div class="col-md-12 ">
                <security:authorize access="hasRole('${form_code}_${view}')">
                  <button class="btn btn-primary" ng-click="viewGeneralLedgerReport()">
                    <i class="fa fa-search">View Report</i>
                  </button>
                  </security:authorize>
                  <security:authorize access="hasRole('${form_code}_${export}')">
                  <button class="btn btn-primary" ng-click="viewExcelExport()">
                    <i class="fa fa-search">Export Excel</i>
                  </button>
                  </security:authorize>
                 <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="formreset()">
                  <i class="fa fa-undo">Reset</i>
                 </button>
                </div>
               </div>
            </div>
             <br>
             <div class="row">
              <div class="col-xs-12">
                <div id="jqgrid">
         <table id="generalLedgerGrid"></table>
         <div id="generalLedgerPage"></div>
        </div>
       </div>
             </div> 
           

     </form>
    </div> <!-- /panel-body -->
   </div> <!-- /panel-default -->
  </div>
 </div>
</div>