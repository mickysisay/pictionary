window.onload=()=>{
  let arr =[]; 
  let canvas = document.getElementById('canv');
  let context = canvas.getContext('2d');
  let all = $("#all").val()
  let gameName = $("#gamename").val();
  arr= all.split(" ");
  for(let i=0;i<arr.length;i++){
  let arrx = arr[i].split(",");
     context.fillRect(arrx[0],arrx[1], 3, 1.5);
  }
   document.getElementById("guess").addEventListener("click",()=>{
    $.ajax({
           type: "GET",
           url: "/"+gameName+"/answercheck",
           data:{
            answer:document.getElementById("answer").value,
           },
           success: function(response){
                document.getElementById("status").innerHTML = response;
           }
        });
   });

  let pic = setInterval(function(){
    
      $.ajax({
           type: "GET",
           url: "/"+gameName+"/imagesave",
           success:function(response){
                 //console.log(response);
                 //console.log(document.getElementById("refr"));
              
               if(response){
                 arr= response.split(" ");
                 for(let i=0;i<arr.length;i++){
                   let arrx = arr[i].split(",");
                   context.fillRect(arrx[0],arrx[1], 3, 1.5);
                 }
               
                }
                 //document.getElementById("img").addAttribute("src",response);

               }
         });
       } , 1000) 
      }
