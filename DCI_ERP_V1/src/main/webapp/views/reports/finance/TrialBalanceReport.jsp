
<style type="text/css">
.highlighted {
    background-color:yellow;
}
.emptyBlock1000 { height:1000px;}
.emptyBlock2000 {
    height:2000px;
}
</style>
<script type="text/javascript">
$('#tree1').treed();


$(document).ready(function() {
     $('#search-button').on("click",function() {
    	
        if(!searchAndHighlight($('#search-term').val())) {
            alert("No results found");
        }
    }); 
     
     $('#frameID').contents().find("html, body").find("tr:eq(0) td:eq(1) a").on("click",function() {
     	
       
             alert("No results found"+this.html());
         
     }); 
});

 $(document).ready(function() {
    $('#tree1 li a').on("click",function() {
   	alert($(this).html());
       if(!searchAndHighlight($(this).html())) {
           alert("No results found");
       }
   }); 
}); 
 
function searchAndHighlight(searchTerm, selector) {
	
	
	$("<style type='text/css'> .highlighted{  background-color:yellow;} </style>").appendTo($('#frameID').contents().find('body'));
//	$( "div:contains('John')" ).css( "text-decoration", "underline" );
//	$('#frameID').contents().find("body:contains('A01')").css( "background-color", "yellow" );
     if(searchTerm) {
        //var wholeWordOnly = new RegExp("\\g"+searchTerm+"\\g","ig"); //matches whole word only
        //var anyCharacter = new RegExp("\\g["+searchTerm+"]\\g","ig"); //matches any word with any of search chars characters
     //   var selector = selector || "body";         
        var selector= $('#frameID').contents().find('body tbody');
        console.log(selector);
       
        var searchTermRegEx = new RegExp(searchTerm,"ig");
        var matches = $(selector).text().match(searchTermRegEx);
        alert(matches);
        if(matches) {
           /*  $('.highlighted').removeClass('highlighted');     //Remove old search highlights
                $(selector).html($(selector).html()
                    .replace(searchTermRegEx, "<span class='highlighted' style='background-color:yellow'>"+searchTerm+"</span>"));
            if($('.highlighted:first').length) {             //if match found, scroll to where the first one appears
                $(window).scrollTop($('.highlighted:first').position().top);
            }
            return true; */
            $('#frameID').contents().find("html, body").find('#1selected').removeClass("highlighted");
            $('#frameID').contents().find("html, body").find('#1selected').removeAttr("id"); 
        	$('#frameID').contents().find('body  tbody').each(function(id,value){
        		 var span = $(value).find("tr:eq(1) td:eq(1) span");   
        		if(span.html() != undefined && (span.html()).indexOf(searchTerm) >-1)   
        			{  span.attr("id","1selected");
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
<div class="panel panel-default">
<div class="panel-heading padding-right-0 padding-left-0 panel-heading-list-page float-left font-bold">
   <div class="col-md-12 padding-right-0 padding-left-0 header-with-breadcrumb">
    <ol class="breadcrumb inline-block padding-left-10">
    <li>
     <a>Reports</a>
    </li>
    <li>
     <a x-ui-sref="app.reports.finance">Finance</a>
    </li>
     <li>
     <a x-ui-sref="app.reports.finance">Financials</a>
    </li>
    <li>
     <a x-ui-sref="app.reports.finance.profitandloss">Trial Balance</a>
    </li>
     <li>
     <a x-ui-sref="app.reports.finance.profitLossGridReport">Report</a>
    </li>
   </ol>
  </div>
 </div>

<section widget-grid id="widget-grid">
  <div class="row">
    <article class="col-sm-12 col-md-12 col-lg-12 ">
     
    <!--  <div jarvis-widget id="wid-id-0">
    <header class="panel-heading font-bold">
       <span class="widget-icon">
        <i class="fa fa-eye"></i>
       </span>
       <h2>Trial Balance</h2>
      </header>
      </div> -->
      <div role="content">
      <div class="bs-example">
    
    <div class="col-xs-12">
    <div class="col-xs-3">
    
    <div class="row">
        <div class="col-md-4">
            <ul id="tree1">
               <!--  <p class="well" style="height:135px;"><strong>Initialization no parameters</strong>

                    <br /> <code>$('#tree1').treed();</code>

                </p> -->
                <li><a> CURRENT ASSETS </a>

                    <ul>
                        
                        <li><a>TRADE DEBTORS</a>
                            <ul>
                                <li><a>AL BADER SHIPPING & GEN.CO.W.L.L.(AGENTS)</a>
                                   <!--  <ul>
                                        <li>Report1</li>
                                        <li>Report2</li>
                                        <li>Report3</li>
                                    </ul> -->
                                </li>
                                 <li><a>ALLIGATOR SHPPING SERVICES (P) LTD</a></li>
                                 <li><a>APL (INDIA) PVT LTD.</a></li>
                                 <li><a>APL INDIA PVT LTD (COCHIN)</a></li>
                                 <li><a>GOOD RICH MARITIME PVT LTD</a></li>
                                
                             <!--    <li>Employee Maint.</li> -->
                            </ul>
                        </li>
                        <!-- <li>Human Resources</li> -->
                    </ul>
                </li>
                <li><a>INVENTORIES</a>
                    <ul>
                        <li><a>FUEL OIL PURCHASED</a></li>
                        
                                <li><a>AS CARELIA</a></li>
                                <li><a>SAXONIA</a></li>
                                <li><a>JACOB RICKMERS</a></li>
                                <li><a>M.V.BALEEN</a></li>
                               
                    </ul>
                        <!-- <li><a>BANKS IN</a>
                            <ul>
                                <li><a>DBS SGD</a>
                                    <ul>
                                        <li>Report1</li>
                                        <li>Report2</li>
                                        <li>Report3</li>
                                    </ul>
                                </li>
                                <li><a>DBS USD</a></li>
                               
                                
                            </ul>
                        </li>
                        <li><a>BANKS IN MALAYSIA</a>
                          <ul>
                          <li><a>HSBC MYR</a></li>
                          </ul>	
                        </li> -->
                    </ul>
             
        </div>
      
    </div>
    </div>
    
     <div class="col-xs-9">
   <!--   <input type="text" id="search-term" />
<input type="submit" id="search-button" value="search" />
<input type="submit" id="search-button" value="search" />
<input type="submit" id="search-button" value="search" />
 -->
         <iframe id="frameID" style="width:100%;height:500px" ng-src="{{tbreport}}"></iframe>
	       
	  </div>
	  </div> 
</div>
      </div>
      
     <!-- widget div-->
    
     <!-- end widget div -->
    
    <!-- end widget -->
   </article>
</div>
</section>
</div>
</div>
