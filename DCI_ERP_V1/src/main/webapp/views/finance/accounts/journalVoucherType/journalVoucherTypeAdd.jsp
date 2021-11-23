<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
			<%@include file="/views/templates/panel-header-form.jsp"%>
			  <div class="panel-body">
       <form class="form-horizontal" name="journalVoucherTypeAddForm" >
           <div class="row book-widget-row">
         <div class="col-sm-12 col-md-10 col-lg-10">
         					<fieldset>
						           <div class="form-group">
            <label class="col-md-5 control-label"> Name <span style = "color:red";></span></label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" 
              	name="jbTypename" 
              	data-ng-model="journalVoucherTypeAdd.jbTypename"
              	validation="required" friendly-name="Name">
            </div>
           </div>
<div class="form-group">
            <label class="col-md-5 control-label"> Description</label>
            <div class="col-md-7">
             	<input type="text" class="form-control input-sm" maxlength="50"
              		name="description" 
              		data-ng-model="journalVoucherTypeAdd.description"
              		>
            </div>
           </div>

					
						<div class="col-md-3"></div>
					</fieldset>
					
					</div>
					</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							           <button class="btn btn-success" type="button"
            data-ng-click="save(journalVoucherTypeAddForm)" data-ng-if="!journalVoucherTypeAdd.isEdit">
            <i class="fa fa-save"></i>
           Save
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(journalVoucherTypeAddForm);"
            data-ng-if="journalVoucherTypeAdd.isEdit == true">
            <i class="fa fa-save"></i>
Update           </button>
           <button class="btn btn-info" type="button" data-ng-if="!journalVoucherTypeAdd.isEdit"
            data-ng-click="reset()">
            <i class="fa fa-undo"></i>
Reset           </button>
           <button class="btn btn-info" type="button" data-ng-if="journalVoucherTypeAdd.isEdit==true"
            data-ng-click="resetUpdate()">
            <i class="fa fa-undo"></i>
Reset           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancel();">
            <i class="fa fa-close"></i>
           Cancel
           </button>
							
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
