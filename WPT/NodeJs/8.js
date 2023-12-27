 /*
    Accept radius from user. On submission,Node must calculate area and 
    circumference of circle and send the calculated data back.use the circle.js
    module we created earlier.
*/

const readline = require('readline');
const circle = require('./circle');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Function to get user input for radius
function getUserInput() {
  rl.question('Enter the radius of the circle: ', (radius) => {
    // Validate user input
    if (isNaN(radius) || radius <= 0) {
      console.log('Invalid input. Please enter a valid positive number for the radius.');
      getUserInput(); // Ask for input again
    } else {
      // Calculate area and circumference using the circle module
      const area = circle.calcArea(parseFloat(radius));
      const circumference = circle.calcCircumference(parseFloat(radius));

      // Display the results
      console.log(`Area of the circle: ${area.toFixed(2)}`);
      console.log(`Circumference of the circle: ${circumference.toFixed(2)}`);

      // Close the readline interface
      rl.close();
    }
  });
}

// Start the application
getUserInput();
