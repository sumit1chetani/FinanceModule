
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<tabset justified="true" class="tab-container"> <tab
		heading="{{tabs[0].title}}">
		
		
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="servicePartnerForm" method="post" class="form-horizontal"
			novalidate>
			<div class="panel-body">
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Code <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.servicePartnerCode" maxlength=6
									data-ng-model="servicePartner.servicePartnerCode"
									name="ServicePartnerCode" validation="required"
									friendly-name="ServicePartnerCode" />

							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Name <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.servicePartnerName" maxlength=250
									data-ng-model="servicePartner.servicePartnerName"
									name="ServicePartnerName" validation="required"
									friendly-name="ServicePartnerName" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Branch <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="branchList" property="servicePartner.branch"
									data-ng-model="servicePartner.branch" name="branch"
									validation="required" form-name="servicePartnerForm"
									friendly-name="branch"> </selectivity>

							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Ledger Name <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.servicePartnerLedgerName" maxlength=255
									data-ng-model="servicePartner.servicePartnerLedgerName"
									name="Service Partner Ledger Name" validation="required"
									friendly-name="Service Partner Ledger Name" />
							</div>
						</div>
					</div>
                <div class="col-md-4">
									<label class="col-md-5 control-label"> Sales Person 
									</label>
									<div class="col-md-7">
										<selectivity list="serviceList" property="servicePartner.salesPerson"
											ng-model="servicePartner.salesPerson" name="salesPerson" 
											friendly-name="Sales Person" form-name="servicePartnerForm"></selectivity>
									</div>
								</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Credit Days Offered</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.creditDaysOffered"
									data-ng-model="servicePartner.creditDaysOffered"
									name="credit Days Offered" friendly-name="Credit Days Offered" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Active</label>
							<div class="col-md-7">
							
								<label class="i-checks m-b-none checkbox"> <input
									type="checkbox" property="servicePartner.active" name="Active"
									data-ng-model="servicePartner.active" friendly-name="Active"/><i></i>
								</label>
							
							
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Address</label>
							<div class="col-md-7">
								<textarea class="form-control input-sm"
									property="servicePartner.address" maxlength=255
									ng-model="servicePartner.address" name="Address"
									friendly-name="Address" rows="2"></textarea>


							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">City<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="cityList" property="servicePartner.city"
									data-ng-model="servicePartner.city" name="City"
									validation="required" form-name="servicePartnerForm"
									friendly-name="City"> </selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Region</label>
							<div class="col-md-7">
								<selectivity list="regionList" property="servicePartner.region"
									data-ng-model="servicePartner.region"
									name="servicePartner.region" form-name="servicePartnerForm"
									friendly-name="servicePartner.region"> </selectivity>

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4"></div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Country</label>
							<div class="col-md-7">
								<selectivity list="countryList"
									property="servicePartner.country"
									data-ng-model="servicePartner.country" name="Country"
									form-name="servicePartnerForm" friendly-name="Country">
								</selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">ZipCode</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.zipCode" maxlength=6
									data-ng-model="servicePartner.zipCode" name="ZipCode"
									friendly-name="ZipCode" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Person To Contact</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.personToContact" maxlength=250
									data-ng-model="servicePartner.personToContact"
									name="Person To Contact" friendly-name="Person To Contact" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Designation</label>
							<div class="col-md-7">

								<input type="text" class="form-control input-sm"
									property="servicePartner.designation" maxlength=250
									data-ng-model="servicePartner.designation" name="Designation"
									friendly-name="Designation" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Email ID</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.emailId" maxlength=50
									data-ng-model="servicePartner.emailId" name="Email"
									friendly-name="Email" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">LandLine No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.landLineNo" maxlength=15
									data-ng-model="servicePartner.landLineNo" name="LandLine No"
									friendly-name="LandLine No" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Mobile No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.mobileNo" maxlength=20
									data-ng-model="servicePartner.mobileNo" name="Mobile No"
									friendly-name="Mobile No" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Skype ID</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.skypeId" maxlength=50
									data-ng-model="servicePartner.skypeId" name="Skype ID"
									friendly-name="Skype ID" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">WebSite</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.webSite" maxlength=50
									data-ng-model="servicePartner.webSite" name="WebSite"
									friendly-name="WebSite" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Description</label>
							<div class="col-md-7">
								<textarea class="form-control input-sm"
									property="servicePartner.servicePartnerDescription" maxlength=250
									ng-model="servicePartner.servicePartnerDescription"
									name="Service Partner
								Description"
									friendly-name="Service Partner
								Description" rows="2"></textarea>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">PAN No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.pANNo" maxlength=50
									data-ng-model="servicePartner.pANNo" name="PAN No"
									friendly-name="PAN No" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Default Type<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="defaultTypeList"
									property="servicePartner.defaultType"
									data-ng-model="servicePartner.defaultType"
									validation="required" name="Default Type"
									form-name="servicePartnerForm" friendly-name="Default Type">
								</selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Partner
								Classification</label>
							<div class="col-md-7">
								<selectivity list="classificationList"
									property="servicePartner.partnerClassification"
									data-ng-model="servicePartner.partnerClassification"
									name="partnerClassification" form-name="servicePartnerForm"
									"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">GSTN State Code<span style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="gstnStateList"
									property="servicePartner.gSTNStateCode"
									data-ng-model="servicePartner.gSTNStateCode"validation="required"
									
									name="GSTN State Code" form-name="servicePartnerForm"
									friendly-name="GSTN State Code"> </selectivity>

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">



					<div class="col-md-4">
						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-5"
								style=""width:100%;">Vendor </label>
							<div class="col-md-7" ng-if="!isEdit">
								<selectivity list="vendorList"
									property="servicePartner.vendorCode" id="vendorCode"></selectivity>
							</div>
							<div class="col-md-7" ng-if="isEdit">
								<selectivity list="vendorList"
									property="servicePartner.vendorName" id="vendorName"></selectivity>
							</div>
						</div>


					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Exemption Under</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.exemptionUnder" maxlength=250
									data-ng-model="servicePartner.exemptionUnder"
									name="Exemption Under" friendly-name="Exemption Under" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">GSTN No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.gSTNNo" maxlength=15
									data-ng-model="servicePartner.gSTNNo" name="GSTN No"
									friendly-name="GSTN No" />
							</div>
						</div>
					</div>
			<div>	
			</div>	 
        
        </div>


				<div class="row pl2pc pr10pc">



					<div class="col-md-4">
						<div class="form-group">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">Nature
									
								</label>
								<div class="col-md-7">
									<selectivity list="tdrNatureList"
										property="servicePartner.tdsNatureCode" id="tdsNatureCode"></selectivity>
								</div>
							</div>
						</div>


					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">Type
								
							</label>
							<div class="col-md-7">
								<select class="form-control input-sm" name="tdsNatureType"
									ng-model="servicePartner.tdsNatureType">
									<option value="" selected="selected">Select</option>
									<option value="C">Company</option>
									<option value="I">Individual</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="inputPassword" class="control-label col-md-5">Description
							</label>
							<div class="col-md-7">
								<textarea ng-model="servicePartner.description" name="description"
									class="custom-scroll width_100" rows="2">
           </textarea>
							</div>
						</div>
					</div>
					<div></div>

				</div>

				<div>
         
			</div>		
					
					
			

			<div data-role="content" class="form-horizontal panel"
				data-collapse="isCollapsed">
				<ul class="dragList row list-unstyled">
					<li data-ng-repeat="column in servicePartnerType"
						class="col-md-4 col-sm-4 col-lg-4">
						<div class="row">
							<label class="control-label col-md-8" style="width: 61%">{{column.title}}
							</label>
							<div class="col-md-4">
								<label class="i-checks m-b-none checkbox"> <input
									type="checkbox" hidden="column.id"
									data-ng-model="column.visible" /><i></i>
								</label>
							</div>

						</div>


					</li>

				</ul>
			</div>




			<div class="table-responsive">
				<table class="table table-striped b-t b-light">
					<thead>
						<tr>
						<th class="sorting width_1">Select</th>
							<th class="sorting width_2">Contact Name</th>
							<th class="sorting width_3">Designation</th>
							<th class="sorting width_3">Email</th>

							<th class="sorting width_2 text-center table-heading">Landline
								No</th>

							<th class="sorting width_2 text-center table-heading">Skype
							</th>
							<th class="sorting width_2 text-center table-heading">City</th>
							<th class="sorting width_2 text-center table-heading">Remarks
							</th>


						</tr>
					</thead>

					<tbody ng-repeat="($index,row) in servicePartnerTable">
						<tr>
							<td><label class="i-checks m-b-none"> <input
								
									type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
							
							<td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=250
											data-ng-model="row.contactName" name="ContactName{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" />
									</div>
								</div>
							</td>


							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=250
											data-ng-model="row.keyDesignation" name="Designation{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=50
											data-ng-model="row.keyLandLineNo" name="LandLineNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=50
											data-ng-model="row.keyMobileNo" name="MobileNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=50
											data-ng-model="row.keySkypeId" name="Skype{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Skype)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<selectivity list="cityList" property="row.keyCityId"
									data-ng-model="row.keyCityId"name="city{{trIndex}}"
									 form-name="servicePartnerForm"
									friendly-name="{{ 'Row' + $index + '(city)'}}" > </selectivity>
										
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=500
											data-ng-model="row.remarks" name="remarks{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(remarks)'}}" />
									</div>
								</div>
							</td>

						</tr>
					</tbody>

				</table>
				<div class="padding-right-5" id="AddOrRmvebtn">
					<button ng-click="addCredRow()" class="btn btn-sm btn-info"
						tooltip="Add Row" ng-disabled="" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
						type="button" tooltip="Delete">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>

