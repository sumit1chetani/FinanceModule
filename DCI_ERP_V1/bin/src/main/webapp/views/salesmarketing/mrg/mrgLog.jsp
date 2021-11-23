<style type="text/css">
.textareath {
	resize: vertical;
	max-height: 100px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 40px !important;
	margin: 2 auto !important;
}
</style>
<div class="wrapper-md">
	<div class="row">
	<div class="panel panel-default panel-default-form">
	<div class="col-sm-12" >
	<span><b>
		MRG UPLOAD LOG
	</b></span>
	</div>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="POST"
			name="ratequotationForm" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<fieldset><div>
	<br>
	<br>
				<table class="table table-striped table-hover dataTable no-footer" style="background-color: #d9f3fc !important;">
					<thead class="dataTables-Main-Head" style="background-color: #44c0d4 !important;">
					<thead style="background-color: #44c0d4 !important;">
						<tr>
							<th style="background-color: #44c0d4 !important;">Uploaded Date</th>
							<th style="background-color: #44c0d4 !important;">Uploaded By</th>
							<th style="background-color: #44c0d4 !important;">IP Address</th>
							<th  style="background-color: #44c0d4 !important;">File Name</th>
						
							
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="row in mrgLog">
						
							<td >{{row.uploadedDate}}</td>
							<td >{{row.uploadedBy}}</td>
							<td>{{row.ipAddress}}</td>
							<td >
							<a id="tbnewExport{{$index}}" style="display: block"
											href="filePath/{{row.fileName}}"
											download="{{row.fileName}}"></a>	
											<a ng-click="downloadNewFile($index)"
													style="color: green">{{row.fileName}}</a>
							</td>
							
						</tr>
					</tbody>

				</table>
			</div>
					</fieldset>
				</div>
				 
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						

						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="cancel()">
							<i class="fa fa-close"></i> Close
						</button>
					</div>
				</div>
			</div>
		</form>
</div>
	</div>
</div>

