import java.util.*;

// Student class
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

// Main class
public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Student Record Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // ✅ clear buffer here

            switch (choice) {
                case 1: // Add
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    sc.nextLine(); // clear buffer
                    students.add(new Student(id, name, marks));
                    System.out.println("✅ Student Added!");
                    break;

                case 2: // View
                    System.out.println("\n--- Student List ---");
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3: // Update
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    boolean updated = false;
                    for (Student s : students) {
                        if (s.getId() == uid) {
                            System.out.print("Enter New Name: ");
                            s.setName(sc.nextLine());
                            System.out.print("Enter New Marks: ");
                            s.setMarks(sc.nextDouble());
                            sc.nextLine(); // clear buffer
                            System.out.println("✅ Student Updated!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("⚠️ Student ID not found!");
                    }
                    break;

                case 4: // Delete
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    boolean removed = students.removeIf(s -> s.getId() == did);
                    if (removed) {
                        System.out.println("❌ Student Deleted!");
                    } else {
                        System.out.println("⚠️ Student ID not found!");
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}