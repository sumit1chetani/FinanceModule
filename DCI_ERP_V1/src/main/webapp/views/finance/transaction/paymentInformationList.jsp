<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('F0257_S')" var="isSearch" />
<security:authorize access="hasRole('F0257_A')" var="isAdd" />
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list"   st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="panel-heading  padding-right-0 padding-left-0 font-bold">
   <div class="col-sm-3 col-md-9 padding-right-0 padding-left-0 header-with-breadcrumb">
  <!--   <state-breadcrumbs></state-breadcrumbs> -->
   </div>
   <%@include file="/views/templates/panel-header.jsp"%> 
  </div>
  <div class="panel-body padding-0">
  <div class="panel panel-default">
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<!-- <div class="col-sm-5 col-md-5 col-lg-5">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Company</label>
							<div class="col-md-6">
				<selectivity  list="companyList" property="paymentInformation.companyCode" id="companyCode"></selectivity>
							</div>
						</div>	
														
					</fieldset>
						</div>	 -->
						<div class="col-sm-5 col-md-5 col-lg-5">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Mode<span style="color: red">*</span></label>
							<div class="col-md-6">
				           <selectivity  list="modeList" property="paymentInformation.mode" id="mode"></selectivity>
							</div>
						</div>									
					</fieldset>
						</div>	
						<div class="col-sm-5 col-md-5 col-lg-5">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Status<span style="color: red">*</span></label>
							<div class="col-md-6">
				<selectivity  list="statusList" property="paymentInformation.status" id="status"></selectivity>
							</div>
						</div>									
					</fieldset>
						</div>		
						</div>
						
		</div>
		
		
 		<div align="center">
			<div class=" panel-body">
				<div class="col-md-12 ">
					<button class="btn btn-success" type="button"
						data-ng-click="search(paymentInformation);">
						<i class="fa fa-search"></i> Search
					</button>			
		 <button class="btn btn-info" type="reset" id="reset"
								data-ng-click="resetAll()">
								<i class="fa fa-undo"></i> Reset
							</button>
				</div>
			</div>
		</div> 
	</div>
  
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead style="background-color: #e2e2e2;">
     <tr>
     <th class="width_1"></th> 
            
       <th class="sorting width_10" st-sort="paymentInformationNo">Payment Order No</th>
       <th class="sorting width_10" st-sort="paymentInformationDate">Date</th>
       <!-- <th class="sorting width_10" st-sort="companyName">Company</th> -->
       <th class="sorting width_10" st-sort="supplierName">Supplier</th>
       <th class="sorting width_10" st-sort="status">Status</th>
       <th class="sorting width_5" >Actions</th>
     </tr>
     <!-- <tr>
      
      <th class="width_10">
          <input st-search="paymentInformationNo" placeholder="Payment Order No" class="input-sm form-control" type="search" />
         </th>
         <th class="width_10">
         <input st-search="paymentInformationDate" placeholder="Date" class="input-sm form-control" type="search" />
        </th>
        <th class="width_10">
         <input st-search="companyName" placeholder="Company" class="input-sm form-control" type="search" />
        </th>
        <th class="width_10">
         <input st-search="supplierName" placeholder="Supplier" class="input-sm form-control" type="search" />
        </th>
        <th class="width_10">
         <input st-search="statusName" placeholder="Status" class="input-sm form-control" type="search" />
        </th>
         <th></th>
        
      </tr>  -->
      </thead>
    <tbody class="dataTables-Main-Body" ng-repeat="(trIndex,objPaymentInformation) in displayedCollection" >
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"    >
       <td><label class="i-checks m-b-none"> <input type="checkbox"  ng-model="objPaymentInformation.select" id="select{{trIndex}}" ng-change="checkApproved(objPaymentInformation)"><i></i></label></td>
       <td class="width_10">
       	 <!-- <a href="#/transaction/paymentOrderView/{{objPaymentInformation.paymentInformationNo}}"> -->
         <span tooltip="{{objPaymentInformation.paymentInformationNo}}" class="tool-tip-span" ng-bind="objPaymentInformation.paymentInformationNo">
         </span>
       </td>
       <td class="width_10" ng-bind="objPaymentInformation.paymentInformationDate"></td>
       <!-- <td class="width_10">
        <span tooltip="{{objPaymentInformation.companyName" class="tool-tip-span text-wrap" ng-bind="objPaymentInformation.companyName"></span>
       </td> -->
        <td class="width_20">
        <span tooltip="{{objPaymentInformation.supplierName}}" class="tool-tip-span text-wrap" ng-bind="objPaymentInformation.supplierName"></span>
       </td>
       <td class="width_10" ng-if="objPaymentInformation.approvedBy == null || objPaymentInformation.approvedBy ==''">
        <span class="tool-tip-span text-wrap" >Pending</span>
       </td>
       <td class="width_10" ng-if="objPaymentInformation.approvedBy != null && objPaymentInformation.approvedBy !=''">
        <span class="tool-tip-span text-wrap" >Approved</span>
       </td>
        <td class="td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span >
         <i class="fa fa-pencil text-success text" data-ng-click="edit(objPaymentInformation)" tooltip="Edit">
         </i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span class ="padding-left-10">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deletePO(objPaymentInformation)" tooltip="Delete"></i>
        </span>
        </security:authorize>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   </div>
      <footer class="panel-footer panel-footer-list" style="padding:0px;">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
    <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					 <security:authorize access="hasRole('${form_code}_${approve}')">
   					<button class="btn btn-danger" ng-click="approvePaymentInformation(displayedCollection)"  type="button">Approve</button>
   					</security:authorize>
   	</div></div></div>
   </footer>
  
  <!-- end widget content -->
 </div>
</div>
 <script type="text/ng-template" id="PaymentOrderDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>