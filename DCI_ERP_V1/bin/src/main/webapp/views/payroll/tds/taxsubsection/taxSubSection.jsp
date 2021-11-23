<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
		       <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		        <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="width_1"></th>
		           <th class="sorting width_10" st-sort="taxSubSectionCode">Sub Section Code</th>
		           <th class="sorting width_10" st-sort="taxSubSectionDescription">Description</th>
		           <th class="sorting width_10" st-sort="taxSectionCode">Section Code</th>
		           <th class="sorting width_10" st-sort="taxSubSectionMaxLimit">Max.Limit</th>
		           <th class="sorting width_10" st-sort="taxSectionStatus">Active</th>
		           <th class="width_5">Action</th>
		          </tr>
		         </thead>
		           <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="taxSubSectionCollection in displayedCollection">
           <td cs-select="objVesselMasterItem"></td>
			<td>{{taxSubSectionCollection.taxSubSectionCode}}</td>
			<td>{{taxSubSectionCollection.taxSubSectionDescription}}</td>
			<td>{{taxSubSectionCollection.taxSectionCode}}</td>
			<td>{{taxSubSectionCollection.taxSubSectionMaxLimit}}</td>
			<td><input type="checkbox" checked="checked" ng-model="taxSubSectionCollection.taxSubSectionStatus" disabled="disabled"></td>
		 <td class=" td-actions text-center" ng-if="taxSubSectionCollection.computed==false">
        <span>
          <security:authorize access="hasRole('${form_code}_${modify}')">   
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(taxSubSectionCollection.taxSubSectionCode)"></i>
         </security:authorize>
        </span>
        <!--<span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(taxSubSectionCollection.taxSubSectionCode)"></i>
        </span>-->
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