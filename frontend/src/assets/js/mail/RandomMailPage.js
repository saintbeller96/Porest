export const fireworks = function() {
  let getFontSize = function() {
    return parseFloat(getComputedStyle(document.documentElement).fontSize);
  };

  let canvas = document.querySelector('.fireworks');
  let ctx = canvas.getContext('2d');
  let numberOfParticules = 24;
  let distance = 200;
  let x = 0;
  let y = 0;
  let animations = [];

  let setCanvasSize = function() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
  };

  let updateCoords = function(e) {
    x = e.clientX || e.touches[0].clientX;
    y = e.clientY || e.touches[0].clientY;
  };

  let colors = ['#b721ff', '#00dbde', '#ff758c', '#0fd850'];

  let createCircle = function(x, y) {
    let p = {};
    p.x = x;
    p.y = y;
    p.color = colors[anime.random(0, colors.length - 1)];
    p.color = '#FFF';
    p.radius = 0;
    p.alpha = 1;
    p.lineWidth = 6;
    p.draw = function() {
      ctx.globalAlpha = p.alpha;
      ctx.beginPath();
      ctx.arc(Math.abs(p.x), Math.abs(p.y), Math.abs(p.radius), 0, 2 * Math.PI, true);
      ctx.lineWidth = p.lineWidth;
      ctx.strokeStyle = p.color;
      ctx.stroke();
      ctx.globalAlpha = 1;
    };
    return p;
  };

  let createParticule = function(x, y) {
    let p = {};
    p.x = x;
    p.y = y;
    p.color = colors[anime.random(0, colors.length - 1)];
    p.radius = anime.random(getFontSize(), getFontSize() * 2);
    while (p.radius < 0) {
      p.radius = anime.random(getFontSize(), getFontSize() * 2);
    }
    p.draw = function() {
      ctx.beginPath();
      ctx.arc(p.x, p.y, p.radius, 0, 2 * Math.PI, true);
      ctx.fillStyle = p.color;
      ctx.fill();
    };
    return p;
  };

  let createParticles = function(x, y) {
    let particules = [];
    for (let i = 0; i < numberOfParticules; i++) {
      let p = createParticule(x, y);
      particules.push(p);
    }
    return particules;
  };

  let removeAnimation = function(animation) {
    let index = animations.indexOf(animation);
    if (index > -1) animations.splice(index, 1);
  };

  let animateParticules = function(x, y) {
    setCanvasSize();
    let particules = createParticles(x, y);
    let circle = createCircle(x, y);
    let particulesAnimation = anime({
      targets: particules,
      x: function(p) {
        return p.x + anime.random(-distance, distance);
      },
      y: function(p) {
        return p.y + anime.random(-distance, distance);
      },
      radius: 0,
      duration: function() {
        return anime.random(1200, 1800);
      },
      easing: 'easeOutExpo',
      complete: removeAnimation,
    });
    let circleAnimation = anime({
      targets: circle,
      radius: function() {
        return anime.random(getFontSize() * 8.75, getFontSize() * 11.25);
      },
      lineWidth: 0,
      alpha: {
        value: 0,
        easing: 'linear',
        duration: function() {
          return anime.random(400, 600);
        },
      },
      duration: function() {
        return anime.random(1000, 1200);
      },
      easing: 'easeOutExpo',
      complete: removeAnimation,
    });
    animations.push(particulesAnimation);
    animations.push(circleAnimation);
  };

  let mainLoop = anime({
    duration: Infinity,
    update: function() {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      animations.forEach(function(anim) {
        anim.animatables.forEach(function(animatable) {
          animatable.target.draw();
        });
      });
    },
  });

  document.addEventListener(
    'click',
    function(e) {
      updateCoords(e);
      animateParticules(x, y);
    },
    false,
  );

  window.addEventListener('resize', setCanvasSize, false);

  return {
    boom: animateParticules,
  };
};
