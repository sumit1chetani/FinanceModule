 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%--  <security:authorize access="hasRole('F0319_${search}')" var="isSearch" /> --%>
<%--  <security:authorize access="hasRole('F0319_${send_mail}')"> --%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection1" st-safe-src="rowCollection">
 <%@include file="/views/templates/panel-header_1.jsp"%> 
  <div class="panel-body padding-0">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="sorting width_5 padding-both-side-5" st-sort="Payer">Customer</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="PayerName">Customer Name</th>
       <th class="sorting width_5 padding-both-side-5" st-sort="Balance">Balance</th>
       <th class="sorting width_4 padding-both-side-5" st-sort="0-15">0-15</th>
       <th class="sorting width_4 padding-both-side-5" st-sort="16-30">16-30 </th>
       <th class="sorting width_4 padding-both-side-5" st-sort="31-45">31-45</th>
       <th class="sorting width_4 padding-both-side-5" st-sort="46-60s" >46-60 </th>
       <th class="sorting width_4 padding-both-side-5" st-sort="Above60">Above-60 </th>
       <th class="sorting width_4 padding-both-side-5" st-sort="Above90">Above-90 </th>
       <th class="sorting width_4 padding-both-side-5" st-sort="Above100">Above-100 </th>
      <!--  <th class="sorting width_7 padding-both-side-5" st-sort="InvAmount">Paid Amt</th> -->
       <th class="sorting width_5 padding-both-side-5" st-sort="Above120">Above-120 </th>
       <th class="sorting width_7 padding-both-side-5" st-sort="Above180">Above-180 </th>
        <th class="sorting width_7 padding-both-side-5" st-sort="Forecast/Projection">Forecast/ Projection</th>
         <th class="sorting width_7 padding-both-side-5" st-sort="MTDCollection">MTD Collection</th>
          <th class="sorting width_7 padding-both-side-5" st-sort="Col(k)-(l)">Balance</th>
       <th class="sorting width_3 padding-both-side-5" st-sort="Country">Country</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objReceivable) in displayedCollection1">
       <td  tooltip="{{objReceivable.customerCode}}" class=" tool-tip-span padding-both-side-2" ng-bind="objReceivable.customerCode">{{objReceivable.customerCode}}
       </td>
       <td tooltip="{{objReceivable.customerName}}" class=" tool-tip-span padding-both-side-2" ng-bind="objReceivable.customerName">
       </td>
        <td tooltip="{{objReceivable.balanceAmount}}" class=" tool-tip-span padding-both-side-2 text-right" ng-bind="objReceivable.balanceAmount">
       </td> 
       <td 
        tooltip="{{objReceivable.below15Days}}" class=" tool-tip-span padding-both-side-2 text-right" ng-bind="objReceivable.below15Days">
       </td>
       <td tooltip="{{objReceivable.days30}}" class=" tool-tip-span padding-both-side-2 text-right" ng-bind="objReceivable.days30">
       </td>
       <td  tooltip="{{objReceivable.days45}}" class=" tool-tip-span padding-both-side-2 text-right" ng-bind="objReceivable.days45">
       </td>
       <td tooltip="{{objReceivable.days45to60}}" class=" tool-tip-span text-right" ng-bind="objReceivable.days45to60">
       </td>
       <td tooltip="{{objReceivable.days60andabove}}" class=" tool-tip-span text-right" ng-bind="objReceivable.days60andabove">
       </td>
       <td  tooltip="{{objReceivable.days90andabove}}" class=" tool-tip-span text-right" ng-bind="objReceivable.days90andabove">
       </td>
       <td  tooltip="{{objReceivable.days100andabove}}" class=" tool-tip-span text-right" ng-bind="objReceivable.days100andabove">
       </td>
       <!-- <td  tooltip="{{objReceivable.paidAmount}}" class="tool-tip-span" ng-bind="objReceivable.paidAmount">
       </td> -->
       <td  tooltip="{{objReceivable.above180days}}" class=" tool-tip-span text-right" ng-bind="objReceivable.above180days">
       </td>
       <td  tooltip="{{objReceivable.days120andabove}}" class=" tool-tip-span text-right" ng-bind="objReceivable.days120andabove">
       </td>
        <td ">
        <input type="text" class="form-control input-sm input-remarks padding-both-side-2 text-right"  ng-model="objReceivable.foreCastingAmt"/>
       	</td>
        <td  tooltip="{{objReceivable.collectionAmount}}" class=" tool-tip-span text-right" ng-bind="objReceivable.collectionAmount">
       	  <td  tooltip="{{objReceivable.foreCastingAmt-objReceivable.collectionAmount}}" class=" tool-tip-span text-right" ng-bind="objReceivable.foreCastingAmt-objReceivable.collectionAmount">
       <td  tooltip="{{objReceivable.location}}" class="tool-tip-span padding-both-side-2" ng-bind="objReceivable.location">
       </td>
      </tr>
     </tbody>
     
    
    </table>

   	   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" ng-click="saveReceivableForeCasting(displayedCollection)"  type="button">Save</button>
   					<button class="btn btn-danger" ng-click="cancel()"  type="button">Cancel</button>
   			        <span >
   				    <button class="btn btn-success" ng-click="fileUpload()"  type="button">Upload</button>
   				    </span>
   				</div>
   			</div>
   	</div>

 
 <script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
<button class="btn btn-info" type="button" id="exportXl"  ng-click="exportfile()">Download Sample File</button>
   <button class="btn btn-info" type="button" ng-click="upload('U')">Upload</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
 
</div>
</div>
</div>
 