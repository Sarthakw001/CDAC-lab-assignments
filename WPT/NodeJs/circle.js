export function calcArea(radius){
    if (isNaN(radius) || radius < 0) {
        return 'Invalid radius';
    }
    const area = Math.PI * Math.pow(radius, 2);
    
    return area;
}

export function calcCircumference(radius){
    const pi=Math.PI;
    const cicumference= 2 * pi * radius;

    return cicumference;
}

export function calcDiameter(radius){
    const diameter= 2 * radius;
    return diameter;
}