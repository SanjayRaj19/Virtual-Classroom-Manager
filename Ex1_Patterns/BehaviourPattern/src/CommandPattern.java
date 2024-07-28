import java.util.*;


interface Command {
    void execute();
}

class ClassroomManager {
    private List<String> classrooms = new ArrayList<>();
    private List<String> assignments = new ArrayList<>();

    public void addClassroom(String className) {
        classrooms.add(className);
        System.out.println("Classroom " + className + " has been created.");
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        assignments.add(className + ": " + assignmentDetails);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void listClassrooms() {
        System.out.println("Classrooms: " + classrooms);
    }

    public void listAssignments() {
        System.out.println("Assignments: " + assignments);
    }
}

class AddClassroomCommand implements Command {
    private ClassroomManager classroomManager;
    private String className;

    public AddClassroomCommand(ClassroomManager classroomManager, String className) {
        this.classroomManager = classroomManager;
        this.className = className;
    }

    @Override
    public void execute() {
        classroomManager.addClassroom(className);
    }
}

class ScheduleAssignmentCommand implements Command {
    private ClassroomManager classroomManager;
    private String className;
    private String assignmentDetails;

    public ScheduleAssignmentCommand(ClassroomManager classroomManager, String className, String assignmentDetails) {
        this.classroomManager = classroomManager;
        this.className = className;
        this.assignmentDetails = assignmentDetails;
    }

    @Override
    public void execute() {
        classroomManager.scheduleAssignment(className, assignmentDetails);
    }
}

class CommandInvoker {
    private List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        ClassroomManager classroomManager = new ClassroomManager();
        CommandInvoker invoker = new CommandInvoker();

        Command addClassroom = new AddClassroomCommand(classroomManager, "C1");
        invoker.executeCommand(addClassroom);

        Command scheduleAssignment = new ScheduleAssignmentCommand(classroomManager, "C1", "Assignment1: Networks");
        invoker.executeCommand(scheduleAssignment);

        classroomManager.listClassrooms();
        classroomManager.listAssignments();
    }
}
