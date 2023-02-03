const body = document.querySelector("body");
const modal = document.querySelector(".modal");
const btnOpenPopup = document.querySelectorAll(".booked-status");

btnOpenPopup.forEach((btn) => {
  btn.addEventListener("click", () => {
    modal.classList.toggle("show");
  });
});

modal.addEventListener("click", (event) => {
  if (event.target === modal) {
    modal.classList.toggle("show");
  }
});

const cancleBtn = document.getElementById("cancle-btn");
cancleBtn.addEventListener("click", () => {
  modal.classList.toggle("show");
});
