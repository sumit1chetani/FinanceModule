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
   <!--   <div class="col-md-4">
     <fieldset>
      <div class="form-group">
      
       <label class="col-md-4 control-label">
        	Mode
        <span style="color: red;">*</span>
       </label>
      <div class="col-md-8" > 
     <div class="col-md-8 no-padding padding-top-5 padding-left-5" >
         <selectivity list="modeList" ng-model="invoiceDraft.mode" property="invoiceDraft.mode" name="mode"
         friendly-name="Mode"></selectivity>
        <br>
        <br>
        <br>
         
       </div>
      </div>
      </fieldset>
     </div> -->
     <div class="col-md-5">
      <div class="form-group">
       <label class="col-md-4 control-label">Invoice Type<span style="color: red;">*</span></label>
       
       <div class="col-md-8">
         
           <selectivity list="salesTypeList" ng-model="invoiceDraft.invoiceType" property="invoiceDraft.invoiceType" name="invoiceType"
         friendly-name="Invoice Type"></selectivity> 
          
       </div>
      </div>
     </div>
      <div class="col-md-5">
      <div class="form-group">
       <label class="col-md-4 control-label">Invoice No<span style="color: red;">*</span></label>
       <div class="col-md-8">
         
       <input type="text" ng-model="invoiceDraft.invoiceNo" class="form-control input-sm text-left" property="invoiceDraft.invoiceNo" name="invoiceNo"
         friendly-name="Invoice No">
       </div>
      </div>
     </div> 
<!--       <div class="col-xs-12 col-sm-3  pull-left width_17 padding-left-0 padding-right-0">
  <div class="dataTables_filter">
   <label>
    <span class="input-group-addon input-sm">
     <i class="glyphicon glyphicon-search"></i>
    </span>
    <input type="search" data-st-search="" class="form-control input-sm" placeholder="Search">
   </label>
  </div>
 </div> -->
    </div>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" type="submit" ng-click="getSearchList(invoiceDraft)" 	>
        <i class="fa fa-search"></i>
        Search
       </button>
       
       
      </div>
     </div>
    </div>
		<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
 
<%--    <%@include file="/views/templates/panel-header.jsp"%>
 --%>
  <div class="panel-body float-left padding-10" style="width:100%">
   <div class="table-responsive" style=" border: 1px solid yellow;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head" style="background-color: yellow;">
      <tr>
<!--        <th class="width_1"> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
<!--        </th> -->
       <th class=" width_20">Voucher No</th>
       <th class=" width_20" >Party Name</th>
        <th class=" width_20">Invoice No</th>
         <th class=" width_20" >Amount</th>
          <th class=" width_20">Amount(USD)</th>
          <th class=" width_20" >Invoice Amount</th>
           <th class=" width_20" >Alloted Date</th>
                  <th class=" width_20" >Alloted By</th>
       

      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">

       <td>{{objTranslationItem.voucherNo}}</td>
              <td>{{objTranslationItem.partyName}}</td>
       
              <td>{{objTranslationItem.invoiceNo}}</td>
       
              <td>{{objTranslationItem.localAmount}}</td>
       
              <td>{{objTranslationItem.usdAmount}}</td>
       
              <td>{{objTranslationItem.invoiceAmount}}</td>
              <td>{{objTranslationItem.allotedDate}}</td>
                     <td>{{objTranslationItem.allotedBy}}</td>
       
      
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer" style="padding:0px;">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div>
    </div>
    