<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" novalidate name="revenueregisterform">

				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">MODE<span style="color: red;">*</span></label>
								<div class="col-md-8">
									<selectivity list="modeList" ng-model="revenueregister.voyage"
										property="revenueregister.voyage" id="voyage" object="voyage"
										name="voyage" validation="required"
										friendly-name="Voyage Name" form-name="revenueregisterform"></selectivity>

									</selectivity>
								</div>
							</div>

							<!-- <div class="form-group">
								<label class="col-md-4 control-label">FROM DATE</label>
								<div class="col-md-8">
									<ng-bs3-datepicker data-ng-model="revenueregister.fromDate"
										name="fromDate" id="fromDate" />
									<label class="control-label text-left" id="fromDate"
										name="fromDate">{{revenueregister.fromDate}}</label>
								</div>
							</div> -->

							<!-- <div class="form-group">
								<label class="col-md-4 control-label">CUSTOMER TYPE</label>
								<div class="col-md-8">
									<select id="customerType" multiple="multiple"
										name="customerType" ng-model="revenueregister.lCustomerType"
										ng-options="option.id for option in customerTypelist"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in customerTypelist"
											value="{{getCustomerTypeId(option)}}"
											data-ng-bind-template="{{option.customerType}}"></option>
									</select>
								</div>
							</div> -->

							<!-- <div class="form-group">
								<label class="col-md-4 control-label">POD</label>
								<div class="col-md-8">

									<select id="pod" multiple="multiple" name="pod"
										ng-model="revenueregister.lpod"
										ng-options="option.text for option in podList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in podList"
											value="{{getpodId(option)}}"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
									                          <selectivity list="portlist" ng-model="revenueregister.pod"
             property="revenueregister.pod" id="pod"  object="pod"  name="pod"
             validation="required" friendly-name="POD" form-name = "revenueregisterform">
             </selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">CUSTOMER</label>
								<div class="col-md-8">

									<select id="payer" multiple="multiple" name="payer"
										ng-model="revenueregister.lpayer"
										ng-options="option.text for option in payerList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in payerList"
											value="{{getpayer(option)}}"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
									                          <selectivity list="portlist" ng-model="revenueregister.pod"
             property="revenueregister.pod" id="pod"  object="pod"  name="pod"
             validation="required" friendly-name="POD" form-name = "revenueregisterform">
             </selectivity>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">From Invoice Date<span style="color: red;">*</span></label>
								<div class="col-md-8">
									<ng-bs3-datepicker
										data-ng-model="revenueregister.invoicefromDate"
										name="invoicefromDate" id="invoicefromDate" />
									<label class="control-label text-left" id="invoicefromDate"
										name="invoicefromDate"
										data-ng-model="revenueregister.invoicefromDate">{{revenueregister.invoicefromDate}}</label>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>


							<!--<div class="form-group">
								<label class="col-md-4 control-label">TO DATE</label>
								<div class="col-md-8">
									<ng-bs3-datepicker data-ng-model="revenueregister.toDate"
										name="toDate" id="toDate" />
									<label class="control-label text-left" id="toDate"
										name="toDate" data-ng-model="revenueregister.toDate">{{revenueregister.toDate}}</label>
								</div>
							</div>
							 <div class="form-group">
								<label class="col-md-4 control-label">CREDIT CATEGORY</label>
								<div class="col-md-8">
									<select id="creditCategory" multiple="multiple"
										name="creditCategory"
										ng-model="revenueregister.lcreditCategory"
										ng-options="option.creditCategory for option in creditCategorylist"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in categoryWiseList"
											value="{{getcreditCategoryOptionId(option)}}"
											data-ng-bind-template="{{option.creditCategory}}"></option>
									</select>
								</div>
							</div> -->
							<!--    <div class="form-group">
        <label class="col-md-4 control-label">LOL ISO CODE </label>
        <div class="col-md-8">
                <selectivity list="portIsoList" ng-model="revenueregister.portisocode"
             property="revenueregister.portisocode"  name="portisocode">
             </selectivity>
        </div>
       </div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">CUSTOMER</label>
								<div class="col-md-8">

									<select id="customer" multiple="multiple" name="customer"
										ng-model="revenueregister.lcustomer"
										ng-options="option.text for option in customerList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in customerList"
											value="{{getcustomer(option)}}"
											data-ng-bind-template="{{option.text}}"></option>  
									</select>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">PAYMENT CENTER</label>
								<div class="col-md-8">

									<selectivity list="paymentCenterList"
										ng-model="revenueregister.paymentCenter"
										property="revenueregister.paymentCenter" id="paymentCenter"
										object="paymentCenter" name="paymentCenter"
										validation="required" friendly-name="Payment Center"
										form-name="revenueregisterform"> </selectivity>
								</div>
							</div> -->

						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">COMPANY</label>
								<div class="col-md-8">
									<selectivity list="companyList"
										ng-model="revenueregister.company"
										property="revenueregister.company" id="company"
										object="company" name="company" validation="required"
										friendly-name="Company Name" form-name="revenueregisterform">
									</selectivity>

								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">LOL</label>
								<div class="col-md-7">

									<select id="pol" multiple="multiple" name="pol"
										ng-model="revenueregister.lpol"
										ng-options="option.text for option in polList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in polList"
											value="{{getpolId(option)}}"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
									             <selectivity list="portlist" ng-model="revenueregister.voyage"
             property="revenueregister.pol" id="pol"  object="pol"  name="pol"
             validation="required" friendly-name="Voyage Name" form-name = "revenueregisterform">
             </selectivity>
								</div>
							</div> -->


							<!-- <div class="form-group">
        <label class="col-md-4 control-label">LOD ISO CODE</label>
        <div class="col-md-8">
         <selectivity list="portIsoList" ng-model="revenueregister.podisocode"
             property="revenueregister.podisocode" id="podisocode"  object="podisocode"  name="podisocode">
             </selectivity>
        </div>
       </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">To Invoice Date<span style="color: red;">*</span></label>
								<div class="col-md-8">
									<ng-bs3-datepicker
										data-ng-model="revenueregister.invoicetoDate"
										name="invoicetoDate" id="invoicetoDate" />
									<label class="control-label text-left" id="invoicetoDate"
										name="invoicetoDate"
										data-ng-model="revenueregister.invoicetoDate">{{revenueregister.invoicetoDate}}</label>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div>
					<header id="btntoggle" data-role="heading"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a>Report Header</a>
						</div>
					</header>
					<div data-role="content" class="form-horizontal panel"
						data-collapse="isCollapsed">
						<ul class="dragList row list-unstyled">
							<li class="col-md-3 col-sm-3 col-lg-3">
								<div class="row">
									<label class="control-label col-md-8" style="width: 61%">SELECT
										ALL :</label>
									<div class="col-md-4" style="padding-left: 36px;">
										<label class="i-checks m-b-none checkbox"> <input
											type="checkbox" data-ng-click="selectAll(selectall)"
											data-ng-model="selectall" /><i style="margin-left: -12px;"></i>
										</label>
									</div>
								</div>
							</li>
							<li data-ng-repeat="column in messageHeaderList"
								class="col-sm-3 col-md-3 col-lg-3">
								<div class="row" data-ng-drag="column.isDraggable"
									data-ng-drop="column.isDraggable"
									data-ng-drop-success="onDropComplete($index, $data,$event)"
									data-ng-drag-data="column" style="width: 100%">
									<label class="control-label col-md-8">{{column.title}}
										:</label>
									<div class="col-md-4">
										<label class="i-checks m-b-none checkbox"> <input
											type="checkbox" data-ng-click="getSelectedColumn(column)"
											data-ng-model="column.visible"
											data-ng-disabled="column.isDefault" /><i></i>
										</label>
									</div>
								</div>
							</li>
							<li class="col-md-3 col-sm-3 col-lg-3 last-child"
								data-ng-drop="true"
								data-ng-drop-success="onDropComplete($index, $data,$event)">
								<div class="row">
									<div class="col-md-4">
										<label class="i-checks m-b-none checkbox"> </label>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" type="button" tooltip="Search"
								ng-click="onSearch(revenueregister)">
								<i class="fa fa-search"></i> Submit
							</button>
							<button type="reset" class="btn btn-info" tooltip="Reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<security:authorize access="hasRole('${form_code}_${export}')">

								<button id="exportXl" class="btn btn-primary"
									data-ng-click="excel(revenueregister);" type="button">
									<i class="fa fa-print"></i> Export Excel
								</button>
							</security:authorize>

						</div>
					</div>
				</div>


				<div class="panel panel-default panel-default-list"
					st-table="displayedCollection" st-safe-src="rowCollection">
					<%-- <div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold">
			 <%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%>
		</div> --%>
					<div class="panel-body float-left padding-0" style="width: 100%;">
						<div class="table-responsive ">
							<table
								class="table table-striped table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr>
										<th class="width_6"
											data-ng-repeat="column in messageHeaderList"
											data-ng-class={hide:(!column.visible)}>{{column.title}}</th>
									</tr>
								</thead>
								<tbody class="dataTables-Main-Body">
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="RevenueRegister in displayedCollection">
										<td class="width_6 padding-number-align text-center "
											data-ng-repeat="column in messageHeaderList"
											data-ng-class={hide:(!column.visible)}><span>{{RevenueRegister[column.id]}}</span>

										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<footer class="panel-footer panel-footer-list"
							style="padding: 0px;">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>
					</div>
				</div>


			</form>
		</div>
	</div>
</div>

