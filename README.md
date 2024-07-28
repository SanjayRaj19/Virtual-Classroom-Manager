# Virtual-Classroom-Manager


The Virtual Classroom Manager is a terminal-based Java application that allows users to manage virtual classrooms. It supports functionalities such as adding/removing classrooms, enrolling students, scheduling assignments, and submitting assignments.

Prerequisites
      1) Java Development Kit (JDK) 8 or higher
      2) A terminal or command prompt

After running the application, you can interact with the Virtual Classroom Manager through the terminal. The application will prompt you to enter commands to manage classrooms, students, and assignments.

Commands
    Add Classroom:
    
        add_classroom <class_name>
        
Creates a new virtual classroom with the specified name.

  Remove Classroom:
  
        remove_classroom <class_name>
        
Removes the virtual classroom with the specified name.

  Add Student:
  
        add_student <student_id> <class_name>
        
Enrolls a student with the specified ID in the given classroom.

  Schedule Assignment:
  
        schedule_assignment <class_name> <assignment_details>
Schedules an assignment for the specified classroom.

  Submit Assignment:
  
      submit_assignment <student_id> <class_name> <assignment_details>
      
Marks an assignment as submitted by the specified student in the given classroom.

  Exit:
  
      exit
      
Exits the application.

Classes Overview:

1)VirtualClassroomManager:
Manages the overall functionalities of adding/removing classrooms, students, and assignments.

2)Main:
The entry point of the application. Handles user input and command execution.

3)Classroom:
Represents a virtual classroom. Manages students and assignments within the classroom.

4)Student:
Represents a student with an ID and name.

5)Assignment:
Represents an assignment with details.



Design Patterns used to demonstarte the the understanding of the software design

Behaviour Patterns

Command Pattern

Encapsulates a request as an object, allowing for parameterization of clients with queues, requests, and operations.

Observer Pattern

Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.


Creational Patterns

Singleton Pattern

Ensures a class has only one instance and provides a global point of access to it.

Factory Pattern

Defines an interface for creating an object but lets subclasses alter the type of objects that will be created.

    
Structural Patterns

Adapter Pattern

Allows incompatible interfaces to work together by converting the interface of a class into another interface the client expects.

Composite Pattern

Composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions uniformly.


Running the Project

Compile all the Java files.
Run the main class for each pattern to see the example usages.
Observe the console outputs to understand how the patterns are applied.
