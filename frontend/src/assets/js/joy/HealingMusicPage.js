export const init = () => {
  let prev_button, next_button;
  let MainWrapper;
  let disk_inner;
  let pageNum = 0;
  let totalNum = 0;
  let album;
  let pointBtnAll;
  let coverImg;
  let bgArray = new Array();
  let musicListWrapper;
  let thumbnail;
  let images = ['../../assets/image/iu_0.jpg'];
  bgArray[0] = ['#0272a4', '#f6a564'];
  bgArray[1] = ['#b6bfc8', '#36595b'];
  bgArray[2] = ['#e58e82', '#6f569f'];
  bgArray[3] = ['#e58e82', '#6f569f'];
  bgArray[4] = ['#e58e82', '#6f569f'];
  bgArray[5] = ['#e58e82', '#6f569f'];
  bgArray[6] = ['#e58e82', '#6f569f'];
  bgArray[7] = ['#e58e82', '#6f569f'];

  musicListWrapper = document.querySelector('.music__list');
  thumbnail = document.querySelector('.thumbnail');
  coverImg = document.querySelector('.coverImg');
  prev_button = document.querySelectorAll('button')[0];
  next_button = document.querySelectorAll('button')[1];

  MainWrapper = document.querySelector('.healing__music__wrapper');
  disk_inner = document.querySelectorAll('.disk_inner');
  album = document.querySelector('.album');
  totalNum = album.length;

  musicListWrapper.addEventListener('click', e => {
    if (e.target.classList.contains('music__item')) {
      let id = e.target.dataset.value;
      if (id > 7) {
        id %= 7;
      }
      console.log(id);
      MainWrapper.style.background =
        'linear-gradient(120deg,' +
        bgArray[id][0] +
        ', ' +
        bgArray[id][1] +
        ')';
    }
  });
  // alert(totalNum)

  // prev_button.addEventListener('click', function() {
  //   if (pageNum > 0) {
  //     pageNum--;
  //   } else {
  //     pageNum = totalNum - 1;
  //   }
  //   pageChangeFunc();
  // });

  // next_button.addEventListener('click', function() {
  //   if (pageNum < totalNum - 1) {
  //     pageNum++;
  //   } else {
  //     pageNum = 0;
  //   }
  //   pageChangeFunc();
  // });

  //최초실행
  // pageNum = 2;
  pageChangeFunc();

  //여기서 모든 것을 한다.
  function pageChangeFunc() {
    // console.log(bgArray[pageNum][1])
    MainWrapper.style.background =
      'linear-gradient(120deg,' +
      bgArray[pageNum][0] +
      ', ' +
      bgArray[pageNum][1] +
      ')';

    for (let i = 0; i < totalNum; i++) {
      if (pageNum == i) {
        //현재 컨텐츠(페이지)
        album[i].classList.add('active');
      } else {
        album[i].classList.remove('active');
      }
    }
    // album[pageNum].classList.add("active");

    disk_inner[pageNum].style.background = bgArray[pageNum][0];
  }
};
