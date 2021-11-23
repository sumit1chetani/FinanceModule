<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">  
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form name="jvAgreementForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
    <div class="col-lg-12 col-sm-12 col-md-12">
    	<div class="col-lg-6 col-sm-6 col-md-6">
    		<div class="form-group">
		        <label class="col-md-3 control-label padding-right-0">Type of JV</label>
		        <div class="col-md-9 padding-left-30">
					<label class="radio radio-inline line-height-30 i-checks">
						<input type="radio" class="style-0" name="jvtypesCRP" checked="checked" ng-model="jvAgreementModelData.jvTypes" value="CRP" />
						<i></i>Cost & Revenue Pooling</label>
					<label class="radio radio-inline line-height-30 i-checks">
						<input type="radio" class="style-0" name="jvTypesS" ng_model="jvAgreementModelData.jvTypes" value="S" />
						<i></i>Swap</label>
					<label class="radio radio-inline line-height-30 i-checks">
						<input type="radio"  class="style-0" name="jvTypesRVC" ng_model="jvAgreementModelData.jvTypes" value="RVC" />
						<i></i>Share of RVC</label>
				</div>
	     	</div>
   		</div>
    </div>
     <div class="col-lg-12 col-sm-12 col-md-12">
	     <div class="col-sm-4 col-lg-4 col-md-4">	     	
	     	<div class="form-group ">
		        <label class="col-md-5 control-label padding-left-5"> Name of the JV Partner<span style="color:red;"> *</span></label>
		        <div class="col-md-7">		      
			        <!-- <select class="form-control input-sm" id="txtJVPartner" name="JV Partner Name" ng-model="jvAgreementModelData.jvPartner" 
			        ng-options="jvp.jvPartnerShortName as jvp.jvPartner for jvp in jvPartnerList" ng-change="createPercentOfShareForJVPartner(jvAgreementModelData.jvPartner)">
			          	<option value="" selected="selected">--Select--</option>
			        </select>  -->			        
					 <select id="txtJVPartner" multiple="multiple" name="multiselect[]" ng-model="jvAgreementModelData.jvPartner"
					 ng-options="option.name for option in jvPartnerList" data-dropdownmultiselect>    
					   <option data-ng-repeat="option in jvPartnerList" value="{{getOptionId(option)}}" 
					   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.name}}"></option>
					</select>
			        <!-- <div class="" ng-dropdown-multiselect options="jvPartnerList" selected-model="jvAgreementModelData.jvPartner" 
			        checkboxes="false"  events="{ onItemSelect: createPercentOfShareForJVPartner(jvAgreementModelData.jvPartner)}" extra-settings="jvPartnerSearch"></div> -->      			       
		        </div>
	       	</div>
	      	 
	       	<div class="form-group">
		        <label class="col-md-5 control-label padding-left-5">Commencement Date<span style="color:red;"> *</span></label>
		        <div class="col-md-7">		         
		            <div class="input-group input-append date" id="commencementDate">
			          <input type="text" class="form-control input-sm" name="Commencement Date" id="txtCommencementDate" 
			          ng-model="jvAgreementModelData.commencementDate" placeholder='dd/mm/yyyy' />
			          <span class="input-group-addon add-on">
			           <span class="glyphicon glyphicon-calendar"></span>
			          </span>
			        </div>
		        </div>
	     	</div>
	       
	     
		    
	    </div>
	    <div class="col-sm-4 col-lg-4 col-md-4">
	    	<div class="form-group ">
		        <label class="col-md-5 control-label"> Vessels in JV<span style="color:red;"> *</span></label>
		        <div class="col-md-7">		      
			        <!-- <select class="form-control input-sm" id="txtJVVessel" name="JV Vessel" ng-model="jvAgreementModelData.jvVessel" 
			        ng-options="ves.vesselCode as ves.vesselName for ves in vesselList" ng-change="fetchVoyageList(jvAgreementModelData.jvVessel);">
			          	<option value="" selected="selected">--Select--</option>
			        </select> -->      
			        <select id="txtJVVessel" multiple="multiple"  name="JV Vessel" ng-model="jvAgreementModelData.jvVessel"
					 ng-options="option.vesselName for option in vesselList" data-dropdownmultiselect>    
					   <option data-ng-repeat="option in vesselList" value="{{getVesselOptionId(option)}}" 
					   ng-selected="isVesselOptionSelected(option)" data-ng-bind-template="{{option.vesselName}}"></option>
					</select> 			       
		        </div>
	       	</div>
	       
	     	<div class="form-group">
		        <label class="col-md-5 control-label">Completion Date<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		        	<div class="input-group input-append date" id="completionDate">
			          <input type="text" class="form-control input-sm" name="Completion Date" id="txtCompletionDate" 
			          ng-model="jvAgreementModelData.completionDate" placeholder='dd/mm/yyyy' />
			          <span class="input-group-addon add-on">
			           <span class="glyphicon glyphicon-calendar"></span>
			          </span>
			        </div>
		        </div>
	     	</div>
	     	
	    </div>
	    <div class="col-sm-4 col-lg-4 col-md-4">	
	    	<div class="form-group">
		        <label class="col-md-5 control-label"> Voyage<span style="color:red;"> *</span></label>
		        <div class="col-md-7">		      
		        	<select class="form-control input-sm" id="txtVoyage" multiple="multiple"  name="Voyage" ng-model="jvAgreementModelData.voyage"
					 ng-options="option.text for option in voyageList" data-dropdownmultiselect>    
					   <option data-ng-repeat="option in voyageList" value="{{getVoyageOptionId(option)}}" 
					   ng-selected="isVoyageOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
					</select> 		
			        <!-- <select class="form-control input-sm" id="txtVoyage" name="Voyage" ng-model="jvAgreementModelData.voyage" 
			        ng-options="voy.id as voy.text for voy in voyageList">
			          	<option value="" selected="selected">--Select--</option>
			        </select>        -->			       
		        </div>
	       	</div>
	       	<div class="form-group">
		        <label class="col-md-5 control-label">Remarks<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		        	<textarea id="jvRemarks" class="form-control input-sm" data-ng-model="jvAgreementModelData.jvRemarks"></textarea>
		        </div>
		    </div>
	    </div>
    </div>
     <div class="col-lg-12 col-sm-12 col-md-12">
   		
   		<div class="col-lg-6 col-sm-6 col-md-6">
  			<div class="form-group">
		        <label class="col-md-4 control-label">Percentage Of Sharing</label>
		        <div class="col-md-8" id="shareOfJVCodeDiv">
		        	<!--dynamic field -->
		        </div>
		    </div>		   
   		</div>
     </div>
     <div class="col-lg-12 col-sm-12 col-md-12">
     	<div class="form-group">
     		<label class="col-md-1 control-label font-bold ">ALLOCATION</label>
     	</div>
     </div>
   </div> 
   <div class="row book-widget-row">
	   <div class="col-lg-12 col-sm-12 col-md-12">
	    <div class="table-responsive">
	      <table class="table table-striped b-t b-light">
	        <thead>
	          <tr>
	            <th colspan=1 class="width_1"></th>
	            <th colspan=1 class="width_13 text-center">From Port</th>
	            <th colspan=1 class="width_13 text-center">To Port</th>
	            <th colspan=1 class="width_10 text-center">Teus Allocation</th>
	            <th colspan=1 class="width_10 text-center">Weight Allocation</th>
	            <th colspan=1 class=" width_10 text-center">Leg Selection</th>
	              
	          </tr>
	        </thead>
	        <tbody ng-repeat="(trIndex, row) in jvAgreementModelData.jvagreetables">
	        	<tr>
		            <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
		            <td class="width_13">
		            	<div class="row">
		            		
		            			<div class="col-xs-12">
				            		<select class="form-control input-sm" name="fromPortCode" ng-model="row.fromPort" 
				            		data-ng-options="ac.portCode as ac.portDesc for ac in fromPortList">
				               			<option value="" selected="selected">Select</option>
				              		</select>
				              	</div>
		        			
		        		</div>
		        	</td>
			        <td class="width_13"> 
			        	<div class="row">
		            		
		            			<div class="col-xs-12">
			            			<select class="form-control input-sm" name="toPortCode" ng-model="row.toPort" 
				            		data-ng-options="ac.portCode as ac.portDesc for ac in toPortList">
				               			<option value="" selected="selected">Select</option>
				              		</select>
			              		</div>       	     	
		        			
		        		</div>
		        	</td>
		          	<td class="width_10">
		          		<div class="row">
		            		 
		            			<div class="col-xs-12">
		            				<input type="text" class="form-control input-sm" name="Tues Allocation" ng-model="row.tuesAllocation"  />
		            			</div>
		              		
		              	</div>
		            </td>
		            <td class="width_10">
		            	<div class="row" >
		            		 
		            			<div class="col-xs-12">
		         	  				<input type="text" class="form-control input-sm" name="Weight Allocation" data-ng-model="row.weightAllocation" />
		         	  			</div>
		              		
		              	</div>
		            </td>
		            <td>
			           	<div class="row">
			           		<div class="col-xs-12"> 
			        	  		<select class="form-control input-sm" name="legSelection" ng-model="row.legSelection">
			               			<option value="select" selected="selected">Select</option>
			               			<option value="wb">West Bound(WB)</option>
									<option value="eb">East Bound(EB)</option>
									<option value="nb">North Bound(NB)</option>
									<option value="sb">South Bound(SB)</option>
			              		</select>
			             	</div>
			            </div>
		            </td>
		        </tr>
		        <tr>
		        	<td colspan="7">
		        		<div class="width_100" id="jvHandsonDiv">
		             		<div id="jvAgreeHandsonTbl{{trIndex}}" style="display: block"></div>
				        </div>
				    </td> 		             	
		       </tr>
	      	</tbody>
	      </table>      
	      <div class="padding-right-5" id="AddOrRmvebtn">
	           <button ng-click="addJVAgreeDtlRow(jvAgreementModelData.jvagreetables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
	            <i class="fa fa-plus"></i>
	           </button>
	           <button ng-click="removeJVAgreeDtlRow(jvAgreementModelData.jvagreetables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
	            <i class="fa  fa-trash-o"></i>
	           </button>
	      </div> <!-- /padding-right-5 - /AddOrRmvebtn -->	
		</div>    <!-- /table-responsive -->	 
		</div> <!-- /col-sm-12 -->
	</div>
    <div class="row book-widget-row">
     <div class="col-lg-12 col-sm-12 col-md-12">
	     <div class="col-sm-4 col-lg-4 col-md-4">	
	     	
	     </div>
	     <div class="col-sm-4 col-lg-4 col-md-4">	
	     	
	     </div>
	     <div class="col-sm-4 col-lg-4 col-md-4">	
	     	
	     </div>
	 </div>
	</div> <!-- /row - /book-widget-row -->
	<div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="submit(jvAgreementForm)" ng-if="!edit">
           <i class="fa fa-save"></i>
           Save
          </button>
          <button class="btn btn-success" type="button" ng-if="edit" ng-click="cancel()">
           <i class="fa fa-save"></i>
           Update
          </button>
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div> <!-- /row -->
   </form>
  </div>
 </div>
</div>