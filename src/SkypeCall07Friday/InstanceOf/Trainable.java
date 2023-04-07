package SkypeCall07Friday.InstanceOf;

public interface Trainable {

    int DEFAULT_TRAINING_HOURS = 3;

    public void train();

    default void trainForHours() {
        for (int i = 0; i < DEFAULT_TRAINING_HOURS; i++) {
            train();
        }
    }

}
