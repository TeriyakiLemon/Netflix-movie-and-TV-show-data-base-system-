public class Title {
    private String type;
    private String name;
    private String rating;
    private String director;
    private String genre;
    private int duration;
    private String country;
    private int releaseYear;

    public Title(String type,String name,String director,String country,int releaseYear,String rating,int duration,String genre) {
        this.type = type;
        this.name = name;
        this.rating = rating;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.releaseYear = releaseYear;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }


    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String toString() {
        return name;
    }

}




