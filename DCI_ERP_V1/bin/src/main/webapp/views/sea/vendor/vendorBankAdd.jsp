<style>
/* .myform-group {
	margin-left: 0px;
	margin-bottom: 0px;
}
.ngdialog-content {
 width: auto;
        height: auto;	
	
} */


.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 85%;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -40px;
}

.multiselect-container {
	position: absolute;
	list-style-type: none;
	margin: 0;
	padding: 0
}


.multiselect-container .input-group {
	margin: 5px
}

.multiselect-container>li {
	padding: 0
}

.multiselect-container>li>a.multiselect-all label {
	font-weight: 700
}

.multiselect-container>li>label.multiselect-group {
	margin: 0;
	padding: 3px 20px;
	height: 100%;
	font-weight: 700
}

.multiselect-container>li>a {
	padding: 0
}

.multiselect-container>li>a>label {
	margin: 0;
	height: 100%;
	cursor: pointer;
	font-weight: 400;
	padding: 3px 20px 3px 40px
}

.multiselect-container>li>a>label.radio, .multiselect-container>li>a>label.checkbox
	{
	margin: 0
}

.multiselect-container>li>a>label>input[type=checkbox] {
	margin-bottom: 5px
}

.btn-group>.btn-group:nth-child(2)>.multiselect.btn {
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px
}

.form-inline .multiselect-container label.checkbox, .form-inline .multiselect-container label.radio
	{
	padding: 3px 20px 3px 40px
}

.form-inline .multiselect-container li a label.checkbox input[type=checkbox],
	.form-inline .multiselect-container li a label.radio input[type=radio]
	{
	margin-left: -20px;
	margin-right: 0
}

.tooltip {
	position: relative;
	display: inline-block;
	border-bottom: 5px dotted black;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 120px;
	background-color: black;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	/ Position the tooltip /
	position: absolute;
	z-index: 1;
	top: -5px;
	left: 105%;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
}
/* 
.tableFixHead          { width:100%;height:300px;overflow:auto; }
.tableFixHead thead th { position: sticky; top: 0; }

/ Just common table stuff. Really. /
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; }
th     { background:#eee; } */

.subcolor {
	background: #42a5f5 !important;
	color: #fff !important;
}

.custom-color-1 .table-striped>tbody>tr>td, .custom-color-1 .table-striped>tfoot>tr>th
	{
	border: 1px solid #000;
	border-bottom: 1px solid #000;
	color: #1a1a1a;
}

.custom-color-1 .table-striped>thead>tr>th {
	border: 1px solid #000;
	color: #fff;
	border-bottom: 1px solid #000;
	border-left: 1px solid #000;
	border-top: black;
}

.table>tbody>tr>td, .table>tfoot>tr>td {
	padding: 4px 10px;
	font-size: 11px;
}

.table>thead>tr>th {
	padding: 0px 10px 0px 10px;
	font-size: 11px;
}

.ls_flag_Color {
	background: #caef7a !important;
}


.inner {
width:100%;height:300px;overflow:auto;
}
.inner thead th { position: sticky; top: 0; }

#optable td, #optable th {
	border: 1px solid #fff;
	width: 200%;
	
}

#optable table {
	table-layout: fixed;
	width: 100%;
}
.freeze-class_hdr {
	position: sticky;
	left: 0;
	z-index: 1;
	background-color: #caef7a;
}
.freeze-class1 {
	position: sticky;
	left: 0;
	z-index: 1;
	background-color: #9dcced;
}

.freeze-class2 {
	position: sticky;
	left: 4%;
	z-index: 1;
	background-color: #9dcced;
}

.freeze-class3 {
	position: sticky;
	left: 17%;
	z-index: 1;
	background-color: #9dcced;
}

.freeze-class4 {
	position: sticky;
	left: 130px;
	z-index: 1;
	background-color: #caef7a;
}

.freeze-class5 {
	position: sticky;
	left: 170px;
	z-index: 1;
	background-color: #caef7a;
}

