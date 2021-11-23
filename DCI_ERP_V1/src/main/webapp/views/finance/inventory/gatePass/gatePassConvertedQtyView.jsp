<%-- <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 1000px;
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
     <header class="ngdialog-header"> <span class="widget-icon"> <i class="fa fa-table"></i> </span> <h2> Converted Quantity Details </h2> </header>
     	<div role="content">
      		<div class="widget-body"> --%>
      		
      		<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       			<form class="form-horizontal" name="purchaseQuoteForm">
        			<div class="row">
        			<div class="col-md-12">
			
           
           <span title="cancel" style="left: 70% important;"> <i
						class="fa fa-close text-danger-dker text" style = "padding-left:97%;"
						data-ng-click="ngcancel()" ></i>
				</span> 
          </div>
          <h4>Out Item Detail</h4>
                 <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all auto-scroll"
        data-st-table="displayedCollection"
        >

        <table id="dt_basic" style="width:86%;"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info" >
         <thead class="dataTables-Main-Head">
          <tr>
           <tr>
        
           <th class="sorting width_10" data-st-sort="">Item Name</th> 
           <th class="sorting width_10" data-st-sort="">Purchase UOM</th>
           <th class="sorting width_10" data-st-sort="">Purchase Qty</th> 
           <th class="sorting width_10" data-st-sort="">Vendor(Alt)	UOM</th>
           <th class="sorting width_10" data-st-sort="">vendor(Alt) Qty</th>
         <!--   <th class="sorting width_10" data-st-sort="">Receiving Qty</th>
           <th class="sorting width_10" data-st-sort="">Converted Qty</th> -->
           
          </tr>
         </thead>
         <tbody >
              <tr >
			  
			   
               <td>{{gatePassItemConvertedQty.dtlItemName}}</td>
               <td hidden="true">{{gatePassItemConvertedQty.rowId}}</td>
               <td class="text-center">{{gatePassItemConvertedQty.purchaseUOMName}}</td>
               <td class="text-center">{{gatePassItemConvertedQty.purchaseQty}}</td>
          
                           <td class="text-center">{{gatePassItemConvertedQty.vendorUOMName}}</td>
            
            <!-- <selectivity list="uomCategoryList"
																				property="row.vendorUOM" id="vendorUOM{{trIndex}}"
																				ng-model="row.vendorUOM" name="vendorUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(vendor) UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity> -->
          
               <td class="text-center">{{gatePassItemConvertedQty.vendorQty}}</td>
				<!-- <td class="width_7"><input type="text"
				class="form-control input-sm" ng-model="gatePassItemConvertedQty.receivingQtypop"
				name="receivingQtypop"  style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td>
				<td class="width_7"><input type="text"
				class="form-control input-sm" ng-model="gatePassItemConvertedQty.convertedQtypop"
				name="convertedQtypop" style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td> -->
			
              </tr>
             </tbody>
        </table>

       </div>
       <br>
       <br>
       
          <h4>In Item Detail</h4>
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all auto-scroll"
        data-st-table="displayedCollection1"
        >

        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info" >
         <thead class="dataTables-Main-Head">
          <tr>
           <tr>
        
           <th class="sorting width_10" data-st-sort="">Item Name</th> 
           <th class="sorting width_10" data-st-sort="">Purchase UOM</th>
       <!--     <th class="sorting width_10" data-st-sort="">Purchase Qty</th>  -->
           <th class="sorting width_10" data-st-sort="">Vendor	UOM</th>
         <!--   <th class="sorting width_10" data-st-sort="">vendor(Alt) Qty</th> -->
           <th class="sorting width_10" data-st-sort="">Receiving Qty</th>
           <th class="sorting width_10" data-st-sort="">Converted Qty</th> 
           
          </tr>
         </thead>
         <tbody >
              <tr >
			  
			   
               <td>
				<selectivity list="itemListconv" 
															ng-model="gatePassItemConvertedQty.convitemname"
															property="gatePassItemConvertedQty.convitemname"
															id="convitemname" object="itemObj"
															name="convitemname" validation="required"
															friendly-name="convitemname"
															form-name="gatePassItemForm"></selectivity>
		</td>
               <td hidden="true">{{gatePassItemConvertedQty.rowId}}</td>
               <td class="text-left"><selectivity list="uomCategoryList"
															ng-model="gatePassItemConvertedQty.convpurchaseuom"
															property="gatePassItemConvertedQty.convpurchaseuom"
															id="uom" object="uomObj"
															name="uom" validation="required"
															friendly-name="uom" disabled = "true"
															form-name="gatePassItemForm"></selectivity></td>
               <td class="text-right"><selectivity list="uomCategoryList"
															ng-model="gatePassItemConvertedQty.convendoruom"
															property="gatePassItemConvertedQty.convendoruom"
															id="vendoruom" object="vendoruomObj"
															name="vendoruom" validation="required"
															friendly-name="vendoruom" 
															form-name="gatePassItemForm"></selectivity></td>
          
                           <!-- <td class="text-left">{{gatePassItemConvertedQty.vendorUOMName}}</td> -->
            
            <!-- <selectivity list="uomCategoryList"
																				property="row.vendorUOM" id="vendorUOM{{trIndex}}"
																				ng-model="row.vendorUOM" name="vendorUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(vendor) UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity> -->
          
              <!--  <td class="text-right">{{gatePassItemConvertedQty.vendorQty}}</td> -->
				<td class="width_7"><input type="text"
				class="form-control input-sm" ng-model="gatePassItemConvertedQty.receivingvendorQty"
				name="receivingQtypop"  style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td>
				<td class="width_7"><input type="text"
				class="form-control input-sm" ng-model="gatePassItemConvertedQty.convertedpurchaseQty"
				name="convertedQtypop" style="text-align: right;"
				ng-pattern-restrict="^[0-9.]*$" /></td>
			
              </tr>
             </tbody>
        </table>

       </div><br>
       <br><br><br><br>
     	</div>
<div class="form-actions">
   <div class="row">
      <div class="col-md-12">
         <button class="btn btn-success" type="button" ng-click="saveItemConvrtQty(gatePassItemConvertedQty,gatePassItemConvertedQty.rowId )"  class="btn btn-success">
	          <i class="fa fa-save"></i>Save
         </button>
         
         <button type="reset" class="btn btn-info" ng-click="resetAddItem(gatePassAddItem)">
	          <i class="fa fa-undo"></i>Reset
         </button>
         <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancelAddItem()">
	          <i class="fa fa-close"></i>Cancel
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
