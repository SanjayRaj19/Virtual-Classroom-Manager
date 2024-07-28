package edu.virtualclassroom;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;
import java.util.List;
import java.util.stream.Collectors;

public class VirtualClassroomManager {
    private static final Logger logger = Logger.getLogger(VirtualClassroomManager.class.getName());
    private Map<String, Classroom> classrooms;
    private Map<String, Map<String, List<String>>> submittedAssignments;

    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
        submittedAssignments = new HashMap<>();
        logger.info("Initialized VirtualClassroomManager");
    }

    public void addClassroom(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be null or empty");
        }
        if (!classrooms.containsKey(name)) {
            classrooms.put(name, new Classroom(name));
            System.out.println("Classroom " + name + " has been created.");
        } else {
            System.out.println("Classroom " + name + " already exists.");
        }
    }

    public void removeClassroom(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be null or empty");
        }
        if (classrooms.containsKey(name)) {
            classrooms.remove(name);
            submittedAssignments.remove(name);
            System.out.println("Classroom " + name + " has been removed.");
        } else {
            System.out.println("Classroom " + name + " does not exist.");
        }
    }

    public void addStudent(String studentId, String className) {
        if (studentId == null || studentId.isEmpty() || className == null || className.isEmpty()) {
            throw new IllegalArgumentException("Student ID and Classroom name cannot be null or empty");
        }
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Student student = new Student(studentId);
            classroom.addStudent(student);
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        if (className == null || className.isEmpty() || assignmentDetails == null || assignmentDetails.isEmpty()) {
            throw new IllegalArgumentException("Classroom name and Assignment details cannot be null or empty");
        }
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Assignment assignment = new Assignment(assignmentDetails);
            classroom.addAssignment(assignment);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        if (studentId == null || studentId.isEmpty() || className == null || className.isEmpty() || assignmentDetails == null || assignmentDetails.isEmpty()) {
            throw new IllegalArgumentException("Student ID, Classroom name, and Assignment details cannot be null or empty");
        }
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            boolean studentExists = classroom.getStudents().stream()
                    .anyMatch(student -> student.getId().equals(studentId));
            if (studentExists) {
                if (!submittedAssignments.containsKey(className)) {
                    submittedAssignments.put(className, new HashMap<>());
                }
                Map<String, List<String>> studentAssignments = submittedAssignments.get(className);
                if (!studentAssignments.containsKey(studentId)) {
                    studentAssignments.put(studentId, new ArrayList<>());
                }
                studentAssignments.get(studentId).add(assignmentDetails);
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
            } else {
                System.out.println("Student " + studentId + " is not enrolled in " + className + ".");
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public List<String> getClassroomList() {
        return classrooms.keySet().stream().collect(Collectors.toList());
    }

    public Map<String, List<String>> getStudentsInClassrooms() {
        return classrooms.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().getStudents().stream().map(Student::getId).collect(Collectors.toList())
        ));
    }

    public Map<String, List<String>> getAssignmentsInClassrooms() {
        return classrooms.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().getAssignments().stream().map(Assignment::getDetails).collect(Collectors.toList())
        ));
    }

    public Map<String, Map<String, List<String>>> getSubmittedAssignments() {
        return submittedAssignments;
    }
}
