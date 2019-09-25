CREATE TABLE students(
student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(30) NOT NULL
);

CREATE TABLE exams(
exam_id INT PRIMARY KEY NOT NULL,
name VARCHAR(30) NOT NULL
);

CREATE TABLE students_exams(
student_id INT NOT NULL,
exam_id INT NOT NULL
);

INSERT INTO students(name)
VALUES('Mila'), ('Toni'), ('Ron');

INSERT INTO exams
VALUES(101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

INSERT INTO students_exams
VALUES(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);


ALTER TABLE students_exams
ADD PRIMARY KEY (student_id, exam_id),
ADD FOREIGN KEY (student_id) REFERENCES students(student_id),
ADD FOREIGN KEY (exam_id) REFERENCES exams(exam_id);