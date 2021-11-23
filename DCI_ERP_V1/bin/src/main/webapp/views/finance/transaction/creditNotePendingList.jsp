<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">

   <%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
   <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
	 <div class="row  m-n">
	  <div class="col-md-7 padding-right-0 padding-left-0 header-with-breadcrumb font-bold" >
	   <state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>
		  <!-- <p>
		   <button type="button" class="btn btn-success" data-ng-hide="started" data-ng-click="start()">Start Demo</button>
		   <button type="button" class="btn btn-danger" data-ng-show="started" data-ng-click="stop()">Stop Demo</button>
		  </p> -->
	  </div>
	  <div class="col-md-5 text-right padding-right-0">
	   <div class="row m-n">
	    <div class="col-md-12  p-l-0 p-r-0 ">
	     <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
	    </div>
	   </div>
	  </div>
	 </div>
	</div>
  	</div><!-- /panel-heading -->
   	<input type="hidden" value="${form_code}" id="form_code_id" />
   	<div class="panel panel-default">
	   	<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-3 col-lg-3 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label"> Company
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity  list="companyList" ng-model="creditnotePendingAcctData.companyCode" property="creditnotePendingAcctData.companyCode" 
								id="company_id" object="company" name="company_id"></selectivity>
							</div>						
						</div>
					</fieldset>
				</div>
				<div class="col-sm-12 col-md-9 col-lg-9 ">
						<button class="btn btn-primary" type="button"
							data-ng-click="getCreditNoteListUtil();">Pending List</button>	
							<button class="btn btn-primary" type="button"
							data-ng-click="pendingApprove(displayedCollection);">Approve</button>				
				</div>
			</div>
		</div>
	</div>
  <div class="panel-body"  st-table="displayedCollection" st-safe-src="rowCollection" >
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"> <input class="tool-tip-span" type="checkbox" ng-model="selectedAll" ng-change="checkAll(displayedCollection,selectedAll)" /></th>
       <th class="sorting width_8" st-sort="creditNoteCode">Cr Code</th>
       <th class="sorting width_8" st-sort="creditNoteDate">Date</th>
       <th class="sorting width_8" st-sort="mloName">Customer</th>
       <th class="sorting width_8" st-sort="invoiceNo">Inv No</th>
       <!-- <th class="sorting width_9" st-sort="location">Locn</th> -->
       <th class="sorting width_8" st-sort="company">Company</th>
       <!-- <th class="sorting width_8 text-wrap" st-sort="creditAmount">TC Amt</th> -->
       <th class="sorting width_8 text-wrap text-wrap-amtusd" st-sort="creditAmountUSD"> Amt</th>
       <th class="sorting width_8 text-wrap" st-sort="approveStatus">Status</th>
       <!-- <th class="width_10">Action</th> -->
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <!-- <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCreditNoteListItem in displayedCollection"> -->
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCreditNoteListItem in displayedCollection | filter:{approveStatus:'N'}">
       <!-- <td class="width_1" cs-select="objCreditNoteListItem"></td> -->
       <td class="width_1"> <label class="i-checks m-b-none">
       <input type="checkbox" ng-model="objCreditNoteListItem.select" id="select{{trIndex}}"><i></i></label></td>
       <td class="width_8" >
       <span ng-if="objCreditNoteListItem.urIsView=='t'">
        <a href="#/transaction/creditnotehdr/view/{{objCreditNoteListItem.creditNoteCode}}">
        <span tooltip="{{objCreditNoteListItem.creditNoteCode}}" class="tool-tip-span font-blue" ng-bind="objCreditNoteListItem.creditNoteCode">
         </span>
      	</a></span>
        <span ng-if="objCreditNoteListItem.urIsView=='f'">
        <span tooltip="{{objCreditNoteListItem.creditNoteCode}}" class="tool-tip-span" ng-bind="objCreditNoteListItem.creditNoteCode">
        </span>
        </span>
       </td>
       <td class="width_8" ng-bind="objCreditNoteListItem.creditNoteDate"></td>
       <td class="width_8">
        <span tooltip="{{objCreditNoteListItem.mloName}}"  ng-bind="objCreditNoteListItem.mloName"></span>
       </td> 
     	<!--   <td class="width_8" ng-bind="objCreditNoteListItem.mloName"> -->
       <td class="width_8" ng-bind="objCreditNoteListItem.invoiceNo">
       </td>
       <!-- <td class="width_8" ng-bind="objCreditNoteListItem.location"></td> -->
       <td class="width_8">
       		<span tooltip="{{objCreditNoteListItem.company}}" class="tool-tip-span text-wrap" ng-bind="objCreditNoteListItem.company"></span>
       </td>
       <!-- <td class="width_8 text-right" ng-bind="objCreditNoteListItem.creditAmount"></td> -->
       <td class="width_8 text-right" ng-bind="objCreditNoteListItem.creditAmountUSD"></td>
       <td class="width_8" ng-bind="objCreditNoteListItem.approveStatus">
       </td>
      </tr>
     </tbody>
    </table>    
   </div>
   <footer class="panel-footer">
   		<!-- <span class="width_10 td-actions b-a r-5x"><i class="fa fa-check text-dark text" data-ng-click="ApproveCreditNote(displayedCollection)" tooltip="Approve"></i></span> -->
		<%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
   <div class="form-actions">
	    <div class="row">
			<div class="col-sm-12 ">
				<div class="form-group pull-right">			       
			        <label class="col-md-8 control-label bold">Total Amount</label>
			        <div class="col-md-4">
			         	<label ng-bind="totalPendingBCAmount"></label>
			        </div>
		       </div>
			</div>
		</div>
	</div>
   	<div class="form-actions">
		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-success" ng-click="backToList()" type="button">Back To List</button>
		   	</div>
		</div>
   	</div>
  </div>
  </div>
</div>