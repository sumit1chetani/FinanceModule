<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" xmlns:th="http://www.thymeleaf.org">
<!--<![endif]-->

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>iDaas</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
      <!-- Favicon -->
    
  
<!-- Favicon -->
<link rel="shortcut icon" href="/img/${user.tenantId}HelpVideos/logo.jpg" type="image/x-icon" />
<!-- <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon" /> -->
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css"
	href="/css/bootstrap.min.css" />
<!-- Fonts  -->
<link rel="stylesheet" href="/css/font-awesome.min.css"
	href="/css/font-awesome.min.css" />
<link rel="stylesheet" href="/css/simple-line-icons.css"
	href="/css/simple-line-icons.css" />
<!-- CSS Animate -->
<link rel="stylesheet" href="/css/animate.css"
	href="/css/animate.css" />
<!-- Custom styles for this theme -->
<link rel="stylesheet" href="/css/main.css"
	href="/css/main.css" />
<!-- Feature detection -->
<script src="/js/vendor/modernizr-2.6.2.min.js" type="text/javascript"></script>



<script src="/js/vendor/jquery-2.1.1.min.js"></script>

<script src="/js/angular/angular.js"></script>
<script src="/js/ui-router/angular-ui-router.min.js"></script>
<script src="/js/bootstrap/ui-bootstrap-tpls-0.12.0.min.js"></script>
<script src="/js/angular/angular-animate.min.js"></script>
<script src="/js/angular/ocLazyLoad.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script src="/js/plugins/navgoco/jquery.navgoco.min.js"></script>

<script src="/js/plugins/morris/raphael.js"></script>
<script src="/js/plugins/morris/morris.js"></script>

<script src="/js/plugins/chartjs/Chart.min.js"></script>

<script src="/js/plugins/ui-events/event.js"></script>

<script src="/js/plugins/growl/angular-growl-notifications.min.js"></script>

<script src="/js/plugins/pace/pace.min.js"></script>

<script src="/js/plugins/bootstrap-slider/js/bootstrap-slider.js"></script>

<script src="/js/plugins/c3Chart/js/d3.min.js"></script>
<script src="/js/plugins/c3Chart/js/c3.min.js"></script>
<script src="/js/plugins/c3Chart/js/c3-angular.min.js"></script>

<script src="/js/plugins/chartjs/tc-angular-chartjs.min.js"></script>

<script src="/js/plugins/sparkline/jquery.sparkline.min.js"></script>

<script src="/js/plugins/gauge/gauge.min.js"></script>

<script src="/js/plugins/ui-tree/angular-ui-tree.min.js"></script>

<script src="/js/plugins/switchery/switchery.min.js"></script>
<script src="/js/plugins/switchery/ui-switchery.js"></script>

<!-- <script src="http://maps.google.com/maps/api/js?sensor=true"></script> -->
<script src="/js/plugins/ui-maps/ui-map.js"></script>
<script
	src="/js/plugins/jvectormap/js/jquery-jvectormap-2.0.1.min.js"></script>
<script
	src="/js/plugins/jvectormap/js/jquery-jvectormap-us-aea-en.js"></script>

<script src="/js/plugins/dataTables/js/jquery.dataTables.js"></script>
<script src="/js/plugins/dataTables/js/dataTables.bootstrap.js"></script>
<script src="/js/plugins/dataTables/js/angular-datatables.min.js"></script>

<script src="/js/plugins/icheck/js/icheck.min.js"></script>
<script src="/js/plugins/weather/js/skycons.js"></script>
<script src="/js/plugins/calendar/moment.js"></script>
<script src="/js/plugins/calendar/clndr.js"></script>
<script src="/js/plugins/dropzone/js/dropzone.min.js"></script>
<script src="/js/plugins/mask/js/jasny-bootstrap.min.js"></script>
<script src="/js/plugins/editors/textAngular-sanitize.js"></script>
<script src="/js/plugins/editors/textAngular.min.js"></script>
<script src="/js/plugins/fullscreen/jquery.fullscreen-min.js"></script>

<script src="/js/app.js"></script>
<script src="/js/directives.js"></script>

<script src="/js/vendor/jquery-1.11.1.min.js"></script>

<script src="/js/plugins/pace/pace.min.js"></script>
    
    
    <script>
  angular.module('app', [])
    .controller('signins', ['$scope', function($scope) {
      $scope.list = [];
      $scope.text = 'hello';
      $scope.submit = function() {
        if ($scope.text) {
         /*  $scope.list.push(this.text);
          $scope.text = ''; */
          console.log("Login succeeded");
        }
        else
        	{
        	 console.log("Login succeeded");
        	}
      };
    }]);
</script>
	
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/vendor/html5shiv.js"></script>
    <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
<body ng-app="neuboard">
    <section class="container animated fadeInUp">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="login-wrapper">
                     <header>
                        <div class="brand">
                            <a href="index.html" class="logo">
                               <img src="../../img/ilantus_login.png" style="width:140px;height:60px" /></a>
                        </div>
                        <div style="text-align: center;">
                            <h3>     
                          <span th:if="${message != null || message != ''}" th:text="${message}" style="color: red;"></span>
                        </h3>
                        </div>
                    </header>
                    <div class="panel panel-primary">
                    
                        <div class="panel-heading">
                            <h3 class="panel-title">     
                           Admin Sign In
                        </h3>
                        </div>
                        <div class="panel-body">
                            <p> Login to access your account.</p>
                            <form class="form-horizontal" role="form" action="/login" method="post">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <input type="text" class="form-control" placeholder="Username"  id="username" name="username" ng-model="credentials.username"/>
                                        <i class="fa fa-user"></i>
                                        </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <input type="password" class="form-control" id="password" name="password" ng-model="credentials.password" placeholder="Password" />
                                        <i class="fa fa-lock"></i>
                                        <a href="javascript:void(0)" class="help-block" style="color:black">Forgot Your Password?</a>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                       <!--  <a href="index.html" class="btn btn-primary btn-block">Sign in</a> -->
                                     <!--     <button type="button" class="btn btn-primary btn-block" ng-click="logins()">Sign in</button> -->
                                       <!--  <input type="submit" id="submit" value="Submit" /> -->
                                       <button type="submit" class="btn btn-primary btn-block" ng-click="login()">Sign in</button>
                                        <hr />
                                        <a href="pages-sign-up.html" class="btn btn-default btn-block">Not a member? Sign Up</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!--Global JS-->
    
</body>

</html>