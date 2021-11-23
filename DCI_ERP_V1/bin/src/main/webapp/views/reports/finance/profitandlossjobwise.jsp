<style>
.table-padding-cls>tbody>tr>td{
 padding: 5px 10px !important;
}
</style>
<%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
<security:authentication var="user" property="principal" />
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form class="form-horizontal" novalidate name="profitLossForm">

    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label">Mode <span style="color: red;">*</span></label>
        <div class="col-md-8">
                      <select form-name="profitLossForm" friendly-name="Mode"  id="customerType" multiple="multiple" 
                       name="customerType" ng-model="joborder.lCustomerType" validation="required"
      ng-options="option.id for option in customerTypelist" data-dropdownmultiselect>    
        <option data-ng-repeat="option in customerTypelist" value="{{getCustomerTypeId(option)}}" data-ng-bind-template="{{option.customerType}}"></option>
     </select>  
        </div>
       </div>
         
      <!--    <div class="form-group">
        <label class="col-md-4 control-label">AOL</label>
        <div class="col-md-7">
        
                  <select id="pol" multiple="multiple"  name="pol" ng-model="joborder.lpol"
      ng-options="option.text for option in polList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in polList" value="{{getpolId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
    </div>
         </div> -->
              
       
       
          <!--  <div class="form-group">
        <label class="col-md-4 control-label">AOD</label>
        <div class="col-md-7">
        
            <select id="pod" multiple="multiple"  name="pod" ng-model="joborder.lpod"
      ng-options="option.text for option in podList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in podList" value="{{getpodId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  

        </div>
       </div> -->
        	<div class="form-group">
        <label class="col-md-4 control-label">Status <span style="color: red;">*</span></label>
        <div class="col-md-8">
        <selectivity list="jobStatusList"
                    	property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus"  id="jobStatus"
											friendly-name="job Status" form-name="jobOrderForm"></selectivity>
        </div>
       </div>
                  
      </fieldset>
        </div>

     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
		<div class="form-group">
        <label class="col-md-4 control-label">Branch</label>
        <div class="col-md-8">
               <select id="branch" multiple="multiple"  name="branch" ng-model="joborder.lbranch"
      ng-options="option.text for option in branchList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in branchList" value="{{getbranchId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
          
        </div>
       </div>
      
    	<div class="form-group">
        <label class="col-md-4 control-label">Service</label>
        <div class="col-md-8">
               <select id="service" multiple="multiple"  name="service" ng-model="joborder.lservice"
      ng-options="option.text for option in servicePartnerTypelist" data-dropdownmultiselect>    
        <option data-ng-repeat="option in servicePartnerTypelist" value="{{getserviceId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
     
     
