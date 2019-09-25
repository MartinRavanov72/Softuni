function printCatalogue(input) {
    let students = new Map;
    for (let line of input){
        let nameParams = line.substring(14).split(", Grade: ").filter(x => x !== "");
        let name = nameParams[0];
        let gradeParams = nameParams[1].split(", Graduated with an average score: ").filter(x => x !== "");
        let grade = +gradeParams[0];
        let averageScore = +gradeParams[1];
        if (averageScore >= 3) {
            let student = {
                name: name,
                grade: ++grade,
                averageScore: averageScore
            }
            if(!students.has(student.grade)){
                students.set(student.grade, []);
            }
            students.get(student.grade).push(student);
        }
    }
        
    let sortedGrades = [...students.keys()].sort((a, b) => a - b);
    
    for (let grade of sortedGrades) {
        console.log(grade + " Grade");
        let sortedStudents = students.get(grade);
        let str = "List of students: " + sortedStudents.map(s => s.name).join(", ");
        console.log(str); 
        let avgResult = (sortedStudents.map(s => s.averageScore).reduce((a, b) => a + b)) / sortedStudents.length;
        let str2 = "Average annual grade from last year: " + (Math.round(avgResult * 100) / 100).toFixed(2);
        console.log(str2);
        console.log();
    }
}