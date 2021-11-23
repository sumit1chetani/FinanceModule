<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
			<form class="form-horizontal" name="agencyTariffAddForm" role="form" >
				<fieldset ng-disabled="isViewDisable">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group">
								<label class="col-md-6 control-label"> Name of the Agent
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" ng-model="AgencyTariffData.agentId">
        							<!--  <selectivity  list="agentNameList" property="AgencyTariffData.agentId" id="agentId" object="Temp" disabled></selectivity> -->
        						</div>
								</div>
								<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Service
									<span style="color: red;">*</span>
								</label>
		
								<div class="col-md-5">
									<selectivity  list="serviceList" property="AgencyTariffData.service" id="service"></selectivity>
								</div>
								</div> -->
								<div class="form-group">
								<label class="col-md-6 control-label"> PORT
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<!-- <div class="form-group">
										 <select id="txtPOL"  multiple="multiple"  name="multiselect[]" ng-model="AgencyTariffData.pols" 
											 ng-options="master.id as master.text for master in polList" data-dropdownmultiselect>    
							 				  <option data-ng-repeat="master in polList" value="{{getOptionId(master)}}" ng-selected="isOptionSelected(master)" data-ng-bind-template="{{master.pol}}"></option>
										</select>
								</div> -->
                               <input type="text" class="form-control input-sm" ng-model="AgencyTariffData.pol">
									<!-- <selectivity  list="polList" property="AgencyTariffData.pol" id="pol"></selectivity> -->
								</div>
							</div>
								<div class="form-group">
								<label class="col-md-6 control-label"> Managing Office / Principal
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<input type="text" class="form-control input-sm" ng-model="AgencyTariffData.principal">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Agreement Period
								</label>
								<div class="col-md-5 line-height-30">
									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agreePeriod" value="d"
							           	  id="definite" name="Agreement Definite"  ng-click="viewAgreementType()"  />
							             <i></i>
							             Definite
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agreePeriod" value="i"
							           	   id="indefinite" name="Agreement InDefinite" ng-click=viewAgreementType() />
							             <i></i>
							             	Indefinite
							          </label>
        									</div>
								</div>
							</div>
							<div class="form-group" id="todate" style="display: none;">
								<label class="col-md-6 control-label"> To Date
								</label>
								 <div class="col-md-5">
										<input type="text" class="form-control input-sm" ng-model="AgencyTariffData.toDate">
        					   </div>
							</div>
							
							 <div class="form-group">
								<label class="col-md-6 control-label">Notice Period
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<div class="col-sm-5">
										<input type="text" class="form-control input-sm" name="Notice Period" ng-model="AgencyTariffData.noticePeriod" validator="required"
          									valid-method="submit" message-id="noticePeriod" >
									</div>
									<div class="col-md-7">
										<select class="form-control input-sm" name="Notice Period Type" ng-model="AgencyTariffData.noticePeriodType"
											 message-id="noticePeriodType">
											<option value="" selected="selected">--Select--</option>
											<option value="D">Days</option>
											<option value="M">Months</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-6 col-lg-6">
							<div class="form-group">
								<div class="col-md-4 control-label">
								<br>
								<label > Agents location / Address
									<span style="color: red;">*</span>
								</label>
								</div>
								<div class="col-md-5">
									<textarea ng-model="AgencyTariffData.agentAddress" name="Agent Address" class="custom-scroll width_100" rows="3" style="resize:none">
         							</textarea>
								</div>
							</div>
						<!-- 	<div class="form-group">
								<label class="col-md-4 control-label"> Voyage
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity  list="voyageList" property="AgencyTariffData.voyage" id="voyage"></selectivity>
								</div>
								</div> -->
								<div class="form-group">
								<label class="col-md-4 control-label"> Currency
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" ng-model="AgencyTariffData.currency">
								</div>
							</div>
							<div class="form-group" id="fromdate" style="display: none;">
								<label class="col-md-4 control-label"> From Date
									<span style="color: red;">*</span>
								</label>
								 <div class="col-md-5">
									<input type="text" class="form-control input-sm" ng-model="AgencyTariffData.fromDate">
        					   </div>
							</div>
							<div class="form-group" id="effectivedate" style="display: none;">
								<label class="col-md-4 control-label"> Effective Date
									<span style="color: red;">*</span>
								</label>
							   <div class="col-md-5">
							   <input type="text" class="form-control input-sm" ng-model="AgencyTariffData.effectiveDate">
        					   </div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Terms Of Payment
								</label>
								<div class="col-md-8 line-height-30">
									<div class="radio radio-inline" ng-init="AgencyTariffData.paymentTerms='box'">
										
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.paymentTerms" value="agf" name="Lump Sum"
							              >
							             <i></i>
							             Lump Sum
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							         	  <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.paymentTerms" value="box" name="BoxCo" >
							             <i></i>
							             	BoxCo
							          </label>
        									</div>
        								<!-- 	<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.paymentTerms" value="both" name="Both Payment">
							             <i></i>
							             	Both
							          </label>
        									</div> -->
								</div>
							</div>
						</div>
						</div>
						<div class="col-sm-12 col-md-12 col-lg-12" ng-if="AgencyTariffData.paymentTerms=='agf'">
							<div class="form-group">
								<div class="col-sm-6 col-md-6 col-lg-6">
									<label class="col-md-6 control-label"> Amount
										<span style="color: red;">*</span>
									</label>
								<div class="col-md-5 p-l-23 p-r-3">
									<input type="text" class="form-control input-sm" name="Lump Sum Amount"  ng-model="AgencyTariffData.lumpSumAmt" validator="required" id="lumpSumAmtTxt"
       									 ng-blur="onChangeDecimal('lumpSumAmtTxt',AgencyTariffData.lumpSumAmt)" valid-method="submit" message-id="lumpSumAmtTxt">
								</div>
								</div>
								<div class="col-sm-6 col-md-6 col-lg-6">
									<label class="col-md-4 control-label p-r-27">Lump Sum
									</label>
									<div class="col-md-8 line-height-30 p-l-0">
											<div class="radio radio-inline">
									         	 <label class="i-checks">
									           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyLumpSum" value="call" checked="checked"  >
									             <i></i>
									             Per Call
									          </label>
		        									</div>
		        									<div class="radio radio-inline">
									         	 <label class="i-checks">
									           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyLumpSum" value="vessel" checked="checked"  >
									             <i></i>
									             	Per Vessel
									          </label>
		        									</div>
		        									<div class="radio radio-inline">
									         	 <label class="i-checks">
									           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyLumpSum" value="month" checked="checked"  >
									             <i></i>
									             	Per Month
									          </label>
		        									</div>
										</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-12 col-lg-12" ng-if="AgencyTariffData.paymentTerms=='box'">
							<div class="col-sm-4 col-md-4 col-lg-4">
								<div class="form-group">
									<label class="col-md-6 control-label"> 
									</label>
								</div>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="form-group">
									<label class="col-md-3 control-label">SFPL Vessels</label>
									<label class="col-md-5 control-label">Non-SFPL Vessels</label>
								</div>
							</div>
						</div>
				
				<div class="col-sm-12 col-md-12 col-lg-12" ng-if="AgencyTariffData.paymentTerms=='box'">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">
									<label class="col-md-12 control-label"> Vessel Attendance Fees/Husbandary Fees
									</label>
							</div>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group">
									<div class="col-md-5 control-label">
	       									<input type="text" class="form-control input-sm" name="Attendance Fees SFPL"  ng-model="AgencyTariffData.attendanceFeesSFPL" validator="required" id="attendanceFeesSSFTxt"
	       									 ng-blur="onChangeDecimal('attendanceFeesSSFTxt',AgencyTariffData.attendanceFeesSSF)" valid-method="submit" message-id="attendanceFeesSFPL">
	      								</div>
	      								<div class="col-md-5 control-label">
	       									<input type="text" class="form-control input-sm" name="Husbandary Fees Non-SFPL"  ng-model="AgencyTariffData.attendanceFeesNonSFPL" validator="required" id="attendanceFeesNonSSFTxt"
	          									valid-method="submit" message-id="attendanceFeesNonSFPL" ng-blur="onChangeDecimal('attendanceFeesNonSSFTxt',AgencyTariffData.attendanceFeesNonSSF)">
	      								</div>
								</div>
						</div>
				</div>
						<div class="col-sm-12 col-md-12 col-lg-12" ng-if="AgencyTariffData.paymentTerms=='box'">
						<fieldset class="b-a p-b-5 p-r-0 p-l-0">
								<label class="col-md-2 control-label"> Box Commission(BoxCo)
								</label>
								</fieldset>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12 p-t-10" ng-if="AgencyTariffData.paymentTerms=='box'">		
					<div class="col-sm-4 col-md-4 col-lg-4">	
							<div class="form-group">
								<label class="col-md-12 control-label">Slot
								</label>
							</div>
							<div class="form-group p-t-10">
								<label class="col-md-12 control-label">Customer
								</label>
							</div>						
							<div class="form-group">
								<label class="col-md-12 control-label"> Basics of Payments : 
									 
								</label>
							</div>
							<div class="form-group">
									<label class="col-md-12 control-label"> Export Laden
										<span style="color: red;">*</span>
									</label>
							</div>
        <div class="form-group">
        <label class="col-md-12 control-label" style="padding-top: 26px;"> 
        </label>
       </div>
							<div class="form-group">
								<label class="col-md-12 control-label"> Export Empty
									<span style="color: red;">*</span>
								</label>
							</div>
        <div class="form-group">
        <label class="col-md-12 control-label" style="padding-top: 27px;"> 
        </label>
       </div>
								<div class="form-group">
									<label class="col-md-12 control-label"> Import Laden
										<span style="color: red;">*</span>
									</label>
								</div>
         <div class="form-group">
        <label class="col-md-12 control-label" style="padding-top: 27px;"> 
        </label>
       </div>
								<div class="form-group">
									<label class="col-md-12 control-label"> Import Empty
										<span style="color: red;">*</span>
									</label>
								</div>
					</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="form-group">
										 <select id="txtSlotAgent"  multiple="multiple"  name="multiselect[]" ng-model="AgencyTariffData.slot"
											 ng-options="master.agentCode as master.agentName for master in slotList" data-dropdownmultiselect>    
							 				  <option data-ng-repeat="master in slotList" value="{{getOptionId(master)}}" ng-selected="isOptionSelected(master)" data-ng-bind-template="{{master.agentName}}"></option>
										</select>
								</div>
								<div class="form-group">
										<select id="txtMloAgent" multiple="multiple"  name="txtMloAgent" ng-model="AgencyTariffData.customer"
											 ng-options="master.agentCode as master.agentName for master in mloList" data-dropdownmultiselect>    
							 				  <option data-ng-repeat="master in mloList" value="{{getOptionId(master)}}" ng-selected="isOptionSelected(master)" data-ng-bind-template="{{master.agentName}}"></option>
										</select>
								</div>
        <div class="form-group" >
								<div class="col-md-8 line-height-30">
   <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.expLadenPaymentBasics" value="Term"> 
              <i></i>
              Per Teu
           </label>
       </div>
    <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.expLadenPaymentBasics" value="Box" >
              <i></i>
              Per Box
           </label>
    </div>

  </div>
								<div class="form-group">
									<div class="col-md-5">
        									<input type="text" class="form-control input-sm" name="Export Laden SFPL"  ng-model="AgencyTariffData.exportLadenSFPL" validator="numbersonly" id="exportLadenSSFTxt"
          									valid-method="submit" message-id="exportLadenSFPL" ng-blur="onChangeDecimal('exportLadenSSFTxt',AgencyTariffData.exportLadenSSF)" >
       								</div>
       								<div class="col-md-5">
        									<input type="text" class="form-control input-sm" name="Export Laden Non-SFPL"  ng-model="AgencyTariffData.exportLadenNonSFPL" validator="numbersonly" id="exportLadenNonSSFTxt"
          									valid-method="submit" message-id="exportLadenNonSFPL" ng-blur="onChangeDecimal('exportLadenNonSSFTxt',AgencyTariffData.exportLadenNonSSF)">
       								</div>
               <div class="col-md-8 line-height-30">
   <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.expEmtyPaymentBasics" value="Term"> 
              <i></i>
              Per Teu
           </label>
       </div>
    <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.expEmtyPaymentBasics" value="Box" >
              <i></i>
              Per Box
           </label>
    </div>

  </div>
  </div>
							</div>
							<div class="form-group">
								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Export Empty SFPL"  ng-model="AgencyTariffData.exportEmptySFPL" validator="numbersonly" id="exportEmptySSFTxt"
          									valid-method="submit" message-id="exportEmptySFPL" ng-blur="onChangeDecimal('exportEmptySSFTxt',AgencyTariffData.exportEmptySSF)">
      								</div>
      								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Export Empty Non-SFPL"  ng-model="AgencyTariffData.exportEmptyNonSFPL" validator="numbersonly" id="exportEmptyNonSSFTxt"
          									valid-method="submit" message-id="exportEmptyNonSFPL" ng-blur="onChangeDecimal('exportEmptyNonSSFTxt',AgencyTariffData.exportEmptyNonSSF)" >
      								</div>
              <div class="col-md-8 line-height-30">
   <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.impLadenPaymentBasics" value="Term"> 
              <i></i>
              Per Teu
           </label>
       </div>
    <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.impLadenPaymentBasics" value="Box" >
              <i></i>
              Per Box
           </label>
    </div>

  </div>
							</div>
								<div class="form-group">
									<div class="col-md-5">
        									<input type="text" class="form-control input-sm" name="Import Laden SFPL"  ng-model="AgencyTariffData.importLandanSFPL" validator="numbersonly" id="importLandanSSFTxt"
          									valid-method="submit" message-id="importLandanSFPL" ng-blur="onChangeDecimal('importLandanSSFTxt',AgencyTariffData.importLandanSSF)">
       								</div>
       								<div class="col-md-5">
        									<input type="text" class="form-control input-sm" name="Import Laden Non-SFPL"  ng-model="AgencyTariffData.importLandanNonSFPL" validator="numbersonly" id="importLandanNonSSFTxt"
          									valid-method="submit" message-id="importLandanNonSFPL" ng-blur="onChangeDecimal('importLandanNonSSFTxt',AgencyTariffData.importLandanNonSSF)" >
       								</div>
               <div class="col-md-8 line-height-30">
   <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.impEmptyPaymentBasics" value="Term"> 
              <i></i>
              Per Teu
           </label>
       </div>
    <div class="radio radio-inline">
            <label class="i-checks">
              <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.impEmptyPaymentBasics" value="Box" >
              <i></i>
              Per Box
           </label>
    </div>

  </div>
								</div>
								<div class="form-group">
									<div class="col-md-5">
        									<input type="text" class="form-control input-sm" name="Import Empty SFPL"  ng-model="AgencyTariffData.importEmptySFPL" validator="numbersonly" id="importEmptySSFTxt"
          									valid-method="submit" message-id="importEmptySFPL" ng-blur="onChangeDecimal('importEmptySSFTxt',AgencyTariffData.importEmptySSF)" >
       								</div>
       								<div class="col-md-5">
        									<input type="text" class="form-control input-sm" name="Import Empty Non-SFPL"  ng-model="AgencyTariffData.importEmptyNonSFPL" validator="numbersonly" id="importEmptyNonSSFTxt"
          									valid-method="submit" message-id="importEmptyNonSFPL" ng-blur="onChangeDecimal('importEmptyNonSSFTxt',AgencyTariffData.importEmptyNonSSF)">
       								</div>
       							</div>
       						</div>
					</div>
				<div class="col-sm-12 col-md-12 col-lg-12" ng-if="AgencyTariffData.paymentTerms=='box'">
					<div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">
									<label class="col-md-12 control-label"> Basis Of Payment
									</label>
								</div>
								<div class="form-group">
									<label class="col-md-12 control-label"> Agency Conveyance
									</label>
								</div>
								<div class="form-group p-t-8">
									<label class="col-md-12 control-label"> Basis Of Payment
									</label>
								</div>
								<div class="form-group">
										<label class="col-md-12 control-label"> Agency Communication
										</label>
								</div>
								<div class="form-group p-t-8">
									<label class="col-md-12 control-label"> Basis Of Payment
									</label>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-12 control-label"> Others
									</label>
								</div> -->
							<!-- <div class="form-group">
								<label class="col-md-12 control-label"> Basics Of Payment
									<span style="color: red;">*</span>
								</label>
							</div>
							<div class="form-group">
								<label class="col-md-12 control-label"> Agency Fees
									<span style="color: red;">*</span>
								</label>
							</div> -->
							
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group">
								<div class="col-md-8 line-height-30">
									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyConveyancePaymentBasis" value="call" checked="checked"  >
							             <i></i>
							             Per Call
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyConveyancePaymentBasis" value="vessel" checked="checked"  >
							             <i></i>
							             	Per Vessel
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyConveyancePaymentBasis" value="month" checked="checked"  >
							             <i></i>
							             	Per Month
							          </label>
        									</div>
								</div>
							</div>
       								<div class="form-group">
								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Agency Conveyance SFPL"  ng-model="AgencyTariffData.agencyConveyanceSFPL" validator="numbersonly" id="agencyConveyanceSSFTxt"
          									valid-method="submit" message-id="agencyConveyanceSFPL" ng-blur="onChangeDecimal('agencyConveyanceSSFTxt',AgencyTariffData.agencyConveyanceSSF)">
      								</div>
      								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Agency Conveyance Non-SFPL"  ng-model="AgencyTariffData.agencyConveyanceNonSFPL" validator="numbersonly" id="agencyConveyanceNonSSFTxt"
          									valid-method="submit" message-id="agencyConveyanceNonSFPL" ng-blur="onChangeDecimal('agencyConveyanceNonSSFTxt',AgencyTariffData.agencyConveyanceNonSSF)">
      								</div>
							</div>
							<div class="form-group">
								<div class="col-md-8 line-height-30">
									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyCommunicationBasis" value="call"  checked="checked"  >
							             <i></i>
							             Per Call
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyCommunicationBasis" value="vessel" checked="checked"  >
							             <i></i>
							             	Per Vessel
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyCommunicationBasis" value="month" checked="checked"  >
							             <i></i>
							             	Per Month
							          </label>
        									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Agency Communication SFPL"  ng-model="AgencyTariffData.agencyCommunicationSFPL" validator="numbersonly" id="agencyCommunicationSSFTxt"
          									valid-method="submit" message-id="agencyCommunicationSFPL" ng-blur="onChangeDecimal('agencyCommunicationSSFTxt',AgencyTariffData.agencyCommunicationSSF)">
      								</div>
      								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Agency Communication Non-SFPL"  ng-model="AgencyTariffData.agencyCommunicationNonSFPL" validator="numbersonly" id="agencyCommunicationNonSSFTxt"
          									valid-method="submit" message-id="agencyCommunicationNonSFPL" ng-blur="onChangeDecimal('agencyCommunicationNonSSFTxt',AgencyTariffData.agencyCommunicationNonSSF)">
      								</div>
							</div>
							<div class="form-group">
								<div class="col-md-8 line-height-30">
									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.othersPaymentBasis" value="call" checked="checked"  >
							             <i></i>
							             Per Call
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.othersPaymentBasis" value="vessel" checked="checked"  >
							             <i></i>
							             	Per Vessel
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.othersPaymentBasis" value="month" checked="checked"  >
							             <i></i>
							             	Per Month
							          </label>
        									</div>
								</div>
						</div>
							<!-- <div class="form-group">
								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Others SFPL"  ng-model="AgencyTariffData.othersSFPL" validator="numbersonly" id="othersSSFTxt"
          									valid-method="submit" message-id="othersSFPL" ng-blur="onChangeDecimal('othersSSFTxt',AgencyTariffData.othersSSF)">
      								</div>
      								<div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Others Non-SFPL"  ng-model="AgencyTariffData.othersNonSFPL" validator="numbersonly" id="othersNonSSFTxt"
          									valid-method="submit" message-id="othersNonSFPL" ng-blur="onChangeDecimal('othersNonSSFTxt',AgencyTariffData.othersNonSSF)">
      								</div>
							</div> -->
							<!-- <div class="form-group">
									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyFeePaymentBasis" value="call"  checked="checked">
							             <i></i>
							             Per Call
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyFeePaymentBasis" value="vessel" checked="checked">
							             <i></i>
							             	Per Vessel
							          </label>
        									</div>
        									<div class="radio radio-inline">
							         	 <label class="i-checks">
							           	 <input type="radio" class="radiobox style-0" ng_model="AgencyTariffData.agencyFeePaymentBasis" value="month"  checked="checked"> 
							            
							             <i></i>
							             	Per Month
							          </label>
        									</div>
								</div> -->
						 <!--  <div class="form-group">
							   <div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Agency Fees SFPL"  ng-model="AgencyTariffData.agencyFeesSFPL" validator="required"
          									valid-method="submit" message-id="agencyFeesSFPL">
      							   </div>
      							   <div class="col-md-5">
       									<input type="text" class="form-control input-sm" name="Agency Fees Non-SFPL"  ng-model="AgencyTariffData.agencyFeesNonSFPL" validator="required"
          									valid-method="submit" message-id="agencyFeesNonSFPL">
      							   </div>
							</div> -->
						</div>
					</div>
					<div class="col-md-12" ng-if="AgencyTariffData.paymentTerms=='box'">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
							      	<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
								        <thead class="dataTables-Main-Head">
								          <tr>
								            <th colspan=1 class="sorting width_1"></th>
								            <th colspan=1 class="sorting width_5 text-center">Charge Name</th>
								            <th colspan=1 class="sorting width_5 text-center">Amount</th>
								          </tr>
								          <tr>
								         </thead>
								        <tbody ng-repeat="(trIndex, row) in AgencyTariffData.extraCharges">
								        	<tr>
								           		 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
									           	 <td class="width_5">
										          		<div class="row" >
										            		<div class="col-xs-12">
										         	  			<input type="text" class="form-control input-sm" name="Charge Name" data-ng-model="row.extraChargeName" required />
										              		</div>
										              	</div>
									             </td>
									             <td class="width_5">
										          		<div class="row" >
										            		<div class="col-xs-12">
										         	  			<input type="text" class="form-control input-sm" name="Extra Amount" data-ng-model="row.extraAmount" required />
										              		</div>
										              	</div>
									             </td>
							            	</tr>
							           	</tbody>
							       </table>		
							       <div class="padding-right-5" id="AddOrRmvebtn">
						           <button ng-click="addOtherFeesRow(AgencyTariffData.extraCharges)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
						            <i class="fa fa-plus"></i>
						           </button>
						           <button ng-click="removeOtherFeesRow(AgencyTariffData.extraCharges)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
						            <i class="fa  fa-trash-o"></i>
						           </button>
						      	</div>					
						   </div>
					</div>
					</div>
					</div>
					</fieldset>
			</form>
			<div class="form-actions">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
     					<button class="btn btn-danger" ng-click="cancelView();">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div> 
		</div>
			
	</div>
</div>
