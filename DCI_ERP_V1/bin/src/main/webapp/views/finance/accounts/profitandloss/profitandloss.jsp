<%@ taglib prefix="security"
uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
      href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
      type="text/css" />
<head>
    <style>
        .main_head {
            /* background-color: #c3e3ef !important; */
            color: black;
            padding: 10px 15px;
            border-bottom: 1px solid transparent;
            border-radius: 2px 2px 0 0;
        }

        .solid {border-style: solid;}

        .data-table {
            margin-bottom: 7px !important;
        }
    </style>


</head>
<security:authentication var="user" property="principal" />
<div>
    <section data-widget-grid id="widget-grid">
        <div class="padding-top-10">
            <article class="col-sm-12">
                <div class="panel panel-default panel-default-list"
                     st-table="displayedCollection" st-safe-src="rowCollection">
                    <%@include file="/views/templates/panel-header-form.jsp"%>
                    <input type="hidden" value="${form_code}" id="form_code_id">
                    <div class="panel panel-default">
                        <div class="form-body form-horizontal">
                            <div class="row m-t-sm">
                                <form name="trialBalanceForm" class="form-horizontal">



                                    <div class="row">
                                        <div class="col-sm-12 col-md-12 col-lg-12">
                                            <!-- <div class="col-sm-4 col-md-4 col-lg-4">
                                                    <fieldset>
                                                            <div class="form-group">
                                                                    <label class="col-md-5 control-label"> Company
                                                                            <span style="color: red;">*</span>
                                                                    </label>
                                                                    <div class="col-md-7">
                                                                            <selectivity list="companyList" property="pl.company" id="company" object="companyCode"></selectivity>
                                                                    </div>
                                                            </div>
                                                    </fieldset>
                                            </div> -->
                                            <div class="col-sm-12 col-md-4 col-lg-4">
                                                <fieldset>
                                                    <div class="form-group">
                                                        <label class="col-md-5 control-label"> Organization <span
                                                                style="color: red;">*</span>
                                                        </label>
                                                        <div class="col-md-7">
                                                            <selectivity list="companyList" ng-model="pl.company"
                                                                         property="pl.company" id="company" object="company"
                                                                         name="organization"></selectivity>

                                                                                <!-- 											 <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="companyCodes"
                                                                                         ng-options="option.id as option.text for option in companyList" data-dropdownmultiselect>    
                                                                                           <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
                                                                                           ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
                                                                                        </select> -->
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <label class="col-md-5 control-label">Fund Type 
                                                        </label>
                                                        <div class="col-md-7">
                                                            <selectivity list="costList" id="costCenter"
                                                                         name="costCenter" form-name="trialBalanceForm"
                                                                         property="pl.costCenter"
                                                                         ng-model="pl.costCenter"
                                                                         friendly-name="Fund Type"  ></selectivity>
                                                        </div>
                                                    </div>
                                                </fieldset>
                                            </div>

                                            <div class="col-sm-4 col-md-4 col-lg-4">
                                                <input type="hidden" id="companyCode" value="${user.companyCode}">
                                                <fieldset>
                                                    <div class="form-group">
                                                        <label for="inputPassword" class="control-label col-md-5">From
                                                            Date <span style="color: red;">*</span>
                                                        </label>
                                                        <!-- <div class="input-group input-append date" id="pl_fromDate">
                                                                <input type="text" class="form-control input-sm"
                                                                        placeholder="dd/mm/yyyy" ng-model="pl.fromDate"
                                                                        name="fromDate" id="fromDate"> <span
                                                                        class="input-group-addon add-on"> <span
                                                                        class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                        </div> -->
                                                        <div class="col-md-7">

                                                            <ng-bs3-datepicker
                                                                ng-disabled="createQuote" data-ng-model="pl.fromDate"
                                                                id="toDate" name="From  Date"
                                                                data-ng-change="checkDatesCL(pl.fromDate)"
                                                                friendly-name="From Date" validation="required" />

                                                            <!-- <div class="dropdown">
                                                                    <a class="dropdown-toggle" id="tb_fromDate" role="button"
                                                                            data-toggle="dropdown" data-target="#" href="#">
                                                                            <div class="input-group">
                                                                                    <input type="text" class="form-control"
                                                                                            placeholder="dd/mm/yyyy" name="From Date" id="fromDate"
                                                                                            data-ng-model="pl.fromDate"> <span
                                                                                            class="input-group-addon"><i
                                                                                            class="glyphicon glyphicon-calendar"></i></span>
                                                                            </div>
                                                                    </a>
                                                                    <ul class="dropdown-menu" role="menu"
                                                                            aria-labelledby="dLabel">
                                                                            <datetimepicker data-ng-model="pl.fromDate"
                                                                                    data-on-set-time="pl.fromDate = onDateSet(newDate)"
                                                                                    data-datetimepicker-config="{ dropdownSelector: '#tb_fromDate',startView:'day', minView:'day'}" />
                                                                    </ul>
                                                            </div> -->




                                                        </div>
                                                        <!-- <div class='input-group date datetimepick' style="width: 69%;">
                                                <div class="dropdown">
                                                        <a class="dropdown-toggle" id="fromDate" role="button"
                                                                data-toggle="dropdown" data-target="#" href="#">
                                                                <div class="input-group">
                                                                        <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="fromDate"  id="fromDate"
                                                                                data-ng-model="pl.fromDate">
                                                                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
                                                                </div>
                                                        </a>
                                                        <ul class="dropdown-menu" role="menu"
                                                                aria-labelledby="dLabel">
                                                                <datetimepicker data-ng-model="pl.fromDate" data-on-set-time="pl.fromDate = onDateSet(newDate)"
                                                                        data-datetimepicker-config="{ dropdownSelector: '#tb_fromdate',startView:'day', minView:'day'}" />
                                                        </ul>
                                                </div>
                                        </div> -->
                                                    </div>
                                                </fieldset>
                                            </div>
                                            <div class="col-sm-4 col-md-4 col-lg-4">
                                                <fieldset>
                                                    <div class="form-group">
                                                        <label for="inputPassword" class="control-label col-md-5">To
                                                            Date <span style="color: red;">*</span>
                                                        </label>
                                                        <div class="col-md-7">
                                                            <!-- <div class="input-group input-append date" id="pl_toDate">
                                                                    <input type="text" class="form-control input-sm"
                                                                            placeholder="dd/mm/yyyy" ng-model="pl.toDate" name="toDate"
                                                                            id="toDate"> <span class="input-group-addon add-on">
                                                                            <span class="glyphicon glyphicon-calendar"></span>
                                                                    </span>
                                                            </div> -->



                                                            <ng-bs3-datepicker
                                                                ng-disabled="createQuote" data-ng-model="pl.toDate"
                                                                id="toDate" name="To Date"
                                                                data-ng-change="checkDatesCL(pl.toDate)"
                                                                friendly-name="To Date" validation="required" />

                                                            <!-- <div class='input-group date datetimepick' style="width: 100%;">
                                                                    <div class="dropdown">
                                                                            <a class="dropdown-toggle" id="tb_toDate" role="button"
                                                                                    data-toggle="dropdown" data-target="#" href="#">
                                                                                    <div class="input-group">
                                                                                            <input type="text" class="form-control"
                                                                                                    placeholder="dd/mm/yyyy" name="From Date" id="toDate"
                                                                                                    data-ng-model="pl.toDate"> <span
                                                                                                    class="input-group-addon"><i
                                                                                                    class="glyphicon glyphicon-calendar"></i></span>
                                                                                    </div>
                                                                            </a>
                                                                            <ul class="dropdown-menu" role="menu"
                                                                                    aria-labelledby="dLabel">
                                                                                    <datetimepicker data-ng-model="pl.toDate"
                                                                                            data-on-set-time="pl.toDate = onDateSet(newDate)"
                                                                                            data-datetimepicker-config="{ dropdownSelector: '#tb_toDate',startView:'day', minView:'day'}" />
                                                                            </ul>
                                                                    </div>
                                                            </div> -->
                                                        </div>
                                                    </div>
                                                </fieldset>
                                            </div>
                                        </div>
                                    </div>


                                    <a id="PLExport" stype="display:none"
                                       href="filePath/ProfitAndLoss.xls" download="ProfitAndLoss.xls"></a>
                                    <div class="form-actions">
                                        <div class="row">
                                            <div class="col-md-12 ">

                                                <%-- <security:authorize access="hasRole('${form_code}_${view}')">
                                                    <button class="btn btn-success"
                                                            ng-click="viewProfitLossNewhor(pl.company)">
                                                        <i class="fa fa-search"></i>View Horizontal Report
                                                    </button>
                                                </security:authorize> --%>

                                                <security:authorize access="hasRole('${form_code}_${view}')">
                                                    <button class="btn btn-success"
                                                            ng-click="viewProfitLossNewVer(pl.company)">
                                                        <i class="fa fa-search"></i>View  Report
                                                    </button>
                                                </security:authorize>

                                                <%-- 	<security:authorize access="hasRole('${form_code}_${export}')">
                                                    <button class="btn btn-primary" ng-click="exportPLExcelVer()">
                                                        <i class="fa fa-search"></i>Export Horizontal Excel
                                                    </button>
                                                </security:authorize> --%>

                                                <a id="exportBS" stype="display:none" href="{{filePath}}"
                                                   download="ProfitAndLoss.xls"></a>


                                                <button class="btn btn-success" class="btn btn-success"
                                                        data-ng-click="exportPLExcel()">Excel export</button>

	
												<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/Income and Expenditure.pdf"
											download="Income and Expenditure.pdf"></a>
									</button>


                                            </div>
                                        </div>
                                    </div>
                                    <!-- <div class="row">
                                    <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid">
                                                    <table id="plReportGrid"></table>
                                                    <div id="plReportGridPage"></div>
                                            </div>	
                           </div> -->

                                    <div class= "" > </div>

                                     <div class="col-sm-2 col-md-2 col-lg-2">
                                    
                                    </div>
                                    <div class="col-sm-8 col-md-8 col-lg-8 solid">
                                    
                                    <div align="center"><img src="/img/MBKHelpVideos/Dental_Council_of_India_logo1.png"></div>
                                        <div
                                            class="main_head  bold toggleBlock-currsor text-center fontSize13 ">
                                            <!-- INCOME and EXPENDITURE - {{pl.companyName}}</div> -->
                                            <u>Dental Council Of India</u></div>

                                        <div 
                                            class="main_head  bold toggleBlock-currsor text-center fontSize13 ">
                                            <!-- INCOME and EXPENDITURE - {{pl.companyName}}</div> -->
                                            INCOME And EXPENDITURE</div>

                                        <table ng-if="viewHor" 
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr>
                                                    <th class="text-center "
                                                        style="/* background: #c3e3ef !important */;">Particulars</th>
                                                    <th class="text-center " ng-if="!malaysia"
                                                        style="/* background: #c3e3ef !important; */">Amount (USD)</th>
                                                    <th class="text-center  " ng-if="malaysia"
                                                        style="/* background: #c3e3ef !important; */">Amount (MYR)</th>
                                                </tr>
                                            </thead>
                                        </table>
                                        <table ng-if="viewHor"
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr ng-click="toggleBlock('sales-record')">
                                                    <th class="  ">Direct Incomes - ( A )</th>
                                                    <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal
                                                                | number:2}}</th>
                                                </tr>
                                            </thead>
                                            <tbody id="sales-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue">
                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>
                                        </table>
                                        <table ng-if="viewHor"
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr ng-click="toggleBlock('cos-record')">
                                                    <th class="  ">Direct Expenses - ( B )</th>
                                                    <th class="text-center   text-right">{{profitLoss.dCostOfSalesTotal
                                                                | number:2}}</th>
                                                </tr>
                                            </thead>
                                            <tbody id="cos-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lCostOfSales">
                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>
                                        </table>

                                        <table ng-if="viewHor"
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr class="main_head">
                                                    <th class="text-center   "
                                                        style="/* background: #c3e3ef !important */">Gross Profit : C=
                                                        (A+B)</th>
                                                    <th class="text-center   text-right"
                                                        style="/* background: #c3e3ef !important */">{{profitLoss.dSalesRevenueTotal
                                                                    + profitLoss.dCostOfSalesTotal| number:2}}</th>
                                                </tr>
                                            </thead>
                                        </table>

                                        <table ng-if="viewHor"
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr ng-click="toggleBlock('ii-record')">
                                                    <th class="  ">Indirect Income - ( D )</th>
                                                    <th class="text-center   text-right">{{profitLoss.dOtherIncome
                                                                | number:2}}</th>
                                                </tr>
                                            </thead>
                                            <tbody id="ii-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome">
                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>
                                        </table>
                                        <table ng-if="viewHor"
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr ng-click="toggleBlock('ie-record')">
                                                    <th class="  ">Indirect Expenses E =
                                                        (IE1+IE2+IE3+IE4+IE5+IE6+IE7)</th>


                                                    <th class="text-center   text-right">{{(profitLoss.dTravellingCost
                                                                +
                                                                profitLoss.dSalesandBuss) + (profitLoss.dPersonalCost) + (profitLoss.dFinanceCost) + (profitLoss.dCommunctionExpense) + (profitLoss.dAdminExpense) + profitLoss.dRentCost
                                                                | number:2}}</th>
                                                </tr>
                                            </thead>
                                            <!-- <tbody id="ie-record"> -->
                                            <tr ng-click="toggleBlock('ie1-record')">
                                                <th class="  ">Travelling Cost (IE1)</th>
                                                <th class="text-center   text-right">{{profitLoss.dTravellingCost
                                                            | number:2}}</th>
                                            </tr>
                                            <tbody id="ie1-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lTravellingCostList">

                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>


                                            <tr ng-click="toggleBlock('ie2-record')">
                                                <th class="  ">Sales & Buisness Cost (IE2)</th>
                                                <th class="text-center   text-right">{{profitLoss.dSalesandBuss
                                                            | number:2}}</th>
                                            </tr>
                                            <tbody id="ie2-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lSalesandBusinessList">

                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>

                                            <tr ng-click="toggleBlock('ie3-record')">
                                                <th class="  ">Personal Cost (IE3)</th>
                                                <th class="text-center   text-right">{{profitLoss.dPersonalCost|
							number:2}}</th>
                                            </tr>
                                            <tbody id="ie3-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lPersonalCostList">

                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>

                                            <tr ng-click="toggleBlock('ie4-record')">
                                                <th class="  ">Finance Cost (IE4)</th>
                                                <th class="text-center   text-right">{{profitLoss.dFinanceCost|
							number:2}}</th>
                                            </tr>
                                            <tbody id="ie4-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lFinanceCost">

                                                    <td class="sorting ">{{row.accountHeadNameAdmin}}</td>
                                                    <td class="sorting text-right">{{row.amountAdmin|
								number:2}}</td>

                                                </tr>
                                            </tbody>


                                            <tr ng-click="toggleBlock('ie5-record')">
                                                <th class="  ">Communication Cost (IE5)</th>
                                                <th class="text-center   text-right">{{profitLoss.dCommunctionExpense|
							number:2}}</th>
                                            </tr>
                                            <tbody id="ie5-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lCommuncationCostList">

                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>
                                            <tr ng-click="toggleBlock('ie6-record')">
                                                <th class="  ">Administrative Cost (IE6)</th>
                                                <th class="text-center   text-right">{{profitLoss.dAdminExpense|
							number:2}}</th>
                                            </tr>
                                            <tbody id="ie6-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lAdminExpense">

                                                    <td class="sorting ">{{row.accountHead}}</td>
                                                    <td class="sorting text-right">{{row.amount| number:2}}</td>

                                                </tr>
                                            </tbody>
                                            <tr ng-click="toggleBlock('ie7-record')">
                                                <th class="  ">Rent Cost (IE7)</th>
                                                <th class="text-center   text-right">{{profitLoss.dRentCost|
							number:2}}</th>
                                            </tr>
                                            <tbody id="ie7-record">
                                                <tr ng-repeat="(trIndex, row) in profitLoss.lRentCostList">

                                                    <td class="sorting ">{{row.accountHeadNameAdmin}}</td>
                                                    <td class="sorting text-right">{{row.amountAdmin|
								number:2}}</td>

                                                </tr>
                                            </tbody>


                                            <!--   </tbody> -->
                                        </table>
                                        <table ng-if="viewHor"
                                               class="table table-striped table-hover data-table no-footer">
                                            <thead class="dataTables-Main-Head">
                                                <tr class="main_head">
                                                    <th class="text-center   "
                                                        style="/* background: #c3e3ef !important; */">Profit of The Year
                                                        H =( C+D+E )</th>
                                                    <th class="text-center   text-right"
                                                        style="/* background: #c3e3ef !important */;">
                                                        {{(profitLoss.dSalesRevenueTotal +
                                                                    profitLoss.dCostOfSalesTotal) + (profitLoss.dOtherIncome) + (profitLoss.dTravellingCost
                                                                    +
                                                                    profitLoss.dSalesandBuss) + (profitLoss.dPersonalCost) + (profitLoss.dFinanceCost) +
                                                                    (profitLoss.dCommunctionExpense) + (profitLoss.dAdminExpense) + (profitLoss.dRentCost)
                                                                    | number:2}}
                                            </thead>
                                        </table>
                                        <br> <br>
                                        <div class="col-sm-8 col-md-8 col-lg-8">

                                            <div class="col-sm-8 col-md-12 col-lg-12">
                                                <table ng-if="viewVer" width=93% align="center"
                                                       cellpadding="10" cellSpacing="0" style="margin-left: 10px;">

                                                    <tr style="/* background: #c3e3ef !important; */">
                                                            <!-- <td class="width_10" align="center" style="font-size: 10px;"><b>Group Code</b></td> -->
                                                        <td  align="left" height="40"
                                                             style="font-size: 13px;"><left>
                                                        <font size="2" face="arial"><b>PARTICULARS</b></font>
                                                    </left></td>
                                                    <td width="100" align="right" height="40" 
                                                         style="font-size: 13px;"><right>
                                                        <font size="2" face="arial"><b>AMOUNT</b></font>
                                                    </right></td>

                                                    </tr>

                                                    <tr style="/* background: #c3e3ef !important; */">
                                                            <!-- <td class="width_10" align="center" style="font-size: 13px;"><b>Group Code</b></td> -->
                                                        <td colspan="2" class=" " align="left" height="40"
                                                            style="font-size: 13px;"><left>
                                                        <font size="2" face="arial"><b><u>INCOME</u></b></font>
                                                    </left></td>

                                                    </tr>



                                                    <%-- 
                                                    <tr>
                                                        <th class="  " colspan="2"  style="font-size: 15px;  height: 40px;"> 

                                                            <a ng-click="Click('DIRECT INCOMES')"> <security:authorize
                                                                    access="hasRole('${form_code}_${view}')">

                                                                    <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                          class="tool-tip-span">SALES ACCOUNTS
                                                                    </span>
                                                                </security:authorize></a>

                                                        </th>
                                                <!-- 12-04-2019	<th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal
                                                                | number:2}}</th>-->
                                                    </tr>
                                                    <tbody id="sales-record">
                                                        <tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue1">
                                                            <td class="width_30" align="left" height="20"
                                                                style="font-size: 10px;">&nbsp
                                                                <a ng-click="AccountClick(row.accountHeadName)"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">{{row.accountHead}}
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </td>
                                                            <td class="width_30" align="right" height="20"
                                                                style="font-size: 10px;">{{row.amount| number:2}} &nbsp</td>
                                                        </tr>

                                                    </tbody>
                                                    --%>


                                                    <tr>
                                                        <th class="  " colspan="2"  style="font-size: 13px;  height: 40px;"> 

                                                            <a ng-click="Click('DIRECT INCOMES')"> <security:authorize
                                                                    access="hasRole('${form_code}_${view}')">

                                                                    <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                          class="tool-tip-span">DIRECT INCOMES
                                                                    </span>
                                                                </security:authorize></a>

                                                        </th>
                                                <!-- 12-04-2019	<th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal
                                                                | number:2}}</th>-->
                                                    </tr>
                                                    <tbody id="sales-record">
                                                        <tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue">
                                                            <td class="width_30" align="left" height="20"
                                                                style="font-size: 13px;">&nbsp
                                                                <a ng-click="AccountClick(row.accountHeadName)"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">{{row.accountHead}}
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </td>
                                                            <td class="width_30" align="right" height="20"
                                                                style="font-size: 13px;">{{row.amount| number:2}} &nbsp</td>
                                                        </tr>

                                                    </tbody>





                                                </table>

                                                <table ng-if="viewVer" width=80% align="center"  le>
                                                    <table ng-if="viewVer" width=80% align="center" ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>

                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>

                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>


                                                    <!--np  -->
                                                    <table ng-if="viewRight" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 10px;">


                                                        <!-- <tr>
                                                                <th class="  ">GROSS PROFIT C/F </th>
                                                                <th class="text-center   text-right">{{((-profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal)|
                                                                        number:2}}</th>
                                                        </tr> -->

                                                        <!-- <tr>
                                                                <th class="  "></th>
                                                                <th class="text-center   text-right">{{(profitLoss.dCostOfSalesTotal)|
                                                                        number:2}}</th>
                                                        </tr> -->

                                                    </table>

                                                    <!--np  -->

                                                    <!--nl  -->

                                                    <table ng-if="viewLeft" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 10px;">
                                                        <tr>
                                                                 <th class="  ">TOTAL-(A)</th>
                                                                  <th class="text-center   text-right">{{(profitLoss.dSalesRevenueTotal)|number:2}}</th>
                                                         </tr> 
                                                    </table>
                                                    <table ng-if="viewLeft" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 10px;     margin-top: 15px;">


                                                        <!-- <tr>
                                                                <th class="  ">GROSS PROFIT B/F </th>   B/f to c/f
                                                                <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
                                                                        number:2}}</th>
                                                        </tr> -->





                                                    </table>

                                                    <!--nl  -->


                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>
                                                    <table  width=80% align="center"  ></table>




                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 10px;">

                                                        <tr>
                                                            <th class="  " style="font-size: 13px;  height: 40px;">

                                                                <a ng-click="Click('INDIRECT INCOME')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">INDIRECT INCOMES 
                                                                        </span>
                                                                    </security:authorize></a>

                                                            </th>
                                                            <th class="text-center   text-right"></th>
                                                        </tr>
                                                        <tbody id="sales-record">
                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 13px;">&nbsp 
                                                                    <a ng-click="AccountClick(row.accountHeadName)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>

                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 13px;">{{row.amount| number:2}} &nbsp</td>
                                                            </tr>

                                                        </tbody>
                                                        <%-- 
                                                        <tr>
                                                            <th class="  " style="font-size: 15px;  height: 40px;">

                                                                <a ng-click="Click('INDIRECT INCOME')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">CLOSING STOCK
                                                                        </span>
                                                                    </security:authorize></a>

                                                            </th>
                                                            <th class="text-center   text-right"></th>
                                                        </tr>
                                                        <tbody id="sales-record">
                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome1">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp 
                                                                    <a ng-click="AccountClick(row.accountHeadName)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>

                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{row.amount| number:2}} &nbsp</td>
                                                            </tr>

                                                        </tbody>
                                                        --%>


                                                    </table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 10px;">

                                                       
                                                        
                                                        <tr>
                                                            <th class="  " style="font-size: 13px;">TOTAL-(B)</th>
                                                             <th class="text-center   text-right">{{profitLoss.dOtherIncome|number:2}}</th> 
                                                        </tr>
                                                        
                                                         <tr>
                                                            <th class="  " style="font-size: 13px;">	TOTAL INCOME-(A+B)					


                                                            </th>
                                                             <th class="text-center   text-right">{{((profitLoss.dSalesRevenueTotal) +(profitLoss.dOtherIncome))
    
                                                                    | number:2}}</th> 
                                                        </tr>
                                                    </table>






                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>


                                                    <table ng-if="viewLeft" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 10px; margin-top:10px">



                                                        <tr ng-if="pl.ntprofit < 0">
                                                                                           <!--	<th class="  " ng-if="pl.ntFlag==true">Net Profit</th>
                                                                                                   <th class="  " ng-if="pl.ntFlag==false">Net Loss</th>
                                                                                                   <th class="text-center   text-right">{{pl.ntloss| number:2}}</th>-->

                                                            <th class="  " >EXCESS OF EXPENDITURE OVER INCOME</th>
                                                            <th class="text-center   text-right">{{-pl.ntprofit| number:2}}</th>
                                                        </tr>

                                                        <%-- <tr ng-if="profitLoss.dSalesRevenueTotal - profitLoss.dCostOfSalesTotal < 0">
                                                        <!--	<th class="  " ng-if="pl.ntFlag==true">Net Profit</th>
                                                                <th class="  " ng-if="pl.ntFlag==false">Net Loss</th>
                                                                <th class="text-center   text-right">{{pl.ntloss| number:2}}</th>-->

                                                            <th class="  " >Net Loss1</th>
                                                            <th class="text-center   text-right">{{pl.ntloss| number:2}}</th>
                                                        </tr> --%>

                                                    </table>








                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-12 col-lg-12"
                                             style="padding-top: 24px;">









                                            <table ng-if="viewRight" width=80% align="center"  
                                                   cellpadding="10" cellSpacing="0"
                                                   style="margin-left: 138px; width: 88%;">




                                                <tr>
                                                        <!-- <td class="width_10" align="left" height="30"
                                                                style="background: #D37878 !important" style="font-size: 10px;"><font
                                                                size="2" face="arial"><b>&nbsp TOTAL</b></font></td>
                                                        <td class="text-center width_15 text-left"
                                                                style="background: #D37878 !important"><b>{{(-profitLoss.dOtherIncome)|
                                                                        number:2 }}&nbsp</b></td>
                                                        <td class="width_10" align="left" height="30"
                                                                style="background: #D37878 !important" style="font-size: 10px;"><font
                                                                size="2" face="arial"><b>&nbspTOTAL</b></font></td>
                                                        <td class="text-center width_15 text-right"
                                                                style="background: #D37878 !important"><b>{{((((profitLoss.dSalesRevenueTotal-(-profitLoss.dCostOfSalesTotal)))
                                                                        -
                                                                        (((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                        (-profitLoss.dcommunicationCost)
                                                                        +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost) +
                                                                        (-profitLoss.dconveyencecost)) + dOtherIncome)
                                                                        ))+
                                                                        (((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                        (-profitLoss.dcommunicationCost)
                                                                        +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)+
                                                                        (-profitLoss.dconveyencecost)))+(((profitLoss.dSalesRevenueTotal)-(-profitLoss.dCostOfSalesTotal)))}}&nbsp</b></td>
                                                
                                                
                                                <td class="text-center width_15 text-left"
                                                                style="background: #D37878 !important"><b>{{(-profitLoss.dOtherIncome)|
                                                                        number:2 }}&nbsp</b></td> -->
                                                </tr>


                                            </table>

                                            <div class="col-sm-8 col-md-8 col-lg-8">

                                                <div class="col-sm-12 col-md-12 col-lg-12">

                                                    <table ng-if="viewVer" width=95% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;">
                                                        <tr style="/* background: #c3e3ef !important; */">
                                                                <!-- <td class="width_10" align="center" style="font-size: 13px;"><b>Group Code</b></td> -->

                                                            <td colspan="2" class=" " align="left" height="40"
                                                                style="font-size: 13px;"><left>
                                                            <font size="2" face="arial"><b><u>EXPENDITURE</u></b></font>
                                                        </left></td>
                                                        </tr>
                                                        <!-- <tr style="/* background: #c3e3ef !important; */">
                                                                <td class="width_10" align="center" style="font-size: 13px;"><b>Group Code</b></td>
    
                                                                <td class="width_30" align="left" height="40"
                                                                        style="font-size: 13px;"><left>
                                                                                <font size="2" face="arial"><b>PARTICULARS</b></font>
                                                                        </left></td>
                                                                <td class="width_30" align="right" height="40"
                                                                        style="font-size: 13px;"><center>
                                                                                <font size="2" face="arial"><b>AMOUNT</b></font>
                                                                        </center></td>
                                                        </tr> -->

                                                        <%-- <tr>
                                                            <th class="  " colspan="2"  style="font-size: 15px;  height: 40px;">
                                                                <a ng-click="Click('DIRECT EXPENSES')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">OPENING STOCK
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </th>

                                                        </tr>

                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lOtherExpense1"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>
                                                        <%-- <tr>
                                                            <th class="  " colspan="2"  style="font-size: 15px;  height: 40px;">
                                                                <a ng-click="Click('DIRECT EXPENSES')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">PURCHASE ACCOUNTS
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </th>

                                                        </tr>

                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lOtherExpense2"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>
                                                        <tr>
                                                            <th class="  " colspan="2"  style="font-size: 13px;  height: 40px;">
                                                                <a ng-click="Click('DIRECT EXPENSES')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">DIRECT EXPENSES
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </th>

                                                        </tr>

                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lOtherExpense"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 13px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 13px;">{{row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody>
                                                    </table>




                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>


                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>

                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>



                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>


                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>


                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>

                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>


                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>
                                                    <table ng-if="viewVer" width=93% align="center" cellSpacing="0"
                                                           style="margin-left: 0px;"></table>

                                                    <!--np  -->
                                                    <table = ng-if="viewRight" width=93% align="center"  
                                                        cellpadding="10" cellSpacing="0" style="margin-left: 0px;">



                                                        <tr>
                                                            <th class="  ">TOTAL-(C)</th>
                                                            <th class="text-center   text-right">{{(-profitLoss.dCostOfSalesTotal)|
									number:2}}</th>
                                                        </tr>


<!-- 	<tr>
                <th class="  ">GROSS PROFIT C/O</th>
                <th class="text-center   text-right">{{((profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal)|
                        number:2}}</th>
        </tr>
                                                        -->




                                                    </table>
                                                    <!--np  -->
                                                    <!-- nl -->

<!-- <table = ng-if="viewLeft" width=93% align="center"  
                                                        cellpadding="10" cellSpacing="0" style="margin-left: 0px; ">
<tr>

        <th class="text-center   text-right" colspan="2">{{(profitLoss.dCostOfSalesTotal)
                                                                        | number:2}}</th>
        </tr>
</table> -->
                                                    <table = ng-if="viewLeft" width=93% align="center"  
                                                        cellpadding="10" cellSpacing="0" style="margin-left: 0px; margin-top:15px">

                                                        <!-- <tr>
                                                                <th class="  "></th>
                                                                <th class="text-center   text-right">{{(((profitLoss.dSalesRevenueTotal)+(profitLoss.dSalesRevenueTotal))-(-profitLoss.dCostOfSalesTotal))|
                                                                        number:2}}</th>
                                                        </tr>
                                                        -->


                                                        <!-- 
                                                                                                                <tr>
                                                                                                                        <th class="  ">GROSS PROFIT C/F </th>   c/o to b/f
                                                                                                                        <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
                                                                                                                                number:2}}</th>
                                                                                                                </tr>
                                                        -->
                                                                                                       <!-- 	<tr>
                                                                                                                       <th class="  "></th>
                                                                                                                       <th class="text-center   text-right">{{(profitLoss.dSalesRevenueTotal)|
                                                                                                                               number:2}}</th>
                                                                                                               </tr> -->

         <!--     <tr ng-if="pl.ntprofit > 0">
                                       <th class="  ">Net Profit2 </th>  
                                       <th class="text-center   text-right">{{pl.ntprofit|
                                               number:2}}</th>
                               </tr> -->

                                                        <!-- <tr ng-if="profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal) > 0">
                                                                <th class="  ">Net Profit2 </th>   c/o to b/f
                                                                <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
                                                                        number:2}}</th>
                                                        </tr> -->



                                                    </table>

                                                    <!-- nl -->
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>

                                                    <table ng-if="viewVer" width=95% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px; margin-top: 0px;">


                                                        <tr>
                                                            <th class="  " style="font-size: 13px;  height: 40px;">INDIRECT EXPENSES</th>
                                                            <th class="text-center   text-right"></th>




                                                            <!-- 									{{((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                    (-profitLoss.dcommunicationCost)
                                                                    +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)) }} -->

                                                        </tr>
                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lindirectexpenses"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="center" height="20"
                                                                    style="font-size: 13px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 13px;">{{row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody>



                                                        <%-- 	<tr>
                                                            <th class="  ">
                                                                <a ng-click="Click('TRAVELLING COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">ANNUAL MAINTENANCE CONTRACT
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dtravellingcost
                                                                        | number:2}}</th>
                                                        </tr>
                                                        --%>
                                                        <%-- <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lTravellingCostList"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>


                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>

                                                        <%-- <tr>
                                                            <th class="  "> 

                                                                <a ng-click="Click('SALES & BUSINESS PROMOTION COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">FUNCTIONS & CELEBRATIONS
                                                                        </span>
                                                                    </security:authorize></a>

                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dsalesCost
                                                                        | number:2}}</th>
                                                        </tr> --%>

                                                        <%-- <tbody id="sales-record">

                                                            <tr
                                                                ng-repeat="(trIndex, row) in profitLoss.lSalesandBusinessList"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>


                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>
                                                        <%-- 
                                                        <tr>
                                                            <th class="  ">

                                                                <a ng-click="Click('PERSONNEL COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">INSURANCE
                                                                        </span>
                                                                    </security:authorize></a>

                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dpersonalCost
                                                                        | number:2}}</th>
                                                        </tr> --%>

                                                        <%-- 	<tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lPersonalCostList"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp

                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>
                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>
                                                        <%-- 	<tr>
                                                            <th class="  "> 

                                                                <a ng-click="Click('FINANCE COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">BANK CHARGES
                                                                        </span>
                                                                    </security:authorize></a>

                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dfinanceCost
                                                                        | number:2}}</th>
                                                        </tr> --%>

                                                        <%-- 	<tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lFinanceCost"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>


                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>


                                                        <%-- 	<tr>
                                                            <th class="  ">


                                                                <a ng-click="Click('COMMUNICATION COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">DONATION EXPENSES
                                                                        </span>
                                                                    </security:authorize></a>

                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dcommunicationCost
                                                                        | number:2}}</th>
                                                        </tr> --%>

                                                        <%-- <tbody id="sales-record">

                                                            <tr
                                                                ng-repeat="(trIndex, row) in profitLoss.lCommuncationCostList"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>

                                                        <%-- <tr>
                                                            <th class="  ">  

                                                                <a ng-click="Click('ADMINISTRATIVE COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">ADMINISTRATIVE EXPENSES
                                                                        </span>
                                                                    </security:authorize></a>
                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dAdminExpense
                                                                        | number:2}}</th>
                                                        </tr>

                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lAdminExpense"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody> --%>




                                                        <%-- 	<tr>
                                                            <th class="  "> 

                                                                <a ng-click="Click('CONVEYANCE COST')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">TRANSPORT FEE
                                                                        </span>
                                                                    </security:authorize></a>
                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dconveyencecost
                                                                        | number:2}}</th>
                                                        </tr>

                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lConveyenceCostList"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>


                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>

                                                        </tbody>
                                                        --%>
                                                        <%-- 	<tr>
                                                            <th class="  ">
                                                                <a ng-click="Click('RENT COSTS')"> <security:authorize
                                                                        access="hasRole('${form_code}_${view}')">

                                                                        <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                              class="tool-tip-span">REPAIRS AND MAINTENANCE
                                                                        </span>
                                                                    </security:authorize></a>


                                                            </th>
                                                            <th class="text-center   text-right">{{-profitLoss.dRentCost
                                                                        | number:2}}</th>



                                                        </tr>



                                                        <tbody id="sales-record">

                                                            <tr ng-repeat="(trIndex, row) in profitLoss.lRentCostList"
                                                                ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
                                                                <td class="width_30" align="left" height="20"
                                                                    style="font-size: 10px;">&nbsp
                                                                    <a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
                                                                            access="hasRole('${form_code}_${view}')">

                                                                            <span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
                                                                                  class="tool-tip-span">{{row.accountHead}}
                                                                            </span>
                                                                        </security:authorize></a>



                                                                </td>
                                                                <td class="width_30" align="right" height="20"
                                                                    style="font-size: 10px;">{{-row.amountAdmin| number:2}}
                                                                    &nbsp</td>


                                                            </tr>


                                                        </tbody> --%>

                                                    </table>



                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;">


                                                        <tr>
                                                            <th class="  ">TOTAL-(D)</th>
                                                            <th class="text-center   text-right">{{( - profitLoss.dpersonalCost) +
                                                                        ( - profitLoss.dsalesCost) +
                                                                        ( - profitLoss.dtravellingcost) + ( - profitLoss.dcommunicationCost) +
                                                                        ( - profitLoss.dRentCost) + ( - profitLoss.dAdminExpense) +
                                                                        ( - profitLoss.dfinanceCost) + ( - profitLoss.dconveyencecost) |
                                                                        number:2}}</th>

                                                        </tr>
                                                        
                                                        
                                                        <tr>
                                                            <th class="  ">TOTAL EXPENDITURE-(C+D)</th>
                                                            <th class="text-center   text-right">{{( - profitLoss.dpersonalCost) +
                                                                        ( - profitLoss.dsalesCost) +
                                                                        ( - profitLoss.dtravellingcost) + ( - profitLoss.dcommunicationCost) +
                                                                        ( - profitLoss.dRentCost) + ( - profitLoss.dAdminExpense) +
                                                                        ( - profitLoss.dfinanceCost) + ( - profitLoss.dconveyencecost) + (-profitLoss.dCostOfSalesTotal) |
                                                                        number:2}}</th>

                                                        </tr>

                                                    </table>

                                                    <table ng-if="viewVer" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px; margin-top:10px">
                                                        <tr ng-if="pl.ntprofit > 0">
                                                            <th class="  ">EXCESS OF INCOME OVER EXPENDITURE</th>
                                                            <th class="text-center   text-right">{{(( - profitLoss.dpersonalCost) +( - profitLoss.dsalesCost) +( - profitLoss.dtravellingcost) + ( - profitLoss.dcommunicationCost) +
( - profitLoss.dRentCost) + ( - profitLoss.dAdminExpense) +( - profitLoss.dfinanceCost) + ( - profitLoss.dconveyencecost) + (-profitLoss.dCostOfSalesTotal)) 
-(((profitLoss.dSalesRevenueTotal) +(profitLoss.dOtherIncome)))}}.00
                                                            </th>
                                                        </tr>
                                                    </table>








                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>
                                                    <table ng-if="viewVer" width=80% align="center"  ></table>


                                                    <table ng-if="viewRight" width=93% align="center"  
                                                           cellpadding="10" cellSpacing="0" style="margin-left: 0px;">

                                                        <!-- 	 ntloss = amount-(totl+dOtherIncome);
                                        ntprof=dOtherIncome-(totl+amount); -->


                                                        <!-- 
                                                                                                                <tr>
                                                                                                                        <th class="  ">Net Profit</th>
                                                                                                                        <th class="text-center   text-right">{{
                                                                                                                        ((-profitLoss.dOtherIncome))
                                                                                                                                -
                                                                                                                                ((((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                                                                                (-profitLoss.dcommunicationCost)
                                                                                                                                +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost) +
                                                                                                                                (-profitLoss.dconveyencecost))  +  (-((-profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal))))| number:2}}</th>
                                                                                                                </tr> -->









                                                    </table>
                                                </div>

                                                <!-- ngIf: viewRight -->

                                                <!-- ngIf: viewLeft -->

                                            </div>



                                            <div class="col-sm-12 col-md-12 col-lg-12" style="padding-top: 24px;">

                                                <!-- ngIf: viewRight -->

                                                <!-- ngIf: viewLeft -->
                                                <table ng-if="viewLeft" width="60%" align="center"   cellpadding="10" cellspacing="0" style="margin: 15px;">

                                                    <tbody>
                                                    <!-- <tr>
                                                    
                                                    <td class="width_10" align="left" height="30" style="/* background: #c3e3ef !important */"><font size="2" face="arial"><b>&nbsp;TOTAL</b></font></td>
                                                    <td class="text-center width_15 text-right" style="/* background: #c3e3ef !important */"><b class="ng-binding"><b>{{pl.total1|
                                                                                                                            number:2 }}&nbsp;</b></td>
                                                    </tr> -->
                                                    </tbody>
                                                </table>
                                            </div>




                                        </div>

                                    </div>
                                    
                                    <div class="col-sm-2 col-md-2 col-lg-2">
                                        
                                        
                                    
                                    </div>
                                    
                                </form>
                            </div>
                            <!-- /panel-body -->
                        </div>
                        <!-- /panel-default -->
                        <br> <br> <br> <br> <br> <br> <br> <br>
                        <br> <br> <br> <br> <br> <br> <br> <br>
                    </div>
                </div>
            </article>
        </div>
    </section>
</div>
