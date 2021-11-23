<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
			<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
	       <form class="form-horizontal" name="cashBankForm">
		        <div class="row">
		    	   <div class="col-sm-12 col-md-12 col-lg-12">
			         	<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
							         <label class="col-md-5 control-label"> Company <span style="color: red;">*</span></label>
						        	<div class="col-md-7">       
						        		<selectivity list="companyList" property="JournalBook.companyCode" id="companyCode" object="companyCode"></selectivity>   
						          		<!-- <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="JournalBook.objCompanyCodes"
										 ng-options="option.text for option in companyList" data-dropdownmultiselect>    
										   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
										   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
										</select> -->
						        	</div>
						        </div>
							</fieldset>
					</div>
					        	 <div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
						          <label for="inputPassword" class="control-label col-md-5">From Date
						          <span style="color: red;">*</span></label>
						          	<div class="input-group input-append date" id="cb_fromDate">
						          		<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
						          									ng-model="JournalBook.fromDate" name="fromDate" id="fromDate">
									 	<span class="input-group-addon add-on">
						     				<span class="glyphicon glyphicon-calendar"></span>
										</span>
						  			  </div>
						        </div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
						          <label for="inputPassword" class="control-label col-md-5">To Date
						          <span style="color: red;">*</span></label>
						          <div class="col-md-7">
						                             
						               <div class="input-group input-append date" id="cb_toDate">
						          		<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
						          									ng-model="JournalBook.toDate" name="toDate" id="toDate">
									 	<span class="input-group-addon add-on">
						     				<span class="glyphicon glyphicon-calendar"></span>
										</span>
						  			  </div>
						          </div>
						        </div>
							</fieldset>
						</div>
			        	
					</div>				
	        	</div>
	        	<br><br>
	        	<a id="CBExport" stype="display:none" href="filePath/JournalBookxls" download="JournalBook.xls"></a>
		        <div class="form-actions">
		         <div class="row">
		          <div class="col-md-12 ">
		           <security:authorize access="hasRole('${form_code}_${view}')">
		           <button  type="button" class="btn btn-success" ng-click="getCashReport(JournalBook)">
		            <i class="fa fa-search"></i>View Report
		           </button>
		           </security:authorize>
		           <security:authorize access="hasRole('${form_code}_${export}')">
		              <button id="exportXl" type="button" class="btn btn-primary " ng-click="excel()">Export To Excel</button>
		              </security:authorize>
		           <%-- <security:authorize access="hasRole('${form_code}_${export}')">
                   <button id="exportXl" type="submit" class="btn btn-primary " ng-click="excel()">Export To Excel</button>
                        </security:authorize>
		   --%>
		          </div>
		         </div>
		        </div>
		       <div class="row">
		       		<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid">
						<table id="JournalMainGrid"></table>
                      <div id="JournalBookPage"></div>
					</div>	
		       </div>
	    	</form>
	    </div> <!-- /panel-body -->
	</div> <!-- /panel-default -->
   </div> <!-- /wrapper-md -->
   


