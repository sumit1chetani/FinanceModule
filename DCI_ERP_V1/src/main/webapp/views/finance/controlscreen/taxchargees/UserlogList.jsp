<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form ">
<%--  <div class="panel panel-default panel-default-form ">
		<%@include file="/views/layout/panel-header-form.jsp"%> --%>
  <div class="panel-body">
   <form name="userLogForm" method="post" class="form-horizontal" novalidate>
   <style>	
   table {width:100%; table-layout: fixed;}
   table td {word-wrap:break-word;}</style>
    <div class="row pl2pc pr10pc">
     <div class="col-md-3">
      <div class="form-group">
       <label class="col-md-5 control-label">From Date</label>
       <div class="col-md-7">
        <ng-bs3-datepicker data-ng-model="userLog.dateFrom" />
       </div>
      </div>
     </div>
     <div class="col-md-3">
      <div class="form-group">
       <label class="col-md-5 control-label">To Date</label>
       <div class="col-md-7">
        <ng-bs3-datepicker data-ng-model="userLog.dateTo" />
       </div>
      </div>
     </div>
     <div class="col-md-3">
      <div class="form-group">
       <label class="col-md-5 control-label">Form Name</label>
       <div class="col-md-7">
        <selectivity list="formCodeList" property="userLog.formCode" data-ng-model="userLog.formCode" form-name="userLogForm"
         friendly-name="form_code"> </selectivity>
       </div>
      </div>
     </div>
     <div class="col-md-3">
      <div class="form-group">
       <label class="col-md-5 control-label">Employee</label>
       <div class="col-md-7">
        <selectivity list="employeeList" property="userLog.employeeId" id="employeeId" data-ng-model="userLog.employeeId" name="employeeId" form-name="userLogForm"
         friendly-name="employeeId"> </selectivity>
       </div>
      </div>
     </div>
<!--       <div class="col-md-3"> -->
<!--       <div class="form-group"> -->
<!--        <label class="col-md-5 control-label">Domain Name</label> -->
<!--        <div class="col-md-7"> -->
<!--         <selectivity list="tableNameList" property="userLog.tableName" id="tableNameId" ng-model="userLog.tableName" name="tableName" form-name="userLogForm" -->
<!--          friendly-name="Table Name"> </selectivity> -->
<!--        </div> -->
<!--       </div> -->
<!--      </div> -->

 <!-- <div class="col-md-3">
      <div class="form-group">
       <label class="col-md-5 control-label">Identifier</label>
       <div class="col-md-7">
        <selectivity list="actionList" property="userLog.actionType"  data-ng-model="userLog.actionType" form-name="userLogForm"
         friendly-name="Table Name"> </selectivity>
       </div>
      </div>
     </div>
    </div>
    </div> -->
     <div class="col-md-3">
      <div class="form-group">
       <label class="col-md-5 control-label">Action</label>
       <div class="col-md-7">
        <selectivity list="actionList" property="userLog.actionType"  data-ng-model="userLog.actionType" form-name="userLogForm"
         friendly-name="Table Name"> </selectivity>
       </div>
<!--       </div> -->
<!--      </div> -->
    </div>
    </div>
    </div>
    
    <div class="form-actions">
	 <div class="row">
		<div class="col-md-12 ">
		<button class="btn btn-success" type="button" ng-click="getUserLogList()">
		  <i class="fa fa-search"></i>
		   Search
		  </button>
		</div>
	</div>
</div>
</form>
   </div>
   </div>
   <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  
<div class="panel-heading panel-heading-list padding-right-0 padding-left-0" >
	 <div class="row  m-n">
	  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold" >
	   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>	   
	  </div>
	  <div class="col-md-6 text-right padding-right-0">
	   <div class="row">
	    <div class="col-md-6 p-r-3">
	     <%-- <security:authorize access="hasRole('${form_code}_${add}')"> --%>
	     <!--  <button class="btn btn-sm btn-success"   id="btnStartStopWizard" value="Start Wizard" style="width:35mm" onClick="WizardScriptControl('START_STOP')">Sign
	     
	     </button> -->
	    </div>
	    <div class="col-md-6">
	     <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
	    </div>
	   </div>
	  </div>
	 </div>
	</div>
	<div class="panel-body float-left padding-0" style="width: 100%">
  <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table class="table table-striped table-hover dataTable no-footer" style="border: 0px solid Red">
     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
      <tr>
       <th class="sorting width_10" st-sort="employeeId">Employee</th>
       <th class="sorting width_10" st-sort="formCode">Form Name</th>
        <th class="sorting width_10" st-sort="identifier">Identifier</th>
       <th class="sorting width_10" st-sort="actionType">Action</th>
       <th class="sorting width_10" st-sort="logDescription">Description</th>
       <th class="sorting width_10" st-sort="logdate">Date Time</th>
       <th class="sorting width_10" st-sort="userIpAddress">IP</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="userLogItem in displayedCollection">
       <td>{{userLogItem.employeeName}}</td>
       <td>{{userLogItem.formName}}</td>
        <td>{{userLogItem.primaryDataId}}</td>
       <td>{{userLogItem.actionType}}</td>
       <td>{{userLogItem.logDescription}}</td>
       <td>{{userLogItem.logdate}}</td>
       <td>{{userLogItem.userIpAddress}}</td>
      </tr>
     </tbody>
    </table>
    <footer class="panel-footer" style="padding:0px;">
     <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
    <br/>
  </div>
  <!-- /panel-body -->
  <!-- wrapper-md -->
 </div>
 <!-- Panel Body close -->
</div>
</div>