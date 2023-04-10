//package IoAndFileSystem.AdvancedIO;
//
//// https://stepik.org/lesson/12785/step/8?unit=3132
//// Дан сериализуемый класс Animal:
//
//import java.io.*;
//import java.util.Objects;
//
// TODO Fix everything
//public class Animal  {
//
//    private final String name;
//
//    public Animal(String name) {
//        this.name = name;
//    }
//
////    @Override
////    public boolean equals(Object obj) {
////        if (obj instanceof Animal) {
////            return Object.equals(name, ((Animal) obj).name);
////        }
////        return false;
////    }
//
//    // Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
//    // Массив байт устроен следующим образом. Сначала идет число типа int,
//    // записанное при помощи ObjectOutputStream.writeInt(size).
//    // Далее подряд записано указанное количество объектов типа Animal, сериализованных при помощи
//    // ObjectOutputStream.writeObject(animal).
//
//    // Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
//    // то метод должен бросить исключение java.lang.IllegalArgumentException.
//
//    // Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные
//    // и посмотрите, какие исключения будут возникать.
//    // Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
//    // Если что-то забудете, то проверяющая система подскажет.
//    // Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
//
//    public static Animal[] deserializeAnimalArray(byte[] data) {
//        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
//            ObjectInputStream ois = new ObjectInputStream(bais)) {
//
//            // Read the size of the Animal array
//            int size = ois.readInt();
//
//            // Create a new Animal array with the given size
//            Animal[] animals = new Animal[size];
//
//            // Loop through the array and deserialize each Animal object
//            for (int i = 0; i < size; i++) {
//                Object obj = ois.readObject();
//
//                // Make sure that the deserialization object is an instance of Animal
//                if (obj instanceof Animal) {
//                    animals[i] = (Animal) obj;
//                } else {
//                    // Throw an exception if the deserialized object is not an Animal
//                    throw new IllegalArgumentException("Invalid object in byte array");
//                }
//            }
//            return animals;
//        } catch (IOException | ClassNotFoundException | ClassCastException ex) {
//            // Throw an exception if there's an error with the byte array or the deserialization
//            throw new IllegalArgumentException("Invalid byte array.", ex);
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//
//        Animal[] animalM1 = {
//                new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
//                new Animal("Rooster"), new Animal("Bull"), new Animal("Ant"),
//                new Animal("Octopus"), new Animal("Worm")
//        };
//        ByteArrayOutputStream bai = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bai);
//        oos.writeInt(animalM1.length);
//        for (int i = 0; i < animalM1.length; i++) {
//            oos.writeObject(animalM1[i]);
//        }
//        oos.flush();
//        oos.close();
//        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
//    }
//
//}
