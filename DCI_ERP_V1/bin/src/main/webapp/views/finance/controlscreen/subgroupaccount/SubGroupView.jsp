<style>
 table.dataTable thead .sorting:after { 
   content: ""; 
 } 
 select{ 
 -webkit-appearance: none; 
   padding: 0; 
  text-indent: 8px; 
   padding : 0 !important; 
 } 
 .input-group-addon{ 
 display:none !important; 
 }
 .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control 


 { 
  background-color:white !important; 
  border:0px !important; 
 } 
 .b-grey{ 
 border:0px !important;
}
</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-0">
				<li><a>Master</a></li>
				<li><a x-ui-sref="app.finance.controlscreen">Control Screen</a>
				</li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroupaccount">Sub Group</a></li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroup-add">View</a>
				</li>
			</ol>
		</div>		
		<div class="panel-body">
			<form class="form-horizontal" name="subGroupAcctForm" novalidate method="POST">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
					<fieldset ng-disabled="viewDisable">
						<div class="col-sm-4 col-md-4 col-lg-4">								
							<div class="form-group" ng-if="subGroupData.edit">
								<label class="col-md-5 control-label">Group code </label>
								<!-- <div class="col-md-7 inputGroupContainer"> --> 
								<label class="col-md-1 control-label" ng-if="subGroupData.edit">{{subGroupData.subGroupCode}}</label>
								
							</div>
							<div class="form-group">
     						   <label class="col-md-5 control-label">Category </label>
						       <div class="col-md-7 inputGroupContainer">
						       <input type="text" class="form-control input-sm"
									name="subGroupName"
									id="subGroupName"
									friendly-name="Sub Group Account" 
									ng-model="subGroupData.grpHeadName" >
								 <!-- <selectivity  list="grpHeadTypeList" property="subGroupData.grpHeadCode" id="grpHeadCode_id"
								validation="required"
								name ="grpHeadCode_id"
								ng-model ="subGroupData.grpHeadCode"
								friendly-name="Group Head" 
								form-name="subGroupAcctForm"></selectivity> -->
							   </div>
						   	</div>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> Group Name
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
									name="subGroupName"
									id="subGroupName"
									validation="required"
									friendly-name="Sub Group Account" 
									ng-model="subGroupData.subGroupName" ng-keyup="changeToUpperCase(subGroupData.subGroupName)" >
								</div>
							</div>						
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> Group Desc 
								</label>
								<div class="col-md-7">
									<textarea rows="2" cols="30" name="Description" 
									ng-model="subGroupData.subGroupDesc" 
									id="description"
									validation="required"
									friendly-name="Description" Style="resize:none"></textarea>
								</div>
							</div>															
						</div>
						</fieldset>
					</div>
					
					 <div class="col-sm-12">
	      				<label class="col-md-2 control-label">Attributes :</label>
	     			</div>
	    			 <div class="col-sm-12" ><br>
					     <div class="col-sm-2">
					     </div>
					     <div class="col-sm-9" id="checkboxDiv">
					     <div class="form-group" >
	        					<div class="form-group">
				                <label id="checkboxLabel" ng-repeat="obj in attributeList" class="col-sm-3">
							 	 <input type="checkbox"  checklist-model="subGroupData.lAttributes" ng-disabled="viewDisable" checklist-value="obj.attributeName"> {{obj.attributeName}}
							    </label><br>
					    	</div>
       						</div> 
					     </div>
					</div>
				</div> <!-- /book-widget-row -->
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div> <!-- /panel-body -->			
	</div>  <!-- /panel-default -->
</div> <!-- /wrapper-md -->
