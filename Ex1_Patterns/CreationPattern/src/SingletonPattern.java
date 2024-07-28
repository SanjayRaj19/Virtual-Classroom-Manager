import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Singleton Pattern Implementation for ClassroomManager

class ClassroomManager {
    private static ClassroomManager instance;
    private List<String> classrooms = new ArrayList<>();
    private Map<String, Student> students = new HashMap<>();
    private List<String> assignments = new ArrayList<>();

    private ClassroomManager() {}

    public static ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String className) {
        classrooms.add(className);
        System.out.println("Classroom " + className + " has been created.");
    }

    public void addStudent(String id, String name) {
        Student student = new Student(id, name);
        students.put(id, student);
        System.out.println("Student " + id + " (" + name + ") has been added.");
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        assignments.add(className + ": " + assignmentDetails);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    public void listClassrooms() {
        System.out.println("Classrooms: " + classrooms);
    }

    public void listStudents() {
        System.out.println("Students: " + students.values());
    }

    public void listAssignments() {
        System.out.println("Assignments: " + assignments);
    }
}

// Student class
class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student - ID: " + id + ", Name: " + name;
    }
}

// Demonstration of Singleton and Factory Patterns
public class SingletonPattern {
    public static void main(String[] args) {
        ClassroomManager manager = ClassroomManager.getInstance();

        manager.addClassroom("IT1");
        manager.addClassroom("IT2");

        manager.addStudent("1", "Ravi");
        manager.addStudent("2", "Ajay");

        manager.scheduleAssignment("IT1", "Assignment1: DSA");
        manager.scheduleAssignment("IT2", "Assignment1: OOPS");

        manager.listClassrooms();
        manager.listStudents();
        manager.listAssignments();
    }
}
