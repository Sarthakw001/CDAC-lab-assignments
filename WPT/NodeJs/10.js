/*
    Use Node and Express to write a simple web application that checks whether a number is a prime or not
    and display message accordingly.
*/  

const express = require('express');
const app = express();
const port = 9090;

// Function to check if a number is prime
function isPrime(num) {
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

// Express route to handle the prime check
app.get('/check/:number', (req, res) => {
  const number = parseInt(req.params.number);
  const primeMessage = isPrime(number)
    ? `${number} is a prime number.`
    : `${number} is not a prime number.`;

  res.send(primeMessage);
});

// Start the Express server
app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
