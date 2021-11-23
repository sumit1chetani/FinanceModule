<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0">
  <div class="form-body form-horizontal">
   <div class="row m-t-sm">
    <div class="col-sm-12 col-md-12 col-lg-12">
     <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">From JV No.</label>
        <div class="col-md-7">
         <selectivity list="jvNoList" property="fromJvNo" id="fromJvNo"></selectivity>
        </div>
       </div>
       
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">To JV No.</label>
        <div class="col-md-7">
         <selectivity list="jvNoList" property="toJvNo" id="toJvNo"></selectivity>
        </div>
       </div>
      </fieldset>    
      
     </div>
     <div class="col-sm-12 col-md-6 col-lg-6">
      <div class="form-group">
       <button class="btn btn-primary" type="button" data-ng-click="jvBulkPrint();">
        Bulk Print
       </button>
      </div>
      
     </div>
     
      <div class="col-sm-12 col-md-3 col-lg-3">
      <fieldset>
       <div class="form-group">
        <label class="col-md-5 control-label  vessel-text">Estimates</label>
        <div class="col-md-7">
         <selectivity list="estimateTypeList" property="estFilter" id="estFilter"></selectivity>
        </div>
       </div>
      </fieldset>    
      
     </div>
     <div class="col-sm-12 col-md-6 col-lg-6">
      <div class="form-group">
       <button class="btn btn-success" type="button" data-ng-click="getList();">
        View
       </button>
      </div>
      
     </div>
    </div>
    
   </div>
  </div> 
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
      <tr>
       <!-- <th class="width_1">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </th> -->
       <th class="sorting width_10" st-sort="estimateCode">Estimates Code</th>
       <th class="sorting width_10" st-sort="jvNo">JV No</th>
       <th class="sorting width_20" st-sort="vesselName">Vessel Name</th>
       <th class="sorting width_12" st-sort="voyageId">Voyage</th>
       <th class="sorting width_30" st-sort="sectorName">Sector</th>
       <th class="sorting width_10" st-sort="voyageCostingStatus">Voyage Costing</th>
       <th class="sorting width_10" st-sort="estimatesStatus">Estimates</th>
       <th class="sorting width_10" st-sort="jvCostPostJvNo">JV Cost Posting</th>
       <th class="sorting width_10" st-sort="vesselOwner">Owner</th>
       <th class="sorting width_20" st-sort="status">Status</th>
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="estimate in displayedCollection">
       <!-- <td class="width_1">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </td> -->
       <td class="">
        <span ng-if="estimate.vesselOwner!='Third Party'">
          <a href="#/controlscreen/estimateView/{{estimate.estimateCode}}/view/{{estimate.vesselOwner}}/{{estimate.voyageCostingStatus}}">
            <span tooltip="{{estimate.estimateCode}}" class="tool-tip-span font-blue">{{estimate.estimateCode}}</span>
        </a>
        </span>
         <span ng-if="estimate.vesselOwner=='Third Party'">
          <a href="#/controlscreen/estimateThirdPartyView/{{estimate.estimateCode}}/view/{{estimate.vesselOwner}}/{{estimate.voyageCostingStatus}}">
            <span tooltip="{{estimate.estimateCode}}" class="tool-tip-span font-blue">{{estimate.estimateCode}}</span>
         </span>
        </td>
       <!-- <td class="sorting">{{estimate.jvNo}}</td> -->
        <td>  
        <span ng-repeat="jvno1 in estimate.jvNoList"><a ng-click="printJournalVoucherDiv(jvno1)"> 
               <span  class="tool-tip-span font-blue">{{jvno1}}</span>
  </a></span>
       </td>
       <td class="sorting">{{estimate.vesselName}}</td>
       <td class="sorting">{{estimate.voyageId}}</td>
       <td class="sorting">{{estimate.sectorName}}</td>
       <td class="sorting">{{estimate.voyageCostingStatus}}</td>
       <td class="sorting">{{estimate.estimatesStatus}}</td>
       <td class="sorting">  <a ng-click="printJournalVoucherDiv(estimate.jvCostPostJvNo)"> 
               <span  class="tool-tip-span font-blue">{{estimate.jvCostPostJvNo}}</span>
  </a> </td>
       
       <td class="sorting text-nowrap">{{estimate.vesselOwner}}</td>
       <td class="sorting"><span ng-if="estimate.status=='A'">Approved</span>
      <span ng-if="estimate.status=='P'">Pending</span>
      <span ng-if="estimate.status=='PA'">Partially Approved</span>
       </td>
       
       <td class="width_15 td-actions text-center text-nowrap">
          <security:authorize access="hasRole('${form_code}_${add}')">
          <!-- && estimate.voyageCostingStatus=='Y'  -->
        <span ng-if="estimate.estimatesStatus=='N'">
         <i class="fa  fa fa-plus text-success text" data-ng-click="add(estimate)"></i>
        </span>
        <!-- && estimate.vesselOwner=='Third Party' -->
        </security:authorize>
         <security:authorize access="hasRole('${form_code}_${modify}')">
        <span ng-if="(estimate.status=='P' || estimate.status=='A' || estimate.status=='PA')">
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(estimate)"></i>
        </span>
       <!--   <span ng-if="(estimate.status=='P' || estimate.status=='PA') ">
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(estimate)"></i>
        </span> -->
        </security:authorize>
          <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="estimate.status=='P'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(estimate)"></i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${approve}')">
        <span ng-if="estimate.voyageCostingStatus=='Y' && (estimate.status=='P' || estimate.status=='A' || estimate.status=='PA') ">
          <i class="fa fa-check  text" data-ng-click="approve(estimate)"></i>
         </span>
          <!-- <span ng-if="(estimate.status=='P' || estimate.status=='PA') ">
          <i class="fa fa-check  text" data-ng-click="approve(estimate)"></i>
         </span> -->
        </security:authorize>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div>