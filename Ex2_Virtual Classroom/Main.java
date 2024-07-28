package edu.virtualclassroom;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Print initial state
        displayState(manager);

        while (!exit) {
            System.out.println("Enter command:");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ", 2);
            String command = tokens[0];

            try {
                switch (command) {
                    case "add_classroom":
                        if (tokens.length < 2) {
                            throw new IllegalArgumentException("Classroom name is required.");
                        }
                        manager.addClassroom(tokens[1]);
                        break;
                    case "remove_classroom":
                        if (tokens.length < 2) {
                            throw new IllegalArgumentException("Classroom name is required.");
                        }
                        manager.removeClassroom(tokens[1]);
                        break;
                    case "add_student":
                        if (tokens.length < 2) {
                            throw new IllegalArgumentException("Student ID and Classroom name are required.");
                        }
                        String[] studentParams = tokens[1].split(" ", 2);
                        if (studentParams.length < 2) {
                            throw new IllegalArgumentException("Student ID and Classroom name are required.");
                        }
                        manager.addStudent(studentParams[0], studentParams[1]);
                        break;
                    case "schedule_assignment":
                        if (tokens.length < 2) {
                            throw new IllegalArgumentException("Classroom name and Assignment details are required.");
                        }
                        String[] assignmentParams = tokens[1].split(" ", 2);
                        if (assignmentParams.length < 2) {
                            throw new IllegalArgumentException("Classroom name and Assignment details are required.");
                        }
                        manager.scheduleAssignment(assignmentParams[0], assignmentParams[1]);
                        break;
                    case "submit_assignment":
                        if (tokens.length < 2) {
                            throw new IllegalArgumentException("Student ID, Classroom name, and Assignment details are required.");
                        }
                        String[] submitParams = tokens[1].split(" ", 3);
                        if (submitParams.length < 3) {
                            throw new IllegalArgumentException("Student ID, Classroom name, and Assignment details are required.");
                        }
                        manager.submitAssignment(submitParams[0], submitParams[1], submitParams[2]);
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        System.out.println("Unknown command.");
                }
                displayState(manager);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error processing command: " + input, e);
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void displayState(VirtualClassroomManager manager) {
        System.out.println("Current State:");

        List<String> classrooms = manager.getClassroomList();
        System.out.println("Number of Classrooms: " + classrooms.size());
        if (!classrooms.isEmpty()) {
            System.out.println("Classrooms: " + classrooms);
        }

        Map<String, List<String>> studentsInClassrooms = manager.getStudentsInClassrooms();
        int totalStudents = studentsInClassrooms.values().stream().mapToInt(List::size).sum();
        System.out.println("Number of Students: " + totalStudents);
        if (totalStudents > 0) {
            studentsInClassrooms.forEach((className, students) -> {
                System.out.println("Classroom " + className + " Students: " + students);
                System.out.println("Number of Students in " + className + ": " + students.size());
            });
        }

        Map<String, List<String>> assignmentsInClassrooms = manager.getAssignmentsInClassrooms();
        int totalAssignments = assignmentsInClassrooms.values().stream().mapToInt(List::size).sum();
        System.out.println("Number of Assignments: " + totalAssignments);
        if (totalAssignments > 0) {
            assignmentsInClassrooms.forEach((className, assignments) -> {
                System.out.println("Classroom " + className + " Assignments: " + assignments);
                System.out.println("Number of Assignments in " + className + ": " + assignments.size());
            });
        }

        Map<String, Map<String, List<String>>> submittedAssignments = manager.getSubmittedAssignments();
        if (!submittedAssignments.isEmpty()) {
            submittedAssignments.forEach((className, studentAssignments) -> {
                System.out.println("Classroom " + className + " Submitted Assignments:");
                studentAssignments.forEach((studentId, assignments) -> {
                    System.out.println("Student " + studentId + " submitted: " + assignments);
                });
            });
        }
    }
}
