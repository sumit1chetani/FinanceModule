<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form" style="border:0px solid Red">
  <!-- <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb inline-block padding-left-10" style="border:0px solid Red">
    <li>
      <a>Finance</a>
    </li>
    <li>
     <a>Control Screen</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.controlscreen.creditgroup">Credit Group</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.controlscreen.creditgroup.list">Add</a>
    </li>
   </ol>
  </div> -->
 <%@include file="/views/templates/panel-header-form.jsp"%>
   
    
    <div class="panel-body">
     <form class="form-horizontal" name="creditGroupAddForm" role="form" novalidate>
      <div class="row">
       <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
        <fieldset>         
         <div class="form-group">
          <label class="col-md-4 control-label">
             Group Name
           <span style="color: red;">*</span>
          </label> 
          <label class="col-md-1 control-label"> </label>
          <div class="col-md-5"
          ng-class="{showerror:ContainerAddForm.containerType.$error.required && submitted}">
           <!-- <input type="text" class="text-left form-control input-sm" name="gouprpName"
           ng-model="creditGroupObj.groupName"  ng-blur="nameCheck(creditGroupObj.groupName)"required> -->
       <!--     <input type="text" class="form-control input-sm" id="groupName" name="Sub Group Account"  
									ng-model="creditGroupObj.groupName" 
									validation="required" friendly-name="Group Name" form-name="creditGroupAddForm"
									typeahead="ac.groupName as ac.groupName for ac in groupNameList| filter:$viewValue |limitTo:10 | concatGroupName:$viewValue"  
									typeahead-min-length='1' typeahead-input-formatter="fetchSelectedGroupName($model,creditGroupObj)"/> -->
           
           <input type="text" class="form-control input-sm"
												friendly-name="" form-name="creditGroupAddForm"
												ng-model="creditGroupObj.groupName"  validation="required"
												name="groupName" id="groupName" >
          </div>
         </div>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Credit Limit Days
          </label>
          <label class="col-md-1 control-label"> </label>
          <div class="col-md-5">
           <input type="text" class="text-right form-control input-sm" placeholder="0.00" name="creditLmtDays" ng-model="creditGroupObj.creditLmtDays">
          </div>
         </div>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Credit Limit Amt
           </label>
          <label class="col-md-1 control-label"> </label>
          <div class="col-md-5">
           <input type="text" class="text-right form-control input-sm" name="creditLmtAmt" placeholder="0.000" ng-model="creditGroupObj.creditLmtAmt" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount Should be 2 digit"  step="0.01" friendly-name="Credit Limit Amt">
          </div>
         </div>
        </fieldset>
       </div>
       <!-- table -->
      
      </div>
       <div class="table-responsive" >
      <table class="table table-striped b-t b-light" >
        <thead>
          <tr>
            <th colspan=1 class="width_1"></th>
            <th colspan=1 class="width_13 text-center">Customer Name</th>
            <th colspan=1 class="width_10 text-center">Customer Code</th>
          <!--   <th colspan=1 class="width_10 text-center">MLO Name</th> -->
            <th colspan=1 class="width_10 text-center">Customer Short Name</th>
            
            <th colspan=1 class="width_1"></th>
          </tr>
        </thead>
        <tbody ng-repeat="(trIndex, row) in creditGroupObj.credittables" >
        	<tr>
	            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<!-- <selectivity list="customerList" property="row.customerName" id="custName{{trIndex}}" object="customerName"></selectivity> -->
		              		<!-- <selectivity list="customerList"  property="row.mloName" id="mloName{{trIndex}}"></selectivity> -->
	        			  <selectivity list="customerList"
															property="row.mloName"
															id="mloName{{trIndex}}"
															ng-model="row.mloName" 
															name="mloName{{trIndex}}" 
															friendly-name="{{ 'Row' + $index + '(Customer Name)'}}"
															form-name="creditGroupAddForm"
															>
														</selectivity>
	        			
	        			</div>
	        		</div>
	        	</td>

		        <td>
		        	<div class="row">
	            		<div class="col-xs-12">
			       	     	<input type="text" class="form-control input-sm" name="description"
			       	     	data-ng-model="row.mloId" required />
	        			</div>
	        		</div>
	        	</td>
	          <!-- 	<td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.mloName" required />
	              		</div>
	              	</div>
	            </td> -->
	            
	            <td>
		           	<div class="row">
		           		<div class="col-xs-12">
		        	  	<input type="text" class="form-control input-sm" name="mloShortName" data-ng-model="row.mloShortName" required />
		             	</div>
		            </div>
	            </td>
     		</tr>
      	</tbody>
      </table>
       <div class="padding-right-5" id="AddOrRmvebtn">
           <button ng-click="addCredRow( creditGroupObj.credittables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>
           </button>
           <button ng-click="removeRow(creditGroupObj.credittables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
      </div>
      <!-- /padding-right-5 - /AddOrRmvebtn -->
	</div> 
      <div class="form-actions">
       <div class="row">
        <div class="col-md-12">
         <button class="btn btn-success" ng-if="isEdit== false" ng-click=save(creditGroupObj,creditGroupAddForm) type="button">
          <i class="fa fa-save"></i>
          Save
         </button>
         <button class="btn btn-success"
            ng-if="isEdit == true" ng-click=update(creditGroupObj,creditGroupAddForm) type="button">
            <i class="fa fa-save"></i> Update
           </button>
        
         <button class="btn btn-danger" ng-click="cancel()" type="button">
                 <i class="fa fa-close"></i>
                 Cancel
                </button>
        </div>
       </div>
      </div>
     </form>
    
 
 </div>
</div>
