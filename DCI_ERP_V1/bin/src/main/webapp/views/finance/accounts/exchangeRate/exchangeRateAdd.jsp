<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="exchangeRateForm">
				<div class="row">

					   		<div class="col-sm-12 col-md-12 col-lg-12">	
							    <div class="col-sm-3 col-md-3 col-lg-3">
								      <fieldset>
								         <!-- <div class="form-group" >
								            <label class="col-md-5 control-label">Ex.Rate Date</label>
								            <div class="col-md-7">
									          	<div class='input-group date datetimepick' style="width:112%;">
													<div class="dropdown">
														<a class="dropdown-toggle" id="exchangeRate_Date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Exchange Rate Date"
																 validation="date_euro_long|required" friendly-name="Exchange Rate Date" 
																data-ng-model="exchangeRateData.exchangeRateDate" />
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																
															</div>
														</a>
														<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
															<datetimepicker data-ng-model="exchangeRateData.exchangeRateDate" data-on-set-time="exchangeRateData.exchangeRateDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#exchangeRate_Date',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>			          	
									        </div>  
								         </div> -->
								         
								         
								         <div class="form-group ">
								<label class="col-md-4 control-label">Ex.Rate Date </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="exchangeRateData.exchangeRateDate"
										id="exchangeRate_Date" name="realisedDate"
										data-ng-change="checkDatesCL(exchangeRateData.exchangeRateDate)"
										friendly-name="Exchange Rate Date"  />
								</div>
								</div>
								      </fieldset>
							    </div>
						      	<div class="col-sm-3 col-md-3 col-lg-3" ng-disabled= 'true'>
								      <fieldset>
										<div class="form-group">
								            <label class="col-md-4 control-label">Currency</label>
								            <div class="col-md-8">
												<selectivity list="currencyList" id="txtCurrencyCode" name="Currency" 
												property="exchangeRateData.currencyCode" ng-model="exchangeRateData.currencyCode"
												validation="required" friendly-name="Currency" form-name="exchangeRateForm" object="currencyObj"></selectivity>
								            </div>
								         </div>
								         
								      </fieldset>
						    	</div>
					     		<div class="col-sm-4 col-md-4 col-lg-4">
					     			<fieldset>
					     				<div class="form-group">
								            <label class="col-md-5 control-label">Book Currency</label>
								            <div class="col-md-6">
												<selectivity list="bookCurrencyList" id="txtCurrencyCode" name="Book Currency" 
												property="exchangeRateData.bookCurrency" ng-model="exchangeRateData.bookCurrency"
												friendly-name="Book Currency" form-name="exchangeRateForm" object="bookCurrencyObj"></selectivity>
								            </div>
								         </div>
							        </fieldset>
					     		</div>
					     		<div class="col-sm-2 col-md-2 col-lg-2">
					     				<div class="form-group">
								            <label class="col-md-4 control-label">Value</label>
								            <div class="col-md-8">
								              <input class="text-right form-control" id="txtValue" name="value" 
								              data-ng-model="exchangeRateData.exchangeRateValue" placeholder="0.00" 
								              validation="required" friendly-name="Value" ng-pattern-restrict="^[0-9.]*$" />
								            </div>
								         </div>
					     				
						     			<div class="form-group pull-right">
						     				<div class="col-md-8">
									         <button class="btn btn-success" ng-if="!isEdit" type="button" 
									         ng-click="validate(exchangeRateForm, exchangeRateData)">
									          <i class="fa fa-save"></i> Save
									         </button>
									    	</div>
								        </div>
					     		</div>
				     		</div> <!-- /col-sm-12 -->
					      </div> <!-- /row -->
					    
					      	<div class="row book-widget-row" id="validCopy" ng-if="!isEdit">
					      		<div class="col-sm-12 col-md-12 col-lg-12">
					      			<div class="col-sm-6 col-md-6 col-lg-6">
						      			<fieldset class="b-a">
						      			<legend class="b-a padding-left-10">Upload</legend>
							     			<div class="form-group">
									          <label class="col-md-3 control-label">File Upload</label>
									           <div class="col-md-5">
									         		<input type="file" class="form-control input-sm" name="uploadfile" />
												</div>
									 			<div class="col-md-4">	
													<button class="btn btn-primary" type="button"
														ng-click="uploadExchangeRate()">Upload
													</button>
												</div>
									       	</div>
									       	
								        </fieldset>
					      			</div>
					      			<div class="col-sm-6 col-md-6 col-lg-6">
						     			<fieldset class="b-a">
						      				<legend class="b-a padding-left-10">Copy</legend>
							     			<!-- div class="form-group">
							         			<label class="col-md-4 control-label"> Source Date </label>			        				
												<div class="col-md-5">
										          	<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="er_sourceDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Source Date"
																	data-ng-model="exchangeRateData.sourceDate" />
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																	
																</div>
															</a>
															<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
																<datetimepicker data-ng-model="exchangeRateData.sourceDate" data-on-set-time="exchangeRateData.sourceDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#er_sourceDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>			          	
										        </div>  									
							         		</div> -->
							         		
							         		<div class="form-group ">
								<label class="col-md-4 control-label">Source Date  </label>
								<div class="col-md-5 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="exchangeRateData.sourceDate"
										id="er_sourceDate" name="Source Date"
										data-ng-change="checkDatesCL(exchangeRateData.sourceDate)"
										friendly-name="Source Date"  />
								</div>
								</div>
							         		<!-- <div class="form-group">
							         			<label class="col-md-4 control-label"> Copy Date </label>			        				
												<div class="col-md-5">
										          	<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="er_copyDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Copy Date"
																	data-ng-model="exchangeRateData.copyDate" />
																		<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																	
																</div>
															</a>
															<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
																<datetimepicker data-ng-model="exchangeRateData.copyDate" data-on-set-time="exchangeRateData.copyDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#er_copyDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>			          	
										        </div>
										        <div class="col-md-2">	
													<button class="btn btn-primary" type="button" ng-click="copyExchangeRate(exchangeRate)">Copy</button>
												</div>  									
							         		</div>  -->
							         		
							         		<div class="form-group ">
								<label class="col-md-4 control-label"> Copy Date  </label>
								<div class="col-md-5 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="exchangeRateData.copyDate"
										id="er_copyDate" name="Copy Date"
										data-ng-change="checkDatesCL(exchangeRateData.copyDate)"
										friendly-name="Copy Date"  />
								</div>
								<div class="col-md-2">	
													<button class="btn btn-primary" type="button" ng-click="copyExchangeRate(exchangeRate)">Copy</button>
												</div> 
								</div>
							         		
								        </fieldset>
						     		</div>						     		
					      		</div>
					      	</div>
					      <div class="form-actions">
					       <div class="row">
					        <div class="col-md-12">
					           	 <button class="btn btn-success" ng-if="isEdit" 
						           type="button" ng-click="save(exchangeRateAddForm, exchangeRateData)">
						            <i class="fa fa-save"></i> Update
						         </button>
					         	<button class="btn btn-danger" ng-click="cancel()" type="button">
					                 <i class="fa fa-close"></i> Cancel
					         	</button>
					        </div>
					       </div>
					      </div>
					     </form>
				      </div>
				      <!-- end widget content -->
				     </div>
			    </div>
   			</article>
   		</div>
 	</section>
</div>