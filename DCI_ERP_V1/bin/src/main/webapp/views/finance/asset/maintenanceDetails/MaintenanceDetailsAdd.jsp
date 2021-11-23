<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetmaintenaceScheduleForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
									
									<div class="row">
					<div class="padding-left-20 padding-top-5" id="jqgrid">
						<div id="inventGrid">
			  				<table id="grid"></table>
			  				<div id="inventorypage"></div>
		  				</div>
					</div>
			  </div>
																			</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											
											<button class="btn btn-danger" type="button"
												data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												Back To List
											</button>
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