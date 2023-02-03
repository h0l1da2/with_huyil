const profile = document.querySelector(".user-profile>img");
const profileDetail = document.querySelector(".user-profile-detail");
profile.addEventListener("click", (e) => {
  profileDetail.classList.toggle("on");
});

// ??.. 이거 어케 끔?
profileDetail.addEventListener("click", (e) => {
  if (e.target != profileDetail) {
    profileDetail.classList.toggle("on");
  }
});
