export const init = () => {
  const book = document.querySelector('.book');
  let page;
  const front = document.querySelectorAll('.front');
  const back = document.querySelectorAll('.back');
  let current = 0;
  book.addEventListener('click', e => {
    page = document.querySelectorAll('.page');
    if (
      e.target.classList.contains('front') ||
      e.target.classList.contains('back') ||
      e.target.classList.contains('page')
    ) {
      let id = e.target.dataset.value;
      if (page[id].classList.contains('active')) {
        nextPage(id);
      } else {
        prevPage(id);
      }
    }
  });

  function nextPage(index) {
    index = parseInt(index, 10);
    page[index].classList.add('flipped');
    page[index].classList.remove('active');
    current = index;
    if (page && index + 1 < page.length) {
      page[index + 1].classList.add('active');
    }
  }
  function prevPage(index) {
    index = parseInt(index, 10);
    page[index].classList.remove('flipped');
    page[index].classList.add('active');
    current = index;

    if (page && index + 1 < page.length) {
      page[index + 1].classList.remove('active');
    }
  }
};
