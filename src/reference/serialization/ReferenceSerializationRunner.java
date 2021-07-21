package reference.serialization;

import java.io.*;

public class ReferenceSerializationRunner {

    public static void main(String[] args) {

        System.out.println("The reference object Director is not implementing Serializable interface");

        Director director = new Director("dir name");
        Movie movie = new Movie("test-movie", director);

        try (FileOutputStream fileOutputStream = new FileOutputStream("object-store2.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(movie);
            System.out.println("Movie object before serialization " + movie.toString());
            System.out.println("Movie 1 object hashcode after serialization  : " + movie.hashCode());
            System.out.println("Successfully serialized object into object-store.ser file");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("object-store2.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Movie movieDeserialized = (Movie) objectInputStream.readObject();
            System.out.println(movieDeserialized.toString());
            System.out.println("Movie object hashcode after de-serialization  : " + movieDeserialized.hashCode());
            System.out.println(movie.getDirector().getDirectorName().equals(movieDeserialized.getDirector().getDirectorName()));

        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
