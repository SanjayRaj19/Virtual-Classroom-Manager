package edu.virtualclassroom;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Classroom {
    private static final Logger logger = Logger.getLogger(Classroom.class.getName());

    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be null or empty");
        }
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        logger.info("Created classroom: " + name);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
        logger.info("Added student: " + student.getId() + " to classroom: " + name);
    }

    public void addAssignment(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Assignment cannot be null");
        }
        assignments.add(assignment);
        logger.info("Added assignment: " + assignment.getDetails() + " to classroom: " + name);
    }
}
