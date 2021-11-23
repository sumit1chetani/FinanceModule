<div class="breadcrumb-wrapper ng-scope">
<div class="panel panel-default panel-default-list" st-table="transAssignBeanList" st-safe-src="mailid" ng-controller="transAssignedCtrl">
<%@include file="/views/templates/panel-header.jsp"%>
<div class="panel panel-default panel-default-form">
<div class="wrapper-md">
<div class="panel panel-default panel-default-form">
<div class="panel-body">
<form name="transAssignForm" class="form-horizontal" novalidate>
<div class="row">
<input type="hidden" value="${form_code}" id="form_code_id">

 	<div class="col-sm-12">
    <fieldset>
        <div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">From Vessel<span style="color: red;">*</span></label>
        <div class="col-md-7">
        <selectivity  list="vesselList" property="transAssign.vessel" ng-model="transAssign.vessel" 
         id="vessel" form-name="transAssignForm" name="vessel" validation="required" friendly-name="From Vessel" ></selectivity>
        </div>
        </div>
        </div>
        
        
        <div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">To Vessel<span style="color: red;">*</span></label>
        <div class="col-md-7">
         <selectivity  list="vesselList" property="transAssign.vesselTo" ng-model="transAssign.vesselTo" 
         id="vesselTo" form-name="transAssignForm" name="vesselTo" validation="required" friendly-name="To Vessel" ></selectivity>
       
        </div>
        </div>
        </div>       
      </fieldset>
      </div>
      
      
      <div class="col-sm-12">
   		<fieldset>
   		<div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">From Voyage<span style="color: red;">*</span></label>
        <div class="col-md-7">
        <selectivity  list="voyageList" property="transAssign.voyage" ng-model="transAssign.voyage"  id="voyage" 
          validation="required" form-name="transAssignForm" name="voyage" friendly-name="From Voyage" ></selectivity>
        </div>
        </div>
        </div>
        
        <div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">To Voyage<span style="color: red;">*</span></label>
        <div class="col-md-7">
        <selectivity  list="voyageListTo" property="transAssign.voyageTo" ng-model="transAssign.voyageTo"  id="voyageTo" 
          validation="required" form-name="transAssignForm" name="voyageTo" friendly-name="To Voyage" ></selectivity>
       
        </div>
        </div>
        </div>
   		
   		</fieldset>
   		</div>
   		
   		
   		<div class="col-sm-12">
   		<fieldset>
   		
   		<div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">From POT<span style="color: red;">*</span></label>
        <div class="col-md-7">
       <selectivity  list="polList" property="transAssign.pol" ng-model="transAssign.pol"  validation="required"
          id="pol" form-name="transAssignForm" name="pol" friendly-name="From Pol"></selectivity>
        </div>
        </div>
        </div>
        
        <div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">To POT<span style="color: red;">*</span></label>
        <div class="col-md-7">
        <selectivity  list="polListTo" property="transAssign.polTo" ng-model="transAssign.polTo"  id="polTo"
         name="polTo" form-name="transAssignForm" validation="required" friendly-name="To Pol"></selectivity>
        </div>
        </div>
        </div>
         <div class="col-md-4" >
		<div class="form-group">
		<label class="col-md-5 control-label">ETD at POT</label>
		<div class="col-md-7">
		<label class="col-md-8 control-label">{{transAssign.etdAtPot}}</label>
		</div>
		</div>
		 </div>
   		</fieldset>
   		</div>
 
 		 
 		 
 		 
 		 <div class="col-sm-12">
   		<fieldset>
   		<div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label"><span style="color: red;"></span></label>
   		</div>
   		</div>
   		
   		
   		<div class="col-md-4">
		<div class="form-group">
   		<label class="col-md-5 control-label">To POD<span style="color: red;">*</span></label>
        <div class="col-md-7">
        <selectivity  list="polListTo" property="transAssign.podTo" ng-model="transAssign.podTo"  id="podTo"
         name="podTo" form-name="transAssignForm" validation="required" friendly-name="To Pod"></selectivity>
        </div>
        </div>
        </div>
        
        <div class="col-md-4" >
		<div class="form-group">
		<label class="col-md-5 control-label">ETA at POD</label>
		<div class="col-md-7">
		<label class="col-md-8 control-label">{{transAssign.etasailDate}}</label>
		</div>
		</div>
		 </div>
   		</fieldset>
   		</div>
   		
   		</div>
 				
 				<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"   
							ng-click="searchAssignedData()">
							<i class="fa fa-search"></i> Search
						</button>  
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
			
			 <div class="panel-body">

				<div class="panel-body padding-0">
					<div class="table-responsive ">
						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dt_basic_info">
							<thead class="dataTables-Main-Head">
								<tr>
								<th >
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]" ng-click="multiSelect(transAssignBeanList)">
         <i></i>
        </label>
       </th>
								    <th class="sorting txtUpperCs" st-sort="exvoyage">Ex-Voyage</th>
									<th class="sorting txtUpperCs" st-sort="bookingno">Booking No.</th>
									<th class="sorting txtUpperCs" st-sort="blno">BL No</th>
									<th class="sorting txtUpperCs" st-sort="custname">Customer </th>
									<th class="sorting txtUpperCs" st-sort="pol">POL</th>
									<th class="sorting txtUpperCs" st-sort="pot">POD</th>
									<th class="sorting txtUpperCs" st-sort="fpod">POD</th>
									<th class="sorting txtUpperCs" st-sort="noofcntrs">No. of Cntrs</th>
									<th class="sorting txtUpperCs" st-sort="assignvessel">Assigned vessel</th>
									<th class="sorting txtUpperCs" st-sort="assignvoyage">Assigned Voyage</th>
									<th class="sorting txtUpperCs" st-sort="leg">T/s Leg</th>
									 
								</tr>
							</thead>
								 
							<tbody class="dataTables-Main-Body" ng-repeat=" (trindex,item)  in transAssignBeanList" ng-controller="tableAddCtrl">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
						<td>
	  <label class="i-checks m-b-none"> <input type="checkbox" ng-model="item.select" id="select{{trindex}}" ><i></i></label>
	  </td>
					                <td class="txtUpperCs"><span>{{item.exvoyage}}</span></td>
									<td class="txtUpperCs"><span>{{item.bookingno}}</span></td>
									<td class="txtUpperCs"><span>{{item.blno}}</span></td>
									<td class="txtUpperCs"><span>{{item.custname}}</span></td>
									<td class="txtUpperCs"><span>{{item.pol}}</span></td>
									<td class="txtUpperCs"><span>{{item.pot}}</span></td>
									<td class="txtUpperCs"><span>{{item.fpod}}</span></td>
									<td class="txtUpperCs"><span>{{item.noofcntrs}}</span></td>
									<td class="txtUpperCs"><span>{{item.assignvessel}}</span></td>
									<td class="txtUpperCs"><span>{{item.assignvoyage}}</span></td>
									<td class="txtUpperCs"><span>{{item.leg}}</span></td>
									 
 
								</tr>
							
							</tbody>
						</table>
					</div>
				</div>
				<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"   
							ng-click="updateVslDtls(item)">
							 T/S Roll Over
						</button>  
						 
					</div>
				</div>
			</div>
			</div>
		 
 
			<br><br><br>
		</form>
	</div>
</div>
</div>
</div></div></div>