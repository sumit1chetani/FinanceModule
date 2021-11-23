

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<br><br>
			<!-- <div class="col-sm-12 col-md-12 col-lg-12"> -->
						<!-- 		<div class="col-sm-12 col-md-3 col-lg-3 ">
		
		    <div class="form-group">
        <label class="col-md-5 control-label">JV No</label>
        <div class="col-md-7">
     <div id="jvCode" class="selectivity-input example-input selectivity-slot jvCode" ><input type="text" class="input-sm selectivity-single-select-input" nextvalue="validFromDate"></div>     
        </div>
       </div> 
       </div> -->
						<!-- <div class="col-sm-12 col-md-3 col-lg-3 "> -->
<div class="form-group ">
								<label class="col-md-2 control-label" style="
    padding-left: 170px;"><b>Query</b> <span
									style="color: red"></span></label>
								<div class="col-md-8">
								<textarea  type="text" class="form-control input-sm"
															name="remarks" 
															class="custom-scroll width_300 resize-none" rows="5" columns="5"
															ng-model="genledg.querycheck">
															</textarea>
							</div>
							</div>
							        	
		      <!--  <div class="form-actions"> -->
		         <!-- <div class="row"> -->
			        <!--   <div class="col-md-12 "> -->
			        
							<button  type="button" class="btn btn-success" ng-click="save(branchMasterForm,branchMaster)">
				            	<i class="fa fa-search" type="button"></i>View Report
				            </button>
				            
				           
				            <button   type="button"class="btn btn-primary" data-ng-click="exportExcel()">
		            			<i class="fa fa-file-excel-o" type="button"></i>Export Excel
		       			         <a id="containerExport" stype="display:none"
					href="filePath/Query.xls" download="Query.xls"></a>
		       				</button>
		       			
				        <!--     <button type="button" class="btn btn-info" ng-click="reset();">
				           		 <i class="fa fa-undo"></i>Reset
				            </button> -->
			       <!--    </div> -->
			   <!--   </div> -->
			<!-- 	</div> -->
					<!-- <button class="btn btn-success" type="button"
								
								ng-click="save(branchMasterForm,branchMaster)">
								<i class="fa fa-save"></i> Execute Now

							</button> -->
		<!-- 					  <button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
        <span class="fa fa-file-excel-o"> Export Excel</span>
         <a id="containerExport" stype="display:none"
					href="filePath/Query.xls" download="Query.xls"></a>
					
					
       </button> -->
					<!-- 	</div> -->
			
				
		<!-- 				<div class="col-sm-6 col-md-3 col-lg-3">
							        
           <button class="btn btn-primary"
            data-ng-click="excel();"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
          <a id="exportXl" href="" download=""></a>
						</div> -->
						<br>
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
					<!-- </div> -->
					
					<br><br><br><br>
<div class="row">
					<div class="col-xs-12">
						<div id="jqgrid">
							<table id="generalLedgerGrid"></table>
							<div id="generalLedgerPage"></div>
						</div>
					</div>
				</div>
</div>
