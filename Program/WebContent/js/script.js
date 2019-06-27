var button = document.getElementsByClassName('btn')[0];
var reset = document.getElementsByClassName('reset')[0];
var form = document.getElementsByClassName('form-control');

button.addEventListener("mousedown", invert);
button.addEventListener("mouseup", revert);
//reset.addEventListener("mousedown", click);
/*
function click() {
  // enable the button
  button.disabled = false;
  button.style.zIndex = "1";
  // reset position
  button.style.position = "relative";
  button.style.marginTop = "45px";
  // reset dimensions
  button.style.height = "50px";
  button.style.width = "250px";
  button.style.opacity = 1; // doesn't work in IE
  button.style.filter  = "alpha(opacity=100) !important";
  button.style.borderRadius = "35px !important";
  button.innerHTML = "Sign In";
}*/

function invert() {
  button.style.color = "#EE6383";
  button.style.background = "white";
}
function revert() {
  button.style.color = "white";
  button.style.background = "#EE6383";
}

/* vanilla JS */
button.onmouseup = function() {
  var coords = function() {
    var c = [];
    c[0] = event.clientX;
    c[1] = event.clientY;
  }
  button.innerHTML = "";  
  var w = 250;
  function frame() {
    w--;
    button.style.width = w + "px";
    if (w == 50) {
      clearInterval(id);
      buttonExpand();
    }
  }
  var id = setInterval(frame, 3);
};

function buttonExpand() {
  // clear the form
  form[0].value = "";
  form[1].value = "";
  // disable the button but keep the cursor
  button.disabled = true;
  button.style.cursor = "default";
  // set the button's new position
  button.style.position = "absolute";
  button.style.marginTop = "0";
  button.style.top = "0";
  button.style.left = "0";
  // button expanding animation
  button.style.animation = "expand 0.8s forwards ease";
}