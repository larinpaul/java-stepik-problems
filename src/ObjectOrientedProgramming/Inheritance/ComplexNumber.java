package ObjectOrientedProgramming.Inheritance;

import java.util.Objects;

public final class ComplexNumber {

    // https://stepik.org/lesson/12769/step/9?unit=3117

    // 3.4. Наследование. Класс Object

    // Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так,чтобы equals() сравнивал экземпляры
    // ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

    // Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

    // Пример
    // ComplexNumber a = new ComplexNumber(1, 1);
    // ComplexNumber b = new ComplexNumber(1, 1);
    // a.equals(b) must return true
    // a.hashCode() must be equal to b.hashCode()

    // Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.

    // Подсказка 2. Можно позвать на помощь среду разработки, которая умеет сама генерировать equals() и hashCode().
    // Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно выглядит именно так.
    // Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode()
    // для какого-нибудь простого класса, то среда разработки помочь не сможет.

    // Complex numbers are the combination of a real and imaginary numbers

    private final double re; // Real part of a complex number
    private final double im; // Imaginary part of a complex number

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object o) {
        // Check if the two objects have the same reference
        // this keyword refers to the current object, i.e. the object that the current method or constructor is being called on
        if (this == o) return true;
        // Check if the passed object is null or of a different class
        if (o == null || getClass() != o.getClass()) return false;
        // Cast the passed object to a ComplexNumber and compare the real and the imaginary parts
        ComplexNumber myNumber = (ComplexNumber) o;
        return Double.compare(myNumber.re, re) == 0 && Double.compare(myNumber.im, im) == 0;
        // Comparator interface is used to order the objects of user-defined classes.
        // (Compare two objects of the same class)
        // compare() method compares two class specific objects (x, y) given as parameters. It returns the value:
        // 0 if (x==y)
        // -1 if (x < y)
        // 1 if (x > y)
    }

    @Override
    public int hashCode() {
        // Generate a hash code based on the real and imaginary parts
        // return Objects.hash(re, im);

        // Choose two prime numbers for the initial hash code and multiplier
        final int primeMultiplier = 31; // recommended by Effective Java to use 31 as a multiplier
        int result = 17; // initialized to an arbitrary non-zero value as the initial hash code

//        // Multiply the current hash code by the prime number, and add the hash
//        result = primeMultiplier * result + Double.hashCode(re);
//        result = primeMultiplier * result + Double.hashCode(im);
//        // Return the final hash code
//        return result;

        return primeMultiplier * (primeMultiplier * result + Double.hashCode(re)) + Double.hashCode(im);
    }

}



