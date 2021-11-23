<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}
</style>
<style>
 

  label.col-md-5.control-label {
    font-weight: bold;
}

 
 marquee{
      font-size: 20px;
      font-weight: 200;
      color: #ec0b0b;
      font-family: sans-serif;
      }
</style>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		
		<!-- split booking -->
		<form name="bookingtool" class="form-horizontal" novalidate>
		
		<div class="row">&nbsp;&nbsp; &nbsp;&nbsp;<marquee> NOTE: The Booking Tool option is used for Split or Merge the Booking using Booking Number.</marquee> </div>
		<tabset justified="true" class="tab-container"> 
		
		<tab heading="Split">
			<div class="panel-body" >
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
						
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<!-- <label class="col-md-15 control-label text-left">{{bookingData.mode}}</label> -->
										<selectivity list="modeList"
										property="bookingData.mode" id="mode"
										name="mode" ng-model="bookingData.mode"
										 friendly-name="Mode"  disabled
										validation="required" form-name="bookingForm"
										></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-7">
								<div class="form-group">
								
								 
									<label class="col-md-3 control-label" style="font-weight: bold;">Booking No.</label>
									<div class="col-md-4">
									
									<selectivity list="bookingNoList" ng-model="bookingTool.bookingNo"
										 friendly-name="bookingNo"
											property="bookingTool.bookingNo" id="bookingNo" name="bookingNo"  
											form-name="bookingtoolForm"></selectivity>
										<!-- <input class="form-control" type="text" form-name="bookingtoolForm"
											validation="required" friendly-name="Booking No"
											name="bookingNo" id="bookingNo"
											ng-model="bookingTool.bookingNo" placeholder="Booking No"> -->
									</div>
									<div class="col-md-3">
										<button ng-click="searchBooking(bookingTool.bookingNo)"
											class="btn btn-success" tooltip="Add Row" type="button">
											<i class="fa fa-search"></i>Search
										</button>
									</div>

								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12">
						<hr>
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Booking Date </label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{bookingData.bookingDate}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{bookingData.vessel}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage</span>
									</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{bookingData.voyage}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;"></span></label>

									<div class="col-md-7">
										<label class="col-md-13 control-label">{{bookingData.pol}}</label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POT/POD<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{bookingData.pod}}</label>
									</div>
								 
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Final Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{bookingData.destination}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>
					

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Customer 
									</label>

									<div class="col-md-7">
										<label class="col-md-15 control-label">{{bookingData.customer}}-{{bookingData.customerName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>

									<div class="col-md-7">
										<label class="col-md-15 control-label">{{bookingData.quotation}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Quotation
										Validity Date </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{bookingData.quotationDate}}</label>


									</div>
								</div>
							</div>
						</fieldset>
					</div>
					

					<div class="col-sm-12">
						<fieldset>
						

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Shipper </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{bookingData.shipperName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{bookingData.consigneeName}}</label>

									</div>
								</div>
							</div>
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{bookingData.frightTerms}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Notify Party </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{bookingData.notifyName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{bookingData.bookingtypeview}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{bookingData.bookremarks}}</label>

									</div>
								</div>
							</div>
							
						</fieldset>
					</div>

					
				</div>

<br> <br> <br> 
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
 							    <th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_10 text-center">No. Of Containers</th>
								<th colspan=1 class="width_10 text-center">Commodity</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in bookingData.boxData track by trIndex">
							<tr>
								 
								<td style="text-align: center">{{row1.cntrType}}</td>
								<td style="text-align: center">{{row1.noOfBox}}</td>
								<td style="text-align: center">{{row1.commodityName}}</td>
								
							</tr>
						</tbody>
					</table>
				</div>


			
			<tabset justified="true" class="tab-container"
							style="width: 98%;margin-left:  1%;margin-top:  4%;">
			   <tab heading="Container Details" style="background:#5da5d4;font-weight: bold;">
						<div class="panel-body">
							<div class="table-responsive"  >
 										<table class="table table-striped b-t b-light">
											<thead>
												<tr>
													<th	colspan=1 class="width_2">Select</th>
													<th colspan=1 class="width_5 text-center">Container No.</th>
													<th colspan=1 class="width_5 text-center">Type</th>
													<th colspan=1 class="width_7 text-center">CRO No.</th>
													<th colspan=1 class="width_5 text-center">Gate Out No.</th>
													<!-- <th colspan=1 class="width_5 text-center">Job No.</th> -->
												 
												</tr>
											</thead>
											<tbody
												ng-repeat="(trIndex, blcntrDtl) in bookingData.containerDtlList">
												<tr>
													<td><label
														class="i-checks m-b-none"> <input type="checkbox" 	ng-model="blcntrDtl.select"><i></i></label></td>
													<td class="text-center">{{blcntrDtl.containerNumber}}</td>
													<td class="text-center">{{blcntrDtl.type}}</td>
													<td class="text-center">{{blcntrDtl.croNo}}</td>
													<td class="text-center">{{blcntrDtl.gateOutNo}}</td>
													<!-- <td class="text-center">{{blcntrDtl.jobNo}}</td> -->
												 
												</tr>
												
											</tbody>
										</table>
										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									 
									<br>



								 
							</div>
						</div>
						</tab> </tabset>
		 
			 </div>
 				<div class="panel-body float-left padding-10" style="width: 100%;padding-left: 42%;padding-right: 42%;" ng-if="tempShow">
			 <div class="table-responsive" >
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
                             <th> The Split Booking Details:</th>

							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collec in tempList">
							<td>{{collec}}</td>
						</tr>
                     </tbody>
				</table>
			
		</div>		
</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"   
							ng-click="save(bookingtool)">
							<i class="fa fa-save"></i> Split
						</button>
					 
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
			<br><br><br>
		
		</tab>
		
		
		<!-- merge booking -->
		
		<tab heading="Merge">
			<div class="panel-body" >
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
						
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label" style="font-weight: bold;color: blue;">Mode<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<!-- <label class="col-md-15 control-label text-left">{{fromBookingData.mode}}</label> -->
										<selectivity list="modeList"
										property="fromBookingData.mode" id="mode"
										name="mode" ng-model="fromBookingData.mode"
										 friendly-name="Mode"  disabled="disabled"
										validation="required" form-name="bookingForm"
										></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-7">
								<div class="form-group">
								
									<label class="col-md-3 control-label" style="font-weight: bold;color: blue;">From Booking No.</label>
									<div class="col-md-4">
									
									<selectivity list="fromBookingNoList" ng-model="fromBookingData.bookingNo"
										 friendly-name="fromBookingNo"
											property="fromBookingData.bookingNo" id="bookingNo" name="bookingNo"  
											form-name="bookingtoolForm"></selectivity>
									</div>

								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12">
						<hr>
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Booking Date </label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{fromBookingData.bookingDate}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{fromBookingData.vessel}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage</span>
									</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{fromBookingData.voyage}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;"></span></label>

									<div class="col-md-7">
										<label class="col-md-13 control-label">{{fromBookingData.pol}}</label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POT/POD<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{fromBookingData.pod}}</label>
									</div>
								 
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Final Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{fromBookingData.destination}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>
					

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Customer 
									</label>

									<div class="col-md-7">
										<label class="col-md-15 control-label">{{fromBookingData.customer}}-{{fromBookingData.customerName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>

									<div class="col-md-7">
										<label class="col-md-15 control-label">{{fromBookingData.quotation}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Quotation
										Validity Date </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{fromBookingData.quotationDate}}</label>


									</div>
								</div>
							</div>
						</fieldset>
					</div>
					

					<div class="col-sm-12">
						<fieldset>
						

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Shipper </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{fromBookingData.shipperName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{fromBookingData.consigneeName}}</label>

									</div>
								</div>
							</div>
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{fromBookingData.frightTerms}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Notify Party </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{fromBookingData.notifyName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{fromBookingData.bookingtypeview}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{fromBookingData.bookremarks}}</label>

									</div>
								</div>
							</div>
							
							
						</fieldset>
					</div>

					
				</div>
				
				<br> <br> 
				
				<!-- To booking Detail -->
				
				<div class="row book-widget-row">
					<div class="col-sm-12">
					<hr>
						<fieldset>
							<div class="col-md-7">
								<div class="form-group">
								
								 
									<label class="col-md-3 control-label" style="font-weight: bold;color: blue;">To Booking No.</label>
									<div class="col-md-4">
									
									<selectivity list="toBookingNoList" ng-model="toBookingData.bookingNo"
										 friendly-name="bookingNo"
											property="toBookingData.bookingNo" id="bookingNo" name="bookingNo"  
											form-name="bookingtoolForm"></selectivity>
										<!-- <input class="form-control" type="text" form-name="bookingtoolForm"
											validation="required" friendly-name="Booking No"
											name="bookingNo" id="bookingNo"
											ng-model="bookingTool.bookingNo" placeholder="Booking No"> -->
									</div>
									<!-- <div class="col-md-3">
										<button ng-click="searchBooking(bookingTool.bookingNo)"
											class="btn btn-success" tooltip="Add Row" type="button">
											<i class="fa fa-search"></i>Search
										</button>
									</div> -->

								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12">
					<hr>
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Booking Date </label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{toBookingData.bookingDate}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{toBookingData.vessel}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage</span>
									</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{toBookingData.voyage}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;"></span></label>

									<div class="col-md-7">
										<label class="col-md-13 control-label">{{toBookingData.pol}}</label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POT/POD<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{toBookingData.pod}}</label>
									</div>
								 
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Final Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<label class="col-md-13 control-label">{{toBookingData.destination}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>
					

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Customer 
									</label>

									<div class="col-md-7">
										<label class="col-md-15 control-label">{{toBookingData.customer}}-{{toBookingData.customerName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>

									<div class="col-md-7">
										<label class="col-md-15 control-label">{{toBookingData.quotation}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Quotation
										Validity Date </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{toBookingData.quotationDate}}</label>


									</div>
								</div>
							</div>
						</fieldset>
					</div>
					

					<div class="col-sm-12">
						<fieldset>
						

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Shipper </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{toBookingData.shipperName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label">{{toBookingData.consigneeName}}</label>

									</div>
								</div>
							</div>
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{toBookingData.frightTerms}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Notify Party </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{toBookingData.notifyName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{toBookingData.bookingtypeview}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
										<label class="col-md-15 control-label text-left">{{toBookingData.bookremarks}}</label>

									</div>
								</div>
							</div>
						
						</fieldset>
					</div>

					
				</div>
				
				<!-- end To booing details -->

<br> <br> <br> 
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
 							    <th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_10 text-center">No. Of Containers</th>
								<th colspan=1 class="width_10 text-center">Commodity</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in fromBookingData.boxData track by trIndex">
							<tr>
								 
								<td style="text-align: center">{{row1.cntrType}}</td>
								<td style="text-align: center">{{row1.noOfBox}}</td>
								<td style="text-align: center">{{row1.commodityName}}</td>
								
							</tr>
						</tbody>
					</table>
				</div>


			
			<tabset justified="true" class="tab-container"
							style="width: 98%;margin-left:  1%;margin-top:  4%;">
			   <tab heading="Container Details" style="background:#5da5d4;font-weight: bold;">
						<div class="panel-body">
							<div class="table-responsive"  >
 										<table class="table table-striped b-t b-light">
											<thead>
												<tr>
													<th	colspan=1 class="width_2">Select</th>
													<th colspan=1 class="width_5 text-center">Container No.</th>
													<th colspan=1 class="width_5 text-center">Type</th>
													<th colspan=1 class="width_7 text-center">CRO No.</th>
													<th colspan=1 class="width_5 text-center">Gate Out No.</th>
													<!-- <th colspan=1 class="width_5 text-center">Job No.</th> -->
												 
												</tr>
											</thead>
											<tbody
												ng-repeat="(trIndex, blcntrDtl) in fromBookingData.containerDtlList">
												<tr>
													<td><label
														class="i-checks m-b-none"> <input type="checkbox" 	ng-model="blcntrDtl.select"><i></i></label></td>
													<td class="text-center">{{blcntrDtl.containerNumber}}</td>
													<td class="text-center">{{blcntrDtl.type}}</td>
													<td class="text-center">{{blcntrDtl.croNo}}</td>
													<td class="text-center">{{blcntrDtl.gateOutNo}}</td>
													<!-- <td class="text-center">{{blcntrDtl.jobNo}}</td> -->
												 
												</tr>
												
											</tbody>
										</table>
										<div class="padding-right-5">
											<div class="col-md-4"></div>
										</div>
									 
									<br>



								 
							</div>
						</div>
						</tab> </tabset>
		 
			 </div>
 				
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"   
							ng-click="merge(bookingtool)">
							<i class="fa fa-save"></i> Merge
						</button>
					 
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
			<br><br><br>
	
		</tab>
		
		 </tabset>
		
			</form>
		
	</div>
</div>
