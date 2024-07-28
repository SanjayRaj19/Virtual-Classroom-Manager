import java.util.*;

interface Observer {
    void update(String studentId, String className, String assignmentDetails);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String studentId, String className, String assignmentDetails);
}

class Student implements Observer {
    private String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public void update(String studentId, String className, String assignmentDetails) {
        if (this.id.equals(studentId)) {
            System.out.println("Student " + id + " has been notified: Assignment in " + className + " has been updated to: " + assignmentDetails);
        }
    }
}

class Classroom implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String className;

    public Classroom(String className) {
        this.className = className;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String studentId, String className, String assignmentDetails) {
        for (Observer observer : observers) {
            observer.update(studentId, className, assignmentDetails);
        }
    }

    public void submitAssignment(String studentId, String assignmentDetails) {
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        notifyObservers(studentId, className, assignmentDetails);
    }
}

// Demonstration of Observer Pattern
public class ObserverPattern {
    public static void main(String[] args) {
        Classroom classroom = new Classroom("IT");
        Student student1 = new Student("1");
        Student student2 = new Student("2");

        classroom.addObserver(student1);
        classroom.addObserver(student2);

        classroom.submitAssignment("1", "Assignment1: A1");
        classroom.submitAssignment("2", "Assignment2: A2");
    }
}
