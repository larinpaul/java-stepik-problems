package SkypeCall07Friday.InstanceOf;

import java.util.Objects;

public class Cat extends Animal implements Cloneable {

    private String nickname;
    private Dog friend;

    public Cat(int age, String nickname, Dog friend) {
        super(age);
        this.nickname = nickname;
        this.friend = friend;
    }

    public String getNickname() {
        return nickname;
    }

    public Dog getFriend() {
        return friend;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFriend(Dog friend) {
        this.friend = friend;
    }

    public void showNickname() {
        System.out.println("This cat's nickname is " + this.nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // checks if they are not equal according to Animal
        Cat cat = (Cat) o; // Downcasting. The parameter "o" is Object, so it doesn't have access to the fields of Cat
        return Objects.equals(nickname, cat.nickname) && Objects.equals(friend, cat.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public Cat clone() throws CloneNotSupportedException {
        // Shallow copy
        Cat catShallowCopy = (Cat) super.clone();

        // Deep copy
        Dog friendDeepCody = (Dog) friend.clone();
        catShallowCopy.setFriend(friendDeepCody);
        return catShallowCopy;
    }

}
