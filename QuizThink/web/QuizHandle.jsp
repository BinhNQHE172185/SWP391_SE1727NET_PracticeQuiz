<%-- 
    Document   : QuizHandle
    Created on : Sep 20, 2023, 2:36:48 PM
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
<%@ page import="java.sql.Time" %>


<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content />
        <meta name="author" content />
        <meta name="robots" content />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="FrontEnd/assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="FrontEnd/FrontEnd/assets/images/favicon.png" />

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
        <link rel="stylesheet" type="text/css"
              href="FrontEnd/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css"
              href="FrontEnd/assets/css/color/color-1.css">

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <style>
                .custom-sticky-header {
                    position: sticky;
                    top: 0;
                    z-index: 1000;
                }
            </style>
            <header class="custom-sticky-header header rs-nav">
                <div class="navbar-expand-lg">
                    <div class="menu-bar clearfix">
                        <div class="container clearfix">
                            <!-- Header Logo ==== -->
                            <div class="menu-logo">
                                <a href="home.jsp"><img src="FrontEnd/assets/images/Logo1-Purple.png" alt=""></a>
                            </div>
                            <!-- Mobile Nav Button ==== -->
                            <button class="navbar-toggler collapsed menuicon justify-content-end"
                                    type="button" data-toggle="collapse" data-target="#menuDropdown"
                                    aria-controls="menuDropdown" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                            <!-- Navigation Menu ==== -->
                            <div class="menu-links navbar-collapse collapse justify-content-start"
                                 id="menuDropdown">
                                <div class="menu-logo">
                                    <a href="index.html"><img src="FrontEnd/assets/images/logo.png" alt></a>
                                </div>
                                <ul class="nav navbar-nav quiz-handle-nav">
                                    <h3 class="question-title">Chapter 1</h3>
                                    <div class="counter-container">
                                        <!-- Counter display for quizzes completed -->
                                        <h4>Quiz completed:</h4>
                                        <h4 id="quiz-counter">0</h4>
                                        <%
                                        Question question = (Question) session.getAttribute("question");
                                        List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");
                                        Time time = (Time) session.getAttribute("endTime");
                                        List<Integer> quizIds = new ArrayList<>();
                                        if ( quizzes != null){
                                            for (Quiz quiz : quizzes) {
                                                quizIds.add(quiz.getQuizId());
                                            }
                                        }
                                        if (question != null) {
                                        %>
                                        <h4>/<%= quizzes.size() %></h4>
                                        <%
                                            }
                                        %>
                                        <div id="submitQuestionId" data-submitQuestionId="<%= question.getQuestionId() %>"></div>
                                        <div id="endTimeElement" data-endTime="<%= time %>"></div>
                                    </div>
                                    <div class="question-timer-container">
                                        <h4>Timer:</h4>
                                        <h4 id="question-timer"></h4>
                                    </div>

                                </ul>
                                <div class="nav-social-link">
                                    <a href="javascript:;"><i class="fa fa-facebook"></i></a>
                                    <a href="javascript:;"><i class="fa fa-google-plus"></i></a>
                                    <a href="javascript:;"><i class="fa fa-linkedin"></i></a>
                                </div>
                            </div>
                            <!-- Navigation Menu END ==== -->
                        </div>
                    </div>
                    <!-- Quiz nav -->
                    <div id="quiz-nav">
                        <%
                            if (quizzes != null && !quizzes.isEmpty()) {
                                for (int i = 1; i <= quizzes.size(); i++) {
                                    Quiz quiz = quizzes.get(i-1);
                        %>
                        <button id = "quiz-nav-btn-quiz<%= quiz.getQuizId() %>" onclick="scrollToQuiz(<%= quiz.getQuizId() %>)"><%= i %></button>
                        <%
                            }
                        }
                        %>
                    </div>
                    <!-- Quiz nav END-->
                </div>
            </header>
            <!-- header END ==== -->
            <!-- Quiz -->
            <div class="page-content bg-white">
                <div class="content-block">
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="row"><h4>Quiz list:</h4></div>
                                    <div class="row">
                                        <!-- Quiz list display-->
                                        <%
                                        if (quizzes != null && !quizzes.isEmpty()) {
                                            for (int i = 1; i <= quizzes.size(); i++) {
                                                Quiz quiz = quizzes.get(i-1);
                                        %>
                                        <div class="col-md-12 col-lg-12 col-sm-12 m-b20">
                                            <div class="cours-bx">
                                                <div id="quiz<%= quiz.getQuizId() %>">
                                                    <div class="col-md-12 col-lg-12 col-sm-12 text-left border-bottom m-t20">
                                                        <h5>Question <%= i %>: <%= quiz.getContent() %></h5>
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
                                                    <div class="col-md-12 col-lg-12 col-sm-12 cours-more-info">
                                                        <div class="review col-md-12 col-lg-12 col-sm-12">
                                                            <ul class="option">
                                                                <%
                                                                List<Answer> answers = (List<Answer>) session.getAttribute("answers" + quiz.getQuizId());
                                                                if (answers != null && !answers.isEmpty()) {
                                                                    for (Answer answer : answers) {
                                                                %>
                                                                <li>
                                                                    <input type="checkbox" name="quiz<%= quiz.getQuizId() %>" id="<%= answer.getAnswerId() %>"
                                                                           onclick="toggleEffect(this,<%= quiz.getType() %>)">
                                                                    <label class = "answer-container" for="<%= answer.getAnswerId() %>">
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
                                        <div class="col-lg-12 m-b20">
                                            <div class="pagination-bx rounded-sm gray clearfix">
                                                <ul class="pagination">
                                                    <li class="previous"><a href="#"><i class="ti-arrow-left"></i> Prev</a></li>
                                                    <li class="active"><a href="#">1</a></li>
                                                    <li><a href="#">2</a></li>
                                                    <li><a href="#">3</a></li>
                                                    <li class="next"><a href="#">Next <i class="ti-arrow-right"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Quiz END-->
            <div class="submit-container">
                <button class="submit-btn" onclick="submitQuiz()">
                    <h4>Submit</h4>
                </button>
            </div>
            <button class="back-to-top fa fa-chevron-up"></button>
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
        <script src="FrontEnd/assets/js/quizHandle.js"></script>
        <script src='FrontEnd/assets/vendors/switcher/switcher.js'></script>
    </body>

</html>

