// Factory Pattern Implementation for Classroom, Student, and Assignment Creation

// Abstract Product
abstract class Element {
    protected String id;
    protected String name;

    public Element(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayInfo();
}

// Concrete Product: Student
class StudentElement extends Element {
    public StudentElement(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student - ID: " + id + ", Name: " + name);
    }
}

// Concrete Product: Classroom
class ClassroomElement extends Element {
    public ClassroomElement(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Classroom - ID: " + id + ", Name: " + name);
    }
}

// Concrete Product: Assignment
class AssignmentElement extends Element {
    private String details;

    public AssignmentElement(String id, String name) {
        super(id, name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Assignment - ID: " + id + ", Name: " + name );
    }
}

// Factory
class ElementFactory {
    public static Element createElement(String type, String id, String name) {
        if (type.equalsIgnoreCase("Student")) {
            return new StudentElement(id, name);
        } else if (type.equalsIgnoreCase("Classroom")) {
            return new ClassroomElement(id, name);
        } else if (type.equalsIgnoreCase("Assignment")) {
            return new AssignmentElement(id, name);
        }
        return null;
    }
}

// Demonstration of Factory Pattern
public class FactoryPattern {
    public static void main(String[] args) {
        Element classroom1 = ElementFactory.createElement("Classroom", "C1", "IT");
        Element classroom2 = ElementFactory.createElement("Classroom", "C2", "CSE");

        Element student1 = ElementFactory.createElement("Student", "S1", "Ravi");
        Element student2 = ElementFactory.createElement("Student", "S2", "Ajay");

        Element assignment1 = ElementFactory.createElement("Assignment", "A1", "DSA");
        Element assignment2 = ElementFactory.createElement("Assignment", "A2", "OOPS");

        classroom1.displayInfo();
        classroom2.displayInfo();

        student1.displayInfo();
        student2.displayInfo();

        assignment1.displayInfo();
        assignment2.displayInfo();
    }
}
