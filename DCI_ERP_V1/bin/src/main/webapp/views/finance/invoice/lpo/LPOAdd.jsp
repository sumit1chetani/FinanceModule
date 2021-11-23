<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="wrapper-md">
    <div class="panel panel-default panel-default-form">
      <%@include file="/views/templates/panel-header-form.jsp"%>
      <input type="hidden" value="${form_code}" id="form_code_id">
      <div class="panel-body">
      	<form name="lpoForm" class="form-horizontal" novalidate>
       		<div class="row book-widget-row">
	    	<div class="col-sm-12 col-md-12 col-lg-12">
	    		<div class="col-sm-4 col-md-4 col-lg-4">
			        <fieldset>
			
			         <div class="form-group">
			          <label class="col-md-5 control-label"> Company
			           <span style="color: red;">*</span>
			          </label>
			          <div class="col-md-7" >
			           <selectivity ng-if="edit" disabled="edit" list="companyList" ng-model="lpoData.company" property="lpoData.company"
			           id="company_id" object="company" name="company_id"
			           validation="required" friendly-name="Company" form-name = "lpoForm"></selectivity>
			          </div>
			          <div class="col-md-7" >
			           <selectivity ng-if="!edit" list="companyList" ng-model="lpoData.company" property="lpoData.company"
			           id="company_id" object="company" name="company_id"
			           validation="required" friendly-name="Company" form-name = "lpoForm"></selectivity>
			          </div>
			         </div>
			
			         <div class="form-group">
			          <label class="col-md-5 control-label"> Currency
			           <span style="color: red;">*</span>
			          </label>
			          <div class="col-md-7">
			           <!-- <input type="text" class="form-control input-sm" readonly ng-model="lpoData.currency"
			            name="Currency" validation="required" friendly-name="Currency"> -->
			           <selectivity list="currencyList" property="lpoData.currency" name="Currency"  
			           id="currency" object="currency" validation="required" friendly-name="Currency" form-name = "lpoForm"
			           ng-model="lpoData.currency"></selectivity>
			          </div>
			         </div>
			         <div class="form-group">
			           <label for="inputPassword" class="control-label col-md-5">Description</label>
			           <div class="col-md-7">
			             <textarea rows="2" class="form-control" name="Description" ng-model="lpoData.description"></textarea>
			           </div>
			         </div>
			        </fieldset>
		       	</div>
	           	<div class="col-sm-4 col-md-4 col-lg-4">
			        <fieldset>
			        	<div class="form-group">
			                <label for="inputPassword" class="control-label col-md-5">LPO Date
			                <span style="color: red;">*</span></label>
			                <div class="col-md-7">
