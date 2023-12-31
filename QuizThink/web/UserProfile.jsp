<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <link rel="stylesheet" type="text/css" href="admin/assets/css/FrontEnd/assets.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">

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
                <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/banner/banner1.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Welcome ${account.getUsername()}</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Profile</li>
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
                                    <div class="profile-bx text-center">
                                        <div class="user-profile-thumb">
                                            <img src="${account.avatar}" alt="" />
                                        </div>
                                        <div class="profile-info">
                                            <h4>${account.getUsername()}</h4>
                                            <span>${account.getEmail()}</span>
                                            <c:if test="${role.roleId == 2}">
                                                <p style="margin-top: 15px; color: red;">Membership included</p>
                                            </c:if>                                                                                       
                                        </div> 
                                        <div class="profile-social">
                                            <ul class="list-inline m-a0">
                                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="profile-tabnav">
                                            <ul class="nav nav-tabs">
                                                <li class="nav-item">
                                                    <a class="nav-link" href="YourSubject"><i
                                                            class="ti-book"></i>Courses</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link active" href="Profile"><i
                                                            class="ti-pencil-alt"></i>Edit Profile</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="CurrentPassword"><i
                                                            class="ti-lock"></i>Change Password</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                    <div class="profile-content-bx">
                                        <div class="tab-content">
                                            <div class="profile-head">
                                                <h3>Edit Profile</h3>
                                            </div>
                                            <form class="edit-profile" action="UpdateUserProfile" method="post">
                                                <div class="">
                                                    <div class="form-group row">
                                                        <label
                                                            class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Full Name</label>
                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                            <input class="form-control" type="text" name="fullname" value="${account.getFullname()}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label
                                                            class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Email</label>
                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                            <input class="form-control" type="email" name="email" value="${account.getEmail()}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Date of Birth</label>
                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                            <input class="form-control" type="date" name="dob" value="${account.getDob()}">
                                                            <span class="help"></span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 col-form-label">Gender</label>
                                                        <div class="col-sm-7">
                                                            <input type="radio" name="gender" value="male" />Male
                                                            <input type="radio" name="gender" value="female"/>Female
                                                            <input type="radio" name="gender" value="others"/>Others
                                                            <span class="help"></span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label
                                                            class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Avatar(Image URL)</label>
                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                            <input class="form-control" type="text" name="avatar" value="${account.avatar}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 col-form-label">Self-Introduction</label>
                                                        <div class="col-sm-7">
                                                            <input class="form-control" type="text" name="introduction" value="${account.getSelfIntroduction()}">
                                                            <span class="help">Tell something about yourself.</span>
                                                        </div>
                                                    </div>                                                       
                                                </div>
                                                <div class="">
                                                    <div class="">
                                                        <div class="row">
                                                            <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                            </div>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <button class="btn">Save changes</button>
                                                                <button type="reset" class="btn-secondry">Cancel</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
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
        <jsp:include page = "footer.jsp"/>
        <!-- Footer END ==== -->
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
    <script src='FrontEnd/assets/vendors/switcher/switcher.js'></script>
</body>

</html>