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
<body>
    <jsp:include page="Dashboard_header.jsp"></jsp:include>  
    <main class="ttr-wrapper">
        <form action="editquiz" method="POST">
            
            <div class="container">
        <!-- Question and Answers -->
        <div class="mb-4">
            <h2>Edit Quiz</h2>
                <div class="card p-4">
                <div class="row mb-3" >
                    <div class="col-sm-1 ">
                         <label>Type:</label>
                     </div>
                     <div>
                         <input class="form-check-input" type="radio" name="quizType" value="0" ${quiz.type == 0 ? 'checked' : ''} onchange="updateCheckboxes()">
                     </div>
                     <div class="col-sm-3">
                         <label class="form-check-label" >Multiple correct answers</label>
                     </div>
                     <div >
                         <input class="form-check-input" type="radio" name="quizType" value="1" ${quiz.type == 1 ? 'checked' : ''} onchange="updateCheckboxes()">
                     </div>
                     <div class="col-sm-3">
                         <label class="form-check-label">One correct answer</label>
                     </div>
                 </div>
                    <hr>
                    <label class="form-label">Question: </label>
                     <div class="question-card mb-3">
                         <input type="text" name="content" class="form-control answerinput" id="questionText" placeholder="Type your quiz content here" style="margin-left: 0px; border-bottom: none" value="${quiz.content}">
                         <input type="hidden" name="quiz_Id" value="${quiz.quizId}">    
                         <input type="hidden" name="questionId" value="${questionId}"> 
                    </div>
                </div>
            
                </br>                

                <div class="card p-4 mb-3">
                    <label class="form-label">Answers</label>
                    
                <c:forEach items="${answerList}" var="o">
                    <div class="question-card form-check input-group mb-3">
                        <input class="form-check-input answercheckbox" type="checkbox" name="checkbox" value="correct" 
                               onchange="updateCheckbox(this)" ${o.isCorrect ? 'checked' : ''}>
                        <input class="form-check-input answerradio" type="radio" name="checkbox" value="incorrect" onchange="updateCheckbox(this)" ${o.isCorrect ? 'checked' : ''}>
                        
                        <input type="hidden" name="isCorrect" value="${o.isCorrect ? 'correct' : 'incorrect'}">
                        <input type="hidden" name="exist" value="${o.answerId}">
                        <input type="hidden" name="delete" value="false">
                        <input type="text" name="answer" class="form-control col-sm-8 answerinput" 
                               placeholder="Type answer option here" value="${o.content}">
                        <button type="button" class="input-group-text remove-answer" onclick="removeRow(this)">
                            <i class="fa fa-trash"></i>
                        </button>
                    </div>
                </c:forEach>
                </div >
                <div class="card p-4 form-check input-group mb-3 " id="description-explaination" style="display: none; background-color: #E0DADF">
                    <div class="question-card">
                        <label class="form-label answerinput">Description or Explaination for correct answers</label>
                        <textarea name="description" class="form-control col-sm-8 answerinput">${quiz.description} </textarea>
                    </div>
                </div>
                <button type="button" class="btn btn-primary add-answer" onclick="addRow()">Add Answer</button>
            <button type="button" class="btn btn-primary add-answer" onclick="addDescription()">Description</button>
            </div>
        </div>

        <!-- Add Question Button -->
        <button type="submit" class="btn btn-primary" id="addQuestion">Save Quiz</button>
        <button type="reset" class="btn btn-primary" id="addQuestion">Reset</button>
        </form>
    </main>
</body>

<script>
        function updateCheckboxes() {
            var quizType = document.querySelector('input[name="quizType"]:checked').value;
            var checkboxes = document.querySelectorAll('.answercheckbox');
            var radioInputs = document.querySelectorAll('.answerradio');
            var hiddenInput;
            
            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].style.display = (quizType === '0') ? 'block' : 'none';
            }
            for (var i = 0; i < radioInputs.length; i++) {
                radioInputs[i].style.display = (quizType === '1') ? 'block' : 'none';
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

            if (!atLeastOneSelected) {
                alert('Please select at least one correct answer');
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
    var hiddenInput = checkbox.parentElement.querySelector('input[name="isCorrect"]');
    
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
        var currentRow = document.querySelector('.form-check.input-group.mb-3');
        var exist = currentRow.querySelector('input[name="exist"]');
        var row = button.parentElement; // get the element contain button
        var deleteStatus = row.querySelector('input[name="delete"]');
        
        if(exist.value !== 'none'){
            deleteStatus.value = 'true';
            row.style.display = "none";
        }
        if(exist.value === 'none' && rows.length >2){
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
        var count = 0;
        rows.forEach(function(row) {
            if (row.style.display !== "none") {
                count++;
            }
        });
        if(count < 8){
            var originalRow = document.querySelector('.form-check.input-group.mb-3');
            var newRow = originalRow.cloneNode(true);
            console.log("Số dòng hiện tại: " + count);
            
            var newCheckbox = newRow.querySelector('input[type="checkbox"]');
            var checkExist = newRow.querySelector('input[name="exist"]').value = 'none';
            var isCorrect = newRow.querySelector('input[name="isCorrect"]').value = 'incorrect';
            newCheckbox.checked = false;
            newCheckbox.onchange = function() {
                updateCheckbox(newCheckbox);
            };
            
             newRow.querySelector('input[type="text"]').value = null;
            newRow.style.display = "flex";
            originalRow.parentElement.appendChild(newRow);
        }
        else if (count >= 8){
            alert("Số dòng đã đạt tối đa.");
        }
    }
</script>
</html>
