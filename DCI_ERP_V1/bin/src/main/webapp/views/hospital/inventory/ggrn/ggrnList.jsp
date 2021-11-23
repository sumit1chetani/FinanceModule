<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('${form_code}_${delete}')" var="isDelete" />
<security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" />
<security:authorize access="hasRole('${form_code}_${upload}')" var="isUpload" /> 

<!-- #MAIN CONTENT -->
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span><state-breadcrumbs></state-breadcrumbs> </span>
      <div class="widget-toolbar">
       <!-- add: non-hidden - to disable auto hide -->
       <div>
        <span> <span class="button-icon" data-reset-widgets rel="tooltip"
         title="<spring:message code="title.widget.reset"></spring:message>" data-placement="bottom">
          <i class="fa fa-refresh"></i>
        </span>
        </span>
       </div>
      </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding"> --%>
      
      <style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection"  st-persist="usermasterTable" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-10">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection" data-st-safe-src="rowCollection">
        <div class="dt-toolbar">
         <div>
		 <div class="col-xs-12 col-sm-3 pull-left width_17 padding-left-0 padding-right-0">
		  <div class="dataTables_filter">
		   <label>
		    <span class="input-group-addon input-sm">
		     <i class="glyphicon glyphicon-search"></i>
		    </span>
		    <input type="search" data-st-search="" class="form-control input-sm" placeholder="Search">
		   </label>
		  </div>
		 </div>
		 <div class="col-xs-12 col-sm-1 padding-left-0" ng-hide="isDisplay">
		  <table class="ui-pg-table navtable">
		   <tbody>
		    <tr>
		    <c:if test="${isAdd}">
		     <td class="ui-pg-button ui-corner-all" title="Add new row" id="del_jqgrid-table-0" ng-hide="isAdd">
		      <div class="btn btn-sm btn-primary" data-ng-click="add()">
		       <span class="fa fa-plus"></span>
		      </div>
		     </td>
		     <td class="ui-pg-button ui-state-disabled" style="width: 4px;" ng-hide="isAdd">
		      <span class="ui-separator"></span>
		     </td>
		     </c:if>
		      <c:if test="${isDelete}">
			     <td class="ui-pg-button ui-corner-all" id="jqgrid-table-0_iladd" title="Delete selected row" ng-hide="isDelete">
			      <div class="btn btn-sm btn-danger" data-ng-click="deleteSelected()">
			       <span class="fa fa-trash-o"></span>
			      </div>
			     </td>
			     <td class="ui-pg-button ui-state-disabled" style="width: 4px;" ng-hide="isDelete">
			      <span class="ui-separator"></span>
			     </td>
		     </c:if>
	   		<c:if test="${isUpload}">
		     <td class="ui-pg-button ui-corner-all" id="jqgrid-table-0_iladd" title="Upload" ng-hide="isUpload">
		      <div class="btn btn-sm btn-success" data-ng-click="fileUpload()">
		       <span class="fa fa-upload"></span>
		      </div>
		     </td>
		     </c:if>
		     <td class="ui-pg-button ui-corner-all" id="jqgrid-table-0_iladd" title="Export" ng-hide="isExport">
		    <div class="row">
							<a id="invReport" stype="display:none"
					href="tempdoc/GRN_File.xlsx" download="GRN_File.xlsx"></a>
									<div class="form-group col-sm-12 col-md-12 col-lg-12 ">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
													
															
														<button type="button" class="btn btn-primary"
									ng-click="exportExcel()">
									<i class="fa fa-download"> </i> Export to Excel
								</button>

												</div>
											</div>
										</div>
										</div>
		      <!-- <div class="btn btn-sm btn-success" data-ng-click="exportExcel()">
		       <span class="fa fa-file-excel-o"></span>
		      </div>
		      <div id="btnRowDivId"> </div> -->
		     </td>
		     
		    </tr>
		   </tbody>
		  </table>
		 </div>
		 <div class="col-xs-12 col-sm-1 col-sm-offset-7 pull-right">
		  <div class="dataTables_length">
		   <label>
		    <select name="dt_basic_length" aria-controls="dt_basic" class="form-control ng-pristine ng-valid" ng-model="itemsByPage" style="">
		     <option value="10">10</option>
		     <option value="25">25</option>
		     <option value="50">50</option>
		     <option value="100">100</option>
		    </select>
		   </label>
		  </div>
		 </div>
		</div>
        </div>
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th> -->
           <th class="sorting width_10" data-st-sort="grnCode">GRN No</th>
           <th class="sorting width_10" data-st-sort="grnDate">GRN Date</th>
           <th class="sorting width_10" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_10" data-st-sort="poNo">Purchase Order</th>
           <th class="sorting width_10" data-st-sort="poRequisition">Requisition</th>
            <th class="sorting width_10" data-st-sort="preparedBy">Prepared By</th>
           <th class="width_6 text-center table-heading"></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="objGrnList in displayedCollection">
          <!--  <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox"
             name="post[]"> <i></i>
           </label></td> -->
           <td class="sorting">{{objGrnList.grnCode}}</td>
           <td class="">{{objGrnList.grnDate}}</td>
           <td class="sorting">{{objGrnList.vendorName}}</td>
           <td class="">
            <!-- <span style="cursor:pointer;color:highlighttext; " -->
             <span style="cursor:pointer;color:black;"
             data-ng-click="navPoDetailsView(objGrnList.poId,objGrnList.purchaseType)">{{objGrnList.poNo}}</span>
           </td>
           <td class="sorting">{{objGrnList.poRequisition}}</td>
               <td class="sorting">{{objGrnList.preparedBy}}</td>
           <td class=" td-actions text-center">
           <security:authorize access="hasRole('${form_code}_${modify}')">
           <span>
             <i class="fa fa-list-alt text-dark text"
             data-ng-click="editRowBtn(objGrnList.grnCode)"></i>
           </span>
           </security:authorize>
           <%-- <security:authorize access="hasRole('${form_code}_${print}')">
        <!-- <span ng-if="collections.isPrint==true">
         <i class="fa fa-print text-dark text" title="Print" data-ng-click="printRow(collections)"></i>
        </span> -->  
        <span>      
         <i class="fa fa-print text-dark text" style="color: green;"  title="Print New" data-ng-click="GRNprint(objGrnList.grnCode)"></i>
        </span>
        </security:authorize> --%>
          <%--  <security:authorize access="hasRole('F0033_D')">
           <span> <i class="fa fa-trash-o text-danger-dker text"
             data-ng-click="deleteRow(objGrnList.grnCode,$index)"></i>
           </span>
           </security:authorize> --%>
           </td>
          </tr>
         </tbody>
        </table>
        
        <footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
       </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>