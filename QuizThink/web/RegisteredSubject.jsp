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

        <style>
            .search-form {
                width: 100%;
                max-width: 300px;

            }

            .search-form:focus-within {
                border: none;
                outline: none;
            }

            .search-form input[type="text"] {
                width: 100%;
                padding: 12px 24px;

                border: none;
                border-radius: 4px;

                background: #fff;

            }

            .search-input {
                position: relative;
            }

            .search-input input {
                width: 100%;
                padding-right: 40px;
            }

            .search-input i {
                position: absolute;
                right: 10px;
                top: 50%;
                transform: translateY(-50%);
            }

            .search-btn1 {
                background: none;
                border: none;
                padding: 0;

                position: absolute;
                top: 50%;
                transform: translateY(-50%);
                right: 10px;
            }

            .search-btn1 i {
                color: #0000008a;
                font-size: 20px;
            }
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
                                                    <a class="nav-link active" href="YourSubject"><i
                                                            class="ti-book"></i>Courses</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="Profile"><i
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
                                            <div class="profile-head" style="margin-bottom: 30px;">
                                                <h3>My Courses</h3>                                                   
                                                <div class="feature-filters style1 ml-auto">
                                                    <form action="SearchRegistedSubject" method="post" class="search-form">
                                                        <div class="search-input">
                                                            <input type="text" name="search" value="${searchContent}" placeholder="Search your subject...">
                                                            <button type="submit" class="search-btn1">
                                                                <i class="fa fa-search"></i>
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <!-- Your Profile Views Chart -->
                                                    <div class="col-lg-12 m-b30">     
                                                        <c:if test="${listSubjects.size() == 0}">
                                                            <div class="widget-inner">
                                                                <p style="font:bold; margin-left: 10px; ">There is no subject</p>
                                                            </div>
                                                        </c:if>
                                                        <c:forEach items = "${listSubjects}" var = "o">
                                                            <div class="widget-inner">
                                                                <div class="card-courses-list admin-courses">
                                                                    <div class="card-courses-media">
                                                                        <img src="${o.imageURL}" alt=""/>
                                                                    </div>
                                                                    <div class="card-courses-full-dec">
                                                                        <div class="card-courses-title">
                                                                            <h4>${o.title}</h4>
                                                                        </div>
                                                                        <div class="card-courses-list-bx">
                                                                            <ul class="card-courses-view">
                                                                                <li class="card-courses-user">
                                                                                    <div class="card-courses-user-pic">
                                                                                        <img src="admin/assets/images/testimonials/pic3.jpg" alt=""/>
                                                                                    </div>
                                                                                    <div class="card-courses-user-info">
                                                                                        <h5>Teacher</h5>
                                                                                        <h4>Keny White</h4>
                                                                                    </div>
                                                                                </li>
                                                                                <li class="card-courses-categories">
                                                                                    <h5>3 Categories</h5>
                                                                                    <h4>Backend</h4>
                                                                                </li>
                                                                                <li class="card-courses-review">
                                                                                    <h5>3 Review</h5>
                                                                                    <ul class="cours-star">
                                                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                                                        <li><i class="fa fa-star"></i></li>
                                                                                        <li><i class="fa fa-star"></i></li>
                                                                                    </ul>
                                                                                </li>
                                                                                <li class="card-courses-stats">
                                                                                    <a href="#" class="btn button-sm green radius-xl">${o.questionCount} questions</a>
                                                                                </li>                                                                           
                                                                            </ul>
                                                                        </div>
                                                                        <div class="row card-courses-dec">
                                                                            <div class="col-md-12">
                                                                                <h6 class="m-b10">Subject Description</h6>
                                                                                <p>${o.description} </p>	
                                                                            </div>
                                                                            <div class="col-md-12">
                                                                                <a href="#" class="btn green radius-xl outline">View</a>
                                                                                <a href="cancel?id=${o.subjectId}" class="btn red outline radius-xl ">Cancel</a>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                                <!-- Your Profile Views Chart END-->
                                            </div>                                           
                                        </div>
                                        <!-- <div class="tab-pane" id="quiz-results">
                                                <div class="profile-head">
                                                        <h3>Quiz Results</h3>
                                                </div>
                                                <div class="courses-filter">
                                                        <div class="row">
                                                                <div class="col-md-6 col-lg-6">
                                                                        <ul class="course-features">
                                                                                <li><i class="ti-book"></i> <span
                                                                                                class="label">Lectures</span> <span
                                                                                                class="value">8</span></li>
                                                                                <li><i class="ti-help-alt"></i> <span
                                                                                                class="label">Quizzes</span> <span
                                                                                                class="value">1</span></li>
                                                                                <li><i class="ti-time"></i> <span
                                                                                                class="label">Duration</span> <span class="value">60
                                                                                                hours</span></li>
                                                                                <li><i class="ti-stats-up"></i> <span class="label">Skill
                                                                                                level</span> <span class="value">Beginner</span>
                                                                                </li>
                                                                                <li><i class="ti-smallcap"></i> <span
                                                                                                class="label">Language</span> <span
                                                                                                class="value">English</span></li>
                                                                                <li><i class="ti-user"></i> <span
                                                                                                class="label">Students</span> <span
                                                                                                class="value">32</span></li>
                                                                                <li><i class="ti-check-box"></i> <span
                                                                                                class="label">Assessments</span> <span
                                                                                                class="value">Yes</span></li>
                                                                        </ul>
                                                                </div>
                                                                <div class="col-md-6 col-lg-6">
                                                                        <ul class="course-features">
                                                                                <li><i class="ti-book"></i> <span
                                                                                                class="label">Lectures</span> <span
                                                                                                class="value">8</span></li>
                                                                                <li><i class="ti-help-alt"></i> <span
                                                                                                class="label">Quizzes</span> <span
                                                                                                class="value">1</span></li>
                                                                                <li><i class="ti-time"></i> <span
                                                                                                class="label">Duration</span> <span class="value">60
                                                                                                hours</span></li>
                                                                                <li><i class="ti-stats-up"></i> <span class="label">Skill
                                                                                                level</span> <span class="value">Beginner</span>
                                                                                </li>
                                                                                <li><i class="ti-smallcap"></i> <span
                                                                                                class="label">Language</span> <span
                                                                                                class="value">English</span></li>
                                                                                <li><i class="ti-user"></i> <span
                                                                                                class="label">Students</span> <span
                                                                                                class="value">32</span></li>
                                                                                <li><i class="ti-check-box"></i> <span
                                                                                                class="label">Assessments</span> <span
                                                                                                class="value">Yes</span></li>
                                                                        </ul>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div> 
                                        <div class="tab-pane" id="edit-profile">
                                                <div class="profile-head">
                                                        <h3>Edit Profile</h3>
                                                </div>
                                                <form class="edit-profile">
                                                        <div class="">
                                                                <div class="form-group row">
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                                <h3>1. Personal Details</h3>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Full
                                                                                Name</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text" value="Mark Andre">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Occupation</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text" value="CTO">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Company
                                                                                Name</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text" value="EduChamp">
                                                                                <span class="help">If you want your invoices addressed to a
                                                                                        company. Leave blank to use your full name.</span>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Phone
                                                                                No.</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text"
                                                                                        value="+120 012345 6789">
                                                                        </div>
                                                                </div>

                                                                <div class="seperator"></div>

                                                                <div class="form-group row">
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                                <h3>2. Address</h3>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Address</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text"
                                                                                        value="5-S2-20 Dummy City, UK">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">City</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text" value="US">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">State</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text" value="California">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Postcode</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text" value="000702">
                                                                        </div>
                                                                </div>

                                                                <div
                                                                        class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x">
                                                                </div>

                                                                <div class="form-group row">
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                                <h3 class="m-form__section">3. Social Links</h3>
                                                                        </div>
                                                                </div>

                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Linkedin</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text"
                                                                                        value="www.linkedin.com">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Facebook</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text"
                                                                                        value="www.facebook.com">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Twitter</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text"
                                                                                        value="www.twitter.com">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Instagram</label>
                                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                <input class="form-control" type="text"
                                                                                        value="www.instagram.com">
                                                                        </div>
                                                                </div>
                                                        </div>
                                                        <div class="">
                                                                <div class="">
                                                                        <div class="row">
                                                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                                                </div>
                                                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                                        <button type="reset" class="btn">Save changes</button>
                                                                                        <button type="reset"
                                                                                                class="btn-secondry">Cancel</button>
                                                                                </div>
                                                                        </div>
                                                                </div>
                                                        </div>
                                                </form>
                                        </div>
                                        <div class="tab-pane" id="change-password">
                                                <div class="profile-head">
                                                        <h3>Change Password</h3>
                                                </div>
                                                <form class="edit-profile">
                                                        <div class="">
                                                                <div class="form-group row">
                                                                        <div class="col-12 col-sm-8 col-md-8 col-lg-9 ml-auto">
                                                                                <h3>Password</h3>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-4 col-md-4 col-lg-3 col-form-label">Current
                                                                                Password</label>
                                                                        <div class="col-12 col-sm-8 col-md-8 col-lg-7">
                                                                                <input class="form-control" type="password" value="">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-4 col-md-4 col-lg-3 col-form-label">New
                                                                                Password</label>
                                                                        <div class="col-12 col-sm-8 col-md-8 col-lg-7">
                                                                                <input class="form-control" type="password" value="">
                                                                        </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                        <label
                                                                                class="col-12 col-sm-4 col-md-4 col-lg-3 col-form-label">Re
                                                                                Type New Password</label>
                                                                        <div class="col-12 col-sm-8 col-md-8 col-lg-7">
                                                                                <input class="form-control" type="password" value="">
                                                                        </div>
                                                                </div>
                                                        </div>
                                                        <div class="row">
                                                                <div class="col-12 col-sm-4 col-md-4 col-lg-3">
                                                                </div>
                                                                <div class="col-12 col-sm-8 col-md-8 col-lg-7">
                                                                        <button type="reset" class="btn">Save changes</button>
                                                                        <button type="reset" class="btn-secondry">Cancel</button>
                                                                </div>
                                                        </div>

                                                </form>
                                        </div>-->
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