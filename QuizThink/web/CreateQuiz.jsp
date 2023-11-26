<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Expert" %>
<%@page import= "Model.Question" %>
<%@page import= "Model.Subject" %>
<%@page import = "java.util.*" %>
<%@ page import="Model.Answer" %>
<%@ page import="Model.Quiz" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Subject" %>
<%@ page import="Model.SubjectDimension" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%
            Expert ex = (Expert) session.getAttribute("currExpert");
        %>
        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="Quiz Think" />

        <!-- OG -->
        <meta property="og:title" content="Quiz Think" />
        <meta property="og:description" content="Quiz Think" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Expert Profile</title>

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
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">
        <style>
            .answercheckbox {
                margin-left: 4em;
                margin-top: 0.5em;
                width: 2em;
                height: 2em;
            }
            .answerradio{
                margin-left: 4em;
                margin-top: 0.5em;
                width: 2em;
                height: 2em;
            }
            .answerinput {
                margin-left: 120px; 
                margin-right: 30px; 
                border: none;
                border-bottom: 1px solid grey;
                outline: none;
            }
            .form-control.answerinput {
                font-size: 14px;
              }
            .form-control.answerinput::placeholder {
                font-size: 14px;
              }
            
            .typeRadio {
                margin-left: 20px; 
                margin-right: 20px; 
            }
            .question-card {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 3px rgba(1, 1, 1, 1);
            margin-bottom: 20px;
            }
            .card.p-4.mb-3{
                background-color: #E0DADF
            }
            
        </style>
    </head>
    <body body class="ttr-opened-sidebar ttr-pinned-sidebar">
    <!-- header start -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <!--sidebar menu toggler start -->
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <!--sidebar menu toggler end -->
                <!--logo start -->
                <div class="ttr-logo-box">
                    <div>
                        <a href="home" class="ttr-logo">
                            <img class="ttr-logo-mobile" alt="" src="FrontEnd\assets\images\Logo1.png" width="30" height="30">
                            <img class="ttr-logo-desktop" alt="" src="FrontEnd\assets\images\Logo1.png" width="160" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <!-- header left menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="home" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="../courses.html">Our Courses</a></li>
                                    <li><a href="../event.html">New Event</a></li>
                                    <li><a href="../membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header left menu end -->
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <!-- header right menu start -->
                    <ul class="ttr-header-navigation">
                        <%
                            if (ex != null){
                        %>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="<%=ex.getAvatar()%>" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="ExpertProfile">My profile</a></li>
                                    <li><a href="Logout">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                    <!-- header right menu end -->
                </div>
                <!--header search panel start -->
                <div class="ttr-search-bar">
                    <form class="ttr-search-form">
                        <div class="ttr-search-input-wrapper">
                            <input type="text" name="qq" placeholder="search something..." class="ttr-search-input">
                            <button type="submit" name="search" class="ttr-search-submit"><i class="ti-arrow-right"></i></button>
                        </div>
                        <span class="ttr-search-close ttr-search-toggle">
                            <i class="ti-close"></i>
                        </span>
                    </form>
                </div>
                <!--header search panel end -->
            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <!-- side menu logo start -->
                <div class="ttr-sidebar-logo">
                    <a href="#"><img alt="" src="FrontEnd\assets\images\Logo1-Purple.png" width="180" height="45"></a>
                    <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                            <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                            <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
                    </div> -->
                    <div class="ttr-sidebar-toggle-button">
                        <i class="ti-arrow-left"></i>
                    </div>
                </div>
                <!-- side menu logo end -->
                <!-- sidebar menu start -->
                <nav class="ttr-sidebar-navi">
                    <ul>
                        <li>
                            <a href="ExpertProfile" class="ttr-material-button">
                                <span class="ttr-icon"><i class="fa fa-user"></i></span>
                                <span class="ttr-label">Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="ExpertSubjectList" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Subject</span>
                            </a>
                        </li>
                        <li>
                            <a href="ExpertStudentList" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Student List</span>
                            </a>
                        </li>
                        <li class="ttr-seperate"></li>
                    </ul>
                    <!-- sidebar menu end -->
                </nav>
                <!-- sidebar menu end -->
            </div>
        </div>
        <!-- Left sidebar menu end -->
    <main class="ttr-wrapper">
        <form onsubmit="return validateForm()" action="createquiz" method="POST">
            <div class="container">
        <!-- Question and Answers -->
        <div class="mb-4">
                <h2>Create new Quiz</h2>
                <div class="card p-4">
                <div class="row mb-3" >
                    <div class="col-sm-1 ">
                         <label>Type:</label>
                     </div>
                     <div>
                         <input class="form-check-input" type="radio" name="quizType" value="0" checked onchange="updateCheckboxes()">
                     </div>
                     <div class="col-sm-3">
                         <label class="form-check-label">Multiple correct answers</label>
                     </div>
                     <div >
                         <input class="form-check-input" type="radio" name="quizType" value="1" onchange="updateCheckboxes()">
                     </div>
                     <div class="col-sm-3">
                         <label class="form-check-label">One correct answer</label>
                     </div>
                </div>
                    <hr>
                    <label class="form-label">Question: ${questionId}</label>
                    <input type="hidden" name="questionId" value="${questionId}">
                    <div class="question-card mb-3">
                        <input type="text" name="content" class="form-control answerinput" id="questionText" placeholder="Type your quiz content here" style="margin-left: 0px; border-bottom: none">
                    </div>
                </div>
            
                </br>
                <div class=" card p-4 mb-3">
                    <label class="form-label">Answers</label>
                    <div class="question-card form-check input-group mb-3">
                        <input class="form-check-input answercheckbox" type="checkbox" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" >
                        <input class="form-check-input answerradio" type="radio" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" >
                        
                        <input type="hidden" name="isCorrect" value =" incorrect">
                        <input type="text" name="answer" class="form-control col-sm-8 answerinput" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer" onclick="removeRow(this)">
                            <i class="fa fa-trash"></i>
                        </button>
                    </div>
                    <div class=" question-card form-check input-group mb-3">
                        <input class="form-check-input answercheckbox" type="checkbox" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" >
                        <input class="form-check-input answerradio" type="radio" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" >
                        
                        <input type="hidden" name="isCorrect" value =" incorrect">
                        <input type="text" name="answer" class="form-control col-sm-8 answerinput" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer" onclick="removeRow(this)">
                            <i class="fa fa-trash"></i>
                        </button>
                    </div>
                    <div class="question-card form-check input-group mb-3 ">
                        <input class="form-check-input answercheckbox " type="checkbox" name="checkbox" value="incorrect" onchange="updateCheckbox(this)">
                        <input class="form-check-input answerradio" type="radio" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" >
                        
                        <input type="hidden" name="isCorrect" value =" incorrect">
                        <input type="text" name="answer" class="form-control col-sm-8 answerinput" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer" onclick="removeRow(this)">
                            <i class="fa fa-trash"></i>
                        </button>
                    </div>
                    <div class="question-card form-check input-group mb-3">
                        <input class="form-check-input answercheckbox" type="checkbox" name="checkbox" value="incorrect" onchange="updateCheckbox(this)">
                        <input class="form-check-input answerradio" type="radio" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" >
                        
                        <input type="hidden" name="isCorrect" value =" incorrect">
                        <input type="text" name="answer" class="form-control col-sm-8 answerinput" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer" onclick="removeRow(this)">
                            <i class="fa fa-trash"></i>
                        </button>
                    </div>

                </div >
                <div class="card p-4 form-check input-group mb-3 " id="description-explaination" style="display: none; background-color: #E0DADF">
                    <div class="question-card">
                        <label class="form-label answerinput">Description or Explaination for correct answers</label>
                        <div>
                            <textarea name="description" class="form-control col-sm-8 answerinput"> </textarea>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-primary add-answer" onclick="addRow()">Add Answer</button>
                <button type="button" class="btn btn-primary add-answer" onclick="addDescription()">Add Description</button>  
            </div>
        </div>
          
        <!-- Add Question Button -->
        <button type="submit" class="btn btn-primary" id="addQuestion">Save Quiz</button>
        <button type="reset" class="btn btn-primary" id="addQuestion">Reset</button>
        </form>
    </main>
    <div class="ttr-overlay"></div>
</body>
<script>
        function updateCheckboxes() {
            var quizType = document.querySelector('input[name="quizType"]:checked').value;
            var checkboxes = document.querySelectorAll('.answercheckbox');
            var radioInputs = document.querySelectorAll('.answerradio');
            var hiddenInput;
            
            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].style.display = (quizType === '0') ? 'block' : 'none';
                checkboxes[i].checked = false;
                hiddenInput = checkboxes[i].parentElement.querySelector('input[type="hidden"]');
                hiddenInput.value = "incorrect";
            }
            for (var i = 0; i < radioInputs.length; i++) {
                radioInputs[i].style.display = (quizType === '1') ? 'block' : 'none';
                radioInputs[i].checked = false;
                hiddenInput = radioInputs[i].parentElement.querySelector('input[type="hidden"]');
                hiddenInput.value = "incorrect";
            }
        }
        updateCheckboxes();
 </script>
