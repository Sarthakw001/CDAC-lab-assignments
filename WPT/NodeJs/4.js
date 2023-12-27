/*
    Write a Node program that prints all the number between 1 and 100,each on a separate line.
    A few caveats:
    1.if the number is divisible by 3,print "fizz"
    2.if the number is divisible by 5,print "buzz"
    3.if the number is divisible by both 3 and 5,print "fizzbuzz"
*/

for (let i = 1; i <= 100; i++) {
    // Check if the number is divisible by both 3 and 5
    if (i % 3 === 0 && i % 5 === 0) {
        console.log('fizzbuzz');
    }
    // Check if the number is divisible by 3
    else if (i % 3 === 0) {
        console.log('fizz');
    }
    // Check if the number is divisible by 5
    else if (i % 5 === 0) {
        console.log('buzz');
    }
    // If none of the above conditions are met, print the number
    else {
        console.log(i);
    }
}
