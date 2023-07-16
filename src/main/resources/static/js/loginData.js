let email = document.querySelector("#user_email");
let password = document.querySelector("#user_password");

const loginBtn = document.querySelector("#submitBtn");

loginBtn.onclick = function (e) {
  e.preventDefault();
  console.log("Email: " + email.value);
  console.log("Password: " + password.value);
};
