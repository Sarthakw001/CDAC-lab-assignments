/*
    create a simple text file.Now use node file handling to read each line from
    text file,prefix line with a number and display
*/
 const fs = require("fs");

// Read the content of the text file
fs.readFile('simpletext.txt', 'utf8', (err, data) => {
  if (err) {
    console.error('Error reading the file:', err);
    return;
  }

  // Split the content into an array of lines
  const lines = data.split('\n');

  // Prefix each line with a number and display
  lines.forEach((line, index) => {
    console.log(`${index + 1}. ${line}`);
  });
});
