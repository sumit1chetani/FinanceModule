<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>


<div class="row" style="margin-top: 15px;">



                          <div class="col-md-6 ">
          
          <button type="button" class="btn btn-primary"
									ng-click="exportExcel()">
									<i class="fa fa-download"> </i> Export to Excel
								</button>
           
			</div>

						          
      						
									
									
           						

							
									
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
           <th class="sorting width_8" data-st-sort="purchaseOrderNum">Purchase Order No</th>
           <th class="sorting width_7" data-st-sort="purchaseOrderDate">Purchase Order Date</th>
           <th class="sorting width_12" data-st-sort="reqType">Request Type</th>
            <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
           <th class="width_8 text-center table-heading">Action</th>
          </tr>
         </thead>
		<tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
           <!-- <td cs-select="collections"></td> -->
            <td>{{collections.purchaseOrderNum}}</td>
            <td>{{collections.purchaseOrderDate}}</td>
              <td>{{collections.reqType}}</td>
            <td>{{collections.vendorName}}</td>
            <td>{{collections.purchaseTypeName}}</td>
            <td>{{collections.purchaseStatus}}</td>
            <td class=" td-actions text-center">
          
        <span  ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' 
        && collections.purchaseStatus !='Cancelled' && collections.purchaseStatus != 'Recommend'
        && collections.purchaseStatus != 'Partially Recieved' && collections.purchaseStatus != 'Recieved'
         && collections.purchaseStatus != 'GRN Done' " >
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collections)"></i>
        </span>

         <span >
        <span 
        >
         <i class="fa  fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
        </span></span>
        <span   ng-if=" collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' 
        && collections.purchaseStatus !='Cancelled' && collections.purchaseStatus != 'Recommend'
        && collections.purchaseStatus != 'Partially Recieved' && collections.purchaseStatus != 'Recieved' 
         && collections.purchaseStatus != 'GRN Done' ">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
        </span>

        
        <!-- <span ng-if="collections.isDelete==true && collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' 
        && collections.purchaseStatus !='Cancelled' && collections.purchaseStatus != 'Recommend'
        && collections.purchaseStatus != 'Partially Recieved' && collections.purchaseStatus != 'Recieved' ">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
        </span> -->
        <!-- <span ng-if="collections.isPrint==true">
         <i class="fa fa-print text-dark text" title="Print" data-ng-click="printRow(collections)"></i>
        </span> -->  
        <span>      
         <i class="fa fa-print text-dark text" title="Print" data-ng-click="printPDF(collections)"></i>
        </span>
        
   <!--      <label class="col-xs-12"
        	data-ng-click="getProductInfo(trIndex)"> -->
        	<span class="fa fa-expand" title="POLog"  ng-if = "collections.poAmendmentNovalid == 'true' " data-ng-click = "poAmendmentLog(collections.purchaseOrderNum,collections.poAmendmentNo)"></span>
        	<!-- </label> -->
				<!-- <span ng-if = "collections.poAmendmentNo == true ">      
         <i class="fa fa-print text-dark text" title="Print" data-ng-click="printPDF(collections)"></i>
        </span>	 -->									
       <%--  <security:authorize access="hasRole('${form_code}_${print}')">
        <span ng-if="collections.isPrint==true">
         <i class="fa fa-print text-dark text" style="color: #3cf066;" title="Print for in Currency" data-ng-click="printRowforcurrecny(collections)"></i>
        </span></security:authorize> --%>
       </td>
          </tr>
         </tbody>
        </table>
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
       </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   <!-- WIDGET END -->
  </div>
