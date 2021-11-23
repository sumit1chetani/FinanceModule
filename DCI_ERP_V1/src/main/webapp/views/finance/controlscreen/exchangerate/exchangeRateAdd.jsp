<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="wrapper-md">
   <div class="panel panel-default">
    <div class="panel-body">
     <form class="form-horizontal" name="exchangeRateForm" role="form" novalidate method="post">
	   	<div class="row book-widget-row">
	   		<div class="col-sm-12 col-md-12 col-lg-12">	
			    <div class="col-sm-3 col-md-3 col-lg-3">
				      <fieldset>
				         <div class="form-group" >
				            <label class="col-md-5 control-label">Ex. Rate Date <span class="font-red">*</span></label>
				            <div class="col-md-7">
					          	<div class='input-group date datetimepick' >
				                 <input type="text" class="form-control" id="txtExchangeRateDate" name="Exchange Rate Date" 
				                 ng-model="exchangeRateData.exchangeRateDate" placeholder="dd/mm/yyyy"
				                 validation="date_euro_long|required" friendly-name="Exchange Rate Date" />
				                  <span class="input-group-addon">
				                     <span class="glyphicon glyphicon-calendar">
				                     </span>
				                  </span>
				              </div>					          		          	
					        </div>  
				         </div>
				      </fieldset>
			    </div>
		      	<div class="col-sm-3 col-md-3 col-lg-3">
				      <fieldset>
						<div class="form-group">
				            <label class="col-md-4 control-label">Currency <span class="font-red">*</span></label>
				            <div class="col-md-8">
								<selectivity list="currencyList" id="txtCurrencyCode" name="Currency" 
								property="exchangeRateData.currencyCode" ng-model="exchangeRateData.currencyCode"
								validation="required" friendly-name="Currency" form-name="exchangeRateForm" object="currencyObj"></selectivity>
				            </div>
				         </div>
				         
				      </fieldset>
		    	</div>
	     		<div class="col-sm-3 col-md-3 col-lg-3">
	     			<fieldset>
	     				<!-- <div class="form-group">
				            <label class="col-md-5 control-label">Book Currency <span color="font-red">*</span></label>
				            <div class="col-md-7">
								<selectivity list="bookCurrencyList" id="txtCurrencyCode" name="Book Currency" 
								property="exchangeRateData.bookCurrency" ng-model="exchangeRateData.bookCurrency"
								validation="required" friendly-name="Book Currency" form-name="exchangeRateForm" object="bookCurrencyObj"></selectivity>
				            </div>
				         </div> -->
		     			<div class="form-group">
				            <label class="col-md-4 control-label">Value <span class="font-red">*</span></label>
				            <div class="col-md-8">
				              <input class="text-right form-control" id="txtValue" name="value" 
				              data-ng-model="exchangeRateData.exchangeRateValue" placeholder="0.00"
				              ng-blur="validateExchangeRateValue(exchangeRateData.currencyCode,exchangeRateData.exchangeRateValue)" 
				              validation="numeric|required" friendly-name="Value" />
				            </div>
				         </div>
	     				
		     			
			        </fieldset>
	     		</div>
	     		<div class="col-sm-3 col-md-3 col-lg-3">
	     				<div class="form-group">
		     				<div class="col-md-8">
					         <button class="btn btn-success" ng-if="!isEdit" type="button"
					         ng-click="validate(exchangeRateForm, exchangeRateData)" ng-disabled="!isexchangeRate">
					          <i class="fa fa-save"></i> Save
					         </button>
					         <button class="btn btn-success" ng-if="isEdit" 
					           type="button" ng-click="save(exchangeRateAddForm, exchangeRateData)">
					            <i class="fa fa-save"></i> Update
					         </button>
					    	</div>
				        </div>
	     		</div>
     		</div> <!-- /col-sm-12 -->
	      </div> <!-- /row -->
	    
	      	<div class="row book-widget-row" id="validCopy">
	      		<div class="col-sm-12 col-md-12 col-lg-12">
	      			<div class="col-sm-6 col-md-6 col-lg-6" ng-if="!(isEdit)">
		      			<fieldset class="b-a">
		      			<legend class="b-a padding-left-10">Upload</legend>
			     			<div class="form-group">
					          <label class="col-md-3 control-label">File Upload</label>
					           <div class="col-md-5">
					         		<!-- <input type="file" class="form-control input-sm" name="uploadfile" /> -->
					         		<input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
								</div>
					 			<div class="col-md-4">	
									<button class="btn btn-primary" type="button"
										ng-click="uploadExchangeRate()">Upload
									</button>
								</div>
					       	</div>
					       	
				        </fieldset>
	      			</div>
	      			<div class="col-sm-6 col-md-6 col-lg-6" ng-if="!isEdit">
		     			<fieldset class="b-a">
		      				<legend class="b-a padding-left-10">Copy</legend>
			     			<div class="form-group">
			         			<label class="col-md-4 control-label"> Source Date <span color="font-red"></span></label>	        				
								<div class="col-md-5">
									<div class='input-group date datetimepick' >
						                 <input type="text" class="form-control" ng-model="exchangeRateData.sourceDate" placeholder="dd/mm/yyyy" id="sourceDate" 
						                     value="{{exchangeRateData.sourceDate}}" />
						                  <span class="input-group-addon">
						                     <span class="glyphicon glyphicon-calendar">
						                     </span>
						                  </span>
					              	</div>						          		          	
						        </div>  									
			         		</div>
			         		<div class="form-group">
			         			<label class="col-md-4 control-label"> Copy Date <span color="font-red"></span></label>			        				
								<div class="col-md-5">
						          	<div class='input-group date datetimepick' >
						                 <input type="text" class="form-control" ng-model="exchangeRateData.copyDate" placeholder="dd/mm/yyyy" id="copyDate" 
						                     value="{{exchangeRateData.copyDate}}" />
						                  <span class="input-group-addon">
						                     <span class="glyphicon glyphicon-calendar">
						                     </span>
						                  </span>
				             		</div>	
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
		           	<!-- <button class="btn btn-primary" type="reset" class="btn btn-success">
		            	<i class="fa fa-undo"></i> Reset
		           </button> -->
		         	<button class="btn btn-danger" ng-click="cancel()" type="button">
		                 <i class="fa fa-close"></i> Cancel
		         	</button>
		        </div>
		       </div>
	      	</div>
		</form>
    </div>
   </div>
  </div>
 </div>
</div>