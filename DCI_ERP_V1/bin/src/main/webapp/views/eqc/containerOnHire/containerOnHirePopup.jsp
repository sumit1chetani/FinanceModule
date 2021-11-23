<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 72%;
	position: absolute;
	top: 20%;
	left: 14%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
<div class="panel panel-default panel-default-list"
		st-table="displayedCollection1" st-safe-src="rowCollection1">
		<security:authorize access="hasRole('${form_code}_${search}')" var="isSearch" />
		
 <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">
 <div class="row  m-n">
<div class="col-md-5 padding-right-0 padding-left-0 header-with-breadcrumb font-bold" style="font-size: 18px;">
 Container Number List
  </div>
<div class="col-md-7 text-right padding-right-0">
   <div class="row">
    <div class="col-md-5 p-r-3">
</div>
<div class="col-md-5  p-l-0">
     <c:choose>
      <c:when test="${isSearch}">
       <input type="text" st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
      </c:when>
      <c:otherwise>
       <input type="text"  st-search="" class="form-control input-sm p-tb-14 bg-white rounded padder" placeholder="Search">
      </c:otherwise>
     </c:choose>
    </div>
    <div class="ngdialog-close"></div>
     </div>
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
							<th class="width_10" >Sl. No.</th>
 							<th class="width_18">Container Number</th>
                             <th class="width_17" >Container Type</th>
                             <th class="width_15" >On Hire Date</th>
                              <th class="width_20">Gate Out Date</th>
                             <th class="width_15" >Off Hire Date</th>
                            
							</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection1">
	
						<td class="sorting" data-toggle="tooltip">{{$index+1}}</td>

							<td class="sorting" data-toggle="tooltip"
												title="{{item.containerNo}}">{{item.containerNo}}</td>
                             <td class="sorting" data-toggle="tooltip"
												title="{{item.containerType}}">{{item.containerType}}</td>
                             <td class="sorting" data-toggle="tooltip"
												title="{{item.actualPickupDate}}">{{item.actualPickupDate}}</td>
								<td class="sorting" data-toggle="tooltip"
												title="{{item.gateOutDate}}">{{item.gateOutDate}}</td>
                             <td class="sorting" data-toggle="tooltip"
												title="{{item.gateOutDate}}">{{item.mtdDate}}</td>
												
							 
						
						</tr>
                     </tbody>
				</table>
			</div> 
			
		</div>
		<br>
		<br>
		<div class="model-footer" style="padding-left:44%;padding-top:18%">
<button class="btn btn-danger" ng-click="closeUpload()"><i class="fa fa-close"></i>Cancel</button>
		</div>
		
		<!-- end widget content -->
	</div>
</div>
</div>
