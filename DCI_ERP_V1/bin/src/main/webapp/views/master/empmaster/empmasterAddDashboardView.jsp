<style>
.field_set {
	border-color: #606060;
	border-style: solid;
}

.setBorder {
	border-style: solid;
	border-width: 1px;
}

/* a:link {
	//color: #200000;
} */
/* a:link {
	text-decoration: none;
} */
a:visited {
	text-decoration: none;
}

.displaynone {
	display: none;
}

.displayblock {
	display: inline-block;
}

a:hover {
	text-decoration: underline;
}

.ngdialog-content {
	background: #fff !important;
}

.tab-head {
	background: #1f3113 !important;
	color: black;
}

div#dependVisa1>ul {
	margin-left: -43% !important;
}

div#dependVisa>ul {
	margin-top: -75% !important;
}

  .nav-tabs > li > a {
color::#fff !important;
} 


.tabs-below > .nav-tabs,
.tabs-right > .nav-tabs,
.tabs-left > .nav-tabs {
    border-bottom: 0;
}

.tab-content > .tab-pane,
.pill-content > .pill-pane {
    display: none;
}

.tab-content > .active,
.pill-content > .active {
    display: block;
}

.tabs-below > .nav-tabs {
    border-top: 1px solid #ddd;
}

.tabs-below > .nav-tabs > li {
    margin-top: -1px;
    margin-bottom: 0;
}

.tabs-below > .nav-tabs > li > a {
    -webkit-border-radius: 0 0 4px 4px;
    -moz-border-radius: 0 0 4px 4px;
    border-radius: 0 0 4px 4px;
}

.tabs-below > .nav-tabs > li > a:hover,
.tabs-below > .nav-tabs > li > a:focus {
    border-top-color: #ddd;
    border-bottom-color: transparent;
}

.tabs-below > .nav-tabs > .active > a,
.tabs-below > .nav-tabs > .active > a:hover,
.tabs-below > .nav-tabs > .active > a:focus {
    border-color: transparent #ddd #ddd #ddd;
}

.tabs-left > .nav-tabs > li,
.tabs-right > .nav-tabs > li {
    float: none;
}

.tabs-left > .nav-tabs > li > a,
.tabs-right > .nav-tabs > li > a {
    min-width: 74px;
    margin-right: 0;
    margin-bottom: 3px;
}

.tabs-left > .nav-tabs {
    float: right;
    margin-right: 19px;
    border-right: 1px solid #ddd;
    height:400px;
    overflow-y: scroll;
     overflow-x: hidden;
}

.tabs-left > .nav-tabs > li > a {
    margin-right: -1px;
    -webkit-border-radius: 4px 0 0 4px;
    -moz-border-radius: 4px 0 0 4px;
    border-radius: 4px 0 0 4px;
}

.tabs-left > .nav-tabs > li > a:hover,
.tabs-left > .nav-tabs > li > a:focus {
    border-color: #eeeeee #dddddd #eeeeee #eeeeee;
}

.tabs-left > .nav-tabs .active > a,
.tabs-left > .nav-tabs .active > a:hover,
.tabs-left > .nav-tabs .active > a:focus {
    border-color: #ddd transparent #ddd #ddd;
    *border-right-color: #ffffff;
}

.tabs-right > .nav-tabs {
    float: right;
    margin-left: 19px;
    border-left: 1px solid #ddd;
}

.tabs-right > .nav-tabs > li > a {
    margin-left: -1px;
    -webkit-border-radius: 0 4px 4px 0;
    -moz-border-radius: 0 4px 4px 0;
    border-radius: 0 4px 4px 0;
}

.tabs-right > .nav-tabs > li > a:hover,
.tabs-right > .nav-tabs > li > a:focus {
    border-color: #eeeeee #eeeeee #eeeeee #dddddd;
}

.tabs-right > .nav-tabs .active > a,
.tabs-right > .nav-tabs .active > a:hover,
.tabs-right > .nav-tabs .active > a:focus {
    border-color: #ddd #ddd #ddd transparent;
    *border-left-color: #ffffff;
}

img.thumb-image
{
width:200px !important; 
max-height:200px !important;
}

