<%-- 
    Document   : SubjectDetail
    Created on : Oct 16, 2023, 3:53:15 PM
    Author     : minhk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

	<!-- META ============================================= -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	
	<!-- DESCRIPTION -->
	<meta name="description" content="EduChamp : Education HTML Template" />
	
	<!-- OG -->
	<meta property="og:title" content="EduChamp : Education HTML Template" />
	<meta property="og:description" content="EduChamp : Education HTML Template" />
	<meta property="og:image" content="" />
	<meta name="format-detection" content="telephone=no">
	
	<!-- FAVICONS ICON ============================================= -->
	<link rel="icon" href="FrontEnd/assets/images/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" type="image/x-icon" href="FrontEnd/assets/images/favicon.png" />
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>QUIZ THINK-Online Quiz Practice Web</title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="FrontEnd/assets/js/html5shiv.min.js"></script>
	<script src="FrontEnd/assets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
	<link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/assets.css">
	
	<!-- TYPOGRAPHY ============================================= -->
	<link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/typography.css">
	
	<!-- SHORTCODES ============================================= -->
	<link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/shortcodes/shortcodes.css">
	
	<!-- STYLESHEETS ============================================= -->
	<link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/style.css">
	<link class="skin" rel="stylesheet" type="text/css" href="FrontEnd/assets/css/color/color-1.css">
	
