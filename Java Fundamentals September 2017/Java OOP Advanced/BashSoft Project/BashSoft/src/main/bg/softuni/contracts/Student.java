package main.bg.softuni.contracts;

import java.util.Map;

public interface Student extends Comparable<Student>{
    Map<String, Course> getEnrolledCourses();

    Map<String, Double> getMarksByCourseName();

    String getUserName();

    void setUserName(String userName);

    void enrollInCourse (Course course);

    void setMarkOnCourse (String courseName, int... scores);
}
