function addSticker() {
  let titleText = $(".title").val();
  let textText = $(".content").val();
  if (!(textText && textText)) {
  }else {
    $("#sticker-list").append(
      $("<li>")
        .addClass("note-content")
        .append(
          $("<a>")
            .addClass("button")
            .text("x")
            .on("click", deleteNote)
        )
        .append($("<h2>").text(titleText))
        .append($("<hr>"))
        .append($("<p>").text(textText))
    );

    function deleteNote() {
      $(this)
        .parent()
        .remove();
    }

    $(".title").val("");
    $(".content").val("");
  }
}
