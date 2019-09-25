function makeReservation(container) {
  $("#submit").on("click", submitForm);
  $("#edit").on("click", editForm);
  $("#continue").on("click", continueForm);

  function submitForm() {
    if ($('#fullName').val().trim() !== "" && $('#email').val().trim() !== "") {
      $('#infoPreview')
        .append(`<li>Name: ${$('#fullName').val()}</li>`)
        .append(`<li>E-mail: ${$('#email').val()}</li>`)
        .append(`<li>Phone: ${$('#phoneNumber').val()}</li>`)
        .append(`<li>Address: ${$('#address').val()}</li>`)
        .append(`<li>Postal Code: ${$('#postalCode').val()}</li>`);

      $('input').val('');
      $('#submit').prop('disabled', true);
      $('#edit').prop('disabled', false);
      $('#continue').prop('disabled', false);
    }
  }

  function editForm() {
    $("#submit").removeAttr("disabled");
    $("#edit").attr("disabled", true);
    $("#continue").attr("disabled", true);
    $("#fullName").val(
      $($("li")[0])
        .text()
        .substring(6)
    );
    $("#email").val(
      $($("li")[1])
        .text()
        .substring(8)
    );
    $("#phoneNumber").val(
      $($("li")[2])
        .text()
        .substring(7)
    );
    $("#address").val(
      $($("li")[3])
        .text()
        .substring(9)
    );
    $("#postalCode").val(
      $($("li")[4])
        .text()
        .substring(13)
    );
    $("ul li").remove();
  }

  function continueForm() {
    $("#submit").attr("disabled", true);
    $("#edit").attr("disabled", true);
    $("#continue").attr("disabled", true);
    $("#container")
      .append(`<h2>Payment details</h2>`)
      .append(
        $(`<select id="paymentOptions" class="custom-select">`)
          .append(`<option selected disabled hidden>Choose</option>`)
          .append(`<option value="creditCard">Credit Card</option>`)
          .append(`<option value="bankTransfer">Bank Transfer</option>`)
      )
      .append(`<div id="extraDetails">`);
    $("#paymentOptions").on("change", paymentDone);
  }

  function paymentDone() {
    $("#extraDetails").empty();

    if ($("#paymentOptions").val() == "creditCard") {
      $("#extraDetails")
        .append($(`<div class="inputLabel">Card Number<input></div><br>`))
        .append($(`<div class="inputLabel">Expiration Date<input></div><br>`))
        .append($(`<div class="inputLabel">Security Numbers<input></div><br>`));
    } else {
      $("#extraDetails").append(
        $(
          `<p>You have 48 hours to transfer the amount to:<br>IBAN: GR96 0810 0010 0000 0123 4567 890</p>`
        )
      );
    }
    

    $("#extraDetails").append($(`<button id="checkOut">Check Out</button>`));

    $("#checkOut").on("click", () => {
      $("#wrapper").empty();
      $("#wrapper").append($(`<h4>Thank you for your reservation!</h4>`));
    });
  }
}
