
<footer class="panel-footer panel-footer-list" style="background-color: #e2e2e2;">
<div class="row">
 <div class="col-sm-12 col-md-1 col-md-offset-4 padding-right-0">
  <select class="pagination-bottom-select input-sm form-control inline v-middle" ng-model="itemsByPage">
   <option ng-repeat="pageCounter in pageCounters" value="{{pageCounter}}">{{pageCounter}}</option>
  </select>
 </div>
 <div class="col-sm-12 col-md-7">
  <div st-items-by-page="itemsByPage" st-pagination="" st-template="/views/templates/pagination.custom.jsp"></div>
 </div>
</div>
</footer>