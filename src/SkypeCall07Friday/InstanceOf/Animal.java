package SkypeCall07Friday.InstanceOf;

import javax.swing.plaf.PanelUI;

public abstract class Animal {

    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void showAge() {
        System.out.println("This animal has this age: " + this.age);
    }

    // Since Animal doesn't have any additional instance variables beyond `age`,
    // equals() can simply compare the age of the current object with that of the given object
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age;
    }

}
