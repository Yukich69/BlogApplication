function onComment() {
  var comment = document.querySelector("input").value;
  if (comment)
    document.getElementById("newComment").innerHTML +=
      ' <div class="pane"> <div class="discussion-msg mb-2 border rounded p-2"> <div class="row"> <div class="col-2 d-flex justify-content-right align-items-center"> <img src="/img/user.webp"  class="rounded-circle w-50" alt="profile"> </div> <div class="col-10"> <p class="discussion-msg mb-0"> ' +
      comment +
      ' </p> <span class="discussion-time d-inline-flex"> <i class="ri-time-line me-2"></i> ' +
      curtime +
      ' </span> <span class="discussion-date d-inline-flex"> <i class="ri-calendar-line mx-2"></i> ' +
      curday(".") +
      ' </span> <div class="d-flex justify-content-right"> <!-- <button class="remove-button btn btn-primary btn-dark ">Delete this comment</button> --> <button class="remove-button">Delete</button> </div> </div> </div> </div> </div>';
  fetch('/user-delete/'+ id, {
    method: 'DELETE',
  });
  return;
}

// ' + curday('.') + '

// remove comment
container.onclick = function (event) {
  if (event.target.className != "remove-button") return;

  let pane = event.target.closest(".pane");
  pane.remove();
  fetch('/user-delete/'+ id, {
    method: 'DELETE',
  });
  console.log("comment deleted");
};

var today = new Date();
var curtime = today.getHours() + ":" + today.getMinutes();

var curday = function (seperator) {
  today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth() + 1; //As January is 0.
  var yyyy = today.getFullYear();

  if (dd < 10) dd = "0" + dd;
  if (mm < 10) mm = "0" + mm;
  return mm + seperator + dd + seperator + yyyy;
};
console.log(curday("."));
