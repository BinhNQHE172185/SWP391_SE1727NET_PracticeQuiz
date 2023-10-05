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
}
function submitQuiz() {
    var submitQuestion = document.getElementById("submitQuestion").getAttribute("data-submitQuestion");
    // Create a data object to send in the POST request
    var data = {
        selectedChoices: selectedChoices,
        timeLeft: timeLeft,
        question: submitQuestion
    };

    // Send a POST request to the servlet endpoint
    fetch('/servlet-url', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        // Handle the response from the servlet
        // Add your code to handle the response here
    })
    .catch(error => {
        // Handle any errors that occur during the request
        console.error('Error:', error);
    });
}
// Set the date we're counting down to
var endTimeElement = document.getElementById("endTimeElement");
var endTime = new Time(endTimeElement.getAttribute("data-endTime")).getTime();

// Update the count down every 1 second
var x = setInterval(function () {

    // Get today's date and time
    var now = new Date().getTime();

    // Find the timeLeft between now and the count down date
    timeLeft = endTime - now;

    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
    var hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

    // Display the result in the element with id="demo"
    document.getElementById("question-timer").innerHTML = days + "d " + hours + "h "
            + minutes + "m " + seconds + "s ";

    // If the count down is finished, write some text
    if (timeLeft < 0) {
        clearInterval(x);
        document.getElementById("question-timer").innerHTML = "EXPIRED";
    }
}, 1000);


function scrollToQuiz(quizNumber) {
    var quizElement = document.getElementById('quiz' + quizNumber);
    if (quizElement) {
        quizElement.scrollIntoView({behavior: 'smooth'});
    }
}

