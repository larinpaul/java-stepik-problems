package SkypeCall07Friday.InstanceOf;

import java.util.Arrays;

public class InstanceOf {

    // Оператор instanceOf - ключевое слово в Java, которое используется для проверки,
    // является ли объект экземпляром класса или его подкласса
    // Оператор instanceof имеет следующий синтаксис:
    // object instanceof class
    // `object` - объект, который необходимо проверить, `class` - имя класса или интерфейса, который вы хотите проверить
    // возвращаемое значение - true или false

    public static void main(String[] args) {

        Animal dog1 = new Dog(1, "Doggo");
        dog1.showAge();
//        dog1.showName(); // impossible
//        dog1.train(); // impossible

        Dog dog2 = new Dog(2, "Dodger");
        dog2.showName();
        dog2.showAge();
        dog2.train();

        GermanShepherd dog3 = new GermanShepherd(3, "Jäger", "Brown");
        dog3.showName();
        dog3.showAge();
        dog3.trainForHours();
        dog3.getColor();

        Cat cat1 = new Cat(1, "Catty", dog3);
        cat1.showNickname();
        cat1.showAge();

        System.out.println(dog1 instanceof Animal); // true
        System.out.println(dog1 instanceof Dog); // true
        System.out.println(dog1 instanceof Trainable); // true
        System.out.println(dog2 instanceof Dog); // true
        System.out.println(dog2 instanceof Trainable); // true
        System.out.println(dog3 instanceof Animal); // true
        System.out.println(dog3 instanceof GermanShepherd); // true
        System.out.println(cat1 instanceof Cat); // true
        System.out.println(cat1 instanceof Animal); // true
        System.out.println(dog2 instanceof GermanShepherd); // false
        System.out.println(dog1 instanceof GermanShepherd); // false
        System.out.println(cat1 instanceof Trainable); // false
        System.out.println(cat1 instanceof Cloneable); // true
//        System.out.println(cat1 instanceof Dog); // impossible
        // A class or interface should be compatible for us to be able to check via instanceof
        // For example, if you have Dog that extends Animal, then Dog is compatible with Animal,
        // as well as with any superclasses or superinterfaces of Animal
        System.out.println(null instanceof Cat); // false

        Animal[] animals1 = new Animal[] {dog1, dog2, dog3, cat1};
        System.out.println(animals1[0] instanceof Animal); // true
        System.out.println(animals1[0] instanceof Dog); // true
        System.out.println(animals1[0] instanceof GermanShepherd); // false

        Object myObj1 = dog3;
        checkIfGermanShepherd(myObj1);
        Object myObj2 = dog1;
        checkIfGermanShepherd(myObj2);
        Object myObj3 = cat1;
        checkIfGermanShepherd(myObj3);

        try { // clone() throws CloneNotSupportedException, which is a checked exception. You need to handle it
            Cat cat2 = cat1.clone();
            System.out.println("A new cat named " + cat2.getNickname()
                    + " who has a new friend " + cat2.getFriend().getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 1) Upcasting. When you cast a subclass to its superclass. This happens implicitly
        Animal animal11 = new Dog(11, "Elf");
//        System.out.println(animal11.showName()); // error

        // 2) Downcasting. When you cast a superclass to its subclass. You have to explicitly cast the object.
        Animal animal12 = new Dog(12, "Twelve");
        Dog dog12 = (Dog) animal12;
        System.out.println(dog12);

        // 3) instanceof operator. It checks whether an object is an instance of a particular class or its subclasses
        Animal animal13 = new Dog(13, "Thirteen");
        if (animal13 instanceof Dog) {
            Dog dog13 = (Dog) animal13;
            dog13.showName();
        }

        // 4) Casting interface types. You can also cast interface types in Java.
        Trainable trainable14 = new GermanShepherd(14, "Fourteen", "Black");
        trainable14.trainForHours();
        Dog dog14 = (Dog) trainable14;
        dog14.showAge();

        Rex dog15 = new Rex();
        System.out.println(dog15.getInnerClassToy());
        System.out.println(Rex.FavoriteFood.foodName);


    }

    public static void checkIfGermanShepherd(Object myObj) {
        if (myObj instanceof GermanShepherd) {
            System.out.println(((GermanShepherd) myObj).getName()
                    + " is a German Shepherd, a very smart dog!");
        } else if (myObj instanceof Dog) {
            System.out.println(((Dog) myObj).getName()
                    + " is some kind of Dog, but I am not sure which... Still smart though");
        } else {
            System.out.println("It is not a dog. Is it smart? Maybe");
        }
    }




}
