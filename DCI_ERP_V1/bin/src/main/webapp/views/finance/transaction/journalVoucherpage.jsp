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
						<!-- 		<div class="col-sm-12 col-md-3 col-lg-3 ">
		
		    <div class="form-group">
        <label class="col-md-5 control-label">JV No</label>
        <div class="col-md-7">
     <div id="jvCode" class="selectivity-input example-input selectivity-slot jvCode" ><input type="text" class="input-sm selectivity-single-select-input" nextvalue="validFromDate"></div>     
        </div>
       </div> 
       </div> -->
						<div class="col-sm-12 col-md-3 col-lg-3 ">

							<div class="form-group">
								<label class="col-md-5 control-label">From JV No</label>
								<div class="col-md-7">
									<div id="jvCode1"
										class="selectivity-input example-input selectivity-slot jvCode">
										<input type="text"
											class="input-sm selectivity-single-select-input"
											nextvalue="validFromDate">
									</div>

								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-3 col-lg-3 ">
							<div class="form-group">
								<label class="col-md-5 control-label">To JV No</label>
								<div class="col-md-7">
									<div id="jvCode2"
										class="selectivity-input example-input selectivity-slot jvCode">
										<input type="text"
											class="input-sm selectivity-single-select-input"
											nextvalue="validFromDate">
									</div>

								</div>
							</div>

						</div>
						<div class="col-sm-12 col-md-6 col-lg-6">
							<security:authorize access="hasRole('${form_code}_${print}')">
								<button class="btn btn-primary" type="button"
									data-ng-click="bulk(jvcode1,jvCode2 );">Bulk Print</button>
							</security:authorize>
	
	
							<button class="btn btn-info" type="button"
								data-ng-click="viewDraft();">View Draft Lists</button>

						</div>
						<%-- 	<div class="col-sm-12 col-md-9 col-lg-9 ">
				<button class="btn btn-primary" type="button"
					data-ng-click="copyJournalVoucher(jvcode);">
					Copy JV
				</button>
				<button class="btn btn-primary" type="button"
					data-ng-click="bulk(jvcode1,jvCode2 );">
					Bulk Print
				</button>
				<security:authorize access="hasRole('${form_code}_${approve}')">
					<button class="btn btn-primary" type="button"
						data-ng-click="reverseJV();">
						Reverse JV
					</button>
				</security:authorize>
				
			<button class="btn btn-info" type="button"
					data-ng-click="viewDraft();">
					View Draft Lists
			</button>
			</div> --%>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-12 col-md-3 col-lg-3 ">

							<div class="form-group">
								<label class="col-md-5 control-label">JV No</label>
								<div class="col-md-7">
									<div id="jvCode"
										class="selectivity-input example-input selectivity-slot jvCode">
										<input type="text"
											class="input-sm selectivity-single-select-input"
											nextvalue="validFromDate">
									</div>
								</div>
							</div>
						</div>

						<div class="col-sm-12 col-md-3 col-lg-3">

							<button class="btn btn-primary" type="button"
								data-ng-click="copyJournalVoucher(jvcode);">Copy JV</button>
							<security:authorize access="hasRole('${form_code}_${approve}')">
								<button class="btn btn-primary" type="button"
									data-ng-click="reverseJV();">Reverse JV</button>
							</security:authorize>

						</div>
					</div>
				</div>
				<div class="panel-body float-left padding-0" style="width: 100%">
					<div class="table-responsive" style="border: 1px solid #CCC;">
						<table class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
								<tr>
									<th class="width_1"></th>
									<th class="sorting" st-sort="jvNumber">JV Number</th>
									<th class="sorting" st-sort="voucherDate">Date</th>
									<th class="sorting" st-sort="narration">Narration</th>
									<th class="sorting" st-sort="narration">TotalBCDebit</th>
									<th class="sorting" st-sort="narration">TotalTCDebit</th>
									<th class="sorting" st-sort="narration">TotoalBCCredit</th>
									<th class="sorting" st-sort="narration">TotalTCCredit</th>
									<th class="sorting" st-sort="narration">Users</th>
									<th class="sorting" st-sort="Action">Action</th>
									<!-- 	<th class="">Action</th> -->
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="objTranslationItem in displayedCollection">
									<td cs-select="objTranslationItem"></td>
									<!--        <td>{{objTranslationItem.jvNumber}}</td> -->
									<td><span><a
											ng-click="view(objTranslationItem.jvNumber)"> <span
												tooltip="{{objTranslationItem.jvNumber}}"
												class="tool-tip-span font-blue">{{objTranslationItem.jvNumber}}</span>
										</a></span> <!-- <span ng-if="objTranslationItem.urIsView=='f'"> <span
											tooltip="{{objTranslationItem.jvNumber}}"
											class="tool-tip-span">{{objTranslationItem.jvNumber}}</span>
									</span> --></td>
									<td>{{objTranslationItem.dataOfIssue}}</td>
									<td><span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.narration}}</span>
									</td>
									<td><span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.totalTcDebitAmt}}</span>
									</td>
									<td><span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.totalBcDebitAmt}}</span>
									</td>
									<td><span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.totalTcCreditAmt}}</span>
									</td>
									<td><span tooltip="{{objTranslationItem.narration}}">{{objTranslationItem.totalBcCreditAmt}}</span>
									</td>
									<td>{{objTranslationItem.createdBy}}</td>
									<td class="td-actions text-center"><security:authorize
											access="hasRole('${form_code}_${print}')">
											<span
												ng-click="printJournalVoucherDiv(objTranslationItem.jvNumber,$index)"
												id="{{objTranslationItem.jvNumber}}" title="Print"
												class=" glyphicon glyphicon-print " data-toggle="tooltip"
												title="Print" style="cursor: pointer; color: gray;"></span>
										</security:authorize> <security:authorize
											access="hasRole('${form_code}_${modify}')">
											<span>
												<i class="fa  fa-pencil text-success text"
												data-ng-click="editedJournalVoucher(objTranslationItem.jvNumber,$index)"></i>
											</span>
										</security:authorize> <security:authorize
											access="hasRole('${form_code}_${delete}')">
											<span> <i
												class="fa fa-trash-o text-danger-dker text"
												data-ng-click="deleteRow(objTranslationItem.jvNumber,$index)"></i>
											</span>
										</security:authorize></td>
								</tr>
							</tbody>
						</table>
					</div>
					<footer class="panel-footer" style="padding: 0px;">
						<%@include file="/views/templates/panel-footer-static.jsp"%>
					</footer>
				</div>
			</div>
		</div>

		<script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
 <div class="col-lg-12">
  <div class="col-lg-12">
   <!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
   <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadPIFile(this)"  accept=".xls,.xlsx,.xlsm" />
  </div>
 </div> 
</div>
<div class="modal-footer">
<a href="assets/docs/JOURNAL_VOUCHER_UPLOAD.xlsx" class="control-label">Download sample excel file</a>
 <button class="btn btn-info" type="button" ng-click="uploadPIStatement()">OK</button>
 <button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>