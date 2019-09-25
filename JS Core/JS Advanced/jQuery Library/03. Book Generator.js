function createBook(selector, title, author, ISBN) {
            let id = 1;

            function bookGenerator(selector, title, author, ISBN) {
                let container = $(selector);
                let bookContainer = $('<div>');
                bookContainer.attr('id', `book${id}`);
                bookContainer.css('border', 'none');
                $(`<p class="title">${title}</p>`).appendTo(bookContainer);
                $(`<p class="author">${author}</p>`).appendTo(bookContainer);
                $(`<p class="isbn">${ISBN}</p>`).appendTo(bookContainer);
                let selectButton = $(`<button>Select</button>`);
                let deselectButton = $(`<button>Deselect</button>`);
                selectButton.on('click', setBorder);
                deselectButton.on('click', removeBorder);

                function setBorder() {
                    bookContainer.css('border', '2px solid blue');
                }

                function removeBorder() {
                    bookContainer.css('border', 'none');
                }
                selectButton.appendTo(bookContainer);
                deselectButton.appendTo(bookContainer);
                bookContainer.appendTo(container);
                

            }
            bookGenerator(selector, title, author, ISBN);
        }