<!-- #MAIN CONTENT -->
<style>
#emp > selectivity > div.selectivity-dropdown{
    min-width: 148px;
    left: 13px;
    top: 30px;
    width: 50% !important;
}

</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>Add Employee Award Or Reward </h2>
     </header> 
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="empAwardRewardForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <div class="form-group">
            <label class="col-md-6 control-label"> Organization Name
            <%-- <spring:message code="label.companyName"></spring:message> --%>
            </label>
            <div class="col-md-6">
<!--             <selectivity list="hospitalList" property="empAwardReward.hosId" id="hospital" -->
<!--              ng-model="empAwardReward.hosId" name="hospital" form-name = "empAwardRewardForm" -->
<!--              validation="required" friendly-name="Hospital"></selectivity> -->
<!--              <select class="form-control" name="HospName" -->
<!--               ng-model="empAwardReward.hosId" ng-disabled="isEdit"  -->
<!--               ng-options="h.hosId as h.hospital for h in hospitalList" validation="required"  -->
<!--               friendly-name="Hospital Name" ng-change="branchLists(empAwardReward.hosId)"> -->
<!--               <option value="">select</option>
             </select> -->
             <input type="text" class="form-control input-sm" name="Company name" validation="required" 
             friendly-name="Organization Name" ng-model="empAwardReward.hospital" ng-disabled=true>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label">
            <spring:message code="label.branch"></spring:message>
            </label>
            <div class="col-md-6">
           <!--   <select class="form-control" name="Branch"
              ng-model="empAwardReward.branchId" ng-disabled="isEdit" 
              ng-options="b.branchId as b.branch for b in branchList" validation="required" 
              friendly-name="Branch" ng-change="employList(empAwardReward.branchId)">
              <option value="">select</option>
             </select> -->
             
          <selectivity list="branchList" ng-model="empAwardReward.branchId" data-ng-if="isEdit != true"
			property="empAwardReward.branchId" name="branchId"
			 validation="required" friendly-name="Branch" form-name = "empAwardRewardForm"></selectivity> 
			           
          <selectivity list="branchList" ng-model="empAwardReward.branchId" data-ng-if="isEdit == true"
			property="empAwardReward.branchId" name="branchId"
			 validation="required" friendly-name="Branch" form-name = "empAwardRewardForm" disabled="true"></selectivity> 
			        								
             
<!--              <input type="text" class="form-control input-sm" name="branch" -->
<!--               ng-model="empAwardReward.branch"> -->
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label">
            <spring:message code="label.employee"></spring:message> 
            </span><spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-6" id="emp">
            <!--  <select class="form-control" name="empId" ng-model="empAwardReward.empId" ng-disabled="isEdit" 
              ng-options="emp.empId as emp.empName for emp in employeeList" 
              validation="required" friendly-name="Employee Name">
              <option value="">select</option>
             </select> -->
                      <selectivity list="employeeList" ng-model="empAwardReward.empId"  data-ng-if="isEdit != true"
			property="empAwardReward.empId" name="empId"
			 validation="required" friendly-name="Employee Name" form-name = "empAwardRewardForm"></selectivity> 
			        								
                <selectivity list="employeeList" ng-model="empAwardReward.empId" data-ng-if="isEdit == true"
			property="empAwardReward.empId" name="empId"
			 validation="required" friendly-name="Employee Name" form-name = "empAwardRewardForm" disabled="true"></selectivity> 
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label">
            <spring:message code="label.award.or.reward"></spring:message>
            <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-6">
           <!--   <select class="form-control" name="awardReward" ng-model="empAwardReward.awardReward"
              ng-options="emp.awardId as emp.awardReward for emp in awardList" 
              validation="required" friendly-name="Award or Reward">             
              <option value="">select</option>
             </select> -->
      <selectivity list="awardList" ng-model="empAwardReward.awardReward" 
			property="empAwardReward.awardReward" id="awardReward"   name="awardReward"
			 validation="required" friendly-name="Award or Reward" form-name = "empAwardRewardForm"></selectivity> 
             
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label">
            <spring:message code="label.conferred.on"></spring:message>
            <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-6">
			 <div class='input-group date datetimepick col-md-12'>
				<div class="dropdown">
				 <a class="dropdown-toggle" id="date" role="button"
					data-toggle="dropdown" data-target="#" href="#">
					<div class="input-group">
					<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Date" 
					validation="date_euro_long|required" friendly-name="Conferred On"
					data-ng-model="empAwardReward.date"><span
					class="input-group-addon"><i
					class="glyphicon glyphicon-calendar"></i></span>
					</div>
				</a>
				<ul class="dropdown-menu" role="menu"
				aria-labelledby="dLabel">
				<datetimepicker data-ng-model="empAwardReward.date" 
                data-on-set-time="empAwardReward.date = onDateSet(newDate)"
				data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
				</ul>
			 </div>
			</div>
			</div>
           </div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button" class="btn btn-success"
            data-ng-click="save(empAwardReward,empAwardRewardForm)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button" class="btn btn-success"
            data-ng-click="update(empAwardReward,empAwardRewardForm);" data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button" ng-click="reset(empAwardRewardForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="button" class="btn btn-success"
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