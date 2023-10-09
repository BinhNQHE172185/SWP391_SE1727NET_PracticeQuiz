<%-- 
    Document   : SubjectApproval
    Created on : Sep 18, 2023, 4:49:13 PM
    Author     : Dell
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
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
	<link rel="icon" href="../error-404.html" type="image/x-icon" />
	<link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png" />
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>EduChamp : Education HTML Template </title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.min.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/assets.css">
	<link rel="stylesheet" type="text/css" href="admin/assets/vendors/calendar/fullcalendar.css">
	
	<!-- TYPOGRAPHY ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/typography.css">
	
	<!-- SHORTCODES ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/shortcodes/shortcodes.css">
	
	<!-- STYLESHEETS ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
	<link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">
	<link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">
    </head>
    <body>
        <jsp:include page="Dashboard_header.jsp"></jsp:include>  
        <!--Main container start -->
	<main class="ttr-wrapper">
		<div class="container-fluid">
			<div class="db-breadcrumb">
				<h4 class="breadcrumb-title">Courses</h4>
				<ul class="db-breadcrumb-list">
					<li><a href="#"><i class="fa fa-home"></i>Home</a></li>
					<li>Courses</li>
				</ul>
			</div>	
			<div class="row">
				<!-- Your Subject Views Chart -->
				<div class="col-lg-12 m-b30">
					<div class="widget-box">
						<div class="wc-title">
							<h4>Courses</h4>
						</div>
                                        <c:forEach items="${listSubject}" var="o">
                                            <div class="widget-inner">
							<div class="card-courses-list admin-courses">
								<div class="card-courses-media">
									<img src="${o.imageURL}" alt=""/>
								</div>
								<div class="card-courses-full-dec">
									<div class="card-courses-title">
										<h4>${o.title}</h4>
									</div>
									<div class="card-courses-list-bx">
										<ul class="card-courses-view">
<!--											<li class="card-courses-user">
												<div class="card-courses-user-pic">
													<img src="assets/images/testimonials/pic3.jpg" alt=""/>
												</div>
												<div class="card-courses-user-info">
													<h5>Teacher</h5>
													<h4>Keny White</h4>
												</div>
											</li>-->
											<li class="card-courses-categories">
												<h5>Created Date</h5>
												<h4>${o.createdDate}</h4>
											</li>
											<li class="card-courses-categories">
												<h5>Numbers of Question </h5>
                                                                                                <h4>${o.questionCount}</h4>
											</li>
											<li class="card-courses-stats">
												<a href="#" class="btn button-sm green radius-xl">Pending</a>
											</li>
											<li class="card-courses-stats">
												<del>LEVEL</del>
												<h5 class="text-primary">${o.level}</h5>
											</li>
										</ul>
									</div>
									<div class="row card-courses-dec">
										<div class="col-md-12">
											<h6 class="m-b10">Course Description</h6>
                                                                                        <p>${o.description}</p>
                                                                                </div>
										<div class="col-md-12">
                                                                                    <form action="approve" method="POST">
                                                                                        <input type="hidden" name="SubjectID" value="${o.subjectId}">
                                                                                        <button type="submit" class="btn green radius-xl outline" >Approve</button>
                                                                                    </form>
											
<!--											<a href="#" class="btn red outline radius-xl ">Cancel</a>-->
										</div>
									</div>
									
								</div>
							</div>
						</div>
                                        </c:forEach>
                                            <!-- End innter -->
					</div>
				</div>
				<!-- Your Subject Views Chart END-->
			</div>
		</div>
	</main>
       <!-- External JavaScripts -->
        <script src="admin/assets/js/jquery.min.js"></script>
        <script src="admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="admin/assets/vendors/masonry/masonry.js"></script>
        <script src="admin/assets/vendors/masonry/filter.js"></script>
        <script src="admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="admin/assets/js/functions.js"></script>
        <script src="admin/assets/vendors/chart/chart.min.js"></script>
        <script src="admin/assets/js/admin.js"></script>
        <script src='admin/assets/vendors/calendar/moment.min.js'></script>
        <script src='admin/assets/vendors/calendar/fullcalendar.js'></script>

        <!-- <script src='assets/vendors/switcher/switcher.js'></script> -->
    <script>
      $(document).ready(function() {

        $('#calendar').fullCalendar({
          header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
          },
          defaultDate: '2019-03-12',
          navLinks: true, // can click day/week names to navigate views

          weekNumbers: true,
          weekNumbersWithinDays: true,
          weekNumberCalculation: 'ISO',

          editable: true,
          eventLimit: true, // allow "more" link when too many events
          events: [
            {
              title: 'All Day Event',
              start: '2019-03-01'
            },
            {
              title: 'Long Event',
              start: '2019-03-07',
              end: '2019-03-10'
            },
            {
              id: 999,
              title: 'Repeating Event',
              start: '2019-03-09T16:00:00'
            },
            {
              id: 999,
              title: 'Repeating Event',
              start: '2019-03-16T16:00:00'
            },
            {
              title: 'Conference',
              start: '2019-03-11',
              end: '2019-03-13'
            },
            {
              title: 'Meeting',
              start: '2019-03-12T10:30:00',
              end: '2019-03-12T12:30:00'
            },
            {
              title: 'Lunch',
              start: '2019-03-12T12:00:00'
            },
            {
              title: 'Meeting',
              start: '2019-03-12T14:30:00'
            },
            {
              title: 'Happy Hour',
              start: '2019-03-12T17:30:00'
            },
            {
              title: 'Dinner',
              start: '2019-03-12T20:00:00'
            },
            {
              title: 'Birthday Party',
              start: '2019-03-13T07:00:00'
            },
            {
              title: 'Click for Google',
              url: 'http://google.com/',
              start: '2019-03-28'
            }
          ]
        });

      });

    </script>
    </body>
</html>
