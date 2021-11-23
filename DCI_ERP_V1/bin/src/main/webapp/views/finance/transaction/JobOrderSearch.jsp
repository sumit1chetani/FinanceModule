<%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form class="form-horizontal" novalidate name="deliveryorderform">

    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label">Mode <span style="color: red;">*</span></label>
        <div class="col-md-8">
                      <select id="customerType" multiple="multiple"  name="customerType" ng-model="joborder.lCustomerType" validatin="required"
      ng-options="option.id for option in customerTypelist" data-dropdownmultiselect>    
        <option data-ng-repeat="option in customerTypelist" value="{{getCustomerTypeId(option)}}" data-ng-bind-template="{{option.customerType}}"></option>
     </select>  
        </div>
       </div>
         
         <div class="form-group">
        <label class="col-md-4 control-label">AOL</label>
        <div class="col-md-7">
        
                  <select id="pol" multiple="multiple"  name="pol" ng-model="joborder.lpol"
      ng-options="option.text for option in polList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in polList" value="{{getpolId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
    </div>
         </div>
              
       
       
           <div class="form-group">
        <label class="col-md-4 control-label">AOD</label>
        <div class="col-md-7">
        
            <select id="pod" multiple="multiple"  name="pod" ng-model="joborder.lpod"
      ng-options="option.text for option in podList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in podList" value="{{getpodId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  

        </div>
       </div>
        	<div class="form-group">
        <label class="col-md-4 control-label">Status</label>
        <div class="col-md-8">
               <select id="status" multiple="multiple"  name="status" ng-model="joborder.lstatus"
      ng-options="option.text for option in statusList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in statusList" value="{{getstatusId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
             <!--     <select id="pod" multiple="multiple"  name="pod" ng-model="revenueregister.lpod"
      ng-options="option.portCode for option in podList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in podList" value="{{getpodId(option)}}" data-ng-bind-template="{{option.pod}}"></option>
     </select>   -->
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
       <div class="form-group">
        <label class="col-md-4 control-label">POD</label>
        <div class="col-md-8">
        
            <select id="aod" multiple="multiple"  name="pod" ng-model="joborder.laod"
      ng-options="option.text for option in aodList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in aodList" value="{{getaodId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  

        </div>
       </div>
       
       <div class="form-group">
        <label class="col-md-4 control-label">POL</label>
        <div class="col-md-8">
        
                  <select id="aol" multiple="multiple"  name="aol" ng-model="joborder.laol"
      ng-options="option.text for option in aolList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in aolList" value="{{getaolId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
         
        </div>
         </div>
       
       
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
          <ng-bs3-datepicker data-ng-model="joborder.fromDate" name="fromDate" id="fromDate"  validation="required"/>
      <label class="control-label text-left"  id="fromDate" name="fromDate" data-ng-model="joborder.fromDate">{{joborder.fromDate}}</label>
        </div>
       </div>
       
		         
          <div class="form-group">
        <label class="col-md-4 control-label">To Date <span style="color: red;">*</span></label>
        <div class="col-md-8">
          <ng-bs3-datepicker data-ng-model="joborder.toDate" name="toDate" id="toDate" validation="required" />
      <label class="control-label text-left"  id="toDate" name="toDate" data-ng-model="joborder.toDate">{{joborder.toDate}}</label>
        </div>
       </div> 
         
    	<div class="form-group">
        <label class="col-md-4 control-label">Sales Type</label>
        <div class="col-md-8">
               <select id="sales" multiple="multiple"  name="sales" ng-model="joborder.lsales"
      ng-options="option.text for option in salesTypeList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in salesTypeList" value="{{getsalesId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
                 
        </div>
       </div> 

							
							
							
       
       
       	<div class="form-group">
        <label class="col-md-4 control-label">Terms</label>
        <div class="col-md-8">
               <select id="term" multiple="multiple"  name="term" ng-model="joborder.lterm"
      ng-options="option.text for option in TermList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in TermList" value="{{gettermId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
             <!--     <select id="pod" multiple="multiple"  name="pod" ng-model="revenueregister.lpod"
      ng-options="option.portCode for option in podList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in podList" value="{{getpodId(option)}}" data-ng-bind-template="{{option.pod}}"></option>
     </select>   -->
        </div>
       </div>
    
            
      </fieldset>
     </div>   
    </div>
  <div>
   <header id="btntoggle" data-role="heading" class="btn btn-default col-sm-12 col-md-12 col-lg-12"  data-ng-click="isCollapsed = !isCollapsed">
    <div class="row"><a>Report Header</a> </div>
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
      <div class="col-md-12 ">
        <button class="btn btn-success" type="button" tooltip="Search"
         ng-click="onSearch(joborder)">
         <i class="fa fa-search"></i> Submit
        </button>
       <button type="reset" class="btn btn-info" tooltip="Reset"  type="button" ng-click="reset()">
        <i class="fa fa-undo"></i> Reset
       </button>
                <security:authorize access="hasRole('${form_code}_${export}')">
          
             <button id="exportXl" class="btn btn-primary"
           data-ng-click="excel(joborder);"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
                    						</security:authorize>
       
      </div>
     </div>
    </div>
    
    
    <div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		
		<div class="panel-body float-left padding-0" style="width:100%;">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							 <th class="width_6"  data-ng-repeat ="column in messageHeaderList" 
            data-ng-class={hide:(!column.visible)}>{{column.title}}</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body"  >
        <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="joborder in displayedCollection">
         <td class="width_6 padding-number-align text-center "   data-ng-repeat ="column in messageHeaderList" 
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
    
    
   </form>
  </div>
 </div>
</div>
