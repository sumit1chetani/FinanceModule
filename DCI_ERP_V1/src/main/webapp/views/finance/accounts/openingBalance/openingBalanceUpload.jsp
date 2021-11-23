

<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
 
 <div class="panel-body float-left padding-0" style="width: 100%;">
     <div role="content">
    
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" data-st-table="displayedCollection" data-st-safe-src="rowCollection">
        <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
        <div class="dt-toolbar">
<%-- 		    <%@include file="/views/layout/toolbar-header.tpl.jsp"%>
 --%>	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('${form_code}_${delete}')"
	var="isDelete" />
<%-- <security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" /> --%>
<security:authorize access="hasRole('${form_code}_${upload}')"
	var="isUpload" />
<div>
<!-- 	<div
		class="col-xs-12 col-sm-3 pull-left width_17 padding-left-0 padding-right-0">
		<div class="dataTables_filter">
			<label> <span class="input-group-addon input-sm"> <i
					class="glyphicon glyphicon-search"></i>
			</span> <input type="search" data-st-search="" class="form-control input-sm"
				placeholder="Search">
			</label>
		</div>
	</div> -->
	<div class="col-xs-12 col-sm-1 padding-left-0" ng-hide="isDisplay">
		<table class="ui-pg-table navtable">
			<tbody>
				<%-- <tr>
					<c:if test="${isAdd}">
						<td class="ui-pg-button ui-corner-all" title="Add new row"
							id="del_jqgrid-table-0" ng-hide="isAdd">
							<div class="btn btn-sm btn-primary" data-ng-click="add()">
								<span class="fa fa-plus"></span>
							</div>
						</td>


						<!-- <td class="ui-pg-button ui-state-disabled" style="width: 4px;"
							ng-hide="isAdd"><span class="ui-separator"></span></td> -->
					</c:if>
					
				</tr> --%>
			</tbody>
		</table>
	</div>
	
 	</div>
		
		
		
                    <a id="Export" stype="display:none"
					href="filePath/OpeningBalance.xls" download="OpeningBalance.xls"></a>
                    
                    
                    
                    <div class="form-group col-sm-12 col-md-12 col-lg-12 ">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
												
		        <br>												
								<button type="button" class="btn btn-primary"
									ng-click="exportExcel()">
									<i class="fa fa-search"></i>Export Excel
								</button>
								
								<button class="btn btn-success"  type="button"
								ng-click="fileUpload()">
								<i class="fa fa-upload"></i> Upload
					            </button>
					            
					            <button type="button" class="btn btn-primary"
									ng-click="generateOBJv()">
									<i class="fa fa-search"></i>Generate Opening Balance JV
								</button>
												</div>
											</div>
										</div>
		<br>
		
		  
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         
		 
		 
		 
		 	<thead style="background-color: #e2e2e2;">
						<tr>
							 <th class="sorting width_2" st-sort="servicePartnerCode">Financial year</th>
						
						   <th class="sorting width_2" st-sort="servicePartnerCode">Account Head</th>
							<th class="sorting width_2" st-sort="servicePartnerCode">Invoice No</th>
							<th class="sorting width_5" st-sort="servicePartnerName">Invoice Date</th>
							<th class="sorting width_5" st-sort="servicePartnerLedgerName">Amount</th>
<!-- 							<th class="sorting width_2" st-sort="region">TC Amount</th>
 -->							<th class="sorting width_3" st-sort="country">Customer/Vendor</th>
							<th class="sorting width_3" st-sort="branchName">Organization Name</th>
					<!-- 		<th class="sorting width_4" st-sort="modifiedBy">Modified By</th>
							<th class="sorting width_3" st-sort="modifiedDate">Modified Date</th> -->
							

							<th class="sorting width_2 text-center table-heading">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							
							 <td class="sorting" >

										<span tooltip="{{objItem.finYear}}" class="tool-tip-span"
											>{{objItem.finYear}}</span>
								
									</td>
							  <td class="sorting" >

										<span tooltip="{{objItem.accountHead}}" class="tool-tip-span"
											>{{objItem.accountHead}}</span>
								
									</td>
                                      <td class="sorting" >

										<span tooltip="{{objItem.invoiceNo}}" class="tool-tip-span"
											>{{objItem.invoiceNo}}</span>
								
									</td>						
							
						<!-- 	<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerCode}}">{{objItem.servicePartnerCode}}</td> -->
							<td class="" data-toggle="tooltip"
												title="{{objItem.invoiceDate}}">{{objItem.invoiceDate}}</td>
							<td class="text-right" data-toggle="tooltip"
												title="{{objItem.bcAmount}}">{{objItem.bcAmount|number:2}}</td>
							<!-- <td class="" data-toggle="tooltip"
												title="{{objItem.tcAmount}}">{{objItem.tcAmount1}}</td> -->
							<td class="" data-toggle="tooltip"
												title="{{objItem.customerName}}">{{objItem.customerName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.companyName}}">{{objItem.companyName}}</td>
							
							

							<td class="td-actions text-center">
									<span class="edit-button  padding-right-5" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objItem.transactionid)"
										tooltip="Edit Row"> <i
										class="fa  fa-pencil text-success text"></i>
									</span>
							</td>
						</tr>
					</tbody>
					
		 
        </table>
       <!--  <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
        -->
        
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
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
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
  <a class="btn btn-success" href="assets/docs/SampleOpeningBalance.xlsx" class="control-label">Download sample excel file</a>
   <button class="btn btn-info" type="button" ng-click="uploadPIN()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>