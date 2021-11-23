<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
						
						<div class="form-group" ng-if="!edit">
								<label class="col-md-5 control-label">Gate Out No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="gateOutNo1"
									property="quotation.gateOutNo1" id="gateOutNo1"
									ng-model="quotation.gateOutNo1"
									friendly-name="gateOutNo1" disabled="true" />
								</div>
							</div>
							
							
							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label">Gate Out No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="gateoutno"
									property="quotation.gateoutno" id="gateoutno"
									ng-model="quotation.gateoutno"
									friendly-name="gateoutno" disabled="true" />
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Type<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="typeList" disabled="true" 
										property="quotation.type" id="type" name="type"
										ng-model="quotation.type" object="type"
										friendly-name="type" validation="required"
										form-name="quotationForm" value="true" disabled="edit"></selectivity>
								</div>
							</div>

							<!-- <div class="form-group" ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">C.R.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="croList"
										property="quotation.croNo" id="croNo" name="croNo"
										ng-model="quotation.croNo" object="croNo"
										friendly-name="croNo" validation="required"
										form-name="quotationForm" disabled="edit"></selectivity>
								</div>
							</div> -->
							<div class="form-group" ng-if="!edit">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<!-- <selectivity list="quotationnoList" ng-model="quotation.quotationno" disabled="isEdit"
											validation="required" friendly-name="quotationno"
											property="quotation.quotationno" id="quotationno" name="quotationno" 
											form-name="bookingForm"></selectivity> -->
											<selectivity list="modeList"
										property="quotation.mode" id="mode"
										name="mode" ng-model="quotation.mode"
										 friendly-name="Mode" 
										validation="required" form-name="quotationForm"
										></selectivity>
									</div>
								</div>
							<div class="form-group" ng-if="!edit" >
									<label class="col-md-5 control-label" >Carrier<span ng-if="quotation.mode==4"
										style="color: red;">*</span> </label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="quotation.carrier"
										 property="quotation.carrier" name="Carrier" 
										id="carrier" validation="required"
										friendly-name="Carrier"
										form-name="quotationForm"></selectivity>
								</div>
								</div>
								<!-- <div class="form-group" ng-if="quotation.mode!=4">
									<label class="col-md-5 control-label">Carrier </label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="quotation.carrier"
										 property="quotation.carrier"
										id="carrier" 
										friendly-name="Carrier"
										form-name="quotationForm"></selectivity>
								</div>
								</div> -->
						 
							
								
							

						</fieldset>
					</div>
						

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						<div class="form-group" ng-if="quotation.type=='Import'">
								<label class="col-md-5 control-label">D.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="doList"
										property="quotation.doNo" id="doNo" name="doNo"
										ng-model="quotation.doNo" object="croNo"
										friendly-name="doNo" validation="required"
										form-name="quotationForm" disabled="edit"></selectivity>
								</div>
							</div>
						<div class="form-group" ng-if="quotation.type=='Export' && !edit">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="bookNoList"
										property="quotation.bookingNo" id="bookingNo" name="bookingNo"
										ng-model="quotation.bookingNo" object="bookingNo"
										friendly-name="bookingNo" validation="required"
										form-name="quotationForm" disabled="edit"></selectivity>
								</div>
							</div>
							<div class="form-group" ng-if="quotation.type=='Export' && edit">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="bookingNo"
									property="quotation.bookingNo" id="bookingNo"
									ng-model="quotation.bookingNo"
									friendly-name="bookingNo" disabled="true" />
								</div>
							</div>
							
							<div class="form-group" ng-if="quotation.type=='Export' && !edit">
								<label class="col-md-5 control-label">C.R.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="croList"
										property="quotation.croNo" id="croNo" name="croNo"
										ng-model="quotation.croNo" object="croNo"
										friendly-name="croNo" validation="required"
										form-name="quotationForm" disabled="edit"></selectivity>
								</div>
								</div>
							<div class="form-group" ng-if="quotation.type=='Export' && edit">
								<label class="col-md-5 control-label">C.R.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="croNo"
									property="quotation.croNo" id="croNo"
									ng-model="quotation.croNo"
									friendly-name="croNo" disabled="true" />
								</div>
							</div>
						
							<div class="form-group " ng-if="!edit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerList"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="customer" validation="required"
										form-name="quotationForm"  disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group " ng-if="edit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerList1"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="customer" validation="required"
										form-name="quotationForm"  disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Depot<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="depotList"
										property="quotation.depot" id="depot{{trIndex}}"
										ng-model="quotation.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div>
							
							
							<!-- <div class="form-group">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="bookList"
										property="quotation.bookingNo" id="bookingNo{{trIndex}}"
										ng-model="quotation.bookingNo" validation="required"
										name="bookingNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(bookingNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div> -->
							
							
							
							<!-- <div class="form-group" ng-if="quotation.type=='Import'">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="bookingNo"
									property="quotation.bookingNo" id="bookingNo"
									ng-model="quotation.bookingNo"
									friendly-name="bookingNo" />
								</div>
							</div> -->
							
							






							<!-- 		<div class="form-group ">
								<label class="col-md-5 control-label">Cont.Drop Off Mode<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="dropoffList"
										property="quotation.dropoff" id="dropoff"
										name="dropoff" ng-model="quotation.dropoff"
										object="dropoff" friendly-name="dropoff"
										validation="required" form-name="quotationForm"></selectivity>
										
								</div>
								</div> -->



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<!-- third column -->
							
								<div class="form-group " ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">CRO Count<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="countTotal"
									property="quotation.countTotal" id="countTotal"
									ng-model="quotation.countTotal"
									friendly-name="countTotal" disabled="true" />
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Gate Out Date<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<input type="text" class="form-control input-sm"
												id="releaseDate" name="releaseDate" 
											ng-model="quotation.releaseDate" validation="required"  
												friendly-name="releaseDate" /> <span
												class="input-group-addon add-on"><span
												form-name="quotationForm" class="glyphicon glyphicon-calendar"></span></span>
												</div>
								<!-- <div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="quotation.releaseDate" id="releaseDate"
										name="releaseDate"  ng-model="quotation.releaseDate"  friendly-name="releaseDate"
										form-name="quotationForm"  />
										</div> -->
								</div>
							</div>
							<div class="form-group " ng-if="quotation.type=='Import'  && !edit">
								<label class="col-md-5 control-label">Discharge Date<span
									style="color: red"></span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<input type="text" class="form-control input-sm"
												id="disDate" name="disDate" 
											ng-model="quotation.disDate" disabled="true"   
												friendly-name="disDate" /> <span
												class="input-group-addon add-on"><span
												form-name="quotationForm" class="glyphicon glyphicon-calendar"></span></span>
												</div>
								<!-- <div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="quotation.releaseDate" id="releaseDate"
										name="releaseDate"  ng-model="quotation.releaseDate"  friendly-name="releaseDate"
										form-name="quotationForm"  />
										</div> -->
								</div>
							</div>
							<!-- <div class="form-group" >
								<label class="col-md-5 control-label">Truck No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text"
									class="form-control input-sm text-left" name="truckNo"
									property="quotation.truckNo" id="truckNo"
									ng-model="quotation.truckNo"
									friendly-name="truckNo"/>
								</div>
							</div> -->

							<div class="form-group" >
								<label class="col-md-5 control-label">Trip No</label>
								<div class="col-md-7">
									<selectivity list="tripNoList"
										property="quotation.truckNo" id="truckNo{{trIndex}}"
										ng-model="quotation.truckNo"
										name="truckNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(truckNo)'}}"
										form-name="quotationForm" ></selectivity>
								</div>
							</div> 


						</fieldset>
					</div>


				</div>
					<br>
				<div style="margin-left: 46%;">
				
				<button class="btn btn-success" type="button"
											ng-click="fetch(quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Fetch Detail
						</button>
			   </div>
			   <br>
				<div class="row">
						<div class="col-md-3">
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-md-5 control-label">Gate Out Date<span
										style="color: red;">*</span></label>
								<div class="col-md-7">
									<div class="input-group  input-append date">
									<ng-bs3-datepicker  	property="quotation.detailDate" id="detailDate"
									name="detailDate"  ng-model="quotation.detailDate"  friendly-name="Gate Out Date" 
									form-name="quotationForm"  />
									</div>
									</div>
								</div>
						</div>
						<div class="col-md-3">
							<button class="btn btn-info ng-scope"  type="button" 
								ng-click="apply(quotation.detailDate)">
								<i class="fa fa-exchange"></i> Apply
							</button>
					</div>
					</div>

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center" ng-if="!isEdit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
							<th colspan=1 class="width_9 text-center">Container Type<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Container No<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_9 text-center">Gate Out Date<span
								style="color: red;">*</span></th>
								<th colspan=1 class="width_9 text-center">Gate Out No<span
								style="color: red;">*</span></th>
								
							<th colspan=1 class=" width_9 text-center" ng-if="!edit">Previous Status Date<span
								style="color: red"></span></th>
								<!-- <th colspan=1 class=" width_9 text-center">Seal No</th> -->
							 <th colspan=1 class="width_9 text-center"></th>

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<td class=" width_1"></td>
								<td class="text-center"><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label>
								</td>
								<td class=" width_9"><selectivity list="conTypeList"
										property="row.conType" id="conType{{trIndex}}"
										ng-model="row.conType" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm" ></selectivity></td>
								<td class=" width_9"><selectivity list="conNoList"
										property="row.containerNo" id="containerNo{{trIndex}}"
										ng-model="row.containerNo" validation="required"
										name="containerNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity></td>
								<td class="width_9">
									<div class="row">
										<div class="col-xs-12">
												<div class="input-group  input-append date">
										<ng-bs3-datepicker  	property="row.gateOutDate" ng-model="row.gateOutDate" id="gateOutDate{{trIndex}}" 
										name="gateOutDate{{trIndex}}"    friendly-name="{{ 'Row' + $index + '(Gate Out Date)'}}"
										form-name="quotationForm"  />
										</div>
										
										</div>
									</div>
								</td>	
								<td class="width_9">
									<input type="text" class="form-control input-sm" id="gateoutnoE{{trIndex}}"
										name="gateoutnoE{{trIndex}}" 
										property="row.gateoutnoE"
										friendly-name="{{ 'Row' + ($index+1) + '(gateoutnoE)'}}" ng-model="row.gateoutnoE" disabled="true"  />
										
								</td>	
								
								<td class=" width_9" ng-if="!edit"><input type="text" class="form-control input-sm" id="previousStatusDate{{trIndex}}"
										name="previousStatusDate{{trIndex}}" 
										property="row.previousStatusDate"
										friendly-name="{{ 'Row' + ($index+1) + '(previousStatusDate)'}}" ng-model="row.previousStatusDate" disabled="true"  /></td>
											<!-- <td class=" width_9">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
											     property="row.sealNo" id="sealNo{{trIndex}}"
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}"  form-name="quotationForm"/>
										</div>
									</div>
								</td> -->
									
									
								<td class=" width_9"></td>
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

				<!-- 	<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button> -->
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>

               <br>  	
