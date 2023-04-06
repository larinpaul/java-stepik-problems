package SkypeCall06Friday;

import java.util.Comparator;

public class PersonTest {

    public static void main(String[] args) {

        Person person = new Person("Name", 22);
        String toPrint = person.toString();
        System.out.println(toPrint);

        Person person1 = new Person("Name1", 111);
        Comparator<Person> personComparator = Comparator.comparing(Person::getName)
                .thenComparing(Person::getName)
                .thenComparing(Person::getAge);
        System.out.println(personComparator);


        Person obj1 = new Person("NAM", 134);
        Person obj2 = new Person("NAM", 134);
        System.out.println(obj1.equals(obj2)); // true
        Person obj3 = new Person("NAM1", 1344);
        System.out.println(obj1.equals(obj3)); // false



    }

}
