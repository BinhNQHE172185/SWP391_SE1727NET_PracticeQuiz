<%@page import = "Model.Answer" %>
<%@page import = "DAO.AnswerDAO" %>
<%@page import = "java.util.*" %>
<%@page import = "java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <style>
            .question-box {
                border: 1px solid #ccc;
                padding: 20px;
                border-bottom-left-radius: 10px;
                border-bottom-right-radius: 10px;


            }

            .question {
                border-bottom: 1px solid #ccc;
                padding-bottom: 10px;
                font-weight: bold;
            }

            h2.question-title {
                text-decoration: underline;
            }

            .answers {
                margin: 15px 20px;
            }

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
                background-color: #4c1864;
                color: white;
            }

            .explanation {
                margin-top: 20px;
                padding: 10px;
                background: #f2f2f2;
                border: 1px solid #ddd;
                margin-bottom: 20px;
            }

            .table {
                margin-top: 50px;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }

            td {
                padding: 5px 10px;
                border: 1px solid #ccc;
            }

            .underline {
                text-decoration: underline;
                padding-bottom: 5px;
                margin-bottom: 5px;
            }

            /* Đáp án đúng - Màu nền xanh */
            input[type="radio"].correct {
                background-color: greenyellow; /* Màu xanh lam */
            }

            /* Đáp án sai - Màu nền đỏ */
            input[type="radio"].incorrect {
                background-color: red; /* Màu đỏ */
            }
        </style>
    </head>
    <body id="bg">

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
                            <h1 class="text-white">Your Result</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Practiced list</a></li>
                            <li>Your Result</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="container">

                    <table class="table">
                        <tr>
                            <td style="font-weight: bold;">Taken Date:</td>
                            <td>${rs.getTakenDate()}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold;">Taken Time:</td>
                            <td>${rs.getTakenDuration()}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold;">Right Answer:</td> 
                            <td>${rs.quizCount}/${listQuiz.size()}</td>
                        </tr>
                        <tr>
                            <td style="font-weight: bold;">Mark:</td>
                            <td>${rs.getMark()}/10</td> 
                        </tr>
                    </table>

                    <div class="question-box">
                        <c:set var="i" value="0"/>
                        <c:forEach items = "${listQuiz}" var = "o" >
                            <div class="question">
                                ${o.content}
                            </div>

                            <div class="answers">
                                <c:set var="answerList" value="${answerMap[o.quizId]}"/>                                                        
                                <c:forEach var="answer" items="${answerList}">   
                                    <c:set var="checked" value="false"/>
                                    <c:forEach items="${selectedAnswers}" var="selectedAnswer">
                                        <c:if test="${answer.answerId == selectedAnswer}">
                                            <c:set var="checked" value="true"/> 
                                        </c:if>
                                    </c:forEach>
                                    <input type="radio" name="question_${o.quizId}" ${checked ? 'checked' : ''} disabled
                                           class="${checked && answer.isCorrect() ? 'correct' : 'incorrect'}"> ${answer.content} <br>

                                    <c:if test="${answer.isCorrect() == true}">
                                        <c:set var="correctAnswer" value="${answer}"/>
                                    </c:if>
                                </c:forEach>                              

                            </div>

                            <div class="explanation">
                                <p style="margin-bottom: 1px;">Correct Answer:<span class="underline"> ${correctAnswer.content}</span> </p>
                                <p>Explain: ${o.description}</p>
                            </div>                            
                        </c:forEach>
                    </div>
                   <button class="submit-btn" onclick="window.history.back()">Back to list practiced</button>
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
        <script src='FrontEnd/assets/vendors/switcher/switcher.js'></script>
        <script>
            // JavaScript to remove margin  
            const explanations = document.querySelectorAll('.explanation');
            const lastExplanation = explanations[explanations.length - 1];
            lastExplanation.style.marginBottom = '0';
        </script>
    </body>

</html>
