<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Testkiller</title>
<style>
.gm-control-active>img {
	box-sizing: content-box;
	display: none;
	left: 50%;
	pointer-events: none;
	position: absolute;
	top: 50%;
	transform: translate(-50%, -50%)
}

.gm-control-active>img:nth-child(1) {
	display: block
}

.gm-control-active:hover>img:nth-child(1), .gm-control-active:active>img:nth-child(1),
	.gm-control-active:disabled>img:nth-child(1) {
	display: none
}

.gm-control-active:hover>img:nth-child(2), .gm-control-active:active>img:nth-child(3),
	.gm-control-active:disabled>img:nth-child(4) {
	display: block
}
</style>
<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Google+Sans_old:400,500,700|Google+Sans+Text:400">
<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Google+Sans+Text:400&amp;text=%E2%86%90%E2%86%92%E2%86%91%E2%86%93">
<style>
.gm-ui-hover-effect {
	opacity: .6
}

.gm-ui-hover-effect:hover {
	opacity: 1
}
</style>
<style>
.gm-style .gm-style-cc a, .gm-style .gm-style-cc button, .gm-style .gm-style-cc span,
	.gm-style .gm-style-mtc div {
	font-size: 10px;
	box-sizing: border-box
}

.gm-style .gm-style-cc a, .gm-style .gm-style-cc button, .gm-style .gm-style-cc span
	{
	outline-offset: 3px
}
</style>
<style>
@media print {
	.gm-style .gmnoprint, .gmnoprint {
		display: none
	}
}

@media screen {
	.gm-style .gmnoscreen, .gmnoscreen {
		display: none
	}
}
</style>
<style>
.dismissButton {
	background-color: #fff;
	border: 1px solid #dadce0;
	color: #1a73e8;
	border-radius: 4px;
	font-family: Roboto, sans-serif;
	font-size: 14px;
	height: 36px;
	cursor: pointer;
	padding: 0 24px
}

.dismissButton:hover {
	background-color: rgba(66, 133, 244, 0.04);
	border: 1px solid #d2e3fc
}

.dismissButton:focus {
	background-color: rgba(66, 133, 244, 0.12);
	border: 1px solid #d2e3fc;
	outline: 0
}

.dismissButton
:focus
:not
 
(
:focus-visible
 
){
background-color
:
 
#fff
;

	
border
:
 
1
px
 
solid
 
#dadce0
;

	
outline
:
 
none


}
.dismissButton:focus-visible {
	background-color: rgba(66, 133, 244, 0.12);
	border: 1px solid #d2e3fc;
	outline: 0
}

.dismissButton:hover:focus {
	background-color: rgba(66, 133, 244, 0.16);
	border: 1px solid #d2e2fd
}

.dismissButton
:hover
:focus
:not
 
(
:focus-visible
 
){
background-color
:
 
rgba
(66
,
133,
244,
0
.04
);

	
border
:
 
1
px
 
solid
 
#d2e3fc


}
.dismissButton:hover:focus-visible {
	background-color: rgba(66, 133, 244, 0.16);
	border: 1px solid #d2e2fd
}

.dismissButton:active {
	background-color: rgba(66, 133, 244, 0.16);
	border: 1px solid #d2e2fd;
	box-shadow: 0 1px 2px 0 rgba(60, 64, 67, 0.3), 0 1px 3px 1px
		rgba(60, 64, 67, 0.15)
}

.dismissButton:disabled {
	background-color: #fff;
	border: 1px solid #f1f3f4;
	color: #3c4043
}
</style>
<style>
.gm-style-moc {
	background-color: rgba(0, 0, 0, 0.45);
	pointer-events: none;
	text-align: center;
	transition: opacity ease-in-out
}

.gm-style-mot {
	color: white;
	font-family: Roboto, Arial, sans-serif;
	font-size: 22px;
	margin: 0;
	position: relative;
	top: 50%;
	transform: translateY(-50%);
	-webkit-transform: translateY(-50%);
	-ms-transform: translateY(-50%)
}
</style>
<style>
.gm-style img {
	max-width: none;
}

.gm-style {
	font: 400 11px Roboto, Arial, sans-serif;
	text-decoration: none;
}
</style>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<!-- /Added by HTTrack -->
 
<!--[if lt IE 10]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 

<link rel="icon"
	href="https://colorlib.com/polygon/admindek/files/assets/images/favicon.ico"
	type="image/x-icon">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:500,700"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/waves.min.css" type="text/css"
	media="all">

<link rel="stylesheet" type="text/css" href="css/feather.css">

<link rel="stylesheet" type="text/css" href="css/font-awesome-n.min.css">


<link rel="stylesheet" type="text/css" href="css/datatables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css" href="css/buttons.datatables.min.css">

<link rel="stylesheet" href="css/chartist.css" type="text/css"
	media="all">

 
