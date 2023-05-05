import java.util.Scanner;
import java.util.List;
public class UserInterface {
    private Scanner scanner;
    private TitleDatabase titleDatabase;

    private String filename;

    public UserInterface(TitleDatabase titleDatabase,String filename) {
        this.scanner = new Scanner(System.in);
        this.titleDatabase = titleDatabase;
        this.filename = filename;
    }
    private void searchForTitles() {
        System.out.println("\nSelect the type of title:");
        System.out.println("1. TV Show");
        System.out.println("2. Movie");
        System.out.print("Enter your choice: ");
        String type = scanner.nextInt() == 1 ? "TV Show" : "Movie";
        scanner.nextLine();

        System.out.println("\nSelect the attribute to search by:");
        System.out.println("1. Rating");
        System.out.println("2. Director");
        System.out.println("3. Genre");
        System.out.println("4. Duration");
        System.out.println("5. Country");
        System.out.println("6. Year");
        System.out.print("Enter your choice: ");
        int attributeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nEnter the value of the attribute: ");
        String value = scanner.nextLine();

        String attribute;
        switch (attributeChoice) {
            case 1:
                attribute = "rating";
                break;
            case 2:
                attribute = "director";
                break;
            case 3:
                attribute = "genre";
                break;
            case 4:
                attribute = "duration";
                break;
            case 5:
                attribute = "country";
                break;
            case 6:
                attribute = "year";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        List<Title> results = titleDatabase.search(attribute, value,type);
        if (results.isEmpty()) {
            System.out.println("\nNo titles found.");
        } else {
            System.out.println("\nSearch results:");
            for (Title title : results) {
                System.out.println(title.getName());
            }
        }
    }
    private void addTitle() {
        System.out.println("\nSelect the type of title:");
        System.out.println("1. TV Show");
        System.out.println("2. Movie");
        System.out.print("Enter your choice: ");
        String type = scanner.nextInt() == 1 ? "TV Show" : "Movie";
        scanner.nextLine();

        System.out.print("Enter the title name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the rating: ");
        String rating = scanner.nextLine();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the director: ");
        String director = scanner.nextLine();

        System.out.print("Enter the genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter the duration: ");
        int duration = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the country: ");
        String country = scanner.nextLine();

        System.out.print("Enter the year: ");
        int releaseYear = scanner.nextInt();

        Title title = new Title(type, name, director, country, releaseYear, rating, duration, genre);
        titleDatabase.addTitle(title);

        System.out.println("\nTitle added successfully.");
    }

    private void deleteTitle(TitleDatabase titleDatabase ,Scanner scanner){
        titleDatabase.displayTitlesWithPagination(scanner);
        System.out.println("Enter the index number of the title you want to delete:");
        int index = scanner.nextInt();
        scanner.nextLine();

        titleDatabase.deleteTitle(index);
    }

    private  void modifyTitle(){
        System.out.println("\nList of titles:");
        List<Title> titles = titleDatabase.getTitles();
        for (int i = 0; i < titles.size(); i++) {
            System.out.printf("%d. %s (%s) (%s)%n", i, titles.get(i).getName(), titles.get(i).getType(),titles.get(i).getRating());
        }
        System.out.print("\nEnter the index of the title you'd like to modify:");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < TitleDatabase.size()){
            System.out.println("Enter the new rating: ");
            String newRating = scanner.nextLine();

            titleDatabase.modifyTitle(index,newRating);
            System.out.println("Title Rating update successfully.");
        }
        else{
            System.out.println("Invalid index.");
        }
        FileHandler.saveDataToFile(filename, titleDatabase);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            // Display the main menu and prompt the user for input
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a title");
            System.out.println("2. Delete a title");
            System.out.println("3. Search for titles");
            System.out.println("4. Modify a title");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Code to add a title
                    addTitle();
                    break;
                case 2:
                    // Code to delete a title
                    deleteTitle(titleDatabase ,scanner);
                    break;
                case 3:
                      // Code to search for titles
                    searchForTitles();
                    break;
                case 4:
                    // Code to modify a title
                    modifyTitle();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

