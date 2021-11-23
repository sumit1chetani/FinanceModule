<style>
#trkTrailAddId{
/* box-shadow: 0px 10px 70px 0px #1a34f1; */
}
#trkSelList > .blockOverlay{
    width: 90% !important;
    margin-left: 5% !important;
    background-color: rgb(210, 205, 205) !important
}
</style>
<div class="wrapper-md trCal"> <!-- widget grid -->
	<div class="panel panel-default panel-default-form">
		<div class="panel panel-default panel-default-form ptCalHdRem ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div id="blkCnt">
		<div class="panel-body" id="TripAddId">
			 <form class="form-horizontal" name="earningDeductionForm" method="post" novalidate>
        <div class="row">
         <fieldset>
          <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
           <div class="col-sm-6 col-md-6 col-lg-6">
            <div class="form-group">
             <label class="col-md-5 control-label"> Earning/Deduction Code <span
              style="color: red;">*</span>
             </label>
             <div class="col-md-5">
              <input type="text" class="form-control"
               data-ng-model="earningDeduction.payComponentId" maxlength="5"
               data-ng-if="!earningDeduction.isEdit" name="Earning Deduction Code"
               data-message-id="payComponentId" validation="required" friendly-name="Earning/Deduction Code"/> 
             <input type="text" class="form-control input-sm"
               data-ng-model="earningDeduction.payComponentId" data-ng-if="earningDeduction.isEdit"
               name="Earning Deduction Code" data-message-id="payComponentId" 
               validation="required" friendly-name="Earning/Deduction Code" readonly />
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Earning/Deduction Name <span
              style="color: red;">*</span>
             </label>
             <div class="col-md-5" data-ng-if="!earningDeduction.isEdit">
              <input type="text" class="form-control input-sm"
               data-ng-model="earningDeduction.payComponentName" name="Earning Deduction Name"
               data-message-id="payComponentName"  
              validation="required" friendly-name="Earning Deduction Name"/>
             </div>
             <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==true">
              <input type="text" class="form-control input-sm"
               data-ng-model="earningDeduction.payComponentName" name="Earning Deduction Name"
               data-message-id="payComponentName"  
              validation="required" friendly-name="Earning Deduction Name"/>
             </div>
               <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==false">
              <input type="text" class="form-control input-sm"
               data-ng-model="earningDeduction.payComponentName" name="Earning Deduction Name"
               data-message-id="payComponentName"  
              validation="required" friendly-name="Earning Deduction Name"/>
             </div>
             
             
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Earning/Deduction Type <span
              style="color: red;">*</span>
             </label>
             <div class="col-md-4" data-ng-if="!earningDeduction.isEdit">
              <input type="radio" value="earning" checked
               data-ng-model="earningDeduction.payComponentTypeName" name="Earning Deduction Type"
               data-message-id="payComponentTypeName"
               validation="required" friendly-name="Earning/Deduction Type"/>  Earning<br>
             </div>
             <div class="col-md-4" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==true">
              <input type="radio" value="earning" checked
               data-ng-model="earningDeduction.payComponentTypeName" name="Earning Deduction Type"
               data-message-id="payComponentTypeName" 
               validation="required" friendly-name="Earning/Deduction Type" disabled/>  Earning<br>
             </div>
               <div class="col-md-4" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==false">
              <input type="radio" value="earning" checked
               data-ng-model="earningDeduction.payComponentTypeName" name="Earning Deduction Type"
               data-message-id="payComponentTypeName" 
               validation="required" friendly-name="Earning/Deduction Type" />  Earning<br>
             </div>
             
             
             <div class="col-md-5" data-ng-if="!earningDeduction.isEdit">
              <input type="radio" value="deduction" checked
               data-ng-model="earningDeduction.payComponentTypeName" name="Earning Deduction Type"
               data-message-id="payComponentTypeName"
               validation="required" friendly-name="Earning/Deduction Type"/>  Deduction<br>
             </div>
             <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==true">
              <input type="radio" value="deduction" checked
               data-ng-model="earningDeduction.payComponentTypeName" name="Earning Deduction Type"
               data-message-id="payComponentTypeName" 
               validation="required" friendly-name="Earning/Deduction Type"  disabled/>  Deduction<br>
             </div>
             
               <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==false">
              <input type="radio" value="deduction" checked
               data-ng-model="earningDeduction.payComponentTypeName" name="Earning Deduction Type"
               data-message-id="payComponentTypeName" 
               validation="required" friendly-name="Earning/Deduction Type"  />  Deduction<br>
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"></label>
             <div class="col-md-5" data-ng-if="earningDeduction.payComponentTypeName == 'deduction'">
              <input type="checkbox" style="padding-left: 25px;"
               data-ng-model="earningDeduction.nonStandardDeduction" name="Non-Standard Deduction"
               data-message-id="nonStandardDeduction" 
               friendly-name="Non-Standard Deduction"  />  Non-Standard Deduction
             </div>
             </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Active 
             </label>
             <div class="col-md-5" data-ng-if="!earningDeduction.isEdit">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.status" name="Active" 
                data-message-id="status" /> <span></span>
               </label>
              </div>
             </div>
              <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==true">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.status" name="Active" 
                data-message-id="status" disabled/> <span></span>
               </label>
              </div>
             </div>
             
              <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==false">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.status" name="Active" 
                data-message-id="status" /> <span></span>
               </label>
              </div>
             </div>
             
             
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Allowance
             </label>
             <div class="col-md-5" data-ng-if="!earningDeduction.isEdit">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.allowance" /> <span></span>
               </label>
              </div>
             </div> 
             <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==true" >
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.allowance" disabled /> <span></span>
               </label>
              </div>
             </div>
             <div class="col-md-5" data-ng-if="earningDeduction.isEdit && earningDeduction.permanant==false">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.allowance" /> <span></span>
               </label>
              </div>
             </div>
             
            </div>
 
 		<div class="form-group">
             <label class="col-md-5 control-label"> JV Mapping 
             </label>
             <div class="col-md-5" >
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.jvMapping" name="Active" data-ng-change = "getAccountHead(earningDeduction.jvMapping)"
                data-message-id="status" /> <span></span>
               </label>
              </div>
             </div>
             </div>
             <div class="form-group" ng-if = "jvmapFlag">
             <label class="col-md-5 control-label">Credit Account Head
             </label>
             <div class="col-md-5" >
              <selectivity
																class=""
																list="accountHeadList" ng-model="earningDeduction.accountHead"
																property="earningDeduction.accountHead"
																id="txtaccountHead"
																name="accountHead"																
																friendly-name="accountHead"></selectivity>
             </div>
             </div>
             <div class="form-group" ng-if = "jvmapFlag">
             <label class="col-md-5 control-label">Debit Account Head
             </label>
             <div class="col-md-5" >
              <selectivity
																class=""
																list="accountHeadList" ng-model="earningDeduction.accountHead"
																property="earningDeduction.debitaccountHead"
																id="txtaccountHead"
																name="accountHead"																
																friendly-name="accountHead"></selectivity>
             </div>
             </div>
           </div>
           
           <div class="col-sm-6 col-md-6 col-lg-6">
            <div class="form-group" data-ng-if="!earningDeduction.isEdit">
             <label class="col-md-5 control-label"> Permanant 
             </label>
             <div class="col-md-5">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.permanant" data-ng-if="!earningDeduction.isEdit"
                /> <span></span>
               </label> <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.permanant" data-ng-if="earningDeduction.isEdit"
                disabled /> <span></span>
               </label>
              </div>
             </div>
            </div>
            <div class="form-group" data-ng-if="earningDeduction.isEdit">
             <label class="col-md-5 control-label"> Permanant 
             </label>
             <div class="col-md-5">
              <div class="checkbox">
               <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.permanant" data-ng-if="!earningDeduction.isEdit"
                disabled /> <span></span>
               </label> <label> <input type="checkbox" class="checkbox style-0"
                data-ng-model="earningDeduction.permanant" data-ng-if="earningDeduction.isEdit"
                disabled /> <span></span>
               </label>
              </div>
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label">Percentage Based On </label>
             <div class="col-md-5 ">
              	<!-- <ui-select multiple ng-model="earningDeduction.percentageAppliedOn" 
												ng-disabled="disabled" name="Percentage Based On" style="width: 100%;">
											<ui-select-match placeholder="Select..." >{{$item.payComponentName}}</ui-select-match>
											<ui-select-choices
												 repeat="ed.payComponentId as ed in earningDeductionMasterList | filter:$select.search">{{ed.payComponentName}}</ui-select-choices>
											</ui-select> -->
				<select id="percentageAppliedOn" multiple="multiple" name="multiselect[]" 
						ng-model="earningDeduction.percentageAppliedOn"
				 		ng-options="option.text for option in earningDeductionMasterList" data-dropdownmultiselect>    
				   <option data-ng-repeat="option in earningDeductionMasterList" value="{{getOptionId(option)}}" 
				   		ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}">
				   	</option>
				</select>
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Percentage 
             </label>
             <div class="col-md-5">
              <input type="text" class="form-control" id="paycomponentPercentage" name="kmc" ng-blur="validatepercentage(earningDeduction.percentageValue)"
               value="" disabled=true data-ng-model="earningDeduction.percentageValue" ng-pattern-restrict="^[0-9.]*$">
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Earning/Deduction Value 
             </label>
             <div class="col-md-5">
              <input type="text" class="form-control" id="paycomponentValue"
               name="Earning Deduction Value" data-ng-model="earningDeduction.amountValue" ng-pattern-restrict="^[0-9.]*$"
              >
             </div>
            </div>
            <div class="form-group">
             <label class="col-md-5 control-label"> Display Order <span style="color: red;">*</span>
             </label>
             <div class="col-md-5">
              <input type="text" class="form-control"
               data-ng-model="earningDeduction.displayOrder" name="Display Order"
               data-message-id="displayOrder" validation="required" friendly-name="Display Order" ng-pattern-restrict="^[0-9]*$"/>
             </div>
            </div>
           </div>
          </div>
         </fieldset>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="submit(earningDeduction,earningDeductionForm)" data-ng-if="!earningDeduction.isEdit">
            <i class="fa fa-save"></i>Save
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(earningDeduction,earningDeductionForm)" data-ng-if="earningDeduction.isEdit">
            <i class="fa fa-save"></i>Update
           </button>
           <button class="btn btn-info ng-scope" type="button" class="btn btn-success"
            ng-click="reset()" data-ng-if="!earningDeduction.isEdit">
            <i class="fa fa-undo"></i>Reset
           </button>
           <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
            <i class="fa fa-close"></i>Cancel
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
     <!-- end widget content -->
    </div>
    <!-- end widget div -->
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>