<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0323_D')" var="isDelete" />
<security:authorize access="hasRole('F0323_A')" var="isAdd" />
<security:authorize access="hasRole('F0323_UP')" var="isUpload" /> --%>
<div id="content">
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
       <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th>
           <th class="sorting width_8" st-sort="">RFQ No</th>
           <th class="sorting width_10" st-sort="">RFQ Date</th>
           <th class="sorting width_10" st-sort="">Sent By</th>
           <th class="sorting width_10" st-sort="">Status</th>
           <th class="width_2 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collection in displayedCollection">
           <td class="">
            <label class="i-checks m-b-none">
             <input type="checkbox" name="post[]">
             <i></i>
            </label>
           </td>
           <td class="">{{collection.rfqNumber}}</td>
           <td class="sorting ">{{collection.rfqDate}}</td>
           <td class="sorting ">{{collection.rfqSentByName}}</td>
           <td class="sorting ">{{collection.rfqStatusName}}</td>
           <td class=" td-actions text-center">
           <security:authorize access="hasRole('${form_code}_${modify}')">
            <span>
             <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collection)"></i>
            </span>
            </security:authorize>
            <security:authorize access="hasRole('${form_code}_${delete}')">
            <span>
            
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collection)"></i>
        </span>
        </security:authorize>
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