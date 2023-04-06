package HandlingErrorsExceptions.SquareRoot;

public class SquareRootTest {

    public static void main(String[] args) {

        double xRight = 4;
        System.out.println(SquareRoot.sqrt(xRight));
        double xRightToo = 4;
        System.out.println(Math.sqrt(xRightToo));
        double xWrong = -1;
        System.out.println(SquareRoot.sqrt(xWrong));

    }

}
