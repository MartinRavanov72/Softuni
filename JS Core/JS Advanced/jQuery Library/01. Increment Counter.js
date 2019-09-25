function increment(selector) {
            let div = $(`${selector}`);
            let textArea = $("<textarea>");
            let incrementBtn = $(`<button>Increment</button>`);
            let addBtn = $("<button>Add</button>");
            let ul = $("<ul>");
            textArea.val(0);
            textArea.addClass("counter");
            textArea.attr("disabled", true);
            incrementBtn.addClass("btn");
            incrementBtn.attr("id", "incrementBtn");
            addBtn.addClass("btn");
            addBtn.attr("id", "addBtn");
            ul.addClass("results");
            textArea.appendTo(div);
            incrementBtn.appendTo(div);
            addBtn.appendTo(div);
            ul.appendTo(div);
            incrementBtn.on("click", incrementValue);
            addBtn.on("click", addValueToList);

            function addValueToList() {
                $(`<li>${textArea.val()}</li>`).appendTo(ul);
            }

            function incrementValue() {
                textArea.val(+textArea.val() + 1);
            }
        }