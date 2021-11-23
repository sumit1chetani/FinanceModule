
<style type="text/css">
#gbox_treeViewTBGrid{
width : 279 !important;
}
#gbox_containerGrid{
width :896px !important;
}
.highlighted {
	background-color: yellow;
}

.emptyBlock1000 {
	height: 1000px;
}

.emptyBlock2000 {
	height: 2000px;
}
/* #trialBalanceGrid{
border: 1px solid black;
} */
.highlight . ui-state-highlight highlight{
color:#fff!important;
background-color: #000!important;
cursor: pointer;
}
/* .ui-jqgrid tr.ui-row-ltr td {
padding: 6px 4px 0px 42px!important;
font-size: 13px!important; */
</style>
<script type="text/javascript">
	/* $('#tree1').treed();

	$(document).ready(function() {
		$('#search-button').on("click", function() {

			if (!searchAndHighlight($('#search-term').val())) {
			//	alert("No results found");
			}
		});

		$('#frameID').contents().find("html, body").find("tr:eq(0) td:eq(1) a").on("click", function() {

		//	alert("No results found" + this.html());

		});
	});

	$(document).ready(function() {
		/* $('#tree1 li a').on("click", function() {
			alert($(this).html());
			if (!searchAndHighlight($(this).html())) {
				alert("No results found");
			}
		}); */

		
	/*	 $('#tree1 li a').on("click", function() {
			 	var index="_0_0";
				if( $(this).closest('ul').attr('class')=='tree'){
					index="_0_0";
				}
				else if($(this).closest('li').attr('class')=='branch'){
					 index="_1_1";
				}
				else{
					index="_2_2";
				} 
				 if (!jqGridGlobalSearchText($(this).html())) {
				//	alert("No results found");
				} 
				 console.log("trigger first");
				 console.log( $("#trialBalanceGrid .containerGridghead_1 td:eq(0)").find(".ui-icon-circlesmall-plus"));
				 console.log("trigger end");
				 $("#trialBalanceGrid").jqGrid('setSelection', 'containerGridghead'+index, false);
				 /*   $("#trialBalanceGrid .containerGridghead_0").find(".ui-icon-circlesmall-plus").trigger("click");
				  $("#trialBalanceGrid .containerGridghead_1").find(".ui-icon-circlesmall-plus").trigger("click"); */
	
//	}); 
//	}); 
	


	
	
	function searchAndHighlight(searchTerm, selector) {

		$("<style type='text/css'> .highlighted{  background-color:yellow;} </style>").appendTo($('#frameID').contents().find('body'));
		//	$( "div:contains('John')" ).css( "text-decoration", "underline" );
		//	$('#frameID').contents().find("body:contains('A01')").css( "background-color", "yellow" );
		if (searchTerm) {
			//var wholeWordOnly = new RegExp("\\g"+searchTerm+"\\g","ig"); //matches whole word only
			//var anyCharacter = new RegExp("\\g["+searchTerm+"]\\g","ig"); //matches any word with any of search chars characters
			//   var selector = selector || "body";         
			var selector = $('#frameID').contents().find('body tbody');
			console.log(selector);

			var searchTermRegEx = new RegExp(searchTerm, "ig");
			var matches = $(selector).text().match(searchTermRegEx);
			alert(matches);
			if (matches) {
				/*  $('.highlighted').removeClass('highlighted');     //Remove old search highlights
				     $(selector).html($(selector).html()
				         .replace(searchTermRegEx, "<span class='highlighted' style='background-color:yellow'>"+searchTerm+"</span>"));
				 if($('.highlighted:first').length) {             //if match found, scroll to where the first one appears
				     $(window).scrollTop($('.highlighted:first').position().top);
				 }
				 return true; */
				$('#frameID').contents().find("html, body").find('#1selected').removeClass("highlighted");
				$('#frameID').contents().find("html, body").find('#1selected').removeAttr("id");
				$('#frameID').contents().find('body  tbody').each(function(id, value) {
					var span = $(value).find("tr:eq(1) td:eq(1) span");
					if (span.html() != undefined && (span.html()).indexOf(searchTerm) > -1) {
						span.attr("id", "1selected");
						$(this).find("#1selected").addClass("highlighted");
						$('#frameID').contents().find("html, body").scrollTop($('#frameID').contents().find("html, body").find('#1selected').offset().top);
						return false;
					}

				});
			}
		}
		return false;
	}
</script> 
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
			 <div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-10">
				<li><a>Reports</a></li>
				<li><a x-ui-sref="app.reports.finance">Finance</a></li>
				<li><a x-ui-sref="app.reports.finance">Financials</a></li>
				<li><a x-ui-sref="app.reports.finance.trailbalance">Trial Balance</a></li>
				<li><a x-ui-sref="app.reports.finance.trailbalanceviewgrid">Report</a>
				</li>
			</ol>

		</div>
			<div class="panel-body">
			<section widget-grid id="widget-grid">
				<div class="row">
					<div class="col-sm-12 col-md-12 ">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
			
		<!-- 	<div
				class="jarviswidget jarviswidget-color-darken jarviswidget-sortable"
				id="wid-id-0">
				<header role="heading">
					<h2>Trial Balance Report</h2>
					<span class="jarviswidget-loader"> <i
						class="fa fa-refresh fa-spin"></i>
					</span>
				</header>
				</div> -->
				<div role="content">
					<div class="bs-example">
						<div class="col-xs-12">
							<div class="col-xs-3">
								
								<div id="jqgrid">
									<table id="treeViewTBGrid"></table>
									<!-- <div id="treeViewTBPage"></div> -->
								</div>   
							</div>

							<div class="col-xs-9">
							
							 	 <div id="jqgrid">
									<table id="trialBalanceGrid"></table>
									<div id="trialBalancePage"></div>
								</div>   

							</div>
						</div>
					</div>
				</div>		
   
			
	</article>	
	</div>
	</div>
	<div class="row">
     <div class="col-sm-12 col-md-12 ">
      <div class="form-actions">
        <div class="row">
         <div class="col-md-12">
        
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>  
     </div>
     </div>
	</section>
	</div>
	</div>
	</div>


<!-- <div ng-app ng-controller="searchPage">
    <div ng-repeat="page in searchResults">
        <a ng-click="itemDetail(page._infoLink)">{{page.label}}</a>
    </div>
    <iframe width="500" height="400" ng-src="http://www.bbc.co.uk/"></iframe>
</div> -->
	