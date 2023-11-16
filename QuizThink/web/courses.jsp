

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>QUIZ THINK-Online Quiz Practice Web </title>

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

            <!-- Header Top ==== -->
            <jsp:include page="header.jsp" />
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/background/fpt1.png);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Our Courses</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="home">Home</a></li>
                            <li>Our Courses</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <div class="widget courses-search-bx placeani">
                                        <div class="form-group">
                                            <form action="SearchSubject" method="GET"> 
                                                <div class="input-group">
                                                    <label for="dzName">Search Subject</label>
                                                    <input id="dzName" name="searchQuery" type="text" required class="form-control">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="widget widget_archive">
                                        <h5 class="widget-title style-1">All Courses</h5>

                                        <ul>
                                            <c:if test="${listDimension == null}">
                                                <div> no Category</div>
                                            </c:if>
                                            <c:forEach items= "${listDimension}" var="o" >
                                                <li class="active"><a href="SubjectList?subjectDimensionId=${o.subjectDimensionId}">${o.title}</a></li>
                                                </c:forEach>
                                        </ul>

                                    </div>
                                    <div class="widget">
                                        <a href="#"><img src="FrontEnd/assets/images/adv/adv.jpg" alt=""/></a>
                                    </div>
                                    <div class="widget recent-posts-entry widget-courses">
                                        <h5 class="widget-title style-1">Recent Courses</h5>
                                        <c:forEach items="${recentSubjects}" var="r" varStatus="loopStatus">
                                            <c:if test="${loopStatus.index < 3}">
                                                <div class="widget-post-bx">
                                                    <div class="widget-post clearfix">
                                                        <div class="ttr-post-media"> <img src="${r.imageURL}" width="200" height="143" alt=""> </div>
                                                        <div class="ttr-post-info">
                                                            <div class="ttr-post-header">
                                                                <h6 class="post-title"><a href="subjectdetail?pid=${r.subjectId}">${r.title}</a></h6>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>

                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="row">
                                        <c:if test="${subjects == null}">
                                            <div> no subject</div>
                                        </c:if>
                                        <c:forEach items="${subjects}" var="o">
                                            <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                                <div class="cours-bx">
                                                    <div class="action-box">
                                                        <div class = "info-bx text-center question-image"  ><img src="${o.imageURL}" alt=""> </div>    

                                                        <a href="subjectdetail?pid=${o.subjectId}" class="btn">Read More</a>
                                                    </div>
                                                    <div class="info-bx text-center">
                                                        <h5><a href="#">${o.title }</a></h5>
                                                        <span>Programming</span>
                                                    </div>

                                                </div>
                                            </div>
                                        </c:forEach>


                                        <!-- Pagination list display-->
                                        <%
                                            int currentPage = 1; // Set the current page value
                                            int noOfPages = 5; // Set the total number of pages
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
                                                        <a href="SubjectList?subjectDimensionId=${subjectDimensionId}&page=<%= currentPage - 1 %>&noOfPages=<%= noOfPages %>">
                                                            <i class="ti-arrow-left"></i> Prev
                                                        </a>
                                                    </li>
                                                    <% } %>

                                                    <%-- For displaying pages --%>
                                                    <% for (int i = 1; i <= noOfPages; i++) { %>
                                                    <% if (currentPage == i) { %>
                                                    <li class="active"><a><%= i %></a></li>
                                                            <% } else { %>
                                                    <li>
                                                        <a href="SubjectList?subjectDimensionId=${subjectDimensionId}&page=<%= i %>&noOfPages=<%= noOfPages %> %>">
                                                            <%= i %>
                                                        </a>
                                                    </li>
                                                    <% } %>
                                                    <% } %>

                                                    <%-- For displaying Next link --%>
                                                    <% if (currentPage < noOfPages) { %>
                                                    <li class="next">
                                                        <a href="SubjectList?subjectDimensionId=${subjectDimensionId}&page=<%= currentPage + 1 %>&noOfPages=<%= noOfPages %>%>">
                                                            Next <i class="ti-arrow-right"></i>
                                                        </a>
                                                    </li>
                                                    <% } %>
                                                </ul>
                                            </div>
                                        </div>
                                        <% } %>
                                        <!-- Pagination list end-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- contact area END -->

            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <jsp:include page="footer.jsp"/>
            <!-- Footer END ==== -->
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
        <script src="FrontEnd/assets/js/functions.js"></script>
        <script src="FrontEnd/assets/js/contact.js"></script>
        <!--<script src='FrontEnd/assets/vendors/switcher/switcher.js'></script>-->
    </body>

</html>
