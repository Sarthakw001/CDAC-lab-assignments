const circle = require('./circle');
const rectangle = require('./Rectangle');
const triangle = require('./Triangle');

const radius = 5;

const areaCircle = circle.calcArea(radius).toFixed(2);
console.log(`Area of the circle with radius ${radius}: ${areaCircle}`);


const circumferenceResult = circle.calcCircumference(radius).toFixed(2);
console.log(`Circumference of the circle with radius ${radius}: ${circumferenceResult}`);


const diameterResult = circle.calcDiameter(radius);
console.log(`Diameter of the circle with radius ${radius}: ${diameterResult}`);
console.log();

const length=4;
const breadth=5;

const areaRec= rectangle.calcArea(length,breadth);
console.log(`Area of the rectangle with length ${length} and breadth ${breadth}: ${areaRec}`)

const perimeterRec=rectangle.calcPerimeter(length,breadth);
console.log(`Perimeter of the rectangle with length ${length} and breadth ${breadth}: ${perimeterRec}`)
console.log();

const side1=4;
const side2=4;
const side3=5;

const isEqualTrian=triangle.isEquilateral(side1,side2,side3);
console.log(`Is the sides ${side1}, ${side2}, ${side3} Equilateral? : ${isEqualTrian}`)

const trianPerimeter=triangle.calcPerimeter(side1,side2,side3);
console.log(`Perimeter of the sides ${side1}, ${side2}, ${side3} : ${trianPerimeter}`)



