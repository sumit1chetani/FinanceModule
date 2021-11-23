<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style type="text/css">
.main_container{
	overflow:auto;
}
</style>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="padding-top-10">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header>
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span><state-breadcrumbs></state-breadcrumbs></span>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="tdsform" novalidate method="post">
        <div class="row">
         <div class="col-sm-12">
		     <div class="col-sm-4">
		     	<div class="form-group" ng-if="edit">
			        <label class="col-md-5 control-label">Voucher No</label>
			        <div class="col-md-7">				       
				        <input type="text" class="form-control  bg-color-none b-none" id="voucherNo" name="Voucher No" ng-model="cashbankpaymentModelData.cbVoucherNo" ng-disabled="true" />				        
			        </div>
		       	</div>
		     <%--   <div class="form-group">
			        <label class="col-md-5 control-label"><spring:message
			              			code="label.company.name"></spring:message><span style="color:red;"> *</span></label>
			        <div class="col-md-7">				       
				        <selectivity list="companyList" property="tdscompanyData.companyName"  ng-model="tdscompanyData.companyName" 
								        id="companyCode" name="<spring:message
			              			code="label.company.name"></spring:message>" object="company" validation="required" 
								        friendly-name="	<spring:message
			              			code="label.company.name"></spring:message>" form-name = "tdsform"></selectivity>					        
			        </div>
		       	</div>  --%>
		      <!--  	<div class="col-sm-4">
		    
		     	<div class="form-group" id="cashaccountgroup">
			        <label class="col-md-5 control-label">Bank Acct</label>
			        <div class="col-md-7">
			           <selectivity list="cashAccountList" id="companyCode" name="Cash Acct Name" 
				        property="tdscompanyData.companyName" ng-model="tdscompanyData.companyName" 
				         friendly-name="Cash Acct" form-name = "tdsform" object="acctList"></selectivity>
			        </div>
			          
		     	</div> -->
		       	
		     	
		      <div class="form-group">
				        <label class="col-md-5 control-label">TDS NAME</label>
				        <div class="col-md-7">
					         <input type="text" class="form-control input-sm" name="tdsname" ng-model="tdscompanyData.tdsname"
				          	 id="tdsname"  friendly-name="tdsname" form-name = "tdsform" validation="required"/>
				        </div>
		    </div>
			       
		     	
		      	
		      <div class="form-group">
				        <label class="col-md-5 control-label">TDS DESC</label>
				        <div class="col-md-7">
					         <input type="text" class="form-control input-sm" name="tdsDesc" ng-model="tdscompanyData.tdsDesc"
				          	 id="tdsDesc"  friendly-name="tdsDesc" form-name = "tdsform"/>
				        </div>
		    </div>
		      
		     	
		     	 
		    </div>
		    
		    
		    
		    <div class="col-sm-4">
		    
		     	<div class="form-group" id="cashaccountgroup">
			        <label class="col-md-5 control-label">TDS CODE</label>
			        <div class="col-md-7">
			          <input type="text" class="form-control input-sm" name="tdscode" ng-model="tdscompanyData.tdscode"
				          	 id="tdscode"  friendly-name="tdscode" form-name = "tdsform"/>
			        </div>
			          
		     	</div>
			
		      
	
		    </div>
		    
		    
		    <div class="col-sm-4">
				        <label class="col-md-4 control-label">TDS TYPE</label>
				        <div class="col-md-7">
					         <input type="text" class="form-control input-sm" name="tdsType" ng-model="tdscompanyData.tdsType"
				          	 id="tdsType" friendly-name="Bank Company Name" form-name = "tdsform"/>
				        </div>
		    </div>
			   
													
		  <!--   <div class="col-sm-4">
		     <div class="form-group">
						<label class="col-md-4 control-label"> Active </label>
						<div class="col-md-3">
							<div class="checkbox">
								<label class="i-checks">
								<input type="checkbox"	 class="checkbox style-0" ng-true-value="'Yes'"	ng-false-value="'No'"	name="isActive"  
								ng-model="tdscompanyData.isActive" checked />
									<i></i> </label>
							</div>
						</div>
					</div>
		    
		      
		    </div> -->
	    </div> <!-- /col-sm-12 -->
	    <!-- /col-md-12 -->
	    
	    
		</div> <!-- /row -->
		 <div class="form-actions">
         <div class="row">
       	 <div class="col-md-12">
          		<button class="btn btn-success" type="button" ng-if="tdscompanyData.edit==false" ng-click="onSubmit(tdsform,tdscompanyData)" >
		          <i class="fa fa-save"></i>
		          Save
		         </button>
		         <button class="btn btn-success"  type="button" ng-if="tdscompanyData.edit==true" ng-click="onSubmit(tdsform,tdscompanyData)"><i class="fa fa-save"></i>
		         Update
		           </button>
		        <button class="btn btn-danger"  type="button" class="btn btn-success" ng-click="cancel()">
		        <i class="fa fa-close"></i>
		        Cancel
		       </button>
          </div>
          </div>
          </div>
       </form>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>  <!-- /standard-datatable-widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
