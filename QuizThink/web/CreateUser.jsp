<%-- 
    Document   : CreateUser
    Created on : Sep 19, 2023, 10:24:41 AM
    Author     : Dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/assets.css">
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
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <jsp:include page="Dashboard_header.jsp"></jsp:include>  
            <!--Main container start -->
            <main class="ttr-wrapper">
                <div class="container-fluid">	
                    <div class="row">
                        <style>
                            .content-section {
                                display: none;
                            }
                            #option1-container {
                                display: block;
                            }
                        </style>
                        <script>
                            function showContent(selectedOption) {
                                // Hide all content sections
                                var contentSections = document.getElementsByClassName("content-section");
                                for (var i = 0; i < contentSections.length; i++) {
                                    contentSections[i].style.display = "none";
                                }

                                // Show the selected content section
                                var selectedSection = document.getElementById("option" + selectedOption + "-container");
                                selectedSection.style.display = "block";
                            }
                        </script>
                        <label for="registrationDropdown">Select Registration Type:</label>
                        <select id="registrationDropdown" onchange="showContent(this.value)">
                            <option value="1">Expert</option>
                            <option value="2">Marketer</option>
                            <option value="3">Account</option>
                        </select>
                        <!-- Your Profile Views Chart -->
                        <div class="col-lg-12 m-b30">
                            <div class="widget-box">
                                <div class="widget-inner">
                                    <div id="option1-container" class="content-section">
                                        <!-- HAVE EXPERT -->
                                        <div class="wc-title">
                                            <h4>Create Expert</h4>
                                        </div>
                                        <form class="edit-profile m-b30" id="approvalForm" action="createaccount" method="POST">
                                            <div class="">
                                                <div class="form-group row">
                                                    <div class="col-sm-10  ml-auto">
                                                        <h3>1. Account</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">UserName</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="username" value="">
                                                        <input class="form-control" type="hidden" name="createExpert" value="true">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Password</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="password" type="password" name="password" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Re-enter Password</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="rePassword" type="password" name="re-password" value="">
                                                        <p class="error-message" id="passwordError" style="color: red; font-size: 10px;"></p>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Email</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="email" name="email" placeholder="Input Email" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-10  ml-auto">
                                                        <h3>2. Personal Details</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Full Name</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="fullname" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Avatar</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="avatar" id="avatarInput" value="">
                                                    </div>
                                                </div>  
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Preview</label>
                                                    <img class="col-sm-7" id="avatarPreview" src="" alt="Avatar Preview" style="max-width: 200px; max-height: 200px; border: #000">
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Self-Introduction</label>
                                                    <div class="col-sm-7">
                                                        <textarea class="form-control" name="self-introduction"></textarea>
                                                    </div>
                                                </div>        

                                            </div>
                                            <div class="">
                                                <div class="">
                                                    <div class="row">
                                                        <div class="col-sm-2">
                                                        </div>
                                                        <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                                            ${notice}
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <button type="submit" class="btn" onclick="confirmBan()">Save changes</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div id="option2-container" class="content-section">                               
                                        <!-- HAVE MARKETER -->
                                        <div class="wc-title">
                                            <h4>Create Marketer</h4>
                                        </div>
                                        <form class="edit-profile m-b30" id="approvalForm" action="createaccount" method="POST">
                                            <div class="">
                                                <div class="form-group row">
                                                    <div class="col-sm-10  ml-auto">
                                                        <h3>1. Account</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">UserName</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="username" value="">
                                                        <input class="form-control" type="hidden" name="createMarketer" value="true">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Password</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="password" type="password" name="password" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Re-enter Password</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="rePassword" type="password" name="re-password" value="">
                                                        <p class="error-message" id="passwordError" style="color: red; font-size: 10px;"></p>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Email</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="email" name="email" placeholder="Input Email" value="">
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <div class="col-sm-10  ml-auto">
                                                        <h3>2. Personal Details</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Full Name</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="fullname" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Avatar</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="avatar" id="avatarInput" value="">
                                                    </div>
                                                </div>  
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Preview</label>
                                                    <img class="col-sm-7" id="avatarPreview" src="" alt="Avatar Preview" style="max-width: 200px; max-height: 200px; border: #000">
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Self-Introduction</label>
                                                    <div class="col-sm-7">
                                                        <textarea class="form-control" name="self-introduction"></textarea>
                                                    </div>
                                                </div>        

                                            </div>
                                            <div class="">
                                                <div class="">
                                                    <div class="row">
                                                        <div class="col-sm-2">
                                                        </div>
                                                        <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                                            ${notice}
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <button type="submit" class="btn" onclick="confirmBan()">Save changes</button>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                    <!-- HAVE ACCOUNT -->
                                    <div id="option3-container" class="content-section">
                                        <div class="wc-title">
                                            <h4>Create Account</h4>
                                        </div>
                                        <form class="edit-profile m-b30" id="approvalForm" action="createaccount" method="POST" onsubmit="">
                                            <div class="">
                                                <div class="form-group row">
                                                    <div class="col-sm-10  ml-auto">
                                                        <h3>1. Account</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">UserName</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" id="usernameInput" name="username" value="">
                                                        <input class="form-control" type="hidden" name="createAccount" value="true">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Password</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="password" type="password" name="password" value="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Re-enter Password</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="rePassword" type="password" name="re-password" value="">
                                                        <p class="error-message" id="passwordError" style="color: red; font-size: 10px;"></p>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Email</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" id="emailInput" type="email" name="email" placeholder="Input Email" value="">
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <div class="col-sm-10  ml-auto">
                                                        <h3>2. Personal Details</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Full Name</label>
                                                    <div class="col-sm-7">
                                                        <input class="form-control" type="text" name="fullname" value="">
                                                    </div>
                                                </div>
                                            <c:set var="male" value="Male"/>
                                            <c:set var="female" value="Female"/>    

                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Gender</label>
                                                <div class="col-sm-7">
                                                    <input type="radio" id="saleRole" name="gender" value="Male" >
                                                    <label class="col-sm-2 col-form-label" for="saleRole">Male</label><br>

                                                    <input type="radio" id="membershipRole" name="gender" value="Female">
                                                    <label class="col-sm-2 col-form-label" for="membershipRole">Female</label><br>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">DOB</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="date" name="DOB" value="">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Avatar</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" name="avatar" id="avatarInput" value="">
                                                </div>
                                            </div>  
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Preview</label>
                                                <img class="col-sm-7" id="avatarPreview" src="" alt="Avatar Preview" style="max-width: 200px; max-height: 200px; border: #000">
                                            </div>
                                            <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Self-Introduction</label>
                                                    <div class="col-sm-7">
                                                        <textarea class="form-control" name="self-introduction"></textarea>
                                                    </div>
                                                </div>  
                                        </div>
                                        <div class="">
                                            <div class="">
                                                <div class="row">
                                                    <div class="col-sm-2">
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="col-lg-12" style="padding-bottom: 10px; color: red;">
                                                            ${notice}
                                                        </div>
                                                        <button type="submit" class="btn">Save changes</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <!-- External JavaScripts -->
        <script src="admin/assets/js/jquery.min.js"></script>
        <script src="admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="admin/assets/vendors/masonry/masonry.js"></script>
        <script src="admin/assets/vendors/masonry/filter.js"></script>
        <script src="admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="admin/assets/js/functions.js"></script>
        <script src="admin/assets/vendors/chart/chart.min.js"></script>
        <script src="admin/assets/js/admin.js"></script>
        <script src='admin/assets/vendors/calendar/moment.min.js'></script>
        <script src='admin/assets/vendors/calendar/fullcalendar.js'></script>

        <!-- <script src='assets/vendors/switcher/switcher.js'></script> -->
        <script>
                                            function validateForm() {
                                                var username = document.getElementById('usernameInput').value;
                                                var password = document.getElementById('password').value;
                                                var email = document.getElementById('emailInput').value;
                                                if (!username || !password || !email) {
                                                    alert("Please fill in all fields");
                                                    return false;
                                                }
                                                if (!/^[a-zA-Z0-9]+$/.test(username) || /\s/.test(username)) {
                                                    alert("Username must not include special characters or spaces");
                                                    return false;
                                                }
                                                if (password.length < 6 || password.length > 30 || /\s/.test(password)) {
                                                    alert("Password must be between 6 and 30 characters and must not include spaces");
                                                    return false;
                                                }
                                                if (/\s/.test(email)) {
                                                    alert("Email must not include spaces");
                                                    return false;
                                                }
                                                return true;
                                            }
        </script>
        <script>
            function confirmAndSubmit(action) {
                var confirmation = confirm("Are you sure you want to " + action + " this account?");
                if (confirmation) {
                    if (action === "Ban") {
                        document.getElementsByName('Ban')[0].value = 'true';
                    } else if (action === "Unban") {
                        document.getElementsByName('Unban')[0].value = 'true';
                    }
                    document.getElementById('approvalForm').submit();
                }
            }

            document.getElementById('banBtn').addEventListener('click', function () {
                confirmAndSubmit('Ban');
            });

            document.getElementById('unbanBtn').addEventListener('click', function () {
                confirmAndSubmit('Unban');
            });
        </script>
        <script>
            document.getElementById('approvalForm').addEventListener('submit', function (event) {
                var password = document.getElementById('password').value;
                var rePassword = document.getElementById('rePassword').value;
                var errorElement = document.getElementById('passwordError');

                if (password !== rePassword) {
                    errorElement.textContent = 'Passwords do not match';
                    alert('Passwords do not match');
                    event.preventDefault();
                    // Prevent form submission
                } else {
                    errorElement.textContent = ''; // Clear the error message
                }
            });
        </script>
        <script>
            document.getElementById('rePassword').addEventListener('input', function () {
                var password = document.getElementById('password').value;
                var rePassword = this.value;
                var errorElement = document.getElementById('passwordError');

                if (password === rePassword) {
                    errorElement.textContent = ''; // Clear the error message
                } else {
                    errorElement.textContent = 'Passwords do not match';
                }
            });
        </script>


        <script>
            // JavaScript to update the image preview when the avatar input changes
            document.getElementById('avatarInput').addEventListener('input', function () {
                var avatarPreview = document.getElementById('avatarPreview');
                avatarPreview.src = this.value;
            });
        </script>

        <script>
            $(document).ready(function () {

                $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay,listWeek'
                    },
                    defaultDate: '2019-03-12',
                    navLinks: true, // can click day/week names to navigate views

                    weekNumbers: true,
                    weekNumbersWithinDays: true,
                    weekNumberCalculation: 'ISO',

                    editable: true,
                    eventLimit: true, // allow "more" link when too many events
                    events: [
                        {
                            title: 'All Day Event',
                            start: '2019-03-01'
                        },
                        {
                            title: 'Long Event',
                            start: '2019-03-07',
                            end: '2019-03-10'
                        },
                        {
                            id: 999,
                            title: 'Repeating Event',
                            start: '2019-03-09T16:00:00'
                        },
                        {
                            id: 999,
                            title: 'Repeating Event',
                            start: '2019-03-16T16:00:00'
                        },
                        {
                            title: 'Conference',
                            start: '2019-03-11',
                            end: '2019-03-13'
                        },
                        {
                            title: 'Meeting',
                            start: '2019-03-12T10:30:00',
                            end: '2019-03-12T12:30:00'
                        },
                        {
                            title: 'Lunch',
                            start: '2019-03-12T12:00:00'
                        },
                        {
                            title: 'Meeting',
                            start: '2019-03-12T14:30:00'
                        },
                        {
                            title: 'Happy Hour',
                            start: '2019-03-12T17:30:00'
                        },
                        {
                            title: 'Dinner',
                            start: '2019-03-12T20:00:00'
                        },
                        {
                            title: 'Birthday Party',
                            start: '2019-03-13T07:00:00'
                        },
                        {
                            title: 'Click for Google',
                            url: 'http://google.com/',
                            start: '2019-03-28'
                        }
                    ]
                });

            });

        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>