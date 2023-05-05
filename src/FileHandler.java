import java.io.*;


public class FileHandler {
    public static void readDataFromFile(String filename, TitleDatabase titleDatabase)  {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 8) {
                    continue;
                }

                String type = data[0];
                String name = data[1];
                String director = data[2];
                String country = data[3];
                int releaseYear = Integer.parseInt(data[4]);
                String rating = data[5];
                int duration = Integer.parseInt(data[6]);
                String genre = data[7];

                Title title = new Title(type, name, director, country, releaseYear, rating, duration, genre);
                titleDatabase.addTitle(title);
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDataToFile(String filename,TitleDatabase titleDatabase){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Title title: titleDatabase.getTitles()){
                 String line =  String.format("%s,%s,%s,%s,%d,%s,%d,%s%n", title.getType(), title.getName(), title.getDirector(), title.getCountry(), title.getReleaseYear(), title.getRating(), title.getDuration(), title.getGenre());
                 bw.write(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
