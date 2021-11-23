<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb inline-block padding-left-10">
    <li>
     <a>Finance</a>
    </li>
    <li>
     <a>Control Screen</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.controlscreen.documentinfo">Document Info</a>
    </li>
    <li>
     <a x-ui-sref="">View</a>
    </li>
   </ol>
  </div>
  <div class="wrapper-md">
   <div class="panel panel-default">
    <div class="panel-body">
     <form class="form-horizontal" name="documentInfoForm" role="form" >
     	<div class="row book-widget-row">
			<div class="col-md-4">
			     <fieldset>
			       <div class="form-group form-group-label-left">
			        	<label class="col-md-4 col-md-offset-1 control-label">Document Type</label>
				        <div class="col-md-7">
				         	<label class="col-md-7 control-label text-left">{{doumentInfoData.documentTypeCode}}</label>
				        </div>
			       </div>
			     </fieldset>
  			</div>
			  <div class="col-md-4">
			     <fieldset>
			       <div class="form-group form-group-label-left">
			        	<label class="col-md-4 col-md-offset-1 control-label">Max</label>
				        <div class="col-md-7">
				         	<label class="col-md-7 control-label text-left">{{doumentInfoData.max}}</label>
				        </div>
			       </div>
			     </fieldset>
			  </div>
			  <div class="col-md-4">
			     <fieldset>
			       <div class="form-group form-group-label-left">
			        	<label class="col-md-4 col-md-offset-1 control-label">Min</label>
				        <div class="col-md-7">
				         	<label class="col-md-7 control-label text-left">{{doumentInfoData.min}}</label>
				        </div>
			       </div>
			     </fieldset>
			  </div>
		  </div>
       </form>
     </div>
    </div>
   </div>
 </div>
</div>