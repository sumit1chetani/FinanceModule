<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  	<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body" style="height: 230px;">
        <form class="form-horizontal" name="BankBookForm">
          <div class="row">
          <div class="col-sm-12 col-md-12 col-lg-12">
             <div class="col-sm-4 col-md-4 col-lg-4">
       <fieldset>
       	<div class="form-group">
	         <label class="col-md-5 control-label"> Company <span style="color: red;">*</span></label>
        	<div class="col-md-7">          
          		
          							<selectivity list="companyList"
											property="BankBook.companyCode" id="companyCode" ng-model="BankBook.companyCode" 
											object="companyCode"></selectivity>
          		
          		
          		<!-- <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="BankBook.objCompanyCodes"
				 ng-options="option.text for option in companyList" data-dropdownmultiselect>    
				   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
				   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
				</select> -->
        	</div>
        </div>
        <div class="form-group">
         <label class="col-md-5 control-label"> Bank Account Code<span style="color: red;">*</span>
         </label>
         <div class="col-md-7">          
          <selectivity  list="accountList" property="BankBook.accountCode" ng-model="BankBook.accountCode" 
          name="accountCode" form-name="BankBook" friendly-name="Account Code" id="accountCode"></selectivity>
        </div>
        </div>
       </fieldset>
      </div>
       <div class="col-sm-4 col-md-4 col-lg-4">
       <fieldset>
        <div class="form-group">
          <label for="inputPassword" class="control-label col-md-5">From Date
          <span style="color: red;">*</span></label>
          	<!-- <ng-bs3-datepicker data-ng-model="BankBook.fromDate" name="fromDate" id="fromDate"/> -->
          	<div class="input-group input-append date" id="bb_fromDate">
          		<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
          									ng-model="BankBook.fromDate" name="fromDate" id="fromDate">
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
                                  <!-- <ng-bs3-datepicker data-ng-model="BankBook.toDate" name="toDate" id="toDate"/> -->
               <div class="input-group input-append date" id="bb_toDate">
          		<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
          									ng-model="BankBook.toDate" name="toDate" id="toDate">
			 	<span class="input-group-addon add-on">
     				<span class="glyphicon glyphicon-calendar"></span>
				</span>
  			  </div>
          </div>
        </div>
       </fieldset>
      </div>
      
      <div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label  class="control-label col-md-5">Voucher No<span style="color: red;"></span>
									</label>
									<div class="col-md-5" style="padding-left: 3px;">
									<input type="text" class="form-control input-sm" 
										 form-name="BankBook"
										 ng-model="BankBook.transactionNo"
										name="trasactionNo" />
								</div>
								</div>
							</fieldset>
						</div>
						
					<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label  class="control-label col-md-5">Narration<span style="color: red;"></span>
									</label>
									<div class="col-md-5">
									<input type="text" class="form-control input-sm" 
										form-name="BankBook"
										ng-model="BankBook.narration"
										name="Narration" />
								</div>
								</div>
							</fieldset>
						</div>
      
     </div>    
          </div>
          <a id="BBExport" stype="display:none" href="filePath/bankBook.xls" download="bankBook.xls"></a>
          <div class="form-actions">
           <div class="row">
            <div class="col-md-12 ">
            <security:authorize access="hasRole('${form_code}_${view}')">
             <button  type="button" class="btn btn-success" ng-click="getBankReport(BankBook)">
              <i class="fa fa-search"></i>View Report
             </button>
             </security:authorize>
              <security:authorize access="hasRole('${form_code}_${export}')">
              <button class="btn btn-primary" ng-click="exportBankBook(BankBook)" type="button">
              <i class="fa fa-search"></i>Excel Export
             </button>
             </security:authorize>
             
             <!-- <button class="btn btn-info" type="reset" class="btn btn-success">
              <i class="fa fa-undo"></i>Reset
             </button> -->
            </div>
           </div>
          </div>
         <div class="row">
           <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid">
      <table id="BankBookMainGrid"></table>
                      <div id="BankBookPage"></div>
     </div> 
         </div>
      </form>
     </div> <!-- /panel-body -->
 </div> <!-- /panel-default -->
   </div> <!-- /wrapper-md -->
   


