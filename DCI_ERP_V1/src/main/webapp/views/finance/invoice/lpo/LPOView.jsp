<style>
table.dataTable thead .sorting:after {
 content: "";
}

.main_container {
 overflow: auto;
}

.datetimepicker {
 width: auto;
}

select {
 -webkit-appearance: none;
 padding: 0;
 text-indent: 8px;
 padding: 0 !important;
}

.input-group-addon {
 display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
 {
 background:white !important;
 background-color: white !important;
 border: 0px !important;
}

.b-grey {
 border: 0px !important;
}
</style>

<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="wrapper-md">
    <div class="panel panel-default panel-default-form">
      <%@include file="/views/templates/panel-header-form.jsp"%>
      <div class="panel-body">
       <form name="lpoForm" class="form-horizontal" novalidate>
        <div class="row book-widget-row">
       <div class="col-sm-12 col-md-4 col-lg-4">
        <fieldset ng-disabled="viewDisable">
        
         <div class="form-group">
          <label class="col-md-5 control-label"> Company
          </label>
          <div class="col-md-7">
           <selectivity list="companyList" ng-model="lpoData.company" property="lpoData.company" 
           id="company_id" object="company" name="company_id"
           validation="required" friendly-name="Company" form-name = "lpoForm" disabled="true"></selectivity>
          </div>
         </div>
         
         

                  <!-- <div class="form-group">
          <label class="col-md-5 control-label"> Party Invoice No
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm" ng-model="lpoData.partyInvoiceNo"
           name="Party Invoice No" validation="required" friendly-name="Party Invoice No" >
          </div>
         </div> -->


           <div class="form-group">
          <label class="col-md-5 control-label"> Currency
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm" readonly ng-model="lpoData.currency"
            name="Currency" validation="required" friendly-name="Currency">
          </div>
         </div>

                  <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">Description</label>
                    <div class="col-md-7">
                      <textarea rows="2" class="form-control" name="Description" ng-model="lpoData.description" 
                      style="resize:none" ng-disabled="true"></textarea>
                    </div>
                  </div>

        </fieldset>
       </div>
           <div class="col-sm-12 col-md-4 col-lg-4">
        <fieldset ng-disabled="viewDisable">
        
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">LPO Date
                    </label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="pi_date">
                         <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                         ng-model="lpoData.lpoDate" name="Date" id="lpoDate"
                         validation="required" friendly-name="LPO Date" ng-disabled="true" />
                       <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                      </div>
                    </div>
                  </div>
                  
         
        <!--  <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">Party Invoice Date
                    </label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="party_date">
                         <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                          ng-model="lpoData.partyInvoiceDate" name="Party Invoice Date" id="party_invoice_date"
                          validation="required" friendly-name="Party Invoice Date">
                          <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                                </div>
                    </div>
                  </div> -->

         <div class="form-group">
           <label class="col-md-5 control-label"> Exchange Rate
           </label>
           <div class="col-md-7">
            <input type="text" class="form-control input-sm" readonly ng-model="lpoData.exchangeRate"
             name="Exchange Rate" validation="required" friendly-name="Exchange Rate">
           </div>
         </div>

         <div class="form-group">
          <label class="col-md-5 control-label"> TC Amount
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm" ng-model="lpoData.tcAmount"
            name="Amount(USD)" ng-keyup="amountLocalCalculation(lpoData.tcAmount)"
            validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="Amount(USD)" ng-disabled="true" />
          </div>
         </div>

                 </fieldset>
       </div>
           <div class="col-sm-12 col-md-4 col-lg-4">
         <fieldset ng-disabled="viewDisable">
         <div class="form-group">
          <label class="col-md-5 control-label"> Supplier
          </label>
          <div class="col-md-7">
           <!-- <select class="form-control input-sm" name="Suppliername" ng-model="lpoData.supplier" data-ng-options="r.supplier as r.supplierName for r in supplierList"
           ng-change="getSupplierCurrency(lpoData.supplier)" >
            <option value="" selected="selected">--Select--</option>
           </select> -->

           <selectivity list="supplierList" property="lpoData.supplier" ng-model="lpoData.supplier"  id="supplier_id" name="supplier_id"
           object="supplier" validation="required" friendly-name="supplier" form-name = "lpoForm" disabled="true"></selectivity>
          </div>
         </div>
         
           <!-- <div class="form-group">
          <label class="col-md-5 control-label"> Purchase Order No
          </label>
          <div class="col-md-7">
           <select class="form-control input-sm" name="Purchase No" ng-model="lpoData.purchaseOrderNo"
           data-ng-options="r.purchaseOrderNo as r.purchaseOrderNo for r in purchaseOrderList" ng-change="getPurchaseCur(lpoData.purchaseOrderNo)">
            <option value="" selected="selected">--Select--</option>
           </select>

           <selectivity list="purchaseOrderList" property="lpoData.purchaseOrderNo" id="purchaseOrder_id" object="purchaseOrder" disabled="true"></selectivity>

          </div>
         </div> -->

            <!-- <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">Due Date</label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="du_date">
                         <input type="text" class="form-control input-sm" name="Due Date"
                         placeholder="dd/mm/yyyy" id="due_date"
                         ng-model="lpoData.dueDate" validation="required" friendly-name="Due Date" >
                         <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                                </div>
                    </div>
                  </div> -->

         <div class="form-group">
          <label class="col-md-5 control-label"> BC Amount({{companyCurrency}})
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm" ng-model="lpoData.bcAmount"
            name="Amount" ng-keyup="amountCalculation(lpoData.bcAmount)" validation="numeric|required" 
            ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="BC Amount" ng-disabled="true" />
          </div>
         </div>
         
         </fieldset>

         </div>
      </div>
      <div class="table-responsive clear">
           <table class="table table-striped b-t b-light">
             <thead>
               <tr>
                  <th colspan=1 class="width_1"></th>
                  <th colspan=1  class="width_1 text-center">SI.No</th>
                   <!-- <th colspan=1  class="width_13 text-center">Sub Group</th> -->
                 <th colspan=1  class="width_13 text-center">Account Name</label></th>
                 <th colspan=1  class="width_13 text-center">Sub Account Code</th>
                 <th colspan=1  class="width_10 text-center">Short Details</label></th>
                 <th colspan=1 class=" width_10 text-center">Currency</label></th>
                 <th colspan=1 class=" width_10 text-center">Rate</label></th>
                 <th colspan=1 class="width_10 text-center">TC Amount</label></th>
                 <th colspan=1 class="width_10 text-center">BC Amount ({{companyCurrency}})</label></th>
                
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
          <selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
          ng-model="row.accountHeadCode" name ="accountHeadCode{{trIndex}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "lpoForm" disabled="true"></selectivity>
         </td>
         <td ng-hide="viewDisable">
         <!--  <selectivity list="subAccountCodeList" property="row.accountHeadCode" id="subAccountCode{{trIndex}}" object="account"
          ng-model="row.subAccountCode" name ="subAccountCode{{trIndex}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(Sub Account Head)'}}" form-name = "lpoForm" disabled="true"></selectivity> -->
          
           <selectivity list="row.subAccountCodeList" property="row.subAccountCode" id="subAccountCode{{trIndex}}" object="subAccount" disabled = "true" friendly-name="{{ 'Row' + $index + '(Sub Account Head)'}}" form-name = "lpoForm"></selectivity>
         </td>
         
         <!-- <td>
          <selectivity list="row.subAccountCodeList" property="row.subAccountCode" id="subAccountCode{{trIndex}}" object="subAccount" disabled="true"></selectivity>
         </td> -->
      
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm" id="shortDetails{{trIndex}}" ng-model="row.shortDetail" 
                      name="shortDetail" validation="required" friendly-name="{{ 'Row' + $index + '(Short Detail)'}}"  ng-disabled="true" />
                 </div>
                </div>
               </td>
               <td> 
                 <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency{{trIndex}}"
                      validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" ng-disabled="true" />
                      <!-- <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency"></selectivity>  -->
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm" id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate" 
                      name="exchangeRate{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}" 
                      ng-disabled="true" />
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm" id="tcAmount{{trIndex}}" ng-model="row.tcAmount"  name="tcAmount{{trIndex}}"
                      ng-keyup="amountCalculationTCTable(row.tcAmount,trIndex,row)" 
                      validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" 
                      friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" ng-disabled="true" />
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                     <input type="text" class="form-control input-sm"  id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}"
                      ng-keyup="amountCalculationBCTable(row.bcAmount,trIndex,row)"  ng-disabled="true"
                      validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" 
                      friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
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
                <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
           <label class="col-md-5 control-label"> Trip
            
           </label>
           <div class="col-md-7">
                        <selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
                <div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
           <label class="col-md-5 control-label"> Truck
            
           </label>
           <div class="col-md-7">
                     <selectivity list="vesselList" property="row.vesselCode" id="vesselCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <!-- <div class="col-sm-2 padding-top-5" ng-if="row.isService">
           <label class="col-md-5 control-label"> Service
            
           </label>
           <div class="col-md-7">
                       <selectivity list="sectorList" property="row.sectorCode" id="sectorCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div> -->
          <div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
           <label class="col-md-5 control-label"> Employee
            
           </label>
           <div class="col-md-7">
                     <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <!-- <div class="col-sm-2 padding-top-5" ng-if="row.isPort">
           <label class="col-md-5 control-label"> Port
            
           </label>
           <div class="col-md-7">
                     <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div> -->
          
          <!-- <div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
           <label class="col-md-5 control-label"> Port.Seq
            
           </label>
           <div class="col-md-7">
                    <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-disabled="viewDisable" ng-model="row.portSequence" name="PortSequence"/>
               </div>
          </div> -->
          
          <div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
           <label class="col-md-5 control-label"> Department
            
           </label>
           <div class="col-md-7">
                     <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          
          <div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
           <label class="col-md-5 control-label"> Agent
            
           </label>
           <div class="col-md-7">
                     <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          
          <div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
           <label class="col-md-5 control-label"> Location
            
           </label>
           <div class="col-md-7">
                       <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
           <label class="col-md-5 control-label"> Customer
            
           </label>
           <div class="col-md-7">
                       <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
           <label class="col-md-5 control-label"> Supplier
            
           </label>
           <div class="col-md-7">
                       <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
           <label class="col-md-5 control-label"> Designation
            
           </label>
           <div class="col-md-7">
                       <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
           <label class="col-md-5 control-label"> CostCtr
            
           </label>
           <div class="col-md-7">
                       <input type="text" class="form-control input-sm" ng-disabled="viewDisable" id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
           <label class="col-md-5 control-label"> Company
            
           </label>
           <div class="col-md-7">
                       <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
           <label class="col-md-5 control-label">Qty(MT)GO</label>
           <div class="col-md-7">
                       <input type="text" class="form-control input-sm" ng-disabled="viewDisable" id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
           <label class="col-md-5 control-label">Qty(MT)FO</label>
           <div class="col-md-7">
                       <input type="text" class="form-control input-sm" ng-disabled="viewDisable" id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
               </div>
          </div>
          </div>
            </td>                 
             </tr>
             </tbody>
           </table>
           <div class="col-sm-12 col-md-12 col-lg-12">
                <div class="col-md-8 col-md-offset-4">
                <fieldset ng-disabled="viewDisable">
          <div class="form-group">
          <label class="col-md-7 control-label">Total
          </label>
          <div class="col-md-2">
           <input type="text" class="form-control input-sm" ng-model="totalTCAmount" readonly
           name="TC Total" placeholder="0.0">
          </div>
          
          <div class="col-md-2">
           <input type="text" class="form-control input-sm" ng-model="totalBCAmount" readonly
           name="BC Total" placeholder="0.0">
          </div>
          
         </div>
        </fieldset>
        </div>
             </div>
             <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12">
            <div class="content">
              <div class="form-actions">
           <div class="row">
            <div class="col-md-12">
             <button class="btn btn-success"
             ng-click="printLPO(lpoData)">
              <i class="fa fa-save"></i> Print
             </button>
             <button class="btn btn-danger"
              class="btn btn-success" ng-click="cancel()">
              <i class="fa fa-close"></i> Cancel
             </button>
            </div>
           </div>
          </div><!-- /form-actions -->
         </div>
        </div>
       </div>
           </div> <!-- /table-responsive --> 
     </form>
    </div> <!-- /panel-body -->
   </div> <!-- /panel-default -->
  </div>
 </div>
</div>