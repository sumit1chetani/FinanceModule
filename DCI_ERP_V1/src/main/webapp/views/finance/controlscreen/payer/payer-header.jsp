<form class="" name="slotHeader" role="form">
         <div class="row m-t-sm">
   <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label  vessel-text">Payer Name</label>
            <div class="col-md-7">
	            <div id="customer_name" class="selectivity-input example-input selectivity-slot customer_name">
				<div class="selectivity-single-select">
				<input type="text" class="selectivity-single-select-input">
				<div class="selectivity-single-result-container">
				<div class="selectivity-placeholder"></div>
				</div><i class="fa fa-sort-desc selectivity-caret"></i>
				</div>
				</div>
            </div>

           </div>



          </fieldset>
         </div>
             <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
 <div class="form-group">
            <label class="col-md-5 control-label">Payer Area</label>
            <div class="col-md-7">
              <div id="customer_area" class="selectivity-input example-input selectivity-slot customer_area">
				<div class="selectivity-single-select">
				<input type="text" class="selectivity-single-select-input">
				<div class="selectivity-single-result-container">
				<div class="selectivity-placeholder"></div>
				</div><i class="fa fa-sort-desc selectivity-caret"></i>
				</div>
				</div>
            </div>
           </div>
           </fieldset></div>
         <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
            <div class="form-group">
            <label class="col-md-5 control-label">Payer ShortName</label>
            <div class="col-md-7">
	            <div id="customer_shortName" class="selectivity-input example-input selectivity-slot customer_shortName">
				<div class="selectivity-single-select">
				<input type="text" class="selectivity-single-select-input">
				<div class="selectivity-single-result-container">
				<div class="selectivity-placeholder"></div>
				</div><i class="fa fa-sort-desc selectivity-caret"></i>
				</div>
				</div>
            </div>
           </div>

          </fieldset>
         </div>
   <div class="col-sm-12 col-sm-offset-4 m-b-sm">

	   <button type="button" class="btn btn-primary btn-sm">Search</button>
	   <button type="button" class="btn btn-primary btn-sm" data-ng-click="resetAll()">Reset</button>

	   <button id="button1" type="button" class="btn btn-primary btn-sm" ng-click="">Payer Consolidated</button>
	   <button type="button" class="btn btn-primary btn-sm" ng-click="updateMlo()">Export To Excel Sun</button>

	   <button type="button" class="btn btn-primary btn-sm">Export  Payer Code To Excel </button>

   </div>

</div>

</form>