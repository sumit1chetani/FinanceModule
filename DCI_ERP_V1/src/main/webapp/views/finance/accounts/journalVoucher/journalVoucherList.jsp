<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel panel-default">
			<div class="form-body form-horizontal">
				<div class="row m-t-sm">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-lg-12">
							<fieldset>
								<div class="col-sm-3 col-md-3">
									<!--  <div class="form-group">
                          <label class="col-md-6 control-label">From Date
                          </label>
                          <div class="col-md-6">
                            <div class='input-group date datetimepick'>
                              <div class="dropdown">
                                <a class="dropdown-toggle" id="fromdate" role="button" data-toggle="dropdown"
                                   data-target="#" href="#">
                                  <div class="input-group">
                                    <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="fromdate"
                                           id="periodFrom"
                                           data-ng-model="fromdate">
                                    <span
                                          class="input-group-addon">
                                      <i class="glyphicon glyphicon-calendar">
                                      </i>
                                    </span>
                                  </div>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                  <datetimepicker data-ng-model="fromdate"
                                                  data-on-set-time="fromdate = onDateSet(newDate);"
                                                  data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
                                </ul>
                              </div>
                            </div>
                          </div>
                        </div> -->

									<div class="form-group ">
										<label class="col-md-4 control-label">From Date </label>
										<div class="col-md-7 ">
											<ng-bs3-datepicker ng-disabled="createQuote"
												data-ng-model="fromdate" id="fromdate" name="fromdate"
												data-ng-change="checkDatesCL(fromdate)"
												friendly-name="fromdate" validation="required" />
										</div>
									</div>

								</div>
								<div class="col-sm-3 col-md-3">
									<!-- <div class="form-group">
                          <label class="col-md-6 control-label">To Date
                          </label>
                          <div class="col-md-6">
                            <div class='input-group date datetimepick'>
                              <div class="dropdown">
                                <a class="dropdown-toggle" id="todate" role="button" data-toggle="dropdown"
                                   data-target="#" href="#">
                                  <div class="input-group">
                                    <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="todate"
                                           id="todate"
                                           data-ng-model="todate">
                                    <span
                                          class="input-group-addon">
                                      <i class="glyphicon glyphicon-calendar">
                                      </i>
                                    </span>
                                  </div>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                  <datetimepicker data-ng-model="todate"
                                                  data-on-set-time="todate = onDateSet(newDate);"
                                                  data-datetimepicker-config="{ dropdownSelector: '#todate',startView:'day', minView:'day'}" />
                                </ul>
                              </div>
                            </div>
                          </div>
                        </div> -->


									<div class="form-group ">
										<label class="col-md-4 control-label">To Date </label>
										<div class="col-md-7 ">
											<ng-bs3-datepicker ng-disabled="createQuote"
												data-ng-model="todate" id="todate" name="todate"
												data-ng-change="checkDatesCL(todate)" friendly-name="todate"
												validation="required" />
										</div>
									</div>
								</div>
								<!-- <div class="col-sm-4 col-md-4">
                      <div class="form-group">
                        <label class="col-md-3 control-label"> JV Type
                        </label>
                        <div class="col-md-6">
                            <selectivity class="selectivity-results-container1 " list="journalVoucherTypeList" ng-model="jvTypeId" 
								property="jvTypeId"></selectivity>
                        </div>
                      </div>
                     </div> -->


								<%-- <div class="form-body form-horizontal">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="col-sm-4 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label  vessel-text">JV No</label>
								<!-- <div class="col-md-7">
									<selectivity list="rowCollection" property="paymentCode"  ng-model="txtPaymentCode" 
								        id="jvCode"></selectivity>	
								</div> -->
								     <div id="jvCode" class="selectivity-input example-input selectivity-slot jvCode" ><input type="text" class="input-sm selectivity-single-select-input" nextvalue="validFromDate"></div>     
								
							</div>
						</fieldset>
					</div>
					<div class="col-sm-8 col-md-8 col-lg-8">
						<!-- <button class="btn btn-primary" type="button"
							data-ng-click="copyPayment();">
							Copy Payment
						</button>	 -->	
					<security:authorize access="hasRole('${form_code}_${approve}')">	
									
						<button class="btn btn-success" type="button"
							data-ng-click="reversePayment();">
							Reverse 
						</button>
						</security:authorize>
					</div>
				</div>			
			</div>
		</div>  --%>




								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-body form-horizontal">
										<div class="row">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<fieldset>
													<div class="form-group">
														<label class="col-md-5 control-label  vessel-text">JV
															No</label>
														<div class="col-md-7">
															<div id="jvCode"
																class="selectivity-input example-input selectivity-slot jvCode">
																<input type="text"
																	class="input-sm selectivity-single-select-input"
																	nextvalue="validFromDate">
															</div>

														</div>
													</div>
												</fieldset>
											</div>
											
											<div class="col-sm-2 col-md-2 col-lg-2">
												<!-- <button class="btn btn-primary" type="button"
													data-ng-click="copyPayment();">
													Copy Payment
												</button>	 -->
												<button class="btn btn-info" type="button"
													data-ng-click="reversePayment();">Reverse JV</button>
											</div>


											<div class="form-group">
												<div class="row">
													<div class="col-md-3 ">
														<button class="btn btn-success" type="button"
															class="btn btn-success" ng-click="getTranslationList()">Generate
														</button>

													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</fieldset>
						</div>


						<div>
							<!-- 	<div class="form-group" >
			        <label class="col-md-2 control-label">JV NO</label>
			        <div class="col-md-2">
			        	<input type="text" class="form-control input-sm" id=jvNumber name="jvNumber"
			        	ng-model="jvNumber" />
			        </div>
		       	</div> -->
							<!--    	
		    <div class="form-group">
        <label class="col-md-2 control-label">JV No</label>
        <div class="col-md-2">
     <div id="jvCode" class="selectivity-input example-input selectivity-slot jvCode" >
     <input type="text" class="input-sm selectivity-single-select-input" nextvalue="validFromDate"></div>     
        </div>
       </div> 
		       	<div class="form-group">
						<div class="row">
                      <div class="col-md-5 col-md-offset-5">
                      <button class="btn btn-primary" type="button"
					data-ng-click="copyJournalVoucher(jvCode);">
					Copy JV
				</button>
				</div>
				</div>
				</div> -->
						</div>


						<!-- div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						<div class="dt-toolbar">
							<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>
						</div>
						<table class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head">
								<tr>
									<!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
									<th class="sorting" st-sort="jvNumber">JV Number</th>
									<th class="sorting" st-sort="voucherDate">Date</th>
									<th class="sorting" st-sort="narration">Narration</th>
									<th class="sorting" st-sort="narration">Fund Type</th>
									<th class="width_5 text-center table-heading">Action</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="objTranslationItem in displayedCollection">
									<!-- <td cs-select="objTranslationItem" class="text-center"></td> -->
									<td>{{objTranslationItem.jvNumber}}</td>
									<td>{{objTranslationItem.dataOfIssue}}</td>
									<td><span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.narration}}</span>
									</td>
									<td>{{objTranslationItem.costcenter}}</td>
									<td class="td-actions text-center">
										<%-- <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span class="fa  fa-pencil text-success text" data-ng-click="editJVRow(objTranslationItem.jvNumber)">
	        </span>
	        </security:authorize> --%> <security:authorize
											access="hasRole('${form_code}_${view}')">
											<span> <i class="fa  fa-list-alt text-dark text"
												data-ng-click="view(objTranslationItem.jvNumber)"
												tooltip="Edit"></i>
											</span>
										</security:authorize> <security:authorize
											access="hasRole('${form_code}_${delete}')">
											<span class="fa fa-trash-o text-danger-dker text"
												data-ng-click="deleteJVRow(objTranslationItem.jvNumber,$index)">
											</span>
										</security:authorize> <span> <i class="fa fa-print text-dark text"
											title="Print"
											ng-click="printJournalVoucherDiv(objTranslationItem.jvNumber)"></i>
									</span> <!-- 	<button class="btn btn-success"  ng-click="printJournalVoucherDiv(objTranslationItem.jvNumber)"  type="button">
	        	  Print
	          	</button> -->
									</td>
								</tr>
							</tbody>
						</table>
						<!--    <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->


						<footer class="panel-footer panel-footer-list">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>
					</div>
				</div>
				</form>
				<!-- end widget content -->
			</div>
			<!-- end widget div -->
		</div>
		<!-- end widget -->
		</article>
		<!-- WIDGET END -->
		</section>
	</div>