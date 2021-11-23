<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
#ngdialog1 .ngdialog-content{
	width:90%;
	height:95%;
}
#ngdialog2 .ngdialog-content{
	width:90%;
	height:95%;
}
#ngdialog3 .ngdialog-content{
	width:90%;
	height:95%;
}
#ngdialog4 .ngdialog-content{
	width:90%;
	height:95%;
}
#ngdialog5 .ngdialog-content{
	width:90%;
	height:95%;
}
</style>
 <!-- #MAIN CONTENT -->
<div id="content" style="margin-top:-7%" >
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <!-- <article class="col-sm-12"> -->
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
      <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <!--  <div id="window">
        <button class="k-button close-button" data-ng-click="close()">Close</button>
      </div> -->
      
      
     
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
               <span >
					<span id="refresh"  class="button-icon jarviswidget-toggle-btn" data-reset-widgets rel="tooltip" title="Warning! This will reset all your widget settings."
                          data-placement="bottom">
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content" style="padding-bottom:7%">
      <div class="widget-body">      
         <form class="form-horizontal" name="vesselMasterForm" role="form" ng-submit="#" novalidate>
         
         	<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Month and Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" style="padding-top:2%">
						           					<label>{{deductMY}}</label>
													</select>
												</div>
											</div>	
										</div>
										
										<div class="col-sm-5 col-md-5 col-lg-5">
										
										<label style="color:#191818;font-size: 27px;padding-left:10%;">Advance Deduction</label>
										
										</div>
										
										<div class="col-sm-3 col-md-3 col-lg-3">
												<div class="col-md-3" style="padding-left: 75%;">
						           					 <button class="btn btn-success" ng-if="dum" type="button" data-ng-click="deduct(displayedCollection)">
									     			Deduct
									       			</button>
												</div>
										</div>
										</div>
										
								</div>
										
         
         
    	  <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection" style="overflow :scroll;height:300px;">
         <!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
         
         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		 </div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head ">
          <tr>
           <!-- <th class="width_1"></th> -->
          <!--  <th class="sorting width_12" st-sort="companyName">Organization</th>
           <th class="sorting width_15" st-sort="">Branch Name</th> -->
           									<th class ="width_3" st-sort="advanceCode">Advance Code</th>
											<th class ="width_13" st-sort="employeeName">Employee Name</th>
											<th class ="width_3" st-sort="amount">Advance Amount  </th>
											<th class ="width_3" st-sort="recoverytype">Recovery Type</th>	
											<th class ="width_3" st-sort="numberOfInstallments">Total Installment</th>	
											<th class ="width_3" st-sort="installmentPaid">Installment Paid</th>
											<th class ="width_3" st-sort="currentInstallment">Current Installment</th>
											<th class ="width_3" st-sort="installmentAmount">Ins. Amount</th>	
											<th class ="width_4" st-sort="toModify">No.of Ins. Deduct</th>	
											<th class ="width_13" st-sort="narration">Narration</th>	
          </tr>
         
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex,myloanlist) in displayedCollection" ng-controller="tableCtrl">
           <!-- <td cs-select="objVesselMasterItem"></td> -->
            <!-- <td>{{myloanlist.companyName}}</td>
           <td>{{myloanlist.branchName}}</td> -->
     										<td class ="width_3">{{myloanlist.advanceCode}}</td>
											<td class ="width_13">{{myloanlist.employeeName}}</td>
											<td class ="width_3" style="text-align: right;">{{myloanlist.amount}}</td>
											<td class ="width_3">{{myloanlist.recoverytype}}</td>
											<td class ="width_3">{{myloanlist.numberOfInstallments}}</td>
											<td class ="width_3">{{myloanlist.installmentPaid}}</td>
											<td class ="width_3">{{myloanlist.currentInstallment}}</td>										
											<td class ="width_3"><input type="text" class="form-control" style="text-align: right;width:70%;" ng-model="myloanlist.installmentAmount" readonly></td>
											<td class ="width_4">
 											<input type="checkbox" ng-change="box(displayedCollection,trIndex)" style="float:left;" class="form-control" ng-model="myloanlist.toChange">
 											<div class="width_20" style="float:left;padding-left: 22%;">									
											<selectivity ng-if="myloanlist.change" list="modify" property="myloanlist.toModify"  ng-model="myloanlist.toModify" form-name = "vesselMasterForm"></selectivity>
											</div>
											<div class="width_20" style="float:left;padding-left: 22%;">									
											<selectivity ng-if="!myloanlist.change" list="modify" property="myloanlist.toModify"  ng-model="myloanlist.toModify" form-name = "vesselMasterForm" disabled="true"></selectivity>
											</div>
										    </td>	
											<td class ="width_13" ng-if="myloanlist.change"><input type="text" class="form-control" style="width:90%;" ng-model="myloanlist.narration"></td>
											<td class ="width_13" ng-if="!myloanlist.change"><input type="text" class="form-control" style="width:90%;" ng-model="myloanlist.narration" readonly></td>


           </tr>
         </tbody>
        </table>
       
       </div>
       
       <div class="row" style="padding-top:10px">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-5 col-md-5 col-lg-5">
											
										</div>
										
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="col-md-7">
												
												<button class="btn btn-danger" type="button" ng-if="dum"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i>Close & Generate
												</button> 
											
											</div>
										</div>
										<div class="col-sm-3 col-md-3 col-lg-3">
											
										</div>
										</div>
										
								</div>
								
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   <!-- </article> -->
   <!-- WIDGET END -->
  </div>
 </section>
</div> 
