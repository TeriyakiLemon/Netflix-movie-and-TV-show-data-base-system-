import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class TitleDatabase {
    private static List<Title> titles;

    public TitleDatabase() {
        titles = new ArrayList<>();
    }

    public static int size() {
       return  titles.size();
    }

    public void addTitle(Title title) {
        titles.add(title);
    }

    public static List<Title> getTitles() {
        return titles;
    }

    public void displayTitlesWithPagination(Scanner scanner) {
        int itemsPerPage = 10;
        int totalPages = (int) Math.ceil((double) titles.size() / itemsPerPage);

        for (int currentPage = 0; currentPage < totalPages; currentPage++) {
            int startIndex = currentPage * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, titles.size());

            System.out.println("Page " + (currentPage + 1) + " of " + totalPages + ":");
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println(i + ": " + titles.get(i).toString());
            }

            if (currentPage < totalPages - 1) {
                System.out.println("Press the space bar to see the next batch of titles or any other key to return to the main menu.");
                String input = scanner.nextLine();
                if (!input.equals(" ")) {
                    break;
                }
            }
        }
    }
    public void deleteTitle(int index) {
        // Code to delete a title by name
        if (index >= 0 && index < titles.size()) {
            titles.remove(index);
            System.out.println("Title deleted successfully.");
        } else {
            System.out.println("Invalid index. Title not found.");
        }
    }


    public void modifyTitle(int index, String newRating) {
        // Code to modify a title by name
        if (index >= 0 && index < titles.size()){
            Title title = titles.get(index);
            title.setRating(newRating);
        }

    }

    public List<Title> search(String attribute, String value, String type) {
        // Code to search for titles based on an attribute and its value
        List<Title> results = new ArrayList<>();
        for (Title title : titles) {

            if (title.getType().equalsIgnoreCase(type)) {

                switch (attribute) {
                    case "rating":
                        results = titles.stream()
                                .filter(t -> t.getRating().equalsIgnoreCase(value))
                                .collect(Collectors.toList());
                        break;
                    case "director":
                        results = titles.stream()
                                .filter(t -> t.getDirector().equalsIgnoreCase(value))
                                .collect(Collectors.toList());
                        break;
                    case "genre":
                        results = titles.stream()
                                .filter(t -> t.getGenre().equalsIgnoreCase(value))
                                .collect(Collectors.toList());
                        break;
                    case "duration":
                        int duration = Integer.parseInt(value);
                        results = titles.stream()
                                .filter(t -> t.getDuration() == duration)
                                .collect(Collectors.toList());
                        break;
                    case "country":
                        results = titles.stream()
                                .filter(t -> t.getCountry().equalsIgnoreCase(value))
                                .collect(Collectors.toList());
                        break;
                    case "year":
                        int year = Integer.parseInt(value);
                        results = titles.stream()
                                .filter(t -> t.getReleaseYear() == year)
                                .collect(Collectors.toList());
                        break;
                    default:
                        System.out.println("Invalid attribute.");
                }

            }
        }
        return results;
    }



}







