function solve(name, age, weight, height) {
  let human = {
    name: name,
    personalInfo: {
      age: age, 
      weight: weight,
      height: height
    },
    BMI: Math.round(weight / (height * height / 10000))
  };

  human.status = human.BMI < 18.5 ? "underweight" : human.BMI < 25 ? "normal" : human.BMI < 30 ? "overweight" : "obese";

  if (human.status == "obese") {
    human.recommendation = "admission required";
  }

  return human;
}

