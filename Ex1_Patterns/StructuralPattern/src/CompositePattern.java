import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Component
interface Component {
    void showDetails();
}

// Leaf
class StudentComponent implements Component {
    private String id;
    private String name;

    public StudentComponent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Student - ID: " + id + ", Name: " + name);
    }
}

// Leaf
class AssignmentComponent implements Component {
    private String id;
    private String details;

    public AssignmentComponent(String id, String details) {
        this.id = id;
        this.details = details;
    }

    @Override
    public void showDetails() {
        System.out.println("Assignment - ID: " + id + ", Details: " + details);
    }
}

// Composite
class ClassroomComposite implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();
    private Map<String, String> submissions = new HashMap<>();

    public ClassroomComposite(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void submitAssignment(String studentId, String assignmentId, String submission) {
        String key = studentId + "-" + assignmentId;
        submissions.put(key, submission);
        System.out.println("Assignment " + assignmentId + " submitted by Student " + studentId + " in " + name + ": " + submission);
    }

    @Override
    public void showDetails() {
        System.out.println("Classroom - Name: " + name);
        for (Component component : components) {
            component.showDetails();
        }
        System.out.println("Submissions: " + submissions);
    }
}

// Client
public class CompositePattern {
    public static void main(String[] args) {
        Component student1 = new StudentComponent("S1", "Ravi");
        Component student2 = new StudentComponent("S2", "Ajay");

        Component assignment1 = new AssignmentComponent("A1", "Solve problem");
        Component assignment2 = new AssignmentComponent("A2", "Describe the solution");

        ClassroomComposite mathClass = new ClassroomComposite("IT");
        mathClass.addComponent(student1);
        mathClass.addComponent(student2);
        mathClass.addComponent(assignment1);
        mathClass.addComponent(assignment2);

        mathClass.submitAssignment("S1", "A1", "Problem solved by Ravi");

        mathClass.showDetails();
    }
}
