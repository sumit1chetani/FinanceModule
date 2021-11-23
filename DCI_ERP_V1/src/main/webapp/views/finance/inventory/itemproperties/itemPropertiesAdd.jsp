  <div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>
			  <div class="panel-body">
      <!-- <h2 ng-if="!isEdit">
       Add Unit of Measurement
      </h2>
       <h2 ng-if="isEdit">
       Edit Unit of Measurement
      </h2> -->
     </header>
     <br>
     <div role="content">
      <div class="widget-body">
          <form name="itemPropertiesAddForm" class="form-horizontal" novalidate method="post">
        		<div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
         	 
         	 
         	 	<fieldset>
				<div class="form-group">
				<label class="col-md-6 control-label">
				Property Type<span style = color:red">*</span></label>
				<div class="col-md-6">						   												   						
				<select class="form-control journalVoucher-textBox" validation="required" friendly-name="Property Type"
		          ng-model="itemPropertiesObj.propertyTypeId" data-ng-options="propertyValues.propertyTypeId as propertyValues.propertTypeName for propertyValues in propertyList"
	              name="propertyTypeId" id="propertyTypeId" ng-change="getDefaultValues(itemPropertiesObj.propertyTypeId)">
	            <option value="">Select</option>
				</select>						   						
				</div>
				</div>			
	         </fieldset>
         	 </div>
         <div class="col-sm-12 col-md-10 col-lg-10">
         	 	<fieldset>
				<div class="form-group">
				<label class="col-md-6 control-label">Type</label>
				<div class="col-md-6">						   												   						
				<select class="form-control journalVoucher-textBox" validation="required" friendly-name="Type"
		          ng-model="itemPropertiesObj.typeId" data-ng-options="typeValues.typeId as typeValues.typeName for typeValues in typeList"
	              name="typeId" id="typeId">
	            <option value="">Select</option>
				</select>						   						
				</div>
				</div>			
	         </fieldset>
         	 </div>
         </div><br>
         <div class="col-sm-12 col-md-10 col-lg-10">
         	<br> <div class="col-sm-12 col-md-6">
			 <div class="form-group"  id="nameProp" style = "display: none">
			  <label class="col-md-7 control-label">Property Name
				<span style = "color:red";></span></label>
				<div class="col-md-7">
				<input type="text" class="form-control input-sm" 
					name="propName" id="propName"
					data-ng-model="itemPropertiesObj.propName">
				</div>
			 </div>
			</div>
			<div class="col-sm-12 col-md-6">
			<div class="form-group"  id="lengthProp" style = "display: none">
			  <label class="col-md-6 control-label">
Length				</label>
				<div class="col-md-6">
				<input type="text" class="form-control input-sm" 
				name="propLength"
				data-ng-model="itemPropertiesObj.propLength" ng-pattern-restrict="{{numExp}}">
				</div>
		   </div>
			</div>
			
			<div class="col-sm-12 col-md-6">
			<div class="form-group"  id="valProp" style = "display: none">
			  <label class="col-md-6 control-label">
				<spring:message code="label.val"></spring:message>	  					
				</label>
				<div class="col-md-6">
				<textarea class="form-control input-sm" id="txtId" style="resize: none;width: 150px;"
            name="<spring:message code="label.val"></spring:message>"
            data-ng-model="itemPropertiesObj.propValue"></textarea>            
				</div><label class="col-md-6 control-label"></label>
		   </div>
			</div>
        </div>
        <div class="col-sm-12 col-md-10 col-lg-10" >        	
		 <div class="col-sm-12 col-md-6" id="defaultProp" style = "display: none">	
		 <div class="form-group"  >
		 <label class="col-md-6 control-label">
				Default Value						  					
				</label>
				<div class="col-md-6">
		 			<input type="text" class="form-control input-sm" name="Name" data-ng-model="itemPropertiesObj.defaultsValue">
  				</div>
  		</div>
  		</div>
		 
		 <div class="col-sm-12 col-md-6">	
		 <div class="form-group" id="defaultDropDownProp" style = "display: none">
            	<label class="col-md-6 control-label">
