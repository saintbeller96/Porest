const btnWrapper = document.querySelector('.btn_wrapper')


btnWrapper.addEventListener('click',e => {
  if(e.target.classList.contains('btn')){
    const id = e.target.dataset.value;
    const audio = new Audio(`./audio/sound${id}.mp3`);
    audio.loop = false; // 반복재생하지 않음
    audio.volume = 0.5; // 음량 설정
    audio.play(); // sound1.mp3 재생
  }
})