<!--      		<div class="form-group ">
								<label class="col-md-5 control-label">Service <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="servicePartnerTypelist"
										property="quotation.service" id="service"
										name="service" ng-model="quotation.service"
										object="quotationType" friendly-name="service"
										validation="required" form-name="quotationForm"
										></selectivity>
										
								</div>
								</div> -->
             <!--     <select id="pod" multiple="multiple"  name="pod" ng-model="revenueregister.lpod"
      ng-options="option.portCode for option in podList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in podList" value="{{getpodId(option)}}" data-ng-bind-template="{{option.pod}}"></option>
     </select>   -->
        </div>
       </div>
       <!-- <div class="form-group">
        <label class="col-md-4 control-label">POD</label>
        <div class="col-md-8">
        
            <select id="aod" multiple="multiple"  name="pod" ng-model="joborder.laod"
      ng-options="option.text for option in aodList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in aodList" value="{{getaodId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  

        </div>
       </div> -->
       
      <!--  <div class="form-group">
        <label class="col-md-4 control-label">POL</label>
        <div class="col-md-8">
        
                  <select id="aol" multiple="multiple"  name="aol" ng-model="joborder.laol"
      ng-options="option.text for option in aolList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in aolList" value="{{getaolId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
         
        </div>
         </div> -->
       
       
      </fieldset>
     </div>

     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
      
      <!-- <div class="form-group">
        <label class="col-md-4 control-label">CUSTOMER</label>
        <div class="col-md-8">
        
            <select id="payer" multiple="multiple"  name="payer" ng-model="freightmanifest.lpayer"
      ng-options="option.text for option in payerList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in payerList" value="{{getpayer(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  

        </div>
       </div> -->
       
       
      <!--  <div class="form-group">
        <label class="col-md-4 control-label">CUSTOMER</label>
        <div class="col-md-8">
        
       <select id="customer" multiple="multiple"  name="customer" ng-model="freightmanifest.lcustomer"
      ng-options="option.text for option in customerList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in customerList" value="{{getcustomer(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  
        </div>
       </div> -->
		
		
		<div class="form-group"> </label>
		        <label class="col-md-4 control-label">From Date <span style="color: red;">*</span></label>
		
        <div class="col-md-8">
          <ng-bs3-datepicker data-ng-model="joborder.fromDate" name="fromDate" id="fromDate" friendly-name="From Date" form-name="profitLossForm"  validation="required"/>
      <label class="control-label text-left"  id="fromDate" name="fromDate" data-ng-model="joborder.fromDate">{{joborder.fromDate}}</label>
        </div>
       </div>
       
		         
          <div class="form-group">
        <label class="col-md-4 control-label">To Date <span style="color: red;">*</span></label>
        <div class="col-md-8">
          <ng-bs3-datepicker data-ng-model="joborder.toDate" friendly-name="To Date" name="toDate" id="toDate" validation="required" form-name="profitLossForm" />
      <label class="control-label text-left"  id="toDate" name="toDate" data-ng-model="joborder.toDate">{{joborder.toDate}}</label>
        </div>
       </div> 
         
    	<!-- <div class="form-group">
        <label class="col-md-4 control-label">Sales Type</label>
        <div class="col-md-8">
               <select id="sales" multiple="multiple"  name="sales" ng-model="joborder.lsales"
      ng-options="option.text for option in salesTypeList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in salesTypeList" value="{{getsalesId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
                 
        </div>
       </div>  -->

							
							
							
       
       
       	<!-- <div class="form-group">
        <label class="col-md-4 control-label">Terms</label>
        <div class="col-md-8">
               <select id="term" multiple="multiple"  name="term" ng-model="joborder.lterm"
      ng-options="option.text for option in TermList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in TermList" value="{{gettermId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
                 <select id="pod" multiple="multiple"  name="pod" ng-model="revenueregister.lpod"
      ng-options="option.portCode for option in podList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in podList" value="{{getpodId(option)}}" data-ng-bind-template="{{option.pod}}"></option>
     </select>  
        </div>
       </div> -->
    
            
      </fieldset>
     </div>   
    </div>
  <div>
   <header id="btntoggle" data-role="heading" class="btn btn-default col-sm-12 col-md-12 col-lg-12"  data-ng-click="isCollapsed = !isCollapsed">
    <div class="row"><a style="color: #0a4190;">Report Header</a> </div>
    </header>
  <div  data-role="content" class="form-horizontal panel"  data-collapse="isCollapsed">
   <ul class="dragList row list-unstyled">     
          <li class="col-md-3 col-sm-3 col-lg-3" >
              <div class="row" >
              <label  class="control-label col-md-8" style="width: 63%">SELECT ALL :</label> 
           <div class="col-md-4" style="padding-left: 5px;">
           <label class="i-checks m-b-none checkbox">
            <input type="checkbox"  data-ng-click="selectAll(selectall)" 
          data-ng-model="selectall" /><i style="margin-left: -12px;" ></i> 
            </label>
           </div>
           </div>
         </li>
          <li data-ng-repeat="column in messageHeaderList" 
          class="col-sm-3 col-md-3 col-lg-3">
         <div  class="row" data-ng-drag="column.isDraggable" data-ng-drop="column.isDraggable" data-ng-drop-success="onDropComplete($index, $data,$event)" 
         data-ng-drag-data="column" style="width: 100%">
         <label  class="control-label col-md-8">{{column.title}} :</label> 
         <div class="col-md-4">
         <label class="i-checks m-b-none checkbox">
         <input type="checkbox"  data-ng-click="getSelectedColumn(column)" 
          data-ng-model="column.visible"  data-ng-disabled="column.isDefault"/><i></i>
          </label>
         </div>
         </div>
        </li>
        <li class="col-md-3 col-sm-3 col-lg-3 last-child" data-ng-drop="true" 
            data-ng-drop-success="onDropComplete($index, $data,$event)" >
              <div class="row" >
           <div class="col-md-4">
           <label class="i-checks m-b-none checkbox">
            </label>
           </div>
           </div>
         </li>
        </ul>
   </div>
  </div>
  
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12 " >
         <div class="col-md-3" style="margin-left: -7%;" > <label><b>Buying Cost:</b>
								</label>     {{n2}}</div>
							
								<div class="col-md-2"
								  style=" margin-left: -7%;"> 	
								 <label ><b> Selling Cost:</b>
								 </label>    {{n1}}</div>
								 	
								<div class="col-md-2"
							style=" margin-left: -4%;" > 	
								 <label ><b> Profit:</b>
								 </label>    {{n3}}</div>
						<div class="col-md-2"
							style=" margin-left: -4%;" > 	
								 <label ><b> Profit(USD):</b>
								 </label>    {{n4}}</div>
        <button class="btn btn-success" type="submit" tooltip="Search"
         ng-click="onSearch(joborder,profitLossForm)" 
     style="margin-left: -17%;"   >
         <i class="fa fa-search"></i> Submit
        </button>
       <button type="reset" class="btn btn-info" tooltip="Reset"   ng-click="reset()">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button type="button" class="btn btn-success" tooltip="Print"   ng-click="printProfitAndLoss(joborder,profitLossForm)">
        <i class="fa fa-print"></i> Print
       </button>
                 
          
             <button id="exportXl" class="btn btn-primary"
           data-ng-click="exportAsExcel(joborder,profitLossForm)"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button><a id="prfitLosExpId" href="" download=""></a>
                    						
       
      </div>
     </div>
    </div>
   
    
    <div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		
		<div class="panel-body float-left padding-0" style="width:100%;">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer table-padding-cls">
					<thead class="dataTables-Main-Head">
						<tr>
							 <th class="width_6"  data-ng-repeat ="column in messageHeaderList" 
            data-ng-class={hide:(!column.visible)}>{{column.title}}</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body"  >
        <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="joborder in displayedCollection">
         <td class="width_6 padding-number-align text-left "   data-ng-repeat ="column in messageHeaderList" 
            data-ng-class={hide:(!column.visible)}>
            <span>{{joborder[column.id]}}</span>
            
            </td>
            </tr>
            </tbody> 
				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
	
	<div id="printableTableId" class="col-md-12" style="display: none;">
	
	<div class="col-md-12">
	<div class="col-md-3" style="width:30%;float: left;">
	<img src="/img/${user.tenantId}HelpVideos/logo.jpg"
								style="padding: 10 0 0 10; height: 60px;">
	</div>
	<div class="col-md-9" style="width: 55%;float: left;text-align: center;">
	<h4>Profit and Loss</h4>
	</div>
	</div>
	
	<div  class="panel panel-default panel-default-list" style="width: 100%;float: left;padding-top: 10px;"
		st-table="displayedCollection1" st-safe-src="printRowCollection">
		
		<div class="panel-body float-left padding-0" style="width:100%;">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer table-padding-cls" style="width: 100%; float: left;">
					<thead class="dataTables-Main-Head">
						<tr>
							 <th class="width_6"  data-ng-repeat ="column in printMessageHeaderList" 
            data-ng-class={hide:(!column.visible)}>{{column.title}}</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body"  >
        <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="joborder in displayedCollection1">
         <td class="width_6 padding-number-align text-left " style="padding: 0px 0px !important;border-top: 1px solid #000;"  data-ng-repeat ="column in printMessageHeaderList" 
            data-ng-class={hide:(!column.visible)}>
            <span>{{joborder[column.id]}}</span>
            
            </td>
            </tr>
            </tbody> 
				</table>
			</div>
		</div>
	</div>
	
	</div>
    
    
   </form>
  </div>
 </div>
</div>

