<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 70% !important;
	bottom: 100px !important;
	margin: 0 auto !important;
}
@media screen and (min-width: 676px) {
        .modal-dialog {
          max-width: 1000px; /* New width for default modal */
        }
    }
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
<div class="panel-body" style=" width: 1200px" st-table="displayedCollection1" st-safe-src="mailid" ng-controller="poPopupCtrl">
<!-- <div class="panel panel-default panel-default-list"
		st-table="displayedCollection1" st-safe-src="mailid" ng-controller="poPopupCtrl"> -->
		
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
<div class="col-md-5 padding-right-0 padding-left-0 header-with-breadcrumb font-bold" style="font-size: 18px;">
CONFIRMATION
  </div>
<div class="col-md-6 text-right padding-right-0">
    </div>
</div>
</div>
	
 
<div class="wrapper-md">

		<div class="panel-body float-left padding-10" style="width: 100%;">
			 <div class="table-responsive" " border: 2px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							
 							<th >The mail will be sent to the below EmailIDs</th>
							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection1">
							<td class="sorting" data-toggle="tooltip">{{item}}</td>
						</tr>
                     </tbody>
				</table>
			</div> 
			
		</div>
		<br>
		<br>
		<div class="model-footer" style="padding-left:36%;padding-top:10%" >
		<button class="btn btn-success" data-ng-click="senttomail()"><i class="fa fa-envelope"></i>Sent</button>
		
<button class="btn btn-danger" ng-click="closeUpload()"><i class="fa fa-close"></i>Cancel</button>
		</div>
		
		<!-- end widget content -->
	</div>
</div>
</div>
