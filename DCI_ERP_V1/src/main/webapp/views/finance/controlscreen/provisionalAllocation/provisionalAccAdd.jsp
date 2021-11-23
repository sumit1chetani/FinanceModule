<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.remarks-td{
   padding: 0px 0px !important;
}
.input-remarks{
 height: 28px !important;
}

</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
    <form name="provisionalAllocationForm" class="" >
    <div class="row book-widget-row">


  <div class="col-sm-12">
   <fieldset>
    <div class="col-md-5">
     <div class="form-group">
           <label  class="control-label col-md-3 bold">Agent</label>
         <div class="col-md-9">
          <!-- <selectivity list="agentList" property="provisionalAllocation.agentCode"
       id="agentCode" name="agentCode"></selectivity>    -->  
       {{provisionalAllocation.agentName}}    
         </div>
           </div>
           <!-- <div class="form-group">
           <label  class="control-label col-md-5 bold">Month :</label>
         <div class="col-md-7">
          {{provisionalAllocation.monthOfYear}}   
         </div>
           </div> -->
    </div>
    
    <div class="col-md-4">
     <div class="form-group">
           <label  class="control-label col-md-3 bold">Vessel</label>
         <div class="col-md-8">
         {{provisionalAllocation.vesselName}}
          <!-- <selectivity list="vesselList" property="provisionalAllocation.vesselCode"
       id="vesselCode" name="vesselCode"></selectivity>   -->     
         </div>
           </div>
    </div>
    
    <div class="col-md-3">
     <div class="form-group">
           <label  class="control-label col-md-3 bold">Voyage</label>
         <div class="col-md-8">
         {{provisionalAllocation.voyageCode}}
          <!-- <selectivity list="voyageList" property="provisionalAllocation.voyageCode"
       id="voyageCode" name="voyageCode"></selectivity>  -->        
         </div>
           </div>
    </div>
     
    <div class="col-md-5">
     <div class="form-group">
           <label  class="control-label col-md-3 bold">Port</label>
         <div class="col-md-9">
         {{provisionalAllocation.portCode}}
         <!--  <selectivity list="portList" property="provisionalAllocation.portCode"
       id="portCode" name="portCode"></selectivity>   -->       
         </div>
           </div>
    </div>
    
    <div class="col-md-4">
     <div class="form-group">
           <label  class="control-label col-md-3 bold">Currency</label>
         <div class="col-md-8">
         {{provisionalAllocation.currency}}        
         </div>
           </div>
    </div>
     <div class="col-md-3">
    <div class="form-group" ng-hide="true">
           <label class="col-md-4 control-label bold"> Exchange Rate
            
           </label>
           <div class="col-md-7">
            <input type="text" class="form-control input-sm text-right"  ng-model="provisionalAllocation.exchangeRate"
             name="Exchange Rate" validation="required" friendly-name="Exchange Rate"  ng-blur="exchangeRateCalcAmount()">
            
           </div>
         </div>
         </div> 
         
         <div class="col-md-3">
    <div class="form-group">
             <label   class="control-label col-md-3 bold">Date
             </label>
             <div class="col-md-7">
              <div class="input-group input-append date" id="tb_disDate">
               <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="provisionalAllocation.disDate" name="disDate" id="disDate"> <span
                class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
               </span>
              </div>
             </div>
            </div>
    </div>
    <!-- <div class="col-md-4">
     <div class="form-group">
               <label  class="control-label col-md-5">Service</label>
             
                 <label class="col-md-4 form-control b-none" ng-bind="provisionalAllocation.sectorName"></label>
               </div>
             </div> -->
   </fieldset>
  </div>
 </div>

  <!-- <div class="form-actions">
   <div class="row">
    <div class="col-md-12">
     <button class="btn btn-success" type="button" ng-click="getProvisionalList('provision')">View</button>
    </div>
   </div>
  </div> -->
 </form>
  </div>
  
  <div class="panel-body float-left padding-0">
   <div class="table-responsive" >
  
    <table id="dt_basic" class="table table-striped table-bordered  dataTable no-footer"  width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">      
      <tr role="row">
      <th class="width_1"></th> 
       <th class=" width_20" >Expense</th>
       <th class=" width_20" >Expense Type</th>
       <th class=" width_20" >Account Name</th>
        <th class=" width_8" >Dis.TC Amt</th>
        <th class=" width_8" >Dis.BC Amt</th>
      <!--  <th class=" width_8">Est TC Amt</th> -->
       <th class=" width_8">Est Amt(USD)</th>
       <th class=" width_8">Exchange Rate</th>
       
       <th class=" width_10">Approved TC Amt</th>
       <th class=" width_10">Approved BC Amt(USD)</th>       
       <th class=" width_5" >Partial Alloc</th>
       <th class=" width_8">Balance Provision Amt(USD)</th>
        <th class=" width_8">Balance To Be Kept(USD)</th>
        <th class=" width_20" >Remarks</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body" >
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in provisionalAllocation.provisionalList">
        <td><label class="i-checks m-b-none"> <input type="checkbox" ng-click="setApproveAmountDefauldt(objTranslationItem,trIndex)" ng-model="objTranslationItem.select" id="select{{trIndex}}"><i></i></label></td> 
       <td class="width_20">
         <span tooltip="{{objTranslationItem.expenseName}}" class="tool-tip-span" ng-bind="objTranslationItem.expenseName"></span>
       </td>
       <td>
       	<span tooltip="{{objTranslationItem.expenseDesc}}" class="tool-tip-span" ng-bind="objTranslationItem.expenseDesc"></span>
       </td>
       <td class="width_20">
       <span ng-if='objTranslationItem.acctHeadName==null || objTranslationItem.acctHeadName==""'  ng-controller="disAllocTableCtrl">
       <!--  <selectivity list="accountList" property="row.acctHeadCode"
               id="acctHeadCode{{trIndex}}"  ng-model="row.acctHeadCode" name="acctHeadCode{{trIndex}}" validation="required"
               friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name="provisionalAllocationForm"></selectivity> -->
                  <selectivity list="accountList" property="objTranslationItem.acctHeadCode" 
               id="acctHeadCode{{trIndex}}" ng-model="objTranslationItem.acctHeadCode" name="acctHeadCode{{trIndex}}" validation="required"
               friendly-name="{{ 'Row' + $index + '(Dr Account Head)'}}" form-name="provisionalAllocationForm"></selectivity>
       </span>
         <span  ng-if='objTranslationItem.acctHeadName!=null || objTranslationItem.acctHeadName!=""' tooltip="{{objTranslationItem.acctHeadName}}"  class="tool-tip-span" ng-bind="objTranslationItem.acctHeadName"></span>
       </td>
        <td class="width_8 text-right" style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.disTcAmount}}" class="tool-tip-span text-right" ng-bind="objTranslationItem.disTcAmount"></span>
       </td>
       <td class="width_8 text-right" style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.disBcAmount}}" class="tool-tip-span text-right" ng-bind="objTranslationItem.disBcAmount"></span>
       </td>
      
     <!--   <td class="width_8" style="background-color: orange">
        <span tooltip="{{objTranslationItem.estTcAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.estTcAmount"></span>
       </td> -->
       <td class="width_8 text-right" style="background-color: orange">
        <span tooltip="{{objTranslationItem.estBcAmount}}" class="tool-tip-span text-right" ng-bind="objTranslationItem.estBcAmount"></span>
       </td>
       <td class="width_10 text-right" >
       
         <div class="col-xs-13">
           <input type="text" class="form-control input-sm text-right" id="exchangeRate{{trIndex}}" ng-model="objTranslationItem.exchangeRate" name="exchangeRate{{trIndex}}"
            validation="numeric|required"  step="0.01" 
            friendly-name="{{ 'Row' + $index + '(Exchange Rate))'}}" ng-blur="exchangeRateValidation(objTranslationItem.exchangeRate,trIndex,objTranslationItem)">
          </div>
       </td>
       
      <td>
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm text-right" id="approvedTcAmount{{trIndex}}" ng-model="objTranslationItem.approvedTcAmount" name="approvedTcAmount{{trIndex}}"
            validation="numeric|required"  step="0.01" ng-keyup="amountCalculationTCTable(objTranslationItem.approvedTcAmount,trIndex,objTranslationItem)"
            friendly-name="{{ 'Row' + $index + '(Approved TC Amount)'}}">
          </div>
         </div>
        </td>
        <td>
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm text-right" id="approvedBcAmount{{trIndex}}" ng-model="objTranslationItem.approvedBcAmount" name="approvedBcAmount{{trIndex}}"
            validation="numeric|required"  step="0.01" ng-keyup="amountCalculationBCTable(objTranslationItem.approvedBcAmount,trIndex,objTranslationItem)"
            ng-blur="exchangeRateValidation(objTranslationItem.exchangeRate,trIndex,objTranslationItem)" friendly-name="{{ 'Row' + $index + '(Approved BC Amount)'}}">
          </div>
         </div>
        </td>
        
       <td class="width_5">
       <!-- <selectivity list="approveTypeList" property="objTranslationItem.approveType" id="approveType"></selectivity> -->
       <label class="i-checks m-b-none"> <input type="checkbox" ng-click="setBalanceAmt(objTranslationItem)" ng-model="objTranslationItem.allocType" id="allocType{{trIndex}}"><i></i></label>
       </td>
       <td>
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm text-right" id="balanceAmount{{trIndex}}" ng-model="objTranslationItem.balanceAmount" name="balanceAmount{{trIndex}}"
            validation="numeric|required"  step="0.01" ng-keyup="totalCalc()" disabled="disabled"
            friendly-name="{{ 'Row' + $index + '(Balance Amount )'}}">
          </div>
         </div>
        </td>
        <td>
         <div class="row">
          <div class="col-xs-12">
           <input type="text" class="form-control input-sm text-right" id="balanceToKeptAmount{{trIndex}}" ng-model="objTranslationItem.balanceToKeptAmount" name="balanceToKeptAmountt{{trIndex}}"
            validation="numeric|required"  step="0.01" 
            friendly-name="{{ 'Row' + $index + '(Balance To Be Kept Amount )'}}">
          </div>
         </div>
        </td>
        <td  class="width_20">
         <div class="row">
          <div class="col-xs-12">
         <input type="text" class="form-control input-sm" name="remarks{{trIndex}}" id="remarks{{trIndex}}"  ng-model="objTranslationItem.remarks" />
         </div>
         </div>
       </td>
        <!-- <td class="width_20">
        <span>
            <i class="fa fa-check-circle-o font-size-12p" data-ng-click="approve(objTranslationItem)"></i>
             <button class="btn btn-dark btn-sm" type="button" data-ng-click="approve(objTranslationItem)">
            Approve
          </button>
        </span>
        <span>
            <i class="fa fa-check-circle font-size-12p" data-ng-click="partialApprove(objTranslationItem)"></i>
            <button class="btn btn-info btn-sm" type="button" data-ng-click="partialApprove(objTranslationItem)">
            Partial Approve
          </button>
        </span>
        </td> -->
      </tr>
     </tbody>
    </table>
    <br><br>
     <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">      
     
     </thead>
     <tbody class="dataTables-Main-Body">
     <td class="width_20"></td>
     <td class="width_17"></td>
     <td class="width_8"></td>
     <td class="width_8"></td>    
     <td class="width_8">Approved Total</td>
     <td class="width_10">
     <div class="row">
        <div class="col-xs-12">
           <input type="text" class="form-control input-sm text-right" ng-model="provisionalAllocation.approvedTcAmtTotal" readonly
              name="approvedTcAmtTotal" placeholder="0.0">
   </div> 
  </div>       
     </td>
      <td class="width_10">
     <div class="row">
        <div class="col-xs-12">
           <input type="text" class="form-control input-sm text-right" ng-model="provisionalAllocation.approvedBcAmtTotal" readonly
              name="approvedBcAmtTotal" placeholder="0.0">
   </div> 
  </div>       
     </td>
     <td class="width_5"></td>
     <td class="width_8"></td>
     <td class="width_20"></td>
     </tbody>
     </table>
     
    <!-- <table class="table table-striped b-t b-light">
           <thead>
            <tr>
             <th colspan=1 class="width_1"></th>
              <th class="sorting width_20" >Account Head</th>
          <th class="sorting width_8" >Dis.TC Amt</th>
          <th class="sorting width_8" >Dis.BC Amt</th>
         <th class="sorting width_8">Est Amt</th>
         <th class="sorting width_20" >Remarks</th>
            </tr>
           </thead>
           <tbody ng-repeat="(trIndex, row) in provisionalAllocation.otherProvisionalList" ng-controller="paTableCtrl">
            <tr>
             <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
             <td>
             <selectivity list="accountList" property="row.expenseName"
               id="acctHeadCode{{trIndex}}" object="account" ng-model="row.expenseName" name="expenseName{{trIndex}}" validation="required"
               friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name="provisionalAllocationForm"></selectivity>
             </td>             
             <td>
                    <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency{{trIndex}}"
                         validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly>
                          <selectivity list="currencyList" ng-model="row.currency" property="row.currency" id="currency{{trIndex}}" object="currency"
                          validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" name="{{ 'Row' + $index + '(Currency)'}}" form-name = "provisionalAllocationForm" ></selectivity>
                    </div>
                   </div>
                  </td>
                  <td> <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
                         name="exchangeRate{{trIndex}}"  ng-keyup ="calculateExchangeRateOnDtlTbl(row.exchangeRate,trIndex,row)"
                         validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}">
                    </div>
                   </div>  
                  </td>
             <td> <div class="row">
                       <div class="col-xs-12">
                         <input type="text" class="form-control input-sm" id="disTcAmount{{trIndex}}" ng-model="row.disTcAmount"  name="disTcAmount{{trIndex}}"
                         ng-keyup="totalCalc()"
                         validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" friendly-name="{{ 'Row' + $index + '(Disbursement TC Amount)'}}">
                    </div>
                   </div>
                </td>
             
              <td>
              <div class="row">
               <div class="col-xs-12">
                <input type="text" class="form-control input-sm" id="disBcAmount{{trIndex}}" ng-model="row.disBcAmount" name="disBcAmount{{trIndex}}"
                 validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="totalCalc()"
                 friendly-name="{{ 'Row' + $index + '(Dibursement BC Amount)'}}">
               </div>
              </div>
             </td>
             <td>
              <div class="row">
               <div class="col-xs-12">
                <input type="text" class="form-control input-sm" id="estBcAmount{{trIndex}}" ng-model="row.estBcAmount" name="estBcAmount{{trIndex}}"
                 validation="numeric|required" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="totalCalc()"
                 friendly-name="{{ 'Row' + $index + '(Estimate Amount)'}}">
               </div>
              </div>
             </td>
             
             
             <td>
              <div class="row">
               <div class="col-xs-12">
                <input type="text" class="form-control input-sm" id="otherRemarks{{trIndex}}" ng-model="row.otherRemarks" name="otherRemarks{{trIndex}}">
               </div>
              </div>
             </td>
            </tr>
           </tbody>
          </table> -->
          <!-- <div class="padding-right-5">
            <div class="col-md-4">
            <button ng-click="addRow(provisionalAllocation.otherProvisionalList)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
             <i class="fa fa-plus"></i>
            </button>
            <button ng-click="removeRow(provisionalAllocation.otherProvisionalList)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
             <i class="fa  fa-trash-o"></i>
            </button> 
           </div>
              <div class="col-md-8">
            <div class="form-group">
            <label class="col-md-3 control-label">Approved Amount Total
            </label> 
            <div class="col-md-3" >
             <input type="text" class="form-control input-sm text-right"  ng-model="provisionalAllocation.disTcAmountTotal" readonly
             name="TC Total" placeholder="0.0">
            </div>
  
            <div class="col-md-3">
             <input type="text" class="form-control input-sm text-right" ng-model="provisionalAllocation.disBcAmountTotal" readonly
             name="BC Total" placeholder="0.0">
            </div>
             <div class="col-md-3">
             <input type="text" class="form-control input-sm text-right" ng-model="provisionalAllocation.estBcAmountTotal" readonly
             name="BC Total" placeholder="0.0">
            </div>
  <div class="col-md-3">
             <input type="text" class="form-control input-sm" ng-model="provisionalAllocation.approvedAmtTotal" readonly
             name="approvedAmtTotal" placeholder="0.0">
            </div>
           </div>
          </div>
          </div> -->
          
   </div>
  <div class="form-actions">
   <div class="row">
    <div class="col-md-12">
          <span>
             <button class="btn btn-success" type="button" data-ng-click="approve(objTranslationItem)">
            Approve
          </button>
        </span>
         <span> 
         <button class="btn btn-danger " type="button" ng-click="back()"><i class="fa fa-arrow-left"></i>&nbsp; Back</button>         
        </span> 
   <span>   
   <button class="btn btn-danger" type="button" ng-click="cancel()">Cancel</button>
           <!--  <button class="btn btn-success" type="button" data-ng-click="partialApprove(objTranslationItem)">
            Partial Approve
          </button> -->
        </span> 
          </div></div>
          </div>
  
  </div>
 </div>
</div>
 