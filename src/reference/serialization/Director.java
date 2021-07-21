package reference.serialization;

public class Director {

    private String directorName;

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorName='" + directorName + '\'' +
                '}';
    }
}
