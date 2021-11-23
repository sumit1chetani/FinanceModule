<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="bg-light lter b-b wrapper-md">
 <div class="row">
  <div class="col-sm-12 col-xs-12 col-md-12">
  <div class="panel panel-default panel-default-form">
      <%@include file="/views/templates/panel-header-form.jsp"%>
   <!-- <ol class="breadcrumb padding-left-0">
    <li><a> Finance </a></li>
    <li><a>Invoice</a></li>
    <li><a>Off Invoice</a></li>
   </ol> -->
  </div>
 </div>
</div>
<div class="wrapper-md">
 <div class="panel panel-default">
  <div class="panel-heading font-bold"><span style="color:white;" >Off Invoice Search</span></div>
  <div class="form-body form-horizontal">
   <div class="row m-t-sm">
    <div class="col-sm-12 col-md-4 col-lg-4 ">
     <fieldset>
      <div class="form-group">
       <label class="col-md-5 control-label  vessel-text">Vessel</label>
       <div class="col-md-6">
        <selectivity list="vesselList"
         property="invoiceViewHeader.vesselid" id="vessel_id"
         object="vesselObj"></selectivity>
       </div>
      </div>

      <div class="form-group">
       <label class="col-md-5 control-label">Customer</label>
       <div class="col-md-6">
        <selectivity list="customerList"
         property="invoiceViewHeader.mloCode" id="customer_id"></selectivity>
       </div>
      </div>
      <div class="form-group">
          <label for="inputPassword" class="control-label col-md-5">From Date 
          </label>
          <div class="col-md-6">
           <div class="input-group input-append date" id="tb_fromDate">
            <input type="text" class="form-control input-sm"
             placeholder="dd/mm/yyyy" ng-model="invoiceViewHeader.fromDate"
             name="fromDate" id="fromDate"> <span
             class="input-group-addon add-on"> <span
             class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
          </div>
         </div>
     </fieldset>
    </div>
    <div class="col-sm-12 col-md-4 col-lg-4 ">
     <fieldset>
      <div class="form-group hidden-group">
       <label class="col-md-5 control-label">Voyage</label>
       <div class="col-md-6">
        <selectivity list="voyageList"
         property="invoiceViewHeader.voyageCode" id="voyage_id"></selectivity>
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-5 control-label">Invoice</label>
       <div class="col-md-6 inputGroupContainer">
        <input type="text" data-ng-model="invoiceViewHeader.invoiceNo"
         class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
       </div>
      </div>
<div class="form-group">
          <label for="inputPassword" class="control-label col-md-5">To Date </label>
          <div class="col-md-6">
           <div class="input-group input-append date" id="tb_toDate">
            <input type="text" class="form-control input-sm"
             placeholder="dd/mm/yyyy" ng-model="invoiceViewHeader.toDate"
             name="toDate" id="toDate"> <span
             class="input-group-addon add-on"> <span
             class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
          </div>
         </div>
     </fieldset>
    </div>
    <div class="col-sm-12 col-md-4 col-lg-4 ">
     <div class="form-group">
      <label class="col-md-5 control-label">Quotation No</label>
      <div class="col-md-6">
       <input type="text" data-ng-model="invoiceViewHeader.quationNo"
        class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
      </div>
     </div>

    </div>
   </div>
  </div>
  <div align="center">
   <div class="row panel-body">
    <div class="col-md-12 ">
    <security:authorize access="hasRole('${form_code}_${search}')">
     <button class="btn btn-success" type="button"
      data-ng-click="searchInvoiceDtl();">
      <i class="fa fa-search"></i> Search
     </button>
