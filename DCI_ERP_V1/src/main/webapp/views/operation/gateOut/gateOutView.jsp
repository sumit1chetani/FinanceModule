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
								<label class="col-md-5 control-label">Gate Out No</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.gateoutno}}
								</label>
								
								</div>
							</div>
							
							
							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label">Gate Out No</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.gateoutno}}
								</label>
								
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Type</label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.type}}
								</label>
								
								</div>
							</div>

							<div class="form-group" ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">C.R.O. No</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.croNo}}
								</label>
							
								</div>
							</div>
							
								<div class="form-group" ng-if="quotation.type=='Import'">
								<label class="col-md-5 control-label">D.O. No</label>
								<div class="col-md-7">
										<label class="control-label" align="left" >{{quotation.doNo}}
								</label>
							
								</div>
							</div>
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Created By</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.createdBy}}
								</label>
							
								</div>
							</div>

<div class="form-group ">
								<label class="col-md-5 control-label">Modified Date</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.modifiedOn}}
								</label>
							
								</div>
							</div>

						</fieldset>
					</div>
						

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.customername}}
								</label>
							
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Depot</label>
								<div class="col-md-7">
										<label class="control-label" align="left" >{{quotation.depotName}}
								</label>
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Booking No</label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.bookingNo}}
								</label>
								<!-- 	<selectivity list="bookList"
										property="quotation.bookingNo" id="bookingNo{{trIndex}}"
										ng-model="quotation.bookingNo" validation="required"
										name="bookingNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(bookingNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
								</div>
							</div>
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

<div class="form-group ">
								<label class="col-md-5 control-label">Created Date</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.createdOn}}
								</label>
							
								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<!-- third column -->
							
								<div class="form-group " ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">CRO Count<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.countTotal}}
								</label>
							<!-- 		<input type="text"
									class="form-control input-sm text-left" name="countTotal"
									property="quotation.countTotal" id="countTotal"
									ng-model="quotation.countTotal"
									friendly-name="countTotal"  disabled="true"/> -->
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Gate Out Date</label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<label class="control-label" align="left" >{{quotation.releaseDate}}
								</label>
									
										</div>
									<!-- <ng-bs3-datepicker
										data-ng-model="quotation.releaseDate" id="releaseDate" name="releaseDate"
										property="quotation.releaseDate"
										friendly-name="{{ 'Row' + ($index+1) + '(releaseDate)'}}"  /> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Truck No</label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.truckNo}}
								</label>
									<!-- <input type="text"
									class="form-control input-sm text-left" name="truckNo"
									property="quotation.truckNo" id="truckNo"
									ng-model="quotation.truckNo"
									friendly-name="truckNo" disabled="true"/> -->
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-5 control-label">Modified By</label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.modifiedBy}}
								</label>
							
								</div>
							</div>


						</fieldset>
					</div>


				</div>
					<br>
				<!-- <div style="margin-left: 46%;">
				
				<button class="btn btn-success" type="button"
											ng-click="fetch(quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Fetch Detail
						</button>
			   </div> -->

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Container Type</th>
							<th colspan=1 class=" width_9 text-center">Container No</th>
							<th colspan=1 class="width_9 text-center">Gate Out Date</th>
								<!-- <th colspan=1 class=" width_9 text-center">Seal No</th> -->
							 <th colspan=1 class="width_9 text-center"></th>

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}" disabled="true">
										<i></i>
								</label></td>
							  <td style="text-align:center">{{row.conType}}</td>
								
				 <!--  <td style="text-align:center">{{row.containerNo}}</td> -->
				  
				   
						 	 <td class=" width_9"><selectivity list="conNoList"
										property="row.containerNo" id="containerNo{{trIndex}}"
										ng-model="row.containerNo" validation="required"
										name="containerNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity></td>
							  <td style="text-align:center">{{row.gateOutDate}}</td> 
								<!--<td class="width_9">
									<div class="row">
										<div class="col-xs-12">
												<div class="input-group  input-append date">
							 					 <td style="text-align:center">{{row.conType}}</td>
												<input	type="text" ng-model="row.gateOutDate" id="section{{trIndex}}" disabled="true">
										<bootstrapdatetimepicker   disabled readonly property="row.gateOutDate" ng-model="row.gateOutDate" id="gateOutDate{{trIndex}}" 
										name="gateOutDate{{trIndex}}"    friendly-name="{{ 'Row' + $index + '(Gate Out Date)'}}"
										form-name="quotationForm"  />
										</div>
										
										</div>
									</div>
								</td> -->
										
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
				<!-- 	<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>

                 	

				<!-- detail -->

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<!-- <button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="submit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save
										</button> -->
										<!-- <button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(quotationForm,quotation)">
											<i class="fa fa-save"></i> Update
										</button> -->
										<!-- <div class="btn btn-primary" ng-if="edit"  data-ng-click="excelexport(quotation.gateOutNo)">
				
				<span class="fa fa-file-excel-o"> Export to Excel</span>
</div>				 -->
			<!-- 	<a id="gateOutExport" style="display:none"
							href="filePath/GateOut.xlsx" download="GateOut.xlsx"></a> -->
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

