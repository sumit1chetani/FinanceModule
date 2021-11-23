<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<style>

#login-box {
	
	position: absolute;
    width: 350px;
    margin: 0 auto;
    margin-top: 5%;
    left: 79%;
    border: 1px solid #fdfdfe;
    background: lightgrey;    
    padding: 23px;
    border-radius: 20px 0 0 0;
    -webkit-border-radius: 20px 0 0 0;
    -moz-border-radius: 20px 0 0 0;
    border-radius: 20px 0 0 0;
    -webkit-box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;
    -moz-box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;
    box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;
    /* box-shadow: 20px 20px 20px; */   
    box-shadow: 18px 20px 56px ;
    transform: translateX(-50%); 
    min-height: 288px;
}
#login-box .logo .logo-caption {
	font-family: 'Poiret One', cursive;
	/* color: white; */
	text-align: center;
	margin-bottom: 0px;
}
#login-box .logo .tweak {
	color: #1a1475;
}
#login-box .controls {
	padding-top: 6px;
}
#login-box .controls input {
	border-radius: 0px;
	background: white;
	border: 0px;
	color: black;
	font-family: 'Nunito', sans-serif;
}
#login-box .controls input:focus {
	box-shadow: none;
}
#login-box .controls input:first-child {
	border-top-left-radius: 2px;
	border-top-right-radius: 2px;
}
#login-box .controls input:last-child {
	border-bottom-left-radius: 2px;
	border-bottom-right-radius: 2px;
}
#login-box button.btn-custom {
	border-radius: 2px;
	margin-top: 8px;
	/* background:#7b7b7b; */
	background:#1a1475;
	border-color: rgba(48, 46, 45, 1);
	color: white;
	font-family: 'Nunito', sans-serif;
}
#login-box button.btn-custom:hover{
	-webkit-transition: all 500ms ease;
	-moz-transition: all 500ms ease;
	-ms-transition: all 500ms ease;
	-o-transition: all 500ms ease;
	transition: all 500ms ease;
	background: rgba(48, 46, 45, 1);
	/* border-color: #424242; */
	 border-color: #1a1475; 
}
 .btn-facebook {
	color: #fff;
	background-color: #3b5998;
	border-color: rgba(0, 0, 0, 0.2);
}

.btn-facebook-disabled {
	color: #fff;
	background-color: #ccc;
	border-color: rgba(0, 0, 0, 0.2);
}

#imagerepeat{
    background-image: url(/img/);
    background-repeat: repeat-x;
}

#909aa0
.up {
	text-align: right;
}

.sign div {
	display: inline-block;
	width: 50%;
	line-height: 50px;
	color: #ccc;
	font-size: 14px;
}

* {
	margin: 0;
	padding: 0;
}

.up a {
	display: block;
	background: #1f7bb6;
	text-align: center;
	height: 35px;
	line-height: 35px;
	width: 50%;
	font-size: 16px;
	text-decoration: none;
	color: #eee;
	border-bottom: solid 3px #1f7bb6;
	border-radius: 3px;
	font-weight: bold;
	margin-left: 50%;
}

.sign {
	width: 100%;
	padding: 0 5%;
	height: 50px;
	display: table;
	background: #556b8d;
}

.btn-google {
	color: #fff;
	background-color: #dd4b39;
	border-color: rgba(0, 0, 0, 0.2);
}

.btn-google-disabled {
	color: #fff;
	background-color: #ccc;
	border-color: rgba(0, 0, 0, 0.2);
}

