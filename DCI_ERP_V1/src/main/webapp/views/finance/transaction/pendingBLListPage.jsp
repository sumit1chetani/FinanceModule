<%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form class="form-horizontal" novalidate name="freightmanifestform">

    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label">Mode<span style="color: red;">*</span></label>
        <div class="col-md-8">
                      <select  required id="customerType" multiple="multiple"  name="customerType" ng-model="freightmanifest.lCustomerType" validation="required" form_name="freightmanifestform" friendly-name="Mode"
      ng-options="option.id for option in customerTypelist" data-dropdownmultiselect>    
        <option data-ng-repeat="option in customerTypelist" value="{{getCustomerTypeId(option)}}" data-ng-bind-template="{{option.customerType}}"></option>
     </select>  
        </div>
       </div>
         
         <div class="form-group">
        <label class="col-md-4 control-label">Vessel</label>
        <div class="col-md-7">
        
                  <!-- <select id="vessel" multiple="multiple"  name="vessel" ng-model="freightmanifest.lvessel"
      ng-options="option.text for option in vesselList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in vesselList" value="{{getvesselId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  -->
     <selectivity list="vesselList" ng-model="freightmanifest.vessel"
										validation="required" friendly-name="vessel"
											property="freightmanifest.vessel" id="vessel" name="vessel"
											form-name="freightmanifestform" ></selectivity>
    </div>
         </div>
              
       
       
           <div class="form-group">
        <label class="col-md-4 control-label">Voyage</label>
        <div class="col-md-7">
        <selectivity list="voyageList" ng-model="freightmanifest.voyage"
											validation="required" friendly-name="Voyage"
											property="freightmanifest.voyage" id="Voyage" name="Voyage" 
											form-name="freightmanifestform"></selectivity>
            <!-- <select id="voyage" multiple="multiple"  name="voyage" ng-model="freightmanifest.lvoyage"
      ng-options="option.text for option in voyageList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in voyageList" value="{{getvoyageId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>   -->

        </div>
       </div>
        
         <div class="form-group">
        <label class="col-md-4 control-label">Invoice Status</label>
        <div class="col-md-7">
        
                  <!-- <select id="vessel" multiple="multiple"  name="vessel" ng-model="freightmanifest.lvessel"
      ng-options="option.text for option in vesselList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in vesselList" value="{{getvesselId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  -->
     <selectivity list="statusList" ng-model="freightmanifest.invStatus"
										validation="required" friendly-name="invStatus"
											property="freightmanifest.invStatus" id="invStatus" name="invStatus"
											form-name="freightmanifestform" ></selectivity>
    </div>
         </div>
                       
      </fieldset>
        </div>

     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
		<!-- <div class="form-group">
        <label class="col-md-4 control-label">Branch</label>
        <div class="col-md-8">
               <select id="creditCategory" multiple="multiple"  name="creditCategory" ng-model="freightmanifest.lcreditCategory"
      ng-options="option.creditCategory for option in creditCategorylist" data-dropdownmultiselect>    
        <option data-ng-repeat="option in categoryWiseList" value="{{getcreditCategoryOptionId(option)}}" data-ng-bind-template="{{option.creditCategory}}"></option>
     </select> 
        </div>
       </div> -->
       
       <div class="form-group">
        <label class="col-md-4 control-label">Branch</label>
        <div class="col-md-8">
        
       <select id="branch" multiple="multiple"  name="branch" ng-model="freightmanifest.lbranch"
      ng-options="option.text for option in branchList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in branchList" value="{{getbranch(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  
        </div>
       </div>
       
       
       
       
       <div class="form-group">
        <label class="col-md-4 control-label">POL</label>
        <div class="col-md-8">
        
                  <select id="aol" multiple="multiple"  name="aol" ng-model="freightmanifest.laol"
      ng-options="option.text for option in aolList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in aolList" value="{{getaolId(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select> 
         
        </div>
         </div>
       <div class="form-group">
        <label class="col-md-4 control-label">POD</label>
        <div class="col-md-8">
        
            <select id="aod" multiple="multiple"  name="pod" ng-model="freightmanifest.laod"
      ng-options="option.text for option in aodList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in aodList" value="{{getaodId(option)}}" data-ng-bind-template="{{option.text}}"></option>
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
       
       
       <div class="form-group">
        <label class="col-md-4 control-label">Customer</label>
        <div class="col-md-8">
        
       <select id="customer" multiple="multiple"  name="customer" ng-model="freightmanifest.lcustomer"
      ng-options="option.text for option in customerList" data-dropdownmultiselect>    
        <option data-ng-repeat="option in customerList" value="{{getcustomer(option)}}" data-ng-bind-template="{{option.text}}"></option>
     </select>  
        </div>
       </div>
		
		
		<div class="form-group">
        <label class="col-md-4 control-label">From Date<span style="color: red;"></span></label>
        <div class="col-md-8">
          <ng-bs3-datepicker data-ng-model="freightmanifest.invoicefromDate" name="invoicefromDate" id="invoicefromDate"  />
      <label class="control-label text-left"  id="invoicefromDate" name="invoicefromDate" data-ng-model="freightmanifest.invoicefromDate" form_name="freightmanifestform" friendly-name="From Date">{{freightmanifest.invoicefromDate}}</label>
        </div>
       </div>
       
		         
          <div class="form-group">
        <label class="col-md-4 control-label">To Date<span style="color: red;"></span></label>
        <div class="col-md-8">
          <ng-bs3-datepicker data-ng-model="freightmanifest.invoicetoDate" name="invoicetoDate" id="invoicetoDate"  />
      <label class="control-label text-left"  id="invoicetoDate" name="invoicetoDate" data-ng-model="freightmanifest.invoicetoDate"  form_name="freightmanifestform" friendly-name="To Date">{{freightmanifest.invoicetoDate}}</label>
        </div>
       </div> 
         
     
            
      </fieldset>
     </div>   
    </div>
  <div>
   <header id="btntoggle" data-role="heading" class="btn btn-default col-sm-12 col-md-12 col-lg-12"  data-ng-click="isCollapsed = !isCollapsed">
    <div class="row"><a style="color: black; text-weight: bold;"><b>Report Header</b></a> </div>
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
        <button class="btn btn-success"  type="button" tooltip="Search"
         ng-click="onSearch(freightmanifest,freightmanifestform)">
         <i class="fa fa-search"></i> Submit
        </button>
       <button type="reset" class="btn btn-info" tooltip="Reset"   ng-click="reset()">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button id="exportXl"  class="btn btn-primary"
           data-ng-click="excel(freightmanifest);"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
      <%--  <security:authorize access="hasRole('${form_code}_${export}')">
             <button id="exportXl" class="btn btn-primary"
           data-ng-click="excel(freightmanifest);"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
          </security:authorize> --%>
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
        <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="FreightManifest in displayedCollection">
         <td class="width_6 padding-number-align text-center "   data-ng-repeat ="column in messageHeaderList" 
            data-ng-class={hide:(!column.visible)}>
           <!-- <c:choose>
           <c:when test="column.title == 'JOB NO' && FreightManifest.status=='Pending'">
          <a data-ng-click="addInvoice(FreightManifest[column.id])">  
          <span  class="tool-tip-span font-blue">{{FreightManifest[column.id]}}</span></a> 
            </c:when>    
    <c:otherwise>
             <span >{{FreightManifest[column.id]}}</span>
             </c:otherwise>
</c:choose> -->
<div ng-if = "column.title == 'JOB NO' && FreightManifest.status=='Pending'">
<a data-ng-click="addInvoice(FreightManifest[column.id])">  
          <span  class="tool-tip-span font-blue">{{FreightManifest[column.id]}}</span></a> 
          </div>
          <div ng-if = "column.title == 'JOB NO' &&  FreightManifest.status=='Approved'">
          <span  >{{FreightManifest[column.id]}}</span> 
          </div>
<div ng-if = "column.title != 'JOB NO'">

          <span >{{FreightManifest[column.id]}}</span>
          </div>
          
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

