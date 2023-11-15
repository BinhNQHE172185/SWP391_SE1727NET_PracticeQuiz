<%-- 
    Document   : ExpertStudentList
    Created on : Oct 13, 2023, 4:01:39 PM
    Author     : QUYBINH
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Expert" %>
<%@page import= "Model.Question" %>
<%@page import= "Model.Subject" %>
<%@page import = "java.util.*" %>
<%@ page import="Model.Answer" %>
<%@ page import="Model.Quiz" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Subject" %>
<%@ page import="Model.SubjectDimension" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
    <head>
        <%
            Expert ex = (Expert) session.getAttribute("currExpert");
            Subject subject = (Subject) request.getAttribute("subject");
            Question question = (Question)request.getAttribute("question");
        %>
        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="Quiz Think" />

        <!-- OG -->
        <meta property="og:title" content="Quiz Think" />
        <meta property="og:description" content="Quiz Think" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Expert Profile</title>

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
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/style.css">
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
                        <%
                            if (ex != null){
                        %>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="<%=ex.getAvatar()%>" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="ExpertProfile">My profile</a></li>
                                    <li><a href="Logout">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                        <%
                            }
                        %>
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
                            <a href="ExpertProfile" class="ttr-material-button">
                                <span class="ttr-icon"><i class="fa fa-user"></i></span>
                                <span class="ttr-label">Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="ExpertSubjectList" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Subject</span>
                            </a>
                        </li>
                        <li>
                            <a href="ExpertStudentList" class="ttr-material-button">
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
                        <li>Question List</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <div style="text-align: left;" class="col-lg-6 m-b10">
                        <h3>Quiz List</h3>
                    </div>                 
                </div>
                <div class="row">
                    <!-- Your Profile Views Chart END-->
                    <!-- Quiz list display-->
                    <%
                    List<Quiz> quizzes = (List<Quiz>) request.getAttribute("quizzes");

                    if (quizzes != null && !quizzes.isEmpty()) {
                        for (Quiz quiz : quizzes) {
                    %>
                    <div class="col-md-12 col-lg-12 col-sm-12 m-b20">
                        <div class="cours-bx">
                            <div class="d-flex" id="quiz<%= quiz.getQuizId() %>">
                                <div class="info-bx col-md-6 col-lg-6 col-sm-6 text-left border-right">
                                    <div class="col-md-12 col-lg-12 col-sm-12 text-left border-bottom">
                                        <h5><%= quiz.getContent() %></h5>
                                        <%
                                        if (quiz.getType() == 0) {
                                        %>
                                        <span>Select all that apply</span>
                                        <%
                                        } else {
                                        %>
                                        <span>Select <%= quiz.getType() %> that apply</span>
                                        <%
                                        }
                                        %>
                                    </div>
                                    <div class="col-md-12 col-lg-12 col-sm-12 text-left m-t20">
                                        <span>Explanation: <%= quiz.getDescription() %></span>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-sm-6 cours-more-info">
                                    <div class="review col-md-12 col-lg-12 col-sm-12">
                                        <ul class="option">
                                            <%
                                            List<Answer> answers = (List<Answer>) request.getAttribute("answers" + quiz.getQuizId());
                                                                
                                            if (answers != null && !answers.isEmpty()) {
                                                for (Answer answer : answers) {
                                            %>
                                            <li class="<%= answer.isCorrect() %>">
                                                <input type="checkbox" name="quiz<%= quiz.getQuizId() %>" id="choice<%= answer.getAnswerId() %>"
                                                       onclick="toggleEffect(this,<%= quiz.getType() %>)">
                                                <label class = "answer-containser" for="choice<%= answer.getAnswerId() %>">
                                                    <h5><%= answer.getContent() %></h5>
                                                </label>
                                            </li>
                                            <%
                                                }
                                            } else {
                                            %>
                                            <p>No answer found.</p>
                                            <%
                                            }
                                            %>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    } else {
                    %>
                    <p>No quizzes found.</p>
                    <%
                    }
                    %>
                    <!-- Quiz list display END-->
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
