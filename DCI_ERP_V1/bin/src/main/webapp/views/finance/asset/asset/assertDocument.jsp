<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -100px;
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
							<spring:message code="label.maintain.document"></spring:message>
						</h2>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="maintainDocumentForm"   novalidate  method="post">
								<div class="row">
									<br>
									<div class="col-sm-10 col-md-5">
										<fieldset>
											<div class="form-group">
												<label class="col-md-6 control-label"> <spring:message
														code="label.manual.document"></spring:message>
												</label>
												<div class="col-md-6">
													<input type="text" class="form-control input-sm"
														name="<spring:message code="label.manual.document"></spring:message>"
														data-ng-model="document.maintainDocument">
												</div>
											</div>

											<%-- <div class="form-group">
		<label class="col-md-6 control-label">
		 <spring:message code="label.description"></spring:message>						  					
		</label>
		<div class="col-md-6" >						   												   						
		 <textarea class="form-control input-sm" style="resize: none"
         name="<spring:message code="label.description"></spring:message>"
		 data-ng-model="document.description"></textarea>						   						
		</div>
	  </div> --%>

											<div class="form-group">
												<label class="col-md-6 control-label">File Upload	<spring:message
              									code="label.asterisk.symbol"></spring:message></label>
												<div class="col-md-4 inputGroupContainer">
													<div class="input-group" id="fileDiv">
														<input type="file" class="form-control align-center"
															name="excelfile"
															onchange="angular.element(this).scope().uploadQuotaionFile(this)"
															accept=".xls,.xlsx,.xlsm,.docx" style="width: 150px;" />
													</div>
													<br>

												</div>
											</div>
										</fieldset>
									</div>

									<div class="col-sm-10 col-md-5">
										<fieldset>
											<div class="form-group">
												<label class="col-md-6 control-label"> <spring:message
														code="label.upload.by"></spring:message>	<spring:message
              									code="label.asterisk.symbol"></spring:message>
												</label>
												<div class="col-md-6">
															
														<selectivity list="empolyeeList" property="document.uploadBy" id=""
	        				ng-model="document.uploadBy" name="uploadBy" form-name = "maintainDocumentForm"
	        				validation="required" friendly-name="Upload By"></selectivity>
	        				
													<!-- <select class="form-control input-sm"
														ng-model="document.uploadBy" name="Destination Location"
														ng-options="c.id as c.text for c in empolyeeList">
														<option value="">Select</option>

													</select> -->

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label"><spring:message
														code="label.upload.date"></spring:message>	<spring:message
              									code="label.asterisk.symbol"></spring:message> </label>
												<div class="col-md-6">
													<div class='input-group date datetimepick col-md-12'>
													
													 <div class="dropdown">
					      <a class="dropdown-toggle" id="uploadDate" role="button"
					          data-toggle="dropdown" data-target="#" href="#">
					       <div class="input-group">
					         <input type="text" class="form-control"
					         placeholder="dd/mm/yyyy" name="uploadDate"
					         validation="required" 
					         friendly-name="Upload Date"
					         data-ng-model="document.uploadDate"><span
					         class="input-group-addon"><i
					         class="glyphicon glyphicon-calendar"></i></span>
					        </div>
					       </a>
					       <ul class="dropdown-menu" role="menu"
					          aria-labelledby="dLabel">
					          <datetimepicker data-ng-model="document.uploadDate"
					          data-on-set-time="document.uploadDate = onDateSet(newDate)"
					          data-datetimepicker-config="{ dropdownSelector: '#uploadDate',startView:'day', minView:'day'}" />
					       </ul>
					      </div>
					      
													<!-- 	<div class="dropdown">
															<a class="dropdown-toggle" id="fromdate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		data-valid-method="submit" data-message-id="From Date"
																		data-ng-model="document.uploadDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="document.uploadDate"
																	data-on-set-time="document.uploadDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
															</ul>
														</div> -->
													</div>
												</div>
											</div>

										</fieldset>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												data-ng-click="savedocument(maintainDocumentForm,document)">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>


											<button class="btn btn-danger" type="button"
												data-ng-click="cancelDoc();">
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