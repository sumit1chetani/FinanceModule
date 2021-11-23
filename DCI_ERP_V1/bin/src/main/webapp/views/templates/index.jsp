	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />
<security:authentication var="user" property="principal" />
<!DOCTYPE html>
<!-- Application Name - app.js and Main controller - controller.js-->
<html>

<head>
<style>
.footer {
	position: fixed;
	right: 0;
	bottom: 0;
	left: 0px;
	/* padding: 1rem; */
	background-color: #e7e7e7;
	text-align: center;
	overflow-x: hidden;
	z-index: 1030;
	transform: translate3d(0, 0, 0);
}
/* 
.navbar-default {
	background-color: #f8f8f8;
	border-color: #e7e7e7;
}

.navbar-fixed-bottom {
	bottom: 0;
	margin-bottom: 0;
	border-width: 1px 0 0;
}

.navbar-fixed-bottom {
	position: fixed;
	right: 0;
	left: 0;
	z-index: 1030;
	-webkit-transform: translate3d(0, 0, 0);
	-o-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}

.navbar {
	position: relative;
	min-height: 50px;
	margin-bottom: 20px;
	border: 1px solid transparent;
}

container-fluid {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

.subdragdiv {
	overflow-y: scroll;
	max-height: 525px;
	border: 1px solid lightblue;
	padding-top: 15px;
}

.subdragdiv::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
	background-color: #F5F5F5;
	border-radius: 10px;
}

.subdragdiv::-webkit-scrollbar {
	width: 10px;
	background-color: #F5F5F5;
}

.subdragdiv::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: rgb(173, 216, 230);
} */
</style>
<title>DCI ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<link rel="shortcut icon" href="/img/MBKHelpVideos/Dental_Council_of_India_logo.png" type="image/x-icon" />

<!-- Page title - directive.js -->
<!-- jQuery -->

<script src="js/vendor/jquery/dist/jquery.min.js"></script>

<script src="js/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="js/vendor/jquery-ui/jquery-ui-1.10.0.custom.min.js"></script>
<script src="js/vendor/smartmenu/jquery.smartmenus.js"></script>

<script src="js/angular/angular.js"></script>
<script src="js/angular/angular.ui.min.js"></script>
<script src="js/vendor/angular-bootstrap/ui-bootstrap.min.js"></script>
<script src="js/vendor/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
<script src="js/angular/ocLazyLoad.js"></script>

<script src="js/vendor/handsontable/select2.js"></script>
<script src="js/vendor/handsontable/handsontable.full.js"></script>
<script src="js/vendor/handsontable/select2-editor.js"></script>
<script src="js/vendor/ui-chosen/chosen.jquery.js"></script>
<script src="js/vendor/jquery-ui/jquery-ui.js"></script>

<!-- Added for Ui Multi Select -->
<script src="js/plugins/ui-multiselect/selectize.js"></script>
<script src="js/plugins/ui-multiselect/angular-selectize.js"></script>
<!-- <script src="js/angular/angular-route.js"></script> -->
<script src="js/ui-router/angular-ui-router.min.js"></script>
<script src="js/angular/angular-animate.min.js"></script>
<script src="js/angular/angular-sanitize.min.js"></script>
<!-- <script src="js/vendor/datetimepicker/bootstrap-datetimepicker.min.js"></script> -->
<script src="js/vendor/selectivity/selectivity-full.js"></script>

<script src="js/plugins/navgoco/jquery.navgoco.min.js"></script>
<script src="js/vendor/smartmenu/jquery.smartmenus.bootstrap.js"></script>
<script src="js/vendor/datetimepicker/ng-bs3-datepicker.js"></script>
<script src="js/plugins/morris/raphael.js"></script>
<script src="js/plugins/morris/morris.js"></script>
<script src="js/vendor/toastr/toastr.min.js"></script>
<script src="js/vendor/angular-loading-bar/loading-bar.js"></script>
<script src="js/vendor/angular-draganddrop/ngDraggable.js"></script>

<script src="js/angular-chart/Chart.min.js"></script>

<script src="js/angular-chart/angular-chart.min.js"></script>
 
<script src="js/angular-chart/highcharts.js"></script>
 <script src="js/app/charts/exporting.js"></script>
 <script src="js/app/charts/streamgraph.js"></script>
 <script src="js/angular/groupedCatgeories.js"></script>
<script src="js/app/charts/series-label.js"></script>
<script src="js/app/charts/annotations.js"></script>
<script src="js/app/charts/export-data.js"></script> 
<script src="js/vendor/jquery-ui/jquery-ui-1.10.0.custom.min.js"></script>
<script src="https://code.highcharts.com/modules/sonification.js"></script>
 
