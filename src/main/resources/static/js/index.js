

let pic = setInterval(function(){
  $.ajax({
    type: "GET",
    url: '/hellos',
    success:function(response){
      //console.log(response); 
      //console.log(document.getElementById("refr"));
      document.getElementById("refr").innerHTML =  response;
     
    },
    
});
  // if(i<5){
    // console.log("hello");
    // }else{
    //   console.log("bye");
    //   clearInterval(pic);
    // }
    // i++
},3000);
