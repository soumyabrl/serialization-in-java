package invalidclass.serialization;

import java.io.*;

class Test implements Serializable {

    private static final long serialVersionUID = 1190796671256540208L;

    String id;

//    below field was added after serialization
//    and at the time of deserialization it will throw InvalidClassException
      int fieldAddedAfterSerialization;

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                '}';
    }
}

public class InvalidClassExceptionRunner {
    public static void main(String[] args) {
        Test test = new Test();
        test.id = "123";

        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("object-store4.ser"))){
            os.writeObject(test);
        }catch (Exception e){
            e.printStackTrace();
        }

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("object-store4.ser"))){
            Test desTest = (Test) is.readObject();
            System.out.println(desTest.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
