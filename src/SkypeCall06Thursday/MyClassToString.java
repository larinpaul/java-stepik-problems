package SkypeCall06Thursday;

public class MyClassToString extends Object {

    //// 2023/04/06

    // Метод toString() возвращает строкое представление объекта.
    // При отсутствии переопределния этого метода в классе,
    // по умолчанию будет использоваться реализация из класса Object,
    // которая возвращает строку, содержащую имя класса (с package) и хеш-код объекта (в шестнадцатеричном формате).

    public String toString() {
        return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode());
    } // this используется для обращения к текущему объекту, для которого вызывается данный метод
    // toString() не принимает аргументы, потому что он вызывается на конкретном объекте,
    // для которого он возвращает строкое представление

    private int myField;

    public MyClassToString(int myField) {
        this.myField = myField;
    }

    public int getMyField() {
        return myField;
    }

    public static void main(String[] args) {
        MyClassToString obj = new MyClassToString(42);
        System.out.println(obj); // SkypeCall06Friday.MyClassToString@2c7b84de

        // Но классы String и StringBuilder переопределяют метод toString()
        // и возвращаю не имя класса и хеш-код, а строку, которую они представляют. Например:

        String str = "String example";
        StringBuilder sb = new StringBuilder("StringBuilder example");

        System.out.println(str.toString()); // String example
        System.out.println(sb.toString()); // StringBuilder example

        // public String toString() {
        //     return this;
        // }


    }

}
