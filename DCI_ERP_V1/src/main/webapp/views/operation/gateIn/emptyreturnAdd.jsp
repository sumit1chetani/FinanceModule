
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="gateInForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							
								
						
						
						<div class="form-group ">
                 <label class="col-md-5 control-label">Type<span
                 style="color: red">*</span></label>
                  <div class="col-md-7">
                     <selectivity list="typeList" disabled="true"
                           property="gateIn.type" id="type" name="type"
                        ng-model="gateIn.type" object="type"
                     friendly-name="type" validation="required"
                    form-name="gateInForm" value="true"></selectivity>
                   </div>
             </div>

							
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-5 control-label">Gate IN No<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="gateInNo"
									property="gateIn.gateInNo" id="gateInNo"
									ng-model="gateIn.gateInNo"
									friendly-name="gateInNo" disabled="true" />
								</div>
								
								
							</div>
						
				       		
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
								<div class="form-group"  >
								<label class="col-md-5 control-label" >Gate Out No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
		                     
		                     <input type="text"
									class="form-control input-sm text-left" name="gateOutNo"
									property="gateIn.gateOutNo" id="gateOutNo"
									ng-model="gateIn.gateOutNo"
									friendly-name="gateInNo" disabled="true" />
									 
									
	                                 </div>
                            </div>
           
           			<div class="form-group"  ng-if="gateIn.type=='Import'  && gateIn.service=='COC'">
								<label class="col-md-5 control-label" >DO No<span
									style="color: red;">*</span>
								</label>
		                   <div class="col-md-7">
									<selectivity list="doNoList"
										property="gateIn.doNo" id="doNo"
										ng-model="gateIn.doNo" name="doNo"
										validation="required" friendly-name="doNo"
										form-name="gateInForm" disabled="isEdit" >
									</selectivity>  
									
	                                      </div>
                                 </div>
              
              
              
								<div class="form-group"  ng-if="gateIn.service=='SOC'">
								<label class="col-md-5 control-label"> Depot<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity list="depotListSOC"
										property="gateIn.depot" id="depot"
										ng-model="gateIn.depot" name="depot"
										validation="required" friendly-name="depot"
										form-name="gateInForm"></selectivity>
								</div>
							</div>
							
								<div class="form-group"  ng-if="gateIn.service=='COC'">
								<label class="col-md-5 control-label"> Depot<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity list="depotList"
										property="gateIn.depot" id="depot"
										ng-model="gateIn.depot" name="depot"
										validation="required" friendly-name="depot"
										form-name="gateInForm" disabled="true" ></selectivity>
								</div>
							</div>
							   
										
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						 <fieldset>
						 <div class="form-group">
								<label class="col-md-5 control-label">Gate IN Date<span
									style="color: red;">*</span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<input type="text" class="form-control input-sm"
												id="returnDate" name="returnDate" 
											ng-model="gateIn.returnDate" validation="required"  
												friendly-name="returnDate" disabled="true" /> <span
												class="input-group-addon add-on"><span
												form-name="gateInForm" class="glyphicon glyphicon-calendar" ></span></span>
												</div>
							
								</div>
							</div>	
							  
                               <div class="form-group" ng-if="isEdit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red;">*</span>
								</label>
	                               	<div class="col-md-7">
									<selectivity list="customerList1"
										property="gateIn.customer" id="customer"
										ng-model="gateIn.customer" name="customer"
										validation="required" friendly-name="customer"
										form-name="gateInForm" 	disabled="true"></selectivity>
                                 	</div>
                             </div>
							</fieldset>
					</div>
				</div>
				
				
				
				<div class="table-responsive clear" >
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Container No<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Seal No<span
									style="color: red;"></span></th>
								<th colspan=1 class="width_17 text-center">Gate IN Date<span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_18 text-center">Previous Status Date<span
									style="color: red;"></span></th>
								<th colspan=1 class="width_15 text-center">Load<span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtl">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td>
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerTypeList"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="gateInForm"></selectivity>

										</div>
									</div>
								</td>

		                        <td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="containerNoList"
												property="row.containerNo" id="containerNo{{trIndex}}"
												data-ng-model="row.containerNo"
												name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}"
												form-name="gateInForm" disabled ="true"></selectivity>

										

										</div>
									</div>
								</td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}"  disabled ="true"/>
										</div>
									</div>
								</td>
								
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
									
												
												<div class="input-group  input-append date" disabled ="true">
										<bootstrapdatetimepicker  	property="row.returnDate" ng-model="row.returnDate" id="returnDate{{trIndex}}" 
										name="returnDate{{trIndex}}"    friendly-name="{{ 'Row' + $index + '(Return Date)'}}"
										form-name="gateInForm"  />
										</div>
										
										</div>
									</div>
								</td>
								
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
									 
									 
									<div class="input-group  input-append date">
											<input type="text" class="form-control input-sm"
											     property="row.previousStatusDate" id="previousStatusDate{{trIndex}}"
												data-ng-model="row.previousStatusDate" name="previousStatusDate{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(previousStatusDate)'}}" disabled ="true"/>
												
										
										</div>
									</div>
								</td>
								
									<td class="width_15" align = "center">
									<div class="row">
												
						  	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" >
										
									
									</div>
								</td>
				
							</tr>
						</tbody>
					
					</table>
					
					<br> <br> <br>
				</div>
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" 
								class="btn btn-success"
								ng-click="save(gateInForm,gateIn)">
								<i class="fa fa-save"></i> Approve

							</button>
							
							
							 
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>