.freeze-class6 {
	position: sticky;
	left: 220px;
	z-index: 1;
	background-color: #caef7a;
}

#optable thead tr th {
	position: sticky;
	top: 0;
}

#optable th:first-child, #optable th:nth-child(2), #optable th:nth-child(3),
	#optable th:nth-child(4), #optable th:nth-child(5), #optable th:nth-child(6)
	{
	z-index: 2;
}

.Class1{

}

</style>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
     	<div role="content">
      		<div class="widget-body">
       					<form class="form-horizontal" name="bankAddForm">
       						<div class="row">
		        				<div class="col-sm-12 col-md-12 col-lg-12">
		        					<div class="col-sm-4 col-md-6 col-lg-6">
		        						<div class="form-group">
							             	<label class="col-md-4 control-label">Bank Name</label>
							             	<div class="col-md-7">
							              		<input type="text" class="form-control input-sm" 
							               			name="Bank Name" id="bankName"
							               			data-ng-model="customerBankobj.bankName"
							               			data-validator="required" data-valid-method="submit">
							             	</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-4 control-label">Account Number</label>
							             		<div class="col-md-7">
									              	<input type="text" class="form-control input-sm" 
								               			name="Account Number" id="accountNo"
								               			data-ng-model="customerBankobj.accountNo" 
								               			data-validator="required" data-valid-method="submit">
							             		</div>
								        </div>
								        <div class="form-group">
								           <label class="col-md-5 control-label">Address</label></label>
								           <div  class="col-md-7">
									            <div  class="col-md-7">
<!-- 									             	<textarea class="text-left form-control input-sm" ng-model="customerBankobj.bankDetAddress" rows="2" cols="15" style="resize: none"> </textarea>
 -->									           <textarea type="text" cols="100"  class="form-control input-sm" id="address" 
			        	name="Address"
			        	ng-model="customerBankobj.bankDetAddress"  friendly-name="Address"></textarea>
									           
									            </div>
										       <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="billingCityList" property="customerBankobj.bankCityId" id="txtCitybillingId"></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="customerBankobj.desStateCode" />
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="customerBankobj.desState" />
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="customerBankobj.desZipcode" />
											        </div>
										        </div> 
										         <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="customerBankobj.desCountryCode" />
										            <input type="text" class="form-control input-sm" placeholder="country" ng-model="customerBankobj.desCountry" />	
									            </div> 
								            </div>								           
						            	</div>
		        					</div>
		        					<div class="col-sm-6 col-md-6 col-lg-6">
		        						<div class="form-group">
							             	<label class="col-md-4 control-label">Account Type </label>
							             		<div class="col-md-8">
							                        <select class="form-control" data-ng-model="customerBankobj.accountTypeId" 
							                        data-ng-options="ci.accountTypeId as ci.accountType for ci in accountTypeList">
										            <option value="" selected="selected">Select</option>
										      </select> 
							             	</div>
								       </div>
								       <div class="form-group">
							             	<label class="col-md-4 control-label"> IFSC Code</label>
							             		<div class="col-md-7">
									              	<input type="text" class="form-control input-sm" 
								               			name="IFSC Code" id="ifscCode"
								               			data-ng-model="customerBankobj.ifscCode" 
								               			data-validator="required" data-valid-method="submit">
							             		</div>
								        </div>
		        					</div>
		        				</div>
		        			</div>
       					</form>
      				</div>
     			</div>
     			<!-- end widget content -->
			     <div class="form-actions">
			      <div class="row">
			       <div class="col-md-12">
			        <button class="btn btn-success" type="submit"
			         data-ng-click="addRowBank(bankAddForm)">			        
			         <i class="fa fa-save"></i>
			         Add to List
			        </button>					
			        <button class="btn btn-danger" type="reset"
			         class="btn btn-success" ng-click="cancelBank()">
			         <i class="fa fa-close"></i>Cancel
			        </button>
			       </div>
			      </div>
			     </div>
     <!-- end widget div -->
    		</div>
    <!-- end widget -->
   	</article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>