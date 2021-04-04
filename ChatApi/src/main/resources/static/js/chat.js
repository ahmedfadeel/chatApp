
    var userName= $("#userName_text").text();
  
    function connect_TO() {
      var socket = new SockJS('/gs-guide-websocket');
      stompClient = Stomp.over(socket);
      stompClient.connect({}, function (frame) {         
          console.log("connected, to queue of  " + userName);
          stompClient.subscribe('/queue/chats-'+userName , function(message) {   
                    
             get_messages(friend,userName);
          //  show_recivedMessage(message.body);
          });
      });
    }
  
  
  
 function sendtoUser() {
   var userName=$("#userName_text").text();
   var recieve="";
   
   if (userName === "ahmed"){
      recieve="ah";
   }
   else{
      recieve="ahmed";
   }
   var message_obj={
      text:$("#text").val(),
      reciever:recieve,
      sender:userName
    };
  

 
 console.log(message_obj)
 stompClient.send( "/app/send.message", {} , JSON.stringify(message_obj) );

  show_sendedMessages( message_obj);
}

function show_sendedMessages(message){
    console.log("in show message " + message);
   $("#messages").append("  <li><h4>  " + userName + "  </h4>   <p>  " +  message.text + " </p> </li>" 
   );
}
function show_recivedMessage(message) {
  console.log("in show message " + message);
   $("#messages").append("  <li><h4>  " + $("#reciever").val() + "  </h4>   <p>  " +  message + " </p> </li>" 
   );
}

$(function () {
   $("form").on('submit', function (e) {
       e.preventDefault();
   });
   $( "#connect" ).click(function() { connect_TO(); });
   $( "#disconnect" ).click(function() { disconnect(); });
   $( "#send" ).click(function() { sendtoUser(); });
   
});