package simple.serialization;

import java.io.*;

public class Runner {

    public static void main(String[] args) {

        Movie movie1 = new Movie("3 Iditios", 2009);

        System.out.println("Movie 1 object hashcode before serialization : " + movie1.hashCode());

        try (FileOutputStream fileOutputStream = new FileOutputStream("object-store.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(movie1);
            System.out.println("Movie 1 object hashcode after serialization  : " + movie1.hashCode());
            System.out.println("Successfully serialized object into object-store.ser file");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("object-store.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Movie movieDeserialized = (Movie) objectInputStream.readObject();
            System.out.println(movieDeserialized.toString());
            System.out.println("Movie object hashcode after de-serialization  : " + movieDeserialized.hashCode());

            System.out.println("Hashcode of the 2 objects are completely different");

        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
