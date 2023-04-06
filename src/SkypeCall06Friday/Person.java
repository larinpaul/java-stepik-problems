package SkypeCall06Friday;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Person {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html
    // The general contract of hashCode:
    // * Whenever it is invoked on the same object more than once during an execution of a Java application,
    // the hashCode method must consistently return the same integer,
    // provided no information used in equals comparisons on the object is modified.
    // This integer need not remain consistent from one execution of an application to another execution of the same application
    // * If two objects are equal according to the equals(Object) method, then calling the hashCode method
    // on each of the two objects must produce the same integer result.
    // * It is NOT required that if two objects are unequal according to the equals(java.lang.Object) method,
    // then calling the hashCode method on each of the two objects must produce distinct integer results.
    // However, the programmer should be aware that producing distinct integer results
    // for unequal objects may improve the performance of hash tables.

    // Основные принципы при проектировании метода equals:
    // 1. Рефлективность: для любых не-null объектов x, x.equals(x) должен возвращать true
    // 2. Симметричность: для любых не-null объектов x и y, x.equals(y) должен возвращать true
    //                                                          если и только если y.equals(x) возвращает true
    // 3. Транзитивность: для любых не-null объектов, x, y, z, если x.equals(y) возвращает true
    //                  и y.equals(z) возвращает true, тогда x.equals(z) должен возвращать true
    // 4. Постоянство: повторный вызов метода equals() должен возвращать одно и то же значение
    // до тех пор, пока какое-либо значение свойств объекта не будет изменено.
    // То есть, если два объекта равны, то они будут равны пока их свойства остаются неизменными.
    // 5. Для любых не-null объектов x, x.equals(null) должно возвращать false

    // equals() сравнивает два объекта на равенство по содержанию. Он принимает один аргумент типа Object
    // и возвращает boolean значение. Реализация по умолчанию сравнивает объекты на равенство по ссылке
//    public boolean equals(Object obj) {
//        return this == obj;
//    }
    // Однако, во многих случаях это поведение не подходит, и нужно переопределить equals(),
    // чтобы он учитывал логическое равенство объектов по их полям или свойствам.
    // Так, например, два объекта String равны, если они содержат одинаковую последовательность символов
//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        } else {
//            boolean var10000;
//            if (anObject instanceof String) {
//                String aString = (String)anObject;
//                if ((!COMPACT_STRINGS || this.coder == aString.coder) && StringLatin1.equals(this.value, aString.value)) {
//                    var10000 = true;
//                    return var10000;
//                }
//            }
//
//            var10000 = false;
//            return var10000;
//        }
//    }


    // Метод hashCode() возвращает целочисленный хеш-код объекта.
    // Хеш-код - это число, которое зависит от содержания объекта и может использоваться
    // для быстрого сравнения или хранения объектов в хеш-таблицах.
    // Реализация по умолчанию возвращает адрес памяти объекта.
//    @IntrinsicCandidate
//    public native int hashCode();
    // Однако, если equals() переопределен, то hashCode() также должен быть переопределен таким образом,
    // чтобы объекты имели одинаковые хеш-коды
    // Это необходимо для корректной работы коллекций, таких как HashSet, HashMap, HashTable, etc...


    // Для реализации этих методов можно использовать аннотацию из библиотеки Lombok,
    // @EqualsAndHashCode, или сгенерировать вручную с помощью IDE. (Alt+Insert on Linux and on Windows probably)

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
//    public static int hash(Object... values) {
//        return Arrays.hashCode(values);
//    }

//    public static int hashCode(Object o) {
//        return o != null ? o.hashCode() : 0; // return 0 is `o` is null
//    }

    // One way to improve the `hashCode()` method is to include only a subset of the object's fields
    // that are more likely to be unique:
    @Override
    public int hashCodeByName() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //    @Override
//    public boolean equals(Object obj) {
//        // Если аргумент - тот же объект, что и вызывающий объект, то вернуть true
//        if (this == obj) return true;
//        // Если аргумент - null или не является объектом класса Person, то вернуть false
//        if (obj == null || getClass() != obj.getClass()) return false;
//        // Привести аргумент к типу Person (EqualsAndHashCode) и сравнить поля name и age
//        Person person = (Person) obj;
//        return age == person.age && Objects.equals(name, person.name);
//    }

//    @Override
//    public int hashCode() {
//        // Использовать статический метод Objects.hash(),
//        // который принимает произвольное количество аргументов и возвращает их хеш-код
//        return Objects.hash(name, age);
//    }

//    @Override
//    public String toString() {
//        // Вернуть строку в формате "Person{name="...", age=...}"
//        return "EqualsAndHashCode Person{" + "name=\"" + name + '\"' + "m age=" + age + '}';
//    }

    public static void main(String[] args) {

        Person person = new Person("Name", 22);
        String toPrint = person.toString();
        System.out.println(toPrint);

        Person obj1 = new Person("NAM", 134);
        Person obj2 = new Person("NAM", 134);
        System.out.println(obj1.equals(obj2)); // true
        Person obj3 = new Person("NAM1", 1344);
        System.out.println(obj1.equals(obj3)); // false


    }

}
