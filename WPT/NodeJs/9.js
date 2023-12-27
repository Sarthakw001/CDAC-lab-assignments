/*
    Develop a login app. The login.html must accept username and password and submit to node.
    At server side,node must first check if password is minimum 6 characters.Create a javascript
    array that contains username and password as comma separated values.Enter 3 user details.
    Middleware must check if username ans password is available in a javascript array.
    If yes,send success.html,else failure.html

*/
const http = require('http');
const fs = require('fs');
const path = require('path');
const queryString = require('querystring');

const server = http.createServer((req, res) => {
    if (req.method === 'GET') {
        // Serve login form
        if (req.url === '/') {
            fs.readFile(path.join(__dirname, 'login.html'), 'utf8', (err, data) => {
                if (err) {
                    res.writeHead(500, { 'Content-Type': 'text/plain' });
                    res.end('Internal Server Error');
                    return;
                }

                res.writeHead(200, { 'Content-Type': 'text/html' });
                res.end(data);
            });
        }
    } else if (req.method === 'POST') {
        // Handle login form submission
        if (req.url === '/login') {
            let data = '';

            req.on('data', (chunk) => {
                data += chunk;
            });

            req.on('end', () => {
                const { username, password } = queryString.parse(data);

                //user data
                const users = [
                    { username: 'user1', password: 'password1' },
                    { username: 'user2', password: 'password2' },
                    { username: 'user3', password: 'password3' },
                ];

                // Check if password is at least 6 characters
                if (password.length < 6) {
                    res.writeHead(200, { 'Content-Type': 'text/html' });
                    return fs.createReadStream(path.join(__dirname, 'failure.html')).pipe(res);
                }

                // Check if username and password match in the users array
                const user = users.find((user) => user.username === username && user.password === password);

                if (user) {
                    res.writeHead(200, { 'Content-Type': 'text/html' });
                    return fs.createReadStream(path.join(__dirname, 'success.html')).pipe(res);
                } else {
                    res.writeHead(200, { 'Content-Type': 'text/html' });
                    return fs.createReadStream(path.join(__dirname, 'failure.html')).pipe(res);
                }
            });
        }
    }
});

const port = 3000;
server.listen(port, () => {
    console.log(`Server is running at http://localhost:${port}`);
});
