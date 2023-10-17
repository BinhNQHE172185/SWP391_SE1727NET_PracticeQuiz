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
                            <td>20/${listQuiz.size()}</td>
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
                                <c:set var="selectedChoices" value="${intArray.i}"/>                               

                                <c:forEach var="answer" items="${answerList}">     
                                    <c:set var="checked" value="${fn:contains(selectedChoices, answer.answerId)}"/>
                                    <input type="radio" name="question_${o.quizId}" ${checked ? 'checked' : ''}> ${answer.content} <br>

                                    <c:if test="${answer.isCorrect() == true}">
                                        <c:set var="correctAnswer" value="${answer}"/>
                                    </c:if>
                                </c:forEach>                              

                            </div>

                            <div class="explanation">
                                <p style="margin-bottom: 1px;">Correct Answer:<span class="underline"> ${correctAnswer.content}</span> </p>
                                <p>Explain: ${o.description}</p>
                            </div>
                            <c:set var="i" value="${i + 1}"/>
                        </c:forEach>
                    </div>

                    <a class="submit-btn" href="">Back to practiced list</a>
                </div>
                <!-- contact area END -->

            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <footer>
                <div class="footer-top">
                    <div class="pt-exebar">
                        <div class="container">
                            <div class="d-flex align-items-stretch">
                                <div class="pt-logo mr-auto">
                                    <a href="index.html"><img src="FrontEnd/assets/images/logo-white.png" alt=""/></a>
                                </div>
                                <div class="pt-social-link">
                                    <ul class="list-inline m-a0">
                                        <li><a href="#" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                                <div class="pt-btn-join">
                                    <a href="#" class="btn ">Join Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-12 col-sm-12 footer-col-4">
                                <div class="widget">
                                    <h5 class="footer-title">Sign Up For A Newsletter</h5>
                                    <p class="text-capitalize m-b20">Weekly Breaking news analysis and cutting edge advices on job searching.</p>
                                    <div class="subscribe-form m-b20">
                                        <form class="subscription-form" action="http://educhamp.themetrades.com/demo/FrontEnd/assets/script/mailchamp.php" method="post">
                                            <div class="ajax-message"></div>
                                            <div class="input-group">
                                                <input name="email" required="required"  class="form-control" placeholder="Your Email Address" type="email">
                                                <span class="input-group-btn">
                                                    <button name="submit" value="Submit" type="submit" class="btn"><i class="fa fa-arrow-right"></i></button>
                                                </span> 
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-5 col-md-7 col-sm-12">
                                <div class="row">
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Company</h5>
                                            <ul>
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="about-1.html">About</a></li>
                                                <li><a href="faq-1.html">FAQs</a></li>
                                                <li><a href="contact-1.html">Contact</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Get In Touch</h5>
                                            <ul>
                                                <li><a href="http://educhamp.themetrades.com/admin/index.html">Dashboard</a></li>
                                                <li><a href="blog-classic-grid.html">Blog</a></li>
                                                <li><a href="portfolio.html">Portfolio</a></li>
                                                <li><a href="event.html">Event</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Courses</h5>
                                            <ul>
                                                <li><a href="courses.html">Courses</a></li>
                                                <li><a href="courses-details.html">Details</a></li>
                                                <li><a href="membership.html">Membership</a></li>
                                                <li><a href="profile.html">Profile</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-5 col-sm-12 footer-col-4">
                                <div class="widget widget_gallery gallery-grid-4">
                                    <h5 class="footer-title">Our Gallery</h5>
                                    <ul class="magnific-image">
                                        <li><a href="FrontEnd/assets/images/gallery/pic1.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic1.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic2.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic2.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic3.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic3.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic4.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic4.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic5.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic5.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic6.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic6.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic7.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic7.jpg" alt=""></a></li>
                                        <li><a href="FrontEnd/assets/images/gallery/pic8.jpg" class="magnific-anchor"><img src="FrontEnd/assets/images/gallery/pic8.jpg" alt=""></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 text-center"> <a target="_blank" href="https://www.templateshub.net">Templates Hub</a></div>
                        </div>
                    </div>
                </div>
            </footer>
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
