<%-- 
    Document   : HistoryList
    Created on : Oct 10, 2023, 11:08:21 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:10:19 GMT -->

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
            <script src="admin/assets/js/html5shiv.min.js"></script>
            <script src="admin/assets/js/respond.min.js"></script>
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

        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/assets.css">
        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/typography.css">
        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/shortcodes/shortcodes.css">
        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="FrontEnd/assets/css/color/color-1.css">
        <!-- REVOLUTION SLIDER CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/vendors/revolution/css/layers.css">
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/vendors/revolution/css/settings.css">
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/vendors/revolution/css/navigation.css">
        <style>
            .submit-btn {
                display: block;
                padding: 10px 20px;
                text-align: center;
                font-size: 16px;
                color: white;
                background-color: #4CAF50;
                border: none;
                border-radius: 4px;
                text-decoration: none;
                margin: 20px auto;
                width: 300px;
                align-items: center;
                background-color: #f7b205;
                color: #4c1864;
            }
        </style>
    </head>

    <body id="bg">

        <!-- header start -->
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/banner/banner3.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Your Practiced Quiz</h1>
                        </div> 
                    </div>
                </div>
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Question List</a></li>
                            <li>Your Practiced Quiz</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="container">
                                <div class="row wc-title">
                                    <div class="col-lg-2 text-center">
                                        <h4>Attempt</h4>
                                    </div>
                                    <div class="col-lg-2 text-center">
                                        <h4>Taken Date</h4>
                                    </div>
                                    <div class="col-lg-2 text-center">
                                        <h4>Taken Time</h4>
                                    </div>
                                    <div class="col-lg-2 text-center">
                                        <h4>Answered</h4>
                                    </div>
                                    <div class="col-lg-2 text-center">
                                        <h4>Mark/10</h4>
                                    </div> 
                                    <div class="col-lg-2 text-center">
                                        <h4>Detail</h4>
                                    </div>
                                </div>
                                <div class="widget-inner">
                                    <c:set var="i" value="1"/> 
                                    <c:forEach items = "${listResult}" var = "o">
                                        <div class="row card-courses-list admin-courses">
                                            <div class="col-lg-2 text-center">
                                                <p>${i}</p>
                                            </div>
                                            <div class="col-lg-2 text-center">
                                                <p>${o.takenDate} </p>
                                            </div>
                                            <div class="col-lg-2 text-center">
                                                <p>${o.takenDuration}</p>
                                            </div>
                                            <div class="col-lg-2 text-center">
                                                <p>${(o.mark*o.quizCount)/10}/${o.quizCount}</p>
                                            </div>
                                            <div class="col-lg-2 text-center">
                                                <p>${o.mark}/10</p>
                                            </div>
                                            <div class="col-lg-2 text-center">
                                                <a href="ViewPracticedDetail?resultId=${o.resultId}">View</a>
                                            </div>
                                        </div>   
                                        <c:set var="i" value="${i + 1}"/>
                                    </c:forEach>                                                               
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
                <Button class="submit-btn" onclick="location.href='/QuizThink/home'">Back to question list</button>
            </div>
            <!-- contact area END -->


            <!-- External JavaScripts -->
        </div>
        <!-- Content END-->
        <!-- Footer ==== -->
        <jsp:include page="footer.jsp"/>
        <!-- Footer END ==== -->
        <button class="back-to-top fa fa-chevron-up" ></button>
    </div>
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
    <script src='admin/assets/vendors/switcher/switcher.js'></script>
</body>
<!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>