<!-- 			                  <div class="input-group input-append date" id="pi_date"> -->
<!-- 			                     <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" -->
<!-- 			                     ng-model="lpoData.lpoDate" name="Date" id="lpoDate" -->
<!-- 			                     validation="required" friendly-name="LPO Date"> -->
<!-- 			                   <span class="input-group-addon add-on"> -->
<!-- 			                            <span class="glyphicon glyphicon-calendar"></span> -->
<!-- 			                         </span> -->
<!-- 			                  </div> -->
<ng-bs3-datepicker data-ng-model="lpoData.lpoDate" id="lpoDate" name="lpoDate" form-name="lpoForm"
       data-ng-change="checkDatesCL(lpoData.lpoDate)" 
        friendly-name="Lpo Date" validation="required"/>
			                </div>
			              </div>
				         <div class="form-group">
				           <label class="col-md-5 control-label"> Exchange Rate
				            <span style="color: red;">*</span>
				           </label>
				           <div class="col-md-7">
				            <input type="text" class="form-control input-sm text-right"  ng-model="lpoData.exchangeRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
				            	ng-keyup="calculateExchangeRateOnHdr(lpoData.exchangeRate)"  ng-blur="exchageratehdr(lpoData.exchangeRate)"
				             name="Exchange Rate" validation="required" friendly-name="Exchange Rate">
				           </div>
				         </div>
				
				         <div class="form-group">
				          <label class="col-md-5 control-label"> TC Amount
				           <span style="color: red;">*</span>
				          </label>
				          <div class="col-md-7">
				           <input type="text" class="form-control input-sm text-right" ng-model="lpoData.tcAmount"
				            name="Amount(USD)" ng-keyup="amountLocalCalculation(lpoData.tcAmount)"
				            validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.01" friendly-name="TC Amount" >
				          </div>
				         </div>
			    	</fieldset>
	       		</div>
	        	<div class="col-sm-4 col-md-4 col-lg-4">
		         <div class="form-group">
		          <label class="col-md-5 control-label"> Supplier
		           <span style="color: red;">*</span>
		          </label>
		          <div class="col-md-7">
		           <selectivity list="supplierList" property="lpoData.supplier" ng-model="lpoData.supplier"  id="supplier_id" name="supplier_id"
		           object="supplier" validation="required" friendly-name="supplier" form-name = "lpoForm"></selectivity>
		          </div>
		         </div>
		         <div class="form-group">
		          <label class="col-md-5 control-label"> BC Amount({{companyCurrency}})
		           <span style="color: red;">*</span>
		          </label>
		          <div class="col-md-7">
		           <input type="text" class="form-control input-sm text-right" ng-model="lpoData.bcAmount"
		            name="Amount" ng-blur="amountCalculation(lpoData.bcAmount)" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.01" friendly-name="BC Amount" >
		          </div>
		         </div>
	        	</div>
	    	</div> <!-- /col-sm-12 -->
      	</div> <!-- /row -->
		<div class="table-responsive clear">
           <table class="table table-striped b-t b-light">
             <thead>
               <tr>
                  <th colspan=1 class="width_1"></th>
                  <th colspan=1  class="width_1 text-center">SI.No</th>
                   <!-- <th colspan=1  class="width_13 text-center">Sub Group</th> -->
                  <th colspan=1  class="width_13 text-center">Company<span style="color: red;">*</span></label></th>
                 <th colspan=1  class="width_13 text-center">Account Name<span style="color: red;">*</span></label></th>
                 <th colspan=1  class="width_13 text-center">Sub Account Code</th>
                 <th colspan=1  class="width_10 text-center">Short Details<span style="color: red;">*</span></label></th>
                 <th colspan=1 class=" width_8 text-center">Currency<span style="color: red;">*</span></label></th>
                 <th colspan=1 class=" width_8 text-center">Rate<span style="color: red;">*</span></label></th>
                 <th colspan=1 class="width_10 text-center">TC Amt<span style="color: red;">*</span></label></th>
                 <th colspan=1 class="width_10 text-center">BC Amt ({{companyCurrency}})<span style="color: red;">*</span></label></th>

                <!--  <th  colspan=1 class="width_1"></th> -->

               </tr>
             </thead>
             <tbody ng-repeat="(trIndex, row) in lpoData.lpoDetail" ng-controller="tableCtrl">
              <tr>
           <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
            <td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>

         <!-- <td>
          <selectivity list="subGrpList" property="row.subGrpCode" id="subGroupCode{{trIndex}}" object="subGroup"></selectivity>
         </td> -->
         <td>
          <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"
          ng-model="row.companyCode" name ="companyCode{{trIndex}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name = "lpoForm"></selectivity>
         </td>

         <td>
          <selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
          ng-model="row.accountHeadCode" name ="accountHeadCode{{trIndex}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "lpoForm"></selectivity>
         </td>
         <td ng-if="row.isSubAccountCode">

											<selectivity list="row.subAccountCodeList"
												property="row.subAccountCode"
												id="subAccountCode{{trIndex}}"
												ng-model="row.subAccountCode" validation="required"
												name="subAccountCode{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
												form-name="lpoForm"></selectivity>


										</td>
         <td ng-if = "!row.isSubAccountCode">
          <selectivity list="row.subAccountCodeList" property="row.subAccountCode" id="subAccountCode{{trIndex}}" object="subAccount" disabled = "!row.isSubAccountCode"></selectivity>
         </td>

               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm" id="shortDetails{{trIndex}}" ng-model="row.shortDetail"
                      name="shortDetail" validation="required" friendly-name="{{ 'Row' + $index + '(Short Detail)'}}">
                 </div>
                </div>
               </td>
               <td>
                 <div class="row">
                    <div class="col-xs-12">
                      <!-- <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency{{trIndex}}"
                      validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly> -->
                       <selectivity list="currencyList" ng-model="row.currency" property="row.currency" id="currency{{trIndex}}" object="currency"
                       validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" name="{{ 'Row' + $index + '(Currency)'}}" form-name = "lpoForm" ></selectivity>
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm text-right" id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
                      name="exchangeRate{{trIndex}}"  ng-keyup ="calculateExchangeRateOnDtlTbl(row.exchangeRate,trIndex,row)"
                      ng-blur="amountCalculationexchange(row.exchangeRate,trIndex,row)" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
                      validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}">
                      
                           <input type="hidden" class="form-control input-sm text-right" id="txtFromCurrency{{trIndex}}" ng-model="row.fromCurrency"  
                      name="From Currency{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
                      <input type="hidden" class="form-control input-sm text-right" id="txtToCurrency{{trIndex}}" ng-model="row.toCurrency"  
                      name="To Currency{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
                 </div>
                </div>
                
             
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm text-right" id="tcAmount{{trIndex}}" ng-model="row.tcAmount"  name="tcAmount{{trIndex}}"
                      ng-keyup="amountCalculationTCTable(row.tcAmount,trIndex,row)"
                      validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(TC Amount)'}}">
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                     <input type="text" class="form-control input-sm text-right"  id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}"
                      ng-blur="amountCalculationBCTable(row.bcAmount,trIndex,row)"
                      validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
                </div>
                </div>
               </td>

             </tr>

             <tr>
               <td colspan="12">
                <div class="col-sm-12">
		                <!-- Attributes list -->
		                <!-- <div class="col-sm-3" >
		                <label class="col-md-5 control-label"> Attriutes </label>
		                </div> -->
		                
		                
		          
		                
		                
		                
		                <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && !row.isVoyageMan">
		           <label class="col-md-5 control-label"> Trip
		
		           </label>
		           <div class="col-md-7">
		                        <selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Trip

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList"
															property="row.voyageCode"
															id="voyageCode{{trIndex}}"
															ng-model="row.voyageCode" validation="required"
															name="voyageCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
															form-name="lpoForm"
															>
														</selectivity>
										     </div>
										     
										    
										</div>
		                <div class="col-sm-2 padding-top-5" ng-if="row.isVessel && !row.isVesselMan">
		           <label class="col-md-5 control-label"> Truck
		
		           </label>
		           <div class="col-md-7">
		                     <selectivity list="vesselList" property="row.vesselCode" id="vesselCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Truck

											</label>
											<div class="col-md-7">
										          <selectivity list="vesselList"
															property="row.vesselCode"
															id="vesselCode{{trIndex}}"
															ng-model="row.vesselCode" validation="required"
															name="vesselCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
															form-name="lpoForm"
															>
														</selectivity>
										     </div>
										</div>
		        <!--   <div class="col-sm-2 padding-top-5" ng-if="row.isService && !row.isServiceMan">
		           <label class="col-md-5 control-label"> Service
		
		           </label>
		           <div class="col-md-7">
		                       <selectivity list="sectorList" property="row.sectorCode" id="sectorCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
									             <selectivity list="sectorList"
														property="row.sectorCode"
														id="sectorCode{{trIndex}}"
														ng-model="row.sectorCode" validation="required"
														name="sectorCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Service)'}}"
														form-name="lpoForm"
														>
													</selectivity>
										     </div>
										</div> -->
		          <div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
		           <label class="col-md-5 control-label"> Employee
		
		           </label>
		           <div class="col-md-7">
		                     <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		        <!--   <div class="col-sm-2 padding-top-5" ng-if="row.isPort">
		           <label class="col-md-5 control-label"> Location
		
		           </label>
		           <div class="col-md-7">
		                     <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}"></selectivity>
		               </div>
		          </div> -->
		
		        <!--   <div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
		           <label class="col-md-5 control-label"> Port.Seq
		
		           </label>
		           <div class="col-md-7">
		                    <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
		               </div>
		          </div> -->
		
		          <div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
		           <label class="col-md-5 control-label"> Department
		
		           </label>
		           <div class="col-md-7">
		                     <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		
		          <div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
		           <label class="col-md-5 control-label"> Agent
		
		           </label>
		           <div class="col-md-7">
		                     <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		
		          <div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
		           <label class="col-md-5 control-label"> Location
		
		           </label>
		           <div class="col-md-7">
		                       <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
		           <label class="col-md-5 control-label"> Customer
		
		           </label>
		           <div class="col-md-7">
		                       <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
		           <label class="col-md-5 control-label"> Supplier
		
		           </label>
		           <div class="col-md-7">
		                       <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
			           <label class="col-md-5 control-label"> Designation</label>
			           <div class="col-md-7">
			                 <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
			           </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
		           <label class="col-md-5 control-label"> CostCtr</label>
		           		<div class="col-md-7">
		               		<input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
		               	</div>
		          </div>
		          <!--  commented for inter-company transaction -->
		          <div class="col-sm-2 padding-top-5" ng-if="row.isAsset">
		           <label class="col-md-5 control-label"> Asset
		
		           </label>
		           <div class="col-md-7">
		                       <selectivity list="row.assetList" property="row.assetCode" id="assetCode{{trIndex}}"></selectivity>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
		           <label class="col-md-5 control-label">Qty(MT)GO</label>
		           <div class="col-md-7">
		                       <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
		               </div>
		          </div>
		          <div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
		           <label class="col-md-5 control-label">Qty(MT)FO</label>
		           <div class="col-md-7">
		                       <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
		               </div>
		          </div>
		          </div>
		        </td>
             </tr>
             </tbody>
           </table>
	       <div class="padding-right-5">
	             <div class="col-md-4">
                   <button ng-click="addRow(lpoData.lpoDetail)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
                   <i class="fa fa-plus"></i>
                  </button>
                  <button ng-click="removeRow(lpoData.lpoDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
                   <i class="fa  fa-trash-o"></i>
                  </button>
                </div>
	            <div class="col-md-8">
		          <div class="form-group">
		          <label class="col-md-6 control-label">Total
		          </label>
		          <div class="col-md-3">
		           <input type="text" class="form-control input-sm text-right" ng-model="totalTCAmount" readonly
		           name="TC Total" placeholder="0.0">
		          </div>
		
		          <div class="col-md-3">
		           <input type="text" class="form-control input-sm text-right" ng-model="totalBCAmount" readonly
		           name="BC Total" placeholder="0.0">
		          </div>
		         </div>
		        </div>
           </div>
           <div class="row">
	        <div class="col-sm-12 col-md-12 col-lg-12">
	            <div class="content">
	              <div class="form-actions">
	           <div class="row">
	            <div class="col-md-12">
	             <button ng-model="add" class="btn btn-success" ng-if="!edit"
	               class="btn btn-success" ng-click="onSubmit(lpoForm,lpoData)">
	              <i class="fa fa-save"></i> Save
	             </button>
	             <button class="btn btn-success" ng-if="edit"
	             ng-click="onSubmit(lpoForm,lpoData)">
	              <i class="fa fa-save"></i> Update
	             </button>
	             <button class="btn btn-danger" type="reset"
	              class="btn btn-success" ng-click="cancel()">
	              <i class="fa fa-close"></i> Cancel
	             </button>
	            </div>
	           </div>
	          </div><!-- /form-actions -->
	         </div>
	        </div>
	       </div> <!-- /row -->
		</div> <!-- /table-responsive -->
     </form>
    </div> <!-- /panel-body -->
   </div> <!-- /panel-default -->
  </div>
 </div>
</div>