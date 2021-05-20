import router from '@/router/index.js';

export const typing = () => {
  let index = 0;
  // let txt = ['당신의 오늘 하루는', '무수히 빛나는 별보다', '더 빛나고 아름답습니다'];
  let txt = '당신의 오늘 하루는 무수히 빛나는 별보다 더 빛나고 아름답습니다.';
  let txt2 = '당신의 마음 속 이야기, POREST 세상 속에서 들려주세요.';
  let speed = 210;
  let count = 0;
  let currentText = '';
  let letter = '';
  const typeBoard = document.querySelector('.type');
  // const audio = document.querySelector('#typing');

  // document.body.addEventListener('mouseon', () => {
  //   if (count === 0) {
  //     audio.loop = false;
  //     audio.volume = 0.3;
  //     audio.play();

  //     count++;
  //   }
  // });

  // const audioTag = document.querySelector('audio');
  // const whiteShow = document.querySelector('.white-show');
  const entrance = document.querySelector('.random-ball-wrapper');
  const big = document.querySelector('.big');
  const magic = document.querySelector('.magic');
  const textIntro = document.querySelector('.text_intro');
  if (entrance) {
    entrance.addEventListener('click', () => {
      typeBoard.style.opacity = '0';
      entrance.classList.add('pop-ball');
      textIntro.classList.remove('show');
      big.classList.add('show');
      setTimeout(() => {
        // audioTag.play();
        router.push({ name: 'MainIsland' });
      }, 3500);
    });
  }
  async function type() {
    // if (count === 3) {
    //   return;
    // }
    if (index === txt.length) {
      setTimeout(() => {
        magic.classList.add('show');
        textIntro.classList.add('show');
        typeBoard.classList.add('hide');
      }, 500);

    }
    // currentText = txt[count];
    currentText = txt;
    letter = currentText.slice(0, ++index);
    typeBoard.textContent = letter;
    // if (letter.length === currentText.length) {
    //   count++;
    //   index = 0;
    //   await setTimeout(() => {
    //     type();
    //     audioTag.play();
    //   }, 1000);
    // } else {
    await setTimeout(type, 140);
    // }
  }
  setTimeout(() => {
    type();
  }, 200);
};
