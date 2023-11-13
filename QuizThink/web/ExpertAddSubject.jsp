<%-- 
    Document   : ExpertStudentList
    Created on : Oct 13, 2023, 4:01:39 PM
    Author     : QUYBINH
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Expert" %>
<%@page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <!--sidebar menu toggler start -->
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <!--sidebar menu toggler end -->
                <!--logo start -->
                <div class="ttr-logo-box">
                    <div>
                        <a href="home" class="ttr-logo">
                            <img class="ttr-logo-mobile" alt="" src="FrontEnd\assets\images\Logo1.png" width="30" height="30">
                            <img class="ttr-logo-desktop" alt="" src="FrontEnd\assets\images\Logo1.png" width="160" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <!-- header left menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="home" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="../courses.html">Our Courses</a></li>
                                    <li><a href="../event.html">New Event</a></li>
                                    <li><a href="../membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header left menu end -->
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <!-- header right menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="#" class="ttr-material-button ttr-search-toggle"><i class="fa fa-search"></i></a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="#" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="user-profile.html">My profile</a></li>
                                    <li><a href="../login.html">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header right menu end -->
                </div>
                <!--header search panel start -->
                <div class="ttr-search-bar">
                    <form class="ttr-search-form">
                        <div class="ttr-search-input-wrapper">
                            <input type="text" name="qq" placeholder="search something..." class="ttr-search-input">
                            <button type="submit" name="search" class="ttr-search-submit"><i class="ti-arrow-right"></i></button>
                        </div>
                        <span class="ttr-search-close ttr-search-toggle">
                            <i class="ti-close"></i>
                        </span>
                    </form>
                </div>
                <!--header search panel end -->
            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <!-- side menu logo start -->
                <div class="ttr-sidebar-logo">
                    <a href="#"><img alt="" src="FrontEnd\assets\images\Logo1-Purple.png" width="180" height="45"></a>
                    <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                            <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                            <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
                    </div> -->
                    <div class="ttr-sidebar-toggle-button">
                        <i class="ti-arrow-left"></i>
                    </div>
                </div>
                <!-- side menu logo end -->
                <!-- sidebar menu start -->
                <nav class="ttr-sidebar-navi">
                    <ul>
                        <li>
                            <a href="Profile" class="ttr-material-button">
                                <span class="ttr-icon"><i class="fa fa-user"></i></span>
                                <span class="ttr-label">Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Subject</span>
                            </a>
                        </li>
                        <li>
                            <a href="ExpertStudentList.jsp" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Student List</span>
                            </a>
                        </li>

                        <li class="ttr-seperate"></li>
                    </ul>
                    <!-- sidebar menu end -->
                </nav>
                <!-- sidebar menu end -->
            </div>
        </div>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <ul class="db-breadcrumb-list">
                        <li><a href="home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li>Subject</li>
                        <li>Add Question</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <!-- Your Profile Views Chart END-->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Add Subject</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="ExpertAddSubject" method="POST">
                                    <div class="row">

                                        <div class="form-group col-7">
                                            <input type="hidden" value="" name="subjectID">
                                            <input type="hidden" value="" name="expertID">
                                            <label class="col-form-label">Subject title</label>
                                            <div>
                                                <input class="form-control" type="text" value="" name="title" required="">
                                            </div>
                                        </div>
                                        <div class="form-group col-5">
                                            <label class="col-form-label">Subject dimension</label>
                                            <div>
                                                <select name="dimension" class="form-control">
                                                    <c:forEach items="${listDimension}" var="o">
                                                        <option value="${o.subjectDimensionId}">${o.title}</option>       
                                                    </c:forEach> 
                                                </select>
                                            </div>
                                        </div>                                       
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Image URL</label>
                                            <div>
                                                <input class="form-control" type="text" value="" name="imageURL" required="">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Subject description</label>
                                            <div>
                                                <textarea class="form-control" name="desc"> </textarea>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button type="submit" class="btn">Add Subject</button>
                                            <button type="button" class="btn-secondry" onclick="window.history.back()">Cancel</button>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </main>
        <div class="ttr-overlay"></div>

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
        <script>
                                                $(document).ready(function () {

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

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
