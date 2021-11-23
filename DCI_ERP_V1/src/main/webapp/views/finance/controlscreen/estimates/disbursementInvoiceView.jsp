<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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

.i-checks input[disabled]+i:before, fieldset[disabled] .i-checks input+i:before {
    background-color: #23b7e5;
}
</style>

<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="wrapper-md">
    <div class="panel panel-default panel-default-form">
      <%@include file="/views/templates/panel-header-form.jsp"%>
      <div class="panel-body">
       <form name="purchaseInvoiceForm" class="form-horizontal" >
        <div class="row book-widget-row">
       <div class="col-sm-12 col-md-4 col-lg-4">
        <fieldset ng-disabled="viewDisable">
        
         <div class="form-group">
          <label class="col-md-5 control-label bold"> Company </label>
          <div class="col-md-7">
          <label class="form-label-control text-left" ng-bind="purchaseInvoiceData.companyName"></label>
          </div>
         </div>
         <input type="hidden" value="${form_code}" id="form_code_id">
         

                  <div class="form-group">
          <label class="col-md-5 control-label bold"> Party Invoice No </label>
          <div class="col-md-7">
          <label class=" control-label text-left" ng-bind="purchaseInvoiceData.partyInvoiceNo"></label>
          </div>
         </div>


           <div class="form-group">
          <label class="col-md-5 control-label bold"> Currency </label>
          <div class="col-md-7">
           <label class="control-label text-left" ng-bind="purchaseInvoiceData.currency"></label>
          </div>
         </div>

                  <div class="form-group">
                    <label class="control-label col-md-5 bold">Description</label>
                    <div class="col-md-7">
                   <label class="control-label text-left" ng-bind="purchaseInvoiceData.description"></label>
                   </div>
                  </div>

        </fieldset>
       </div>
           <div class="col-sm-12 col-md-4 col-lg-4">
        <fieldset ng-disabled="viewDisable">
        
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5 bold">Invoice Date</label>
                    <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.puchaseInvoiceDate"></label>
                  </div>
                  
         
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5 bold">Party Invoice Date</label>
                    <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.partyInvoiceDate"></label>
                  </div>

         <div class="form-group">
           <label class="col-md-5 control-label bold"> Exchange Rate </label>
           <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.exchangeRate"></label>
         </div>

         <div class="form-group">
          <label class="col-md-5 control-label bold"> TC Amount</label>
          <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.tcAmount"></label>
         </div>

                 </fieldset>
       </div>
           <div class="col-sm-12 col-md-4 col-lg-4">
         <fieldset ng-disabled="viewDisable">
         <div class="form-group">
          <label class="col-md-5 control-label bold"> Agent </label>
          <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.supplierName"></label>
         </div>
         
           <div class="form-group">
          <label class="col-md-5 control-label bold"> Purchase Order No </label>
          <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.purchaseOrderNo"></label>
         </div>

            <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5 bold">Due Date</label>
                    <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.dueDate"></label>
                  </div>

         <div class="form-group">
          <label class="col-md-5 control-label bold"> BC Amount</label>
          <label class="col-md-7 control-label text-left" ng-bind="purchaseInvoiceData.bcAmount"></label>
         </div>
         
         </fieldset>

         </div>
      </div>
      <div class="table-responsive clear">
           <table class="table table-striped b-t b-light">
             <thead>
                <tr>
                 <th colspan=1  class="width_13 text-center">Company<span style="color: red;">*</span></th>
                 <th colspan=1  class="width_13 text-center">Account Name<span style="color: red;">*</span></th>
                 <th colspan=1  class="width_13 text-center">Voyage</th>
                 <th colspan=1  class="width_13 text-center">Port</th>
                 <th colspan=1  class="width_13 text-center">Est Amt</th>
                 <th colspan=1  class="width_13 text-center" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1">Partial Alloc</th>
                 <th colspan=1 class=" width_8 text-center">Currency<span style="color: red;">*</span></th>
                 <th colspan=1 class=" width_8 text-center">Rate<span style="color: red;">*</span></th>
                 <th colspan=1 class="width_10 text-center">TC Amt<span style="color: red;">*</span></th>
                 <th colspan=1 class="width_10 text-center">BC Amt<span style="color: red;">*</span></th>
               </tr>
             </thead>
             <tbody ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceDetail">
              <tr>

         <td>
          <label class="col-md-7 " ng-bind="row.companyName"></label>
         </td>

         <td>
          <label class="col-md-7 " ng-bind="row.accountHeadName"></label>
         </td>
         <td>
          <label class="col-md-7 " ng-bind="row.voyageCode"></label>
         </td>

               <td> 
                <label class="col-md-7 " ng-bind="row.portCode"></label>
               </td>
               
               
                <td> 
                <label class="col-md-7 " ng-bind="row.estAmount"></label>
               </td>
               <td class="text-center" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1">
		          <span ng-if="row.status == 'P'">
		          	<label class="i-checks m-b-none"> <input type="checkbox" disabled checked><i></i></label>
		          </span>
		          <span ng-if="row.status == 'A'">
		          	<label class="i-checks m-b-none"> <input type="checkbox" disabled><i></i></label>
		          </span>
	           </td>
               <td>
                <label class="col-md-7 " ng-bind="row.currency"></label>
               </td>
               <td> 
                <label class="col-md-7 " ng-bind="row.exchangeRate"></label>
               </td>
               
               <td> 
                 <label class="col-md-7 " ng-bind="row.tcAmount"></label>
               </td>
               <td> 
                <label class="col-md-7 " ng-bind="row.bcAmount"></label>
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
           <label class="col-md-5 control-label bold"> Voyage

           </label>
           <div class="col-md-7">
                    <label class="col-md-7 w-s-no line-height-30" ng-bind="row.voyageCode"></label>
               </div>
          </div>
                <div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
           <label class="col-md-5 control-label bold"> Vessel

           </label>
           <div class="col-md-7">
                      <label class="col-md-7 line-height-30" ng-bind="row.vesselName"></label>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isService">
           <label class="col-md-5 control-label bold"> Service

           </label>
           <div class="col-md-7">
                        <label class="col-md-7 line-height-30" ng-bind="row.sectorName"></label>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
           <label class="col-md-5 control-label bold"> Employee

           </label>
           <div class="col-md-7">
                     <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isPort">
           <label class="col-md-5 control-label bold"> Port

           </label>
           <div class="col-md-7">
                     <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>

          <div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
           <label class="col-md-5 control-label bold"> Port.Seq

           </label>
           <div class="col-md-7">
                    <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence" ng-disabled="true"/>
               </div>
          </div>

          <div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
           <label class="col-md-5 control-label bold"> Department

           </label>
           <div class="col-md-7">
                     <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>

          <div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
           <label class="col-md-5 control-label bold"> Agent

           </label>
           <div class="col-md-7">
                     <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>

          <div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
           <label class="col-md-5 control-label bold"> Location

           </label>
           <div class="col-md-7">
                       <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
           <label class="col-md-5 control-label bold"> Customer

           </label>
           <div class="col-md-7">
                       <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
           <label class="col-md-5 control-label bold"> Supplier

           </label>
           <div class="col-md-7">
                       <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
           <label class="col-md-5 control-label bold"> Designation

           </label>
           <div class="col-md-7">
                       <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}" disabled="true"></selectivity>
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
           <label class="col-md-5 control-label bold"> CostCtr

           </label>
           <div class="col-md-7">
                       <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter" ng-disabled="true" />
               </div>
          </div>
          <!--  commented for inter-company transaction -->
          <!-- <div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
           <label class="col-md-5 control-label"> Company

           </label>
           <div class="col-md-7">
                       <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
               </div>
          </div> -->
          <div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
           <label class="col-md-5 control-label bold">Qty(MT)GO</label>
           <div class="col-md-7">
                       <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO" ng-disabled="true" />
               </div>
          </div>
          <div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
           <label class="col-md-5 control-label bold">Qty(MT)FO</label>
           <div class="col-md-7">
                       <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO" ng-disabled="true" />
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
          <label class="col-md-7 control-label bold">Total
          </label>
          <div class="col-md-2">
           <input type="text" class="form-control input-sm bold" ng-model="purchaseInvoiceData.tcAmount" readonly
           name="TC Total" placeholder="0.0">
          </div>
          
          <div class="col-md-2">
           <input type="text" class="form-control input-sm bold" ng-model="purchaseInvoiceData.bcAmount" readonly
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
              class="btn btn-success" ng-click="print(purchaseInvoiceData.puchaseInvoiceNo)">
              Print
             </button>
             
             <button class="btn btn-danger"
              class="btn btn-success" ng-click="cancel()">
              <i class="fa fa-close"></i> Cancel
             </button>
             
             <security:authorize access="hasRole('F0403_${approve}')">
             <button class="btn btn-success" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1"
              class="btn btn-success" ng-click="approve(purchaseInvoiceData.puchaseInvoiceNo)">
              Approve
             </button>
             
             <button class="btn btn-danger" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1"
              class="btn btn-success" ng-click="reject(purchaseInvoiceData.puchaseInvoiceNo)">
              <i class="fa fa-close"></i> Reject
             </button>
             </security:authorize>
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