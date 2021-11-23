<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="app" class="ng-scope">
<head>
<meta charset="utf-8">
<title>Simatech</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description"
 content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon.png">
<!-- Css -->
<%@include file="styles.jsp"%>
<!-- <link rel="stylesheet" href="css/styles.min.css" type="text/css" /> -->
<%@include file="userrights.jsp"%>
<!-- Css -->
 </head>
 
<body data-ng-controller="MainCtrl" ng-app="neuboard" class="{{app.settings.bodyStyle}} {{fontSizeClass}}">
 <toaster-container toaster-options="{'time-out': 3000, 'close-button':true, 'animation-class': 'toast-top-right'}"> </toaster-container>
 <div class="app app-aside-custom" id="app"
  data-ng-class="{'app-header-fixed':app.settings.headerFixed, 'app-aside-fixed':app.settings.asideFixed, 'app-aside-folded-hover':app.settings.asideFoldedHover,'app-aside-folded':app.settings.asideFolded, 'app-aside-dock':app.settings.asideDock, 'container':app.settings.container}"
  data-ui-view="root"></div>
 <!-- Scripts -->
<!-- <script src="js/scripts.js"></script> -->
 <%@include file="scripts.jsp"%>
  <%@include file="templates.jsp"%>
   <%@include file="index.jsp"%>
 <script type="text/javascript">
   app.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
       $urlRouterProvider.otherwise('home/dashboard');
       $stateProvider.state('app', {
           abstract : true,
           views : {
               root : {
                   templateUrl : '/index.jsp'
               }
           }
       });
   } ]);
 </script>
 <!-- Scripts -->
 <div notifications="top right"></div>
</body>
</html>