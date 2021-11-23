<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id">
    <div class="panel panel-default">
    <div class="form-body form-horizontal">
       <div class="row m-t-sm">
        
        <div class="col-sm-12 col-md-12 col-lg-12">
         <div class="col-sm-12 col-md-3 col-lg-3">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label  vessel-text">LPO No.</label>
            <div class="col-md-7">
             <selectivity list="reverseLpoList" property="reverseLpoNo" id="reverseLpoNo"></selectivity>
            </div>
           </div>
           
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-3 col-lg-3">
          <fieldset>
           <div class="form-group">
            <button class="btn btn-success" type="button" data-ng-click="reverseLpo(reverseLpoNo);">
            Reverse
            </button>
            	<button class="btn btn-primary" type="button"
					data-ng-click="copyLPO(reverseLpoNo);">
					Copy LPO
				</button>
           </div>
          </fieldset>    
          
         </div>
        </div>
       </div>
      </div> 
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
<!--        <th class="width_1"> -->
<!--        </th> -->
       <th class="sorting" st-sort="invoiceNo">LPO No</th>
       <th class="sorting" st-sort="date">LPO Date</th>
       <th class="sorting" st-sort="supplier">Supplier</th>
       <th class="sorting" st-sort="description">Description</th>
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPuInvHdrLstBean in displayedCollection">
<!--        <td class=""> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
        <td><span ng-if="objPuInvHdrLstBean.urIsView=='t'">
       <a ng-click="view(objPuInvHdrLstBean.lpoNo)">
   <span tooltip="{{objPuInvHdrLstBean.lpoNo}}" class="tool-tip-span font-blue">{{objPuInvHdrLstBean.lpoNo}}</span>
         </a></span>
         <span ng-if="objPuInvHdrLstBean.urIsView=='f'">
         <span tooltip="{{objPuInvHdrLstBean.lpoNo}}" class="tool-tip-span">{{objPuInvHdrLstBean.lpoNo}}</span>
         </span>
       </td>
       <td class="sorting ">{{objPuInvHdrLstBean.lpoDate}}</td>
       <td class="sorting ">{{objPuInvHdrLstBean.supplier}}</td>
       <td class="sorting ">{{objPuInvHdrLstBean.description}}</td>
       <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span ng-if="objPuInvHdrLstBean.urIsEdit=='t'">
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPuInvHdrLstBean.lpoNo,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="objPuInvHdrLstBean.urIsDelete=='t'">
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPuInvHdrLstBean.lpoNo,$index)"></i>
         </span>
        </security:authorize>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
  </div>
  </div>
 </div>
</div>