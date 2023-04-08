package SkypeCall07Friday.InstanceOf;

import java.util.Objects;

public class GermanShepherd extends Dog {

    private String color;

    public GermanShepherd(int age, String name, String color) {
        super(age, name);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // checks if they are not equal according to Animal
        GermanShepherd that = (GermanShepherd) o; // Downcasting. The parameter "o" is Object, so it doesn't have access
        return Objects.equals(color, that.color);       // to the fields of GermanShepherd
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
