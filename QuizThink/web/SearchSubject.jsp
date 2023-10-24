<%-- 
    Document   : SearchSubject
    Created on : Oct 22, 2023, 4:15:29 PM
    Author     : minhk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <meta name="description" content="Search Results" />
        <!-- OG -->
        <meta property="og:title" content="Search Results" />
        <meta property="og:description" content="Search Results" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="FrontEnd/assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="FrontEnd/assets/images/favicon.png" />
        <!-- PAGE TITLE HERE ============================================= -->
        <title>Search Results</title>
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

            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/background/fpt1.png);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Search Results</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="home.jsp">Home</a></li>
                            <li>Search Results</li>
                        </ul>
                    </div>
                </div>
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- Section for displaying search results -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <c:if test="${subjects.size() == 0}">
                                    <p>No subjects found.</p>
                                </c:if>

                                <c:forEach items="${subjects}" var="subject">
                                    <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <div class="info-bx text-center question-image">
                                                    <img src="${subject.imageURL}" alt="">
                                                </div>
                                                <a href="subjectdetail?pid=${subject.subjectId}" class="btn">Read More</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <h5><a href="#">${subject.title}</a></h5>
                                                <span>Programming</span>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                                <!-- Pagination -->
                                <%
                                    int currentPage = 1; // Set the current page value
                                    int noOfPages = 5; // Set the total number of pages
                                    if (request.getAttribute("currentPage") != null) {
                                        currentPage = (int) request.getAttribute("currentPage");
                                    }
                                    if (request.getAttribute("noOfPages") != null) {
                                        noOfPages = (int) request.getAttribute("noOfPages");
                                    }
                                    if (noOfPages > 1) {
                                %>
                                <div class="col-lg-12 m-b20">
                                    <div class="pagination-bx rounded-sm gray clearfix">
                                        <ul class="pagination">
                                            <!-- For displaying Previous link except for the 1st page -->
                                            <%
                                                if (currentPage != 1) {
                                            %>
                                            <li class="previous">
                                                <a href="SearchSubject?page=<%= currentPage - 1 %>&noOfPages=<%= noOfPages %>">
                                                    <i class="ti-arrow-left"></i> Prev
                                                </a>
                                            </li>
                                            <%
                                                }
                                            %>

                                            <!-- For displaying pages -->
                                            <%
                                                for (int i = 1; i <= noOfPages; i++) {
                                                    if (currentPage == i) {
                                            %>
                                            <li class="active"><a><%= i %></a></li>
                                                    <%
                                                            } else {
                                                    %>
                                            <li>
                                                <a href="SearchSubject?page=<%= i %>&noOfPages=<%= noOfPages %>">
                                                    <%= i %>
                                                </a>
                                            </li>
                                            <%
                                                    }
                                                }
                                            %>

                                            <!-- For displaying Next link -->
                                            <%
                                                if (currentPage < noOfPages) {
                                            %>
                                            <li class="next">
                                                <a href="SearchSubject?page=<%= currentPage + 1 %>&noOfPages=<%= noOfPages %>">
                                                    Next <i class="ti-arrow-right"></i>
                                                </a>
                                            </li>
                                            <%
                                                }
                                            %>
                                        </ul>
                                    </div>
                                </div>
                                <% } %>
                                <!-- Pagination list end-->
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Include footer -->
                <jsp:include page="footer.jsp" />

                <button class="back-to-top fa fa-chevron-up"></button>
            </div>
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

