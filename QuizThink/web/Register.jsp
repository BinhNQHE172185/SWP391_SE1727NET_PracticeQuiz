<%-- 
    Document   : Register
    Created on : Sep 18, 2023, 11:04:52 PM
    Author     : LEMONLORD
--%>

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
        <title>Quiz Think : Prepare to Quiz Think with Awesomeness! </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
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

        <% String Pstatus = (String) request.getAttribute("Pstatus"); %>
        <% String Ustatus = (String) request.getAttribute("Ustatus"); %>
        <% String UserExistStatus = (String) request.getAttribute("UserExistStatus"); %>
        <% String emailExistStatus = (String) request.getAttribute("emailExistStatus"); %>

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <div class="account-form">
                <div class="account-head" style="background-image:url(FrontEnd/assets/images/background/bg2.jpg);">
                    <a href="home"><img src="FrontEnd/assets/images/Logo2.png" alt=""></a>
                </div>
                <div class="account-form-inner">
                    <div class="account-container">
                        <div class="heading-bx left">
                            <h2 class="title-head">Sign Up <span>Now</span></h2>
                            <p>Login Your Account <a href="Login">Click here</a></p>
                        </div>	
                        <form class="contact-bx" action="RegisterUser" method="Post">
                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Username</label>
                                            <input name="username" type="text" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <% if(Ustatus !=null){ %>
                                <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                    <%=
                                    Ustatus
                                    %>
                                </div>
                                <%}%>
                                <% if(UserExistStatus !=null){ %>
                                <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                    <%=
                                    UserExistStatus
                                    %>
                                </div>
                                <%}%>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Your Email Address</label>
                                            <input name="email" type="email" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <% if(emailExistStatus !=null){ %>
                                <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                    <%=
                                    emailExistStatus
                                    %>
                                </div>
                                <%}%>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <label>Your Password</label>
                                            <input name="password" type="password" class="form-control" required="">
                                        </div>
                                    </div>
                                </div>
                                <% if(Pstatus !=null){ %>
                                <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                    <%=
                                    Pstatus
                                    %>
                                </div>
                                <%}%>
                                <div class="form-group col-lg-6 m-b30" style="visibility: hidden;">
                                     <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="customControlAutosizing" name="expert">
                                    <label class="custom-control-label" for="customControlAutosizing">I am a teacher</label>
                                </div>
                            </div>
                            <div class="col-lg-12 m-b30">
                                <button name="submit" type="submit" value="Submit" class="btn button-md">Sign Up</button>
                            </div>
                    </div>
                    </form>
                </div>
            </div>
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
</body>

</html>

