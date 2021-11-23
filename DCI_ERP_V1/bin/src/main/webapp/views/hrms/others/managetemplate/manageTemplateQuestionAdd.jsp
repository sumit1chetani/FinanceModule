 <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}

select{
-webkit-appearance: none;
  padding: 0;
  text-indent: 8px;
  padding : 0 !important;
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
       Add Questions
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
		 <div class="col-md-12 padding-top-10">
		     <div role="content">
		      <div class="widget-body no-padding auto-scroll">
		       <div
		        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
		        data-st-table="displayedCollection"
		        data-st-safe-src="rowCollection">
		        <table id="dt_basic"
		         class="table table-striped table-bordered table-hover dataTable no-footer"
		         role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="width_1 text-center table-heading">
		            <label class="i-checks m-b-none">
		             <input type="checkbox"  ng-model="selectedAll" ng-change="checkAllPurchase(displayedCollection,selectedAll)">
		             <i></i>
		            </label>
		           </th>
		           <th class="sorting width_10" data-st-sort="">Question ID</th>
		           <th class="sorting width_10" data-st-sort="">Question Description</th>
		           <th class="sorting width_10" data-st-sort="">Status</th>
		          </tr>
		         </thead>
		         <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="questionCollections in displayedCollection">
		           <td>  
		          		<label class="i-checks m-b-none">
			             	<input type="checkbox" ng-model="questionCollections.select">
			             	<i></i>
			        	</label>
			       </td>
		           <td>{{questionCollections.question_id}}</td>
		           <td>{{questionCollections.question_desc}}</td>
		           <td>{{questionCollections.status}}</td>
		          </tr>
		         </tbody>
		        </table>
		       </div>
		      </div>
		      <!-- end widget content -->
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
<!--            <button type="reset" class="btn btn-info" -->
<!--             ng-click="reset(purchaseOrderRequestForm)"> -->
<!--             <i class="fa fa-undo"></i> -->
<%--             <spring:message code="label.reset"></spring:message> --%>
<!--            </button> -->
           <button class="btn btn-danger" type="reset"
            class="btn btn-success" ng-click="cancelReq()">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
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