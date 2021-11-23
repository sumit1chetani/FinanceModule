<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  				<div class="panel-body">
    				<form name="charterHireStmtForm" class="form-horizontal" >
		    			<div class="row">
					     	<div class="col-sm-12 col-md-12 col-lg-12">
					     		<div class="col-sm-4 col-md-4 col-lg-4">
									<div class="form-group">
            							<label for="inputPassword" class="control-label col-md-4">From Date</label>
           								<div class="col-md-7">
            									<div class="input-group input-append date" id="chs_fromDate">
               									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
               									ng-model="charterHireStmt.chFromDate" name="fromDate" id="fromDate" ng-disabled="true" />
	           									 <!-- <span class="input-group-addon add-on">
                       								<span class="glyphicon glyphicon-calendar"></span>
                   								 </span> -->
       									     </div>
           								</div>
          							</div>
								</div>
								<div class="col-sm-4 col-md-4 col-lg-4">
									<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-4">To Date</label>
            								<div class="col-md-7">
             									<div class="input-group input-append date" id="chs_toDate">
                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                									ng-model="charterHireStmt.chToDate" name="toDate" id="txtToDate" ng-disabled="true" />
		           									 <!-- <span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span> -->
        									     </div>
            								</div>
           							</div>
								</div>
								<div class="col-sm-4 col-md-4 col-lg-4">
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">Vessel<span style="color: red;"> </span></label>
										<div class="col-md-7">
											<select class="form-control" id="txtVesselCode" name="Vessel" ng-model="charterHireStmt.vesselCode" ng-options="ve.id as ve.text for ve in vesselList" ng-disabled="true"></select>
											<!-- <selectivity list="vesselList" property="row.vesselCode" id="txtVesselCode"></selectivity> -->
										</div>
									</div>
								</div>								    
					     	</div>
					     	<div class="col-sm-12 col-md-12 col-lg-12 width_100 pull-left">
							     <div class="col-sm-6 col-md-6 col-lg-6 width_50">
								    <div class="form-group">
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;">Date: </label>					     		
							     	</div>
							     	<div class="form-group">					     		
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;">Charter Hire No: </label>
							     		<label class="control-label" style="padding-top: 7px;margin-bottom: 0;text-align: right;" ng-bind="charterHireStmt.charterHireNo"> </label>
							     	</div>
							     </div>
						     </div>
					     	<div class="col-sm-12 col-md-12 col-lg-12 width_100" st-table="displayedCollection" st-safe-src="rowCollection">
					     		<fieldset class="b-a">
						      		<legend class="width_100 text-center no-border m-n">CHARTER HIRE STATEMENT</legend>
						      		<legend class="width_100 text-center no-border m-n text-font-size-20p">Vessel: 
						      		</legend>
						      		<legend class="width_100 text-center no-border m-n text-font-size-20p" ng-bind="charterHireStmt.vesselName"></legend>
						      	
									<table class="table table-striped table-bordered table-hover dataTable no-footer" 
									align=center border=0 cellPadding=0 cellSpacing=0 width="100%">
										<thead border="1">
											<tr>
												<th colspan=1 style="width: 20%; border:0px; height:38px;" class="width_2 no-border height-38p"></th>
												<th colspan=1 style="width: 70%;height:38px; text-align:center; border:0;"></th>
												<th colspan=1 style="width:20%;text-align:center;font-weight: bold;background-color: #cfdadd;">
												Total in USD
												</th>							
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="width_20">A</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														Period
													</div>													
												</td>
											</tr>
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="padding-top-20 row" ng-repeat="objCharterHireBean in displayedCollection">
														<div class="col-xs-12">
															<div class="col-xs-4">
																<div class="form-group">
																	From
																</div>												
															</div>
															<div class="col-xs-4">
																<div class="form-group">
																	<span ng-bind="objCharterHireBean.chFromDate"></span>
																	<span ng-bind="objCharterHireBean.currencyCode"></span>
																</div>												
															</div>
														</div>
														<div class="col-xs-12">
															<div class="col-xs-4">
																<div class="form-group">
																	Till
																</div>												
															</div>
															<div class="col-xs-4">
																<div class="form-group">
																	<span ng-bind="objCharterHireBean.chToDate"></span>
																	<span ng-bind="objCharterHireBean.currencyCode"></span>
																</div>												
															</div>
														</div>
														<div class="col-xs-12">
															<div class="col-xs-4">
																<div class="form-group">
																	i.e.,
																</div>												
															</div>
															<div class="col-xs-4">
																<div class="form-group">
																	<span ng-bind="objCharterHireBean.noOfDays"></span>
																	days * 
																	<span ng-bind="objCharterHireBean.currencyCode"></span>
																	7300 pdpr
																</div>												
															</div>
														</div>
													</div>
												</td>
												<td class="width_20">
													<div class="padding-top-20 row" ng-repeat="objCharterHireBean in displayedCollection">
														
														<div class="col-xs-12">															
															<div class="form-group padding-top-55 text-right">
																<span ng-bind="objCharterHireBean.totalCharges"></span>																
															</div>
														</div>
													</div>											 
												</td>
											</tr>
											
											<tr>
												<td class="width_20">B</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														LESS
													</div>
												</td>	
											</tr>
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-4">
															<div class="form-group">
																Add commission 2.5%
															</div>												
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="row">														
														<div class="col-xs-12">															
															<div class="form-group text-right font-red">
																<span ng-bind="chStmt.totalChargesWithCommission"></span>																
															</div>
														</div>
													</div>																						 
												</td>
											</tr>
											<tr>
												<td class="width_20">C</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														CHARTERERS' EXPENSE
													</div>
												</td>	
											</tr>
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group">
																Communication (USD 600/month)
															</div>
															<div class="form-group">
																Representation (USD 500/month)
															</div>
															<div class="form-group">
																Lashing Expense (USD 1200/month)
															</div>												
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="row">
														<div class="col-xs-12">
															<div class="form-group text-right">
																<span ng-bind="chStmt.charExpenseComn"></span>
															</div>
															<div class="form-group text-right">
																<span ng-bind="chStmt.charExpenRep"></span>
															</div>
															<div class="form-group text-right">
																<span ng-bind="chStmt.charLashingExpen"></span>
															</div>
														</div>		
													</div>									 
												</td>	
											</tr>
											<tr>
												<td class="width_20">D</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														OWNERS' EXPENSE
													</div>
												</td>	
											</tr>
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="row">
														<div class="col-xs-12">
															<div class="col-xs-8">
																<div class="form-group">
																	Acct/01
																</div>		
																<div class="form-group">
																	Acct/02
																</div>		
																<div class="form-group">
																	Acct/03
																</div>												
															</div>		
															<div class="col-xs-4">
																<div class="form-group text-right">															 
																	<span ng-bind="chStmt.ownersExpAcct1"></span>		
																</div>		
																<div class="form-group text-right">
																	<span ng-bind="chStmt.ownersExpAcct2"></span>
																</div>		
																<div class="form-group text-right b-b b-black">
																	<span ng-bind="chStmt.ownersExpAcct3"></span>
																</div>												
															</div>												
														</div>
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group text-right">-
														</div>
														<div class="form-group text-right">-
														</div>
														<div class="form-group font-red text-right">
															<span ng-bind="chStmt.ownersExpenceCharges"></span>
														</div>
													</div>											 
												</td>
											</tr>
											<tr>
												<td class="width_20">E</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														DELIVERY BUNKER
													</div>
												</td>
											</tr>	
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group">
																FO:  169.2mt  x  USD 395 pmt
															</div>																									
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group text-right">
															<span ng-bind="chStmt.deliveryBunkerCharges"></span>
														</div>
													</div>											 
												</td>
											</tr>									
											<tr>
												<td class="width_20">F</td>
												<td class="width_70">
													<div class="col-xs-8 text-left bold">
														PROVISION
													</div>
												</td>											
											</tr>
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group">
																Redelivery FO Bunker (Estimated):  (250mt  x  USD 420 pmt)  x  (1/2)
															</div>																									
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group text-right font-red">
															<span ng-bind="chStmt.redeliveryBunkerCharges"></span>
														</div>
													</div>											 
												</td>
											</tr>	
											<tr>
												<td class="width_20"></td>
												<td class="width_70">
													<div class="col-xs-12">
														<div class="col-xs-8">
															<div class="form-group bold">
																Nett Due To Owners
															</div>																									
														</div>												
													</div>
												</td>
												<td class="width_20">
													<div class="col-xs-12 no-padder">
														<div class="form-group bg-color-cfdadd">
															<span ng-bind="chStmt.NettDueToOwnerCharges"></span>														
														</div>
													</div>											 
												</td>
											</tr>	
										</tbody>
									</table>
								</fieldset>
							</div> <!-- /col-sm-12 -->
						</div>
						<div class="form-actions"><!-- Form Actions -->
					   		<div class="row">
								<div class="col-md-12 ">
								
				         			<button class="btn btn-danger" ng-click="cancel();">
				          				<i class="fa fa-search"> Cancel</i>
				         			</button>			         			  	
			         			</div>
		      				</div>
		     			</div>
         			</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>