<link rel="stylesheet" type="text/css" href="css/component.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/pages.css">

<link rel="stylesheet" type="text/css" href="css/widget.css">
<script type="text/javascript" async=""
	src="https://www.google-analytics.com/analytics.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/common.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/util.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/map.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/marker.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/infowindow.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/controls.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="https://maps.google.com/maps-api-v3/api/js/48/2/onion.js"></script>

</head>

<body themebg-pattern="theme1">



	<div id="pcoded" class="pcoded iscollapsed" nav-type="st2"
		theme-layout="vertical" vertical-placement="left"
		vertical-layout="wide" pcoded-device-type="desktop"
		vertical-nav-type="expanded" vertical-effect="shrink"
		vnavigation-view="view1" fream-type="theme1" layout-type="light">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">



			<jsp:include page="StudentHeader.jsp"></jsp:include>




			<div class="pcoded-main-container" style="margin-top: 70.3906px;">
				<div class="pcoded-wrapper">

					<jsp:include page="StudentSideBar.jsp"></jsp:include>


					<div class="pcoded-content">

						<div class="page-header card">
							<div class="row align-items-end">
								<div class="col-lg-8">
									<div class="page-header-title">
										<i class="feather icon-home bg-c-blue"></i>
										<div class="d-inline">
											<h5>Welcome, ${student.studentName }</h5>
											
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="#!"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Dashboard
													</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>

						<div class="pcoded-inner-content">
							<div class="main-body">
								<div class="page-wrapper">
									<div class="page-body">

										<div class="row">

											<div class="col-xl-3 col-md-6">
												<div class="card prod-p-card card-red">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white">Total Members</h6>
																<h3 class="m-b-0 f-w-700 text-white">${totalUserCount}</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-money-bill-alt text-c-red f-18"></i>
															</div>
														</div>
														<p class="m-b-0 text-white">
															<span class="label label-danger m-r-10">+11%</span>From
															Previous Month
														</p>
													</div>
												</div>
											</div>
											<div class="col-xl-3 col-md-6">
												<div class="card prod-p-card card-blue">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white">On Board Developers</h6>
																<h3 class="m-b-0 f-w-700 text-white">${totalDeveloperCount}</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-database text-c-blue f-18"></i>
															</div>
														</div>
														<p class="m-b-0 text-white">
															<span class="label label-primary m-r-10">+12%</span>From
															Previous Month
														</p>
													</div>
												</div>
											</div>
											<div class="col-xl-3 col-md-6">
												<div class="card prod-p-card card-green">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white">Average Price</h6>
																<h3 class="m-b-0 f-w-700 text-white">$6,780</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-dollar-sign text-c-green f-18"></i>
															</div>
														</div>
														<p class="m-b-0 text-white">
															<span class="label label-success m-r-10">+52%</span>From
															Previous Month
														</p>
													</div>
												</div>
											</div>
											<div class="col-xl-3 col-md-6">
												<div class="card prod-p-card card-yellow">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white">Product Sold</h6>
																<h3 class="m-b-0 f-w-700 text-white">6,784</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-tags text-c-yellow f-18"></i>
															</div>
														</div>
														<p class="m-b-0 text-white">
															<span class="label label-warning m-r-10">+52%</span>From
															Previous Month
														</p>
													</div>
												</div>
											</div>

















										</div>

									</div>
								</div>
							</div>
						</div>
					</div>

					<div id="styleSelector"></div>

				</div>
			</div>
		</div>
	</div>

 <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logoutstudent">Logout</a>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

	<script src="js/waves.min.js" type="text/javascript"></script>

	<script type="text/javascript" src="js/jquery.slimscroll.js"></script>

	<script type="text/javascript" src="js/jquery.datatables.min.js"></script>

	<script src="js/jquery.flot.js" type="text/javascript"></script>
	<script src="js/jquery.flot.categories.js" type="text/javascript"></script>
	<script src="js/curvedlines.js" type="text/javascript"></script>
	<script src="js/jquery.flot.tooltip.min.js" type="text/javascript"></script>

	<script src="js/amcharts.js" type="text/javascript"></script>
	<script src="js/serial.js" type="text/javascript"></script>
	<script src="js/light.js" type="text/javascript"></script>

	<script src="js/markerclusterer.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="https://maps.google.com/maps/api/js?sensor=true"></script>
	<script type="text/javascript" src="js/gmaps.js"></script>

	<script src="js/pcoded.min.js" type="text/javascript"></script>
	<script src="js/vertical-layout.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/crm-dashboard.min.js"></script>
	<script type="text/javascript" src="js/script.min.js"></script>
	<script type="text/javascript" src="js/html2pdf.js"></script>

	<script async=""
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"
		type="text/javascript"></script>
	<script type="text/javascript">
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>



</body>

</html>