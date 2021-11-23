<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="bg-light lter b-b wrapper-md">
	<div class="row">
		<div class="col-sm-12 col-xs-12 col-md-12">
			<ol class="breadcrumb padding-left-0">
				<li><a> Finance </a></li>
				<li><a>Invoice</a></li>
				<li><a>Split View</a></li>
			</ol>
		</div>
	</div>
</div>
<div class="wrapper-md">
	<div class="panel panel-default">
		<div class="panel-heading font-bold">Split Invoice </div>
		<div class="form-body form-horizontal">
				<div class="row m-t-sm">
	   <div class="col-sm-12 col-md-4 col-lg-4 ">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label  vessel-text">Customer</label>
            <div class="col-md-6">
	            <selectivity list="customerList" property="splitInvoiceHeader.customerId" id="customer_id" ></selectivity>
            </div>
           </div>
           
           <div class="form-group">
            <label class="col-md-5 control-label">Invoice</label>
            <div class="col-md-6">
             <selectivity list="invoiceList" property="splitInvoiceHeader.invoiceNo" id="invoice_id" ></selectivity>
            </div>
           </div>
           <div class="form-group ">
            <label class="col-md-5 control-label">Pod</label>
             <div class="col-md-6">
			   <selectivity list="portList" property="splitInvoiceHeader.pod" id="pod_id"></selectivity>
			</div>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-4 col-lg-4 ">
          <fieldset>
          <div class="form-group ">
            <label class="col-md-5 control-label">Surcharge</label>
             <div class="col-md-6">
			   <selectivity list="surchargeList" property="splitInvoiceHeader.surcharge" id="surcharge_id"></selectivity>
			</div>
           </div>
            <div class="form-group">
            <label class="col-md-5 control-label">Container</label>
            <div class="col-md-6 inputGroupContainer">
           <selectivity list="containerList" property="splitInvoiceHeader.container" id="container_id"></selectivity>
            </div>
            </div>
            <div class="form-group ">
            <label class="col-md-5 control-label">Split Invoice No</label>
             <div class="col-md-6">
			   <selectivity list="spliInvoiceList" property="splitInvoiceHeader.splitInvoiceNo" id="invoice_no_id"></selectivity>
			</div>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-4 col-lg-4 ">
         <div class="form-group">
            <label class="col-md-5 control-label">Voyage</label>
            <div class="col-md-6">
             <selectivity list="voyageList" property="splitInvoiceHeader.voyageId" id="voyage_id"></selectivity>
            </div>
           </div>
           <div class="form-group ">
            <label class="col-md-5 control-label">Pol</label>
             <div class="col-md-6">
			   <selectivity list="portList" property="splitInvoiceHeader.pol" id="pol_id"></selectivity>
			</div>
           </div>
           <div class="form-group ">
            <label class="col-md-5 control-label">Group By</label>
             <div class="col-md-6">
			   <label class="i-checks m-b-none checkbox">
	        <input type="checkbox"  data-ng-model="splitInvoiceHeader.groupBy"  class="ng-pristine ng-untouched ng-valid"><i></i>
	         </label>
			</div>
           </div>
         </div>
</div>
			</div>
			<div align="center">
				<div class="row panel-body">
					<div class="col-md-12 ">
					 <security:authorize access="hasRole('${form_code}_${add}')">
						<button class="btn btn-primary" type="button"
							data-ng-click="searchInvoiceDtl();">
							<i class="glyphicon glyphicon-floppy-disk"></i> Generate
						</button>
						</security:authorize>
						<button class="btn btn-danger" type="button"
							data-ng-click="reset();">
							<i class="fa fa-undo"></i> Reset
						</button>
						 <security:authorize access="hasRole('${form_code}_${view}')">
						<button class="btn btn-success" type="button"
							data-ng-click="searchInvoiceDtl();">
							<i class="fa "></i> View
						</button>
						</security:authorize>
					</div>
				</div>
			</div>
		</div>
	
</div>
