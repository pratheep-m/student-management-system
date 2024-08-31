import java.util.Scanner;

// Node class to represent each student in the system
class StudentNode {
    String name;
    int rollNo;
    String course;
    StudentNode next;  // Points to the next student in the list

    // Constructor to initialize a student node
    public StudentNode(String name, int rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.next = null;
    }
}

// LinkedList class to manage students in the system
class StudentLinkedList {
    private StudentNode head;  // Points to the first student in the list

    // Constructor to initialize an empty linked list
    public StudentLinkedList() {
        this.head = null;
    }

    // Method to add a student at the end of the list
    public void addStudent(String name, int rollNo, String course) {
        StudentNode newStudent = new StudentNode(name, rollNo, course);
        if (head == null) {  // If the list is empty, set the new student as the head
            head = newStudent;
        } else {
            StudentNode lastStudent = head;
            while (lastStudent.next != null) {  // Traverse to the end of the list
                lastStudent = lastStudent.next;
            }
            lastStudent.next = newStudent;  // Append the new student to the list
        }
        System.out.println("Student \"" + name + "\" added successfully.");
    }

    // Method to display all students
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students in the system.");
        } else {
            StudentNode current = head;
            while (current != null) {
                System.out.println("Name: " + current.name + ", Roll No: " + current.rollNo + ", Course: " + current.course);
                current = current.next;
            }
        }
    }

    // Method to search for a student by name
    public void searchStudent(String name) {
        StudentNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("Student found - Name: " + current.name + ", Roll No: " + current.rollNo + ", Course: " + current.course);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    // Method to remove a student by roll number
    public void removeStudent(int rollNo) {
        if (head == null) {
            System.out.println("The system is empty.");
            return;
        }

        // If the student to be removed is the first one
        if (head.rollNo == rollNo) {
            System.out.println("Student \"" + head.name + "\" removed.");
            head = head.next;  // Update head to the next student
            return;
        }

        // Traverse to find the student to remove
        StudentNode previous = null;
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                System.out.println("Student \"" + current.name + "\" removed.");
                previous.next = current.next;  // Skip the current node
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Student with Roll No: " + rollNo + " not found.");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Remove Student by Roll No");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student course: ");
                    String course = scanner.nextLine();
                    studentList.addStudent(name, rollNo, course);
                    break;
                case 2:
                    studentList.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter the name of the student to search: ");
                    String searchName = scanner.nextLine();
                    studentList.searchStudent(searchName);
                    break;
                case 4:
                    System.out.print("Enter the roll number of the student to remove: ");
                    int removeRollNo = scanner.nextInt();
                    studentList.removeStudent(removeRollNo);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
