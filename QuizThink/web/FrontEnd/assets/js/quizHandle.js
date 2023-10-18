/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//quiz handle
//quiz handle
var quizCounter = 0;
var selectedChoices = [];
var timeLeft = 0;

function toggleEffect(checkbox, limitCheck) {
    var selectedCheckboxes = document.querySelectorAll(
            'input[name="' + checkbox.name + '"]:checked'
            );

    // Limit the user to selecting only a specific number of options
    if (limitCheck != 0) {
        if (selectedCheckboxes.length > limitCheck) {
            checkbox.checked = false;
            return;
        }
    }

    var selectedLabel = document.querySelector('label[for="' + checkbox.id + '"]');
    var navButton = document.getElementById('quiz-nav-btn-' + checkbox.name);

    if (checkbox.checked) {
        selectedLabel.classList.add("selected");
        navButton.classList.add("selected");
        // Increment the quiz counter if at least one choice is selected
        if (selectedCheckboxes.length === 1) {
            quizCounter++;
        }
        // Add the selected choice to the array
        selectedChoices.push(checkbox.id);
    } else {
        selectedLabel.classList.remove("selected");
        navButton.classList.remove("selected");
        // Decrement the quiz counter if the last choice is deselected
        if (selectedCheckboxes.length === 0) {
            quizCounter--;
        }
        // Remove the deselected choice from the array
        var index = selectedChoices.indexOf(checkbox.id);
        if (index !== -1) {
            selectedChoices.splice(index, 1);
        }
    }

    // Update the counter display
    var counterElement = document.getElementById("quiz-counter");
    counterElement.textContent = quizCounter;
    //console.log(selectedChoices);
}
function submitQuiz() {
    var submitQuestionId = document.getElementById("submitQuestionId").getAttribute("data-submitQuestionId");
    var data = {
        questionId: submitQuestionId,
        timeLeft: timeLeft,
        selectedChoices: selectedChoices
    };

    $.ajax({
        url: "QuizSubmitServlet",
        method: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function (response) {
            // Handle the success response
            console.log(response);
            var resultId = response;
            window.location = "ViewPracticedDetail?resultId=" + resultId;
        },
        error: function (error) {
            // Handle any errors that occur during the request
            console.error('Error:', error);
        }
    });
}
// get endtime 
var endTimeElement = document.getElementById("endTimeElement");
var endTimeString = endTimeElement.getAttribute("data-endTime");
var timeParts = endTimeString.split(":");
var hours = parseInt(timeParts[0], 10);
var minutes = parseInt(timeParts[1], 10);
var seconds = parseInt(timeParts[2], 10);

var endTime = new Date();
endTime.setHours(hours);
endTime.setMinutes(minutes);
endTime.setSeconds(seconds);
//console.log(endTime);
// Update the count down every 1 second
var x = setInterval(function () {

    // Get today's date and time
    var now = new Date().getTime();

    // Find the timeLeft between now and the count down date
    timeLeft = endTime - now;
    //console.log("endTime:", endTime);
    //console.log("timeLeft:", timeLeft);
    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
    var hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

    // Display timer
    var timerDisplay = "";

    if (days > 0) {
        timerDisplay += days + "d ";
    }
    if (hours > 0) {
        timerDisplay += hours + "h ";
    }
    if (minutes > 0) {
        timerDisplay += minutes + "m ";
    }
    timerDisplay += seconds + "s";
    document.getElementById("question-timer").innerHTML = timerDisplay;
    // If the count down is finished, write some text
    if (timeLeft < 0) {
        clearInterval(x);
        document.getElementById("question-timer").innerHTML = "Time-up";
        //submitQuiz();
    }
}, 1000);


function scrollToQuiz(quizNumber) {
    var quizElement = document.getElementById('quiz' + quizNumber);
    if (quizElement) {
        quizElement.scrollIntoView({behavior: 'smooth'});
    }
}

