<%-- 
    Document   : ExpertStudentList
    Created on : Oct 13, 2023, 4:01:39 PM
    Author     : QUYBINH
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "Model.*" %>
<%@page import= "java.util.*" %>
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

        <% List<Subject> subject = (List<Subject>) request.getAttribute("list");%>
        <% List<SubjectStatus> subjectStatus = (List<SubjectStatus>) request.getAttribute("subjectStatus");%>
        <% List<Account> account = (List<Account>) request.getAttribute("studentList");%>
        <% List<Account> student = (List<Account>) request.getAttribute("student");%>
        <% 
            int subjectId = (Integer) session.getAttribute("subjectId");
        %>


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
                        <a href="home.jsp" class="ttr-logo">
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
                            <a href="home.jsp" class="ttr-material-button ttr-submenu-toggle">HOME</a>
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
                                    <li><a href="ExpertProfile">My profile</a></li>
                                    <li><a href="Logout">Logout</a></li>
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
                        <li>Student List</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <!-- Your Profile Views Chart END-->
                    <div class="container-fluid">
                        <table>
                            <tr>
                                <td>
                                    <label style="text-align: left;">Subject</label>
                                    <form action="ExpertStudentShowList" class="form" onsubmit="countRows()">
                                        <div class="input-group">
                                            <select class="form-select" name="option">
                                                <option>Select Subject</option>
                                                <% if(subject!=null){%>
                                                <%for(Subject s : subject){%>
                                                <option value="<%=s.getSubjectId()%>"><%=s.getTitle()%></option>
                                                <%}}%>
                                            </select>
                                            <div style="margin-left: 10px">
                                                <button type="submit" class="btn btn-success"> Submit</button>
                                            </div>
                                        </div>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </div>


                </div>
                <div class="row">
                    <div style="text-align: left;" class="col-lg-6 m-b10">
                        <h3>Student List</h3>
                    </div>
                    <div id="Ebtn" class="col-lg-6 m-b10">
                        <div style="display: flex;justify-content: flex-end;">
                            <button type="button" class="btn btn-btn-primary" data-toggle="modal" data-target="#exampleModalCenter"><i class="fa fa-plus"></i> Add new student</button>
                            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <form action="ExpertAddStudent" method="POST">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalCenterTitle">Add new Student</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="success-message" style="display:none; color: green; margin-top: 10px; margin-left: 20px;">
                                                Add Successfully!
                                            </div>
                                            <div class="empty-message" style="display:none; color: red; margin-top: 10px; margin-left: 20px;">
                                                Empty!
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <input type="email" name="email" class="form-control" placeholder="Type student's email">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary">Add</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="dropdown">
                                <button class="btn btn-success" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-sort"></i> Sort
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="ShowStudentListAsc">By Name Asc</a>
                                    <a class="dropdown-item" href="ShowStudentListDesc">By Name Desc</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <section>
                    <div>
                        <section class="content">
                            <div class="row">
                                <div class="col-lg-12 m-b30">
                                    <div class="box">
                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <table id="example2" class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Full Name</th>
                                                        <th>Email</th>
                                                        <th>Gender</th>
                                                        <th>Date of Birth</th>
                                                        <th>Erolled Date</th>
                                                        <th>History</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="userdata">
                                                    <% if (account != null && subjectStatus != null) { %>
                                                    <% for (Account acc : account) { %>
                                                    <tr>
                                                        <td><%= acc.getFullname() %></td>
                                                        <td><%= acc.getEmail() %></td>
                                                        <td><%= acc.getGender() %></td>
                                                        <td><%= acc.getDob() %></td>
                                                        <td><%= acc.getCreatedDate() %></td>
                                                        <td><a href="ExpertStudentHistory?AccountId=<%=acc.getAccountId()%>">View</a></td>
                                                        <td><a href="ExpertRemoveStudent?accountId=<%=acc.getAccountId()%>">Remove</a></td>
                                                    </tr>
                                                    <% } %>
                                                    <% } %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                            <div >
                                <ul class="pagination">	
                                    <c:forEach begin="1" end="${lastPage}" var="i">
                                        <li <c:if test="${i == currentPage}">class="active"</c:if>><a data-param="page" data-value="${i}" onclick="handleLinkClick(event, this)">${i}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </section>
                    </div>
                </section>
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
        <script>
            function showSuccessMessage() {
                var emailInput = document.querySelector('input[name="email"]');
                var successMessage = document.querySelector('.success-message');
                var emptyMessage = document.querySelector('.empty-message');

                if (emailInput && emailInput.value.trim() !== '') {
                    successMessage.style.display = 'block';
                    emptyMessage.style.display = 'none';
                } else {
                    emptyMessage.style.display = 'block';
                    successMessage.style.display = 'none';
                }
            }
        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
