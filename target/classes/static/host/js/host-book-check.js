const body = document.querySelector("body");
// btn-open-popup
const openPopup = document.querySelectorAll(".table_status");

const modal = document.querySelector(".modal");

openPopup.forEach((element) =>
  element.addEventListener("click", () => {
    modal.classList.toggle("show");
  })
);
modal.addEventListener("click", (e) => {
  if (e.target === modal) {
    modal.classList.toggle("show");
  }
});

const cancleBtn = document.getElementById("cancle-btn");
cancleBtn.addEventListener("click", () => {
  modal.classList.toggle("show");
});
