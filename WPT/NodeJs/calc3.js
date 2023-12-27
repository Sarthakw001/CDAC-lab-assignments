const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const myFunctions = require('./mymodule');

rl.question('Enter a number: ', (answer) => {
    const number = parseInt(answer);
    if (number < 5) {
        const result = myFunctions.factorial(number);
        console.log(`Factorial of ${number} is: ${result}`);
    } else if (number > 5 && number < 10) {
        myFunctions.printable(number, number); 
    } else {
        const isPrime = myFunctions.myprime(number);
        console.log(`${number} is${isPrime ? '' : ' not'} a prime number.`);
    }

    rl.close();
});
