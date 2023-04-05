package SkypeCallTuesday.MutableImmutable;

public class MutableImmutable {

    public static void main(String[] args) {

        // String - immutable

        // StingBuilder = mutable

        // Сравнить надо было не через ХешКоды
        // ХешКод - целочисленная переменная, которая описывает состояние твоего объекта
        String str1 = "hello";
        String str11 = new String("hello"); // Изменяемый\Неизменяемы - дело в ссылке
        System.out.println("str1: " + str1); // toString() автоматически печатает место в памяти
        System.out.println("Hash code of str1: " + str1.hashCode()); // Скорее всего есть особая обработка в System.out.out.println()
        String str3 = str1.concat(" world");                    // Как вывести ссылку на объект строки
        System.out.println("str1: " + str1);
        System.out.println("Hash code of str1: " + str1.hashCode());
        System.out.println("str3: " + str3);
        System.out.println("Hash code of str3: " + str3.hashCode());

        StringBuilder sb1 = new StringBuilder("hello");
        System.out.println("sb1: " + sb1);
        System.out.println("Hash code of sb1: " + sb1.hashCode());
        sb1.append(" world");
        System.out.println("sb1: " + sb1);
        System.out.println("Hash code of ab1: " + sb1.hashCode());

        // Есть определенная договоренность и контракт между equals() hashCode()
        // 1. Они должны быть равны
        // 2. Когда Хеш КОды Равны, это не означает равенство объектов





    }




}
