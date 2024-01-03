const express = require('express');
const route = require('./routes/routes');
const cors = require('cors')

const app = express();


app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use('/',route);

app.listen(8080,()=>{
    console.log("Server started");
})