<!-- JqGrid -->
<script src="js/vendor/jqgrid/js/minified/jquery.jqGrid.4.7.js"></script>
<script src="js/vendor/jqgrid/js/i18n/grid.locale-en.4.7.js"></script>
<script src="js/vendor/selectivity/selectivity-full.js"></script>


<script src="js/plugins/chartjs/Chart.min.js"></script>

<script src="js/plugins/ui-events/event.js"></script>

<script src="js/plugins/growl/angular-growl-notifications.min.js"></script>

<script src="js/plugins/pace/pace.min.js"></script>

<script src="js/plugins/bootstrap-slider/js/bootstrap-slider.js"></script>

<script src="js/plugins/c3Chart/js/d3.min.js"></script>
<script src="js/plugins/c3Chart/js/c3.min.js"></script>
<script src="js/plugins/c3Chart/js/c3-angular.min.js"></script>
<script src="js/plugins/chartjs/tc-angular-chartjs.js"></script>

<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

<script src="js/plugins/gauge/gauge.min.js"></script>

<script src="js/plugins/ui-tree/angular-ui-tree.min.js"></script>

<script src="js/plugins/switchery/switchery.min.js"></script>
<script src="js/plugins/switchery/ui-switchery.js"></script>

 <script src="js/plugins/ui-maps/ui-map.js"></script>
<script src="js/plugins/jvectormap/js/jquery-jvectormap-2.0.1.min.js"></script>
<script src="js/plugins/jvectormap/js/jquery-jvectormap-us-aea-en.js"></script>

<script src="js/plugins/dataTables/js/jquery.dataTables.js"></script>
<script src="js/plugins/dataTables/js/dataTables.bootstrap.js"></script>
<script src="js/plugins/dataTables/js/angular-datatables.min.js"></script>
<script src="js/plugins/icheck/js/icheck.min.js"></script>

<script src="js/plugins/bootstrap-multiselect/bootstrap-multiselect.js"></script>
<script src="js/plugins/ui-select/select.js"></script>
<script src="js/plugins/weather/js/skycons.js"></script>
<!-- <script src="js/plugins/calendar/moment.js"></script> -->
<!-- <script src="js/plugins/calendar/clndr.js"></script> -->
<script src="js/plugins/dropzone/js/dropzone.min.js"></script>
<script src="js/plugins/mask/js/jasny-bootstrap.min.js"></script>
<script src="js/plugins/editors/textAngular-sanitize.js"></script>
<script src="js/plugins/editors/textAngular.min.js"></script>
<script src="js/plugins/fullscreen/jquery.fullscreen-min.js"></script>
<script src="js/plugins/FileUpload/jquery.fileupload.js"></script>
<script src="js/plugins/FileUpload/jquery.iframe-transport.js"></script>
<script src="js/listSelect/ngListSelect.min.js"></script>
<script src="js/listSelect/ngListSelect.js"></script>
<script src="js/vendor/smarttable/smart-table.js"></script>
<script src="js/plugins/angular-tree-widget/angular-recursion.js"></script>
<script src="js/plugins/angular-tree-widget/angular-tree-widget.js"></script>


<script src="js/angulardraganddroplists/angular-drag-and-drop-lists.js"></script>

<script src="js/vendor/datetimepicker/datetime-picker.min.js"></script>
<script src="js/vendor/datetimepicker/datetime-picker.tpls.js"></script>
<script src="js/vendor/moment/moment.js"></script>
<script src="js/vendor/datetimepicker/pikaday.js"></script>
<script src="js/vendor/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="js/vendor/datetimepicker/ng-bs3-datepicker.js"></script>
<script src="js/vendor/angular-validation/angular-validation-rule.js"></script>
<script src="js/vendor/angular-validation/angular-validation.js"></script>
<script src="js/vendor/angular-translate/angular-translate.min.js"></script>
<script
	src="js/vendor/angular-translate/angular-translate-loader-static-files.min.js"></script>
