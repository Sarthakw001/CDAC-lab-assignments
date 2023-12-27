/*
    Create a file mydata.txt,myfile.data read contents of both files parallelly and display number of
    words in each file. (use asynchronous api)
*/

const fs = require('fs');

// Function to count words in a given text
function countWords(text) {
    const words = text.split(/\s+/);
    return words.length;
}

// Function to read a file and count words
function readFileAndCountWords(filename) {
    fs.readFile(filename, 'utf8', (err, data) => {
        if (err) {
            console.error(`Error reading ${filename}: ${err.message}`);
            return;
        }

        const wordCount = countWords(data);
        console.log(`Number of words in ${filename}: ${wordCount}`);
    });
}

// Read and count words in mydata.txt
readFileAndCountWords('mydata.txt');

// Read and count words in myfile.data
readFileAndCountWords('myfile.data');
