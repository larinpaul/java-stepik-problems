package SkypeCall07Friday.InstanceOf;

import javax.swing.plaf.PanelUI;
import java.util.Objects;

public class Dog extends Animal implements Trainable, Cloneable {

    private String name;

    public Dog(int age, String name) {
        super(age);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void showAge() {
        System.out.println("This dog has this age: " + this.getAge());
    }

    public void showName() {
        System.out.println("This dog's name is: " + this.name);
    }

    public void train() {
        System.out.println("You are training your " + this.getClass().getSimpleName()
                + " for an hour, " + this.name + " is getting stronger and smarter");
    }

    // equals() in Dog adds more instance variable, name, so we should check for both:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // checks if they are not equal according to Animal
        Dog dog = (Dog) o; // Downcasting. The parameter "o" is Object, so it doesn't have access to the fields of Dog
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public Dog clone() throws CloneNotSupportedException {
        // Shallow copy (Dog doesn't have any objects as its fields)
        Dog dogShallowCopy = (Dog) super.clone();
        return dogShallowCopy;
    }

}
