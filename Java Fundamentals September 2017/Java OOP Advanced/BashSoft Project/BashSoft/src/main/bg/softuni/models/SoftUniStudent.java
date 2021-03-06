package main.bg.softuni.models;

import main.bg.softuni.contracts.Course;
import main.bg.softuni.contracts.Student;
import main.bg.softuni.exceptions.DuplicateEntryInStructureException;
import main.bg.softuni.exceptions.InvalidStringException;
import main.bg.softuni.exceptions.KeyNotFoundException;
import main.bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniStudent implements Student {
    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(marksByCourseName);
    }

    public SoftUniStudent(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.equals("")) {
            throw new InvalidStringException();

        }
        this.userName = userName;
    }

    public void enrollInCourse (Course softUniCourse){
        if (this.enrolledCourses.containsKey(softUniCourse.getName())) {
            throw new DuplicateEntryInStructureException(this.userName, softUniCourse.getName());
        }
        this.enrolledCourses.put(softUniCourse.getName(), softUniCourse);
    }

    public void setMarkOnCourse (String courseName, int... scores){
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new KeyNotFoundException();
        }
        if (scores.length > SoftUniCourse.NUMBER_OF_TASKS_ON_EXAMS) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }
        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores){
        double percentageOfSolvedExams = Arrays.stream(scores).sum() / (double) (SoftUniCourse.NUMBER_OF_TASKS_ON_EXAMS * SoftUniCourse.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExams * 4 + 2;
        return mark;
    }

    @Override
    public int compareTo(Student student) {
        return this.getUserName().compareTo(student.getUserName());
    }

    @Override
    public String toString() {
        return this.getUserName();
    }
}
