package reference.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class Movie implements Serializable {

    private String name;
    private transient Director director;

    public Movie(String name, Director director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director=" + director +
                '}';
    }

    // override writeObject() and readObject() methods

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            // invoking this it tells JVM to do normal serialization of this movie object
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeChars(director.getDirectorName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream){
        try{
            // invoking this it tells JVM to do normal deserialization of this movie object
            objectInputStream.defaultReadObject();
            director = new Director(objectInputStream.readLine());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
