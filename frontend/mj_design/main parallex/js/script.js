let scrollTop = 0;
let imageAll;
let totalNum = 0;

window.onload = function() {
  progressBar = document.getElementsByClassName('progressBar')[0];
  imageAll = document.querySelectorAll('.parallax_image');
  // alert(imageAll.length)
  totalNum = imageAll.length;

  // window.addEventListener('resize', stageResize, false);
  window.addEventListener('scroll', scrollFunc);

  // stageResize();
  const bodyInnerHeight = document.body.clientHeight;
  // window.scrollTo({
  //   top:bodyInnerHeight,
  //   left:0,
  //   behavior:'smooth'
  // })
};

function scrollFunc(e) {
  const lastPage = document.querySelector('.subPage.lastPage');
  const iframe = document.querySelector('iframe');
  scrollTop = this.scrollY;

  // let per = Math.ceil(scrollTop / (_documentHum - _windowHNum) * 100);
  // progressBar.style.width = per + "%";
  if (scrollTop >= lastPage.offsetTop - 10) {
    const url = iframe.getAttribute('src');
    iframe.setAttribute('src', url + '?autoplay=1&mute=0');
  }
  for (var i = 0; i < totalNum; i++) {
    // imageAll[i].style.transform = "perspective(400px) translateZ("+ scrollTop/5 +"px)";
    //        console.log(scrollTop , 1+scrollTop / (5*(totalNum-i))*0.001 );
    imageAll[i].style.transform =
      'perspective(400px) translateZ(' +
      scrollTop / (50 * (totalNum - i)) +
      'px) translateY(' +
      scrollTop / (11 * i) +
      'px) scale(' +
      (1 + (scrollTop / (5 * (totalNum - i))) * 0.001) +
      ') ';
    if (i === 1) {
      imageAll[i].style.transform =
        'perspective(400px) translateZ(' +
        scrollTop / (30 * (totalNum - i)) +
        'px) translateY(' +
        -scrollTop / (2 * (totalNum - i)) +
        'px) scale(' +
        (0.1 + (scrollTop / (5 * (totalNum - i))) * 0.009) +
        ') translateX(' +
        -(1 + (scrollTop / (5 * (totalNum - i))) * 0.015) +
        'px)';
      continue;
    }
    if (i == 6) {
      imageAll[i].style.transform =
        'perspective(400px) translateZ(' +
        scrollTop / (35 * (totalNum - i)) +
        'px) translateY(' +
        -scrollTop / (40 * (totalNum - i)) +
        'px)';
      continue;
    }
    imageAll[i].style.opacity = 1 - (scrollTop / (10 * totalNum)) * 0.001;
  }
}

// function stageResize() {
//     _documentHum = document.body.offsetHeight;
//     _windowHNum = window.outerHeight;
// }
