//$().ready(function() {
//   rotate_and_fly();
//});

document.addEventListener("DOMContentLoaded", function () {
  setTimeout(rotate_and_fly, 5000);
});



rotate_and_fly = function () {
  //var left_inside_wing2 = document.querySelector('.left_inside_wing');

  var left_inside_wing = Snap('#left_inside_wing');
  var right_inside_wing = Snap('#right_inside_wing');
  var left_wing = Snap('#left_wing');
  var right_wing = Snap('#right_wing');
  left_inside_wing.animate({
    fill: '#ffffff',
    stroke: 'white'
  }, 600);
  right_inside_wing.animate({
    fill: '#ffffff',
    stroke: 'white'
  }, 600);

  left_wing.animate({
    stroke: 'white'
  }, 500);
  right_wing.animate({
    stroke: 'white'
  }, 500);

  fold_left_top_wing();
}



fold_left_top_wing = function () {
  //  var top_left_wing =document.querySelector('.top_left_wing');

  //  top_left_wing.setAttribute('points', "0,0,150,0 ,0,150");

  //  top_left_wing.classList.add('change2');
  //  
  //  
  var top_left_wing = Snap("#top_left_wing");
  Snap.animate(top_left_wing.attr('points'), [0, 0, 150, 0, 0, 150],
    function (val) {
      top_left_wing.attr({
        points: val
      })
    }, 500, mina.easeout, fold_right_top_wing);
  top_left_wing.animate({
    stroke: 'white'
  }, 550);
  //
}

fold_right_top_wing = function () {
  var top_right_wing = Snap("#top_right_wing");
  Snap.animate(top_right_wing.attr('points'), [150, 0, 300, 0, 300, 150],
    function (val) {
      top_right_wing.attr({
        points: val
      })
    }, 500, mina.linear, fold_left_bottom_wing);
  top_right_wing.animate({
    stroke: 'white'
  }, 550);
}

fold_left_bottom_wing = function () {
  var left_bottom = Snap("#left_bottom");
  Snap.animate(left_bottom.attr('points'), [0, 150, 150, 150, 150, 190, 0, 190],
    function (val) {
      left_bottom.attr({
        points: val
      })
    }, 500, mina.linear, fold_right_bottom_wing);
  //   left_bottom.animate({stroke:'white'},200);
}

fold_right_bottom_wing = function () {
  var right_bottom = Snap("#right_bottom");
  Snap.animate(right_bottom.attr('points'), [150, 150, 300, 150, 300, 190, 150, 190],
    function (val) {
      right_bottom.attr({
        points: val
      })
    }, 500, mina.linear);
  //  right_bottom.animate({stroke:'white'},1000);
}
