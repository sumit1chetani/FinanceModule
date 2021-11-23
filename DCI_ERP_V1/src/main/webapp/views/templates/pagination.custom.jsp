<div class="row">
 <div class="col-sm-12 col-md-6">
  <ul class="pagination pagination-bottom">
   <li class="footable-page-arrow" style="margin-left: 7px;float: left; margin-left: 5px;">
 
    <a data-page="first" ng-click="selectPage(1)" ng-class="{'ui-state-disabled' : currentPage==1}">
     <i class="fa fa-fast-backward text-info"></i>
    </a>
   </li>
   <li class="footable-page-arrow" >
    <a data-page="prev" ng-click="selectPage(currentPage - 1)" ng-class="{'ui-state-disabled' : currentPage==1}">
     <i class="fa fa-backward text-info"></i>
    </a>
   </li>
   <li class="footable-page active">
    <input class="pagination-bottom-count" type="number" min="1" max="{{numPages}}" class="" ng-model="currentPage"
     ng-change="selectPage(currentPage)">
   </li>
   <li class="footable-page-arrow">
    <a data-page="next" ng-click="selectPage(currentPage + 1)" ng-class="{'ui-state-disabled' : currentPage==numPages}">
     <i class="fa fa-forward text-info"></i>
    </a>
   </li>
   <li class="footable-page-arrow">
    <a data-page="last" ng-click="selectPage(numPages);getTranslationList();"
     ng-class="{'ui-state-disabled' : currentPage==numPages}">
     <i class="fa fa-fast-forward text-info"></i>
    </a>
   </li>
  </ul>
 </div>
 <div class="col-sm-12 col-md-6 text-right pagination-count-label">
  <small class="inline m-t-sm m-b-sm"> Showing page {{currentPage}} of {{numPages}} </small>
 </div>
</div>