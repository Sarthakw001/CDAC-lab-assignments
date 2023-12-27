const http=require('http');

var server=http.createServer(function(req,resp){
    resp.write("<h1>Welcome to nodejs </h1>");
    
})
server.listen(5000,function(){
    console.log("server running at port 5000")
})