</head>
<body id="bg">
<div class="page-wraper">
<div id="loading-icon-bx"></div>
<jsp:include page = "header.jsp"/>

    <!-- Content -->
    <div class="page-content bg-white">
        <!-- inner page banner -->
        <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/background/fpt1.png);">
            <div class="container">
                <div class="page-banner-entry">
                    <h1 class="text-white">Courses Details</h1>
				 </div>
            </div>
        </div>
		<!-- Breadcrumb row -->
		<div class="breadcrumb-row">
			<div class="container">
				<ul class="list-inline">
					<li><a href="#">Home</a></li>
					<li>Courses Details</li>
				</ul>
			</div>
		</div>
		<!-- Breadcrumb row END -->
        <!-- inner page banner END -->
		<div class="content-block">
            <!-- About Us -->
			<div class="section-area section-sp1">
                <div class="container">
					 <div class="row d-flex flex-row-reverse">
						<div class="col-lg-3 col-md-4 col-sm-12 m-b30">
							<div class="course-detail-bx">
									
								<div class="course-buy-now text-center">
									<a href="#" class="btn radius-xl text-uppercase">Enroll now</a>
								</div>
								<div class="teacher-bx">
									<div class="teacher-info">
										<div class="teacher-thumb">
											<img src="${expert.avatar}" alt=""/>
										</div>
										<div class="teacher-name">
											<h5>${expert.username}</h5>
											<span>${expert.name}</span>
										</div>
									</div>
								</div>
								<div class="cours-more-info">
									<div class="review">
										<span>3 Review</span>
										<ul class="cours-star">
											<li class="active"><i class="fa fa-star"></i></li>
											<li class="active"><i class="fa fa-star"></i></li>
											<li class="active"><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
										</ul>
									</div>
									<div class="price categories">
										<span>Categories</span>
										<h5 class="text-primary">Frontend</h5>
									</div>
								</div>
								<div class="course-info-list scroll-page">
									<ul class="navbar">
										<li><a class="nav-link" href="#overview"><i class="ti-zip"></i>Overview</a></li>
										
										<li><a class="nav-link" href="#reviews"><i class="ti-comments"></i>Reviews</a></li>
									</ul>
								</div>
							</div>
						</div>
					
						<div class="col-lg-9 col-md-8 col-sm-12">
							<div class="courses-post">
								<div class="ttr-post-media media-effect">
									<a href="#"><img src="${subjectdetail.imageURL}" alt=""></a>
								</div>
								<div class="ttr-post-info">
									<div class="ttr-post-title ">
										 <h2 class="post-title">${subjectdetail.title}</h2>
									</div>
									<div class="ttr-post-text">
										<p>${subjectdetail.description}</p>
									</div>
								</div>
							</div>
							<div class="courese-overview" id="overview">
								<h4>Overview</h4>
								<div class="row">
									<div class="col-md-12 col-lg-4">
										<ul class="course-features">
											<li><i class="ti-book"></i> <span class="label">Questions</span> <span class="value">${subjectdetail.questionCount}</span></li>
											<li><i class="ti-help-alt"></i> <span class="label">Requirement</span> <span class="value">${subjectdetail.requirement}%</span></li>
											<li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
											<li><i class="ti-stats-up"></i> <span class="label">Rate</span> <span class="value">${subjectdetail.rate}</span></li>
											<li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
											
										
										</ul>
									</div>
									<div class="col-md-12 col-lg-8">
										<h5 class="m-b5">Course Description</h5>
										<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
										
									</div>
								</div>
							</div>
							
							
							<div class="" id="reviews">
								<h4>Reviews</h4>
								
								<div class="review-bx">
									<div class="all-review">
										<h2 class="rating-type">3</h2>
										<ul class="cours-star">
											<li class="active"><i class="fa fa-star"></i></li>
											<li class="active"><i class="fa fa-star"></i></li>
											<li class="active"><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
										</ul>
										<span>3 Rating</span>
									</div>
									<div class="review-bar">
										<div class="bar-bx">
											<div class="side">
												<div>5 star</div>
											</div>
											<div class="middle">
												<div class="bar-container">
													<div class="bar-5" style="width:90%;"></div>
												</div>
											</div>
											<div class="side right">
												<div>150</div>
											</div>
										</div>
										<div class="bar-bx">
											<div class="side">
												<div>4 star</div>
											</div>
											<div class="middle">
												<div class="bar-container">
													<div class="bar-5" style="width:70%;"></div>
												</div>
											</div>
											<div class="side right">
												<div>140</div>
											</div>
										</div>
										<div class="bar-bx">
											<div class="side">
												<div>3 star</div>
											</div>
											<div class="middle">
												<div class="bar-container">
													<div class="bar-5" style="width:50%;"></div>
												</div>
											</div>
											<div class="side right">
												<div>120</div>
											</div>
										</div>
										<div class="bar-bx">
											<div class="side">
												<div>2 star</div>
											</div>
											<div class="middle">
												<div class="bar-container">
													<div class="bar-5" style="width:40%;"></div>
												</div>
											</div>
											<div class="side right">
												<div>110</div>
											</div>
										</div>
										<div class="bar-bx">
											<div class="side">
												<div>1 star</div>
											</div>
											<div class="middle">
												<div class="bar-container">
													<div class="bar-5" style="width:20%;"></div>
												</div>
											</div>
											<div class="side right">
												<div>80</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						
					</div>
				</div>
            </div>
        </div>
		<!-- contact area END -->
		
    </div>
    <!-- Content END-->
	<jsp:include page="footer.jsp"/>
    <button class="back-to-top fa fa-chevron-up" ></button>
</div>
<!-- External JavaScripts -->
<script src="FrontEnd/assets/js/jquery.min.js"></script>
<script src="FrontEnd/assets/vendors/bootstrap/js/popper.min.js"></script>
<script src="FrontEnd/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
<script src="FrontEnd/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
<script src="FrontEnd/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="FrontEnd/assets/vendors/magnific-popup/magnific-popup.js"></script>
<script src="FrontEnd/assets/vendors/counter/waypoints-min.js"></script>
<script src="FrontEnd/assets/vendors/counter/counterup.min.js"></script>
<script src="FrontEnd/assets/vendors/imagesloaded/imagesloaded.js"></script>
<script src="FrontEnd/assets/vendors/masonry/masonry.js"></script>
<script src="FrontEnd/assets/vendors/masonry/filter.js"></script>
<script src="FrontEnd/assets/vendors/owl-carousel/owl.carousel.js"></script>
<script src="FrontEnd/assets/js/jquery.scroller.js"></script>
<script src="FrontEnd/assets/js/functions.js"></script>
<script src="FrontEnd/assets/js/contact.js"></script>
</body>

</html>

