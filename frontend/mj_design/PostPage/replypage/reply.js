const btns = document.getElementsByClassName("btn");
const texts = document.getElementsByClassName("text-tab");

for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function () {
    document.querySelectorAll(".text-tab.active").forEach(function (item) {
      item.classList.remove("active");
    });
    texts[this.value].className += " active";
  })
}
