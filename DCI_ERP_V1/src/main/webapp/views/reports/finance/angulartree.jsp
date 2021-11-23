<style type="text/css" >
div[data-angular-treeview] {
  /* prevent user selection */
  -moz-user-select: -moz-none;
  -khtml-user-select: none;
  -webkit-user-select: none;
  -ms-user-select: none;
  user-select: none;

  /* default */
  font-family: Tahoma;
  font-size:13px;
  color: #555;
  text-decoration: none;
}

div[data-tree-model] ul {
  margin: 0;
  padding: 0;
  list-style: none; 
  border: none;
  overflow: hidden;
}

div[data-tree-model] li {
  position: relative;
  padding: 0 0 0 20px;
  line-height: 20px;
}

div[data-tree-model] li .expanded {
  padding: 1px 10px;
  background-image: url("http://cfile23.uf.tistory.com/image/205B973A50C13F4B19D9BD");
  background-repeat: no-repeat;
}

div[data-tree-model] li .collapsed {
  padding: 1px 10px;
  background-image: url("http://cfile23.uf.tistory.com/image/1459193A50C13F4B1B05FB");
  background-repeat: no-repeat;
}

div[data-tree-model] li .normal {
  padding: 1px 10px;
  background-image: url("http://cfile23.uf.tistory.com/image/165B663A50C13F4B196CCA");
  background-repeat: no-repeat;
}

div[data-tree-model] li i, div[data-tree-model] li span {
  cursor: pointer;
}

div[data-tree-model] li .selected {
  background-color: #aaddff;
  font-weight: bold;
  padding: 1px 5px;
}

</style>
<!-- #MAIN CONTENT -->
<div id="content">
	<!-- row -->
	<div class="row">
		<!-- NEW WIDGET START -->
		<article
			class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
			<!-- Widget ID (each widget will need unique ID)-->
			<div
				class="jarviswidget jarviswidget-color-darken jarviswidget-sortable"
				id="wid-id-0">
				<header role="heading">
					<h2>Trial Balance Grid</h2>
					<span class="jarviswidget-loader"> <i
						class="fa fa-refresh fa-spin"></i>
					</span>
				</header>
				<div role="content">
					<div class="bs-example">
						<div class="col-xs-12">
							<div class="col-xs-3">
							<!-- <div ng-app="myApp"> -->
								<!--   <div ng-controller="myController"> -->
								
								    <!-- <div>
								      <input type="button" value="TREE MODEL 1" data-ng-click="roleList = roleList1" /> <input type="button" value="TREE MODEL 2" data-ng-click="roleList = roleList2" />
								    </div>
								
								    <div style="margin:10px 0 30px 0; padding:10px; background-color:#EEEEEE; border-radius:5px; font:12px Tahoma;">
								      <span><b>Selected Node</b> : {{currentNode.roleName}}</span>
								    </div> -->
								
								    <!--
								      [TREE attribute]
								      angular-treeview: the treeview directive
								      tree-model : the tree model on $scope.
								      node-id : each node's id
								      node-label : each node's label
								      node-children: each node's children
								    -->
								    <div
								      data-angular-treeview="true"
								      data-tree-model="roleList"
								      data-node-id="roleId"
								      data-node-label="roleName"
								      data-node-children="children" >
								    </div>
								
								<!--   </div>
								</div> -->
							</div>

							<div class="col-xs-9">
							
							 	 <div id="jqgrid">
									<table id="containerGrid"></table>
									<div id="containerPage"></div>
								</div>   

							</div>
						</div>
					</div>
				</div>				
			</div>
		
	</div>

<!-- <div ng-app ng-controller="searchPage">
    <div ng-repeat="page in searchResults">
        <a ng-click="itemDetail(page._infoLink)">{{page.label}}</a>
    </div>
    <iframe width="500" height="400" ng-src="http://www.bbc.co.uk/"></iframe>
</div> -->
