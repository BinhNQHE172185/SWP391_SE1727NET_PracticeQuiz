<%-- 
    Document   : QuestionList
    Created on : Sep 20, 2023, 2:49:12 PM
    Author     : kimdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Account" %>
<%@ page import="Model.Answer" %>
<%@ page import="Model.Quiz" %>
<%@ page import="Model.Question" %>
<%@ page import="Model.Subject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

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
        <title>EduChamp : Education HTML Template </title>

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
            <%
                Subject subject = (Subject) request.getAttribute("subject");
                Question question = (Question)request.getAttribute("question");
            %>
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/banner/banner3.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white"><%= subject.getTitle() %></h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Science</li>
                            <li>Computer science</li>
                            <li>Software Engineering</li>
                            <li><%= subject.getTitle() %></li>
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
                                            <form action="QuizSearchServlet" method="GET"> <!-- Replace "/search" with the appropriate form submission URL -->
                                                <div class="input-group">
                                                    <label for="dzName">Search Quiz</label>
                                                    <input id="dzName" name="searchQuery" type="text" required class="form-control">
                                                    <input type="hidden" name="questionId" value="<%= question.getQuestionId() %>">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="widget">
                                        <a href="#"><img src="FrontEnd/assets/images/adv/adv.jpg" alt=""/></a>
                                    </div>
                                    <div class="widget recent-posts-entry widget-courses">
                                        <h5 class="widget-title style-1">Recent Subject</h5>
                                        <div class="widget-post-bx">
                                            <div class="widget-post clearfix">
                                                <div class="ttr-post-media"> <img src="FrontEnd/assets/images/blog/recent-blog/pic1.jpg" width="200" height="143" alt=""> </div>
                                                <div class="ttr-post-info">
                                                    <div class="ttr-post-header">
                                                        <h6 class="post-title"><a href="#">Introduction EduChamp</a></h6>
                                                    </div>
                                                    <div class="ttr-post-meta">
                                                        <ul>
                                                            <li class="review">03 Questions</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="widget-post clearfix">
                                                <div class="ttr-post-media"> <img src="FrontEnd/assets/images/blog/recent-blog/pic3.jpg" width="200" height="160" alt=""> </div>
                                                <div class="ttr-post-info">
                                                    <div class="ttr-post-header">
                                                        <h6 class="post-title"><a href="#">English For Tommorow</a></h6>
                                                    </div>
                                                    <div class="ttr-post-meta">
                                                        <ul>
                                                            <li class="review">07 Questions</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <!-- Breadcrumb row -->
                                    <div class="breadcrumb-row">
                                        <div class="container">
                                            <ul class="list-inline">
                                                <li><a href="#">Home</a></li>
                                                <li>Science</li>
                                                <li>Computer science</li>
                                                <li>Software Engineering</li>
                                                <li><%= subject.getTitle() %></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- Breadcrumb row END -->
                                    <div class="row">
                                        <!-- Question detail display-->
                                        <%
                                        if (question != null) {
                                        %>
                                        <div class="col-md-12 col-lg-12 col-sm-12 m-b30">
                                            <div class="cours-bx detail">
                                                <div class="col-md-6 col-lg-6 col-sm-12 info-bx text-left">
                                                    <img src="<%= question.getImageURL() %>" alt="" />
                                                </div>
                                                <div class="col-md-6 col-lg-6 col-sm-12 info-bx text-left d-flex align-items-center flex-column question-navigation">
                                                    <button class="submit-btn detail"><h4>Learn quiz</h4></button>
                                                    <button class="submit-btn detail" onclick="showExamPopup()"><h4>New exam</h4></button>
                                                    <button class="submit-btn detail"><h4>View history</h4></button>
                                                </div>
                                                <!-- The Exam Popup -->
                                                <div id="examPopup" class="exam-popup">
                                                    <div class="exam-popup-content">
                                                        <button class="submit-btn quit" onclick="closeExamPopup()">X</button>
                                                        <h3>Exam Information</h3>
                                                        <h5><%= question.getQuizCount() %> quiz</h5>
                                                        <h5>Duration: <%= question.getDuration() %></h5>
                                                        <h5>Higher than <%= question.getRequirement() %>% to pass</h5>

                                                        <!-- Add exam information here -->
                                                        <form class = "text-center m-t20" action="QuizHandleServlet" method="POST">
                                                            <input type="hidden" name="questionId" value="<%= question.getQuestionId() %>">
                                                            <button type="submit" class="submit-btn detail">Start Exam</button>
                                                        </form>
                                                    </div>
                                                </div>
                                                <!-- The Exam Popup END-->
                                                <div class="info-bx text-left detail">
                                                    <h5><%= question.getTitle() %><%= question.getQuestionId() %></h5>
                                                    <br>
                                                    <span><%= question.getQuizCount() %> quiz</span>
                                                    <br>
                                                    <span>Duration: <%= question.getDuration() %></span>
                                                    <br>
                                                    <span>Requirement: <%= question.getRequirement() %>%</span>
                                                    <br>
                                                    <span>Created Date: <%= question.getCreatedDate() %></span>
                                                    <br>
                                                    <p>Description: <%= question.getDescription() %></p>
                                                </div>
                                                <div class="col-md-12 col-lg-12 col-sm-12 cours-more-info">
                                                    <div class="review"><!-- show current progress, show passed + icon if completed-->
                                                        <h5>Passed</h5>
                                                        <i class="fa fa-check"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            } else {
                                        %>
                                        <p>No info</p>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <!-- Question detail display END-->

                                    <div class="row"><h4>Quizzes list:</h4></div>
                                    <div class="row">
                                        <!-- Question list display-->
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
                                        <!-- Question list display END-->
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
                                                        <a href="QuestionDetailServlet?questionId=<%= question.getQuestionId() %>&page=<%= currentPage - 1 %>">
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
                                                        <a href="QuestionDetailServlet?questionId=<%= question.getQuestionId() %>&page=<%= i %>">
                                                            <%= i %>
                                                        </a>
                                                    </li>
                                                    <% } %>
                                                    <% } %>

                                                    <%-- For displaying Next link --%>
                                                    <% if (currentPage < noOfPages) { %>
                                                    <li class="next">
                                                        <a href="QuestionDetailServlet?questionId=<%= question.getQuestionId() %>&page=<%= currentPage + 1 %>">
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
        <script src='FrontEnd/assets/vendors/switcher/switcher.js'></script>
    </body>

</html>
