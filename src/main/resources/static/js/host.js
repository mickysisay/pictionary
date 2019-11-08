
console.log('j');
window.onload = function(){
let clicked = false;
   function getMousePos(canvas,evt){
    let rect = canvas.getBoundingClientRect();
        return {
          x: (evt.clientX - rect.left) ,
          y: evt.clientY - rect.top
        };
    }
      let arr = [];
      let canvas = document.getElementById('canv');
      let context = canvas.getContext('2d');
      canvas.addEventListener("mousedown",()=>{
       clicked = true;
      });
      canvas.addEventListener("mouseup",()=>{
          clicked = false;
            });
      canvas.addEventListener('mousemove', function(evt) {
       if (clicked){
        let mousePos = getMousePos(canvas, evt);
        
        context.fillRect(mousePos.x*3/5, mousePos.y*3/10, 3, 1.5);
        //console.log('Mouse position: ' + mousePos.x + ',' + mousePos.y);
        if(!arr.includes(mousePos.x*3/5 +","+mousePos.y*3/10)){
        arr.push(mousePos.x*3/5 +","+mousePos.y*3/10);
        }
        //console.log(arr);
       }
      }, false);
      let sen = setInterval(()=>{
             $.ajax({
                    type: "POST",
                    url: "/imagesave",
                    data: {
                       arrays: arr.join(" "),
                    }
                  }).done(function(o) {
                    
                    arr=[];
                    // If you want the file to be visible in the browser
                    // - please modify the callback in javascript. All you
                    // need is to return the url to the file, you just saved
                    // and than put the image in your browser.
                  });
      },1000);
//   let send = setInterval(()=>{
//     let dataURL = canvas.toDataURL();
//     $.ajax({
//       type: "POST",
//       url: "/imagesave",
//       data: {
//          imgBase64: dataURL
//       }
//     }).done(function(o) {
//       console.log('saved');
//       // If you want the file to be visible in the browser
//       // - please modify the callback in javascript. All you
//       // need is to return the url to the file, you just saved
//       // and than put the image in your browser.
//     });
//   },3000);
}

