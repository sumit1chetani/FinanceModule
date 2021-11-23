<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0282_D')" var="isDelete" />
<security:authorize access="hasRole('F0282_A')" var="isAdd" />
<security:authorize access="hasRole('F0282_UP')" var="isUpload" /> --%>
<div id="content">
 <!-- widget grid -->
 <section id="widget-grid" data-widget-grid> 
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"> 
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <div>
				<span>
					<span class="button-icon" data-placement="bottom" data-reset-widgets rel="tooltip" title="<spring:message code='title.widget.reset'></spring:message>">
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" data-st-table="displayedCollection" data-st-safe-src="rowCollection">
        <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		</div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="sorting sorting-no text-center  width_4">
                <input role="checkbox" type="checkbox" class="cbox" data-ng-model="selectall" data-ng-change="checkAll(selectall)">
               </th>
			<th class="sorting width_10" data-st-sort="designationName">Customer Name </th>
           <th class="sorting width_10" data-st-sort="status">Invoice Number</th>
           <th class="sorting width_10">Amount</th>
            <th class="sorting width_10">Paid Amount</th>
             <th class="sorting width_10">Balance Amount</th>
             <th class="sorting width_10">Due Date</th>
             <th class="sorting width_10">Received Status</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="designation in displayedCollection">
				<td class="text-center">
                <input role="checkbox" type="checkbox" class="cbox" data-ng-model="designation.select">
               </td>
           <td>{{designation.entityName}}</td>
             <td>{{designation.invoiceNo}}</td>
               <td>{{designation.invBcAmt}}</td>
                 <td>{{designation.paidTcAmount}}</td>
                 <td>{{designation.balanceAmount}}</td>
                   <td>{{designation.dueDate}}</td>
                    <td>{{designation.receivedStatus}}</td>
          </tr>
         </tbody>
        </table>
         <div class="form-actions">
         <div class="row">
          <div class="col-lg-12 col-md-12">
            <button class="btn btn-primary" type="button" data-ng-click="sendMail()">Send Mail</button>
          </div>
          </div>
          <br>
           <div class="row">
          <div class="col-lg-12 col-md-12">
           <label class="col-md-7 control-label" style="margin-left: 21%;"> <span style="color: red;">*</span> The above sales invoices are pending morethan 30 days from the due date. 
             </label>
          </div>
          </div>
           <br>
         </div>
     
        
        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
