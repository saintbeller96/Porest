export const init = () => {
  let totalCards = 0;
  let currentCard = 0;
  let currentDeg = 0;
  let rotateDeg;
  const cardWrapper = document.querySelector('.card-main-wrapper');
  const cards = document.querySelectorAll('.card');
  const prev = document.querySelector('.prev-button');
  const next = document.querySelector('.next-button');
  const exitBtn = document.querySelector('.room-list-eixt-btn');
  const listPopUp = document.querySelector('.list-pop-up');
  const createRoom = document.querySelector('.create-chat-room');
  const createRoomFront = document.querySelector('.room-card-front');
  const createRoomBack = document.querySelector('.room-card-back');
  const exitroomBtn = document.querySelector('.exit-room-create');
  const publicBtn = document.querySelector('.public');
  const NonpublicBtn = document.querySelector('.non-public');
  const roomCategorySelect = document.querySelector('.room-category-select');
  const roomCategory = document.querySelectorAll('.room-category');
  const categoryName = document.querySelector('.category-name');
  const introTitle = document.querySelector('.intro_title');
  const frontImg = document.querySelector('.front-card-img');
  const categories = [
    '학교 생활',
    '직장 생활',
    '학업 및 진로',
    '자녀 양육',
    '대인 관계',
    '심리 및 정서',
    '연애',
    '기타',
  ];

  totalCards = cards.length;
  rotateDeg = 360 / totalCards;
  for (let i = 0; i < totalCards; i++) {
    cards[i].style.transform = `rotate(${rotateDeg * i}deg) translateY(-350px)`;
  }
  function prevHandler() {
    if (currentCard == 0) {
      currentCard = totalCards - 1;
    } else {
      currentCard--;
    }
    currentDeg += rotateDeg;
    rotateCard();
  }
  function nextHandler() {
    if (currentCard == totalCards - 1) {
      currentCard = 0;
    } else {
      currentCard++;
    }
    currentDeg -= rotateDeg;
    rotateCard();
  }
  prev.addEventListener('click', prevHandler);
  next.addEventListener('click', nextHandler);

  function rotateCard() {
    for (let i = 0; i < totalCards; i++) {
      cards[i].style.transform = `rotate(${currentDeg +
        rotateDeg * i}deg) translateY(-350px)`;
    }
  }

  function wrapperHandler(e) {
    if (e.target.classList.contains('card-outer')) {
      let selectCard = e.target;
      let selectCardId = parseInt(e.target.dataset.value, 10) - 1;
      roomCategory.forEach(ele => {
        if (ele.dataset.value == selectCardId + 1) {
          ele.classList.add('room-category-selected');
        }
      });
      introTitle.classList.add('show');
      cardWrapper.classList.add('bottom');
      listPopUp.classList.add('list-pop-up-show');
      selectCard.classList.add('card-show');
      prev.classList.add('button-hide');
      next.classList.add('button-hide');
    }
  }

  function exitHandler() {
    listPopUp.classList.remove('list-pop-up-show');
    cardWrapper.classList.remove('bottom');
    prev.classList.remove('button-hide');
    next.classList.remove('button-hide');
    createRoomBack.classList.remove('room-card-back-fade');
    createRoomFront.classList.remove('room-card-front-fade');
    introTitle.classList.remove('show');
    roomCategory.forEach(ele => {
      ele.classList.remove('room-category-selected');
    });
  }
  function createRoomHandler() {
    createRoomBack.classList.add('room-card-back-fade');
    createRoomFront.classList.add('room-card-front-fade');
  }
  function createRoomExitHandler() {
    createRoomBack.classList.remove('room-card-back-fade');
    createRoomFront.classList.remove('room-card-front-fade');
  }
  exitroomBtn.addEventListener('click', createRoomExitHandler);
  if (createRoom) {
    createRoom.addEventListener('click', createRoomHandler);
  }
  exitBtn.addEventListener('click', exitHandler);
  cardWrapper.addEventListener('click', wrapperHandler);

  function publicBtnHandler() {
    publicBtn.classList.add('public-active');
    NonpublicBtn.classList.remove('public-active');
  }
  function nonpublicBtnHandler() {
    publicBtn.classList.remove('public-active');
    NonpublicBtn.classList.add('public-active');
  }

  publicBtn.addEventListener('click', publicBtnHandler);
  NonpublicBtn.addEventListener('click', nonpublicBtnHandler);

  let capacityNumber = 1;
  const countPlus = document.querySelector('.count-plus');
  const countMinus = document.querySelector('.count-minus');
  const countNum = document.querySelector('.count-num');
  const capacityWarningOver = document.querySelector('.capacity-warning-over');
  const capacityWarningLess = document.querySelector('.capacity-warning-less');

  function capacityPlusHandler() {
    countPlus.classList.add('click');
    if (capacityNumber <= 3) {
      capacityNumber++;
      countNum.innerText = capacityNumber;
      capacityWarningOver.classList.remove('capacity-warning-show');
      capacityWarningLess.classList.remove('capacity-warning-show');
    } else {
      capacityWarningOver.classList.add('capacity-warning-show');
    }
    setTimeout(() => {
      countPlus.classList.remove('click');
    }, 300);
  }
  function capacityMinusHandler() {
    countMinus.classList.add('click');

    if (capacityNumber >= 2) {
      capacityNumber--;
      countNum.innerText = capacityNumber;
      capacityWarningLess.classList.remove('capacity-warning-show');
      capacityWarningOver.classList.remove('capacity-warning-show');
    } else {
      capacityWarningLess.classList.add('capacity-warning-show');
    }
    setTimeout(() => {
      countMinus.classList.remove('click');
    }, 300);
  }
  function roomCategoryHandler(e) {
    if (e.target.classList.contains('room-category')) {
      e.target.classList.toggle('room-category-selected');
    }
  }

  countPlus.addEventListener('click', capacityPlusHandler);
  countMinus.addEventListener('click', capacityMinusHandler);
  roomCategorySelect.addEventListener('click', roomCategoryHandler);
};
