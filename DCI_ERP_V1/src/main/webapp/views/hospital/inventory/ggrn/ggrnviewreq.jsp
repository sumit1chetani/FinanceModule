 <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header"> <span class="widget-icon"> <i class="fa fa-table"></i> </span> <h2> View Requisition Details </h2> </header>
     	<div role="content">
      		<div class="widget-body">
       			<form class="form-horizontal" name="purchaseQuoteForm">
        			<%-- <div class="row">
         				<div class="col-sm-10 col-md-6">
          					<fieldset>
           					<div class="form-group">
	            			<label class="col-md-6 control-label"> Requisition No <spring:message code="label.asterisk.symbol"></spring:message> </label>
	            			<div class="col-md-5">
	              	<input type="text" class="form-control input-sm" ng-model="displayedCollection[0].poNo" readonly>
	            </div>
            </div>

		   </fieldset>
        </div>
    	<div class="col-sm-10 col-md-6">
          <fieldset>
           	<div class="form-group">
        		<label class="col-md-5 control-label"> Requisition Date </label>
        		   <div class="col-md-5">
					 <input type="text" class="form-control input-sm"  ng-model="displayedCollection[0].poDate" readonly>
					</div>
			</div>

          </fieldset>
         </div>
     	</div> --%>
     	 <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowReqCollection">

        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
			<th class="sorting width_10" data-st-sort="">Request Code</th>
			<th class="sorting width_10" data-st-sort="">Request Date</th>
           <th class="sorting width_10" data-st-sort="">Item Code</th>
           <th class="sorting width_10" data-st-sort="">Item Name</th>
           <th class="sorting width_10" data-st-sort="">Item Desc</th>
           <!-- <th class="sorting width_10" data-st-sort="">Tax</th>
           <th class="sorting width_10" data-st-sort="">Unit Of Measure</th> -->
           <th class="sorting width_10" data-st-sort="">Quantity</th>
           <!-- <th class="sorting width_10" data-st-sort="">Unit Price</th>
           <th class="sorting width_10" data-st-sort="">Discount</th> -->
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body" >
              <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="grnReqData in displayedCollection">

					<td>{{grnReqData.poNo}}</td>
	               <td>{{grnReqData.poDate}}</td>
			       <td>{{grnReqData.dtlItemCode}}</td>
	               <td>{{grnReqData.dtlItemName}}</td>
	               <td>{{grnReqData.dtlItemDesc}}</td>
	               <td class="text-right">{{grnReqData.dtlQty}}</td>
	               <!-- <td>{{ggrnData.dtlPrice}}</td> -->

              </tr>
             </tbody>
        </table>

       </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="ngcancel()"> <i class="fa fa-close"></i>  <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
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
