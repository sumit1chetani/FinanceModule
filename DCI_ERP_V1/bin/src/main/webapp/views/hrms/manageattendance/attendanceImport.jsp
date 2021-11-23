
<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
      <state-breadcrumbs></state-breadcrumbs> 
     </header>
     <!-- <div class="panel-body">
			<form class="form-horizontal">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
						 <div class="form-group">
           	<label class="col-md-4 control-label">File Name</label>
           	<div class="col-md-15 inputGroupContainer">
           		<div class="input-group">
           			 <input type="file" name="excelfiles" class="form-control" ng-model="excelfiles" /> 
           			<button type="button" ng-model="excelfiles"  onclick="angular.element(excelfiles).scope().generatingExcel(excelfiles)" >Upload</button>   
           		</div>
           	</div> 
           	</div>
						</fieldset>
						</div>
						</div>
						</form>
						</div> -->
						<div role="content">
	      <div class="widget-body no-padding">
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
	        	<div class="widget-body">
		       		<form class="form-horizontal" name="shiftImportAddForm" role="form" ng-submit="#" novalidate>
		        		<div class="row">
		         			<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10 col-lg-offset-3">
		          				<fieldset>
				  					<div class="form-group">
             							<label class="col-md-4 control-label">File Name</label>
             								<div class="col-md-8">
             									<input type="file" class="form-control" name="excelfile" 
             									onchange="angular.element(this).scope().uploadFile(this)" accept=".xls,.xlsx,.xlsm" />             									
              									<a id="sPdfExport" stype="display:none" href="tempdoc/Sample_Attendance_Upload_File.xls" 
              									download="Sample_Attendance_Upload_File.xls"></a>
      										</div>
          							 </div>
          						</fieldset>
       						</div>
		           		</div>
          	 		</form>
           		</div>
	        </div>
	        <div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-primary" type="button" class="btn btn-success" ng-click="downloadFile()">
			            <i class="fa fa-download"></i>
			           		Download Sample File
			           </button>
			          	<button class="btn btn-success" type="button" class="btn btn-success" 
			          		ng-click="uploadAttendanceFile()">
			            	<i class="fa fa-check"></i>
			           		OK
			           </button>
			            <button class="btn btn-danger" type="button"
							class="btn btn-success" ng-click="exit()">
								<i class="fa fa-close"></i> Exit
						</button>
					</div>
				</div>
			</div><br><br>
			<!-- <div class="col-sm-12 col-md-12 col-lg-12" style="padding-left:78px;">
				<fieldset>
					<div class="form-group">
						<label><span style="color : red ">*</span> Importing Excel is only For Inserting New Records</label>
					</div>
				</fieldset>
			</div> -->
	       </div>
	      </div>
						</div>
						</article>
					</div>
					</section>
					</div>
					