Default Value				</label>
				<div class="col-md-6">
		 			<input type="text" class="form-control input-sm" name="Name" data-ng-model="itemPropertiesObj.defaultsValue">
  				</div>
           </div>
		 </div>
		 <div class="col-sm-12 col-md-6" >
			 <div class="form-group" id= "mandiVal" style = "display: none">
            <label class="col-md-6 control-label"> Is Mandatory <span style= "color:red";>*</span>
            </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label> <input type="checkbox"
               class="checkbox style-0"
               data-ng-model="itemPropertiesObj.manditory"
               data-ng-true-value="'Y'" data-ng-false-value="'N'">
               <span></span>              </label>
             </div>
            </div>
           </div>
	    </div> 
     </div>
         
         <div class="col-sm-12 col-md-10 col-lg-10" id="numberDisplay" style = "display: none">  
           <div class="col-sm-12 col-md-6">     
         <div class="form-group"  id="nameNumProp" style = "display: none">
			 <label class="col-md-6 control-label"> Name<span style= "color:red";>*</span>				  					
			 </label>
				<div class="col-md-6">
				 <input type="text" class="form-control input-sm" 
					name="propName" id="propName" data-ng-model="itemPropertiesObj.propName">
				</div>
		</div>
		</div>
		
		<div class="col-sm-12 col-md-6">
			<div class="form-group"  id="decimalvalProp" style = "display: none">
			  <label class="col-md-6 control-label"> Length					  					
			  </label>
				<div class="col-md-6">
				<input type="text" class="form-control input-sm" 
				name="Name" data-ng-model="itemPropertiesObj.propLength">				
				</div>
		    </div>
		</div>
		</div>
		<div class="col-sm-12 col-md-10 col-lg-10" id="numberDisplays" style = "display: none">
		<div class="col-sm-12 col-md-6">
			<div class="form-group"  id="decimalvalProps" style = "display: none">
			  <label class="col-md-6 control-label"> Decimal Value	<span style= "color:red";>*</span>				  					
			  </label>
				<div class="col-md-6">
				 <input type="text" class="form-control input-sm" name="Name" 
				 data-ng-model="itemPropertiesObj.defaultsValue">				
				</div>
		    </div>
		</div>
		<div class="col-sm-12 col-md-6">
			<div class="form-group"  id="decimalvalPropes" style = "display: none">
			  	<label class="col-md-6 control-label">
Default Value				</label>
				<div class="col-md-6">
		 			<input type="text" class="form-control input-sm" name="Name" data-ng-model="itemPropertiesObj.defaultsValue">
  				</div>
		    </div>
		</div>
        </div>
        
        <div class="col-sm-12 col-md-10 col-lg-10" id="dateDisplay" style = "display: none">
      <div class="form-group"  id="nameProps" style = "display: none">
		<label class="col-md-6 control-label"> Property Name				  					
		</label>
			<div class="col-md-6">
			 <input type="text" class="form-control input-sm" name="propName" id="propName" style=" width: 135px;" 
			 data-ng-model="itemPropertiesObj.propName">
			</div>
	  </div>
			 
	   <div class="col-sm-12 col-md-6" style=" margin-left: 170px; ">
	    	<label class="col-md-6 control-label">Default Value
				</label>
				<div class="col-md-6">
		 			<input type="text" class="form-control input-sm" name="Name" data-ng-model="itemPropertiesObj.defaultsValue">
  				</div>
		</div>			 	   
	  </div>
        
        <div class="col-sm-12 col-md-10 col-lg-10" id="dateDefDisplay" style = "display: none">
	    <div class="col-sm-12 col-md-6" style=" margin-left: 172px; ">
		<div class="form-group" id= "mandiVal">
          <label class="col-md-6 control-label"> Is Mandatory
          </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label> <input type="checkbox" class="checkbox style-0"
               data-ng-model="itemPropertiesObj.manditory" data-ng-true-value="'Y'" data-ng-false-value="'N'">
               <span></span>  </label>
             </div>
            </div>
           </div>
	    </div>			 
       </div>
       </div>
        </div>         
			<div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="validate(itemPropertiesAddForm,itemPropertiesObj)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>Save
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="validate(itemPropertiesAddForm,itemPropertiesObj)"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>Update
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(itemPropertiesAddForm)">
            <i class="fa fa-undo"></i>Reset
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancel()">
            <i class="fa fa-close"></i>Cancel
           </button>
          </div>
         </div>
        </div>
       </form>
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