<script>
        function validateForm() {
            var questionTextValue = document.getElementById('questionText').value.trim();
            if (questionTextValue === '') {
                alert('Please fill in the question text');
                return false;
            }

            var answerInputs = document.querySelectorAll('.answerinput');

            for (var i = 0; i < answerInputs.length; i++) {
                var answerInputValue = answerInputs[i].value.trim();

                if (answerInputValue === '') {
                    alert('Please fill in all answer options');
                    return false;
                }
            }
            var checkboxInputs = document.querySelectorAll('.answercheckbox');
            var atLeastOneSelected = false;
            for (var i = 0; i < checkboxInputs.length; i++) {
                if (checkboxInputs[i].checked) {
                    atLeastOneSelected = true;
                    break;
                }
            }
            var radioInputs = document.querySelectorAll('.answerradio');
            var atLeastOneSelectedR = false;
            for (var i = 0; i < radioInputs.length; i++) {
                if (checkboxInputs[i].checked) {
                    atLeastOneSelectedR = true;
                    break;
                }
            }

            if (!atLeastOneSelected) {
                alert('Please select at least one correct answer');
                return false;
            }
            if (!atLeastOneSelectedR) {
                alert('Please select correct answer');
                return false;
            }

            return true;
        }
    </script>
<script>

function updateCheckbox(checkbox) {
    // Check if the checkbox is checked
    var isChecked = checkbox.checked;
    
    // Find the hidden input element within the same parent div
    var hiddenInput = checkbox.parentElement.querySelector('input[type="hidden"]');
    
    if (isChecked) {
        // If the checkbox is checked, set the hidden input value to "correct"
        hiddenInput.value = "correct";
    } else {
        // If the checkbox is not checked, set the hidden input value to "incorrect"
        hiddenInput.value = "incorrect";
    }
    
    // Optional: Log the hidden input value for testing
    console.log(hiddenInput.value);
}
</script>

    
<script>
    
    function removeRow(button){
        var rows = document.querySelectorAll('.form-check.input-group.mb-3');
        if(rows.length >2){
           var row = button.parentElement; // get the element contain button
            row.remove(); 
        }
    }
</script>
<script>
    function addDescription(){
        var div = document.getElementById("description-explaination");
        if (div.style.display === "none" || div.style.display === "") {
            div.style.display = "block"; // Hiện thẻ div
        } else {
            div.style.display = "none"; // Ẩn thẻ div
        }
    }
    
</script> 

<script>
    function addRow(){
        var rows = document.querySelectorAll('.form-check.input-group.mb-3');
        if(rows.length < 8){
            var originalRow = document.querySelector('.form-check.input-group.mb-3');
            var newRow = originalRow.cloneNode(true);
            console.log("Số dòng hiện tại: " + rows.length);
            
            var newCheckbox = newRow.querySelector('input[type="checkbox"]');
            
            newCheckbox.onchange = function() {
                updateCheckbox(newCheckbox);
            };
            
            newRow.querySelector('input[type="text"]').value = '';
            originalRow.parentElement.appendChild(newRow);
        }
        else if (rows.length >= 8){
            alert("Số dòng đã đạt tối đa.");
        }
    }
</script>
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
</html>
