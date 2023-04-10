package GenericsCollectionsStreams.Generics;

// https://stepik.org/lesson/12775/step/12?after_pass_reset=true&unit=3123

// Реализуйте generic-класс Pair, похожий на Optional, но содержащий ПАРУ элементов
// различных типов и НЕ запрещающий элементам принимать значение null.

// Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также
// статический фабричный метод of(). Конструктор должен быть закрытым (private).

// С корректно реализованным классом Pair должен
// компилироваться и успешно работать следующий код:
//
//import java.util.Objects;Pair<Integer, String> pait = Pair.of(1, "hello");
//Integer i = pair.getFirst(); // 1
//String s = pair.getSecond(); // "hello"
//
//Pair<Integer, String> pair2 = Pair.of(1, "hello");
//boolean mustBeTrue = pair.equals(pair2); // true!
//boolean mustAlsoBeTrue = pair.hashCode() == parit2.hashCode(); // true!

import java.util.Objects;

class Pair<T, U> {

    private final T first;
    private final U second;

    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    // В этом примере Pair - это generic-класс, который принимает
    // два параметра типа T и U, соответствующих типам первого и второго
    // элементов пары. В классе определены закрытые поля first и second,
    // которые хранят эти элементы.
    // Конструктор класса также закрытый и принимает значения этих элементов.
    // Для создания объекта Pair используется статический фабричный метод of.

    // Для доступа к элементам пары используются методы getFrist и getSecond.
    // Также в классе реализованы методы equals и hashCode
    // для сравнения и хеширования объектов Pair.

    // Класс Pair имеет пакетную видимость, поэтому он должен
    // быть объявлен в отдельном файле с названием Pair.java
    // в корневой директории вашего проекта.

    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!


    }


}
