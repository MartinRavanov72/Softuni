class Textbox {
  constructor(selector, regex) {
    this._elements = $(selector);
    this.value = $(this._elements[0]).val();
    this._invalidSymbols = regex;
    this.onInput();
  }

  onInput() {
    this._elements.on('input', (event) => {
      let text = $(event.target).val();
      this.value = text;
    });
  }

  get elements() {
    return this._elements;
  }

  get value() {
    return this._value;
  }

  set value(value) {
    this._value = value;
    for (let element of this._elements) {
      $(element).val(value);
    }
  }

  isValid() {
    return !this._invalidSymbols.test(this.value);
  }
}