</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
		 <legend>EMPLOYEE NAME  : {{EmployeeMasterData.firstName}}</legend>
		<div class ="col-md-2"> 
				
									<div class="col-md-12 ">
									
											<div id="image-holder">
											
											
											</div>
						
										
						
									</div>
                          	
						<div class="form-group">
					
							<label><b style="color:#0072C6 !important;">EMPLOYEE NAME : {{EmployeeMasterData.firstName}}</b></label>
						</div>	
						 <div class="form-group" ng-if="EmployeeMasterData.isEdit">
						
						<label><b >EMPLOYEE ID : {{employeeId}}</b></label>
						</div>							
						<div class="form-group">
						
							<label><b>DEPARTMENT : {{EmployeeMasterData.departmentCode}}</b></label>
						</div>			
									
									
				</div>
		
			<tabset class="tabs-left">  
			
			
			<tab heading="{{tabs[22].title}}" id="referenceTab" class="tab-head"
				active="tabs[22].active" ng-click="setInActive(22);">
			<form class="form-horizontal" name="Reference" id="referenceForm"
				novalidate method="post" ng-init="setForm(this);">
				<div class="row">
					
					<div class="col-sm-6 col-md-6 col-lg-6 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionRef"
														data-st-safe-src="rowCollectionRef">
														<div class="dt-toolbar" style="padding-bottom: 10px;">
															<!-- <button class="btn btn-sm btn-success width_12"
																style="height: 44px;" type="button"
																ng-click="addReference();">Add Reference</button> -->
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<!--     <th class="width_1"></th> -->
																	<th class="sorting width_20">GENERATE CHART </th>
																	
																	
																
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="EmployeeMasterDataRef in displayedCollectionRef">
																	<!--  <td data-cs-select="designation"></td> -->
																	<td class="wrapping">{{EmployeeMasterDataRef.referenceName}}</td>
																
															
																	
																</tr>
															</tbody>
														</table>
														<div class="dt-toolbar-footer"
															data-smart-include="views/layout/toolbar-footer.tpl"></div>
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
					</div>
				</div>
				
			</form>
			</tab>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 <!-- WIDGET END --> <tab heading="{{tabs[16].title}}" id="salesTab"
				class="tab-head" active="tabs[16].active"
				ng-click="setInActive(16);" ng-if='salesTab'>
			<div class="wrapper-md">
				<div class="form-actions-tab" ng-if='salesTab'>
					<div class="row">
						<div class="col-md-12" id="9">
							<button class="btn btn-info" ng-click="tabLabelPrevious();"
								style="margin-right: 1769%;">
								<i class="fa fa-arrow-left"></i>{{tabs[14].title}}
							</button>
							<!-- <button class="btn btn-info" style="margin-left: 1039px;margin-top:-54px;" ng-click="tabLabel(13)">
														{{tabs[14].title}}	<i class="fa fa-arrow-right"></i>													
													</button> -->
						</div>
					</div>
				</div>
				<div class="panel panel-default panel-default-list"
					st-table="displayedCollection"
					st-safe-src="customerdisplayedCollection">
					<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
					<!-- </div> -->
					<div class="panel-body float-left padding-0" style="width: 100%;">

						<div class="table-responsive ">
							<table
								class="table table-striped table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
								<thead>
									<tr>
										<th class="sorting width_2" st-sort="customerName">Customer
											Code</th>
										<th class="sorting width_2" st-sort="customerName">Account
											Head Code</th>
										<th class="sorting width_2" st-sort="customerName">Customer
											Name</th>
										<th class="sorting width_3" st-sort="customerShortName">Customer
											Short Name</th>
										<th class="sorting width_3" st-sort="country">Country</th>
										<th class="sorting width_3" st-sort="currency">Currency</th>
										<th class="sorting width_3" st-sort="status">Active</th>
										<th class="sorting width_2">Action</th>
									</tr>
								</thead>

								</thead>

								<tbody class="dataTables-Main-Body">

									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="objItem in displayedCollection">
										<td class="">{{objItem.customerCode}}</td>
										<td class="">{{objItem.accountNumber}}</td>
										<td class="">{{objItem.custName}}</td>
										<td class="">{{objItem.customerShortName}}</td>
										<td class="">{{objItem.countryName}}</td>
										<td class="">{{objItem.currency}}</td>
										<td class="">{{objItem.active}}</td>
										<!-- 	<td class="td-actions text-center"><span
											class="edit-button  padding-right-5"
											data-ng-click="editRow(objItem)" tooltip="Edit Row"> <i
												class="fa  fa-pencil text-success text"></i>
										</span> <span class="delete-button"
											data-ng-click="deleteCustomer(objItem.customerCode,$index)"
											tooltip="Delete Row"> <i
												class="fa fa-trash-o text-danger-dker tex"></i>
										</span></td> -->
									</tr>
								</tbody>


							</table>
						</div>
						<footer class="panel-footer panel-footer-list">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>
						<div class="form-actions-tab" ng-if='salesTab'>
							<div class="row">
								<div class="col-md-12" id="9">
									<button class="btn btn-info" ng-click="tabLabelPrevious();"
										style="margin-right: 1769%;">
										<i class="fa fa-arrow-left"></i>{{tabs[14].title}}
									</button>
									<!-- <button class="btn btn-info" style="margin-left: 1039px;margin-top:-54px;" ng-click="tabLabel(13)">
														{{tabs[14].title}}	<i class="fa fa-arrow-right"></i>													
													</button> -->
								</div>
							</div>
						</div>
					</div>
					<!-- end widget content -->
				</div>
			</div>
		</div>


		</tab>





		</tabset>


		<script type="text/ng-template" id="employeeConfirm">
<div
	class="modal-header modal-header-new padding-left-10 padding-top-0 padding-bottom-0 padding-right-0  line-height-30"
	style="font-weight: bold;">Your Employee Id and Password</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<label class="col-md-4 control-label">Employee ID:</label> <label
				class="col-md-1 control-label" style="padding-right: 0px;">{{EmployeeMasterData.empId}}</label>
		</div>
		<div class=" col-lg-12">
			<label class="col-md-4 control-label">Password:</label> <label
				class="col-md-1 control-label" style="padding-right: 0px;">{{EmployeeMasterData.pwd}}</label>
		</div>
	</div>
</div>
<div class="modal-footer" style="padding: 10px">
	<button class="btn btn-danger" ng-click="employeeConfirm()">Ok</button>
</div>
 </script>