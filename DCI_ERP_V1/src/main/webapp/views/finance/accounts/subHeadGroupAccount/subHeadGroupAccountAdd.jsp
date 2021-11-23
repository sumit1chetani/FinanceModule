<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="subGroupAccountForm">
				<div class="row">
				         <div class="col-sm-12 col-md-10 col-lg-10">
				          <div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-4 control-label"> Sub Group code</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="subGroupData.subGroupCode" readonly>
								</div>
							</div>
							<div class="form-group">
							 <!--   <label class="col-md-4 control-label">Group Head Code<span style="color: red;">*</span> </label> -->
							   <label class="col-md-4 control-label">Group Master<span style="color: red;">*</span> </label>
						       <div class="col-md-7 inputGroupContainer">
								 <selectivity list="grpHeadTypeList" property="subGroupData.grpHeadCode" id="txtGrpHeadCode"
									 ng-model="subGroupData.grpHeadCode" name="grpHead" form-name ="subGroupAccountForm"
				   							validation="required" friendly-name="Group Head Code"></selectivity>
							   </div>
						   	</div>
						  	<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Type</label>
								<div class="col-md-7">
									<select class="form-control input-sm" name="type" ng-model="subGroupData.sgType" required>
						              <option value="select">Select</option>
						              <option value="B">Business Associate</option>
						              <option value="G">General</option>
						              <option value="Q">Quantity Related</option>
						              <option value="E">Employee Related</option>
						            </select>
								</div>
							</div> -->
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="form-group">
								<label class="col-md-4 control-label"> <!-- Sub Head Name --> Group Head
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="Group Head Name" id="subGroupName"
										ng-model="subGroupData.subGroupName" validation="required" friendly-name="Sub Group Name" maxlength="50">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> <!-- Sub -->Group Head Desc <!-- <span style="color: red;">*</span> -->
								</label>
								<div class="col-md-7">
									<textarea rows="2" cols="60" name="Description" id="subGroupDesc" validation="optional" friendly-name="Sub Group Desc"
										ng-model="subGroupData.subGroupDesc" class="resize-none padding-top-5 padding-left-10" maxlength="200"></textarea>
								</div>
							</div>
						</div>
				         </div>
				        </div>
				        <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">
				    			<button class="btn btn-success" type="button" ng-click="submit(subGroupAccountForm,subGroupData)"
									ng-if="!isEdit" class="btn btn-success">
									<i class="fa fa-save"></i> Save
								</button>
								<button class="btn btn-success" type="button" ng-click="submit(subGroupAccountForm,subGroupData)"
									ng-if="isEdit" type="submit">
									<i class="fa fa-save"></i> Update
								</button>
								<button class="btn btn-danger" type="reset"
									class="btn btn-success" ng-click="cancel()">
									<i class="fa fa-close"></i> Cancel
								</button>
				          </div>
				         </div>
				        </div>
				       </form>
				      </div>
				      <!-- end widget content -->
				     </div>
			    </div>
   			</article>
   		</div>
 	</section>
</div>