
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
							
								<div class="form-group" hidden=true>
									<label class="col-md-5 control-label">Service</label>

									<div class="col-md-7">
										<div class="radio radio-inline" >
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0"   name="service"
												ng_model="gateIn.service" value="COC"
												checked="checked"> <i></i> COC
											</label>
										</div>
										<div class="radio  radio-inline">
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0" ng_model="gateIn.service"
												value="SOC"   name="service"> <i></i>
											SOC
											</label>
										</div>
				
									</div>
								</div>
						
						
						<div class="form-group "  ng-if="gateIn.service=='COC'">
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


						
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-5 control-label">Gate IN No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="gateInNoMaxCnt"
									property="gateIn.gateInNoMaxCnt" id="gateInNoMaxCnt"
									ng-model="gateIn.gateInNoMaxCnt"
									friendly-name="gateInNoMaxCnt" disabled="true" />
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
						
				       		<div class="form-group"  ng-if="gateIn.service=='SOC'">
								<label class="col-md-5 control-label" >Booking No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
									<selectivity list="bookingNoList"
										property="gateIn.bookingNo" id="bookingNo"
										ng-model="gateIn.bookingNo" name="bookingNo"
										validation="required" friendly-name="bookingNo"
										form-name="gateInForm" ></selectivity>  
	                                 </div>
                            </div>
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
								<div class="form-group"  ng-if="gateIn.type=='Empty Return' && gateIn.service=='COC'">
								<label class="col-md-5 control-label" >Gate Out No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
									<selectivity list="gateOutList"
										property="gateIn.gateOutNo" id="gateOutNo"
										ng-model="gateIn.gateOutNo" name="gateOutNo"
										validation="required" friendly-name="gateOutNo"
										form-name="gateInForm" disabled="isEdit" ></selectivity>  
									
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
										form-name="gateInForm"  ></selectivity>
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
												friendly-name="returnDate" /> <span
												class="input-group-addon add-on"><span
												form-name="gateInForm" class="glyphicon glyphicon-calendar"></span></span>
												</div>
							<!-- 	<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="gateIn.returnDate" id="returnDate"
										name="returnDate"  ng-model="gateIn.returnDate"  friendly-name="returnDate"
										form-name="gateInForm"  />
										</div> -->
								</div>
							</div>	
							  <div class="form-group" ng-if="!isEdit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red;">*</span>
								</label>
	                               	<div class="col-md-7">
									<selectivity list="customerList"
										property="gateIn.customer" id="customer"
										ng-model="gateIn.customer" name="customer"
										validation="required" friendly-name="customer"
										form-name="gateInForm" disabled="true"></selectivity>
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
										form-name="gateInForm" disabled="true"></selectivity>
                                 	</div>
                             </div>
							</fieldset>
					</div>
				</div>
				
				
				<div class="table-responsive clear" ng-if="gateIn.service=='COC'">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th colspan=1 class="width_1" ng-if="!isEdit">Select</th> -->
								 <th colspan=1 class="width_15 text-center" ng-if="!isEdit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_12 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Container No<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Seal No<span
									style="color: red;"></span></th>
									
								<th colspan=1 class="width_17 text-center">Gate IN Date<span
									style="color: red;">*</span></th>
									
								<th colspan=1 class="width_18 text-center">Previous Status Date<span
									style="color: red;"></span></th>
									
						     <th colspan=1 class="width_15 text-center">Load<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtl">
							<!-- 	<td ng-if="!isEdit"><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								-->
									 
									<td class="width_15" align = "center" ng-if="!isEdit">
									<div class="row">
						  	<input type="checkbox" data-ng-model="row.select" id="section" name="section{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(select)'}}" >
									</div>
								</td>
								<td> 
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerTypeList"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="gateInForm" disabled ="true" ></selectivity>

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
											     property="row.sealNo" id="sealNo{{trIndex}}"
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}" />
										</div>
									</div>
								</td>
								
								
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
										<!-- <div class="input-group  input-append date">
											<input type="text" class="form-control input-sm"
											     property="row.returnDate" id="returnDate{{trIndex}}"
												data-ng-model="row.returnDate" name="returnDate{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(returnDate)'}}" />
												<span
												class="input-group-addon add-on"><span
												form-name="gateInForm" class="glyphicon glyphicon-calendar"></span></span></div> -->
												
								<!-- 
												<ng-bs3-datetimepicker data-ng-model="row.returnDate"
												id="returnDate{{trIndex}}" name="returnDate{{trIndex}}"
												form-name="gateInForm"
												friendly-name="{{ 'Row' + $index + '(Return Date)'}}" /> -->
												
												<div class="input-group  input-append date">
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
												<!-- <span
												class="input-group-addon add-on"><span
												form-name="gateInForm" class="glyphicon glyphicon-calendar" disabled ="true"></span></span> --></div>
												<!-- 
												<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.previousStatusDate" ng-model="row.previousStatusDate" id="previousStatusDate{{trIndex}}" 
										name="previousStatusDate{{trIndex}}"    friendly-name="{{ 'Row' + $index + '(previousStatusDate)'}}"
										form-name="gateInForm"  />
										</div> -->
										
										</div>
									</div>
								</td>
								
								
								
									<td class="width_15" align = "center">
									<div class="row">
									
												
						      	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						     	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}"  disabled ="true">	
									</div>
								</td>
				
				
							</tr>
						</tbody>
					
					</table>
				<!-- 	<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
				
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<br> <br> <br>
				</div>
				
				<div class="table-responsive clear" ng-if="gateIn.service=='SOC'">
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
						     <th colspan=1 class="width_15 text-center">Load<span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtlsoc">
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
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.containerNo" name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}" />

										

										</div>
									</div>
								</td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}" />
										</div>
									</div>
								</td>
								
									<td class="width_15" align = "center">
									<div class="row">
									<!-- 	
									
											<input type="checkbox" class="form-control input-sm" 
												data-ng-model="row.emptyOrLoad" name="emptyOrLoad{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" /></label> -->
												
						  	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" >
										
									
									</div>
								</td>
				
							</tr>
						</tbody>
					
					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addRow1()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<!-- <button class="btn btn-sm btn-info" ng-click="addCredRow1()"
							style="display: none;" tooltip="ssssss Row" id="buttontemp"
							type="button">
							<i class="fa fa-plus"></i>
						</button> -->
						<button ng-click="removeRow1()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"  
								class="btn btn-success"
								ng-click="saveEmptyReturn(gateInForm,gateIn)">
								<i class="fa fa-save"></i> Save

							</button>
							
							<button class="btn btn-info" type="button"
								data-ng-click="reset(gateInForm)">
								<i class="fa fa-undo"></i> Reset
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



