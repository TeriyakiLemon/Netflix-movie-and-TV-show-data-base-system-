import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file containing title data: ");
        String filename = scanner.nextLine();

        TitleDatabase titleDatabase = new TitleDatabase();
        boolean fileRead = false; // Add this line
        FileHandler.readDataFromFile(filename, titleDatabase);
        fileRead = true; // Set the flag to true if the file is read successfully

        // Only proceed with the user interface if the file was read successfully
        if (fileRead) {
            UserInterface userInterface = new UserInterface(titleDatabase,filename);
            userInterface.start();

        }


    }
}
