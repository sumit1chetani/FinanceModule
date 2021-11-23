<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
			   		<form name="creditNoteForm" class="form-horizontal" novalidate>
			    		<div class="row book-widget-row">
			    			<div class="col-sm-12">
							    <div class="col-sm-3">
							        
							        <div class="form-group">
											<label class="col-md-4 control-label p-l-0 bold"> Invoice No</label>
											<div class="col-md-8">
												<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.phcinvoiceCode"></label>
											</div>
										</div>
							        <div class="form-group">
											<label class="col-md-4 control-label p-l-0 bold"> Company</label>
											<div class="col-md-8">
												<label class="form-control input-sm b-none" ng-bind="creditnoteAcctData.company"></label>
											</div>
										</div>
									<div class="form-group ">
									        <label class="col-md-4 control-label bold">Pol </label>
									        <div class="col-md-8">							
										        <label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.polISOCode"></label>
									        </div>
								       	</div>	
								    <div class="form-group ">
									        <label class="col-md-4 control-label bold">BL No. </label>
									        <div class="col-md-8">										        
										        <label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.blNo"></label>
									        </div>
								       	</div>	
								       	
								    <!-- <div class="form-group ">
									        <label class="col-md-4 control-label bold">Fee Type</label>
									        <div class="col-md-8">									        	
									        	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.feeType"></label>
									        </div>
								       	</div>    -->
								       		    	
							      
							    </div>
						      	<div class="col-sm-3">
						       		<div class="form-group">
								        <label class="col-md-4 control-label bold">Inv Date</label>
								        <div class="col-md-8">
											<div class="input-group input-append date" id="in_date" >
												<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.phcinvoiceDate"></label>
										     </div>
										</div>
							     	</div>
							    	<div class="form-group ">
								        <label class="col-md-4 control-label bold">Pot </label>
								        <div class="col-md-8">
									        <label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.pot"></label>
								        </div>
							       	</div>   
							    	<div class="form-group ">
								        <label class="col-md-4 control-label bold">Payer	</label>
								        <div class="col-md-8">
									        <label class="form-control input-sm b-none" ng-bind="creditnoteAcctData.accountName"></label>
								        </div>
							       	</div>
							     	<!-- <div class="form-group ">
								        <label class="col-md-4 control-label bold">Rate</label>
								        <div class="col-md-8">
								        	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.feeRate"></label>
								        </div>
							       	</div>	 -->						       	 
							       <!-- 	<div class="form-group">
								        <label class="col-md-4 control-label bold">TC Amt</label>
								        <div class="col-md-8">									        	
								        	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.totalTCFee"></label>
								        </div>
							       	</div>	 -->
							       	<div class="form-group">
								        <label class="col-md-4 control-label bold">Frieght Inv.</label>
								        <div class="col-md-8">
								         	<!-- <a href="#/invoice/singleInvoiceView/{{creditnoteAcctData.invoiceNo}}"  target="_blank" style="cursor:hand;"><label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.invoiceNo"></label></a> -->
								         	<a href="#/invoice/singleInvoiceView/{{creditnoteAcctData.invoiceNo}}" target="_blank" ng-bind="creditnoteAcctData.invoiceNo" class="col-md-6 text-left control-label">{{creditnoteAcctData.invoiceNo}}</a>
								        </div>
							    	</div>	     	
						      	</div>
						        <div class="col-sm-3">
						        	<div class="form-group ">
								        <label class="col-md-4 control-label bold">Vessel </label>
								        <div class="col-md-8">
									        <label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.vesselName"></label>
								        </div>
							       	</div>
							    	<div class="form-group ">
								        <label class="col-md-4 control-label bold">Pod </label>
								        <div class="col-md-8">
									        <label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.podISOCode"></label>
								        </div>
							       	</div>
							     	<div class="form-group ">
								        <label class="col-md-4 control-label bold">Currency</label>
								        <div class="col-md-8">
								        	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.currencyCode"></label>
								        </div>
							       	</div>  
							       <!-- 	<div class="form-group">
								        <label class="col-md-4 control-label bold">No of Bill</label>
								        <div class="col-md-8">
								         	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.noOfBill"></label>
								        </div>
							    	</div>	 -->
							    	   	<div class="form-group">
								        <label class="col-md-4 control-label bold">Shipment</label>
								        <div class="col-md-8">
								         	<label class="form-control input-sm b-none line-height-25"><span data-ng-if="creditnoteAcctData.shipment === ''">-</span><span data-ng-if="creditnoteAcctData.shipment !== ''">{{creditnoteAcctData.shipment}}</span></label>
								        </div>
							    	</div>	 
							    	
							       	
							    	
							    								    		
						        </div>
					         	<div class="col-sm-3">
						        	<div class="form-group ">
								        <label class="col-md-4 control-label bold">Voyage </label>
								        <div class="col-md-8">									        
									        <label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.voyage"></label>
								        </div>
							       	</div>
							      	<div class="form-group ">
								        <label class="col-md-4 control-label p-l-0 bold">Customer	</label>
								        <div class="col-md-8">									        
									        <label class="form-control input-sm b-none" ng-bind="creditnoteAcctData.customerName"></label>
								        </div>
							       	</div> 	
							       	<div class="form-group">
								        <label class="col-md-4 control-label bold">Ex Rate</label>
								        <div class="col-md-8">
								         	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.exchangeRate"></label>
								        </div>
							       	</div>
							       	<!-- <div class="form-group ">
								        <label class="col-md-4 control-label bold">BC Amt</label>
								        <div class="col-md-8">
								        	<label class="form-control input-sm b-none line-height-25" ng-bind="creditnoteAcctData.totalBCFee"></label>
								        </div>
							       	</div> -->	
					         	</div>
					   		</div>
			   			</div> <!-- /row -->
					    <div class="table-responsive clear">
					      <table class="table table-striped b-t b-light">
					        <thead>
					          <tr>
					            <th colspan=1 class="width_1"></th>
					            <th colspan=1 class="width_13 text-center">Account Head</th>
					            <th colspan=1 class="width_10 text-center">Service</th>
					            <th colspan=1 class="width_10 text-center">Con. Type</th>
					             <th colspan=1 class="width_10 text-center">Rate</th>
					              <th colspan=1 class="width_10 text-center">No of Con.</th>
					            <th colspan=1 class="width_10 text-center">TC Amt</th>
					            <th colspan=1 class=" width_10 text-center">BC Amt ({{creditnoteAcctData.companyCurrency}})</th>
					            <th colspan=1 class="width_1"></th>
					          </tr>
					        </thead>
					        <tbody ng-repeat="(trIndex, row) in creditnoteAcctData.credittables" ng-controller="tableViewCtrl">
					        	<tr>
						            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">
							              		<label class="form-control input-sm b-none" ng-bind="row.crdtlAccountHead"></label>
						        			</div>
						        		</div>
						        	</td>
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">							              		
												<label class="form-control input-sm b-none" ng-bind="row.service"></label>		
						        			</div>
						        		</div>
						        	</td>
						        	
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">
							              		<label class="form-control input-sm b-none" ng-bind="row.conType"></label>					
						        			</div>
						        		</div>
						        	</td>	        	
						          	<td class="width_10">
						          		<div class="row" >
						            		<div class="col-xs-12">
						         	  			<label class="form-control input-sm b-none" ng-bind="row.conRate"></label>
						              		</div>
						              	</div>
						            </td>
						            
						            <td class="width_10">
						          		<div class="row" >
						            		<div class="col-xs-12">						         	  			
						         	  			<label class="form-control input-sm b-none" ng-bind="row.noOfCon"></label>
						              		</div>
						              	</div>
						            </td>
						            <td>
							           	<div class="row">
							           		<div class="col-xs-12">
							        	  		<label class="form-control input-sm b-none" ng-bind="row.tcamount"></label>
							             	</div>
							            </div>
						            </td>
						            <td>
						            	<div class="row" >
						            		<div class="col-xs-12">
						         	  			<label class="form-control input-sm b-none" ng-bind="row.bcamount"></label>
						              		</div>
						              	</div>
						            </td>
						            
					     		</tr>     	
					     	</tbody>
					      </table>					      
						</div>  
						<div class="table-responsive clear">
					      <table class="table table-striped b-t b-light">
					        <thead>
					          <tr>
					            <th colspan=1 class="width_1"></th>
					            <th colspan=3 class="width_34 text-center">Fee Type</th>
					             <th colspan=1 class="width_10 text-center">Rate</th>
					              <th colspan=1 class="width_10 text-center">No of Bl.</th>
					            <th colspan=1 class="width_10 text-center">TC Amt</th>
					            <th colspan=1 class=" width_10 text-center">BC Amt ({{creditnoteAcctData.companyCurrency}})</th>
					            <th colspan=1 class="width_1"></th>
					          </tr>
					        </thead>
					        <tbody>
					        	<tr>
						            <td></td>
						            <td colspan=3>
						            	<div class="row">
						            		<div class="col-xs-12">
							              		<label class="form-control input-sm b-none text-center" ><span data-ng-if="creditnoteAcctData.feeType == '' ">-</span>
							              		<span data-ng-if="creditnoteAcctData.feeType !== '' ">{{creditnoteAcctData.feeType}}</span>
							              		</label>
						        			</div>
						        		</div>
						        	</td>
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">							              		
												<label class="form-control input-sm b-none" data-ng-bind="creditnoteAcctData.feeRate"></label>		
						        			</div>
						        		</div>
						        	</td>
						        	
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">
							              		<label class="form-control input-sm b-none" data-ng-bind="creditnoteAcctData.noOfBill"></label>					
						        			</div>
						        		</div>
						        	</td>	        	
						          	<td class="width_10">
						          		<div class="row" >
						            		<div class="col-xs-12">
						         	  			<label class="form-control input-sm b-none" data-ng-bind="creditnoteAcctData.totalTCFee"></label>
						              		</div>
						              	</div>
						            </td>
						            
						            <td class="width_10">
						          		<div class="row" >
						            		<div class="col-xs-12">						         	  			
						         	  			<label class="form-control input-sm b-none" data-ng-bind="creditnoteAcctData.totalBCFee"></label>
						              		</div>
						              	</div>
						            </td>
						            <td></td>
						            
					     		</tr>     	
					     	</tbody>
					      </table>					      
						</div>  
						
						<div class="table-responsive clear">
					      <table class="table table-striped b-t b-light">
					        <thead>
					          <tr>
					            <th colspan=1 class="width_1"></th>
					            <th colspan=1 class="width_13 text-center">Account Head</th>
					            <th colspan=1 class="width_10 text-center">Service</th>
					            <th colspan=1 class="width_10 text-center">Con. Type</th>
					             <th colspan=1 class="width_10 text-center">Rate</th>
					              <th colspan=1 class="width_10 text-center">No of Con.</th>
					            <th colspan=1 class="width_10 text-center">TC Amt</th>
					            <th colspan=1 class=" width_10 text-center">BC Amt ({{creditnoteAcctData.companyCurrency}})</th>
					            <th colspan=1 class="width_1"></th>
					          </tr>
					        </thead>
					        <tbody ng-repeat="(trIndex, row1) in creditnoteAcctData.doorOpenTable" ng-controller="tableViewCtrl">
					        	<tr>
						            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row1.select" id="section{{trIndex}}"><i></i></label></td>
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">
							              		<label class="form-control input-sm b-none" ng-bind="row1.crdtlAccountHead"></label>
						        			</div>
						        		</div>
						        	</td>
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">							              		
												<label class="form-control input-sm b-none" ng-bind="row1.service"></label>		
						        			</div>
						        		</div>
						        	</td>
						        	
						            <td>
						            	<div class="row">
						            		<div class="col-xs-12">
							              		<label class="form-control input-sm b-none" ng-bind="row1.conType"></label>					
						        			</div>
						        		</div>
						        	</td>	        	
						          	<td class="width_10">
						          		<div class="row" >
						            		<div class="col-xs-12">
						         	  			<label class="form-control input-sm b-none" ng-bind="row1.conRate"></label>
						              		</div>
						              	</div>
						            </td>
						            
						            <td class="width_10">
						          		<div class="row" >
						            		<div class="col-xs-12">						         	  			
						         	  			<label class="form-control input-sm b-none" ng-bind="row1.noOfCon"></label>
						              		</div>
						              	</div>
						            </td>
						            <td>
							           	<div class="row">
							           		<div class="col-xs-12">
							        	  		<label class="form-control input-sm b-none" ng-bind="row1.tcamount"></label>
							             	</div>
							            </div>
						            </td>
						            <td>
						            	<div class="row" >
						            		<div class="col-xs-12">
						         	  			<label class="form-control input-sm b-none" ng-bind="row1.bcamount"></label>
						              		</div>
						              	</div>
						            </td>
						            
					     		</tr>     	
					     	</tbody>
					      </table>					      
						</div> 
						
						
						  <!-- /table-responsive -->
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group pull-right">
							       
							        <label class="col-md-5 control-label bold">Total TC Amt</label>
							        <div class="col-md-4">
							         	<label class="form-control input-sm b-none" ng-bind="creditnoteAcctData.totalTCAmount"></label>
							        </div>
							        
							         <label class="col-md-5 control-label bold">Total BC Amt</label>
							        <div class="col-md-4">
						         	  	<label class="form-control input-sm b-none" ng-bind="creditnoteAcctData.totalBCAmount"></label>		
							        </div>
						       </div>
							</div>
						</div>
						 <div class="row">
					     <div class="col-sm-12 col-md-12 col-lg-12">
					      <div class="content">
					      	<div class="form-actions">
					        <div class="row">
					         <div class="col-md-12">
					          <button class="btn btn-success" ng-if="phcTable==false" type="button" data-ng-click="printPHCInvoice(creditnoteAcctData.phcinvoiceCode,'both',1)">
					           Print Both
					          </button>
					          <button class="btn btn-success" ng-if="phcTable==false" type="button" data-ng-click="printPHCInvoice(creditnoteAcctData.phcinvoiceCode,'usd',2)">
					           Print USD
					          </button>
					          <button class="btn btn-success" ng-if="phcTable==false" type="button" data-ng-click="printPHCInvoice(creditnoteAcctData.phcinvoiceCode,'local',3)">
					           Print Local
					          </button>
					          <button class="btn btn-danger" ng-if="phcTable==false" ng-click="cancel()" type="button">
					           <i class="fa fa-close"></i>
					           Cancel
					          </button>
					          <button class="btn btn-danger" ng-if="phcTable==true" ng-click="cancel1()" type="button">
					           <i class="fa fa-close"></i>
					           Cancel
					          </button>
					         </div>
					        </div>
					       </div>
					      </div>
					     </div>
					    </div>
			   		</form>
			 	</div>
			</div>
		</div> <!-- /wrapper-md -->
	</div>
</div>