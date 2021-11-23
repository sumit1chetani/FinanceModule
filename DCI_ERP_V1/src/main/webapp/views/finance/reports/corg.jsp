<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="corgForm" role="form">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						
						<div class="col-sm-4 col-md-4 col-lg-6">
							<div class="form-group">
								<label class="col-md-4 control-label"> Company Location
								<!-- 	<span style="color: red;">*</span> -->
								</label>
								<div class="col-md-6">
                                    <selectivity  list="companyList" property="corgReport.companyCode" id="companyCode"  object="tempDropDownObj"></selectivity>
																	
								</div>
								</div>
						</div>
                      <!--  <div class="col-sm-12 col-md-3 col-lg-3">
                      <fieldset>
                       <div class="form-group">
                        <label for="inputPassword" class="control-label col-md-5">From
                         Date <span style="color: red;">*</span>
                        </label>
                        <div class="col-md-7">
                         <div class="input-group input-append date" id="tb_fromDate">
                          <input type="text" class="form-control input-sm"
                           placeholder="dd/mm/yyyy" ng-model="corgReport.fromDate"
                           name="fromDate" id="fromDate"> <span
                           class="input-group-addon add-on"> <span
                           class="glyphicon glyphicon-calendar"></span>
                          </span>
                         </div>
                        </div>
                       </div>
                      </fieldset>
                     </div>
              
                     <div class="col-sm-12 col-md-3 col-lg-3">
                      <fieldset>
                       <div class="form-group">
                        <label for="inputPassword" class="control-label col-md-5">To
                         Date </label>
                        <div class="col-md-7">
                         <div class="input-group input-append date" id="tb_toDate">
                          <input type="text" class="form-control input-sm"
                           placeholder="dd/mm/yyyy" ng-model="corgReport.toDate"
                           name="toDate" id="toDate"> <span
                           class="input-group-addon add-on"> <span
                           class="glyphicon glyphicon-calendar"></span>
                          </span>
                         </div>
                        </div>
                       </div>
                      </fieldset>
                     </div> -->
      
						
        <div class="col-sm-4 col-md-4 col-lg-6">
                 <div class="form-group">
                   <label class="col-md-3 control-label">
                    Week
                   </label>
                   <div class="col-md-7">
                    <div class="col-md-3 nopadding">
                    	<selectivity list="weekList" property="corgReport.week" id="week"></selectivity>
                     </div>
                     <div class="col-md-8 nopadding">
                      <label class="col-md-2 control-label">
                       Year
                     </label>
                     <div class="col-md-4 col-sm-push-2 nopadding">
                     	<selectivity list="yearList" property="corgReport.year" id="year"></selectivity>
                      </div>
                     </div>
                   </div>
                   <label class="col-md-2 control-label">
                    {{weekEndDate}}
                   </label>
                  </div>
		</div>    
					</div>
				</div>
				<a id="corgExport" stype="display:none"
						href="filePath/CORG.xls"
						download="CORG.xls"></a>
			</form>
				<div class="form-actions">
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
						  <security:authorize access="hasRole('${form_code}_${view}')">
							<button class="btn btn-success" type="submit" ng-click="viewCorgReport()">
	       								<i class="fa fa-search"></i>View
	       					</button>
	       					<button class="btn btn-success" type="submit" ng-click="viewCorgReportAsOnDate()">
	       								<i class="fa fa-search"></i>View As on Date
	       					</button>
	       					</security:authorize>
	       					<button class="btn btn-primary" type="submit" ng-click="exportCorgReport()">
	       								<i class="fa fa-search"></i>Export
	       					</button>
	       					<button class="btn btn-primary" type="submit" ng-click="exportCorgReportAsOnDate()">
	       								<i class="fa fa-search"></i>Export As on Date
	       					</button>
	     					<button class="btn btn-info"  type="reset" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
						</div>
					</div>
				</div> 
				
				<div class="panel-body float-left padding-0">
   <div class="table-responsive" >
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
       <th class="sorting width_9" >Week</th>
       <th class="sorting width_9" >Total Amt</th>
       <th class="sorting width_9">Blw 30 Amt</th>
       <th class="sorting width_9" >Blw 30 %</th>
       <th class="sorting width_9" >30 -45 Amt</th>
       <th class="sorting width_9" >30 - 45 %</th>
       <th class="sorting width_9" >45 - 60 Amt</th>
       <th class="sorting width_9" >45 - 60 %</th>
       <th class="sorting width_9" >Abv 60 Amt</th>
       <th class="sorting width_9" >Abv 60 %</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in rowCollection">
       <td>
         <span tooltip="{{objTranslationItem.week}}" class="tool-tip-span" ng-bind="objTranslationItem.week"></span>
       </td>
        <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.totalAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.totalAmount"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.co30}}" class="tool-tip-span" ng-bind="objTranslationItem.co30"></span>
       </td>
       <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.co30Per}}" class="tool-tip-span" ng-bind="objTranslationItem.co30Per"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.co30to45}}" class="tool-tip-span" ng-bind="objTranslationItem.co30to45"></span>
       </td>
       <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.co30to45Per}}" class="tool-tip-span" ng-bind="objTranslationItem.co30to45Per"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.co45to60}}" class="tool-tip-span" ng-bind="objTranslationItem.co45to60"></span>
       </td>
       <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.co45to60Per}}" class="tool-tip-span" ng-bind="objTranslationItem.co45to60Per"></span>
       </td>
        <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.co60Plus}}" class="tool-tip-span" ng-bind="objTranslationItem.co60Plus"></span>
       </td>
        <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.co60PlusPer}}" class="tool-tip-span" ng-bind="objTranslationItem.co60PlusPer"></span>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
  
 
		</div>
	</div>
</div>
