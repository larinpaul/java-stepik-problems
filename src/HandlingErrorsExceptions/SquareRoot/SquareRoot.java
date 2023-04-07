package HandlingErrorsExceptions.SquareRoot;

public class SquareRoot {

    // Можно использовать метод Ньютона (метод касательных)
    // для приближенного нахождения квадратного корня уравнения

    // Для квадратного корня из числа x начальное приближение можно взять равным самому х
    // А затем итеративно вычислять новые значения,
    // пока разность между квадратом текущего значения и x не будет достаточно малой

    // Формула для вычисления нового значения выглядит следующим образом:
    // y = (x + a/x)/2
    // где a - исходное число, x - текущее приближение, y - новое значение

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        double y = x; // This is an initial estimate for the square root of `x`
        while (Math.abs(y * y - x) > 0.0001) { // Check if the abs difference between y squared and x is greater than 0.0001
            y = (y + x / y) / 2;          // If it is, continue to step 3. If it is not, exit the loop and return y
        } // Update the value of `y` using the formula that takes the average of the current estimate of y and x
        return y;                                                          // divided by the current estimate `y`
    }     // Go back to step 2 and repeat the process until the condition is met.
    // In other words, the loop repeatedly updates the value of `y` until it gets close enough to the true square root of x

    // This loop is an implementation of the Babylonian method (Newton-Raphson method
    // )
    // for calculating the square root of a number.

    // The idea behind this method is to repeatedly calculate the average
    // of a number and its reciprocal, and then use this average
    // to get a better approximation of the square root.

    // In the loop, we start with an initial guess for the square root
    // (which can be any positive number), and then repeatedly calculate a new guess using the formula:

    // y = (y + x / y) / 2

    // Here, x is the number whose square root we want to find,
    // and y is our current guess for the square root.
    // The formula calculates a new value of y that is closer
    // to the actual square root of x.

    // The loop continues until the difference
    // between y^2 and x is less than 0.0001.
    // This is a small value that determines how accurate
    // our approximation needs to be. Once the difference is small enough,
    // we have found a good enough approximation of the square root
    // and we exit the loop.

    // At each iteration of the loop,
    // we are refining our approximation of the square root,
    // so the loop will converge towards the actual square root of x.


}
