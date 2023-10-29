<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "Model.SubjectDimension" %>
<%@page import = "java.util.*" %>
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
        <link rel="stylesheet" type="text/css" href="admin/assets/css/add-quiz.css">
    </head>
    <body>
        <%
            String search = (String) request.getAttribute("search");
            int parentId = (int) request.getAttribute("parentId");
            List<SubjectDimension> SDlist = (List<SubjectDimension>) request.getAttribute("SDlist");
        %>
        <jsp:include page="Dashboard_header.jsp"></jsp:include>  

            <!--Main container start -->
            <main class="ttr-wrapper">
                <div class="container-fluid">
                    <div class="db-breadcrumb">
                        <ul class="db-breadcrumb-list">
                            <li><a href="Dashboard.jsp"><i class="fa fa-home"></i>Dashboard</a></li>
                            <li>Subject Dimension</li>
                        </ul>
                    </div>	
                    <!-- Card -->
                    <div class="row">
                        <div class="container-fluid">
                            <table>
                                <tr>
                                    <td>
                                        <label style="text-align: left;">Search</label>
                                        <form action="AdminSDSearch" class="form" method="GET">
                                            <div class="input-group">
                                                <input type="text" name="search" class="form-control" placeholder="Search subject dimension by name">
                                                <div class="input-group-append">
                                                    <button type="submit" class="btn btn-success"><i class="fa fa-search"></i> Search</button>
                                                </div>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div style="text-align: left;" class="col-lg-6 m-b10">
                            <h3>Subject Dimension List</h3>
                            <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                            ${status}
                        </div>
                    </div>
                    <div id="Ebtn" class="col-lg-6 m-b10">
                        <div style="display: flex;justify-content: flex-end;">
                            <form action="AdminAddSD" method="GET">
                                <button class="btn btn-success" type="submit">
                                    <i class="fa fa-plus"></i> Add new subject dimension
                                </button>
                            </form>
                            <div class="dropdown">
                                <button class="btn btn-success" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-sort"></i> Sort
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="AdminSDSortAsc?parentId=<%= parentId %>">By Name Asc</a>
                                    <a class="dropdown-item" href="AdminSDSortDesc?parentId=<%= parentId %>">By Name Desc</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <c:choose>
                        <c:when test="${not empty SDlist}">
                            <c:forEach var="subjectDimension" items="${SDlist}">
                                <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                    <a href="SDDetailServlet?subjectDimensionId=${subjectDimension.subjectDimensionId}">
                                        <div class="cours-bx">
                                            <div class="info-bx text-center question-image">
                                                <img src="${subjectDimension.imageURL}" alt="" />
                                            </div>
                                            <div class="info-bx text-center">
                                                <h5>${subjectDimension.title}</h5>
                                            </div>
                                            <div class="cours-more-info">
                                                <div class="review" style="text-align: center;">
                                                    <span><a href="AdminUpdateSD?subjectDimensionId=${subjectDimension.subjectDimensionId}"><h5>Edit</h5></a></span>
                                                </div>
                                                <div class="review" style="text-align: center;">
                                                    <span><a href="AdminDeleteSD?subjectDimensionId=${subjectDimension.subjectDimensionId}"><h5>Delete</h5></a></span>
                                                </div>
                                                <div class="review" style="text-align: center;">
                                                    <span><a href="AdminSDList?parentId=${subjectDimension.subjectDimensionId}"><h5>View Child SD</h5></a></span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>No subject dimension found.</p>
                        </c:otherwise>
                    </c:choose>

                    <!-- Pagination list display-->
                    <%
                        int currentPage = 1; // Set the current page value
                        int noOfPages = 1; // Set the total number of pages
                        if (request.getAttribute("currentPage") != null ){
                             currentPage = (int) request.getAttribute("currentPage");
                        }
                        if (request.getAttribute("noOfPages") != null ){
                             noOfPages = (int) request.getAttribute("noOfPages");
                        }
                        if (noOfPages > 1) {
                    %>
                    <div class="col-lg-12 m-b20">
                        <div class="pagination-bx rounded-sm gray clearfix">
                            <ul class="pagination">
                                <%-- For displaying Previous link except for the 1st page --%>
                                <% if (currentPage != 1) { %>
                                <li class="previous">
                                    <% if(search==null){%>
                                    <a href="AdminSDList?parentId=<%= parentId %>&page=<%= currentPage - 1 %>">
                                        <i class="ti-arrow-left"></i> Prev
                                    </a>
                                    <%}else{%>
                                    <a href="AdminSDSearch?search=<%=search%>&page=<%= currentPage - 1 %>">
                                        <i class="ti-arrow-left"></i> Prev
                                    </a>
                                    <%}%>
                                </li>
                                <% } %>

                                <%-- For displaying pages --%>
                                <% for (int i = 1; i <= noOfPages; i++) { %>
                                <% if (currentPage == i) { %>
                                <li class="active"><a><%= i %></a></li>
                                        <% } else { %>
                                <li>
                                    <% if(search==null){%>
                                    <a href="AdminSDList?parentId=<%= parentId %>&page=<%= i %>">
                                        <%= i %>
                                    </a>
                                    <%}else{%>
                                    <a href="AdminSDSearch?search=<%=search%>&page=<%= i %>">
                                        <%= i %>
                                    </a>
                                    <%}%>
                                </li>
                                <% } %>
                                <% } %>

                                <%-- For displaying Next link --%>
                                <% if (currentPage < noOfPages) { %>
                                <li class="next">
                                    <% if (search==null){%>
                                    <a href="AdminSDList?parentId=<%= parentId %>&page=<%= currentPage + 1 %>">
                                        Next <i class="ti-arrow-right"></i>
                                    </a>
                                    <%}else{%>
                                    <a href="AdminSDSearch?search=<%=search%>&page=<%= currentPage + 1 %>">
                                        Next <i class="ti-arrow-right"></i>
                                    </a>
                                    <%}%>
                                </li>
                                <% } %>
                            </ul>
                        </div>
                    </div>
                    <% } %>
                    <!-- Pagination list end-->
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
</html>
