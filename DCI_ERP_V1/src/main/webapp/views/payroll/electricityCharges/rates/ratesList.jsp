<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0331_D')" var="isDelete" />
<security:authorize access="hasRole('F0331_A')" var="isAdd" /> --%>
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
      <span><state-breadcrumbs></state-breadcrumbs>  </span>
     </header>
	     <div role="content">
	      <div class="widget-body no-padding">
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		    <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		        <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
		    	<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="width_1"></th>
		         	<th class="sorting width_10" st-sort="rangeFrm">Range From</th>
		           <th class="sorting width_10" st-sort="rangeTo">Range To</th>
		           <th class="sorting width_10" st-sort="percentage">Unit Charge</th>
		           <th class="width_5">Action</th>
		          </tr>
		         </thead>
		           <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="rateCollection in displayedCollection">
           <td cs-select="objVesselMasterItem"></td>
          	<td>{{rateCollection.rangeFrom}}</td>
			<td>{{rateCollection.rangeTo}}</td>
			<td>{{rateCollection.unitCharge}}</td>
			
		 <td class=" td-actions text-center">
        <span>
           <security:authorize access="hasRole('${form_code}_${modify}')">   
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(rateCollection.id)"></i>
         </security:authorize>
        </span>
        <span>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(rateCollection.id)"></i>
         </security:authorize>
        </span>
       </td>
          </tr>
         </tbody>
		        </table>
		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
	        </div>
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>