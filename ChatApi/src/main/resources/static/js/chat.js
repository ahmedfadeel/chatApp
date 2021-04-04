
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
   console.log(friend);
 
   let message_obj={
      text:$("#text").val(),
      reciever:friend,
      sender:userName
    };
  
 show_sendedMessages( message_obj);
 console.log(message_obj)
 stompClient.send( "/app/send.message", {} , JSON.stringify(message_obj) );

}

function show_sendedMessages(message){
    console.log("in show message " + message.text);
    $("#messages").append("  <li> <h4>  " + userName + "  </h4>  <p>  " +  message.text + " </p> </li>" );
   
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