<div class="form-group" style="margin-left: 0%;" ng-if="!edit">
									<label class="col-md-5 control-label">Selected Container Count<span
										style="color: red;"></span>
									</label>
									<div class="col-md-2">
									<input type="text"
									class="form-control input-sm text-right" name="croCount"
									property="croCount" id="croCount"
									ng-model="croCount"
									friendly-name="croCount" disabled="true" />
										
									</div>
								</div>
				<!-- detail -->

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" ng-if="!edit" ng-disabled ="saveButtonDisble"
											ng-click="submit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save
										</button>
										<!-- <button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(quotationForm,quotation)">
											<i class="fa fa-save"></i> Update
										</button> -->
										<div class="btn btn-primary" ng-if="edit"  data-ng-click="excelexport(quotation.gateOutNo)">
				
				<span class="fa fa-file-excel-o"> Export to Excel</span>
</div>				
				<a id="gateOutExport" style="display:none"
							href="filePath/GateOut.xlsx" download="GateOut.xlsx"></a>
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Back
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
</div>
 <script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="fsorm-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary" name="excelfile1" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
            <a id="sampleDownload" stype="display:none" href="docs/CRO_Sample.xls" download="CRO_Sample.xls"></a>		
       </div>
	</div> 
</div>
<div class="modal-footer">
    <button class="btn btn-info" type="button" ng-click="DownloadSample()">Download Sample</button>
	<button class="btn btn-info" type="button" ng-click="uploadInvoice()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>

