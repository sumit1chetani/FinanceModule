<style>
.ui-search-table{
	display :none !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
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
  	<div role="content">
   		<form class="form-horizontal" name="assetLocationForm" role="form" novalidate>
	      <div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 panel-body">
						<div class="col-md-4">
				          	<div class="form-group">
								<label class="col-md-3 control-label">Asset Item</label>
								<div class="col-md-6">
									<selectivity list="itemLists" property="assetLocation.itemId" id="itemName"></selectivity>
									
								</div>
							</div>

		          		</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-3 control-label">Location</label>
								<div class="col-md-6">
									<selectivity list="locationLists" property="assetLocation.locationId" id="locationName"></selectivity>
								</div>
							</div>
						</div>
		          		<div class="col-md-4">
			          		<div class="form-group">
								<div class="col-md-12">
			            			<button class ="btn btn-success width_25" data-ng-click="getItemList(assetLocation)">Submit</button>
			            			<button class ="btn btn-info width_25" data-ng-click="reset()">Reset</button>
	            				</div>
            				</div>
		          		</div>
		          </div>
				</div>

		      <div class="row">
					<div class="padding-left-5 padding-top-5" id="jqgrid">
						<div id="locationGrid">
			  				<table id="grid"></table>
			  				<div id="assetLocation"></div>
		  				</div>
					</div>
			  </div>

   		 </form>
      <!-- end widget content -->
     <!-- end widget div -->
    </div>
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>