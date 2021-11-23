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
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       Add Asset Category List
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="assetCategoryPropertyForm">
        <div class="row">
         <div class="col-md-8">
          <fieldset>
           		<div class="form-group">
					<label class="col-md-6 control-label">
						<spring:message code="label.property.type"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
						<div class="col-md-4">						   												   						
							<select class="form-control journalVoucher-textBox" 
					          ng-model="assetPropertiesObj.propertyTypeId" data-ng-options="propertyValues.propertyTypeId as propertyValues.propertTypeName for propertyValues in propertyList"
				              name="Property Type">
				            <option value="">Select</option>
							</select>						   						
						</div>
						<div class="col-md-2">						   												   						
							<button class="btn btn-success" ng-click="getAssetPropertiesList(assetPropertiesObj.propertyTypeId)">Filter</button>						   						
						</div>
				</div>
		   </fieldset>
         </div><br><br>
		 <div class="col-md-12 padding-top-10">
		     <div role="content">
		      <div class="widget-body no-padding">
		       <div
		        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
		        data-st-table="displayedCollection"
		        data-st-safe-src="rowCollection">
		        <table id="dt_basic"
		         class="table table-striped table-bordered table-hover dataTable no-footer"
		         role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="width_1 table-heading text-center">
		            <label class="i-checks m-b-none">
		             <input type="checkbox">
		             <i></i>
		            </label>
		           </th>
		           <th class="sorting width_10" data-st-sort="">Property Name</th>
		           <th class="sorting width_10" data-st-sort="">Property Type</th>
		           <th class="sorting width_10" data-st-sort="">Type</th>
		           <th class="sorting width_10" data-st-sort="">Is Mandatory</th>
		          </tr>
		         </thead>
		         <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="assetCategoryProperties in displayedCollection">
		           <td class="text-center" cs-select="assetCategoryProperties"></td>
		           <td>{{assetCategoryProperties.propName}}</td>
		           <td>{{assetCategoryProperties.propertyTypeName}}</td>
		           <td>{{assetCategoryProperties.typeName}}</td>
		           <td data-ng-if="assetCategoryProperties.manditory=='t'">
			           <div class="checkbox">
			           	<label>
						  <input type="checkbox" checked="checked" disabled="disabled">
						<span></span>
						</label>
						</div>
		           </td>
		           <td data-ng-if="assetCategoryProperties.manditory!='t'">
		           		<div class="checkbox">
			           	<label class="i-checks">
						  <input type="checkbox" disabled="disabled">
							<i></i>
						</label>
						</div>
		           </td>
		          </tr>
		         </tbody>
		        </table>
		       </div>
		      </div>
		     </div>
		    </div>    
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            class="btn btn-success"
            ng-click="getListValue(displayedCollection)">
            <i class="fa fa-save"></i> <spring:message code="label.select"></spring:message>
           </button>
           <button class="btn btn-danger" type="button"
            class="btn btn-success" ng-click="cancelReq()">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
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