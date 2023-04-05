package SkypeCallTuesday.Incrementing;

public class MainIncrementing {

    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            System.out.print(i++);
//            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < 5; ++i) {
            System.out.print(++i);
//            System.out.print(i);
        }

        // ++i
        // Преинкремент
        // Сначала увеличивает переменную, а затем отдает её значение

    }

}
