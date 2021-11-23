<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
 
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		
  <div class="panel-body padding-10">
    <div class="table-responsive" style=" border: 1px solid #CCC;">
    <input type="hidden" value="${user.userId}" id="userId">
   <!--    <div class="pull-right">
        <div class="col-md-12">
          <nav class="navbar">
            <input class="form-control  pull-center" placeholder="Search.." name="search" [(ngModel)]="filter">
          </nav>

        </div>
      </div>
      <div>
        <button type="button" class="btn btn-primary pull-right" data-ng-click="add();"><i class="fa fa-plus"></i></button>
<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive "> -->

        <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
            <tr>
              <th style="width: 10%;" st-sort="blNo"> BL NO</th>
              <th style="width: 10%;" st-sort="bookingNo"> Booking No</th>
              <th style="width: 10%;" st-sort="issuePlace"> Issue Place</th>
              <th style="width: 10%;" st-sort="pol"> P.O.L</th>
              <th style="width: 10%;" st-sort="pod"> P.O.D</th>
              <th style="width: 10%;" st-sort="noBls"> No.Bls</th>

              <th style="width: 10%;">Action</th>
            </tr>
          </thead>

          <tbody class="dataTables-Main-Body">
            <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="item in displayedCollection">
              <td> {{item.blNo}}</td>
              <td>{{item.bookingNo}}</td>
              <td>{{item.issuePlace}}</td>
              <td>{{item.pol}}</td>
              <td>{{item.pod}}</td>
              <td>{{item.noBls}}</td>
              <td class=" td-actions text-center">
                <span>
                  <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit" ng-click="editRow(item.blNo)"></i>
                </span>
              <!--   <span>
                  <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" (click)="alertConfirm(item.blNo)">
                  </i>
                </span> -->
			   <span> 
              <i class="fa  fa-print text-success text" title="Print Original" data-ng-click="printBLOriginal(item.blNo)"></i>
			  </span>
			   <span> 
              <i class="fa  fa-print text-primary text" title="Print Copy" data-ng-click="printBLCopy(item.blNo)"></i>
			  </span>
              </td>
            </tr>
          </tbody>
        </table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			</div>
      </div>
      <br>
      <br>
    </div>
</body>
</html>