package main.bg.softuni.repository;

import main.bg.softuni.contracts.*;
import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.models.SoftUniCourse;
import main.bg.softuni.models.SoftUniStudent;
import main.bg.softuni.staticData.SessionData;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.staticData.ExceptionMessages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsRepository implements Database {

    private boolean isDataInitialized = false;
    private DataFilter filter;
    private DataSorter sorter;
    private LinkedHashMap<String, Student> students;
    private LinkedHashMap<String, Course> courses;

    public StudentsRepository(DataFilter filter, DataSorter sorter) {
        this.filter = filter;
        this.sorter = sorter;
    }

    public void loadData(String fileName) throws IOException {
        if (isDataInitialized) {
            throw new RuntimeException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
        }

        this.students = new LinkedHashMap<>();
        this.courses = new LinkedHashMap<>();
        this.readData(fileName);
    }

    public void unloadData() throws IOException {
        if (!this.isDataInitialized) {
            throw new RuntimeException(ExceptionMessages.DATA_NOT_INITIALIZED);
        }

        this.students = null;
        this.courses = null;
        this.isDataInitialized = false;
    }

    private void readData(String fileName) throws IOException {
        String regex = "([A-Z][a-zA-Z#\\+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Za-z]+\\d{2}_\\d{2,4})\\s([\\s0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        String path = SessionData.currentPath + "\\" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
            matcher = pattern.matcher(line);

            if (!line.isEmpty() && matcher.find()) {
                String courseName = matcher.group(1);
                String studentName = matcher.group(2);
                String scoresStr = matcher.group(3);
                try {
                    String[] splitScores = scoresStr.split("\\s+");
                    int[] scores = new int[splitScores.length];
                    for (int i = 0; i < splitScores.length; i++) {
                        scores[i] = Integer.parseInt(splitScores[i]);
                    }
                    if (Arrays.stream(scores).anyMatch(score -> score > 100 || score < 0)) {
                        OutputWriter.displayException(ExceptionMessages.INVALID_SCORE);
                        continue;
                    }
                    if (scores.length > SoftUniCourse.NUMBER_OF_TASKS_ON_EXAMS) {
                        OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
                        continue;
                    }
                    if (!this.students.containsKey(studentName)) {
                        this.students.put(studentName, new SoftUniStudent(studentName));
                    }
                    if (!this.courses.containsKey(courseName)) {
                        this.courses.put(courseName, new SoftUniCourse(courseName));
                    }
                    Course softUniCourse = this.courses.get(courseName);
                    Student softUniStudent = this.students.get(studentName);
                    softUniStudent.enrollInCourse(softUniCourse);
                    softUniStudent.setMarkOnCourse(courseName, scores);
                    softUniCourse.enrollStudent(softUniStudent);
                } catch (NumberFormatException nfe) {
                    OutputWriter.displayException(nfe.getMessage() + " at line: ");
                }
            }
        }
        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }

    public void getStudentMarkInCourse(String courseName, String studentName) {
        if (!isQueryForStudentPossible(courseName, studentName)) {
            return;
        }

        double mark = this.courses.get(courseName).getStudentsByName().get(studentName).getMarksByCourseName().get(courseName);
        OutputWriter.printStudent(studentName, mark);
    }

    public void getStudentsByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, Student> student : this.courses.get(course).getStudentsByName().entrySet()) {
            this.getStudentMarkInCourse(course, student.getKey());
        }
    }

    private boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!this.courses.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }

        return true;
    }

    private boolean isQueryForStudentPossible(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!this.courses.get(courseName).getStudentsByName().containsKey(studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }

        return true;
    }

    public void filterAndTake(String courseName, String filter) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        filterAndTake(courseName, filter, studentsToTake);
    }

    public void filterAndTake(
            String courseName, String filter, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));
        }
        this.filter.printFilteredStudents(marks, filter, studentsToTake);
    }

    public void orderAndTake(
            String courseName, String orderType, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }
        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));
        }
        this.sorter.printSortedStudents(marks, orderType, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        orderAndTake(courseName, orderType, studentsToTake);
    }

    @Override
    public SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp) {
        SimpleSortedList<Course> courseSortedList = new SimpleSortedList<>(Course.class, cmp);
        courseSortedList.addAll(this.courses.values());
        return courseSortedList;
    }

    @Override
    public SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp) {
        SimpleSortedList<Student> studentSortedList = new SimpleSortedList<>(Student.class, cmp);
        studentSortedList.addAll(this.students.values());
        return studentSortedList;
    }
}
