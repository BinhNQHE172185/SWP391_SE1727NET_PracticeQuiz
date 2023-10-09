<%-- 
    Document   : MemberShip
    Created on : Oct 9, 2023, 1:37:52 PM
    Author     : admin
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
            
        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <jsp:include page = "header.jsp"/>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Membership</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Membership</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp2">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 heading-bx text-center">
                                    <h2 class="title-head text-uppercase m-b0">Set a plan, start practicing and <br/> <span> unlock your potential</span></h2>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
                                </div>
                            </div>
                            <div class="pricingtable-row">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6 col-lg-6 m-b40">
                                        <div class="pricingtable-wrapper">
                                            <div class="pricingtable-inner">
                                                <div class="pricingtable-main"> 
                                                    <div class="pricingtable-price"> 
                                                        <span class="priceing-doller">$</span>
                                                        <span class="pricingtable-bx">10</span>
                                                        <span class="pricingtable-type">1 Time payment</span>
                                                    </div>
                                                    <div class="pricingtable-title">
                                                        <h2>Basic</h2>
                                                        <p>We are just getting started</p>
                                                    </div>
                                                </div>
                                                <ul class="pricingtable-features">
                                                    <li>One Time Fee</li>
                                                    <li>3 User</li>
                                                    <li>Lifetime Availability</li>
                                                    <li>Unlock New Features</li>
                                                    <li>30 days Listing</li>
                                                    <li>24/7 Support</li>
                                                    <li>Select</li>
                                                </ul>
                                                <div class="pricingtable-footer"> 
                                                    <a href="#" class="btn radius-xl" id="get-it-now-button">Get It Now</a>
                                                    <span class="tooltip" id="tooltip-text">Membership already included</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12 col-md-6 col-lg-6 m-b40">
                                        <div class="pricingtable-wrapper">
                                            <div class="pricingtable-inner">
                                                <div class="pricingtable-main"> 
                                                    <div class="pricingtable-price"> 
                                                        <span class="priceing-doller">$</span>
                                                        <span class="pricingtable-bx">20</span>
                                                        <span class="pricingtable-type">1 Time payment</span>
                                                    </div>
                                                    <div class="pricingtable-title">
                                                        <h2>Advanced</h2>
                                                        <p>Experience the best for quiz practicing</p>
                                                    </div>
                                                </div>
                                                <ul class="pricingtable-features">
                                                    <li>One Time Fee</li>
                                                    <li>3 User</li>
                                                    <li>Lifetime Availability</li>
                                                    <li>More Contents</li>
                                                    <li>30 days Listing</li>
                                                    <li>24/7 Support</li>
                                                    <li>Select</li>
                                                </ul>
                                                <div class="pricingtable-footer"> 
                                                    <a href="#" class="btn radius-xl" id="get-it-now-button">Get It Now</a>
                                                    <span class="tooltip" id="tooltip-text">Membership already included</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Our Services ==== -->
                    <div class="section-area section-sp2 bg-fix ovbl-dark join-bx" style="background-image:url(FrontEnd/assets/images/background/bg1.jpg);">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 text-center heading-bx text-white">
                                    <h2 class="title-head m-b0">Why Choose <span>Us</span></h2>
                                    <p class="m-b0">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the</p>
                                </div>
                                <div class="col-md-6">	
                                    <div class="why-chooses-bx ">
                                        <div class="ttr-accordion m-b30 faq-bx" id="accordion1">
                                            <div class="panel">
                                                <div class="acod-head">
                                                    <h6 class="acod-title"> 
                                                        <a data-toggle="collapse" href="#faq1" class="collapsed" data-parent="#faq1">
                                                            Why won't my payment go through? </a> </h6>
                                                </div>
                                                <div id="faq1" class="acod-body collapse">
                                                    <div class="acod-content">Web design aorem apsum dolor sit amet, adipiscing elit, sed diam nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
                                                </div>
                                            </div>
                                            <div class="panel">
                                                <div class="acod-head">
                                                    <h6 class="acod-title"> 
                                                        <a data-toggle="collapse" href="#faq2" class="collapsed" data-parent="#faq2">
                                                            How do I get a refund?</a> </h6>
                                                </div>
                                                <div id="faq2" class="acod-body collapse">
                                                    <div class="acod-content">Graphic design aorem apsum dolor sit amet, adipiscing elit, sed diam nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
                                                </div>
                                            </div>
                                            <div class="panel">
                                                <div class="acod-head">
                                                    <h6 class="acod-title"> 
                                                        <a data-toggle="collapse"  href="#faq3" class="collapsed"  data-parent="#faq3">
                                                            How do I redeem a coupon? </a> </h6>
                                                </div>
                                                <div id="faq3" class="acod-body collapse">
                                                    <div class="acod-content">Developement aorem apsum dolor sit amet, adipiscing elit, sed diam nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
                                                </div>
                                            </div>
                                            <div class="panel">
                                                <div class="acod-head">
                                                    <h6 class="acod-title"> 
                                                        <a data-toggle="collapse"  href="#faq4" class="collapsed"  data-parent="#faq4">
                                                            Why aren't my courses showing in my account? </a> </h6>
                                                </div>
                                                <div id="faq4" class="acod-body collapse">
                                                    <div class="acod-content">Developement aorem apsum dolor sit amet, adipiscing elit, sed diam nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
                                                </div>
                                            </div>
                                            <div class="panel">
                                                <div class="acod-head">
                                                    <h6 class="acod-title"> 
                                                        <a data-toggle="collapse"  href="#faq5" class="collapsed"  data-parent="#faq5">
                                                            Changing account name </a> </h6>
                                                </div>
                                                <div id="faq5" class="acod-body collapse">
                                                    <div class="acod-content">Developement aorem apsum dolor sit amet, adipiscing elit, sed diam nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
                                                </div>
                                            </div>
                                            <div class="panel">
                                                <div class="acod-head">
                                                    <h6 class="acod-title"> 
                                                        <a data-toggle="collapse"  href="#faq6" class="collapsed"  data-parent="#faq6">
                                                            Why aren't my courses showing in my account? </a> </h6>
                                                </div>
                                                <div id="faq6" class="acod-body collapse">
                                                    <div class="acod-content">Developement aorem apsum dolor sit amet, adipiscing elit, sed diam nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">	
                                    <div class="video-bx">
                                        <img src="FrontEnd/assets/images/about/pic1.jpg" alt=""/>
                                        <a href="https://www.youtube.com/watch?v=x_sJzVe9P_8" class="popup-youtube video"><i class="fa fa-play"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- contact area END ==== -->
                <!-- Our Status ==== -->
                <div class="section-area content-inner section-sp1">
                    <div class="container">
                        <div class="section-content">
                            <div class="row">
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30" style="text-align: center;">
                                    <div class="counter-style-1">
                                        <div class="text-primary">
                                            <span class="counter">${subNumber}</span><span></span>
                                        </div>
                                        <span class="counter-text">Completed Subjects</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30" style="text-align: center;">
                                    <div class="counter-style-1">
                                        <div class="text-black">
                                            <span class="counter">${quizNumber}</span><span></span>
                                        </div>
                                        <span class="counter-text">Practice Quizzes</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30" style="text-align: center;">
                                    <div class="counter-style-1">
                                        <div class="text-primary">
                                            <span class="counter">${accNumber}</span><span></span>
                                        </div>
                                        <span class="counter-text">Active Users</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30" style="text-align: center;">
                                    <div class="counter-style-1">
                                        <div class="text-black">
                                            <span class="counter">${expertNumber}</span><span></span>
                                        </div>
                                        <span class="counter-text">Qualified Experts</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Our Status END ==== -->
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <jsp:include page = "footer.jsp"/>
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
            const getItNowButton = document.getElementById("get-it-now-button");
            const tooltip = document.getElementById("tooltip-text");

            // Check if the user has earned the membership (you'll need your own logic here)
            const userHasMembership = true;

            getItNowButton.addEventListener("mouseover", (){
                if (userHasMembership) {
                    tooltip.style.display = "block";
                }
            });

            getItNowButton.addEventListener("mouseout", (){
                tooltip.style.display = "none";
            });
        </script>
    </body>

</html>

