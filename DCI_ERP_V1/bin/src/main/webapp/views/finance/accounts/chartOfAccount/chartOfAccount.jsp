<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>

.icon-add{
display: inline-block !important;
text-align: left !important;
}
a
{
color: black;
}

a:hover, a:active {
    outline: none;
    text-decoration: none;
    /* color: #999999; */
    color: #999999;
}
#chartofaccounts-tree-left-bar{	
	background: #e2e2e2; /* Old browsers */
	/* IE9 SVG, needs conditional override of 'filter' to 'none' */
	background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iI2UyZTJlMiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUwJSIgc3RvcC1jb2xvcj0iI2RiZGJkYiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUxJSIgc3RvcC1jb2xvcj0iI2QxZDFkMSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNmZWZlZmUiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
	background: -moz-linear-gradient(top, #e2e2e2 0%, #dbdbdb 50%, #d1d1d1 51%, #fefefe 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#e2e2e2), color-stop(50%,#dbdbdb), color-stop(51%,#d1d1d1), color-stop(100%,#fefefe)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #e2e2e2 0%,#dbdbdb 50%,#d1d1d1 51%,#fefefe 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #e2e2e2 0%,#dbdbdb 50%,#d1d1d1 51%,#fefefe 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #e2e2e2 0%,#dbdbdb 50%,#d1d1d1 51%,#fefefe 100%); /* IE10+ */
	background: linear-gradient(to bottom, #e2e2e2 0%,#dbdbdb 50%,#d1d1d1 51%,#fefefe 100%); /* W3C */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#fefefe',GradientType=0 ); /* IE6-8 */
	border: 1px solid rgba(97, 91, 91, 0.26);
	box-shadow: 3px 3px 3px #dedede;
}

.context-menu-list{
	width: 150px !important;
}
.context-menu-list .context-menu-item{
	width: 120px;
	line-height: 13px;
}
.context-menu-list .context-menu-item > span{
word-wrap: break-word;}
.context-menu-item.icon{
	background-position: 3px 3px;
}
.context-menu-item{
	padding: 5px 2px 4px 24px;
}
.chartofacc-ghcode-select{
	width: 165px;
}
</style>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
   <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
	<form name="creditNoteForm" class="form-horizontal" novalidate>
	    <div class="row book-widget-row">
		    <div class="col-sm-12 col-md-12 col-lg-12">
		    	<div class="col-sm-5 col-md-5 col-lg-5">
		    		<div class ="padding-bottom-5">
		    		<a id="COAExport" stype="display:none"
					href="filePath/ChartOfAccounts.xls"
					download="ChartOfAccounts.xls"></a>
					<security:authorize access="hasRole('${form_code}_${export}')">
			    	<button class="btn btn-primary" ng-click="exportExcel()" >
	         			 Export
	         		</button>
	         		</security:authorize>
         			<br>
         			</div>
					<div  id="chartofaccounts-tree-left-bar">
						<input type="hidden" name="menuval" id="menuval">
						<div class="tree">
							<!-- group head code... -->	
							<!-- <ul>
								<li class="parent" ng-repeat="(liIndex1,level1) in groupHeadList"> 
									<a ng-bind="groupHeadList[liIndex1].groupHeadName"></a>
									<ul>
										<li class="parent" ng-repeat="(liIndex2,level2) in subGroupHeadList">
											<a ng-bind="subGroupHeadList[liIndex2].subGroupAcctName">												
											</a>	
										</li>
									</ul>
								</li>
							</ul> -->
						</div>
						
					</div>
				</div>	
		    </div>
	    </div>
    </form>   
  </div>
 </div>
</div>
