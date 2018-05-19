var socket = io.connect("http://localhost:4000/");

var chatWindow = document.getElementById("chat-window");
var guestList = document.getElementById("guesstList");
var message = document.getElementById("message");
var handle = document.getElementById("handle");
var btn = document.getElementById("send");
var output = document.getElementById("output");
var feedback = document.getElementById("feedback");
var counter = 0

message.addEventListener("keypress", function(e) {
    socket.emit("typing", handle.value);
    if (e.keyCode === 13) { 
        buttonFunction();
    }
});

btn.addEventListener("keypress", function(e) {
    if (e.keyCode === 13) { 
        buttonFunction();
    }
});

btn.addEventListener("click", buttonFunction);

function buttonFunction() {
    socket.emit("chat", {
        message: message.value,
        handle: handle.value
    });
    if (counter===0) {
        socket.emit("guestName", {
            nick: handle.value
        });
    } counter=1;

    var data = JSON.stringify(    {
        "message": message.value,
        "nickName": handle.value,
        "socketID": socket.id
    });
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/ChatAPI/webapi/chatcontent"
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(data);
    message.value = "";
}

socket.on("chat", function(data) {
    feedback.innerHTML = "";
    output.innerHTML +="<p><strong>" + data.handle + ": </strong>" + data.message + "</p>";
    chatWindow.scrollTop = chatWindow.scrollHeight;
});

socket.on("guestName", function(data) {
    var date = new Date();
    guestList.innerHTML += "<p>Nick: <strong>" + data.nick + "</strong> Logged time: <strong>" + date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+ "</strong></p>"
});

socket.on("typing", function(data) {
    feedback.innerHTML = "<p><em>" + data + " pisze wiadmość... </em></p>";
});