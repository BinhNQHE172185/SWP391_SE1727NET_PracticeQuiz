<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
        <link rel="stylesheet" type="text/css" href="admin/assets/css/add-quiz.css">
    </head>
<body>
    <jsp:include page="Dashboard_header.jsp"></jsp:include>  
    <main class="ttr-wrapper">
        <div class="container">
        <!-- Question and Answers -->
        <div class="mb-4">
            <h2>Create new Quiz </h2>
            <label class="form-label">Question: </label>
                <div class="mb-3">
                    <label for="questionText" class="form-label">Quiz No.</label>
                    <input type="text" class="form-control" id="questionText" placeholder="Type quiz here">
                </div>

                <div class="mb-3">
                    <label class="form-label">Answers</label>
                    <div class="form-check input-group mb-3">
                        <input class="form-check-input" type="radio" name="isCorrect" value="option1">
                        <input type="text" class="form-control col-sm-8" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer">
                            <i class="fa fa-trash"></i> <!-- Sử dụng biểu tượng thùng rác từ     Font Awesome -->
                        </button>
                    </div>
                    <div class="form-check input-group mb-3">
                        <input class="form-check-input" type="radio" name="isCorrect" value="option2">
                        <input type="text" class="form-control col-sm-8" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer">
                            <i class="fa fa-trash"></i> <!-- Sử dụng biểu tượng thùng rác từ Font Awesome -->
                        </button>
                    </div>
                    <div class="form-check input-group mb-3 ">
                        <input class="form-check-input" type="radio" name="isCorrect" value="option3">
                        <input type="text" class="form-control col-sm-8" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer">
                            <i class="fa fa-trash"></i> <!-- Sử dụng biểu tượng thùng rác từ Font Awesome -->
                        </button>
                    </div>
                    <div class="form-check input-group mb-3">
                        <input class="form-check-input" type="radio" name="isCorrect" value="option4">
                        <input type="text" class="form-control col-sm-8" placeholder="Type answer option here">
                        <button class="input-group-text remove-answer">
                            <i class="fa fa-trash"></i> <!-- Sử dụng biểu tượng thùng rác từ Font Awesome -->
                        </button>
                    </div>

                </div>
                <button class="btn btn-primary add-answer">Add Answer</button>

            </div>
        </div>

        <!-- Add Question Button -->
        <button class="btn btn-primary" id="addQuestion">Save Quiz</button>
        <button class="btn btn-primary" id="addQuestion">Reset</button>

    </div>
    </main>
</body>

<script>
    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('add-answer')) {
            const answerButton = event.target;
            const answerContainer = answerButton.parentElement.querySelector('.form-check');
            const currentAnswers = answerContainer.parentElement.querySelectorAll('.form-check').length;
            
            if (currentAnswers < 8) {
                const newAnswer = answerContainer.cloneNode(true);
                answerContainer.parentElement.appendChild(newAnswer);
            }
        }
    });
    
    const addQuestionButton = document.getElementById('addQuestion');
    addQuestionButton.addEventListener('click', function() {
        const question = document.querySelector('.question');
        const newQuestion = question.cloneNode(true);
        newQuestion.querySelector('.add-answer').remove();
        question.parentElement.appendChild(newQuestion);
    });
    
    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('remove-answer')) {
            const answerButton = event.target;
            const answerContainer = answerButton.parentElement;
            const answers = answerContainer.parentElement.querySelectorAll('.form-check');

            if (answers.length > 2) {
                answerContainer.remove();
            }
        }
    });
</script>
</html>
