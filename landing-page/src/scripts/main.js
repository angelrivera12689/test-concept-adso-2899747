// This file contains JavaScript code for the landing page of the Football Tournament Management System project.

// Function to display an alert when the page loads
window.onload = function() {
    alert("Welcome to the Football Tournament Management System!");
};

// Function to handle button click event
function handleButtonClick() {
    alert("Learn more about our system!");
}

// Add event listener to a button with the ID 'learnMoreButton'
document.addEventListener("DOMContentLoaded", function() {
    const learnMoreButton = document.getElementById("learnMoreButton");
    if (learnMoreButton) {
        learnMoreButton.addEventListener("click", handleButtonClick);
    }
});