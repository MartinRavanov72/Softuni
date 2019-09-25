describe('isOddOrEven', function () {
  it('with a number parameter should return undefined', function () {
    assert.equal(isOddOrEven(13), undefined);
  });
  it('with an object parameter should return undefined', function () {
    assert.equal(isOddOrEven({
      name: 'Stamat'
    }), undefined);
  });
  it('with an even length string should return even', function () {
    assert.equal(isOddOrEven("azis"), "even");
  });
  it('with an odd length string should return odd', function () {
    assert.equal(isOddOrEven("azisi"), "odd");
  });
  it('with multiple checks should return correct values', function () {
    assert.equal(isOddOrEven("azi"), 'odd');
    assert.equal(isOddOrEven("azisisi"), "odd");
    assert.equal(isOddOrEven("AsIz"), "even");
  });
});