<div class="panel-body float-left padding-0" ng-if="isEdit" style="width: 100%;">
				
					<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Sales Person</a>
						</div>
					</header>
				
			</div>
			
	
<table class="table table-striped b-t b-light" ng-if="isEdit">
					<thead>
						<tr>
							

							<!-- <th class="sorting width_6">Customer Id </th> -->
							<th class="sorting width_3">Sales Person Employee </span></th>
							<th class="sorting width_4">From Date </span></th>
							<th class="sorting width_3 text-center table-heading">To Date</th>
                       </tr>
					</thead>

					<tbody ng-repeat="($index,row) in salesTable">
						<tr>
							
							<!-- <td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text"  class="form-control input-sm"
											data-ng-model="row.servicePartnerId" disable=true name="servicePartnerId{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(customerID)'}}" disabled/>
									</div>
								</div>
							</td> -->

                          
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<!-- <selectivity list="serviceList"
											data-ng-model="row.salesPersonEmp" name="salesPersonEmp{{trIndex}}" 
											friendly-name="{{ 'Row' + $index + '(salesPersonEmp)'}} form-name="servicePartnerForm"></selectivity> -->
											<input type="text"  class="form-control input-sm" name="salesPerson{{trIndex}}"
											data-ng-model="row.salesPerson" disabled  />
										
									</div>
								</div>
							</td>
							
							
							 <td class="width_10">
								<div class="row">
									<div class="col-xs-10">
										
											<ng-bs3-datepicker
											data-ng-model="row.createdDate" name="ToDate{{trIndex}}"
											form-name="servicePartnerForm"
											friendly-name="{{ 'Row' + $index + '(ToDate)'}}" disabled/>
											
									</div>
								</div>
							</td> 
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="row.toDate" name="ToDate{{trIndex}}"
											form-name="servicePartnerForm"
											friendly-name="{{ 'Row' + $index + '(ToDate)'}}" disabled />
									</div>
								</div>
							</td>
					
						</tr>
					</tbody>
	          
				</table>
				<br /> <br />
	                     <div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							

							
							
							
							

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</div>

		</form>
		
		
		</tab>
		<!-- kyc -->
       	
		 <tab heading="{{tabs[1].title}}" active="tabs[1].active">
	<div class="panel-body" ng-hide="isShow">
		<form class="form-horizontal ng-pristine ng-pending" method="POST"
			name="CustCommForm" method="post" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">


							<div class="form-group">
								<label class="col-md-4 control-label"> Managing Director
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="subject"
										id="subject" ng-model="customComm.subject" maxlength="50">
								</div>
							</div>
							<!--  <div class="form-group">
        <label class="col-md-4 control-label">
         Turn Over
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" ng-model="customComm.referral" name="referral" message-id="referral" id="referral"
          typeahead="r.text as r.text for r in referralList| filter:$viewValue |limitTo:10" typeahead-min-length='1' maxlength="50" />
          <input type="text" class="form-control input-sm"  ng-model="customComm.referral" name="referral" message-id="referral"
	          id="referral"   validator="required"   valid-method="submit"/>
        </div>
       </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person"
										ng-model="customComm.bookingCntctPrsn" id="bookingCntctPrsn"
										maxlength="100"">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person"
										ng-model="customComm.pricingCntctPrsn" id="pricingCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person"
										ng-model="customComm.operationsCntctPrsn" maxlength="100"
										id="operationsCntctPrsn">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person"
										ng-model="customComm.financeCntctPrsn" id="financeCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Tel Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Tel Number" ng-model="customComm.teleNumber"
										id="teleNumber" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">
							<div class="form-group">
								<label class="col-md-4 control-label">Turn Over </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-model="customComm.assignedTo" name="assignedTo"
										id="assignedTo" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person Email"
										ng-model="customComm.bookingCntctPrsnEmail" maxlength="500"
										id="bookingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person Email"
										ng-model="customComm.pricingCntctPrsnEmail" maxlength="500"
										id="pricingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person Email" maxlength="500"
										ng-model="customComm.operationsCntctPrsnEmail">
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person Email"
										ng-model="customComm.financeCntctPrsnEmail" maxlength="500"
										id="financeCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Fax Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Fax No"
										id="faxNum" ng-model="customComm.faxNum" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
		</form>
		<div class="form-actions" ng-show="!isShow"
			ng-hide="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					
					<button class="btn btn-danger" type="reset" class="btn btn-success"
						ng-click="cancelCustomDetail()">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
		<div class="form-actions" ng-show="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-danger" type="button"
						ng-click="cancelCustomDetail()" class="btn btn-success">
						<i class="fa fa-arrow-left"></i> Back To Lists
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-body" ng-hide="!isShow">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<fieldset>
					<div class="wrapper-md">
						<div class="panel panel-default">
							<section widget-grid id="widget-grid">
								<div class="row ">
									<article class="col-sm-12">
										<div>
											<div class="" st-table="displayedCollectionFollowup"
												st-safe-src="rowCollectionFollowup">
												<div class="widget-body no-padding ">
													<div class=" " style="min-width: 100%; overflow-x: scroll;">
														<table
															class="table table-striped b-t b-light table-hover dataTable no-footer">
															<thead class="dataTables-Main-Head">
																<tr>

																	<th class="width_5 text-center">Managing Director</th>
																	<th class="width_5 text-center">Turn Over</th>
																	<th class="width_5 text-center">Booking Contact
																		Person</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person</th>
																	<th class="width_20 text-center">Operations
																		Contact Person</th>
																	<th class="width_20 text-center">Finance Contact
																		Person</th>
																	<th class="width_20 text-center">Tel Number</th>
																	<th class="width_5 text-center">Booking Contact
																		Person Email</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person Email</th>
																	<th class="width_20 text-center">Operations
																		Contact Person Email</th>
																	<th class="width_20 text-center">Finance Contact
																		Person Email</th>
																	<th class="width_20 text-center">Fax Num</th>
																	<th class="text-center  width_5">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-repeat="customComm in displayedCollectionFollowup track by $index">

																	<td class="width_20 text-center">{{customComm.subject}}</td>
																	<td class="width_20 text-center">{{customComm.assignedTo}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.teleNumber}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.faxNum}}</td>

																	<td class="td-actions text-center width_5">
																		<div ng-hide="customComm.isLead == 'true'">
																			<span> <i
																				class="fa  fa-pencil text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span> <span> <i
																				class="fa fa-trash-o text-danger-dker text"
																				data-ng-click="deleteFollow(customComm.customId,customComm.customCommId)"></i>
																			</span>
																		</div>
																		<div ng-show="customComm.isLead == 'true'">
																			<span> <i class="fa fa-eye text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span>
																		</div>
																	</td>
																</tr>
															</tbody>
														</table>
														
													</div>
													<table class="odd table-hover ">
															<tfoot>
																<tr>
																	<td class="width_100">
																		<button data-ng-click="addFollowUpRow()"
																			class="btn btn-primary" type="button">
																			<i class="fa fa-plus"></i> Add FollowUp
																		</button>
																	</td>
																</tr>
															</tfoot>
														</table>
												</div>
											</div>
										</div>
									</article>
								</div>
							</section>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	<div class="form-actions" ng-show="isShow">
		<div class="row">
			<div class="col-md-12">
				<button ng-model="add" class="btn btn-danger" type="button"
					ng-click="cancel()" class="btn btn-success">
					<i class="fa fa-arrow-left"></i> Back To Lists
				</button>
			</div>
		</div>
	</div>
	</tab>
	
		</tabset>
		
	</div>

		
	</div>

