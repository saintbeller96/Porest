export const init = () => {
  console.log('all letters');
  const book = document.querySelector('.book');
  let page;
  const front = document.querySelectorAll('.front');
  const back = document.querySelectorAll('.back');
  let current = 0;
  book.addEventListener('click', e => {
    page = document.querySelectorAll('.page');
    console.log(e.target);
    if (
      e.target.classList.contains('front') ||
      e.target.classList.contains('back') ||
      e.target.classList.contains('page')
    ) {
      let id = e.target.dataset.value;
      console.log(id);
      if (page[id].classList.contains('active')) {
        console.log('있디');
        nextPage(id);
      } else {
        console.log('없다');
        prevPage(id);
      }
    }
  });

  function nextPage(index) {
    index = parseInt(index, 10);
    page[index].classList.add('flipped');
    page[index].classList.remove('active');
    current = index;
    console.log(current);
    if (page && index + 1 < page.length) {
      page[index + 1].classList.add('active');
      console.log('더한다', page[parseInt(index, 10) + 1]);
    }
  }
  function prevPage(index) {
    index = parseInt(index, 10);
    page[index].classList.remove('flipped');
    page[index].classList.add('active');
    current = index;
    console.log(current);

    if (page && index + 1 < page.length) {
      page[index + 1].classList.remove('active');
      console.log('뺀다', page[parseInt(index, 10) + 1]);
    }
  }
};
