describe("Test HolidayPackage class", function () {
  let pack = new HolidayPackage();
  beforeEach(() => {
    pack = new HolidayPackage("Azisland", "Summer");
  });
  it("works fine", () => {
    assert.equal(pack.showVacationers(), "No vacationers are added yet")
  });

  it("works fine", () => {
    pack.addVacationer("Azis Sladura");
    pack.addVacationer("Kitaeca Azisov");
    assert.equal(pack.showVacationers(), "Vacationers:\n" + "Azis Sladura\n" + "Kitaeca Azisov");
  });

  it("works fine", () => {
    expect(() => pack.addVacationer(3)).to.throw();
  });

  it("works fine", () => {
    expect(() => pack.addVacationer(' ')).to.throw();
  });

  it("works fine", () => {
    expect(() => pack.addVacationer('Azis')).to.throw();
  });

  it("works fine", () => {
    expect(() => pack.addVacationer('Azis Azisov Azisov')).to.throw();
  });

  it("works fine", () => {
    pack.addVacationer("Azis Sladura");
    assert.equal(pack.vacationers[0], "Azis Sladura");
  });

  it("works fine", () => {
    expect(() => pack.generateHolidayPackage()).to.throw();
  });

  it("works fine", () => {
    pack.addVacationer("Azis Sladura");
    assert.equal(pack.vacationers[0], "Azis Sladura");
  });

  it("works fine", () => {
    pack.addVacationer("Azis Sladura");
    pack.addVacationer("Kitaeca Azisov");
    assert.equal(pack.generateHolidayPackage(), "Holiday Package Generated\n" +
      "Destination: " + "Azisland" + "\n" +
      "Vacationers:\n" + "Azis Sladura\n" + "Kitaeca Azisov" + "\n" +
      "Price: " + "1000");
  });

  it("works fine", () => {
    pack.season = "Winter"
    pack.addVacationer("Azis Sladura");
    pack.addVacationer("Kitaeca Azisov");
    pack.addVacationer("Brat Mu");
    pack.insuranceIncluded = true;
    assert.equal(pack.generateHolidayPackage(), "Holiday Package Generated\n" +
      "Destination: " + "Azisland" + "\n" +
      "Vacationers:\n" + "Azis Sladura\n" + "Kitaeca Azisov" + "\n" + "Brat Mu\n" +
      "Price: " + "1500");
  });

  it("works fine", () => {
    pack.season = "Spring"
    pack.addVacationer("Azis Sladura");
    pack.addVacationer("Kitaeca Azisov");
    pack.addVacationer("Brat Mu");
    pack.insuranceIncluded = false;
    assert.equal(pack.generateHolidayPackage(), "Holiday Package Generated\n" +
      "Destination: " + "Azisland" + "\n" +
      "Vacationers:\n" + "Azis Sladura\n" + "Kitaeca Azisov" + "\n" + "Brat Mu\n" +
      "Price: " + "1200");
  });

  it("works fine", () => {
    pack.season = "Spring"
    pack.addVacationer("Azis Sladura");
    pack.addVacationer("Kitaeca Azisov");
    pack.addVacationer("Brat Mu");
    expect(() => pack.insuranceIncluded = "Azis").to.throw();
  });

  it("works fine", () => {
    pack.season = "Spring"
    pack.addVacationer("Azis Sladura");
    pack.addVacationer("Kitaeca Azisov");
    pack.addVacationer("Brat Mu");
    pack.insuranceIncluded = false;
    assert.equal(pack.insuranceIncluded, false);
  });
});