</security:authorize>
<button class="btn btn-info" type="reset"
          class="btn btn-success" ng-click="formreset()">
          <i class="fa fa-undo"></i>Reset
         </button>
     <!-- <button class="btn btn-primary" ng-click="exportExcel()">
										<i class="fa fa-download"> Export Excel</i>
									</button>
     <button class="btn btn-primary" ng-click="exportReportExcel()">
										<i class="fa fa-download">Summary Report</i>
									</button> -->
    </div>
   </div>
  </div>
 </div><div class="row">
       <div class="col-xs-12">
 <div class="panel panel-default panel-default-list"
  st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
   <%-- <%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%> --%>
   <div class="col-md-4  p-l-0 p-r-0 pull-right">
          <input type="text" st-search=""
           class="form-control input-sm p-tb-14 bg-white rounded padder"
           placeholder="Search">
         </div>
  <!-- </div> -->
  <div class="panel-body float-left padding-0">
   <div class="table-responsive ">
    <table id="dt_basic"
     class="table table-striped table-bordered table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th  class="width_1"></th>
       <th  class="sorting width_10 text-center" st-sort="invoiceNo">Invoice No.</th>       
       <th  class="sorting width_10 text-center" st-sort="invoiceDate">Invoice  Date</th>
       <th  class="sorting width_14 text-center" st-sort="vessel">Vessel</th>
       <th  class="sorting width_10 text-center" st-sort="voyage">Voyage</th>   
      <th  class="sorting width_10 text-center" st-sort="voyage">BL No.</th>
       <th  class="sorting width_10 text-center" st-sort="voyage">Quotation No.</th>   
           <th  class="sorting width_10 text-center" st-sort="voyage">Customer</th>
       <th  class="sorting width_10 text-center" st-sort="voyage">Payer</th>     
      </tr>
     </thead>
     <tbody>
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
       ng-repeat="($index,objTranslationItem) in displayedCollection">
       
       <td></td>
       
       <td class="sorting width_10"  >
       <a href="#/invoice/offInvoiceView/{{objTranslationItem.invoiceNo}}" >
         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span font-blue">{{objTranslationItem.invoiceNo}}</span>
        </a>
        
       </td>
     <!--   <td ng-bind="objTranslationItem.blno"></td>
       <td ng-bind="objTranslationItem.quotationNo"></td> -->
       <td ng-bind="objTranslationItem.invoiceDate"></td>
       <td ng-bind="objTranslationItem.vessel"></td>
       <td ng-bind="objTranslationItem.voyage"></td>
       <td ng-bind="objTranslationItem.blno"></td>
       <td ng-bind="objTranslationItem.quotationNo"></td>
          <td ng-bind="objTranslationItem.mlo"></td>
       <td ng-bind="objTranslationItem.payerName"></td>
       <%-- <td><select ng-model="objTranslationItem.printList" id ="printSelect{{$index}}">
         <option value="both" >Both</option>
         <option value="usd">USD</option>
         <option value="local">Local</option>
       </select>
           &nbsp;&nbsp;
           <security:authorize access="hasRole('${form_code}_${send_mail}')">
           <span><i class="icon-envelope red" data-ng-click="clickInvoiceMail(objTranslationItem.invoiceNo,objTranslationItem.printList)" style="cursor: pointer; color: gray;"></i></span>
           </security:authorize>
           <security:authorize access="hasRole('${form_code}_${print}')"> 
           &nbsp;&nbsp;<span data-ng-click="clickInvoiceFunction(objTranslationItem.invoiceNo,objTranslationItem.printList)"
        id="{{objTranslationItem.invoiceNo}}"
        class=" glyphicon glyphicon-print "
        style="cursor: pointer; color: gray;"></span>
        </security:authorize>
        &nbsp;&nbsp;
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span> <i
         class="fa fa-trash-o text-danger-dker text"
         style="cursor: pointer;" data-ng-click="deleteInvoice(objTranslationItem.invoiceNo)"></i>
       </span>
       </security:authorize></td> --%>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
</div></div>
</div>
</div>

 <script type="text/ng-template" id="invoiceDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
 <button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
 <button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
  <script type="text/ng-template" id="invoiceMail">

<div class="modal-header"> Are you sure to send Email? </div>
<div class="row">
</div>
<div class="modal-footer">
 <button class="btn btn-info" type="button" ng-click="SendConfirm()">OK</button>
 <button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
 