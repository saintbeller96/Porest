export const init = () => {
  let totalCards = 0;
  let currentCard = 0;
  let currentDeg = 0;
  let rotateDeg;
  let pageNum;

  const cards = document.querySelectorAll('.card');
  const prev = document.querySelector('.prev-button');
  const next = document.querySelector('.next-button');
  console.log(cards);
  totalCards = cards.length;
  rotateDeg = 360 / totalCards;
  console.log(rotateDeg);
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
    // if (currentDeg >= 360) {
    //   currentDeg -= 360;
    // }
    rotateCard();

    console.log(currentCard, currentDeg);
  }
  function nextHandler() {
    if (currentCard == totalCards - 1) {
      currentCard = 0;
    } else {
      currentCard++;
    }
    currentDeg -= rotateDeg;
    // if (currentDeg < 0) {
    //   currentDeg = 360 + currentDeg;
    // }
    rotateCard();
    console.log(currentCard, currentDeg);
  }
  prev.addEventListener('click', prevHandler);
  next.addEventListener('click', nextHandler);

  function rotateCard() {
    for (let i = 0; i < totalCards; i++) {
      cards[i].style.transform = `rotate(${currentDeg + rotateDeg * i}deg) translateY(-350px)`;
    }
  }
};
