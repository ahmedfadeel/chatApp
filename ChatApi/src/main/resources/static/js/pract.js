
 $(document).ready(getAllUsers);
 var friend="";
function getAllUsers(){
    $.getJSON("http://localhost:8082/getUsers_names", displayNames);
};
  $(document).on("click", ".messages-list .userName button" , function() {
          friend=$(this).text();
          console.log (friend + "  "+ userName);
          get_messages(friend,userName);
          
        });
        
 function display_Messages(result){
   console.log("in display messages "+ result.length );
  $.each(result, function(i, field){  
    console.log(field);
    $("#messages").append("  <li>  <p>  " +  field + " </p> </li>" );
       
   });
} 
function get_messages(ms_sender, ms_reciever) {
    let sender_=ms_sender;
    let reciever_ =ms_reciever;
    console.log(" in get messages  "+ms_sender  +"  and reciever is  " +ms_reciever  );
    $.ajax({
        url: 'http://localhost:8082/message.getBySender',
        type: 'get',
        success: function (data) {
            console.log(" in get messages  "+ms_sender  +"  and reciever is  " +ms_reciever  );
            display_Messages(data);
        },
        data:{
          sender : sender_,
          reciever:reciever_
        }
    });

  }
  
    
  

function displayNames(result){
 
    var user_image="userImage";
    var userImage_div ="";
   
    let text="";
     $.each(result, function(i, field){   
      userImage_div ="<div id=" + user_image +"   class= " + user_image +" > " +field[0] +"  </div>";
        
      if ( field !== userName){
        $("#username").append( userImage_div );
        $("#username").append( " <button> "+ field +"  </button>" );
      }
    });
     
     
};

$(function () {
    
 });