.btn-social {
	position: relative;
	padding-left: 44px;
	text-align: left;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.btn {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}

a {
	color: #337ab7;
	text-decoration: none;
}

a {
	background-color: transparent;
}

* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.panel>.panel-heading {
	padding: 14px 10px;
}

.w3-animate-fading {
    animation: fading 5s infinite;
}
 
</style>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>DCI ERP</title>
<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<c:set var="context" value="<%=request.getContextPath()%>" />
<!-- Favicon -->
<%-- <link rel="shortcut icon" href="/img/${tenantId}HelpVideos/logo.jpg"
	type="image/x-icon" /> --%>
<link rel="shortcut icon" href="/img/MBKHelpVideos/Dental_Council_of_India_logo.png" type="image/x-icon" />
<!-- <link rel="shortcut icon" href="/img/MBKHelpVideos/imgpsh_fullsize_anim.jpg" type="image/x-icon" /> -->

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="${context}/css/bootstrap.min.css"
	href="${context}/css/bootstrap.min.css" />
<!-- Fonts  -->
<link rel="stylesheet" href="${context}/css/font-awesome.min.css"
	href="${context}/css/font-awesome.min.css" />
<link rel="stylesheet" href="${context}/css/simple-line-icons.css"
	href="${context}/css/simple-line-icons.css" />
<!-- CSS Animate -->
<link rel="stylesheet" href="${context}/css/animate.css"
	href="${context}/css/animate.css" />
<!-- Custom styles for this theme -->
<link rel="stylesheet" href="${context}/css/main.css"
	href="${context}/css/main.css" />
<!-- Feature detection -->
<script src="${context}/js/vendor/modernizr-2.6.2.min.js"
	type="text/javascript"></script>



<script src="${context}/js/vendor/jquery-2.1.1.min.js"></script>

<script src="${context}/js/angular/angular.js"></script>
<script src="${context}/js/ui-router/angular-ui-router.min.js"></script>
<script src="${context}/js/bootstrap/ui-bootstrap-tpls-0.12.0.min.js"></script>
<script src="${context}/js/angular/angular-animate.min.js"></script>
<script src="${context}/js/angular/ocLazyLoad.js"></script>
<script src="${context}/js/bootstrap/bootstrap.min.js"></script>
<script src="${context}/js/plugins/navgoco/jquery.navgoco.min.js"></script>

<script src="${context}/js/plugins/morris/raphael.js"></script>
<script src="${context}/js/plugins/morris/morris.js"></script>

<script src="${context}/js/plugins/chartjs/Chart.min.js"></script>

<script src="${context}/js/plugins/ui-events/event.js"></script>

<script
	src="${context}/js/plugins/growl/angular-growl-notifications.min.js"></script>

<script src="${context}/js/plugins/pace/pace.min.js"></script>

<script
	src="${context}/js/plugins/bootstrap-slider/truck/js/bootstrap-slider.js"></script>

<script src="${context}/js/plugins/c3Chart/truck/js/d3.min.js"></script>
<script src="${context}/js/plugins/c3Chart/truck/js/c3.min.js"></script>
<script src="${context}/js/plugins/c3Chart/truck/js/c3-angular.min.js"></script>

<script src="${context}/js/plugins/chartjs/tc-angular-chartjs.min.js"></script>

<script src="${context}/js/plugins/sparkline/jquery.sparkline.min.js"></script>

<script src="${context}/js/plugins/gauge/gauge.min.js"></script>

<script src="${context}/js/plugins/ui-tree/angular-ui-tree.min.js"></script>

<script src="${context}/js/plugins/switchery/switchery.min.js"></script>
<script src="${context}/js/plugins/switchery/ui-switchery.js"></script>

<!-- <script src="http://maps.google.com/maps/api/truck/js?sensor=true"></script> -->
<script src="${context}/js/plugins/ui-maps/ui-map.js"></script>
<script
	src="${context}/js/plugins/jvectormap/truck/js/jquery-jvectormap-2.0.1.min.js"></script>
<script
	src="${context}/js/plugins/jvectormap/truck/js/jquery-jvectormap-us-aea-en.js"></script>

<script
	src="${context}/js/plugins/dataTables/truck/js/jquery.dataTables.js"></script>
<script
	src="${context}/js/plugins/dataTables/truck/js/dataTables.bootstrap.js"></script>
<script
	src="${context}/js/plugins/dataTables/truck/js/angular-datatables.min.js"></script>

<script src="${context}/js/plugins/icheck/truck/js/icheck.min.js"></script>
<script src="${context}/js/plugins/weather/truck/js/skycons.js"></script>
<script src="${context}/js/plugins/calendar/moment.js"></script>
<script src="${context}/js/plugins/calendar/clndr.js"></script>
<script src="${context}/js/plugins/dropzone/truck/js/dropzone.min.js"></script>
<script src="${context}/js/plugins/mask/truck/js/jasny-bootstrap.min.js"></script>
<script src="${context}/js/plugins/editors/textAngular-sanitize.js"></script>
<script src="${context}/js/plugins/editors/textAngular.min.js"></script>
<script src="${context}/js/plugins/fullscreen/jquery.fullscreen-min.js"></script>

<script src="${context}/js/app.js"></script>
<script src="${context}/js/directives.js"></script>

<script src="${context}/js/vendor/jquery-1.11.1.min.js"></script>

<script src="${context}/js/plugins/pace/pace.min.js"></script>
 <script type="text/javascript">
var images = [];
images[0] = "/img/freight_logo1.jpg";
images[1] = "/img/freight_logo1.jpg";
images[2] = "/img/freight_logo1.jpg";


	var tenantId = '';
	var count=3;
	var i=0;
	$(function() {
	});
	
	   function startTimer() {
           setInterval(setImageSrc, 5000);
       }

	   startTimer()
	   
	function setImageSrc()
	{
	var img1=document.getElementById('img1');
	if(count==3){
		i=0;
		count=2;
	}
	else if(count==2){
		i=1;
		count=1;
	}
	else if(count==1){
		i=2;
		count=3;
	}
	img1.src=images[i];
	}
</script> 

<script>
	angular.module('neuboard', []).controller('signins',
			[ '$scope','$http', function($scope,$http) {
				
				 $scope.tenantId = $('#tenantId').val();
				 
				$scope.list = [];
				$scope.text = 'hello';
				$scope.submit = function() {
					if ($scope.text) {
						/*  $scope.list.push(this.text);
						 $scope.text = ''; */
						console.log("Login succeeded");
					} else {
						console.log("Login succeeded");
					}
				};
				
				$scope.forgetpassword = function(emailId) {
					/* alert($scope.tenantId); */
					/* alert($scope.forget.emailId); */
					var test = $scope.tenantId+'/app/usermaster/forgetPassword?emailId=' + $scope.forget.emailId;
					console.log(test);
			          $http.get($scope.tenantId+'/app/usermaster/forgetPassword?emailId=' + $scope.forget.emailId).success(function(datas) {
			            // alert(JSON.stringify(datas));
			            console.log("response is" + datas);
			            if (datas.success == true) {
			                alert("Password has been sent to your MailID");
			                
			                 errorForgetMessage.innerHTML = 'Please Check Your mail For reseeting';
			            } else {
			               /*  alert("Invalid UserID"); */

			            }
			            console.log(datas);
			        });  
			    }
				
			} ]);
</script>
<script type="text/javascript">
	$(function() {
		//var tenantId = $('#tenantId').val();
		//$('#formId').attr('action','/'+tenantId)
	});
</script>
</head>

<body ng-app="neuboard" ng-controller="signins" onload=""
	class="ng-scope   pace-done pace-done">
	<div class="top_logo">
	
  <img src="/img/MBKHelpVideos/imgpsh_fullsize_anim.jpg"></div>


		
				
				
	<section class="container animated fadeInUp" style="width: 100%">
	<form class="form-horizontal ng-valid ng-dirty ng-valid-parse" role="form" action="${context}/login" method="post" id="formId">
								<div class="container">
								<input type="hidden" name="domaininfo" id="domain_info">
								<input type="hidden" name="macAddress" id="macAddress">
			<div id="login-box">
				<div class="logo" align="center">
				<img src="/img/MBKHelpVideos/Dental_Council_of_India_logo.png" style="width: 20%">
<!-- 					 <label style="font-size: 33px;font-style: oblique !important;">DCI </label>
 -->				</div> 
				<br>
				<!-- /.logo -->
				<header>
					<div style="text-align: center;">
						<!-- <h6>
							<span style="color: black;font-style: oblique !important;">Enter your username and password and click on login.</span>
						</h6> -->
					</div>					
				</header>
				<div class="controls">
					<input type="text" placeholder="Username" class="form-control"
						id="username" name="username" ng-model="credentials.username"
						required /> <input type="password" style="margin-top: 5px;"
						placeholder="Password" class="form-control" id="password"
						name="password" ng-model="credentials.password" required />
					<button type="submit" class="btn btn-default btn-block btn-custom">Login</button>
					<div style="text-align: center;">
						<h6>
							<span style="color: red;">${message}</span>
						</h6>
					<!-- 	 <a data-toggle="modal" data-target="#myModal3"
							style="cursor: pointer;" data-dismiss="modal">Forgot
							Password?</a> -->
					</div>
				</div>

				<input type="hidden" value="${tenantId}" name="tenantId"
					id="tenantId">
				<!-- /.controls -->
			</div>
			<!-- /#login-box -->
		</div>
	</form>						
			
			
				
					
					
				
			
		

	</section>
	<!--Global JS-->
	<!-- <div class="backstretch "
		style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 104px; width: 100%; z-index: -999999; position: fixed;">
		<img class="w3-animate-fading" id="img1"
			style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 100%; width: 100%; z-index: -999999; position: fixed;"
			src="">
	</div> -->
	
	
	<div class="modal fade"  id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-left:40%;margin-top:5%; ">
			<div class="modal-content" style="width: 60%;  border-radius:20px 0 0 0; border:0;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">X</button>
					<h4 class="modal-title">Forgot Password</h4>
				</div>
				<div class="modal-body">
					<form role="form" method="GET">
						<div class="controls">			
							
									
								<input type="text" class="form-control" style="background :rgb(98, 96, 96);  color: white; font-family: 'Nunito', sans-serif;"
						id="emailId" name="emailId" ng-model="forget.emailId" placeholder = "UserID"
						required autocomplete="off"/> 
							<br>
						</div>
						<button class="btn btn-default btn-block btn-custom" type="submit" style="background :#1a1475"
							ng-click="forgetpassword(forget.emailId)">Submit</button>
						
					</form>

				</div>
			

			</div>

		</div>

	</div>
</body>

</html>