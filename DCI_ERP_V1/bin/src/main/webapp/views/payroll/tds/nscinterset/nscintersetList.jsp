 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 <!-- #MAIN CONTENT -->
 
<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
   <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">   
     
         <form class="form-horizontal" name="nscIntersetForm" role="form" ng-submit="#" novalidate method="post">
         <div class="row">
         
		
		<div class="col-md-12  panel-body">
			<div class="col-md-4" >
       		<label class="col-md-4 control-label">Financial Year <spring:message	code="label.asterisk.symbol"></spring:message></label>
			<div class="col-md-6" >
			<selectivity list="financialYearList" ng-model="nscinterest.financialYear" ng-if="!nscinterest.isEdit" name="Financial Year"
			property="nscinterest.financialYear" form-name = "nscIntersetForm" validation ="required" friendly-name="Financial Year">
			</selectivity>
			<selectivity list="financialYearList" ng-model="nscinterest.financialYear" ng-if="nscinterest.isEdit" name="Financial Year"
			property="nscinterest.financialYear" form-name = "nscIntersetForm" validation ="required" friendly-name="Financial Year" disabled>
			</selectivity>
			</div>
			</div>
			<div class="col-md-4">
       		<label class="col-md-4 control-label">Interest Rate <spring:message	code="label.asterisk.symbol"></spring:message></label>
       		
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm text-right" ng-model="nscinterest.rateOfInterest" ng-pattern-restrict="^[0-9.]*$"
			  name="Interest Rate" validation ="required" friendly-name="Interest Rate" />
		</div>
		</div>
		<div class="col-md-4">
		
		<div class="col-md-4">
			<button class="btn btn-success" type="button" data-ng-if="!nscinterest.isEdit"
												data-ng-click="submit(nscIntersetForm)">
												<i class="fa fa-save"></i> Save
			</button>
			
			<button class="btn btn-success" type="button" data-ng-if="nscinterest.isEdit"
												data-ng-click="update(nscIntersetForm)">
												<i class="fa fa-save"></i> Update
			</button>
		</div>
		</div>
        </div>
       <div class="col-lg-12">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
        
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1"></th> -->
           <th class="sorting width_15" st-sort="financialYear">Financial Year</th>
           <th class="sorting width_15" st-sort="rateOfInterest">Rate Of Interest</th>
          <th class="sorting width_5" st-sort="">Action</th>
          </tr>
         </thead>
          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="slabRateCollection in displayedCollection">
           <!-- <td cs-select="objVesselMasterItem"></td> -->
			<td>{{slabRateCollection.financialYear}}</td>
			<td>{{slabRateCollection.rateOfInterest}}</td>
			
		 <td class=" td-actions text-center">
        <span>
         <security:authorize access="hasRole('${form_code}_${modify}')">   
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(slabRateCollection.financialYear)"></i>
         </security:authorize>
        </span>
        <span>
        <!--  <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(nscinterest.financialYear)"></i> -->
        </span>
       </td>
          </tr>
         </tbody>
       	
        </table>
      
       </div>
</div>
       <%--    <div class="col-md-12 col-md-offset-5" style ="margin-top:10px">
          
           
           <button class="btn btn-success" type="button"
												data-ng-click="save(gradeTypeList,leaveDeclareObj)" data-ng-if="!leaveDeclareObj.isEdit">
												<i class="fa fa-save"></i> <spring:message code="label.edit"></spring:message>
											</button>
             <button class="btn btn-success" type="button"
												 data-ng-click="update();"
												data-ng-if="leaveDeclareObj.isEdit">
												<i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
											</button>
           <button class="btn btn-info ng-scope" type="submit" class="btn btn-success">
			<i class="fa fa-undo"></i>
    		 <spring:message code="label.reset"></spring:message>
			</button>
           
          </div> --%>
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