<script src="js/vendor/angular-validation/angular-validation.min.js"></script>
<script src="js/vendor/ui-chosen/angular-chosen.js"></script>
<script src="js/vendor/toastr/toastr.min.js"></script>
<script src="js/vendor/toastr/toastrangular.js"></script>
<script src="js/vendor/toastr/toaster.js"></script>
<script src="js/angular/unique.js"></script>
<script src="js/vendor/ngdialog/ngDialog.js"></script>
<script src="js/app.js"></script>
<script src="js/app/general/directives/loggerService.js"></script>
<script src="js/app/general/directives/utilsService.js"></script>
<script src="js/app/general/directives/selectivityDirective.js"></script>
<script src="js/app/general/directives/bootstrapDateTimeDirective.js"></script>
<script src="js/app/general/directives/checklist-model.js"></script>
<script src="js/app/general/service/sharedService.js"></script>
<script src="js/app/general/service/stateBreadCrumbs.js"></script>
<!-- <script src="js/config.js"></script> -->
<script src="js/app/finance/finance.js"></script>
<script src="js/app/reports/reports.js"></script>
<script src="js/app/mis/mis.js"></script>
<script src="js/app/master/master.js"></script>
<script src="js/app/hr/hr.js"></script>
<script src="js/app/operation/operation.js"></script>

<script src="js/app/payroll/payroll.js"></script>

<script src="js/app/trade/trade.js"></script>
<script src="js/app/documentation/documentation.js"></script>
<script src="js/config.js"></script>
<!-- <script src="js/hello.js"></script> -->
<script src="js/directives.js"></script>
<script src="js/smartMenu.js"></script>
<script src="js/controllers.js"></script>
<script src="js/app/salesmarketing/salesmarketing.js"></script>

<!-- air -->
<script src="js/app/air/air.js"></script>

<!-- Color Picker -->
<script src="js/vendor/color-picker/color-picker.min.js"></script>

<script src="js/app/master/tracking/static.js"></script>
<!-- <script type="text/javascript" -->
<!-- 	src="https://www.google-analytics.com/analytics.js">     -->
<!-- </script> -->

 
 
 

<link href='/css/fullcalendar.min.css' rel='stylesheet' />
<link href='/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href='/css/scheduler.min.css' rel='stylesheet' />
<link href='/css/jquery.fileupload.css' rel='stylesheet' />
<link href='/css/style-fileup.css' rel='stylesheet' />
<script src='js/app/master/calendar/js/moment.min.js'></script>
<script src='js/app/master/calendar/js/calendar.js'></script>
<script src='js/app/master/calendar/js/gcal.js'></script>
<script src='js/app/master/calendar/js/fullcalendar.min.js'></script>
<script src='js/app/master/calendar/js/scheduler.min.js'></script>

<script src='js/jquery.blockUI.js'></script>




<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />



<link href="/css/handsontable.full.css" rel="stylesheet" />
 
<%@include file="styles.jsp"%>
<%@include file="userrights.jsp"%>
</head>
<script type="text/javascript">
	var tenantId = '';
	$(function() {
		//$('#userNameText').html($('#userName').val());
	});
</script>

<!-- Current state name -->
<input type="hidden" value="${isMaster}" id="isMaster"></input>
<input type="hidden" value="${userName}" id="userName"></input>
<input type="hidden" value="${tenantId}" id="tenantId"></input>
<input type="hidden" value="${empId}" id="empId"></input>

<!--  <base href="/"></base>  -->
<body class="{{$state.current.name}}" ng-app="neuboard"
	ng-controller="MainCtrl">
	<toaster-container
		toaster-options="{'time-out': 3000, 'close-button':true, 'animation-class': 'toast-top-right'}">
	</toaster-container>
	<!-- Page Wrapper-->
	<section id="main-wrapper" class="theme-default">
		<!-- Page wrapper -->
		<header id="header" ng-include="'views/templates/header.jsp'"
			style="border-bottom: 1px solid red;"></header>
		<!-- Left Sidebar Navigation -->
		<!-- <aside class="sidebar sidebar-left"
			ng-include="'/views/left-sidebar.html'"></aside> -->
		<!-- Content wraper -->
		<section class="main-content-wrapper">
			<!-- Main content view  -->
			<div class="ui-view"></div>
			<!-- <div class="container">

		<div>
			<h1>Spring Boot - Nue Board</h1>
			<h2>
				<span th:text=" ${message}"></span>
			</h2>
			    
		</div>

	</div> -->
			<!-- Footer -->
			<div ng-include="'views/templates/footer.jsp'"></div>
		</section>
		<!-- /Content wraper-->
	</section>
	<script type="text/ng-template" id="modalDialogId1">
  <%@include file="modalDialogId1.jsp"%>

 </script>
	<%@include file="templates.jsp"%>
</body>
<footer align="center" class="footer">
	<div class="row">
		<div class="col-md-12 text-center">
			<%-- <small>© <span>${currentYear }</span> 
				Powered by Paragon Dynamics Info Systems Pvt. Ltd.
			</small> --%>
		</div>
		<div class="col-md-12 text-center"></div>
	</div>
</footer>
</html>
