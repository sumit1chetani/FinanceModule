<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body float-left padding-10">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1"></th>
       <th class="sorting" st-sort="jvNumber">JV Draft Number</th>
       <th class="sorting" st-sort="voucherDate">Date</th>
       <th class="sorting" st-sort="narration">Narration</th>
       <th class="">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
       <td cs-select="objTranslationItem"></td>
<!--        <td>{{objTranslationItem.jvNumber}}</td> -->
<!--        <td>  <span ng-if="objTranslationItem.urIsView=='t'"><a ng-click="view(objTranslationItem.jvNumber)"> 
		             <span tooltip="{{objTranslationItem.jvNumber}}" class="tool-tip-span font-blue">{{objTranslationItem.jvNumber}}</span>
		         </a></span>
		      <span ng-if="objTranslationItem.urIsView=='f'">
		      <span tooltip="{{objTranslationItem.jvNumber}}" class="tool-tip-span">{{objTranslationItem.jvNumber}}</span>
		      </span>   
		         
		         
       </td> -->
         <td>{{objTranslationItem.jvDraftNumber}}</td>
       <td>{{objTranslationItem.dataOfIssue}}</td>
       <td>
        <span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.narration}}</span>
       </td>
       <td class="td-actions text-center">
       
        <i class="fa  fa-pencil text-success text" data-ng-click="editedJournalVoucherTemp(objTranslationItem.jvDraftNumber,$index)"></i>
    
        <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objTranslationItem.jvDraftNumber,$index)" ></i>

       </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
</div>

<script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
 <div class="col-lg-12">
  <div class="col-lg-12">
   <!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
   <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadPIFile(this)"  accept=".xls,.xlsx,.xlsm" />
  </div>
 </div> 
</div>
<div class="modal-footer">
<a href="assets/docs/JOURNAL_VOUCHER_UPLOAD.xlsx" class="control-label">Download sample excel file</a>
 <button class="btn btn-info" type="button" ng-click="uploadPIStatement()">OK</button>
 <button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>