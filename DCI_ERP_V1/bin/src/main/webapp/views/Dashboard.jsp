<!-- <link rel="stylesheet" href="css/chat.css"> -->
   
<!-- <script src="https://code.highcharts.com/highcharts.js"></script>
 <script src="https://code.highcharts.com/modules/exporting.js"></script>
 <script src="js/app/charts/streamgraph.js"></script>
 <script src="js/angular/groupedCatgeories.js"></script>
<script src="js/app/charts/series-label.js"></script>
<script src="js/app/charts/annotations.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script> 
<script src="js/vendor/jquery-ui/jquery-ui-1.10.0.custom.min.js"></script>
<script src="https://code.highcharts.com/modules/sonification.js"></script> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

 <style>
A:hover { COLOR: #055d96; TEXT-DECORATION: none; font-weight: bold }
div.orgtable select {
	width: 140px;
}

.panel-default>.panel-heading {
	border-color: #eff2f7;
	background: #fff;
	background: #ddd;
	color: #767676;
}

.WC {
	background-color: #7cb5ec
}

.OB {
	background-color: #f7a35c
}

.WD {
	background-color: #90ed7d
}

.OW {
	background-color: #434348
}

.TP {
	background-color: #8085e9
}

.SM {
	background-color: #f15c80
}

.calbody {
	margin: 20px 10px;
	padding: 0;
}
/* .ngdialog{
 z-index: 9999 !important;
} */
.defcalClass {
	max-width: 80%;
	margin: 0 auto;
	height: 100%;
}

.defcalClass>.fc-toolbar {
	padding: 1%;
	background: #ddd;
	border-radius: 3px 3px 3px 3px;
}

.defcalClass>.fc-toolbar>.fc-center>h2 {
	color: #333;
	margin-top: 6%;
}

.fc-event-container>a:HOVER {
	color: #fff !important;
}

.fc-list-item-title>a:HOVER {
	color: #27378b !important;
}

.pnl-hding {
	background: linear-gradient(to right, rgba(182, 7, 25, 0.61),
		rgb(3, 45, 144)) !important;
}

.DrvTripClass>.fc-toolbar {
	padding: 1%;
	background: #ddd;
	border-radius: 3px 3px 3px 3px;
}

.DrvTruckClass>.fc-toolbar {
	padding: 1%;
	background: #ddd;
	border-radius: 3px 3px 3px 3px;
}

.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}
.tip-card[_ngcontent-c9] .tip-ico-info[_ngcontent-c9] {
    background: linear-gradient(to top right, #ff572c, #f81515);
    background: -webkit-linear-gradient(to top right, #2cc3ff, #15f8bf);
}

.nav-justified>li, .nav-tabs.nav-justified>li:active {
	background-color: #fff;
}

.nav-tabs>li.active {
	background-color: #fff;
	border: 1px solid #375785;
}

.tab-head {
	background: dodgerblue !important;
	color: black;
}

.tabOwnCss>ul>li>a {
	height: 57px;
	color: #fff;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}

.nav>li>a:hover, .nav>li>a:focus {
	background-color: rgba(5, 120, 144, 0.16);
}

.txtAlgRt {
	text-align: right;
}
/* .panel-default>.panel-heading{
background: #779ed6;
} */
.txtUpperCs {
	text-transform: uppercase;
}

.magmtClass>.panel-heading {
	background: #8a8d92;
}

.nav-justified>li, .nav-tabs.nav-justified>li {
	width: 9%;
}

.tip-card[_ngcontent-c9] {
    padding: 13px;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: row;
    flex-direction: row;
    -ms-flex-pack: distribute;
    justify-content: space-around;
        padding-top: 16px;
}
.card-block {
    display: block;
    padding: 10px;
}

.tip-card[_ngcontent-c9] .tip-ico-primary[_ngcontent-c9] {
    box-shadow: 0 2px 10px 0 rgba(252, 164, 0, 0.5);
    -o-box-shadow: 0 2px 10px 0 rgba(252, 164, 0, 0.5);
    -moz-box-shadow: 0 2px 10px 0 rgba(252, 164, 0, 0.5);
    -webkit-box-shadow: 0 2px 10px 0 rgba(252, 164, 0, 0.5);
}

.tip-card[_ngcontent-c9] .tip-ico[_ngcontent-c9] {
    margin: 0 10px;
    border-radius: 3px;
    color: #fff;
    width: 141px;
    height: 85px;
    text-align: center;
    line-height: 60px;
    font-size: 30px;
    border: none;
    outline: none;
}

.bg-primary[_ngcontent-c9], .tip-card[_ngcontent-c9] .tip-ico-primary[_ngcontent-c9] {
    background: linear-gradient(to top right, #fca400, #ffd17c);
    background: -webkit-linear-gradient(to top right, #fca400, #ffd17c);
}
button, html input[type=button], input[type=reset], input[type=submit] {
    -webkit-appearance: button;
    cursor: pointer;
}
.card {
    width: auto;
    height: auto;
    background: #fff;
    position: relative;
    border: 1px solid #e4e3e3;
    border-radius: 2px;
    color: #26253c;
    margin-bottom: 24px;
}
.fa-fw {
    width: 1.28571429em !important;
    text-align: center;
}

.fa {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
    font-size: inherit;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
.tip-card[_ngcontent-c9] .tip-ico-success[_ngcontent-c9] {
    box-shadow: 0 2px 10px 0 rgba(22, 190, 154, 0.5);
    -o-box-shadow: 0 2px 10px 0 rgba(22, 190, 154, 0.5);
    -moz-box-shadow: 0 2px 10px 0 rgba(22, 190, 154, 0.5);
    -webkit-box-shadow: 0 2px 10px 0 rgba(22, 190, 154, 0.5);
}
.bg-success[_ngcontent-c9], .tip-card[_ngcontent-c9] .tip-ico-success[_ngcontent-c9] {
    background: linear-gradient(to top right, #16be9a, #42e697);
    background: -webkit-linear-gradient(to top right, #16be9a, #42e697);
}

.paddLftRht0px {
	padding-left: 0px;
	padding-right: 0px;
}
.tip-card[_ngcontent-c9] .tip-ico-danger[_ngcontent-c9] {
    background: linear-gradient(to top right, #fa5167, #fda09c);
    background: -webkit-linear-gradient(to top right, #fa5167, #fda09c);
}
</style> 
<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 72%;
	position: absolute;
	top: 20%;
	left: 14%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}

</style>
<style>
.square1 {
  height: 12px;
  width: 12px;
   background-color: #FFFF00;
   
}
.square2 {
  height: 12px;
  width: 12px;
   background-color: #90EE90; 
}
.square3 {
  height: 12px;
  width: 12px;
   background-color: #87CEEB;
}
.square4 {
  height: 12px;
  width: 12px;
   background-color: #ff7800;
}

.new-class{
font-family: 'Montserrat', sans-serif !important;
}
</style>
<div class="pageheader" >
	<div class="breadcrumb-wrapper hidden-xs new-class">
		<span class="label">You are here:</span>
		<ol class="breadcrumb">
			<li>DashBoard</li>
			<!-- <li class="active">List</li> -->
		</ol>
	</div>
	


</div>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<br>
	 
  <div class="row" >
  <div class="col-md-12">
  <div class="col-md-6">
  </div>
 </div>
 
 
 
 
 
 
 
 
 
  
	
	 
  
	 
	
	 </div>	
	
	
	
	