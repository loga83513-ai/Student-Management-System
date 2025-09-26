import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    // Method to write notes to file
    public static void writeNote(String note, boolean append) {
        try (FileWriter fw = new FileWriter(FILE_NAME, append)) {
            fw.write(note + System.lineSeparator());
            System.out.println("✅ Note saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error while writing note: " + e.getMessage());
        }
    }

    // Method to read all notes from file
    public static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📖 Your Notes:");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ No notes found. Start writing one!");
        } catch (IOException e) {
            System.out.println("❌ Error while reading notes: " + e.getMessage());
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n==== Notes Manager ====");
            System.out.println("1. Add Note (Overwrite)");
            System.out.println("2. Add Note (Append)");
            System.out.println("3. View Notes");
            System.out.println("4. Exit");
            System.out.print("👉 Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("✍ Enter your note: ");
                    String overwriteNote = sc.nextLine();
                    writeNote(overwriteNote, false); // overwrite mode
                    break;
                case 2:
                    System.out.print("✍ Enter your note: ");
                    String appendNote = sc.nextLine();
                    writeNote(appendNote, true); // append mode
                    break;
                case 3:
                    readNotes();
                    break;
                case 4:
                    System.out.println("👋 Exiting Notes Manager...");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
