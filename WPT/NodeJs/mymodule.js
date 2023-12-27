exports.factorial=function(n){
    var f=1;
    for(var i=1;i<=n;i++){
        f=f*i;
    }
    return f;
}
exports.myprime = function(n){
    if (n < 2) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false; // If divisible, it's not a prime number
        }
    }

    return true; // If not divisible by any number, it's a prime number
}

exports.printable=function(rows, columns) {
    for (let i = 1; i <= rows; i++) {
        for (let j = 1; j <= columns; j++) {
            let result = i * j;
            process.stdout.write(`${result}\t`);
        }
        process.stdout.write('\n');
    }
}