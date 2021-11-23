<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
 <!--  <div class="row"> -->
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
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

 <div class="row" style="border:0px solid Red" >
     <div class="col-md-11 panel-body" style="border:0px solid red">

			<div >
  <label class="col-md-2 padding-left-28">Salary for month and year</label>
       		</div>     		
			<div >
			<select class="col-md-2">
			  <option value="select">select</option>
			  <option value="Tolani Shipping Company">Tolani Shipping Company</option>
			</select>
			</div>

			<div >
       		<label class="col-md-1"></label>
       		</div>
       		
			<div >
			<select class="col-md-2">
			  <option value="select">select</option>
			  <option value="Tolani Shipping Company">Tolani Shipping Company</option>
			</select>
			</div>
			<div >
  <label class="col-md-2 padding-left-28">Refresh</label>
       		</div>     		
			<div >
			<select class="col-md-2">
			  <option value="select">select</option>
			  <option value="Tolani Shipping Company">Tolani Shipping Company</option>
			</select>
			</div>
			
			
	</div>

	
     </div>
     
       
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
       
          <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1"></th>
           <th class="sorting width_15" st-sort="">Employee Name</th>
           <th class="sorting width_15" st-sort="">Debit Ledger</th>
            <th class="sorting width_15" st-sort="">Net Pay</th>
           <th class="sorting width_15" st-sort="">Advance</th>
           <th class="sorting width_15" st-sort="">Other Deduction</th>
           
          </tr>
         
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objVesselMasterItem in displayedCollection">
           <td cs-select="objVesselMasterItem"></td>
<!--            <td>{{objVesselMasterItem.designationName}}</td> -->
<!--            <td>{{objVesselMasterItem.status}}</td> -->
          </tr>
         </tbody>
        </table>
        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>  
       
       <div class="form-actions">
     <div class="row">
      <div class="col-sm-6 col-md-6 col-lg-6">
      <!--   <div class="form-group"> -->
		        <label class="col-md-2 control-label">
		     Gross
		        </label>
		        <div class="col-md-4">
		          <input
		          type="text"
		          class="form-control "
		          ng-model="branchMaster.sectorName"
		          name="sector Name"
		          /> 
		        
		        </div>
		      <!--  </div> -->
      </div>
      
       <div class="col-sm-12 col-md-12 col-lg-12">
       <button class="btn btn-success col-md-offset-1"  type="submit">
		    		 <i class="fa fa-save"></i>Submit
		     	 </button>
		     	  <button class="btn btn-danger" data-ng-click="cancel();"type="button">
                 <i class="fa fa-close"></i>
                 Cancel
                </button>
       </div>
     </div>
    </div>
       
     
</div>
</article>
<!-- </div> -->
</section>
</div>

