<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
 <div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>
	

   
		</div>
  
		<div class="panel-body">
			<form class="form-horizontal" name="AssetMasterForm" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						<div class="form-group">
								<label class="col-md-4 control-label">CN Request No</label>
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.cnReqNo"></label>
								</div>
							</div>  
							<div class="form-group">
								<label class="col-md-4 control-label">Invoice No</label>
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.invoiceNo"></label>
								</div>
							</div>          
							<div class="form-group">
								<label class="col-md-4 control-label">Date Raised</label>
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.dateRaised"></label>
								</div>
							</div>	                               		 			
           					<div class="form-group">
       							<label class="col-md-4 control-label">Customer</label>
		      				    <div class="col-md-5">
		      				    <label class="control-label" ng-bind="cnReq.mlo"></label>
								</div>
							</div>  
						 								 	                 
							<div class="form-group">
								<label class="col-md-4 control-label">Invoice Date Issued</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.invoiceDate"></label>
								</div>
							</div> 
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Quotation No</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.quoNo"></label>
								</div>
							</div>   
							<div class="form-group">
								<label class="col-md-4 control-label">Revised Quotation No</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.revQuo"></label>
								</div>
							</div>     
							<div class="form-group">
								<label class="col-md-4 control-label">Rebilled Invoice No</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.rebInvNo"></label>
								</div>
							</div>  
							<div class="form-group">
								<label class="col-md-4 control-label">Service</label>	
								<div clasCNRequestApproves="col-md-5">
								<label class="control-label" ng-bind="cnReq.service"></label>
								</div>
							</div>  
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.vessel"></label>
								</div>
							</div>  
							<div class="form-group">
								<label class="col-md-4 control-label">Voyage</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.voyage"></label>
								</div>
							</div>  -->
							
								<div class="form-group">
								<label class="col-md-4 control-label">LOL</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.pol"></label>
								</div>
							</div> 
							<div class="form-group">
								<label class="col-md-4 control-label">LOD</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.pod"></label>
								</div>
							</div> 
									<div class="form-group" >
							<label class="col-md-4 control-label">Attached Files</label>
								<div class="col-md-7">
								<div class="" ng-repeat="(tIndex, filelist) in cnReq.files">
								<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.cnno!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											</div>
											
											<div ng-if="filelist.cnno==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
											</div>
							</div>
							</div>
							</div>
						</fieldset>
					</div>    
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>     
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Shipment Date</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.shipDate"></label>
								</div>
							</div>  -->
							<div class="form-group">
								<label class="col-md-4 control-label">CN Type</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.cnType1"></label>
								</div>
							</div> 
							<div class="form-group">
								<label class="col-md-4 control-label">CN Amount</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.cnamount"></label>
								</div>
							</div> 
						
							<div class="form-group">
								<label class="col-md-4 control-label">Category Of CN</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.catCN1"></label>
								</div>
							</div> 
							<div class="form-group">
								<label class="col-md-4 control-label">Detailed Explanation For The CN Request</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.expCN"></label>
								</div>
							</div> 
						<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Pricing Comments</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.priCom"></label>
								</div>
							</div>  -->
							<div class="form-group">
								<label class="col-md-4 control-label">Requesting Office</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.reqFee"></label>
								</div>
							</div> 
							<div class="form-group">
								<label class="col-md-4 control-label">Department</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.department"></label>
								</div>
							</div> 
							<div class="form-group">
								<label class="col-md-4 control-label">Person</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.person"></label>
								</div>
							</div> 
						<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Approval</label>	
								<div class="col-md-5">
								<label class="control-label" ng-bind="cnReq.approval"></label>
								</div>
							</div>   -->                     
						</fieldset>
					</div>
				</div>
						  <div class="table-responsive clear">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <th colspan=1 class="width_1"></th>
            <th colspan=1 class="width_13 text-center">Account Head<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_10 text-center">Narration<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_10 text-center">TC Amt<span style="color:red;"> *</span></th>
            <th colspan=1 class=" width_10 text-center">BC Amt({{companyCurrency}})<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_1"></th>
          </tr>
        </thead>
        <tbody ng-repeat="(trIndex, row) in cnReq.credittables" ng-controller="cnRequesttablectrl">
        <tr>
	            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<selectivity list="crdtlAcctHeadList" property="row.crdtlAccountHead" id="accountHeadCode{{trIndex}}" object="accHead"
		              		ng-model="row.crdtlAccountHead" name ="accountHeadCode{{trIndex}}" validation="required" disabled="true"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "creditNoteForm"></selectivity>
	        			</div>
	        		</div>
	        	</td>
	         
	          	<td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.narration" disabled
	         	  			name ="narration{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
	              		</div>
	              	</div>
	            </td>
	            <td>
		           	<div class="row">
		           		<div class="col-xs-12">
		        	  	<input type="text" class="form-control input-sm text-right" name="tcamount" data-ng-model="row.tcamount" 
		        	  	ng-keyup="bcamountCalculation(row.tcamount,trIndex,row)"  disabled
						name ="tcAmount{{trIndex}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required" friendly-name="{{ 'Row' + $index + '(TC Amount)'}}"  />
		             	</div>
		            </div>
	            </td>
	            <td>
	            	<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm text-right" data-ng-model="row.bcamount"
	         	  			step="0.01" ng-blur="tcamountCalculation(row.bcamount,trIndex,row)" disabled
							name ="bcamount{{trIndex}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"  />
	              		</div>
	              	</div>
	            </td>
	            
     		</tr>     		
        </tbody>
        </table>
        </div>
				<br>   
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">      
							<button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i>Cancel
							</button>      
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
      
