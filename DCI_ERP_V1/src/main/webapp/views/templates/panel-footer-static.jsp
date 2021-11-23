<footer class="panel-footer panel-footer-list" style="background-color: #e2e2e2;">		
<div class="row">
 <div class="col-sm-12 col-md-1 col-md-offset-4 padding-right-0">
  <select class="pagination-bottom-select input-sm form-control inline v-middle"  ng-model="itemsByPage" convert-to-number>
  <option value="5" >5</option>
   <option value="10" >10</option>
   <option value="15">15</option>
   <option value="25" >25</option>
   <option value="50">50</option>
   <option value="75">75</option>
   <option value="100">100</option>
   <option value="125">125</option>
   <option value="150">150</option>
  </select>
 </div>
 <div class="col-sm-12 col-md-7">
  <div st-items-by-page="itemsByPage" st-pagination="" st-template="/views/templates/pagination.custom.jsp"></div>
 </div>
</div>
</footer>
 