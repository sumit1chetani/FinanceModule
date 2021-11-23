<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="padding-top-10">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs></span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="requestAddForm" role="form" novalidate>
        <fieldset>
        <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        	data-st-table="lRFQItemBean" data-st-safe-src="rowCollectionSearch">
        <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>
         <div class="row">
          <div class="col-sm-12 col-md-12 col-lg-12">
           <div class="padding-left-5 padding-top-5" id="jqgrid"> --%>
           <style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
            <table id="grid"></table>
	            <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer ui-jqgrid" role="grid" aria-describedby="dt_basic_info">
             <thead class="dataTables-Main-Head">
              <tr>
               <th class="sorting sorting-no text-center  width_4">
                <input role="checkbox" type="checkbox" class="cbox" data-ng-model="itemStatus" data-ng-change="changeItemStatus()">
               </th>
               <th class="sorting sorting-no text-center width_4"></th>
               <th class="sorting sorting-no text-center">Item Code</th>
               <th class="sorting sorting-no text-center">Item Name</th>
               <th class="sorting sorting-no text-center">Location</th>
               <th class="sorting sorting-no text-center">Requested Quantity</th>
              </tr>
             </thead>
             <tbody class="dataTables-Main-Body" data-ng-repeat="rfqItemBean in lRFQItemBean">
              <tr>
               <td class="text-center">
                <input role="checkbox" type="checkbox" class="cbox" data-ng-model="rfqItemBean.status" data-ng-change="setItemStatus()">
               </td>
               <td class="text-center">
                <span class="fa" data-ng-class="{'fa-plus-circle':showId!=$index,'fa-minus-circle':showId==$index}"
                 data-ng-click="changeIndexValue($index,rfqItemBean.purchaseRequsitionNumber)"></span>
               </td>
               <td class="text-center">{{rfqItemBean.itemCode}}</td>
               <td class="text-center">{{rfqItemBean.itemName}}</td>
               <td class="text-center">{{rfqItemBean.stateName}}</td>
               <td class="text-center">{{rfqItemBean.qty}}</td>
              </tr>
              <tr data-ng-show="showId==$index">
               <td colspan="7">
                <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
                 <thead class="dataTables-Main-Head">
                  <tr>
                   <th class="sorting sorting-no text-center">Purchase Requisition No</th>
                   <th class="sorting sorting-no text-center">Requisition Date</th>
                   <th class="sorting sorting-no text-center">Location</th>
                   <th class="sorting sorting-no text-center">Quantity</th>
                  </tr>
                 </thead>
                 <tbody class="dataTables-Main-Body" data-ng-repeat="rfqItemSubBean in lRFQItemSubBean">
                  <tr>
                   <td class="text-center">{{rfqItemSubBean.requsitionNumber}}</td>
                   <td class="text-center">{{rfqItemSubBean.date}}</td>
                   <td class="text-center">{{rfqItemSubBean.locName}}</td>
                   <td class="text-center">{{rfqItemSubBean.quantity}}</td>
                  </tr>
                 </tbody>
                </table>
               </td>
              </tr>
             </tbody>
            </table>
           </div>
          </div>
         </div>
         </div>
        </fieldset>
        <div class="form-actions">
         <div class="row">
          <div class="col-lg-12 col-md-12">
           <div class="row">
            <div class="col-md-3">
             <div class="form-group"></div>
            </div>
            <div class="col-md-6">
             <button class="btn btn-primary" type="back" data-ng-click="back()">Back</button>
             <button class="btn btn-primary" type="button" data-ng-click="requestForQuote()">Request For Quotation</button>
            </div>
            <div class="col-md-3">
             <div class="form-group"></div>
            </div>
           </div>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
    </div>
   </article>
  </div>
 </section>
</div>