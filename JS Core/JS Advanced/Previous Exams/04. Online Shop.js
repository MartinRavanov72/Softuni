function onlineShop(selector) {
  let form = `<div id="header">Online Shop Inventory</div>
    <div class="block">
        <label class="field">Product details:</label>
        <br>
        <input placeholder="Enter product" class="custom-select">
        <input class="input1" id="price" type="number" min="1" max="999999" value="1"><label class="text">BGN</label>
        <input class="input1" id="quantity" type="number" min="1" value="1"><label class="text">Qty.</label>
        <button id="submit" class="button" disabled>Submit</button>
        <br><br>
        <label class="field">Inventory:</label>
        <br>
        <ul class="display">
        </ul>
        <br>
        <label class="field">Capacity:</label><input id="capacity" readonly>
        <label class="field">(maximum capacity is 150 items.)</label>
        <br>
        <label class="field">Price:</label><input id="sum" readonly>
        <label class="field">BGN</label>
    </div>`;
  let allQuantity = 0;
  $(selector).html(form);
  $(".custom-select").on("input", enableSubmitButton);

  function enableSubmitButton() {
    $("#submit").removeAttr("disabled");
  }

  $("#submit").on("click", enlist);

  function enlist() {
    let price = $("#price").val();
    let quantity = $("#quantity").val();
    allQuantity += +quantity;
    let name = $(".custom-select").val();
    let str = `Product: ${name} Price: ${price} Quantity: ${quantity}`;
    $(".display").append($("<li>").text(str));
    $("#sum").val(+$("#sum").val() + +price);
    $("#price").val(1);
    $("#quantity").val(1);
    $(".custom-select").val("");
    $("#capacity").val(allQuantity);
    $("#submit").attr("disabled", true);
    if (allQuantity >= 150) {
      $("#capacity").val("full");
      $("#capacity").addClass("fullCapacity");
      $("#price").attr("disabled", true);
      $("#quantity").attr("disabled", true);
      $(".custom-select").attr("disabled", true);
      $("#submit").attr("disabled", true);
    }
  }
}
