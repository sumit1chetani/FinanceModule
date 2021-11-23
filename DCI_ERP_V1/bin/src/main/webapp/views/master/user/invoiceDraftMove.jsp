<style type="text/css">
/* .panel-body {
	padding-left: 0px;
	padding-right: 0px;
} */
.property-head-code {
	font-size: 14px;
}

.property-head-name {
	font-size: 9px;
}

table ,tr td{
    border:1px solid red
}
tbody {
    display:block;
    height:250px;
    overflow-y:scroll
}
thead, tbody tr {
    display:table;
    width:100%;
    table-layout:fixed;/* even columns width , fix width of table too*/
}
thead {
    width: calc( 100% - 1em )/* scrollbar is average 1em/16px width, remove it from thead width */
}
table {
    width:100px;
}

</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
     <input type="hidden" value="${form_code}" id="form_code_id" /> 
  <div class="panel-body">
   <form class="form-horizontal" name="userMasterForm" role="form">
    <!-- Show Copy Wizard 1 -->
   <div class="row " ng-hide="showCopyWizard">
     <div class="col-md-4">
     <fieldset>
      <div class="form-group">
      
       <label class="col-md-4 control-label">
        	Mode
        <span style="color: red;">*</span>
       </label>
      <div class="col-md-8" > 
     <!-- <div class="col-md-8 no-padding padding-top-5 padding-left-5" > -->
         <selectivity list="modeList" ng-model="invoiceDraft.mode" property="invoiceDraft.mode" name="mode"
         friendly-name="Mode"></selectivity>
        <br>
        <br>
        <br>
         
       </div>
      </div>
      </fieldset>
     </div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label">Invoice Type<span style="color: red;">*</span></label>
       
       <div class="col-md-8">
         
           <selectivity list="salesTypeList" ng-model="invoiceDraft.invoiceType" property="invoiceDraft.invoiceType" name="invoiceType"
         friendly-name="Invoice Type"></selectivity> 
          
       </div>
      </div>
     </div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label">Invoice No<span style="color: red;">*</span></label>
       <div class="col-md-8">
        <selectivity list="invoiceList" ng-model="invoiceDraft.invoiceNo" property="invoiceDraft.invoiceNo" name="invoiceNo"
         friendly-name="Invoice No"></selectivity> 

       <!-- <input type="text" ng-model="invoiceDraft.invoiceNo" class="form-control input-sm text-left" property="invoiceDraft.invoiceNo" name="invoiceNo"
         friendly-name="Invoice No"> -->
       </div>
      </div>
     </div>
    </div>
    <br>
    <br>
    <br>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" type="submit" ng-click="saveInvoice(invoiceDraft)" 	>
        <i class="fa fa-save"></i>
        Move To Draft
       </button>
       
      </div>
     </div>
    </div>
    </form>
    </div>
    </div>
    </div>
    