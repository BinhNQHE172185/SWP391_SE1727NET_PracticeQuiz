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
        <form action="editquiz" method="POST">
            <div class="container">
        <!-- Question and Answers -->
        <div class="mb-4">
            <h2>Create new Quiz </h2>
            <label class="form-label">Question: </label>
                <div class="mb-3">
                    <label for="questionText" class="form-label">Quiz No.</label>
                    <input type="hidden" name="quiz_Id" value="${quiz.quizId}">
                    <label for="questionText" class="form-label">Quiz Type</label>
<!--                    <select name="quizType">
                        <option > Single Correct Answer</option>
                        <option > Multiple Correct Answer</option>
                    </select>-->
                    <input type="text" name="content" class="form-control" id="questionText" placeholder="Type quiz here" value="${quiz.content}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Answers</label>
                    
                <c:forEach items="${answerList}" var="o">
                    <div class="form-check input-group mb-3">
                        <input class="form-check-input" type="checkbox" name="checkbox" value="correct" 
                               onchange="updateCheckbox(this)" ${o.isCorrect ? 'checked' : ''}>
                        <input type="hidden" name="isCorrect" value="${o.isCorrect ? 'correct' : 'incorrect'}">
                        <input type="hidden" name="exist" value="${o.answerId}">
                        <input type="hidden" name="delete" value="false">
                        <input type="text" name="answer" class="form-control col-sm-8" 
                               placeholder="Type answer option here" value="${o.content}">
                        <button type="button" class="input-group-text remove-answer" onclick="removeRow(this)">
                            <i class="fa fa-trash"></i>
                        </button>
                    </div>
                </c:forEach>
                </div >
                <div class="form-check input-group mb-3 " id="description-explaination" style="display: none">
                    <label class="form-label">Description or Explaination for correct answers</label>
                    <div>
                        <textarea name="description" class="form-control col-sm-8"> ${quiz.description} </textarea>
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
