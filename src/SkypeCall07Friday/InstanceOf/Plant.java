package SkypeCall07Friday.InstanceOf;

public class Plant {

    // If you don't specify any constructor in your class,
    // then the Java compiler provides a default constructor with no parameters.
    // This default constructor initializes all instance variables of the class
    // to their default values (0, null, false).

    // If there is already a constructor with at least one parameter, the default constructor won't be generated,
    // but we could call it like this Plant plant1 = new Plant(5);
    //    public Plant(int height) {
//        this.height = height;
//    }
    // There can also be Constructor Overloading

    private String species;
    private int height;



    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {

        Plant plant = new Plant();
        System.out.println(plant.getSpecies());
        System.out.println(plant.getHeight());

    }

}
