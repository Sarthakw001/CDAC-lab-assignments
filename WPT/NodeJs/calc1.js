
const mathOperations = require('./calc');

let resultAddition = mathOperations.addition(5, 3);
console.log('Addition:', resultAddition);

let resultSubtract = mathOperations.subtract(10, 4);
console.log('Subtraction:', resultSubtract);

let resultMultiply = mathOperations.multiply(6, 7);
console.log('Multiplication:', resultMultiply);

let resultDivide = mathOperations.divide(15, 3);
console.log('Division:', resultDivide);

let resultSquare = mathOperations.square(4);
console.log('Square:', resultSquare);

let resultSum = mathOperations.sum(8, 2);
console.log('Sum:', resultSum);
