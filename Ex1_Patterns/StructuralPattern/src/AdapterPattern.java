import java.util.HashMap;
import java.util.Map;

// Legacy Student System
class LegacyStudent {
    private String studentId;
    private String studentName;

    public LegacyStudent(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}

// Target Interface
interface Student {
    String getId();
    String getName();
}

// Adapter
class StudentAdapter implements Student {
    private LegacyStudent legacyStudent;

    public StudentAdapter(LegacyStudent legacyStudent) {
        this.legacyStudent = legacyStudent;
    }

    @Override
    public String getId() {
        return legacyStudent.getStudentId();
    }

    @Override
    public String getName() {
        return legacyStudent.getStudentName();
    }
}

// New Classroom, Assignment, and Manager Classes
class Classroom {
    private String name;
    private Map<String, Student> students = new HashMap<>();
    private Map<String, String> assignments = new HashMap<>();
    private Map<String, String> submissions = new HashMap<>();

    public Classroom(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println("Student " + student.getId() + " (" + student.getName() + ") has been added to " + name);
    }

    public void scheduleAssignment(String assignmentId, String details) {
        assignments.put(assignmentId, details);
        System.out.println("Assignment " + assignmentId + " scheduled for " + name + ": " + details);
    }

    public void submitAssignment(String studentName, String assignmentId, String submission) {
        String key = studentName + "-" + assignmentId;
        submissions.put(key, submission);
        System.out.println("Assignment " + assignmentId + " submitted by Student " + studentName + " in " + name + ": " + submission);
    }

    public void showDetails() {
        System.out.println("Classroom: " + name);
        System.out.println("Students: " + students.keySet());
        System.out.println("Assignments: " + assignments);
        System.out.println("Submissions: " + submissions);
    }
}

// Client
public class AdapterPattern {
    public static void main(String[] args) {
        LegacyStudent legacyStudent1 = new LegacyStudent("1", "Ravi");
        Student student1 = new StudentAdapter(legacyStudent1);

        LegacyStudent legacyStudent2 = new LegacyStudent("2", "Ajay");
        Student student2 = new StudentAdapter(legacyStudent2);

        Classroom mathClass = new Classroom("IT");

        mathClass.addStudent(student1);
        mathClass.addStudent(student2);

        mathClass.scheduleAssignment("A1", "Complete the program");
        mathClass.submitAssignment("Ravi", "A1", "Program solved by Ravi");

        mathClass.showDetails();
    }
}
