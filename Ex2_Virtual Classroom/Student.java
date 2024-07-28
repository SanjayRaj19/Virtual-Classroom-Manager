package edu.virtualclassroom;

import java.util.logging.Logger;

public class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());

    private String id;

    public Student(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
        this.id = id;
        logger.info("Created student with ID: " + id);
    }

    public String getId() {
        return id;
    }
}