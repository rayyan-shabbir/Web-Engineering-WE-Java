
// Java program to demonstrate working of Externalization
// interface
import java.io.*;

class Car implements Externalizable {
    static int age;
    String name;
    transient int year;

    public Car() {
        System.out.println("Default Constructor called");
    }

    Car(String n, int y) {
        this.name = n;
        this.year = y;
        age = 15;
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeInt(0);
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        year = in.readInt();
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\n"
                + "Year: " + year + "\n"
                + "Age: " + age);
    }
}

public class Externalizable_Interface {
    public static void main(String[] args) {
        Car car = new Car("Shubham", 1995);
        // System.out.println("The original car is:\n" + car);
        Car newcar = null;

        // Serialize the car
        try {
            FileOutputStream fo = new FileOutputStream("gfg.txt");
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(car);
            so.flush();
        } catch (Exception e) {
            System.out.println(e);

        }

        // System.out.println("The original car is:\n" + car);

        // Deserialization the car
        try {
            FileInputStream fi = new FileInputStream("gfg.txt");
            ObjectInputStream si = new ObjectInputStream(fi);
            newcar = (Car) si.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("The original car is:\n" + car);
        System.out.println("The new car is:\n" + newcar);
    }
}
