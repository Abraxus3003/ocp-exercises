package info.krogulec.io;

import java.io.*;
import java.util.stream.Stream;

public class ObjectStreams implements Serializable {
    public static void main(String[] args) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\piotr.krogulec\\Desktop\\OCP\\fileToWriteObject.txt"))) {

            Animal animal = new ObjectStreams().new Animal();
            animal.setAge(2);
            animal.setName("as");



            oos.writeObject(animal);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\piotr.krogulec\\Desktop\\OCP\\fileToWriteObject.txt"))) {

            Animal a = (Animal) ois.readObject();

            System.out.println(a);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    class Animal implements Serializable{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
